package com.hive.module.interfaces.authv4;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import com.hive.module.interfaces.authv4.IdentityVerification;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016JV\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t28\u0010\n\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u000bH&JB\u0010\u0010\u001a\u00020\u000528\u0010\n\u001a4\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00050\u000bH&¨\u0006\u0012"}, d2 = {"Lcom/hive/module/interfaces/authv4/AdultConfirm;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "show", "", "activity", "Landroid/app/Activity;", "identity", "Lcom/hive/module/interfaces/authv4/IdentityVerification$Identity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lcom/hive/ResultAPI;", "Lkotlin/ParameterName;", "name", "resultApi", "getHashedDi", "hashedDi", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AdultConfirm extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(AdultConfirm adultConfirm) {
            return HiveModuleName.INSTANCE.getAuthV4_Adult_Confirm();
        }

        public static /* synthetic */ void show$default(AdultConfirm adultConfirm, Activity activity, IdentityVerification.Identity identity, Function2 function2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
            }
            if ((i & 2) != 0) {
                identity = null;
            }
            adultConfirm.show(activity, identity, function2);
        }
    }

    void getHashedDi(Function2<? super ResultAPI, ? super String, Unit> listener);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void show(Activity activity, IdentityVerification.Identity identity, Function2<? super ResultAPI, ? super IdentityVerification.Identity, Unit> listener);
}
