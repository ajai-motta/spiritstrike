package com.moloco.sdk.internal.services;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.moloco.sdk.internal.services.AbstractC3002c;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.internal.services.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3004e implements InterfaceC3003d {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2343a;

    public C3004e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2343a = context;
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC3003d
    public AbstractC3002c a() {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(AdvertisingIdClient.getAdvertisingIdInfo(this.f2343a));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        AbstractC3002c aVar = null;
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = null;
        }
        AdvertisingIdClient.Info info = (AdvertisingIdClient.Info) objM7415constructorimpl;
        if (info != null) {
            if (info.isLimitAdTrackingEnabled()) {
                aVar = AbstractC3002c.b.b;
            } else {
                String id = info.getId();
                if (id != null) {
                    aVar = new AbstractC3002c.a(id);
                }
            }
            if (aVar != null) {
                return aVar;
            }
        }
        return AbstractC3002c.b.b;
    }
}
