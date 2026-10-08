package com.hive.module.interfaces.authv4;

import android.app.Activity;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016JZ\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010H&JC\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00050\u0010H&¨\u0006\u0016"}, d2 = {"Lcom/hive/module/interfaces/authv4/DeviceManagement;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "checkDevice", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "disableSubscriptionGuide", "", "phoneCode", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, InAppPurchaseMetaData.KEY_SIGNATURE, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "Lcom/hive/ResultAPI;", "show", "Lkotlin/ParameterName;", "name", "result", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface DeviceManagement extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void checkDevice$default(DeviceManagement deviceManagement, Activity activity, HiveLifecycle.HiveAccount hiveAccount, boolean z, String str, String str2, String str3, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkDevice");
            }
            deviceManagement.checkDevice(activity, hiveAccount, z, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3, function1);
        }

        public static String getHiveModuleName(DeviceManagement deviceManagement) {
            return HiveModuleName.INSTANCE.getAuthV4_Device_Management();
        }
    }

    void checkDevice(Activity activity, HiveLifecycle.HiveAccount account, boolean disableSubscriptionGuide, String phoneCode, String phoneNumber, String signature, Function1<? super ResultAPI, Unit> listener);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void show(Activity activity, HiveLifecycle.HiveAccount account, boolean disableSubscriptionGuide, Function1<? super ResultAPI, Unit> listener);
}
