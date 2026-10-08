package com.bykv.vk.openvk.qdl.qdl.qdl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.ud.qdl.rq;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class lnr {
    private static String lnr = null;
    private static boolean mml = false;
    private static int mo = 1;
    private static rq mzz;
    public static boolean qdl;
    private static Context ud;

    public static Context qdl() {
        return ud;
    }

    public static String ud() {
        if (TextUtils.isEmpty(lnr)) {
            try {
                File file = new File(qdl().getFilesDir(), "ttad_dir");
                if (!file.exists()) {
                    file.mkdirs();
                }
                lnr = file.getAbsolutePath();
            } catch (Throwable unused) {
            }
        }
        return lnr;
    }

    public static void qdl(Context context, String str) {
        ud = context;
        lnr = str;
    }

    public static boolean lnr() {
        return mml;
    }

    public static void qdl(boolean z) {
        mml = z;
    }

    public static rq mml() {
        if (mzz == null) {
            mzz = new rq.qdl("v_config").qdl(10000L, TimeUnit.MILLISECONDS).ud(10000L, TimeUnit.MILLISECONDS).lnr(10000L, TimeUnit.MILLISECONDS).qdl();
        }
        return mzz;
    }

    public static void qdl(rq rqVar) {
        mzz = rqVar;
    }

    public static boolean mzz() {
        return qdl;
    }

    public static void qdl(int i) {
        mo = i;
    }

    public static int mo() {
        return mo;
    }
}
