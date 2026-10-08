package com.fyber.inneractive.sdk.config.cellular;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static d a(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            return new c(context);
        }
        if (i >= 24) {
            return new g(context);
        }
        return null;
    }
}
