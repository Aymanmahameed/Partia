import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportCustomers {
	private SystemDataBase database;
	BufferedReader readc;

	public SystemDataBase getDatabase() {
		return database;
	}

	public void setDatabase(SystemDataBase database) {
		this.database = database;
	}

	public ImportCustomers(SystemDataBase database) throws FileNotFoundException, IOException {
		this.database = database;
		try {
			readc = new BufferedReader(new FileReader("src/Bracelets.txt"));
			String line;
			while ((line = readc.readLine()) != null) {
				if (!(line.isEmpty()))
					this.database.addBracelet(new Bracelet(line));
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error ");
			throw e;
		} catch (IOException e) {
			System.out.println("Error ");
			e.printStackTrace();
		}
		readc.close();

	}

}
