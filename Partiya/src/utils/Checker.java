package utils;



public class Checker {
	
	
	
	private static Checker instance;

	private Checker() {
		
	}

	public static Checker getInstance() {
		if (instance == null)
			instance = new Checker();
		return instance;
	}
	
	
	
	public Boolean isNum(String string) {
		if(string.isEmpty()) return false;
		for(int i=0;i<string.length();i++) {
			if(string.charAt(i)<'0' || string.charAt(i)>'9') {
				return false;
			}
			
		}
		return true;
	}
	
	public Boolean isRightName(String name) {
		return true;
	}
	
	public Boolean cardCheck(String name,String cardnum,String id,String cvv) {
		return isNum(id) && isNum(cardnum) && isNum(cvv) && isRightName(name);
	}

}
