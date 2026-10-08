package com.bytedance.sdk.openadsdk.core.settings;

import android.util.Log;
import com.bytedance.sdk.component.utils.aaj;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class wd {
    private static final AtomicInteger qdl = new AtomicInteger(1);

    public static boolean qdl() {
        return qdl.get() == 1;
    }

    protected static void qdl(int i) {
        AtomicInteger atomicInteger;
        boolean z = true;
        if (i == 1 || i == 2) {
            try {
                atomicInteger = qdl;
            } catch (Throwable th) {
                th = th;
                z = false;
            }
            if (atomicInteger.get() != i) {
                try {
                    atomicInteger.set(i);
                } catch (Throwable th2) {
                    th = th2;
                    aaj.lnr("SdkSwitch", th.getMessage());
                    if (!z) {
                        return;
                    }
                }
                Log.e("SdkSwitch", "switch status changed: " + qdl());
                if (qdl()) {
                    com.bytedance.sdk.openadsdk.mml.qdl.ud.ud();
                } else {
                    com.bytedance.sdk.openadsdk.mml.qdl.ud.lnr();
                }
            }
        }
    }
}
