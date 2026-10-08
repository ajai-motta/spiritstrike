package com.hive.authv4.helper;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.authv4.AuthV4Account;
import com.hive.authv4.AuthV4Impl;
import com.hive.authv4.AuthV4Keys;
import com.hive.authv4.AuthV4Network;
import com.hive.authv4.helper.AuthV4HelperPlayGames;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.base.Property;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames;
import com.hive.protocol.authv4.GetIdpUid;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001IB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0012\u0010\u001c\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010 \u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010%\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0016J\u0018\u0010*\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0018\u0010/\u001a\u00020\u000f2\u0006\u00100\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\u0018\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\rH\u0002J\b\u00105\u001a\u00020\u000fH\u0002J\b\u00106\u001a\u00020\u000fH\u0002J(\u00107\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010;\u001a\u00020\u000fH\u0002J\u001c\u0010<\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\u001a\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020)2\b\u0010?\u001a\u0004\u0018\u000109H\u0002J\n\u0010@\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010A\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010\u000bH\u0002J\u001a\u0010B\u001a\u00020\u000f2\u0006\u00102\u001a\u0002032\b\u0010C\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010D\u001a\u0002032\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J\b\u0010E\u001a\u000203H\u0002J\b\u0010F\u001a\u00020\rH\u0002J\u0010\u0010G\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010H\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/hive/authv4/helper/AuthV4HelperPlayGames;", "Lcom/hive/authv4/helper/AuthV4Helper;", "<init>", "()V", "helperProviderType", "Lcom/hive/AuthV4$ProviderType;", "signInListener", "Lcom/hive/AuthV4$Helper$AuthV4HelperListener;", "connectListener", "conflictProviderType", "conflictPlayerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "isInProgressConflict", "", "syncAccount", "", "providerType", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "signIn", "signOut", "playerDelete", "connect", "disconnect", "showConflict", "conflictData", "Lcom/hive/AuthV4$Helper$ConflictSingleViewInfo;", "switchAccount", "resolveConflict", "showAchievements", "achievementsReveal", "achievementId", "", "achievementsUnlock", "achievementsIncrement", "incrementalAchievementId", "value", "", "showLeaderboard", "leaderboardsSubmitScore", "leaderboardId", FirebaseAnalytics.Param.SCORE, "", "internalConnect", "resolveMode", "Lcom/hive/authv4/helper/AuthV4HelperPlayGames$AuthV4HelperResolveMode;", "internalSignOut", "internalResolveConflict", "internalSwitchAccount", "conflictPlayerId", "checkBlackListResult", "result", "Lcom/hive/ResultAPI;", "needImplicitLogin", "processImplicitLoginFailure", "implicitLogin", "checkProvider", "currentProviderInfo", "Lcom/hive/AuthV4$ProviderInfo;", "playerInfo", "cleanUpConflictInfo", "getProviderInfo", "createPlayer", "playerId", "providerInfo", "currentPlayer", "connectResult", "signInResult", "currentPlayerInfo", "syncAccountStatus", "signInStatus", "hasConflict", "checkGooglePlayGamesAccount", "isSupportedHelperProviderType", "AuthV4HelperResolveMode", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4HelperPlayGames implements AuthV4Helper {
    private static AuthV4.PlayerInfo conflictPlayerInfo;
    private static AuthV4.ProviderType conflictProviderType;
    private static AuthV4.Helper.AuthV4HelperListener connectListener;
    private static boolean isInProgressConflict;
    private static AuthV4.Helper.AuthV4HelperListener signInListener;
    public static final AuthV4HelperPlayGames INSTANCE = new AuthV4HelperPlayGames();
    private static final AuthV4.ProviderType helperProviderType = AuthV4.ProviderType.GOOGLE_PLAY_GAMES;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/hive/authv4/helper/AuthV4HelperPlayGames$AuthV4HelperResolveMode;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "SELECT", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AuthV4HelperResolveMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AuthV4HelperResolveMode[] $VALUES;
        public static final AuthV4HelperResolveMode NONE = new AuthV4HelperResolveMode("NONE", 0);
        public static final AuthV4HelperResolveMode SELECT = new AuthV4HelperResolveMode("SELECT", 1);

        private static final /* synthetic */ AuthV4HelperResolveMode[] $values() {
            return new AuthV4HelperResolveMode[]{NONE, SELECT};
        }

        static {
            AuthV4HelperResolveMode[] authV4HelperResolveModeArr$values = $values();
            $VALUES = authV4HelperResolveModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(authV4HelperResolveModeArr$values);
        }

        private AuthV4HelperResolveMode(String str, int i) {
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
    }

    /* JADX INFO: renamed from: com.hive.authv4.helper.AuthV4HelperPlayGames$checkProvider$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/hive/authv4/helper/AuthV4HelperPlayGames$checkProvider$1", "Lcom/hive/AuthV4$AuthV4CheckProviderListener;", "onDeviceProviderInfo", "", "result", "Lcom/hive/ResultAPI;", "providerInfo", "Lcom/hive/AuthV4$ProviderInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C28771 implements AuthV4.AuthV4CheckProviderListener {
        final /* synthetic */ AuthV4.ProviderInfo $currentProviderInfo;
        final /* synthetic */ AuthV4.Helper.AuthV4HelperListener $listener;
        final /* synthetic */ AuthV4.PlayerInfo $playerInfo;
        final /* synthetic */ AuthV4.ProviderType $providerType;

        public C28771(AuthV4.ProviderInfo providerInfo, AuthV4.PlayerInfo playerInfo, AuthV4.ProviderType providerType, AuthV4.Helper.AuthV4HelperListener authV4HelperListener) {
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
                AuthV4HelperPlayGames.conflictProviderType = providerType;
                Long l = (Long) mapIdpFromProviderUid.get(providerInfo.getProviderUserId());
                if (l != null) {
                    AuthV4.PlayerInfo playerInfoCreatePlayer = AuthV4HelperPlayGames.INSTANCE.createPlayer(l.longValue(), providerInfo);
                    AuthV4Impl.INSTANCE.setRecentConflictPlayerInfo(playerInfoCreatePlayer);
                    AuthV4HelperPlayGames.conflictPlayerInfo = playerInfoCreatePlayer;
                }
                authV4HelperListener.onAuthV4Helper(resultAPI, AuthV4HelperPlayGames.conflictPlayerInfo);
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
            authV4Network.getIdpUid$hive_service_release(playerInfo, providerType, providerUserId, new Function3() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$checkProvider$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AuthV4HelperPlayGames.C28771.onDeviceProviderInfo$lambda$2(providerType2, providerInfo, authV4HelperListener, resultAPI, (ResultAPI) obj, (GetIdpUid) obj2, (HashMap) obj3);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.helper.AuthV4HelperPlayGames$showAchievements$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/hive/authv4/helper/AuthV4HelperPlayGames$showAchievements$1", "Lcom/hive/AuthV4$Helper$AuthV4HelperListener;", "onAuthV4Helper", "", "result", "Lcom/hive/ResultAPI;", "playerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C28861 implements AuthV4.Helper.AuthV4HelperListener {
        final /* synthetic */ AuthV4.Helper.AuthV4HelperListener $listener;

        public C28861(AuthV4.Helper.AuthV4HelperListener authV4HelperListener) {
            this.$listener = authV4HelperListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onAuthV4Helper$lambda$0(final AuthV4.Helper.AuthV4HelperListener authV4HelperListener, final ResultAPI showAchievementsResult) {
            Intrinsics.checkNotNullParameter(showAchievementsResult, "showAchievementsResult");
            if (showAchievementsResult.getCode() == ResultAPI.Code.AuthV4GoogleLogout) {
                AuthV4HelperPlayGames.INSTANCE.internalSignOut(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$showAchievements$1$onAuthV4Helper$1$1
                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                    public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        AuthV4.Helper.AuthV4HelperListener authV4HelperListener2 = authV4HelperListener;
                        if (authV4HelperListener2 != null) {
                            authV4HelperListener2.onAuthV4Helper(showAchievementsResult, null);
                        }
                    }
                });
            } else if (authV4HelperListener != null) {
                authV4HelperListener.onAuthV4Helper(showAchievementsResult, null);
            }
            return Unit.INSTANCE;
        }

        @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
        public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!result.isSuccess()) {
                AuthV4.Helper.AuthV4HelperListener authV4HelperListener = this.$listener;
                if (authV4HelperListener != null) {
                    authV4HelperListener.onAuthV4Helper(result, playerInfo);
                    return;
                }
                return;
            }
            HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
            String name = ProviderGooglePlayGames.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
            if (!(hiveModule instanceof ProviderGooglePlayGames)) {
                hiveModule = null;
            }
            ProviderGooglePlayGames providerGooglePlayGames = (ProviderGooglePlayGames) (hiveModule instanceof ProviderGooglePlayGames ? hiveModule : null);
            if (providerGooglePlayGames != null) {
                final AuthV4.Helper.AuthV4HelperListener authV4HelperListener2 = this.$listener;
                providerGooglePlayGames.showAchievements(new Function1() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$showAchievements$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AuthV4HelperPlayGames.C28861.onAuthV4Helper$lambda$0(authV4HelperListener2, (ResultAPI) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: com.hive.authv4.helper.AuthV4HelperPlayGames$showLeaderboard$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/hive/authv4/helper/AuthV4HelperPlayGames$showLeaderboard$1", "Lcom/hive/AuthV4$Helper$AuthV4HelperListener;", "onAuthV4Helper", "", "result", "Lcom/hive/ResultAPI;", "playerInfo", "Lcom/hive/AuthV4$PlayerInfo;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C28891 implements AuthV4.Helper.AuthV4HelperListener {
        final /* synthetic */ AuthV4.Helper.AuthV4HelperListener $listener;

        public C28891(AuthV4.Helper.AuthV4HelperListener authV4HelperListener) {
            this.$listener = authV4HelperListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onAuthV4Helper$lambda$0(final AuthV4.Helper.AuthV4HelperListener authV4HelperListener, final ResultAPI showLeaderboardsResult) {
            Intrinsics.checkNotNullParameter(showLeaderboardsResult, "showLeaderboardsResult");
            if (showLeaderboardsResult.getCode() == ResultAPI.Code.AuthV4GoogleLogout) {
                AuthV4HelperPlayGames.INSTANCE.internalSignOut(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$showLeaderboard$1$onAuthV4Helper$1$1
                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                    public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        AuthV4.Helper.AuthV4HelperListener authV4HelperListener2 = authV4HelperListener;
                        if (authV4HelperListener2 != null) {
                            authV4HelperListener2.onAuthV4Helper(showLeaderboardsResult, null);
                        }
                    }
                });
            } else if (authV4HelperListener != null) {
                authV4HelperListener.onAuthV4Helper(showLeaderboardsResult, null);
            }
            return Unit.INSTANCE;
        }

        @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
        public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (!result.isSuccess()) {
                AuthV4.Helper.AuthV4HelperListener authV4HelperListener = this.$listener;
                if (authV4HelperListener != null) {
                    authV4HelperListener.onAuthV4Helper(result, playerInfo);
                    return;
                }
                return;
            }
            HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
            String name = ProviderGooglePlayGames.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
            if (!(hiveModule instanceof ProviderGooglePlayGames)) {
                hiveModule = null;
            }
            ProviderGooglePlayGames providerGooglePlayGames = (ProviderGooglePlayGames) (hiveModule instanceof ProviderGooglePlayGames ? hiveModule : null);
            if (providerGooglePlayGames != null) {
                final AuthV4.Helper.AuthV4HelperListener authV4HelperListener2 = this.$listener;
                providerGooglePlayGames.showLeaderboards(new Function1() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$showLeaderboard$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AuthV4HelperPlayGames.C28891.onAuthV4Helper$lambda$0(authV4HelperListener2, (ResultAPI) obj);
                    }
                });
            }
        }
    }

    private AuthV4HelperPlayGames() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit achievementsIncrement$lambda$2(AuthV4.Helper.AuthV4HelperListener authV4HelperListener, ResultAPI it) {
        Intrinsics.checkNotNullParameter(it, "it");
        authV4HelperListener.onAuthV4Helper(it, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit achievementsReveal$lambda$0(AuthV4.Helper.AuthV4HelperListener authV4HelperListener, ResultAPI it) {
        Intrinsics.checkNotNullParameter(it, "it");
        authV4HelperListener.onAuthV4Helper(it, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit achievementsUnlock$lambda$1(AuthV4.Helper.AuthV4HelperListener authV4HelperListener, ResultAPI it) {
        Intrinsics.checkNotNullParameter(it, "it");
        authV4HelperListener.onAuthV4Helper(it, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkBlackListResult(ResultAPI result, boolean needImplicitLogin) {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] checkBlackListResult()");
        if (result.getErrorCode() == -17) {
            signInResult(result, null);
        } else if (needImplicitLogin) {
            implicitLogin();
        } else {
            processImplicitLoginFailure();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6, types: [com.hive.AuthV4$Helper$AuthV4HelperListener, com.hive.authv4.helper.AuthV4HelperPlayGames$checkGooglePlayGamesAccount$authV4HelperListener$1] */
    private final void checkGooglePlayGamesAccount(final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] checkGoogleAccount()");
        AuthV4.ProviderType providerType = AuthV4.ProviderType.GOOGLE_PLAY_GAMES;
        ResultAPI resultAPISyncAccountStatus = syncAccountStatus(providerType);
        if (!resultAPISyncAccountStatus.isSuccess()) {
            listener.onAuthV4Helper(resultAPISyncAccountStatus, null);
            return;
        }
        if (!AuthV4Impl.INSTANCE.getIdpList().contains(providerType)) {
            listener.onAuthV4Helper(new ResultAPI(-2, ResultAPI.Code.AuthV4GoogleNotSupported), null);
            return;
        }
        final ?? r1 = new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$checkGooglePlayGamesAccount$authV4HelperListener$1
            @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
            public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                Intrinsics.checkNotNullParameter(result, "result");
                listener.onAuthV4Helper(result, playerInfo);
            }
        };
        if (getProviderInfo(currentPlayer(), providerType) != null) {
            HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
            String name = ProviderGooglePlayGames.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
            if (!(hiveModule instanceof ProviderGooglePlayGames)) {
                hiveModule = null;
            }
            ProviderGooglePlayGames providerGooglePlayGames = (ProviderGooglePlayGames) (hiveModule instanceof ProviderGooglePlayGames ? hiveModule : null);
            if (providerGooglePlayGames == null || !providerGooglePlayGames.getLastAuthenticated()) {
                AuthV4ProviderAdapter.INSTANCE.login(providerType, new AuthV4ProviderAdapter.ProviderLoginListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.checkGooglePlayGamesAccount.1
                    @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLoginListener
                    public void onProviderLoginListener(ResultAPI result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        if (result.isSuccess()) {
                            AuthV4HelperPlayGames.INSTANCE.syncAccount(AuthV4.ProviderType.GOOGLE_PLAY_GAMES, AuthV4HelperResolveMode.SELECT, r1);
                        } else {
                            listener.onAuthV4Helper(result, null);
                        }
                    }
                });
                return;
            } else {
                syncAccount(providerType, AuthV4HelperResolveMode.SELECT, r1);
                return;
            }
        }
        HiveModuleManager hiveModuleManager2 = HiveModuleManager.INSTANCE;
        String name2 = ProviderGooglePlayGames.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        HiveModule hiveModule2 = hiveModuleManager2.getHiveModule(name2);
        if (!(hiveModule2 instanceof ProviderGooglePlayGames)) {
            hiveModule2 = null;
        }
        ProviderGooglePlayGames providerGooglePlayGames2 = (ProviderGooglePlayGames) (hiveModule2 instanceof ProviderGooglePlayGames ? hiveModule2 : null);
        if (providerGooglePlayGames2 == null || !providerGooglePlayGames2.getLastAuthenticated()) {
            AuthV4ProviderAdapter.INSTANCE.login(providerType, new AuthV4ProviderAdapter.ProviderLoginListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.checkGooglePlayGamesAccount.2
                @Override // com.hive.authv4.provider.AuthV4ProviderAdapter.ProviderLoginListener
                public void onProviderLoginListener(ResultAPI result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (result.isSuccess()) {
                        AuthV4HelperPlayGames.INSTANCE.internalConnect(AuthV4.ProviderType.GOOGLE_PLAY_GAMES, r1);
                    } else {
                        listener.onAuthV4Helper(result, null);
                    }
                }
            });
        } else {
            internalConnect(providerType, r1);
        }
    }

    private final void checkProvider(AuthV4.ProviderType providerType, AuthV4.ProviderInfo currentProviderInfo, AuthV4.PlayerInfo playerInfo, AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] checkProvider : " + providerType + "    \nProviderInfo: " + currentProviderInfo + "    \nplayerInfo: " + playerInfo);
        AuthV4Impl.INSTANCE.checkProvider(providerType, new C28771(currentProviderInfo, playerInfo, providerType, listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanUpConflictInfo() {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] cleanUpConflictInfo()");
        conflictPlayerInfo = null;
        conflictProviderType = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void connectResult(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
        LoggerImpl.INSTANCE.dL("[AuthV4HelperPlayGames] connectResult() : " + result + "\n    PlayerInfo : " + playerInfo);
        AuthV4.Helper.AuthV4HelperListener authV4HelperListener = connectListener;
        if (authV4HelperListener != null) {
            authV4HelperListener.onAuthV4Helper(result, playerInfo);
        }
        connectListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthV4.PlayerInfo createPlayer(long playerId, AuthV4.ProviderInfo providerInfo) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        StringBuilder sb = new StringBuilder("[AuthV4HelperPlayGames] createPlayer() : ");
        sb.append(playerId);
        sb.append("\n    ProviderInfo : ");
        sb.append(providerInfo != null ? providerInfo : "providerInfo is null");
        loggerImpl.d(sb.toString());
        AuthV4.PlayerInfo playerInfo = new AuthV4.PlayerInfo();
        playerInfo.setPlayerId(playerId);
        if (providerInfo != null) {
            playerInfo.getProviderInfoData().put(providerInfo.getProviderType(), providerInfo);
        }
        return playerInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthV4.PlayerInfo currentPlayer() {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] currentPlayer()");
        return AuthV4Account.INSTANCE.getPlayerInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AuthV4.ProviderInfo getProviderInfo(AuthV4.PlayerInfo playerInfo, AuthV4.ProviderType providerType) {
        LoggerImpl.INSTANCE.dL("[AuthV4HelperPlayGames] getProviderInfo() - " + providerType + "\n    " + playerInfo);
        if (playerInfo == null) {
            return null;
        }
        for (AuthV4.ProviderType providerType2 : playerInfo.getProviderInfoData().keySet()) {
            Intrinsics.checkNotNullExpressionValue(providerType2, "next(...)");
            AuthV4.ProviderType providerType3 = providerType2;
            if (providerType == providerType3) {
                return playerInfo.getProviderInfoData().get(providerType3);
            }
        }
        return null;
    }

    private final boolean hasConflict() {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] hasConflict()");
        return conflictPlayerInfo != null;
    }

    private final void implicitLogin() {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] implicitLogin()");
        boolean z = Boolean.parseBoolean(Property.INSTANCE.getINSTANCE().getValue(AuthV4Keys.IMPLICIT_SIGNED_IN_EVER, "false"));
        if (!isSupportedHelperProviderType() || z) {
            processImplicitLoginFailure();
        } else {
            AuthV4Impl.INSTANCE.signIn(helperProviderType, new AuthV4.AuthV4SignInListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.implicitLogin.1
                @Override // com.hive.AuthV4.AuthV4SignInListener
                public void onAuthV4SignIn(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (result.isFailure()) {
                        AuthV4HelperPlayGames.INSTANCE.checkBlackListResult(result, false);
                        return;
                    }
                    Property.Companion companion = Property.INSTANCE;
                    Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.IMPLICIT_SIGNED_IN_EVER, "true", null, 4, null);
                    companion.getINSTANCE().writeProperties();
                    AuthV4HelperPlayGames.INSTANCE.signInResult(result, playerInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalConnect(final AuthV4.ProviderType providerType, final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] internalConnect() - " + providerType);
        final AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        AuthV4Impl.INSTANCE.connect(providerType, new AuthV4.AuthV4ConnectListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.internalConnect.1

            /* JADX INFO: renamed from: com.hive.authv4.helper.AuthV4HelperPlayGames$internalConnect$1$WhenMappings */
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
                LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] internalConnect result : " + result);
                int i = WhenMappings.$EnumSwitchMapping$0[result.getCode().ordinal()];
                if (i == 1) {
                    listener.onAuthV4Helper(result, playerInfo);
                    return;
                }
                if (i == 2) {
                    listener.onAuthV4Helper(result, playerInfo);
                    return;
                }
                if (i != 3) {
                    listener.onAuthV4Helper(result, null);
                    return;
                }
                AuthV4HelperPlayGames authV4HelperPlayGames = AuthV4HelperPlayGames.INSTANCE;
                AuthV4HelperPlayGames.conflictProviderType = providerType;
                AuthV4HelperPlayGames.conflictPlayerInfo = conflictPlayer;
                listener.onAuthV4Helper(result, AuthV4HelperPlayGames.conflictPlayerInfo);
            }
        });
    }

    private final void internalResolveConflict(final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] internalResolveConflict()");
        AuthV4Impl.INSTANCE.resolveConflict(new AuthV4.AuthV4ResolveConflictListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.internalResolveConflict.1
            @Override // com.hive.AuthV4.AuthV4ResolveConflictListener
            public void onAuthV4ResolveConflict(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (!result.isSuccess()) {
                    listener.onAuthV4Helper(result, null);
                    return;
                }
                ResultAPI resultAPI = new ResultAPI(-6, ResultAPI.Code.AuthV4PlayerResolved);
                AuthV4HelperPlayGames authV4HelperPlayGames = AuthV4HelperPlayGames.INSTANCE;
                authV4HelperPlayGames.cleanUpConflictInfo();
                listener.onAuthV4Helper(resultAPI, authV4HelperPlayGames.currentPlayer());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void internalSignOut(final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] internalSignOut()");
        AuthV4Impl.INSTANCE.signOut(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.internalSignOut.1
            @Override // com.hive.AuthV4.AuthV4SignOutListener
            public void onAuthV4SignOut(ResultAPI result) {
                Intrinsics.checkNotNullParameter(result, "result");
                listener.onAuthV4Helper(result, null);
            }
        });
    }

    private final void internalSwitchAccount(long conflictPlayerId, final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] internalSwitchAccount()");
        AuthV4Impl.INSTANCE.selectConflict(conflictPlayerId, new AuthV4.AuthV4SignInListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.internalSwitchAccount.1
            @Override // com.hive.AuthV4.AuthV4SignInListener
            public void onAuthV4SignIn(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (!result.isSuccess()) {
                    listener.onAuthV4Helper(result, null);
                    return;
                }
                AuthV4HelperPlayGames.INSTANCE.cleanUpConflictInfo();
                listener.onAuthV4Helper(new ResultAPI(-15, ResultAPI.Code.AuthV4PlayerChange), playerInfo);
            }
        });
    }

    private final boolean isSupportedHelperProviderType() {
        return AuthV4Impl.INSTANCE.getIdpList().contains(helperProviderType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit leaderboardsSubmitScore$lambda$3(AuthV4.Helper.AuthV4HelperListener authV4HelperListener, ResultAPI it) {
        Intrinsics.checkNotNullParameter(it, "it");
        authV4HelperListener.onAuthV4Helper(it, null);
        return Unit.INSTANCE;
    }

    private final void processImplicitLoginFailure() {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] processImplicitLoginFailure()");
        Property.Companion companion = Property.INSTANCE;
        Property.setValue$default(companion.getINSTANCE(), AuthV4Keys.IMPLICIT_SIGNED_IN_EVER, "true", null, 4, null);
        companion.getINSTANCE().writeProperties();
        signInResult(new ResultAPI(-9, ResultAPI.Code.AuthV4HelperImplifiedLoginFail, "Need explicit login."), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void signInResult(ResultAPI result, AuthV4.PlayerInfo currentPlayerInfo) {
        LoggerImpl.INSTANCE.dL("[AuthV4HelperPlayGames] signInResult() : " + result + "\n    PlayerInfo : " + currentPlayerInfo);
        AuthV4.Helper.AuthV4HelperListener authV4HelperListener = signInListener;
        if (authV4HelperListener != null) {
            authV4HelperListener.onAuthV4Helper(result, currentPlayerInfo);
        }
        signInListener = null;
    }

    private final ResultAPI signInStatus() {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4HelperPlayGames] signInStatus()");
        if (AuthV4Impl.INSTANCE.isSetup()) {
            return currentPlayer() != null ? new ResultAPI(-1, ResultAPI.Code.AuthV4AlreadyAuthorized) : new ResultAPI();
        }
        loggerImpl.w("[AuthV4HelperPlayGames] signInStatus - [SignIn] Need AuthV4 setup first");
        return new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized, "[SignIn] Need AuthV4 setup first");
    }

    private final ResultAPI syncAccountStatus(AuthV4.ProviderType providerType) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4HelperPlayGames] syncAccountStatus() : " + providerType);
        if (!AuthV4Impl.INSTANCE.isSetup()) {
            loggerImpl.w("[AuthV4HelperPlayGames] syncAccountStatus failed - Need AuthV4 setup first");
            return new ResultAPI(-7, ResultAPI.Code.AuthV4NotInitialized);
        }
        if (AuthV4Account.INSTANCE.readPlayerInfo() == null) {
            loggerImpl.w("[AuthV4HelperPlayGames] syncAccountStatus failed - User not authorized.");
            return new ResultAPI(-9, ResultAPI.Code.AuthV4SigninFirst);
        }
        loggerImpl.d("[AuthV4HelperPlayGames] syncAccountStatus success.");
        return new ResultAPI();
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void achievementsIncrement(String incrementalAchievementId, int value, final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(incrementalAchievementId, "incrementalAchievementId");
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] achievementsIncrement() - " + incrementalAchievementId + " (" + value + ')');
        if (listener == null) {
            HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
            String name = ProviderGooglePlayGames.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
            if (!(hiveModule instanceof ProviderGooglePlayGames)) {
                hiveModule = null;
            }
            ProviderGooglePlayGames providerGooglePlayGames = (ProviderGooglePlayGames) (hiveModule instanceof ProviderGooglePlayGames ? hiveModule : null);
            if (providerGooglePlayGames != null) {
                ProviderGooglePlayGames.DefaultImpls.achievementsIncrement$default(providerGooglePlayGames, incrementalAchievementId, value, null, 4, null);
                return;
            }
            return;
        }
        HiveModuleManager hiveModuleManager2 = HiveModuleManager.INSTANCE;
        String name2 = ProviderGooglePlayGames.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        HiveModule hiveModule2 = hiveModuleManager2.getHiveModule(name2);
        if (!(hiveModule2 instanceof ProviderGooglePlayGames)) {
            hiveModule2 = null;
        }
        ProviderGooglePlayGames providerGooglePlayGames2 = (ProviderGooglePlayGames) (hiveModule2 instanceof ProviderGooglePlayGames ? hiveModule2 : null);
        if (providerGooglePlayGames2 != null) {
            providerGooglePlayGames2.achievementsIncrement(incrementalAchievementId, value, new Function1() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4HelperPlayGames.achievementsIncrement$lambda$2(listener, (ResultAPI) obj);
                }
            });
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void achievementsReveal(String achievementId, final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(achievementId, "achievementId");
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] achievementsReveal() - " + achievementId);
        if (listener != null) {
            HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
            String name = ProviderGooglePlayGames.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
            if (!(hiveModule instanceof ProviderGooglePlayGames)) {
                hiveModule = null;
            }
            ProviderGooglePlayGames providerGooglePlayGames = (ProviderGooglePlayGames) (hiveModule instanceof ProviderGooglePlayGames ? hiveModule : null);
            if (providerGooglePlayGames != null) {
                providerGooglePlayGames.achievementsReveal(achievementId, new Function1() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AuthV4HelperPlayGames.achievementsReveal$lambda$0(listener, (ResultAPI) obj);
                    }
                });
                return;
            }
            return;
        }
        HiveModuleManager hiveModuleManager2 = HiveModuleManager.INSTANCE;
        String name2 = ProviderGooglePlayGames.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        HiveModule hiveModule2 = hiveModuleManager2.getHiveModule(name2);
        if (!(hiveModule2 instanceof ProviderGooglePlayGames)) {
            hiveModule2 = null;
        }
        if (!(hiveModule2 instanceof ProviderGooglePlayGames)) {
            hiveModule2 = null;
        }
        ProviderGooglePlayGames providerGooglePlayGames2 = (ProviderGooglePlayGames) hiveModule2;
        if (providerGooglePlayGames2 != null) {
            ProviderGooglePlayGames.DefaultImpls.achievementsReveal$default(providerGooglePlayGames2, achievementId, null, 2, null);
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void achievementsUnlock(String achievementId, final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(achievementId, "achievementId");
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] achievementsUnlock() - " + achievementId);
        if (listener != null) {
            HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
            String name = ProviderGooglePlayGames.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
            if (!(hiveModule instanceof ProviderGooglePlayGames)) {
                hiveModule = null;
            }
            ProviderGooglePlayGames providerGooglePlayGames = (ProviderGooglePlayGames) (hiveModule instanceof ProviderGooglePlayGames ? hiveModule : null);
            if (providerGooglePlayGames != null) {
                providerGooglePlayGames.achievementsUnlock(achievementId, new Function1() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AuthV4HelperPlayGames.achievementsUnlock$lambda$1(listener, (ResultAPI) obj);
                    }
                });
                return;
            }
            return;
        }
        HiveModuleManager hiveModuleManager2 = HiveModuleManager.INSTANCE;
        String name2 = ProviderGooglePlayGames.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        HiveModule hiveModule2 = hiveModuleManager2.getHiveModule(name2);
        if (!(hiveModule2 instanceof ProviderGooglePlayGames)) {
            hiveModule2 = null;
        }
        if (!(hiveModule2 instanceof ProviderGooglePlayGames)) {
            hiveModule2 = null;
        }
        ProviderGooglePlayGames providerGooglePlayGames2 = (ProviderGooglePlayGames) hiveModule2;
        if (providerGooglePlayGames2 != null) {
            ProviderGooglePlayGames.DefaultImpls.achievementsUnlock$default(providerGooglePlayGames2, achievementId, null, 2, null);
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void connect(AuthV4.ProviderType providerType, AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] connect()");
        if (connectListener != null) {
            listener.onAuthV4Helper(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgressSignIn), null);
        } else {
            connectListener = listener;
            internalConnect(providerType, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.connect.1
                @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    AuthV4HelperPlayGames.INSTANCE.connectResult(result, playerInfo);
                }
            });
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void disconnect(AuthV4.ProviderType providerType, final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] disconnect()");
        AuthV4Impl.INSTANCE.disconnect(providerType, new AuthV4.AuthV4DisconnectListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.disconnect.1
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
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] leaderboardsSubmitScore() - " + leaderboardId + " (" + score + ')');
        if (listener == null) {
            HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
            String name = ProviderGooglePlayGames.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
            if (!(hiveModule instanceof ProviderGooglePlayGames)) {
                hiveModule = null;
            }
            ProviderGooglePlayGames providerGooglePlayGames = (ProviderGooglePlayGames) (hiveModule instanceof ProviderGooglePlayGames ? hiveModule : null);
            if (providerGooglePlayGames != null) {
                ProviderGooglePlayGames.DefaultImpls.leaderboardsSubmitScore$default(providerGooglePlayGames, leaderboardId, score, null, 4, null);
                return;
            }
            return;
        }
        HiveModuleManager hiveModuleManager2 = HiveModuleManager.INSTANCE;
        String name2 = ProviderGooglePlayGames.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        HiveModule hiveModule2 = hiveModuleManager2.getHiveModule(name2);
        if (!(hiveModule2 instanceof ProviderGooglePlayGames)) {
            hiveModule2 = null;
        }
        ProviderGooglePlayGames providerGooglePlayGames2 = (ProviderGooglePlayGames) (hiveModule2 instanceof ProviderGooglePlayGames ? hiveModule2 : null);
        if (providerGooglePlayGames2 != null) {
            providerGooglePlayGames2.leaderboardsSubmitScore(leaderboardId, score, new Function1() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AuthV4HelperPlayGames.leaderboardsSubmitScore$lambda$3(listener, (ResultAPI) obj);
                }
            });
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void playerDelete(final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] playerDelete()");
        AuthV4Impl.INSTANCE.playerDelete(new AuthV4.AuthV4SignOutListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.playerDelete.1
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
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] resolveConflict()");
        if (hasConflict()) {
            internalResolveConflict(listener);
        } else {
            listener.onAuthV4Helper(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidConflictInfo, "Not conflicted."), null);
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void showAchievements(AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] showAchievements()");
        checkGooglePlayGamesAccount(new C28861(listener));
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void showConflict(final AuthV4.Helper.AuthV4HelperListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4HelperPlayGames] showConflict()");
        final AuthV4.ProviderType providerType = conflictProviderType;
        if (!hasConflict() || providerType == null) {
            listener.onAuthV4Helper(new ResultAPI(-1, ResultAPI.Code.AuthV4InvalidConflictInfo, "Not conflicted."), null);
        } else if (isInProgressConflict) {
            loggerImpl.w("[AuthV4HelperPlayGames] showConflict is in progress.");
        } else {
            isInProgressConflict = true;
            HiveUiActivity.INSTANCE.launch(HiveActivity.INSTANCE.getRecentActivity(), new OnActivityLifecycle() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.showConflict.1
                public AuthV4HelperConflictView conflictView;

                private final AuthV4HelperConflictView createDialog(final Activity activity) {
                    AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
                    boolean zIsGuest = playerInfo != null ? playerInfo.isGuest() : false;
                    AuthV4.ProviderType providerType2 = providerType;
                    final AuthV4.Helper.AuthV4HelperListener authV4HelperListener = listener;
                    return new AuthV4HelperConflictView(activity, providerType2, zIsGuest, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$showConflict$1$createDialog$view$1
                        @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                        public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo2) {
                            Intrinsics.checkNotNullParameter(result, "result");
                            AuthV4HelperPlayGames.isInProgressConflict = false;
                            if (result.isSuccess()) {
                                AuthV4HelperPlayGames authV4HelperPlayGames = AuthV4HelperPlayGames.INSTANCE;
                                final AuthV4.Helper.AuthV4HelperListener authV4HelperListener2 = authV4HelperListener;
                                authV4HelperPlayGames.resolveConflict(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$showConflict$1$createDialog$view$1$onAuthV4Helper$1
                                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                                    public void onAuthV4Helper(ResultAPI result2, AuthV4.PlayerInfo playerInfo3) {
                                        Intrinsics.checkNotNullParameter(result2, "result");
                                        authV4HelperListener2.onAuthV4Helper(result2, playerInfo3);
                                    }
                                });
                            } else {
                                AuthV4HelperPlayGames authV4HelperPlayGames2 = AuthV4HelperPlayGames.INSTANCE;
                                final AuthV4.Helper.AuthV4HelperListener authV4HelperListener3 = authV4HelperListener;
                                authV4HelperPlayGames2.switchAccount(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$showConflict$1$createDialog$view$1$onAuthV4Helper$2
                                    @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                                    public void onAuthV4Helper(ResultAPI result2, AuthV4.PlayerInfo playerInfo3) {
                                        Intrinsics.checkNotNullParameter(result2, "result");
                                        authV4HelperListener3.onAuthV4Helper(result2, playerInfo3);
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
    public void showLeaderboard(AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] showAchievements()");
        checkGooglePlayGamesAccount(new C28891(listener));
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void signIn(AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AuthV4HelperPlayGames] signIn()");
        ResultAPI resultAPISignInStatus = signInStatus();
        if (resultAPISignInStatus.isFailure()) {
            loggerImpl.w(resultAPISignInStatus.toString());
            if (listener != null) {
                listener.onAuthV4Helper(resultAPISignInStatus, null);
                return;
            }
            return;
        }
        if (listener == null) {
            loggerImpl.w("[AuthV4HelperPlayGames] SignIn - AuthV4HelperInListener is null");
            return;
        }
        if (signInListener != null) {
            loggerImpl.w("[AuthV4HelperPlayGames] SignIn - in progress sign-in");
            listener.onAuthV4Helper(new ResultAPI(-3, ResultAPI.Code.AuthV4InProgressSignIn), null);
            return;
        }
        signInListener = listener;
        AuthV4Impl authV4Impl = AuthV4Impl.INSTANCE;
        if (authV4Impl.isAutoSignIn()) {
            authV4Impl.signIn(AuthV4.ProviderType.AUTO, new AuthV4.AuthV4SignInListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.signIn.1
                @Override // com.hive.AuthV4.AuthV4SignInListener
                public void onAuthV4SignIn(ResultAPI result, AuthV4.PlayerInfo playerInfo) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (!result.isSuccess()) {
                        AuthV4HelperPlayGames.INSTANCE.checkBlackListResult(result, true);
                        return;
                    }
                    AuthV4HelperPlayGames authV4HelperPlayGames = AuthV4HelperPlayGames.INSTANCE;
                    if (authV4HelperPlayGames.getProviderInfo(playerInfo, AuthV4HelperPlayGames.helperProviderType) != null) {
                        authV4HelperPlayGames.syncAccount(AuthV4.ProviderType.AUTO, AuthV4HelperResolveMode.SELECT, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames$signIn$1$onAuthV4SignIn$1$1
                            @Override // com.hive.AuthV4.Helper.AuthV4HelperListener
                            public void onAuthV4Helper(ResultAPI result2, AuthV4.PlayerInfo playerInfo2) {
                                Intrinsics.checkNotNullParameter(result2, "result");
                                if (result2.isSuccess() || result2.getCode() == ResultAPI.Code.AuthV4ConflictPlayer) {
                                    AuthV4HelperPlayGames.INSTANCE.signInResult(result2, playerInfo2);
                                } else {
                                    AuthV4HelperPlayGames authV4HelperPlayGames2 = AuthV4HelperPlayGames.INSTANCE;
                                    authV4HelperPlayGames2.signInResult(new ResultAPI(), authV4HelperPlayGames2.currentPlayer());
                                }
                            }
                        });
                    } else {
                        authV4HelperPlayGames.signInResult(result, playerInfo);
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
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] signOut()");
        internalSignOut(new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.signOut.1
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
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] switchAccount()");
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
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] syncAccount - ProvideType : " + providerType);
        syncAccount(providerType, AuthV4HelperResolveMode.NONE, listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncAccount(AuthV4.ProviderType providerType, AuthV4HelperResolveMode resolveMode, final AuthV4.Helper.AuthV4HelperListener listener) {
        LoggerImpl.INSTANCE.d("[AuthV4HelperPlayGames] syncAccount - " + providerType + ", " + resolveMode);
        ResultAPI resultAPISyncAccountStatus = syncAccountStatus(providerType);
        if (resultAPISyncAccountStatus.isFailure()) {
            listener.onAuthV4Helper(resultAPISyncAccountStatus, null);
            return;
        }
        AuthV4.PlayerInfo playerInfo = AuthV4Account.INSTANCE.getPlayerInfo();
        if (providerType == AuthV4.ProviderType.AUTO) {
            providerType = helperProviderType;
        }
        AuthV4.ProviderInfo providerInfo = getProviderInfo(playerInfo, providerType);
        if (providerInfo != null && playerInfo != null) {
            checkProvider(providerType, providerInfo, playerInfo, new AuthV4.Helper.AuthV4HelperListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.syncAccount.1

                /* JADX INFO: renamed from: com.hive.authv4.helper.AuthV4HelperPlayGames$syncAccount$1$WhenMappings */
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
                public void onAuthV4Helper(ResultAPI result, AuthV4.PlayerInfo playerInfo2) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (WhenMappings.$EnumSwitchMapping$0[result.getCode().ordinal()] == 1) {
                        listener.onAuthV4Helper(result, playerInfo2);
                    } else {
                        listener.onAuthV4Helper(result, playerInfo2);
                    }
                }
            });
        } else {
            listener.onAuthV4Helper(new ResultAPI(-2, ResultAPI.Code.AuthV4NotSupportedProviderType, "Connected provider not found"), playerInfo);
        }
    }

    @Override // com.hive.authv4.helper.AuthV4Helper
    public void showConflict(AuthV4.Helper.ConflictSingleViewInfo conflictData, final AuthV4.Helper.AuthV4HelperListener listener) throws JSONException {
        Intrinsics.checkNotNullParameter(conflictData, "conflictData");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL("[AuthV4HelperPlayGames] showConflict() ConflictSingleViewInfo : " + conflictData);
        loggerImpl.dR("[AuthV4HelperPlayGames] showConflict() ConflictSingleViewInfo");
        AuthV4.PlayerInfo playerInfo = conflictPlayerInfo;
        if (hasConflict() && playerInfo != null) {
            if (conflictData.getPlayerData().get("player_id") == null || Intrinsics.areEqual(conflictData.getPlayerData().get("player_id"), "")) {
                conflictData.getPlayerData().put("player_id", Long.valueOf(playerInfo.getPlayerId()));
            }
            AuthV4Impl.INSTANCE.showConflictSelection(null, conflictData.getPlayerData(), new AuthV4.AuthV4SignInListener() { // from class: com.hive.authv4.helper.AuthV4HelperPlayGames.showConflict.2
                @Override // com.hive.AuthV4.AuthV4SignInListener
                public void onAuthV4SignIn(ResultAPI result, AuthV4.PlayerInfo playerInfo2) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    AuthV4HelperPlayGames.INSTANCE.cleanUpConflictInfo();
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
