package com.bk.blueberry;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.blueberry.R;

public class MainActivity extends Activity implements OnClickListener {

	ImageButton imagebtn_return;
	ImageButton imagebtn_more;
	ImageButton imagebtn_userhead_icon;
    public static Context main_context;//保存MainActivity中的Context,方便其他Activity使用
	public static View view_FirstTopBar;// 用于保存主界面起动时的顶部主BAR（放置头像和更多按钮的BAR）
	public static RelativeLayout rel_body_content;//用于保存主界面中间启动时的内容部分VIEW
	MoreActivity moreActivity;//用于保存‘更多’界面用Activity的实例化对象
	public static LayoutInflater inflater;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		main_context=this;
		inflater = LayoutInflater.from(this);
		InitView();// 启动时初始化视图和相关变量
		 
	}

	private void InitView() {
		
		// TODO Auto-generated method stub
		imagebtn_more = (ImageButton) findViewById(R.id.imagebtn_more);
		imagebtn_userhead_icon = (ImageButton) findViewById(R.id.imagebtn_userhead_icon);
		rel_body_content=(RelativeLayout)findViewById(R.id.rel_body_content);
		// 顶部右侧‘更多’按钮点击事件
		imagebtn_more.setOnClickListener(this);
		imagebtn_userhead_icon.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		RelativeLayout rel_top_bar = (RelativeLayout) findViewById(R.id.rel_top_bar);
		
		//保存主窗口中间的内容部分VIEW
		 
		switch (v.getId()) {
		case R.id.imagebtn_more://first bar中的右侧‘更多’按钮

			view_FirstTopBar = (View) findViewById(R.id.rel_title_bar);

			View layout_bar_top_more = inflater.inflate(R.layout.bar_top_more,
					null);
			LayoutParams layoutParams = new LayoutParams();
			layoutParams.height = rel_top_bar.getHeight();

			rel_top_bar.addView(layout_bar_top_more, layoutParams);
			moreActivity=new MoreActivity();
			moreActivity.InitView(rel_top_bar);
			
			break;
		

		}

	}
}
