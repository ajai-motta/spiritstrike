package com.hive.ui.common.view;

import android.app.Activity;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import com.hive.core.Logger;
import com.hive.core.OauthToken;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HiveView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005JJ\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u0017J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010$\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0017J&\u0010%\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0000X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0014\u0010&\u001a\u00020'8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020'8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b+\u0010)¨\u0006,"}, d2 = {"Lcom/hive/ui/common/view/HiveView;", "Landroid/widget/FrameLayout;", "activity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "TAG", "", "kotlin.jvm.PlatformType", "mRoot", "getMRoot", "()Lcom/hive/ui/common/view/HiveView;", "setMRoot", "(Lcom/hive/ui/common/view/HiveView;)V", "webView", "Lcom/hive/core/webview/HiveWebView;", "getWebView", "()Lcom/hive/core/webview/HiveWebView;", "setWebView", "(Lcom/hive/core/webview/HiveWebView;)V", MobileAdsBridgeBase.initializeMethodName, "", "url", "postData", "token", "Lcom/hive/core/OauthToken;", "webViewClient", "Lcom/hive/core/webview/HiveWebViewClient;", "webChromeClient", "Landroid/webkit/WebChromeClient;", "canGoBack", "", "goBack", "onCreateView", "onCreateWebView", "onLoadWebView", "backUrlIndex", "", "getBackUrlIndex", "()I", "forwardUrlIndex", "getForwardUrlIndex", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class HiveView extends FrameLayout {
    private final String TAG;
    private final Activity activity;
    protected HiveView mRoot;
    protected HiveWebView webView;

    public abstract void onCreateView(Activity activity);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveView(Activity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.TAG = "HiveView";
    }

    public final Activity getActivity() {
        return this.activity;
    }

    protected final HiveView getMRoot() {
        HiveView hiveView = this.mRoot;
        if (hiveView != null) {
            return hiveView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        return null;
    }

    protected final void setMRoot(HiveView hiveView) {
        Intrinsics.checkNotNullParameter(hiveView, "<set-?>");
        this.mRoot = hiveView;
    }

    protected final HiveWebView getWebView() {
        HiveWebView hiveWebView = this.webView;
        if (hiveWebView != null) {
            return hiveWebView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("webView");
        return null;
    }

    protected final void setWebView(HiveWebView hiveWebView) {
        Intrinsics.checkNotNullParameter(hiveWebView, "<set-?>");
        this.webView = hiveWebView;
    }

    public static /* synthetic */ void initialize$default(HiveView hiveView, Activity activity, String str, String str2, OauthToken oauthToken, HiveWebViewClient hiveWebViewClient, WebChromeClient webChromeClient, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: initialize");
        }
        hiveView.initialize(activity, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : oauthToken, (i & 16) != 0 ? null : hiveWebViewClient, (i & 32) == 0 ? webChromeClient : null);
    }

    public final void initialize(Activity activity, String url, String postData, OauthToken token, HiveWebViewClient webViewClient, WebChromeClient webChromeClient) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        onCreateView(activity);
        if (this.webView != null) {
            Logger.INSTANCE.d(this.TAG, "onCreateWebView");
            onCreateWebView(webViewClient, webChromeClient);
            onLoadWebView(url, postData, token);
            return;
        }
        Logger.INSTANCE.d(this.TAG, "Not onCreateWebView. ");
    }

    public final boolean canGoBack() {
        if (this.webView != null) {
            return getWebView().canGoBack();
        }
        return false;
    }

    public final void goBack() {
        if (this.webView != null) {
            getWebView().goBack();
        }
    }

    public void onCreateWebView(HiveWebViewClient webViewClient, WebChromeClient webChromeClient) {
        HiveWebView webView = getWebView();
        if (webViewClient != null) {
            webView.setWebViewClient(webViewClient);
        }
        if (webChromeClient != null) {
            webView.setWebChromeClient(webChromeClient);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(false);
        webView.getSettings().setDefaultTextEncodingName(Charsets.UTF_8.name());
        webView.getSettings().setCacheMode(2);
        webView.addJavascriptInterface(new HiveView$onCreateWebView$1$3(this, webView), "Android");
    }

    public void onLoadWebView(String url, String postData, OauthToken token) {
        String str = url;
        if (str == null || str.length() == 0) {
            return;
        }
        getWebView().setOauthToken(token);
        String str2 = postData;
        if (str2 == null || str2.length() == 0) {
            getWebView().loadUrl(url);
            return;
        }
        HiveWebView webView = getWebView();
        byte[] bytes = postData.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        webView.postUrl(url, bytes);
    }

    protected final int getBackUrlIndex() {
        WebBackForwardList webBackForwardListCopyBackForwardList = getWebView().copyBackForwardList();
        Intrinsics.checkNotNullExpressionValue(webBackForwardListCopyBackForwardList, "copyBackForwardList(...)");
        int i = -1;
        for (int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex() - 1; -1 < currentIndex; currentIndex--) {
            String url = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex).getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
            if (!StringsKt.contains$default((CharSequence) url, (CharSequence) "hive_error_embed.html", false, 2, (Object) null)) {
                break;
            }
            i--;
        }
        if (getWebView().canGoBackOrForward(i)) {
            return i;
        }
        return 0;
    }

    protected final int getForwardUrlIndex() {
        WebBackForwardList webBackForwardListCopyBackForwardList = getWebView().copyBackForwardList();
        if (webBackForwardListCopyBackForwardList == null) {
            return 0;
        }
        int i = 1;
        int size = webBackForwardListCopyBackForwardList.getSize();
        for (int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex() + 1; currentIndex < size; currentIndex++) {
            String url = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex).getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
            if (!StringsKt.contains$default((CharSequence) url, (CharSequence) "hive_error_embed.html", false, 2, (Object) null)) {
                break;
            }
            i++;
        }
        if (getWebView().canGoBackOrForward(i)) {
            return i;
        }
        return 0;
    }
}
