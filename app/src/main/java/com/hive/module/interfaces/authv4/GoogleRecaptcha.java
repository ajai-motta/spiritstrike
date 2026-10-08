package com.hive.module.interfaces.authv4;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J$\u0010\u0004\u001a\u00020\u00052\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\u0007H'¨\u0006\t"}, d2 = {"Lcom/hive/module/interfaces/authv4/GoogleRecaptcha;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "executeRecaptcha", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface GoogleRecaptcha extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(GoogleRecaptcha googleRecaptcha) {
            return HiveModuleName.INSTANCE.getAuthV4_Google_Recaptcha();
        }
    }

    void executeRecaptcha(Function2<? super Integer, ? super String, Unit> listener);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();
}
