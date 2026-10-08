package com.hive.plugin;

import android.util.Log;

/* JADX INFO: loaded from: classes6.dex */
public class HivePluginUnreal extends HivePlugin {
    private static HivePluginUnreal hivePluginUnrealImpl = new HivePluginUnreal();
    private String _cbGameObject = "";

    private native void jniCallEngine(String str, String str2);

    private native void jniInitEngine();

    public static HivePluginUnreal getInstance() {
        Log.d("UE4", "HIVE SDK UE get instance");
        return hivePluginUnrealImpl;
    }

    private HivePluginUnreal() {
        Log.d("UE4", "HIVE SDK UE Constructor");
    }

    public static String callNativeApi(String str) {
        Log.d("UE4", "HIVE SDK callNativeApi Success");
        return getInstance().executeNative(str);
    }

    @Override // com.hive.plugin.ICallEngine
    public void callEngine(String str, String str2) {
        jniCallEngine(str, str2);
    }
}
