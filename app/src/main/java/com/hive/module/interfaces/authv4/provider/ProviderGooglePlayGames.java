package com.hive.module.interfaces.authv4.provider;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.ResultAPI;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\nH&JD\u0010\f\u001a\u00020\r2:\u0010\u000e\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fH&JD\u0010\u0014\u001a\u00020\r2:\u0010\u000e\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\r0\u000fH&J7\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00032%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H&J7\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00032%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H&J?\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H&J/\u0010\u001f\u001a\u00020\r2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H&J?\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020#2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H&J/\u0010$\u001a\u00020\r2%\b\u0002\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r\u0018\u00010\u0017H&R\u0012\u0010\u0004\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006%"}, d2 = {"Lcom/hive/module/interfaces/authv4/provider/ProviderGooglePlayGames;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "playGamesServerClientId", "getPlayGamesServerClientId", "()Ljava/lang/String;", "playGamesRedirectUri", "getPlayGamesRedirectUri", "isGpgPcEnvironment", "", "lastAuthenticated", "isAuthenticated", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "serverAuthCode", "failReason", "signIn", "achievementsReveal", "achievementId", "Lkotlin/Function1;", "Lcom/hive/ResultAPI;", "resultApi", "achievementsUnlock", "achievementsIncrement", "incrementalAchievementId", "value", "", "showAchievements", "leaderboardsSubmitScore", "leaderboardId", FirebaseAnalytics.Param.SCORE, "", "showLeaderboards", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ProviderGooglePlayGames extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void achievementsIncrement$default(ProviderGooglePlayGames providerGooglePlayGames, String str, int i, Function1 function1, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: achievementsIncrement");
            }
            if ((i2 & 4) != 0) {
                function1 = null;
            }
            providerGooglePlayGames.achievementsIncrement(str, i, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void achievementsReveal$default(ProviderGooglePlayGames providerGooglePlayGames, String str, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: achievementsReveal");
            }
            if ((i & 2) != 0) {
                function1 = null;
            }
            providerGooglePlayGames.achievementsReveal(str, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void achievementsUnlock$default(ProviderGooglePlayGames providerGooglePlayGames, String str, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: achievementsUnlock");
            }
            if ((i & 2) != 0) {
                function1 = null;
            }
            providerGooglePlayGames.achievementsUnlock(str, function1);
        }

        public static String getHiveModuleName(ProviderGooglePlayGames providerGooglePlayGames) {
            return HiveModuleName.INSTANCE.getAuthV4_Provider_Google_PlayGames();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void leaderboardsSubmitScore$default(ProviderGooglePlayGames providerGooglePlayGames, String str, long j, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: leaderboardsSubmitScore");
            }
            if ((i & 4) != 0) {
                function1 = null;
            }
            providerGooglePlayGames.leaderboardsSubmitScore(str, j, function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showAchievements$default(ProviderGooglePlayGames providerGooglePlayGames, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAchievements");
            }
            if ((i & 1) != 0) {
                function1 = null;
            }
            providerGooglePlayGames.showAchievements(function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void showLeaderboards$default(ProviderGooglePlayGames providerGooglePlayGames, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLeaderboards");
            }
            if ((i & 1) != 0) {
                function1 = null;
            }
            providerGooglePlayGames.showLeaderboards(function1);
        }
    }

    void achievementsIncrement(String incrementalAchievementId, int value, Function1<? super ResultAPI, Unit> listener);

    void achievementsReveal(String achievementId, Function1<? super ResultAPI, Unit> listener);

    void achievementsUnlock(String achievementId, Function1<? super ResultAPI, Unit> listener);

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    String getPlayGamesRedirectUri();

    String getPlayGamesServerClientId();

    void isAuthenticated(Function2<? super String, ? super String, Unit> listener);

    boolean isGpgPcEnvironment();

    boolean lastAuthenticated();

    void leaderboardsSubmitScore(String leaderboardId, long score, Function1<? super ResultAPI, Unit> listener);

    void showAchievements(Function1<? super ResultAPI, Unit> listener);

    void showLeaderboards(Function1<? super ResultAPI, Unit> listener);

    void signIn(Function2<? super String, ? super String, Unit> listener);
}
