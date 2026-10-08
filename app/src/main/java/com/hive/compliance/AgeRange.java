package com.hive.compliance;

import com.hive.AuthV4;
import com.hive.ResultAPI;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0007H\u0007J\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\nH\u0086@¢\u0006\u0002\u0010\fJ*\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0007H\u0007J\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\n2\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\nH\u0002J\u001e\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002¨\u0006\u0017"}, d2 = {"Lcom/hive/compliance/AgeRange;", "", "<init>", "()V", "getAgeRange", "", "callback", "Lkotlin/Function2;", "", "Lcom/hive/AuthV4$AgeRange;", "Lkotlin/Pair;", "Lcom/hive/ResultAPI;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showAgeRangeUpdatePermission", "description", "", "googleAgeSignals", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "amazonGetUserAgeData", "oneStoreAgeSignals", "galaxyStoreAgeSignals", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AgeRange {
    public static final AgeRange INSTANCE = new AgeRange();

    /* JADX INFO: renamed from: com.hive.compliance.AgeRange$getAgeRange$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.compliance.AgeRange$getAgeRange$1", f = "AgeRange.kt", i = {}, l = {26, 27}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Boolean, AuthV4.AgeRange, Unit> $callback;
        int label;

        /* JADX INFO: renamed from: com.hive.compliance.AgeRange$getAgeRange$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.compliance.AgeRange$getAgeRange$1$1", f = "AgeRange.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C03531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Pair<ResultAPI, AuthV4.AgeRange> $ageRange;
            final /* synthetic */ Function2<Boolean, AuthV4.AgeRange, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C03531(Function2<? super Boolean, ? super AuthV4.AgeRange, Unit> function2, Pair<ResultAPI, AuthV4.AgeRange> pair, Continuation<? super C03531> continuation) {
                super(2, continuation);
                this.$callback = function2;
                this.$ageRange = pair;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03531(this.$callback, this.$ageRange, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$callback.invoke(Boxing.boxBoolean(this.$ageRange.getFirst().isSuccess()), this.$ageRange.getSecond());
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function2<? super Boolean, ? super AuthV4.AgeRange, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(r1, r3, r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.throwOnFailure(r7)
                goto L43
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                kotlin.ResultKt.throwOnFailure(r7)
                goto L2c
            L1e:
                kotlin.ResultKt.throwOnFailure(r7)
                com.hive.compliance.AgeRange r7 = com.hive.compliance.AgeRange.INSTANCE
                r6.label = r3
                java.lang.Object r7 = r7.getAgeRange(r6)
                if (r7 != r0) goto L2c
                goto L42
            L2c:
                kotlin.Pair r7 = (kotlin.Pair) r7
                kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()
                com.hive.compliance.AgeRange$getAgeRange$1$1 r3 = new com.hive.compliance.AgeRange$getAgeRange$1$1
                kotlin.jvm.functions.Function2<java.lang.Boolean, com.hive.AuthV4$AgeRange, kotlin.Unit> r4 = r6.$callback
                r5 = 0
                r3.<init>(r4, r7, r5)
                r6.label = r2
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r1, r3, r6)
                if (r7 != r0) goto L43
            L42:
                return r0
            L43:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.compliance.AgeRange.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.hive.compliance.AgeRange$getAgeRange$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.compliance.AgeRange", f = "AgeRange.kt", i = {}, l = {41, 42}, m = "getAgeRange", n = {}, s = {})
    public static final class AnonymousClass2 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgeRange.this.getAgeRange(this);
        }
    }

    /* JADX INFO: renamed from: com.hive.compliance.AgeRange$googleAgeSignals$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.compliance.AgeRange", f = "AgeRange.kt", i = {0}, l = {81}, m = "googleAgeSignals", n = {"googleAgeSignals"}, s = {"L$0"})
    public static final class C29001 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C29001(Continuation<? super C29001> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgeRange.this.googleAgeSignals(null, this);
        }
    }

    /* JADX INFO: renamed from: com.hive.compliance.AgeRange$showAgeRangeUpdatePermission$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.compliance.AgeRange$showAgeRangeUpdatePermission$1", f = "AgeRange.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
    public static final class C29011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Boolean, AuthV4.AgeRange, Unit> $callback;
        final /* synthetic */ String $description;
        int label;

        /* JADX INFO: renamed from: com.hive.compliance.AgeRange$showAgeRangeUpdatePermission$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.compliance.AgeRange$showAgeRangeUpdatePermission$1$1", f = "AgeRange.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C03541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Pair<ResultAPI, AuthV4.AgeRange> $ageRange;
            final /* synthetic */ Function2<Boolean, AuthV4.AgeRange, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C03541(Function2<? super Boolean, ? super AuthV4.AgeRange, Unit> function2, Pair<ResultAPI, AuthV4.AgeRange> pair, Continuation<? super C03541> continuation) {
                super(2, continuation);
                this.$callback = function2;
                this.$ageRange = pair;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C03541(this.$callback, this.$ageRange, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$callback.invoke(Boxing.boxBoolean(this.$ageRange.getFirst().isSuccess()), this.$ageRange.getSecond());
                return Unit.INSTANCE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C03541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C29011(String str, Function2<? super Boolean, ? super AuthV4.AgeRange, Unit> function2, Continuation<? super C29011> continuation) {
            super(2, continuation);
            this.$description = str;
            this.$callback = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29011(this.$description, this.$callback, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Pair<ResultAPI, AuthV4.AgeRange> pairShowAgeRangeUpdatePermission = AgeRange.INSTANCE.showAgeRangeUpdatePermission(this.$description);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                C03541 c03541 = new C03541(this.$callback, pairShowAgeRangeUpdatePermission, null);
                this.label = 1;
                if (BuildersKt.withContext(main, c03541, this) == coroutine_suspended) {
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
            return ((C29011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private AgeRange() {
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.Pair<com.hive.ResultAPI, com.hive.AuthV4.AgeRange> amazonGetUserAgeData(android.content.Context r6) {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.compliance.AgeRange.amazonGetUserAgeData(android.content.Context):kotlin.Pair");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.Pair<com.hive.ResultAPI, com.hive.AuthV4.AgeRange> galaxyStoreAgeSignals(android.content.Context r6) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.compliance.AgeRange.galaxyStoreAgeSignals(android.content.Context):kotlin.Pair");
    }

    @JvmStatic
    public static final void getAgeRange(Function2<? super Boolean, ? super AuthV4.AgeRange, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object googleAgeSignals(android.content.Context r7, kotlin.coroutines.Continuation<? super kotlin.Pair<com.hive.ResultAPI, com.hive.AuthV4.AgeRange>> r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 300
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.compliance.AgeRange.googleAgeSignals(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Pair<ResultAPI, AuthV4.AgeRange> oneStoreAgeSignals() {
        return null;
    }

    @JvmStatic
    public static final void showAgeRangeUpdatePermission(String description, Function2<? super Boolean, ? super AuthV4.AgeRange, Unit> callback) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C29011(description, callback, null), 3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x008d, code lost:
    
        if (r7 == r1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00bb, code lost:
    
        if (r7 == r1) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getAgeRange(kotlin.coroutines.Continuation<? super kotlin.Pair<com.hive.ResultAPI, com.hive.AuthV4.AgeRange>> r7) {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.compliance.AgeRange.getAgeRange(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Pair<ResultAPI, AuthV4.AgeRange> showAgeRangeUpdatePermission(String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        return new Pair<>(new ResultAPI(-2, ResultAPI.Code.CommonNotSupported), new AuthV4.AgeRange());
    }
}
