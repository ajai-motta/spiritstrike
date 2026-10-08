package com.bytedance.adsdk.ud.mzz;

import android.graphics.PointF;
import android.util.JsonReader;
import android.util.SparseArray;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class aaj {
    private static final Interpolator qdl = new LinearInterpolator();
    private static SparseArray<WeakReference<Interpolator>> ud;

    aaj() {
    }

    private static SparseArray<WeakReference<Interpolator>> qdl() {
        if (ud == null) {
            ud = new SparseArray<>();
        }
        return ud;
    }

    private static WeakReference<Interpolator> qdl(int i) {
        WeakReference<Interpolator> weakReference;
        synchronized (aaj.class) {
            weakReference = qdl().get(i);
        }
        return weakReference;
    }

    private static void qdl(int i, WeakReference<Interpolator> weakReference) {
        synchronized (aaj.class) {
            ud.put(i, weakReference);
        }
    }

    static <T> com.bytedance.adsdk.ud.wd.qdl<T> qdl(JsonReader jsonReader, com.bytedance.adsdk.ud.wd wdVar, float f, wc<T> wcVar, boolean z, boolean z2) throws IOException {
        if (z && z2) {
            return ud(wdVar, jsonReader, f, wcVar);
        }
        if (z) {
            return qdl(wdVar, jsonReader, f, wcVar);
        }
        return qdl(jsonReader, f, wcVar);
    }

    private static <T> com.bytedance.adsdk.ud.wd.qdl<T> qdl(com.bytedance.adsdk.ud.wd wdVar, JsonReader jsonReader, float f, wc<T> wcVar) throws IOException {
        Interpolator interpolatorQdl;
        jsonReader.beginObject();
        PointF pointFUd = null;
        T tUd = null;
        T tUd2 = null;
        PointF pointFUd2 = null;
        PointF pointFUd3 = null;
        float fNextDouble = 0.0f;
        boolean z = false;
        PointF pointFUd4 = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            switch (strNextName) {
                case "e":
                    tUd = wcVar.ud(jsonReader, f);
                    break;
                case "h":
                    if (jsonReader.nextInt() != 1) {
                        z = false;
                        break;
                    } else {
                        z = true;
                        break;
                    }
                    break;
                case "i":
                    pointFUd4 = exc.ud(jsonReader, 1.0f);
                    break;
                case "o":
                    pointFUd = exc.ud(jsonReader, 1.0f);
                    break;
                case "s":
                    tUd2 = wcVar.ud(jsonReader, f);
                    break;
                case "t":
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case "ti":
                    pointFUd3 = exc.ud(jsonReader, f);
                    break;
                case "to":
                    pointFUd2 = exc.ud(jsonReader, f);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        if (!z) {
            if (pointFUd != null && pointFUd4 != null) {
                interpolatorQdl = qdl(pointFUd, pointFUd4);
            }
            com.bytedance.adsdk.ud.wd.qdl<T> qdlVar = new com.bytedance.adsdk.ud.wd.qdl<>(wdVar, tUd2, tUd, interpolatorQdl, fNextDouble, null);
            qdlVar.jpc = pointFUd2;
            qdlVar.tvp = pointFUd3;
            return qdlVar;
        }
        tUd = tUd2;
        interpolatorQdl = qdl;
        com.bytedance.adsdk.ud.wd.qdl<T> qdlVar2 = new com.bytedance.adsdk.ud.wd.qdl<>(wdVar, tUd2, tUd, interpolatorQdl, fNextDouble, null);
        qdlVar2.jpc = pointFUd2;
        qdlVar2.tvp = pointFUd3;
        return qdlVar2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0267 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0278  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static <T> com.bytedance.adsdk.ud.wd.qdl<T> ud(com.bytedance.adsdk.ud.wd r23, android.util.JsonReader r24, float r25, com.bytedance.adsdk.ud.mzz.wc<T> r26) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 710
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.mzz.aaj.ud(com.bytedance.adsdk.ud.wd, android.util.JsonReader, float, com.bytedance.adsdk.ud.mzz.wc):com.bytedance.adsdk.ud.wd.qdl");
    }

    private static Interpolator qdl(PointF pointF, PointF pointF2) {
        Interpolator linearInterpolator;
        pointF.x = com.bytedance.adsdk.ud.mo.mzz.ud(pointF.x, -1.0f, 1.0f);
        pointF.y = com.bytedance.adsdk.ud.mo.mzz.ud(pointF.y, -100.0f, 100.0f);
        pointF2.x = com.bytedance.adsdk.ud.mo.mzz.ud(pointF2.x, -1.0f, 1.0f);
        pointF2.y = com.bytedance.adsdk.ud.mo.mzz.ud(pointF2.y, -100.0f, 100.0f);
        int iQdl = com.bytedance.adsdk.ud.mo.mo.qdl(pointF.x, pointF.y, pointF2.x, pointF2.y);
        WeakReference<Interpolator> weakReferenceQdl = com.bytedance.adsdk.ud.mzz.qdl() ? null : qdl(iQdl);
        Interpolator interpolator = weakReferenceQdl != null ? weakReferenceQdl.get() : null;
        if (weakReferenceQdl == null || interpolator == null) {
            try {
                linearInterpolator = com.bytedance.adsdk.ud.yt.qdl(pointF.x, pointF.y, pointF2.x, pointF2.y);
            } catch (IllegalArgumentException e) {
                if ("The Path cannot loop back on itself.".equals(e.getMessage())) {
                    linearInterpolator = com.bytedance.adsdk.ud.yt.qdl(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y);
                } else {
                    linearInterpolator = new LinearInterpolator();
                }
            }
            interpolator = linearInterpolator;
            if (!com.bytedance.adsdk.ud.mzz.qdl()) {
                try {
                    qdl(iQdl, (WeakReference<Interpolator>) new WeakReference(interpolator));
                } catch (ArrayIndexOutOfBoundsException unused) {
                }
            }
        }
        return interpolator;
    }

    private static <T> com.bytedance.adsdk.ud.wd.qdl<T> qdl(JsonReader jsonReader, float f, wc<T> wcVar) throws IOException {
        return new com.bytedance.adsdk.ud.wd.qdl<>(wcVar.ud(jsonReader, f));
    }
}
