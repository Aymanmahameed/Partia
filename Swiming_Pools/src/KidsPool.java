import java.util.ArrayList;
import java.util.Arrays;

public class KidsPool extends Pool {
	
	private int maxAges;
	private boolean isNeeded;
	
	public KidsPool(double depth, double width, double length, int maxAges, boolean isNeeded) {
		super(depth, width, length);
		this.maxAges = maxAges;
		this.isNeeded = isNeeded;
	}
	
	public KidsPool(double depth, double width, double length, int maxAges) {
		super(depth, width, length);
		this.maxAges = maxAges;
		
	}

	public KidsPool(double depth, double width, double length) {
		super(depth, width, length);
	}

	public int getMaxAges() {
		return maxAges;
	}

	public void setMaxAges(int maxAges) {
		this.maxAges = maxAges;
	}

	public boolean isNeeded() {
		return isNeeded;
	}

	public void setNeeded(boolean isNeeded) {
		this.isNeeded = isNeeded;
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
		return "KidsPool [code=" + code + ", depth=" + depth
				+ ", width=" + width + ", length=" + length + ", costumersOfToday=" + tmpC.toString()
				+ ", managerOfThePool=" + man + ", maxAges=" + maxAges + ", isNeeded=" + isNeeded + "]";
	}

	
	
	
	
	
}
