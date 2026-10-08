package com.hive.authv4.helper;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.AuthV4;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006 "}, d2 = {"Lcom/hive/authv4/helper/AuthV4Helper;", "", "syncAccount", "", "providerType", "Lcom/hive/AuthV4$ProviderType;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/AuthV4$Helper$AuthV4HelperListener;", "signIn", "signOut", "playerDelete", "connect", "disconnect", "showConflict", "conflictData", "Lcom/hive/AuthV4$Helper$ConflictSingleViewInfo;", "switchAccount", "resolveConflict", "showAchievements", "achievementsReveal", "achievementId", "", "achievementsUnlock", "achievementsIncrement", "incrementalAchievementId", "value", "", "showLeaderboard", "leaderboardsSubmitScore", "leaderboardId", FirebaseAnalytics.Param.SCORE, "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AuthV4Helper {
    void achievementsIncrement(String incrementalAchievementId, int value, AuthV4.Helper.AuthV4HelperListener listener);

    void achievementsReveal(String achievementId, AuthV4.Helper.AuthV4HelperListener listener);

    void achievementsUnlock(String achievementId, AuthV4.Helper.AuthV4HelperListener listener);

    void connect(AuthV4.ProviderType providerType, AuthV4.Helper.AuthV4HelperListener listener);

    void disconnect(AuthV4.ProviderType providerType, AuthV4.Helper.AuthV4HelperListener listener);

    void leaderboardsSubmitScore(String leaderboardId, long score, AuthV4.Helper.AuthV4HelperListener listener);

    void playerDelete(AuthV4.Helper.AuthV4HelperListener listener);

    void resolveConflict(AuthV4.Helper.AuthV4HelperListener listener);

    void showAchievements(AuthV4.Helper.AuthV4HelperListener listener);

    void showConflict(AuthV4.Helper.AuthV4HelperListener listener);

    void showConflict(AuthV4.Helper.ConflictSingleViewInfo conflictData, AuthV4.Helper.AuthV4HelperListener listener);

    void showLeaderboard(AuthV4.Helper.AuthV4HelperListener listener);

    void signIn(AuthV4.Helper.AuthV4HelperListener listener);

    void signOut(AuthV4.Helper.AuthV4HelperListener listener);

    void switchAccount(AuthV4.Helper.AuthV4HelperListener listener);

    void syncAccount(AuthV4.ProviderType providerType, AuthV4.Helper.AuthV4HelperListener listener);
}
