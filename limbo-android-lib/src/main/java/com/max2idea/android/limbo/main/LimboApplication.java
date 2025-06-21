package com.max2idea.android.limbo.main;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

public class LimboApplication extends Application {

    @Override
	public void onCreate() {

		Thread.setDefaultUncaughtExceptionHandler(
                new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread thread, Throwable throwable) {
                        Intent intent = new Intent(getApplicationContext(), LastCrash.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_LAUNCH_ADJACENT | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        intent.putExtra("crash_log", Log.getStackTraceString(throwable));
                        startActivity(intent);
                    }
                });

        super.onCreate();
		try {
			Class.forName("android.os.AsyncTask");
		} catch (Throwable ignore) {
			// ignored
		}

		

	}

}
