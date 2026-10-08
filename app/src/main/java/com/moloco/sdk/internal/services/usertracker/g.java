package com.moloco.sdk.internal.services.usertracker;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes6.dex */
public final class g implements f {
    public static final int d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f2395a;
    public final com.moloco.sdk.internal.services.usertracker.b b;
    public final Mutex c;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.usertracker.UserTrackerServiceImpl", f = "UserTrackerService.kt", i = {0, 0, 1}, l = {48, 29}, m = "clear", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2396a;
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
            return g.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.usertracker.UserTrackerServiceImpl", f = "UserTrackerService.kt", i = {0, 0, 1, 1, 2, 2}, l = {48, 33, 36}, m = "getIdentifier", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "currentId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2397a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return g.this.b(this);
        }
    }

    public g(e idGenerator, com.moloco.sdk.internal.services.usertracker.b idRepository) {
        Intrinsics.checkNotNullParameter(idGenerator, "idGenerator");
        Intrinsics.checkNotNullParameter(idRepository, "idRepository");
        this.f2395a = idGenerator;
        this.b = idRepository;
        this.c = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.usertracker.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.moloco.sdk.internal.services.usertracker.g.a
            if (r0 == 0) goto L13
            r0 = r7
            com.moloco.sdk.internal.services.usertracker.g$a r0 = (com.moloco.sdk.internal.services.usertracker.g.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.moloco.sdk.internal.services.usertracker.g$a r0 = new com.moloco.sdk.internal.services.usertracker.g$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r0 = r0.f2396a
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Throwable -> L31
            goto L6a
        L31:
            r7 = move-exception
            goto L70
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3b:
            java.lang.Object r2 = r0.b
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r4 = r0.f2396a
            com.moloco.sdk.internal.services.usertracker.g r4 = (com.moloco.sdk.internal.services.usertracker.g) r4
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5a
        L47:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.sync.Mutex r2 = r6.c
            r0.f2396a = r6
            r0.b = r2
            r0.e = r4
            java.lang.Object r7 = r2.lock(r5, r0)
            if (r7 != r1) goto L59
            return r1
        L59:
            r4 = r6
        L5a:
            com.moloco.sdk.internal.services.usertracker.b r7 = r4.b     // Catch: java.lang.Throwable -> L72
            r0.f2396a = r2     // Catch: java.lang.Throwable -> L72
            r0.b = r5     // Catch: java.lang.Throwable -> L72
            r0.e = r3     // Catch: java.lang.Throwable -> L72
            java.lang.Object r7 = r7.a(r0)     // Catch: java.lang.Throwable -> L72
            if (r7 != r1) goto L69
            return r1
        L69:
            r0 = r2
        L6a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L31
            r0.unlock(r5)
            return r7
        L70:
            r2 = r0
            goto L73
        L72:
            r7 = move-exception
        L73:
            r2.unlock(r5)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.usertracker.g.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0089 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:21:0x004c, B:34:0x0085, B:36:0x0089), top: B:47:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.usertracker.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object b(kotlin.coroutines.Continuation<? super java.lang.String> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.moloco.sdk.internal.services.usertracker.g.b
            if (r0 == 0) goto L13
            r0 = r9
            com.moloco.sdk.internal.services.usertracker.g$b r0 = (com.moloco.sdk.internal.services.usertracker.g.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.moloco.sdk.internal.services.usertracker.g$b r0 = new com.moloco.sdk.internal.services.usertracker.g$b
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L5f
            if (r2 == r5) goto L52
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r1 = r0.b
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.f2397a
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L39
            goto La0
        L39:
            r9 = move-exception
            goto La8
        L3c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L44:
            java.lang.Object r2 = r0.b
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r4 = r0.f2397a
            com.moloco.sdk.internal.services.usertracker.g r4 = (com.moloco.sdk.internal.services.usertracker.g) r4
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L50
            goto L85
        L50:
            r9 = move-exception
            goto La9
        L52:
            java.lang.Object r2 = r0.b
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r5 = r0.f2397a
            com.moloco.sdk.internal.services.usertracker.g r5 = (com.moloco.sdk.internal.services.usertracker.g) r5
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r2
            goto L72
        L5f:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.sync.Mutex r9 = r8.c
            r0.f2397a = r8
            r0.b = r9
            r0.e = r5
            java.lang.Object r2 = r9.lock(r6, r0)
            if (r2 != r1) goto L71
            return r1
        L71:
            r5 = r8
        L72:
            com.moloco.sdk.internal.services.usertracker.b r2 = r5.b     // Catch: java.lang.Throwable -> La4
            r0.f2397a = r5     // Catch: java.lang.Throwable -> La4
            r0.b = r9     // Catch: java.lang.Throwable -> La4
            r0.e = r4     // Catch: java.lang.Throwable -> La4
            java.lang.Object r2 = r2.b(r0)     // Catch: java.lang.Throwable -> La4
            if (r2 != r1) goto L81
            return r1
        L81:
            r4 = r5
            r7 = r2
            r2 = r9
            r9 = r7
        L85:
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L50
            if (r9 != 0) goto L9e
            com.moloco.sdk.internal.services.usertracker.e r9 = r4.f2395a     // Catch: java.lang.Throwable -> L50
            java.lang.String r9 = r9.a()     // Catch: java.lang.Throwable -> L50
            com.moloco.sdk.internal.services.usertracker.b r4 = r4.b     // Catch: java.lang.Throwable -> L50
            r0.f2397a = r2     // Catch: java.lang.Throwable -> L50
            r0.b = r9     // Catch: java.lang.Throwable -> L50
            r0.e = r3     // Catch: java.lang.Throwable -> L50
            java.lang.Object r0 = r4.a(r9, r0)     // Catch: java.lang.Throwable -> L50
            if (r0 != r1) goto L9e
            return r1
        L9e:
            r1 = r9
            r0 = r2
        La0:
            r0.unlock(r6)
            return r1
        La4:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
        La8:
            r2 = r0
        La9:
            r2.unlock(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.usertracker.g.b(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
