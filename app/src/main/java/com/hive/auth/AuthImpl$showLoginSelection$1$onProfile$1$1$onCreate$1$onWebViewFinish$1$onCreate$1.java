package com.hive.auth;

import android.app.Activity;
import com.hive.ResultAPI;
import com.hive.SocialHive;
import com.hive.auth.AuthDataInterface;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/hive/auth/AuthImpl$showLoginSelection$1$onProfile$1$1$onCreate$1$onWebViewFinish$1$onCreate$1", "Lcom/hive/SocialHive$ShowHiveDialogDataListener;", "onShowHiveDialogWithData", "", "result", "Lcom/hive/ResultAPI;", "jsonData", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthImpl$showLoginSelection$1$onProfile$1$1$onCreate$1$onWebViewFinish$1$onCreate$1 implements SocialHive.ShowHiveDialogDataListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $fApiName;
    final /* synthetic */ AuthDataInterface.AuthLoginListener $listener;

    public AuthImpl$showLoginSelection$1$onProfile$1$1$onCreate$1$onWebViewFinish$1$onCreate$1(Activity activity, String str, AuthDataInterface.AuthLoginListener authLoginListener) {
        this.$activity = activity;
        this.$fApiName = str;
        this.$listener = authLoginListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onShowHiveDialogWithData$lambda$0(ResultAPI resultAPI, String str, AuthDataInterface.AuthLoginListener authLoginListener) {
        AuthImpl.INSTANCE.onLoginFinish(resultAPI, AuthDataInterface.LoginType.GUEST, null, null, str, authLoginListener);
        return Unit.INSTANCE;
    }

    @Override // com.hive.SocialHive.ShowHiveDialogDataListener
    public void onShowHiveDialogWithData(ResultAPI result, JSONObject jsonData) {
        Intrinsics.checkNotNullParameter(result, "result");
        LoggerImpl.INSTANCE.w(AuthDataInterface.getTAG(), "[selectLogin] webView select error (canceled)");
        AuthImpl authImpl = AuthImpl.INSTANCE;
        AuthImpl.loginType = AuthDataInterface.LoginType.AUTO;
        AuthImpl.isLoginInProgress = false;
        final ResultAPI resultAPI = new ResultAPI(-6, ResultAPI.Code.AuthCanceled, "[selectLogin] webView select error (canceled)");
        this.$activity.finish();
        AuthImpl authImpl2 = AuthImpl.INSTANCE;
        final String str = this.$fApiName;
        final AuthDataInterface.AuthLoginListener authLoginListener = this.$listener;
        authImpl2.disconnectGoogleProviderAfterLogout(new Function0() { // from class: com.hive.auth.AuthImpl$showLoginSelection$1$onProfile$1$1$onCreate$1$onWebViewFinish$1$onCreate$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AuthImpl$showLoginSelection$1$onProfile$1$1$onCreate$1$onWebViewFinish$1$onCreate$1.onShowHiveDialogWithData$lambda$0(resultAPI, str, authLoginListener);
            }
        });
    }
}
