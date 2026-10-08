package com.moloco.sdk.acm.db;

import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes6.dex */
public interface d {

    public static final class a {

        /* JADX INFO: renamed from: com.moloco.sdk.acm.db.d$a$a, reason: collision with other inner class name */
        @DebugMetadata(c = "com.moloco.sdk.acm.db.MetricsDAO$DefaultImpls", f = "MetricsDAO.kt", i = {0, 0, 0, 1}, l = {58, 62}, m = "deleteAndReturnDeletedEvents", n = {"$this", "deletedEvents", "eventsToDeleteChunk", "deletedEvents"}, s = {"L$0", "L$1", "L$2", "L$0"})
        public static final class C0376a extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f1972a;
            public Object b;
            public Object c;
            public /* synthetic */ Object d;
            public int e;

            public C0376a(Continuation<? super C0376a> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.d = obj;
                this.e |= Integer.MIN_VALUE;
                return a.a(null, this);
            }
        }

        @DebugMetadata(c = "com.moloco.sdk.acm.db.MetricsDAO$DefaultImpls", f = "MetricsDAO.kt", i = {0}, l = {69, 70}, m = "resetDatabase", n = {"$this"}, s = {"L$0"})
        public static final class b extends ContinuationImpl {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f1973a;
            public /* synthetic */ Object b;
            public int c;

            public b(Continuation<? super b> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.c |= Integer.MIN_VALUE;
                return a.b(null, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a3 -> B:32:0x00a5). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object a(com.moloco.sdk.acm.db.d r9, kotlin.coroutines.Continuation<? super java.util.List<com.moloco.sdk.acm.db.b>> r10) throws java.lang.Throwable {
            /*
                boolean r0 = r10 instanceof com.moloco.sdk.acm.db.d.a.C0376a
                if (r0 == 0) goto L13
                r0 = r10
                com.moloco.sdk.acm.db.d$a$a r0 = (com.moloco.sdk.acm.db.d.a.C0376a) r0
                int r1 = r0.e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.e = r1
                goto L18
            L13:
                com.moloco.sdk.acm.db.d$a$a r0 = new com.moloco.sdk.acm.db.d$a$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.d
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.e
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L49
                if (r2 == r4) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r9 = r0.f1972a
                java.util.List r9 = (java.util.List) r9
                kotlin.ResultKt.throwOnFailure(r10)
                goto L6c
            L30:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L38:
                java.lang.Object r9 = r0.c
                java.util.List r9 = (java.util.List) r9
                java.lang.Object r2 = r0.b
                java.util.List r2 = (java.util.List) r2
                java.lang.Object r5 = r0.f1972a
                com.moloco.sdk.acm.db.d r5 = (com.moloco.sdk.acm.db.d) r5
                kotlin.ResultKt.throwOnFailure(r10)
                r10 = r2
                goto La5
            L49:
                kotlin.ResultKt.throwOnFailure(r10)
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
            L51:
                java.util.List r2 = r9.b()
                boolean r5 = r2.isEmpty()
                if (r5 == 0) goto L6d
                r0.f1972a = r10
                r2 = 0
                r0.b = r2
                r0.c = r2
                r0.e = r3
                java.lang.Object r9 = r9.d(r0)
                if (r9 != r1) goto L6b
                return r1
            L6b:
                r9 = r10
            L6c:
                return r9
            L6d:
                java.util.ArrayList r5 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r2, r6)
                r5.<init>(r6)
                java.util.Iterator r6 = r2.iterator()
            L7c:
                boolean r7 = r6.hasNext()
                if (r7 == 0) goto L94
                java.lang.Object r7 = r6.next()
                com.moloco.sdk.acm.db.b r7 = (com.moloco.sdk.acm.db.b) r7
                long r7 = r7.i()
                java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
                r5.add(r7)
                goto L7c
            L94:
                r0.f1972a = r9
                r0.b = r10
                r0.c = r2
                r0.e = r4
                java.lang.Object r5 = r9.a(r5, r0)
                if (r5 != r1) goto La3
                return r1
            La3:
                r5 = r9
                r9 = r2
            La5:
                r10.addAll(r9)
                r9 = r5
                goto L51
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.db.d.a.a(com.moloco.sdk.acm.db.d, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.Object b(com.moloco.sdk.acm.db.d r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) throws java.lang.Throwable {
            /*
                boolean r0 = r6 instanceof com.moloco.sdk.acm.db.d.a.b
                if (r0 == 0) goto L13
                r0 = r6
                com.moloco.sdk.acm.db.d$a$b r0 = (com.moloco.sdk.acm.db.d.a.b) r0
                int r1 = r0.c
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.c = r1
                goto L18
            L13:
                com.moloco.sdk.acm.db.d$a$b r0 = new com.moloco.sdk.acm.db.d$a$b
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.c
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L3c
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                kotlin.ResultKt.throwOnFailure(r6)
                goto L56
            L2c:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L34:
                java.lang.Object r5 = r0.f1973a
                com.moloco.sdk.acm.db.d r5 = (com.moloco.sdk.acm.db.d) r5
                kotlin.ResultKt.throwOnFailure(r6)
                goto L4a
            L3c:
                kotlin.ResultKt.throwOnFailure(r6)
                r0.f1973a = r5
                r0.c = r4
                java.lang.Object r6 = r5.b(r0)
                if (r6 != r1) goto L4a
                return r1
            L4a:
                r6 = 0
                r0.f1973a = r6
                r0.c = r3
                java.lang.Object r5 = r5.d(r0)
                if (r5 != r1) goto L56
                return r1
            L56:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.db.d.a.b(com.moloco.sdk.acm.db.d, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    long a(b bVar);

    b a(long j);

    Object a(List<Long> list, Continuation<? super Unit> continuation);

    Object a(Continuation<? super List<b>> continuation);

    List<b> a();

    List<Long> a(List<b> list);

    Object b(Continuation<? super Unit> continuation);

    List<b> b();

    List<Long> b(List<b> list);

    Object c(Continuation<? super Unit> continuation);

    Object d(Continuation<? super Unit> continuation);
}
