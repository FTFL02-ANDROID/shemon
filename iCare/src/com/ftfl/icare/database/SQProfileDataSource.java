package com.ftfl.icare.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ftfl.icare.model.Profile;

public class SQProfileDataSource {

	// Database fields
	private SQLiteDatabase profileDataBase;
	SQLiteHelper profileDBhelper;
	Cursor mCursor;

	List<Profile> profileList = new ArrayList<Profile>();

	public SQProfileDataSource(Context context) {
		profileDBhelper = new SQLiteHelper(context);

	}

	// open a method for writable database
	public void open() throws SQLException {
		profileDataBase = profileDBhelper.getWritableDatabase();
	}

	// close database connection
	public void close() {
		profileDBhelper.close();
	}

	// insert data into the database.

	public boolean insert(Profile eProfile) {

		this.open();

		ContentValues values = new ContentValues();

		values.put(SQLiteHelper.COLUMNL_PROFILE_NAME_FIELD, eProfile.getmName());
		values.put(SQLiteHelper.COLUMNL_DATE_OF_BIRTH_FIELD,
				eProfile.getmDateOfBirth());
		values.put(SQLiteHelper.COLUMNL_HEIGHT_FIELD, eProfile.getmHeight());
		values.put(SQLiteHelper.COLUMNL_WEIGHT_FIELD, eProfile.getmWeight());
		values.put(SQLiteHelper.COLUMNL_BLOOD_GROUP_FIELD,
				eProfile.getmBloodGroup());

                 		long check = profileDataBase.insert(SQLiteHelper.TABLE_NAME_PROFILE,
				null, values);
		profileDataBase.close();
		this.close();

		if (check < 0)
			return false;
		else
			return true;
	}


	// update database by Id
	public boolean updateData(Profile eProfile) {
		this.open();
		ContentValues values = new ContentValues();

		values.put(SQLiteHelper.COLUMNL_PROFILE_NAME_FIELD, eProfile.getmName());
		values.put(SQLiteHelper.COLUMNL_DATE_OF_BIRTH_FIELD,
				eProfile.getmDateOfBirth());
		values.put(SQLiteHelper.COLUMNL_HEIGHT_FIELD, eProfile.getmHeight());
		values.put(SQLiteHelper.COLUMNL_WEIGHT_FIELD, eProfile.getmWeight());
		values.put(SQLiteHelper.COLUMNL_BLOOD_GROUP_FIELD,
				eProfile.getmBloodGroup());

		int check = profileDataBase.update(SQLiteHelper.TABLE_NAME_PROFILE,
				values, null, null);

		profileDataBase.close();
		if (check == 0)
			return false;
		else
			return true;
	}

	// delete data form database.
	/*public Integer deleteData(Integer id) {
		this.open();
		return profileDataBase.delete(SQLiteHelper.TABLE_NAME_PROFILE,
				SQLiteHelper.COLUMNL_PROFILE_ID_FIELD + " = ? ",
				new String[] { Integer.toString(id) });

	}*/

	/*
	 * using cursor for display data from database.
	 */
	public List<Profile> getProfileList() {
		this.open();

		mCursor = profileDataBase.query(
				SQLiteHelper.TABLE_NAME_PROFILE, new String[] {
						SQLiteHelper.COLUMNL_PROFILE_ID_FIELD,
						SQLiteHelper.COLUMNL_PROFILE_NAME_FIELD,
						SQLiteHelper.COLUMNL_DATE_OF_BIRTH_FIELD,
						SQLiteHelper.COLUMNL_HEIGHT_FIELD,
						SQLiteHelper.COLUMNL_WEIGHT_FIELD,
						SQLiteHelper.COLUMNL_DATE_OF_BIRTH_FIELD},
						null, null, null, null, null);

		if (mCursor != null) {
			if (mCursor.moveToFirst()) {

				do {

					int userId = mCursor.getInt(mCursor.getColumnIndex(SQLiteHelper.COLUMNL_PROFILE_ID_FIELD));
					String userName = mCursor.getString(mCursor.getColumnIndex(SQLiteHelper.COLUMNL_PROFILE_NAME_FIELD));
					
					String dateOfBirth = mCursor.getString(mCursor.getColumnIndex(SQLiteHelper.COLUMNL_BLOOD_GROUP_FIELD));
					
					String height = mCursor.getString(mCursor.getColumnIndex(SQLiteHelper.COLUMNL_HEIGHT_FIELD));
					
					String weight = mCursor.getString(mCursor.getColumnIndex(SQLiteHelper.COLUMNL_WEIGHT_FIELD));
					
					String bloodGroup = mCursor.getString(mCursor.getColumnIndex(SQLiteHelper.COLUMNL_BLOOD_GROUP_FIELD));
					

					profileList.add(new Profile(userId, userName,dateOfBirth, height, weight, bloodGroup));

				} while (mCursor.moveToNext());
			}
			mCursor.close();
		}
		this.close();
		return profileList;
	}
	
	
	

