package com.hive.module.interfaces.authv4.provider;

import android.app.Activity;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\nH&J¤\u0001\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0091\u0001\u0010\u000f\u001a\u008c\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\f0\u0010H&J]\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2K\u0010\u000f\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u001aH&R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderXiaomi;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "userId", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "isLogin", "", "login", "", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "isSuccess", "", "code", NotificationCompat.CATEGORY_MESSAGE, "token", "nickname", "logout", "Lkotlin/Function3;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderXiaomi extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ProviderXiaomi providerXiaomi) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_Xiaomi();
        }
    }

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    String getUserId();

    boolean isLogin();

    void login(Activity activity, Function6<? super Boolean, ? super Integer, ? super String, ? super String, ? super String, ? super String, Unit> listener);

    void logout(Activity activity, Function3<? super Boolean, ? super Integer, ? super String, Unit> listener);

    void setUserId(String str);
}
