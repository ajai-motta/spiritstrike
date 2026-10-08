package com.moloco.sdk.internal.publisher;

import android.content.Context;
import android.view.ViewParent;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.login.LoginLogger;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.TimerEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.InterfaceC2985a;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.error.b;
import com.moloco.sdk.internal.i;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.services.InterfaceC3005f;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.Initialization;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.service_locator.a;
import java.util.Locale;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C2991b {
    public static final a f = new a(null);
    public static final int g = 8;
    public static final String h = "UNABLE_TO_CREATE_AD";
    public static final String i = "AdCreator";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StateFlow<Initialization> f2161a;
    public final I b;
    public final C2992c c;
    public final Function1<Continuation<? super InterfaceC2985a>, Object> d;
    public final CoroutineContext e;

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0392b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2162a;

        static {
            int[] iArr = new int[Initialization.values().length];
            try {
                iArr[Initialization.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Initialization.FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f2162a = iArr;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b$c */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator", f = "AdCreator.kt", i = {0, 0, 0}, l = {TTAdConstant.VIDEO_INFO_CODE}, m = "awaitAdFactoryWithTimeoutOrNull", n = {"createAdType", "metricsRecorder", "awaitTimer"}, s = {"L$0", "L$1", "L$2"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2163a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return C2991b.this.a(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b$d */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$awaitAdFactoryWithTimeoutOrNull$2", f = "AdCreator.kt", i = {}, l = {TTAdConstant.VIDEO_INFO_CODE}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InterfaceC2985a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2164a;
        public final /* synthetic */ Function1<Continuation<? super InterfaceC2985a>, Object> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super Continuation<? super InterfaceC2985a>, ? extends Object> function1, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InterfaceC2985a> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2164a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function1<Continuation<? super InterfaceC2985a>, Object> function1 = this.b;
                this.f2164a = 1;
                obj = function1.invoke(this);
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

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b$e */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createBanner$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {67}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2165a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super e> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C2991b.this.new e(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            s sVar;
            TimerEvent timerEvent;
            String str;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.f2249a;
                long jInvoke = C2991b.this.b.invoke();
                String strA = C2991b.this.a();
                TimerEvent timerEventWithTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Creating " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                C2991b c2991b = C2991b.this;
                Function1 function1 = c2991b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f2165a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jInvoke;
                this.e = 1;
                objA = c2991b.a(function1, sVar2, metricsRecorder, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sVar = sVar2;
                timerEvent = timerEventWithTag;
                str = strA;
                j = jInvoke;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f2165a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                str = str2;
                sVar = sVar3;
                objA = obj;
            }
            InterfaceC2985a interfaceC2985a = (InterfaceC2985a) objA;
            if (interfaceC2985a != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f2418a.a();
                InterfaceC3005f interfaceC3005fE = a.b.f2420a.e();
                String str3 = this.h;
                a.h hVar = a.h.f2426a;
                long j2 = j;
                ViewParent viewParentB = interfaceC2985a.b(contextA, interfaceC3005fE, str3, hVar.j(), hVar.f(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C2990a(AdFormatType.BANNER, com.moloco.sdk.internal.mediators.b.a(this.j), null), hVar.i(), i.c.d, this.g);
                if (viewParentB != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.j.c());
                    com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(dVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar.name()).withTag("initial_sdk_init_state", str));
                    this.g.recordTimerEvent(timerEvent.withTag(dVar.c(), "success"));
                    if (viewParentB instanceof r) {
                        ((r) viewParentB).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Created " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(viewParentB);
                }
            }
            MolocoAdError.AdCreateError adCreateErrorA = C2991b.this.a(this.h, str, timerEvent, sVar, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C2991b.i, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new v.a(adCreateErrorA);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b$f */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createBannerTablet$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {119}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2166a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super f> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C2991b.this.new f(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            s sVar;
            TimerEvent timerEvent;
            String str;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.b;
                long jInvoke = C2991b.this.b.invoke();
                String strA = C2991b.this.a();
                TimerEvent timerEventWithTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Creating " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                C2991b c2991b = C2991b.this;
                Function1 function1 = c2991b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f2166a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jInvoke;
                this.e = 1;
                objA = c2991b.a(function1, sVar2, metricsRecorder, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sVar = sVar2;
                timerEvent = timerEventWithTag;
                str = strA;
                j = jInvoke;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f2166a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                str = str2;
                sVar = sVar3;
                objA = obj;
            }
            InterfaceC2985a interfaceC2985a = (InterfaceC2985a) objA;
            if (interfaceC2985a != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f2418a.a();
                InterfaceC3005f interfaceC3005fE = a.b.f2420a.e();
                String str3 = this.h;
                a.h hVar = a.h.f2426a;
                long j2 = j;
                ViewParent viewParentC = interfaceC2985a.c(contextA, interfaceC3005fE, str3, hVar.j(), hVar.f(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C2990a(AdFormatType.BANNER, com.moloco.sdk.internal.mediators.b.a(this.j), null), hVar.i(), i.d.d, this.g);
                if (viewParentC != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.j.c());
                    com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(dVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar.name()).withTag("initial_sdk_init_state", str));
                    this.g.recordTimerEvent(timerEvent.withTag(dVar.c(), "success"));
                    if (viewParentC instanceof r) {
                        ((r) viewParentC).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Created " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(viewParentC);
                }
            }
            MolocoAdError.AdCreateError adCreateErrorA = C2991b.this.a(this.h, str, timerEvent, sVar, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C2991b.i, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new v.a(adCreateErrorA);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b$g */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createInterstitial$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {261}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<InterstitialAd, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2167a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super g> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<InterstitialAd, MolocoAdError.AdCreateError>> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C2991b.this.new g(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            s sVar;
            TimerEvent timerEvent;
            String str;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.f;
                long jInvoke = C2991b.this.b.invoke();
                String strA = C2991b.this.a();
                TimerEvent timerEventWithTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Creating " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                C2991b c2991b = C2991b.this;
                Function1 function1 = c2991b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f2167a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jInvoke;
                this.e = 1;
                objA = c2991b.a(function1, sVar2, metricsRecorder, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sVar = sVar2;
                timerEvent = timerEventWithTag;
                str = strA;
                j = jInvoke;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f2167a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                str = str2;
                sVar = sVar3;
                objA = obj;
            }
            InterfaceC2985a interfaceC2985a = (InterfaceC2985a) objA;
            if (interfaceC2985a != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f2418a.a();
                InterfaceC3005f interfaceC3005fE = a.b.f2420a.e();
                String str3 = this.h;
                a.h hVar = a.h.f2426a;
                long j2 = j;
                InterstitialAd interstitialAdA = interfaceC2985a.a(contextA, interfaceC3005fE, str3, hVar.j(), hVar.f(), a.i.f2427a.c(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C2990a(AdFormatType.INTERSTITIAL, com.moloco.sdk.internal.mediators.b.b(this.j), null), this.g);
                if (interstitialAdA != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.j.c());
                    com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(dVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar.name()).withTag("initial_sdk_init_state", str.toString()));
                    this.g.recordTimerEvent(timerEvent.withTag(dVar.c(), "success"));
                    if (interstitialAdA instanceof r) {
                        ((r) interstitialAdA).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Created " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(interstitialAdA);
                }
            }
            MolocoAdError.AdCreateError adCreateErrorA = C2991b.this.a(this.h, str, timerEvent, sVar, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C2991b.i, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new v.a(adCreateErrorA);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b$h */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createMREC$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {167}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class h extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2168a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super h> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C2991b.this.new h(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            s sVar;
            TimerEvent timerEvent;
            String str;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.c;
                long jA = C2991b.this.b.a();
                String strA = C2991b.this.a();
                TimerEvent timerEventWithTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Creating " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                C2991b c2991b = C2991b.this;
                Function1 function1 = c2991b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f2168a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jA;
                this.e = 1;
                objA = c2991b.a(function1, sVar2, metricsRecorder, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sVar = sVar2;
                timerEvent = timerEventWithTag;
                str = strA;
                j = jA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f2168a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                str = str2;
                sVar = sVar3;
                objA = obj;
            }
            InterfaceC2985a interfaceC2985a = (InterfaceC2985a) objA;
            if (interfaceC2985a != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f2418a.a();
                InterfaceC3005f interfaceC3005fE = a.b.f2420a.e();
                String str3 = this.h;
                a.h hVar = a.h.f2426a;
                long j2 = j;
                ViewParent viewParentA = interfaceC2985a.a(contextA, interfaceC3005fE, str3, hVar.j(), hVar.f(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C2990a(AdFormatType.MREC, com.moloco.sdk.internal.mediators.b.a(this.j), null), hVar.i(), i.b.d, this.g);
                if (viewParentA != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.j.c());
                    com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(dVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar.name()).withTag("initial_sdk_init_state", str.toString()));
                    this.g.recordTimerEvent(timerEvent.withTag(dVar.c(), "success"));
                    if (viewParentA instanceof r) {
                        ((r) viewParentA).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Created " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(viewParentA);
                }
            }
            MolocoAdError.AdCreateError adCreateErrorA = C2991b.this.a(this.h, str, timerEvent, sVar, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C2991b.i, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new v.a(adCreateErrorA);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b$i */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createNativeAd$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {211}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<NativeAd, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2169a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super i> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<NativeAd, MolocoAdError.AdCreateError>> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C2991b.this.new i(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            s sVar;
            TimerEvent timerEvent;
            String str;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.d;
                long jA = C2991b.this.b.a();
                String strA = C2991b.this.a();
                TimerEvent timerEventWithTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Creating " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                C2991b c2991b = C2991b.this;
                Function1 function1 = c2991b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f2169a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jA;
                this.e = 1;
                objA = c2991b.a(function1, sVar2, metricsRecorder, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sVar = sVar2;
                timerEvent = timerEventWithTag;
                str = strA;
                j = jA;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f2169a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                str = str2;
                sVar = sVar3;
                objA = obj;
            }
            InterfaceC2985a interfaceC2985a = (InterfaceC2985a) objA;
            if (interfaceC2985a != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f2418a.a();
                InterfaceC3005f interfaceC3005fE = a.b.f2420a.e();
                com.moloco.sdk.internal.services.n nVarI = a.e.f2423a.i();
                String str3 = this.h;
                a.h hVar = a.h.f2426a;
                long j2 = j;
                NativeAd nativeAdA = interfaceC2985a.a(contextA, interfaceC3005fE, nVarI, str3, hVar.j(), hVar.f(), a.i.f2427a.c(), hVar.i(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C2990a(AdFormatType.NATIVE, com.moloco.sdk.internal.mediators.b.c(this.j), null), hVar.h(), this.g);
                if (nativeAdA != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.j.c());
                    com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(dVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar.name()).withTag("initial_sdk_init_state", str.toString()));
                    this.g.recordTimerEvent(timerEvent.withTag(dVar.c(), "success"));
                    if (nativeAdA instanceof r) {
                        ((r) nativeAdA).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Created " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(nativeAdA);
                }
            }
            MolocoAdError.AdCreateError adCreateErrorA = C2991b.this.a(this.h, str, timerEvent, sVar, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C2991b.i, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new v.a(adCreateErrorA);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.b$j */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.AdCreator$createRewardedInterstitial$2", f = "AdCreator.kt", i = {0, 0, 0, 0}, l = {308}, m = "invokeSuspend", n = {"adType", "isSdkInitialized", "createTimerEvent", "createAdTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
    public static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.v<RewardedInterstitialAd, MolocoAdError.AdCreateError>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2170a;
        public Object b;
        public Object c;
        public long d;
        public int e;
        public final /* synthetic */ MetricsRecorder g;
        public final /* synthetic */ String h;
        public final /* synthetic */ String i;
        public final /* synthetic */ String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(MetricsRecorder metricsRecorder, String str, String str2, String str3, Continuation<? super j> continuation) {
            super(2, continuation);
            this.g = metricsRecorder;
            this.h = str;
            this.i = str2;
            this.j = str3;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.v<RewardedInterstitialAd, MolocoAdError.AdCreateError>> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C2991b.this.new j(this.g, this.h, this.i, this.j, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objA;
            s sVar;
            TimerEvent timerEvent;
            String str;
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                s sVar2 = s.g;
                long jInvoke = C2991b.this.b.invoke();
                String strA = C2991b.this.a();
                TimerEvent timerEventWithTag = this.g.startTimerEvent(com.moloco.sdk.internal.client_metrics_data.e.h.c()).withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar2.name()).withTag("initial_sdk_init_state", strA);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Creating " + sVar2 + " ad with adUnitId: " + this.h, null, false, 12, null);
                C2991b c2991b = C2991b.this;
                Function1 function1 = c2991b.d;
                MetricsRecorder metricsRecorder = this.g;
                this.f2170a = sVar2;
                this.b = strA;
                this.c = timerEventWithTag;
                this.d = jInvoke;
                this.e = 1;
                objA = c2991b.a(function1, sVar2, metricsRecorder, this);
                if (objA == coroutine_suspended) {
                    return coroutine_suspended;
                }
                sVar = sVar2;
                timerEvent = timerEventWithTag;
                str = strA;
                j = jInvoke;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                j = this.d;
                TimerEvent timerEvent2 = (TimerEvent) this.c;
                String str2 = (String) this.b;
                s sVar3 = (s) this.f2170a;
                ResultKt.throwOnFailure(obj);
                timerEvent = timerEvent2;
                str = str2;
                sVar = sVar3;
                objA = obj;
            }
            InterfaceC2985a interfaceC2985a = (InterfaceC2985a) objA;
            if (interfaceC2985a != null) {
                Context contextA = com.moloco.sdk.service_locator.a.f2418a.a();
                InterfaceC3005f interfaceC3005fE = a.b.f2420a.e();
                String str3 = this.h;
                a.h hVar = a.h.f2426a;
                long j2 = j;
                RewardedInterstitialAd rewardedInterstitialAdB = interfaceC2985a.b(contextA, interfaceC3005fE, str3, hVar.j(), hVar.f(), a.i.f2427a.c(), new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.A(this.i), new C2990a(AdFormatType.REWARDED, com.moloco.sdk.internal.mediators.b.b(this.j), null), this.g);
                if (rewardedInterstitialAdB != null) {
                    MetricsRecorder metricsRecorder2 = this.g;
                    CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.j.c());
                    com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
                    metricsRecorder2.recordCountEvent(countEvent.withTag(dVar.c(), "success").withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar.name()).withTag("initial_sdk_init_state", str));
                    this.g.recordTimerEvent(timerEvent.withTag(dVar.c(), "success"));
                    if (rewardedInterstitialAdB instanceof r) {
                        ((r) rewardedInterstitialAdB).setCreateAdObjectStartTime(j2);
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, C2991b.i, "Created " + sVar + " ad with adUnitId: " + this.h, null, false, 12, null);
                    return new v.b(rewardedInterstitialAdB);
                }
            }
            MolocoAdError.AdCreateError adCreateErrorA = C2991b.this.a(this.h, str, timerEvent, sVar, this.g);
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, C2991b.i, "Failed to create " + sVar + " with reason: " + adCreateErrorA, null, false, 12, null);
            return new v.a(adCreateErrorA);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C2991b(StateFlow<? extends Initialization> initializationState, I timeProviderService, C2992c adCreatorConfiguration, Function1<? super Continuation<? super InterfaceC2985a>, ? extends Object> awaitAdFactory) {
        Intrinsics.checkNotNullParameter(initializationState, "initializationState");
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        Intrinsics.checkNotNullParameter(adCreatorConfiguration, "adCreatorConfiguration");
        Intrinsics.checkNotNullParameter(awaitAdFactory, "awaitAdFactory");
        this.f2161a = initializationState;
        this.b = timeProviderService;
        this.c = adCreatorConfiguration;
        this.d = awaitAdFactory;
        this.e = com.moloco.sdk.internal.scheduling.b.a().getDefault();
    }

    public final Object d(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new h(metricsRecorder, str2, str3, str, null), continuation);
    }

    public final Object e(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<NativeAd, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new i(metricsRecorder, str2, str3, str, null), continuation);
    }

    public final Object f(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<RewardedInterstitialAd, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new j(metricsRecorder, str2, str3, str, null), continuation);
    }

    public static /* synthetic */ Object d(C2991b c2991b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c2991b.d(str, str2, metricsRecorder, str3, continuation);
    }

    public static /* synthetic */ Object e(C2991b c2991b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c2991b.e(str, str2, metricsRecorder, str3, continuation);
    }

    public static /* synthetic */ Object f(C2991b c2991b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c2991b.f(str, str2, metricsRecorder, str3, continuation);
    }

    public final Object b(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new f(metricsRecorder, str2, str3, str, null), continuation);
    }

    public final Object c(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<InterstitialAd, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new g(metricsRecorder, str2, str3, str, null), continuation);
    }

    public static /* synthetic */ Object b(C2991b c2991b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c2991b.b(str, str2, metricsRecorder, str3, continuation);
    }

    public static /* synthetic */ Object c(C2991b c2991b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c2991b.c(str, str2, metricsRecorder, str3, continuation);
    }

    public final Object a(String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>> continuation) {
        return BuildersKt.withContext(this.e, new e(metricsRecorder, str2, str3, str, null), continuation);
    }

    public static /* synthetic */ Object a(C2991b c2991b, String str, String str2, MetricsRecorder metricsRecorder, String str3, Continuation continuation, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        return c2991b.a(str, str2, metricsRecorder, str3, (Continuation<? super com.moloco.sdk.internal.v<Banner, MolocoAdError.AdCreateError>>) continuation);
    }

    public final MolocoAdError.AdCreateError a(String str, String str2, TimerEvent timerEvent, s sVar, MetricsRecorder metricsRecorder) {
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.j.c());
        com.moloco.sdk.internal.client_metrics_data.d dVar = com.moloco.sdk.internal.client_metrics_data.d.d;
        CountEvent countEventWithTag = countEvent.withTag(dVar.c(), LoginLogger.EVENT_EXTRAS_FAILURE).withTag("initial_sdk_init_state", str2).withTag(com.moloco.sdk.internal.client_metrics_data.d.c.c(), sVar.name());
        Initialization value = this.f2161a.getValue();
        int i2 = value == null ? -1 : C0392b.f2162a[value.ordinal()];
        if (i2 == -1) {
            com.moloco.sdk.internal.error.b bVarF = a.b.f2420a.f();
            StringBuilder sb = new StringBuilder("CREATE_");
            String upperCase = sVar.name().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            sb.append(upperCase);
            sb.append("_AD_FAILED_SDK_INIT_NOT_COMPLETED");
            b.a.a(bVarF, sb.toString(), null, 2, null);
            TimerEvent timerEventWithTag = timerEvent.withTag(dVar.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.d dVar2 = com.moloco.sdk.internal.client_metrics_data.d.b;
            metricsRecorder.recordTimerEvent(timerEventWithTag.withTag(dVar2.c(), "sdk_init_not_completed"));
            metricsRecorder.recordCountEvent(countEventWithTag.withTag(dVar2.c(), "sdk_init_not_completed"));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, i, "Cannot retrieve AdFactory as SDK init was not called or not completed", null, false, 12, null);
            return MolocoAdError.AdCreateError.SDK_INIT_WAS_NOT_COMPLETED;
        }
        if (i2 == 1) {
            b.a.a(a.b.f2420a.f(), h, null, 2, null);
            TimerEvent timerEventWithTag2 = timerEvent.withTag(dVar.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.d dVar3 = com.moloco.sdk.internal.client_metrics_data.d.b;
            metricsRecorder.recordTimerEvent(timerEventWithTag2.withTag(dVar3.c(), "unable_to_create_ad"));
            metricsRecorder.recordCountEvent(countEventWithTag.withTag(dVar3.c(), "unable_to_create_ad"));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, i, "Could not find the adUnitId that was requested for load: " + str, null, false, 12, null);
            return MolocoAdError.AdCreateError.UNABLE_TO_CREATE_AD;
        }
        if (i2 == 2) {
            com.moloco.sdk.internal.error.b bVarF2 = a.b.f2420a.f();
            StringBuilder sb2 = new StringBuilder("CREATE_");
            String upperCase2 = sVar.name().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            sb2.append(upperCase2);
            sb2.append("_AD_FAILED_SDK_INIT_FAILED");
            b.a.a(bVarF2, sb2.toString(), null, 2, null);
            TimerEvent timerEventWithTag3 = timerEvent.withTag(dVar.c(), LoginLogger.EVENT_EXTRAS_FAILURE);
            com.moloco.sdk.internal.client_metrics_data.d dVar4 = com.moloco.sdk.internal.client_metrics_data.d.b;
            metricsRecorder.recordTimerEvent(timerEventWithTag3.withTag(dVar4.c(), "sdk_init_failed"));
            metricsRecorder.recordCountEvent(countEventWithTag.withTag(dVar4.c(), "sdk_init_failed"));
            MolocoLogger.error$default(MolocoLogger.INSTANCE, i, "Cannot create AdFactory as SDK init was failure", null, false, 12, null);
            return MolocoAdError.AdCreateError.SDK_INIT_FAILED;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.InterfaceC2985a>, ? extends java.lang.Object> r19, com.moloco.sdk.internal.publisher.s r20, com.moloco.sdk.acm.recorder.MetricsRecorder r21, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.InterfaceC2985a> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.C2991b.a(kotlin.jvm.functions.Function1, com.moloco.sdk.internal.publisher.s, com.moloco.sdk.acm.recorder.MetricsRecorder, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String a() {
        String strName;
        Initialization value = this.f2161a.getValue();
        if (value != null && (strName = value.name()) != null) {
            String lowerCase = strName.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                return lowerCase;
            }
        }
        return "not_invoked_or_in_progress";
    }
}
