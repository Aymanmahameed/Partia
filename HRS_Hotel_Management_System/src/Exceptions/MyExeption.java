package Exceptions;


public class MyExeption extends Exception  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String msg;
	

	public MyExeption(String msg) {
		super(msg);
	}

}
