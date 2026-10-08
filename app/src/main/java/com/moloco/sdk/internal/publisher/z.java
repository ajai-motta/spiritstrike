package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.InterfaceC3005f;
import com.moloco.sdk.internal.w;
import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdShowListener;
import com.moloco.sdk.publisher.MolocoAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
public final class z implements y {
    public static final a k = new a(null);
    public static final int l = 8;
    public static final String m = "InternalAdShowListenerImpl";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AdShowListener f2265a;
    public final InterfaceC3005f b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a c;
    public final Function0<com.moloco.sdk.internal.ortb.model.x> d;
    public final Function0<j> e;
    public final com.moloco.sdk.internal.w f;
    public final com.moloco.sdk.internal.f g;
    public final AdFormatType h;
    public final MetricsRecorder i;
    public final com.moloco.sdk.internal.client_metrics_data.a j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.InternalAdShowListenerImpl$onAdShowSuccess$2$1", f = "InternalAdShowListener.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2266a;
        public final /* synthetic */ long c;
        public final /* synthetic */ j d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j, j jVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.c = j;
            this.d = jVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return z.this.new b(this.c, this.d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2266a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar = z.this.c;
                long j = this.c;
                a.AbstractC0526a.e eVar = a.AbstractC0526a.e.b;
                String strA = this.d.a();
                this.f2266a = 1;
                obj = aVar.a(j, eVar, strA, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            z.this.g.a((String) obj);
            return Unit.INSTANCE;
        }
    }

    public z(AdShowListener adShowListener, InterfaceC3005f appLifecycleTrackerService, com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, Function0<com.moloco.sdk.internal.ortb.model.x> provideSdkEvents, Function0<j> provideBUrlData, com.moloco.sdk.internal.w sdkEventUrlTracker, com.moloco.sdk.internal.f bUrlTracker, AdFormatType adType, MetricsRecorder metricsRecorder, com.moloco.sdk.internal.client_metrics_data.a acmClickDeduper) {
        Intrinsics.checkNotNullParameter(appLifecycleTrackerService, "appLifecycleTrackerService");
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(provideSdkEvents, "provideSdkEvents");
        Intrinsics.checkNotNullParameter(provideBUrlData, "provideBUrlData");
        Intrinsics.checkNotNullParameter(sdkEventUrlTracker, "sdkEventUrlTracker");
        Intrinsics.checkNotNullParameter(bUrlTracker, "bUrlTracker");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(metricsRecorder, "metricsRecorder");
        Intrinsics.checkNotNullParameter(acmClickDeduper, "acmClickDeduper");
        this.f2265a = adShowListener;
        this.b = appLifecycleTrackerService;
        this.c = customUserEventBuilderService;
        this.d = provideSdkEvents;
        this.e = provideBUrlData;
        this.f = sdkEventUrlTracker;
        this.g = bUrlTracker;
        this.h = adType;
        this.i = metricsRecorder;
        this.j = acmClickDeduper;
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdClicked(MolocoAd molocoAd) {
        String onAdClicked;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, m, "onAdClicked: " + molocoAd, false, 4, null);
        this.b.b();
        com.moloco.sdk.internal.ortb.model.x xVarInvoke = this.d.invoke();
        if (xVarInvoke != null && (onAdClicked = xVarInvoke.getOnAdClicked()) != null) {
            w.a.a(this.f, onAdClicked, System.currentTimeMillis(), null, 4, null);
        }
        MetricsRecorder metricsRecorder = this.i;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.D.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.d.c.c();
        String lowerCase = this.h.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordCountEvent(countEvent.withTag(strC, lowerCase));
        this.j.a(this.h);
        AdShowListener adShowListener = this.f2265a;
        if (adShowListener != null) {
            adShowListener.onAdClicked(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdHidden(MolocoAd molocoAd) {
        String onAdHidden;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, m, "onAdHidden: " + molocoAd, false, 4, null);
        com.moloco.sdk.internal.ortb.model.x xVarInvoke = this.d.invoke();
        if (xVarInvoke != null && (onAdHidden = xVarInvoke.getOnAdHidden()) != null) {
            w.a.a(this.f, onAdHidden, System.currentTimeMillis(), null, 4, null);
        }
        AdShowListener adShowListener = this.f2265a;
        if (adShowListener != null) {
            adShowListener.onAdHidden(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void onAdShowSuccess(MolocoAd molocoAd) {
        String onAdShowSuccess;
        Intrinsics.checkNotNullParameter(molocoAd, "molocoAd");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, m, "onAdShowSuccess: " + molocoAd, false, 4, null);
        com.moloco.sdk.internal.ortb.model.x xVarInvoke = this.d.invoke();
        if (xVarInvoke != null && (onAdShowSuccess = xVarInvoke.getOnAdShowSuccess()) != null) {
            w.a.a(this.f, onAdShowSuccess, System.currentTimeMillis(), null, 4, null);
        }
        this.j.a();
        j jVarInvoke = this.e.invoke();
        if (jVarInvoke != null) {
            BuildersKt__Builders_commonKt.launch$default(com.moloco.sdk.internal.scheduling.c.f2269a.b(), null, null, new b(System.currentTimeMillis(), jVarInvoke, null), 3, null);
        }
        MetricsRecorder metricsRecorder = this.i;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.B.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.d.c.c();
        String lowerCase = this.h.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordCountEvent(countEvent.withTag(strC, lowerCase));
        AdShowListener adShowListener = this.f2265a;
        if (adShowListener != null) {
            adShowListener.onAdShowSuccess(molocoAd);
        }
    }

    @Override // com.moloco.sdk.internal.publisher.y
    public void a(com.moloco.sdk.internal.s internalError) {
        String onAdShowFailed;
        Intrinsics.checkNotNullParameter(internalError, "internalError");
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, m, "onAdShowFailed: " + internalError, false, 4, null);
        com.moloco.sdk.internal.ortb.model.x xVarInvoke = this.d.invoke();
        if (xVarInvoke != null && (onAdShowFailed = xVarInvoke.getOnAdShowFailed()) != null) {
            this.f.a(onAdShowFailed, System.currentTimeMillis(), internalError);
        }
        MetricsRecorder metricsRecorder = this.i;
        CountEvent countEvent = new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.C.c());
        String strC = com.moloco.sdk.internal.client_metrics_data.d.c.c();
        String lowerCase = this.h.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        metricsRecorder.recordCountEvent(countEvent.withTag(strC, lowerCase).withTag(com.moloco.sdk.internal.client_metrics_data.d.b.c(), String.valueOf(internalError.c().getErrorType())));
        AdShowListener adShowListener = this.f2265a;
        if (adShowListener != null) {
            adShowListener.onAdShowFailed(internalError.c());
        }
    }
}
