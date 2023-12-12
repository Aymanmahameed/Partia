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
	public static final String SQL_SEL_CUSTOMES = "SELECT * FROM Customers  ";
	public static final String SQL_SEL_FRIEND = "{ call showFriends(?); }";
	public static final String SQL_SEL_ALLFREIENDSHIP = "SELECT * FROM Friendships";
	public static final String SQL_SEL_PARTIES = "SELECT * FROM Parties";
	public static final String SQL_SEL_CONCERTS = "SELECT * FROM ConcertSquares";
	public static final String SQL_SEL_PARTIESLOCATIONS = "SELECT * FROM PartiesLocations";
	public static final String SQL_SEL_ARTIST = "SELECT * FROM Artists";
	public static final String SQL_SEL_SHOW = "SELECT * FROM Shows";
	public static final String SQL_SEL_PARTICIPANTINPARTY = "SELECT * FROM ParticipantsInParties";
	public static final String SQL_SEL_PARTICIPANTINLOCATION = "SELECT * FROM ParticipanstInLocation";
	public static final String SQL_SEL_PARTICIPANTINLSQARE = "SELECT * FROM ParticipantsInPerformanceSquares";
	
	public static final String SQL_SEL_SHOWBYID = "{ call qrygetShowsbyId(?)}";
	
	
	
	
	
	public static final String SQL_INS_FREIENDSHIP = "{ call qryInsFriendships(?,?)}";
	public static final String SQL_DEL_FREIENDSHIP = "{ call qryDelFrienship(?,?) ;}";

	

	public static final String SQL_INS_ARTIST = "{ call qryInsArtist(?,?,?,?);}";
	public static final String SQL_DEL_ARTIST = "{ }";
	public static final String SQL_UPDATE_ARTIST = "{call qryUpdateArtist(?,?,?,?);}";

	public static final String SQL_INSERT_PARTY = "{ call qryInsertParty(?,?,?,?,?,?,?,?,?); }";
	public static final String SQL_UPDATE_PARTY = "{ call qryUpdateParty(?,?,?,?,?,?,?,?,?); }";
	public static final String SQL_DELETE_PARTY = "{ call qryDeleteParty(?); }";

	public static final String SQL_INSERT_LOCATION = "{ call qryInsLocation(?,?,?,?,?,?); }";
	public static final String SQL_UPDATE_LOCATION = "{call qryUpdateLocation(?,?,?,?,?,?)}; ";
	public static final String SQL_DEL_LOCATION = "{ }";

	public static final String SQL_INSERT_CONCERT = "{ call qryInsConcert(?,?,?,?,?,?,?); }";
	public static final String SQL_UPDATE_CONCERT = "{call qryUpdateConcert(?,?,?,?,?,?,?)} ;";
	public static final String SQL_DEL_CONCERT = "{ } ;";
	
	
	public static final String SQL_INSERT_PARTINPARTY = "{ call qryInsParticipantInParty(?,?,?,?,?); }";
	public static final String SQL_UPDATE_PARTINPARTY = "{call qryupdParInParty(?,?,?,?,?)} ;";
	public static final String SQL_DEL_PARTINPARTY = "{call qryDelParInParty(?,?,?)} ;";
	
	
	public static final String SQL_INSERT_PARTINLOCATION = "{ call qryinsParticipanstInLocation(?,?,?,?); }";
	public static final String SQL_UPDATE_PARTINLOCATION = "{call qryUpdParticipantsInLocation(?,?,?,?)} ;";
	public static final String SQL_DEL_PARTINLOCATION = "{call qryDelParticipanstInLocation(?,?)} ;";
	
	public static final String SQL_INSERT_PARTINSQUARE = "{ call qryInspartInSquare(?,?); }";
	public static final String SQL_UPDATE_PARTINSQUARE = "{call qryUpdPartInSquare(?,?,?,?)} ;";
	public static final String SQL_DEL_PARTINSQUARE = "{call qryDelPartInSquare(?,?)} ;";
	
	
	

	/**
	 * find the correct path of the DB file
	 * 
	 * @return the path of the DB file (from eclipse or with runnable file)
	 */
	private static String getDBPath() {
		try {
			String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String decoded = URLDecoder.decode(path, "UTF-8");
			// System.out.println(decoded) - Can help to check the returned path
			if (decoded.contains(".jar")) {
				decoded = decoded.substring(0, decoded.lastIndexOf('/'));
				return decoded + "/database/Db2.accdb";
			} else {
				decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
				System.out.println(decoded);
				return decoded + "src/entity/Db2.accdb";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
