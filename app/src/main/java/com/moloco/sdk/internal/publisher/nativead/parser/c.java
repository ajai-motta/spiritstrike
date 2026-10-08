package com.moloco.sdk.internal.publisher.nativead.parser;

import android.content.Context;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.publisher.nativead.model.b;
import com.moloco.sdk.internal.publisher.nativead.model.c;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2226a = "PrepareNativeAssets";

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", i = {0}, l = {113}, m = "prepareImageAsset", n = {"asset"}, s = {"L$0"})
    public static final class a extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2227a;
        public /* synthetic */ Object b;
        public int c;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.c |= Integer.MIN_VALUE;
            return c.b(null, null, this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", i = {0, 0, 0, 1}, l = {37, 58}, m = "prepareNativeAssets-exY8QGI", n = {"loadVast", "optionalAssetsGroup", "timeout", "preparedRequiredAssets"}, s = {"L$0", "L$1", "J$0", "L$0"})
    public static final class b extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2228a;
        public Object b;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return c.a((Context) null, (List<? extends b.a>) null, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.parser.c$c, reason: collision with other inner class name */
    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedOptionalAssets$1", f = "PrepareNativeAssets.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
    public static final class C0403c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Pair<? extends b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2229a;
        public /* synthetic */ Object b;
        public final /* synthetic */ List<b.a> c;
        public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> d;
        public final /* synthetic */ long e;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.publisher.nativead.parser.c$c$a */
        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedOptionalAssets$1$1$1", f = "PrepareNativeAssets.kt", i = {}, l = {60}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f2230a;
            public int b;
            public final /* synthetic */ b.a c;
            public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> d;
            public final /* synthetic */ long e;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(b.a aVar, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super a> continuation) {
                super(2, continuation);
                this.c = aVar;
                this.d = lazy;
                this.e = j;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.c, this.d, this.e, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                b.a aVar;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    b.a aVar2 = this.c;
                    Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.d;
                    long j = this.e;
                    this.f2230a = aVar2;
                    this.b = 1;
                    Object objB = c.b(aVar2, lazy, j, this);
                    if (objB == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    aVar = aVar2;
                    obj = objB;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar = (b.a) this.f2230a;
                    ResultKt.throwOnFailure(obj);
                }
                return TuplesKt.to(aVar, obj);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0403c(List<? extends b.a> list, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super C0403c> continuation) {
            super(2, continuation);
            this.c = list;
            this.d = lazy;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Pair<? extends b.a, ? extends v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>> continuation) {
            return ((C0403c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C0403c c0403c = new C0403c(this.c, this.d, this.e, continuation);
            c0403c.b = obj;
            return c0403c;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2229a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.b;
                List<b.a> list = this.c;
                Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.d;
                long j = this.e;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new a((b.a) it.next(), lazy, j, null), 3, null));
                }
                this.f2229a = 1;
                obj = AwaitKt.awaitAll(arrayList, this);
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

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedRequiredAssets$1", f = "PrepareNativeAssets.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Pair<? extends b.a, ? extends v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2231a;
        public /* synthetic */ Object b;
        public final /* synthetic */ List<b.a> c;
        public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> d;
        public final /* synthetic */ long e;

        @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt$prepareNativeAssets$preparedRequiredAssets$1$1$1", f = "PrepareNativeAssets.kt", i = {}, l = {40}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends b.a, ? extends v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2232a;
            public final /* synthetic */ b.a b;
            public final /* synthetic */ Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> c;
            public final /* synthetic */ long d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public a(b.a aVar, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = aVar;
                this.c = lazy;
                this.d = j;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Pair<? extends b.a, v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f2232a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    b.a aVar = this.b;
                    Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.c;
                    long j = this.d;
                    this.f2232a = 1;
                    obj = c.b(aVar, lazy, j, this);
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
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, c.f2226a, "Successfully prepared native asset: " + this.b.a(), null, false, 12, null);
                    return TuplesKt.to(this.b, vVar);
                }
                if (!(vVar instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.warn$default(MolocoLogger.INSTANCE, c.f2226a, "Failed to prepare required native asset: " + this.b.a(), null, false, 12, null);
                throw new com.moloco.sdk.internal.publisher.nativead.parser.b(this.b.a(), (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c) ((v.a) vVar).a());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(List<? extends b.a> list, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = list;
            this.d = lazy;
            this.e = j;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends Pair<? extends b.a, v.b<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>>>> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(this.c, this.d, this.e, continuation);
            dVar.b = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f2231a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.b;
                List<b.a> list = this.c;
                Lazy<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy = this.d;
                long j = this.e;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new a((b.a) it.next(), lazy, j, null), 3, null));
                }
                this.f2231a = 1;
                obj = AwaitKt.awaitAll(arrayList, this);
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

    @DebugMetadata(c = "com.moloco.sdk.internal.publisher.nativead.parser.PrepareNativeAssetsKt", f = "PrepareNativeAssets.kt", i = {0, 0, 0, 1}, l = {148, 155}, m = "prepareVideoAsset-exY8QGI", n = {"asset", "loadVast", "timeout", "asset"}, s = {"L$0", "L$1", "J$0", "L$0"})
    public static final class e extends ContinuationImpl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f2233a;
        public Object b;
        public long c;
        public /* synthetic */ Object d;
        public int e;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return c.b((b.a.d) null, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d) null, 0L, this);
        }
    }

    public static final Object b(b.a aVar, Lazy<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d> lazy, long j, Continuation<? super v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> continuation) {
        if (aVar instanceof b.a.C0399a) {
            return new v.b(new c.a((b.a.C0399a) aVar));
        }
        if (aVar instanceof b.a.C0400b) {
            return a((b.a.C0400b) aVar, null, continuation, 2, null);
        }
        if (aVar instanceof b.a.c) {
            return new v.b(new c.C0402c((b.a.c) aVar));
        }
        if (aVar instanceof b.a.d) {
            return b((b.a.d) aVar, lazy.getValue(), j, continuation);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(final android.content.Context r11, java.util.List<? extends com.moloco.sdk.internal.publisher.nativead.model.b.a> r12, long r13, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.publisher.nativead.model.d, com.moloco.sdk.internal.publisher.nativead.parser.b>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.parser.c.a(android.content.Context, java.util.List, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(com.moloco.sdk.internal.publisher.nativead.model.b.a.C0400b r7, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i r8, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof com.moloco.sdk.internal.publisher.nativead.parser.c.a
            if (r0 == 0) goto L13
            r0 = r9
            com.moloco.sdk.internal.publisher.nativead.parser.c$a r0 = (com.moloco.sdk.internal.publisher.nativead.parser.c.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.c = r1
            goto L18
        L13:
            com.moloco.sdk.internal.publisher.nativead.parser.c$a r0 = new com.moloco.sdk.internal.publisher.nativead.parser.c$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.f2227a
            com.moloco.sdk.internal.publisher.nativead.model.b$a$b r7 = (com.moloco.sdk.internal.publisher.nativead.model.b.a.C0400b) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L47
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r9 = r7.e()
            r0.f2227a = r7
            r0.c = r3
            java.lang.Object r9 = r8.a(r9, r0)
            if (r9 != r1) goto L47
            return r1
        L47:
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i$a r9 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a) r9
            boolean r8 = r9 instanceof com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.b
            if (r8 == 0) goto L95
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE     // Catch: java.lang.Exception -> L7e
            java.lang.String r1 = "PrepareNativeAssets"
            java.lang.String r2 = "Successfully loaded image asset media"
            r5 = 12
            r6 = 0
            r3 = 0
            r4 = 0
            com.moloco.sdk.internal.MolocoLogger.info$default(r0, r1, r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L7e
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i$a$b r9 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i.a.b) r9     // Catch: java.lang.Exception -> L7e
            java.io.File r8 = r9.a()     // Catch: java.lang.Exception -> L7e
            java.lang.String r8 = r8.getAbsolutePath()     // Catch: java.lang.Exception -> L7e
            java.lang.String r9 = "getAbsolutePath(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch: java.lang.Exception -> L7e
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch: java.lang.Exception -> L7e
            java.lang.String r9 = "parse(this)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch: java.lang.Exception -> L7e
            com.moloco.sdk.internal.v$b r9 = new com.moloco.sdk.internal.v$b
            com.moloco.sdk.internal.publisher.nativead.model.c$b r0 = new com.moloco.sdk.internal.publisher.nativead.model.c$b
            r0.<init>(r7, r8)
            r9.<init>(r0)
            goto Laa
        L7e:
            r7 = move-exception
            r3 = r7
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            r5 = 8
            r6 = 0
            java.lang.String r1 = "PrepareNativeAssets"
            java.lang.String r2 = "Failed to prepare image asset"
            r4 = 0
            com.moloco.sdk.internal.MolocoLogger.warn$default(r0, r1, r2, r3, r4, r5, r6)
            com.moloco.sdk.internal.v$a r7 = new com.moloco.sdk.internal.v$a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f r8 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.c
            r7.<init>(r8)
            return r7
        L95:
            com.moloco.sdk.internal.MolocoLogger r0 = com.moloco.sdk.internal.MolocoLogger.INSTANCE
            r5 = 12
            r6 = 0
            java.lang.String r1 = "PrepareNativeAssets"
            java.lang.String r2 = "Failed to fetch image asset media"
            r3 = 0
            r4 = 0
            com.moloco.sdk.internal.MolocoLogger.warn$default(r0, r1, r2, r3, r4, r5, r6)
            com.moloco.sdk.internal.v$a r9 = new com.moloco.sdk.internal.v$a
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f r7 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.f.b
            r9.<init>(r7)
        Laa:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.parser.c.b(com.moloco.sdk.internal.publisher.nativead.model.b$a$b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object b(com.moloco.sdk.internal.publisher.nativead.model.b.a.d r11, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d r12, long r13, kotlin.coroutines.Continuation<? super com.moloco.sdk.internal.v<com.moloco.sdk.internal.publisher.nativead.model.c, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.publisher.nativead.parser.c.b(com.moloco.sdk.internal.publisher.nativead.model.b$a$d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.d a(Context context) {
        return f.a(context);
    }

    public static /* synthetic */ Object a(b.a.C0400b c0400b, i iVar, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            iVar = a.g.f2425a.a();
        }
        return b(c0400b, iVar, continuation);
    }
}
