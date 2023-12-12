
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SystemDataBase {
	Scanner input = new Scanner(System.in);	
	private MainManager mainManager;
	private List<Pool> allPools;
	private List<Manager> allManagers;
	private Hashtable <Integer, Bracelet> tableCodeBracelet;
	private Hashtable <Integer, Manager> tablePoolsManager;


	// constructor for all 
	public SystemDataBase(MainManager mainManager) {
		super();
		this.allPools = this.allPools ==null?  new ArrayList<>(): this.allPools;
		this.allManagers = this.allManagers ==null?  new ArrayList<>(): this.allManagers;
		this.tableCodeBracelet =this.tableCodeBracelet ==null? new Hashtable <Integer, Bracelet> (): this.tableCodeBracelet;
		this.tablePoolsManager= this.tablePoolsManager ==null? new Hashtable <Integer, Manager> () : this.tablePoolsManager;
		this.mainManager = mainManager;
	}
	

	//add functions 

	public boolean addPool(Pool pool) {
		if (pool ==null) {
			return false;
		}
		if (allPools.contains(pool)) {
			return false;
		}
		 return allPools.add(pool);	
	}

	public boolean addManagers(Manager manager) {
		if (manager ==null) {
			return false;
		}
		if (allManagers.contains(manager)) {
			return false;
		}
		return allManagers.add(manager);	
		
	}
	//adding bracelet to Hashtable 
	public void addBracelet(Bracelet bracelet) { 
		if (bracelet==null) {
			return;
		}
		if (tableCodeBracelet.contains(bracelet)) {
			return;
		}
		tableCodeBracelet.put(bracelet.getCode(), bracelet);	
		
	}
	//for choice 3 - add costumer to pool and opposite
	public Pool findPoolbyID (int poolCode) {
		Pool tempP=null; 
		for (Pool p: allPools) {
			if (p.getCode()==poolCode) {
				tempP=p;
			}
		}
		return tempP; 		
	}

	public Bracelet findBraceletbyID (int bracId) {
		return tableCodeBracelet.get(bracId);
	}

	//for choice 6- look for manager in allManagers array list
	public Manager findMnagerbyID (int manaId) {
		Manager tempM=null;
		for (Manager m: allManagers) {
			if (m.getID()== manaId) {
				tempM=m ;
			}
		}
		return tempM;
	}
	
	public void printMangerPools (Manager m) {
		Pool p; 
		int pCode=0;
		int i=0;
		System.out.println("the pools that he manage:");
	//print head pools - array list 
	for (Map.Entry <Integer, Manager> entry: tablePoolsManager.entrySet()) {
		if (entry.getValue().equals(m)) {
			pCode= entry.getKey();	
			p = this.findPoolbyID(pCode);
			i++;
			System.out.println(i+". "+p.toString());	
		}
	}
	if (pCode==0) {
		System.out.println("this manager has no pools that he manage.");
	}
	return;
	}
	
	public int addPooltoManager(Pool p, Manager M) {
		for(Map.Entry<Integer,Manager> map:tablePoolsManager.entrySet()) {
			if(map.getKey()!=null) {
			if(map.getKey()==p.getCode()) {
				if(map.getValue()!=null) {
				return 0;
				}
			}
		}
		}
		tablePoolsManager.put(p.getCode(), M);
		M.addheadPools(p);
		p.addManager(M);
		return 1;
	}
	@Override
	public String toString() {
		return "SystemDataBase [allPools=" + allPools + ", allManagers=" + allManagers + ", tablePoolsManager="
				+ tablePoolsManager + ", tableCodeBracelet=" + tableCodeBracelet + ", mainManager=" + mainManager + "]";
	}
	
	//getters & setters
	public MainManager getMainManager() {
		return mainManager;
	}

	public void setMainManager(MainManager mainManager) {
		this.mainManager = mainManager;
	}

	public List<Pool> getAllPools() {
		return allPools;
	}

	public void setAllPools(List<Pool> allPools) {
		this.allPools = allPools;
	}

	public List<Manager> getAllManagers() {
		return allManagers;
	}

	public void setAllManagers(List<Manager> allManagers) {
		this.allManagers = allManagers;
	}

	public Hashtable<Integer, Bracelet> getTableCodeBracelet() {
		return tableCodeBracelet;
	}

	public void setTableCodeBracelet(Hashtable<Integer, Bracelet> tableCodeBracelet) {
		this.tableCodeBracelet = tableCodeBracelet;
	}

	public Hashtable<Integer, Manager> getTablePoolsManager() {
		return tablePoolsManager;
	}

	public void setTablePoolsManager(Hashtable<Integer, Manager> tablePoolsManager) {
		this.tablePoolsManager = tablePoolsManager;
	}
	
	
	//options func

		public void opt1() {
			Bracelet b;
			System.out.println("enter a name of the new costumer: ");
			String name = input.next();
			if(!name.isEmpty()){ //checking if we got null input
				//later we will add check if the name is letters- not in this task
				b = new Bracelet(name);
				this.addBracelet(b);	//call to function to add new costumer 		
				System.out.println("customer added successfully!");
				return; 
			}
			//in case the adding wasn't successful
			System.out.println("failed, please try again!");
			return;
		}
		
		public void opt2() {
			//first we'll scan all the characteristics that all pools have
			System.out.println("first enter basic characteristics:");
			System.out.println("enter pool depth: ");
			double depth= input.nextInt();
			System.out.println("enter pool width: ");
			double width= input.nextInt();
			System.out.println("enter pool length: ");
			double lenght= input.nextInt();
			
			//letting the user chose what kind of pool he wants to add to our system
			System.out.println("now, what kind of pool do you want it to be?");
			System.out.println("choose one of the following options (enter the number)");
			System.out.println("1- a regular pool");
			System.out.println("2- a proffesional pool");
			System.out.println("3- a kids pool");
			int choise= input.nextInt();
			
			switch (choise) {
			//regular pool
			case 1: 
				System.out.println("lets add regular pool");
				Pool newPool= new Pool (depth,width,lenght);
				if (this.addPool(newPool)) {
					System.out.println("pool added successfully!");
					return;
				}
				//in case the adding wasn't successful
				System.out.println("Something went wrong, please try again!"); 
				break;
			
			//Professional pool
			case 2: 
				System.out.println("lets add a proffesional pool");
				System.out.println("enter number of swimming lanes");
				int swimlanes= input.nextInt();
		
				Pool newPP= new ProffesionalPool (depth,width,lenght, swimlanes);
				if (this.addPool(newPP)) {
					System.out.println("pool added successfully!");
					return;
				}
				//in case the adding wasn't successful
				System.out.println("Something went wrong, please try again!"); 
				break;
				
			//kids pool
			case 3: 
				boolean isNeeded = false;
				System.out.println("lets add proffesional pool");
				System.out.println("enter a maximum age in the pool: ");
				int maxAge= input.nextInt();
				System.out.println("Do the kids need a chaperone? ");
				System.out.println("enter: 1-yes, 2-no");
				int answer=input.nextInt();
				if (answer==1) {
					isNeeded= true; 
				}
				if (answer==2) {
					isNeeded= false;
				}
				else if (answer !=1 && answer!=2) {
					System.out.println("you can choose only 1/2! please start over..");
					return;
				}
				
				Pool newKP= new KidsPool (depth,width,lenght,maxAge,isNeeded);
				if (this.addPool(newKP)) {
					System.out.println("pool added successfully!");
					return;
				}
				//in case the adding wasn't successful
				System.out.println("Something went wrong, please try again!"); 
				break;	
				
			 default:
				 System.out.println("you need to choose one of the chars: 1/2/3 only!");
			}
			return;		
		}
		
		public void opt3() {
			int bracId=0;
			int poolId =0;
			Pool p;
			Bracelet b;
			System.out.println("enter bracelet code: ");
			bracId = input.nextInt();
			System.out.println("enter pool code: ");
			poolId = input.nextInt();
			
			p=this.findPoolbyID(poolId);
			b=this.findBraceletbyID(bracId);
			//if both does'nt exist
			if(p==null&&b==null) {
				System.out.println("fail! pool&customer ID doesn't exist! try again..");
				return;
			}
			//if pool is not in the array list- we don't have this pool in the system 
			if(p==null) {
				System.out.println("fail! pool ID doesn't exist! try again..");
				return;
			}
			//if the costumer is not in the hashtable- we don't have this costumer in the system 
			if(b==null) {
				System.out.println("fail! customer ID doesn't exist! try again..");
				return;
			}
			//call to adding functions
			p.addBracelet(b);
			b.addPool(p);
			System.out.println("customer added successfully to the pool!");
			return;
		}
		
		public void opt4() {
			String manaName=null;
			int manaAge=0; 
			int manaSalery=0;
			System.out.println("enter manager name: ");
			manaName = input.next();
			System.out.println("enter manager age: ");
			manaAge = input.nextInt();
			System.out.println("enter manager salery: ");
			manaSalery = input.nextInt();
			//we want to accept name and age above 15 
			if(!manaName.isEmpty() && manaAge >= 16) {
				Manager m = new Manager(manaName,manaAge, manaSalery);
				this.addManagers(m); 
				System.out.println("manager added successfully!");
				return;
				}
			if(manaAge < 16) {
				System.out.println("the manager age is not makes sense!");
			}
			//in case the adding wasn't successful
			System.out.println("manager wasn't added successfully, please try again!");
		}
		
		public void opt5() {
			int manaId=0;
			int poolId =0;
			Pool p;
			Manager m;
			System.out.println("enter pool code: ");
			poolId = input.nextInt();
			System.out.println("enter manager code: ");
			manaId = input.nextInt();
			
			p= this.findPoolbyID(poolId);
			m=this.findMnagerbyID(manaId);
			
			//if both not exist 
			if(p==null&&m==null) {
				System.out.println("failed! pool&manager ID doesn't exist!");
				return;
			}
			//if pool is not in the array list- we don't have this pool in the system 
			if(p==null) {
				System.out.println("failed! pool ID doesn't exist!");
				return;
			}
			//if the manager is not in the array list- we don't have this manager in the system 
			if(m==null) {
				System.out.println("failed! manager ID doesn't exist!");
				return;
			}
			this.getTablePoolsManager().put(poolId,m);
			//for those who didn't gave up on the classes:
			p.addManager(m);
			m.addheadPools(p);
			System.out.println("added successfully! the manager is now managing the pool..");
		}
		
		public void opt6() {
			Manager m; 
			System.out.println("enter manager id: ");
			int manaId = input.nextInt();
			
			//looking for the manager
			m=this.findMnagerbyID(manaId);
			//if manager is not in the array list- we don't have this manager in the system 
			if (m == null) {
				System.out.println("the manager ID doesn't exist! try again..");
				return ;
			}
			//printing all the manager's pools
			this.printMangerPools(m);
			return; 
		}
		
		
		public void opt7() {
			boolean flagG=false;
			Bracelet br;
			int i=0;
			System.out.println("enter bracelet id: ");
			int bId = input.nextInt();
			br=findBraceletbyID(bId);
			if (br==null) {
				System.out.println("failed! customer ID doesn't exist.");
				return;
			}
			if(br.getPoolsOfToday().isEmpty()) {
				System.out.println("this customer didn't visit in any pool yet.");
				return;
			}
			
			System.out.println("enter olympic game name: ");
			String gName = input.next();
			
			
			for (Pool p : br.getPoolsOfToday()) {
				if(p instanceof ProffesionalPool) {
					if(((ProffesionalPool) p).getOlympicGamesNames().contains(gName)) {			
						flagG=true;
					}
				}
			}	
			if(!flagG) {
				System.out.println("there is no such game name in the braclet pools..");
				return;
			}
			
			System.out.println("the pools that the braclet has been at and contain the game name:");
			for (Pool p : br.getPoolsOfToday()) {
				if(p instanceof ProffesionalPool) {
					if(((ProffesionalPool) p).getOlympicGamesNames().contains(gName)) {			
						i++;
						System.out.println(i+". "+p.toString());
					}
				}
			}	
		}

		
		
		public void opt8() {
			Manager ma;
			int i=0;
			System.out.println("enter manager id: ");
			int mId = input.nextInt();
			ma=findMnagerbyID(mId);
			if(ma==null) {
				System.out.println("failed! the manager doesn't exist.");
				return;
			}
			if(ma.getPool().isEmpty()) {
				System.out.println("this manager don't manage any pool.");
				return;
			}
			System.out.println("the kids at the manager pools:");
			for(Pool p : ma.getPool()) {
				if(p instanceof KidsPool) {
				/*	if(p.getCostumersOfToday().isEmpty()) {
						System.out.println("there is no customers in this pool yet.");
						return;
					}*/	
					for(Bracelet b: p.getCostumersOfToday()) {
						i++;
						System.out.println(i+". name="+b.getcustomerName()+", code="+b.getCode());
					}
					
				}	
			}
			return;
		}
		
		public void opt9() {
			System.out.println("Thank you for visiting today! ");
			System.out.println("bye bye!");
		}
		
		






}
