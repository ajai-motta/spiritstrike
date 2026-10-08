package com.hive.authv4;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.webviewflow.AuthV4WebView;
import com.hive.logger.LoggerImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/hive/authv4/AuthV4Impl$showSignIn$1$onCreate$1", "Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;", "onWebViewFinish", "", "select", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4Impl$showSignIn$1$onCreate$1 implements AuthV4WebView.AuthV4WebViewListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $fApiName;
    final /* synthetic */ AuthV4.AuthV4SignInListener $listener;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AuthV4.ProviderType.values().length];
            try {
                iArr[AuthV4.ProviderType.LINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AuthV4Impl$showSignIn$1$onCreate$1(String str, AuthV4.AuthV4SignInListener authV4SignInListener, Activity activity) {
        this.$fApiName = str;
        this.$listener = authV4SignInListener;
        this.$activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onWebViewFinish$lambda$0(AuthV4.ProviderType providerType, String str, AuthV4.AuthV4SignInListener authV4SignInListener) {
        AuthV4Impl.INSTANCE.signIn(providerType, str, authV4SignInListener);
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
    public void onReceivedError(int errorCode, String description, String failingUrl) {
        String str = "[showSignIn] webView Error : errorCode : " + errorCode + " decsription : " + description + " failingURL : " + failingUrl;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL(AuthV4.getTAG(), str);
        loggerImpl.dR(AuthV4.getTAG(), "[showSignIn] webView Error : errorCode : " + errorCode + " decsription : " + description);
        ResultAPI resultAPI = new ResultAPI(-5, ResultAPI.Code.AuthV4WebviewDialogError, str);
        loggerImpl.apiCallbackLog(AuthV4.getTAG(), this.$fApiName, resultAPI.toString());
        AuthV4Impl.INSTANCE.onSignInFinish(resultAPI, null, this.$fApiName, this.$listener);
        this.$activity.finish();
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
    public void onWebViewFinish(String select) {
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d(AuthV4.getTAG(), "showSignIn scheme: " + select);
        if (select == null || StringsKt.isBlank(select)) {
            loggerImpl.w(AuthV4.getTAG(), "[showSignIn] webView select error (canceled)");
            AuthV4Impl.INSTANCE.onSignInFinish(new ResultAPI(-6, ResultAPI.Code.AuthV4CancelDialog, "[showSignIn] webView select error (canceled)"), null, this.$fApiName, this.$listener);
        } else {
            try {
                Uri uri = Uri.parse(select);
                String queryParameter = uri.getQueryParameter("idp");
                if (queryParameter == null) {
                    throw new Exception("idp is null");
                }
                final String queryParameter2 = uri.getQueryParameter("t");
                final AuthV4.ProviderType providerType = AuthV4.ProviderType.INSTANCE.getProviderType(queryParameter);
                loggerImpl.d(AuthV4.getTAG(), "showSignIn providerType: " + providerType);
                int i = providerType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[providerType.ordinal()];
                if (i == -1) {
                    throw new Exception("provider type is null");
                }
                if (i != 1) {
                    AuthV4Impl.isInProgressSign = false;
                    AuthV4Impl.INSTANCE.signIn(providerType, queryParameter2, this.$listener);
                    Unit unit = Unit.INSTANCE;
                } else {
                    AuthV4Impl.isInProgressSign = false;
                    Handler handler = new Handler(Looper.getMainLooper());
                    final AuthV4.AuthV4SignInListener authV4SignInListener = this.$listener;
                    handler.postDelayed(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$showSignIn$1$onCreate$1$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            AuthV4Impl$showSignIn$1$onCreate$1.onWebViewFinish$lambda$0(providerType, queryParameter2, authV4SignInListener);
                        }
                    }, 500L);
                }
            } catch (Exception e) {
                String str = "[showSignIn] webView scheme parse error: " + select + " Exception: " + e;
                LoggerImpl.INSTANCE.w(AuthV4.getTAG(), str);
                AuthV4Impl.INSTANCE.onSignInFinish(new ResultAPI(-8, ResultAPI.Code.AuthV4NotSupportedProviderType, str), null, this.$fApiName, this.$listener);
                Unit unit2 = Unit.INSTANCE;
            }
        }
        this.$activity.finish();
    }
}
