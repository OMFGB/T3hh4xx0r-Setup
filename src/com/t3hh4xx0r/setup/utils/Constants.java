package com.t3hh4xx0r.setup.utils;
import android.os.SystemProperties;

public final class Constants {

	public static boolean FIRST_LAUNCH = true;
	 
	public static boolean SUPPORTED =true;

	public static String ROM = SystemProperties.get("ro.build.romversion");
}
