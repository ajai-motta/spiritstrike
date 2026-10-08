package com.hive.module.googleplaygames;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.AuthenticationResult;
import com.google.android.gms.games.GamesSignInClient;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Configuration;
import com.hive.core.ExtentionsKt;
import com.hive.logger.LoggerImpl;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.Resource;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: compiled from: HiveModuleGooglePlayGames.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010!\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\r0\"H\u0082@¢\u0006\u0002\u0010#J\u001c\u0010$\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\r0\"H\u0082@¢\u0006\u0002\u0010#J\u001e\u0010%\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\r0\"H\u0082@¢\u0006\u0002\u0010#J \u0010&\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0006\u0012\u0004\u0018\u00010\r0\"2\b\b\u0002\u0010'\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020 H\u0016J\b\u0010\u001f\u001a\u00020 H\u0016JD\u0010!\u001a\u00020)2:\u0010*\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020)0+H\u0016JD\u0010$\u001a\u00020)2:\u0010*\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020)0+H\u0016J5\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020\r2#\u0010*\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020)\u0018\u000102H\u0016J5\u00105\u001a\u00020)2\u0006\u00101\u001a\u00020\r2#\u0010*\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020)\u0018\u000102H\u0016J=\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u0002092#\u0010*\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020)\u0018\u000102H\u0016J-\u0010:\u001a\u00020)2#\u0010*\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020)\u0018\u000102H\u0016J=\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020>2#\u0010*\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020)\u0018\u000102H\u0016J-\u0010?\u001a\u00020)2#\u0010*\u001a\u001f\u0012\u0013\u0012\u001103¢\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020)\u0018\u000102H\u0016J\u0010\u0010@\u001a\u00020 2\u0006\u0010A\u001a\u000209H\u0002J\b\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u000209H\u0002J\u0014\u0010E\u001a\u00020\r2\n\u0010F\u001a\u0006\u0012\u0002\b\u00030GH\u0002J\u0010\u0010E\u001a\u00020\r2\u0006\u0010H\u001a\u00020IH\u0002J\u0014\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0KH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\rX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L"}, d2 = {"Lcom/hive/module/googleplaygames/HiveModuleGooglePlayGames;", "Lcom/hive/module/interfaces/authv4/provider/ProviderGooglePlayGames;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "activity$delegate", "Lkotlin/Lazy;", "keyGooglePlayGamesServerClientId", "", "playGamesServerClientId", "getPlayGamesServerClientId", "()Ljava/lang/String;", "playGamesRedirectUri", "getPlayGamesRedirectUri", "gamesSignInClient", "Lcom/google/android/gms/games/GamesSignInClient;", "getGamesSignInClient", "()Lcom/google/android/gms/games/GamesSignInClient;", "achievementsClient", "Lcom/google/android/gms/games/AchievementsClient;", "getAchievementsClient", "()Lcom/google/android/gms/games/AchievementsClient;", "leaderboardsClient", "Lcom/google/android/gms/games/LeaderboardsClient;", "getLeaderboardsClient", "()Lcom/google/android/gms/games/LeaderboardsClient;", "lastAuthenticated", "", "isAuthenticated", "Lkotlin/Pair;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signIn", "requestServerSideAccess", "checkInvalidSetup", "ui", "isGpgPcEnvironment", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "serverAuthCode", "failReason", "achievementsReveal", "achievementId", "Lkotlin/Function1;", "Lcom/hive/ResultAPI;", "resultApi", "achievementsUnlock", "achievementsIncrement", "incrementalAchievementId", "value", "", "showAchievements", "leaderboardsSubmitScore", "leaderboardId", FirebaseAnalytics.Param.SCORE, "", "showLeaderboards", "isGamesActivityResultErrorCode", "resultCode", "getProviderFromHiveConfig", "Lorg/json/JSONObject;", "generatorRequestCode", "getGamesApiStatusMessage", "task", "Lcom/google/android/gms/tasks/Task;", "exception", "Ljava/lang/Exception;", "getVersionInfo", "", "hive-authv4-provider-google-playgames_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveModuleGooglePlayGames implements ProviderGooglePlayGames {

    /* JADX INFO: renamed from: activity$delegate, reason: from kotlin metadata */
    private final Lazy activity;
    private final Context context;
    private final String keyGooglePlayGamesServerClientId;
    private boolean lastAuthenticated;
    private final String playGamesRedirectUri;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isGamesActivityResultErrorCode(int resultCode) {
        return resultCode == 10001;
    }

    public HiveModuleGooglePlayGames(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.activity = LazyKt.lazy(new Function0() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HiveModuleGooglePlayGames.activity_delegate$lambda$0();
            }
        });
        this.keyGooglePlayGamesServerClientId = "@serverClientId";
        this.playGamesRedirectUri = "https://auth.qpyou.cn/callback";
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return ProviderGooglePlayGames.DefaultImpls.getHiveModuleName(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity activity_delegate$lambda$0() {
        return HiveActivity.INSTANCE.getRecentActivity();
    }

    private final Activity getActivity() {
        return (Activity) this.activity.getValue();
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    public String getPlayGamesServerClientId() {
        String googlePlayGamesServerClientId = Configuration.INSTANCE.getGooglePlayGamesServerClientId();
        if (!(!StringsKt.isBlank(googlePlayGamesServerClientId))) {
            googlePlayGamesServerClientId = null;
        }
        if (googlePlayGamesServerClientId != null) {
            return googlePlayGamesServerClientId;
        }
        String strOptString = getProviderFromHiveConfig().optString(this.keyGooglePlayGamesServerClientId, "");
        Intrinsics.checkNotNull(strOptString);
        String str = StringsKt.isBlank(strOptString) ^ true ? strOptString : null;
        if (str != null) {
            return str;
        }
        String string = Resource.INSTANCE.getString("google_play_games_server_client_id");
        return string == null ? "" : string;
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    public String getPlayGamesRedirectUri() {
        return this.playGamesRedirectUri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GamesSignInClient getGamesSignInClient() {
        GamesSignInClient gamesSignInClient = PlayGames.getGamesSignInClient(getActivity());
        Intrinsics.checkNotNullExpressionValue(gamesSignInClient, "getGamesSignInClient(...)");
        return gamesSignInClient;
    }

    private final AchievementsClient getAchievementsClient() {
        AchievementsClient achievementsClient = PlayGames.getAchievementsClient(getActivity());
        Intrinsics.checkNotNullExpressionValue(achievementsClient, "getAchievementsClient(...)");
        return achievementsClient;
    }

    private final LeaderboardsClient getLeaderboardsClient() {
        LeaderboardsClient leaderboardsClient = PlayGames.getLeaderboardsClient(getActivity());
        Intrinsics.checkNotNullExpressionValue(leaderboardsClient, "getLeaderboardsClient(...)");
        return leaderboardsClient;
    }

    static /* synthetic */ Pair checkInvalidSetup$default(HiveModuleGooglePlayGames hiveModuleGooglePlayGames, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return hiveModuleGooglePlayGames.checkInvalidSetup(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<Boolean, String> checkInvalidSetup(boolean ui) {
        if (!Android.isGooglePlayServicesAvailable$default(Android.INSTANCE, ui ? getActivity() : this.context, ui, 0, 4, null)) {
            return new Pair<>(true, "Google Play Services not available.");
        }
        if (StringsKt.isBlank(this.keyGooglePlayGamesServerClientId)) {
            return new Pair<>(true, "Provisional key does not exist.");
        }
        return new Pair<>(false, null);
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    public boolean isGpgPcEnvironment() {
        boolean zHasSystemFeature = this.context.getApplicationContext().getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
        System.out.println((Object) ("[GooglePlayGames] - isPcEnvironment : " + zHasSystemFeature));
        return zHasSystemFeature;
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    /* JADX INFO: renamed from: lastAuthenticated, reason: from getter */
    public boolean getLastAuthenticated() {
        return this.lastAuthenticated;
    }

    /* JADX INFO: renamed from: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$isAuthenticated$3, reason: invalid class name */
    /* JADX INFO: compiled from: HiveModuleGooglePlayGames.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.module.googleplaygames.HiveModuleGooglePlayGames$isAuthenticated$3", f = "HiveModuleGooglePlayGames.kt", i = {}, l = {161, 163, 170, 171}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<String, String, Unit> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Function2<? super String, ? super String, Unit> function2, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$listener = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HiveModuleGooglePlayGames.this.new AnonymousClass3(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x008f A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L2e
                if (r1 == r6) goto L2a
                if (r1 == r5) goto L26
                if (r1 == r4) goto L22
                if (r1 != r3) goto L1a
                kotlin.ResultKt.throwOnFailure(r8)
                goto L90
            L1a:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L22:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L76
            L26:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L65
            L2a:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L3f
            L2e:
                kotlin.ResultKt.throwOnFailure(r8)
                com.hive.module.googleplaygames.HiveModuleGooglePlayGames r8 = com.hive.module.googleplaygames.HiveModuleGooglePlayGames.this
                r1 = r7
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r7.label = r6
                java.lang.Object r8 = com.hive.module.googleplaygames.HiveModuleGooglePlayGames.access$isAuthenticated(r8, r1)
                if (r8 != r0) goto L3f
                return r0
            L3f:
                kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> r1 = r7.$listener
                kotlin.Pair r8 = (kotlin.Pair) r8
                java.lang.Object r6 = r8.getFirst()
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 != 0) goto L68
                kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
                com.hive.module.googleplaygames.HiveModuleGooglePlayGames$isAuthenticated$3$1$1 r4 = new com.hive.module.googleplaygames.HiveModuleGooglePlayGames$isAuthenticated$3$1$1
                r4.<init>(r1, r8, r2)
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                r7.label = r5
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r7)
                if (r8 != r0) goto L65
                return r0
            L65:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            L68:
                com.hive.module.googleplaygames.HiveModuleGooglePlayGames r8 = com.hive.module.googleplaygames.HiveModuleGooglePlayGames.this
                r1 = r7
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r7.label = r4
                java.lang.Object r8 = com.hive.module.googleplaygames.HiveModuleGooglePlayGames.access$requestServerSideAccess(r8, r1)
                if (r8 != r0) goto L76
                return r0
            L76:
                kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> r1 = r7.$listener
                kotlin.Pair r8 = (kotlin.Pair) r8
                kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
                com.hive.module.googleplaygames.HiveModuleGooglePlayGames$isAuthenticated$3$2$1 r5 = new com.hive.module.googleplaygames.HiveModuleGooglePlayGames$isAuthenticated$3$2$1
                r5.<init>(r1, r8, r2)
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                r7.label = r3
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r7)
                if (r8 != r0) goto L90
                return r0
            L90:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.module.googleplaygames.HiveModuleGooglePlayGames.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    public void isAuthenticated(Function2<? super String, ? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass3(listener, null), 3, null);
    }

    /* JADX INFO: renamed from: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$signIn$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HiveModuleGooglePlayGames.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.module.googleplaygames.HiveModuleGooglePlayGames$signIn$3", f = "HiveModuleGooglePlayGames.kt", i = {}, l = {180, 182, PsExtractor.PRIVATE_STREAM_1, FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend", n = {}, s = {})
    static final class C29313 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<String, String, Unit> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C29313(Function2<? super String, ? super String, Unit> function2, Continuation<? super C29313> continuation) {
            super(2, continuation);
            this.$listener = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HiveModuleGooglePlayGames.this.new C29313(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C29313) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x008f A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 0
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L2e
                if (r1 == r6) goto L2a
                if (r1 == r5) goto L26
                if (r1 == r4) goto L22
                if (r1 != r3) goto L1a
                kotlin.ResultKt.throwOnFailure(r8)
                goto L90
            L1a:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L22:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L76
            L26:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L65
            L2a:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L3f
            L2e:
                kotlin.ResultKt.throwOnFailure(r8)
                com.hive.module.googleplaygames.HiveModuleGooglePlayGames r8 = com.hive.module.googleplaygames.HiveModuleGooglePlayGames.this
                r1 = r7
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r7.label = r6
                java.lang.Object r8 = com.hive.module.googleplaygames.HiveModuleGooglePlayGames.access$signIn(r8, r1)
                if (r8 != r0) goto L3f
                return r0
            L3f:
                kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> r1 = r7.$listener
                kotlin.Pair r8 = (kotlin.Pair) r8
                java.lang.Object r6 = r8.getFirst()
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 != 0) goto L68
                kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
                com.hive.module.googleplaygames.HiveModuleGooglePlayGames$signIn$3$1$1 r4 = new com.hive.module.googleplaygames.HiveModuleGooglePlayGames$signIn$3$1$1
                r4.<init>(r1, r8, r2)
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                r7.label = r5
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r7)
                if (r8 != r0) goto L65
                return r0
            L65:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            L68:
                com.hive.module.googleplaygames.HiveModuleGooglePlayGames r8 = com.hive.module.googleplaygames.HiveModuleGooglePlayGames.this
                r1 = r7
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r7.label = r4
                java.lang.Object r8 = com.hive.module.googleplaygames.HiveModuleGooglePlayGames.access$requestServerSideAccess(r8, r1)
                if (r8 != r0) goto L76
                return r0
            L76:
                kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> r1 = r7.$listener
                kotlin.Pair r8 = (kotlin.Pair) r8
                kotlinx.coroutines.MainCoroutineDispatcher r4 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
                com.hive.module.googleplaygames.HiveModuleGooglePlayGames$signIn$3$2$1 r5 = new com.hive.module.googleplaygames.HiveModuleGooglePlayGames$signIn$3$2$1
                r5.<init>(r1, r8, r2)
                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                r7.label = r3
                java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r4, r5, r7)
                if (r8 != r0) goto L90
                return r0
            L90:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.module.googleplaygames.HiveModuleGooglePlayGames.C29313.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    public void signIn(Function2<? super String, ? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C29313(listener, null), 3, null);
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    public void achievementsReveal(String achievementId, final Function1<? super ResultAPI, Unit> listener) {
        Object objM7415constructorimpl;
        Object objAddOnCompleteListener;
        Intrinsics.checkNotNullParameter(achievementId, "achievementId");
        LoggerImpl.INSTANCE.d("[GooglePlayGames] achievementsReveal(" + achievementId + ')');
        try {
            Result.Companion companion = Result.INSTANCE;
            if (listener == null) {
                LoggerImpl.INSTANCE.d("[GooglePlayGames] achievementsReveal - call reveal()");
                getAchievementsClient().reveal(achievementId);
                objAddOnCompleteListener = Unit.INSTANCE;
            } else {
                objAddOnCompleteListener = getAchievementsClient().revealImmediate(achievementId).addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$$ExternalSyntheticLambda7
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        HiveModuleGooglePlayGames.achievementsReveal$lambda$14$lambda$13(this.f$0, listener, task);
                    }
                });
                Intrinsics.checkNotNull(objAddOnCompleteListener);
            }
            objM7415constructorimpl = Result.m7415constructorimpl(objAddOnCompleteListener);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[GooglePlayGames] achievementsReveal - exception : " + thM7418exceptionOrNullimpl.getMessage());
            if (listener != null) {
                listener.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailAchievementsReveal, thM7418exceptionOrNullimpl.getMessage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void achievementsReveal$lambda$14$lambda$13(HiveModuleGooglePlayGames hiveModuleGooglePlayGames, Function1 function1, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        String gamesApiStatusMessage = hiveModuleGooglePlayGames.getGamesApiStatusMessage((Task<?>) task);
        if (task.isSuccessful()) {
            LoggerImpl.INSTANCE.d("[GooglePlayGames] achievementsReveal - successful : " + gamesApiStatusMessage);
            function1.invoke(new ResultAPI(0, ResultAPI.Code.Success, gamesApiStatusMessage));
            return;
        }
        LoggerImpl.INSTANCE.w("[GooglePlayGames] achievementsReveal - failed : " + gamesApiStatusMessage);
        function1.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailAchievementsReveal, gamesApiStatusMessage));
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    public void achievementsUnlock(String achievementId, final Function1<? super ResultAPI, Unit> listener) {
        Object objM7415constructorimpl;
        Object objAddOnCompleteListener;
        Intrinsics.checkNotNullParameter(achievementId, "achievementId");
        LoggerImpl.INSTANCE.d("[GooglePlayGames] achievementsUnlock(" + achievementId + ')');
        try {
            Result.Companion companion = Result.INSTANCE;
            if (listener == null) {
                LoggerImpl.INSTANCE.d("[GooglePlayGames] achievementsUnlock - call reveal()");
                getAchievementsClient().unlock(achievementId);
                objAddOnCompleteListener = Unit.INSTANCE;
            } else {
                objAddOnCompleteListener = getAchievementsClient().unlockImmediate(achievementId).addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$$ExternalSyntheticLambda5
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        HiveModuleGooglePlayGames.achievementsUnlock$lambda$17$lambda$16(this.f$0, listener, task);
                    }
                });
                Intrinsics.checkNotNull(objAddOnCompleteListener);
            }
            objM7415constructorimpl = Result.m7415constructorimpl(objAddOnCompleteListener);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[GooglePlayGames] achievementsUnlock - exception : " + thM7418exceptionOrNullimpl.getMessage());
            if (listener != null) {
                listener.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailAchievementsUnlock, thM7418exceptionOrNullimpl.getMessage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void achievementsUnlock$lambda$17$lambda$16(HiveModuleGooglePlayGames hiveModuleGooglePlayGames, Function1 function1, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        String gamesApiStatusMessage = hiveModuleGooglePlayGames.getGamesApiStatusMessage((Task<?>) task);
        if (task.isSuccessful()) {
            LoggerImpl.INSTANCE.d("[GooglePlayGames] achievementsUnlock - successful : " + gamesApiStatusMessage);
            function1.invoke(new ResultAPI(0, ResultAPI.Code.Success, gamesApiStatusMessage));
            return;
        }
        LoggerImpl.INSTANCE.w("[GooglePlayGames] achievementsUnlock - failed : " + gamesApiStatusMessage);
        function1.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailAchievementsUnlock, gamesApiStatusMessage));
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    public void achievementsIncrement(String incrementalAchievementId, int value, final Function1<? super ResultAPI, Unit> listener) {
        Object objM7415constructorimpl;
        Object objAddOnCompleteListener;
        Intrinsics.checkNotNullParameter(incrementalAchievementId, "incrementalAchievementId");
        LoggerImpl.INSTANCE.d("[GooglePlayGames] achievementsIncrement(" + incrementalAchievementId + ", " + value + ')');
        try {
            Result.Companion companion = Result.INSTANCE;
            if (listener == null) {
                LoggerImpl.INSTANCE.d("[GooglePlayGames] achievementsIncrement - call reveal()");
                getAchievementsClient().increment(incrementalAchievementId, value);
                objAddOnCompleteListener = Unit.INSTANCE;
            } else {
                objAddOnCompleteListener = getAchievementsClient().incrementImmediate(incrementalAchievementId, value).addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$$ExternalSyntheticLambda6
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        HiveModuleGooglePlayGames.achievementsIncrement$lambda$20$lambda$19(this.f$0, listener, task);
                    }
                });
                Intrinsics.checkNotNull(objAddOnCompleteListener);
            }
            objM7415constructorimpl = Result.m7415constructorimpl(objAddOnCompleteListener);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[GooglePlayGames] achievementsIncrement - exception : " + thM7418exceptionOrNullimpl.getMessage());
            if (listener != null) {
                listener.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailAchievementsIncrement, thM7418exceptionOrNullimpl.getMessage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void achievementsIncrement$lambda$20$lambda$19(HiveModuleGooglePlayGames hiveModuleGooglePlayGames, Function1 function1, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        String gamesApiStatusMessage = hiveModuleGooglePlayGames.getGamesApiStatusMessage((Task<?>) task);
        if (task.isSuccessful()) {
            LoggerImpl.INSTANCE.d("[GooglePlayGames] achievementsIncrement - successful : " + gamesApiStatusMessage);
            function1.invoke(new ResultAPI(0, ResultAPI.Code.Success, gamesApiStatusMessage));
            return;
        }
        LoggerImpl.INSTANCE.w("[GooglePlayGames] achievementsIncrement - failed : " + gamesApiStatusMessage);
        function1.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailAchievementsIncrement, gamesApiStatusMessage));
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    public void showAchievements(final Function1<? super ResultAPI, Unit> listener) {
        Object objM7415constructorimpl;
        LoggerImpl.INSTANCE.d("[GooglePlayGames] showAchievements()");
        try {
            Result.Companion companion = Result.INSTANCE;
            Task<Intent> achievementsIntent = getAchievementsClient().getAchievementsIntent();
            final Function1 function1 = new Function1() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HiveModuleGooglePlayGames.showAchievements$lambda$25$lambda$22(this.f$0, listener, (Intent) obj);
                }
            };
            objM7415constructorimpl = Result.m7415constructorimpl(achievementsIntent.addOnSuccessListener(new OnSuccessListener() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$$ExternalSyntheticLambda9
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$$ExternalSyntheticLambda10
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiveModuleGooglePlayGames.showAchievements$lambda$25$lambda$24(this.f$0, listener, exc);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[GooglePlayGames] showAchievements - exception : " + thM7418exceptionOrNullimpl.getMessage());
            if (listener != null) {
                listener.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailShowAchievements, thM7418exceptionOrNullimpl.getMessage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showAchievements$lambda$25$lambda$22(final HiveModuleGooglePlayGames hiveModuleGooglePlayGames, final Function1 function1, final Intent intent) {
        LoggerImpl.INSTANCE.d("[GooglePlayGames] showAchievements - successful");
        final int iGeneratorRequestCode = hiveModuleGooglePlayGames.generatorRequestCode();
        HiveActivity.registerHiveActivityLifecycleListeners(new OnActivityLifecycle() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$showAchievements$1$1$1
            @Override // com.hive.ui.OnActivityLifecycle
            public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                LoggerImpl.INSTANCE.d("[GooglePlayGames] showAchievements - onActivityResult : \nrequestCode: " + requestCode + "\nresultCode: " + resultCode + "\nintent: " + intent);
                if (requestCode != iGeneratorRequestCode) {
                    super.onActivityResult(activity, requestCode, resultCode, data);
                    return;
                }
                if (hiveModuleGooglePlayGames.isGamesActivityResultErrorCode(resultCode)) {
                    Function1<ResultAPI, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(new ResultAPI(-9, ResultAPI.Code.AuthV4GoogleLogout));
                    }
                } else {
                    Function1<ResultAPI, Unit> function13 = function1;
                    if (function13 != null) {
                        function13.invoke(new ResultAPI(0, ResultAPI.Code.Success, String.valueOf(resultCode)));
                    }
                }
                HiveActivity.unregisterHiveActivityLifecycleListeners(this);
            }
        });
        Activity activity = hiveModuleGooglePlayGames.getActivity();
        Intrinsics.checkNotNull(intent);
        ExtentionsKt.startActivityForResultCatching$default(activity, intent, iGeneratorRequestCode, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAchievements$lambda$25$lambda$24(HiveModuleGooglePlayGames hiveModuleGooglePlayGames, Function1 function1, Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        String gamesApiStatusMessage = hiveModuleGooglePlayGames.getGamesApiStatusMessage(exception);
        LoggerImpl.INSTANCE.w("[GooglePlayGames] showAchievements - failed : " + gamesApiStatusMessage);
        if (function1 != null) {
            function1.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailShowAchievements, gamesApiStatusMessage));
        }
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    public void leaderboardsSubmitScore(String leaderboardId, long score, final Function1<? super ResultAPI, Unit> listener) {
        Object objM7415constructorimpl;
        Object objAddOnCompleteListener;
        Intrinsics.checkNotNullParameter(leaderboardId, "leaderboardId");
        LoggerImpl.INSTANCE.d("[GooglePlayGames] leaderboardsSubmitScore(" + leaderboardId + ", " + score + ')');
        try {
            Result.Companion companion = Result.INSTANCE;
            if (listener == null) {
                LoggerImpl.INSTANCE.d("[GooglePlayGames] leaderboardsSubmitScore - call reveal()");
                getLeaderboardsClient().submitScore(leaderboardId, score);
                objAddOnCompleteListener = Unit.INSTANCE;
            } else {
                objAddOnCompleteListener = getLeaderboardsClient().submitScoreImmediate(leaderboardId, score).addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        HiveModuleGooglePlayGames.leaderboardsSubmitScore$lambda$28$lambda$27(this.f$0, listener, task);
                    }
                });
                Intrinsics.checkNotNull(objAddOnCompleteListener);
            }
            objM7415constructorimpl = Result.m7415constructorimpl(objAddOnCompleteListener);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[GooglePlayGames] leaderboardsSubmitScore - exception : " + thM7418exceptionOrNullimpl.getMessage());
            if (listener != null) {
                listener.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailLeaderboardsSubmitScore, thM7418exceptionOrNullimpl.getMessage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void leaderboardsSubmitScore$lambda$28$lambda$27(HiveModuleGooglePlayGames hiveModuleGooglePlayGames, Function1 function1, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        String gamesApiStatusMessage = hiveModuleGooglePlayGames.getGamesApiStatusMessage((Task<?>) task);
        if (task.isSuccessful()) {
            LoggerImpl.INSTANCE.d("[GooglePlayGames] leaderboardsSubmitScore - successful : " + gamesApiStatusMessage);
            function1.invoke(new ResultAPI(0, ResultAPI.Code.Success, gamesApiStatusMessage));
            return;
        }
        LoggerImpl.INSTANCE.w("[GooglePlayGames] leaderboardsSubmitScore - failed : " + gamesApiStatusMessage);
        function1.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailLeaderboardsSubmitScore, gamesApiStatusMessage));
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames
    public void showLeaderboards(final Function1<? super ResultAPI, Unit> listener) {
        Object objM7415constructorimpl;
        LoggerImpl.INSTANCE.d("[GooglePlayGames] showLeaderboards()");
        try {
            Result.Companion companion = Result.INSTANCE;
            Task<Intent> allLeaderboardsIntent = getLeaderboardsClient().getAllLeaderboardsIntent();
            final Function1 function1 = new Function1() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HiveModuleGooglePlayGames.showLeaderboards$lambda$33$lambda$30(this.f$0, listener, (Intent) obj);
                }
            };
            objM7415constructorimpl = Result.m7415constructorimpl(allLeaderboardsIntent.addOnSuccessListener(new OnSuccessListener() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$$ExternalSyntheticLambda2
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$$ExternalSyntheticLambda3
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    HiveModuleGooglePlayGames.showLeaderboards$lambda$33$lambda$32(this.f$0, listener, exc);
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[GooglePlayGames] showLeaderboards - exception : " + thM7418exceptionOrNullimpl.getMessage());
            if (listener != null) {
                listener.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailShowLeaderboards, thM7418exceptionOrNullimpl.getMessage()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showLeaderboards$lambda$33$lambda$30(final HiveModuleGooglePlayGames hiveModuleGooglePlayGames, final Function1 function1, final Intent intent) {
        LoggerImpl.INSTANCE.d("[GooglePlayGames] showLeaderboards - successful");
        final int iGeneratorRequestCode = hiveModuleGooglePlayGames.generatorRequestCode();
        HiveActivity.registerHiveActivityLifecycleListeners(new OnActivityLifecycle() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$showLeaderboards$1$1$1
            @Override // com.hive.ui.OnActivityLifecycle
            public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                LoggerImpl.INSTANCE.d("[GooglePlayGames] showLeaderboards - onActivityResult : \nrequestCode: " + requestCode + "\nresultCode: " + resultCode + "\nintent: " + intent);
                if (requestCode != iGeneratorRequestCode) {
                    super.onActivityResult(activity, requestCode, resultCode, data);
                    return;
                }
                if (hiveModuleGooglePlayGames.isGamesActivityResultErrorCode(resultCode)) {
                    Function1<ResultAPI, Unit> function12 = function1;
                    if (function12 != null) {
                        function12.invoke(new ResultAPI(-9, ResultAPI.Code.AuthV4GoogleLogout));
                    }
                } else {
                    Function1<ResultAPI, Unit> function13 = function1;
                    if (function13 != null) {
                        function13.invoke(new ResultAPI(0, ResultAPI.Code.Success, String.valueOf(resultCode)));
                    }
                }
                HiveActivity.unregisterHiveActivityLifecycleListeners(this);
            }
        });
        Activity activity = hiveModuleGooglePlayGames.getActivity();
        Intrinsics.checkNotNull(intent);
        ExtentionsKt.startActivityForResultCatching$default(activity, intent, iGeneratorRequestCode, null, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showLeaderboards$lambda$33$lambda$32(HiveModuleGooglePlayGames hiveModuleGooglePlayGames, Function1 function1, Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        String gamesApiStatusMessage = hiveModuleGooglePlayGames.getGamesApiStatusMessage(exception);
        LoggerImpl.INSTANCE.w("[GooglePlayGames] showLeaderboards - failed : " + gamesApiStatusMessage);
        if (function1 != null) {
            function1.invoke(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailShowLeaderboards, gamesApiStatusMessage));
        }
    }

    private final JSONObject getProviderFromHiveConfig() {
        return ConfigurationImpl.INSTANCE.getProviderFromHiveConfig("googleplaygames");
    }

    private final int generatorRequestCode() {
        int iNextInt = new SecureRandom().nextInt(65500);
        return iNextInt < 0 ? -iNextInt : iNextInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getGamesApiStatusMessage(Task<?> task) {
        Exception exception = task.getException();
        ApiException apiException = exception instanceof ApiException ? (ApiException) exception : null;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(apiException != null ? apiException.getStatusCode() : -99);
        Intrinsics.checkNotNullExpressionValue(statusCodeString, "getStatusCodeString(...)");
        return statusCodeString;
    }

    private final String getGamesApiStatusMessage(Exception exception) {
        ApiException apiException = exception instanceof ApiException ? (ApiException) exception : null;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(apiException != null ? apiException.getStatusCode() : -99);
        Intrinsics.checkNotNullExpressionValue(statusCodeString, "getStatusCodeString(...)");
        return statusCodeString;
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Authv4_Google_Playgames(), "26.2.0");
        try {
            Result.Companion companion = Result.INSTANCE;
            Properties properties = new Properties();
            properties.load(HiveActivity.INSTANCE.getRecentActivity().getClassLoader().getResourceAsStream("play-services-games-v2.properties"));
            map.put(ModuleCheckName.INSTANCE.getPlay_Services_Gamesv2(), properties.getProperty("version"));
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object isAuthenticated(Continuation<? super Pair<Boolean, String>> continuation) {
        Object objM7415constructorimpl;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        LoggerImpl.INSTANCE.d("[GooglePlayGames] isAuthenticated()");
        Pair pairCheckInvalidSetup = checkInvalidSetup(false);
        if (((Boolean) pairCheckInvalidSetup.getFirst()).booleanValue()) {
            LoggerImpl.INSTANCE.w("[GooglePlayGames] isAuthenticated check setup : " + ((String) pairCheckInvalidSetup.getSecond()));
            if (cancellableContinuationImpl2.isActive()) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m7415constructorimpl(new Pair(Boxing.boxBoolean(false), pairCheckInvalidSetup.getSecond())));
            }
        } else {
            try {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(getGamesSignInClient().isAuthenticated().addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$isAuthenticated$2$1$1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task<AuthenticationResult> task) {
                        AuthenticationResult result;
                        Intrinsics.checkNotNullParameter(task, "task");
                        String gamesApiStatusMessage = this.this$0.getGamesApiStatusMessage((Task<?>) task);
                        if (task.isSuccessful() && (result = task.getResult()) != null && result.isAuthenticated()) {
                            LoggerImpl.INSTANCE.d("[GooglePlayGames] isAuthenticated - successful : " + gamesApiStatusMessage);
                            this.this$0.lastAuthenticated = true;
                            if (cancellableContinuationImpl2.isActive()) {
                                CancellableContinuation<Pair<Boolean, String>> cancellableContinuation = cancellableContinuationImpl2;
                                Result.Companion companion3 = Result.INSTANCE;
                                cancellableContinuation.resumeWith(Result.m7415constructorimpl(new Pair(true, gamesApiStatusMessage)));
                                return;
                            }
                            return;
                        }
                        LoggerImpl.INSTANCE.w("[GooglePlayGames] isAuthenticated - failed : " + gamesApiStatusMessage);
                        this.this$0.lastAuthenticated = false;
                        if (cancellableContinuationImpl2.isActive()) {
                            CancellableContinuation<Pair<Boolean, String>> cancellableContinuation2 = cancellableContinuationImpl2;
                            Result.Companion companion4 = Result.INSTANCE;
                            cancellableContinuation2.resumeWith(Result.m7415constructorimpl(new Pair(false, gamesApiStatusMessage)));
                        }
                    }
                }));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                LoggerImpl.INSTANCE.w("[GooglePlayGames] isAuthenticated - exception : " + thM7418exceptionOrNullimpl.getMessage());
                if (cancellableContinuationImpl2.isActive()) {
                    Result.Companion companion4 = Result.INSTANCE;
                    cancellableContinuationImpl2.resumeWith(Result.m7415constructorimpl(new Pair(Boxing.boxBoolean(false), thM7418exceptionOrNullimpl.getMessage())));
                }
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object signIn(Continuation<? super Pair<Boolean, String>> continuation) {
        Object objM7415constructorimpl;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        LoggerImpl.INSTANCE.d("[GooglePlayGames] signIn()");
        Pair pairCheckInvalidSetup = checkInvalidSetup(true);
        if (((Boolean) pairCheckInvalidSetup.getFirst()).booleanValue()) {
            LoggerImpl.INSTANCE.w("[GooglePlayGames] signIn check setup : " + ((String) pairCheckInvalidSetup.getSecond()));
            if (cancellableContinuationImpl2.isActive()) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m7415constructorimpl(new Pair(Boxing.boxBoolean(false), pairCheckInvalidSetup.getSecond())));
            }
        } else {
            try {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(getGamesSignInClient().signIn().addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$signIn$2$1$1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task<AuthenticationResult> task) {
                        AuthenticationResult result;
                        Intrinsics.checkNotNullParameter(task, "task");
                        String gamesApiStatusMessage = this.this$0.getGamesApiStatusMessage((Task<?>) task);
                        if (task.isSuccessful() && (result = task.getResult()) != null && result.isAuthenticated()) {
                            LoggerImpl.INSTANCE.d("[GooglePlayGames] signIn - successful : " + gamesApiStatusMessage);
                            this.this$0.lastAuthenticated = true;
                            if (cancellableContinuationImpl2.isActive()) {
                                CancellableContinuation<Pair<Boolean, String>> cancellableContinuation = cancellableContinuationImpl2;
                                Result.Companion companion3 = Result.INSTANCE;
                                cancellableContinuation.resumeWith(Result.m7415constructorimpl(new Pair(true, gamesApiStatusMessage)));
                                return;
                            }
                            return;
                        }
                        LoggerImpl.INSTANCE.w("[GooglePlayGames] signIn - failed : " + gamesApiStatusMessage);
                        this.this$0.lastAuthenticated = false;
                        if (cancellableContinuationImpl2.isActive()) {
                            CancellableContinuation<Pair<Boolean, String>> cancellableContinuation2 = cancellableContinuationImpl2;
                            Result.Companion companion4 = Result.INSTANCE;
                            cancellableContinuation2.resumeWith(Result.m7415constructorimpl(new Pair(false, gamesApiStatusMessage)));
                        }
                    }
                }));
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                LoggerImpl.INSTANCE.w("[GooglePlayGames] signIn - exception : " + thM7418exceptionOrNullimpl.getMessage());
                if (cancellableContinuationImpl2.isActive()) {
                    Result.Companion companion4 = Result.INSTANCE;
                    cancellableContinuationImpl2.resumeWith(Result.m7415constructorimpl(new Pair(Boxing.boxBoolean(false), thM7418exceptionOrNullimpl.getMessage())));
                }
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestServerSideAccess(Continuation<? super Pair<String, String>> continuation) {
        Object objM7415constructorimpl;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        LoggerImpl.INSTANCE.d("[GooglePlayGames] requestServerSideAccess()");
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(getGamesSignInClient().requestServerSideAccess(getPlayGamesServerClientId(), true).addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.module.googleplaygames.HiveModuleGooglePlayGames$requestServerSideAccess$2$1$1
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task<String> task) {
                    Intrinsics.checkNotNullParameter(task, "task");
                    String gamesApiStatusMessage = this.this$0.getGamesApiStatusMessage((Task<?>) task);
                    if (task.isSuccessful() && task.getResult() != null) {
                        String result = task.getResult();
                        LoggerImpl.INSTANCE.dL("[GooglePlayGames] requestServerSideAccess - successful : " + result);
                        LoggerImpl.INSTANCE.dR("[GooglePlayGames] requestServerSideAccess - successful");
                        if (cancellableContinuationImpl2.isActive()) {
                            CancellableContinuation<Pair<String, String>> cancellableContinuation = cancellableContinuationImpl2;
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m7415constructorimpl(new Pair(result, gamesApiStatusMessage)));
                            return;
                        }
                        return;
                    }
                    LoggerImpl.INSTANCE.w("[GooglePlayGames] requestServerSideAccess - failed : " + gamesApiStatusMessage);
                    if (cancellableContinuationImpl2.isActive()) {
                        CancellableContinuation<Pair<String, String>> cancellableContinuation2 = cancellableContinuationImpl2;
                        Result.Companion companion3 = Result.INSTANCE;
                        cancellableContinuation2.resumeWith(Result.m7415constructorimpl(new Pair(null, gamesApiStatusMessage)));
                    }
                }
            }));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[GooglePlayGames] requestServerSideAccess - exception : " + thM7418exceptionOrNullimpl.getMessage());
            if (cancellableContinuationImpl2.isActive()) {
                Result.Companion companion3 = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m7415constructorimpl(new Pair(null, thM7418exceptionOrNullimpl.getMessage())));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
