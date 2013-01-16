package com.example.blueberry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch);
		
		final Intent intent=new Intent(LoginActivity.this,MainActivity.class);
		RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.launchlayout);
		Animation animation = AnimationUtils.loadAnimation(this,R.anim.launch_exit);  
		animation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				 startActivity(intent);
			}
		});
		 myLayout.startAnimation(animation);
		
	}

	 

}
