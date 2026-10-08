package com.moloco.sdk.internal.publisher;

import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class o {
    public static final a c = new a(null);
    public static final int d = 0;
    public static final String e = "BidLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.internal.ortb.a f2244a;
    public final p b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", i = {0, 0}, l = {33, 46}, m = "parse", n = {"this", HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID}, s = {"L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2245a;
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
            return o.this.a(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", i = {0}, l = {71}, m = "parseBidResponse", n = {HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID}, s = {"L$0"})
    public static final class c extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2246a;
        public /* synthetic */ Object b;
        public int d;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return o.this.b(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.BidLoader", f = "BidLoader.kt", i = {0}, l = {58}, m = "processBidResponse$moloco_sdk_release", n = {"bidResponseJson"}, s = {"L$0"})
    public static final class d extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2247a;
        public /* synthetic */ Object b;
        public int d;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return o.this.a(null, this);
        }
    }

    public o(com.moloco.sdk.internal.ortb.a bidResponseParser, p bidProcessor) {
        Intrinsics.checkNotNullParameter(bidResponseParser, "bidResponseParser");
        Intrinsics.checkNotNullParameter(bidProcessor, "bidProcessor");
        this.f2244a = bidResponseParser;
        this.b = bidProcessor;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.internal.s>> r10) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.moloco.sdk.internal.publisher.o.c
            if (r0 == 0) goto L13
            r0 = r10
            com.moloco.sdk.internal.publisher.o$c r0 = (com.moloco.sdk.internal.publisher.o.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.o$c r0 = new com.moloco.sdk.internal.publisher.o$c
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r8 = r0.f2246a
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L46
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            kotlin.ResultKt.throwOnFailure(r10)
            com.moloco.sdk.internal.ortb.a r10 = r7.f2244a
            r0.f2246a = r9
            r0.d = r3
            java.lang.Object r10 = r10.a(r8, r0)
            if (r10 != r1) goto L46
            return r1
        L46:
            com.moloco.sdk.internal.v r10 = (com.moloco.sdk.internal.v) r10
            boolean r8 = r10 instanceof com.moloco.sdk.internal.v.a
            if (r8 == 0) goto L70
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            com.moloco.sdk.internal.v$a r10 = (com.moloco.sdk.internal.v.a) r10
            java.lang.Object r8 = r10.a()
            r3 = r8
            java.lang.Throwable r3 = (java.lang.Throwable) r3
            r5 = 8
            r6 = 0
            java.lang.String r1 = "BidLoader"
            java.lang.String r2 = "parseBidResponse failed to parse BID json string."
            r4 = 0
            com.moloco.sdk.internal.MolocoLogger.error$default(r0, r1, r2, r3, r4, r5, r6)
            com.moloco.sdk.publisher.MolocoAdError$ErrorType r8 = com.moloco.sdk.publisher.MolocoAdError.ErrorType.AD_BID_PARSE_ERROR
            com.moloco.sdk.internal.o r10 = com.moloco.sdk.internal.o.c
            com.moloco.sdk.internal.s r8 = com.moloco.sdk.internal.t.a(r9, r8, r10)
            com.moloco.sdk.internal.v$a r9 = new com.moloco.sdk.internal.v$a
            r9.<init>(r8)
            goto L94
        L70:
            boolean r8 = r10 instanceof com.moloco.sdk.internal.v.b
            if (r8 == 0) goto L95
            com.moloco.sdk.internal.v$b r9 = new com.moloco.sdk.internal.v$b
            com.moloco.sdk.internal.v$b r10 = (com.moloco.sdk.internal.v.b) r10
            java.lang.Object r8 = r10.a()
            com.moloco.sdk.internal.ortb.model.e r8 = (com.moloco.sdk.internal.ortb.model.e) r8
            java.util.List r8 = r8.b()
            r10 = 0
            java.lang.Object r8 = r8.get(r10)
            com.moloco.sdk.internal.ortb.model.y r8 = (com.moloco.sdk.internal.ortb.model.y) r8
            java.util.List r8 = r8.b()
            java.lang.Object r8 = r8.get(r10)
            r9.<init>(r8)
        L94:
            return r9
        L95:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.o.b(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r12, java.lang.String r13, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.ortb.model.c, com.moloco.sdk.internal.s>> r14) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.moloco.sdk.internal.publisher.o.b
            if (r0 == 0) goto L13
            r0 = r14
            com.moloco.sdk.internal.publisher.o$b r0 = (com.moloco.sdk.internal.publisher.o.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.o$b r0 = new com.moloco.sdk.internal.publisher.o$b
            r0.<init>(r14)
        L18:
            java.lang.Object r14 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L40
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r14)
            goto L97
        L2c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L34:
            java.lang.Object r12 = r0.b
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r0.f2245a
            com.moloco.sdk.internal.publisher.o r13 = (com.moloco.sdk.internal.publisher.o) r13
            kotlin.ResultKt.throwOnFailure(r14)
            goto L69
        L40:
            kotlin.ResultKt.throwOnFailure(r14)
            com.moloco.sdk.internal.MolocoLogger r5 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r2 = "parse() called with bidResponseJson: "
            r14.<init>(r2)
            r14.append(r13)
            java.lang.String r7 = r14.toString()
            r9 = 4
            r10 = 0
            java.lang.String r6 = "BidLoader"
            r8 = 0
            com.moloco.sdk.internal.MolocoLogger.debug$default(r5, r6, r7, r8, r9, r10)
            r0.f2245a = r11
            r0.b = r12
            r0.e = r4
            java.lang.Object r14 = r11.a(r13, r0)
            if (r14 != r1) goto L68
            return r1
        L68:
            r13 = r11
        L69:
            java.lang.String r14 = (java.lang.String) r14
            if (r14 != 0) goto L7b
            com.moloco.sdk.publisher.MolocoAdError$ErrorType r13 = com.moloco.sdk.publisher.MolocoAdError.ErrorType.AD_BID_PARSE_ERROR
            com.moloco.sdk.internal.o r14 = com.moloco.sdk.internal.o.b
            com.moloco.sdk.internal.s r12 = com.moloco.sdk.internal.t.a(r12, r13, r14)
            com.moloco.sdk.internal.v$a r13 = new com.moloco.sdk.internal.v$a
            r13.<init>(r12)
            return r13
        L7b:
            com.moloco.sdk.internal.MolocoLogger r4 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            r9 = 12
            r10 = 0
            java.lang.String r5 = "BidLoader"
            java.lang.String r6 = "Processed the bidResponse, proceeding with parsing it."
            r7 = 0
            r8 = 0
            com.moloco.sdk.internal.MolocoLogger.info$default(r4, r5, r6, r7, r8, r9, r10)
            r2 = 0
            r0.f2245a = r2
            r0.b = r2
            r0.e = r3
            java.lang.Object r14 = r13.b(r14, r12, r0)
            if (r14 != r1) goto L97
            return r1
        L97:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.o.a(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(java.lang.String r8, kotlin.coroutines.Continuation<? super java.lang.String> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.moloco.sdk.internal.publisher.o.d
            if (r0 == 0) goto L13
            r0 = r9
            com.moloco.sdk.internal.publisher.o$d r0 = (com.moloco.sdk.internal.publisher.o.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.o$d r0 = new com.moloco.sdk.internal.publisher.o$d
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.f2247a
            java.lang.String r8 = (java.lang.String) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L45
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            kotlin.ResultKt.throwOnFailure(r9)
            com.moloco.sdk.internal.publisher.p r9 = r7.b
            r0.f2247a = r8
            r0.d = r3
            java.lang.Object r9 = r9.a(r8, r0)
            if (r9 != r1) goto L45
            return r1
        L45:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L58
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            r5 = 12
            r6 = 0
            java.lang.String r1 = "BidLoader"
            java.lang.String r2 = "Found no pre-preprocessor for the current mediation. Returning the original bid response."
            r3 = 0
            r4 = 0
            com.moloco.sdk.internal.MolocoLogger.warn$default(r0, r1, r2, r3, r4, r5, r6)
            return r9
        L58:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.o.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
