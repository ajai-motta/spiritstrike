package com.bytedance.sdk.component.adexpress.dynamic.mzz;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.ud.exu;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    private String jpc;
    private int mo;
    private double mzz;
    private exu tvp;
    private double wd;
    public Map<String, lnr> qdl = new HashMap();
    public Map<String, lnr> ud = new HashMap();
    public Map<String, lnr> lnr = new HashMap();
    private double mml = Math.random();

    public ud(double d, int i, double d2, String str, exu exuVar) {
        this.mzz = d;
        this.mo = i;
        this.wd = d2;
        this.jpc = str;
        this.tvp = exuVar;
    }

    public lnr qdl(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar, float f, float f2) {
        float f3;
        if (TextUtils.isEmpty(jpcVar.to().lnr()) && jpcVar.to().mzz().zy() == null) {
            return new lnr(0.0f, 0.0f);
        }
        if (TextUtils.equals(jpcVar.to().ud(), "creative-playable-bait")) {
            return new lnr(0.0f, 0.0f);
        }
        float fJpc = jpcVar.jpc();
        float fTvp = jpcVar.tvp();
        com.bytedance.sdk.component.adexpress.dynamic.mml.mo moVarMzz = jpcVar.to().mzz();
        String strKoa = moVarMzz.koa();
        String strBqt = moVarMzz.bqt();
        float fExu = jpcVar.exu();
        float fRdp = jpcVar.rdp();
        float fBjy = jpcVar.bjy();
        float fJtx = jpcVar.jtx();
        if (TextUtils.equals(strKoa, "fixed")) {
            f = Math.min(fJpc, f);
            if (TextUtils.equals(strBqt, "auto")) {
                f3 = ud(jpcVar, f - fBjy, f2 - fJtx).ud;
                fTvp = f3 + fJtx;
            }
        } else if (TextUtils.equals(strKoa, "auto")) {
            lnr lnrVarUd = ud(jpcVar, f - fBjy, f2 - fJtx);
            f = lnrVarUd.qdl + fBjy;
            if (TextUtils.equals(strBqt, "auto")) {
                f3 = lnrVarUd.ud;
                fTvp = f3 + fJtx;
            }
        } else if (!TextUtils.equals(strKoa, "flex")) {
            f = fJpc;
        } else if (TextUtils.equals(strBqt, "auto")) {
            f3 = ud(jpcVar, f - fBjy, f2 - fJtx).ud;
            fTvp = f3 + fJtx;
        }
        if (TextUtils.equals(strBqt, "scale")) {
            float fRound = Math.round((f - fExu) / fTvp) + fRdp;
            if (fRound > f2) {
                f = Math.round((f2 - fRdp) * fTvp) + fExu;
            } else {
                f2 = fRound;
            }
        } else if (TextUtils.equals(strBqt, "fixed")) {
            f2 = Math.min(fTvp + fRdp, f2);
        } else if (!TextUtils.equals(strBqt, "flex")) {
            f2 = fTvp;
        }
        lnr lnrVar = new lnr();
        lnrVar.qdl = f;
        lnrVar.ud = f2;
        return lnrVar;
    }

    public lnr ud(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar, float f, float f2) {
        lnr lnrVar = new lnr();
        if (jpcVar.to().mzz() == null) {
            return lnrVar;
        }
        lnr lnrVarMzz = mzz(jpcVar, f, f2);
        float f3 = lnrVarMzz.qdl;
        float f4 = lnrVarMzz.ud;
        lnrVar.qdl = Math.min(f3, f);
        lnrVar.ud = Math.min(f4, f2);
        return lnrVar;
    }

    private lnr mzz(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar, float f, float f2) {
        String str = jpcVar.lnr() + "_" + f + "_" + f2;
        if (this.lnr.containsKey(str)) {
            return this.lnr.get(str);
        }
        lnr lnrVarMo = mo(jpcVar, f, f2);
        this.lnr.put(str, lnrVarMo);
        return lnrVarMo;
    }

    private lnr mo(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar, float f, float f2) {
        new lnr();
        com.bytedance.sdk.component.adexpress.dynamic.mml.mo moVarMzz = jpcVar.to().mzz();
        jpcVar.to().lnr();
        moVarMzz.zlt();
        float fJl = moVarMzz.jl();
        int iJjk = moVarMzz.jjk();
        double dXi = moVarMzz.xi();
        int iTaz = moVarMzz.taz();
        boolean zOm = moVarMzz.om();
        boolean zTid = moVarMzz.tid();
        int iCx = moVarMzz.cx();
        C0194ud c0194ud = new C0194ud();
        c0194ud.qdl = fJl;
        c0194ud.ud = iJjk;
        c0194ud.lnr = iTaz;
        c0194ud.mml = dXi;
        c0194ud.mzz = f;
        return qdl(jpcVar.to().lnr(), c0194ud, zOm, zTid, iCx, jpcVar);
    }

    private lnr qdl(String str, C0194ud c0194ud, boolean z, boolean z2, int i, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        return rq.qdl(str, jpcVar.to().ud(), C0194ud.qdl(c0194ud).toString(), z, z2, i, jpcVar, this.mzz, this.mo, this.wd, this.jpc, this.tvp);
    }

    public lnr lnr(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar, float f, float f2) {
        if (jpcVar == null) {
            return null;
        }
        lnr lnrVarQdl = qdl(jpcVar);
        if (lnrVarQdl != null && (lnrVarQdl.qdl != 0.0f || lnrVarQdl.ud != 0.0f)) {
            return lnrVarQdl;
        }
        lnr lnrVarMml = mml(jpcVar, f, f2);
        qdl(jpcVar, lnrVarMml);
        return lnrVarMml;
    }

    public lnr mml(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar, float f, float f2) {
        float fMin;
        lnr lnrVar = new lnr();
        float f3 = 0.0f;
        if (f2 <= 0.0f || f <= 0.0f) {
            lnrVar.qdl = 0.0f;
            lnrVar.ud = 0.0f;
            return lnrVar;
        }
        if (jpcVar.jl()) {
            return qdl(jpcVar, f, f2);
        }
        float fJpc = jpcVar.jpc();
        float fTvp = jpcVar.tvp();
        float fBjy = jpcVar.bjy();
        float fJtx = jpcVar.jtx();
        com.bytedance.sdk.component.adexpress.dynamic.mml.mo moVarMzz = jpcVar.to().mzz();
        String strKoa = moVarMzz.koa();
        String strBqt = moVarMzz.bqt();
        float fMin2 = ((TextUtils.equals(strKoa, "flex") || TextUtils.equals(strKoa, "auto")) ? f : Math.min(fJpc, f)) - fBjy;
        if (TextUtils.equals(strBqt, "scale")) {
            fMin = Math.round(fMin2 / fTvp) + fJtx;
            if (fMin > f2) {
                fMin2 = Math.round((f2 - fJtx) * fTvp);
            }
        } else {
            fMin = (TextUtils.equals(strBqt, "auto") || TextUtils.equals(strBqt, "flex")) ? f2 : Math.min(fTvp, f2);
        }
        float f4 = fMin - fJtx;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> listYt = jpcVar.yt();
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> it = listYt.iterator();
        float fMax = 0.0f;
        float fMax2 = 0.0f;
        while (it.hasNext()) {
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> it2 = it;
            List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> next = it.next();
            lnr lnrVar2 = lnrVar;
            lnr lnrVarUd = ud(next, fMin2, f4);
            if (ud(next)) {
                f3 += 1.0f;
            } else {
                fMax = Math.max(fMax, lnrVarUd.qdl);
            }
            float f5 = f3;
            if (jpcVar.to().ud().equals("carousel")) {
                fMax2 = Math.max(jpcVar.tvp(), lnrVarUd.ud);
            } else {
                fMax2 += lnrVarUd.ud;
            }
            lnrVar = lnrVar2;
            it = it2;
            f3 = f5;
        }
        lnr lnrVar3 = lnrVar;
        if (TextUtils.equals(strKoa, "auto")) {
            if (f3 == listYt.size()) {
                fMin2 = f;
            } else {
                for (List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list : listYt) {
                    lnr(list);
                    ud(list, fMax, f4);
                }
                fMin2 = fMax;
            }
        }
        if (TextUtils.equals(strBqt, "auto")) {
            if (fMax2 <= f2) {
                f4 = fMax2;
            } else {
                qdl(listYt, fMin2, f4);
            }
        } else if ((TextUtils.equals(strBqt, "fixed") || TextUtils.equals(strBqt, "flex")) && f4 < fMax2) {
            qdl(listYt, fMin2, f4);
        }
        lnrVar3.qdl = Math.min(fMin2 + fBjy, f);
        lnrVar3.ud = Math.min(f4 + fJtx, f2);
        return lnrVar3;
    }

    private void qdl(List<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> list, float f, float f2) {
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (qdl(it.next(), false)) {
                z = true;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list2 : list) {
            qdl qdlVar = new qdl();
            boolean zQdl = qdl(list2, !z);
            qdlVar.qdl = zQdl ? 1.0f : ud(list2, f, f2).ud;
            qdlVar.ud = !zQdl;
            arrayList.add(qdlVar);
        }
        List<qdl> listQdl = to.qdl(f2, arrayList);
        for (int i = 0; i < list.size(); i++) {
            if (((qdl) arrayList.get(i)).qdl != listQdl.get(i).qdl) {
                List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list3 = list.get(i);
                lnr(list3);
                ud(list3, f, listQdl.get(i).qdl);
            }
        }
    }

    private boolean ud(List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> listYt;
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().to().mzz().koa(), "flex")) {
                return true;
            }
        }
        while (true) {
            boolean z = false;
            for (com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar : list) {
                if (TextUtils.equals(jpcVar.to().mzz().koa(), "auto") && (listYt = jpcVar.yt()) != null) {
                    int i = 0;
                    for (List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list2 : listYt) {
                        i++;
                        if (!ud(list2)) {
                            break;
                        }
                        if (i == list2.size()) {
                            z = true;
                        }
                    }
                }
            }
            return z;
        }
    }

    private lnr ud(List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list, float f, float f2) {
        lnr lnrVarQdl = qdl(list);
        if (lnrVarQdl != null && (lnrVarQdl.qdl != 0.0f || lnrVarQdl.ud != 0.0f)) {
            return lnrVarQdl;
        }
        lnr lnrVarLnr = lnr(list, f, f2);
        qdl(list, lnrVarLnr);
        return lnrVarLnr;
    }

    private lnr lnr(List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list, float f, float f2) {
        float fMax;
        mml(list);
        lnr lnrVar = new lnr();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.mml.mo moVarMzz = jpcVar.to().mzz();
            if (moVarMzz.sy() == 1 || moVarMzz.sy() == 2) {
                arrayList.add(jpcVar);
            }
            if (moVarMzz.sy() != 1 && moVarMzz.sy() != 2) {
                arrayList2.add(jpcVar);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            lnr((com.bytedance.sdk.component.adexpress.dynamic.mml.jpc) it.next(), f, f2);
        }
        if (arrayList2.size() <= 0) {
            return lnrVar;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(Float.valueOf(lnr(it2.next(), f, f2).qdl));
        }
        ArrayList arrayList4 = new ArrayList();
        int i = 0;
        while (true) {
            if (i >= arrayList2.size()) {
                break;
            }
            com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar2 = arrayList2.get(i);
            String strKoa = jpcVar2.to().mzz().koa();
            float fJpc = jpcVar2.jpc();
            boolean zEquals = TextUtils.equals(strKoa, "flex");
            if (TextUtils.equals(strKoa, "auto")) {
                List<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> listYt = jpcVar2.yt();
                if (listYt == null || listYt.size() <= 0) {
                    zEquals = false;
                } else {
                    Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> it3 = listYt.iterator();
                    while (it3.hasNext()) {
                        if (ud(it3.next())) {
                            zEquals = true;
                            break;
                        }
                    }
                    zEquals = false;
                }
            }
            qdl qdlVar = new qdl();
            if (!zEquals) {
                fJpc = ((Float) arrayList3.get(i)).floatValue();
            }
            qdlVar.qdl = fJpc;
            qdlVar.ud = !zEquals;
            if (zEquals) {
                fMax = ((Float) arrayList3.get(i)).floatValue();
            }
            qdlVar.lnr = fMax;
            arrayList4.add(qdlVar);
            i++;
        }
        qdl(arrayList4, f, arrayList2);
        List<qdl> listQdl = to.qdl(f, arrayList4);
        float f3 = 0.0f;
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            f3 += listQdl.get(i2).qdl;
            if (((Float) arrayList3.get(i2)).floatValue() != listQdl.get(i2).qdl) {
                mml(arrayList2.get(i2));
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> it4 = arrayList2.iterator();
        int i3 = 0;
        boolean z = false;
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            i3++;
            if (!ud(it4.next())) {
                z = false;
                break;
            }
            if (i3 == arrayList2.size()) {
                z = true;
            }
        }
        fMax = z ? f2 : 0.0f;
        ArrayList arrayList5 = new ArrayList();
        for (int i4 = 0; i4 < arrayList2.size(); i4++) {
            com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar3 = arrayList2.get(i4);
            lnr lnrVarLnr = lnr(jpcVar3, listQdl.get(i4).qdl, f2);
            if (!ud(jpcVar3)) {
                fMax = Math.max(fMax, lnrVarLnr.ud);
            }
            arrayList5.add(lnrVarLnr);
        }
        ArrayList arrayList6 = new ArrayList();
        Iterator it5 = arrayList5.iterator();
        while (it5.hasNext()) {
            arrayList6.add(Float.valueOf(((lnr) it5.next()).ud));
        }
        if (!z) {
            for (int i5 = 0; i5 < arrayList2.size(); i5++) {
                com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar4 = arrayList2.get(i5);
                if (ud(jpcVar4) && ((Float) arrayList6.get(i5)).floatValue() != fMax) {
                    mml(jpcVar4);
                    lnr(jpcVar4, listQdl.get(i5).qdl, fMax);
                }
            }
        }
        lnrVar.qdl = f3;
        lnrVar.ud = fMax;
        return lnrVar;
    }

    private boolean ud(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        if (jpcVar == null) {
            return false;
        }
        if (TextUtils.equals(jpcVar.to().mzz().bqt(), "flex")) {
            return true;
        }
        return lnr(jpcVar);
    }

    private boolean lnr(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        List<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> listYt;
        if (!jpcVar.jl() && TextUtils.equals(jpcVar.to().mzz().bqt(), "auto") && (listYt = jpcVar.yt()) != null && listYt.size() > 0) {
            if (listYt.size() == 1) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> it = listYt.get(0).iterator();
                while (it.hasNext()) {
                    if (!ud(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> it2 = listYt.iterator();
            while (it2.hasNext()) {
                if (qdl(it2.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean qdl(List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list, boolean z) {
        for (com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar : list) {
            com.bytedance.sdk.component.adexpress.dynamic.mml.mo moVarMzz = jpcVar.to().mzz();
            String strBqt = moVarMzz.bqt();
            if (TextUtils.equals(strBqt, "flex") || (z && ((TextUtils.equals(moVarMzz.koa(), "flex") && TextUtils.equals(moVarMzz.bqt(), "scale") && com.bytedance.sdk.component.adexpress.dynamic.mml.mzz.qdl.get(jpcVar.to().ud()).intValue() == 7) || TextUtils.equals(strBqt, "flex")))) {
                return true;
            }
        }
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> it = list.iterator();
        while (it.hasNext()) {
            if (lnr(it.next())) {
                return true;
            }
        }
        return false;
    }

    private void qdl(List<qdl> list, float f, List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list2) {
        float f2 = 0.0f;
        for (qdl qdlVar : list) {
            if (qdlVar.ud) {
                f2 += qdlVar.qdl;
            }
        }
        if (f2 > f) {
            int i = 0;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (list.get(i2).ud && list2.get(i2).oth()) {
                    i++;
                }
            }
            if (i > 0) {
                float fCeil = (float) (Math.ceil(((f2 - f) / i) * 1000.0f) / 1000.0d);
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    qdl qdlVar2 = list.get(i3);
                    if (qdlVar2.ud && list2.get(i3).oth()) {
                        qdlVar2.qdl -= fCeil;
                    }
                }
            }
        }
    }

    public void qdl() {
        this.lnr.clear();
        this.qdl.clear();
        this.ud.clear();
    }

    public lnr qdl(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        return this.qdl.get(mzz(jpcVar));
    }

    public lnr qdl(List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list) {
        return this.ud.get(mml(list));
    }

    private void mml(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        this.qdl.remove(mzz(jpcVar));
        List<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> listYt = jpcVar.yt();
        if (listYt == null || listYt.size() <= 0) {
            return;
        }
        Iterator<List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc>> it = listYt.iterator();
        while (it.hasNext()) {
            lnr(it.next());
        }
    }

    private void lnr(List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.ud.remove(mml(list));
        Iterator<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> it = list.iterator();
        while (it.hasNext()) {
            mml(it.next());
        }
    }

    private String mzz(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        return jpcVar.lnr();
    }

    private String mml(List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String strLnr = list.get(i).lnr();
            if (i < list.size() - 1) {
                sb.append(strLnr);
                sb.append("-");
            } else {
                sb.append(strLnr);
            }
        }
        return sb.toString();
    }

    private void qdl(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar, lnr lnrVar) {
        this.qdl.put(mzz(jpcVar), lnrVar);
    }

    private void qdl(List<com.bytedance.sdk.component.adexpress.dynamic.mml.jpc> list, lnr lnrVar) {
        this.ud.put(mml(list), lnrVar);
    }

    static class lnr {
        float qdl;
        float ud;

        public lnr() {
        }

        public lnr(float f, float f2) {
            this.qdl = f;
            this.ud = f2;
        }

        public String toString() {
            return "UnitSize{width=" + this.qdl + ", height=" + this.ud + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.adexpress.dynamic.mzz.ud$ud, reason: collision with other inner class name */
    static class C0194ud {
        int lnr;
        double mml;
        float mzz;
        float qdl;
        int ud;

        C0194ud() {
        }

        static JSONObject qdl(C0194ud c0194ud) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_SIZE, c0194ud.qdl);
                jSONObject.put("letterSpacing", c0194ud.ud);
                jSONObject.put("lineHeight", c0194ud.mml);
                jSONObject.put("maxWidth", c0194ud.mzz);
                jSONObject.put(TtmlNode.ATTR_TTS_FONT_WEIGHT, c0194ud.lnr);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    static class qdl implements Cloneable {
        float lnr;
        float qdl;
        boolean ud;

        qdl() {
        }

        public Object clone() {
            try {
                return (qdl) super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }
    }
}
