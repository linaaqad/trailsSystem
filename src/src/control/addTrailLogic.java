package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import entity.Consts;
import entity.DifficultyLevel;
import entity.NatureGuide;
import entity.Site;
import entity.Trail;
import entity.TrailType;

public class addTrailLogic {
	
	private static addTrailLogic _instance;

	private addTrailLogic() {
	}

	public static addTrailLogic getInstance() {
		if (_instance == null)
			_instance = new addTrailLogic();
		return _instance;
	}
	
	/**
	 * Add new Trail to the trails list in DB 
	 * return true if the adding was successful, else - return false
	 * @param customerID - the customer to delete from DB
     * @return 
	 */		
		
	

	 public ArrayList<Long> getSiteNumbers() {
	        ArrayList<Long> siteNumbers = new ArrayList<>();
	        try {
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
	                 PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_sites);
	                 ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    siteNumbers.add(rs.getLong("siteNumber"));
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return siteNumbers;
	    }
	
	public ArrayList<NatureGuide> getNatureGuide() {
		ArrayList<NatureGuide> results = new ArrayList<NatureGuide>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_NatureGuides);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new NatureGuide(rs.getString(i++), rs.getString(i++), rs.getDate(i++), rs.getString(i++),
							rs.getString(i++), rs.getBoolean(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
}  

	
	public static int addtrail(String difficultyLevel, String description, float length, 
            String trailType, int siteNum) {
	     	int generatedTrailNum = -1; 
           // to deleteeee this testtttttttttttttttt
		    System.out.println(difficultyLevel + description + length + trailType + siteNum);
           // System.out.println("hhhhhhhhhdhfhgjhhhh");
           try {
               Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
           CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_TRAIL)) {
           int i = 1;
           if (difficultyLevel != null) {
           stmt.setString(i++, difficultyLevel); 
            } else {  
           stmt.setNull(i++, java.sql.Types.VARCHAR);
          }
          if (description != null) {
            stmt.setString(i++, description);
          } else {
          stmt.setNull(i++, java.sql.Types.VARCHAR);
          }
          stmt.setFloat(i++, length);
          if (trailType != null) {
          stmt.setString(i++, trailType); 
          } else {
          stmt.setNull(i++, java.sql.Types.VARCHAR);
          }
          stmt.setInt(i++, siteNum);
          stmt.executeUpdate();
          
          try (Statement maxTrailNumStmt = conn.createStatement();
                  ResultSet rs = maxTrailNumStmt.executeQuery("SELECT MAX(trailNum) FROM tblTrail")) {
                 if (rs.next()) {
                     generatedTrailNum = rs.getInt(1);
                 }
             }
          System.out.println("Trail added successfully!");
          } catch (SQLException e) {
          e.printStackTrace();
          System.out.println("Failed to add trail: " + e.getMessage());
          }
          } catch (ClassNotFoundException e) {
          e.printStackTrace();
          System.out.println("Failed to add trail: " + e.getMessage());
          } catch (NumberFormatException e) {
          e.printStackTrace();
          System.out.println("Invalid input format. Please provide valid values.");
           }
           return generatedTrailNum;
         }
	
	public static void addguidedate(long trailnum , String natureguideId , Date traildate) {
		System.out.println(trailnum + natureguideId + traildate );
		try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
        CallableStatement stmt = conn.prepareCall(Consts.SQL_INS_Guidedate)) {
        int i = 1;
            stmt.setLong(i++, trailnum);
            
        if (natureguideId != null) {
            stmt.setString(i++, natureguideId); 
             } else {  
            stmt.setNull(i++, java.sql.Types.VARCHAR);
           }
        
        if (traildate != null) {
            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(traildate.getTime());
            stmt.setDate(i++, sqlDate);
        } else {
            stmt.setNull(i++, java.sql.Types.DATE);
        }
           stmt.executeUpdate();
           
           System.out.println("guide added successfully!");
        } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Failed to add guide: " + e.getMessage());
        }
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        System.out.println("Failed to add guide: " + e.getMessage());
        } catch (NumberFormatException e) {
        e.printStackTrace();
        System.out.println("Invalid input format. Please provide valid values.");
         }
   }
}


