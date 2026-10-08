package com.bytedance.sdk.openadsdk.bjy.qdl;

import com.facebook.internal.NativeProtocol;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mzz {
    public static void qdl(final String str, final String str2, final int i, final String str3) {
        com.bytedance.sdk.openadsdk.bjy.lnr.qdl(str, false, 10, new com.bytedance.sdk.openadsdk.bjy.ud() { // from class: com.bytedance.sdk.openadsdk.bjy.qdl.mzz.1
            @Override // com.bytedance.sdk.openadsdk.bjy.ud
            public lnr getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i);
                jSONObject.put("error_msg", str3);
                return mml.ud().qdl(str).ud(jSONObject.toString());
            }
        });
    }
}
