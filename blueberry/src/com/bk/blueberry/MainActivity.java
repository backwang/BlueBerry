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
    public static Context main_context;//����MainActivity�е�Context,��������Activityʹ��
	public static View view_FirstTopBar;// ���ڱ�����������ʱ�Ķ�����BAR������ͷ��͸��ఴť��BAR��
	public static RelativeLayout rel_body_content;//���ڱ����������м�����ʱ�����ݲ���VIEW
	MoreActivity moreActivity;//���ڱ��桮���࡯������Activity��ʵ��������
	public static LayoutInflater inflater;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		main_context=this;
		inflater = LayoutInflater.from(this);
		InitView();// ����ʱ��ʼ����ͼ����ر���
		 
	}

	private void InitView() {
		
		// TODO Auto-generated method stub
		imagebtn_more = (ImageButton) findViewById(R.id.imagebtn_more);
		imagebtn_userhead_icon = (ImageButton) findViewById(R.id.imagebtn_userhead_icon);
		rel_body_content=(RelativeLayout)findViewById(R.id.rel_body_content);
		// �����Ҳ࡮���࡯��ť����¼�
		imagebtn_more.setOnClickListener(this);
		imagebtn_userhead_icon.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		RelativeLayout rel_top_bar = (RelativeLayout) findViewById(R.id.rel_top_bar);
		
		//�����������м�����ݲ���VIEW
		 
		switch (v.getId()) {
		case R.id.imagebtn_more://first bar�е��Ҳ࡮���࡯��ť

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
