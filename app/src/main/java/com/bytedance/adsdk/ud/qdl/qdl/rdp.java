package com.bytedance.adsdk.ud.qdl.qdl;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.ud.lnr.ud.exc;
import com.bytedance.adsdk.ud.lnr.ud.to;
import com.bytedance.adsdk.ud.qdl.ud.qdl;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class rdp implements exu, rq, qdl.InterfaceC0180qdl {
    private boolean bjy;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> exu;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> fs;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, PointF> jpc;
    private final com.bytedance.adsdk.ud.tvp lnr;
    private final to.qdl mml;
    private final boolean mo;
    private final boolean mzz;
    private final Path qdl = new Path();
    private final ud rdp = new ud();
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> rq;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> to;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> tvp;
    private final String ud;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> wd;

    public rdp(com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar, com.bytedance.adsdk.ud.lnr.ud.to toVar) {
        this.lnr = tvpVar;
        this.ud = toVar.qdl();
        to.qdl qdlVarUd = toVar.ud();
        this.mml = qdlVarUd;
        this.mzz = toVar.to();
        this.mo = toVar.rq();
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl = toVar.lnr().qdl();
        this.wd = qdlVarQdl;
        com.bytedance.adsdk.ud.qdl.ud.qdl<PointF, PointF> qdlVarQdl2 = toVar.mml().qdl();
        this.jpc = qdlVarQdl2;
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl3 = toVar.mzz().qdl();
        this.tvp = qdlVarQdl3;
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl4 = toVar.wd().qdl();
        this.rq = qdlVarQdl4;
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl5 = toVar.tvp().qdl();
        this.exu = qdlVarQdl5;
        if (qdlVarUd == to.qdl.STAR) {
            this.to = toVar.mo().qdl();
            this.fs = toVar.jpc().qdl();
        } else {
            this.to = null;
            this.fs = null;
        }
        qdlVar.qdl(qdlVarQdl);
        qdlVar.qdl(qdlVarQdl2);
        qdlVar.qdl(qdlVarQdl3);
        qdlVar.qdl(qdlVarQdl4);
        qdlVar.qdl(qdlVarQdl5);
        if (qdlVarUd == to.qdl.STAR) {
            qdlVar.qdl(this.to);
            qdlVar.qdl(this.fs);
        }
        qdlVarQdl.qdl(this);
        qdlVarQdl2.qdl(this);
        qdlVarQdl3.qdl(this);
        qdlVarQdl4.qdl(this);
        qdlVarQdl5.qdl(this);
        if (qdlVarUd == to.qdl.STAR) {
            this.to.qdl(this);
            this.fs.qdl(this);
        }
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl.InterfaceC0180qdl
    public void qdl() {
        ud();
    }

    private void ud() {
        this.bjy = false;
        this.lnr.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.lnr
    public void qdl(List<lnr> list, List<lnr> list2) {
        for (int i = 0; i < list.size(); i++) {
            lnr lnrVar = list.get(i);
            if (lnrVar instanceof jyq) {
                jyq jyqVar = (jyq) lnrVar;
                if (jyqVar.ud() == exc.qdl.SIMULTANEOUSLY) {
                    this.rdp.qdl(jyqVar);
                    jyqVar.qdl(this);
                }
            }
        }
    }

    @Override // com.bytedance.adsdk.ud.qdl.qdl.exu
    public Path mml() {
        if (this.bjy) {
            return this.qdl;
        }
        this.qdl.reset();
        if (this.mzz) {
            this.bjy = true;
            return this.qdl;
        }
        int i = AnonymousClass1.qdl[this.mml.ordinal()];
        if (i == 1) {
            lnr();
        } else if (i == 2) {
            mzz();
        }
        this.qdl.close();
        this.rdp.qdl(this.qdl);
        this.bjy = true;
        return this.qdl;
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ud.qdl.qdl.rdp$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] qdl;

        static {
            int[] iArr = new int[to.qdl.values().length];
            qdl = iArr;
            try {
                iArr[to.qdl.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                qdl[to.qdl.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void lnr() {
        int i;
        float f;
        float f2;
        double d;
        float fSin;
        float f3;
        float f4;
        float f5;
        double d2;
        float f6;
        float f7;
        float f8;
        double d3;
        float fFloatValue = this.wd.wd().floatValue();
        double radians = Math.toRadians((this.tvp == null ? 0.0d : r2.wd().floatValue()) - 90.0d);
        double d4 = fFloatValue;
        float f9 = (float) (6.283185307179586d / d4);
        if (this.mo) {
            f9 *= -1.0f;
        }
        float f10 = f9 / 2.0f;
        float f11 = fFloatValue - ((int) fFloatValue);
        int i2 = (f11 > 0.0f ? 1 : (f11 == 0.0f ? 0 : -1));
        if (i2 != 0) {
            radians += (double) ((1.0f - f11) * f10);
        }
        float fFloatValue2 = this.rq.wd().floatValue();
        float fFloatValue3 = this.to.wd().floatValue();
        com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> qdlVar = this.fs;
        float fFloatValue4 = qdlVar != null ? qdlVar.wd().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> qdlVar2 = this.exu;
        float fFloatValue5 = qdlVar2 != null ? qdlVar2.wd().floatValue() / 100.0f : 0.0f;
        if (i2 != 0) {
            f3 = ((fFloatValue2 - fFloatValue3) * f11) + fFloatValue3;
            i = i2;
            double d5 = f3;
            float fCos = (float) (d5 * Math.cos(radians));
            fSin = (float) (d5 * Math.sin(radians));
            this.qdl.moveTo(fCos, fSin);
            d = radians + ((double) ((f9 * f11) / 2.0f));
            f = fCos;
            f2 = f10;
        } else {
            i = i2;
            double d6 = fFloatValue2;
            float fCos2 = (float) (Math.cos(radians) * d6);
            float fSin2 = (float) (d6 * Math.sin(radians));
            this.qdl.moveTo(fCos2, fSin2);
            f = fCos2;
            f2 = f10;
            d = radians + ((double) f2);
            fSin = fSin2;
            f3 = 0.0f;
        }
        double dCeil = Math.ceil(d4) * 2.0d;
        int i3 = 0;
        float f12 = f2;
        float f13 = f;
        boolean z = false;
        while (true) {
            double d7 = i3;
            if (d7 < dCeil) {
                float f14 = z ? fFloatValue2 : fFloatValue3;
                if (f3 == 0.0f || d7 != dCeil - 2.0d) {
                    f4 = f9;
                    f5 = f12;
                } else {
                    f4 = f9;
                    f5 = (f9 * f11) / 2.0f;
                }
                if (f3 == 0.0f || d7 != dCeil - 1.0d) {
                    d2 = d7;
                    f6 = f3;
                    f3 = f14;
                } else {
                    d2 = d7;
                    f6 = f3;
                }
                double d8 = f3;
                double d9 = dCeil;
                float fCos3 = (float) (d8 * Math.cos(d));
                float fSin3 = (float) (d8 * Math.sin(d));
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.qdl.lineTo(fCos3, fSin3);
                    d3 = d;
                    f7 = fFloatValue4;
                    f8 = fFloatValue5;
                } else {
                    f7 = fFloatValue4;
                    double dAtan2 = (float) (Math.atan2(fSin, f13) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    f8 = fFloatValue5;
                    d3 = d;
                    double dAtan22 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan22);
                    float fSin5 = (float) Math.sin(dAtan22);
                    float f15 = z ? f7 : f8;
                    float f16 = z ? f8 : f7;
                    float f17 = (z ? fFloatValue3 : fFloatValue2) * f15 * 0.47829f;
                    float f18 = fCos4 * f17;
                    float f19 = f17 * fSin4;
                    float f20 = (z ? fFloatValue2 : fFloatValue3) * f16 * 0.47829f;
                    float f21 = fCos5 * f20;
                    float f22 = f20 * fSin5;
                    if (i != 0) {
                        if (i3 == 0) {
                            f18 *= f11;
                            f19 *= f11;
                        } else if (d2 == d9 - 1.0d) {
                            f21 *= f11;
                            f22 *= f11;
                        }
                    }
                    this.qdl.cubicTo(f13 - f18, fSin - f19, fCos3 + f21, fSin3 + f22, fCos3, fSin3);
                }
                d = d3 + ((double) f5);
                z = !z;
                i3++;
                f13 = fCos3;
                fSin = fSin3;
                fFloatValue5 = f8;
                fFloatValue4 = f7;
                f3 = f6;
                f9 = f4;
                dCeil = d9;
            } else {
                PointF pointFWd = this.jpc.wd();
                this.qdl.offset(pointFWd.x, pointFWd.y);
                this.qdl.close();
                return;
            }
        }
    }

    private void mzz() {
        int i;
        double d;
        double d2;
        double d3;
        int iFloor = (int) Math.floor(this.wd.wd().floatValue());
        double radians = Math.toRadians((this.tvp == null ? 0.0d : r2.wd().floatValue()) - 90.0d);
        double d4 = iFloor;
        float fFloatValue = this.exu.wd().floatValue() / 100.0f;
        float fFloatValue2 = this.rq.wd().floatValue();
        double d5 = fFloatValue2;
        float fCos = (float) (Math.cos(radians) * d5);
        float fSin = (float) (Math.sin(radians) * d5);
        this.qdl.moveTo(fCos, fSin);
        double d6 = (float) (6.283185307179586d / d4);
        double d7 = radians + d6;
        double dCeil = Math.ceil(d4);
        int i2 = 0;
        while (i2 < dCeil) {
            float fCos2 = (float) (Math.cos(d7) * d5);
            double d8 = dCeil;
            float fSin2 = (float) (d5 * Math.sin(d7));
            if (fFloatValue != 0.0f) {
                d2 = d5;
                i = i2;
                d = d7;
                double dAtan2 = (float) (Math.atan2(fSin, fCos) - 1.5707963267948966d);
                float fCos3 = (float) Math.cos(dAtan2);
                float fSin3 = (float) Math.sin(dAtan2);
                d3 = d6;
                double dAtan22 = (float) (Math.atan2(fSin2, fCos2) - 1.5707963267948966d);
                float f = fFloatValue2 * fFloatValue * 0.25f;
                this.qdl.cubicTo(fCos - (fCos3 * f), fSin - (fSin3 * f), fCos2 + (((float) Math.cos(dAtan22)) * f), fSin2 + (f * ((float) Math.sin(dAtan22))), fCos2, fSin2);
            } else {
                i = i2;
                d = d7;
                d2 = d5;
                d3 = d6;
                this.qdl.lineTo(fCos2, fSin2);
            }
            d7 = d + d3;
            i2 = i + 1;
            fSin = fSin2;
            fCos = fCos2;
            dCeil = d8;
            d5 = d2;
            d6 = d3;
        }
        PointF pointFWd = this.jpc.wd();
        this.qdl.offset(pointFWd.x, pointFWd.y);
        this.qdl.close();
    }
}
