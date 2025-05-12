package com.limbo.emu.main;

import android.content.Intent;

import com.max2idea.android.limbo.main.SetupWizardActivity;

public class SetupWizard2Activity extends SetupWizardActivity {
    protected void finishNow() {
        Intent intent = new Intent(this, LimboEmuActivity.class);
        startActivity(intent);
    }
}
