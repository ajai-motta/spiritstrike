package com.hive.plugin;

import com.unity3d.services.core.properties.MadeWithUnityDetector;

/* JADX INFO: loaded from: classes6.dex */
public class HivePluginUnity extends HivePlugin {
    private static HivePluginUnity hivePluginUnityImpl = new HivePluginUnity();

    public static HivePluginUnity getInstance() {
        return hivePluginUnityImpl;
    }

    private HivePluginUnity() {
    }

    public static String callNative(String str) {
        return getInstance().executeNative(str);
    }

    @Override // com.hive.plugin.ICallEngine
    public void callEngine(String str, String str2) {
        HivePlugin.invokeMethod(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME, "UnitySendMessage", new Object[]{str, "callEngine", str2});
    }
}
