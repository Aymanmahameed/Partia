import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ImportPools {
	private SystemDataBase dataBase;
	BufferedReader readP;
	BufferedReader readcon;
	Exeptions ex = new Exeptions();

	public SystemDataBase getDb() {
		return dataBase;
	}

	public void setDb(SystemDataBase db) {
		this.dataBase = db;
	}

	public ImportPools(SystemDataBase db) throws IOException {
		super();
		this.dataBase = db;
		try {
			// new pools
			readP = new BufferedReader(new FileReader("src/Pools.txt"));
			String linep;
			while ((linep = readP.readLine()) != null) {
				StringTokenizer Stp = new StringTokenizer(linep);
				// Regular pool
				if (Stp.countTokens() == 3) {
					Double Dep = Double.parseDouble(Stp.nextToken());
					Double wid = Double.parseDouble(Stp.nextToken());
					Double len = Double.parseDouble(Stp.nextToken());
					dataBase.addPool(new Pool(Dep, wid, len));
				}
				// Proffesional pool
				else if (Stp.countTokens() == 4) {
					Double Dep = Double.parseDouble(Stp.nextToken());
					Double wid = Double.parseDouble(Stp.nextToken());
					Double len = Double.parseDouble(Stp.nextToken());
					Integer swimmingLanes = Integer.parseInt(Stp.nextToken());
					dataBase.addPool(new ProffesionalPool(Dep, wid, len, swimmingLanes));
				}
				// kids pool
				else if (Stp.countTokens() == 5) {
					Double Dep = Double.parseDouble(Stp.nextToken());
					Double wid = Double.parseDouble(Stp.nextToken());
					Double len = Double.parseDouble(Stp.nextToken());
					Integer maxAe = Integer.parseInt(Stp.nextToken());
					boolean isNeede = Boolean.parseBoolean(Stp.nextToken());
					dataBase.addPool(new KidsPool(Dep, wid, len, maxAe, isNeede));

				} else {
					System.out.println(linep);
					System.out.println("Error Line!");
				}

			}
			
			readP.close();
			//reading the connection between the customers and the pools from files
			readcon = new BufferedReader(new FileReader("src/CustomersAndPools.txt"));
			String linecon;
			while ((linecon = readcon.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(linecon);
				if (st.countTokens() == 2) {
					Bracelet c = dataBase.findBraceletbyID(Integer.parseInt(st.nextToken()));
					Pool p = dataBase.findPoolbyID(Integer.parseInt(st.nextToken()));
					if(c==null || p==null) {
						System.out.println("Faild to find customer");
					}else {
						ex.addbracopool(c, p);
					}
					
				}
			}
			readcon.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error ");
			throw e;
		} catch (IOException e) {
			System.out.println("Error ");
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
