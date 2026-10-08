package com.hive.userengagement;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.hive.base.Property;
import com.hive.base.PropertyKeys;
import com.hive.core.Logger;

/* JADX INFO: loaded from: classes6.dex */
public class DeferredDeeplinkActivity extends Activity {
    public static String getSharedPreferencesData(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return context.getApplicationContext().getSharedPreferences(DeferredDeeplinkActivity.class.getName(), 0).getString(str, null);
    }

    public static void removeSharedPreferencesData(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(DeferredDeeplinkActivity.class.getName(), 0).edit();
        editorEdit.remove(str);
        editorEdit.commit();
    }

    public static void setSharedPreferencesData(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(DeferredDeeplinkActivity.class.getName(), 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    private void startLauncherActivity() {
        try {
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            launchIntentForPackage.setFlags(268435456);
            Log.d("DeferredDeeplink", "DeferredDeeplink, startLauncherActivity mainActivity");
            startActivity(launchIntentForPackage);
        } catch (Exception e) {
            Log.d("DeferredDeeplink", "DeferredDeeplink, startLauncherActivity exception : " + e);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Uri data;
        super.onCreate(bundle);
        try {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getActionBar().hide();
        } catch (Exception e) {
            Log.d("DeferredDeeplink", "onCreate exception(set view option) : " + e.toString());
        }
        try {
            Intent intent = getIntent();
            if (intent != null && intent.getAction() != null && (data = intent.getData()) != null) {
                try {
                    Property.Companion companion = Property.INSTANCE;
                    companion.getINSTANCE().setValue(PropertyKeys.DEFERRED_DEEPLINK_INFO, data.toString(), Property.PropertySaveOption.SaveEmptyString);
                    companion.getINSTANCE().writeProperties();
                    setSharedPreferencesData(this, PropertyKeys.DEFERRED_DEEPLINK_INFO, data.toString());
                } catch (Exception e2) {
                    Log.d("DeferredDeeplink", "onCreate exception(set properties) : " + e2.toString());
                }
                Logger logger = Logger.INSTANCE;
                logger.d("DeferredDeeplink, property data : " + Property.INSTANCE.getINSTANCE().getValue(PropertyKeys.DEFERRED_DEEPLINK_INFO));
                logger.d("DeferredDeeplink, sharedPreferences data : " + getSharedPreferencesData(this, PropertyKeys.DEFERRED_DEEPLINK_INFO));
            }
        } catch (Exception e3) {
            Log.d("DeferredDeeplink", "onCreate exception(set intent) : " + e3.toString());
        }
        startLauncherActivity();
    }
}
