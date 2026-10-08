package com.hive;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.HiveDataStore;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J$\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00122\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u001a\u0010\u0013\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0014H\u0007J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0016H\u0007J\u001a\u0010\u0017\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0002R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/hive/DataStore;", "", "<init>", "()V", "dataStore", "Lcom/hive/module/interfaces/HiveDataStore;", "getDataStore", "()Lcom/hive/module/interfaces/HiveDataStore;", "dataStore$delegate", "Lkotlin/Lazy;", "set", "", "key", "", "value", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/DataStore$DataStoreSetListener;", "data", "", "get", "Lcom/hive/DataStore$DataStoreGetListener;", "getMyData", "Lcom/hive/DataStore$DataStoreMyDataListener;", "getUsersData", "Lcom/hive/DataStore$DataStoreUsersDataListener;", "getLibraryMissingError", "Lcom/hive/ResultAPI;", "DataStoreSetListener", "DataStoreGetListener", "DataStoreMyDataListener", "DataStoreUsersDataListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DataStore {
    public static final DataStore INSTANCE = new DataStore();

    /* JADX INFO: renamed from: dataStore$delegate, reason: from kotlin metadata */
    private static final Lazy dataStore = LazyKt.lazy(new Function0() { // from class: com.hive.DataStore$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return DataStore.dataStore_delegate$lambda$0();
        }
    });

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/DataStore$DataStoreGetListener;", "", "onDataStoreGet", "", "result", "Lcom/hive/ResultAPI;", "data", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DataStoreGetListener {
        void onDataStoreGet(ResultAPI result, String data);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, d2 = {"Lcom/hive/DataStore$DataStoreMyDataListener;", "", "onDataStoreMyData", "", "result", "Lcom/hive/ResultAPI;", "myData", "", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DataStoreMyDataListener {
        void onDataStoreMyData(ResultAPI result, Map<String, String> myData);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/DataStore$DataStoreSetListener;", "", "onDataStoreSet", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DataStoreSetListener {
        void onDataStoreSet(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\tH&¨\u0006\u000b"}, d2 = {"Lcom/hive/DataStore$DataStoreUsersDataListener;", "", "onDataStoreUsersData", "", "result", "Lcom/hive/ResultAPI;", "key", "", "usersData", "", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface DataStoreUsersDataListener {
        void onDataStoreUsersData(ResultAPI result, String key, Map<Long, String> usersData);
    }

    private DataStore() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HiveDataStore dataStore_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HiveDataStore.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HiveDataStore)) {
            hiveModule = null;
        }
        return (HiveDataStore) (hiveModule instanceof HiveDataStore ? hiveModule : null);
    }

    @JvmStatic
    public static final void get(String key, DataStoreGetListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        DataStore dataStore2 = INSTANCE;
        HiveDataStore dataStore3 = dataStore2.getDataStore();
        if (dataStore3 != null) {
            dataStore3.get(key, listener);
        } else {
            listener.onDataStoreGet(dataStore2.getLibraryMissingError(), null);
        }
    }

    private final HiveDataStore getDataStore() {
        return (HiveDataStore) dataStore.getValue();
    }

    private final ResultAPI getLibraryMissingError() {
        return new ResultAPI(-13, ResultAPI.Code.CommonLibraryMissing, "DataStore library missing.");
    }

    @JvmStatic
    public static final void getMyData(DataStoreMyDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        DataStore dataStore2 = INSTANCE;
        HiveDataStore dataStore3 = dataStore2.getDataStore();
        if (dataStore3 != null) {
            dataStore3.getMyData(listener);
        } else {
            listener.onDataStoreMyData(dataStore2.getLibraryMissingError(), MapsKt.emptyMap());
        }
    }

    @JvmStatic
    public static final void getUsersData(String key, DataStoreUsersDataListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        DataStore dataStore2 = INSTANCE;
        HiveDataStore dataStore3 = dataStore2.getDataStore();
        if (dataStore3 != null) {
            dataStore3.getUsersData(key, listener);
        } else {
            listener.onDataStoreUsersData(dataStore2.getLibraryMissingError(), key, MapsKt.emptyMap());
        }
    }

    @JvmStatic
    public static final void set(String key, String value, DataStoreSetListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        DataStore dataStore2 = INSTANCE;
        HiveDataStore dataStore3 = dataStore2.getDataStore();
        if (dataStore3 != null) {
            dataStore3.set(key, value, listener);
        } else {
            listener.onDataStoreSet(dataStore2.getLibraryMissingError());
        }
    }

    @JvmStatic
    public static final void set(Map<String, String> data, DataStoreSetListener listener) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(listener, "listener");
        DataStore dataStore2 = INSTANCE;
        HiveDataStore dataStore3 = dataStore2.getDataStore();
        if (dataStore3 != null) {
            dataStore3.set(data, listener);
        } else {
            listener.onDataStoreSet(dataStore2.getLibraryMissingError());
        }
    }
}
