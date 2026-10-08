package com.bytedance.adsdk.ud.mo;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.ud.lnr.ud.rdp;

/* JADX INFO: loaded from: classes.dex */
public class mzz {
    private static final PointF qdl = new PointF();

    public static boolean lnr(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static float qdl(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    public static int qdl(int i, int i2, float f) {
        return (int) (i + (f * (i2 - i)));
    }

    public static PointF qdl(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void qdl(rdp rdpVar, Path path) {
        path.reset();
        PointF pointFQdl = rdpVar.qdl();
        path.moveTo(pointFQdl.x, pointFQdl.y);
        qdl.set(pointFQdl.x, pointFQdl.y);
        for (int i = 0; i < rdpVar.lnr().size(); i++) {
            com.bytedance.adsdk.ud.lnr.qdl qdlVar = rdpVar.lnr().get(i);
            PointF pointFQdl2 = qdlVar.qdl();
            PointF pointFUd = qdlVar.ud();
            PointF pointFLnr = qdlVar.lnr();
            PointF pointF = qdl;
            if (pointFQdl2.equals(pointF) && pointFUd.equals(pointFLnr)) {
                path.lineTo(pointFLnr.x, pointFLnr.y);
            } else {
                path.cubicTo(pointFQdl2.x, pointFQdl2.y, pointFUd.x, pointFUd.y, pointFLnr.x, pointFLnr.y);
            }
            pointF.set(pointFLnr.x, pointFLnr.y);
        }
        if (rdpVar.ud()) {
            path.close();
        }
    }

    static int qdl(float f, float f2) {
        return qdl((int) f, (int) f2);
    }

    private static int qdl(int i, int i2) {
        return i - (i2 * ud(i, i2));
    }

    private static int ud(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int qdl(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float ud(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}
