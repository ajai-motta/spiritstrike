package com.bytedance.sdk.openadsdk.core.rq.ud.mml;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.core.fs;
import com.bytedance.adsdk.ugeno.mml;
import com.bytedance.adsdk.ugeno.wd.lnr;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ud extends com.bytedance.adsdk.ugeno.ud.qdl<qdl> {
    private int dps;
    private JSONArray iw;
    private int lme;

    public ud(Context context) {
        super(context);
        this.dps = 0;
        this.lme = 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [T extends android.view.View, android.view.View] */
    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public View qdl() {
        try {
            this.mzz = new qdl(this.ud);
            ((qdl) this.mzz).qdl((mml) this);
        } catch (Throwable unused) {
            this.mzz = new View(this.ud);
        }
        return this.mzz;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public void qdl(String str, String str2) {
        super.qdl(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        switch (str) {
            case "driveMode":
                this.lme = lnr.qdl(str2, 0);
                break;
            case "direction":
                if (TextUtils.equals(str2, "vertical")) {
                    this.dps = 1;
                    break;
                } else {
                    this.dps = 0;
                    break;
                }
                break;
            case "dataList":
                this.iw = com.bytedance.adsdk.ugeno.wd.ud.qdl(str2, (JSONArray) null);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ud.qdl, com.bytedance.adsdk.ugeno.ud.lnr
    public void ud() {
        super.ud();
        if (this.mzz instanceof qdl) {
            ((qdl) this.mzz).setOrientation(this.dps);
            ((qdl) this.mzz).qdl(this);
            if (this.lme == 1) {
                mml();
            } else {
                lnr();
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ud.qdl
    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
        if (lnrVar == null) {
            return;
        }
        this.qdl.add(lnrVar);
    }

    @Override // com.bytedance.adsdk.ugeno.ud.qdl
    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar, ViewGroup.LayoutParams layoutParams) {
        if (lnrVar == null) {
            return;
        }
        this.qdl.add(lnrVar);
    }

    private void lnr() {
        if (this.qdl == null || this.qdl.isEmpty()) {
            return;
        }
        com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVar = this.qdl.get(0);
        if (this.iw == null) {
            return;
        }
        for (int i = 0; i < this.iw.length(); i++) {
            fs fsVar = new fs(this.ud);
            fsVar.qdl(this.zvv);
            try {
                JSONObject jSONObjectOptJSONObject = this.iw.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    if (jSONObjectOptJSONObject.has("$chunk")) {
                        this.mml.put("$item", jSONObjectOptJSONObject.optJSONArray("$chunk"));
                    } else {
                        this.mml.put("$item", jSONObjectOptJSONObject);
                    }
                    ((qdl) this.mzz).qdl(fsVar.qdl(lnrVar.rc(), this.mml, (JSONObject) null));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void mml() {
        for (int i = 0; i < this.qdl.size(); i++) {
            com.bytedance.adsdk.ugeno.ud.lnr<View> lnrVar = this.qdl.get(i);
            if (lnrVar != null) {
                fs fsVar = new fs(this.ud);
                fsVar.qdl(this.zvv);
                ((qdl) this.mzz).qdl(fsVar.qdl(lnrVar.rc(), this.mml, (JSONObject) null));
            }
        }
    }
}
