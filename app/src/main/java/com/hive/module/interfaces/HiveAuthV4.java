package com.hive.module.interfaces;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.AuthV4;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\b\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\rH&J\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lcom/hive/module/interfaces/HiveAuthV4;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "showInquiry", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/AuthV4$AuthV4ShowInquiryListener;", "showMyInquiry", "Lcom/hive/AuthV4$AuthV4ShowMyInquiryListener;", "showProfile", "playerId", "", "Lcom/hive/AuthV4$AuthV4ShowProfileListener;", "getVersionInfo", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HiveAuthV4 extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(HiveAuthV4 hiveAuthV4) {
            return HiveModuleName.INSTANCE.getAuthV4();
        }

        public static Map<String, String> getVersionInfo(HiveAuthV4 hiveAuthV4) {
            return new HashMap();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    @Override // com.hive.module.HiveModule
    Map<String, String> getVersionInfo();

    void showInquiry(AuthV4.AuthV4ShowInquiryListener listener);

    void showMyInquiry(AuthV4.AuthV4ShowMyInquiryListener listener);

    void showProfile(long playerId, AuthV4.AuthV4ShowProfileListener listener);
}
