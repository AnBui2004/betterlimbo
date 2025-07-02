/*
Copyright (C) Max Kastanas 2012

 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
package com.max2idea.android.limbo.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.view.Window;
import android.view.WindowManager;

import com.limbo.emu.lib.R;
import com.max2idea.android.limbo.utils.UIUtils;

public class LimboSettingsManager extends PreferenceActivity {

	static String getDNSServer(Activity activity) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		return prefs.getString("dnsServer", Config.defaultDNSServer);
	}

	public static void setDNSServer(Activity activity, String dnsServer) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		SharedPreferences.Editor edit = prefs.edit();
		edit.putString("dnsServer", dnsServer);
		edit.apply();
	}

	public static int getOrientationSetting(Activity activity) {

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		int orientation = prefs.getInt("orientation", 0);
		// UIUtils.log("Getting First time: " + firstTime);
		return orientation;
	}
	
	public static void setOrientationSetting(Activity activity, int orientation) {

		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		SharedPreferences.Editor edit = prefs.edit();
		edit.putInt("orientation", orientation);
		edit.apply();
	}


	public static boolean getPromptUpdateVersion(Activity activity) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		return prefs.getBoolean("updateVersionPrompt", Config.defaultCheckNewVersion);
	}
	

	public static void setPromptUpdateVersion(Activity activity, boolean flag) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		SharedPreferences.Editor edit = prefs.edit();
		edit.putBoolean("updateVersionPrompt", flag);
		edit.apply();
		// UIUtils.log("Setting First time: ");
	}
	
	static boolean getPrio(Activity activity) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		return prefs.getBoolean("HighPrio", false);
	}

	public static void setPrio(Activity activity, boolean flag) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		SharedPreferences.Editor edit = prefs.edit();
		edit.putBoolean("HighPrio", flag);
		edit.apply();
		// UIUtils.log("Setting First time: ");
	}
	
	public static boolean getAlwaysShowMenuToolbar(Activity activity) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		return prefs.getBoolean("AlwaysShowMenuToolbar", false);
	}

	public static void setAlwaysShowMenuToolbar(Activity activity, boolean flag) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		SharedPreferences.Editor edit = prefs.edit();
		edit.putBoolean("AlwaysShowMenuToolbar", flag);
		edit.apply();
		// UIUtils.log("Setting First time: ");
	}
	
	public static boolean getFullscreen(Activity activity) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		return prefs.getBoolean("ShowFullscreen", true);
	}

	public static void setFullscreen(Activity activity, boolean flag) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		SharedPreferences.Editor edit = prefs.edit();
		edit.putBoolean("ShowFullscreen", flag);
		edit.apply();
		// UIUtils.log("Setting First time: ");
	}

	public static boolean getDesktopMode(Activity activity) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		return prefs.getBoolean("DesktopMode", false);
	}

	public static void setDesktopMode(Activity activity, boolean flag) {
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
		SharedPreferences.Editor edit = prefs.edit();
		edit.putBoolean("DesktopMode", flag);
		edit.apply();
		// UIUtils.log("Setting First time: ");
	}

    public static boolean getEnableLegacyFileManager(Activity activity) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        return prefs.getBoolean("EnableLegacyFileManager", false);
	}


    public static void setEnableLegacyFileManager(Activity activity, boolean flag) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean("EnableLegacyFileManager", flag);
        edit.apply();
        // UIUtils.log("Setting First time: ");
    }

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent data = new Intent();
		setResult(Config.SETTINGS_RETURN_CODE, data);
		addPrefs();
        UIUtils.dynamicSetLightStatusBar(this);
	}

	public void addPrefs() {
		addPreferencesFromResource(R.xml.settings);
	}



    public static String getLastDir(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String imagesDir = prefs.getString("lastDir", null);
        return imagesDir;
    }

    public static void setLastDir(Context context, String imagesPath) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("lastDir", imagesPath);
        edit.commit();
    }

    public static String getImagesDir(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String imagesDir = prefs.getString("imagesDir", null);
        return imagesDir;
    }

    public static void setImagesDir(Context context, String imagesPath) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("imagesDir", imagesPath);
        edit.commit();
    }


    public static String getExportDir(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String imagesDir = prefs.getString("exportDir", null);
        return imagesDir;
    }

    public static void setExportDir(Context context, String imagesPath) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("exportDir", imagesPath);
        edit.commit();
    }


    public static String getSharedDir(Context context) {
        String lastDir = Environment.getExternalStorageDirectory().getPath();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString("sharedDir", lastDir);
    }

    public static void setSharedDir(Context context, String lastDir) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putString("sharedDir", lastDir);
        edit.apply();
        // UIUtils.log("Setting First time: ");
    }



    public static int getExitCode(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        int exitCode = prefs.getInt("exitCode", 1);
        return exitCode;
    }

    public static void setExitCode(Context context, int exitCode) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = prefs.edit();
        edit.putInt("exitCode", exitCode);
        edit.commit();
    }


    public static boolean isFirstLaunch(Activity activity) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        boolean firstTime = false;
        PackageInfo pInfo = null;

        try {
            pInfo = activity.getPackageManager().getPackageInfo(activity.getClass().getPackage().getName(),
                    PackageManager.GET_META_DATA);
            firstTime = prefs.getBoolean("firstTime" + pInfo.versionName, true);
        } catch (PackageManager.NameNotFoundException e) {
            firstTime = prefs.getBoolean("firstTime", true);
            e.printStackTrace();
        }
        return firstTime;
    }

    public static void setFirstLaunch(Activity activity) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor edit = prefs.edit();
        PackageInfo pInfo = null;

        try {
            pInfo = activity.getPackageManager().getPackageInfo(activity.getClass().getPackage().getName(),
                    PackageManager.GET_META_DATA);
            edit.putBoolean("firstTime" + pInfo.versionName, false);
            edit.putBoolean("firstTime", false);
        } catch (PackageManager.NameNotFoundException e) {
            edit.putBoolean("firstTime", false);
            e.printStackTrace();
        }
        edit.commit();
    }

}
