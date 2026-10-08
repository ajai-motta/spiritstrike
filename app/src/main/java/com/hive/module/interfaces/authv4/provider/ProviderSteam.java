package com.hive.module.interfaces.authv4.provider;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import io.ktor.http.auth.HttpAuthHeader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016JL\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2:\u0010\r\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\u000eH&R\u0012\u0010\u0004\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderSteam;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", HttpAuthHeader.Parameters.Realm, "getRealm", "()Ljava/lang/String;", "authenticationRequestUrl", "getAuthenticationRequestUrl", "login", "", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "encodedQuery", "steamId", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderSteam extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ProviderSteam providerSteam) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_Steam();
        }
    }

    String getAuthenticationRequestUrl();

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    String getRealm();

    void login(Activity activity, Function2<? super String, ? super String, Unit> listener);
}
