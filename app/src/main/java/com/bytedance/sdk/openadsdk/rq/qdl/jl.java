package com.bytedance.sdk.openadsdk.rq.qdl;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.mrf;
import com.facebook.appevents.AppEventsConstants;
import java.util.Arrays;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class jl extends com.bytedance.sdk.component.qdl.jl<JSONObject, JSONObject> {
    public static final HashSet<String> qdl = new HashSet<>(Arrays.asList("setStorageItem", "getStorageItem", "removeAllStorage", "removeStorageItem"));
    private ljh ud;

    public jl(ljh ljhVar) {
        this.ud = ljhVar;
    }

    public static void qdl(com.bytedance.sdk.component.qdl.bjy bjyVar, ljh ljhVar) {
        bjyVar.qdl(qdl, new jl(ljhVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.sdk.component.qdl.mml
    public JSONObject qdl(String str, JSONObject jSONObject, com.bytedance.sdk.component.qdl.mzz mzzVar) throws Exception {
        String strYot;
        ljh ljhVar = this.ud;
        if (ljhVar == null || (strYot = ljhVar.yot()) == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1166163208:
                if (str.equals("getStorageItem")) {
                    b = 0;
                }
                break;
            case 541948222:
                if (str.equals("removeAllStorage")) {
                    b = 1;
                }
                break;
            case 1357067884:
                if (str.equals("setStorageItem")) {
                    b = 2;
                }
                break;
            case 1498706186:
                if (str.equals("removeStorageItem")) {
                    b = 3;
                }
                break;
        }
        switch (b) {
            case 0:
                String strOptString = jSONObject.optString("key");
                if (!TextUtils.isEmpty(strOptString) && mrf.qdl().ud(strYot, strOptString)) {
                    jSONObject2.put("value", mrf.qdl().qdl(strYot, strOptString));
                    jSONObject2.put("code", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                } else {
                    jSONObject2.put("code", "1");
                }
                return jSONObject2;
            case 1:
                mrf.qdl().qdl(strYot);
                jSONObject2.put("code", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                return jSONObject2;
            case 2:
                String strOptString2 = jSONObject.optString("key");
                String strOptString3 = jSONObject.optString("value");
                if (strOptString2 != null) {
                    mrf.qdl().qdl(strYot, strOptString2, strOptString3);
                    jSONObject2.put("code", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                } else {
                    jSONObject2.put("code", "1");
                }
                return jSONObject2;
            case 3:
                String strOptString4 = jSONObject.optString("key");
                if (!TextUtils.isEmpty(strOptString4)) {
                    jSONObject2.put("code", mrf.qdl().lnr(strYot, strOptString4) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
                } else {
                    jSONObject2.put("code", "1");
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
