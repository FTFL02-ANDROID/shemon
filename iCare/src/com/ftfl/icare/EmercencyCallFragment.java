package com.ftfl.icare;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EmercencyCallFragment extends Fragment {
	
	//public EmercencyCallFragment(){}
	EditText phone;
	

	public static final String MyPREFERENCES = "MyPrefs";
	public static final String PHONE = "phoneKey";

	SharedPreferences sharedpreferences;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_emergency_call, container, false);
        phone = (EditText) rootView.findViewById(R.id.editTextPhone);

        Button mButton=(Button) rootView.findViewById(R.id.btnEmercenvyCallInsert);
        mButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg1) {
				
					String mPhone = phone.getText().toString();
					Editor editor = sharedpreferences.edit();

					editor.putString(PHONE, mPhone);

					editor.commit();

				}
				
				
					
					});
        
        sharedpreferences = this.getActivity().getSharedPreferences(MyPREFERENCES,
				Context.MODE_PRIVATE);

		if (sharedpreferences.contains(PHONE)) {
			Intent intent = new Intent(getActivity(), OnShake.class);
			startActivity(intent);
		}
			
        return rootView;
    }
	
	

}
