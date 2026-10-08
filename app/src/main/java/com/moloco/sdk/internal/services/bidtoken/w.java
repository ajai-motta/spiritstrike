package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.I;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class w implements v {
    public static final a e = new a(null);
    public static final int f = 8;
    public static final String g = "ServerBidTokenCache";
    public static final long h = 15;
    public static final long i = 2;
    public final com.moloco.sdk.internal.bidtoken.b b;
    public final I c;
    public k d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenCacheImpl", f = "ServerBidTokenCache.kt", i = {0}, l = {62}, m = "tokenStatus", n = {"this"}, s = {"L$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2332a;
        public /* synthetic */ Object b;
        public int d;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return w.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.bidtoken.ServerBidTokenCacheImpl", f = "ServerBidTokenCache.kt", i = {0, 0, 1, 1, 1}, l = {95, 98}, m = "updateCache", n = {"this", "bidTokenComponents", "this", "bidTokenComponents", "newToken"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2333a;
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
            return w.this.a(null, this);
        }
    }

    public w(com.moloco.sdk.internal.bidtoken.b bidTokenParser, I timeProviderService) {
        Intrinsics.checkNotNullParameter(bidTokenParser, "bidTokenParser");
        Intrinsics.checkNotNullParameter(timeProviderService, "timeProviderService");
        this.b = bidTokenParser;
        this.c = timeProviderService;
        this.d = new k("", "", e.a());
    }

    public static /* synthetic */ void d() {
    }

    public final void a(k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<set-?>");
        this.d = kVar;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.v
    public void b() {
        this.d = new k("", "", e.a());
    }

    public final k c() {
        return this.d;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.v
    public k a() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.bidtoken.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.services.bidtoken.B> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.w.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.bidtoken.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(com.moloco.sdk.internal.services.bidtoken.k r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.bidtoken.w.a(com.moloco.sdk.internal.services.bidtoken.k, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void a(String str) {
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, g, "[Thread: " + Thread.currentThread().getName() + "][sbt] " + str, false, 4, null);
    }
}
