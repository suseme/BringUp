package com.misday.bringup;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.AbstractAction;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.ClickAction;
import com.misday.bringup.model.Cald;
import com.misday.bringup.model.Setting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RecordActivity extends Activity {
	private Setting mSetting;
	private ActionBar mActionBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.setContentView(R.layout.record);
		
		mSetting = Setting.getInstance();
		
		mActionBar = (ActionBar) findViewById(R.id.actionbar);
        //mActionBar.setTitle(this.getString(R.string.record));
        
        final Action acceptAction = new ClickAction(accept, R.drawable.accept);
        mActionBar.addAction(acceptAction);
		
		super.onCreate(savedInstanceState);
	}

	View.OnClickListener accept = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			//TODO: record data.
			
			RecordActivity.this.finish();
		}
	};

	@Override
	protected void onResume() {
		Cald birthday = new Cald(mSetting.mBirthData.year, mSetting.mBirthData.month, mSetting.mBirthData.day);
		String days = String.format(this.getString(R.string.title_days_format), birthday.fromToday());
		
		mActionBar.setTitle(this.getString(R.string.record) + days);
		
		super.onResume();
	}
	
	
}
