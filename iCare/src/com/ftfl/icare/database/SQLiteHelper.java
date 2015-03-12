package com.ftfl.icare.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "iCare.db";
	private static final int DATABASE_VERSION = 2;

	//profile table constant
	public static final String TABLE_NAME_PROFILE = "profile";
	public static final String COLUMNL_PROFILE_ID_FIELD = "id";
	public static final String COLUMNL_PROFILE_NAME_FIELD = "profileName";
	public static final String COLUMNL_DATE_OF_BIRTH_FIELD = "dateOfBirth";
	public static final String COLUMNL_HEIGHT_FIELD = "height";
	public static final String COLUMNL_WEIGHT_FIELD = "weight";
	public static final String COLUMNL_BLOOD_GROUP_FIELD = "bloodGroup";
	
	
	// ICare Doctor Profile Table
			public static final String I_CARE_DOCTOR_PROFILE = "icaredoctorprofiles";
			public static final String COL_ICARE_DOCTOR_PROFILE_ID = "id";
			public static final String COL_ICARE_DOCTOR_PROFILE_NAME = "doctor_name";
			public static final String COL_ICARE_DOCTOR_PROFILE_SPECIALITY = "speciality";
			public static final String COL_ICARE_DOCTOR_PROFILE_PHONE = "phone";
			public static final String COL_ICARE_DOCTOR_PROFILE_EMAIL = "email";
			public static final String COL_ICARE_DOCTOR_PROFILE_CHAMBER = "chamber";

			// table name
			public static final String DIET_TABLE_NAME = "diet_information";
			public static final String KEY_DIET_ID = "id";
			public static final String KEY_FEAST = "feast";
			public static final String KEY_MENU = "menu";
			public static final String KEY_DIET_DATE = "diet_date";
			public static final String KEY_DIET_TIME = "diet_time";
			public static final String KEY_ALARM = "alarm";

			// table information
			public String CREATE_DIET_TABLE = "create table " + DIET_TABLE_NAME + "("
					+ KEY_DIET_ID + " integer primary key autoincrement, "
					+ KEY_FEAST + " text not null, " 
					+ KEY_MENU + " text not null, "
					+ KEY_DIET_DATE + " text not null, " 
					+ KEY_DIET_TIME + " text not null, " 
					+ KEY_ALARM + " text not null);";
			
	// create profile table
	public static final String TABLE_CRATE_PROFILE = "create table " + TABLE_NAME_PROFILE
			+ "(" + COLUMNL_PROFILE_ID_FIELD + " INTEGER PRIMARY KEY, "
			+ COLUMNL_PROFILE_NAME_FIELD + " text, " + COLUMNL_DATE_OF_BIRTH_FIELD + " text, "
			+ COLUMNL_HEIGHT_FIELD + " text, " + COLUMNL_WEIGHT_FIELD + " text, " 
			+ COLUMNL_BLOOD_GROUP_FIELD + " text)";
	
	// Database creation sql statement
			private static final String DATABASE_CREATE_DOCTOR_PROFILE = "create table "
					+ I_CARE_DOCTOR_PROFILE + "( " + COL_ICARE_DOCTOR_PROFILE_ID
					+ " integer primary key autoincrement, " + " "
					+ COL_ICARE_DOCTOR_PROFILE_NAME + " text not null," + " "
					+ COL_ICARE_DOCTOR_PROFILE_SPECIALITY + " text not null," + " "
					+ COL_ICARE_DOCTOR_PROFILE_PHONE + " text not null," + " "
					+ COL_ICARE_DOCTOR_PROFILE_EMAIL + " text not null," + " "
					+ COL_ICARE_DOCTOR_PROFILE_CHAMBER + " text not null);";
			
			

	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

		db.execSQL(TABLE_CRATE_PROFILE);
		db.execSQL(DATABASE_CREATE_DOCTOR_PROFILE);
		db.execSQL(CREATE_DIET_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

		Log.w(SQLiteHelper.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion
				+ ", which will destroy all old data");

		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_PROFILE);
		db.execSQL("DROP TABLE IF EXISTS " + I_CARE_DOCTOR_PROFILE);
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_DIET_TABLE);
		onCreate(db);

	}

}
