package com.google.android.play.core.integrity;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static aw f1757a;

    static synchronized aw a(Context context) {
        if (f1757a == null) {
            u uVar = new u(null);
            uVar.a(com.google.android.play.integrity.internal.ag.a(context));
            f1757a = uVar.b();
        }
        return f1757a;
    }
}
