package com.bk.blueberry;

import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.blueberry.R;

public class MoreActivity extends MainActivity implements OnClickListener {

	Button btn_login;
	RelativeLayout rel_top_bar;
    ImageButton btn_return;
	 
	public void InitView(RelativeLayout rel_top_bar) {
		// TODO Auto-generated method stub
		 
		 
		btn_login = (Button) (rel_top_bar.findViewById(R.id.btn_login));
		btn_login.setOnClickListener(this);
		 
		btn_return = (ImageButton) (rel_top_bar.findViewById(R.id.btn_return));
		btn_return.setOnClickListener(this);
		this.rel_top_bar = rel_top_bar;
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_login:
			 
			View layout_activity_login = MainActivity.inflater.inflate(R.layout.activity_login,null);
			LayoutParams layoutParams=new LayoutParams();
			layoutParams.gravity=Gravity.CENTER;
			rel_body_content.addView(layout_activity_login,layoutParams);
			break;
		case R.id.btn_return:
			View layout_activity_main = MainActivity.inflater.inflate(R.layout.activity_main,null);
			rel_body_content.addView(layout_activity_main);
			break;
		default:
			break;
		}
	}

	 
}
