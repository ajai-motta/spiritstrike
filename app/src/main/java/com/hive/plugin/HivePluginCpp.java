package com.hive.plugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes6.dex */
public class HivePluginCpp extends HivePlugin {
    private static HivePluginCpp hivePluginCppImpl = new HivePluginCpp();
    private Object activity;

    private native void jniCallEngine(String str, String str2);

    private native void jniInitEngine();

    public static HivePluginCpp getInstance() {
        return hivePluginCppImpl;
    }

    public void setActivity(Object obj) {
        this.activity = obj;
    }

    private HivePluginCpp() {
        jniInitEngine();
    }

    public static String callNative(String str) {
        return getInstance().executeNative(str);
    }

    @Override // com.hive.plugin.ICallEngine
    public void callEngine(String str, String str2) {
        jniCallEngine(str, str2);
    }

    public static void showAlertDialog(final String str) {
        if (str == null) {
            str = "(null)";
        }
        final Activity activity = (Activity) getInstance().activity;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.plugin.HivePluginCpp.1
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(activity).setTitle("HIVE SDK Log Dialog").setMessage(str).create().show();
            }
        });
    }
}
