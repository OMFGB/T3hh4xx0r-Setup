package com.t3hh4xx0r.setup;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;

import com.t3hh4xx0r.setup.IconPreferenceScreenLeft;
import com.t3hh4xx0r.setup.IconPreferenceScreenRight;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.widget.Toast;


public class UninstallMenu extends PreferenceActivity {
	private IconPreferenceScreenLeft mWallpapers;
	private IconPreferenceScreenRight mGodMode;
	private IconPreferenceScreenLeft mLauncher;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.uninstall_menu);
		mGodMode = (IconPreferenceScreenRight) findPreference("godmode");		
		mWallpapers = (IconPreferenceScreenLeft) findPreference("wallpapers");
		mLauncher = (IconPreferenceScreenLeft) findPreference("launcher");
		
		File wallpapersf = new File("/system/app/Wallpapers.apk");
		if (!wallpapersf.exists()) {
			mWallpapers.setEnabled(false);
			mWallpapers.setSummary(R.string.uninstalled_uninstall);
		}
		
		File godmodef = new File("/system/app/God_Mode.apk");
		if (!godmodef.exists()) {
			mGodMode.setEnabled(false);
			mGodMode.setSummary(R.string.uninstalled_uninstall);
		}
		
		File launcherf = new File("/system/app/OMFGB-Launcher.apk");
		if (!launcherf.exists()) {
			mLauncher.setEnabled(false);
			mLauncher.setSummary(R.string.uninstalled_uninstall);
		}
	}
	
	public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
		
		if (preference == mWallpapers) {
			File wallpapersf = new File("/system/app/Wallpapers.apk");
			if (wallpapersf.exists()) {
                Toast pieceToast = Toast.makeText(getApplicationContext(), "Rebooting", Toast.LENGTH_SHORT);
                pieceToast.show();
			    Thread cmdThread = new Thread(){
				    @Override
				    public void run() {
					final Runtime run = Runtime.getRuntime();
					DataOutputStream out = null;
					Process p = null;
					try {
		                p = run.exec("su");
						out = new DataOutputStream(p.getOutputStream());
						out.writeBytes("busybox mount -o remount rw /system\n");				
						out.writeBytes("busybox rm /system/app/Wallpapers.apk\n");	
						out.writeBytes("busybox mount -o remount ro /system\n");										
                        out.writeBytes("reboot\n");
						out.flush();
					    } catch (IOException e) {
						    e.printStackTrace();
						    return;
					    }

				    }
			    };
			    cmdThread.start();
			}
			mWallpapers.setEnabled(false);
			mWallpapers.setSummary(R.string.uninstalled_uninstall);
		}
		if (preference == mGodMode) {
			File godmodef = new File("/system/app/God_Mode.apk");
			if (godmodef.exists()) {
                Toast pieceToast = Toast.makeText(getApplicationContext(), "Rebooting", Toast.LENGTH_SHORT);
                pieceToast.show();
			    Thread cmdThread = new Thread(){
				    @Override
				    public void run() {
					final Runtime run = Runtime.getRuntime();
					DataOutputStream out = null;
					Process p = null;
					try {
		                p = run.exec("su");
						out = new DataOutputStream(p.getOutputStream());
						out.writeBytes("busybox mount -o remount rw /system\n");				
						out.writeBytes("busybox rm /system/app/God_Mode.apk\n");	
						out.writeBytes("busybox mount -o remount ro /system\n");										
                        out.writeBytes("reboot\n");
						out.flush();
					    } catch (IOException e) {
						    e.printStackTrace();
						    return;
					    }

				    }
			    };
			    cmdThread.start();
			}
			mGodMode.setEnabled(false);
			mGodMode.setSummary(R.string.uninstalled_uninstall);
		}
		if (preference == mLauncher) {
			File launcherf = new File("/system/app/OMFGB-Launcher.apk");
			if (launcherf.exists()) {
                Toast pieceToast = Toast.makeText(getApplicationContext(), "Rebooting", Toast.LENGTH_SHORT);
                pieceToast.show();
			    Thread cmdThread = new Thread(){
				    @Override
				    public void run() {
					final Runtime run = Runtime.getRuntime();
					DataOutputStream out = null;
					Process p = null;
					try {
		                p = run.exec("su");
						out = new DataOutputStream(p.getOutputStream());
						out.writeBytes("busybox mount -o remount rw /system\n");				
						out.writeBytes("busybox rm /system/app/OMFGB-Launcher.apk\n");	
						out.writeBytes("busybox mount -o remount ro /system\n");										
                        out.writeBytes("reboot\n");
						out.flush();
					    } catch (IOException e) {
						    e.printStackTrace();
						    return;
					    }

				    }
			    };
			    cmdThread.start();
			}
			mLauncher.setEnabled(false);
			mLauncher.setSummary(R.string.uninstalled_uninstall);
		}
		return false;
	}

}
