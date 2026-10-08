package com.moloco.sdk.acm.eventprocessing;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes6.dex */
public final class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.acm.eventprocessing.c f1995a;
    public final com.moloco.sdk.acm.a b;
    public final ScheduledExecutorService c;
    public final CoroutineScope d;
    public ScheduledFuture<?> e;
    public final Mutex f;

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.RequestSchedulerTimer", f = "RequestSchedulerTimer.kt", i = {0, 0}, l = {68}, m = "resetScheduleAndTriggerNewScheduledUpload", n = {"this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f1996a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return m.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.RequestSchedulerTimer$schedule$1$1", f = "RequestSchedulerTimer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1997a;

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
            return m.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f1997a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            m.this.f1995a.a();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.eventprocessing.RequestSchedulerTimer", f = "RequestSchedulerTimer.kt", i = {0, 0}, l = {68}, m = "scheduleUploadAndPurge", n = {"this", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f1998a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return m.this.b(this);
        }
    }

    public m(com.moloco.sdk.acm.eventprocessing.c dbWorkRequest, com.moloco.sdk.acm.a opsConfig, ScheduledExecutorService scheduler, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(dbWorkRequest, "dbWorkRequest");
        Intrinsics.checkNotNullParameter(opsConfig, "opsConfig");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.f1995a = dbWorkRequest;
        this.b = opsConfig;
        this.c = scheduler;
        this.d = coroutineScope;
        this.f = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.acm.eventprocessing.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.moloco.sdk.acm.eventprocessing.m.c
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.acm.eventprocessing.m$c r0 = (com.moloco.sdk.acm.eventprocessing.m.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.moloco.sdk.acm.eventprocessing.m$c r0 = new com.moloco.sdk.acm.eventprocessing.m$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.b
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.f1998a
            com.moloco.sdk.acm.eventprocessing.m r0 = (com.moloco.sdk.acm.eventprocessing.m) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r5.f
            r0.f1998a = r5
            r0.b = r6
            r0.e = r3
            java.lang.Object r0 = r6.lock(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
            r1 = r6
        L4e:
            r0.a()     // Catch: java.lang.Throwable -> L57
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L57
            r1.unlock(r4)
            return r6
        L57:
            r6 = move-exception
            r1.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.eventprocessing.m.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.acm.eventprocessing.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.moloco.sdk.acm.eventprocessing.m.a
            if (r0 == 0) goto L13
            r0 = r6
            com.moloco.sdk.acm.eventprocessing.m$a r0 = (com.moloco.sdk.acm.eventprocessing.m.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.moloco.sdk.acm.eventprocessing.m$a r0 = new com.moloco.sdk.acm.eventprocessing.m$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.b
            kotlinx.coroutines.sync.Mutex r1 = (kotlinx.coroutines.sync.Mutex) r1
            java.lang.Object r0 = r0.f1996a
            com.moloco.sdk.acm.eventprocessing.m r0 = (com.moloco.sdk.acm.eventprocessing.m) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.sync.Mutex r6 = r5.f
            r0.f1996a = r5
            r0.b = r6
            r0.e = r3
            java.lang.Object r0 = r6.lock(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
            r1 = r6
        L4e:
            java.util.concurrent.ScheduledFuture<?> r6 = r0.e     // Catch: java.lang.Throwable -> L63
            if (r6 == 0) goto L5a
            r2 = 0
            boolean r6 = r6.cancel(r2)     // Catch: java.lang.Throwable -> L63
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch: java.lang.Throwable -> L63
        L5a:
            r0.a()     // Catch: java.lang.Throwable -> L63
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L63
            r1.unlock(r4)
            return r6
        L63:
            r6 = move-exception
            r1.unlock(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.eventprocessing.m.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ m(com.moloco.sdk.acm.eventprocessing.c cVar, com.moloco.sdk.acm.a aVar, ScheduledExecutorService scheduledExecutorService, CoroutineScope coroutineScope, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, aVar, (i & 4) != 0 ? Executors.newSingleThreadScheduledExecutor() : scheduledExecutorService, coroutineScope);
    }

    public static final void b(m mVar) {
        BuildersKt__Builders_commonKt.launch$default(mVar.d, null, null, mVar.new b(null), 3, null);
    }

    public final void a() {
        ScheduledFuture<?> scheduledFuture = this.e;
        if (scheduledFuture == null || (scheduledFuture != null && scheduledFuture.isCancelled())) {
            this.e = this.c.scheduleWithFixedDelay(new Runnable() { // from class: com.moloco.sdk.acm.eventprocessing.m$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    m.b(this.f$0);
                }
            }, this.b.h(), this.b.h(), TimeUnit.SECONDS);
        }
    }
}
