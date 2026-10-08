package com.hive.ui.common.view;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebHistoryItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedCallback;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.Configuration;
import com.hive.core.Logger;
import com.hive.core.OauthToken;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.core.webview.SchemeHandler;
import com.hive.ui.Resource;
import com.hive.ui.common.model.HiveCustomViewBannerData;
import com.hive.ui.common.model.OnClosedListener;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HiveCustomViewBanner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001*B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u0002\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020!H\u0002J\u0018\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/hive/ui/common/view/HiveCustomViewBanner;", "Lcom/hive/ui/common/view/HiveView;", "activity", "Landroid/app/Activity;", "data", "Lcom/hive/ui/common/model/HiveCustomViewBannerData;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/ui/common/model/OnClosedListener;", "<init>", "(Landroid/app/Activity;Lcom/hive/ui/common/model/HiveCustomViewBannerData;Lcom/hive/ui/common/model/OnClosedListener;)V", "appearance", "Lcom/hive/ui/common/view/HiveCustomViewBanner$ViewAppearance;", "url", "", "postData", "token", "Lcom/hive/core/OauthToken;", "schemeHandler", "Lcom/hive/core/webview/SchemeHandler;", "chromeClient", "Landroid/webkit/WebChromeClient;", "btnPrev", "Landroid/widget/ImageView;", "btnNext", "btnRefresh", "btnClose", "spinnerProgressBar", "Landroid/widget/ProgressBar;", "loadingProgressBar", "mWebViewClient", "Lcom/hive/core/webview/HiveWebViewClient;", "mChromeClient", "onCreateView", "", "initButtons", "onBackPressed", "Landroidx/activity/ComponentActivity;", "checkHistoryAndUpdateButton", "updateButtons", "view", "isEnabled", "", "ViewAppearance", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveCustomViewBanner extends HiveView {
    private final ViewAppearance appearance;
    private ImageView btnClose;
    private ImageView btnNext;
    private ImageView btnPrev;
    private ImageView btnRefresh;
    private final WebChromeClient chromeClient;
    private final OnClosedListener listener;
    private ProgressBar loadingProgressBar;
    private final WebChromeClient mChromeClient;
    private final HiveWebViewClient mWebViewClient;
    private final String postData;
    private final SchemeHandler schemeHandler;
    private ProgressBar spinnerProgressBar;
    private final OauthToken token;
    private final String url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveCustomViewBanner(Activity activity, HiveCustomViewBannerData data, OnClosedListener onClosedListener) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(data, "data");
        this.listener = onClosedListener;
        this.appearance = data.getAppearance();
        String url = data.getUrl();
        this.url = url;
        String postData = data.getPostData();
        this.postData = postData;
        OauthToken token = data.getToken();
        this.token = token;
        final SchemeHandler schemeHandler = data.getSchemeHandler();
        this.schemeHandler = schemeHandler;
        this.chromeClient = data.getChromeClient();
        HiveWebViewClient hiveWebViewClient = new HiveWebViewClient(schemeHandler) { // from class: com.hive.ui.common.view.HiveCustomViewBanner$mWebViewClient$1
            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url2, Bitmap favicon) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                ProgressBar progressBar = this.this$0.spinnerProgressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("spinnerProgressBar");
                    progressBar = null;
                }
                progressBar.bringToFront();
                progressBar.setVisibility(0);
            }

            @Override // com.hive.core.webview.HiveWebViewClient, android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url2) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url2, "url");
                ProgressBar progressBar = this.this$0.spinnerProgressBar;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("spinnerProgressBar");
                    progressBar = null;
                }
                progressBar.setVisibility(8);
                this.this$0.checkHistoryAndUpdateButton();
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
                    view.loadUrl("file:///android_res/raw/hive_error_embed.html?lang=" + gameLanguage);
                }
            }
        };
        this.mWebViewClient = hiveWebViewClient;
        WebChromeClient webChromeClient = new WebChromeClient() { // from class: com.hive.ui.common.view.HiveCustomViewBanner$mChromeClient$1
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                ProgressBar progressBar = this.this$0.spinnerProgressBar;
                ProgressBar progressBar2 = null;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("spinnerProgressBar");
                    progressBar = null;
                }
                progressBar.setProgress(newProgress);
                ProgressBar progressBar3 = this.this$0.loadingProgressBar;
                if (progressBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("loadingProgressBar");
                } else {
                    progressBar2 = progressBar3;
                }
                progressBar2.setProgress(newProgress);
                if (newProgress >= 100) {
                    progressBar2.setVisibility(4);
                } else {
                    progressBar2.setVisibility(0);
                }
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

    /* JADX INFO: compiled from: HiveCustomViewBanner.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/hive/ui/common/view/HiveCustomViewBanner$ViewAppearance;", "", "frameColor", "", "navbarColor", "navbarButtonInactiveColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFrameColor", "()Ljava/lang/String;", "getNavbarColor", "getNavbarButtonInactiveColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class ViewAppearance {
        private final String frameColor;
        private final String navbarButtonInactiveColor;
        private final String navbarColor;

        public static /* synthetic */ ViewAppearance copy$default(ViewAppearance viewAppearance, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = viewAppearance.frameColor;
            }
            if ((i & 2) != 0) {
                str2 = viewAppearance.navbarColor;
            }
            if ((i & 4) != 0) {
                str3 = viewAppearance.navbarButtonInactiveColor;
            }
            return viewAppearance.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFrameColor() {
            return this.frameColor;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getNavbarColor() {
            return this.navbarColor;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getNavbarButtonInactiveColor() {
            return this.navbarButtonInactiveColor;
        }

        public final ViewAppearance copy(String frameColor, String navbarColor, String navbarButtonInactiveColor) {
            Intrinsics.checkNotNullParameter(frameColor, "frameColor");
            Intrinsics.checkNotNullParameter(navbarColor, "navbarColor");
            Intrinsics.checkNotNullParameter(navbarButtonInactiveColor, "navbarButtonInactiveColor");
            return new ViewAppearance(frameColor, navbarColor, navbarButtonInactiveColor);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewAppearance)) {
                return false;
            }
            ViewAppearance viewAppearance = (ViewAppearance) other;
            return Intrinsics.areEqual(this.frameColor, viewAppearance.frameColor) && Intrinsics.areEqual(this.navbarColor, viewAppearance.navbarColor) && Intrinsics.areEqual(this.navbarButtonInactiveColor, viewAppearance.navbarButtonInactiveColor);
        }

        public int hashCode() {
            return (((this.frameColor.hashCode() * 31) + this.navbarColor.hashCode()) * 31) + this.navbarButtonInactiveColor.hashCode();
        }

        public String toString() {
            return "ViewAppearance(frameColor=" + this.frameColor + ", navbarColor=" + this.navbarColor + ", navbarButtonInactiveColor=" + this.navbarButtonInactiveColor + ')';
        }

        public ViewAppearance(String frameColor, String navbarColor, String navbarButtonInactiveColor) {
            Intrinsics.checkNotNullParameter(frameColor, "frameColor");
            Intrinsics.checkNotNullParameter(navbarColor, "navbarColor");
            Intrinsics.checkNotNullParameter(navbarButtonInactiveColor, "navbarButtonInactiveColor");
            this.frameColor = frameColor;
            this.navbarColor = navbarColor;
            this.navbarButtonInactiveColor = navbarButtonInactiveColor;
        }

        public final String getFrameColor() {
            return this.frameColor;
        }

        public final String getNavbarColor() {
            return this.navbarColor;
        }

        public final String getNavbarButtonInactiveColor() {
            return this.navbarButtonInactiveColor;
        }
    }

    @Override // com.hive.ui.common.view.HiveView
    public void onCreateView(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Activity activity2 = activity;
        View viewInflate = View.inflate(activity2, Resource.INSTANCE.getLayoutId(activity2, "promotion_customview_v2_banner"), this);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.hive.ui.common.view.HiveView");
        setMRoot((HiveView) viewInflate);
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(activity2, "promotion_customview_v2_webview"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        setWebView((HiveWebView) viewFindViewById);
        View viewFindViewById2 = findViewById(Resource.INSTANCE.getViewId(activity2, "promotion_view_spinner"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
        this.spinnerProgressBar = (ProgressBar) viewFindViewById2;
        View viewFindViewById3 = findViewById(Resource.INSTANCE.getViewId(activity2, "promotion_customview_v2_loadingbar"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ProgressBar");
        this.loadingProgressBar = (ProgressBar) viewFindViewById3;
        initButtons();
        if (activity instanceof ComponentActivity) {
            onBackPressed((ComponentActivity) activity);
        }
    }

    private final void initButtons() {
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(getActivity(), "promotion_customview_v2_bottom"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        View viewFindViewById2 = findViewById(Resource.INSTANCE.getViewId(getActivity(), "promotion_customview_v2_bg"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
        View viewFindViewById3 = findViewById(Resource.INSTANCE.getViewId(getActivity(), "promotion_customview_v2_btn_prev"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        this.btnPrev = (ImageView) viewFindViewById3;
        View viewFindViewById4 = findViewById(Resource.INSTANCE.getViewId(getActivity(), "promotion_customview_v2_btn_next"));
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        this.btnNext = (ImageView) viewFindViewById4;
        View viewFindViewById5 = findViewById(Resource.INSTANCE.getViewId(getActivity(), "promotion_customview_v2_btn_refresh"));
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        this.btnRefresh = (ImageView) viewFindViewById5;
        View viewFindViewById6 = findViewById(Resource.INSTANCE.getViewId(getActivity(), "promotion_customview_v2_btn_close"));
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.ImageView");
        this.btnClose = (ImageView) viewFindViewById6;
        Drawable current = ((LinearLayout) viewFindViewById2).getBackground().getCurrent();
        Intrinsics.checkNotNull(current, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        ((GradientDrawable) current).setColor(Color.parseColor(this.appearance.getFrameColor()));
        ((LinearLayout) viewFindViewById).setBackgroundColor(Color.parseColor(this.appearance.getNavbarColor()));
        ImageView imageView = this.btnPrev;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
            imageView = null;
        }
        imageView.setColorFilter(Color.parseColor(this.appearance.getFrameColor()));
        ImageView imageView3 = this.btnNext;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
            imageView3 = null;
        }
        imageView3.setColorFilter(Color.parseColor(this.appearance.getFrameColor()));
        ImageView imageView4 = this.btnRefresh;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRefresh");
            imageView4 = null;
        }
        imageView4.setColorFilter(Color.parseColor(this.appearance.getFrameColor()));
        ImageView imageView5 = this.btnClose;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnClose");
            imageView5 = null;
        }
        imageView5.setColorFilter(Color.parseColor(this.appearance.getFrameColor()));
        ImageView imageView6 = this.btnPrev;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
            imageView6 = null;
        }
        TouchEffectKt.setTouchEffect(imageView6, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(this.appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.ui.common.view.HiveCustomViewBanner$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveCustomViewBanner.initButtons$lambda$0(this.f$0, (View) obj);
            }
        } : null);
        ImageView imageView7 = this.btnNext;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
            imageView7 = null;
        }
        TouchEffectKt.setTouchEffect(imageView7, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(this.appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.ui.common.view.HiveCustomViewBanner$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveCustomViewBanner.initButtons$lambda$1(this.f$0, (View) obj);
            }
        } : null);
        ImageView imageView8 = this.btnRefresh;
        if (imageView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRefresh");
            imageView8 = null;
        }
        TouchEffectKt.setTouchEffect(imageView8, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(this.appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.ui.common.view.HiveCustomViewBanner$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveCustomViewBanner.initButtons$lambda$2(this.f$0, (View) obj);
            }
        } : null);
        ImageView imageView9 = this.btnClose;
        if (imageView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnClose");
            imageView9 = null;
        }
        TouchEffectKt.setTouchEffect(imageView9, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(this.appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.ui.common.view.HiveCustomViewBanner$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveCustomViewBanner.initButtons$lambda$3(this.f$0, (View) obj);
            }
        } : null);
        ImageView imageView10 = this.btnPrev;
        if (imageView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
            imageView10 = null;
        }
        imageView10.setImageResource(Resource.INSTANCE.getDrawableId(getActivity(), "promotion_customview_btn_prev_vector"));
        ImageView imageView11 = this.btnNext;
        if (imageView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnNext");
            imageView11 = null;
        }
        imageView11.setImageResource(Resource.INSTANCE.getDrawableId(getActivity(), "promotion_customview_btn_next_vector"));
        ImageView imageView12 = this.btnRefresh;
        if (imageView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRefresh");
            imageView12 = null;
        }
        imageView12.setImageResource(Resource.INSTANCE.getDrawableId(getActivity(), "promotion_customview_btn_refresh_vector"));
        ImageView imageView13 = this.btnClose;
        if (imageView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnClose");
        } else {
            imageView2 = imageView13;
        }
        imageView2.setImageResource(Resource.INSTANCE.getDrawableId(getActivity(), "promotion_customview_btn_close_vector"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$0(HiveCustomViewBanner hiveCustomViewBanner, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (hiveCustomViewBanner.getBackUrlIndex() != 0) {
            hiveCustomViewBanner.getWebView().goBackOrForward(hiveCustomViewBanner.getBackUrlIndex());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$1(HiveCustomViewBanner hiveCustomViewBanner, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (hiveCustomViewBanner.getForwardUrlIndex() != 0) {
            hiveCustomViewBanner.getWebView().goBackOrForward(hiveCustomViewBanner.getForwardUrlIndex());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$2(HiveCustomViewBanner hiveCustomViewBanner, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        hiveCustomViewBanner.getWebView().reload();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$3(HiveCustomViewBanner hiveCustomViewBanner, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        OnClosedListener onClosedListener = hiveCustomViewBanner.listener;
        if (onClosedListener != null) {
            onClosedListener.onClosed();
        }
        return Unit.INSTANCE;
    }

    private final void onBackPressed(ComponentActivity activity) {
        activity.getOnBackPressedDispatcher().addCallback(activity, new OnBackPressedCallback() { // from class: com.hive.ui.common.view.HiveCustomViewBanner.onBackPressed.1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (HiveCustomViewBanner.this.getWebView().canGoBack()) {
                    Logger.INSTANCE.d("[HiveCustomViewBanner] onBackPressed goBack()");
                    HiveCustomViewBanner.this.getWebView().goBack();
                    return;
                }
                Logger.INSTANCE.d("[HiveCustomViewBanner] onBackPressed activity finish()");
                OnClosedListener onClosedListener = HiveCustomViewBanner.this.listener;
                if (onClosedListener != null) {
                    onClosedListener.onClosed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkHistoryAndUpdateButton() {
        WebBackForwardList webBackForwardListCopyBackForwardList = getWebView().copyBackForwardList();
        Intrinsics.checkNotNullExpressionValue(webBackForwardListCopyBackForwardList, "copyBackForwardList(...)");
        ImageView imageView = null;
        if (webBackForwardListCopyBackForwardList.getSize() == 0) {
            ImageView imageView2 = this.btnPrev;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
                imageView2 = null;
            }
            updateButtons(imageView2, false);
            ImageView imageView3 = this.btnNext;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnNext");
                imageView3 = null;
            }
            updateButtons(imageView3, false);
            ImageView imageView4 = this.btnRefresh;
            if (imageView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnRefresh");
            } else {
                imageView = imageView4;
            }
            updateButtons(imageView, true);
            return;
        }
        WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex());
        if (itemAtIndex != null) {
            String url = itemAtIndex.getUrl();
            Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
            if (StringsKt.contains$default((CharSequence) url, (CharSequence) "hive_error_embed.html", false, 2, (Object) null)) {
                ImageView imageView5 = this.btnPrev;
                if (imageView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
                    imageView5 = null;
                }
                updateButtons(imageView5, false);
                ImageView imageView6 = this.btnNext;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnNext");
                    imageView6 = null;
                }
                updateButtons(imageView6, false);
                ImageView imageView7 = this.btnRefresh;
                if (imageView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnRefresh");
                } else {
                    imageView = imageView7;
                }
                updateButtons(imageView, false);
                return;
            }
        }
        if (getBackUrlIndex() == 0) {
            ImageView imageView8 = this.btnPrev;
            if (imageView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
                imageView8 = null;
            }
            updateButtons(imageView8, false);
        } else {
            ImageView imageView9 = this.btnPrev;
            if (imageView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
                imageView9 = null;
            }
            updateButtons(imageView9, true);
        }
        if (getForwardUrlIndex() == 0) {
            ImageView imageView10 = this.btnNext;
            if (imageView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnNext");
                imageView10 = null;
            }
            updateButtons(imageView10, false);
        } else {
            ImageView imageView11 = this.btnNext;
            if (imageView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnNext");
                imageView11 = null;
            }
            updateButtons(imageView11, true);
        }
        ImageView imageView12 = this.btnRefresh;
        if (imageView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRefresh");
        } else {
            imageView = imageView12;
        }
        updateButtons(imageView, true);
    }

    private final void updateButtons(ImageView view, boolean isEnabled) {
        view.setEnabled(isEnabled);
        if (isEnabled) {
            view.setColorFilter(Color.parseColor(this.appearance.getFrameColor()));
        } else {
            view.setColorFilter(Color.parseColor(this.appearance.getNavbarButtonInactiveColor()));
        }
    }
}
