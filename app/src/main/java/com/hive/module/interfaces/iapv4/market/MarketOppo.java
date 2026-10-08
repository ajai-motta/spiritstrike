package com.hive.module.interfaces.iapv4.market;

import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/hive/module/interfaces/iapv4/market/MarketOppo;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "getVersionInfo", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface MarketOppo extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(MarketOppo marketOppo) {
            return HiveModuleName.INSTANCE.getIapV4_Market_Oppo();
        }

        public static Map<String, String> getVersionInfo(MarketOppo marketOppo) {
            return new HashMap();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    @Override // com.hive.module.HiveModule
    Map<String, String> getVersionInfo();
}
