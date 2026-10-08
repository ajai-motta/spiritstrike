package com.bytedance.sdk.openadsdk.core.rq.mo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.bytedance.adsdk.ugeno.core.exu;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.core.jl;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.utils.gy;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mzz {
    private boolean bjy;
    private boolean exu;
    private final JSONObject fs;
    private final ljh jpc;
    private JSONArray jtx;
    private com.bytedance.adsdk.ugeno.ud.lnr lnr;
    private com.bytedance.adsdk.ugeno.ud.lnr mml;
    private com.bytedance.adsdk.ugeno.ud.lnr mzz;
    private boolean rdp;
    private JSONObject rq;
    private com.bytedance.sdk.openadsdk.core.widget.mzz to;
    private final String tvp;
    private final Context wd;
    private int qdl = -1;
    private int ud = -1;
    private final String mo = "UGenSwiperEvent";

    public mzz(Context context, ljh ljhVar, String str, JSONObject jSONObject) {
        this.wd = context;
        this.jpc = ljhVar;
        this.tvp = str;
        this.fs = jSONObject;
    }

    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVar) {
        com.bytedance.adsdk.ugeno.ud.lnr<T> lnrVarMzz = lnrVar.mzz("swiperLayout");
        this.mzz = lnrVarMzz;
        if (lnrVarMzz instanceof com.bytedance.adsdk.ugeno.lnr) {
            this.jtx = this.fs.optJSONArray("dpa_data");
            this.lnr = lnrVar.mzz("swiperLeftArrow");
            this.mml = lnrVar.mzz("swiperRightArrow");
            ((com.bytedance.adsdk.ugeno.lnr) this.mzz).qdl(new com.bytedance.adsdk.ugeno.mo.lnr() { // from class: com.bytedance.sdk.openadsdk.core.rq.mo.mzz.1
                @Override // com.bytedance.adsdk.ugeno.mo.lnr
                public void qdl(boolean z, int i) {
                }

                @Override // com.bytedance.adsdk.ugeno.mo.lnr
                public void qdl(boolean z, int i, float f, int i2) {
                }

                @Override // com.bytedance.adsdk.ugeno.mo.lnr
                public void qdl(boolean z, int i, int i2, boolean z2, boolean z3) {
                    mzz.this.ud = i;
                    mzz.this.qdl = i2;
                    mzz.this.exu = z;
                    mzz.this.rdp = z2;
                    mzz.this.bjy = z3;
                    mzz.this.qdl(z, z2, z3);
                    mzz.this.qdl(i);
                }
            });
        }
    }

    public void qdl() {
        qdl(this.exu, this.rdp, this.bjy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(boolean z, boolean z2, boolean z3) {
        com.bytedance.adsdk.ugeno.ud.lnr lnrVar = this.lnr;
        if (lnrVar == null || this.mml == null) {
            return;
        }
        View viewRq = lnrVar.rq();
        View viewRq2 = this.mml.rq();
        JSONArray jSONArray = this.jtx;
        if (jSONArray != null && jSONArray.length() == 1) {
            viewRq.setVisibility(8);
            viewRq2.setVisibility(8);
            return;
        }
        if (z) {
            return;
        }
        if (z2) {
            if (viewRq instanceof TextView) {
                qdl((TextView) viewRq, 90);
            }
            if (viewRq2 instanceof TextView) {
                qdl((TextView) viewRq2, 255);
                return;
            }
            return;
        }
        if (z3) {
            if (viewRq instanceof TextView) {
                qdl((TextView) viewRq, 255);
            }
            if (viewRq2 instanceof TextView) {
                qdl((TextView) viewRq2, 90);
                return;
            }
            return;
        }
        if (viewRq instanceof TextView) {
            qdl((TextView) viewRq, 255);
        }
        if (viewRq2 instanceof TextView) {
            qdl((TextView) viewRq2, 255);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(FirebaseAnalytics.Param.INDEX, i);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.mml.lnr.ud(this.jpc, this.tvp, "carousel_show", jSONObject);
    }

    private void qdl(TextView textView, int i) {
        int currentTextColor = textView.getCurrentTextColor();
        textView.setTextColor(Color.argb(i, Color.red(currentTextColor), Color.green(currentTextColor), Color.blue(currentTextColor)));
    }

    public void ud() {
        int i;
        com.bytedance.adsdk.ugeno.ud.lnr lnrVar = this.mzz;
        if (!(lnrVar instanceof com.bytedance.adsdk.ugeno.lnr) || (i = this.qdl) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.lnr) lnrVar).qdl(i - 1);
    }

    public void lnr() {
        int i;
        com.bytedance.adsdk.ugeno.ud.lnr lnrVar = this.mzz;
        if (!(lnrVar instanceof com.bytedance.adsdk.ugeno.lnr) || (i = this.qdl) == -1) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.lnr) lnrVar).qdl(i + 1);
    }

    public void qdl(com.bytedance.sdk.openadsdk.core.widget.mzz mzzVar) {
        this.to = mzzVar;
    }

    public boolean qdl(exu exuVar) {
        JSONObject jSONObjectOptJSONObject;
        this.rq = null;
        int i = this.ud;
        if (i != -1 && i != 0) {
            try {
                JSONObject jSONObjectLnr = exuVar.lnr();
                if (jSONObjectLnr != null && (jSONObjectOptJSONObject = jSONObjectLnr.optJSONObject("related_dpa_click")) != null) {
                    boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("enableOpenExternalUrl");
                    int iOptInt = jSONObjectOptJSONObject.optInt("landingStyle");
                    if (zOptBoolean && iOptInt != -1) {
                        if (this.jtx != null) {
                            String strQdl = com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObjectOptJSONObject.optString("url"), this.jtx.optJSONObject(this.ud));
                            String strQdl2 = com.bytedance.adsdk.ugeno.lnr.ud.qdl(jSONObjectOptJSONObject.optString("fallback_url"), this.jtx.optJSONObject(this.ud));
                            jSONObjectOptJSONObject.put("url", strQdl);
                            jSONObjectOptJSONObject.put("fallback_url", strQdl2);
                            qdl(jSONObjectOptJSONObject, this.jtx.optJSONObject(this.ud));
                        }
                        qdl(jSONObjectOptJSONObject, exuVar.qdl().rq());
                        return true;
                    }
                    return false;
                }
            } catch (Throwable th) {
                aaj.lnr("UGenSwiperEvent", th.getMessage());
            }
        }
        return false;
    }

    private void qdl(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("clickInfo");
        this.rq = jSONObjectOptJSONObject;
        if (jSONObjectOptJSONObject != null) {
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    this.rq.putOpt(next, com.bytedance.adsdk.ugeno.lnr.ud.qdl((String) this.rq.opt(next), jSONObject2));
                } catch (Throwable unused) {
                }
            }
            try {
                jSONObject.putOpt("clickInfo", this.rq);
            } catch (Throwable unused2) {
            }
        }
    }

    public JSONObject mml() {
        return this.rq;
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
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rq.mo.mzz.qdl(int, java.lang.String, java.lang.String):boolean");
    }

    private void qdl(JSONObject jSONObject, View view) {
        if (qdl(jSONObject.optInt("landingStyle"), jSONObject.optString("url"), jSONObject.optString("fallback_url"))) {
            jl.qdl(qdl(view), this.wd instanceof Activity, jSONObject, this.jpc, this.tvp, gy.qdl(this.tvp), null, this.to);
        }
    }

    private Context qdl(View view) {
        Activity activityQdl = view != null ? com.bytedance.sdk.component.utils.ud.qdl(view) : null;
        return activityQdl == null ? this.wd : activityQdl;
    }
}
