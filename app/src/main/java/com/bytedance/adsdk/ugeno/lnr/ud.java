package com.bytedance.adsdk.ugeno.lnr;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.lnr.qdl;
import com.bytedance.adsdk.ugeno.mzz;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ud {
    public static String qdl(String str, JSONObject jSONObject) {
        qdl qdlVarLnr;
        qdl.InterfaceC0183qdl interfaceC0183qdlQdl;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                return (!str.startsWith("${") || !str.endsWith("}") || (qdlVarLnr = mzz.qdl().lnr()) == null || (interfaceC0183qdlQdl = qdlVarLnr.qdl(str.substring(2, str.length() + (-1)))) == null) ? str : (String) interfaceC0183qdlQdl.qdl(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return str;
    }
}
