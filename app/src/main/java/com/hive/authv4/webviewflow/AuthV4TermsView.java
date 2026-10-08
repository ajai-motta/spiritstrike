package com.hive.authv4.webviewflow;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.hive.AuthV4;
import com.hive.authv4.webviewflow.AuthV4WebView;
import com.hive.core.ExtentionsKt;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.logger.LoggerImpl;
import com.hive.ui.ExtensionsKt;
import com.hive.ui.Resource;
import com.hive.ui.view.HiveAnimationButton;
import com.hive.webview.HiveSchemeHandler;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4TermsView;", "Lcom/hive/authv4/webviewflow/AuthV4WebView;", "activity", "Landroid/app/Activity;", "url", "", "onPostWebViewListener", "Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lcom/hive/authv4/webviewflow/AuthV4WebView$AuthV4WebViewListener;)V", "createWebView", "", "webViewClient", "Lcom/hive/core/webview/HiveWebViewClient;", "AuthV4TermsSchemeHandler", "AuthV4TermsWebViewCallback", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AuthV4TermsView extends AuthV4WebView {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4TermsView$AuthV4TermsSchemeHandler;", "Lcom/hive/webview/HiveSchemeHandler;", "<init>", "(Lcom/hive/authv4/webviewflow/AuthV4TermsView;)V", "schemeEvent", "", "view", "Landroid/webkit/WebView;", "scheme", "Lcom/hive/core/Scheme;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AuthV4TermsSchemeHandler extends HiveSchemeHandler {
        public AuthV4TermsSchemeHandler() {
        }

        @Override // com.hive.webview.HiveSchemeHandler
        public boolean schemeEvent(WebView view, Scheme scheme) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            LoggerImpl.INSTANCE.d(AuthV4.getTAG(), "[AuthV4TermsSchemeHandler] \nschemeEvent: " + scheme + '\n');
            AuthV4TermsView authV4TermsView = AuthV4TermsView.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                if (Intrinsics.areEqual(Uri.parse(authV4TermsView.getUrl()).getHost(), scheme.getHost())) {
                    return false;
                }
                if (view instanceof HiveWebView) {
                    ((HiveWebView) view).blacklistDomain(false);
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(scheme.getUrl()));
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching$default(authV4TermsView.getActivity(), intent, null, 2, null);
                return true;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7415constructorimpl(ResultKt.createFailure(th));
                return super.schemeEvent(view, scheme);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/hive/authv4/webviewflow/AuthV4TermsView$AuthV4TermsWebViewCallback;", "Lcom/hive/authv4/webviewflow/AuthV4WebView$WebViewCallBack;", "Lcom/hive/authv4/webviewflow/AuthV4WebView;", "<init>", "(Lcom/hive/authv4/webviewflow/AuthV4TermsView;)V", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class AuthV4TermsWebViewCallback extends AuthV4WebView.WebViewCallBack {
        public AuthV4TermsWebViewCallback() {
            super(AuthV4TermsView.this, AuthV4TermsView.this.new AuthV4TermsSchemeHandler());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthV4TermsView(Activity activity, String url, AuthV4WebView.AuthV4WebViewListener onPostWebViewListener) {
        super(activity, url, "", "", "", AuthV4WebView.CloseButtonType.TYPE_THEME, onPostWebViewListener);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(onPostWebViewListener, "onPostWebViewListener");
    }

    @Override // com.hive.authv4.webviewflow.AuthV4WebView
    public void createWebView(HiveWebViewClient webViewClient) {
        View decorView;
        Intrinsics.checkNotNullParameter(webViewClient, "webViewClient");
        Activity activity = getActivity();
        Resource resource = Resource.INSTANCE;
        activity.setContentView(resource.getLayoutId(getActivity(), "hive_authv4_terms_dialog"));
        ColorDrawable colorDrawable = new ColorDrawable(-1);
        Window window = getActivity().getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setBackground(colorDrawable);
        }
        View viewFindViewById = getActivity().findViewById(resource.getViewId(getActivity(), "hive_authv4_webview"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        setWebView((HiveWebView) viewFindViewById);
        getWebView().setBackgroundColor(0);
        View viewFindViewById2 = getActivity().findViewById(resource.getViewId(getActivity(), "hive_authv4_webview_spinner"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
        setProgressBar((ProgressBar) viewFindViewById2);
        ProgressBar progressBar = getProgressBar();
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) getActivity().findViewById(resource.getViewId(getActivity(), "hive_authv4_close_button"));
        AuthV4WebView.CloseButtonType closeButtonType = getCloseButtonType();
        Intrinsics.checkNotNull(hiveAnimationButton);
        setButtonType(closeButtonType, hiveAnimationButton);
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.authv4.webviewflow.AuthV4TermsView.createWebView.1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                AuthV4TermsView.this.dismiss();
            }
        });
        ExtensionsKt.applyDisplayCutoutMargin(hiveAnimationButton);
        AuthV4WebView.setWebViewSettings$default(this, new AuthV4TermsWebViewCallback(), null, 2, null);
    }
}
