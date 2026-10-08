package com.hive.module.interfaces.authv4;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import com.hive.standalone.HiveLifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J,\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u000bH&¨\u0006\r"}, d2 = {"Lcom/hive/module/interfaces/authv4/RealNameVerification;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "verify", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface RealNameVerification extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(RealNameVerification realNameVerification) {
            return HiveModuleName.INSTANCE.getAuthV4_Real_Name_Verification();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void verify(Activity activity, HiveLifecycle.HiveAccount account, Function1<? super ResultAPI, Unit> listener);
}
