package com.hive.module.googlesignin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.hive.HiveActivity;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Configuration;
import com.hive.core.ExtentionsKt;
import com.hive.logger.LoggerImpl;
import com.hive.module.GoogleSignInModule;
import com.hive.module.ModuleCheckName;
import com.hive.module.googlesignin.HiveModuleGoogleSignIn;
import com.hive.module.interfaces.authv4.provider.ProviderGoogleSignIn;
import com.hive.ui.HiveUiActivity;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: HiveModuleGoogleSignIn.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0016H\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0018H\u0002J \u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010\t0 2\b\b\u0002\u0010!\u001a\u00020\u0013H\u0002J\n\u0010\"\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013H\u0016J\u0010\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013H\u0016JY\u0010'\u001a\u00020$2O\u0010(\u001aK\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020$0)H\u0016JY\u0010.\u001a\u00020$2O\u0010(\u001aK\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020$0)H\u0016JB\u0010/\u001a\u00020$28\u0010(\u001a4\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(,\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(-\u0012\u0004\u0012\u00020$00H\u0016J\b\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000204H\u0002J\u0014\u00105\u001a\u00020\t2\n\u00106\u001a\u0006\u0012\u0002\b\u000307H\u0002J\u0014\u00108\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t09H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/hive/module/googlesignin/HiveModuleGoogleSignIn;", "Lcom/hive/module/interfaces/authv4/provider/ProviderGoogleSignIn;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "keyGooglePlayAppId", "", "keyGoogleServerClientId", "googleAppId", "getGoogleAppId", "()Ljava/lang/String;", "googleAppId$delegate", "Lkotlin/Lazy;", "googleServerClientId", "getGoogleServerClientId", "requestOptionsEmail", "", "requestOptionsServerAuthCode", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "googleSignInAccount", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "getGoogleSignInOptions", "Lcom/google/android/gms/auth/api/signin/GoogleSignInOptions;", "getGoogleSignInClient", "createGoogleAccount", "Lcom/hive/module/GoogleSignInModule$GoogleAccount;", "account", "checkInvalidSetup", "Lkotlin/Pair;", "ui", "getCurrentAccount", "setRequestEmail", "", TypedValues.Custom.S_BOOLEAN, "setRequestServerAuthCode", "silentSignIn", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSuccessful", "failReason", "signIn", "signOut", "Lkotlin/Function2;", "getProviderFromHiveConfig", "Lorg/json/JSONObject;", "generatorRequestCode", "", "logTaskStatusCode", "task", "Lcom/google/android/gms/tasks/Task;", "getVersionInfo", "", "hive-authv4-provider-google-signin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveModuleGoogleSignIn implements ProviderGoogleSignIn {
    private final Context context;

    /* JADX INFO: renamed from: googleAppId$delegate, reason: from kotlin metadata */
    private final Lazy googleAppId;
    private GoogleSignInAccount googleSignInAccount;
    private GoogleSignInClient googleSignInClient;
    private final String keyGooglePlayAppId;
    private final String keyGoogleServerClientId;
    private boolean requestOptionsEmail;
    private boolean requestOptionsServerAuthCode;

    public HiveModuleGoogleSignIn(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.keyGooglePlayAppId = "@playAppId";
        this.keyGoogleServerClientId = "@serverClientId";
        this.googleAppId = LazyKt.lazy(new Function0() { // from class: com.hive.module.googlesignin.HiveModuleGoogleSignIn$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HiveModuleGoogleSignIn.googleAppId_delegate$lambda$0(this.f$0);
            }
        });
        this.requestOptionsEmail = true;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.hive.module.interfaces.authv4.provider.ProviderGoogleSignIn, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return ProviderGoogleSignIn.DefaultImpls.getHiveModuleName(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String googleAppId_delegate$lambda$0(HiveModuleGoogleSignIn hiveModuleGoogleSignIn) {
        return hiveModuleGoogleSignIn.getProviderFromHiveConfig().optString(hiveModuleGoogleSignIn.keyGooglePlayAppId, "");
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

    private final GoogleSignInOptions getGoogleSignInOptions() {
        GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN);
        builder.requestId();
        builder.requestProfile();
        if (this.requestOptionsEmail) {
            builder.requestEmail();
        }
        builder.requestIdToken(getGoogleServerClientId());
        if (this.requestOptionsServerAuthCode) {
            builder.requestServerAuthCode(getGoogleServerClientId());
        }
        GoogleSignInOptions googleSignInOptionsBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(googleSignInOptionsBuild, "build(...)");
        return googleSignInOptionsBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GoogleSignInClient getGoogleSignInClient() {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            GoogleSignInClient client = this.googleSignInClient;
            if (client == null) {
                client = GoogleSignIn.getClient(this.context, getGoogleSignInOptions());
                Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
            }
            objM7415constructorimpl = Result.m7415constructorimpl(client);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[GoogleSignIn] Create GoogleSignInClient Exception : " + thM7418exceptionOrNullimpl);
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = null;
        }
        GoogleSignInClient googleSignInClient = (GoogleSignInClient) objM7415constructorimpl;
        this.googleSignInClient = googleSignInClient;
        return googleSignInClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GoogleSignInModule.GoogleAccount createGoogleAccount(final GoogleSignInAccount account) {
        return account != null ? new GoogleSignInModule.GoogleAccount(account) { // from class: com.hive.module.googlesignin.HiveModuleGoogleSignIn$createGoogleAccount$1$1
            private final String displayName;
            private final String email;
            private final String openId;
            private final String openIdToken;
            private final String photoUrl;
            private final String serverAuthCode;

            {
                this.openId = account.getId();
                this.openIdToken = account.getIdToken();
                this.displayName = account.getDisplayName();
                Uri photoUrl = account.getPhotoUrl();
                this.photoUrl = photoUrl != null ? photoUrl.toString() : null;
                this.email = account.getEmail();
                this.serverAuthCode = account.getServerAuthCode();
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

            @Override // com.hive.module.GoogleSignInModule.GoogleAccount
            public String getServerAuthCode() {
                return this.serverAuthCode;
            }

            public String toString() {
                return "[GoogleAccount] : \n    openId: " + getOpenId() + "\n    openIdToken: " + getOpenIdToken() + "\n    displayName: " + getDisplayName() + "\n    photoUrl: " + getPhotoUrl() + "\n    email: " + getEmail() + "\n    serverAuthCode: " + getServerAuthCode() + '\n';
            }
        } : null;
    }

    static /* synthetic */ Pair checkInvalidSetup$default(HiveModuleGoogleSignIn hiveModuleGoogleSignIn, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return hiveModuleGoogleSignIn.checkInvalidSetup(z);
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
        return createGoogleAccount(this.googleSignInAccount);
    }

    @Override // com.hive.module.GoogleSignInModule
    public void setRequestEmail(boolean z) {
        LoggerImpl.INSTANCE.d("[GoogleSignIn] setRequestEmail(): " + z);
        this.requestOptionsEmail = z;
    }

    @Override // com.hive.module.GoogleSignInModule
    public void setRequestServerAuthCode(boolean z) {
        LoggerImpl.INSTANCE.d("[GoogleSignIn] setRequestServerAuthCode(): " + z);
        this.requestOptionsServerAuthCode = z;
    }

    @Override // com.hive.module.GoogleSignInModule
    public void silentSignIn(final Function3<? super Boolean, ? super String, ? super GoogleSignInModule.GoogleAccount, Unit> listener) {
        Task<GoogleSignInAccount> taskSilentSignIn;
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[GoogleSignIn] silentSignIn()");
        Pair pairCheckInvalidSetup$default = checkInvalidSetup$default(this, false, 1, null);
        if (((Boolean) pairCheckInvalidSetup$default.getFirst()).booleanValue()) {
            LoggerImpl.INSTANCE.w("[GoogleSignIn] silentSignIn check setup : " + ((String) pairCheckInvalidSetup$default.getSecond()));
            listener.invoke(false, pairCheckInvalidSetup$default.getSecond(), null);
            return;
        }
        GoogleSignInClient googleSignInClient = getGoogleSignInClient();
        if (googleSignInClient == null || (taskSilentSignIn = googleSignInClient.silentSignIn()) == null || taskSilentSignIn.addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.module.googlesignin.HiveModuleGoogleSignIn$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                HiveModuleGoogleSignIn.silentSignIn$lambda$9(this.f$0, listener, task);
            }
        }) == null) {
            LoggerImpl.INSTANCE.w("[GoogleSignIn] silentSignIn - failed : GoogleSignInClient Exception.");
            this.googleSignInAccount = null;
            listener.invoke(false, "GoogleSignInClient Exception.", null);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void silentSignIn$lambda$9(HiveModuleGoogleSignIn hiveModuleGoogleSignIn, Function3 function3, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        String strLogTaskStatusCode = hiveModuleGoogleSignIn.logTaskStatusCode(task);
        if (task.isSuccessful() && task.getResult() != null) {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) task.getResult();
            LoggerImpl.INSTANCE.d("[GoogleSignIn] silentSignIn - successful : " + strLogTaskStatusCode);
            function3.invoke(true, strLogTaskStatusCode, hiveModuleGoogleSignIn.createGoogleAccount(googleSignInAccount));
            hiveModuleGoogleSignIn.googleSignInAccount = googleSignInAccount;
            return;
        }
        LoggerImpl.INSTANCE.w("[GoogleSignIn] silentSignIn - failed : " + strLogTaskStatusCode);
        hiveModuleGoogleSignIn.googleSignInAccount = null;
        function3.invoke(false, strLogTaskStatusCode, null);
    }

    @Override // com.hive.module.GoogleSignInModule
    public void signIn(Function3<? super Boolean, ? super String, ? super GoogleSignInModule.GoogleAccount, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[GoogleSignIn] signIn()");
        Pair<Boolean, String> pairCheckInvalidSetup = checkInvalidSetup(true);
        if (pairCheckInvalidSetup.getFirst().booleanValue()) {
            LoggerImpl.INSTANCE.w("[GoogleSignIn] signIn check setup : " + pairCheckInvalidSetup.getSecond());
            listener.invoke(false, pairCheckInvalidSetup.getSecond(), null);
            return;
        }
        HiveUiActivity.INSTANCE.launch(this.context, new AnonymousClass1(listener));
    }

    /* JADX INFO: renamed from: com.hive.module.googlesignin.HiveModuleGoogleSignIn$signIn$1, reason: invalid class name */
    /* JADX INFO: compiled from: HiveModuleGoogleSignIn.kt */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J*\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0012"}, d2 = {"com/hive/module/googlesignin/HiveModuleGoogleSignIn$signIn$1", "Lcom/hive/ui/OnActivityLifecycle;", "generatedRequestCode", "", "getGeneratedRequestCode", "()I", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "hive-authv4-provider-google-signin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 extends OnActivityLifecycle {
        final /* synthetic */ Function3<Boolean, String, GoogleSignInModule.GoogleAccount, Unit> $listener;
        private final int generatedRequestCode;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function3<? super Boolean, ? super String, ? super GoogleSignInModule.GoogleAccount, Unit> function3) {
            this.$listener = function3;
            this.generatedRequestCode = HiveModuleGoogleSignIn.this.generatorRequestCode();
        }

        public final int getGeneratedRequestCode() {
            return this.generatedRequestCode;
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onCreate(Activity activity, Bundle savedInstanceState) {
            Intent signInIntent;
            Intrinsics.checkNotNullParameter(activity, "activity");
            super.onCreate(activity, savedInstanceState);
            GoogleSignInClient googleSignInClient = HiveModuleGoogleSignIn.this.getGoogleSignInClient();
            if (googleSignInClient != null && (signInIntent = googleSignInClient.getSignInIntent()) != null) {
                ExtentionsKt.startActivityForResultCatching$default(activity, signInIntent, this.generatedRequestCode, null, 4, null);
                return;
            }
            HiveModuleGoogleSignIn hiveModuleGoogleSignIn = HiveModuleGoogleSignIn.this;
            Function3<Boolean, String, GoogleSignInModule.GoogleAccount, Unit> function3 = this.$listener;
            LoggerImpl.INSTANCE.w("[GoogleSignIn] signIn - failed : GoogleSignInClient signInIntent Exception.");
            hiveModuleGoogleSignIn.googleSignInAccount = null;
            function3.invoke(false, "GoogleSignInClient signInIntent Exception.", null);
            activity.finish();
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onActivityResult(final Activity activity, int requestCode, int resultCode, Intent data) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (requestCode == this.generatedRequestCode) {
                Task<GoogleSignInAccount> signedInAccountFromIntent = GoogleSignIn.getSignedInAccountFromIntent(data);
                final HiveModuleGoogleSignIn hiveModuleGoogleSignIn = HiveModuleGoogleSignIn.this;
                final Function3<Boolean, String, GoogleSignInModule.GoogleAccount, Unit> function3 = this.$listener;
                Intrinsics.checkNotNull(signedInAccountFromIntent.addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.module.googlesignin.HiveModuleGoogleSignIn$signIn$1$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        HiveModuleGoogleSignIn.AnonymousClass1.onActivityResult$lambda$3(hiveModuleGoogleSignIn, function3, activity, task);
                    }
                }));
                return;
            }
            super.onActivityResult(activity, requestCode, resultCode, data);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onActivityResult$lambda$3(HiveModuleGoogleSignIn hiveModuleGoogleSignIn, Function3 function3, Activity activity, Task task) {
            Intrinsics.checkNotNullParameter(task, "task");
            String strLogTaskStatusCode = hiveModuleGoogleSignIn.logTaskStatusCode(task);
            if (task.isSuccessful() && task.getResult() != null) {
                LoggerImpl.INSTANCE.d("[GoogleSignIn] signIn - successful : " + strLogTaskStatusCode);
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) task.getResult();
                function3.invoke(true, strLogTaskStatusCode, hiveModuleGoogleSignIn.createGoogleAccount(googleSignInAccount));
                hiveModuleGoogleSignIn.googleSignInAccount = googleSignInAccount;
            } else {
                LoggerImpl.INSTANCE.d("[GoogleSignIn] signIn - failed : " + strLogTaskStatusCode);
                hiveModuleGoogleSignIn.googleSignInAccount = null;
                function3.invoke(false, strLogTaskStatusCode, null);
            }
            activity.finish();
        }

        @Override // com.hive.ui.OnActivityLifecycle
        public void onDestroy(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (getIsCalledFinish() || getIsRecreated()) {
                return;
            }
            LoggerImpl.INSTANCE.w("[GoogleSignIn] signIn - failed : GoogleSignIn Activity Destroyed.");
            HiveModuleGoogleSignIn.this.googleSignInAccount = null;
            this.$listener.invoke(false, "GoogleSignIn Activity Destroyed.", null);
        }
    }

    @Override // com.hive.module.GoogleSignInModule
    public void signOut(final Function2<? super Boolean, ? super String, Unit> listener) {
        Task<Void> taskSignOut;
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.i("[GoogleSignIn] signOut()");
        Pair pairCheckInvalidSetup$default = checkInvalidSetup$default(this, false, 1, null);
        if (((Boolean) pairCheckInvalidSetup$default.getFirst()).booleanValue()) {
            LoggerImpl.INSTANCE.w("[GoogleSignIn] signOut check setup : " + ((String) pairCheckInvalidSetup$default.getSecond()));
            listener.invoke(false, pairCheckInvalidSetup$default.getSecond());
            return;
        }
        GoogleSignInClient googleSignInClient = getGoogleSignInClient();
        if (googleSignInClient == null || (taskSignOut = googleSignInClient.signOut()) == null || taskSignOut.addOnCompleteListener(new OnCompleteListener() { // from class: com.hive.module.googlesignin.HiveModuleGoogleSignIn$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                HiveModuleGoogleSignIn.signOut$lambda$11(this.f$0, listener, task);
            }
        }) == null) {
            LoggerImpl.INSTANCE.w("[GoogleSignIn] signOut - failed : GoogleSignInClient Exception.");
            this.googleSignInAccount = null;
            listener.invoke(false, "GoogleSignInClient Exception.");
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void signOut$lambda$11(HiveModuleGoogleSignIn hiveModuleGoogleSignIn, Function2 function2, Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        String strLogTaskStatusCode = hiveModuleGoogleSignIn.logTaskStatusCode(task);
        if (task.isSuccessful()) {
            LoggerImpl.INSTANCE.d("[GoogleSignIn] signOut - successful : " + strLogTaskStatusCode);
            hiveModuleGoogleSignIn.googleSignInAccount = null;
            function2.invoke(true, hiveModuleGoogleSignIn.logTaskStatusCode(task));
            return;
        }
        LoggerImpl.INSTANCE.d("[GoogleSignIn] signOut - failed : " + strLogTaskStatusCode);
        function2.invoke(false, hiveModuleGoogleSignIn.logTaskStatusCode(task));
    }

    private final JSONObject getProviderFromHiveConfig() {
        return ConfigurationImpl.INSTANCE.getProviderFromHiveConfig("google");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int generatorRequestCode() {
        int iNextInt = new SecureRandom().nextInt(65500);
        return iNextInt < 0 ? -iNextInt : iNextInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String logTaskStatusCode(Task<?> task) {
        Exception exception = task.getException();
        ApiException apiException = exception instanceof ApiException ? (ApiException) exception : null;
        String statusCodeString = CommonStatusCodes.getStatusCodeString(apiException != null ? apiException.getStatusCode() : task.isSuccessful() ? 0 : -99);
        Intrinsics.checkNotNullExpressionValue(statusCodeString, "getStatusCodeString(...)");
        return statusCodeString;
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Authv4_Google_Signin(), "26.2.0");
        try {
            Result.Companion companion = Result.INSTANCE;
            Properties properties = new Properties();
            properties.load(HiveActivity.INSTANCE.getRecentActivity().getClassLoader().getResourceAsStream("play-services-auth.properties"));
            map.put(ModuleCheckName.INSTANCE.getPlay_Services_Auth(), properties.getProperty("version"));
            Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        return map;
    }
}
