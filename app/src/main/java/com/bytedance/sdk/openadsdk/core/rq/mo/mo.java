package com.bytedance.sdk.openadsdk.core.rq.mo;

import android.content.Context;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.core.jl;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.utils.gy;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mo {
    private final String qdl = "UGenV3OpenLinks";
    private final String ud = "landingStyle";
    private final String lnr = "url";
    private final String mml = "fallbackUrl";

    public void qdl(Context context, boolean z, ljh ljhVar, String str, Map<String, String> map, com.bytedance.sdk.openadsdk.core.widget.mzz mzzVar) {
        if (map == null || map.isEmpty()) {
            return;
        }
        try {
            if (qdl(Integer.parseInt(map.get("landingStyle")), map.get("url"), map.get("fallbackUrl"))) {
                jl.qdl(context, z, qdl(map), ljhVar, str, gy.qdl(str), null, mzzVar);
            }
        } catch (Throwable th) {
            aaj.lnr("UGenV3OpenLinks", th.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean qdl(int r4, java.lang.String r5, java.lang.String r6) {
        /*
            r3 = this;
            r0 = 0
            r1 = 1
            if (r4 == r1) goto L1f
            r2 = 2
            if (r4 == r2) goto Lb
            r6 = 3
            if (r4 == r6) goto L1f
            goto L26
        Lb:
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            if (r4 == 0) goto L18
            boolean r4 = android.text.TextUtils.isEmpty(r6)
            if (r4 == 0) goto L18
            goto L27
        L18:
            boolean r4 = com.bytedance.sdk.component.utils.jl.qdl(r6)
            if (r4 != 0) goto L26
            goto L27
        L1f:
            boolean r4 = com.bytedance.sdk.component.utils.jl.qdl(r5)
            if (r4 != 0) goto L26
            goto L27
        L26:
            r0 = r1
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rq.mo.mo.qdl(int, java.lang.String, java.lang.String):boolean");
    }

    private JSONObject qdl(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }
}
