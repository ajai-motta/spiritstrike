package com.hive.authv4.helper;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ProviderGoogle;
import com.hive.ResultAPI;
import com.hive.authv4.AuthV4Account;
import com.hive.authv4.AuthV4Impl;
import com.hive.authv4.AuthV4Keys;
import com.hive.authv4.AuthV4Network;
import com.hive.authv4.helper.AuthV4HelperLegacy;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.authv4.provider.AuthV4ProviderGoogle;
import com.hive.base.Property;
import com.hive.logger.LoggerImpl;
import com.hive.module.GoogleSignInModule;
import com.hive.protocol.authv4.GetIdpUid;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0012\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001PB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0012\u0010\u0018\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\fH\u0002J\b\u0010#\u001a\u00020\u0010H\u0002J\b\u0010$\u001a\u00020\u0010H\u0002J(\u0010%\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u0010)\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J*\u0010,\u001a\u00020\u00102\b\u0010-\u001a\u0004\u0018\u00010\n2\u0006\u0010*\u001a\u00020+2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0010\u0010/\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\u0018\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u0002022\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u00103\u001a\u00020\u0010H\u0002J\u0010\u00104\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005H\u0002J\"\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u0002072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010;\u001a\u00020\u00102\u0006\u0010:\u001a\u0002072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u0002072\u0006\u0010>\u001a\u00020?2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010@\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010A\u001a\u00020\u0010H\u0002J\u001c\u0010B\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u001a\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u0002022\b\u0010E\u001a\u0004\u0018\u00010'H\u0002J\n\u0010F\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010G\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010H\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\b\u0010I\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010J\u001a\u00020!2\u0006\u0010K\u001a\u00020\bH\u0002J\b\u0010L\u001a\u00020!H\u0002J\b\u0010M\u001a\u00020\fH\u0002J\b\u0010N\u001a\u00020\fH\u0002J\b\u0010O\u001a\u00020\u000eH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/hive/authv4/helper/AuthV4HelperLegacy;", "Lcom/hive/authv4/helper/AuthV4Helper;", "<init>", "()V", "signInListener", "Lcom/hive/AuthV4$Helper$AuthV4HelperListener;", "connectListener", "conflictProviderType", "Lcom/hive/AuthV4$ProviderType;", "conflictPlayerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "isInProgressConflict", "", "onActivityStartListener", "Lcom/hive/ui/OnActivityLifecycle;", "syncAccount", "", "providerType", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "signIn", "signOut", "playerDelete", "disconnect", "connect", "showAchievements", "showLeaderboard", "showConflict", "conflictData", "Lcom/hive/AuthV4$Helper$ConflictSingleViewInfo;", "resolveConflict", "switchAccount", "checkBlackListResult", "result", "Lcom/hive/ResultAPI;", "needImplicitLogin", "processImplicitLoginFailure", "implicitLogin", "checkProvider", "currentProviderInfo", "Lcom/hive/AuthV4$ProviderInfo;", "playerInfo", "internalConnect", "resolveMode", "Lcom/hive/authv4/helper/AuthV4HelperLegacy$AuthV4HelperResolveMode;", "handleHiveConflict", "conflictPlayer", "internalSignOut", "internalResolveConflict", "internalSwitchAccount", "conflictPlayerId", "", "internalImplicitLogin", "checkGoogleAccount", "leaderboardsSubmitScore", "leaderboardId", "", FirebaseAnalytics.Param.SCORE, "achievementsReveal", "achievementId", "achievementsUnlock", "achievementsIncrement", "incrementalAchievementId", "value", "", "getGoogleProviderInfo", "cleanUpConflictInfo", "getProviderInfo", "createPlayer", "playerId", "providerInfo", "currentPlayer", "connectResult", "signInResult", "currentPlayerInfo", "syncAccountStatus", "ProviderType", "signInStatus", "isSupportedGoogleSignInIdp", "hasConflict", "createOnActivityStartListener", "AuthV4HelperResolveMode", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4HelperLegacy implements AuthV4Helper {
    public static final AuthV4HelperLegacy INSTANCE;
    private static AuthV4.PlayerInfo conflictPlayerInfo;
    private static AuthV4.ProviderType conflictProviderType;
    private static AuthV4.Helper.AuthV4HelperListener connectListener;
    private static boolean isInProgressConflict;
    private static OnActivityLifecycle onActivityStartListener;
    private static AuthV4.Helper.AuthV4HelperListener signInListener;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000b\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000ej\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u0010"}, d2 = {"Lcom/hive/authv4/helper/AuthV4HelperLegacy$AuthV4HelperResolveMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NONE", "SELECT", "SWITCH", "stringValue", "", "getStringValue", "()Ljava/lang/String;", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthV4HelperResolveMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AuthV4HelperResolveMode[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final AuthV4HelperResolveMode NONE = new AuthV4HelperResolveMode("NONE", 0, 1);
        public static final AuthV4HelperResolveMode SELECT = new AuthV4HelperResolveMode("SELECT", 1, 2);
        public static final AuthV4HelperResolveMode SWITCH = new AuthV4HelperResolveMode("SWITCH", 2, 3);
        private final int value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/authv4/helper/AuthV4HelperLegacy$AuthV4HelperResolveMode$Companion;", "", "<init>", "()V", "findValue", "Lcom/hive/authv4/helper/AuthV4HelperLegacy$AuthV4HelperResolveMode;", "value", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final AuthV4HelperResolveMode findValue(int value) {
                if (value == 1) {
                    return AuthV4HelperResolveMode.NONE;
                }
                if (value == 2) {
                    return AuthV4HelperResolveMode.SELECT;
                }
                if (value != 3) {
                    return null;
                }
                return AuthV4HelperResolveMode.SWITCH;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ AuthV4HelperResolveMode[] $values() {
            return new AuthV4HelperResolveMode[]{NONE, SELECT, SWITCH};
        }

        static {
            AuthV4HelperResolveMode[] authV4HelperResolveModeArr$values = $values();
            $VALUES = authV4HelperResolveModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(authV4HelperResolveModeArr$values);
            INSTANCE = new Companion(null);
        }

        private AuthV4HelperResolveMode(String str, int i, int i2) {
            this.value = i2;
        }

        public static EnumEntries<AuthV4HelperResolveMode> getEntries() {
            return $ENTRIES;
        }

        public static AuthV4HelperResolveMode valueOf(String str) {
            return (AuthV4HelperResolveMode) Enum.valueOf(AuthV4HelperResolveMode.class, str);
        }

        public static AuthV4HelperResolveMode[] values() {
            return (AuthV4HelperResolveMode[]) $VALUES.clone();
        }

        public final String getStringValue() {
            return String.valueOf(this.value);
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AuthV4HelperResolveMode.values().length];
            try {
                iArr[AuthV4HelperResolveMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AuthV4HelperResolveMode.SELECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AuthV4HelperResolveMode.SWITCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.helper.AuthV4HelperLegacy$checkProvider$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/hive/authv4/helper/AuthV4HelperLegacy$checkProvider$1", "Lcom/hive/AuthV4$AuthV4CheckProviderListener;", "onDeviceProviderInfo", "", "result", "Lcom/hive/ResultAPI;", "providerInfo", "Lcom/hive/AuthV4$ProviderInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C28571 implements AuthV4.AuthV4CheckProviderListener {
        final /* synthetic */ AuthV4.ProviderInfo $currentProviderInfo;
        final /* synthetic */ AuthV4.Helper.AuthV4HelperListener $listener;
        final /* synthetic */ AuthV4.PlayerInfo $playerInfo;
        final /* synthetic */ AuthV4.ProviderType $providerType;

        public C28571(AuthV4.ProviderInfo providerInfo, AuthV4.PlayerInfo playerInfo, AuthV4.ProviderType providerType, AuthV4.Helper.AuthV4HelperListener authV4HelperListener) {
            this.$currentProviderInfo = providerInfo;
            this.$playerInfo = playerInfo;
            this.$providerType = providerType;
            this.$listener = authV4HelperListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onDeviceProviderInfo$lambda$2(AuthV4.ProviderType providerType, AuthV4.ProviderInfo providerInfo, AuthV4.Helper.AuthV4HelperListener authV4HelperListener, ResultAPI resultAPI, ResultAPI resultApi, GetIdpUid getIdpUid, HashMap mapIdpFromProviderUid) {
            Intrinsics.checkNotNullParameter(resultApi, "resultApi");
            Intrinsics.checkNotNullParameter(getIdpUid, "<unused var>");
            Intrinsics.checkNotNullParameter(mapIdpFromProviderUid, "mapIdpFromProviderUid");
            if (resultApi.isSuccess()) {
                AuthV4HelperLegacy.conflictProviderType = providerType;
                Long l = (Long) mapIdpFromProviderUid.get(providerInfo.getProviderUserId());
                if (l != null) {
                    AuthV4.PlayerInfo playerInfoCreatePlayer = AuthV4HelperLegacy.INSTANCE.createPlayer(l.longValue(), providerInfo);
                    AuthV4Impl.INSTANCE.setRecentConflictPlayerInfo(playerInfoCreatePlayer);
                    AuthV4HelperLegacy.conflictPlayerInfo = playerInfoCreatePlayer;
                }
                authV4HelperListener.onAuthV4Helper(resultAPI, AuthV4HelperLegacy.conflictPlayerInfo);
            } else {
                authV4HelperListener.onAuthV4Helper(resultApi, null);
            }
            return Unit.INSTANCE;
        }

        @Override // com.hive.AuthV4.AuthV4CheckProviderListener
        public void onDeviceProviderInfo(ResultAPI result, final AuthV4.ProviderInfo providerInfo) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (result.getErrorCode() != 0 || providerInfo == null) {
                if (result.getErrorCode() == -6) {
                    this.$listener.onAuthV4Helper(result, null);
                    return;
                } else {
                    this.$listener.onAuthV4Helper(result, null);
                    return;
                }
            }
            if (Intrinsics.areEqual(this.$currentProviderInfo.getProviderUserId(), providerInfo.getProviderUserId())) {
                this.$listener.onAuthV4Helper(result, this.$playerInfo);
                return;
            }
            final ResultAPI resultAPI = new ResultAPI(-11, ResultAPI.Code.AuthV4ConflictPlayer);
            AuthV4Network authV4Network = AuthV4Network.INSTANCE;
            AuthV4.PlayerInfo playerInfo = this.$playerInfo;
            AuthV4.ProviderType providerType = this.$providerType;
            String providerUserId = providerInfo.getProviderUserId();
            final AuthV4.ProviderType providerType2 = this.$providerType;
            final AuthV4.Helper.AuthV4HelperListener authV4HelperListener = this.$listener;
            authV4Network.getIdpUid$hive_service_release(playerInfo, providerType, providerUserId, new Function3() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy$checkProvider$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4HelperLegacy.C28571.onDeviceProviderInfo$lambda$2(providerType2, providerInfo, authV4HelperListener, resultAPI, (ResultAPI) obj, (GetIdpUid) obj2, (HashMap) obj3);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.helper.AuthV4HelperLegacy$createOnActivityStartListener$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/hive/authv4/helper/AuthV4HelperLegacy$createOnActivityStartListener$1", "Lcom/hive/ui/OnActivityLifecycle;", "onStart", "", "activity", "Landroid/app/Activity;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C28591 extends OnActivityLifecycle {
        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static final kotlin.Unit onStart$lambda$1$lambda$0(com.hive.module.GoogleSignInModule r2, boolean r3, java.lang.String r4, com.hive.module.GoogleSignInModule.GoogleAccount r5) {
            /*
                if (r5 == 0) goto L7
                java.lang.String r5 = r5.getOpenId()
                goto L8
            L7:
                r5 = 0
            L8:
                if (r3 == 0) goto L45
                if (r5 == 0) goto L45
                com.hive.authv4.provider.AuthV4ProviderGoogle r3 = com.hive.authv4.provider.AuthV4ProviderGoogle.INSTANCE
                java.lang.String r0 = r3.getUserId()
                boolean r0 = kotlin.text.StringsKt.isBlank(r0)
                if (r0 != 0) goto L45
                java.lang.String r3 = r3.getUserId()
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)
                if (r3 != 0) goto L58
                com.hive.logger.LoggerImpl r3 = com.hive.logger.LoggerImpl.INSTANCE
                java.lang.String r4 = "[AuthV4GoogleSignIn] notifyChangedProviderInfo()"
                r3.d(r4)
                com.hive.authv4.AuthV4Impl r3 = com.hive.authv4.AuthV4Impl.INSTANCE
                com.hive.AuthV4$AuthV4CheckProviderListener r3 = r3.getCheckProviderListener()
                if (r3 == 0) goto L58
                com.hive.ResultAPI r4 = new com.hive.ResultAPI
                r4.<init>()
                com.hive.AuthV4$ProviderInfo r0 = new com.hive.AuthV4$ProviderInfo
                com.hive.AuthV4$ProviderType r1 = com.hive.AuthV4.ProviderType.GOOGLE
                java.lang.String r2 = r2.getGoogleAppId()
                r0.<init>(r1, r5, r2)
                r3.onDeviceProviderInfo(r4, r0)
                goto L58
            L45:
                com.hive.logger.LoggerImpl r2 = com.hive.logger.LoggerImpl.INSTANCE
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r5 = "[AuthV4GoogleSignIn] checkProvider failed. : "
                r3.<init>(r5)
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                r2.w(r3)
            L58:
                kotlin.Unit r2 = kotlin.Unit.INSTANCE
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.authv4.helper.AuthV4HelperLegacy.C28591.onStart$lambda$1$lambda$0(com.hive.module.GoogleSignInModule, boolean, java.lang.String, com.hive.module.GoogleSignInModule$GoogleAccount):kotlin.Unit");
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onStart(Activity activity) {
            HashMap<AuthV4.ProviderType, AuthV4.ProviderInfo> providerInfoData;
            AuthV4.ProviderInfo providerInfo;
            String providerUserId;
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onStart(activity);
            AuthV4.PlayerInfo playerInfoCurrentPlayer = AuthV4HelperLegacy.INSTANCE.currentPlayer();
            boolean z = (playerInfoCurrentPlayer == null || (providerInfoData = playerInfoCurrentPlayer.getProviderInfoData()) == null || (providerInfo = providerInfoData.get(AuthV4.ProviderType.GOOGLE)) == null || (providerUserId = providerInfo.getProviderUserId()) == null) ? false : !StringsKt.isBlank(providerUserId);
            if (AuthV4Impl.INSTANCE.getCheckProviderListener() != null) {
                AuthV4ProviderGoogle authV4ProviderGoogle = AuthV4ProviderGoogle.INSTANCE;
                if (authV4ProviderGoogle.getIsLogIn() && z) {
                    final GoogleSignInModule loginSuccessObject = authV4ProviderGoogle.getLoginSuccessObject();
                    if (loginSuccessObject != null) {
                        loginSuccessObject.silentSignIn(new Function3() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy$createOnActivityStartListener$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return AuthV4HelperLegacy.C28591.onStart$lambda$1$lambda$0(loginSuccessObject, ((Boolean) obj).booleanValue(), (String) obj2, (GoogleSignInModule.GoogleAccount) obj3);
                            }
                        });
                    } else {
                        LoggerImpl.INSTANCE.w("[AuthV4GoogleSignIn] googleSignInObject is null.");
                    }
                }
            }
        }
    }

    static {
        AuthV4HelperLegacy authV4HelperLegacy = new AuthV4HelperLegacy();
        INSTANCE = authV4HelperLegacy;
        onActivityStartListener = authV4HelperLegacy.createOnActivityStartListener();
    }

    private AuthV4HelperLegacy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkBlackListResult(ResultAPI result, boolean needImplicitLogin) {
        LoggerImpl.INSTANCE.d("[checkBlackListResult]");
        if (result.getErrorCode() == -17) {
            signInResult(result, null);
        } else if (needImplicitLogin) {
            implicitLogin();
        } else {
            processImplicitLoginFailure();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [com.hive.AuthV4$Helper$AuthV4HelperListener, com.hive.authv4.helper.AuthV4HelperLegacy$checkGoogleAccount$authV4HelperListener$1] */
    private final void checkGoogleAccount(final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[checkGoogleAccount]");
        AuthV4.ProviderType providerType = AuthV4.ProviderType.GOOGLE;
        ResultAPI resultAPISyncAccountStatus = syncAccountStatus(providerType);
        if (!resultAPISyncAccountStatus.isSuccess()) {
            listener.onAuthV4Helper(resultAPISyncAccountStatus, null);
            return;
        }
        if (!isSupportedGoogleSignInIdp()) {
            listener.onAuthV4Helper(new ResultAPI(-2, ResultAPI.Code.AuthV4GoogleNotSupported), null);
            return;
        }
        final ?? r1 = new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy$checkGoogleAccount$authV4HelperListener$1
            @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
            public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                Intrinsics.checkNotNullParameter(result, "result");
                listener.onAuthV4Helper(result, playerInfo);
            }
        };
        if (getGoogleProviderInfo(currentPlayer()) != null) {
            GoogleSignInModule loginSuccessObject = AuthV4ProviderGoogle.INSTANCE.getLoginSuccessObject();
            if ((loginSuccessObject != null ? loginSuccessObject.getCurrentAccount() : null) != null) {
                syncAccount(providerType, AuthV4HelperResolveMode.SELECT, r1);
                return;
            } else {
                AuthV4ProviderAdapter.INSTANCE.login(providerType, new AuthV4ProviderAdapter.ProviderLoginListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.checkGoogleAccount.1
                    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLoginListener
                    public void onProviderLoginListener(ResultAPI result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        if (result.isSuccess()) {
                            AuthV4HelperLegacy.INSTANCE.syncAccount(AuthV4.ProviderType.GOOGLE, AuthV4HelperResolveMode.SELECT, r1);
                        } else {
                            listener.onAuthV4Helper(result, null);
                        }
                    }
                });
                return;
            }
        }
        GoogleSignInModule loginSuccessObject2 = AuthV4ProviderGoogle.INSTANCE.getLoginSuccessObject();
        if ((loginSuccessObject2 != null ? loginSuccessObject2.getCurrentAccount() : null) != null) {
            internalConnect(providerType, r1);
        } else {
            AuthV4ProviderAdapter.INSTANCE.login(providerType, new AuthV4ProviderAdapter.ProviderLoginListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.checkGoogleAccount.2
                @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLoginListener
                public void onProviderLoginListener(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (result.isSuccess()) {
                        AuthV4HelperLegacy.INSTANCE.internalConnect(AuthV4.ProviderType.GOOGLE, r1);
                    } else {
                        listener.onAuthV4Helper(result, null);
                    }
                }
            });
        }
    }

    private final void checkProvider(AuthV4.ProviderType providerType, AuthV4.ProviderInfo currentProviderInfo, AuthV4.PlayerInfo playerInfo, AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        loggerImpl.dL(helper.getTAG(), "[checkProvider] ProviderType : " + providerType + "\nProviderInfo : " + currentProviderInfo + "\nPlayerInfo : " + playerInfo);
        loggerImpl.dR(helper.getTAG(), "[checkProvider] ProviderType : " + providerType + "\nProviderInfo : " + currentProviderInfo + "\nPlayerInfo : " + playerInfo.getPlayerId());
        AuthV4Impl.INSTANCE.checkProvider(providerType, new C28571(currentProviderInfo, playerInfo, providerType, listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanUpConflictInfo() {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[cleanUpConflictInfo]");
        conflictPlayerInfo = null;
        conflictProviderType = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectResult(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        loggerImpl.iL(helper.getTAG(), "[connectResult] ResultAPI : " + result + "\nPlayerInfo : " + playerInfo);
        String tag = helper.getTAG();
        StringBuilder sb = new StringBuilder("[connectResult] ResultAPI : ");
        sb.append(result);
        sb.append("\nPlayerInfo : ");
        sb.append(playerInfo != null ? Long.valueOf(playerInfo.getPlayerId()) : null);
        loggerImpl.iR(tag, sb.toString());
        AuthV4.Helper.AuthV4HelperListener authV4HelperListener = connectListener;
        if (authV4HelperListener != null) {
            authV4HelperListener.onAuthV4Helper(result, playerInfo);
        }
        connectListener = null;
    }

    private final OnActivityLifecycle createOnActivityStartListener() {
        return new C28591();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthV4.PlayerInfo createPlayer(long playerId, AuthV4.ProviderInfo providerInfo) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        String tag = helper.getTAG();
        StringBuilder sb = new StringBuilder("[createPlayer] PlayerId : ");
        sb.append(playerId);
        sb.append("\nProviderInfo : ");
        sb.append(providerInfo != null ? providerInfo : "providerInfo is null");
        loggerImpl.iL(tag, sb.toString());
        loggerImpl.iR(helper.getTAG(), "[createPlayer]");
        AuthV4.PlayerInfo playerInfo = new AuthV4.PlayerInfo();
        playerInfo.setPlayerId(playerId);
        if (providerInfo != null) {
            playerInfo.getProviderInfoData().put(providerInfo.getProviderType(), providerInfo);
        }
        return playerInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthV4.PlayerInfo currentPlayer() {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[currentPlayer]");
        return AuthV4Account.INSTANCE.getPlayerInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthV4.ProviderInfo getGoogleProviderInfo(AuthV4.PlayerInfo playerInfo) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        String tag = helper.getTAG();
        StringBuilder sb = new StringBuilder("[getGoogleProviderInfo] PlayerInfo : ");
        sb.append(playerInfo != null ? playerInfo : "playerInfo is null");
        loggerImpl.iL(tag, sb.toString());
        String tag2 = helper.getTAG();
        StringBuilder sb2 = new StringBuilder("[getGoogleProviderInfo] PlayerInfo : ");
        sb2.append(playerInfo != null ? Long.valueOf(playerInfo.getPlayerId()) : "playerInfo is null");
        loggerImpl.iR(tag2, sb2.toString());
        return getProviderInfo(playerInfo, AuthV4.ProviderType.GOOGLE);
    }

    private final AuthV4.ProviderInfo getProviderInfo(AuthV4.PlayerInfo playerInfo, AuthV4.ProviderType providerType) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        loggerImpl.iL(helper.getTAG(), "[getProviderInfo] PlayerInfo : " + playerInfo + "\nProviderType : " + providerType);
        String tag = helper.getTAG();
        StringBuilder sb = new StringBuilder("[getProviderInfo] PlayerInfo : ");
        sb.append(playerInfo != null ? Long.valueOf(playerInfo.getPlayerId()) : null);
        sb.append("\nProviderType : ");
        sb.append(providerType);
        loggerImpl.iR(tag, sb.toString());
        if (playerInfo != null) {
            for (AuthV4.ProviderType providerType2 : playerInfo.getProviderInfoData().keySet()) {
                Intrinsics.checkNotNullExpressionValue(providerType2, "next(...)");
                AuthV4.ProviderType providerType3 = providerType2;
                if (providerType == providerType3) {
                    return playerInfo.getProviderInfoData().get(providerType3);
                }
            }
        }
        return null;
    }

    private final void handleHiveConflict(AuthV4.PlayerInfo conflictPlayer, AuthV4HelperResolveMode resolveMode, ResultAPI result, final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        String tag = helper.getTAG();
        StringBuilder sb = new StringBuilder("[handleHiveConflict] PlayerInfo : ");
        sb.append(conflictPlayer != null ? conflictPlayer : "conflictPlayer is null");
        sb.append("\nResolveMode : ");
        sb.append(resolveMode);
        sb.append("\nResultAPI : ");
        sb.append(result);
        loggerImpl.iL(tag, sb.toString());
        String tag2 = helper.getTAG();
        StringBuilder sb2 = new StringBuilder("[handleHiveConflict] PlayerInfo : ");
        sb2.append(conflictPlayer != null ? Long.valueOf(conflictPlayer.getPlayerId()) : "conflictPlayer is null");
        sb2.append("\nResolveMode : ");
        sb2.append(resolveMode);
        sb2.append("\nResultAPI : ");
        sb2.append(result);
        loggerImpl.iR(tag2, sb2.toString());
        int i = WhenMappings.$EnumSwitchMapping$0[resolveMode.ordinal()];
        if (i == 1) {
            listener.onAuthV4Helper(result, conflictPlayer);
        } else if (i == 2) {
            showConflict(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.handleHiveConflict.1
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI result2, AuthV4.PlayerInfo playerInfo) {
                    Intrinsics.checkNotNullParameter(result2, "result");
                    listener.onAuthV4Helper(result2, playerInfo);
                }
            });
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            switchAccount(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.handleHiveConflict.2
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI result2, AuthV4.PlayerInfo playerInfo) {
                    Intrinsics.checkNotNullParameter(result2, "result");
                    listener.onAuthV4Helper(result2, playerInfo);
                }
            });
        }
    }

    private final boolean hasConflict() {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[hasConflict]");
        return conflictPlayerInfo != null;
    }

    private final void implicitLogin() {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[implicitLogin]");
        boolean z = Boolean.parseBoolean(Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.IMPLICIT_SIGNED_IN_EVER, "false"));
        if (!isSupportedGoogleSignInIdp() || z) {
            processImplicitLoginFailure();
        } else {
            internalImplicitLogin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalConnect(final AuthV4.ProviderType providerType, final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[internalConnect] ProviderType : " + providerType);
        final AuthV4.PlayerInfo playerInfoCurrentPlayer = currentPlayer();
        AuthV4Impl.INSTANCE.connect(providerType, new AuthV4.AuthV4ConnectListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.internalConnect.1

            /* JADX INFO: renamed from: com.hive.authv4.helper.AuthV4HelperLegacy$internalConnect$1$WhenMappings */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[ResultAPI.Code.values().length];
                    try {
                        iArr[ResultAPI.Code.Success.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ResultAPI.Code.AuthV4GoogleLoginCancel.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ResultAPI.Code.AuthV4ConflictPlayer.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // com.hive.AuthV4.AuthV4ConnectListener
            public void onAuthV4Connect(ResultAPI result, AuthV4.PlayerInfo conflictPlayer) {
                Intrinsics.checkNotNullParameter(result, "result");
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
                loggerImpl.i(helper.getTAG(), "internalConnect result: " + result);
                loggerImpl.iL(helper.getTAG(), "internalConnect playerInfo: " + conflictPlayer);
                String tag = helper.getTAG();
                StringBuilder sb = new StringBuilder("internalConnect playerInfo: ");
                sb.append(conflictPlayer != null ? Long.valueOf(conflictPlayer.getPlayerId()) : null);
                loggerImpl.iR(tag, sb.toString());
                int i = WhenMappings.$EnumSwitchMapping$0[result.getCode().ordinal()];
                if (i == 1) {
                    listener.onAuthV4Helper(result, playerInfoCurrentPlayer);
                    return;
                }
                if (i == 2) {
                    listener.onAuthV4Helper(result, playerInfoCurrentPlayer);
                    return;
                }
                if (i != 3) {
                    listener.onAuthV4Helper(result, null);
                    return;
                }
                AuthV4HelperLegacy authV4HelperLegacy = AuthV4HelperLegacy.INSTANCE;
                AuthV4HelperLegacy.conflictProviderType = providerType;
                AuthV4HelperLegacy.conflictPlayerInfo = conflictPlayer;
                listener.onAuthV4Helper(result, AuthV4HelperLegacy.conflictPlayerInfo);
            }
        });
    }

    private final void internalImplicitLogin() {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[internalImplicitLogin]");
        AuthV4Impl.INSTANCE.signIn(AuthV4.ProviderType.GOOGLE, new AuthV4.AuthV4SignInListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.internalImplicitLogin.1
            @Override // com.hive.AuthV4.AuthV4SignInListener
            public void onAuthV4SignIn(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.isFailure()) {
                    AuthV4HelperLegacy.INSTANCE.checkBlackListResult(result, false);
                    return;
                }
                Property.Companion companion = Property.INSTANCE;
                Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.IMPLICIT_SIGNED_IN_EVER, "true", null, 4, null);
                companion.getINSTANCE().writeProperties();
                AuthV4HelperLegacy.INSTANCE.signInResult(result, playerInfo);
            }
        });
    }

    private final void internalResolveConflict(final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[internalResolveConflict]");
        AuthV4Impl.INSTANCE.resolveConflict(new AuthV4.AuthV4ResolveConflictListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.internalResolveConflict.1
            @Override // com.hive.AuthV4.AuthV4ResolveConflictListener
            public void onAuthV4ResolveConflict(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (!result.isSuccess()) {
                    listener.onAuthV4Helper(result, null);
                    return;
                }
                ResultAPI resultAPI = new ResultAPI(-6, ResultAPI.Code.AuthV4PlayerResolved);
                AuthV4HelperLegacy authV4HelperLegacy = AuthV4HelperLegacy.INSTANCE;
                authV4HelperLegacy.cleanUpConflictInfo();
                listener.onAuthV4Helper(resultAPI, authV4HelperLegacy.currentPlayer());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalSignOut(final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[internalSignOut]");
        AuthV4Impl.INSTANCE.signOut(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.internalSignOut.1
            @Override // com.hive.AuthV4.AuthV4SignOutListener
            public void onAuthV4SignOut(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                listener.onAuthV4Helper(result, null);
            }
        });
    }

    private final void internalSwitchAccount(long conflictPlayerId, final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[internalSwitchAccount]");
        AuthV4Impl.INSTANCE.selectConflict(conflictPlayerId, new AuthV4.AuthV4SignInListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.internalSwitchAccount.1
            @Override // com.hive.AuthV4.AuthV4SignInListener
            public void onAuthV4SignIn(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (!result.isSuccess()) {
                    listener.onAuthV4Helper(result, null);
                    return;
                }
                AuthV4HelperLegacy.INSTANCE.cleanUpConflictInfo();
                listener.onAuthV4Helper(new ResultAPI(-15, ResultAPI.Code.AuthV4PlayerChange), playerInfo);
            }
        });
    }

    private final boolean isSupportedGoogleSignInIdp() {
        return AuthV4Impl.INSTANCE.getIdpList().contains(AuthV4.ProviderType.GOOGLE);
    }

    private final void processImplicitLoginFailure() {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[processImplicitLoginFailure]");
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.IMPLICIT_SIGNED_IN_EVER, "true", null, 4, null);
        companion.getINSTANCE().writeProperties();
        signInResult(new ResultAPI(-9, ResultAPI.Code.AuthV4HelperImplifiedLoginFail, "Need explicit login."), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void signInResult(ResultAPI result, AuthV4.PlayerInfo currentPlayerInfo) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        loggerImpl.iL(helper.getTAG(), "[signInResult] ResultAPI : " + result + "\nPlayerInfo : " + currentPlayerInfo);
        String tag = helper.getTAG();
        StringBuilder sb = new StringBuilder("[signInResult] ResultAPI : ");
        sb.append(result);
        sb.append("\nPlayerInfo : ");
        sb.append(currentPlayerInfo != null ? Long.valueOf(currentPlayerInfo.getPlayerId()) : null);
        loggerImpl.iR(tag, sb.toString());
        if (result.isSuccess()) {
            HiveActivity.registerHiveActivityLifecycleListeners(onActivityStartListener);
        }
        AuthV4.Helper.AuthV4HelperListener authV4HelperListener = signInListener;
        if (authV4HelperListener != null) {
            authV4HelperListener.onAuthV4Helper(result, currentPlayerInfo);
        }
        signInListener = null;
    }

    private final ResultAPI signInStatus() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        loggerImpl.i(helper.getTAG(), "[signInStatus]");
        if (AuthV4Impl.INSTANCE.isSetup()) {
            return currentPlayer() != null ? new ResultAPI(-1, ResultAPI.Code.AuthV4AlreadyAuthorized) : new ResultAPI();
        }
        loggerImpl.w(helper.getTAG(), "[SignIn] Need AuthV4 setup first");
        return new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[SignIn] Need AuthV4 setup first");
    }

    private final ResultAPI syncAccountStatus(AuthV4.ProviderType ProviderType) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        loggerImpl.i(helper.getTAG(), "[syncAccountStatus] ProviderType : " + ProviderType);
        if (!AuthV4Impl.INSTANCE.isSetup()) {
            loggerImpl.w(helper.getTAG(), "Need AuthV4 setup first");
            return new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized);
        }
        if (AuthV4Account.INSTANCE.readPlayerInfo() != null) {
            return new ResultAPI();
        }
        loggerImpl.w(helper.getTAG(), "User not authorized.");
        return new ResultAPI(-9, ResultAPI.Code.AuthV4SigninFirst);
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void achievementsIncrement(String incrementalAchievementId, int value, final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(incrementalAchievementId, "incrementalAchievementId");
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[achievementsIncrement] achievementId : " + incrementalAchievementId + ", value : " + value);
        if (listener == null) {
            ProviderGoogle.achievementsIncrement(incrementalAchievementId, value);
        } else {
            ProviderGoogle.achievementsIncrement(incrementalAchievementId, value, new ProviderGoogle.GoogleAchievementsListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.achievementsIncrement.1
                @Override // com.hive.ProviderGoogle.GoogleAchievementsListener
                public void onAchievementsResult(ResultAPI resultAPI) {
                    Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                    listener.onAuthV4Helper(resultAPI, null);
                }
            });
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void achievementsReveal(String achievementId, final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(achievementId, "achievementId");
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[achievementsReveal] achievementId : " + achievementId);
        if (listener == null) {
            ProviderGoogle.achievementsReveal(achievementId);
        } else {
            ProviderGoogle.achievementsReveal(achievementId, new ProviderGoogle.GoogleAchievementsListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.achievementsReveal.1
                @Override // com.hive.ProviderGoogle.GoogleAchievementsListener
                public void onAchievementsResult(ResultAPI resultAPI) {
                    Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                    listener.onAuthV4Helper(resultAPI, null);
                }
            });
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void achievementsUnlock(String achievementId, final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(achievementId, "achievementId");
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[achievementsUnlock] achievementId : " + achievementId);
        if (listener == null) {
            ProviderGoogle.achievementsUnlock(achievementId);
        } else {
            ProviderGoogle.achievementsUnlock(achievementId, new ProviderGoogle.GoogleAchievementsListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.achievementsUnlock.1
                @Override // com.hive.ProviderGoogle.GoogleAchievementsListener
                public void onAchievementsResult(ResultAPI resultAPI) {
                    Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                    listener.onAuthV4Helper(resultAPI, null);
                }
            });
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void connect(AuthV4.ProviderType providerType, AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[connect] ProvideType : " + providerType);
        if (connectListener != null) {
            listener.onAuthV4Helper(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgressSignIn), null);
        } else {
            connectListener = listener;
            internalConnect(providerType, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.connect.1
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    AuthV4HelperLegacy.INSTANCE.connectResult(result, playerInfo);
                }
            });
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void disconnect(AuthV4.ProviderType providerType, final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[disconnect] ProvideType : " + providerType);
        AuthV4Impl.INSTANCE.disconnect(providerType, new AuthV4.AuthV4DisconnectListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.disconnect.1
            @Override // com.hive.AuthV4.AuthV4DisconnectListener
            public void onAuthV4Disconnect(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                listener.onAuthV4Helper(result, null);
            }
        });
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void leaderboardsSubmitScore(String leaderboardId, long score, final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(leaderboardId, "leaderboardId");
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[leaderboardsSubmitScore] leaderboardId : " + leaderboardId);
        if (listener == null) {
            ProviderGoogle.leaderboardsSubmitScore(leaderboardId, score);
        } else {
            ProviderGoogle.leaderboardsSubmitScore(leaderboardId, score, new ProviderGoogle.GoogleLeaderboardsListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.leaderboardsSubmitScore.1
                @Override // com.hive.ProviderGoogle.GoogleLeaderboardsListener
                public void onLeaderboardsResult(ResultAPI resultAPI) {
                    Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                    listener.onAuthV4Helper(resultAPI, null);
                }
            });
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void playerDelete(final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[playerDelete]");
        AuthV4Impl.INSTANCE.playerDelete(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.playerDelete.1
            @Override // com.hive.AuthV4.AuthV4SignOutListener
            public void onAuthV4SignOut(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                listener.onAuthV4Helper(result, null);
            }
        });
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void resolveConflict(AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[resolveConflict]");
        if (hasConflict()) {
            internalResolveConflict(listener);
        } else {
            listener.onAuthV4Helper(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidConflictInfo, "Not conflicted."), null);
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void showAchievements(final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[showAchievements]");
        checkGoogleAccount(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.showAchievements.1
            @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
            public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.isSuccess()) {
                    final AuthV4.Helper.AuthV4HelperListener authV4HelperListener = listener;
                    ProviderGoogle.showAchievements(new ProviderGoogle.GoogleAchievementsListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy$showAchievements$1$onAuthV4Helper$1
                        @Override // com.hive.ProviderGoogle.GoogleAchievementsListener
                        public void onAchievementsResult(final ResultAPI resultAPI) {
                            Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                            if (resultAPI.getCode() == ResultAPI.Code.AuthV4GoogleLogout) {
                                AuthV4HelperLegacy authV4HelperLegacy = AuthV4HelperLegacy.INSTANCE;
                                final AuthV4.Helper.AuthV4HelperListener authV4HelperListener2 = authV4HelperListener;
                                authV4HelperLegacy.internalSignOut(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy$showAchievements$1$onAuthV4Helper$1$onAchievementsResult$1
                                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                                    public void onAuthV4Helper(ResultAPI result2, AuthV4.PlayerInfo playerInfo2) {
                                        Intrinsics.checkNotNullParameter(result2, "result");
                                        AuthV4.Helper.AuthV4HelperListener authV4HelperListener3 = authV4HelperListener2;
                                        if (authV4HelperListener3 != null) {
                                            authV4HelperListener3.onAuthV4Helper(resultAPI, null);
                                        }
                                    }
                                });
                            } else {
                                AuthV4.Helper.AuthV4HelperListener authV4HelperListener3 = authV4HelperListener;
                                if (authV4HelperListener3 != null) {
                                    authV4HelperListener3.onAuthV4Helper(resultAPI, null);
                                }
                            }
                        }
                    });
                } else {
                    AuthV4.Helper.AuthV4HelperListener authV4HelperListener2 = listener;
                    if (authV4HelperListener2 != null) {
                        authV4HelperListener2.onAuthV4Helper(result, playerInfo);
                    }
                }
            }
        });
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void showConflict(final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        loggerImpl.i(helper.getTAG(), "[showConflict]");
        final AuthV4.ProviderType providerType = conflictProviderType;
        if (!hasConflict() || providerType == null) {
            listener.onAuthV4Helper(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidConflictInfo, "Not conflicted."), null);
        } else if (isInProgressConflict) {
            loggerImpl.w(helper.getTAG(), "[showConflict] is in progress.");
        } else {
            isInProgressConflict = true;
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.showConflict.1
                public AuthV4HelperConflictView conflictView;

                private final AuthV4HelperConflictView createDialog(final Activity activity) {
                    AuthV4.PlayerInfo playerInfoCurrentPlayer = AuthV4HelperLegacy.INSTANCE.currentPlayer();
                    boolean zIsGuest = playerInfoCurrentPlayer != null ? playerInfoCurrentPlayer.isGuest() : false;
                    AuthV4.ProviderType providerType2 = providerType;
                    final AuthV4.Helper.AuthV4HelperListener authV4HelperListener = listener;
                    return new AuthV4HelperConflictView(activity, providerType2, zIsGuest, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy$showConflict$1$createDialog$view$1
                        @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                        public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            AuthV4HelperLegacy.isInProgressConflict = false;
                            if (result.isSuccess()) {
                                AuthV4HelperLegacy authV4HelperLegacy = AuthV4HelperLegacy.INSTANCE;
                                final AuthV4.Helper.AuthV4HelperListener authV4HelperListener2 = authV4HelperListener;
                                authV4HelperLegacy.resolveConflict(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy$showConflict$1$createDialog$view$1$onAuthV4Helper$1
                                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                                    public void onAuthV4Helper(ResultAPI result2, AuthV4.PlayerInfo playerInfo2) {
                                        Intrinsics.checkNotNullParameter(result2, "result");
                                        authV4HelperListener2.onAuthV4Helper(result2, playerInfo2);
                                    }
                                });
                            } else {
                                AuthV4HelperLegacy authV4HelperLegacy2 = AuthV4HelperLegacy.INSTANCE;
                                final AuthV4.Helper.AuthV4HelperListener authV4HelperListener3 = authV4HelperListener;
                                authV4HelperLegacy2.switchAccount(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy$showConflict$1$createDialog$view$1$onAuthV4Helper$2
                                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                                    public void onAuthV4Helper(ResultAPI result2, AuthV4.PlayerInfo playerInfo2) {
                                        Intrinsics.checkNotNullParameter(result2, "result");
                                        authV4HelperListener3.onAuthV4Helper(result2, playerInfo2);
                                    }
                                });
                            }
                            activity.finish();
                        }
                    });
                }

                public final AuthV4HelperConflictView getConflictView() {
                    AuthV4HelperConflictView authV4HelperConflictView = this.conflictView;
                    if (authV4HelperConflictView != null) {
                        return authV4HelperConflictView;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("conflictView");
                    return null;
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public boolean onBackPressed() {
                    return getConflictView().onBackPressed();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onConfigurationChanged(Activity activity, Configuration newConfig) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    Intrinsics.checkNotNullParameter(newConfig, "newConfig");
                    activity.recreate();
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onCreate(Activity activity, Bundle savedInstanceState) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    super.onCreate(activity, savedInstanceState);
                    setConflictView(createDialog(activity));
                    activity.setContentView(getConflictView().getView());
                }

                @Override // com.hive.ui.OnActivityLifecycle
                public void onDestroy(Activity activity) {
                    Intrinsics.checkNotNullParameter(activity, "activity");
                    if (!getIsCalledFinish() && !getIsRecreated()) {
                        getConflictView().dismiss(false);
                    }
                    super.onDestroy(activity);
                }

                public final void setConflictView(AuthV4HelperConflictView authV4HelperConflictView) {
                    Intrinsics.checkNotNullParameter(authV4HelperConflictView, "<set-?>");
                    this.conflictView = authV4HelperConflictView;
                }
            });
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void showLeaderboard(final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[showLeaderboard]");
        checkGoogleAccount(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.showLeaderboard.1
            @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
            public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.isSuccess()) {
                    final AuthV4.Helper.AuthV4HelperListener authV4HelperListener = listener;
                    ProviderGoogle.showLeaderboards(new ProviderGoogle.GoogleLeaderboardsListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy$showLeaderboard$1$onAuthV4Helper$1
                        @Override // com.hive.ProviderGoogle.GoogleLeaderboardsListener
                        public void onLeaderboardsResult(final ResultAPI resultAPI) {
                            Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
                            if (resultAPI.getCode() == ResultAPI.Code.AuthV4GoogleLogout) {
                                AuthV4HelperLegacy authV4HelperLegacy = AuthV4HelperLegacy.INSTANCE;
                                final AuthV4.Helper.AuthV4HelperListener authV4HelperListener2 = authV4HelperListener;
                                authV4HelperLegacy.internalSignOut(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy$showLeaderboard$1$onAuthV4Helper$1$onLeaderboardsResult$1
                                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                                    public void onAuthV4Helper(ResultAPI result2, AuthV4.PlayerInfo playerInfo2) {
                                        Intrinsics.checkNotNullParameter(result2, "result");
                                        AuthV4.Helper.AuthV4HelperListener authV4HelperListener3 = authV4HelperListener2;
                                        if (authV4HelperListener3 != null) {
                                            authV4HelperListener3.onAuthV4Helper(resultAPI, null);
                                        }
                                    }
                                });
                            } else {
                                AuthV4.Helper.AuthV4HelperListener authV4HelperListener3 = authV4HelperListener;
                                if (authV4HelperListener3 != null) {
                                    authV4HelperListener3.onAuthV4Helper(resultAPI, null);
                                }
                            }
                        }
                    });
                } else {
                    AuthV4.Helper.AuthV4HelperListener authV4HelperListener2 = listener;
                    if (authV4HelperListener2 != null) {
                        authV4HelperListener2.onAuthV4Helper(result, playerInfo);
                    }
                }
            }
        });
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void signIn(AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        loggerImpl.i(helper.getTAG(), "[signIn]");
        ResultAPI resultAPISignInStatus = signInStatus();
        if (!resultAPISignInStatus.isSuccess()) {
            loggerImpl.w(helper.getTAG(), resultAPISignInStatus.toString());
            if (listener != null) {
                listener.onAuthV4Helper(resultAPISignInStatus, null);
                return;
            }
            return;
        }
        if (listener == null) {
            loggerImpl.e(helper.getTAG(), "[SignIn] AuthV4HelperInListener is null");
            return;
        }
        if (signInListener != null) {
            listener.onAuthV4Helper(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgressSignIn), null);
            return;
        }
        signInListener = listener;
        AuthV4Impl authV4Impl = AuthV4Impl.INSTANCE;
        if (authV4Impl.isAutoSignIn()) {
            authV4Impl.signIn(AuthV4.ProviderType.AUTO, new AuthV4.AuthV4SignInListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.signIn.1
                @Override // com.hive.AuthV4.AuthV4SignInListener
                public void onAuthV4SignIn(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (!result.isSuccess()) {
                        AuthV4HelperLegacy.INSTANCE.checkBlackListResult(result, true);
                        return;
                    }
                    AuthV4HelperLegacy authV4HelperLegacy = AuthV4HelperLegacy.INSTANCE;
                    if (authV4HelperLegacy.getGoogleProviderInfo(playerInfo) != null) {
                        authV4HelperLegacy.syncAccount(AuthV4.ProviderType.AUTO, AuthV4HelperResolveMode.SELECT, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy$signIn$1$onAuthV4SignIn$1
                            @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                            public void onAuthV4Helper(ResultAPI result2, AuthV4.PlayerInfo playerInfo2) {
                                Intrinsics.checkNotNullParameter(result2, "result");
                                if (result2.isSuccess() || result2.getCode() == ResultAPI.Code.AuthV4ConflictPlayer) {
                                    AuthV4HelperLegacy.INSTANCE.signInResult(result2, playerInfo2);
                                } else {
                                    AuthV4HelperLegacy authV4HelperLegacy2 = AuthV4HelperLegacy.INSTANCE;
                                    authV4HelperLegacy2.signInResult(new ResultAPI(), authV4HelperLegacy2.currentPlayer());
                                }
                            }
                        });
                    } else {
                        authV4HelperLegacy.signInResult(result, playerInfo);
                    }
                }
            });
        } else {
            implicitLogin();
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void signOut(final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[signOut]");
        HiveActivity.unregisterHiveActivityLifecycleListeners(onActivityStartListener);
        internalSignOut(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.signOut.1
            @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
            public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                Intrinsics.checkNotNullParameter(result, "result");
                listener.onAuthV4Helper(result, null);
            }
        });
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void switchAccount(AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[switchAccount]");
        AuthV4.PlayerInfo playerInfo = conflictPlayerInfo;
        Long lValueOf = playerInfo != null ? Long.valueOf(playerInfo.getPlayerId()) : null;
        if (!hasConflict() || lValueOf == null) {
            listener.onAuthV4Helper(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidConflictInfo, "Not conflicted."), null);
        } else {
            internalSwitchAccount(lValueOf.longValue(), listener);
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void syncAccount(AuthV4.ProviderType providerType, AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[syncAccount] ProvideType : " + providerType);
        syncAccount(providerType, AuthV4HelperResolveMode.NONE, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncAccount(AuthV4.ProviderType providerType, AuthV4HelperResolveMode resolveMode, final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.i(AuthV4.Helper.INSTANCE.getTAG(), "[syncAccount] ProviderType : " + providerType + "\nResolveMode : " + resolveMode);
        ResultAPI resultAPISyncAccountStatus = syncAccountStatus(providerType);
        if (resultAPISyncAccountStatus.isFailure()) {
            listener.onAuthV4Helper(resultAPISyncAccountStatus, null);
            return;
        }
        AuthV4.PlayerInfo playerInfoCurrentPlayer = currentPlayer();
        if (providerType == AuthV4.ProviderType.AUTO) {
            providerType = AuthV4.ProviderType.GOOGLE;
        }
        AuthV4.ProviderInfo providerInfo = getProviderInfo(playerInfoCurrentPlayer, providerType);
        if (providerInfo != null && playerInfoCurrentPlayer != null) {
            checkProvider(providerType, providerInfo, playerInfoCurrentPlayer, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.syncAccount.1

                /* JADX INFO: renamed from: com.hive.authv4.helper.AuthV4HelperLegacy$syncAccount$1$WhenMappings */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[ResultAPI.Code.values().length];
                        try {
                            iArr[ResultAPI.Code.AuthV4ConflictPlayer.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (WhenMappings.$EnumSwitchMapping$0[result.getCode().ordinal()] == 1) {
                        listener.onAuthV4Helper(result, playerInfo);
                    } else {
                        listener.onAuthV4Helper(result, playerInfo);
                    }
                }
            });
        } else {
            listener.onAuthV4Helper(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, "Connected provider not found"), playerInfoCurrentPlayer);
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void showConflict(AuthV4.Helper.ConflictSingleViewInfo conflictData, final AuthV4.Helper.AuthV4HelperListener listener) throws JSONException {
        Intrinsics.checkNotNullParameter(conflictData, "conflictData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        AuthV4.Helper helper = AuthV4.Helper.INSTANCE;
        loggerImpl.iL(helper.getTAG(), "[showConflict] ConflictSingleViewInfo : " + conflictData);
        loggerImpl.iR(helper.getTAG(), "[showConflict] ConflictSingleViewInfo");
        AuthV4.PlayerInfo playerInfo = conflictPlayerInfo;
        if (hasConflict() && playerInfo != null) {
            if (conflictData.getPlayerData().get("player_id") == null || Intrinsics.areEqual(conflictData.getPlayerData().get("player_id"), "")) {
                conflictData.getPlayerData().put("player_id", Long.valueOf(playerInfo.getPlayerId()));
            }
            AuthV4Impl.INSTANCE.showConflictSelection(null, conflictData.getPlayerData(), new AuthV4.AuthV4SignInListener() { // from class: com.hive.authv4.helper.AuthV4HelperLegacy.showConflict.2
                @Override // com.hive.AuthV4.AuthV4SignInListener
                public void onAuthV4SignIn(ResultAPI result, AuthV4.PlayerInfo playerInfo2) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    AuthV4HelperLegacy.INSTANCE.cleanUpConflictInfo();
                    if (!result.isSuccess()) {
                        listener.onAuthV4Helper(result, playerInfo2);
                    } else {
                        listener.onAuthV4Helper(new ResultAPI(-15, ResultAPI.Code.AuthV4PlayerChange), playerInfo2);
                    }
                }
            });
            return;
        }
        listener.onAuthV4Helper(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidConflictInfo, "Not conflicted."), null);
    }
}
