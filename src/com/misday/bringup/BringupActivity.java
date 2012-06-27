package com.misday.bringup;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;
import com.misday.bringup.model.Cald;
import com.misday.bringup.model.Setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BringupActivity extends Activity implements View.OnClickListener {
	
	private Setting mSetting;
	private TextView tv_name;
	private TextView tv_days;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        actionBar.setTitle(this.getString(R.string.app_name));
        
        final Action recordAction = new IntentAction(this, new Intent(this, RecordActivity.class), R.drawable.record);
        actionBar.addAction(recordAction);
        final Action settingAction = new IntentAction(this, new Intent(this, SettingActivity.class), R.drawable.settings);
        actionBar.addAction(settingAction);
        

        
        //this.findViewById(R.id.btn_memorize).setOnClickListener(this);
        //this.findViewById(R.id.btn_result).setOnClickListener(this);
        //this.findViewById(R.id.btn_setting).setOnClickListener(this);
        tv_name = (TextView)this.findViewById(R.id.tv_name);
        tv_days = (TextView)this.findViewById(R.id.tv_days);
        
        mSetting = Setting.getInstance();
        mSetting.setContext(this);
        
        
    }

	@Override
	protected void onStart() {
		mSetting.readSharePreference();
		
		super.onStart();
	}
	
	

	@Override
	protected void onResume() {
		if (!mSetting.setted()) {
			Intent intent = new Intent(this, SettingActivity.class);
			
			BringupActivity.this.startActivity(intent);
		} else {
			tv_name.setText(mSetting.mBirthData.name);
			
			Cald birthDay = new Cald(mSetting.mBirthData.year, mSetting.mBirthData.month, mSetting.mBirthData.day);
			Cald.MiDate date = birthDay.fromTodayH();
			int days = birthDay.fromToday();
			String strDays = String.format(this.getString(R.string.days_format), date.year, date.month, date.day, days);
			tv_days.setText(strDays);
			
			tv_name.setVisibility(View.VISIBLE);
			tv_days.setVisibility(View.VISIBLE);
		}
		
		super.onResume();
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		
		// TODO Auto-generated method stub
		switch (v.getId()) {
		//case R.id.btn_memorize:
		//	break;
			
		//case R.id.btn_result:
		//	intent = new Intent(this, ResultActivity.class);
			
		//	BringupActivity.this.startActivity(intent);
		//	break;
			
		//case R.id.btn_setting:
		//	intent = new Intent(this, SettingActivity.class);
			
		//	BringupActivity.this.startActivity(intent);
		//	break;
		}
		
	}
    
    
}