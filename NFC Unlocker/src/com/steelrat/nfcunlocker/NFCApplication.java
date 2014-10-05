package com.steelrat.nfcunlocker;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;


public class NFCApplication extends Application {
	static Context mContext;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		mContext = this;
    }
	
	public static Context getContext() {
		return mContext;
	}
	
	public static String getVersion() {	
		String version = "";
		
		try {
			PackageInfo pInfo;
			pInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
			version = pInfo.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		
		return version;
	}
}
