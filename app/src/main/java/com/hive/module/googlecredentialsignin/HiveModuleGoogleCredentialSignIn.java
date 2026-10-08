package com.hive.module.googlecredentialsignin;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.CredentialManager;
import androidx.credentials.CustomCredential;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialException;
import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.hive.HiveActivity;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Configuration;
import com.hive.logger.LoggerImpl;
import com.hive.module.GoogleSignInModule;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.authv4.provider.ProviderGoogleCredentialSignIn;
import com.hive.ui.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: compiled from: HiveModuleGoogleCredentialSignIn.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\"H\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010#\u001a\u00020\u0013H\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\u0018H\u0002J \u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\t0(2\b\b\u0002\u0010)\u001a\u00020\u0013H\u0002J\n\u0010*\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0013H\u0016J\u0010\u0010.\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0013H\u0016JY\u0010/\u001a\u00020,2O\u00100\u001aK\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020,01H\u0016JY\u00106\u001a\u00020,2O\u00100\u001aK\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020,01H\u0016Ja\u00107\u001a\u00020,2\u0006\u0010#\u001a\u00020\u00132O\u00100\u001aK\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020,01H\u0002Jc\u00108\u001a\u00020,2\b\u00109\u001a\u0004\u0018\u00010:2O\u00100\u001aK\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020,01H\u0002JB\u0010;\u001a\u00020,28\u00100\u001a4\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020,0<H\u0016J\b\u0010=\u001a\u00020,H\u0002J\b\u0010>\u001a\u00020?H\u0002J\u0014\u0010@\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0AH\u0016J\u0012\u0010B\u001a\u0004\u0018\u00010?2\u0006\u0010C\u001a\u00020\tH\u0002J\b\u0010D\u001a\u00020\tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001e\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/hive/module/googlecredentialsignin/HiveModuleGoogleCredentialSignIn;", "Lcom/hive/module/interfaces/authv4/provider/ProviderGoogleCredentialSignIn;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "keyGooglePlayAppId", "", "keyGoogleServerClientId", "googleAppId", "getGoogleAppId", "()Ljava/lang/String;", "googleAppId$delegate", "Lkotlin/Lazy;", "googleServerClientId", "getGoogleServerClientId", "requestOptionsEmail", "", "requestOptionsServerAuthCode", "getCredentialRequest", "Landroidx/credentials/GetCredentialRequest;", "googleIdTokenCredential", "Lcom/google/android/libraries/identity/googleid/GoogleIdTokenCredential;", "credentialManager", "Landroidx/credentials/CredentialManager;", "getCredentialManager", "()Landroidx/credentials/CredentialManager;", "credentialManager$delegate", "generatedNonce", "getGoogleIdOption", "Lcom/google/android/libraries/identity/googleid/GetGoogleIdOption;", "getSignInWithGoogleOption", "Lcom/google/android/libraries/identity/googleid/GetSignInWithGoogleOption;", "useSilentSignIn", "createGoogleAccount", "Lcom/hive/module/GoogleSignInModule$GoogleAccount;", "account", "checkInvalidSetup", "Lkotlin/Pair;", "ui", "getCurrentAccount", "setRequestEmail", "", TypedValues.Custom.S_BOOLEAN, "setRequestServerAuthCode", "silentSignIn", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccessful", "failReason", "signIn", "processSignInRequest", "processSignInResult", "result", "Landroidx/credentials/GetCredentialResponse;", "signOut", "Lkotlin/Function2;", "resetGoogleObject", "getProviderFromHiveConfig", "Lorg/json/JSONObject;", "getVersionInfo", "", "decodeIdToken", "idToken", "generateRandomBase64String", "hive-authv4-provider-google-credential-signin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveModuleGoogleCredentialSignIn implements ProviderGoogleCredentialSignIn {
    private final Context context;

    /* JADX INFO: renamed from: credentialManager$delegate, reason: from kotlin metadata */
    private final Lazy credentialManager;
    private String generatedNonce;
    private GetCredentialRequest getCredentialRequest;

    /* JADX INFO: renamed from: googleAppId$delegate, reason: from kotlin metadata */
    private final Lazy googleAppId;
    private GoogleIdTokenCredential googleIdTokenCredential;
    private final String keyGooglePlayAppId;
    private final String keyGoogleServerClientId;
    private boolean requestOptionsEmail;
    private boolean requestOptionsServerAuthCode;

    public HiveModuleGoogleCredentialSignIn(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.keyGooglePlayAppId = "@playAppId";
        this.keyGoogleServerClientId = "@serverClientId";
        this.googleAppId = LazyKt.lazy(new Function0() { // from class: com.hive.module.googlecredentialsignin.HiveModuleGoogleCredentialSignIn$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HiveModuleGoogleCredentialSignIn.googleAppId_delegate$lambda$0(this.f$0);
            }
        });
        this.requestOptionsEmail = true;
        this.credentialManager = LazyKt.lazy(new Function0() { // from class: com.hive.module.googlecredentialsignin.HiveModuleGoogleCredentialSignIn$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HiveModuleGoogleCredentialSignIn.credentialManager_delegate$lambda$3();
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGoogleCredentialSignIn, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return ProviderGoogleCredentialSignIn.DefaultImpls.getHiveModuleName(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String googleAppId_delegate$lambda$0(HiveModuleGoogleCredentialSignIn hiveModuleGoogleCredentialSignIn) {
        return hiveModuleGoogleCredentialSignIn.getProviderFromHiveConfig().optString(hiveModuleGoogleCredentialSignIn.keyGooglePlayAppId, "");
    }

    @Override // com.hive.module.GoogleSignInModule
    public String getGoogleAppId() {
        Object value = this.googleAppId.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (String) value;
    }

    @Override // com.hive.module.GoogleSignInModule
    public String getGoogleServerClientId() {
        String googleServerClientId = Configuration.INSTANCE.getGoogleServerClientId();
        if (!(!StringsKt.isBlank(googleServerClientId))) {
            googleServerClientId = null;
        }
        if (googleServerClientId != null) {
            return googleServerClientId;
        }
        String strOptString = getProviderFromHiveConfig().optString(this.keyGoogleServerClientId, "");
        Intrinsics.checkNotNull(strOptString);
        String str = StringsKt.isBlank(strOptString) ^ true ? strOptString : null;
        if (str != null) {
            return str;
        }
        String string = Resource.INSTANCE.getString("google_server_client_id");
        return string == null ? "" : string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CredentialManager getCredentialManager() {
        return (CredentialManager) this.credentialManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CredentialManager credentialManager_delegate$lambda$3() {
        return CredentialManager.INSTANCE.create(HiveActivity.INSTANCE.getRecentActivity());
    }

    private final GetGoogleIdOption getGoogleIdOption() {
        GetGoogleIdOption.Builder autoSelectEnabled = new GetGoogleIdOption.Builder().setFilterByAuthorizedAccounts(true).setServerClientId(getGoogleServerClientId()).setAutoSelectEnabled(true);
        String str = this.generatedNonce;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("generatedNonce");
            str = null;
        }
        return autoSelectEnabled.setNonce(str).build();
    }

    private final GetSignInWithGoogleOption getSignInWithGoogleOption() {
        String googleServerClientId = getGoogleServerClientId();
        String str = this.generatedNonce;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("generatedNonce");
            str = null;
        }
        return new GetSignInWithGoogleOption(googleServerClientId, null, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GetCredentialRequest getCredentialRequest(boolean useSilentSignIn) {
        Object objM7415constructorimpl;
        GetCredentialRequest getCredentialRequestBuild;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.generatedNonce = generateRandomBase64String();
            if (useSilentSignIn) {
                getCredentialRequestBuild = new GetCredentialRequest.Builder().addCredentialOption(getGoogleIdOption()).build();
            } else {
                getCredentialRequestBuild = new GetCredentialRequest.Builder().addCredentialOption(getSignInWithGoogleOption()).build();
            }
            objM7415constructorimpl = Result.m7415constructorimpl(getCredentialRequestBuild);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[GoogleCredentialSignIn] Create GetCredentialRequest Exception : " + thM7418exceptionOrNullimpl);
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = null;
        }
        GetCredentialRequest getCredentialRequest = (GetCredentialRequest) objM7415constructorimpl;
        this.getCredentialRequest = getCredentialRequest;
        return getCredentialRequest;
    }

    private final GoogleSignInModule.GoogleAccount createGoogleAccount(final GoogleIdTokenCredential account) {
        if (account == null) {
            return null;
        }
        final JSONObject jSONObjectDecodeIdToken = decodeIdToken(account.getZzb());
        String str = this.generatedNonce;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("generatedNonce");
            str = null;
        }
        if (Intrinsics.areEqual(str, jSONObjectDecodeIdToken != null ? jSONObjectDecodeIdToken.optString("nonce") : null)) {
            LoggerImpl.INSTANCE.d("[GoogleCredentialSignIn] createGoogleAccount, nonce match verification success");
        }
        return new GoogleSignInModule.GoogleAccount(jSONObjectDecodeIdToken, account) { // from class: com.hive.module.googlecredentialsignin.HiveModuleGoogleCredentialSignIn$createGoogleAccount$1$1
            private final String displayName;
            private final String email;
            private final String openId;
            private final String openIdToken;
            private final String photoUrl;
            private final Void serverAuthCode;

            {
                this.openId = jSONObjectDecodeIdToken != null ? jSONObjectDecodeIdToken.optString(AuthenticationTokenClaims.JSON_KEY_SUB) : null;
                this.openIdToken = account.getZzb();
                this.displayName = account.getZzc();
                this.photoUrl = String.valueOf(account.getZzf());
                this.email = jSONObjectDecodeIdToken != null ? jSONObjectDecodeIdToken.optString("email") : null;
            }

            @Override // com.hive.module.GoogleSignInModule.GoogleAccount
            public /* bridge */ /* synthetic */ String getServerAuthCode() {
                return (String) getServerAuthCode();
            }

            @Override // com.hive.module.GoogleSignInModule.GoogleAccount
            public String getOpenId() {
                return this.openId;
            }

            @Override // com.hive.module.GoogleSignInModule.GoogleAccount
            public String getOpenIdToken() {
                return this.openIdToken;
            }

            @Override // com.hive.module.GoogleSignInModule.GoogleAccount
            public String getDisplayName() {
                return this.displayName;
            }

            @Override // com.hive.module.GoogleSignInModule.GoogleAccount
            public String getPhotoUrl() {
                return this.photoUrl;
            }

            @Override // com.hive.module.GoogleSignInModule.GoogleAccount
            public String getEmail() {
                return this.email;
            }

            public Void getServerAuthCode() {
                return this.serverAuthCode;
            }

            public String toString() {
                return "[GoogleAccount] : \n    openId: " + getOpenId() + "\n    openIdToken : " + getOpenIdToken() + "\n    displayName : " + getDisplayName() + "\n    photoUrl : " + getPhotoUrl() + "\n    email : " + getEmail() + "\n    serverAuthCode : " + getServerAuthCode() + '\n';
            }
        };
    }

    static /* synthetic */ Pair checkInvalidSetup$default(HiveModuleGoogleCredentialSignIn hiveModuleGoogleCredentialSignIn, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return hiveModuleGoogleCredentialSignIn.checkInvalidSetup(z);
    }

    private final Pair<Boolean, String> checkInvalidSetup(boolean ui) {
        if (!Android.isGooglePlayServicesAvailable$default(Android.INSTANCE, ui ? HiveActivity.INSTANCE.getRecentActivity() : this.context, ui, 0, 4, null)) {
            return new Pair<>(true, "Google Play Services not available.");
        }
        if (StringsKt.isBlank(getGoogleServerClientId())) {
            return new Pair<>(true, "Provisional key does not exist.");
        }
        return new Pair<>(false, null);
    }

    @Override // com.hive.module.GoogleSignInModule
    public GoogleSignInModule.GoogleAccount getCurrentAccount() {
        return createGoogleAccount(this.googleIdTokenCredential);
    }

    @Override // com.hive.module.GoogleSignInModule
    public void setRequestEmail(boolean z) {
        LoggerImpl.INSTANCE.d("[GoogleCredentialSignIn] setRequestEmail(): " + z);
        this.requestOptionsEmail = z;
    }

    @Override // com.hive.module.GoogleSignInModule
    public void setRequestServerAuthCode(boolean z) {
        LoggerImpl.INSTANCE.d("[GoogleCredentialSignIn] setRequestServerAuthCode(): " + z);
        this.requestOptionsServerAuthCode = z;
    }

    @Override // com.hive.module.GoogleSignInModule
    public void silentSignIn(Function3<? super Boolean, ? super String, ? super GoogleSignInModule.GoogleAccount, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[GoogleCredentialSignIn] silentSignIn()");
        processSignInRequest(true, listener);
    }

    @Override // com.hive.module.GoogleSignInModule
    public void signIn(Function3<? super Boolean, ? super String, ? super GoogleSignInModule.GoogleAccount, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[GoogleCredentialSignIn] signIn()");
        processSignInRequest(false, listener);
    }

    private final void processSignInRequest(boolean useSilentSignIn, Function3<? super Boolean, ? super String, ? super GoogleSignInModule.GoogleAccount, Unit> listener) {
        Pair<Boolean, String> pairCheckInvalidSetup = checkInvalidSetup(true);
        if (pairCheckInvalidSetup.getFirst().booleanValue()) {
            LoggerImpl.INSTANCE.w("[GoogleCredentialSignIn] processSignInRequest check setup : " + pairCheckInvalidSetup.getSecond());
            listener.invoke(false, pairCheckInvalidSetup.getSecond(), null);
            return;
        }
        GoogleSignInModule.GoogleAccount currentAccount = getCurrentAccount();
        if (currentAccount == null) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AnonymousClass2(useSilentSignIn, listener, null), 3, null);
        } else {
            LoggerImpl.INSTANCE.i("[GoogleCredentialSignIn] processSignInRequest, Google SignIn connection(googleIdTokenCredential) already exist, return current account");
            listener.invoke(true, "googleIdTokenCredential already exist, return current account", currentAccount);
        }
    }

    /* JADX INFO: renamed from: com.hive.module.googlecredentialsignin.HiveModuleGoogleCredentialSignIn$processSignInRequest$2, reason: invalid class name */
    /* JADX INFO: compiled from: HiveModuleGoogleCredentialSignIn.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.module.googlecredentialsignin.HiveModuleGoogleCredentialSignIn$processSignInRequest$2", f = "HiveModuleGoogleCredentialSignIn.kt", i = {0}, l = {227}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<Boolean, String, GoogleSignInModule.GoogleAccount, Unit> $listener;
        final /* synthetic */ boolean $useSilentSignIn;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(boolean z, Function3<? super Boolean, ? super String, ? super GoogleSignInModule.GoogleAccount, Unit> function3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$useSilentSignIn = z;
            this.$listener = function3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = HiveModuleGoogleCredentialSignIn.this.new AnonymousClass2(this.$useSilentSignIn, this.$listener, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            HiveModuleGoogleCredentialSignIn hiveModuleGoogleCredentialSignIn;
            Function3<Boolean, String, GoogleSignInModule.GoogleAccount, Unit> function3;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
            } catch (GetCredentialException e) {
                String str = "GetCredentialException(" + ((Object) e.getErrorMessage()) + ')';
                LoggerImpl.INSTANCE.w("[GoogleCredentialSignIn] processSignInRequest - failed : " + str);
                HiveModuleGoogleCredentialSignIn.this.googleIdTokenCredential = null;
                this.$listener.invoke(Boxing.boxBoolean(false), str, null);
            } catch (Exception e2) {
                String str2 = "Exception(" + e2 + ')';
                LoggerImpl.INSTANCE.w("[GoogleCredentialSignIn] processSignInRequest - failed : " + str2);
                HiveModuleGoogleCredentialSignIn.this.googleIdTokenCredential = null;
                this.$listener.invoke(Boxing.boxBoolean(false), str2, null);
            }
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                GetCredentialRequest credentialRequest = HiveModuleGoogleCredentialSignIn.this.getCredentialRequest(this.$useSilentSignIn);
                if (credentialRequest != null) {
                    HiveModuleGoogleCredentialSignIn hiveModuleGoogleCredentialSignIn2 = HiveModuleGoogleCredentialSignIn.this;
                    Function3<Boolean, String, GoogleSignInModule.GoogleAccount, Unit> function32 = this.$listener;
                    CredentialManager credentialManager = hiveModuleGoogleCredentialSignIn2.getCredentialManager();
                    Activity recentActivity = HiveActivity.INSTANCE.getRecentActivity();
                    this.L$0 = coroutineScope;
                    this.L$1 = hiveModuleGoogleCredentialSignIn2;
                    this.L$2 = function32;
                    this.label = 1;
                    obj = credentialManager.getCredential(recentActivity, credentialRequest, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    hiveModuleGoogleCredentialSignIn = hiveModuleGoogleCredentialSignIn2;
                    function3 = function32;
                } else {
                    HiveModuleGoogleCredentialSignIn hiveModuleGoogleCredentialSignIn3 = HiveModuleGoogleCredentialSignIn.this;
                    Function3<Boolean, String, GoogleSignInModule.GoogleAccount, Unit> function33 = this.$listener;
                    LoggerImpl.INSTANCE.w("[GoogleCredentialSignIn] processSignInRequest - failed : GetCredentialRequest is null");
                    hiveModuleGoogleCredentialSignIn3.googleIdTokenCredential = null;
                    function33.invoke(Boxing.boxBoolean(false), "GetCredentialRequest is null", null);
                    return Unit.INSTANCE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function3 = (Function3) this.L$2;
                hiveModuleGoogleCredentialSignIn = (HiveModuleGoogleCredentialSignIn) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            hiveModuleGoogleCredentialSignIn.processSignInResult((GetCredentialResponse) obj, function3);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processSignInResult(GetCredentialResponse result, Function3<? super Boolean, ? super String, ? super GoogleSignInModule.GoogleAccount, Unit> listener) {
        if (result != null) {
            if (result.getCredential() instanceof CustomCredential) {
                if (Intrinsics.areEqual(result.getCredential().getType(), GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL)) {
                    LoggerImpl.INSTANCE.d("[GoogleCredentialSignIn] processSignInResult - successful");
                    this.googleIdTokenCredential = GoogleIdTokenCredential.INSTANCE.createFrom(result.getCredential().getData());
                    listener.invoke(true, "SignIn Success", createGoogleAccount(this.googleIdTokenCredential));
                    return;
                } else {
                    LoggerImpl.INSTANCE.w("[GoogleCredentialSignIn] processSignInResult - failed : GetCredentialResponse.result.credential.type is not TYPE_GOOGLE_ID_TOKEN_CREDENTIAL");
                    this.googleIdTokenCredential = null;
                    listener.invoke(false, "GetCredentialResponse.result.credential.type is not TYPE_GOOGLE_ID_TOKEN_CREDENTIAL", null);
                    return;
                }
            }
            LoggerImpl.INSTANCE.w("[GoogleCredentialSignIn] processSignInResult - failed : GetCredentialResponse.result.credential not in case");
            this.googleIdTokenCredential = null;
            listener.invoke(false, "GetCredentialResponse.result.credential not in case", null);
            return;
        }
        LoggerImpl.INSTANCE.w("[GoogleCredentialSignIn] processSignInResult - failed : GetCredentialResponse.result is null");
        this.googleIdTokenCredential = null;
        listener.invoke(false, "GetCredentialResponse.result is null", null);
    }

    @Override // com.hive.module.GoogleSignInModule
    public void signOut(Function2<? super Boolean, ? super String, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[GoogleCredentialSignIn] signOut()");
        Pair pairCheckInvalidSetup$default = checkInvalidSetup$default(this, false, 1, null);
        if (!((Boolean) pairCheckInvalidSetup$default.getFirst()).booleanValue()) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(listener, null), 3, null);
            return;
        }
        LoggerImpl.INSTANCE.w("[GoogleCredentialSignIn] signOut check setup : " + ((String) pairCheckInvalidSetup$default.getSecond()));
        listener.invoke(false, pairCheckInvalidSetup$default.getSecond());
    }

    /* JADX INFO: renamed from: com.hive.module.googlecredentialsignin.HiveModuleGoogleCredentialSignIn$signOut$1, reason: invalid class name */
    /* JADX INFO: compiled from: HiveModuleGoogleCredentialSignIn.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.hive.module.googlecredentialsignin.HiveModuleGoogleCredentialSignIn$signOut$1", f = "HiveModuleGoogleCredentialSignIn.kt", i = {}, l = {304}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Boolean, String, Unit> $listener;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super Boolean, ? super String, Unit> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$listener = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HiveModuleGoogleCredentialSignIn.this.new AnonymousClass1(this.$listener, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (HiveModuleGoogleCredentialSignIn.this.getCredentialManager().clearCredentialState(new ClearCredentialStateRequest(), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                HiveModuleGoogleCredentialSignIn.this.resetGoogleObject();
                LoggerImpl.INSTANCE.d("[GoogleCredentialSignIn] signOut - successful");
                this.$listener.invoke(Boxing.boxBoolean(true), "SignOut Success");
            } catch (Exception e) {
                LoggerImpl.INSTANCE.d("[GoogleCredentialSignIn] signOut exception (" + e + ')');
                this.$listener.invoke(Boxing.boxBoolean(false), "SignOut Failed (exception occurred)");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetGoogleObject() {
        this.getCredentialRequest = null;
        this.googleIdTokenCredential = null;
    }

    private final JSONObject getProviderFromHiveConfig() {
        return ConfigurationImpl.INSTANCE.getProviderFromHiveConfig("google");
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Authv4_Google_Credential_Signin(), "26.2.0");
        try {
            Result.Companion companion = Result.INSTANCE;
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            Unit unit = null;
            InputStream resourceAsStream = contextClassLoader != null ? contextClassLoader.getResourceAsStream("META-INF/androidx.credentials_credentials-play-services-auth.version") : null;
            if (resourceAsStream != null) {
                Reader inputStreamReader = new InputStreamReader(resourceAsStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                try {
                    map.put(ModuleCheckName.INSTANCE.getCredential_Play_Services_Auth(), bufferedReader.readLine());
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(bufferedReader, null);
                    unit = Unit.INSTANCE;
                } finally {
                }
            }
            Result.m7415constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return map;
    }

    private final JSONObject decodeIdToken(String idToken) {
        List listSplit$default = StringsKt.split$default((CharSequence) idToken, new String[]{"."}, false, 0, 6, (Object) null);
        if (listSplit$default.size() != 3) {
            return null;
        }
        byte[] bArrDecode = Base64.decode((String) listSplit$default.get(1), 10);
        Intrinsics.checkNotNull(bArrDecode);
        return new JSONObject(new String(bArrDecode, Charsets.UTF_8));
    }

    private final String generateRandomBase64String() {
        byte[] bArr = new byte[15];
        new SecureRandom().nextBytes(bArr);
        String strEncodeToString = Base64.encodeToString(bArr, 10);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return StringsKt.take(strEncodeToString, 20);
    }
}
