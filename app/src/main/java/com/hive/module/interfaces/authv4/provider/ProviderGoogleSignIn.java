package com.hive.module.interfaces.authv4.provider;

import com.hive.module.GoogleSignInModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderGoogleSignIn;", "Lcom/hive/module/GoogleSignInModule;", "getHiveModuleName", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderGoogleSignIn extends GoogleSignInModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ProviderGoogleSignIn providerGoogleSignIn) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_Google_SignIn();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();
}
