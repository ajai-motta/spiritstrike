package com.bytedance.sdk.openadsdk.core.fs.qdl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.fs.ud.lnr;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.facebook.internal.NativeProtocol;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ud {
    protected int lnr;
    protected double mml;
    public qdl mo;
    public int mzz;
    public int qdl;
    protected final Context ud;

    public static class qdl {
        public boolean lnr;
        public int qdl;
        public int ud;
    }

    public abstract com.bytedance.sdk.openadsdk.core.fs.qdl qdl(String str, File file, List<lnr> list);

    public ud(Context context, int i, int i2) {
        this.lnr = 0;
        this.mml = 0.0d;
        if (i2 > 0 && i > 0) {
            this.mml = ((double) i) / ((double) i2);
        }
        float fJpc = ax.jpc(context);
        if (fJpc != 0.0f && i > 0) {
            this.lnr = (int) (i / fJpc);
        }
        this.ud = context.getApplicationContext();
    }

    protected void qdl(Exception exc, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("exception", exc.getMessage());
            jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, i);
            com.bytedance.sdk.openadsdk.bjy.lnr.qdl().qdl("load_vast", jSONObject);
        } catch (Exception unused) {
        }
    }

    protected boolean qdl(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return Integer.parseInt(str) < 2;
        } catch (NumberFormatException unused) {
            return true;
        }
    }

    protected String qdl(String str, List<lnr> list) {
        int i = this.qdl;
        String strMml = null;
        if (i >= 5) {
            return null;
        }
        this.qdl = i + 1;
        if (str == null) {
            return null;
        }
        try {
            com.bytedance.sdk.component.wd.ud.ud udVarLnr = com.bytedance.sdk.openadsdk.jl.ud.ud().lnr().lnr();
            udVarLnr.ud(str);
            com.bytedance.sdk.component.wd.ud udVarQdl = udVarLnr.qdl();
            strMml = udVarQdl.mml();
            udVarQdl.qdl();
            return strMml;
        } catch (Exception e) {
            qdl(e, 0);
            if (list.isEmpty()) {
                return strMml;
            }
            lnr.ud((ljh) null, list, com.bytedance.sdk.openadsdk.core.fs.qdl.qdl.WRAPPER_TIMEOUT, -1L, (String) null, (String) null);
            return strMml;
        }
    }
}
