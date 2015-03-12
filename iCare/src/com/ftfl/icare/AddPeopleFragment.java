package com.ftfl.icare;


import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import com.ftfl.icare.database.SQProfileDataSource;
import com.ftfl.icare.model.Profile;
import com.ftfl.icare.util.Validation;

public class AddPeopleFragment extends Fragment {
	// public AddPeopleFragment(){}

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
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

	//	profile = new Profile();
		//sqlSource = new SQProfileDataSource(getActivity());

//		profile = sqlSource.getProfile();

		View rootView = inflater.inflate(R.layout.fragment_add_people,
				container, false);
		

		
		mNameEditText = (EditText) rootView.findViewById(R.id.profileNameET);
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
		
		mDOBEditText = (EditText) rootView.findViewById(R.id.dobET);
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
		
		mHeightEditText = (EditText) rootView.findViewById(R.id.heightET);
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
		});*/
		
		mWeightEditText = (EditText) rootView.findViewById(R.id.weightET);
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
		
		mBloodGroupEditText = (EditText) rootView.findViewById(R.id.bloodGroupET);
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
		
		mSaveButton = (Button) rootView.findViewById(R.id.profile_save);

		//setData();

		mSaveButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				saveData();

			}
		});
				
		return rootView;

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

			sqlSource = new SQProfileDataSource(getActivity());
			
			boolean insert = sqlSource.insert(profile);
			if (insert == true) {
				Toast toast = Toast.makeText(getActivity(), "Data Saved.",
						Toast.LENGTH_LONG);
				toast.show();

			} else {
				Toast toast = Toast.makeText(getActivity(),
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
