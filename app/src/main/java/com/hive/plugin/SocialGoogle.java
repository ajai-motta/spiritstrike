package com.hive.plugin;

import com.hive.HiveActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class SocialGoogle {
    private ICallEngine callEngine;

    public SocialGoogle(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String executeNative(String str, String str2, JSONObject jSONObject) {
        HiveActivity hiveActivity = HiveActivity.INSTANCE;
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger logger = com.hive.Logger.INSTANCE;
            com.hive.Logger.d("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.SocialGoogle.1
            @Override // java.lang.Runnable
            public void run() {
            }
        });
        return "";
    }
}
