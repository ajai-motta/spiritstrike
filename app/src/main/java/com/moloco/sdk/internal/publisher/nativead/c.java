package com.moloco.sdk.internal.publisher.nativead;

import android.content.Context;
import androidx.compose.runtime.ComposerKt;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.publisher.C2990a;
import com.moloco.sdk.internal.publisher.nativead.model.b;
import com.moloco.sdk.internal.publisher.o;
import com.moloco.sdk.internal.publisher.x;
import com.moloco.sdk.internal.s;
import com.moloco.sdk.internal.scheduling.DispatcherProvider;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.MolocoAdKt;
import java.util.List;
import java.util.Locale;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static final a k = new a(null);
    public static final int l = 8;
    public static final String m = "NativeAdLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2201a;
    public final String b;
    public final o c;
    public final com.moloco.sdk.internal.publisher.nativead.parser.a d;
    public final C2990a e;
    public final MetricsRecorder f;
    public final I g;
    public final AdFormatType h;
    public final TimerEvent i;
    public final DispatcherProvider j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    public static final class b {
        public static final int d = 8;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.moloco.sdk.internal.ortb.model.c f2202a;
        public final com.moloco.sdk.internal.publisher.nativead.model.b b;
        public final com.moloco.sdk.internal.publisher.nativead.model.d c;

        public b(com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.internal.publisher.nativead.model.b ortbResponse, com.moloco.sdk.internal.publisher.nativead.model.d preparedAssets) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            Intrinsics.checkNotNullParameter(ortbResponse, "ortbResponse");
            Intrinsics.checkNotNullParameter(preparedAssets, "preparedAssets");
            this.f2202a = bid;
            this.b = ortbResponse;
            this.c = preparedAssets;
        }

        public final com.moloco.sdk.internal.ortb.model.c a() {
            return this.f2202a;
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.b b() {
            return this.b;
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.d c() {
            return this.c;
        }

        public final com.moloco.sdk.internal.ortb.model.c d() {
            return this.f2202a;
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.b e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.areEqual(this.f2202a, bVar.f2202a) && Intrinsics.areEqual(this.b, bVar.b) && Intrinsics.areEqual(this.c, bVar.c);
        }

        public final com.moloco.sdk.internal.publisher.nativead.model.d f() {
            return this.c;
        }

        public int hashCode() {
            return (((this.f2202a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public String toString() {
            return "LoadedNativeAd(bid=" + this.f2202a + ", ortbResponse=" + this.b + ", preparedAssets=" + this.c + ')';
        }

        public final b a(com.moloco.sdk.internal.ortb.model.c bid, com.moloco.sdk.internal.publisher.nativead.model.b ortbResponse, com.moloco.sdk.internal.publisher.nativead.model.d preparedAssets) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            Intrinsics.checkNotNullParameter(ortbResponse, "ortbResponse");
            Intrinsics.checkNotNullParameter(preparedAssets, "preparedAssets");
            return new b(bid, ortbResponse, preparedAssets);
        }

        public static /* synthetic */ b a(b bVar, com.moloco.sdk.internal.ortb.model.c cVar, com.moloco.sdk.internal.publisher.nativead.model.b bVar2, com.moloco.sdk.internal.publisher.nativead.model.d dVar, int i, Object obj) {
            if ((i & 1) != 0) {
                cVar = bVar.f2202a;
            }
            if ((i & 2) != 0) {
                bVar2 = bVar.b;
            }
            if ((i & 4) != 0) {
                dVar = bVar.c;
            }
            return bVar.a(cVar, bVar2, dVar);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.c$c, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0, 0, 0}, l = {239}, m = "fetchAssets-8Mi8wO0", n = {"this", "adType", "nativeAdPrepareTime"}, s = {"L$0", "L$1", "L$2"})
    public static final class C0397c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2203a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public C0397c(Continuation<? super C0397c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return c.this.a((com.moloco.sdk.internal.publisher.nativead.model.b) null, 0L, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$fireAdLoadFailedEventOnUiThread$2", f = "NativeAdLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2204a;
        public final /* synthetic */ x b;
        public final /* synthetic */ s c;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.x d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(x xVar, s sVar, com.moloco.sdk.internal.ortb.model.x xVar2, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = xVar;
            this.c = sVar;
            this.d = xVar2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2204a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.b.a(this.c, this.d);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0, 0, 0, 1, 2}, l = {PsExtractor.PRIVATE_STREAM_1, ComposerKt.compositionLocalMapKey, 209}, m = "handleAssetsFetching-yxL6bBk", n = {"this", "sdkEvents", "adLoadTracker", "timeoutError", "error"}, s = {"L$0", "L$1", "L$2", "L$0", "L$0"})
    public static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2205a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            Object objA = c.this.a((com.moloco.sdk.internal.ortb.model.x) null, (com.moloco.sdk.internal.publisher.nativead.model.b) null, (x) null, 0L, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7414boximpl(objA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$handleAssetsFetching$result$1", f = "NativeAdLoader.kt", i = {}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2206a;
        public final /* synthetic */ com.moloco.sdk.internal.publisher.nativead.model.b c;
        public final /* synthetic */ long d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(com.moloco.sdk.internal.publisher.nativead.model.b bVar, long j, Continuation<? super f> continuation) {
            super(2, continuation);
            this.c = bVar;
            this.d = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new f(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2206a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                c cVar = c.this;
                com.moloco.sdk.internal.publisher.nativead.model.b bVar = this.c;
                long j = this.d;
                this.f2206a = 1;
                obj = cVar.a(bVar, j, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0, 0, 0, 1}, l = {143, 159}, m = "handleBidParsing-BWLJW6A", n = {"this", "acmLoadTimerEvent", "adLoadTracker", "it"}, s = {"L$0", "L$1", "L$2", "L$0"})
    public static final class g extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2207a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public g(Continuation<? super g> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            Object objA = c.this.a((String) null, (TimerEvent) null, (x) null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7414boximpl(objA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {0}, l = {175}, m = "handleOrtbParsing-BWLJW6A", n = {"result"}, s = {"L$0"})
    public static final class h extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2208a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public h(Continuation<? super h> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            Object objA = c.this.a((String) null, (com.moloco.sdk.internal.ortb.model.x) null, (x) null, this);
            return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Result.m7414boximpl(objA);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {}, l = {99}, m = "load-BWLJW6A", n = {}, s = {})
    public static final class i extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f2209a;
        public int c;

        public i(Continuation<? super i> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            this.f2209a = obj;
            this.c |= Integer.MIN_VALUE;
            Object objB = c.this.b(null, null, null, this);
            return objB == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objB : Result.m7414boximpl(objB);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$load$2", f = "NativeAdLoader.kt", i = {0, 1, 1, 2, 2, 3, 3}, l = {111, 119, 126, 132}, m = "invokeSuspend", n = {"adLoadStartTimeMs", "bid", "adLoadStartTimeMs", "bid", "adLoadStartTimeMs", "bid", "ortbResponse"}, s = {"J$0", "L$0", "J$0", "L$0", "J$0", "L$0", "L$1"})
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends b>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2210a;
        public Object b;
        public Object c;
        public int d;
        public final /* synthetic */ TimerEvent f;
        public final /* synthetic */ String g;
        public final /* synthetic */ x h;

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader$load$2$1", f = "NativeAdLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2211a;
            public final /* synthetic */ x b;
            public final /* synthetic */ c c;
            public final /* synthetic */ com.moloco.sdk.internal.ortb.model.c d;
            public final /* synthetic */ long e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(x xVar, c cVar, com.moloco.sdk.internal.ortb.model.c cVar2, long j, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = xVar;
                this.c = cVar;
                this.d = cVar2;
                this.e = j;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f2211a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.b.a(MolocoAdKt.createAdInfo(this.c.b, Boxing.boxFloat(this.d.getPrice()), this.d.getCrid()), this.e, this.d.getExt().getSdkEvents());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(TimerEvent timerEvent, String str, x xVar, Continuation<? super j> continuation) {
            super(2, continuation);
            this.f = timerEvent;
            this.g = str;
            this.h = xVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<b>> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new j(this.f, this.g, this.h, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0116 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0117  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0120  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x016a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r18) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 392
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.NativeAdLoader", f = "NativeAdLoader.kt", i = {}, l = {286}, m = "prepareAssets-8Mi8wO0", n = {}, s = {})
    public static final class k extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f2212a;
        public int c;

        public k(Continuation<? super k> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f2212a = obj;
            this.c |= Integer.MIN_VALUE;
            return c.this.a((List<? extends b.a>) null, 0L, this);
        }
    }

    public c(Context context, String adUnitId, o bidLoader, com.moloco.sdk.internal.publisher.nativead.parser.a ortbResponseParser, C2990a createLoadTimeoutManager, MetricsRecorder metricsRecorder, I timeProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(bidLoader, "bidLoader");
        Intrinsics.checkNotNullParameter(ortbResponseParser, "ortbResponseParser");
        Intrinsics.checkNotNullParameter(createLoadTimeoutManager, "createLoadTimeoutManager");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.f2201a = context;
        this.b = adUnitId;
        this.c = bidLoader;
        this.d = ortbResponseParser;
        this.e = createLoadTimeoutManager;
        this.f = metricsRecorder;
        this.g = timeProvider;
        AdFormatType adFormatType = AdFormatType.NATIVE;
        this.h = adFormatType;
        TimerEvent timerEventStartTimerEvent = metricsRecorder.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.q.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.d.c.c();
        String lowerCase = adFormatType.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        this.i = timerEventStartTimerEvent.withTag(strC, lowerCase);
        this.j = com.moloco.sdk.internal.scheduling.b.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r11, com.moloco.sdk.acm.TimerEvent r12, com.moloco.sdk.internal.publisher.x r13, kotlin.coroutines.Continuation<? super kotlin.Result<com.moloco.sdk.internal.publisher.nativead.c.b>> r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.moloco.sdk.internal.publisher.nativead.c.i
            if (r0 == 0) goto L13
            r0 = r14
            com.moloco.sdk.internal.publisher.nativead.c$i r0 = (com.moloco.sdk.internal.publisher.nativead.c.i) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.nativead.c$i r0 = new com.moloco.sdk.internal.publisher.nativead.c$i
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.f2209a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r14)
            goto L4e
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            kotlin.ResultKt.throwOnFailure(r14)
            com.moloco.sdk.internal.scheduling.DispatcherProvider r14 = r10.j
            kotlin.coroutines.CoroutineContext r14 = r14.getDefault()
            com.moloco.sdk.internal.publisher.nativead.c$j r2 = new com.moloco.sdk.internal.publisher.nativead.c$j
            r9 = 0
            r4 = r2
            r5 = r10
            r6 = r12
            r7 = r11
            r8 = r13
            r4.<init>(r6, r7, r8, r9)
            r0.c = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.withContext(r14, r2, r0)
            if (r14 != r1) goto L4e
            return r1
        L4e:
            kotlin.Result r14 = (kotlin.Result) r14
            java.lang.Object r11 = r14.getValue()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.b(java.lang.String, com.moloco.sdk.acm.TimerEvent, com.moloco.sdk.internal.publisher.x, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r12, com.moloco.sdk.acm.TimerEvent r13, com.moloco.sdk.internal.publisher.x r14, kotlin.coroutines.Continuation<? super kotlin.Result<com.moloco.sdk.internal.ortb.model.c>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.a(java.lang.String, com.moloco.sdk.acm.TimerEvent, com.moloco.sdk.internal.publisher.x, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r12, com.moloco.sdk.internal.ortb.model.x r13, com.moloco.sdk.internal.publisher.x r14, kotlin.coroutines.Continuation<? super kotlin.Result<com.moloco.sdk.internal.publisher.nativead.model.b>> r15) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.moloco.sdk.internal.publisher.nativead.c.h
            if (r0 == 0) goto L13
            r0 = r15
            com.moloco.sdk.internal.publisher.nativead.c$h r0 = (com.moloco.sdk.internal.publisher.nativead.c.h) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.nativead.c$h r0 = new com.moloco.sdk.internal.publisher.nativead.c$h
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r12 = r0.f2208a
            kotlin.ResultKt.throwOnFailure(r15)
            goto L66
        L2b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L33:
            kotlin.ResultKt.throwOnFailure(r15)
            com.moloco.sdk.internal.publisher.nativead.parser.a r15 = r11.d
            java.lang.Object r12 = r15.a(r12)
            java.lang.Throwable r7 = kotlin.Result.m7418exceptionOrNullimpl(r12)
            if (r7 == 0) goto L66
            com.moloco.sdk.internal.MolocoLogger r4 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            r9 = 8
            r10 = 0
            java.lang.String r5 = "NativeAdLoader"
            java.lang.String r6 = "handleOrtbParsing"
            r8 = 0
            com.moloco.sdk.internal.MolocoLogger.error$default(r4, r5, r6, r7, r8, r9, r10)
            java.lang.String r15 = r11.b
            com.moloco.sdk.publisher.MolocoAdError$ErrorType r2 = com.moloco.sdk.publisher.MolocoAdError.ErrorType.AD_LOAD_FAILED
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f r4 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.f2518a
            com.moloco.sdk.internal.s r15 = com.moloco.sdk.internal.t.a(r15, r2, r4)
            r0.f2208a = r12
            r0.b = r12
            r0.e = r3
            java.lang.Object r13 = r11.a(r14, r15, r13, r0)
            if (r13 != r1) goto L66
            return r1
        L66:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.a(java.lang.String, com.moloco.sdk.internal.ortb.model.x, com.moloco.sdk.internal.publisher.x, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.moloco.sdk.internal.ortb.model.x r21, com.moloco.sdk.internal.publisher.nativead.model.b r22, com.moloco.sdk.internal.publisher.x r23, long r24, kotlin.coroutines.Continuation<? super kotlin.Result<com.moloco.sdk.internal.publisher.nativead.model.d>> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.a(com.moloco.sdk.internal.ortb.model.x, com.moloco.sdk.internal.publisher.nativead.model.b, com.moloco.sdk.internal.publisher.x, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(com.moloco.sdk.internal.publisher.nativead.model.b r16, long r17, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 543
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.a(com.moloco.sdk.internal.publisher.nativead.model.b, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.util.List<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a> r8, long r9, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.internal.publisher.nativead.parser.b>> r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.moloco.sdk.internal.publisher.nativead.c.k
            if (r0 == 0) goto L13
            r0 = r11
            com.moloco.sdk.internal.publisher.nativead.c$k r0 = (com.moloco.sdk.internal.publisher.nativead.c.k) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.nativead.c$k r0 = new com.moloco.sdk.internal.publisher.nativead.c$k
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.f2212a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r11)
            goto L3f
        L29:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L31:
            kotlin.ResultKt.throwOnFailure(r11)
            android.content.Context r11 = r7.f2201a
            r0.c = r3
            java.lang.Object r11 = com.moloco.sdk.internal.publisher.nativead.parser.c.a(r11, r8, r9, r0)
            if (r11 != r1) goto L3f
            return r1
        L3f:
            com.moloco.sdk.internal.v r11 = (com.moloco.sdk.internal.v) r11
            boolean r8 = r11 instanceof com.moloco.sdk.internal.v.b
            if (r8 == 0) goto L51
            com.moloco.sdk.internal.v$b r8 = new com.moloco.sdk.internal.v$b
            com.moloco.sdk.internal.v$b r11 = (com.moloco.sdk.internal.v.b) r11
            java.lang.Object r9 = r11.a()
            r8.<init>(r9)
            goto L74
        L51:
            boolean r8 = r11 instanceof com.moloco.sdk.internal.v.a
            if (r8 == 0) goto L75
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            com.moloco.sdk.internal.v$a r11 = (com.moloco.sdk.internal.v.a) r11
            java.lang.Object r8 = r11.a()
            r3 = r8
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r5 = 8
            r6 = 0
            java.lang.String r1 = "NativeAdLoader"
            java.lang.String r2 = "NativeAd prepareAssets failed"
            r4 = 0
            com.moloco.sdk.internal.MolocoLogger.error$default(r0, r1, r2, r3, r4, r5, r6)
            com.moloco.sdk.internal.v$a r8 = new com.moloco.sdk.internal.v$a
            java.lang.Object r9 = r11.a()
            r8.<init>(r9)
        L74:
            return r8
        L75:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.c.a(java.util.List, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object a(x xVar, s sVar, com.moloco.sdk.internal.ortb.model.x xVar2, Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(this.j.getMain(), new d(xVar, sVar, xVar2, null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }
}
