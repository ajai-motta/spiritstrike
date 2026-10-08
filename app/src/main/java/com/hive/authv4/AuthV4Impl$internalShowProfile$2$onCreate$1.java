package com.hive.authv4;

import android.app.Activity;
import android.os.Handler;
import com.hive.AuthV4;
import com.hive.ResultAPI;
import com.hive.authv4.webviewflow.AuthV4WebView;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J$\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/hive/authv4/AuthV4Impl$internalShowProfile$2$onCreate$1", "Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;", "onWebViewFinish", "", "select", "", "onReceivedError", "errorCode", "", "description", "failingUrl", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4Impl$internalShowProfile$2$onCreate$1 implements AuthV4WebView.AuthV4WebViewListener {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $fApiName;
    final /* synthetic */ AuthV4.AuthV4ShowProfileListener $listener;
    final /* synthetic */ AuthV4.PlayerInfo $playerInfo;
    final /* synthetic */ long $targetPlayerId;

    public AuthV4Impl$internalShowProfile$2$onCreate$1(AuthV4.PlayerInfo playerInfo, long j, Activity activity, String str, AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener) {
        this.$playerInfo = playerInfo;
        this.$targetPlayerId = j;
        this.$activity = activity;
        this.$fApiName = str;
        this.$listener = authV4ShowProfileListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReceivedError$lambda$1(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowProfileListener.onAuthV4ShowProfile(resultAPI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onWebViewFinish$lambda$0(String str, ResultAPI resultAPI, AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener) {
        LoggerImpl.INSTANCE.apiCallbackLog(AuthV4.getTAG(), str, resultAPI.toString());
        authV4ShowProfileListener.onAuthV4ShowProfile(resultAPI);
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
    public void onReceivedError(int errorCode, String description, String failingUrl) {
        String str = "[showProfile] webView Error : errorCode : " + errorCode + " decsription : " + description + " failingURL : " + failingUrl;
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.dL(AuthV4.getTAG(), str);
        loggerImpl.dR(AuthV4.getTAG(), "[showProfile] webView Error : errorCode : " + errorCode + " decsription : " + description + " failingURL");
        final ResultAPI resultAPI = new ResultAPI(-5, ResultAPI.Code.AuthV4WebviewDialogError, str);
        Handler handler = AuthV4Impl.mainLooperHandler;
        final String str2 = this.$fApiName;
        final AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener = this.$listener;
        handler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$internalShowProfile$2$onCreate$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AuthV4Impl$internalShowProfile$2$onCreate$1.onReceivedError$lambda$1(str2, resultAPI, authV4ShowProfileListener);
            }
        });
        this.$activity.finish();
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
    public void onWebViewFinish(String select) {
        String str = "[showProfile] webView finish: " + select;
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), str);
        if (this.$playerInfo.getPlayerId() == this.$targetPlayerId) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(this.$targetPlayerId));
            AuthV4Impl.INSTANCE.getProfile(arrayList, new AuthV4Impl$internalShowProfile$2$onCreate$1$onWebViewFinish$1(str, this.$fApiName, this.$listener));
        } else {
            final ResultAPI resultAPI = new ResultAPI(0, ResultAPI.Code.Success, str);
            Handler handler = AuthV4Impl.mainLooperHandler;
            final String str2 = this.$fApiName;
            final AuthV4.AuthV4ShowProfileListener authV4ShowProfileListener = this.$listener;
            handler.post(new Runnable() { // from class: com.hive.authv4.AuthV4Impl$internalShowProfile$2$onCreate$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AuthV4Impl$internalShowProfile$2$onCreate$1.onWebViewFinish$lambda$0(str2, resultAPI, authV4ShowProfileListener);
                }
            });
        }
        this.$activity.finish();
    }
}
