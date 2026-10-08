package com.moloco.sdk.internal.services.init;

import com.adxcorp.ads.mediation.util.ReportUtil;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.MediationInfo;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
public final class l implements k {
    public static final int e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.internal.services.init.d f2375a;
    public final g b;
    public final CoroutineScope c;
    public Init.SDKInitResponse d;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitServiceImpl", f = "InitService.kt", i = {0, 0, 0, 0, 1}, l = {94, 107}, m = "fetchInitResponse", n = {"this", "appKey", "mediationInfo", "metricsRecorder", "this"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2376a;
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
            return l.this.a(null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitServiceImpl$fetchInitResponse$3", f = "InitService.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2377a;
        public final /* synthetic */ String c;
        public final /* synthetic */ MediationInfo d;
        public final /* synthetic */ MetricsRecorder e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, MediationInfo mediationInfo, MetricsRecorder metricsRecorder, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = str;
            this.d = mediationInfo;
            this.e = metricsRecorder;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return l.this.new b(this.c, this.d, this.e, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2377a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, m.f2380a, "Async fetching init response", null, false, 12, null);
                l lVar = l.this;
                String str = this.c;
                MediationInfo mediationInfo = this.d;
                MetricsRecorder metricsRecorder = this.e;
                this.f2377a = 1;
                if (lVar.a(str, mediationInfo, metricsRecorder, true, (Continuation<? super v<Init.SDKInitResponse, j>>) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitServiceImpl", f = "InitService.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 4, 4, 4}, l = {TsExtractor.TS_STREAM_TYPE_E_AC3, 144, 146, 183, 196}, m = "fetchServerInitResponse$moloco_sdk_release", n = {"this", "appKey", "mediationInfo", "metricsRecorder", "result", "asyncFetch", ReportUtil.EVENT_TYPE_ATTEMPT, "metricsRecorder", "it", "cacheKey", "$this$fetchServerInitResponse_u24lambda_u244_u24lambda_u242_u24lambda_u241", "asyncFetch", ReportUtil.EVENT_TYPE_ATTEMPT, "metricsRecorder", "it", "asyncFetch", ReportUtil.EVENT_TYPE_ATTEMPT, "result", "this", "appKey", "mediationInfo", "metricsRecorder", "result", "asyncFetch"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$2", "L$0", "L$1", "L$2", "L$3", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0", "L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2378a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public boolean g;
        public int h;
        public int i;
        public int j;
        public /* synthetic */ Object k;
        public int m;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.k = obj;
            this.m |= Integer.MIN_VALUE;
            return l.this.a((String) null, (MediationInfo) null, (MetricsRecorder) null, false, (Continuation<? super v<Init.SDKInitResponse, j>>) this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.init.InitServiceImpl", f = "InitService.kt", i = {0, 0}, l = {68}, m = "performInit", n = {"metricsRecorder", "performInitEvent"}, s = {"L$0", "L$1"})
    public static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2379a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return l.this.a(null, null, this);
        }
    }

    public l(com.moloco.sdk.internal.services.init.d initApi, g initCache, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(initApi, "initApi");
        Intrinsics.checkNotNullParameter(initCache, "initCache");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.f2375a = initApi;
        this.b = initCache;
        this.c = scope;
    }

    @Override // com.moloco.sdk.internal.services.init.k
    public Init.SDKInitResponse a() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.init.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(java.lang.String r6, com.moloco.sdk.publisher.MediationInfo r7, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.init.l.a(java.lang.String, com.moloco.sdk.publisher.MediationInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r24, com.moloco.sdk.publisher.MediationInfo r25, com.moloco.sdk.acm.recorder.MetricsRecorder r26, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.services.init.c> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.init.l.a(java.lang.String, com.moloco.sdk.publisher.MediationInfo, com.moloco.sdk.acm.recorder.MetricsRecorder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.moloco.sdk.internal.services.init.k
    public Object a(Continuation<? super Unit> continuation) {
        this.d = null;
        Object objA = this.b.a(continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x035c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x033d -> B:78:0x0344). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r31, com.moloco.sdk.publisher.MediationInfo r32, com.moloco.sdk.acm.recorder.MetricsRecorder r33, boolean r34, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.Init.SDKInitResponse, com.moloco.sdk.internal.services.init.j>> r35) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 913
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.init.l.a(java.lang.String, com.moloco.sdk.publisher.MediationInfo, com.moloco.sdk.acm.recorder.MetricsRecorder, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
