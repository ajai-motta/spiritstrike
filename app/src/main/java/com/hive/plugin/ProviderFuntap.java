package com.hive.plugin;

import com.hive.HiveActivity;
import com.hive.ProviderFuntap;
import com.hive.ResultAPI;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
class ProviderFuntap {
    private final ICallEngine callEngine;

    public ProviderFuntap(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String isFunTapUnderGovernmentReview(String str, JSONObject jSONObject) {
        boolean zIsFunTapUnderGovernmentReview = com.hive.ProviderFuntap.isFunTapUnderGovernmentReview();
        JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(null, jSONObject);
        try {
            jSONObjectCreateResponse.put("isFunTapUnderGovernmentReview", zIsFunTapUnderGovernmentReview);
        } catch (Exception unused) {
        }
        return jSONObjectCreateResponse.toString();
    }

    public String checkUserInfoComplete(final String str, final JSONObject jSONObject) {
        com.hive.ProviderFuntap.checkUserInfoComplete(jSONObject.optString("userId"), new ProviderFuntap.CheckUserInfoCompleteListener() { // from class: com.hive.plugin.ProviderFuntap.1
            @Override // com.hive.ProviderFuntap.CheckUserInfoCompleteListener
            public void onResult(ResultAPI resultAPI, boolean z) {
                JSONObject jSONObjectCreateResponse = HivePlugin.createResponse(resultAPI, jSONObject);
                try {
                    jSONObjectCreateResponse.put("isCompleted", z);
                } catch (Exception unused) {
                }
                ProviderFuntap.this.callEngine.callEngine(str, jSONObjectCreateResponse.toString());
            }
        });
        return "";
    }

    public String showUpdateUserInfo(final String str, final JSONObject jSONObject) {
        com.hive.ProviderFuntap.showUpdateUserInfo(jSONObject.optString("userId"), new ProviderFuntap.ShowUpdateUserInfoListener() { // from class: com.hive.plugin.ProviderFuntap.2
            @Override // com.hive.ProviderFuntap.ShowUpdateUserInfoListener
            public void onResult(ResultAPI resultAPI) {
                ProviderFuntap.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String saveCharacter(String str, JSONObject jSONObject) {
        com.hive.ProviderFuntap.saveCharacter(jSONObject.optString("roleId"), jSONObject.optString("areaId"));
        return "";
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        if ("isFunTapUnderGovernmentReview".equals(str)) {
            return isFunTapUnderGovernmentReview(str2, jSONObject);
        }
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger.e("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.ProviderFuntap.3
            @Override // java.lang.Runnable
            public void run() {
                if ("checkUserInfoComplete".equals(str)) {
                    ProviderFuntap.this.checkUserInfoComplete(str2, jSONObject);
                } else if ("showUpdateUserInfo".equals(str)) {
                    ProviderFuntap.this.showUpdateUserInfo(str2, jSONObject);
                } else if ("saveCharacter".equals(str)) {
                    ProviderFuntap.this.saveCharacter(str2, jSONObject);
                }
            }
        });
        return "";
    }
}
