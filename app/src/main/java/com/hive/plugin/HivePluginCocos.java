package com.hive.plugin;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes6.dex */
public class HivePluginCocos extends HivePlugin {
    private static HivePluginCocos hivePluginCocosImpl = new HivePluginCocos();
    private Object cocos2dxActivity;

    /* JADX INFO: Access modifiers changed from: private */
    public native void jniCallEngine(String str, String str2);

    private native void jniInitEngine();

    public static HivePluginCocos getInstance() {
        return hivePluginCocosImpl;
    }

    private HivePluginCocos() {
        jniInitEngine();
    }

    public void setCocos2dxActivity(Object obj) {
        this.cocos2dxActivity = obj;
    }

    public static String callNative(String str) {
        return getInstance().executeNative(str);
    }

    @Override // com.hive.plugin.ICallEngine
    public void callEngine(final String str, final String str2) {
        HivePlugin.invokeMethod(this.cocos2dxActivity, "runOnGLThread", new Object[]{new Runnable() { // from class: com.hive.plugin.HivePluginCocos.1
            @Override // java.lang.Runnable
            public void run() {
                HivePluginCocos.this.jniCallEngine(str, str2);
            }
        }});
    }

    public static void showAlertDialog(final String str) {
        if (str == null) {
            str = "(null)";
        }
        final Activity activity = (Activity) getInstance().cocos2dxActivity;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.plugin.HivePluginCocos.2
            @Override // java.lang.Runnable
            public void run() {
                new AlertDialog.Builder(activity).setTitle("HIVE SDK Log Dialog").setMessage(str).create().show();
            }
        });
    }
}
