package com.t3hh4xx0r.setup;

import com.t3hh4xx0r.setup.utils.Constants;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainMenu extends Activity {
		private Button mUninstallButton;
		private Button mAppsButton;
		
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);

		if (Constants.FIRST_LAUNCH) {
			isSupported();
			Constants.FIRST_LAUNCH = false;
		}
		
		setContentView(R.layout.main);
		mUninstallButton = (Button) findViewById(R.id.uninstall_button);
		mAppsButton = (Button) findViewById(R.id.apps_button);

		if(!Constants.SUPPORTED) {
			mUninstallButton.setEnabled(false);
		}
		
		mUninstallButton.setOnClickListener(mUninstallListener);
		mAppsButton.setOnClickListener(mAppsListener);
	}

	private OnClickListener mAppsListener = new OnClickListener() {
		public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setClassName("com.t3hh4xx0r.setup","com.t3hh4xx0r.setup.AppsMenu");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
			}
	};
	
	private OnClickListener mUninstallListener = new OnClickListener() {
		public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setClassName("com.t3hh4xx0r.setup","com.t3hh4xx0r.setup.UninstallMenu");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
			}
	};
	
	public void isSupported() {
		if(!Build.USER.equals("r2doesinc")) {
			Constants.SUPPORTED = false;
		}
		
	}
}
