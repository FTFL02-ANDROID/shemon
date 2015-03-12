package com.ftfl.icare.model;

public class Profile {

	// ------------------ Variables ------------------- //
	private String mName = null;
	private String mDateOfBirth = null;
	private String mHeight = null;
	private String mWeight = null;
	private String mBloodGroup = null;
	private Integer mID = null;
	
	public Profile() {
		super();
	}

	// --- Constructor with ID and OtherParameters ---- //
	public Profile(Integer mID, String mName, String mDateOfBirth, String mHeight,
			String mWeight, String mBloodGroup ) {
		super();
		this.mID = mID;
		this.mName = mName;
		this.mDateOfBirth = mDateOfBirth;
		this.mHeight = mHeight;
		this.mWeight = mWeight;
		this.mBloodGroup = mBloodGroup;
		
	}

	// --- Constructor without ID and OtherParameters ---- //
	public Profile(String mName, String mDateOfBirth, String mHeight,
			String mWeight, String mBloodGroup) {
		super();
		this.mName = mName;
		this.mDateOfBirth = mDateOfBirth;
		this.mHeight = mHeight;
		this.mWeight = mWeight;
		this.mBloodGroup = mBloodGroup;
	}

	// -------------- Getter Setter Methods --------------- //
	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmDateOfBirth() {
		return mDateOfBirth;
	}

	public void setmDateOfBirth(String mDateOfBirth) {
		this.mDateOfBirth = mDateOfBirth;
	}

	public String getmHeight() {
		return mHeight;
	}

	public void setmHeight(String mHeight) {
		this.mHeight = mHeight;
	}

	public String getmWeight() {
		return mWeight;
	}

	public void setmWeight(String mWeight) {
		this.mWeight = mWeight;
	}

	public String getmBloodGroup() {
		return mBloodGroup;
	}

	public void setmBloodGroup(String mBloodGroup) {
		this.mBloodGroup = mBloodGroup;
	}

	public Integer getmID() {
		return mID;
	}

	public void setmID(Integer mID) {
		this.mID = mID;
	}

}
