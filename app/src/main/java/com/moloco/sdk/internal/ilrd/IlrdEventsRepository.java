package com.moloco.sdk.internal.ilrd;

import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.moloco.sdk.IlrdRequest;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.ilrd.c;
import com.moloco.sdk.internal.services.I;
import com.moloco.sdk.internal.services.InterfaceC3003d;
import com.moloco.sdk.internal.services.w;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\b\u0001\u0018\u0000 W2\u00020\u0001:\u0001+B\u008d\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b!\u0010 J\u001f\u0010!\u001a\n %*\u0004\u0018\u00010$0$2\u0006\u0010#\u001a\u00020\"H\u0002¢\u0006\u0004\b!\u0010&J\u0017\u0010!\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b!\u0010(J\u000f\u0010)\u001a\u00020\u001eH\u0002¢\u0006\u0004\b)\u0010*J\u0010\u0010+\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b+\u0010 J\u0010\u0010,\u001a\u00020\u001eH\u0082@¢\u0006\u0004\b,\u0010 J\r\u0010-\u001a\u00020\u001e¢\u0006\u0004\b-\u0010*J\u0015\u0010+\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b+\u0010.J\u0017\u00101\u001a\u00020\u001e2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u001eH\u0001¢\u0006\u0004\b3\u0010*J\u000f\u0010!\u001a\u00020\u001eH\u0001¢\u0006\u0004\b!\u0010*J\u000f\u00104\u001a\u00020\u001eH\u0001¢\u0006\u0004\b4\u0010*J\u000f\u00105\u001a\u00020\u001eH\u0001¢\u0006\u0004\b5\u0010*J\u000f\u00107\u001a\u000206H\u0007¢\u0006\u0004\b7\u00108R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u00109R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010:R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010;R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010<R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b?\u0010<R\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010<R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u0010AR\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010BR\u0014\u0010\u0014\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010:R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010:R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010CR\u0017\u0010\u0019\u001a\u00020\u00188G¢\u0006\f\n\u0004\b3\u0010D\u001a\u0004\b?\u0010ER\u0017\u0010\u001a\u001a\u00020\u00188G¢\u0006\f\n\u0004\bF\u0010D\u001a\u0004\b@\u0010ER\u0017\u0010\u001b\u001a\u00020\u00188G¢\u0006\f\n\u0004\bG\u0010D\u001a\u0004\b\u001f\u0010ER\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bI\u0010JR(\u0010Q\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010L8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\b=\u0010PR&\u0010V\u001a\b\u0012\u0004\u0012\u00020$0R8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\bS\u0010T\u0012\u0004\b,\u0010*\u001a\u0004\b+\u0010U¨\u0006X"}, d2 = {"Lcom/moloco/sdk/internal/ilrd/IlrdEventsRepository;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "url", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/persistenttransport/i;", "persistentHttpRequest", "Lkotlin/time/Duration;", "sessionExp", "", "maxBatchSize", "uploadInterval", "sessionMaxLength", "Lcom/moloco/sdk/internal/services/I;", "timeProvider", "Landroidx/lifecycle/Lifecycle;", "processLifeycle", "Lcom/moloco/sdk/internal/services/d;", "advertisingIdService", "pubId", "appId", "Lcom/moloco/sdk/internal/services/w;", "dataStoreService", "Lcom/moloco/sdk/internal/ilrd/d;", "sessionInactiveScheduler", "sessionMaxLengthScheduler", "scheduledUploadScheduler", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Lcom/moloco/sdk/xenoss/sdkdevkit/android/persistenttransport/i;JIJJLcom/moloco/sdk/internal/services/I;Landroidx/lifecycle/Lifecycle;Lcom/moloco/sdk/internal/services/d;Ljava/lang/String;Ljava/lang/String;Lcom/moloco/sdk/internal/services/w;Lcom/moloco/sdk/internal/ilrd/d;Lcom/moloco/sdk/internal/ilrd/d;Lcom/moloco/sdk/internal/ilrd/d;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lcom/moloco/sdk/internal/ilrd/c$a;", "ilrdData", "Lcom/moloco/sdk/IlrdRequest$ImpressionLevelRevenue;", "kotlin.jvm.PlatformType", "(Lcom/moloco/sdk/internal/ilrd/c$a;)Lcom/moloco/sdk/IlrdRequest$ImpressionLevelRevenue;", TypedValues.TransitionType.S_DURATION, "(J)V", "k", "()V", "b", "c", "i", "(Lcom/moloco/sdk/internal/ilrd/c$a;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "onPause", "(Landroidx/lifecycle/LifecycleOwner;)V", InneractiveMediationDefs.GENDER_MALE, "j", "l", "", "h", "()Z", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/lang/String;", "Lcom/moloco/sdk/xenoss/sdkdevkit/android/persistenttransport/i;", "J", "e", "I", InneractiveMediationDefs.GENDER_FEMALE, "g", "Lcom/moloco/sdk/internal/services/I;", "Lcom/moloco/sdk/internal/services/d;", "Lcom/moloco/sdk/internal/services/w;", "Lcom/moloco/sdk/internal/ilrd/d;", "()Lcom/moloco/sdk/internal/ilrd/d;", "n", "o", "Lkotlinx/coroutines/sync/Mutex;", TtmlNode.TAG_P, "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lcom/moloco/sdk/internal/ilrd/a;", "value", "q", "Lcom/moloco/sdk/internal/ilrd/a;", "()Lcom/moloco/sdk/internal/ilrd/a;", "session", "", AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, "Ljava/util/List;", "()Ljava/util/List;", "events", "s", "moloco-sdk_release"}, k = 1, mv = {2, 0, 0})
public final class IlrdEventsRepository implements DefaultLifecycleObserver {

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int t = 8;
    public static final String u = "IlrdEventsRepository";
    public static final String v = "ilrd_session_store";
    public static final String w = "ilrd_events_store";

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final CoroutineScope scope;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final String url;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final long sessionExp;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final int maxBatchSize;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final long uploadInterval;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final long sessionMaxLength;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final I timeProvider;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final InterfaceC3003d advertisingIdService;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final String pubId;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final String appId;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final w dataStoreService;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final com.moloco.sdk.internal.ilrd.d sessionInactiveScheduler;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final com.moloco.sdk.internal.ilrd.d sessionMaxLengthScheduler;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final com.moloco.sdk.internal.ilrd.d scheduledUploadScheduler;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final Mutex mutex;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public com.moloco.sdk.internal.ilrd.a session;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final List<IlrdRequest.ImpressionLevelRevenue> events;

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$1", f = "IlrdEventsRepository.kt", i = {0, 1}, l = {498, 115, 117}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2059a;
        public Object b;
        public int c;
        public final /* synthetic */ Lifecycle e;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.ilrd.IlrdEventsRepository$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$1$2", f = "IlrdEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C0380a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2060a;
            public final /* synthetic */ Lifecycle b;
            public final /* synthetic */ IlrdEventsRepository c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0380a(Lifecycle lifecycle, IlrdEventsRepository ilrdEventsRepository, Continuation<? super C0380a> continuation) {
                super(2, continuation);
                this.b = lifecycle;
                this.c = ilrdEventsRepository;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C0380a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C0380a(this.b, this.c, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.f2060a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.b.addObserver(this.c);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Lifecycle lifecycle, Continuation<? super a> continuation) {
            super(2, continuation);
            this.e = lifecycle;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IlrdEventsRepository.this.new a(this.e, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007b A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.c
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L34
                if (r1 == r4) goto L28
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                kotlin.ResultKt.throwOnFailure(r7)
                goto L7c
            L16:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1e:
                java.lang.Object r1 = r6.f2059a
                kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
                kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L26
                goto L5b
            L26:
                r7 = move-exception
                goto L7f
            L28:
                java.lang.Object r1 = r6.b
                com.moloco.sdk.internal.ilrd.IlrdEventsRepository r1 = (com.moloco.sdk.internal.ilrd.IlrdEventsRepository) r1
                java.lang.Object r4 = r6.f2059a
                kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
                kotlin.ResultKt.throwOnFailure(r7)
                goto L4d
            L34:
                kotlin.ResultKt.throwOnFailure(r7)
                com.moloco.sdk.internal.ilrd.IlrdEventsRepository r7 = com.moloco.sdk.internal.ilrd.IlrdEventsRepository.this
                kotlinx.coroutines.sync.Mutex r7 = com.moloco.sdk.internal.ilrd.IlrdEventsRepository.b(r7)
                com.moloco.sdk.internal.ilrd.IlrdEventsRepository r1 = com.moloco.sdk.internal.ilrd.IlrdEventsRepository.this
                r6.f2059a = r7
                r6.b = r1
                r6.c = r4
                java.lang.Object r4 = r7.lock(r5, r6)
                if (r4 != r0) goto L4c
                return r0
            L4c:
                r4 = r7
            L4d:
                r6.f2059a = r4     // Catch: java.lang.Throwable -> L81
                r6.b = r5     // Catch: java.lang.Throwable -> L81
                r6.c = r3     // Catch: java.lang.Throwable -> L81
                java.lang.Object r7 = com.moloco.sdk.internal.ilrd.IlrdEventsRepository.a(r1, r6)     // Catch: java.lang.Throwable -> L81
                if (r7 != r0) goto L5a
                return r0
            L5a:
                r1 = r4
            L5b:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L26
                r1.unlock(r5)
                com.moloco.sdk.internal.scheduling.DispatcherProvider r7 = com.moloco.sdk.internal.scheduling.b.a()
                kotlin.coroutines.CoroutineContext r7 = r7.getMain()
                com.moloco.sdk.internal.ilrd.IlrdEventsRepository$a$a r1 = new com.moloco.sdk.internal.ilrd.IlrdEventsRepository$a$a
                androidx.lifecycle.Lifecycle r3 = r6.e
                com.moloco.sdk.internal.ilrd.IlrdEventsRepository r4 = com.moloco.sdk.internal.ilrd.IlrdEventsRepository.this
                r1.<init>(r3, r4, r5)
                r6.f2059a = r5
                r6.c = r2
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r6)
                if (r7 != r0) goto L7c
                return r0
            L7c:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            L7f:
                r4 = r1
                goto L82
            L81:
                r7 = move-exception
            L82:
                r4.unlock(r5)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.ilrd.IlrdEventsRepository.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.ilrd.IlrdEventsRepository$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void a() {
        }

        public static /* synthetic */ void b() {
        }

        public Companion() {
        }

        public final byte[] a(byte[] bArr) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(bArr);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(gZIPOutputStream, null);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    Intrinsics.checkNotNullExpressionValue(byteArray, "use(...)");
                    return byteArray;
                } finally {
                }
            } finally {
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$onEvent$1", f = "IlrdEventsRepository.kt", i = {0, 0, 1, 1, 2, 2}, l = {498, 250, 258, 266}, m = "invokeSuspend", n = {"shouldSend", "$this$withLock_u24default$iv", "shouldSend", "$this$withLock_u24default$iv", "shouldSend", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2061a;
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ c.a g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(c.a aVar, Continuation<? super c> continuation) {
            super(2, continuation);
            this.g = aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IlrdEventsRepository.this.new c(this.g, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00e9 A[Catch: all -> 0x004e, TryCatch #2 {all -> 0x004e, blocks: (B:17:0x004a, B:33:0x00b0, B:35:0x00e9, B:37:0x00ef), top: B:61:0x004a }] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00ee  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0110 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x011a A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:12:0x0032, B:41:0x0114, B:43:0x011a, B:44:0x011c), top: B:57:0x0032 }] */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0125  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r21) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 320
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.ilrd.IlrdEventsRepository.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository", f = "IlrdEventsRepository.kt", i = {0, 1, 1, 2, 5, 5, 6}, l = {147, 149, 152, 165, 175, 193, 204, 208}, m = "restoreSavedSession", n = {"this", "this", "existingSession", "this", "this", "restoredSession", "this"}, s = {"L$0", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0"})
    public static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2062a;
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
            return IlrdEventsRepository.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$restoreSavedSession$restoredSession$1", f = "IlrdEventsRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.internal.ilrd.a>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2063a;
        public final /* synthetic */ String c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str, Continuation<? super e> continuation) {
            super(2, continuation);
            this.c = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.internal.ilrd.a> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IlrdEventsRepository.this.new e(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f2063a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return new com.moloco.sdk.internal.ilrd.a(IlrdEventsRepository.this.timeProvider, this.c);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$scheduleInactiveSessionExpiry$1", f = "IlrdEventsRepository.kt", i = {}, l = {357}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2064a;

        public f(Continuation<? super f> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((f) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return IlrdEventsRepository.this.new f(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2064a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.internal.ilrd.a session = IlrdEventsRepository.this.getSession();
                if (session != null) {
                    session.a();
                }
                IlrdEventsRepository ilrdEventsRepository = IlrdEventsRepository.this;
                this.f2064a = 1;
                if (ilrdEventsRepository.b(this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$scheduleMaxSessionLength$1", f = "IlrdEventsRepository.kt", i = {}, l = {376}, m = "invokeSuspend", n = {}, s = {})
    public static final class g extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2065a;

        public g(Continuation<? super g> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((g) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return IlrdEventsRepository.this.new g(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2065a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.moloco.sdk.internal.ilrd.a session = IlrdEventsRepository.this.getSession();
                if (session != null) {
                    session.a();
                }
                IlrdEventsRepository ilrdEventsRepository = IlrdEventsRepository.this;
                this.f2065a = 1;
                if (ilrdEventsRepository.b(this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$scheduleUploadIntervalScheduler$1", f = "IlrdEventsRepository.kt", i = {}, l = {391}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2066a;

        public h(Continuation<? super h> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((h) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return IlrdEventsRepository.this.new h(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2066a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IlrdEventsRepository ilrdEventsRepository = IlrdEventsRepository.this;
                this.f2066a = 1;
                if (ilrdEventsRepository.b(this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$sendEvents$1", f = "IlrdEventsRepository.kt", i = {}, l = {TTAdConstant.DEEPLINK_FALLBACK_TYPE_CODE}, m = "invokeSuspend", n = {}, s = {})
    public static final class i extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2067a;

        public i(Continuation<? super i> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((i) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IlrdEventsRepository.this.new i(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2067a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IlrdEventsRepository ilrdEventsRepository = IlrdEventsRepository.this;
                this.f2067a = 1;
                if (ilrdEventsRepository.b(this) == coroutine_suspended) {
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

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository", f = "IlrdEventsRepository.kt", i = {0, 0, 1, 1, 1}, l = {498, 436}, m = "sendEventsSuspending", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "compressed"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class j extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2068a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int f;

        public j(Continuation<? super j> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return IlrdEventsRepository.this.b(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$storeEventsToPersistentStorage$2", f = "IlrdEventsRepository.kt", i = {}, l = {447, 454}, m = "invokeSuspend", n = {}, s = {})
    public static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2069a;

        public k(Continuation<? super k> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IlrdEventsRepository.this.new k(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2069a;
            if (i != 0) {
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            if (IlrdEventsRepository.this.b().isEmpty()) {
                w wVar = IlrdEventsRepository.this.dataStoreService;
                this.f2069a = 1;
                if (wVar.a(IlrdEventsRepository.w, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            String strEncodeToString = Base64.encodeToString(IlrdRequest.ImpressionRevenueRequest.newBuilder().addAllEvents(IlrdEventsRepository.this.b()).build().toByteArray(), 2);
            w wVar2 = IlrdEventsRepository.this.dataStoreService;
            this.f2069a = 2;
            if (wVar2.a(IlrdEventsRepository.w, strEncodeToString, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.ilrd.IlrdEventsRepository$storeSessionToPersistentStorage$2", f = "IlrdEventsRepository.kt", i = {}, l = {TsExtractor.TS_STREAM_TYPE_AC3}, m = "invokeSuspend", n = {}, s = {})
    public static final class l extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2070a;
        public final /* synthetic */ com.moloco.sdk.internal.ilrd.a b;
        public final /* synthetic */ IlrdEventsRepository c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(com.moloco.sdk.internal.ilrd.a aVar, IlrdEventsRepository ilrdEventsRepository, Continuation<? super l> continuation) {
            super(2, continuation);
            this.b = aVar;
            this.c = ilrdEventsRepository;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((l) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new l(this.b, this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2070a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String strF = this.b.f();
                MolocoLogger.info$default(MolocoLogger.INSTANCE, IlrdEventsRepository.u, "Storing current session: " + strF, null, false, 12, null);
                w wVar = this.c.dataStoreService;
                this.f2070a = 1;
                if (wVar.a(IlrdEventsRepository.v, strF, this) == coroutine_suspended) {
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

    public /* synthetic */ IlrdEventsRepository(CoroutineScope coroutineScope, String str, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, long j2, int i2, long j3, long j4, I i3, Lifecycle lifecycle, InterfaceC3003d interfaceC3003d, String str2, String str3, w wVar, com.moloco.sdk.internal.ilrd.d dVar, com.moloco.sdk.internal.ilrd.d dVar2, com.moloco.sdk.internal.ilrd.d dVar3, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, str, iVar, j2, i2, j3, j4, i3, lifecycle, interfaceC3003d, str2, str3, wVar, dVar, dVar2, dVar3);
    }

    public static /* synthetic */ void c() {
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final com.moloco.sdk.internal.ilrd.a getSession() {
        return this.session;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final com.moloco.sdk.internal.ilrd.d getSessionInactiveScheduler() {
        return this.sessionInactiveScheduler;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final com.moloco.sdk.internal.ilrd.d getSessionMaxLengthScheduler() {
        return this.sessionMaxLengthScheduler;
    }

    public final boolean h() {
        boolean z = this.events.size() >= this.maxBatchSize;
        if (z) {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "batch size reached", null, false, 12, null);
        }
        return z;
    }

    public final synchronized void i() {
        a();
        j();
    }

    public final void j() {
        this.sessionInactiveScheduler.a(this.sessionExp, new f(null));
    }

    public final void k() {
        this.scheduledUploadScheduler.a(this.uploadInterval, new h(null));
    }

    public final void l() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new i(null), 3, null);
    }

    public final void m() {
        com.moloco.sdk.internal.ilrd.a aVar = new com.moloco.sdk.internal.ilrd.a(this.timeProvider, null, 2, null);
        this.session = aVar;
        a(this.sessionMaxLength);
        k();
        MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "New session started: sessionId=" + aVar.c() + ", maxBatch=" + this.maxBatchSize + ", uploadInterval=" + ((Object) Duration.m8819toStringimpl(this.uploadInterval)) + ", sessionExp=" + ((Object) Duration.m8819toStringimpl(this.sessionExp)) + ", maxLength=" + ((Object) Duration.m8819toStringimpl(this.sessionMaxLength)), null, false, 12, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "onPause called, sending events", null, false, 12, null);
        l();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
    }

    public IlrdEventsRepository(CoroutineScope scope, String url, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest, long j2, int i2, long j3, long j4, I timeProvider, Lifecycle processLifeycle, InterfaceC3003d advertisingIdService, String pubId, String appId, w dataStoreService, com.moloco.sdk.internal.ilrd.d sessionInactiveScheduler, com.moloco.sdk.internal.ilrd.d sessionMaxLengthScheduler, com.moloco.sdk.internal.ilrd.d scheduledUploadScheduler) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(persistentHttpRequest, "persistentHttpRequest");
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(processLifeycle, "processLifeycle");
        Intrinsics.checkNotNullParameter(advertisingIdService, "advertisingIdService");
        Intrinsics.checkNotNullParameter(pubId, "pubId");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(dataStoreService, "dataStoreService");
        Intrinsics.checkNotNullParameter(sessionInactiveScheduler, "sessionInactiveScheduler");
        Intrinsics.checkNotNullParameter(sessionMaxLengthScheduler, "sessionMaxLengthScheduler");
        Intrinsics.checkNotNullParameter(scheduledUploadScheduler, "scheduledUploadScheduler");
        this.scope = scope;
        this.url = url;
        this.persistentHttpRequest = persistentHttpRequest;
        this.sessionExp = j2;
        this.maxBatchSize = i2;
        this.uploadInterval = j3;
        this.sessionMaxLength = j4;
        this.timeProvider = timeProvider;
        this.advertisingIdService = advertisingIdService;
        this.pubId = pubId;
        this.appId = appId;
        this.dataStoreService = dataStoreService;
        this.sessionInactiveScheduler = sessionInactiveScheduler;
        this.sessionMaxLengthScheduler = sessionMaxLengthScheduler;
        this.scheduledUploadScheduler = scheduledUploadScheduler;
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.events = new ArrayList();
        MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "ILRD repository initialized - url=" + url + ", uploadInterval=" + ((Object) Duration.m8819toStringimpl(j3)) + ", maxBatchSize=" + i2 + ", sessionExpiry=" + ((Object) Duration.m8819toStringimpl(j2)) + ", maxSessionLength=" + ((Object) Duration.m8819toStringimpl(j4)), null, false, 12, null);
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new a(processLifeycle, null), 3, null);
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final com.moloco.sdk.internal.ilrd.d getScheduledUploadScheduler() {
        return this.scheduledUploadScheduler;
    }

    public final List<IlrdRequest.ImpressionLevelRevenue> b() {
        return this.events;
    }

    public final Object d(Continuation<? super Unit> continuation) {
        Object objWithContext;
        com.moloco.sdk.internal.ilrd.a aVar = this.session;
        return (aVar != null && (objWithContext = BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getDefault(), new l(aVar, this, null), continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objWithContext : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x02a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 700
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.ilrd.IlrdEventsRepository.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void b(c.a ilrdData) {
        Intrinsics.checkNotNullParameter(ilrdData, "ilrdData");
        BuildersKt.launch(this.scope, EmptyCoroutineContext.INSTANCE, CoroutineStart.DEFAULT, new c(ilrdData, null));
    }

    public final Object c(Continuation<? super Unit> continuation) {
        Object objWithContext = BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getDefault(), new k(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    public /* synthetic */ IlrdEventsRepository(CoroutineScope coroutineScope, String str, com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, long j2, int i2, long j3, long j4, I i3, Lifecycle lifecycle, InterfaceC3003d interfaceC3003d, String str2, String str3, w wVar, com.moloco.sdk.internal.ilrd.d dVar, com.moloco.sdk.internal.ilrd.d dVar2, com.moloco.sdk.internal.ilrd.d dVar3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineScope, str, iVar, j2, i2, j3, j4, i3, lifecycle, interfaceC3003d, str2, str3, wVar, (i4 & 8192) != 0 ? new com.moloco.sdk.internal.ilrd.d(coroutineScope, i3, "SessionInactiveScheduler") : dVar, (i4 & 16384) != 0 ? new com.moloco.sdk.internal.ilrd.d(coroutineScope, i3, "SessionMaxLengthScheduler") : dVar2, (i4 & 32768) != 0 ? new com.moloco.sdk.internal.ilrd.d(coroutineScope, i3, "UploadIntervalScheduler") : dVar3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.ilrd.IlrdEventsRepository.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final IlrdRequest.ImpressionLevelRevenue a(c.a ilrdData) {
        IlrdRequest.ImpressionLevelRevenue.Builder eventId = IlrdRequest.ImpressionLevelRevenue.newBuilder().setEventId(UUID.randomUUID().toString());
        com.moloco.sdk.internal.ilrd.a aVar = this.session;
        if (aVar != null) {
            eventId.setSessionId(aVar.c());
            Duration.Companion companion = Duration.INSTANCE;
            long duration = DurationKt.toDuration(this.timeProvider.a() - aVar.d(), DurationUnit.MILLISECONDS);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "Event created: sessionId=" + aVar.c() + ", sessionAge=" + ((Object) Duration.m8819toStringimpl(duration)), null, false, 12, null);
        }
        if (ilrdData instanceof c.a.b) {
            eventId.setMax(((c.a.b) ilrdData).b());
        } else {
            if (!(ilrdData instanceof c.a.C0385a)) {
                throw new NoWhenBranchMatchedException();
            }
            eventId.setLevelplay(((c.a.C0385a) ilrdData).b());
        }
        return eventId.build();
    }

    public final void a() {
        com.moloco.sdk.internal.ilrd.a aVar = this.session;
        if (aVar != null && !aVar.e()) {
            Duration.Companion companion = Duration.INSTANCE;
            long duration = DurationKt.toDuration(this.timeProvider.a() - aVar.d(), DurationUnit.MILLISECONDS);
            MolocoLogger.info$default(MolocoLogger.INSTANCE, u, "Session validation - age: " + ((Object) Duration.m8819toStringimpl(duration)) + ", limit: " + ((Object) Duration.m8819toStringimpl(this.sessionMaxLength)), null, false, 12, null);
            return;
        }
        m();
    }

    public final void a(long duration) {
        this.sessionMaxLengthScheduler.a(duration, new g(null));
    }
}
