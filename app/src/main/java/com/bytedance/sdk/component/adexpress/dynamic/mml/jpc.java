package com.bytedance.sdk.component.adexpress.dynamic.mml;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class jpc {
    private String exu;
    private List<List<jpc>> fs;
    private float jpc;
    private float lnr;
    private float mml;
    private float mo;
    private float mzz;
    private String qdl;
    private boolean rdp;
    private jpc rq;
    private List<jpc> to;
    private mzz tvp;
    private float ud;
    private float wd;
    private Map<String, String> bjy = new HashMap();
    private Map<Integer, String> jtx = new HashMap();

    public String qdl() {
        return this.exu;
    }

    public void qdl(String str) {
        this.exu = str;
    }

    public Map<Integer, String> ud() {
        return this.jtx;
    }

    public void qdl(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    this.jtx.put(Integer.valueOf(jSONObjectOptJSONObject.optInt("id")), jSONObjectOptJSONObject.optString("value"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String lnr() {
        return this.qdl;
    }

    public void ud(String str) {
        this.qdl = str;
    }

    public float mml() {
        return this.mml;
    }

    public void qdl(float f) {
        this.mml = f;
    }

    public float mzz() {
        return this.mzz;
    }

    public void ud(float f) {
        this.mzz = f;
    }

    public float mo() {
        return this.ud;
    }

    public void lnr(float f) {
        this.ud = f;
    }

    public float wd() {
        return this.lnr;
    }

    public void mml(float f) {
        this.lnr = f;
    }

    public float jpc() {
        return this.mo;
    }

    public void mzz(float f) {
        this.mo = f;
    }

    public float tvp() {
        return this.wd;
    }

    public void mo(float f) {
        this.wd = f;
    }

    public void wd(float f) {
        this.jpc = f;
    }

    public mzz to() {
        return this.tvp;
    }

    public void qdl(mzz mzzVar) {
        this.tvp = mzzVar;
    }

    public List<jpc> rq() {
        return this.to;
    }

    public void qdl(List<jpc> list) {
        this.to = list;
    }

    public void qdl(jpc jpcVar) {
        this.rq = jpcVar;
    }

    public jpc fs() {
        return this.rq;
    }

    public int exu() {
        mo moVarMzz = this.tvp.mzz();
        return moVarMzz.gt() + moVarMzz.irn();
    }

    public int rdp() {
        mo moVarMzz = this.tvp.mzz();
        return moVarMzz.yh() + moVarMzz.wak();
    }

    public float bjy() {
        mo moVarMzz = this.tvp.mzz();
        return exu() + moVarMzz.bjy() + moVarMzz.jtx() + (moVarMzz.fs() * 2.0f);
    }

    public float jtx() {
        mo moVarMzz = this.tvp.mzz();
        return rdp() + moVarMzz.yt() + moVarMzz.rdp() + (moVarMzz.fs() * 2.0f);
    }

    public void ud(List<List<jpc>> list) {
        this.fs = list;
    }

    public List<List<jpc>> yt() {
        return this.fs;
    }

    public boolean jl() {
        List<jpc> list = this.to;
        return list == null || list.size() <= 0;
    }

    public boolean exc() {
        return this.rdp;
    }

    public void qdl(boolean z) {
        this.rdp = z;
    }

    public Map<String, String> aaj() {
        return this.bjy;
    }

    public void qdl(String str, String str2) {
        this.bjy.put(str, str2);
    }

    public void jyq() {
        List<List<jpc>> list = this.fs;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<jpc> list2 : this.fs) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.fs = arrayList;
    }

    public boolean oth() {
        return TextUtils.equals(this.tvp.mzz().koa(), "flex");
    }

    public String ljh() {
        return this.tvp.mzz().ljh();
    }

    public void lnr(String str) {
        this.tvp.mzz().mo(str);
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.qdl + "', x=" + this.ud + ", y=" + this.lnr + ", width=" + this.mo + ", height=" + this.wd + ", remainWidth=" + this.jpc + ", rootBrick=" + this.tvp + ", childrenBrickUnits=" + this.to + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean bch() {
        return this.tvp.mzz().lq() < 0 || this.tvp.mzz().gg() < 0 || this.tvp.mzz().tqd() < 0 || this.tvp.mzz().fzn() < 0;
    }

    public String qdl(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tvp.ud());
        sb.append(":");
        sb.append(this.qdl);
        if (this.tvp.mzz() != null) {
            sb.append(":");
            sb.append(this.tvp.mzz().syy());
        }
        sb.append(":");
        sb.append(i);
        return sb.toString();
    }
}
