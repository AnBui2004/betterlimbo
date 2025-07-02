package com.max2idea.android.limbo.main;

import android.os.Bundle;
import android.text.Spannable;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.limbo.emu.lib.R;
import com.max2idea.android.limbo.utils.FileUtils;
import com.max2idea.android.limbo.utils.UIUtils;

public class LastCrash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UIUtils.applyDynamicColor(getApplication());
        UIUtils.edgeToEdge(this);
        setContentView(R.layout.last_crash);
        UIUtils.setOnApplyWindowInsetsListener(findViewById(R.id.linear_crash_log));
        UIUtils.dynamicSetLightStatusBar(this);
        TextView crash_log = findViewById(R.id.crash_log);
        if (getIntent().hasExtra("crash_log")) {
            crash_log.setText(getIntent().getStringExtra("crash_log"));
        } else {
            String contents = FileUtils.getFileContents(Config.logFilePath);

            if (contents.length() > 50 * 1024)
                contents = contents.substring(0, 25 * 1024)
                        + "\n.....\n" +
                        contents.substring(contents.length() - 25 * 1024);

            final String finalContents = contents;
            final Spannable contentsFormatted = UIUtils.formatAndroidLog(contents);
            crash_log.setText(contentsFormatted);
        }

        if (crash_log.getText().toString().isEmpty())
            crash_log.setText("Nothing here!");
    }
}
