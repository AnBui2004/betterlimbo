package com.limbo.emu.main;

import android.content.Intent;

import com.max2idea.android.limbo.main.SplashActivity;
public class Splash2Activity extends SplashActivity {

    protected void startHome() {
        Intent intent = new Intent(this, LimboEmuActivity.class);
        startActivity(intent);
    }

    protected void startSetup() {
        Intent intent = new Intent(this, SetupWizard2Activity.class);
        startActivity(intent);
    }
}
