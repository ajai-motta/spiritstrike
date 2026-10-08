package com.hive.promotion.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.core.Configuration;
import com.hive.core.ExtentionsKt;
import com.hive.core.Logger;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.promotion.ui.PromotionView;
import com.hive.standalone.HiveLifecycle;
import com.hive.webview.HiveSchemeHandler;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PromotionView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000£\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001|\b&\u0018\u0000  \u00012\u00020\u0001:\b \u0001¡\u0001¢\u0001£\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\fB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0010J\u0010\u0010x\u001a\u00020y2\b\u0010z\u001a\u0004\u0018\u00010mJ\t\u0010\u008d\u0001\u001a\u00020yH\u0014J\u0017\u0010\u008e\u0001\u001a\u00020y2\u0006\u0010\u0004\u001a\u00020\u0005H ¢\u0006\u0003\b\u008f\u0001J\u000f\u0010\u0090\u0001\u001a\u00020\u0017H ¢\u0006\u0003\b\u0091\u0001J\t\u0010\u0092\u0001\u001a\u00020yH\u0016J\u0011\u0010\u0093\u0001\u001a\u00020y2\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\t\u0010\u0094\u0001\u001a\u00020yH\u0005J\t\u0010\u0095\u0001\u001a\u00020yH\u0017J\u0012\u0010\u0096\u0001\u001a\u00020y2\u0007\u0010\u0097\u0001\u001a\u00020]H\u0002J\u0012\u0010\u0098\u0001\u001a\u00020y2\u0007\u0010\u0099\u0001\u001a\u00020;H\u0002J\t\u0010\u009a\u0001\u001a\u00020yH\u0002J\t\u0010\u009b\u0001\u001a\u00020yH\u0007J\u0013\u0010\u009c\u0001\u001a\u00020y2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0002J\u0013\u0010\u009f\u0001\u001a\u00020y2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001H\u0002R\u001a\u0010\u0011\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0019R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020\u0000X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u001a\u00102\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001a\u0010:\u001a\u00020;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010=\"\u0004\bB\u0010?R\u001a\u0010C\u001a\u00020;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010=\"\u0004\bE\u0010?R\u001a\u0010F\u001a\u00020;X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010=\"\u0004\bH\u0010?R\u001c\u0010I\u001a\u0004\u0018\u00010JX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u00010JX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010L\"\u0004\bQ\u0010NR\u001c\u0010R\u001a\u0004\u0018\u00010JX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010L\"\u0004\bT\u0010NR\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR&\u0010[\u001a\u000e\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020\t0\\X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0011\u0010b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bb\u00104R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010c\u001a\u00020\u0005X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010,\"\u0004\be\u0010.R\u001a\u0010f\u001a\u00020gX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001c\u0010l\u001a\u0004\u0018\u00010mX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001c\u0010r\u001a\u0004\u0018\u00010sX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u0010\u0010{\u001a\u00020|X\u0082\u0004¢\u0006\u0004\n\u0002\u0010}R\u000e\u0010~\u001a\u00020\u007fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0080\u0001\u001a\u00020sX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0081\u0001\u001a\u00030\u0082\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u0018\u0010\u0087\u0001\u001a\u00030\u0088\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008b\u0001\u001a\u00030\u0088\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008a\u0001¨\u0006¤\u0001"}, d2 = {"Lcom/hive/promotion/ui/PromotionView;", "Landroid/widget/FrameLayout;", "activity", "Landroid/app/Activity;", "url", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "useCutout", "", "(Landroid/app/Activity;Ljava/lang/String;Z)V", AdUnitActivity.EXTRA_ORIENTATION, "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "webViewInfo", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "showAlways", "(Landroid/app/Activity;Lcom/hive/promotion/ui/PromotionView$WebViewInfo;Ljava/lang/String;)V", "mActivity", "getMActivity$hive_promotion_release", "()Landroid/app/Activity;", "setMActivity$hive_promotion_release", "(Landroid/app/Activity;)V", "mWebView", "Lcom/hive/core/webview/HiveWebView;", "getMWebView", "()Lcom/hive/core/webview/HiveWebView;", "setMWebView", "(Lcom/hive/core/webview/HiveWebView;)V", "webView", "getWebView", "webBundle", "Landroid/os/Bundle;", "mWebViewInfo", "getMWebViewInfo$hive_promotion_release", "()Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "setMWebViewInfo$hive_promotion_release", "(Lcom/hive/promotion/ui/PromotionView$WebViewInfo;)V", "mRoot", "getMRoot$hive_promotion_release", "()Lcom/hive/promotion/ui/PromotionView;", "setMRoot$hive_promotion_release", "(Lcom/hive/promotion/ui/PromotionView;)V", "mUrl", "getMUrl$hive_promotion_release", "()Ljava/lang/String;", "setMUrl$hive_promotion_release", "(Ljava/lang/String;)V", "mPostdata", "getMPostdata", "setMPostdata", "isRequest", "isRequest$hive_promotion_release", "()Z", "setRequest$hive_promotion_release", "(Z)V", "isLoading", "isLoading$hive_promotion_release", "setLoading$hive_promotion_release", "startTime", "", "getStartTime$hive_promotion_release", "()J", "setStartTime$hive_promotion_release", "(J)V", "finishTime", "getFinishTime$hive_promotion_release", "setFinishTime$hive_promotion_release", "lastUpdateTime", "getLastUpdateTime$hive_promotion_release", "setLastUpdateTime$hive_promotion_release", "targetTimeout", "getTargetTimeout$hive_promotion_release", "setTargetTimeout$hive_promotion_release", "promotion_view_spinner", "Landroid/widget/ProgressBar;", "getPromotion_view_spinner", "()Landroid/widget/ProgressBar;", "setPromotion_view_spinner", "(Landroid/widget/ProgressBar;)V", "promotion_view_full_loadingbar", "getPromotion_view_full_loadingbar", "setPromotion_view_full_loadingbar", "promotion_customview_loading_progress", "getPromotion_customview_loading_progress", "setPromotion_customview_loading_progress", "mWebViewHistoryListener", "Lcom/hive/promotion/ui/PromotionView$PromotionWebViewHistoryListener;", "getMWebViewHistoryListener", "()Lcom/hive/promotion/ui/PromotionView$PromotionWebViewHistoryListener;", "setMWebViewHistoryListener", "(Lcom/hive/promotion/ui/PromotionView$PromotionWebViewHistoryListener;)V", "schemeEventFunc", "Lkotlin/Function1;", "Lcom/hive/core/Scheme;", "getSchemeEventFunc", "()Lkotlin/jvm/functions/Function1;", "setSchemeEventFunc", "(Lkotlin/jvm/functions/Function1;)V", "isSchemeEventFuncInitialized", "displayOrientation", "getDisplayOrientation", "setDisplayOrientation", "myHandler", "Landroid/os/Handler;", "getMyHandler$hive_promotion_release", "()Landroid/os/Handler;", "setMyHandler$hive_promotion_release", "(Landroid/os/Handler;)V", "buttonClickedListener", "Lcom/hive/promotion/ui/PromotionView$ButtonClickedListener;", "getButtonClickedListener", "()Lcom/hive/promotion/ui/PromotionView$ButtonClickedListener;", "setButtonClickedListener", "(Lcom/hive/promotion/ui/PromotionView$ButtonClickedListener;)V", "promotionWebChromeClient", "Landroid/webkit/WebChromeClient;", "getPromotionWebChromeClient", "()Landroid/webkit/WebChromeClient;", "setPromotionWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "setOnButtonClickedListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "schemeHandler", "com/hive/promotion/ui/PromotionView$schemeHandler$1", "Lcom/hive/promotion/ui/PromotionView$schemeHandler$1;", "mWebViewClient", "Lcom/hive/core/webview/HiveWebViewClient;", "mWebChromeClient", "timeoutEvent", "Ljava/lang/Runnable;", "getTimeoutEvent$hive_promotion_release", "()Ljava/lang/Runnable;", "setTimeoutEvent$hive_promotion_release", "(Ljava/lang/Runnable;)V", "backUrlIndex", "", "getBackUrlIndex", "()I", "forwardUrlIndex", "getForwardUrlIndex", "onAttachedToWindow", "onCreateView", "onCreateView$hive_promotion_release", "onCreateWebView", "onCreateWebView$hive_promotion_release", "reCreate", "showWebView", "reload", "show", "webViewBackgroundTransparency", "scheme", "updateTimeout", "timeout", "removeTimeout", "showErrorPage", "setDisplayCutoutNever", "rootView", "Landroid/view/View;", "setOnDisplayCutoutNever", k.M, "ButtonClickedListener", "PromotionWebViewHistoryListener", "WebViewInfo", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PromotionView extends FrameLayout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PromotionView";
    private ButtonClickedListener buttonClickedListener;
    private String displayOrientation;
    private long finishTime;
    private boolean isLoading;
    private boolean isRequest;
    private long lastUpdateTime;
    private Activity mActivity;
    private String mPostdata;
    public PromotionView mRoot;
    private String mUrl;
    private WebChromeClient mWebChromeClient;
    protected HiveWebView mWebView;
    private HiveWebViewClient mWebViewClient;
    private PromotionWebViewHistoryListener mWebViewHistoryListener;
    private WebViewInfo mWebViewInfo;
    private Handler myHandler;
    private WebChromeClient promotionWebChromeClient;
    private ProgressBar promotion_customview_loading_progress;
    private ProgressBar promotion_view_full_loadingbar;
    private ProgressBar promotion_view_spinner;
    public Function1<? super Scheme, Boolean> schemeEventFunc;
    private final PromotionView$schemeHandler$1 schemeHandler;
    private long startTime;
    private long targetTimeout;
    private Runnable timeoutEvent;
    private boolean useCutout;
    private Bundle webBundle;

    /* JADX INFO: compiled from: PromotionView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/hive/promotion/ui/PromotionView$ButtonClickedListener;", "", "onClose", "", "onForce", "type", "", AnalyticsProviderAdjust.EventKeys.pid, "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ButtonClickedListener {
        void onClose();

        void onForce(String type, int pid);
    }

    /* JADX INFO: compiled from: PromotionView.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/hive/promotion/ui/PromotionView$PromotionWebViewHistoryListener;", "", "checkHistoryAndUpdateButtons", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PromotionWebViewHistoryListener {
        void checkHistoryAndUpdateButtons();
    }

    public abstract void onCreateView$hive_promotion_release(String url);

    public abstract HiveWebView onCreateWebView$hive_promotion_release();

    /* JADX INFO: compiled from: PromotionView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/hive/promotion/ui/PromotionView$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return PromotionView.TAG;
        }
    }

    /* JADX INFO: renamed from: getMActivity$hive_promotion_release, reason: from getter */
    public final Activity getMActivity() {
        return this.mActivity;
    }

    public final void setMActivity$hive_promotion_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.mActivity = activity;
    }

    protected final HiveWebView getMWebView() {
        HiveWebView hiveWebView = this.mWebView;
        if (hiveWebView != null) {
            return hiveWebView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mWebView");
        return null;
    }

    protected final void setMWebView(HiveWebView hiveWebView) {
        Intrinsics.checkNotNullParameter(hiveWebView, "<set-?>");
        this.mWebView = hiveWebView;
    }

    public final HiveWebView getWebView() {
        return getMWebView();
    }

    /* JADX INFO: renamed from: getMWebViewInfo$hive_promotion_release, reason: from getter */
    public final WebViewInfo getMWebViewInfo() {
        return this.mWebViewInfo;
    }

    public final void setMWebViewInfo$hive_promotion_release(WebViewInfo webViewInfo) {
        Intrinsics.checkNotNullParameter(webViewInfo, "<set-?>");
        this.mWebViewInfo = webViewInfo;
    }

    public final PromotionView getMRoot$hive_promotion_release() {
        PromotionView promotionView = this.mRoot;
        if (promotionView != null) {
            return promotionView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        return null;
    }

    public final void setMRoot$hive_promotion_release(PromotionView promotionView) {
        Intrinsics.checkNotNullParameter(promotionView, "<set-?>");
        this.mRoot = promotionView;
    }

    /* JADX INFO: renamed from: getMUrl$hive_promotion_release, reason: from getter */
    public final String getMUrl() {
        return this.mUrl;
    }

    public final void setMUrl$hive_promotion_release(String str) {
        this.mUrl = str;
    }

    public final String getMPostdata() {
        return this.mPostdata;
    }

    public final void setMPostdata(String str) {
        this.mPostdata = str;
    }

    /* JADX INFO: renamed from: isRequest$hive_promotion_release, reason: from getter */
    public final boolean getIsRequest() {
        return this.isRequest;
    }

    public final void setRequest$hive_promotion_release(boolean z) {
        this.isRequest = z;
    }

    /* JADX INFO: renamed from: isLoading$hive_promotion_release, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final void setLoading$hive_promotion_release(boolean z) {
        this.isLoading = z;
    }

    /* JADX INFO: renamed from: getStartTime$hive_promotion_release, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime$hive_promotion_release(long j) {
        this.startTime = j;
    }

    /* JADX INFO: renamed from: getFinishTime$hive_promotion_release, reason: from getter */
    public final long getFinishTime() {
        return this.finishTime;
    }

    public final void setFinishTime$hive_promotion_release(long j) {
        this.finishTime = j;
    }

    /* JADX INFO: renamed from: getLastUpdateTime$hive_promotion_release, reason: from getter */
    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final void setLastUpdateTime$hive_promotion_release(long j) {
        this.lastUpdateTime = j;
    }

    /* JADX INFO: renamed from: getTargetTimeout$hive_promotion_release, reason: from getter */
    public final long getTargetTimeout() {
        return this.targetTimeout;
    }

    public final void setTargetTimeout$hive_promotion_release(long j) {
        this.targetTimeout = j;
    }

    protected final ProgressBar getPromotion_view_spinner() {
        return this.promotion_view_spinner;
    }

    protected final void setPromotion_view_spinner(ProgressBar progressBar) {
        this.promotion_view_spinner = progressBar;
    }

    protected final ProgressBar getPromotion_view_full_loadingbar() {
        return this.promotion_view_full_loadingbar;
    }

    protected final void setPromotion_view_full_loadingbar(ProgressBar progressBar) {
        this.promotion_view_full_loadingbar = progressBar;
    }

    protected final ProgressBar getPromotion_customview_loading_progress() {
        return this.promotion_customview_loading_progress;
    }

    protected final void setPromotion_customview_loading_progress(ProgressBar progressBar) {
        this.promotion_customview_loading_progress = progressBar;
    }

    protected final PromotionWebViewHistoryListener getMWebViewHistoryListener() {
        return this.mWebViewHistoryListener;
    }

    protected final void setMWebViewHistoryListener(PromotionWebViewHistoryListener promotionWebViewHistoryListener) {
        this.mWebViewHistoryListener = promotionWebViewHistoryListener;
    }

    public final Function1<Scheme, Boolean> getSchemeEventFunc() {
        Function1 function1 = this.schemeEventFunc;
        if (function1 != null) {
            return function1;
        }
        Intrinsics.throwUninitializedPropertyAccessException("schemeEventFunc");
        return null;
    }

    public final void setSchemeEventFunc(Function1<? super Scheme, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.schemeEventFunc = function1;
    }

    public final boolean isSchemeEventFuncInitialized() {
        return this.schemeEventFunc != null;
    }

    protected final String getDisplayOrientation() {
        return this.displayOrientation;
    }

    protected final void setDisplayOrientation(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.displayOrientation = str;
    }

    /* JADX INFO: renamed from: getMyHandler$hive_promotion_release, reason: from getter */
    public final Handler getMyHandler() {
        return this.myHandler;
    }

    public final void setMyHandler$hive_promotion_release(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.myHandler = handler;
    }

    protected final ButtonClickedListener getButtonClickedListener() {
        return this.buttonClickedListener;
    }

    protected final void setButtonClickedListener(ButtonClickedListener buttonClickedListener) {
        this.buttonClickedListener = buttonClickedListener;
    }

    public final WebChromeClient getPromotionWebChromeClient() {
        return this.promotionWebChromeClient;
    }

    public final void setPromotionWebChromeClient(WebChromeClient webChromeClient) {
        this.promotionWebChromeClient = webChromeClient;
    }

    public final void setOnButtonClickedListener(ButtonClickedListener listener) {
        if (listener != null) {
            this.buttonClickedListener = listener;
        }
    }

    /* JADX INFO: renamed from: getTimeoutEvent$hive_promotion_release, reason: from getter */
    public final Runnable getTimeoutEvent() {
        return this.timeoutEvent;
    }

    public final void setTimeoutEvent$hive_promotion_release(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.timeoutEvent = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void timeoutEvent$lambda$1(PromotionView promotionView) {
        long jNanoTime = System.nanoTime() - promotionView.startTime;
        if (jNanoTime < promotionView.targetTimeout) {
            Logger.INSTANCE.d(TAG, "TimeoutEvent in = " + jNanoTime + "/ " + promotionView.targetTimeout);
        }
        promotionView.showErrorPage();
    }

    protected final int getBackUrlIndex() {
        WebBackForwardList webBackForwardListCopyBackForwardList = getMWebView().copyBackForwardList();
        Intrinsics.checkNotNullExpressionValue(webBackForwardListCopyBackForwardList, "copyBackForwardList(...)");
        String url = webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex()).getUrl();
        int i = -1;
        for (int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex() - 1; -1 < currentIndex; currentIndex--) {
            WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex);
            String url2 = itemAtIndex.getUrl();
            Intrinsics.checkNotNullExpressionValue(url2, "getUrl(...)");
            if (!StringsKt.contains$default((CharSequence) url2, (CharSequence) "hive_error_embed.html", false, 2, (Object) null) && !Intrinsics.areEqual(itemAtIndex.getUrl(), url)) {
                break;
            }
            i--;
        }
        if (getMWebView().canGoBackOrForward(i)) {
            return i;
        }
        return 0;
    }

    protected final int getForwardUrlIndex() {
        WebBackForwardList webBackForwardListCopyBackForwardList = getMWebView().copyBackForwardList();
        Intrinsics.checkNotNullExpressionValue(webBackForwardListCopyBackForwardList, "copyBackForwardList(...)");
        String url = webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex()).getUrl();
        int i = 1;
        int size = webBackForwardListCopyBackForwardList.getSize();
        for (int currentIndex = webBackForwardListCopyBackForwardList.getCurrentIndex() + 1; currentIndex < size; currentIndex++) {
            WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(currentIndex);
            String url2 = itemAtIndex.getUrl();
            Intrinsics.checkNotNullExpressionValue(url2, "getUrl(...)");
            if (!StringsKt.contains$default((CharSequence) url2, (CharSequence) "hive_error_embed.html", false, 2, (Object) null) && !Intrinsics.areEqual(itemAtIndex.getUrl(), url)) {
                break;
            }
            i++;
        }
        if (getMWebView().canGoBackOrForward(i)) {
            return i;
        }
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.hive.promotion.ui.PromotionView$schemeHandler$1] */
    public PromotionView(Activity activity, String url) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        this.webBundle = new Bundle();
        this.useCutout = true;
        this.displayOrientation = "";
        this.myHandler = new Handler(Looper.getMainLooper());
        final ?? r0 = new HiveSchemeHandler() { // from class: com.hive.promotion.ui.PromotionView$schemeHandler$1
            @Override // com.hive.webview.HiveSchemeHandler
            public boolean schemeEvent(WebView view, Scheme scheme) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                this.this$0.webViewBackgroundTransparency(scheme);
                if (this.this$0.isSchemeEventFuncInitialized()) {
                    return this.this$0.getSchemeEventFunc().invoke(scheme).booleanValue();
                }
                return super.schemeEvent(view, scheme);
            }
        };
        this.schemeHandler = r0;
        this.mWebViewClient = new HiveWebViewClient(r0) { // from class: com.hive.promotion.ui.PromotionView$mWebViewClient$1
            {
                super(r0);
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(request, "request");
                if (request.getRequestHeaders() != null) {
                    Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request.getRequestHeaders() : " + request.getRequestHeaders());
                }
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request.getUrl() : " + request.getUrl());
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request.getMethod() : " + request.getMethod());
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request : " + request);
                String string = request.getUrl().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return shouldOverrideUrlLoading(view, string);
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url2, Bitmap favicon) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                super.onPageStarted(view, url2, favicon);
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onPageStarted : loading url is " + url2);
                ProgressBar promotion_view_spinner = this.this$0.getPromotion_view_spinner();
                if (promotion_view_spinner != null) {
                    promotion_view_spinner.bringToFront();
                    promotion_view_spinner.setVisibility(0);
                }
                ProgressBar promotion_view_full_loadingbar = this.this$0.getPromotion_view_full_loadingbar();
                if (promotion_view_full_loadingbar != null) {
                    promotion_view_full_loadingbar.bringToFront();
                    promotion_view_full_loadingbar.setVisibility(0);
                }
                this.this$0.setStartTime$hive_promotion_release(System.nanoTime());
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url2) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                super.onPageFinished(view, url2);
                this.this$0.setFinishTime$hive_promotion_release(System.nanoTime());
                long finishTime = this.this$0.getFinishTime() - this.this$0.getStartTime();
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onPageFinished : loaded url is " + url2 + " recordTime : " + finishTime);
                this.this$0.removeTimeout();
                ProgressBar promotion_view_spinner = this.this$0.getPromotion_view_spinner();
                if (promotion_view_spinner != null) {
                    promotion_view_spinner.setVisibility(8);
                }
                ProgressBar promotion_view_full_loadingbar = this.this$0.getPromotion_view_full_loadingbar();
                if (promotion_view_full_loadingbar != null) {
                    promotion_view_full_loadingbar.setVisibility(8);
                }
                PromotionView.PromotionWebViewHistoryListener mWebViewHistoryListener = this.this$0.getMWebViewHistoryListener();
                if (mWebViewHistoryListener != null) {
                    mWebViewHistoryListener.checkHistoryAndUpdateButtons();
                }
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url2) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                super.onLoadResource(view, url2);
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onLoadResource : loaded url is " + url2);
            }

            @Override // com.hive.core.webview.HiveWebViewClient
            public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
                Intrinsics.checkNotNullParameter(view, "view");
                Logger.INSTANCE.w(PromotionView.INSTANCE.getTAG(), "receivedErrorEvent : code(" + errorCode + "):" + description + "\n fail url is " + failingUrl);
                this.this$0.removeTimeout();
                this.this$0.showErrorPage();
            }
        };
        this.mWebChromeClient = new WebChromeClient() { // from class: com.hive.promotion.ui.PromotionView$mWebChromeClient$1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                Intrinsics.checkNotNullParameter(view, "view");
                Logger.INSTANCE.d("LoadingProgress = " + newProgress);
                if (newProgress == 100) {
                    this.this$0.setLoading$hive_promotion_release(false);
                } else if (newProgress > 0) {
                    this.this$0.setLoading$hive_promotion_release(true);
                }
                ProgressBar promotion_view_spinner = this.this$0.getPromotion_view_spinner();
                if (promotion_view_spinner != null) {
                    promotion_view_spinner.setProgress(newProgress);
                }
                ProgressBar promotion_view_full_loadingbar = this.this$0.getPromotion_view_full_loadingbar();
                if (promotion_view_full_loadingbar != null) {
                    promotion_view_full_loadingbar.setProgress(newProgress);
                }
                ProgressBar promotion_customview_loading_progress = this.this$0.getPromotion_customview_loading_progress();
                if (promotion_customview_loading_progress != null) {
                    promotion_customview_loading_progress.setProgress(newProgress);
                    if (newProgress >= 100) {
                        promotion_customview_loading_progress.setVisibility(4);
                    } else {
                        promotion_customview_loading_progress.setVisibility(0);
                    }
                }
                this.this$0.setLastUpdateTime$hive_promotion_release(System.nanoTime());
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onShowFileChooser()");
                WebChromeClient promotionWebChromeClient = this.this$0.getPromotionWebChromeClient();
                return promotionWebChromeClient != null ? promotionWebChromeClient.onShowFileChooser(webView, filePathCallback, fileChooserParams) : super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
            }
        };
        this.timeoutEvent = new Runnable() { // from class: com.hive.promotion.ui.PromotionView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PromotionView.timeoutEvent$lambda$1(this.f$0);
            }
        };
        this.mActivity = activity;
        this.mWebViewInfo = new WebViewInfo(new JSONObject());
        onCreateView$hive_promotion_release(url);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PromotionView(Activity activity, String url, boolean z) {
        this(activity, url);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        this.useCutout = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.hive.promotion.ui.PromotionView$schemeHandler$1] */
    public PromotionView(Activity activity, String url, String orientation) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.webBundle = new Bundle();
        this.useCutout = true;
        this.displayOrientation = "";
        this.myHandler = new Handler(Looper.getMainLooper());
        final ?? r0 = new HiveSchemeHandler() { // from class: com.hive.promotion.ui.PromotionView$schemeHandler$1
            @Override // com.hive.webview.HiveSchemeHandler
            public boolean schemeEvent(WebView view, Scheme scheme) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                this.this$0.webViewBackgroundTransparency(scheme);
                if (this.this$0.isSchemeEventFuncInitialized()) {
                    return this.this$0.getSchemeEventFunc().invoke(scheme).booleanValue();
                }
                return super.schemeEvent(view, scheme);
            }
        };
        this.schemeHandler = r0;
        this.mWebViewClient = new HiveWebViewClient(r0) { // from class: com.hive.promotion.ui.PromotionView$mWebViewClient$1
            {
                super(r0);
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(request, "request");
                if (request.getRequestHeaders() != null) {
                    Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request.getRequestHeaders() : " + request.getRequestHeaders());
                }
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request.getUrl() : " + request.getUrl());
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request.getMethod() : " + request.getMethod());
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request : " + request);
                String string = request.getUrl().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return shouldOverrideUrlLoading(view, string);
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url2, Bitmap favicon) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                super.onPageStarted(view, url2, favicon);
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onPageStarted : loading url is " + url2);
                ProgressBar promotion_view_spinner = this.this$0.getPromotion_view_spinner();
                if (promotion_view_spinner != null) {
                    promotion_view_spinner.bringToFront();
                    promotion_view_spinner.setVisibility(0);
                }
                ProgressBar promotion_view_full_loadingbar = this.this$0.getPromotion_view_full_loadingbar();
                if (promotion_view_full_loadingbar != null) {
                    promotion_view_full_loadingbar.bringToFront();
                    promotion_view_full_loadingbar.setVisibility(0);
                }
                this.this$0.setStartTime$hive_promotion_release(System.nanoTime());
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url2) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                super.onPageFinished(view, url2);
                this.this$0.setFinishTime$hive_promotion_release(System.nanoTime());
                long finishTime = this.this$0.getFinishTime() - this.this$0.getStartTime();
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onPageFinished : loaded url is " + url2 + " recordTime : " + finishTime);
                this.this$0.removeTimeout();
                ProgressBar promotion_view_spinner = this.this$0.getPromotion_view_spinner();
                if (promotion_view_spinner != null) {
                    promotion_view_spinner.setVisibility(8);
                }
                ProgressBar promotion_view_full_loadingbar = this.this$0.getPromotion_view_full_loadingbar();
                if (promotion_view_full_loadingbar != null) {
                    promotion_view_full_loadingbar.setVisibility(8);
                }
                PromotionView.PromotionWebViewHistoryListener mWebViewHistoryListener = this.this$0.getMWebViewHistoryListener();
                if (mWebViewHistoryListener != null) {
                    mWebViewHistoryListener.checkHistoryAndUpdateButtons();
                }
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url2) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                super.onLoadResource(view, url2);
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onLoadResource : loaded url is " + url2);
            }

            @Override // com.hive.core.webview.HiveWebViewClient
            public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
                Intrinsics.checkNotNullParameter(view, "view");
                Logger.INSTANCE.w(PromotionView.INSTANCE.getTAG(), "receivedErrorEvent : code(" + errorCode + "):" + description + "\n fail url is " + failingUrl);
                this.this$0.removeTimeout();
                this.this$0.showErrorPage();
            }
        };
        this.mWebChromeClient = new WebChromeClient() { // from class: com.hive.promotion.ui.PromotionView$mWebChromeClient$1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                Intrinsics.checkNotNullParameter(view, "view");
                Logger.INSTANCE.d("LoadingProgress = " + newProgress);
                if (newProgress == 100) {
                    this.this$0.setLoading$hive_promotion_release(false);
                } else if (newProgress > 0) {
                    this.this$0.setLoading$hive_promotion_release(true);
                }
                ProgressBar promotion_view_spinner = this.this$0.getPromotion_view_spinner();
                if (promotion_view_spinner != null) {
                    promotion_view_spinner.setProgress(newProgress);
                }
                ProgressBar promotion_view_full_loadingbar = this.this$0.getPromotion_view_full_loadingbar();
                if (promotion_view_full_loadingbar != null) {
                    promotion_view_full_loadingbar.setProgress(newProgress);
                }
                ProgressBar promotion_customview_loading_progress = this.this$0.getPromotion_customview_loading_progress();
                if (promotion_customview_loading_progress != null) {
                    promotion_customview_loading_progress.setProgress(newProgress);
                    if (newProgress >= 100) {
                        promotion_customview_loading_progress.setVisibility(4);
                    } else {
                        promotion_customview_loading_progress.setVisibility(0);
                    }
                }
                this.this$0.setLastUpdateTime$hive_promotion_release(System.nanoTime());
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onShowFileChooser()");
                WebChromeClient promotionWebChromeClient = this.this$0.getPromotionWebChromeClient();
                return promotionWebChromeClient != null ? promotionWebChromeClient.onShowFileChooser(webView, filePathCallback, fileChooserParams) : super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
            }
        };
        this.timeoutEvent = new Runnable() { // from class: com.hive.promotion.ui.PromotionView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PromotionView.timeoutEvent$lambda$1(this.f$0);
            }
        };
        this.mActivity = activity;
        this.mWebViewInfo = new WebViewInfo(new JSONObject());
        this.displayOrientation = orientation;
        onCreateView$hive_promotion_release(url);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r4v7, types: [com.hive.promotion.ui.PromotionView$schemeHandler$1] */
    public PromotionView(Activity activity, WebViewInfo webViewInfo, String showAlways) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        Intrinsics.checkNotNullParameter(showAlways, "showAlways");
        this.webBundle = new Bundle();
        this.useCutout = true;
        this.displayOrientation = "";
        this.myHandler = new Handler(Looper.getMainLooper());
        final ?? r4 = new HiveSchemeHandler() { // from class: com.hive.promotion.ui.PromotionView$schemeHandler$1
            @Override // com.hive.webview.HiveSchemeHandler
            public boolean schemeEvent(WebView view, Scheme scheme) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                this.this$0.webViewBackgroundTransparency(scheme);
                if (this.this$0.isSchemeEventFuncInitialized()) {
                    return this.this$0.getSchemeEventFunc().invoke(scheme).booleanValue();
                }
                return super.schemeEvent(view, scheme);
            }
        };
        this.schemeHandler = r4;
        this.mWebViewClient = new HiveWebViewClient(r4) { // from class: com.hive.promotion.ui.PromotionView$mWebViewClient$1
            {
                super(r4);
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(request, "request");
                if (request.getRequestHeaders() != null) {
                    Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request.getRequestHeaders() : " + request.getRequestHeaders());
                }
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request.getUrl() : " + request.getUrl());
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request.getMethod() : " + request.getMethod());
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "request : " + request);
                String string = request.getUrl().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return shouldOverrideUrlLoading(view, string);
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url2, Bitmap favicon) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                super.onPageStarted(view, url2, favicon);
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onPageStarted : loading url is " + url2);
                ProgressBar promotion_view_spinner = this.this$0.getPromotion_view_spinner();
                if (promotion_view_spinner != null) {
                    promotion_view_spinner.bringToFront();
                    promotion_view_spinner.setVisibility(0);
                }
                ProgressBar promotion_view_full_loadingbar = this.this$0.getPromotion_view_full_loadingbar();
                if (promotion_view_full_loadingbar != null) {
                    promotion_view_full_loadingbar.bringToFront();
                    promotion_view_full_loadingbar.setVisibility(0);
                }
                this.this$0.setStartTime$hive_promotion_release(System.nanoTime());
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url2) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                super.onPageFinished(view, url2);
                this.this$0.setFinishTime$hive_promotion_release(System.nanoTime());
                long finishTime = this.this$0.getFinishTime() - this.this$0.getStartTime();
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onPageFinished : loaded url is " + url2 + " recordTime : " + finishTime);
                this.this$0.removeTimeout();
                ProgressBar promotion_view_spinner = this.this$0.getPromotion_view_spinner();
                if (promotion_view_spinner != null) {
                    promotion_view_spinner.setVisibility(8);
                }
                ProgressBar promotion_view_full_loadingbar = this.this$0.getPromotion_view_full_loadingbar();
                if (promotion_view_full_loadingbar != null) {
                    promotion_view_full_loadingbar.setVisibility(8);
                }
                PromotionView.PromotionWebViewHistoryListener mWebViewHistoryListener = this.this$0.getMWebViewHistoryListener();
                if (mWebViewHistoryListener != null) {
                    mWebViewHistoryListener.checkHistoryAndUpdateButtons();
                }
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onLoadResource(WebView view, String url2) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                super.onLoadResource(view, url2);
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onLoadResource : loaded url is " + url2);
            }

            @Override // com.hive.core.webview.HiveWebViewClient
            public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
                Intrinsics.checkNotNullParameter(view, "view");
                Logger.INSTANCE.w(PromotionView.INSTANCE.getTAG(), "receivedErrorEvent : code(" + errorCode + "):" + description + "\n fail url is " + failingUrl);
                this.this$0.removeTimeout();
                this.this$0.showErrorPage();
            }
        };
        this.mWebChromeClient = new WebChromeClient() { // from class: com.hive.promotion.ui.PromotionView$mWebChromeClient$1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                Intrinsics.checkNotNullParameter(view, "view");
                Logger.INSTANCE.d("LoadingProgress = " + newProgress);
                if (newProgress == 100) {
                    this.this$0.setLoading$hive_promotion_release(false);
                } else if (newProgress > 0) {
                    this.this$0.setLoading$hive_promotion_release(true);
                }
                ProgressBar promotion_view_spinner = this.this$0.getPromotion_view_spinner();
                if (promotion_view_spinner != null) {
                    promotion_view_spinner.setProgress(newProgress);
                }
                ProgressBar promotion_view_full_loadingbar = this.this$0.getPromotion_view_full_loadingbar();
                if (promotion_view_full_loadingbar != null) {
                    promotion_view_full_loadingbar.setProgress(newProgress);
                }
                ProgressBar promotion_customview_loading_progress = this.this$0.getPromotion_customview_loading_progress();
                if (promotion_customview_loading_progress != null) {
                    promotion_customview_loading_progress.setProgress(newProgress);
                    if (newProgress >= 100) {
                        promotion_customview_loading_progress.setVisibility(4);
                    } else {
                        promotion_customview_loading_progress.setVisibility(0);
                    }
                }
                this.this$0.setLastUpdateTime$hive_promotion_release(System.nanoTime());
            }

            @Override // android.webkit.WebChromeClient
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "onShowFileChooser()");
                WebChromeClient promotionWebChromeClient = this.this$0.getPromotionWebChromeClient();
                return promotionWebChromeClient != null ? promotionWebChromeClient.onShowFileChooser(webView, filePathCallback, fileChooserParams) : super.onShowFileChooser(webView, filePathCallback, fileChooserParams);
            }
        };
        this.timeoutEvent = new Runnable() { // from class: com.hive.promotion.ui.PromotionView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PromotionView.timeoutEvent$lambda$1(this.f$0);
            }
        };
        this.mActivity = activity;
        this.mWebViewInfo = webViewInfo;
        this.displayOrientation = webViewInfo.getDisplayOrientation();
        onCreateView$hive_promotion_release(webViewInfo.getUrl());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.useCutout) {
            return;
        }
        setDisplayCutoutNever(getMRoot$hive_promotion_release());
        setOnDisplayCutoutNever(getMRoot$hive_promotion_release());
    }

    public void reCreate() {
        getWebView().saveState(this.webBundle);
        removeAllViewsInLayout();
        String str = this.mUrl;
        if (str == null) {
            str = "";
        }
        onCreateView$hive_promotion_release(str);
        getWebView().restoreState(this.webBundle);
        if (getWebView().copyBackForwardList().getSize() == 0) {
            reload();
        }
    }

    public void showWebView(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        setMWebView(onCreateWebView$hive_promotion_release());
        Uri uri = Uri.parse(url);
        Intrinsics.checkNotNull(uri);
        webViewBackgroundTransparency(new Scheme(uri));
        getMWebView().setWebViewClient(this.mWebViewClient);
        getMWebView().setWebChromeClient(this.mWebChromeClient);
        getMWebView().getSettings().setJavaScriptEnabled(true);
        getMWebView().getSettings().setDefaultTextEncodingName("UTF-8");
        getMWebView().getSettings().setCacheMode(-1);
        getMWebView().getSettings().setTextZoom(100);
        getMWebView().addJavascriptInterface(new AnonymousClass1(), "Android");
        this.mUrl = url;
    }

    /* JADX INFO: renamed from: com.hive.promotion.ui.PromotionView$showWebView$1, reason: invalid class name */
    /* JADX INFO: compiled from: PromotionView.kt */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"com/hive/promotion/ui/PromotionView$showWebView$1", "", "retry", "", "json", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 {
        AnonymousClass1() {
        }

        @JavascriptInterface
        public final void retry() {
            Log.d("JS", "retry no params");
            Handler myHandler = PromotionView.this.getMyHandler();
            final PromotionView promotionView = PromotionView.this;
            myHandler.post(new Runnable() { // from class: com.hive.promotion.ui.PromotionView$showWebView$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    promotionView.reload();
                }
            });
        }

        @JavascriptInterface
        public final void retry(String json) {
            Intrinsics.checkNotNullParameter(json, "json");
            Log.d("JS", "retry with params: " + json);
            Handler myHandler = PromotionView.this.getMyHandler();
            final PromotionView promotionView = PromotionView.this;
            myHandler.post(new Runnable() { // from class: com.hive.promotion.ui.PromotionView$showWebView$1$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    promotionView.reload();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void reload() {
        if ((getMRoot$hive_promotion_release() instanceof PromotionCustomViewBanner) || (getMRoot$hive_promotion_release() instanceof PromotionCustomViewFullscreen) || (getMRoot$hive_promotion_release() instanceof PromotionViewFullscreen)) {
            if (getMWebView().canGoBack()) {
                getMWebView().goBackOrForward(-1);
                this.isRequest = true;
                updateTimeout(this.targetTimeout);
                return;
            } else {
                this.isRequest = false;
                show();
                return;
            }
        }
        this.isRequest = false;
        this.finishTime = 0L;
        show();
    }

    public void show() {
        if (this.isRequest) {
            return;
        }
        String str = this.mUrl;
        if (str != null) {
            getMWebView().setOauthToken(HiveLifecycle.INSTANCE.getAccount().getOauthToken());
            String str2 = this.mPostdata;
            if (str2 != null) {
                HiveWebView mWebView = getMWebView();
                byte[] bytes = str2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                mWebView.postUrl(str, bytes);
            } else {
                getMWebView().loadUrl(str);
            }
        }
        this.isRequest = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void webViewBackgroundTransparency(Scheme scheme) {
        if (Intrinsics.areEqual(scheme.getParameter().get("hive_transparent"), "true")) {
            getMWebView().setBackgroundColor(0);
        }
    }

    private final void updateTimeout(long timeout) {
        this.targetTimeout = timeout;
        this.myHandler.removeCallbacks(this.timeoutEvent);
        long j = this.targetTimeout;
        if (j <= 0 || this.finishTime != 0) {
            return;
        }
        this.myHandler.postDelayed(this.timeoutEvent, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeTimeout() {
        this.myHandler.removeCallbacks(this.timeoutEvent);
    }

    public final void showErrorPage() {
        getMWebView().stopLoading();
        String gameLanguage = Configuration.INSTANCE.getGameLanguage();
        getMWebView().loadUrl("file:///android_res/raw/hive_error_embed.html?lang=" + gameLanguage);
    }

    private final void setDisplayCutoutNever(View rootView) {
        if (Build.VERSION.SDK_INT >= 28) {
            rootView.setBackgroundColor(-16777216);
            try {
                DisplayCutout displayCutout = rootView.getRootWindowInsets().getDisplayCutout();
                if (displayCutout != null) {
                    rootView.setPadding(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom());
                }
            } catch (Exception e) {
                Logger.INSTANCE.w("[PromotionView] setDisplayCutoutNever()\ne: " + e.getMessage());
            }
        }
    }

    private final void setOnDisplayCutoutNever(View rootView) {
        if (Build.VERSION.SDK_INT >= 28) {
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.hive.promotion.ui.PromotionView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return PromotionView.setOnDisplayCutoutNever$lambda$5(this.f$0, view, windowInsets);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets setOnDisplayCutoutNever$lambda$5(PromotionView promotionView, View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        promotionView.setDisplayCutoutNever(view);
        return windowInsets;
    }

    /* JADX INFO: compiled from: PromotionView.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0004RSTUB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010Q\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u001a\u0010\u001b\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\u001e\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R\u001a\u0010!\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010$\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u001a\u0010'\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\t\"\u0004\bD\u0010\u000bR\u001e\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010J\u001a\u0004\bE\u0010G\"\u0004\bH\u0010IR\u001a\u0010K\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\t\"\u0004\bM\u0010\u000bR\u001a\u0010N\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\t\"\u0004\bP\u0010\u000b¨\u0006V"}, d2 = {"Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "typeWebView", "getTypeWebView", "setTypeWebView", "contentKey", "getContentKey", "setContentKey", AnalyticsProviderAdjust.EventKeys.pid, "", "getPid", "()I", "setPid", "(I)V", "landImageWidth", "getLandImageWidth", "setLandImageWidth", "landImageHeight", "getLandImageHeight", "setLandImageHeight", "portImageWidth", "getPortImageWidth", "setPortImageWidth", "portImageHeight", "getPortImageHeight", "setPortImageHeight", "state", "getState", "setState", "style", "getStyle", "setStyle", "badge", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo$Badge;", "getBadge", "()Lcom/hive/promotion/ui/PromotionView$WebViewInfo$Badge;", "setBadge", "(Lcom/hive/promotion/ui/PromotionView$WebViewInfo$Badge;)V", "appearance", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo$ViewAppearance;", "getAppearance", "()Lcom/hive/promotion/ui/PromotionView$WebViewInfo$ViewAppearance;", "setAppearance", "(Lcom/hive/promotion/ui/PromotionView$WebViewInfo$ViewAppearance;)V", "bannerDetail", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo$BannerDetail;", "getBannerDetail", "()Lcom/hive/promotion/ui/PromotionView$WebViewInfo$BannerDetail;", "setBannerDetail", "(Lcom/hive/promotion/ui/PromotionView$WebViewInfo$BannerDetail;)V", "webBanner", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo$WebBanner;", "getWebBanner", "()Lcom/hive/promotion/ui/PromotionView$WebViewInfo$WebBanner;", "setWebBanner", "(Lcom/hive/promotion/ui/PromotionView$WebViewInfo$WebBanner;)V", "groupId", "getGroupId", "setGroupId", "isAdvGroup", "", "()Ljava/lang/Boolean;", "setAdvGroup", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "typeCamp", "getTypeCamp", "setTypeCamp", "displayOrientation", "getDisplayOrientation", "setDisplayOrientation", InAppPurchaseConstants.METHOD_TO_STRING, "Badge", "ViewAppearance", "BannerDetail", "WebBanner", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WebViewInfo {
        private ViewAppearance appearance;
        private Badge badge;
        private BannerDetail bannerDetail;
        private String contentKey;
        private String displayOrientation;
        private String groupId;
        private Boolean isAdvGroup;
        private final JSONObject jsonObj;
        private int landImageHeight;
        private int landImageWidth;
        private int pid;
        private int portImageHeight;
        private int portImageWidth;
        private int state;
        private String style;
        private String typeCamp;
        private String typeWebView;
        private String url;
        private WebBanner webBanner;

        public WebViewInfo(JSONObject jsonObj) {
            Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
            this.jsonObj = jsonObj;
            this.url = "";
            this.typeWebView = "";
            this.contentKey = "";
            this.style = "";
            this.typeCamp = "";
            this.displayOrientation = "";
            String strOptString = jsonObj.optString("url");
            Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
            this.url = strOptString;
            String strOptString2 = jsonObj.optString("type_webview");
            Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
            this.typeWebView = strOptString2;
            String strOptString3 = jsonObj.optString("content_key");
            Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
            this.contentKey = strOptString3;
            this.pid = jsonObj.optInt(AnalyticsProviderAdjust.EventKeys.pid);
            this.landImageWidth = jsonObj.optInt("land_image_width");
            this.landImageHeight = jsonObj.optInt("land_image_height");
            this.portImageWidth = jsonObj.optInt("port_image_width");
            this.portImageHeight = jsonObj.optInt("port_image_height");
            this.state = jsonObj.optInt("state");
            String strOptString4 = jsonObj.optString("style");
            Intrinsics.checkNotNullExpressionValue(strOptString4, "optString(...)");
            this.style = strOptString4;
            JSONObject jSONObjectOptJSONObject = jsonObj.optJSONObject("badge");
            if (jSONObjectOptJSONObject != null) {
                this.badge = new Badge(jSONObjectOptJSONObject);
            }
            JSONObject jSONObjectOptJSONObject2 = jsonObj.optJSONObject("appearance");
            if (jSONObjectOptJSONObject2 != null) {
                this.appearance = new ViewAppearance(jSONObjectOptJSONObject2);
            }
            JSONObject jSONObjectOptJSONObject3 = jsonObj.optJSONObject("banner_detail");
            if (jSONObjectOptJSONObject3 != null) {
                this.bannerDetail = new BannerDetail(jSONObjectOptJSONObject3);
            }
            JSONObject jSONObjectOptJSONObject4 = jsonObj.optJSONObject("web_banner");
            if (jSONObjectOptJSONObject4 != null) {
                this.webBanner = new WebBanner(jSONObjectOptJSONObject4);
            }
            this.groupId = ExtentionsKt.optStringOrNull(jsonObj, FirebaseAnalytics.Param.GROUP_ID);
            this.isAdvGroup = ExtentionsKt.optBooleanOrNull(jsonObj, "is_adv_group");
            String strOptString5 = jsonObj.optString("type_camp");
            Intrinsics.checkNotNullExpressionValue(strOptString5, "optString(...)");
            this.typeCamp = strOptString5;
            String strOptString6 = jsonObj.optString("display_orientation");
            Intrinsics.checkNotNullExpressionValue(strOptString6, "optString(...)");
            this.displayOrientation = strOptString6;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public final String getTypeWebView() {
            return this.typeWebView;
        }

        public final void setTypeWebView(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.typeWebView = str;
        }

        public final String getContentKey() {
            return this.contentKey;
        }

        public final void setContentKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.contentKey = str;
        }

        public final int getPid() {
            return this.pid;
        }

        public final void setPid(int i) {
            this.pid = i;
        }

        public final int getLandImageWidth() {
            return this.landImageWidth;
        }

        public final void setLandImageWidth(int i) {
            this.landImageWidth = i;
        }

        public final int getLandImageHeight() {
            return this.landImageHeight;
        }

        public final void setLandImageHeight(int i) {
            this.landImageHeight = i;
        }

        public final int getPortImageWidth() {
            return this.portImageWidth;
        }

        public final void setPortImageWidth(int i) {
            this.portImageWidth = i;
        }

        public final int getPortImageHeight() {
            return this.portImageHeight;
        }

        public final void setPortImageHeight(int i) {
            this.portImageHeight = i;
        }

        public final int getState() {
            return this.state;
        }

        public final void setState(int i) {
            this.state = i;
        }

        public final String getStyle() {
            return this.style;
        }

        public final void setStyle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.style = str;
        }

        public final Badge getBadge() {
            return this.badge;
        }

        public final void setBadge(Badge badge) {
            this.badge = badge;
        }

        public final ViewAppearance getAppearance() {
            return this.appearance;
        }

        public final void setAppearance(ViewAppearance viewAppearance) {
            this.appearance = viewAppearance;
        }

        public final BannerDetail getBannerDetail() {
            return this.bannerDetail;
        }

        public final void setBannerDetail(BannerDetail bannerDetail) {
            this.bannerDetail = bannerDetail;
        }

        public final WebBanner getWebBanner() {
            return this.webBanner;
        }

        public final void setWebBanner(WebBanner webBanner) {
            this.webBanner = webBanner;
        }

        public final String getGroupId() {
            return this.groupId;
        }

        public final void setGroupId(String str) {
            this.groupId = str;
        }

        /* JADX INFO: renamed from: isAdvGroup, reason: from getter */
        public final Boolean getIsAdvGroup() {
            return this.isAdvGroup;
        }

        public final void setAdvGroup(Boolean bool) {
            this.isAdvGroup = bool;
        }

        public final String getTypeCamp() {
            return this.typeCamp;
        }

        public final void setTypeCamp(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.typeCamp = str;
        }

        public final String getDisplayOrientation() {
            return this.displayOrientation;
        }

        public final void setDisplayOrientation(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.displayOrientation = str;
        }

        public String toString() throws JSONException {
            String string = this.jsonObj.toString(4);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }

        /* JADX INFO: compiled from: PromotionView.kt */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/hive/promotion/ui/PromotionView$WebViewInfo$Badge;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "typeBadge", "", "getTypeBadge", "()Ljava/lang/String;", "setTypeBadge", "(Ljava/lang/String;)V", "startDate", "", "getStartDate", "()I", "setStartDate", "(I)V", "expire", "getExpire", "setExpire", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Badge {
            private int expire;
            private final JSONObject jsonObj;
            private int startDate;
            private String typeBadge;

            public Badge(JSONObject jsonObj) {
                Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
                this.jsonObj = jsonObj;
                this.typeBadge = "";
                this.startDate = -1;
                this.expire = -1;
                try {
                    String string = jsonObj.getString("type_badge");
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    this.typeBadge = string;
                    this.startDate = jsonObj.getInt("startdate");
                    this.expire = jsonObj.getInt("expire_second");
                } catch (Exception e) {
                    Logger.INSTANCE.w(PromotionView.INSTANCE.getTAG(), "[PromotionNetwork] Badge Exception: " + e);
                }
            }

            public final String getTypeBadge() {
                return this.typeBadge;
            }

            public final void setTypeBadge(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.typeBadge = str;
            }

            public final int getStartDate() {
                return this.startDate;
            }

            public final void setStartDate(int i) {
                this.startDate = i;
            }

            public final int getExpire() {
                return this.expire;
            }

            public final void setExpire(int i) {
                this.expire = i;
            }

            public String toString() throws JSONException {
                String string = this.jsonObj.toString(4);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        }

        /* JADX INFO: compiled from: PromotionView.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/hive/promotion/ui/PromotionView$WebViewInfo$ViewAppearance;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "frameColor", "getFrameColor", "setFrameColor", "navbarColor", "getNavbarColor", "setNavbarColor", "navbarButtonInactiveColor", "getNavbarButtonInactiveColor", "setNavbarButtonInactiveColor", InAppPurchaseConstants.METHOD_TO_STRING, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ViewAppearance {
            private String frameColor;
            private final JSONObject jsonObj;
            private String navbarButtonInactiveColor;
            private String navbarColor;
            private String type;

            public ViewAppearance(JSONObject jsonObj) {
                Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
                this.jsonObj = jsonObj;
                this.type = "";
                this.frameColor = "#ff9030";
                this.navbarColor = "#ba9d81";
                this.navbarButtonInactiveColor = "#f9f9f9";
                try {
                    String string = jsonObj.getString("type");
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    this.type = string;
                    String strOptString = jsonObj.optString("frame_color", "#ff9030");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    this.frameColor = strOptString;
                    String strOptString2 = jsonObj.optString("navbar_color", "#ba9d81");
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    this.navbarColor = strOptString2;
                    String strOptString3 = jsonObj.optString("navbar_button_inactive_color", "#f9f9f9");
                    Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                    this.navbarButtonInactiveColor = strOptString3;
                } catch (Exception e) {
                    Logger.INSTANCE.w(PromotionView.INSTANCE.getTAG(), "[PromotionNetwork] ViewAppearance Exception: " + e);
                }
            }

            public final String getType() {
                return this.type;
            }

            public final void setType(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.type = str;
            }

            public final String getFrameColor() {
                return this.frameColor;
            }

            public final void setFrameColor(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.frameColor = str;
            }

            public final String getNavbarColor() {
                return this.navbarColor;
            }

            public final void setNavbarColor(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.navbarColor = str;
            }

            public final String getNavbarButtonInactiveColor() {
                return this.navbarButtonInactiveColor;
            }

            public final void setNavbarButtonInactiveColor(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.navbarButtonInactiveColor = str;
            }

            public String toString() throws JSONException {
                String string = this.jsonObj.toString(4);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        }

        /* JADX INFO: compiled from: PromotionView.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010*\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR\u001c\u0010!\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/hive/promotion/ui/PromotionView$WebViewInfo$BannerDetail;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "rawdata", "", "getRawdata", "()Ljava/lang/String;", "setRawdata", "(Ljava/lang/String;)V", "bucketNumber", "", "getBucketNumber", "()I", "setBucketNumber", "(I)V", "imageUrl", "getImageUrl", "setImageUrl", "interworkUrl", "getInterworkUrl", "setInterworkUrl", "portImageUrl", "getPortImageUrl", "setPortImageUrl", "landImageUrl", "getLandImageUrl", "setLandImageUrl", "bannerLink", "getBannerLink", "setBannerLink", "typeLink", "getTypeLink", "setTypeLink", "eventPeriod", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo$BannerDetail$EventPeriod;", "getEventPeriod", "()Lcom/hive/promotion/ui/PromotionView$WebViewInfo$BannerDetail$EventPeriod;", "setEventPeriod", "(Lcom/hive/promotion/ui/PromotionView$WebViewInfo$BannerDetail$EventPeriod;)V", InAppPurchaseConstants.METHOD_TO_STRING, "EventPeriod", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class BannerDetail {
            private String bannerLink;
            private int bucketNumber;
            private EventPeriod eventPeriod;
            private String imageUrl;
            private String interworkUrl;
            private final JSONObject jsonObj;
            private String landImageUrl;
            private String portImageUrl;
            private String rawdata;
            private String typeLink;

            public BannerDetail(JSONObject jsonObj) {
                Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
                this.jsonObj = jsonObj;
                this.rawdata = jsonObj.toString();
                try {
                    this.bucketNumber = jsonObj.optInt("bucket_number");
                    this.imageUrl = jsonObj.optString("image");
                    this.interworkUrl = jsonObj.optString("interwork_url");
                    this.portImageUrl = ExtentionsKt.optStringOrNull(jsonObj, "port_image");
                    this.landImageUrl = ExtentionsKt.optStringOrNull(jsonObj, "land_image");
                    this.bannerLink = jsonObj.getString("link");
                    this.typeLink = jsonObj.getString("type_link");
                    JSONObject jSONObjectOptJSONObject = jsonObj.optJSONObject("event_period");
                    if (jSONObjectOptJSONObject != null) {
                        this.eventPeriod = new EventPeriod(jSONObjectOptJSONObject);
                    }
                } catch (JSONException e) {
                    Logger.INSTANCE.w("[PromotionView] BannerDetail.init()\ne: " + e.getMessage());
                }
            }

            public final String getRawdata() {
                return this.rawdata;
            }

            public final void setRawdata(String str) {
                this.rawdata = str;
            }

            public final int getBucketNumber() {
                return this.bucketNumber;
            }

            public final void setBucketNumber(int i) {
                this.bucketNumber = i;
            }

            public final String getImageUrl() {
                return this.imageUrl;
            }

            public final void setImageUrl(String str) {
                this.imageUrl = str;
            }

            public final String getInterworkUrl() {
                return this.interworkUrl;
            }

            public final void setInterworkUrl(String str) {
                this.interworkUrl = str;
            }

            public final String getPortImageUrl() {
                return this.portImageUrl;
            }

            public final void setPortImageUrl(String str) {
                this.portImageUrl = str;
            }

            public final String getLandImageUrl() {
                return this.landImageUrl;
            }

            public final void setLandImageUrl(String str) {
                this.landImageUrl = str;
            }

            public final String getBannerLink() {
                return this.bannerLink;
            }

            public final void setBannerLink(String str) {
                this.bannerLink = str;
            }

            public final String getTypeLink() {
                return this.typeLink;
            }

            public final void setTypeLink(String str) {
                this.typeLink = str;
            }

            public final EventPeriod getEventPeriod() {
                return this.eventPeriod;
            }

            public final void setEventPeriod(EventPeriod eventPeriod) {
                this.eventPeriod = eventPeriod;
            }

            /* JADX INFO: compiled from: PromotionView.kt */
            @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/hive/promotion/ui/PromotionView$WebViewInfo$BannerDetail$EventPeriod;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "visiable", "", "getVisiable", "()Ljava/lang/String;", "setVisiable", "(Ljava/lang/String;)V", "periodText", "getPeriodText", "setPeriodText", "message", "getMessage", "setMessage", "time", "getTime", "setTime", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class EventPeriod {
                private String message;
                private String periodText;
                private String time;
                private String visiable;

                public EventPeriod(JSONObject jsonObj) {
                    Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
                    this.visiable = "n";
                    try {
                        String strOptString = jsonObj.optString("visiable", "n");
                        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                        this.visiable = strOptString;
                        if (Intrinsics.areEqual("y", strOptString)) {
                            this.periodText = jsonObj.optString("text", null);
                            this.message = jsonObj.optString("message");
                            this.time = jsonObj.optString("time");
                        }
                    } catch (JSONException e) {
                        Logger.INSTANCE.w("[PromotionView] EventPeriod.init()\ne: " + e.getMessage());
                    }
                }

                public final String getVisiable() {
                    return this.visiable;
                }

                public final void setVisiable(String str) {
                    Intrinsics.checkNotNullParameter(str, "<set-?>");
                    this.visiable = str;
                }

                public final String getPeriodText() {
                    return this.periodText;
                }

                public final void setPeriodText(String str) {
                    this.periodText = str;
                }

                public final String getMessage() {
                    return this.message;
                }

                public final void setMessage(String str) {
                    this.message = str;
                }

                public final String getTime() {
                    return this.time;
                }

                public final void setTime(String str) {
                    this.time = str;
                }
            }

            public String toString() throws JSONException {
                String string = this.jsonObj.toString(4);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        }

        /* JADX INFO: compiled from: PromotionView.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/hive/promotion/ui/PromotionView$WebViewInfo$WebBanner;", "", "jsonObj", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "use", "", "getUse", "()I", "setUse", "(I)V", InAppPurchaseConstants.METHOD_TO_STRING, "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class WebBanner {
            private final JSONObject jsonObj;
            private int use;

            public WebBanner(JSONObject jsonObj) {
                Intrinsics.checkNotNullParameter(jsonObj, "jsonObj");
                this.jsonObj = jsonObj;
                this.use = jsonObj.optInt("use");
            }

            public final int getUse() {
                return this.use;
            }

            public final void setUse(int i) {
                this.use = i;
            }

            public String toString() throws JSONException {
                String string = this.jsonObj.toString(4);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return string;
            }
        }
    }
}
