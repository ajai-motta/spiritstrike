package com.hive.ui.common.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.Configuration;
import com.hive.core.OauthToken;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.core.webview.SchemeHandler;
import com.hive.ui.R;
import com.hive.ui.Resource;
import com.hive.ui.common.model.HiveFullscreenViewData;
import com.hive.ui.common.model.OnClosedListener;
import com.hive.ui.view.HiveAnimationButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HiveFullscreenView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/hive/ui/common/view/HiveFullscreenView;", "Lcom/hive/ui/common/view/HiveView;", "activity", "Landroid/app/Activity;", "data", "Lcom/hive/ui/common/model/HiveFullscreenViewData;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/ui/common/model/OnClosedListener;", "<init>", "(Landroid/app/Activity;Lcom/hive/ui/common/model/HiveFullscreenViewData;Lcom/hive/ui/common/model/OnClosedListener;)V", "url", "", "postData", "token", "Lcom/hive/core/OauthToken;", "schemeHandler", "Lcom/hive/core/webview/SchemeHandler;", "chromeClient", "Landroid/webkit/WebChromeClient;", "errorPageUrl", "closeButton", "Lcom/hive/ui/view/HiveAnimationButton;", "progressBar", "Landroid/widget/ProgressBar;", "mWebViewClient", "Lcom/hive/core/webview/HiveWebViewClient;", "mChromeClient", "onCreateView", "", "setCloseButtonColor", "white", "", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveFullscreenView extends HiveView {
    private final WebChromeClient chromeClient;
    private HiveAnimationButton closeButton;
    private final String errorPageUrl;
    private final OnClosedListener listener;
    private final WebChromeClient mChromeClient;
    private final HiveWebViewClient mWebViewClient;
    private final String postData;
    private ProgressBar progressBar;
    private final SchemeHandler schemeHandler;
    private final OauthToken token;
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveFullscreenView(Activity activity, HiveFullscreenViewData data, OnClosedListener onClosedListener) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        this.listener = onClosedListener;
        String url = data.getUrl();
        this.url = url;
        String postData = data.getPostData();
        this.postData = postData;
        OauthToken token = data.getToken();
        this.token = token;
        final SchemeHandler schemeHandler = data.getSchemeHandler();
        this.schemeHandler = schemeHandler;
        this.chromeClient = data.getChromeClient();
        this.errorPageUrl = "file:///android_res/raw/hive_error_embed.html";
        HiveWebViewClient hiveWebViewClient = new HiveWebViewClient(schemeHandler) { // from class: com.hive.ui.common.view.HiveFullscreenView$mWebViewClient$1
            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url2, Bitmap favicon) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                ProgressBar progressBar = this.this$0.progressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    progressBar = null;
                }
                progressBar.setVisibility(0);
                this.this$0.setCloseButtonColor(!StringsKt.startsWith$default(url2, r4.errorPageUrl, false, 2, (Object) null));
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url2) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                ProgressBar progressBar = this.this$0.progressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    progressBar = null;
                }
                progressBar.setVisibility(8);
            }

            @Override // com.hive.core.webview.HiveWebViewClient
            public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
                Intrinsics.checkNotNullParameter(view, "view");
                showErrorPage(view);
            }

            private final void showErrorPage(WebView view) {
                if (view != null) {
                    view.stopLoading();
                }
                String gameLanguage = Configuration.INSTANCE.getGameLanguage();
                if (view != null) {
                    view.loadUrl(this.this$0.errorPageUrl + "?lang=" + gameLanguage);
                }
                this.this$0.setCloseButtonColor(false);
            }
        };
        this.mWebViewClient = hiveWebViewClient;
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.hive.ui.common.view.HiveFullscreenView$mChromeClient$1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                ProgressBar progressBar = this.this$0.progressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressBar");
                    progressBar = null;
                }
                progressBar.setProgress(newProgress);
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                WebChromeClient webChromeClient2 = this.this$0.chromeClient;
                return webChromeClient2 != null ? webChromeClient2.onShowFileChooser(webView, filePathCallback, fileChooserParams) : super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
            }
        };
        this.mChromeClient = webChromeClient;
        initialize(activity, url, postData, token, hiveWebViewClient, webChromeClient);
    }

    @Override // com.hive.ui.common.view.HiveView
    public void onCreateView(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity activity2 = activity;
        View viewInflate = View.inflate(activity2, Resource.INSTANCE.getLayoutId(activity2, "hive_authv4_dialog"), this);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.hive.ui.common.view.HiveView");
        setMRoot((HiveView) viewInflate);
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(activity2, "hive_authv4_webview"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        setWebView((HiveWebView) viewFindViewById);
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) findViewById(Resource.INSTANCE.getViewId(activity2, "hive_authv4_close_button"));
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.ui.common.view.HiveFullscreenView$onCreateView$1$1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                OnClosedListener onClosedListener = this.this$0.listener;
                if (onClosedListener != null) {
                    onClosedListener.onClosed();
                }
            }
        });
        this.closeButton = hiveAnimationButton;
        setCloseButtonColor(true);
        View viewFindViewById2 = findViewById(Resource.INSTANCE.getViewId(activity2, "hive_authv4_webview_spinner"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
        this.progressBar = (ProgressBar) viewFindViewById2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setCloseButtonColor(boolean white) {
        HiveAnimationButton hiveAnimationButton = this.closeButton;
        if (hiveAnimationButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeButton");
            hiveAnimationButton = null;
        }
        hiveAnimationButton.setImageResource(R.drawable.hive_view_close_btn_down_to_up);
        hiveAnimationButton.setOffAnimationResourcesId(R.drawable.hive_view_close_btn_up_to_down);
        hiveAnimationButton.setOnAnimationResourcesId(R.drawable.hive_view_close_btn_down_to_up);
    }
}
