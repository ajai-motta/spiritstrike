package com.hive.module.interfaces;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.SocialV4;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\fH&J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/hive/module/interfaces/HiveSocialV4;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "showCommunity", "", "providerType", "Lcom/hive/SocialV4$ProviderType;", "viewType", "Lcom/hive/SocialV4$ViewType;", "url", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/SocialV4$SocialV4ShowCommunityListener;", "getVersionInfo", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HiveSocialV4 extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(HiveSocialV4 hiveSocialV4) {
            return HiveModuleName.INSTANCE.getSocialV4();
        }

        public static Map<String, String> getVersionInfo(HiveSocialV4 hiveSocialV4) {
            return new HashMap();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    @Override // com.hive.module.HiveModule
    Map<String, String> getVersionInfo();

    void showCommunity(SocialV4.ProviderType providerType, SocialV4.ViewType viewType, String url, SocialV4.SocialV4ShowCommunityListener listener);
}
