package entity;

import java.util.Date;
import java.util.Objects;

public class Guide {
	String guideserialNumber;
	String name;
	Date dateOfBirth;
	String email;
	String phoneNumber;
	Boolean isSocial;
	
	public  Guide(String guideserialNumber,String name,Date dateOfBirth,String email,String phoneNumber,Boolean isSocial)
	{
		super();
		this.guideserialNumber = guideserialNumber;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isSocial = isSocial;
	}

	public String getGuideserialNumber() {
		return guideserialNumber;
	}

	public void setGuideserialNumber(String guideserialNumber) {
		this.guideserialNumber = guideserialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Boolean getIsSocial() {
		return isSocial;
	}

	public void setIsSocial(Boolean isSocial) {
		this.isSocial = isSocial;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateOfBirth, email, guideserialNumber, isSocial, name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guide other = (Guide) obj;
		return Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
				&& guideserialNumber == other.guideserialNumber && Objects.equals(isSocial, other.isSocial)
				&& Objects.equals(name, other.name) && Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "Guide [guideserialNumber=" + guideserialNumber + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", isSocial=" + isSocial + "]";
	}


}
