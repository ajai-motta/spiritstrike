package com.google.ads.mediation.pangle;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.google.android.gms.ads.mediation.MediationAdConfiguration;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class PangleRequestHelper {
    public static final String ADMOB_WATERMARK_KEY = "admob_watermark";

    public static void setWatermarkString(PAGRequest pAGRequest, String str, MediationAdConfiguration mediationAdConfiguration) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String watermark = mediationAdConfiguration.getWatermark();
        if (TextUtils.isEmpty(watermark)) {
            return;
        }
        Map<String, Object> extraInfo = pAGRequest.getExtraInfo();
        if (extraInfo == null) {
            extraInfo = new HashMap<>();
        }
        extraInfo.put(ADMOB_WATERMARK_KEY, watermark);
        pAGRequest.setExtraInfo(extraInfo);
    }

    private PangleRequestHelper() {
    }
}
