import java.io.BufferedWriter;
public class Exeptions extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedWriter writetocon;
	void addbracopool(Bracelet b, Pool p) throws Exception {
		if (p.getCostumersOfToday().size() >= 50)
			throw new Exception("The pool is full!");
		else {
			b.addPool(p);
			p.addBracelet(b);
			
		}
	}
	void checkRemoving(Bracelet b)throws Exception {
		if(!b.getPoolsOfToday().isEmpty())
			throw new Exception("The customer have pools");
		
		else return;
	}
}
