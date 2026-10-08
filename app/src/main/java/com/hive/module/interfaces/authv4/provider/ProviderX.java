package com.hive.module.interfaces.authv4.provider;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016Jz\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2h\u0010\u000b\u001ad\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\fH&R\u0012\u0010\u0004\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderX;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "xClientId", "getXClientId", "()Ljava/lang/String;", "login", "", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "userId", "userName", "accessToken", "message", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderX extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ProviderX providerX) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_X();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    String getXClientId();

    void login(Activity activity, Function4<? super String, ? super String, ? super String, ? super String, Unit> listener);
}
