package com.adxcorp.ads.common;

import android.content.Context;
import com.adxcorp.ads.mediation.MediationSDK;
import com.gomfactory.adpie.sdk.AdPieSDK;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdPieUtil {
    public static void initialize(Context context, String str) {
        if (AdPieSDK.getInstance().isInitialized()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (MediationSDK.getInstance().isLiteSdk()) {
            try {
                jSONObject.put("adpie_config_url", "api.adpiex.com/adp/config");
                jSONObject.put("adpie_ssp_url", "api.adpiex.com/ssp/request");
            } catch (Exception unused) {
            }
            AdPieSDK.getInstance().initialize(context.getApplicationContext(), str, jSONObject);
        } else {
            try {
                jSONObject.put("adpie_config_url", "adp.adpies.com/adp/config");
                jSONObject.put("adpie_ssp_url", "ssp.adpies.com/ssp/request");
            } catch (Exception unused2) {
            }
            AdPieSDK.getInstance().initialize(context.getApplicationContext(), str, jSONObject);
        }
    }
}
