package com.hive.module.interfaces.authv4.provider;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderQq;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "login", "", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/provider/AuthV4ProviderAdapter$ProviderLoginListener;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderQq extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ProviderQq providerQq) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_Qq();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void login(Activity activity, AuthV4ProviderAdapter.ProviderLoginListener listener);
}
