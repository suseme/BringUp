package com.misday.bringup;

import com.markupartist.android.widget.ActionBar;
import com.misday.bringup.model.Setting;

import android.app.Activity;
import android.os.Bundle;

public class ResultActivity extends Activity {
	
	private Setting mSetting;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.setContentView(R.layout.setting);
		
		final ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        actionBar.setTitle("Result");
		
		super.onCreate(savedInstanceState);
	}
	
	

}
