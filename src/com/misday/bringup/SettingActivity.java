package com.misday.bringup;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.ClickAction;
import com.misday.bringup.model.Setting;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class SettingActivity extends Activity {
	private Setting mSetting;
	private boolean needSave = false;
	
	private DatePicker dp_birthday;
	private EditText et_name;
	private EditText et_height;
	private EditText et_weight;
	private EditText et_hc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.setting);
		
		final ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        actionBar.setTitle(this.getText(R.string.setting));
        
        final Action acceptAction = new ClickAction(accept, R.drawable.accept);
        actionBar.addAction(acceptAction);
		
		mSetting = Setting.getInstance();
		
		dp_birthday = (DatePicker)findViewById(R.id.dp_birthday);
		et_name = (EditText)findViewById(R.id.setting_name);
		et_height = (EditText)findViewById(R.id.setting_height);
		et_weight = (EditText)findViewById(R.id.setting_weight);
		et_hc = (EditText)findViewById(R.id.setting_hc);
	}
	
	

	@Override
	protected void onResume() {
		//dp.setCalendarViewShown(true);
		dp_birthday.updateDate(mSetting.mBirthData.year, mSetting.mBirthData.month, mSetting.mBirthData.day);
		et_name.setText(mSetting.mBirthData.name);
		et_height.setText(Float.toString(mSetting.mBirthData.height));
		et_weight.setText(Float.toString(mSetting.mBirthData.weight));
		et_hc.setText(Float.toString(mSetting.mBirthData.hc));
		
		super.onResume();
	}
	
/*
	@Override
	public void onBackPressed() {
		mSetting.mBirthData.name = et_name.getText().toString();
		
		mSetting.mBirthData.year = dp_birthday.getYear();
		mSetting.mBirthData.month = dp_birthday.getMonth();
		mSetting.mBirthData.date = dp_birthday.getDayOfMonth();
		
		mSetting.mBirthData.height = Float.parseFloat(et_height.getText().toString());
		mSetting.mBirthData.weight = Float.parseFloat(et_weight.getText().toString());
		mSetting.mBirthData.hc = Float.parseFloat(et_hc.getText().toString());

		mSetting.writeSharePreference();
		
		super.onBackPressed();
	}
	*/
	
	View.OnClickListener accept = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			mSetting.mBirthData.name = et_name.getText().toString();
			
			mSetting.mBirthData.year  = dp_birthday.getYear();
			mSetting.mBirthData.month = dp_birthday.getMonth();
			mSetting.mBirthData.day  = dp_birthday.getDayOfMonth();
			
			mSetting.mBirthData.height = Float.parseFloat(et_height.getText().toString());
			mSetting.mBirthData.weight = Float.parseFloat(et_weight.getText().toString());
			mSetting.mBirthData.hc     = Float.parseFloat(et_hc.getText().toString());

			mSetting.writeSharePreference();
			
			SettingActivity.this.finish();
		}
	};
	
}
