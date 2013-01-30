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

import com.bk.comm.ui.Frame_element;
import com.example.blueberry.R;

public class MainActivity extends Activity implements OnClickListener {

	ImageButton imagebtn_return;
	ImageButton imagebtn_more;
	ImageButton imagebtn_userhead_icon;
    public static Context main_context;//����MainActivity�е�Context,��������Activityʹ��
	 
	 
	public static Frame_element frame_element;//���ȫ���û�UIԪ�ص�ʵ����
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
		
		frame_element=new Frame_element();//��ʼ��������Ԫ�ص���
		
		frame_element.setRel_body_content((RelativeLayout)findViewById(R.id.rel_body_content));//�����м����ݿ��
		frame_element.setRel_top_bar((RelativeLayout)findViewById(R.id.rel_top_bar));//���涥��BAR���
		
		
		// �����Ҳ࡮���࡯��ť����¼�
		imagebtn_more = (ImageButton) findViewById(R.id.imagebtn_more);
		imagebtn_userhead_icon = (ImageButton) findViewById(R.id.imagebtn_userhead_icon);
		imagebtn_more.setOnClickListener(this);
		imagebtn_userhead_icon.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 
		
		//�����������м�����ݲ���VIEW
		 
		switch (v.getId()) {
		case R.id.imagebtn_more://first bar�е��Ҳ࡮���࡯��ť

			 

			View layout_bar_top_more = inflater.inflate(R.layout.bar_top_more,null);
			LayoutParams layoutParams = new LayoutParams();
			layoutParams.height = frame_element.getRel_top_bar().getHeight();

			frame_element.getRel_top_bar().addView(layout_bar_top_more, layoutParams);
			moreActivity=new MoreActivity();
			moreActivity.InitView();
			
			break;
		

		}

	}
}
