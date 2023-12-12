package entity;

import java.net.URLDecoder;

/**
 * http://www.javapractices.com/topic/TopicAction.do?Id=2
 */
public final class Consts {
	private Consts() {
		throw new AssertionError();
	}

	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY;";
	public enum Manipulation {
    	UPDATE, INSERT, DELETE;
    }
	
	/*----------------------------------------- QUERIES -----------------------------------------*/
	public static final String SQL_SEL_AGENTS = "SELECT * FROM Agent ";
	public static final String SQL_SEL_MUSICIANS = "SELECT * FROM musician ";
	public static final String SQL_SEL_REPRESENTED = "SELECT * FROM represented_by ";
	public static final String SQL_SEL_CONCERTS = "SELECT * FROM  Concert_Area";
	public static final String SQL_SEL_AREAS = "SELECT * FROM Area";
	public static final String SQL_SEL_CONCERTSID = "SELECT * FROM Concert";
	public static final String SQL_SEL_PERFORMIN = "SELECT * FROM Perform_in";
	public static final String SQL_SEL_OCCURIN = "SELECT * FROM Occurs_in";
	
	
	
	public static final String SQL_INSERT_CONCERTID= "{ call qryInsConcertId(?); }";
    public static final String SQL_UPDATE_CONCERTID = "{ call qryUpdateParty(?,?,?,?,?,?,?,?,?); }";
	public static final String SQL_DELETE_CONCERTID = "{ call qryDeleteParty(?); }";
	
	public static final String SQL_INSERT_PERFORM= "{ call qryInsPerform(?,?,?); }";
    public static final String SQL_UPDATE_PERFORM = "{ call qryUpdperform(?,?,?); }";
	public static final String SQL_DELETE_PERFORM = "{ call qryDelPerform(?,?,?); }";
	
	public static final String SQL_INSERT_OCCUR = "{ call qryInsOccur(?,?,?,?,?,?); }";
    public static final String SQL_UPDATE_OCCUR = "{ call qryUpdOccur(?,?,?,?,?,?); }";
	public static final String SQL_DELETE_OCCUR = "{ call qryDelOccur(?,?,?); }";
	
	public static final String SQL_GET_SHOWS = "{ call qryMusicianShows(?); }";
	
	
	    

	/**
	 * find the correct path of the DB file
     * @return the path of the DB file (from eclipse or with runnable file)
	 */
	private static String getDBPath() {
		try {
			String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String decoded = URLDecoder.decode(path, "UTF-8");
			// System.out.println(decoded) - Can help to check the returned path
			if (decoded.contains(".jar")) {
				decoded = decoded.substring(0, decoded.lastIndexOf('/'));
				return decoded + "/database/ManageDB.accdb";
			} else {
				decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
				System.out.println(decoded);
				return decoded + "src/entity/ManageDB.accdb";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
