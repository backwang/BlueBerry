package com.bk.blueberry;

import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.blueberry.R;

public class MoreActivity extends MainActivity implements OnClickListener {

	Button btn_login;

	ImageButton btn_return;
	LoginActivity loginActivity;

	public void InitView() {
		// TODO Auto-generated method stub

		RelativeLayout relativeLayout = MainActivity.frame_element
				.getRel_top_bar();
		btn_login = (Button) (relativeLayout.findViewById(R.id.btn_login));
		btn_login.setOnClickListener(this);

		btn_return = (ImageButton) (MainActivity.frame_element.getRel_top_bar()
				.findViewById(R.id.btn_return));
		btn_return.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		LayoutParams layoutParams = new LayoutParams();
		switch (v.getId()) {
		case R.id.btn_login:

			View layout_activity_login = MainActivity.inflater.inflate(
					R.layout.activity_login, null);

			layoutParams.gravity = Gravity.CENTER;
			MainActivity.frame_element.getRel_body_content().addView(
					layout_activity_login, layoutParams);

			LoginActivity loginActivity = new LoginActivity();
			loginActivity.InitView();
			break;
		case R.id.btn_return:

			MainActivity.frame_element.getRel_top_bar().removeView(
					(View) MainActivity.frame_element.getLayout_bar_top_more());
			break;
		default:
			break;
		}
	}

}
