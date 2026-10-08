package com.bytedance.adsdk.ud;

import android.content.Context;
import android.os.Trace;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class mzz {
    private static volatile com.bytedance.adsdk.ud.mml.wd fs = null;
    private static int jpc = 0;
    private static boolean lnr = true;
    private static boolean mml = true;
    private static long[] mo;
    private static String[] mzz;
    public static boolean qdl;
    private static volatile com.bytedance.adsdk.ud.mml.jpc rq;
    private static com.bytedance.adsdk.ud.mml.mzz to;
    private static com.bytedance.adsdk.ud.mml.mo tvp;
    private static boolean ud;
    private static int wd;

    public static void qdl(String str) {
        if (ud) {
            int i = wd;
            if (i == 20) {
                jpc++;
                return;
            }
            mzz[i] = str;
            mo[i] = System.nanoTime();
            Trace.beginSection(str);
            wd++;
        }
    }

    public static float ud(String str) {
        int i = jpc;
        if (i > 0) {
            jpc = i - 1;
            return 0.0f;
        }
        if (!ud) {
            return 0.0f;
        }
        int i2 = wd - 1;
        wd = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(mzz[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + mzz[wd] + ".");
        }
        Trace.endSection();
        return (System.nanoTime() - mo[wd]) / 1000000.0f;
    }

    public static com.bytedance.adsdk.ud.mml.jpc qdl(Context context) {
        com.bytedance.adsdk.ud.mml.jpc jpcVar;
        com.bytedance.adsdk.ud.mml.jpc jpcVar2 = rq;
        if (jpcVar2 != null) {
            return jpcVar2;
        }
        synchronized (com.bytedance.adsdk.ud.mml.jpc.class) {
            jpcVar = rq;
            if (jpcVar == null) {
                com.bytedance.adsdk.ud.mml.wd wdVarUd = ud(context);
                com.bytedance.adsdk.ud.mml.mo udVar = tvp;
                if (udVar == null) {
                    udVar = new com.bytedance.adsdk.ud.mml.ud();
                }
                jpcVar = new com.bytedance.adsdk.ud.mml.jpc(wdVarUd, udVar);
                rq = jpcVar;
            }
        }
        return jpcVar;
    }

    public static com.bytedance.adsdk.ud.mml.wd ud(Context context) {
        com.bytedance.adsdk.ud.mml.wd wdVar;
        if (!lnr) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.bytedance.adsdk.ud.mml.wd wdVar2 = fs;
        if (wdVar2 != null) {
            return wdVar2;
        }
        synchronized (com.bytedance.adsdk.ud.mml.wd.class) {
            wdVar = fs;
            if (wdVar == null) {
                com.bytedance.adsdk.ud.mml.mzz mzzVar = to;
                if (mzzVar == null) {
                    mzzVar = new com.bytedance.adsdk.ud.mml.mzz() { // from class: com.bytedance.adsdk.ud.mzz.1
                        @Override // com.bytedance.adsdk.ud.mml.mzz
                        public File qdl() {
                            return new File(applicationContext.getCacheDir(), "lottie_network_cache");
                        }
                    };
                }
                wdVar = new com.bytedance.adsdk.ud.mml.wd(mzzVar);
                fs = wdVar;
            }
        }
        return wdVar;
    }

    public static boolean qdl() {
        return mml;
    }
}
