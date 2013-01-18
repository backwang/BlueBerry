package com.example.blueberry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener {

	ImageButton imagebtn_return;
	ImageButton imagebtn_more;
	ImageButton imagebtn_userhead_icon;
	 
	View view_FirstTopBar;//用于保存主界面起动时的顶部主BAR（放置头像和更多按钮的BAR）

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		InitView();// 启动时初始化视图和相关变量
	}

	private void InitView() {
		// TODO Auto-generated method stub
		imagebtn_more = (ImageButton) findViewById(R.id.imagebtn_more);
		imagebtn_userhead_icon = (ImageButton) findViewById(R.id.imagebtn_userhead_icon);
		
		// 顶部右侧‘更多’按钮点击事件
		imagebtn_more.setOnClickListener(this);
		imagebtn_userhead_icon.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		RelativeLayout loadtwoLayout = (RelativeLayout) findViewById(R.id.rel_top_bar);
		LayoutInflater inflater = LayoutInflater.from(this);
		switch (v.getId()) {
		case R.id.imagebtn_more:
			
			 
			view_FirstTopBar = (View)findViewById(R.id.rel_title_bar);
			
			View layout_bar_top_more = inflater.inflate(R.layout.bar_top_more,
					null);
			LayoutParams layoutParams = new LayoutParams();
			layoutParams.height = loadtwoLayout.getHeight();
			 
			loadtwoLayout.addView(layout_bar_top_more, layoutParams);
			imagebtn_return = (ImageButton) findViewById(R.id.btn_return);
			imagebtn_return.setOnClickListener(this);
			break;
		case R.id.btn_return:
			loadtwoLayout.removeAllViews();
			loadtwoLayout.addView(view_FirstTopBar);
			 
			break;

		}

	}
}
