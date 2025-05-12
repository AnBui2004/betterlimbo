package com.max2idea.android.limbo.main;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.limbo.emu.lib.R;
import com.max2idea.android.limbo.utils.SharedPreferencesUtils;
import com.max2idea.android.limbo.utils.UIUtils;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        UIUtils.dynamicSetLightStatusBar(this);
        new Handler().postDelayed(() -> {
            if (SharedPreferencesUtils.getisSetupWizardDone(this)) {
                startHome();
            } else {
                startSetup();
            }
        }, 1000);
    }

    protected void startHome() {

    }

    protected void startSetup() {

    }
}
