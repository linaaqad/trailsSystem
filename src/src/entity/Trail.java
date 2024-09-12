package entity;

import java.util.ArrayList;
import java.util.Objects;

public class Trail {
	long TrailNum;
	String description;
	DifficultyLevel difficultyLevel; 
	float length;
	TrailType trailType;
	int siteNum;
	//NatureGuide natureGuideId;
	
	public Trail(long TrailNum,String description,DifficultyLevel difficultyLevel, float length,TrailType trailType,int siteNum) {
		super();
		this.TrailNum = TrailNum;
		this.description = description;
		this.difficultyLevel = difficultyLevel;
		this.length = length;
		this.trailType = trailType;
		this.siteNum = siteNum;
		//this.guidesList = guidesList;
	}
	
	public Trail(long TrailNum) {
		super();
		this.TrailNum = TrailNum;
	}
	

	

/*	public ArrayList<NatureGuide> getGuidesList() {
		return guidesList;
	}

	public void setGuidesList(ArrayList<NatureGuide> guidesList) {
		this.guidesList = guidesList;
	}
	*/


	public long getTrailNum() {
		return TrailNum;
	}

	public void setTrailNum(long trailNum) {
		TrailNum = trailNum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DifficultyLevel getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public TrailType getTrailType() {
		return trailType;
	}

	public void setTrailType(TrailType trailType) {
		this.trailType = trailType;
	}

	public int getSiteNum() {
		return siteNum;
	}

	public void setSiteNum(int siteNum) {
		this.siteNum = siteNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(TrailNum, description, difficultyLevel, length, trailType);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trail other = (Trail) obj;
		return TrailNum == other.TrailNum && Objects.equals(description, other.description)
				&& difficultyLevel == other.difficultyLevel
				&& Float.floatToIntBits(length) == Float.floatToIntBits(other.length) && trailType == other.trailType;
	}


	@Override
	public String toString() {
		return "Trail [TrailNum=" + TrailNum + ", description=" + description + ", difficultyLevel=" + difficultyLevel
				+ ", length=" + length + ", trailType=" + trailType + "]";
	}

}
