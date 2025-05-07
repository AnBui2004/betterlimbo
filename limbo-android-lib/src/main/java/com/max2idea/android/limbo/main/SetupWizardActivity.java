package com.max2idea.android.limbo.main;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.limbo.emu.lib.R;
import com.max2idea.android.limbo.utils.FileUtils;
import com.max2idea.android.limbo.utils.PermisionUtils;
import com.max2idea.android.limbo.utils.SharedPreferencesUtils;
import com.max2idea.android.limbo.utils.UIUtils;

import java.io.IOException;

public class SetupWizardActivity extends AppCompatActivity {
    private LinearLayout linearwelcome;
    private LinearLayout steplicense;
    private LinearLayout stepchangelog;
    private LinearLayout stephelp;
    private LinearLayout stepstoragepermission;
    private LinearLayout stepfinish;
    private MaterialButton gotowikibutton;
    private MaterialButton storagepermissionbutton;
    private MaterialButton skipbutton;
    private MaterialButton nextbutton;
    private TextView licensetext;
    private TextView changelogtext;
    private TextView storagepermissiontext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setup_wizard_activity);

        linearwelcome = findViewById(R.id.linearwelcome);
        steplicense = findViewById(R.id.steplicense);
        stepchangelog = findViewById(R.id.stepchangelog);
        stephelp = findViewById(R.id.stephelp);
        stepstoragepermission = findViewById(R.id.stepstoragepermission);
        stepfinish = findViewById(R.id.stepfinish);
        gotowikibutton = findViewById(R.id.gotowikibutton);
        storagepermissionbutton = findViewById(R.id.storagepermissionbutton);
        skipbutton = findViewById(R.id.skipbutton);
        nextbutton = findViewById(R.id.nextbutton);
        licensetext = findViewById(R.id.licensetext);
        changelogtext = findViewById(R.id.changelogtext);
        storagepermissiontext = findViewById(R.id.storagepermissiontext);

        gotowikibutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Config.guidesLink));
                startActivity(intent);
            }
        });

        storagepermissionbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PermisionUtils.storagePermissionForSetupWizard(SetupWizardActivity.this);
            }
        });

        skipbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backStep();
            }
        });

        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextStep();
            }
        });

        try {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                licensetext.setText(Html.fromHtml(FileUtils.LoadFile(this, "LICENSE", false), Html.FROM_HTML_MODE_COMPACT));
//            } else {
                licensetext.setText(FileUtils.LoadFile(this, "LICENSE", false));
//            }
        } catch (IOException e) {
            licensetext.setText("Load failed!");
            throw new RuntimeException(e);
        }

        try {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                changelogtext.setText(Html.fromHtml(FileUtils.LoadFile(this, "CHANGELOG", false), Html.FROM_HTML_MODE_COMPACT));
//            } else {
                changelogtext.setText(FileUtils.LoadFile(this, "CHANGELOG", false));
//            }
        } catch (IOException e) {
            changelogtext.setText("Load failed!");
            throw new RuntimeException(e);
        }

        skipbutton.setVisibility(GONE);
        UIUtils.dynamicSetLightStatusBar(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        checkstepstoragepermission();
    }

    @Override
    public void onBackPressed() {
        backStep();
    }

    private void backStep() {
        if (stepstoragepermission.getVisibility() == GONE) {
            stepstoragepermission.setVisibility(VISIBLE);
            checkstepstoragepermission();
        } else if (stephelp.getVisibility() == GONE) {
            stephelp.setVisibility(VISIBLE);
        } else if (stepchangelog.getVisibility() == GONE) {
            stepchangelog.setVisibility(VISIBLE);
            skipbutton.setVisibility(GONE);
        }
//        } else if (steplicense.getVisibility() == GONE) {
//            steplicense.setVisibility(VISIBLE);
//            skipbutton.setVisibility(GONE);
//        } else if (linearwelcome.getVisibility() == GONE) {
//            linearwelcome.setVisibility(VISIBLE);
//            skipbutton.setVisibility(GONE);
//        }
    }

    private void nextStep() {
        if (linearwelcome.getVisibility() == VISIBLE) {
            linearwelcome.setVisibility(GONE);
        } else if (steplicense.getVisibility() == VISIBLE) {
            steplicense.setVisibility(GONE);
            skipbutton.setVisibility(GONE);
        } else if (stepchangelog.getVisibility() == VISIBLE) {
            stepchangelog.setVisibility(GONE);
            skipbutton.setVisibility(VISIBLE);
        } else if (stephelp.getVisibility() == VISIBLE) {
            stephelp.setVisibility(GONE);
            checkstepstoragepermission();
        } else if (stepstoragepermission.getVisibility() == VISIBLE) {
            stepstoragepermission.setVisibility(GONE);
        } else {
            SharedPreferencesUtils.setisSetupWizardDone(this);
            finish();
        }
    }

    private void checkstepstoragepermission() {
        if (PermisionUtils.storagePermission(false,this)) {
            storagepermissionbutton.setVisibility(GONE);
            storagepermissiontext.setText("You have granted permission.");
            if (stephelp.getVisibility() == GONE) {
                nextbutton.setVisibility(VISIBLE);
            }
        } else {
            storagepermissionbutton.setVisibility(VISIBLE);
            storagepermissiontext.setText("Grant access to storage to continue.");
            if (stephelp.getVisibility() == GONE) {
                nextbutton.setVisibility(GONE);
            }
        }
    }
}
