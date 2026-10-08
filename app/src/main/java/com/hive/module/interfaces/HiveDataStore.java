package com.hive.module.interfaces;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.DataStore;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J$\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\tH&J$\u0010\u0004\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\b\u001a\u00020\tH&J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000fH&J\u001a\u0010\u0010\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0011H&¨\u0006\u0012"}, d2 = {"Lcom/hive/module/interfaces/HiveDataStore;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "set", "", "key", "value", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/DataStore$DataStoreSetListener;", "data", "", "get", "Lcom/hive/DataStore$DataStoreGetListener;", "getMyData", "Lcom/hive/DataStore$DataStoreMyDataListener;", "getUsersData", "Lcom/hive/DataStore$DataStoreUsersDataListener;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HiveDataStore extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(HiveDataStore hiveDataStore) {
            return HiveModuleName.INSTANCE.getDataStore();
        }
    }

    void get(String key, DataStore.DataStoreGetListener listener);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void getMyData(DataStore.DataStoreMyDataListener listener);

    void getUsersData(String key, DataStore.DataStoreUsersDataListener listener);

    void set(String key, String value, DataStore.DataStoreSetListener listener);

    void set(Map<String, String> data, DataStore.DataStoreSetListener listener);
}
