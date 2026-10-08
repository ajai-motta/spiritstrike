package com.hive.plugin;

import android.text.TextUtils;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.SocialV4;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
class SocialV4 {
    private ICallEngine callEngine;

    public SocialV4(ICallEngine iCallEngine) {
        this.callEngine = iCallEngine;
    }

    public String showCommunity(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("providerType");
        if (TextUtils.isEmpty(strOptString)) {
            return "";
        }
        String upperCase = strOptString.toUpperCase(Locale.US);
        if (TextUtils.isEmpty(upperCase)) {
            return "";
        }
        SocialV4.ProviderType providerTypeValueOf = SocialV4.ProviderType.valueOf(upperCase);
        String strOptString2 = jSONObject.optString("viewType");
        if (TextUtils.isEmpty(strOptString2)) {
            com.hive.SocialV4.INSTANCE.showCommunity(providerTypeValueOf, new SocialV4.SocialV4ShowCommunityListener() { // from class: com.hive.plugin.SocialV4.1
                @Override // com.hive.SocialV4.SocialV4ShowCommunityListener
                public void onShowCommunity(ResultAPI resultAPI) {
                    SocialV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
                }
            });
        } else {
            com.hive.SocialV4.INSTANCE.showCommunity(providerTypeValueOf, SocialV4.ViewType.valueOf(strOptString2), new SocialV4.SocialV4ShowCommunityListener() { // from class: com.hive.plugin.SocialV4.2
                @Override // com.hive.SocialV4.SocialV4ShowCommunityListener
                public void onShowCommunity(ResultAPI resultAPI) {
                    SocialV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
                }
            });
        }
        return "";
    }

    public String sharePhoto(final String str, final JSONObject jSONObject) {
        String strOptString = jSONObject.optString("providerType");
        if (TextUtils.isEmpty(strOptString)) {
            return "";
        }
        String upperCase = strOptString.toUpperCase(Locale.US);
        if (TextUtils.isEmpty(upperCase)) {
            return "";
        }
        com.hive.SocialV4.INSTANCE.sharePhoto(SocialV4.ProviderType.valueOf(upperCase), new SocialV4.SocialV4SharePhotoListener() { // from class: com.hive.plugin.SocialV4.3
            @Override // com.hive.SocialV4.SocialV4SharePhotoListener
            public void onShare(ResultAPI resultAPI) {
                SocialV4.this.callEngine.callEngine(str, HivePlugin.createResponse(resultAPI, jSONObject).toString());
            }
        });
        return "";
    }

    public String executeNative(final String str, final String str2, final JSONObject jSONObject) {
        HiveActivity hiveActivity = HiveActivity.INSTANCE;
        if (!HiveActivity.isActivityInitialized()) {
            com.hive.Logger logger = com.hive.Logger.INSTANCE;
            com.hive.Logger.e("Plugin", "HiveActivity.getRecentActivity() == null");
            return "";
        }
        HiveActivity.INSTANCE.getRecentActivity().runOnUiThread(new Runnable() { // from class: com.hive.plugin.SocialV4$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m5567lambda$executeNative$0$comhivepluginSocialV4(str, str2, jSONObject);
            }
        });
        return "";
    }

    /* JADX INFO: renamed from: lambda$executeNative$0$com-hive-plugin-SocialV4, reason: not valid java name */
    /* synthetic */ void m5567lambda$executeNative$0$comhivepluginSocialV4(String str, String str2, JSONObject jSONObject) {
        if ("showCommunity".equals(str)) {
            showCommunity(str2, jSONObject);
        } else if ("sharePhoto".equals(str)) {
            sharePhoto(str2, jSONObject);
        }
    }
}
