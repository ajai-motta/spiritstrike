package com.moloco.sdk.publisher;

import android.content.Context;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.adxcorp.util.ADXLogUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.Init;
import com.moloco.sdk.acm.AndroidClientMetrics;
import com.moloco.sdk.acm.CountEvent;
import com.moloco.sdk.acm.InitConfig;
import com.moloco.sdk.acm.UpdateConfig;
import com.moloco.sdk.acm.recorder.MetricsRecorder;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.android_context.b;
import com.moloco.sdk.internal.publisher.C2991b;
import com.moloco.sdk.internal.publisher.C2992c;
import com.moloco.sdk.internal.publisher.w;
import com.moloco.sdk.internal.scheduling.c;
import com.moloco.sdk.internal.services.bidtoken.h;
import com.moloco.sdk.internal.services.bidtoken.i;
import com.moloco.sdk.internal.services.bidtoken.n;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.init.MolocoInitParams;
import com.moloco.sdk.service_locator.a;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\"\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013Jk\u0010 \u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`\u001eH\u0007¢\u0006\u0004\b \u0010!Jk\u0010\"\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`\u001eH\u0007¢\u0006\u0004\b\"\u0010!Jk\u0010#\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`\u001eH\u0007¢\u0006\u0004\b#\u0010!Jk\u0010'\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010$¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`&H\u0007¢\u0006\u0004\b'\u0010!Jk\u0010+\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010(¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b()\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`*H\u0007¢\u0006\u0004\b+\u0010!Jk\u0010/\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00142>\u0010\u001f\u001a:\u0012\u0015\u0012\u0013\u0018\u00010,¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(-\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\b0\u0017j\u0002`.H\u0007¢\u0006\u0004\b/\u0010!J\u0017\u00102\u001a\u00020\b2\u0006\u00101\u001a\u000200H\u0002¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\bH\u0082@¢\u0006\u0004\b4\u00105J\u0017\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0004H\u0002¢\u0006\u0004\b7\u0010\fJ\u000f\u00108\u001a\u00020\bH\u0002¢\u0006\u0004\b8\u0010\u0003J\u0017\u0010;\u001a\u00020:2\u0006\u00109\u001a\u00020\u0014H\u0002¢\u0006\u0004\b;\u0010<J\u0010\u0010>\u001a\u00020\bH\u0081@¢\u0006\u0004\b=\u00105R2\u0010A\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060@0?8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bA\u0010B\u0012\u0004\bE\u0010\u0003\u001a\u0004\bC\u0010DR\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00140F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020I8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010K\u001a\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010K\u001a\u0004\b[\u0010\\R*\u0010_\u001a\u0004\u0018\u00010^8\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b_\u0010`\u0012\u0004\be\u0010\u0003\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR*\u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b6\u0010f\u0012\u0004\bj\u0010\u0003\u001a\u0004\bg\u0010h\"\u0004\bi\u0010\fR\u001a\u0010k\u001a\u00020:8FX\u0087\u0004¢\u0006\f\u0012\u0004\bm\u0010\u0003\u001a\u0004\bk\u0010lR\u0016\u0010p\u001a\u0004\u0018\u00010\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u001a\u0010t\u001a\b\u0012\u0004\u0012\u00020\u00140q8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\br\u0010s¨\u0006u"}, d2 = {"Lcom/moloco/sdk/publisher/Moloco;", "", "<init>", "()V", "Lcom/moloco/sdk/publisher/init/MolocoInitParams;", "initParam", "Lcom/moloco/sdk/publisher/MolocoInitializationListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", MobileAdsBridgeBase.initializeMethodName, "(Lcom/moloco/sdk/publisher/init/MolocoInitParams;Lcom/moloco/sdk/publisher/MolocoInitializationListener;)V", "logMolocoInfo", "(Lcom/moloco/sdk/publisher/init/MolocoInitParams;)V", "Lcom/moloco/sdk/publisher/MediationInfo;", "mediationInfo", "Landroid/content/Context;", "context", "Lcom/moloco/sdk/publisher/MolocoBidTokenListener;", "getBidToken", "(Lcom/moloco/sdk/publisher/MediationInfo;Landroid/content/Context;Lcom/moloco/sdk/publisher/MolocoBidTokenListener;)V", "", HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID, "watermarkString", "Lkotlin/Function2;", "Lcom/moloco/sdk/publisher/Banner;", "Lkotlin/ParameterName;", "name", ReportUtil.INVENTORY_TYPE_BANNER, "Lcom/moloco/sdk/publisher/MolocoAdError$AdCreateError;", "error", "Lcom/moloco/sdk/publisher/CreateBannerCallback;", "callback", "createBanner", "(Lcom/moloco/sdk/publisher/MediationInfo;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "createBannerTablet", "createMREC", "Lcom/moloco/sdk/publisher/NativeAd;", "nativeAd", "Lcom/moloco/sdk/publisher/CreateNativeAdCallback;", "createNativeAd", "Lcom/moloco/sdk/publisher/InterstitialAd;", "interstitialAd", "Lcom/moloco/sdk/publisher/CreateInterstitialAdCallback;", "createInterstitial", "Lcom/moloco/sdk/publisher/RewardedInterstitialAd;", "rewardedInterstitialAd", "Lcom/moloco/sdk/publisher/CreateRewardedInterstitialAdCallback;", "createRewardedInterstitial", "Lcom/moloco/sdk/Init$SDKInitResponse;", "sdkInitResponse", "processInitConfigs", "(Lcom/moloco/sdk/Init$SDKInitResponse;)V", "updateAndroidClientMetricsOnInitSuccess", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initParams", "initializeAndroidClientMetrics", "initializeILRD", "mediationName", "", "shouldInitializeILRD", "(Ljava/lang/String;)Z", "clearState$moloco_sdk_release", "clearState", "", "", "pendingInitByMediator", "Ljava/util/Map;", "getPendingInitByMediator$moloco_sdk_release", "()Ljava/util/Map;", "getPendingInitByMediator$moloco_sdk_release$annotations", "", "_failedMediations", "Ljava/util/Set;", "Lcom/moloco/sdk/internal/publisher/v;", "initializationHandler$delegate", "Lkotlin/Lazy;", "getInitializationHandler", "()Lcom/moloco/sdk/internal/publisher/v;", "initializationHandler", "Lcom/moloco/sdk/internal/services/bidtoken/h;", "bidTokenHandler$delegate", "getBidTokenHandler", "()Lcom/moloco/sdk/internal/services/bidtoken/h;", "bidTokenHandler", "Lcom/moloco/sdk/internal/publisher/b;", "adCreator$delegate", "getAdCreator", "()Lcom/moloco/sdk/internal/publisher/b;", "adCreator", "Lkotlinx/coroutines/CoroutineScope;", "scope$delegate", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/Job;", "initJob", "Lkotlinx/coroutines/Job;", "getInitJob", "()Lkotlinx/coroutines/Job;", "setInitJob", "(Lkotlinx/coroutines/Job;)V", "getInitJob$annotations", "Lcom/moloco/sdk/publisher/init/MolocoInitParams;", "getInitParams", "()Lcom/moloco/sdk/publisher/init/MolocoInitParams;", "setInitParams", "getInitParams$annotations", "isInitialized", "()Z", "isInitialized$annotations", "getAppKey$moloco_sdk_release", "()Ljava/lang/String;", "appKey", "", "getFailedMediations$moloco_sdk_release", "()Ljava/util/Set;", "failedMediations", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
public final class Moloco {
    private static Job initJob;
    private static MolocoInitParams initParams;
    public static final Moloco INSTANCE = new Moloco();
    private static final Map<String, List<MolocoInitializationListener>> pendingInitByMediator = new LinkedHashMap();
    private static final Set<String> _failedMediations = new LinkedHashSet();

    /* JADX INFO: renamed from: initializationHandler$delegate, reason: from kotlin metadata */
    private static final Lazy initializationHandler = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.publisher.Moloco$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Moloco.initializationHandler_delegate$lambda$7();
        }
    });

    /* JADX INFO: renamed from: bidTokenHandler$delegate, reason: from kotlin metadata */
    private static final Lazy bidTokenHandler = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.publisher.Moloco$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Moloco.bidTokenHandler_delegate$lambda$8();
        }
    });

    /* JADX INFO: renamed from: adCreator$delegate, reason: from kotlin metadata */
    private static final Lazy adCreator = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.publisher.Moloco$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Moloco.adCreator_delegate$lambda$9();
        }
    });

    /* JADX INFO: renamed from: scope$delegate, reason: from kotlin metadata */
    private static final Lazy scope = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.publisher.Moloco$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Moloco.scope_delegate$lambda$10();
        }
    });
    public static final int $stable = 8;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Init.SDKInitResponse.SupportedNetworks.values().length];
            try {
                iArr[Init.SDKInitResponse.SupportedNetworks.LEVEL_PLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createBanner$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createBanner$1", f = "Moloco.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<Banner, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ MediationInfo $mediationInfo;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(MediationInfo mediationInfo, String str, String str2, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$mediationInfo = mediationInfo;
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$mediationInfo, this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsRecorder metricsRecorderCreate = MetricsRecorder.INSTANCE.create(this.$mediationInfo.getName());
                C2991b adCreator = Moloco.INSTANCE.getAdCreator();
                String name = this.$mediationInfo.getName();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.a(name, str, metricsRecorderCreate, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            v vVar = (v) obj;
            if (vVar instanceof v.b) {
                pair = TuplesKt.to(((v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((v.a) vVar).a());
            }
            Banner banner = (Banner) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("Banner for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(banner == null);
            MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, sb.toString(), null, false, 12, null);
            this.$callback.invoke(banner, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createBannerTablet$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createBannerTablet$1", f = "Moloco.kt", i = {}, l = {280}, m = "invokeSuspend", n = {}, s = {})
    public static final class C30111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<Banner, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ MediationInfo $mediationInfo;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C30111(MediationInfo mediationInfo, String str, String str2, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super C30111> continuation) {
            super(2, continuation);
            this.$mediationInfo = mediationInfo;
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30111(this.$mediationInfo, this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsRecorder metricsRecorderCreate = MetricsRecorder.INSTANCE.create(this.$mediationInfo.getName());
                C2991b adCreator = Moloco.INSTANCE.getAdCreator();
                String name = this.$mediationInfo.getName();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.b(name, str, metricsRecorderCreate, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            v vVar = (v) obj;
            if (vVar instanceof v.b) {
                pair = TuplesKt.to(((v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((v.a) vVar).a());
            }
            Banner banner = (Banner) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("Banner for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(banner == null);
            MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, sb.toString(), null, false, 12, null);
            this.$callback.invoke(banner, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createInterstitial$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createInterstitial$1", f = "Moloco.kt", i = {}, l = {372}, m = "invokeSuspend", n = {}, s = {})
    public static final class C30121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<InterstitialAd, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ MediationInfo $mediationInfo;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C30121(MediationInfo mediationInfo, String str, String str2, Function2<? super InterstitialAd, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super C30121> continuation) {
            super(2, continuation);
            this.$mediationInfo = mediationInfo;
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30121(this.$mediationInfo, this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsRecorder metricsRecorderCreate = MetricsRecorder.INSTANCE.create(this.$mediationInfo.getName());
                C2991b adCreator = Moloco.INSTANCE.getAdCreator();
                String name = this.$mediationInfo.getName();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.c(name, str, metricsRecorderCreate, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            v vVar = (v) obj;
            if (vVar instanceof v.b) {
                pair = TuplesKt.to(((v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((v.a) vVar).a());
            }
            InterstitialAd interstitialAd = (InterstitialAd) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("Interstitial for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(interstitialAd == null);
            MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, sb.toString(), null, false, 12, null);
            this.$callback.invoke(interstitialAd, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createMREC$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createMREC$1", f = "Moloco.kt", i = {}, l = {311}, m = "invokeSuspend", n = {}, s = {})
    public static final class C30131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<Banner, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ MediationInfo $mediationInfo;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C30131(MediationInfo mediationInfo, String str, String str2, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super C30131> continuation) {
            super(2, continuation);
            this.$mediationInfo = mediationInfo;
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30131(this.$mediationInfo, this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsRecorder metricsRecorderCreate = MetricsRecorder.INSTANCE.create(this.$mediationInfo.getName());
                C2991b adCreator = Moloco.INSTANCE.getAdCreator();
                String name = this.$mediationInfo.getName();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.d(name, str, metricsRecorderCreate, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            v vVar = (v) obj;
            if (vVar instanceof v.b) {
                pair = TuplesKt.to(((v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((v.a) vVar).a());
            }
            Banner banner = (Banner) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("MREC for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(banner == null);
            MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, sb.toString(), null, false, 12, null);
            this.$callback.invoke(banner, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createNativeAd$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createNativeAd$1", f = "Moloco.kt", i = {}, l = {343}, m = "invokeSuspend", n = {}, s = {})
    public static final class C30141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<NativeAd, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ MediationInfo $mediationInfo;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C30141(MediationInfo mediationInfo, String str, String str2, Function2<? super NativeAd, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super C30141> continuation) {
            super(2, continuation);
            this.$mediationInfo = mediationInfo;
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30141(this.$mediationInfo, this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsRecorder metricsRecorderCreate = MetricsRecorder.INSTANCE.create(this.$mediationInfo.getName());
                C2991b adCreator = Moloco.INSTANCE.getAdCreator();
                String name = this.$mediationInfo.getName();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.e(name, str, metricsRecorderCreate, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            v vVar = (v) obj;
            if (vVar instanceof v.b) {
                pair = TuplesKt.to(((v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((v.a) vVar).a());
            }
            NativeAd nativeAd = (NativeAd) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("Native Ad for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(nativeAd == null);
            MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, sb.toString(), null, false, 12, null);
            this.$callback.invoke(nativeAd, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$createRewardedInterstitial$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$createRewardedInterstitial$1", f = "Moloco.kt", i = {}, l = {402}, m = "invokeSuspend", n = {}, s = {})
    public static final class C30151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $adUnitId;
        final /* synthetic */ Function2<RewardedInterstitialAd, MolocoAdError.AdCreateError, Unit> $callback;
        final /* synthetic */ MediationInfo $mediationInfo;
        final /* synthetic */ String $watermarkString;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C30151(MediationInfo mediationInfo, String str, String str2, Function2<? super RewardedInterstitialAd, ? super MolocoAdError.AdCreateError, Unit> function2, Continuation<? super C30151> continuation) {
            super(2, continuation);
            this.$mediationInfo = mediationInfo;
            this.$adUnitId = str;
            this.$watermarkString = str2;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30151(this.$mediationInfo, this.$adUnitId, this.$watermarkString, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Pair pair;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsRecorder metricsRecorderCreate = MetricsRecorder.INSTANCE.create(this.$mediationInfo.getName());
                C2991b adCreator = Moloco.INSTANCE.getAdCreator();
                String name = this.$mediationInfo.getName();
                String str = this.$adUnitId;
                String str2 = this.$watermarkString;
                this.label = 1;
                obj = adCreator.f(name, str, metricsRecorderCreate, str2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            v vVar = (v) obj;
            if (vVar instanceof v.b) {
                pair = TuplesKt.to(((v.b) vVar).a(), null);
            } else {
                if (!(vVar instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                pair = TuplesKt.to(null, ((v.a) vVar).a());
            }
            RewardedInterstitialAd rewardedInterstitialAd = (RewardedInterstitialAd) pair.component1();
            MolocoAdError.AdCreateError adCreateError = (MolocoAdError.AdCreateError) pair.component2();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            StringBuilder sb = new StringBuilder("Rewarded for adUnitId: ");
            sb.append(this.$adUnitId);
            sb.append(" has error: ");
            sb.append(rewardedInterstitialAd == null);
            MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, sb.toString(), null, false, 12, null);
            this.$callback.invoke(rewardedInterstitialAd, adCreateError);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$getBidToken$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$getBidToken$1", f = "Moloco.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
    public static final class C30161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MolocoBidTokenListener $listener;
        final /* synthetic */ MediationInfo $mediationInfo;
        final /* synthetic */ MetricsRecorder $metricsRecorder;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C30161(MetricsRecorder metricsRecorder, MediationInfo mediationInfo, MolocoBidTokenListener molocoBidTokenListener, Continuation<? super C30161> continuation) {
            super(2, continuation);
            this.$metricsRecorder = metricsRecorder;
            this.$mediationInfo = mediationInfo;
            this.$listener = molocoBidTokenListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C30161(this.$metricsRecorder, this.$mediationInfo, this.$listener, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "Handling bid token request", null, false, 12, null);
                h bidTokenHandler = Moloco.INSTANCE.getBidTokenHandler();
                MetricsRecorder metricsRecorder = this.$metricsRecorder;
                MediationInfo mediationInfo = this.$mediationInfo;
                MolocoBidTokenListener molocoBidTokenListener = this.$listener;
                this.label = 1;
                if (bidTokenHandler.a(metricsRecorder, mediationInfo, molocoBidTokenListener, this) == coroutine_suspended) {
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

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C30161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.publisher.Moloco$initialize$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.moloco.sdk.publisher.Moloco$initialize$2", f = "Moloco.kt", i = {}, l = {149, 151, 174}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ MolocoInitParams $initParam;
        final /* synthetic */ MolocoInitializationListener $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(MolocoInitParams molocoInitParams, MolocoInitializationListener molocoInitializationListener, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$initParam = molocoInitParams;
            this.$listener = molocoInitializationListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$initParam, this.$listener, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0132 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 459
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.publisher.Moloco.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private Moloco() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C2991b adCreator_delegate$lambda$9() {
        return new C2991b(INSTANCE.getInitializationHandler().d(), a.h.f2426a.h(), new C2992c(null, 0L, 3, null), new Moloco$adCreator$2$1(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final i bidTokenHandler_delegate$lambda$8() {
        return new i(n.a(), INSTANCE.getInitializationHandler(), a.h.f2426a.h());
    }

    @JvmStatic
    public static final void createBanner(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(INSTANCE.getScope(), null, null, new AnonymousClass1(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createBanner$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createBanner(mediationInfo, str, str2, function2);
    }

    @JvmStatic
    public static final void createBannerTablet(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner tablet async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(INSTANCE.getScope(), null, null, new C30111(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createBannerTablet$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createBannerTablet(mediationInfo, str, str2, function2);
    }

    @JvmStatic
    public static final void createInterstitial(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super InterstitialAd, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating interstitial ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(INSTANCE.getScope(), null, null, new C30121(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createInterstitial$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createInterstitial(mediationInfo, str, str2, function2);
    }

    @JvmStatic
    public static final void createMREC(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super Banner, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating banner MREC async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(INSTANCE.getScope(), null, null, new C30131(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createMREC$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createMREC(mediationInfo, str, str2, function2);
    }

    @JvmStatic
    public static final void createNativeAd(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super NativeAd, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating native ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(INSTANCE.getScope(), null, null, new C30141(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createNativeAd$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createNativeAd(mediationInfo, str, str2, function2);
    }

    @JvmStatic
    public static final void createRewardedInterstitial(MediationInfo mediationInfo, String adUnitId, String watermarkString, Function2<? super RewardedInterstitialAd, ? super MolocoAdError.AdCreateError, Unit> callback) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Creating rewarded ad for mediation async for adUnitId: " + adUnitId, null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(INSTANCE.getScope(), null, null, new C30151(mediationInfo, adUnitId, watermarkString, callback, null), 3, null);
    }

    public static /* synthetic */ void createRewardedInterstitial$default(MediationInfo mediationInfo, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        createRewardedInterstitial(mediationInfo, str, str2, function2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final C2991b getAdCreator() {
        return (C2991b) adCreator.getValue();
    }

    @JvmStatic
    public static final void getBidToken(MediationInfo mediationInfo, Context context, MolocoBidTokenListener listener) {
        Intrinsics.checkNotNullParameter(mediationInfo, "mediationInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        b.a(context);
        MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "[Thread id: " + Thread.currentThread().getId() + ", name: " + Thread.currentThread().getName() + "] Fetching bid token", null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(c.f2269a.b(), null, null, new C30161(MetricsRecorder.INSTANCE.create(mediationInfo.getName()), mediationInfo, listener, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h getBidTokenHandler() {
        return (h) bidTokenHandler.getValue();
    }

    public static /* synthetic */ void getInitJob$annotations() {
    }

    public static /* synthetic */ void getInitParams$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.moloco.sdk.internal.publisher.v getInitializationHandler() {
        return (com.moloco.sdk.internal.publisher.v) initializationHandler.getValue();
    }

    public static /* synthetic */ void getPendingInitByMediator$moloco_sdk_release$annotations() {
    }

    private final CoroutineScope getScope() {
        return (CoroutineScope) scope.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.moloco.sdk.internal.publisher.v initializationHandler_delegate$lambda$7() {
        return new com.moloco.sdk.internal.publisher.v(a.h.f2426a.h());
    }

    @JvmStatic
    public static final void initialize(MolocoInitParams initParam) {
        Intrinsics.checkNotNullParameter(initParam, "initParam");
        initialize$default(initParam, null, 2, null);
    }

    public static /* synthetic */ void initialize$default(MolocoInitParams molocoInitParams, MolocoInitializationListener molocoInitializationListener, int i, Object obj) {
        if ((i & 2) != 0) {
            molocoInitializationListener = null;
        }
        initialize(molocoInitParams, molocoInitializationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeAndroidClientMetrics(MolocoInitParams initParams2) {
        if (!getInitializationHandler().c()) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "ACM cannot be initialized as Moloco SDK cannot be initialized", null, false, 12, null);
            return;
        }
        com.moloco.sdk.internal.configs.a aVarC = com.moloco.sdk.internal.configs.b.c();
        AndroidClientMetrics androidClientMetrics = AndroidClientMetrics.INSTANCE;
        String appKey = initParams2.getAppKey();
        String strD = aVarC.d();
        Context appContext = initParams2.getAppContext();
        long jC = aVarC.c();
        Pair pair = TuplesKt.to(com.moloco.sdk.acm.b.e, initParams2.getAppKey());
        a.e eVar = a.e.f2423a;
        AndroidClientMetrics.initialize$default(androidClientMetrics, new InitConfig(appKey, strD, appContext, jC, MapsKt.mapOf(pair, TuplesKt.to(com.moloco.sdk.acm.b.f, eVar.h().invoke().b()), TuplesKt.to(com.moloco.sdk.acm.b.g, eVar.h().invoke().c()), TuplesKt.to(com.moloco.sdk.acm.b.h, BuildConfig.SDK_VERSION_NAME), TuplesKt.to(com.moloco.sdk.acm.b.d, eVar.l().invoke().w()), TuplesKt.to(com.moloco.sdk.acm.b.c, eVar.l().invoke().x()))), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeILRD() {
        Init.SDKInitResponse sDKInitResponseE = getInitializationHandler().e();
        if (sDKInitResponseE == null) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "ILRD cannot be initialized as Moloco SDK is not initialized", null, false, 12, null);
            return;
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(a.b.f2420a.g().b(sDKInitResponseE));
        if (thM7418exceptionOrNullimpl != null) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "ILRD initialization failed. " + thM7418exceptionOrNullimpl.getMessage(), null, false, 12, null);
        }
    }

    public static final boolean isInitialized() {
        return INSTANCE.getInitializationHandler().d().getValue() == Initialization.SUCCESS;
    }

    @JvmStatic
    public static /* synthetic */ void isInitialized$annotations() {
    }

    private final void logMolocoInfo(MolocoInitParams initParam) {
        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
        MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "=====================================", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "Moloco SDK initializing", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "SDK Version: 4.2.1", null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "Mediation: " + initParam.getMediationInfo().getName(), null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "isInitialized: " + isInitialized(), null, false, 12, null);
        MolocoLogger.info$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "=====================================", null, false, 12, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processInitConfigs(Init.SDKInitResponse sdkInitResponse) {
        if (sdkInitResponse.hasEventCollectionConfig()) {
            Init.SDKInitResponse.EventCollectionConfig eventCollectionConfig = sdkInitResponse.getEventCollectionConfig();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            MolocoLogger.debug$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "Init response has eventCollectionConfig", false, 4, null);
            MolocoLogger.debug$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "eventCollectionConfig:", false, 4, null);
            MolocoLogger.debug$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "eventCollectionEnabled: " + eventCollectionConfig.getEventCollectionEnabled(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "mrefCollectionEnabled: " + eventCollectionConfig.getMrefCollectionEnabled(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "appFgUrl: " + eventCollectionConfig.getAppForegroundTrackingUrl(), false, 4, null);
            MolocoLogger.debug$default(molocoLogger, ADXLogUtil.PLATFORM_MOLOCO, "appBgUrl: " + eventCollectionConfig.getAppBackgroundTrackingUrl(), false, 4, null);
            com.moloco.sdk.xenoss.sdkdevkit.android.core.services.c cVarC = a.k.f2429a.c();
            boolean eventCollectionEnabled = eventCollectionConfig.getEventCollectionEnabled();
            boolean mrefCollectionEnabled = eventCollectionConfig.getMrefCollectionEnabled();
            String appForegroundTrackingUrl = eventCollectionConfig.getAppForegroundTrackingUrl();
            Intrinsics.checkNotNullExpressionValue(appForegroundTrackingUrl, "getAppForegroundTrackingUrl(...)");
            String appBackgroundTrackingUrl = eventCollectionConfig.getAppBackgroundTrackingUrl();
            Intrinsics.checkNotNullExpressionValue(appBackgroundTrackingUrl, "getAppBackgroundTrackingUrl(...)");
            cVarC.a(eventCollectionEnabled, mrefCollectionEnabled, appForegroundTrackingUrl, appBackgroundTrackingUrl);
            if (eventCollectionConfig.getEventCollectionEnabled()) {
                a.b.f2420a.e().a();
            }
        } else {
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "Init response does not have eventCollectionConfig", false, 4, null);
        }
        a.c.f2421a.b().a(sdkInitResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineScope scope_delegate$lambda$10() {
        return CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMain());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean shouldInitializeILRD(String mediationName) {
        Init.SDKInitResponse.ILRDConfig ilrdConfig;
        List<Init.SDKInitResponse.SupportedNetworks> supportedNetworksList;
        Init.SDKInitResponse sDKInitResponseE = getInitializationHandler().e();
        if (sDKInitResponseE == null || (ilrdConfig = sDKInitResponseE.getIlrdConfig()) == null || (supportedNetworksList = ilrdConfig.getSupportedNetworksList()) == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(supportedNetworksList, 10));
        for (Init.SDKInitResponse.SupportedNetworks supportedNetworks : supportedNetworksList) {
            String lowerCase = ((supportedNetworks != null && WhenMappings.$EnumSwitchMapping$0[supportedNetworks.ordinal()] == 1) ? "LevelPlay" : supportedNetworks.name()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            arrayList.add(lowerCase);
        }
        String lowerCase2 = mediationName.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return arrayList.contains(lowerCase2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateAndroidClientMetricsOnInitSuccess(Continuation<? super Unit> continuation) throws Throwable {
        Object objUpdateConfig = AndroidClientMetrics.INSTANCE.updateConfig(new UpdateConfig(((com.moloco.sdk.internal.configs.a) a.c.f2421a.b().a(com.moloco.sdk.internal.configs.a.class, com.moloco.sdk.internal.configs.b.c())).d(), Boxing.boxLong(r0.c())), continuation);
        return objUpdateConfig == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objUpdateConfig : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object clearState$moloco_sdk_release(kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            r12 = this;
            boolean r0 = r13 instanceof com.moloco.sdk.publisher.Moloco$clearState$1
            if (r0 == 0) goto L13
            r0 = r13
            com.moloco.sdk.publisher.Moloco$clearState$1 r0 = (com.moloco.sdk.publisher.Moloco$clearState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.moloco.sdk.publisher.Moloco$clearState$1 r0 = new com.moloco.sdk.publisher.Moloco$clearState$1
            r0.<init>(r12, r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r13)
            goto L74
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L35:
            java.lang.Object r2 = r0.L$0
            com.moloco.sdk.publisher.Moloco r2 = (com.moloco.sdk.publisher.Moloco) r2
            kotlin.ResultKt.throwOnFailure(r13)
            goto L5e
        L3d:
            kotlin.ResultKt.throwOnFailure(r13)
            com.moloco.sdk.internal.MolocoLogger r6 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            r10 = 4
            r11 = 0
            java.lang.String r7 = "Moloco"
            java.lang.String r8 = "clearState() unit testing function called"
            r9 = 0
            com.moloco.sdk.internal.MolocoLogger.debug$default(r6, r7, r8, r9, r10, r11)
            com.moloco.sdk.publisher.Moloco.initParams = r5
            kotlinx.coroutines.Job r13 = com.moloco.sdk.publisher.Moloco.initJob
            if (r13 == 0) goto L5d
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r13 = kotlinx.coroutines.JobKt.cancelAndJoin(r13, r0)
            if (r13 != r1) goto L5d
            return r1
        L5d:
            r2 = r12
        L5e:
            com.moloco.sdk.publisher.Moloco.initJob = r5
            java.util.Map<java.lang.String, java.util.List<com.moloco.sdk.publisher.MolocoInitializationListener>> r13 = com.moloco.sdk.publisher.Moloco.pendingInitByMediator
            r13.clear()
            com.moloco.sdk.internal.publisher.v r13 = r2.getInitializationHandler()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r13 = r13.b(r0)
            if (r13 != r1) goto L74
            return r1
        L74:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.publisher.Moloco.clearState$moloco_sdk_release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getAppKey$moloco_sdk_release() {
        MolocoInitParams molocoInitParams = initParams;
        if (molocoInitParams != null) {
            return molocoInitParams.getAppKey();
        }
        return null;
    }

    public final Set<String> getFailedMediations$moloco_sdk_release() {
        return CollectionsKt.toSet(_failedMediations);
    }

    public final Job getInitJob() {
        return initJob;
    }

    public final MolocoInitParams getInitParams() {
        return initParams;
    }

    public final Map<String, List<MolocoInitializationListener>> getPendingInitByMediator$moloco_sdk_release() {
        return pendingInitByMediator;
    }

    public final void setInitJob(Job job) {
        initJob = job;
    }

    public final void setInitParams(MolocoInitParams molocoInitParams) {
        initParams = molocoInitParams;
    }

    @JvmStatic
    public static final synchronized void initialize(MolocoInitParams initParam, MolocoInitializationListener listener) {
        Intrinsics.checkNotNullParameter(initParam, "initParam");
        Moloco moloco = INSTANCE;
        moloco.logMolocoInfo(initParam);
        if (initParam.getAppKey().length() == 0) {
            throw new IllegalArgumentException("Moloco SDK initialized with empty appKey");
        }
        if (isInitialized()) {
            if (Intrinsics.areEqual(initParam.getAppKey(), moloco.getAppKey$moloco_sdk_release())) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "Already initialized. Returning and notifying listener", null, false, 12, null);
                if (moloco.shouldInitializeILRD(initParam.getMediationInfo().getName())) {
                    moloco.initializeILRD();
                }
                if (listener != null) {
                    w.a(listener, com.moloco.sdk.internal.publisher.v.f.a());
                }
            } else {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "Already initialized but with different appKey. Returning error and notifying listener", null, false, 12, null);
                _failedMediations.add(initParam.getMediationInfo().getName());
                MetricsRecorder.INSTANCE.create(initParam.getMediationInfo().getName()).recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.i.c()));
                if (listener != null) {
                    w.a(listener, com.moloco.sdk.internal.publisher.v.f.a(com.moloco.sdk.internal.publisher.v.k));
                }
            }
            return;
        }
        synchronized (moloco) {
            Job job = initJob;
            if (job == null || !job.isActive()) {
                Unit unit = Unit.INSTANCE;
                initParams = initParam;
                b.a(initParam.getAppContext());
                initJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getIo()), null, null, new AnonymousClass2(initParam, listener, null), 3, null);
                return;
            }
            String appKey = initParam.getAppKey();
            MolocoInitParams molocoInitParams = initParams;
            if (!Intrinsics.areEqual(appKey, molocoInitParams != null ? molocoInitParams.getAppKey() : null)) {
                MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "Init Job active with different appKey. Notifying listener and avoiding init", null, false, 12, null);
                _failedMediations.add(initParam.getMediationInfo().getName());
                MetricsRecorder.INSTANCE.create(initParam.getMediationInfo().getName()).recordCountEvent(new CountEvent(com.moloco.sdk.internal.client_metrics_data.b.i.c()));
                if (listener != null) {
                    w.a(listener, com.moloco.sdk.internal.publisher.v.f.a(com.moloco.sdk.internal.publisher.v.l));
                }
                return;
            }
            MolocoLogger.info$default(MolocoLogger.INSTANCE, ADXLogUtil.PLATFORM_MOLOCO, "Init Job active with same appKey. Queuing listener and returning for mediator: " + initParam.getMediationInfo().getName(), null, false, 12, null);
            String name = initParam.getMediationInfo().getName();
            Map<String, List<MolocoInitializationListener>> map = pendingInitByMediator;
            List<MolocoInitializationListener> arrayList = map.get(name);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                map.put(name, arrayList);
            }
            List<MolocoInitializationListener> list = arrayList;
            if (listener != null) {
                list.add(listener);
            }
        }
    }
}
