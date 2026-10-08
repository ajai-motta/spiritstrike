package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3033n implements InterfaceC3032m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i f2602a;
    public final com.moloco.sdk.internal.error.b b;

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.n$a */
    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.DECLoaderImpl", f = "DECLoader.kt", i = {0, 0, 0, 0}, l = {31}, m = "load", n = {"this", "decToLoad", "mtid", "appIconUri"}, s = {"L$0", "L$1", "L$2", "L$3"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2603a;
        public Object b;
        public Object c;
        public Object d;
        public /* synthetic */ Object e;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return C3033n.this.a(null, null, this);
        }
    }

    public C3033n(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i mediaCacheRepository, com.moloco.sdk.internal.error.b errorReportingService) {
        Intrinsics.checkNotNullParameter(mediaCacheRepository, "mediaCacheRepository");
        Intrinsics.checkNotNullParameter(errorReportingService, "errorReportingService");
        this.f2602a = mediaCacheRepository;
        this.b = errorReportingService;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.InterfaceC3032m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3028i r22, java.lang.String r23, kotlin.coroutines.Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3028i> r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3033n.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
