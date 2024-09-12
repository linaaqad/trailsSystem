package entity;

import java.net.URLDecoder;

public class Consts {
	
	protected static final String DB_FILEPATH = getDBPath();
	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";
	
	public static final String SQL_SEL_sites = "SELECT siteNumber FROM TblSite";
	public static final String SQL_SEL_NatureGuides = "SELECT * FROM TblNatureGuide";
	public static final String SQL_INS_TRAIL = "{ call qryInsTrail(?,?,?,?,?) }";
	public static final String SQL_INS_Guidedate = "{ call qryInsGuidedate(?,?,?) }";
	
	
	private static String getDBPath() {
		try {
		String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decoded = URLDecoder.decode(path, "UTF-8");
		if (decoded.contains(".jar")) {
		decoded = decoded.substring(0, decoded.lastIndexOf('/'));
		return decoded + "/ex1_Accsess_2024_LSteam.accdb";
		} else {
		decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
		return decoded + "src/entity/ex1_Accsess_2024_LSteam.accdb";
		}
		} catch (Exception e) {
		e.printStackTrace();
		 return null;
		}
	}


}
