package com.bytedance.sdk.component.adexpress.dynamic.mzz;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.component.adexpress.dynamic.mzz.ud;
import com.bytedance.sdk.component.adexpress.ud.exu;
import com.facebook.appevents.AppEventsConstants;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class mzz {
    private com.bytedance.sdk.component.adexpress.dynamic.mml.jpc lnr;
    private qdl mml;
    public com.bytedance.sdk.component.adexpress.dynamic.mml.ud qdl;
    protected ud ud;

    static class qdl {
        float lnr;
        float qdl;
        float ud;

        qdl() {
        }
    }

    public mzz(double d, int i, double d2, String str, exu exuVar) {
        this.ud = new ud(d, i, d2, str, exuVar);
    }

    public void qdl(qdl qdlVar) {
        this.mml = qdlVar;
    }

    public void qdl() {
        this.ud.qdl();
    }

    public void qdl(com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar, float f, float f2) {
        if (jpcVar != null) {
            this.lnr = jpcVar;
        }
        com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar2 = this.lnr;
        float fJpc = jpcVar2.jpc();
        float fTvp = jpcVar2.tvp();
        float f3 = TextUtils.equals(jpcVar2.to().mzz().bqt(), "fixed") ? fTvp : 65536.0f;
        this.ud.qdl();
        this.ud.lnr(jpcVar2, fJpc, f3);
        ud.lnr lnrVarQdl = this.ud.qdl(jpcVar2);
        com.bytedance.sdk.component.adexpress.dynamic.mml.ud udVar = new com.bytedance.sdk.component.adexpress.dynamic.mml.ud();
        udVar.qdl = f;
        udVar.ud = f2;
        if (lnrVarQdl != null) {
            fJpc = lnrVarQdl.qdl;
        }
        udVar.lnr = fJpc;
        if (lnrVarQdl != null) {
            fTvp = lnrVarQdl.ud;
        }
        udVar.mml = fTvp;
        udVar.mzz = "root";
        udVar.tvp = 1280.0f;
        udVar.mo = jpcVar2;
        udVar.mo.lnr(udVar.qdl);
        udVar.mo.mml(udVar.ud);
        udVar.mo.mzz(udVar.lnr);
        udVar.mo.mo(udVar.mml);
        com.bytedance.sdk.component.adexpress.dynamic.mml.ud udVarQdl = qdl(udVar, 0.0f);
        this.qdl = udVarQdl;
        qdl(udVarQdl);
    }

    public void qdl(com.bytedance.sdk.component.adexpress.dynamic.mml.ud udVar) {
        if (udVar == null) {
            return;
        }
        udVar.mo.to().ud();
        float f = udVar.lnr;
        float f2 = udVar.mml;
        float f3 = udVar.qdl;
        float f4 = udVar.ud;
        List<List<com.bytedance.sdk.component.adexpress.dynamic.mml.ud>> list = udVar.wd;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (List<com.bytedance.sdk.component.adexpress.dynamic.mml.ud> list2 : list) {
            if (list2 != null && list2.size() > 0) {
                Iterator<com.bytedance.sdk.component.adexpress.dynamic.mml.ud> it = list2.iterator();
                while (it.hasNext()) {
                    qdl(it.next());
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.adexpress.dynamic.mml.ud qdl(com.bytedance.sdk.component.adexpress.dynamic.mml.ud r37, float r38) {
        /*
            Method dump skipped, instruction units count: 1000
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.mzz.mzz.qdl(com.bytedance.sdk.component.adexpress.dynamic.mml.ud, float):com.bytedance.sdk.component.adexpress.dynamic.mml.ud");
    }

    private com.bytedance.sdk.component.adexpress.dynamic.mml.tvp qdl(com.bytedance.sdk.component.adexpress.dynamic.mml.mo moVar, ud.lnr lnrVar, ud.lnr lnrVar2) {
        float fTqd = moVar.tqd();
        float fLq = moVar.lq();
        float fFzn = moVar.fzn();
        float fGg = moVar.gg();
        boolean zMlb = moVar.mlb();
        boolean zLte = moVar.lte();
        boolean zDk = moVar.dk();
        boolean zIjp = moVar.ijp();
        if (!zMlb) {
            if (zLte) {
                fTqd = ((this.mml.qdl != 0.0f ? Math.min(this.mml.qdl, lnrVar.qdl) : lnrVar.qdl) - fFzn) - lnrVar2.qdl;
            } else {
                fTqd = 0.0f;
            }
        }
        if (!zDk) {
            if (zIjp) {
                fLq = ((this.mml.ud != 0.0f ? this.mml.ud : lnrVar.ud) - fGg) - lnrVar2.ud;
            } else {
                fLq = 0.0f;
            }
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.mml.tvp(fTqd, fLq);
    }

    private com.bytedance.sdk.component.adexpress.dynamic.mml.tvp qdl(com.bytedance.sdk.component.adexpress.dynamic.mml.ud udVar, com.bytedance.sdk.component.adexpress.dynamic.mml.mo moVar, float f, float f2) {
        float f3;
        float f4;
        float f5 = udVar.qdl;
        float f6 = udVar.ud;
        float fTqd = moVar.tqd();
        float fLq = moVar.lq();
        float fFzn = moVar.fzn();
        float fGg = moVar.gg();
        boolean zMlb = moVar.mlb();
        boolean zLte = moVar.lte();
        boolean zDk = moVar.dk();
        boolean zIjp = moVar.ijp();
        String strCar = moVar.car();
        float f7 = udVar.lnr;
        float f8 = udVar.mml;
        if (TextUtils.equals(strCar, AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            if (zMlb) {
                f5 = udVar.qdl + fTqd;
            } else if (zLte) {
                f5 = ((udVar.qdl + f7) - fFzn) - f;
            }
            if (zDk) {
                f4 = udVar.ud;
                f6 = f4 + fLq;
            } else if (zIjp) {
                f3 = udVar.ud;
                f6 = ((f3 + f8) - fGg) - f2;
            }
        } else if (TextUtils.equals(strCar, "1")) {
            f5 = udVar.qdl + ((f7 - f) / 2.0f);
            if (zDk) {
                f4 = udVar.ud;
                f6 = f4 + fLq;
            } else if (zIjp) {
                f3 = udVar.ud;
                f6 = ((f3 + f8) - fGg) - f2;
            }
        } else if (TextUtils.equals(strCar, "2")) {
            f6 = udVar.ud + ((f8 - f2) / 2.0f);
            if (zMlb) {
                f5 = udVar.qdl + fTqd;
            } else if (zLte) {
                f5 = ((udVar.qdl + f7) - fFzn) - f;
            }
        } else if (TextUtils.equals(strCar, ExifInterface.GPS_MEASUREMENT_3D)) {
            f5 = udVar.qdl + ((f7 - f) / 2.0f);
            f6 = udVar.ud + ((f8 - f2) / 2.0f);
        }
        return new com.bytedance.sdk.component.adexpress.dynamic.mml.tvp(f5, f6);
    }
}
