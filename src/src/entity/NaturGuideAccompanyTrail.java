package entity;

import java.util.ArrayList;
import java.util.Date;

public class NaturGuideAccompanyTrail{
	long trailNum;
	Date trailDate;
	String natureGuideId;

    public NaturGuideAccompanyTrail(long trailNum, String  natureGuideId, Date trailDate) {
    	super();
		this.trailNum = trailNum;
		this.natureGuideId = natureGuideId;
		this.trailDate = trailDate;
	}

	public long getTrailNum() {
		return trailNum;
	}

	public void setTrailNum(long trailNum) {
		this.trailNum = trailNum;
	}

	public Date getTrailDate() {
		return trailDate;
	}

	public void setTrailDate(Date trailDate) {
		this.trailDate = trailDate;
	}

	public String getNatureGuideId() {
		return natureGuideId;
	}

	public void setNatureGuideId(String natureGuideId) {
		this.natureGuideId = natureGuideId;
	}
}