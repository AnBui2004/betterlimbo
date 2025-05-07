package com.max2idea.android.limbo.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import com.limbo.emu.lib.R;
import com.max2idea.android.limbo.main.LimboActivity;

public class PermisionUtils {
    public static boolean storagePermission(boolean _request, Activity _context) {
        if (Build.VERSION.SDK_INT > 29) {
            if (!Environment.isExternalStorageManager()) {
                if (!SharedPreferencesUtils.getDontShowAgainRequestManageAllFilesPermission(_context) && _request) {
                    MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(_context);
                    dialog.setIcon(R.drawable.folder_24px);
                    dialog.setTitle("Manager all files");
                    dialog.setMessage("Limbo need this permission to access your files more easily and avoid file inaccessible errors.If you do not allow this permission, some errors may occur.");
                    dialog.setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                            Uri uri = Uri.fromParts("package", _context.getPackageName(), null);
                            intent.setData(uri);
                            _context.startActivity(intent);
                        }
                    });
                    dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.setNeutralButton("Don't show again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            SharedPreferencesUtils.setDontShowAgainRequestManageAllFilesPermission(_context);
                        }
                    });
                    dialog.show();
                }
            } else {
                return true;
            }
        } else if (Build.VERSION.SDK_INT > 22) {
            if (ContextCompat.checkSelfPermission(_context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (!SharedPreferencesUtils.getDontShowAgainRequestManageAllFilesPermission(_context) && _request) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(_context, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(_context);
                        dialog.setIcon(R.drawable.folder_24px);
                        dialog.setTitle("Files");
                        dialog.setMessage("Limbo need this permission to access your files more easily and avoid file inaccessible errors.If you do not allow this permission, some errors may occur.");
                        dialog.setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(_context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
                            }
                        });
                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.setNeutralButton("Don't show again", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferencesUtils.setDontShowAgainRequestManageAllFilesPermission(_context);
                            }
                        });
                        dialog.show();
                    } else {
                        ActivityCompat.requestPermissions(_context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
                    }
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean notificationPermission(boolean _request, Activity _context) {
        if (Build.VERSION.SDK_INT > 32) {
            if (ContextCompat.checkSelfPermission(_context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                if (!SharedPreferencesUtils.getDontShowAgainRequestNotificationPermission(_context) && _request) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(_context, Manifest.permission.POST_NOTIFICATIONS)) {
                        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(_context);
                        dialog.setIcon(R.drawable.notifications_24px);
                        dialog.setTitle("Notification");
                        dialog.setMessage("Limbo need this permission to post notifications about virtual machine status. You may not need to allow this permission.");
                        dialog.setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(_context, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1000);
                            }
                        });
                        dialog.setNegativeButton("Still not allowed", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SharedPreferencesUtils.setDontShowAgainRequestNotificationPermission(_context);
                            }
                        });
                        dialog.create().show();
                    } else {
                        ActivityCompat.requestPermissions(_context, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1000);
                    }
                }
            } else {
                return true;
            }
        } else {
            return true;
        }
        return false;
    }

    public static void storagePermissionForSetupWizard(Activity _context) {
        if (Build.VERSION.SDK_INT > 29) {
            if (!Environment.isExternalStorageManager()) {
                MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(_context);
                dialog.setIcon(R.drawable.folder_24px);
                dialog.setTitle("Manager all files");
                dialog.setMessage("Limbo need this permission to access your files more easily and avoid file inaccessible errors.If you do not allow this permission, some errors may occur.");
                dialog.setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_APP_ALL_FILES_ACCESS_PERMISSION);
                        Uri uri = Uri.fromParts("package", _context.getPackageName(), null);
                        intent.setData(uri);
                        _context.startActivity(intent);
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        } else if (Build.VERSION.SDK_INT > 22) {
            if (ContextCompat.checkSelfPermission(_context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (!SharedPreferencesUtils.getDontShowAgainRequestManageAllFilesPermission(_context)) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(_context, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(_context);
                        dialog.setIcon(R.drawable.notifications_24px);
                        dialog.setTitle("Files");
                        dialog.setMessage("Limbo need this permission to access your files more easily and avoid file inaccessible errors.If you do not allow this permission, some errors may occur.");
                        dialog.setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(_context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
                            }
                        });
                        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        dialog.show();
                    } else {
                        ActivityCompat.requestPermissions(_context, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
                    }
                }
            }
        }
    }
}
