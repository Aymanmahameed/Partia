
public class MainManager extends Manager{
	
	private String userName;
	private String password;
	
	
	public MainManager(int iD, String name, int age, int salery, Pool[] pool, String userName, String password) {
		super(name, age, salery, pool);
		this.userName = userName;
		this.password = password;
	}
	
	public MainManager(String name, int age, int salery, String userName, String password) {
		super(name, age, salery);
		this.userName = userName;
		this.password = password;
	}


	public MainManager(String name, int age, int salery, Pool[] pool) {
		super(name, age, salery, pool);
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MainManager [id=" + id + ", name=" + name
				+ ", age=" + age + ", salery=" + salery + ", headPools=" + headPools + ", userName=" + userName + ", password=" + password+"]";
	}


	
	
	

	
	

	
}
