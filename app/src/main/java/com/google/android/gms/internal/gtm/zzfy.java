package com.google.android.gms.internal.gtm;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzfy extends Handler {
    public zzfy() {
        Looper.getMainLooper();
    }

    public zzfy(Looper looper) {
        super(looper);
        Looper.getMainLooper();
    }

    public zzfy(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        Looper.getMainLooper();
    }
}
