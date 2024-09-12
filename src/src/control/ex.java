package control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.sql.Date;

import entity.Consts;
import entity.Guide;
import entity.NatureGuide;
import entity.Site;

public class ex {
	private static ex _instance;

	public static ex getInstance() {
		if (_instance == null)
			_instance = new ex();
		return _instance;
	}
	
	public ArrayList<NatureGuide> getNatureGuide() {
		ArrayList<NatureGuide> results = new ArrayList<NatureGuide>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts. SQL_SEL_NatureGuides);
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
/*
	public ArrayList<Site> getSite() {
		ArrayList<Site> results = new ArrayList<Site>();
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.SQL_SEL_sites);
					ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					int i = 1;
					results.add(new Site(rs.getInt(i++)));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return results;
}
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
	
}