package com.misday.bringup.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Setting {
	private static final String TAG = "Setting";
	
	private static final String SETTING = "setting";
	
	//private static Setting sInstance = null;
	private Context mContext;
	public BirthData mBirthData;
	public boolean mSetted = false;
	
	Setting() {
		mBirthData = new BirthData();
	}
	
	private static class SettingHolder {
		public static final Setting INSTANCE = new Setting();
	}
	
	public static Setting getInstance() {
		/*
		if (sInstance == null) {
			sInstance = SettingHolder.INSTANCE;
		}
		
		return sInstance;
		*/
		return SettingHolder.INSTANCE;
	}
	
	public void setContext(Context context) {
		mContext = context;
	}
	
	public void readSharePreference() {
		if (mContext != null) {
			SharedPreferences setting = mContext.getSharedPreferences(this.SETTING, Context.MODE_PRIVATE);
			
			mBirthData.name 	= setting.getString(BirthData.NAME, BirthData.DFT_NAME);
			mBirthData.year 	= setting.getInt(BirthData.YEAR, BirthData.DFT_YEAR);
			mBirthData.month 	= setting.getInt(BirthData.MONTH, BirthData.DFT_MONTH);
			mBirthData.day 	= setting.getInt(BirthData.DAY, BirthData.DFT_DAY);
			mBirthData.height 	= setting.getFloat(BirthData.HEIGHT, BirthData.DFT_HEIGHT);
			mBirthData.weight 	= setting.getFloat(BirthData.WEIGHT, BirthData.DFT_WEIGHT);
			mBirthData.hc 		= setting.getFloat(BirthData.HC, BirthData.DFT_HC);
			mSetted				= setting.getBoolean("SETTED", false);
			
			Log.i(TAG, "name = " + mBirthData.name);
			Log.i(TAG, "year = " + mBirthData.year);
			Log.i(TAG, "month = " + mBirthData.month);
			Log.i(TAG, "date = " + mBirthData.day);
			Log.i(TAG, "height = " + mBirthData.height);
			Log.i(TAG, "weight = " + mBirthData.weight);
			Log.i(TAG, "hc = " + mBirthData.hc);
			Log.i(TAG, "mSetted = " + mSetted);
		} else {
			Log.e(TAG, "mContext is null");
		}
	}
	
	public void writeSharePreference() {
		if (mContext != null) {
			SharedPreferences setting = mContext.getSharedPreferences(this.SETTING, Context.MODE_PRIVATE);
			SharedPreferences.Editor settingEditor = setting.edit();
			
			settingEditor.putString(BirthData.NAME, mBirthData.name);
			settingEditor.putInt(BirthData.YEAR, mBirthData.year);
			settingEditor.putInt(BirthData.MONTH, mBirthData.month);
			settingEditor.putInt(BirthData.DAY, mBirthData.day);
			settingEditor.putFloat(BirthData.HEIGHT, mBirthData.height);
			settingEditor.putFloat(BirthData.WEIGHT, mBirthData.weight);
			settingEditor.putFloat(BirthData.HC, mBirthData.hc);
			settingEditor.putBoolean("SETTED", mSetted = true);
			
			settingEditor.commit();
		} else {
			Log.e(TAG, "mContext is null");
		}
	}
	
	public boolean setted() {
		return mSetted;
	}
	
	public class BirthData {
		public static final String NAME 	= "name";
		public static final String YEAR 	= "year";
		public static final String MONTH 	= "month";
		public static final String DAY 		= "day";
		public static final String HEIGHT 	= "height";
		public static final String WEIGHT 	= "weight";
		public static final String HC 		= "hc";
		
		public static final String DFT_NAME 	= "Little Q";
		public static final int DFT_YEAR 		= 2012;
		public static final int DFT_MONTH 		= 2;
		public static final int DFT_DAY 		= 30;
		public static final float DFT_HEIGHT 	= 50; //cm
		public static final float DFT_WEIGHT 	= 3.45f; //kg
		public static final float DFT_HC 		= 45; //cm
		
		public String name;
		public int year;
		public int month;
		public int day;
		public float height;
		public float weight;
		public float hc; //head circumference 
	}
}
