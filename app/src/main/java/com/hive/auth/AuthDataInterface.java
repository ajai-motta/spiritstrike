package com.hive.auth;

import com.facebook.internal.NativeProtocol;
import com.hive.ResultAPI;
import com.hive.base.DataModel;
import com.hive.logger.LoggerImpl;
import com.hive.social.SocialKeys;
import com.hive.standalone.HiveLifecycle;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001:\f\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/hive/auth/AuthDataInterface;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "loginType", "Lcom/hive/auth/AuthDataInterface$LoginType;", "getLoginType$annotations", "getLoginType", "()Lcom/hive/auth/AuthDataInterface$LoginType;", "account", "Lcom/hive/auth/AuthDataInterface$Account;", "getAccount$annotations", "getAccount", "()Lcom/hive/auth/AuthDataInterface$Account;", "AuthInitializeListener", "AuthLoginListener", "AuthLogoutListener", "AuthShowTermsListener", "AuthMaintenanceListener", "AuthAdultConfirmListener", "LoginType", "AuthMaintenanceActionType", "Account", "AuthInitResult", "AuthMaintenanceInfo", "AuthMaintenanceExtraButton", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthDataInterface {
    public static final AuthDataInterface INSTANCE = new AuthDataInterface();
    private static final String TAG = "AuthDataInterface";

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/auth/AuthDataInterface$AuthAdultConfirmListener;", "", "onAuthAdultConfirm", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthAdultConfirmListener {
        void onAuthAdultConfirm(ResultAPI result);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/auth/AuthDataInterface$AuthInitializeListener;", "", "onAuthInitialize", "", "result", "Lcom/hive/ResultAPI;", "authInitResult", "Lcom/hive/auth/AuthDataInterface$AuthInitResult;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthInitializeListener {
        void onAuthInitialize(ResultAPI result, AuthInitResult authInitResult);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&¨\u0006\u000b"}, d2 = {"Lcom/hive/auth/AuthDataInterface$AuthLoginListener;", "", "onAuthLogin", "", "result", "Lcom/hive/ResultAPI;", "loginType", "Lcom/hive/auth/AuthDataInterface$LoginType;", "currentAccount", "Lcom/hive/auth/AuthDataInterface$Account;", "usedAccount", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthLoginListener {
        void onAuthLogin(ResultAPI result, LoginType loginType, Account currentAccount, Account usedAccount);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/auth/AuthDataInterface$AuthLogoutListener;", "", "onAuthLogout", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthLogoutListener {
        void onAuthLogout(ResultAPI result);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u0012"}, d2 = {"Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNDEFINED", "TIMEOVER", "OPEN_URL", "EXIT", "DONE", "stringValue", "", "getStringValue", "()Ljava/lang/String;", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthMaintenanceActionType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AuthMaintenanceActionType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int value;
        public static final AuthMaintenanceActionType UNDEFINED = new AuthMaintenanceActionType("UNDEFINED", 0, -1);
        public static final AuthMaintenanceActionType TIMEOVER = new AuthMaintenanceActionType("TIMEOVER", 1, 0);
        public static final AuthMaintenanceActionType OPEN_URL = new AuthMaintenanceActionType("OPEN_URL", 2, 1);
        public static final AuthMaintenanceActionType EXIT = new AuthMaintenanceActionType("EXIT", 3, 2);
        public static final AuthMaintenanceActionType DONE = new AuthMaintenanceActionType("DONE", 4, 3);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType$Companion;", "", "<init>", "()V", "findValue", "Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final AuthMaintenanceActionType findValue(int value) {
                if (value == 0) {
                    return AuthMaintenanceActionType.TIMEOVER;
                }
                if (value == 1) {
                    return AuthMaintenanceActionType.OPEN_URL;
                }
                if (value == 2) {
                    return AuthMaintenanceActionType.EXIT;
                }
                if (value != 3) {
                    return null;
                }
                return AuthMaintenanceActionType.DONE;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ AuthMaintenanceActionType[] $values() {
            return new AuthMaintenanceActionType[]{UNDEFINED, TIMEOVER, OPEN_URL, EXIT, DONE};
        }

        static {
            AuthMaintenanceActionType[] authMaintenanceActionTypeArr$values = $values();
            $VALUES = authMaintenanceActionTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(authMaintenanceActionTypeArr$values);
            INSTANCE = new Companion(null);
        }

        private AuthMaintenanceActionType(String str, int i, int i2) {
            this.value = i2;
        }

        @JvmStatic
        public static final AuthMaintenanceActionType findValue(int i) {
            return INSTANCE.findValue(i);
        }

        public static EnumEntries<AuthMaintenanceActionType> getEntries() {
            return $ENTRIES;
        }

        public static AuthMaintenanceActionType valueOf(String str) {
            return (AuthMaintenanceActionType) Enum.valueOf(AuthMaintenanceActionType.class, str);
        }

        public static AuthMaintenanceActionType[] values() {
            return (AuthMaintenanceActionType[]) $VALUES.clone();
        }

        public final String getStringValue() {
            return String.valueOf(this.value);
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/hive/auth/AuthDataInterface$AuthMaintenanceListener;", "", "onAuthMaintenance", "", "result", "Lcom/hive/ResultAPI;", "authMaintenanceInfo", "Lcom/hive/auth/AuthDataInterface$AuthMaintenanceInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthMaintenanceListener {
        void onAuthMaintenance(ResultAPI result, AuthMaintenanceInfo authMaintenanceInfo);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/auth/AuthDataInterface$AuthShowTermsListener;", "", "onAuthShowTerms", "", "result", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthShowTermsListener {
        void onAuthShowTerms(ResultAPI result);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/hive/auth/AuthDataInterface$LoginType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "GUEST", "ACCOUNT", "SELECT", "AUTO", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LoginType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LoginType[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private static final HashMap<String, LoginType> map;
        private final String value;
        public static final LoginType GUEST = new LoginType("GUEST", 0, SocialKeys.PeppermintRequestUrlPath.PEPPERMINT_GUEST_ACQUIRE_UID_PATH);
        public static final LoginType ACCOUNT = new LoginType("ACCOUNT", 1, "account");
        public static final LoginType SELECT = new LoginType("SELECT", 2, "select");
        public static final LoginType AUTO = new LoginType("AUTO", 3, "auto");

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0007R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/hive/auth/AuthDataInterface$LoginType$Companion;", "", "<init>", "()V", "map", "Ljava/util/HashMap;", "", "Lcom/hive/auth/AuthDataInterface$LoginType;", "Lkotlin/collections/HashMap;", "getLoginType", "key", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final LoginType getLoginType(String key) {
                Intrinsics.checkNotNullParameter(key, "key");
                return (LoginType) LoginType.map.get(key);
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ LoginType[] $values() {
            return new LoginType[]{GUEST, ACCOUNT, SELECT, AUTO};
        }

        static {
            LoginType[] loginTypeArr$values = $values();
            $VALUES = loginTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(loginTypeArr$values);
            INSTANCE = new Companion(null);
            map = new HashMap<>();
            for (LoginType loginType : values()) {
                map.put(loginType.value, loginType);
            }
        }

        private LoginType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<LoginType> getEntries() {
            return $ENTRIES;
        }

        @JvmStatic
        public static final LoginType getLoginType(String str) {
            return INSTANCE.getLoginType(str);
        }

        public static LoginType valueOf(String str) {
            return (LoginType) Enum.valueOf(LoginType.class, str);
        }

        public static LoginType[] values() {
            return (LoginType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    private AuthDataInterface() {
    }

    public static final Account getAccount() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        Account account = AuthImpl.INSTANCE.getAccount();
        loggerImpl.apiReturnLog(str, "Account : " + account);
        return account;
    }

    @JvmStatic
    public static /* synthetic */ void getAccount$annotations() {
    }

    public static final LoginType getLoginType() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "");
        LoginType loginType = AuthImpl.INSTANCE.getLoginType();
        loggerImpl.apiReturnLog(str, "LoginType : " + loginType);
        return loginType;
    }

    @JvmStatic
    public static /* synthetic */ void getLoginType$annotations() {
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B?\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0002\u0010\rB\u0013\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0002\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u000eR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u000eR\u001c\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/hive/auth/AuthDataInterface$AuthInitResult;", "Lcom/hive/base/DataModel;", "<init>", "()V", "isAuthorized", "", "loginType", "Lcom/hive/auth/AuthDataInterface$LoginType;", "did", "", "isPGSLogin", "playerName", "playerId", "(ZLcom/hive/auth/AuthDataInterface$LoginType;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "()Z", "setAuthorized", "(Z)V", "getLoginType", "()Lcom/hive/auth/AuthDataInterface$LoginType;", "setLoginType", "(Lcom/hive/auth/AuthDataInterface$LoginType;)V", "getDid", "()Ljava/lang/String;", "setDid", "setPGSLogin", "getPlayerName", "setPlayerName", "getPlayerId", "setPlayerId", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthInitResult extends DataModel {
        private String did;
        private boolean isAuthorized;
        private boolean isPGSLogin;
        private LoginType loginType;
        private String playerId;
        private String playerName;

        public AuthInitResult() {
            this.loginType = LoginType.GUEST;
        }

        public final String getDid() {
            return this.did;
        }

        public final LoginType getLoginType() {
            return this.loginType;
        }

        public final String getPlayerId() {
            return this.playerId;
        }

        public final String getPlayerName() {
            return this.playerName;
        }

        /* JADX INFO: renamed from: isAuthorized, reason: from getter */
        public final boolean getIsAuthorized() {
            return this.isAuthorized;
        }

        /* JADX INFO: renamed from: isPGSLogin, reason: from getter */
        public final boolean getIsPGSLogin() {
            return this.isPGSLogin;
        }

        public final void setAuthorized(boolean z) {
            this.isAuthorized = z;
        }

        public final void setDid(String str) {
            this.did = str;
        }

        public final void setLoginType(LoginType loginType) {
            Intrinsics.checkNotNullParameter(loginType, "<set-?>");
            this.loginType = loginType;
        }

        public final void setPGSLogin(boolean z) {
            this.isPGSLogin = z;
        }

        public final void setPlayerId(String str) {
            this.playerId = str;
        }

        public final void setPlayerName(String str) {
            this.playerName = str;
        }

        public AuthInitResult(boolean z, LoginType loginType, String str, boolean z2, String str2, String str3) {
            Intrinsics.checkNotNullParameter(loginType, "loginType");
            LoginType.Companion companion = LoginType.INSTANCE;
            this.isAuthorized = z;
            this.loginType = loginType;
            this.did = str;
            this.isPGSLogin = z2;
            this.playerName = str2;
            this.playerId = str3;
        }

        public AuthInitResult(String str) {
            this.loginType = LoginType.GUEST;
            this.did = str;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0002\u0010\tR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/hive/auth/AuthDataInterface$AuthMaintenanceExtraButton;", "", "<init>", "()V", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;", "url", "", "button", "(Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;", "setAction", "(Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getButton", "setButton", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthMaintenanceExtraButton {
        private AuthMaintenanceActionType action;
        private String button;
        private String url;

        public AuthMaintenanceExtraButton() {
            this.url = "";
            this.button = "";
        }

        public final AuthMaintenanceActionType getAction() {
            return this.action;
        }

        public final String getButton() {
            return this.button;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setAction(AuthMaintenanceActionType authMaintenanceActionType) {
            this.action = authMaintenanceActionType;
        }

        public final void setButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.button = str;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public AuthMaintenanceExtraButton(AuthMaintenanceActionType action, String url, String button) {
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(button, "button");
            this.action = action;
            this.url = url;
            this.button = button;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b#\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B9\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0002\u0010\rBI\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0010BG\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0002\u0010\u0014BW\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0016\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0017R\u001a\u0010\u0015\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010\u001fR\u001a\u0010\u000f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001f¨\u00066"}, d2 = {"Lcom/hive/auth/AuthDataInterface$AuthMaintenanceInfo;", "Lcom/hive/base/DataModel;", "<init>", "()V", "title", "", "message", "button", NativeProtocol.WEB_DIALOG_ACTION, "Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;", "url", "remainingTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;Ljava/lang/String;I)V", "customerButton", "customerLink", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "exButtons", "", "Lcom/hive/auth/AuthDataInterface$AuthMaintenanceExtraButton;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;Ljava/lang/String;ILjava/util/List;)V", "type", "originResponse", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;Ljava/lang/String;ILjava/util/List;Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getMessage", "setMessage", "getButton", "setButton", "getAction", "()Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;", "setAction", "(Lcom/hive/auth/AuthDataInterface$AuthMaintenanceActionType;)V", "getUrl", "setUrl", "getRemainingTime", "setRemainingTime", "getCustomerButton", "setCustomerButton", "getCustomerLink", "setCustomerLink", "getExButtons", "()Ljava/util/List;", "setExButtons", "(Ljava/util/List;)V", "getOriginResponse", "setOriginResponse", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class AuthMaintenanceInfo extends DataModel {
        private AuthMaintenanceActionType action;
        private String button;
        private String customerButton;
        private String customerLink;
        private List<AuthMaintenanceExtraButton> exButtons;
        private String message;
        private String originResponse;
        private int remainingTime;
        private String title;
        private int type;
        private String url;

        public AuthMaintenanceInfo() {
            this.title = "";
            this.message = "";
            this.button = "";
            this.url = "";
            this.customerButton = "";
            this.customerLink = "";
            this.originResponse = "";
        }

        public final AuthMaintenanceActionType getAction() {
            return this.action;
        }

        public final String getButton() {
            return this.button;
        }

        public final String getCustomerButton() {
            return this.customerButton;
        }

        public final String getCustomerLink() {
            return this.customerLink;
        }

        public final List<AuthMaintenanceExtraButton> getExButtons() {
            return this.exButtons;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getOriginResponse() {
            return this.originResponse;
        }

        public final int getRemainingTime() {
            return this.remainingTime;
        }

        public final String getTitle() {
            return this.title;
        }

        public final int getType() {
            return this.type;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setAction(AuthMaintenanceActionType authMaintenanceActionType) {
            this.action = authMaintenanceActionType;
        }

        public final void setButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.button = str;
        }

        public final void setCustomerButton(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.customerButton = str;
        }

        public final void setCustomerLink(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.customerLink = str;
        }

        public final void setExButtons(List<AuthMaintenanceExtraButton> list) {
            this.exButtons = list;
        }

        public final void setMessage(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.message = str;
        }

        public final void setOriginResponse(String str) {
            this.originResponse = str;
        }

        public final void setRemainingTime(int i) {
            this.remainingTime = i;
        }

        public final void setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.title = str;
        }

        public final void setType(int i) {
            this.type = i;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public AuthMaintenanceInfo(String title, String message, String button, AuthMaintenanceActionType action, String url, int i) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(button, "button");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(url, "url");
            this.customerButton = "";
            this.customerLink = "";
            this.originResponse = "";
            this.title = title;
            this.message = message;
            this.button = button;
            this.action = action;
            this.url = url;
            this.remainingTime = i;
        }

        public AuthMaintenanceInfo(String title, String message, String button, AuthMaintenanceActionType action, String url, int i, String customerButton, String customerLink) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(button, "button");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(customerButton, "customerButton");
            Intrinsics.checkNotNullParameter(customerLink, "customerLink");
            this.originResponse = "";
            this.title = title;
            this.message = message;
            this.button = button;
            this.action = action;
            this.url = url;
            this.remainingTime = i;
            this.customerButton = customerButton;
            this.customerLink = customerLink;
        }

        public AuthMaintenanceInfo(String title, String message, String button, AuthMaintenanceActionType action, String url, int i, List<AuthMaintenanceExtraButton> exButtons) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(button, "button");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(exButtons, "exButtons");
            this.customerButton = "";
            this.customerLink = "";
            this.originResponse = "";
            this.title = title;
            this.message = message;
            this.button = button;
            this.action = action;
            this.url = url;
            this.remainingTime = i;
            this.exButtons = exButtons;
        }

        public AuthMaintenanceInfo(int i, String title, String message, String button, AuthMaintenanceActionType action, String url, int i2, List<AuthMaintenanceExtraButton> exButtons, String originResponse) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(button, "button");
            Intrinsics.checkNotNullParameter(action, "action");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(exButtons, "exButtons");
            Intrinsics.checkNotNullParameter(originResponse, "originResponse");
            this.customerButton = "";
            this.customerLink = "";
            this.type = i;
            this.title = title;
            this.message = message;
            this.button = button;
            this.action = action;
            this.url = url;
            this.remainingTime = i2;
            this.exButtons = exButtons;
            this.originResponse = originResponse;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\tB;\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0002\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/hive/auth/AuthDataInterface$Account;", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "<init>", "()V", "vid", "", "uid", "did", "accessToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "uidSession", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getVid", "()Ljava/lang/String;", "setVid", "(Ljava/lang/String;)V", "getUid", "setUid", "getDid", "setDid", "vidSession", "getVidSession", "setVidSession", "getUidSession", "setUidSession", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Account extends HiveLifecycle.HiveAccount {
        private String did;
        private String uid;
        private String uidSession;
        private String vid;
        private String vidSession;

        public Account() {
            setOauthToken(AuthAccount.INSTANCE);
        }

        @Override // com.hive.standalone.HiveLifecycle.HiveAccount
        public String getDid() {
            return this.did;
        }

        @Override // com.hive.standalone.HiveLifecycle.HiveAccount
        public String getUid() {
            return this.uid;
        }

        @Override // com.hive.standalone.HiveLifecycle.HiveAccount
        public String getUidSession() {
            return this.uidSession;
        }

        @Override // com.hive.standalone.HiveLifecycle.HiveAccount
        public String getVid() {
            return this.vid;
        }

        @Override // com.hive.standalone.HiveLifecycle.HiveAccount
        public String getVidSession() {
            return this.vidSession;
        }

        @Override // com.hive.standalone.HiveLifecycle.HiveAccount
        public void setDid(String str) {
            this.did = str;
        }

        @Override // com.hive.standalone.HiveLifecycle.HiveAccount
        public void setUid(String str) {
            this.uid = str;
        }

        @Override // com.hive.standalone.HiveLifecycle.HiveAccount
        public void setUidSession(String str) {
            this.uidSession = str;
        }

        @Override // com.hive.standalone.HiveLifecycle.HiveAccount
        public void setVid(String str) {
            this.vid = str;
        }

        @Override // com.hive.standalone.HiveLifecycle.HiveAccount
        public void setVidSession(String str) {
            this.vidSession = str;
        }

        public Account(String str, String str2, String str3, String str4) {
            setOauthToken(AuthAccount.INSTANCE);
            setVid(str);
            setUid(str2);
            setDid(str3);
            setVidSession(str4);
        }

        public Account(String str, String str2, String str3, String str4, String str5) {
            setOauthToken(AuthAccount.INSTANCE);
            setVid(str);
            setUid(str2);
            setDid(str3);
            setVidSession(str4);
            setUidSession(str5);
        }
    }
}
