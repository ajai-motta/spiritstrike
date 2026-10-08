package com.hive.module.interfaces.authv4.provider;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016Jc\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2Q\u0010\u000f\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\f0\u0010H&J\b\u0010\u0016\u001a\u00020\fH&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0003H&R\u0012\u0010\u0004\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderWeverse;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "weverseClientId", "getWeverseClientId", "()Ljava/lang/String;", "weverseIsTest", "", "getWeverseIsTest", "()Z", "login", "", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "userKey", "accessToken", "errorMessage", "logout", "getUserKey", "getAccessToken", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderWeverse extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ProviderWeverse providerWeverse) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_Weverse();
        }
    }

    String getAccessToken();

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    String getUserKey();

    String getWeverseClientId();

    boolean getWeverseIsTest();

    void login(Activity activity, Function3<? super String, ? super String, ? super String, Unit> listener);

    void logout();
}
