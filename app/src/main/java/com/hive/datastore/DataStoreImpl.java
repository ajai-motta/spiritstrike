package com.hive.datastore;

import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Configuration;
import com.hive.DataStore;
import com.hive.ResultAPI;
import com.hive.configuration.ConfigurationImpl;
import com.hive.logger.LoggerImpl;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.HiveDataStore;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: DataStoreImpl.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J$\u0010\b\u001a\u00020\t2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u0011\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u000bH\u0080@¢\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u000bH\u0082@¢\u0006\u0002\u0010\u001fJ\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0!H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/hive/datastore/DataStoreImpl;", "Lcom/hive/module/interfaces/HiveDataStore;", "<init>", "()V", "ioDispatcher", "Lkotlin/coroutines/CoroutineContext;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "set", "", "key", "", "value", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/DataStore$DataStoreSetListener;", "data", "", "get", "Lcom/hive/DataStore$DataStoreGetListener;", "getMyData", "Lcom/hive/DataStore$DataStoreMyDataListener;", "getUsersData", "Lcom/hive/DataStore$DataStoreUsersDataListener;", "getPublicKey", "getPublicKey$hive_datastore_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDataStoreEnable", "", "checkParams", "Lcom/hive/ResultAPI;", "apiName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVersionInfo", "", "hive-datastore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataStoreImpl implements HiveDataStore {
    public static final DataStoreImpl INSTANCE = new DataStoreImpl();
    private static final CoroutineContext ioDispatcher;
    private static final CoroutineScope scope;

    /* JADX INFO: renamed from: com.hive.datastore.DataStoreImpl$checkParams$1, reason: invalid class name */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.datastore.DataStoreImpl", f = "DataStoreImpl.kt", i = {}, l = {174, 178}, m = "checkParams", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreImpl.this.checkParams(null, this);
        }
    }

    private DataStoreImpl() {
    }

    @Override // com.hive.module.interfaces.HiveDataStore, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return HiveDataStore.DefaultImpls.getHiveModuleName(this);
    }

    static {
        CoroutineContext coroutineContextPlus = Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null));
        ioDispatcher = coroutineContextPlus;
        scope = CoroutineScopeKt.CoroutineScope(coroutineContextPlus);
    }

    @Override // com.hive.module.interfaces.HiveDataStore
    public void set(String key, String value, DataStore.DataStoreSetListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[DataStore] set(key)");
        String str = key;
        if (str != null && !StringsKt.isBlank(str)) {
            if (value == null) {
                value = "";
            }
            set(MapsKt.mapOf(TuplesKt.to(key, value)), listener);
        } else {
            ResultAPI resultAPI = new ResultAPI(-1, ResultAPI.Code.DataStoreInvalidParam, "key is empty.");
            listener.onDataStoreSet(resultAPI);
            Unit unit = Unit.INSTANCE;
            LoggerImpl.INSTANCE.d(resultAPI.toString());
        }
    }

    @Override // com.hive.module.interfaces.HiveDataStore
    public void set(Map<String, String> data, DataStore.DataStoreSetListener listener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[DataStore] set(data)");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new AnonymousClass2(data, listener, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.datastore.DataStoreImpl$set$2, reason: invalid class name */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.datastore.DataStoreImpl$set$2", f = "DataStoreImpl.kt", i = {0, 1}, l = {36, 39, 43}, m = "invokeSuspend", n = {"result", "result"}, s = {"L$0", "L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Map<String, String> $data;
        final /* synthetic */ DataStore.DataStoreSetListener $listener;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Map<String, String> map, DataStore.DataStoreSetListener dataStoreSetListener, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$data = map;
            this.$listener = dataStoreSetListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$data, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00a0 A[RETURN] */
        /* JADX WARN: Type inference failed for: r8v16, types: [T, com.hive.ResultAPI] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 3
                r3 = 2
                r4 = 1
                r5 = 0
                if (r1 == 0) goto L33
                if (r1 == r4) goto L27
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                kotlin.ResultKt.throwOnFailure(r8)
                goto La1
            L17:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1f:
                java.lang.Object r1 = r7.L$0
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L71
            L27:
                java.lang.Object r1 = r7.L$1
                kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
                java.lang.Object r4 = r7.L$0
                kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
                kotlin.ResultKt.throwOnFailure(r8)
                goto L50
            L33:
                kotlin.ResultKt.throwOnFailure(r8)
                kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
                r1.<init>()
                com.hive.datastore.DataStoreImpl r8 = com.hive.datastore.DataStoreImpl.INSTANCE
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.L$0 = r1
                r7.L$1 = r1
                r7.label = r4
                java.lang.String r4 = "set(data)"
                java.lang.Object r8 = com.hive.datastore.DataStoreImpl.access$checkParams(r8, r4, r6)
                if (r8 != r0) goto L4f
                return r0
            L4f:
                r4 = r1
            L50:
                r1.element = r8
                T r8 = r4.element
                com.hive.ResultAPI r8 = (com.hive.ResultAPI) r8
                boolean r8 = r8.isSuccess()
                if (r8 == 0) goto L82
                com.hive.datastore.DataStoreNetwork r8 = com.hive.datastore.DataStoreNetwork.INSTANCE
                java.util.Map<java.lang.String, java.lang.String> r1 = r7.$data
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.L$0 = r4
                r7.L$1 = r5
                r7.label = r3
                java.lang.Object r8 = r8.insert(r1, r6)
                if (r8 != r0) goto L70
                return r0
            L70:
                r1 = r4
            L71:
                com.hive.protocol.datastore.Insert r8 = (com.hive.protocol.datastore.Insert) r8
                com.hive.datastore.DataStoreNetwork r3 = com.hive.datastore.DataStoreNetwork.INSTANCE
                com.hive.protocol.datastore.Insert$InsertResponse r8 = r8.getResponse()
                com.hive.protocol.datastore.DataStore$DataStoreResponse r8 = (com.hive.protocol.datastore.DataStore.DataStoreResponse) r8
                com.hive.ResultAPI r8 = r3.resultApi(r8)
                r1.element = r8
                r4 = r1
            L82:
                kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
                com.hive.datastore.DataStoreImpl$set$2$1 r1 = new com.hive.datastore.DataStoreImpl$set$2$1
                com.hive.DataStore$DataStoreSetListener r3 = r7.$listener
                r1.<init>(r3, r4, r5)
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                r3 = r7
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r7.L$0 = r5
                r7.L$1 = r5
                r7.label = r2
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r3)
                if (r8 != r0) goto La1
                return r0
            La1:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreImpl.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.hive.datastore.DataStoreImpl$set$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: DataStoreImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.datastore.DataStoreImpl$set$2$1", f = "DataStoreImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ DataStore.DataStoreSetListener $listener;
            final /* synthetic */ Ref.ObjectRef<ResultAPI> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(DataStore.DataStoreSetListener dataStoreSetListener, Ref.ObjectRef<ResultAPI> objectRef, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$listener = dataStoreSetListener;
                this.$result = objectRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$listener, this.$result, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$listener.onDataStoreSet(this.$result.element);
                Unit unit = Unit.INSTANCE;
                LoggerImpl.INSTANCE.d(this.$result.element.toString());
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.hive.module.interfaces.HiveDataStore
    public void get(String key, DataStore.DataStoreGetListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[DataStore] get");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C29041(key, listener, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.datastore.DataStoreImpl$get$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.datastore.DataStoreImpl$get$1", f = "DataStoreImpl.kt", i = {0, 1, 1}, l = {54, 62, 72}, m = "invokeSuspend", n = {"result", "result", "data"}, s = {"L$0", "L$0", "L$1"})
    static final class C29041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ DataStore.DataStoreGetListener $listener;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29041(String str, DataStore.DataStoreGetListener dataStoreGetListener, Continuation<? super C29041> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$listener = dataStoreGetListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29041(this.$key, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00bd  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x010e A[RETURN] */
        /* JADX WARN: Type inference failed for: r11v6, types: [T, com.hive.ResultAPI] */
        /* JADX WARN: Type inference failed for: r5v4, types: [T, com.hive.ResultAPI] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 274
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreImpl.C29041.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.hive.datastore.DataStoreImpl$get$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DataStoreImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.datastore.DataStoreImpl$get$1$2", f = "DataStoreImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<String> $data;
            final /* synthetic */ DataStore.DataStoreGetListener $listener;
            final /* synthetic */ Ref.ObjectRef<ResultAPI> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DataStore.DataStoreGetListener dataStoreGetListener, Ref.ObjectRef<ResultAPI> objectRef, Ref.ObjectRef<String> objectRef2, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$listener = dataStoreGetListener;
                this.$result = objectRef;
                this.$data = objectRef2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$listener, this.$result, this.$data, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$listener.onDataStoreGet(this.$result.element, this.$data.element);
                Unit unit = Unit.INSTANCE;
                LoggerImpl.INSTANCE.d(this.$result.element.toString());
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.hive.module.interfaces.HiveDataStore
    public void getMyData(DataStore.DataStoreMyDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[DataStore] getMyData");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C29051(listener, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.datastore.DataStoreImpl$getMyData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.datastore.DataStoreImpl$getMyData$1", f = "DataStoreImpl.kt", i = {0, 1, 1}, l = {83, 87, 101}, m = "invokeSuspend", n = {"result", "result", "data"}, s = {"L$0", "L$0", "L$1"})
    static final class C29051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DataStore.DataStoreMyDataListener $listener;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29051(DataStore.DataStoreMyDataListener dataStoreMyDataListener, Continuation<? super C29051> continuation) {
            super(2, continuation);
            this.$listener = dataStoreMyDataListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29051(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00f6 A[RETURN] */
        /* JADX WARN: Type inference failed for: r4v6, types: [T, com.hive.ResultAPI] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 250
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreImpl.C29051.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.hive.datastore.DataStoreImpl$getMyData$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DataStoreImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.datastore.DataStoreImpl$getMyData$1$2", f = "DataStoreImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Map<String, String> $data;
            final /* synthetic */ DataStore.DataStoreMyDataListener $listener;
            final /* synthetic */ Ref.ObjectRef<ResultAPI> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DataStore.DataStoreMyDataListener dataStoreMyDataListener, Ref.ObjectRef<ResultAPI> objectRef, Map<String, String> map, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$listener = dataStoreMyDataListener;
                this.$result = objectRef;
                this.$data = map;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$listener, this.$result, this.$data, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$listener.onDataStoreMyData(this.$result.element, this.$data);
                Unit unit = Unit.INSTANCE;
                LoggerImpl.INSTANCE.d(this.$result.element.toString());
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.hive.module.interfaces.HiveDataStore
    public void getUsersData(String key, DataStore.DataStoreUsersDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[DataStore] getUsersData");
        BuildersKt__Builders_commonKt.launch$default(scope, null, null, new C29061(key, listener, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.datastore.DataStoreImpl$getUsersData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataStoreImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.datastore.DataStoreImpl$getUsersData$1", f = "DataStoreImpl.kt", i = {0, 1, 1}, l = {112, 120, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO}, m = "invokeSuspend", n = {"result", "result", "data"}, s = {"L$0", "L$0", "L$1"})
    static final class C29061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        final /* synthetic */ DataStore.DataStoreUsersDataListener $listener;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C29061(String str, DataStore.DataStoreUsersDataListener dataStoreUsersDataListener, Continuation<? super C29061> continuation) {
            super(2, continuation);
            this.$key = str;
            this.$listener = dataStoreUsersDataListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C29061(this.$key, this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00d5  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x012e A[RETURN] */
        /* JADX WARN: Type inference failed for: r13v7, types: [T, com.hive.ResultAPI] */
        /* JADX WARN: Type inference failed for: r4v4, types: [T, com.hive.ResultAPI] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 306
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreImpl.C29061.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.hive.datastore.DataStoreImpl$getUsersData$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DataStoreImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.hive.datastore.DataStoreImpl$getUsersData$1$2", f = "DataStoreImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Map<Long, String> $data;
            final /* synthetic */ String $key;
            final /* synthetic */ DataStore.DataStoreUsersDataListener $listener;
            final /* synthetic */ Ref.ObjectRef<ResultAPI> $result;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DataStore.DataStoreUsersDataListener dataStoreUsersDataListener, Ref.ObjectRef<ResultAPI> objectRef, String str, Map<Long, String> map, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$listener = dataStoreUsersDataListener;
                this.$result = objectRef;
                this.$key = str;
                this.$data = map;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$listener, this.$result, this.$key, this.$data, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$listener.onDataStoreUsersData(this.$result.element, this.$key, this.$data);
                Unit unit = Unit.INSTANCE;
                LoggerImpl.INSTANCE.d(this.$result.element.toString());
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object checkParams(java.lang.String r8, kotlin.coroutines.Continuation<? super com.hive.ResultAPI> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.hive.datastore.DataStoreImpl.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            com.hive.datastore.DataStoreImpl$checkParams$1 r0 = (com.hive.datastore.DataStoreImpl.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.hive.datastore.DataStoreImpl$checkParams$1 r0 = new com.hive.datastore.DataStoreImpl$checkParams$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = -13
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3b
            if (r2 == r5) goto L37
            if (r2 != r4) goto L2f
            kotlin.ResultKt.throwOnFailure(r9)
            goto L96
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L7d
        L3b:
            kotlin.ResultKt.throwOnFailure(r9)
            com.hive.logger.LoggerImpl r9 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "[DataStore] checkParams: "
            r2.<init>(r6)
            r2.append(r8)
            java.lang.String r8 = r2.toString()
            r9.i(r8)
            com.hive.standalone.HiveLifecycle r8 = com.hive.standalone.HiveLifecycle.INSTANCE
            boolean r8 = r8.isSdkSetup()
            if (r8 != 0) goto L62
            com.hive.ResultAPI r8 = new com.hive.ResultAPI
            r9 = -7
            com.hive.ResultAPI$Code r0 = com.hive.ResultAPI.Code.DataStoreNotInitialized
            r8.<init>(r9, r0)
            return r8
        L62:
            com.hive.standalone.HiveLifecycle r8 = com.hive.standalone.HiveLifecycle.INSTANCE
            boolean r8 = r8.isSignOut()
            if (r8 == 0) goto L74
            com.hive.ResultAPI r8 = new com.hive.ResultAPI
            r9 = -9
            com.hive.ResultAPI$Code r0 = com.hive.ResultAPI.Code.DataStoreNeedSignIn
            r8.<init>(r9, r0)
            return r8
        L74:
            r0.label = r5
            java.lang.Object r9 = r7.isDataStoreEnable(r0)
            if (r9 != r1) goto L7d
            return r1
        L7d:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r8 = r9.booleanValue()
            if (r8 != 0) goto L8d
            com.hive.ResultAPI r8 = new com.hive.ResultAPI
            com.hive.ResultAPI$Code r9 = com.hive.ResultAPI.Code.DataStoreDisabled
            r8.<init>(r3, r9)
            return r8
        L8d:
            r0.label = r4
            java.lang.Object r9 = r7.getPublicKey$hive_datastore_release(r0)
            if (r9 != r1) goto L96
            return r1
        L96:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            boolean r8 = kotlin.text.StringsKt.isBlank(r9)
            if (r8 == 0) goto La6
            com.hive.ResultAPI r8 = new com.hive.ResultAPI
            com.hive.ResultAPI$Code r9 = com.hive.ResultAPI.Code.DataStoreNotExistPublicKey
            r8.<init>(r3, r9)
            return r8
        La6:
            com.hive.ResultAPI r8 = new com.hive.ResultAPI
            r9 = 0
            com.hive.ResultAPI$Code r0 = com.hive.ResultAPI.Code.Success
            r8.<init>(r9, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreImpl.checkParams(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Datastore(), "26.2.0");
        return map;
    }

    public final Object getPublicKey$hive_datastore_release(Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ConfigurationImpl.INSTANCE.getMetaData("data_store_key", false, new Configuration.GetMetaDataListener() { // from class: com.hive.datastore.DataStoreImpl$getPublicKey$2$1
            @Override // com.hive.Configuration.GetMetaDataListener
            public void onGetMetaData(ResultAPI result, String data) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(data, "data");
                if (cancellableContinuationImpl2.isActive()) {
                    CancellableContinuation<String> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(data));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object isDataStoreEnable(Continuation<? super Boolean> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ConfigurationImpl.INSTANCE.getMetaData("data_store", false, new Configuration.GetMetaDataListener() { // from class: com.hive.datastore.DataStoreImpl$isDataStoreEnable$2$1
            @Override // com.hive.Configuration.GetMetaDataListener
            public void onGetMetaData(ResultAPI result, String data) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(data, "data");
                int iHashCode = data.hashCode();
                boolean z = iHashCode == 49 ? data.equals("1") : iHashCode == 2583950 ? data.equals("TRUE") : iHashCode == 3569038 && data.equals("true");
                if (cancellableContinuationImpl2.isActive()) {
                    Boolean boolValueOf = Boolean.valueOf(z);
                    CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m7415constructorimpl(boolValueOf));
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
