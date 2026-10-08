package com.hive;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.ResultAPI;
import com.hive.authv4.provider.AuthV4ProviderGooglePlayGames;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\"#$B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0007J\u001c\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J$\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0012\u0010\u0019\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007J\u0018\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\"\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u001eH\u0007J\u0012\u0010\u001f\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u001eH\u0007J\u0012\u0010 \u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010!H\u0007R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006%"}, d2 = {"Lcom/hive/ProviderGoogle;", "", "<init>", "()V", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "googlePlayGames", "Lcom/hive/module/interfaces/authv4/provider/ProviderGooglePlayGames;", "getGooglePlayGames", "()Lcom/hive/module/interfaces/authv4/provider/ProviderGooglePlayGames;", "googlePlayGames$delegate", "Lkotlin/Lazy;", "achievementsReveal", "", "achievementId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/ProviderGoogle$GoogleAchievementsListener;", "achievementsUnlock", "achievementsIncrement", "incrementalAchievementId", "value", "", "showAchievements", "leaderboardsSubmitScore", "leaderboardId", FirebaseAnalytics.Param.SCORE, "", "Lcom/hive/ProviderGoogle$GoogleLeaderboardsListener;", "showLeaderboards", "getGooglePlayerId", "Lcom/hive/ProviderGoogle$GooglePlayerIdListener;", "GoogleAchievementsListener", "GoogleLeaderboardsListener", "GooglePlayerIdListener", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProviderGoogle {
    public static final ProviderGoogle INSTANCE = new ProviderGoogle();
    private static final String TAG;

    /* JADX INFO: renamed from: googlePlayGames$delegate, reason: from kotlin metadata */
    private static final Lazy googlePlayGames;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/ProviderGoogle$GoogleAchievementsListener;", "", "onAchievementsResult", "", "resultAPI", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface GoogleAchievementsListener {
        void onAchievementsResult(ResultAPI resultAPI);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/hive/ProviderGoogle$GoogleLeaderboardsListener;", "", "onLeaderboardsResult", "", "resultAPI", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface GoogleLeaderboardsListener {
        void onLeaderboardsResult(ResultAPI resultAPI);
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lcom/hive/ProviderGoogle$GooglePlayerIdListener;", "", "onPlayerIdResult", "", "resultAPI", "Lcom/hive/ResultAPI;", "googlePlayerId", "", "authCode", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface GooglePlayerIdListener {
        void onPlayerIdResult(ResultAPI resultAPI, String googlePlayerId, String authCode);
    }

    static {
        Intrinsics.checkNotNullExpressionValue("ProviderGoogle", "getSimpleName(...)");
        TAG = "ProviderGoogle";
        googlePlayGames = LazyKt.lazy(new Function0() { // from class: com.hive.ProviderGoogle$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ProviderGoogle.googlePlayGames_delegate$lambda$0();
            }
        });
    }

    private ProviderGoogle() {
    }

    @JvmStatic
    public static final void achievementsIncrement(String incrementalAchievementId, int value) {
        Intrinsics.checkNotNullParameter(incrementalAchievementId, "incrementalAchievementId");
        achievementsIncrement(incrementalAchievementId, value, null);
    }

    public static /* synthetic */ void achievementsIncrement$default(String str, int i, GoogleAchievementsListener googleAchievementsListener, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            googleAchievementsListener = null;
        }
        achievementsIncrement(str, i, googleAchievementsListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit achievementsIncrement$lambda$5(GoogleAchievementsListener googleAchievementsListener, ResultAPI resultApi) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        googleAchievementsListener.onAchievementsResult(resultApi);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void achievementsReveal(String achievementId) {
        Intrinsics.checkNotNullParameter(achievementId, "achievementId");
        achievementsReveal(achievementId, null);
    }

    public static /* synthetic */ void achievementsReveal$default(String str, GoogleAchievementsListener googleAchievementsListener, int i, Object obj) {
        if ((i & 2) != 0) {
            googleAchievementsListener = null;
        }
        achievementsReveal(str, googleAchievementsListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit achievementsReveal$lambda$1(GoogleAchievementsListener googleAchievementsListener, ResultAPI resultApi) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        googleAchievementsListener.onAchievementsResult(resultApi);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void achievementsUnlock(String achievementId) {
        Intrinsics.checkNotNullParameter(achievementId, "achievementId");
        achievementsUnlock(achievementId, null);
    }

    public static /* synthetic */ void achievementsUnlock$default(String str, GoogleAchievementsListener googleAchievementsListener, int i, Object obj) {
        if ((i & 2) != 0) {
            googleAchievementsListener = null;
        }
        achievementsUnlock(str, googleAchievementsListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit achievementsUnlock$lambda$3(GoogleAchievementsListener googleAchievementsListener, ResultAPI resultApi) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        googleAchievementsListener.onAchievementsResult(resultApi);
        return Unit.INSTANCE;
    }

    private final ProviderGooglePlayGames getGooglePlayGames() {
        return (ProviderGooglePlayGames) googlePlayGames.getValue();
    }

    @JvmStatic
    public static final void getGooglePlayerId(final GooglePlayerIdListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "listener = " + listener);
        AuthV4ProviderGooglePlayGames.INSTANCE.getPlayerId(new Function3() { // from class: com.hive.ProviderGoogle$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ProviderGoogle.getGooglePlayerId$lambda$15(listener, (ResultAPI) obj, (String) obj2, (String) obj3);
            }
        });
        loggerImpl.apiReturnLog(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGooglePlayerId$lambda$15(final GooglePlayerIdListener googlePlayerIdListener, ResultAPI resultAPI, final String str, String str2) {
        Intrinsics.checkNotNullParameter(resultAPI, "<unused var>");
        ProviderGooglePlayGames googlePlayGames2 = INSTANCE.getGooglePlayGames();
        if (googlePlayGames2 != null) {
            googlePlayGames2.isAuthenticated(new Function2() { // from class: com.hive.ProviderGoogle$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProviderGoogle.getGooglePlayerId$lambda$15$lambda$13(str, googlePlayerIdListener, (String) obj, (String) obj2);
                }
            });
        } else {
            LoggerImpl.INSTANCE.i(TAG, "AuthV4 provider is not initialize.");
            if (googlePlayerIdListener != null) {
                googlePlayerIdListener.onPlayerIdResult(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleNotSupported), "", "");
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getGooglePlayerId$lambda$15$lambda$13(String str, GooglePlayerIdListener googlePlayerIdListener, String str2, String str3) {
        if (str == null || !(!StringsKt.isBlank(str)) || str2 == null) {
            if (googlePlayerIdListener != null) {
                googlePlayerIdListener.onPlayerIdResult(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleNotSupported, str3), "", "");
            }
        } else if (googlePlayerIdListener != null) {
            googlePlayerIdListener.onPlayerIdResult(new ResultAPI(), str, str2);
        }
        return Unit.INSTANCE;
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProviderGooglePlayGames googlePlayGames_delegate$lambda$0() {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderGooglePlayGames.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderGooglePlayGames)) {
            hiveModule = null;
        }
        return (ProviderGooglePlayGames) (hiveModule instanceof ProviderGooglePlayGames ? hiveModule : null);
    }

    @JvmStatic
    public static final void leaderboardsSubmitScore(String leaderboardId, long score) {
        Intrinsics.checkNotNullParameter(leaderboardId, "leaderboardId");
        leaderboardsSubmitScore(leaderboardId, score, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit leaderboardsSubmitScore$lambda$9(GoogleLeaderboardsListener googleLeaderboardsListener, ResultAPI resultApi) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        googleLeaderboardsListener.onLeaderboardsResult(resultApi);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void showAchievements(final GoogleAchievementsListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "listener = " + listener);
        if (listener == null) {
            ProviderGooglePlayGames googlePlayGames2 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames2 != null) {
                ProviderGooglePlayGames.DefaultImpls.showAchievements$default(googlePlayGames2, null, 1, null);
            }
        } else {
            ProviderGooglePlayGames googlePlayGames3 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames3 != null) {
                googlePlayGames3.showAchievements(new Function1() { // from class: com.hive.ProviderGoogle$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProviderGoogle.showAchievements$lambda$7(listener, (ResultAPI) obj);
                    }
                });
            } else {
                loggerImpl.i(str, "Game provider is not initialize.");
                listener.onAchievementsResult(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailShowAchievements));
            }
        }
        loggerImpl.apiReturnLog(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAchievements$lambda$7(GoogleAchievementsListener googleAchievementsListener, ResultAPI resultApi) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        googleAchievementsListener.onAchievementsResult(resultApi);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void showLeaderboards(final GoogleLeaderboardsListener listener) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "listener = " + listener);
        if (listener == null) {
            ProviderGooglePlayGames googlePlayGames2 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames2 != null) {
                ProviderGooglePlayGames.DefaultImpls.showLeaderboards$default(googlePlayGames2, null, 1, null);
            }
        } else {
            ProviderGooglePlayGames googlePlayGames3 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames3 != null) {
                googlePlayGames3.showLeaderboards(new Function1() { // from class: com.hive.ProviderGoogle$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProviderGoogle.showLeaderboards$lambda$11(listener, (ResultAPI) obj);
                    }
                });
            } else {
                loggerImpl.i(str, "Game provider is not initialize.");
                listener.onLeaderboardsResult(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailShowLeaderboards));
            }
        }
        loggerImpl.apiReturnLog(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showLeaderboards$lambda$11(GoogleLeaderboardsListener googleLeaderboardsListener, ResultAPI resultApi) {
        Intrinsics.checkNotNullParameter(resultApi, "resultApi");
        googleLeaderboardsListener.onLeaderboardsResult(resultApi);
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void achievementsIncrement(String incrementalAchievementId, int value, final GoogleAchievementsListener listener) {
        Intrinsics.checkNotNullParameter(incrementalAchievementId, "incrementalAchievementId");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "incrementalAchievementId = " + incrementalAchievementId + ", value = " + value);
        if (listener == null) {
            ProviderGooglePlayGames googlePlayGames2 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames2 != null) {
                ProviderGooglePlayGames.DefaultImpls.achievementsIncrement$default(googlePlayGames2, incrementalAchievementId, value, null, 4, null);
            }
        } else {
            ProviderGooglePlayGames googlePlayGames3 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames3 != null) {
                googlePlayGames3.achievementsIncrement(incrementalAchievementId, value, new Function1() { // from class: com.hive.ProviderGoogle$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProviderGoogle.achievementsIncrement$lambda$5(listener, (ResultAPI) obj);
                    }
                });
            } else {
                loggerImpl.i(str, "Game provider is not initialize.");
                listener.onAchievementsResult(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailAchievementsIncrement));
            }
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void achievementsReveal(String achievementId, final GoogleAchievementsListener listener) {
        Intrinsics.checkNotNullParameter(achievementId, "achievementId");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "achievementId = " + achievementId);
        if (listener == null) {
            ProviderGooglePlayGames googlePlayGames2 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames2 != null) {
                ProviderGooglePlayGames.DefaultImpls.achievementsReveal$default(googlePlayGames2, achievementId, null, 2, null);
            }
        } else {
            ProviderGooglePlayGames googlePlayGames3 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames3 != null) {
                googlePlayGames3.achievementsReveal(achievementId, new Function1() { // from class: com.hive.ProviderGoogle$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProviderGoogle.achievementsReveal$lambda$1(listener, (ResultAPI) obj);
                    }
                });
            } else {
                loggerImpl.i(str, "Game provider is not initialize.");
                listener.onAchievementsResult(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailAchievementsReveal));
            }
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void achievementsUnlock(String achievementId, final GoogleAchievementsListener listener) {
        Intrinsics.checkNotNullParameter(achievementId, "achievementId");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "achievementId = " + achievementId);
        if (listener == null) {
            ProviderGooglePlayGames googlePlayGames2 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames2 != null) {
                ProviderGooglePlayGames.DefaultImpls.achievementsUnlock$default(googlePlayGames2, achievementId, null, 2, null);
            }
        } else {
            ProviderGooglePlayGames googlePlayGames3 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames3 != null) {
                googlePlayGames3.achievementsUnlock(achievementId, new Function1() { // from class: com.hive.ProviderGoogle$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProviderGoogle.achievementsUnlock$lambda$3(listener, (ResultAPI) obj);
                    }
                });
            } else {
                loggerImpl.i(str, "Game provider is not initialize.");
                listener.onAchievementsResult(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailAchievementsUnlock));
            }
        }
        loggerImpl.apiReturnLog(str, "");
    }

    @JvmStatic
    public static final void leaderboardsSubmitScore(String leaderboardId, long score, final GoogleLeaderboardsListener listener) {
        Intrinsics.checkNotNullParameter(leaderboardId, "leaderboardId");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "leaderboardId = " + leaderboardId + ", score = " + score);
        if (listener == null) {
            ProviderGooglePlayGames googlePlayGames2 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames2 != null) {
                ProviderGooglePlayGames.DefaultImpls.leaderboardsSubmitScore$default(googlePlayGames2, leaderboardId, score, null, 4, null);
            }
        } else {
            ProviderGooglePlayGames googlePlayGames3 = INSTANCE.getGooglePlayGames();
            if (googlePlayGames3 != null) {
                googlePlayGames3.leaderboardsSubmitScore(leaderboardId, score, new Function1() { // from class: com.hive.ProviderGoogle$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProviderGoogle.leaderboardsSubmitScore$lambda$9(listener, (ResultAPI) obj);
                    }
                });
            } else {
                loggerImpl.i(str, "Game provider is not initialize.");
                listener.onLeaderboardsResult(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailLeaderboardsSubmitScore));
            }
        }
        loggerImpl.apiReturnLog(str, "");
    }
}
