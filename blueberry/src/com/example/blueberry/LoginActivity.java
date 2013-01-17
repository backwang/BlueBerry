package com.example.blueberry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch);
		 
		new CountDownTimer(3000, 1000) {  
		    
		    public void onFinish() {  
		    	Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);

				overridePendingTransition(R.anim.main_start, R.anim.launch_exit);
		    }

			@Override
			public void onTick(long millisUntilFinished) {
				// TODO Auto-generated method stub
				
			}

			 
		 }.start();  
	}

	 

}