	/*
	 * Provide data According to the profile id
	 */
	public Profile getProfile(int mID) {
		
		this.open();
		Profile tempProfile = null;
		String query = "SELECT * FROM "+SQLiteHelper.TABLE_NAME_PROFILE+" WHERE "
		+SQLiteHelper.COLUMNL_PROFILE_ID_FIELD+" ="+ "1";
		Cursor mCursor = profileDataBase.rawQuery(query, null);
		
		

//		mCursor = profileDataBase.query(SQLiteHelper.TABLE_NAME_PROFILE,
//				new String[] { SQLiteHelper.COLUMNL_PROFILE_ID_FIELD,
//						SQLiteHelper.COLUMNL_PROFILE_NAME_FIELD,
//						SQLiteHelper.COLUMNL_DATE_OF_BIRTH_FIELD,
//						SQLiteHelper.COLUMNL_HEIGHT_FIELD,
//						SQLiteHelper.COLUMNL_WEIGHT_FIELD,
//						SQLiteHelper.COLUMNL_BLOOD_GROUP_FIELD } , "where"
//						+SQLiteHelper.COLUMNL_PROFILE_ID_FIELD+" ="+mID, null,
//				null, null, null);

//		if (mCursor != null) {
//			if (mCursor.moveToFirst()) {
//
//				do {
//		 
//		 if (mCursor.moveToFirst()){
//				
//				do {
//
//					int mId = mCursor
//							.getInt(mCursor
//									.getColumnIndex(SQLiteHelper.COLUMNL_PROFILE_ID_FIELD));
//					String mName = mCursor
//							.getString(mCursor
//									.getColumnIndex(SQLiteHelper.COLUMNL_DATE_OF_BIRTH_FIELD));
//					String mDateOfBirth = mCursor
//							.getString(mCursor
//									.getColumnIndex(SQLiteHelper.COLUMNL_DATE_OF_BIRTH_FIELD));
//					String mHeight = mCursor.getString(mCursor
//							.getColumnIndex(SQLiteHelper.COLUMNL_HEIGHT_FIELD));
//					String mWeight = mCursor.getString(mCursor
//							.getColumnIndex(SQLiteHelper.COLUMNL_WEIGHT_FIELD));
//					String mBloodGroup = mCursor
//							.getString(mCursor
//									.getColumnIndex(SQLiteHelper.COLUMNL_BLOOD_GROUP_FIELD));
//
//					tempProfile = new Profile( mName, mDateOfBirth,
//							mHeight, mWeight, mBloodGroup);
//
//				} while (mCursor.moveToNext());
//			
//			mCursor.close();
//		}
//		this.close();
//		return tempProfile;
//	}

		 if (mCursor.moveToFirst()){
				
				do {

					int appointmentID = mCursor.getInt(mCursor.getColumnIndex(SQLiteHelper.COLUMNL_PROFILE_ID_FIELD));
					String mName = mCursor
							.getString(mCursor
									.getColumnIndex(SQLiteHelper.COLUMNL_PROFILE_NAME_FIELD));
					String mDateOfBirth = mCursor
							.getString(mCursor
									.getColumnIndex(SQLiteHelper.COLUMNL_DATE_OF_BIRTH_FIELD));
					String mHeight = mCursor.getString(mCursor
							.getColumnIndex(SQLiteHelper.COLUMNL_HEIGHT_FIELD));
					String mWeight = mCursor.getString(mCursor
							.getColumnIndex(SQLiteHelper.COLUMNL_WEIGHT_FIELD));
					String mBloodGroup = mCursor
							.getString(mCursor
									.getColumnIndex(SQLiteHelper.COLUMNL_BLOOD_GROUP_FIELD));
					tempProfile = new Profile( appointmentID, mName, mDateOfBirth,
							mHeight, mWeight, mBloodGroup);
				} while (mCursor.moveToNext());
		}
		this.close();
		return tempProfile;
	}
	/*
	 * Check is the database empty or not
	 */

	public boolean isEmpty() {
		this.open();
		Cursor mCursor = profileDataBase.query(SQLiteHelper.TABLE_NAME_PROFILE,
				new String[] { SQLiteHelper.COLUMNL_PROFILE_ID_FIELD,
						SQLiteHelper.COLUMNL_PROFILE_NAME_FIELD,
						SQLiteHelper.COLUMNL_DATE_OF_BIRTH_FIELD,
						SQLiteHelper.COLUMNL_HEIGHT_FIELD,
						SQLiteHelper.COLUMNL_WEIGHT_FIELD,
						SQLiteHelper.COLUMNL_BLOOD_GROUP_FIELD }, null, null,
				null, null, null);
		if (mCursor.getCount() == 0) {
			this.close();
			return true;
		}

		else {
			this.close();
			return false;
		}
	}
}
