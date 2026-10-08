package com.moloco.sdk.internal.services.usertracker;

import com.moloco.sdk.internal.services.w;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements b {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f2393a;

    public c(w dataStoreService) {
        Intrinsics.checkNotNullParameter(dataStoreService, "dataStoreService");
        this.f2393a = dataStoreService;
    }

    @Override // com.moloco.sdk.internal.services.usertracker.b
    public Object a(String str, Continuation<? super Unit> continuation) {
        Object objA = this.f2393a.a(d.f2394a, str, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    @Override // com.moloco.sdk.internal.services.usertracker.b
    public Object b(Continuation<? super String> continuation) {
        return this.f2393a.d(d.f2394a, continuation);
    }

    @Override // com.moloco.sdk.internal.services.usertracker.b
    public Object a(Continuation<? super Unit> continuation) {
        Object objA = this.f2393a.a(d.f2394a, continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }
}
