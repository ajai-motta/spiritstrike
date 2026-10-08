package com.hive.promotion.ui.news;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hive.core.Configuration;
import com.hive.core.Logger;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.promotion.R;
import com.hive.promotion.ui.news.Navigation;
import com.hive.promotion.ui.news.NewsV2WebFragment;
import com.hive.standalone.HiveLifecycle;
import com.hive.webview.HiveSchemeHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: compiled from: NewsV2WebFragment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0017J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0016J\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u001dR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2WebFragment;", "Lcom/hive/promotion/ui/news/NewsV2Fragment;", "<init>", "()V", "menu", "Lcom/hive/promotion/ui/news/Navigation$Menu;", "basePostData", "Lorg/json/JSONObject;", "(Lcom/hive/promotion/ui/news/Navigation$Menu;Lorg/json/JSONObject;)V", "webView", "Lcom/hive/core/webview/HiveWebView;", "getWebView", "()Lcom/hive/core/webview/HiveWebView;", "setWebView", "(Lcom/hive/core/webview/HiveWebView;)V", "onSaveInstanceState", "", "outState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "postUrl", "onBackPressed", "showErrorPage", "Landroid/webkit/WebView;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewsV2WebFragment extends NewsV2Fragment {
    private JSONObject basePostData;
    private Navigation.Menu menu;
    public HiveWebView webView;

    public NewsV2WebFragment() {
    }

    public final HiveWebView getWebView() {
        HiveWebView hiveWebView = this.webView;
        if (hiveWebView != null) {
            return hiveWebView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webView");
        return null;
    }

    public final void setWebView(HiveWebView hiveWebView) {
        Intrinsics.checkNotNullParameter(hiveWebView, "<set-?>");
        this.webView = hiveWebView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewsV2WebFragment(Navigation.Menu menu, JSONObject jSONObject) {
        this();
        Intrinsics.checkNotNullParameter(menu, "menu");
        this.menu = menu;
        this.basePostData = jSONObject;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        if (this.webView != null) {
            getWebView().saveState(outState);
        }
        super.onSaveInstanceState(outState);
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.hive.promotion.ui.news.NewsV2WebFragment$onCreateView$schemeHandler$1] */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.news_web_fragment, container, false);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) viewInflate;
        setWebView((HiveWebView) viewGroup.findViewById(R.id.webView));
        getWebView().setWebViewClient(new HiveWebViewClient(new HiveSchemeHandler() { // from class: com.hive.promotion.ui.news.NewsV2WebFragment$onCreateView$schemeHandler$1
            @Override // com.hive.webview.HiveSchemeHandler
            public boolean schemeEvent(WebView view, Scheme scheme) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                return NewsV2Activity.INSTANCE.getSchemeEventFunc().invoke(scheme).booleanValue();
            }
        }, this) { // from class: com.hive.promotion.ui.news.NewsV2WebFragment.onCreateView.1
            final /* synthetic */ NewsV2WebFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(newsV2WebFragment$onCreateView$schemeHandler$1);
                this.this$0 = this;
            }

            @Override // com.hive.core.webview.HiveWebViewClient
            public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
                Intrinsics.checkNotNullParameter(view, "view");
                NewsV2WebFragment newsV2WebFragment = this.this$0;
                newsV2WebFragment.showErrorPage(newsV2WebFragment.getWebView());
            }
        });
        getWebView().setWebChromeClient(new WebChromeClient() { // from class: com.hive.promotion.ui.news.NewsV2WebFragment.onCreateView.2
            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                Logger.INSTANCE.d("[NewsV2View] onShowFileChooser()");
                WebChromeClient promotionWebChromeClient = NewsV2Activity.INSTANCE.getPromotionWebChromeClient();
                return promotionWebChromeClient != null ? promotionWebChromeClient.onShowFileChooser(webView, filePathCallback, fileChooserParams) : super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
            }
        });
        getWebView().getSettings().setJavaScriptEnabled(true);
        getWebView().getSettings().setLoadWithOverviewMode(true);
        getWebView().getSettings().setUseWideViewPort(true);
        getWebView().getSettings().setCacheMode(2);
        getWebView().getSettings().setTextZoom(100);
        getWebView().addJavascriptInterface(new AnonymousClass3(), "Android");
        if (savedInstanceState != null) {
            getWebView().restoreState(savedInstanceState);
            if (getWebView().copyBackForwardList().getSize() == 0) {
                postUrl();
            }
        } else {
            postUrl();
        }
        return viewGroup;
    }

    /* JADX INFO: renamed from: com.hive.promotion.ui.news.NewsV2WebFragment$onCreateView$3, reason: invalid class name */
    /* JADX INFO: compiled from: NewsV2WebFragment.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"com/hive/promotion/ui/news/NewsV2WebFragment$onCreateView$3", "", "retry", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass3 {
        AnonymousClass3() {
        }

        @JavascriptInterface
        public final void retry() {
            Navigation.Menu.Contents contents;
            final String link;
            Navigation.Menu menu = NewsV2WebFragment.this.menu;
            if (menu == null || (contents = menu.getContents()) == null || (link = contents.getLink()) == null) {
                return;
            }
            final NewsV2WebFragment newsV2WebFragment = NewsV2WebFragment.this;
            final JSONObject jSONObject = newsV2WebFragment.basePostData;
            if (jSONObject != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.promotion.ui.news.NewsV2WebFragment$onCreateView$3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        NewsV2WebFragment.AnonymousClass3.retry$lambda$2$lambda$1$lambda$0(newsV2WebFragment, link, jSONObject);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void retry$lambda$2$lambda$1$lambda$0(NewsV2WebFragment newsV2WebFragment, String str, JSONObject jSONObject) {
            HiveWebView webView = newsV2WebFragment.getWebView();
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            webView.postUrl(str, bytes);
        }
    }

    private final void postUrl() {
        Navigation.Menu.Contents contents;
        String link;
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.basePostData;
        if (jSONObject2 != null) {
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("view_type", "contents");
                jSONObject2.put("promotion", jSONObject3);
            } catch (Exception e) {
                Logger.INSTANCE.w("[NewsV2WebFragment] postUrl() \ne: " + e.getMessage());
                Unit unit = Unit.INSTANCE;
            }
        }
        Navigation.Menu menu = this.menu;
        if (menu == null || (contents = menu.getContents()) == null || (link = contents.getLink()) == null || (jSONObject = this.basePostData) == null) {
            return;
        }
        getWebView().setOauthToken(HiveLifecycle.INSTANCE.getAccount().getOauthToken());
        HiveWebView webView = getWebView();
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        webView.postUrl(link, bytes);
    }

    @Override // com.hive.promotion.ui.news.NewsV2Fragment
    public void onBackPressed() {
        if (this.webView != null && getWebView().canGoBack()) {
            getWebView().goBack();
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void showErrorPage(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        webView.stopLoading();
        webView.loadUrl("file:///android_res/raw/hive_error_embed_v2.html?lang=" + Configuration.INSTANCE.getGameLanguage());
    }
}
