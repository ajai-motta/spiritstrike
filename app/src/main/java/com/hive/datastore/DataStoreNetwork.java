package com.hive.datastore;

import com.hive.ResultAPI;
import com.hive.protocol.datastore.DataStore;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataStoreNetwork.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0086@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\"\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0014H\u0086@¢\u0006\u0002\u0010\u0015J(\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0017\"\b\b\u0000\u0010\u0018*\u00020\u0019*\b\u0012\u0004\u0012\u0002H\u00180\u0017H\u0082@¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/hive/datastore/DataStoreNetwork;", "", "<init>", "()V", "resultApi", "Lcom/hive/ResultAPI;", "Lcom/hive/protocol/datastore/DataStore$DataStoreResponse;", "get", "Lcom/hive/protocol/datastore/Get;", "key", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDataKey", "Lcom/hive/protocol/datastore/GetDataKey;", "getUserKey", "Lcom/hive/protocol/datastore/GetUserKey;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "Lcom/hive/protocol/datastore/Insert;", "data", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setBasePostBody", "Lcom/hive/protocol/Protocol;", "T", "Lcom/hive/protocol/datastore/DataStore;", "(Lcom/hive/protocol/Protocol;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hive-datastore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataStoreNetwork {
    public static final DataStoreNetwork INSTANCE = new DataStoreNetwork();

    /* JADX INFO: renamed from: com.hive.datastore.DataStoreNetwork$get$1, reason: invalid class name */
    /* JADX INFO: compiled from: DataStoreNetwork.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.datastore.DataStoreNetwork", f = "DataStoreNetwork.kt", i = {0, 0}, l = {40}, m = "get", n = {"key", "$this$get_u24lambda_u240"}, s = {"L$0", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreNetwork.this.get(null, this);
        }
    }

    /* JADX INFO: renamed from: com.hive.datastore.DataStoreNetwork$getDataKey$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataStoreNetwork.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.datastore.DataStoreNetwork", f = "DataStoreNetwork.kt", i = {0, 0}, l = {50}, m = "getDataKey", n = {"key", "$this$getDataKey_u24lambda_u241"}, s = {"L$0", "L$2"})
    static final class C29071 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C29071(Continuation<? super C29071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreNetwork.this.getDataKey(null, this);
        }
    }

    /* JADX INFO: renamed from: com.hive.datastore.DataStoreNetwork$getUserKey$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataStoreNetwork.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.datastore.DataStoreNetwork", f = "DataStoreNetwork.kt", i = {}, l = {60}, m = "getUserKey", n = {}, s = {})
    static final class C29081 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C29081(Continuation<? super C29081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreNetwork.this.getUserKey(this);
        }
    }

    /* JADX INFO: renamed from: com.hive.datastore.DataStoreNetwork$insert$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataStoreNetwork.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.datastore.DataStoreNetwork", f = "DataStoreNetwork.kt", i = {0, 0}, l = {75}, m = "insert", n = {"json", "$this$insert_u24lambda_u245"}, s = {"L$0", "L$2"})
    static final class C29091 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C29091(Continuation<? super C29091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreNetwork.this.insert(null, this);
        }
    }

    /* JADX INFO: renamed from: com.hive.datastore.DataStoreNetwork$setBasePostBody$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DataStoreNetwork.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.datastore.DataStoreNetwork", f = "DataStoreNetwork.kt", i = {0}, l = {84}, m = "setBasePostBody", n = {"$this$setBasePostBody"}, s = {"L$0"})
    static final class C29101<T extends DataStore> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C29101(Continuation<? super C29101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DataStoreNetwork.this.setBasePostBody(null, this);
        }
    }

    private DataStoreNetwork() {
    }

    public final ResultAPI resultApi(DataStore.DataStoreResponse dataStoreResponse) {
        Intrinsics.checkNotNullParameter(dataStoreResponse, "<this>");
        if (dataStoreResponse.isSuccess()) {
            return new ResultAPI();
        }
        if (dataStoreResponse.getHttpStatusCode() == 200) {
            int msgCode = dataStoreResponse.getMsgCode();
            if (msgCode == 0) {
                return new ResultAPI();
            }
            switch (msgCode) {
                case 11:
                    return new ResultAPI(-8, ResultAPI.Code.DataStoreNotExistKey, dataStoreResponse.getMsg());
                case 12:
                    return new ResultAPI(-8, ResultAPI.Code.DataStoreNotExistColumn, dataStoreResponse.getMsg());
                case 13:
                    return new ResultAPI(-8, ResultAPI.Code.DataStoreGameIsBeingInspected, dataStoreResponse.getMsg());
                default:
                    return new ResultAPI(-8, ResultAPI.Code.DataStoreResponseError, dataStoreResponse.getMsg());
            }
        }
        return new ResultAPI(-8, ResultAPI.Code.DataStoreResponseError, "(" + dataStoreResponse.getHttpStatusCode() + ") " + dataStoreResponse.getMsg());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object get(java.lang.String r5, kotlin.coroutines.Continuation<? super com.hive.protocol.datastore.Get> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.hive.datastore.DataStoreNetwork.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r6
            com.hive.datastore.DataStoreNetwork$get$1 r0 = (com.hive.datastore.DataStoreNetwork.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.hive.datastore.DataStoreNetwork$get$1 r0 = new com.hive.datastore.DataStoreNetwork$get$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$2
            com.hive.protocol.Protocol r5 = (com.hive.protocol.Protocol) r5
            java.lang.Object r1 = r0.L$1
            com.hive.protocol.Protocol r1 = (com.hive.protocol.Protocol) r1
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L60
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.ResultKt.throwOnFailure(r6)
            com.hive.protocol.Protocol$Companion r6 = com.hive.protocol.Protocol.INSTANCE
            com.hive.protocol.Protocol r6 = new com.hive.protocol.Protocol
            com.hive.datastore.DataStoreNetwork$get$$inlined$invoke$1 r2 = new kotlin.jvm.functions.Function0<com.hive.protocol.datastore.Get>() { // from class: com.hive.datastore.DataStoreNetwork$get$$inlined$invoke$1
                static {
                    /*
                        com.hive.datastore.DataStoreNetwork$get$$inlined$invoke$1 r0 = new com.hive.datastore.DataStoreNetwork$get$$inlined$invoke$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.hive.datastore.DataStoreNetwork$get$$inlined$invoke$1) com.hive.datastore.DataStoreNetwork$get$$inlined$invoke$1.INSTANCE com.hive.datastore.DataStoreNetwork$get$$inlined$invoke$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$get$$inlined$invoke$1.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$get$$inlined$invoke$1.<init>():void");
                }

                /* JADX WARN: Type inference failed for: r0v0, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.datastore.Get] */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ com.hive.protocol.datastore.Get invoke() {
                    /*
                        r1 = this;
                        com.hive.protocol.ProtocolRequest r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$get$$inlined$invoke$1.invoke():java.lang.Object");
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.datastore.Get] */
                @Override // kotlin.jvm.functions.Function0
                public final com.hive.protocol.datastore.Get invoke() throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
                    /*
                        r3 = this;
                        java.lang.Class<com.hive.protocol.datastore.Get> r0 = com.hive.protocol.datastore.Get.class
                        r1 = 0
                        java.lang.Class[] r2 = new java.lang.Class[r1]
                        java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r2)
                        java.lang.Object[] r1 = new java.lang.Object[r1]
                        java.lang.Object r0 = r0.newInstance(r1)
                        java.lang.String r1 = "newInstance(...)"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                        com.hive.protocol.ProtocolRequest r0 = (com.hive.protocol.ProtocolRequest) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$get$$inlined$invoke$1.invoke():com.hive.protocol.ProtocolRequest");
                }
            }
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r6.<init>(r2)
            com.hive.datastore.DataStoreNetwork r2 = com.hive.datastore.DataStoreNetwork.INSTANCE
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r0 = r2.setBasePostBody(r6, r0)
            if (r0 != r1) goto L5d
            return r1
        L5d:
            r0 = r5
            r5 = r6
            r1 = r5
        L60:
            com.hive.core.HiveKeys r6 = com.hive.core.HiveKeys.KEY_data_key
            r5.setParam(r6, r0)
            com.hive.protocol.ProtocolRequest r5 = r1.request()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork.get(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getDataKey(java.lang.String r5, kotlin.coroutines.Continuation<? super com.hive.protocol.datastore.GetDataKey> r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.hive.datastore.DataStoreNetwork.C29071
            if (r0 == 0) goto L14
            r0 = r6
            com.hive.datastore.DataStoreNetwork$getDataKey$1 r0 = (com.hive.datastore.DataStoreNetwork.C29071) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            com.hive.datastore.DataStoreNetwork$getDataKey$1 r0 = new com.hive.datastore.DataStoreNetwork$getDataKey$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r5 = r0.L$2
            com.hive.protocol.Protocol r5 = (com.hive.protocol.Protocol) r5
            java.lang.Object r1 = r0.L$1
            com.hive.protocol.Protocol r1 = (com.hive.protocol.Protocol) r1
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L60
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.ResultKt.throwOnFailure(r6)
            com.hive.protocol.Protocol$Companion r6 = com.hive.protocol.Protocol.INSTANCE
            com.hive.protocol.Protocol r6 = new com.hive.protocol.Protocol
            com.hive.datastore.DataStoreNetwork$getDataKey$$inlined$invoke$1 r2 = new kotlin.jvm.functions.Function0<com.hive.protocol.datastore.GetDataKey>() { // from class: com.hive.datastore.DataStoreNetwork$getDataKey$$inlined$invoke$1
                static {
                    /*
                        com.hive.datastore.DataStoreNetwork$getDataKey$$inlined$invoke$1 r0 = new com.hive.datastore.DataStoreNetwork$getDataKey$$inlined$invoke$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.hive.datastore.DataStoreNetwork$getDataKey$$inlined$invoke$1) com.hive.datastore.DataStoreNetwork$getDataKey$$inlined$invoke$1.INSTANCE com.hive.datastore.DataStoreNetwork$getDataKey$$inlined$invoke$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$getDataKey$$inlined$invoke$1.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$getDataKey$$inlined$invoke$1.<init>():void");
                }

                /* JADX WARN: Type inference failed for: r0v0, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.datastore.GetDataKey] */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ com.hive.protocol.datastore.GetDataKey invoke() {
                    /*
                        r1 = this;
                        com.hive.protocol.ProtocolRequest r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$getDataKey$$inlined$invoke$1.invoke():java.lang.Object");
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.datastore.GetDataKey] */
                @Override // kotlin.jvm.functions.Function0
                public final com.hive.protocol.datastore.GetDataKey invoke() throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
                    /*
                        r3 = this;
                        java.lang.Class<com.hive.protocol.datastore.GetDataKey> r0 = com.hive.protocol.datastore.GetDataKey.class
                        r1 = 0
                        java.lang.Class[] r2 = new java.lang.Class[r1]
                        java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r2)
                        java.lang.Object[] r1 = new java.lang.Object[r1]
                        java.lang.Object r0 = r0.newInstance(r1)
                        java.lang.String r1 = "newInstance(...)"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                        com.hive.protocol.ProtocolRequest r0 = (com.hive.protocol.ProtocolRequest) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$getDataKey$$inlined$invoke$1.invoke():com.hive.protocol.ProtocolRequest");
                }
            }
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r6.<init>(r2)
            com.hive.datastore.DataStoreNetwork r2 = com.hive.datastore.DataStoreNetwork.INSTANCE
            r0.L$0 = r5
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r0 = r2.setBasePostBody(r6, r0)
            if (r0 != r1) goto L5d
            return r1
        L5d:
            r0 = r5
            r5 = r6
            r1 = r5
        L60:
            com.hive.core.HiveKeys r6 = com.hive.core.HiveKeys.KEY_data_key
            r5.setParam(r6, r0)
            com.hive.protocol.ProtocolRequest r5 = r1.request()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork.getDataKey(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getUserKey(kotlin.coroutines.Continuation<? super com.hive.protocol.datastore.GetUserKey> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.hive.datastore.DataStoreNetwork.C29081
            if (r0 == 0) goto L14
            r0 = r5
            com.hive.datastore.DataStoreNetwork$getUserKey$1 r0 = (com.hive.datastore.DataStoreNetwork.C29081) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.hive.datastore.DataStoreNetwork$getUserKey$1 r0 = new com.hive.datastore.DataStoreNetwork$getUserKey$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            com.hive.protocol.Protocol r0 = (com.hive.protocol.Protocol) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L52
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            com.hive.protocol.Protocol$Companion r5 = com.hive.protocol.Protocol.INSTANCE
            com.hive.protocol.Protocol r5 = new com.hive.protocol.Protocol
            com.hive.datastore.DataStoreNetwork$getUserKey$$inlined$invoke$1 r2 = new kotlin.jvm.functions.Function0<com.hive.protocol.datastore.GetUserKey>() { // from class: com.hive.datastore.DataStoreNetwork$getUserKey$$inlined$invoke$1
                static {
                    /*
                        com.hive.datastore.DataStoreNetwork$getUserKey$$inlined$invoke$1 r0 = new com.hive.datastore.DataStoreNetwork$getUserKey$$inlined$invoke$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.hive.datastore.DataStoreNetwork$getUserKey$$inlined$invoke$1) com.hive.datastore.DataStoreNetwork$getUserKey$$inlined$invoke$1.INSTANCE com.hive.datastore.DataStoreNetwork$getUserKey$$inlined$invoke$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$getUserKey$$inlined$invoke$1.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$getUserKey$$inlined$invoke$1.<init>():void");
                }

                /* JADX WARN: Type inference failed for: r0v0, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.datastore.GetUserKey] */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ com.hive.protocol.datastore.GetUserKey invoke() {
                    /*
                        r1 = this;
                        com.hive.protocol.ProtocolRequest r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$getUserKey$$inlined$invoke$1.invoke():java.lang.Object");
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.datastore.GetUserKey] */
                @Override // kotlin.jvm.functions.Function0
                public final com.hive.protocol.datastore.GetUserKey invoke() throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
                    /*
                        r3 = this;
                        java.lang.Class<com.hive.protocol.datastore.GetUserKey> r0 = com.hive.protocol.datastore.GetUserKey.class
                        r1 = 0
                        java.lang.Class[] r2 = new java.lang.Class[r1]
                        java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r2)
                        java.lang.Object[] r1 = new java.lang.Object[r1]
                        java.lang.Object r0 = r0.newInstance(r1)
                        java.lang.String r1 = "newInstance(...)"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                        com.hive.protocol.ProtocolRequest r0 = (com.hive.protocol.ProtocolRequest) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$getUserKey$$inlined$invoke$1.invoke():com.hive.protocol.ProtocolRequest");
                }
            }
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r5.<init>(r2)
            com.hive.datastore.DataStoreNetwork r2 = com.hive.datastore.DataStoreNetwork.INSTANCE
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r0 = r2.setBasePostBody(r5, r0)
            if (r0 != r1) goto L51
            return r1
        L51:
            r0 = r5
        L52:
            com.hive.protocol.ProtocolRequest r5 = r0.request()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork.getUserKey(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object insert(java.util.Map<java.lang.String, java.lang.String> r6, kotlin.coroutines.Continuation<? super com.hive.protocol.datastore.Insert> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.hive.datastore.DataStoreNetwork.C29091
            if (r0 == 0) goto L14
            r0 = r7
            com.hive.datastore.DataStoreNetwork$insert$1 r0 = (com.hive.datastore.DataStoreNetwork.C29091) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.hive.datastore.DataStoreNetwork$insert$1 r0 = new com.hive.datastore.DataStoreNetwork$insert$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r6 = r0.L$2
            com.hive.protocol.Protocol r6 = (com.hive.protocol.Protocol) r6
            java.lang.Object r1 = r0.L$1
            com.hive.protocol.Protocol r1 = (com.hive.protocol.Protocol) r1
            java.lang.Object r0 = r0.L$0
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L86
        L36:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3e:
            kotlin.ResultKt.throwOnFailure(r7)
            org.json.JSONObject r7 = new org.json.JSONObject
            r7.<init>()
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L4e:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L68
            java.lang.Object r2 = r6.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r2 = r2.getValue()
            com.hive.core.CommonIdentifierKt.putCheck(r7, r4, r2)
            goto L4e
        L68:
            com.hive.protocol.Protocol$Companion r6 = com.hive.protocol.Protocol.INSTANCE
            com.hive.protocol.Protocol r6 = new com.hive.protocol.Protocol
            com.hive.datastore.DataStoreNetwork$insert$$inlined$invoke$1 r2 = new kotlin.jvm.functions.Function0<com.hive.protocol.datastore.Insert>() { // from class: com.hive.datastore.DataStoreNetwork$insert$$inlined$invoke$1
                static {
                    /*
                        com.hive.datastore.DataStoreNetwork$insert$$inlined$invoke$1 r0 = new com.hive.datastore.DataStoreNetwork$insert$$inlined$invoke$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:com.hive.datastore.DataStoreNetwork$insert$$inlined$invoke$1) com.hive.datastore.DataStoreNetwork$insert$$inlined$invoke$1.INSTANCE com.hive.datastore.DataStoreNetwork$insert$$inlined$invoke$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$insert$$inlined$invoke$1.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$insert$$inlined$invoke$1.<init>():void");
                }

                /* JADX WARN: Type inference failed for: r0v0, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.datastore.Insert] */
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ com.hive.protocol.datastore.Insert invoke() {
                    /*
                        r1 = this;
                        com.hive.protocol.ProtocolRequest r0 = r1.invoke()
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$insert$$inlined$invoke$1.invoke():java.lang.Object");
                }

                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.datastore.Insert] */
                @Override // kotlin.jvm.functions.Function0
                public final com.hive.protocol.datastore.Insert invoke() throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.reflect.InvocationTargetException {
                    /*
                        r3 = this;
                        java.lang.Class<com.hive.protocol.datastore.Insert> r0 = com.hive.protocol.datastore.Insert.class
                        r1 = 0
                        java.lang.Class[] r2 = new java.lang.Class[r1]
                        java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r2)
                        java.lang.Object[] r1 = new java.lang.Object[r1]
                        java.lang.Object r0 = r0.newInstance(r1)
                        java.lang.String r1 = "newInstance(...)"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                        com.hive.protocol.ProtocolRequest r0 = (com.hive.protocol.ProtocolRequest) r0
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork$insert$$inlined$invoke$1.invoke():com.hive.protocol.ProtocolRequest");
                }
            }
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r6.<init>(r2)
            com.hive.datastore.DataStoreNetwork r2 = com.hive.datastore.DataStoreNetwork.INSTANCE
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r0 = r2.setBasePostBody(r6, r0)
            if (r0 != r1) goto L84
            return r1
        L84:
            r1 = r6
            r0 = r7
        L86:
            com.hive.core.HiveKeys r7 = com.hive.core.HiveKeys.KEY_data
            r6.setParam(r7, r0)
            com.hive.protocol.ProtocolRequest r6 = r1.request()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork.insert(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <T extends com.hive.protocol.datastore.DataStore> java.lang.Object setBasePostBody(com.hive.protocol.Protocol<T> r6, kotlin.coroutines.Continuation<? super com.hive.protocol.Protocol<T>> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.hive.datastore.DataStoreNetwork.C29101
            if (r0 == 0) goto L14
            r0 = r7
            com.hive.datastore.DataStoreNetwork$setBasePostBody$1 r0 = (com.hive.datastore.DataStoreNetwork.C29101) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L19
        L14:
            com.hive.datastore.DataStoreNetwork$setBasePostBody$1 r0 = new com.hive.datastore.DataStoreNetwork$setBasePostBody$1
            r0.<init>(r7)
        L19:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            com.hive.protocol.datastore.DataStore r6 = (com.hive.protocol.datastore.DataStore) r6
            java.lang.Object r0 = r0.L$0
            com.hive.protocol.Protocol r0 = (com.hive.protocol.Protocol) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L56
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            com.hive.protocol.ProtocolRequest r7 = r6.getProtocol()
            com.hive.protocol.datastore.DataStore r7 = (com.hive.protocol.datastore.DataStore) r7
            com.hive.datastore.DataStoreImpl r2 = com.hive.datastore.DataStoreImpl.INSTANCE
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r0 = r2.getPublicKey$hive_datastore_release(r0)
            if (r0 != r1) goto L52
            return r1
        L52:
            r4 = r0
            r0 = r6
            r6 = r7
            r7 = r4
        L56:
            java.lang.String r7 = (java.lang.String) r7
            r6.setPublicKey(r7)
            com.hive.standalone.HiveLifecycle r6 = com.hive.standalone.HiveLifecycle.INSTANCE
            com.hive.standalone.HiveLifecycle$HiveAccount r6 = r6.getAccount()
            com.hive.core.HiveKeys r7 = com.hive.core.HiveKeys.KEY_player_id
            java.lang.String r1 = r6.getVid()
            if (r1 != 0) goto L6d
            java.lang.String r1 = r6.getUid()
        L6d:
            r0.setParam(r7, r1)
            com.hive.core.HiveKeys r7 = com.hive.core.HiveKeys.KEY_vid_type
            java.lang.String r1 = r6.getVidType()
            r0.setParam(r7, r1)
            com.hive.core.HiveKeys r7 = com.hive.core.HiveKeys.KEY_app_id
            com.hive.core.Configuration r1 = com.hive.core.Configuration.INSTANCE
            java.lang.String r1 = r1.getAppId()
            r0.setParam(r7, r1)
            com.hive.core.HiveKeys r7 = com.hive.core.HiveKeys.KEY_did
            java.lang.String r1 = r6.getDid()
            r0.setParam(r7, r1)
            com.hive.core.HiveKeys r7 = com.hive.core.HiveKeys.KEY_token
            java.lang.String r1 = r6.getVidSession()
            if (r1 != 0) goto L99
            java.lang.String r1 = r6.getUidSession()
        L99:
            r0.setParam(r7, r1)
            com.hive.core.OauthToken r6 = r6.getOauthToken()
            if (r6 == 0) goto La5
            r0.setOauthToken(r6)
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.datastore.DataStoreNetwork.setBasePostBody(com.hive.protocol.Protocol, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
