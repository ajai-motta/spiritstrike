package com.hive.module.interfaces.authv4.provider;

import android.app.Activity;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016JH\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000326\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u000fH&J;\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u00032!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u0017H&R\u0012\u0010\u0004\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderFuntap;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "token", "getToken", "()Ljava/lang/String;", "skipUpdateUserInfo", "", "getSkipUpdateUserInfo", "()Z", "checkUserInfoComplete", "", "userId", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "isCompleted", "showUpdateUserInfo", "activity", "Landroid/app/Activity;", "Lkotlin/Function1;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderFuntap extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ProviderFuntap providerFuntap) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_Funtap();
        }
    }

    void checkUserInfoComplete(String userId, Function2<? super Boolean, ? super Boolean, Unit> callback);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    boolean getSkipUpdateUserInfo();

    String getToken();

    void showUpdateUserInfo(Activity activity, String userId, Function1<? super Boolean, Unit> callback);
}
