import java.util.ArrayList;

import java.util.List;

public class Bracelet {
	
	private static int CODE=1;
	private int code;
	private String customerName;
	private  List<Pool> poolsOfToday= new ArrayList<>();
	
	//adding new Pool
	public boolean addPool(Pool pool) {
			if (pool ==null) {
				return false;
			}
			if (poolsOfToday.contains(pool)) {
				return true;
			}
				return poolsOfToday.add(pool);
		}
	
	//adding new headPools
		public boolean addPoolsforToday (Pool pool) {
			if (pool ==null) {
				return false ;
			}
			if (poolsOfToday.contains(pool)) {
				return false;
			}
			 return poolsOfToday.add(pool);		
		}
		

	public Bracelet(String customerName) {
		super();
		this.code = CODE++;
		this.customerName = customerName;
	}
	
	
	public Bracelet() {
		super();
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getcustomerName() {
		return customerName;
	}
	public void setcustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<Pool> getPoolsOfToday() {
		return poolsOfToday;
	}
	public void setPoolsOfToday(List<Pool> poolsOfToday) {
		this.poolsOfToday = poolsOfToday;
	}

	
	@Override
	public String toString() {
		ArrayList<Integer> tmpP = new ArrayList<Integer>();
		for(Pool p:poolsOfToday) {
			tmpP.add(p.getCode());
		}
		return "Bracelet [code=" + code + ", customerName=" + customerName + ", poolsOfToday="
				+ tmpP.toString() + "]";
	}

	
}
