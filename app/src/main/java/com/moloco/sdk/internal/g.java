package com.moloco.sdk.internal;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i f2055a;

    public g(com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest) {
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        this.f2055a = persistentHttpRequest;
    }

    @Override // com.moloco.sdk.internal.f
    public void a(String burl) {
        Intrinsics.checkNotNullParameter(burl, "burl");
        try {
            Uri uri = Uri.parse(burl);
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar = this.f2055a;
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            iVar.a(string);
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "BUrlTrackerImpl", e.toString(), null, false, 12, null);
        }
    }
}
