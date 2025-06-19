package com.max2idea.android.limbo.utils;

import android.app.Activity;
import android.content.DialogInterface;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class DialogUtils {

    public static void oneDialog(Activity _context, String _title, String _message, String _textPositiveButton, boolean _isicon, int _iconid, boolean _cancel, Runnable _onPositive) {
        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(_context);
        dialog.setTitle(_title);
        dialog.setMessage(_message);
        if (_isicon) {
            dialog.setIcon(_iconid);
        }
        if (!_cancel) {
            dialog.setCancelable(false);
        }
        dialog.setPositiveButton(_textPositiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (_onPositive != null) _onPositive.run();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public static void twoDialog(Activity _context, String _title, String _message, String _textPositiveButton, String _textNegativeButton, boolean _isicon, int _iconid, boolean _cancel, Runnable _onPositive, Runnable _onNegative) {
        MaterialAlertDialogBuilder dialog = new MaterialAlertDialogBuilder(_context);
        dialog.setTitle(_title);
        dialog.setMessage(_message);
        if (_isicon) {
            dialog.setIcon(_iconid);
        }
        if (!_cancel) {
            dialog.setCancelable(false);
        }
        dialog.setPositiveButton(_textPositiveButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (_onPositive != null) _onPositive.run();
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton(_textNegativeButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (_onNegative != null) _onNegative.run();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
