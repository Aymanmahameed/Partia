import java.util.ArrayList;
import java.util.List;

public class ProffesionalPool extends Pool {
	
	private int swimmingLanes;
	private List<String> olympicGamesNames= new ArrayList<>();
	

	public ProffesionalPool(double depth, double width, double length, int swimmingLanes,
			List<String> olympicGamesNames) {
		super(depth, width, length);
		this.swimmingLanes = swimmingLanes;
		this.olympicGamesNames = olympicGamesNames; 
	}
	
	public ProffesionalPool(double depth, double width, double length, int swimmingLanes) {
		super(depth, width, length);
		this.swimmingLanes = swimmingLanes;
	
	}


	public ProffesionalPool() {
		super();
	}


	public int getSwimmingLanes() {
		return swimmingLanes;
	}


	public void setSwimmingLanes(int swimmingLanes) {
		this.swimmingLanes = swimmingLanes;
	}


	public List<String> getOlympicGamesNames() {
		return olympicGamesNames;
	}


	public void setOlympicGamesNames(List<String> olympicGamesNames) {
		this.olympicGamesNames = olympicGamesNames;
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
		return "ProfPool [code=" + code + ", depth=" + depth + ", width=" + width + ", length=" + length
				+ ", costumersOfToday=" + tmpC.toString() + ", managerCode=" + man + ", swimmingLanes=" + swimmingLanes + ", olympicGamesNames=" + olympicGamesNames
						+"]";
	}

		//adding new olympicGamesNames
		public void addOlympicGamesNames(String name) {
			if (name ==null) {
				return;
			}
			if (olympicGamesNames.contains(name)) {
				return;
			}
			else {
				olympicGamesNames.add(name);	
			}
		}
		

	
}
