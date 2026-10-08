package com.hive.socialv4.provider;

import androidx.core.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.SocialV4;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.authv4.provider.ProviderGooglePlayGames;
import com.hive.social.SocialKeys;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0015H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/hive/socialv4/provider/SocialV4ProviderGooglePlayGames;", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter;", "<init>", "()V", "googlePlayGames", "Lcom/hive/module/interfaces/authv4/provider/ProviderGooglePlayGames;", "getGooglePlayGames", "()Lcom/hive/module/interfaces/authv4/provider/ProviderGooglePlayGames;", "googlePlayGames$delegate", "Lkotlin/Lazy;", "getServiceName", "", "isConnected", "", "disconnect", "", "requestPlayerId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialV4RequestListener;", "isGamesV2", "handleSocialRequestUserTokenScheme", "Lcom/hive/socialv4/provider/SocialV4ProviderAdapter$SocialSchemeListener;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SocialV4ProviderGooglePlayGames extends SocialV4ProviderAdapter {
    public static final SocialV4ProviderGooglePlayGames INSTANCE = new SocialV4ProviderGooglePlayGames();

    /* JADX INFO: renamed from: googlePlayGames$delegate, reason: from kotlin metadata */
    private static final Lazy googlePlayGames = LazyKt.lazy(new Function0() { // from class: com.hive.socialv4.provider.SocialV4ProviderGooglePlayGames$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SocialV4ProviderGooglePlayGames.googlePlayGames_delegate$lambda$0();
        }
    });

    private SocialV4ProviderGooglePlayGames() {
        super(SocialV4.ProviderType.GOOGLE_PLAY_GAMES);
    }

    private final ProviderGooglePlayGames getGooglePlayGames() {
        return (ProviderGooglePlayGames) googlePlayGames.getValue();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit handleSocialRequestUserTokenScheme$lambda$5(SocialV4ProviderAdapter.SocialSchemeListener socialSchemeListener, String str, String str2) {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_SERVICE, INSTANCE.getServiceName());
            jSONObject.put("type", SocialKeys.PeppermintSocialRequestType.SOCIAL_REQUEST_USER_TOKEN);
            if (str != null) {
                jSONObject.put("token", str);
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, 0);
            } else {
                jSONObject.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, -9);
                LoggerImpl.INSTANCE.w("handleSocialRequestUserTokenScheme: " + str2);
            }
            objM7415constructorimpl = Result.m7415constructorimpl(jSONObject);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        JSONObject jSONObject2 = new JSONObject();
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = jSONObject2;
        }
        socialSchemeListener.onResult((JSONObject) objM7415constructorimpl);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPlayerId$lambda$2(SocialV4ProviderAdapter.SocialV4RequestListener socialV4RequestListener, String str, String str2) throws JSONException {
        if (str == null || StringsKt.isBlank(str)) {
            socialV4RequestListener.onComplete(new ResultAPI(-8, ResultAPI.Code.AuthV4GoogleResponseFailPGSGetPlayerId, str2), "");
        } else {
            ResultAPI resultAPI = new ResultAPI();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            Unit unit = Unit.INSTANCE;
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            socialV4RequestListener.onComplete(resultAPI, string);
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void disconnect() {
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public String getServiceName() {
        return "googlepgs";
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void handleSocialRequestUserTokenScheme(final SocialV4ProviderAdapter.SocialSchemeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ProviderGooglePlayGames googlePlayGames2 = getGooglePlayGames();
        if (googlePlayGames2 != null) {
            googlePlayGames2.signIn(new Function2() { // from class: com.hive.socialv4.provider.SocialV4ProviderGooglePlayGames$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialV4ProviderGooglePlayGames.handleSocialRequestUserTokenScheme$lambda$5(listener, (String) obj, (String) obj2);
                }
            });
        }
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public boolean isConnected() {
        ProviderGooglePlayGames googlePlayGames2 = getGooglePlayGames();
        if (googlePlayGames2 != null) {
            return googlePlayGames2.lastAuthenticated();
        }
        return false;
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public boolean isGamesV2() {
        return getGooglePlayGames() != null;
    }

    @Override // com.hive.socialv4.provider.SocialV4ProviderAdapter
    public void requestPlayerId(final SocialV4ProviderAdapter.SocialV4RequestListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ProviderGooglePlayGames googlePlayGames2 = getGooglePlayGames();
        if (googlePlayGames2 != null) {
            googlePlayGames2.signIn(new Function2() { // from class: com.hive.socialv4.provider.SocialV4ProviderGooglePlayGames$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SocialV4ProviderGooglePlayGames.requestPlayerId$lambda$2(listener, (String) obj, (String) obj2);
                }
            });
        }
    }
}
