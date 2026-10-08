package com.moloco.sdk.internal.services;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.core.net.ConnectivityManagerCompat;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes6.dex */
public final class v implements u {
    public static final int c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2398a;
    public final String b;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.ConnectivityServiceImpl", f = "ConnectivityService.kt", i = {}, l = {40}, m = "waitForNetwork", n = {}, s = {})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f2399a;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2399a = obj;
            this.c |= Integer.MIN_VALUE;
            return v.this.a(0L, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.ConnectivityServiceImpl$waitForNetwork$hasConnectivity$1", f = "ConnectivityService.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2400a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return v.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2400a;
            if (i != 0 && i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            while (!v.this.a()) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, v.this.b, "waiting because of no network connection", null, false, 12, null);
                this.f2400a = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(true);
        }
    }

    public v(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2398a = context;
        this.b = "ConnectivityServiceImpl";
    }

    @Override // com.moloco.sdk.internal.services.u
    public boolean b() {
        try {
            return ConnectivityManagerCompat.isActiveNetworkMetered(a(this.f2398a));
        } catch (Exception e) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "isNetworkMetered", e.toString(), e, false, 8, null);
            return false;
        }
    }

    public final Context c() {
        return this.f2398a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(long r5, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.moloco.sdk.internal.services.v.a
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.internal.services.v$a r0 = (com.moloco.sdk.internal.services.v.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.internal.services.v$a r0 = new com.moloco.sdk.internal.services.v$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f2399a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L43
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            com.moloco.sdk.internal.services.v$b r7 = new com.moloco.sdk.internal.services.v$b
            r2 = 0
            r7.<init>(r2)
            r0.c = r3
            java.lang.Object r7 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r5, r7, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            if (r7 == 0) goto L4c
            boolean r5 = r7.booleanValue()
            goto L4d
        L4c:
            r5 = 0
        L4d:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.v.a(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.moloco.sdk.internal.services.u
    public boolean a() {
        NetworkCapabilities networkCapabilities;
        Object systemService = this.f2398a.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3);
    }

    public final ConnectivityManager a(Context context) {
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        return (ConnectivityManager) systemService;
    }
}
