package com.ftfl.icare;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.ftfl.icare.database.SQProfileDataSource;

public class SplashActivity extends Activity {
	SQProfileDataSource sqlSource;
	
	
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.activity_splash);
		
		//requestWindowFeature(Window.FEATURE_NO_TITLE);
		//getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//Remove title bar
	   // this.requestWindowFeature(Window.FEATURE_NO_TITLE);

	    //Remove notification bar
	   // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		
		sqlSource = new SQProfileDataSource(this);
		
		
		Thread mSplash = new Thread() {
			public void run() {
				try {
					// Thread will sleep for 3 seconds
					sleep(2 * 1000);
				if (sqlSource.isEmpty()) {
					Intent i = new Intent(SplashActivity.this,
							AddProfileActivity.class);
					startActivity(i);
				} 
				else {
					Intent i = new Intent(SplashActivity.this,
							MainActivity.class);
					startActivity(i);
				}
				
				// Remove activity
				finish();
			} catch (Exception e) {
			}
		}
	};
	// start thread
	mSplash.start();

}
			
}
