package com.hive.module.interfaces.authv4.provider;

import android.app.Activity;
import com.adxcorp.util.ADXLogUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0001\u001dJ\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\bH&Ja\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2O\u0010\u0010\u001aK\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0016\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\r0\u0011H&J\b\u0010\u0018\u001a\u00020\rH&J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H&J \u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0003H&R\u0012\u0010\u0004\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderFuntapAppraisal;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "appKey", "getAppKey", "()Ljava/lang/String;", "autoSaveCharacter", "", "getAutoSaveCharacter", "()Z", "isLogin", "login", "", "activity", "Landroid/app/Activity;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Lcom/hive/module/interfaces/authv4/provider/ProviderFuntapAppraisal$LoginResult;", "Lkotlin/ParameterName;", "name", "result", "userId", "token", "logout", "saveCharacter", "roleId", "areaId", "saveCharacterIfAutoSaveEnabled", "LoginResult", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderFuntapAppraisal extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ProviderFuntapAppraisal providerFuntapAppraisal) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_Funtap_Appraisal();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderFuntapAppraisal$LoginResult;", "", "<init>", "(Ljava/lang/String;I)V", ADXLogUtil.EVENT_LOAD_SUCCESS, "Cancel", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoginResult {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LoginResult[] $VALUES;
        public static final LoginResult Success = new LoginResult(ADXLogUtil.EVENT_LOAD_SUCCESS, 0);
        public static final LoginResult Cancel = new LoginResult("Cancel", 1);

        private static final /* synthetic */ LoginResult[] $values() {
            return new LoginResult[]{Success, Cancel};
        }

        static {
            LoginResult[] loginResultArr$values = $values();
            $VALUES = loginResultArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(loginResultArr$values);
        }

        private LoginResult(String str, int i) {
        }

        public static EnumEntries<LoginResult> getEntries() {
            return $ENTRIES;
        }

        public static LoginResult valueOf(String str) {
            return (LoginResult) Enum.valueOf(LoginResult.class, str);
        }

        public static LoginResult[] values() {
            return (LoginResult[]) $VALUES.clone();
        }
    }

    String getAppKey();

    boolean getAutoSaveCharacter();

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    boolean isLogin();

    void login(Activity activity, Function3<? super LoginResult, ? super String, ? super String, Unit> listener);

    void logout();

    void saveCharacter(Activity activity, String roleId, String areaId);

    void saveCharacterIfAutoSaveEnabled(Activity activity, String roleId, String areaId);
}
