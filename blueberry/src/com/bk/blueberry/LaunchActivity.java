package com.bk.blueberry;

import com.example.blueberry.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class LaunchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch);
		 
		new CountDownTimer(1000, 1000) {  
		    
		    @SuppressLint("NewApi")//可以修正下面overridePendingTransition的报错
			public void onFinish() {  
		    	Intent intent = new Intent(LaunchActivity.this, MainActivity.class);
				startActivity(intent);

				overridePendingTransition(R.anim.main_start, R.anim.launch_exit);
				finish();
		    }

			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				
			}

			 
		 }.start();  
	}

	 

}
