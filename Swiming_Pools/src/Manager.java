import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manager {
	
	protected static int ID=1;
	protected int id;
	protected String name;
	protected int age;
	protected int salery;
	protected List<Pool> headPools= new ArrayList<>();
	
	
	
	public Manager(String name, int age, int salery, Pool[] pool) {
		super();
		this.id=ID++;
		this.name = name;
		this.age = age;
		this.salery = salery;
	}
	
	public Manager(int id, String name, int age, int salery) {
		super();
		this.id = ID++;
		this.name = name;
		this.age = age;
		this.salery = salery;
	
	}
	
	//constructor for opt 4- create manager without asking to enter id
	public Manager(String name, int age, int salery) {
		this.id = ID++;
		this.name = name;
		this.age = age;
		this.salery = salery;
		
	}


	public Manager() {
		super();
	}



	public int getID() {
		return id;
	}


	public void setID(int iD) {
		id = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int getSalery() {
		return salery;
	}


	public void setSalery(int salery) {
		this.salery = salery;
	}


	public List<Pool> getPool() {
		return headPools;
	}


	public void setPool(List<Pool> pool) {
		headPools = pool;
	}

	@Override
	public String toString() {
		int [] tempPArr = new int[0];
		int i=0;
		for(Pool p:headPools) {
			tempPArr=Arrays.copyOf(tempPArr, i+1);
			tempPArr[i]=p.getCode();
			i++;
		}
		return "Manager [id=" + id + ", name=" + name + ", age=" + age + ", salery=" + salery + ", headPools="
				+ Arrays.toString(tempPArr) + "]";
	}
	
	//adding new headPools
	public void addheadPools(Pool pool) {
		if (pool ==null) {
			return;
		}
		if (headPools.contains(pool)) {
			return;
		}
		else {
			headPools.add(pool);	
			}
		}

	
}
