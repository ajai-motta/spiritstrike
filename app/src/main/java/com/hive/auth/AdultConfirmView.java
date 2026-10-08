package com.hive.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.auth.AuthDataInterface;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.CommonIdentifierKt;
import com.hive.core.HiveKeys;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.logger.LoggerImpl;
import com.hive.protocol.Protocol;
import com.hive.protocol.ProtocolRequest;
import com.hive.protocol.adultconfirm.AdultCheck;
import com.hive.service.databinding.HiveAuthv4AdultConfirmDialogBinding;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.view.HiveAnimationButton;
import com.hive.webview.HiveSchemeHandler;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\b\u0004*\u0001\"\u0018\u00002\u00020\u0001:\u0001$B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J \u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0017H\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010#¨\u0006%"}, d2 = {"Lcom/hive/auth/AdultConfirmView;", "", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/auth/AuthDataInterface$AuthAdultConfirmListener;", "(Landroid/app/Activity;Lcom/hive/auth/AuthDataInterface$AuthAdultConfirmListener;)V", "binding", "Lcom/hive/service/databinding/HiveAuthv4AdultConfirmDialogBinding;", "getBinding", "()Lcom/hive/service/databinding/HiveAuthv4AdultConfirmDialogBinding;", "setBinding", "(Lcom/hive/service/databinding/HiveAuthv4AdultConfirmDialogBinding;)V", "mWebView", "Lcom/hive/core/webview/HiveWebView;", "gobackButton", "Lcom/hive/ui/view/HiveAnimationButton;", "launchActivity", "result", "Lcom/hive/ResultAPI;", "queryParameterResult", "", "queryParameterResultMsg", "show", "", "dismiss", "createBaseView", "convertWebViewHGoBackBtn", "createWebView", "strURL", "postString", "schemeHandler", "com/hive/auth/AdultConfirmView$schemeHandler$1", "Lcom/hive/auth/AdultConfirmView$schemeHandler$1;", "WebViewCallBack", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AdultConfirmView {
    private final Activity activity;
    public HiveAuthv4AdultConfirmDialogBinding binding;
    private HiveAnimationButton gobackButton;
    private Activity launchActivity;
    private AuthDataInterface.AuthAdultConfirmListener listener;
    private HiveWebView mWebView;
    private String queryParameterResult;
    private String queryParameterResultMsg;
    private ResultAPI result;
    private final AdultConfirmView$schemeHandler$1 schemeHandler;

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\"\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J,\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u000fH\u0016J \u0010\u0019\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006#"}, d2 = {"Lcom/hive/auth/AdultConfirmView$WebViewCallBack;", "Lcom/hive/core/webview/HiveWebViewClient;", "context", "Landroid/content/Context;", "<init>", "(Lcom/hive/auth/AdultConfirmView;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "onLoadResource", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPageFinished", "receivedErrorEvent", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "request", "Landroid/webkit/WebResourceRequest;", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class WebViewCallBack extends HiveWebViewClient {
        private Context context;
        final /* synthetic */ AdultConfirmView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebViewCallBack(AdultConfirmView adultConfirmView, Context context) {
            super(adultConfirmView.schemeHandler);
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = adultConfirmView;
            this.context = context;
        }

        public final Context getContext() {
            return this.context;
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onLoadResource(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d("[AdultConfirm] onLoadResource url : " + url);
            super.onLoadResource(view, url);
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView view, String url) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            super.onPageFinished(view, url);
            LoggerImpl.INSTANCE.d("[AdultConfirm] onPageFinished url: " + url);
            this.this$0.convertWebViewHGoBackBtn();
            this.this$0.getBinding().hiveAdultConfirmWebviewSpinner.hide();
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(url, "url");
            LoggerImpl.INSTANCE.d(null, "[AdultConfirm] onPageStarted url : " + url);
            this.this$0.getBinding().hiveAdultConfirmWebviewSpinner.show();
            super.onPageStarted(view, url, favicon);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            if (request.isForMainFrame()) {
                LoggerImpl.INSTANCE.d("[AdultConfirm] onReceivedHttpError statusCode: " + errorResponse.getStatusCode() + ", failingUrl: " + request.getUrl());
                this.this$0.getBinding().hiveAdultConfirmWebviewSpinner.hide();
            }
            super.onReceivedHttpError(view, request, errorResponse);
        }

        @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(error, "error");
            LoggerImpl.INSTANCE.d("[AdultConfirm] onReceivedSslError errorCode: " + error.getPrimaryError() + ", failingUrl: " + error.getUrl());
            this.this$0.getBinding().hiveAdultConfirmWebviewSpinner.hide();
            super.onReceivedSslError(view, handler, error);
        }

        @Override // com.hive.core.webview.HiveWebViewClient
        public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
            Intrinsics.checkNotNullParameter(view, "view");
            LoggerImpl.INSTANCE.w("[AdultConfirm] receivedErrorEvent errorCode: " + errorCode + ", " + description + ", failingUrl: " + failingUrl);
            this.this$0.getBinding().hiveAdultConfirmWebviewSpinner.hide();
        }

        public final void setContext(Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.context = context;
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.hive.auth.AdultConfirmView$schemeHandler$1] */
    private AdultConfirmView(Activity activity) {
        this.activity = activity;
        this.result = new ResultAPI(-99, ResultAPI.Code.CommonUnknown, "");
        this.schemeHandler = new HiveSchemeHandler() { // from class: com.hive.auth.AdultConfirmView$schemeHandler$1
            @Override // com.hive.webview.HiveSchemeHandler
            public boolean schemeEvent(WebView view, Scheme scheme) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
                loggerImpl.d("[AdultConfirm] schemeEvent");
                try {
                    if (!Intrinsics.areEqual(scheme.getScheme(), "c2s") || !Intrinsics.areEqual(scheme.getHost(), "adultAuthResult")) {
                        return false;
                    }
                    this.this$0.queryParameterResult = scheme.getParameter().get("result");
                    this.this$0.queryParameterResultMsg = scheme.getParameter().get("result_msg");
                    StringBuilder sb = new StringBuilder("[AdultConfirm] queryParameterResult : ");
                    String str = this.this$0.queryParameterResult;
                    String str2 = AbstractJsonLexerKt.NULL;
                    if (str == null) {
                        str = AbstractJsonLexerKt.NULL;
                    }
                    sb.append(str);
                    loggerImpl.d(sb.toString());
                    StringBuilder sb2 = new StringBuilder("[AdultConfirm] queryParameterResultMsg : ");
                    String str3 = this.this$0.queryParameterResultMsg;
                    if (str3 != null) {
                        str2 = str3;
                    }
                    sb2.append(str2);
                    loggerImpl.d(sb2.toString());
                    this.this$0.dismiss();
                    return true;
                } catch (Exception e) {
                    LoggerImpl.INSTANCE.w("[AdultConfirm] schemeEvent error: " + e);
                    return false;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void convertWebViewHGoBackBtn() {
        final HiveWebView hiveWebView = this.mWebView;
        if (hiveWebView != null) {
            HiveAnimationButton hiveAnimationButton = null;
            if (hiveWebView.canGoBack()) {
                HiveAnimationButton hiveAnimationButton2 = this.gobackButton;
                if (hiveAnimationButton2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gobackButton");
                    hiveAnimationButton2 = null;
                }
                if (hiveAnimationButton2.getId() == getBinding().hiveAdultConfirmGobackDeactiveBtn.getId()) {
                    LoggerImpl.INSTANCE.i(null, "[AdultConfirm] convertWebViewHGoBackBtn, gobackButton set active");
                    HiveAnimationButton hiveAnimationButton3 = this.gobackButton;
                    if (hiveAnimationButton3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gobackButton");
                    } else {
                        hiveAnimationButton = hiveAnimationButton3;
                    }
                    hiveAnimationButton.setVisibility(4);
                    HiveAnimationButton hiveAdultConfirmGobackBtn = getBinding().hiveAdultConfirmGobackBtn;
                    Intrinsics.checkNotNullExpressionValue(hiveAdultConfirmGobackBtn, "hiveAdultConfirmGobackBtn");
                    hiveAdultConfirmGobackBtn.setVisibility(0);
                    hiveAdultConfirmGobackBtn.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.auth.AdultConfirmView$convertWebViewHGoBackBtn$1$1$1
                        @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
                        public void onClick() {
                            if (hiveWebView.canGoBack()) {
                                hiveWebView.goBack();
                            }
                        }
                    });
                    hiveAdultConfirmGobackBtn.setActionUpEventType(HiveAnimationButton.ActionUpAnimationType.USE_OFF_ANIMATION);
                    this.gobackButton = hiveAdultConfirmGobackBtn;
                    return;
                }
            }
            if (hiveWebView.canGoBack()) {
                return;
            }
            HiveAnimationButton hiveAnimationButton4 = this.gobackButton;
            if (hiveAnimationButton4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("gobackButton");
                hiveAnimationButton4 = null;
            }
            if (hiveAnimationButton4.getId() == getBinding().hiveAdultConfirmGobackBtn.getId()) {
                LoggerImpl.INSTANCE.i(null, "[AdultConfirm] convertWebViewHGoBackBtn, gobackButton set deactive");
                HiveAnimationButton hiveAnimationButton5 = this.gobackButton;
                if (hiveAnimationButton5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gobackButton");
                } else {
                    hiveAnimationButton = hiveAnimationButton5;
                }
                hiveAnimationButton.setVisibility(4);
                HiveAnimationButton hiveAdultConfirmGobackDeactiveBtn = getBinding().hiveAdultConfirmGobackDeactiveBtn;
                Intrinsics.checkNotNullExpressionValue(hiveAdultConfirmGobackDeactiveBtn, "hiveAdultConfirmGobackDeactiveBtn");
                hiveAdultConfirmGobackDeactiveBtn.setVisibility(0);
                this.gobackButton = hiveAdultConfirmGobackDeactiveBtn;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createBaseView() {
        getBinding().hiveAdultConfirmCloseBtn.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.auth.AdultConfirmView$createBaseView$1$1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                this.this$0.dismiss();
            }
        });
        HiveAnimationButton hiveAdultConfirmGobackDeactiveBtn = getBinding().hiveAdultConfirmGobackDeactiveBtn;
        Intrinsics.checkNotNullExpressionValue(hiveAdultConfirmGobackDeactiveBtn, "hiveAdultConfirmGobackDeactiveBtn");
        hiveAdultConfirmGobackDeactiveBtn.setActionUpEventType(HiveAnimationButton.ActionUpAnimationType.USE_OFF_ANIMATION);
        this.gobackButton = hiveAdultConfirmGobackDeactiveBtn;
        getBinding().hiveAdultConfirmWebviewSpinner.hide();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createWebView(Activity activity, String strURL, String postString) {
        byte[] bytes;
        HiveWebView hiveWebView = getBinding().hiveAdultConfirmWebview;
        hiveWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        hiveWebView.setInitialScale(0);
        hiveWebView.setPadding(0, 0, 0, 0);
        hiveWebView.getSettings().setLoadWithOverviewMode(true);
        hiveWebView.getSettings().setBuiltInZoomControls(true);
        hiveWebView.getSettings().setUseWideViewPort(true);
        hiveWebView.getSettings().setJavaScriptEnabled(true);
        hiveWebView.getSettings().setCacheMode(2);
        hiveWebView.setWebViewClient(new WebViewCallBack(this, activity));
        hiveWebView.setWebChromeClient(new AdultConfirmView$createWebView$1$1(activity));
        try {
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            bytes = postString.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        } catch (UnsupportedEncodingException e) {
            LoggerImpl.INSTANCE.w(null, "[AdultConfirm] showWebView error: " + e);
            bytes = null;
        }
        if (bytes != null) {
            hiveWebView.setOauthToken(HiveLifecycle.INSTANCE.getAccount().getOauthToken());
            hiveWebView.postUrl(strURL, bytes);
        } else {
            hiveWebView.loadUrl(strURL);
        }
        this.mWebView = hiveWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismiss$lambda$6(AdultConfirmView adultConfirmView) {
        if (TextUtils.equals("Y", adultConfirmView.queryParameterResult)) {
            LoggerImpl.INSTANCE.d(null, "[AdultConfirm] authorization success");
            if (TextUtils.isEmpty(adultConfirmView.queryParameterResultMsg)) {
                adultConfirmView.queryParameterResultMsg = "authorization success";
            }
            adultConfirmView.result = new ResultAPI(0, ResultAPI.Code.Success, adultConfirmView.queryParameterResultMsg);
        } else {
            LoggerImpl.INSTANCE.d(null, "[AdultConfirm] authorization failed");
            if (TextUtils.isEmpty(adultConfirmView.queryParameterResultMsg)) {
                adultConfirmView.queryParameterResultMsg = "user canceled";
            }
            adultConfirmView.result = new ResultAPI(-6, ResultAPI.Code.AuthUserCanceled, adultConfirmView.queryParameterResultMsg);
        }
        AuthDataInterface.AuthAdultConfirmListener authAdultConfirmListener = adultConfirmView.listener;
        if (authAdultConfirmListener != null) {
            authAdultConfirmListener.onAuthAdultConfirm(adultConfirmView.result);
        }
        adultConfirmView.queryParameterResult = null;
        adultConfirmView.queryParameterResultMsg = null;
        Activity activity = adultConfirmView.launchActivity;
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit show$lambda$5(final AdultConfirmView adultConfirmView, AdultCheck it) throws JSONException {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResponse().isSuccessYN()) {
            String adultCheckResult = it.getResponse().getAdultCheckResult();
            String adultCheckResultMsg = it.getResponse().getAdultCheckResultMsg();
            final String strOptString = it.getResponse().getContentJSONObject().optString("auth_url");
            if (adultCheckResult == null || StringsKt.isBlank(adultCheckResult)) {
                LoggerImpl.INSTANCE.w("[AdultConfirm] httpClientResponse error");
                adultConfirmView.result = new ResultAPI(-8, ResultAPI.Code.AuthInvalidServerResponse, "httpClientResponse error : responseResult is null");
            } else {
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String upperCase = adultCheckResult.toUpperCase(US);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                if (Intrinsics.areEqual(upperCase, "Y")) {
                    LoggerImpl.INSTANCE.d("[AdultConfirm] responseResult success");
                    final JSONObject jSONObjectPutCI = CommonIdentifierKt.putCI(new JSONObject());
                    try {
                        jSONObjectPutCI.put(HiveKeys.KEY_appid.getValue(), ConfigurationImpl.INSTANCE.getAppId());
                        String value = HiveKeys.KEY_vid_type.getValue();
                        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
                        jSONObjectPutCI.put(value, hiveLifecycle.getAccount().getVidType());
                        jSONObjectPutCI.put(HiveKeys.KEY_vid.getValue(), hiveLifecycle.getAccount().getVid());
                        jSONObjectPutCI.put(HiveKeys.KEY_uid.getValue(), hiveLifecycle.getAccount().getUid());
                        jSONObjectPutCI.put(HiveKeys.KEY_vid_sessionkey.getValue(), hiveLifecycle.getAccount().getVidSession());
                        jSONObjectPutCI.put(HiveKeys.KEY_uid_sessionkey.getValue(), hiveLifecycle.getAccount().getUidSession());
                        Intent intent = new Intent();
                        intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
                        HiveUiActivity.INSTANCE.launch(adultConfirmView.activity, intent, new OnActivityLifecycle() { // from class: com.hive.auth.AdultConfirmView$show$1$3
                            @Override // com.hive.ui.OnActivityLifecycle
                            public boolean onBackPressed() {
                                LoggerImpl.INSTANCE.d("[AdultConfirm] onBackPressed");
                                HiveWebView hiveWebView = this.this$0.mWebView;
                                if (hiveWebView == null) {
                                    return true;
                                }
                                AdultConfirmView adultConfirmView2 = this.this$0;
                                if (hiveWebView.canGoBack()) {
                                    hiveWebView.goBack();
                                    return true;
                                }
                                adultConfirmView2.dismiss();
                                return true;
                            }

                            @Override // com.hive.ui.OnActivityLifecycle
                            public void onCreate(Activity activity, Bundle savedInstanceState) {
                                Intrinsics.checkNotNullParameter(activity, "activity");
                                super.onCreate(activity, savedInstanceState);
                                LoggerImpl.INSTANCE.d("[AdultConfirm] create view");
                                this.this$0.launchActivity = activity;
                                this.this$0.setBinding(HiveAuthv4AdultConfirmDialogBinding.inflate(activity.getLayoutInflater()));
                                activity.setContentView(this.this$0.getBinding().getRoot());
                                this.this$0.createBaseView();
                                AdultConfirmView adultConfirmView2 = this.this$0;
                                String str = strOptString;
                                Intrinsics.checkNotNull(str);
                                String string = jSONObjectPutCI.toString();
                                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                adultConfirmView2.createWebView(activity, str, string);
                            }

                            @Override // com.hive.ui.OnActivityLifecycle
                            public void onDestroy(Activity activity) {
                                Intrinsics.checkNotNullParameter(activity, "activity");
                                if (!getIsCalledFinish()) {
                                    this.this$0.dismiss();
                                }
                                super.onDestroy(activity);
                            }
                        });
                    } catch (Exception e) {
                        LoggerImpl.INSTANCE.w(null, "[AdultConfirm] show - invalid user. (" + e + ')');
                        adultConfirmView.result = new ResultAPI(-9, ResultAPI.Code.AuthInvalidUser, "[AdultConfirm] invalid user.");
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AdultConfirmView$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                AdultConfirmView.show$lambda$5$lambda$2(this.f$0);
                            }
                        });
                        return Unit.INSTANCE;
                    }
                } else {
                    Intrinsics.checkNotNullExpressionValue(US, "US");
                    String upperCase2 = adultCheckResult.toUpperCase(US);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    if (Intrinsics.areEqual(upperCase2, "N")) {
                        LoggerImpl.INSTANCE.d(null, "[AdultConfirm] onRequestNetworkTaskListener skip");
                        adultConfirmView.result = new ResultAPI(0, ResultAPI.Code.Success, "adult confirm skip");
                    } else {
                        LoggerImpl.INSTANCE.w(null, "[AdultConfirm] onRequestNetworkTaskListener failed");
                        adultConfirmView.result = new ResultAPI(-8, ResultAPI.Code.AuthServerResponseNotSuccessful, adultCheckResultMsg);
                    }
                }
            }
        } else {
            LoggerImpl.INSTANCE.w(null, "[AdultConfirm] onRequestNetworkTaskListener network error");
            adultConfirmView.result = new ResultAPI(-5, ResultAPI.Code.AuthNetworkErrorRequestAdultConfirm, "[AdultConfirm] onRequestNetworkTaskListener network error");
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AdultConfirmView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                AdultConfirmView.show$lambda$5$lambda$4(this.f$0);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$5$lambda$2(AdultConfirmView adultConfirmView) {
        AuthDataInterface.AuthAdultConfirmListener authAdultConfirmListener = adultConfirmView.listener;
        if (authAdultConfirmListener != null) {
            authAdultConfirmListener.onAuthAdultConfirm(adultConfirmView.result);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$5$lambda$4(AdultConfirmView adultConfirmView) {
        AuthDataInterface.AuthAdultConfirmListener authAdultConfirmListener;
        if (adultConfirmView.result.getErrorCode() == -99 || (authAdultConfirmListener = adultConfirmView.listener) == null) {
            return;
        }
        authAdultConfirmListener.onAuthAdultConfirm(adultConfirmView.result);
    }

    public final void dismiss() {
        LoggerImpl.INSTANCE.d("[AdultConfirm] dismiss");
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.auth.AdultConfirmView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AdultConfirmView.dismiss$lambda$6(this.f$0);
            }
        });
    }

    public final HiveAuthv4AdultConfirmDialogBinding getBinding() {
        HiveAuthv4AdultConfirmDialogBinding hiveAuthv4AdultConfirmDialogBinding = this.binding;
        if (hiveAuthv4AdultConfirmDialogBinding != null) {
            return hiveAuthv4AdultConfirmDialogBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(HiveAuthv4AdultConfirmDialogBinding hiveAuthv4AdultConfirmDialogBinding) {
        Intrinsics.checkNotNullParameter(hiveAuthv4AdultConfirmDialogBinding, "<set-?>");
        this.binding = hiveAuthv4AdultConfirmDialogBinding;
    }

    public final void show() {
        Protocol.Companion companion = Protocol.INSTANCE;
        Protocol protocol = new Protocol(new Function0<AdultCheck>() { // from class: com.hive.auth.AdultConfirmView$show$$inlined$invoke$1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v3, types: [com.hive.protocol.ProtocolRequest, com.hive.protocol.adultconfirm.AdultCheck] */
            @Override // kotlin.jvm.functions.Function0
            public final AdultCheck invoke() throws IllegalAccessException, InstantiationException, InvocationTargetException {
                Object objNewInstance = AdultCheck.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(objNewInstance, "newInstance(...)");
                return (ProtocolRequest) objNewInstance;
            }
        });
        protocol.setParam(HiveKeys.KEY_api, "adult_auth_check");
        HiveKeys hiveKeys = HiveKeys.KEY_appid;
        ConfigurationImpl configurationImpl = ConfigurationImpl.INSTANCE;
        protocol.setParam(hiveKeys, configurationImpl.getAppId());
        HiveKeys hiveKeys2 = HiveKeys.KEY_appversion;
        Android android2 = Android.INSTANCE;
        protocol.setParam(hiveKeys2, android2.getAppVersion());
        protocol.setParam(HiveKeys.KEY_app_version_display, android2.getAppVersion());
        HiveKeys hiveKeys3 = HiveKeys.KEY_did;
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        protocol.setParam(hiveKeys3, hiveLifecycle.getDid());
        protocol.setParam(HiveKeys.KEY_country, android2.getCountry());
        protocol.setParam(HiveKeys.KEY_vid_type, hiveLifecycle.getAccount().getVidType());
        protocol.setParam(HiveKeys.KEY_vid, hiveLifecycle.getAccount().getVid());
        protocol.setParam(HiveKeys.KEY_uid, hiveLifecycle.getAccount().getUid());
        protocol.setParam(HiveKeys.KEY_vid_sessionkey, hiveLifecycle.getAccount().getVidSession());
        protocol.setParam(HiveKeys.KEY_uid_sessionkey, hiveLifecycle.getAccount().getUidSession());
        protocol.setParam(HiveKeys.KEY_world, configurationImpl.getServerId());
        protocol.request(new Function1() { // from class: com.hive.auth.AdultConfirmView$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AdultConfirmView.show$lambda$5(this.f$0, (AdultCheck) obj);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AdultConfirmView(Activity activity, AuthDataInterface.AuthAdultConfirmListener authAdultConfirmListener) {
        this(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        loggerImpl.d("[AdultConfirm] create");
        if (authAdultConfirmListener == null) {
            loggerImpl.w("[AdultConfirm] show - listener is null");
        } else {
            this.listener = authAdultConfirmListener;
        }
    }
}
