import java.util.ArrayList;

import java.util.List;

public class Pool {
	
	protected static int CODE=1;
	protected int code;
	protected double depth;
	protected double width;
	protected double length;
	protected List<Bracelet> costumersOfToday= new ArrayList<>();
	protected Manager managerOfThePool= new Manager();
	
	
	
	public Pool(double depth, double width, double length) {
		super();
		this.code = CODE++;
		this.depth = depth;
		this.width = width;
		this.length = length;
		
	}


	public Pool(double depth, double width, double length, List<Bracelet> costumersOfToday) {
		super();
		this.code = CODE++;
		this.depth = depth;
		this.width = width;
		this.length = length;
		this.costumersOfToday = costumersOfToday;
	}


	public Pool() {
		super();
	}

	public List<Bracelet> getCostumersOfToday() {
		return costumersOfToday;
	}


	public void setCostumersOfToday(List<Bracelet> costumersOfToday) {
		this.costumersOfToday = costumersOfToday;
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public Manager getManagerOfThePool() {
		return managerOfThePool;
	}


	public void setManagerOfThePool(Manager managerOfThePool) {
		this.managerOfThePool = managerOfThePool;
	}
	public String getCustomersbyString() {
		
		ArrayList<Integer> tmpC = new ArrayList<Integer>();
		for(Bracelet b:costumersOfToday) {
			tmpC.add(b.getCode());
		}
		
		return tmpC.toString();
		
	}


	
	
	
	@Override
	public String toString() {
		String man;
		ArrayList<Integer> tmpC = new ArrayList<Integer>();
		for(Bracelet b:costumersOfToday) {
			tmpC.add(b.getCode());
		}
		if(managerOfThePool.getID()==0) {
			man="none";
		}
		else man=String.valueOf(managerOfThePool.getID());

		return "Pool [code=" + code + ", depth=" + depth + ", width=" + width + ", length=" + length
				+ ", costumersOfToday=" + tmpC.toString() + ", managerCode=" + man + "]";
	}


	//adding new Bracelet\customer
	//change to like add pool in Bracelet
	public boolean addBracelet(Bracelet bracelet) {
		if (bracelet ==null) {
			return false;
		}
		if (costumersOfToday.contains(bracelet)) {
			return true;
		}
		else {
			return costumersOfToday.add(bracelet);	
		}
	}
	
	
		public void addManager(Manager manager) {
			setManagerOfThePool(manager);
		}

}
