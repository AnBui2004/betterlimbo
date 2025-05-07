package com.max2idea.android.limbo.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtils {
    public static void setDontShowAgainRequestManageAllFilesPermission(Context _context) {
        SharedPreferences _sp = _context.getSharedPreferences("settingsdata", Context.MODE_PRIVATE);
        _sp.edit().putBoolean("dontShowAgainRequestManageAllFilesPermission", true).apply();
    }
    public static boolean getDontShowAgainRequestManageAllFilesPermission(Context _context) {
        SharedPreferences _sp = _context.getSharedPreferences("settingsdata", Context.MODE_PRIVATE);
        return _sp.getBoolean("dontShowAgainRequestManageAllFilesPermission", false);
    }

    public static void setDontShowAgainRequestNotificationPermission(Context _context) {
        SharedPreferences _sp = _context.getSharedPreferences("settingsdata", Context.MODE_PRIVATE);
        _sp.edit().putBoolean("dontShowAgainRequestNotificationPermission", true).apply();
    }
    public static boolean getDontShowAgainRequestNotificationPermission(Context _context) {
        SharedPreferences _sp = _context.getSharedPreferences("settingsdata", Context.MODE_PRIVATE);
        return _sp.getBoolean("dontShowAgainRequestNotificationPermission", false);
    }

    public static void setisSetupWizardDone(Context _context) {
        SharedPreferences _sp = _context.getSharedPreferences("settingsdata", Context.MODE_PRIVATE);
        _sp.edit().putBoolean("isSetupWizardDone", true).apply();
    }
    public static boolean getisSetupWizardDone(Context _context) {
        SharedPreferences _sp = _context.getSharedPreferences("settingsdata", Context.MODE_PRIVATE);
        return _sp.getBoolean("isSetupWizardDone", false);
    }
}
