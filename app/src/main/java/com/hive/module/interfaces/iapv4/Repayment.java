package com.hive.module.interfaces.iapv4;

import android.app.Activity;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import com.hive.standalone.HiveLifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH&¨\u0006\f"}, d2 = {"Lcom/hive/module/interfaces/iapv4/Repayment;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "showRepayment", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "startGameListener", "Lkotlin/Function0;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface Repayment extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(Repayment repayment) {
            return HiveModuleName.INSTANCE.getIapV4_Repayment();
        }

        public static /* synthetic */ void showRepayment$default(Repayment repayment, Activity activity, HiveLifecycle.HiveAccount hiveAccount, Function0 function0, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showRepayment");
            }
            if ((i & 2) != 0) {
                hiveAccount = HiveLifecycle.INSTANCE.getAccount();
            }
            repayment.showRepayment(activity, hiveAccount, function0);
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void showRepayment(Activity activity, HiveLifecycle.HiveAccount account, Function0<Unit> startGameListener);
}
