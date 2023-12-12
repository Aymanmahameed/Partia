
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		MainManager mm = new MainManager("Shadi", 57, 17000, "oop", "1234");
		SystemDataBase dataBase = new SystemDataBase(mm);

		boolean flag = true;

		/*Pool p1 = new Pool(2, 2, 5);
		Pool p2 = new Pool(3, 2, 5);
		Pool p3 = new Pool(5, 4, 8);

		dataBase.addPool(p1);
		dataBase.addPool(p2);
		dataBase.addPool(p3);

		ProffesionalPool pp1 = new ProffesionalPool(2, 2, 5, 4);
		ProffesionalPool pp2 = new ProffesionalPool(3, 5, 5, 4);
		ProffesionalPool pp3 = new ProffesionalPool(7, 5, 7, 8);

		//adding names
		pp1.addOlympicGamesNames("XXI");
		pp1.addOlympicGamesNames("XII");

		pp2.addOlympicGamesNames("XXI");
		pp2.addOlympicGamesNames("XXX");

		pp3.addOlympicGamesNames("XII");
		pp3.addOlympicGamesNames("XXX");
		pp3.addOlympicGamesNames("2022");

		dataBase.addPool(pp1);
		dataBase.addPool(pp2);
		dataBase.addPool(pp3);

		KidsPool kp1 = new KidsPool(0.3, 3, 5, 3, true);
		KidsPool kp2 = new KidsPool(0.7, 5, 5, 6, false);
		KidsPool kp3 = new KidsPool(2, 5, 7, 16, false);

		dataBase.addPool(kp1);
		dataBase.addPool(kp2);
		dataBase.addPool(kp3);

		// adding new customers
		
		 Bracelet b1 = new Bracelet("Oscar Pistorius"); Bracelet b2 = new
		  Bracelet("Svetlana Romashina"); Bracelet b3 = new Bracelet("Katie Ledecky");
		  
		  dataBase.addBracelet(b1); dataBase.addBracelet(b2); dataBase.addBracelet(b3);
		 

		// adding customers to the pools & pools to the customers
		
		  p1.addBracelet(b1); p1.addBracelet(b2); b1.addPoolsforToday(p1);
		 b2.addPoolsforToday(p1);
		  
		  p2.addBracelet(b1); p2.addBracelet(b3); b1.addPoolsforToday(p2);
		  b3.addPoolsforToday(p2);
		  
		  p3.addBracelet(b2); p3.addBracelet(b3); p3.addBracelet(b1);
		  b1.addPoolsforToday(p3); b2.addPoolsforToday(p3); b3.addPoolsforToday(p3);
		  
		  pp1.addBracelet(b1); pp1.addBracelet(b2); b1.addPoolsforToday(pp1);
		  b2.addPoolsforToday(pp1);
		 
		 pp2.addBracelet(b1); b1.addPoolsforToday(pp2);
		 
		 pp3.addBracelet(b2); pp3.addBracelet(b3); pp3.addBracelet(b1);
		 b1.addPoolsforToday(pp3); b2.addPoolsforToday(pp3); b3.addPoolsforToday(pp3);
		  
		  kp1.addBracelet(b1); kp1.addBracelet(b2); b1.addPoolsforToday(kp1);
		  b2.addPoolsforToday(kp1);
		  
		  kp2.addBracelet(b1); b1.addPoolsforToday(kp2);
		  
		  kp3.addBracelet(b2); kp3.addBracelet(b3); kp3.addBracelet(b1);
		  b1.addPoolsforToday(kp3); b2.addPoolsforToday(kp3); b3.addPoolsforToday(kp3);
		 

		// new managers
		Manager m1 = new Manager("Yuval", 47, 13000);
		Manager m2 = new Manager("Ofir", 37, 11000);

		dataBase.addManagers(m1);
		dataBase.addManagers(m2);
		dataBase.addManagers(mm);

		// adding managers to the pools & pools to the managers
			
		  m1.addheadPools(p1); m1.addheadPools(pp3); m1.addheadPools(kp2);
		  m2.addheadPools(p3); m2.addheadPools(kp3); p1.addManager(m1);
		  pp3.addManager(m1); kp2.addManager(m1); p3.addManager(m2);
		  kp3.addManager(m2);
		  
		  // adding managers & pools to hashtable
		  dataBase.getTablePoolsManager().put(p1.getCode(), m1);
		  dataBase.getTablePoolsManager().put(pp3.getCode(), m1);
		  dataBase.getTablePoolsManager().put(kp2.getCode(), m1);
		  dataBase.getTablePoolsManager().put(p3.getCode(), m2);
		  dataBase.getTablePoolsManager().put(kp3.getCode(), m2);*/
		
		
		
		
		
		Login log = new Login();
		log.setDb(dataBase);

		// for main manager
		Scanner input = new Scanner(System.in);
		System.out.println("Username: ");
		String username = input.next();
		System.out.println("Password: ");
		String password = input.next();

		// checking
		while (!username.equals(mm.getUserName()) || !password.equals(mm.getPassword())) {
			System.out.println("Username\\password not correct! You can try again..");
			System.out.println("Username: ");
			username = input.next();
			System.out.println("Password: ");
			password = input.next();
		}

		// print db
		System.out.println("\nThe db: ");
		for (Bracelet b : dataBase.getTableCodeBracelet().values())
			System.out.println(b.toString());
		for (Manager b : dataBase.getAllManagers())
			System.out.println(b.toString());
		for (Pool b : dataBase.getAllPools()) {
			System.out.println(b.toString());
		}

		while (flag) {

			/*
			 * //print db checking System.out.println("\nmy db: "); for(Bracelet
			 * b:Service.bracelets) System.out.println(b.toString()); for(Manager
			 * b:Service.managers) System.out.println(b.toString()); for(Pool
			 * b:Service.pools) { System.out.println(b.toString()); }
			 */

			System.out.println("");
			System.out.println("Choose one of the options:");
			System.out.println("1. add new costumer");
			System.out.println("2. add new pool");
			System.out.println("3. add costumer visit in a pool");
			System.out.println("4. add new manager");
			System.out.println("5. add pool to a manager");
			System.out.println("6. print pools of a manager");
			System.out.println("7. print proffesional pools");
			System.out.println("8. print kids details");
			System.out.println("9. finish");
			int opt = input.nextInt();

			// each case calls to a func in Service class
			switch (opt) {
			case 1:
				System.out.println("let's do option 1!");
				dataBase.opt1();
				break;
			case 2:
				System.out.println("let's do option 1!");
				dataBase.opt2();
				break;
			case 3:
				System.out.println("let's do option 3!");
				dataBase.opt3();
				break;
			case 4:
				System.out.println("let's do option 4!");
				dataBase.opt4();
				break;
			case 5:
				System.out.println("let's do option 5!");
				dataBase.opt5();
				break;
			case 6:
				System.out.println("let's do option 6!");
				dataBase.opt6();
				break;
			case 7:
				System.out.println("let's do option 7!");
				dataBase.opt7();
				break;
			case 8:
				System.out.println("let's do option 8!");
				dataBase.opt8();
				break;
			case 9:
				System.out.println("let's do option 9!");
				dataBase.opt9();

				// print db
				System.out.println("\nThe new db: ");
				for (Bracelet b : dataBase.getTableCodeBracelet().values())
					System.out.println(b.toString());
				for (Manager b : dataBase.getAllManagers())
					System.out.println(b.toString());
				for (Pool b : dataBase.getAllPools()) {
					System.out.println(b.toString());
				}
				flag = false;
				break;

			}
		}

		return;
	}

}
