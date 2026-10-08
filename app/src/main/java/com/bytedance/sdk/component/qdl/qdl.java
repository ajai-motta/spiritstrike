package com.bytedance.sdk.component.qdl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.qdl.mo;
import com.facebook.internal.NativeProtocol;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class qdl {
    protected wd lnr;
    protected String mzz;
    protected Context qdl;
    protected rq ud;
    mo wd;
    protected Handler mml = new Handler(Looper.getMainLooper());
    protected volatile boolean mo = false;
    private final Map<String, mo> jpc = new HashMap();

    protected abstract Context qdl(tvp tvpVar);

    protected abstract String qdl();

    protected abstract void qdl(String str);

    protected abstract void ud(tvp tvpVar);

    protected qdl() {
    }

    protected void invokeMethod(final String str) {
        if (this.mo) {
            return;
        }
        this.mml.post(new Runnable() { // from class: com.bytedance.sdk.component.qdl.qdl.1
            @Override // java.lang.Runnable
            public void run() {
                rdp rdpVarQdl;
                if (qdl.this.mo) {
                    return;
                }
                try {
                    rdpVarQdl = qdl.this.qdl(new JSONObject(str));
                } catch (Exception unused) {
                    rdpVarQdl = null;
                }
                if (rdp.qdl(rdpVarQdl)) {
                    Objects.toString(rdpVarQdl);
                    if (rdpVarQdl != null) {
                        qdl.this.ud(exc.qdl(new jtx(rdpVarQdl.qdl, "Failed to parse invocation.")), rdpVarQdl);
                        return;
                    }
                    return;
                }
                qdl.this.qdl(rdpVarQdl);
            }
        });
    }

    protected void qdl(String str, rdp rdpVar) {
        qdl(str);
    }

    protected void ud() {
        this.wd.qdl();
        Iterator<mo> it = this.jpc.values().iterator();
        while (it.hasNext()) {
            it.next().qdl();
        }
        this.mml.removeCallbacksAndMessages(null);
        this.mo = true;
    }

    protected final void qdl(rdp rdpVar) {
        String strQdl;
        if (this.mo || (strQdl = qdl()) == null) {
            return;
        }
        mo moVarUd = ud(rdpVar.wd);
        if (moVarUd == null) {
            Objects.toString(rdpVar);
            if (this.ud != null) {
                qdl();
            }
            ud(exc.qdl(new jtx(-4, "Namespace " + rdpVar.wd + " unknown.")), rdpVar);
            return;
        }
        mzz mzzVar = new mzz();
        mzzVar.ud = strQdl;
        mzzVar.qdl = this.qdl;
        mzzVar.lnr = moVarUd;
        try {
            mo.qdl qdlVarQdl = moVarUd.qdl(rdpVar, mzzVar);
            if (qdlVarQdl == null) {
                Objects.toString(rdpVar);
                if (this.ud != null) {
                    qdl();
                }
                ud(exc.qdl(new jtx(-2, "Function " + rdpVar.mml + " is not registered.")), rdpVar);
                return;
            }
            if (qdlVarQdl.qdl) {
                ud(qdlVarQdl.ud, rdpVar);
            }
            if (this.ud != null) {
                qdl();
            }
        } catch (Exception e) {
            Objects.toString(rdpVar);
            ud(exc.qdl(e), rdpVar);
        }
    }

    final void lnr(tvp tvpVar) {
        this.qdl = qdl(tvpVar);
        this.lnr = tvpVar.mml;
        this.ud = tvpVar.jpc;
        this.wd = new mo(tvpVar, this);
        this.mzz = tvpVar.to;
        ud(tvpVar);
    }

    final void ud(String str, rdp rdpVar) {
        JSONObject jSONObject;
        if (this.mo || TextUtils.isEmpty(rdpVar.mo)) {
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            jpc.qdl(new IllegalArgumentException("Illegal callback data: ".concat(String.valueOf(str))));
        }
        String str2 = rdpVar.mo;
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        qdl(exu.qdl().qdl("__msg_type", "callback").qdl("__callback_id", rdpVar.mo).qdl("__params", jSONObject).ud(), rdpVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public rdp qdl(JSONObject jSONObject) {
        String strOptString;
        if (this.mo) {
            return null;
        }
        String strOptString2 = jSONObject.optString("__callback_id");
        String strOptString3 = jSONObject.optString("func");
        if (qdl() == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String strValueOf = "";
            try {
                Object objOpt = jSONObject.opt(NativeProtocol.WEB_DIALOG_PARAMS);
                if (objOpt == null) {
                    strOptString = strValueOf;
                } else if (objOpt instanceof JSONObject) {
                    strOptString = String.valueOf((JSONObject) objOpt);
                } else {
                    if (objOpt instanceof String) {
                        strValueOf = (String) objOpt;
                    } else {
                        strValueOf = String.valueOf(objOpt);
                    }
                    strOptString = strValueOf;
                }
            } catch (Throwable unused) {
                strOptString = jSONObject.optString(NativeProtocol.WEB_DIALOG_PARAMS);
            }
            String string2 = jSONObject.getString("JSSDK");
            String strOptString4 = jSONObject.optString("namespace");
            return rdp.qdl().qdl(string2).ud(string).lnr(strOptString3).mml(strOptString).mzz(strOptString2).mo(strOptString4).wd(jSONObject.optString("__iframe_url")).qdl();
        } catch (JSONException unused2) {
            return rdp.qdl(strOptString2, -1);
        }
    }

    private mo ud(String str) {
        if (TextUtils.equals(str, this.mzz) || TextUtils.isEmpty(str)) {
            return this.wd;
        }
        return this.jpc.get(str);
    }
}
