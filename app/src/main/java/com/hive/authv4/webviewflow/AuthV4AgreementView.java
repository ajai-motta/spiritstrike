package com.hive.authv4.webviewflow;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.hive.AuthV4;
import com.hive.HiveActivity;
import com.hive.ResultAPI;
import com.hive.auth.AuthDataInterface;
import com.hive.authv4.AuthV4Impl;
import com.hive.authv4.webviewflow.AuthV4WebView;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.ExtentionsKt;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.logger.LoggerImpl;
import com.hive.ui.Resource;
import com.hive.webview.HiveSchemeHandler;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.ads.adplayer.AndroidWebViewClient;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 '2\u00020\u0001:\u0005'()*+B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J\b\u0010!\u001a\u00020\u0011H\u0016J\r\u0010\"\u001a\u00020\u0011H\u0010¢\u0006\u0002\b#J\n\u0010$\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010%\u001a\u00020\u001dH\u0002J\b\u0010&\u001a\u00020\u001dH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082D¢\u0006\u0002\n\u0000R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4AgreementView;", "Lcom/hive/authv4/webviewflow/AuthV4WebView;", "activity", "Landroid/app/Activity;", "agreementList", "Ljava/util/ArrayList;", "Lcom/hive/authv4/AuthV4Impl$Agreement;", "Lkotlin/collections/ArrayList;", "agreementDialogListener", "Lcom/hive/authv4/webviewflow/AuthV4AgreementView$AuthV4AgreementDialogListener;", "<init>", "(Landroid/app/Activity;Ljava/util/ArrayList;Lcom/hive/authv4/webviewflow/AuthV4AgreementView$AuthV4AgreementDialogListener;)V", "mainHandler", "Landroid/os/Handler;", "backKeyHandler", "Lcom/hive/authv4/webviewflow/AuthV4AgreementView$BackKeyHandler;", "destroyParentActivity", "", "webViewTimeoutFlag", "webViewErrorFlag", "agreement_version", "", "agreedList", "currentAgreement", "agreementCount", "jsMessage", "", "backKeyText", "createWebView", "", "webViewClient", "Lcom/hive/core/webview/HiveWebViewClient;", "show", "onBackPressed", "internalBackPressed", "internalBackPressed$hive_service_release", "nextAgreement", "closeAgreement", "dismiss", k.M, "AuthV4AgreementDialogListener", "BackKeyHandler", "AgreementSchemeHandler", "AgreementWebViewCallback", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4AgreementView extends AuthV4WebView {
    private static boolean backKeyFlag;
    private final ArrayList<AuthV4Impl.Agreement> agreedList;
    private int agreementCount;
    private final ArrayList<AuthV4Impl.Agreement> agreementList;
    private final int agreement_version;
    private final BackKeyHandler backKeyHandler;
    private String backKeyText;
    private AuthV4Impl.Agreement currentAgreement;
    private boolean destroyParentActivity;
    private String jsMessage;
    private final Handler mainHandler;
    private boolean webViewErrorFlag;
    private boolean webViewTimeoutFlag;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4AgreementView$AgreementSchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "(Lcom/hive/authv4/webviewflow/AuthV4AgreementView;)V", "schemeEvent", "", "view", "Landroid/webkit/WebView;", "scheme", "Lcom/hive/core/Scheme;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AgreementSchemeHandler extends HiveSchemeHandler {
        public AgreementSchemeHandler() {
        }

        @Override // com.hive.webview.HiveSchemeHandler
        public boolean schemeEvent(WebView view, Scheme scheme) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL(AuthDataInterface.getTAG(), "[AuthV4AgreementDialog] \nschemeEvent url : " + scheme);
            loggerImpl.dR(AuthDataInterface.getTAG(), "[AuthV4AgreementDialog] \nschemeEvent");
            try {
                if (Intrinsics.areEqual(AuthV4AgreementView.this.getScheme(), scheme.getScheme()) && Intrinsics.areEqual(AuthV4AgreementView.this.getHost(), scheme.getHost())) {
                    AuthV4AgreementView.this.destroyParentActivity = false;
                    AuthV4Impl.Agreement agreement = AuthV4AgreementView.this.currentAgreement;
                    if (agreement != null) {
                        agreement.setScheme(scheme.getUrl());
                    }
                    AuthV4Impl.Agreement agreement2 = AuthV4AgreementView.this.currentAgreement;
                    if (agreement2 != null) {
                        agreement2.setParameter(scheme.getParameter());
                    }
                    AuthV4AgreementView.this.closeAgreement();
                    return true;
                }
                AuthV4AgreementView authV4AgreementView = AuthV4AgreementView.this;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    if (Intrinsics.areEqual(Uri.parse(authV4AgreementView.getUrl()).getHost(), scheme.getHost())) {
                        return false;
                    }
                    if (view instanceof HiveWebView) {
                        ((HiveWebView) view).blacklistDomain(false);
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(scheme.getUrl()));
                    intent.setFlags(268435456);
                    ExtentionsKt.startActivityCatching$default(authV4AgreementView.getActivity(), intent, null, 2, null);
                    return true;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return super.schemeEvent(view, scheme);
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J,\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J \u0010\u001e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\"\u0010\u0004\u001a\n0\u0005R\u00060\u0000R\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006$"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4AgreementView$AgreementWebViewCallback;", "Lcom/hive/core/webview/HiveWebViewClient;", "<init>", "(Lcom/hive/authv4/webviewflow/AuthV4AgreementView;)V", "localDataRunnable", "Lcom/hive/authv4/webviewflow/AuthV4AgreementView$AgreementWebViewCallback$LocalDataRunnable;", "Lcom/hive/authv4/webviewflow/AuthV4AgreementView;", "getLocalDataRunnable", "()Lcom/hive/authv4/webviewflow/AuthV4AgreementView$AgreementWebViewCallback$LocalDataRunnable;", "setLocalDataRunnable", "(Lcom/hive/authv4/webviewflow/AuthV4AgreementView$AgreementWebViewCallback$LocalDataRunnable;)V", "onPageStarted", "", "view", "Landroid/webkit/WebView;", "url", "", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "receivedErrorEvent", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "request", "Landroid/webkit/WebResourceRequest;", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "LocalDataRunnable", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AgreementWebViewCallback extends HiveWebViewClient {
        private LocalDataRunnable localDataRunnable;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4AgreementView$AgreementWebViewCallback$LocalDataRunnable;", "Ljava/lang/Runnable;", "<init>", "(Lcom/hive/authv4/webviewflow/AuthV4AgreementView$AgreementWebViewCallback;)V", "run", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public final class LocalDataRunnable implements Runnable {
            public LocalDataRunnable() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (AuthV4AgreementView.this.webViewTimeoutFlag || AuthV4AgreementView.this.webViewErrorFlag) {
                    ProgressBar progressBar = AuthV4AgreementView.this.getProgressBar();
                    if (progressBar != null) {
                        progressBar.setVisibility(8);
                    }
                    AuthV4AgreementView.this.destroyParentActivity = false;
                    AuthV4AgreementView.this.currentAgreement = null;
                    AuthV4AgreementView.this.closeAgreement();
                }
            }
        }

        public AgreementWebViewCallback() {
            super(AuthV4AgreementView.this.new AgreementSchemeHandler());
            this.localDataRunnable = new LocalDataRunnable();
        }

        public final LocalDataRunnable getLocalDataRunnable() {
            return this.localDataRunnable;
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL(AuthDataInterface.getTAG(), "[AuthV4AgreementDialog] \nonPageFinished url : " + url);
            loggerImpl.dR(AuthDataInterface.getTAG(), "[AuthV4AgreementDialog] \nonPageFinished");
            AuthV4AgreementView.this.webViewTimeoutFlag = false;
            AuthV4AgreementView.this.webViewErrorFlag = false;
            ProgressBar progressBar = AuthV4AgreementView.this.getProgressBar();
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            super.onPageFinished(view, url);
            if (TextUtils.equals(url, AndroidWebViewClient.BLANK_PAGE)) {
                loggerImpl.d(AuthV4.getTAG(), "[AuthV4AgreementDialog] url is blank. try local view.\n");
                AuthV4AgreementView.this.webViewErrorFlag = true;
                AuthV4AgreementView.this.mainHandler.postDelayed(this.localDataRunnable, 0L);
            }
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL(AuthDataInterface.getTAG(), "[AuthV4AgreementDialog] \nonPageStarted url : " + url);
            loggerImpl.dR(AuthDataInterface.getTAG(), "[AuthV4AgreementDialog] \nonPageStarted");
            ProgressBar progressBar = AuthV4AgreementView.this.getProgressBar();
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            AuthV4AgreementView.this.webViewTimeoutFlag = true;
            AuthV4AgreementView.this.mainHandler.postDelayed(this.localDataRunnable, 10000L);
            super.onPageStarted(view, url, favicon);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            if (!request.isForMainFrame()) {
                super.onReceivedHttpError(view, request, errorResponse);
                return;
            }
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.dL(AuthV4.getTAG(), "[AuthV4AgreementDialog] onReceivedHttpError url : " + request.getUrl());
            loggerImpl.d(AuthV4.getTAG(), "[AuthV4AgreementDialog] onReceivedHttpError errorResponse : " + errorResponse.getStatusCode());
            AuthV4AgreementView.this.webViewErrorFlag = true;
            AuthV4AgreementView.this.mainHandler.postDelayed(this.localDataRunnable, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(error, "error");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.w(AuthV4.getTAG(), "[AuthV4AgreementDialog] onReceivedSslError ErrorCode : " + error.getPrimaryError());
            loggerImpl.w(AuthV4.getTAG(), "[AuthV4AgreementDialog] onReceivedSslError Description : " + error);
            super.onReceivedSslError(view, handler, error);
            AuthV4AgreementView.this.webViewErrorFlag = true;
            AuthV4AgreementView.this.mainHandler.postDelayed(this.localDataRunnable, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }

        @Override // com.hive.core.webview.HiveWebViewClient
        public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
            loggerImpl.wL(AuthV4.getTAG(), "[AuthV4AgreementDialog] receivedErrorEvent url : " + failingUrl);
            loggerImpl.w(AuthV4.getTAG(), "[AuthV4AgreementDialog] receivedErrorEvent errorCode : " + errorCode);
            loggerImpl.w(AuthV4.getTAG(), "[AuthV4AgreementDialog] receivedErrorEvent description : " + description);
            AuthV4AgreementView.this.webViewErrorFlag = true;
            AuthV4AgreementView.this.mainHandler.postDelayed(this.localDataRunnable, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }

        public final void setLocalDataRunnable(LocalDataRunnable localDataRunnable) {
            Intrinsics.checkNotNullParameter(localDataRunnable, "<set-?>");
            this.localDataRunnable = localDataRunnable;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4AgreementView$AuthV4AgreementDialogListener;", "", "onAgreementFinish", "", "agreementList", "Ljava/util/ArrayList;", "Lcom/hive/authv4/AuthV4Impl$Agreement;", "Lkotlin/collections/ArrayList;", "strHwIds", "", "onAgreementDeny", "resultAPI", "Lcom/hive/ResultAPI;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface AuthV4AgreementDialogListener {
        void onAgreementDeny(ResultAPI resultAPI);

        void onAgreementFinish(ArrayList<AuthV4Impl.Agreement> agreementList, String strHwIds);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4AgreementView$BackKeyHandler;", "Landroid/os/Handler;", "<init>", "()V", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BackKeyHandler extends Handler {
        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            if (msg.what == 0) {
                AuthV4AgreementView.backKeyFlag = false;
            }
            super.handleMessage(msg);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthV4AgreementView(Activity activity, ArrayList<AuthV4Impl.Agreement> agreementList, final AuthV4AgreementDialogListener authV4AgreementDialogListener) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(agreementList, "agreementList");
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.backKeyHandler = new BackKeyHandler();
        this.destroyParentActivity = true;
        this.webViewTimeoutFlag = true;
        this.agreement_version = -1;
        this.agreementList = agreementList;
        this.agreedList = new ArrayList<>();
        this.jsMessage = "";
        this.backKeyText = "Back press again to exit.";
        backKeyFlag = false;
        String string = Resource.INSTANCE.getString("hive_useragree_dialog_backkey");
        this.backKeyText = string == null ? "Tap the Back Button again to exit." : string;
        this.currentAgreement = nextAgreement();
        setUrl("");
        setPostData(TextUtils.isEmpty(getPostData()) ? "" : getPostData());
        setScheme("c2s");
        setHost("activeuser");
        setCloseButtonType(AuthV4WebView.CloseButtonType.TYPE_NONE);
        setAuthV4WebViewDialogListener(new AuthV4WebView.AuthV4WebViewListener() { // from class: com.hive.authv4.webviewflow.AuthV4AgreementView.1
            @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
            public void onReceivedError(int errorCode, String description, String failingUrl) {
                if (authV4AgreementDialogListener != null) {
                    if (!ConfigurationImpl.INSTANCE.getExitEventEnabled()) {
                        authV4AgreementDialogListener.onAgreementFinish(this.agreedList, this.jsMessage);
                    } else if (this.destroyParentActivity) {
                        authV4AgreementDialogListener.onAgreementDeny(new ResultAPI(-17, ResultAPI.Code.AuthV4AgreementFailWithWebviewError_DoExit, ""));
                    } else {
                        authV4AgreementDialogListener.onAgreementFinish(this.agreedList, this.jsMessage);
                    }
                }
            }

            @Override // com.hive.authv4.webviewflow.AuthV4WebView.AuthV4WebViewListener
            public void onWebViewFinish(String scheme) {
                if (authV4AgreementDialogListener != null) {
                    if (!ConfigurationImpl.INSTANCE.getExitEventEnabled()) {
                        authV4AgreementDialogListener.onAgreementFinish(this.agreedList, this.jsMessage);
                    } else if (this.destroyParentActivity) {
                        authV4AgreementDialogListener.onAgreementDeny(new ResultAPI(-17, ResultAPI.Code.AuthV4AgreementFail_DoExit, ""));
                    } else {
                        authV4AgreementDialogListener.onAgreementFinish(this.agreedList, this.jsMessage);
                    }
                }
            }
        });
        createWebView(new AgreementWebViewCallback());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeAgreement() {
        if (this.destroyParentActivity) {
            dismiss();
            return;
        }
        AuthV4Impl.Agreement agreement = this.currentAgreement;
        if (agreement != null) {
            this.agreedList.add(agreement);
        }
        AuthV4Impl.Agreement agreementNextAgreement = nextAgreement();
        if (agreementNextAgreement != null) {
            this.destroyParentActivity = agreementNextAgreement.getVIEWMODE() == AuthV4Impl.Agreement.ViewMode.REQUIRE;
            String url = agreementNextAgreement.getUrl();
            if (url == null) {
                url = "";
            }
            setUrl(url);
            show();
        } else {
            dismiss();
        }
        this.currentAgreement = agreementNextAgreement;
    }

    private final AuthV4Impl.Agreement nextAgreement() {
        AuthV4Impl.Agreement agreement;
        int size;
        int i;
        LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4AgreementDialog] nextAgreement: " + this.agreementCount);
        try {
            size = this.agreementList.size();
            i = this.agreementCount;
        } catch (Exception e) {
            LoggerImpl.INSTANCE.w(AuthV4.getTAG(), "nextAgreement exception: " + e);
        }
        if (size > i) {
            ArrayList<AuthV4Impl.Agreement> arrayList = this.agreementList;
            this.agreementCount = i + 1;
            agreement = arrayList.get(i);
        } else {
            agreement = null;
        }
        LoggerImpl.INSTANCE.dL(AuthV4.getTAG(), "\n" + agreement);
        return agreement;
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView
    public void createWebView(HiveWebViewClient webViewClient) {
        View decorView;
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        super.createWebView(webViewClient);
        Window window = getActivity().getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setBackground(new ColorDrawable(0));
        }
        getWebView().addJavascriptInterface(new Object() { // from class: com.hive.authv4.webviewflow.AuthV4AgreementView.createWebView.1
            @JavascriptInterface
            public final void postMessage(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                loggerImpl.dL(AuthV4.getTAG(), "JS Interface : " + message);
                loggerImpl.dR(AuthV4.getTAG(), "JS Interface");
                AuthV4AgreementView.this.jsMessage = message;
            }
        }, "hiveInterface");
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView
    public void dismiss() {
        ProgressBar progressBar = getProgressBar();
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        if (getWebView().isShown()) {
            getWebView().stopLoading();
        }
        if (!this.destroyParentActivity) {
            super.dismiss();
            return;
        }
        super.dismiss();
        if (ConfigurationImpl.INSTANCE.getExitEventEnabled()) {
            return;
        }
        Android.INSTANCE.finish();
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView
    public boolean internalBackPressed$hive_service_release() {
        getWebView().loadUrl("javascript:backKeyPressed();");
        if (backKeyFlag) {
            dismiss();
            return true;
        }
        Toast.makeText(HiveActivity.INSTANCE.getRecentActivity(), this.backKeyText, 0).show();
        backKeyFlag = true;
        this.backKeyHandler.sendEmptyMessageDelayed(0, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        return true;
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView
    public boolean onBackPressed() {
        return internalBackPressed$hive_service_release();
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView
    public void show() {
        AuthV4Impl.Agreement agreement = this.currentAgreement;
        if (agreement == null) {
            this.destroyParentActivity = false;
            closeAgreement();
            return;
        }
        String url = agreement.getUrl();
        if (this.currentAgreement == null || !agreement.getShow() || url == null || !(!StringsKt.isBlank(url))) {
            this.destroyParentActivity = false;
            closeAgreement();
        } else {
            this.destroyParentActivity = agreement.getVIEWMODE() == AuthV4Impl.Agreement.ViewMode.REQUIRE;
            setUrl(url);
            super.show();
        }
    }
}
