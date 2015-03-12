package com.ftfl.icare;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.ftfl.icare.adapter.DietListAdapter;
import com.ftfl.icare.database.DietDataSource;
import com.ftfl.icare.model.DietModel;

public class DisplayAllDietChartActivity extends Activity {
	// Variable Declaration
		ListView mAllDietList = null;	
		TextView mDietIDTV = null;
		DietModel mDietModel = null;
		DietDataSource mDietDataSource = null;
		ArrayList<DietModel> mModel = null;
		DietListAdapter mAdapter = null;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_all_diet_chart);
			
			// definition - gives variable a reference
			mAllDietList =(ListView)findViewById(R.id.alldiet);
			mDietDataSource = new DietDataSource(this);
			mModel = mDietDataSource.getAllDietList();

			mAdapter = new DietListAdapter(this, mModel);
			mAllDietList.setAdapter(mAdapter);
		}
}
