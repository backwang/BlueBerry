package com.bk.blueberry;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.bk.comm.ui.Frame_element;
import com.example.blueberry.R;

public class MainActivity extends Activity implements OnClickListener {

	ImageButton imagebtn_return;
	ImageButton imagebtn_more;
	ImageButton imagebtn_userhead_icon;
	public static Context main_context;// 保存MainActivity中的Context,方便其他Activity使用

	public static Frame_element frame_element;// 存放全局用户UI元素的实例类
	MoreActivity moreActivity;// 用于保存‘更多’界面用Activity的实例化对象
	public static LayoutInflater inflater;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		main_context = this;
		inflater = LayoutInflater.from(this);
		InitView();// 启动时初始化视图和相关变量

	}

	private void InitView() {

		// TODO Auto-generated method stub

		frame_element = new Frame_element();// 初始化保存框架元素的类

		frame_element
				.setRel_body_content((RelativeLayout) findViewById(R.id.rel_body_content));// 保存中间内容框架
		frame_element
				.setRel_top_bar((RelativeLayout) findViewById(R.id.rel_top_bar));// 保存顶部BAR框架

		frame_element
				.setRel_frist_bar((RelativeLayout) findViewById(R.id.rel_frist_bar));// 保存顶部首页BAR
		// 顶部右侧‘更多’按钮点击事件
		imagebtn_more = (ImageButton) findViewById(R.id.imagebtn_more);
		imagebtn_userhead_icon = (ImageButton) findViewById(R.id.imagebtn_userhead_icon);
		imagebtn_more.setOnClickListener(this);
		imagebtn_userhead_icon.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		// 保存主窗口中间的内容部分VIEW

		switch (v.getId()) {
		case R.id.imagebtn_more:// first bar中的右侧‘更多’按钮

			frame_element.setLayout_bar_top_more(inflater.inflate(
					R.layout.bar_top_more, null));

			LayoutParams layoutParams = new LayoutParams();
			layoutParams.height = frame_element.getRel_top_bar().getHeight();

			frame_element.getRel_top_bar().addView(
					frame_element.getLayout_bar_top_more(), layoutParams);
			moreActivity = new MoreActivity();
			moreActivity.InitView();

			break;

		case R.id.imagebtn_userhead_icon:// frist bar中左侧的头像按钮

			View layout_userinfo = inflater.inflate(R.layout.activity_userinfo,
					null);

			PopupWindow pop_userinfo = new PopupWindow(layout_userinfo,
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			pop_userinfo.setFocusable(true);

			pop_userinfo.setBackgroundDrawable(new BitmapDrawable());// 这句让用户按BACK键可以关闭弹出窗
			pop_userinfo.setAnimationStyle(R.style.popupanimation);
			pop_userinfo.showAtLocation(frame_element.getRel_body_content(),
					Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置在屏幕中的显示位置

			pop_userinfo.update();

			break;
		}

	}
}
