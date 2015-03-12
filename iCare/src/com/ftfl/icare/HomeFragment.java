package com.ftfl.icare;




import java.util.List;

import com.ftfl.icare.database.SQProfileDataSource;
import com.ftfl.icare.model.Profile;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HomeFragment extends Fragment {
	
	//public HomeFragment(){}
	SQProfileDataSource sqlSource ;
	Profile profile ;
	
	Button mDoctorButton;
	Button mVaccinationButton;
	Button mDietButton;
	Button mPrescriptionButton;
	List<Profile> mProfileList = null;
	int mid = 1;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		profile = new Profile();
		sqlSource = new SQProfileDataSource(getActivity());
		
		
		profile = sqlSource.getProfile(mid);
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        
        TextView nameTv = (TextView) rootView.findViewById(R.id.profileNameVw);
        TextView dateOfBirthTv = (TextView) rootView.findViewById(R.id.dobVw);
		TextView heightTv = (TextView) rootView.findViewById(R.id.heightVw);
		TextView weightTv = (TextView) rootView.findViewById(R.id.weightVw);
		TextView bloodGroupTv = (TextView) rootView.findViewById(R.id.bloodGroupVw);
		
		
		 nameTv.setText(profile.getmName().toString());
		 dateOfBirthTv.setText(profile.getmDateOfBirth().toString());
		 heightTv.setText(profile.getmHeight().toString());
		 weightTv.setText(profile.getmWeight().toString());	 
		 bloodGroupTv.setText(profile.getmBloodGroup().toString());
		 
		 mDoctorButton=(Button) rootView.findViewById(R.id.go_doctor); 
		 mDoctorButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg1) {
					
					
					Intent in=new Intent(getActivity(), CreateDoctorActivity.class);
					startActivity(in);
						}
						});
		 
		 mDietButton=(Button) rootView.findViewById(R.id.go_diet); 
		 mDietButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg1) {
					
					
					Intent in=new Intent(getActivity(), DietChartCreationActivity.class);
					startActivity(in);
						}
						});
         
        return rootView;
    }
}
