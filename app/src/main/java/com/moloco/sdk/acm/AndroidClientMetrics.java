package com.moloco.sdk.acm;

import androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.moloco.sdk.acm.eventprocessing.h;
import com.moloco.sdk.acm.eventprocessing.l;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0003J!\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0086@¢\u0006\u0004\b\u0010\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0018H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010 \u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u001f\u0010\u0003R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b%\u0010&R(\u0010(\u001a\u00020'8\u0000@\u0000X\u0081.¢\u0006\u0018\n\u0004\b(\u0010)\u0012\u0004\b.\u0010\u0003\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0018\u0010/\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u00102\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0014\u00105\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\"\u0010:\u001a\u0010\u0012\f\u0012\n 9*\u0004\u0018\u00010808078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00180<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00110<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010>R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u00168\u0002X\u0082T¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010G\u001a\u0002088@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006H"}, d2 = {"Lcom/moloco/sdk/acm/AndroidClientMetrics;", "", "<init>", "()V", "Lcom/moloco/sdk/acm/UpdateConfig;", "newConfig", "", "updateConfigInternal", "(Lcom/moloco/sdk/acm/UpdateConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processQueuedEvents", "Lcom/moloco/sdk/acm/InitConfig;", "config", "Lcom/moloco/sdk/acm/AndroidClientMetricsCallback;", "callback", MobileAdsBridgeBase.initializeMethodName, "(Lcom/moloco/sdk/acm/InitConfig;Lcom/moloco/sdk/acm/AndroidClientMetricsCallback;)V", "updateConfig", "Lcom/moloco/sdk/acm/CountEvent;", "event", "recordCountEvent$moloco_android_client_metrics_release", "(Lcom/moloco/sdk/acm/CountEvent;)V", "recordCountEvent", "", "eventName", "Lcom/moloco/sdk/acm/TimerEvent;", "startTimerEvent$moloco_android_client_metrics_release", "(Ljava/lang/String;)Lcom/moloco/sdk/acm/TimerEvent;", "startTimerEvent", "recordTimerEvent$moloco_android_client_metrics_release", "(Lcom/moloco/sdk/acm/TimerEvent;)V", "recordTimerEvent", "triggerBackgroundEvent$moloco_android_client_metrics_release", "triggerBackgroundEvent", "Lcom/moloco/sdk/acm/eventprocessing/h;", "eventProcessor", "Lcom/moloco/sdk/acm/eventprocessing/h;", "Lcom/moloco/sdk/acm/services/c;", "applicationLifecycleTracker", "Lcom/moloco/sdk/acm/services/c;", "Lcom/moloco/sdk/acm/a;", "opsConfig", "Lcom/moloco/sdk/acm/a;", "getOpsConfig$moloco_android_client_metrics_release", "()Lcom/moloco/sdk/acm/a;", "setOpsConfig$moloco_android_client_metrics_release", "(Lcom/moloco/sdk/acm/a;)V", "getOpsConfig$moloco_android_client_metrics_release$annotations", "pendingConfigUpdate", "Lcom/moloco/sdk/acm/UpdateConfig;", "Lkotlinx/coroutines/sync/Mutex;", "configMutex", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/CoroutineScope;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/moloco/sdk/acm/f;", "kotlin.jvm.PlatformType", "_initializationStatus", "Ljava/util/concurrent/atomic/AtomicReference;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "preInitTimerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "preInitCountList", "Lcom/moloco/sdk/acm/eventprocessing/l;", "requestScheduler", "Lcom/moloco/sdk/acm/eventprocessing/l;", "TAG", "Ljava/lang/String;", "getInitializationStatus$moloco_android_client_metrics_release", "()Lcom/moloco/sdk/acm/f;", "initializationStatus", "moloco-android-client-metrics_release"}, k = 1, mv = {2, 0, 0})
public final class AndroidClientMetrics {
    private static final String TAG = "AndroidClientMetrics";
    private static com.moloco.sdk.acm.services.c applicationLifecycleTracker;
    private static h eventProcessor;
    public static com.moloco.sdk.acm.a opsConfig;
    private static UpdateConfig pendingConfigUpdate;
    private static l requestScheduler;
    public static final AndroidClientMetrics INSTANCE = new AndroidClientMetrics();
    private static final Mutex configMutex = MutexKt.Mutex$default(false, 1, null);
    private static final CoroutineScope ioScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    private static final AtomicReference<f> _initializationStatus = new AtomicReference<>(f.c);
    private static final CopyOnWriteArrayList<TimerEvent> preInitTimerList = new CopyOnWriteArrayList<>();
    private static final CopyOnWriteArrayList<CountEvent> preInitCountList = new CopyOnWriteArrayList<>();

    @DebugMetadata(c = "com.moloco.sdk.acm.AndroidClientMetrics$initialize$1", f = "AndroidClientMetrics.kt", i = {0, 1}, l = {258, 124}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f1961a;
        public int b;
        public final /* synthetic */ InitConfig c;
        public final /* synthetic */ AndroidClientMetricsCallback d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(InitConfig initConfig, AndroidClientMetricsCallback androidClientMetricsCallback, Continuation<? super a> continuation) {
            super(2, continuation);
            this.c = initConfig;
            this.d = androidClientMetricsCallback;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.c, this.d, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00f0 A[Catch: Exception -> 0x00f8, IllegalStateException -> 0x0118, TryCatch #3 {IllegalStateException -> 0x0118, Exception -> 0x00f8, blocks: (B:32:0x00e4, B:34:0x00f0, B:35:0x00f4, B:36:0x00f7, B:14:0x002a, B:17:0x0032, B:19:0x0090, B:20:0x0096, B:22:0x009c, B:23:0x00a2, B:7:0x0016, B:31:0x00e2, B:26:0x00c0, B:28:0x00c6), top: B:47:0x000b, inners: #2 }] */
        /* JADX WARN: Type inference failed for: r2v0, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.sync.Mutex] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 314
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.AndroidClientMetrics.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.AndroidClientMetrics$processQueuedEvents$1", f = "AndroidClientMetrics.kt", i = {}, l = {234, 235}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f1962a;
        public int b;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0066  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.b
                r2 = 0
                java.lang.String r3 = "eventProcessor"
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L29
                if (r1 == r5) goto L21
                if (r1 != r4) goto L19
                java.lang.Object r1 = r7.f1962a
                java.util.Iterator r1 = (java.util.Iterator) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L60
            L19:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L21:
                java.lang.Object r1 = r7.f1962a
                java.util.Iterator r1 = (java.util.Iterator) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L34
            L29:
                kotlin.ResultKt.throwOnFailure(r8)
                java.util.concurrent.CopyOnWriteArrayList r8 = com.moloco.sdk.acm.AndroidClientMetrics.access$getPreInitTimerList$p()
                java.util.Iterator r1 = r8.iterator()
            L34:
                boolean r8 = r1.hasNext()
                if (r8 == 0) goto L58
                java.lang.Object r8 = r1.next()
                com.moloco.sdk.acm.TimerEvent r8 = (com.moloco.sdk.acm.TimerEvent) r8
                com.moloco.sdk.acm.eventprocessing.h r6 = com.moloco.sdk.acm.AndroidClientMetrics.access$getEventProcessor$p()
                if (r6 != 0) goto L4a
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
                r6 = r2
            L4a:
                kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
                r7.f1962a = r1
                r7.b = r5
                java.lang.Object r8 = r6.a(r8, r7)
                if (r8 != r0) goto L34
                return r0
            L58:
                java.util.concurrent.CopyOnWriteArrayList r8 = com.moloco.sdk.acm.AndroidClientMetrics.access$getPreInitCountList$p()
                java.util.Iterator r1 = r8.iterator()
            L60:
                boolean r8 = r1.hasNext()
                if (r8 == 0) goto L84
                java.lang.Object r8 = r1.next()
                com.moloco.sdk.acm.CountEvent r8 = (com.moloco.sdk.acm.CountEvent) r8
                com.moloco.sdk.acm.eventprocessing.h r5 = com.moloco.sdk.acm.AndroidClientMetrics.access$getEventProcessor$p()
                if (r5 != 0) goto L76
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
                r5 = r2
            L76:
                kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
                r7.f1962a = r1
                r7.b = r4
                java.lang.Object r8 = r5.a(r8, r7)
                if (r8 != r0) goto L60
                return r0
            L84:
                java.util.concurrent.CopyOnWriteArrayList r8 = com.moloco.sdk.acm.AndroidClientMetrics.access$getPreInitTimerList$p()
                r8.clear()
                java.util.concurrent.CopyOnWriteArrayList r8 = com.moloco.sdk.acm.AndroidClientMetrics.access$getPreInitCountList$p()
                r8.clear()
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.AndroidClientMetrics.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.AndroidClientMetrics$recordCountEvent$1", f = "AndroidClientMetrics.kt", i = {}, l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1963a;
        public final /* synthetic */ CountEvent b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CountEvent countEvent, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = countEvent;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f1963a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                h hVar = AndroidClientMetrics.eventProcessor;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventProcessor");
                    hVar = null;
                }
                CountEvent countEvent = this.b;
                this.f1963a = 1;
                if (hVar.a(countEvent, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.acm.AndroidClientMetrics$recordTimerEvent$1", f = "AndroidClientMetrics.kt", i = {}, l = {225}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1964a;
        public final /* synthetic */ TimerEvent b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(TimerEvent timerEvent, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = timerEvent;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f1964a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                h hVar = AndroidClientMetrics.eventProcessor;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("eventProcessor");
                    hVar = null;
                }
                TimerEvent timerEvent = this.b;
                this.f1964a = 1;
                if (hVar.a(timerEvent, this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.acm.AndroidClientMetrics", f = "AndroidClientMetrics.kt", i = {0, 0}, l = {258, 164}, m = "updateConfig", n = {"newConfig", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    public static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f1965a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return AndroidClientMetrics.this.updateConfig(null, this);
        }
    }

    private AndroidClientMetrics() {
    }

    public static /* synthetic */ void getOpsConfig$moloco_android_client_metrics_release$annotations() {
    }

    public static /* synthetic */ void initialize$default(AndroidClientMetrics androidClientMetrics, InitConfig initConfig, AndroidClientMetricsCallback androidClientMetricsCallback, int i, Object obj) {
        if ((i & 2) != 0) {
            androidClientMetricsCallback = null;
        }
        androidClientMetrics.initialize(initConfig, androidClientMetricsCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processQueuedEvents() {
        BuildersKt__Builders_commonKt.launch$default(ioScope, null, null, new b(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateConfigInternal(UpdateConfig updateConfig, Continuation<? super Unit> continuation) {
        String postAnalyticsUrl = updateConfig.getPostAnalyticsUrl();
        if (postAnalyticsUrl != null) {
            INSTANCE.getOpsConfig$moloco_android_client_metrics_release().a(postAnalyticsUrl);
        }
        Long requestPeriodSeconds = updateConfig.getRequestPeriodSeconds();
        if (requestPeriodSeconds != null) {
            INSTANCE.getOpsConfig$moloco_android_client_metrics_release().a(requestPeriodSeconds.longValue());
        }
        l lVar = requestScheduler;
        if (lVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("requestScheduler");
            lVar = null;
        }
        Object objA = lVar.a(continuation);
        return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
    }

    public final f getInitializationStatus$moloco_android_client_metrics_release() {
        f fVar = _initializationStatus.get();
        Intrinsics.checkNotNullExpressionValue(fVar, "get(...)");
        return fVar;
    }

    public final com.moloco.sdk.acm.a getOpsConfig$moloco_android_client_metrics_release() {
        com.moloco.sdk.acm.a aVar = opsConfig;
        if (aVar != null) {
            return aVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("opsConfig");
        return null;
    }

    public final void initialize(InitConfig config, AndroidClientMetricsCallback callback) {
        Intrinsics.checkNotNullParameter(config, "config");
        com.moloco.sdk.acm.services.e.b(com.moloco.sdk.acm.services.e.f2014a, TAG, "ACM initialize", false, 4, null);
        if (ComplexDouble$$ExternalSyntheticBackport0.m(_initializationStatus, f.c, f.b)) {
            setOpsConfig$moloco_android_client_metrics_release(com.moloco.sdk.acm.e.a(config));
            BuildersKt__Builders_commonKt.launch$default(ioScope, null, null, new a(config, callback, null), 3, null);
        }
    }

    public final void recordCountEvent$moloco_android_client_metrics_release(CountEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (_initializationStatus.get() == f.f1999a) {
            BuildersKt__Builders_commonKt.launch$default(ioScope, null, null, new c(event, null), 3, null);
        } else {
            preInitCountList.add(event);
            com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f2014a, TAG, "Moloco Client Metrics not initialized", false, 4, null);
        }
    }

    public final void recordTimerEvent$moloco_android_client_metrics_release(TimerEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        event.stopTimer();
        if (_initializationStatus.get() == f.f1999a) {
            BuildersKt__Builders_commonKt.launch$default(ioScope, null, null, new d(event, null), 3, null);
        } else {
            preInitTimerList.add(event);
            com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f2014a, TAG, "Moloco Client Metrics not initialized", false, 4, null);
        }
    }

    public final void setOpsConfig$moloco_android_client_metrics_release(com.moloco.sdk.acm.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        opsConfig = aVar;
    }

    public final TimerEvent startTimerEvent$moloco_android_client_metrics_release(String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (_initializationStatus.get() != f.f1999a) {
            com.moloco.sdk.acm.services.e.a(com.moloco.sdk.acm.services.e.f2014a, TAG, "Moloco Client Metrics not initialized", false, 4, null);
        }
        TimerEvent timerEventCreate = TimerEvent.INSTANCE.create(eventName);
        timerEventCreate.startTimer();
        return timerEventCreate;
    }

    public final void triggerBackgroundEvent$moloco_android_client_metrics_release() {
        com.moloco.sdk.acm.services.c cVar = applicationLifecycleTracker;
        if (cVar != null) {
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationLifecycleTracker");
                cVar = null;
            }
            cVar.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateConfig(com.moloco.sdk.acm.UpdateConfig r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.moloco.sdk.acm.AndroidClientMetrics.e
            if (r0 == 0) goto L13
            r0 = r15
            com.moloco.sdk.acm.AndroidClientMetrics$e r0 = (com.moloco.sdk.acm.AndroidClientMetrics.e) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.moloco.sdk.acm.AndroidClientMetrics$e r0 = new com.moloco.sdk.acm.AndroidClientMetrics$e
            r0.<init>(r15)
        L18:
            java.lang.Object r15 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L43
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r15)
            goto L8f
        L2d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L35:
            java.lang.Object r14 = r0.b
            kotlinx.coroutines.sync.Mutex r14 = (kotlinx.coroutines.sync.Mutex) r14
            java.lang.Object r0 = r0.f1965a
            com.moloco.sdk.acm.UpdateConfig r0 = (com.moloco.sdk.acm.UpdateConfig) r0
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r14
            r14 = r0
            goto L6d
        L43:
            kotlin.ResultKt.throwOnFailure(r15)
            java.util.concurrent.atomic.AtomicReference<com.moloco.sdk.acm.f> r15 = com.moloco.sdk.acm.AndroidClientMetrics._initializationStatus
            java.lang.Object r15 = r15.get()
            com.moloco.sdk.acm.f r2 = com.moloco.sdk.acm.f.f1999a
            if (r15 == r2) goto L7a
            com.moloco.sdk.acm.services.e r6 = com.moloco.sdk.acm.services.e.f2014a
            r11 = 12
            r12 = 0
            java.lang.String r7 = "AndroidClientMetrics"
            java.lang.String r8 = "ACM updateConfig called when the SDK was not initialized. Initialize the SDK first."
            r9 = 0
            r10 = 0
            com.moloco.sdk.acm.services.e.b(r6, r7, r8, r9, r10, r11, r12)
            kotlinx.coroutines.sync.Mutex r15 = com.moloco.sdk.acm.AndroidClientMetrics.configMutex
            r0.f1965a = r14
            r0.b = r15
            r0.e = r4
            java.lang.Object r0 = r15.lock(r5, r0)
            if (r0 != r1) goto L6d
            return r1
        L6d:
            com.moloco.sdk.acm.AndroidClientMetrics.pendingConfigUpdate = r14     // Catch: java.lang.Throwable -> L75
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L75
            r15.unlock(r5)
            return r14
        L75:
            r14 = move-exception
            r15.unlock(r5)
            throw r14
        L7a:
            com.moloco.sdk.acm.services.e r6 = com.moloco.sdk.acm.services.e.f2014a
            r10 = 4
            r11 = 0
            java.lang.String r7 = "AndroidClientMetrics"
            java.lang.String r8 = "ACM update called. ACM initialized already, proceeding with update"
            r9 = 0
            com.moloco.sdk.acm.services.e.b(r6, r7, r8, r9, r10, r11)
            r0.e = r3
            java.lang.Object r14 = r13.updateConfigInternal(r14, r0)
            if (r14 != r1) goto L8f
            return r1
        L8f:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.AndroidClientMetrics.updateConfig(com.moloco.sdk.acm.UpdateConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
