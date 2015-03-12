package com.ftfl.icare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ftfl.icare.database.SQProfileDataSource;
import com.ftfl.icare.model.Profile;
import com.ftfl.icare.util.Validation;

public class AddProfileActivity extends Activity{
	EditText mNameEditText;
	EditText mDOBEditText;
	EditText mHeightEditText;
	EditText mWeightEditText;
	EditText mBloodGroupEditText;

	String mName;
	String mDOB;
	String mHeight;
	String mWeight;
	String mBloodGroup;

	SQProfileDataSource sqlSource = null;
	Profile profile = null;

	Button mSaveButton = null;
	
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_add_people);
	//	profile = new Profile();
		//sqlSource = new SQProfileDataSource(getActivity());

//		profile = sqlSource.getProfile();
		

		
		mNameEditText = (EditText) findViewById(R.id.profileNameET);
		/*mNameEditText.addTextChangedListener(new TextWatcher() {

			public void afterTextChanged(Editable s) {

				Validation.hasText(mNameEditText);
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});*/
		
		mDOBEditText = (EditText) findViewById(R.id.dobET);
		/*mDOBEditText.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				Validation.hasText(mDOBEditText);
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});*/
		
		mHeightEditText = (EditText) findViewById(R.id.heightET);
		/*mHeightEditText.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				Validation.hasText(mHeightEditText);
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});
		*/
		mWeightEditText = (EditText) findViewById(R.id.weightET);
		/*mWeightEditText.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				Validation.hasText(mWeightEditText);
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});*/
		
		mBloodGroupEditText = (EditText) findViewById(R.id.bloodGroupET);
		/*mBloodGroupEditText.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable s) {
				Validation.hasText(mBloodGroupEditText);
			}

			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
			}

			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
			}
		});*/
		
		mSaveButton = (Button) findViewById(R.id.profile_save);

		//setData();

		mSaveButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				saveData();
				
				Intent i = new Intent(AddProfileActivity.this,
						MainActivity.class);
				startActivity(i);

			}
		});
				
	

	}
	
	/*public void setData() {

		mNameEditText.setText(profile.getmName().toString());
		mDOBEditText.setText(profile.getmDateOfBirth().toString());
		mHeightEditText.setText(profile.getmHeight().toString());
		mWeightEditText.setText(profile.getmWeight().toString());
		mBloodGroupEditText.setText(profile.getmBloodGroup().toString());

	}*/

	public void saveData() {
		if (checkValidation()) {
			// getting values from input fields.....
			mName = mNameEditText.getText().toString();
			mDOB = mDOBEditText.getText().toString();
			mHeight = mHeightEditText.getText().toString();
			mWeight = mWeightEditText.getText().toString();
			mBloodGroup = mBloodGroupEditText.getText().toString();
			// ................................................

			profile = new Profile(mName, mDOB, mHeight,
					mWeight, mBloodGroup);

			sqlSource = new SQProfileDataSource(this);
			
			boolean insert = sqlSource.insert(profile);
			if (insert == true) {
				Toast toast = Toast.makeText(this, "Data Saved.",
						Toast.LENGTH_LONG);
				toast.show();

			} else {
				Toast toast = Toast.makeText(this,
						"Unable to save, Please insert above information.",
						Toast.LENGTH_LONG);
				toast.show();

			}
		}

	}
	
	private boolean checkValidation() {
		boolean isValid = true;

		if (!Validation.hasText(mNameEditText))
			isValid = false;
		if (!Validation.hasText(mDOBEditText))
			isValid = false;
		if (!Validation.hasText(mHeightEditText))
			isValid = false;
		if (!Validation.hasText(mWeightEditText))
			isValid = false;
		if (!Validation.hasText(mBloodGroupEditText))
			isValid = false;

		return isValid;
	}

	
}
