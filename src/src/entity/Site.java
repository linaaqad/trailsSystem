package entity;

import java.util.Objects;

public class Site {
	
	protected static long ID=21; // because i already have 20 sites in the DB 
	long siteNum;
	String siteName;
	float entranceFee;
	
	public Site(long siteNum,String siteName,float entranceFee) {
		super();
		this.siteNum = ID++ ;
		this.siteName = siteName;
		this.entranceFee = entranceFee;
	}
	
	public Site(long siteNum) {
		this.siteNum = ID++ ;
	}

	public long getSiteNum() {
		return siteNum;
	}

	public void setSiteNum(long siteNum) {
		this.siteNum = siteNum;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public float getEntranceFee() {
		return entranceFee;
	}

	public void setEntranceFee(float entranceFee) {
		this.entranceFee = entranceFee;
	}
	
	@Override
	public String toString() {
		return "Site [siteNum=" + siteNum + ", siteName=" + siteName + ", entranceFee=" + entranceFee + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(entranceFee, siteName, siteNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Site other = (Site) obj;
		return Float.floatToIntBits(entranceFee) == Float.floatToIntBits(other.entranceFee)
				&& Objects.equals(siteName, other.siteName) && siteNum == other.siteNum;
	}
	

	
}
