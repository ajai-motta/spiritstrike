package com.hive.promotion.ui.news;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.Configuration;
import com.hive.core.Logger;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.core.webview.HiveWebViewClient;
import com.hive.promotion.ui.news.NewsV2View;
import com.hive.standalone.HiveLifecycle;
import com.hive.webview.HiveSchemeHandler;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: compiled from: NewsV2View.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 52\u00020\u0001:\u00044567B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010$\u001a\u00020%J\b\u0010&\u001a\u00020%H&J\b\u0010'\u001a\u00020%H\u0017J\b\u0010(\u001a\u00020%H\u0002J\u0006\u0010)\u001a\u00020%J\u0010\u0010*\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010,\u001a\u00020%J\n\u0010-\u001a\u0004\u0018\u00010.H\u0014J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u00010.H\u0014J\u000e\u0010-\u001a\u00020%2\u0006\u00101\u001a\u000202J\u000e\u0010/\u001a\u00020%2\u0006\u00103\u001a\u000202R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00068"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2View;", "Landroid/widget/FrameLayout;", "activity", "Landroid/app/Activity;", "url", "", "basePostData", "Lorg/json/JSONObject;", "showBackButton", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lorg/json/JSONObject;Z)V", "getActivity", "()Landroid/app/Activity;", "getShowBackButton", "()Z", "setShowBackButton", "(Z)V", "webView", "Lcom/hive/core/webview/HiveWebView;", "getWebView", "()Lcom/hive/core/webview/HiveWebView;", "setWebView", "(Lcom/hive/core/webview/HiveWebView;)V", "viewType", "Lcom/hive/promotion/ui/news/NewsV2View$ViewType;", "getViewType", "()Lcom/hive/promotion/ui/news/NewsV2View$ViewType;", "setViewType", "(Lcom/hive/promotion/ui/news/NewsV2View$ViewType;)V", "buttonClickListener", "Lcom/hive/promotion/ui/news/NewsV2View$ButtonClickListener;", "getButtonClickListener", "()Lcom/hive/promotion/ui/news/NewsV2View$ButtonClickListener;", "setButtonClickListener", "(Lcom/hive/promotion/ui/news/NewsV2View$ButtonClickListener;)V", MobileAdsBridgeBase.initializeMethodName, "", "onCreateView", "onCreateWebView", "postWebView", "showErrorPage", "setOnButtonClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onBackPressed", "onSaveInstanceState", "Landroid/os/Parcelable;", "onRestoreInstanceState", "state", "outState", "Landroid/os/Bundle;", "savedInstanceState", "ButtonClickListener", k.M, "ViewType", "SavedState", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class NewsV2View extends FrameLayout {
    public static final String KEY_SAVE_PARCEL = "NewsV2View.SAVE_PARCEL_KEY";
    private final Activity activity;
    private JSONObject basePostData;
    private ButtonClickListener buttonClickListener;
    private boolean showBackButton;
    private String url;
    public ViewType viewType;
    public HiveWebView webView;

    /* JADX INFO: compiled from: NewsV2View.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2View$ButtonClickListener;", "", "onBack", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ButtonClickListener {
        void onBack();
    }

    public abstract void onCreateView();

    public static final /* synthetic */ void access$postWebView(NewsV2View newsV2View) {
        newsV2View.postWebView();
    }

    public final Activity getActivity() {
        return this.activity;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsV2View(Activity activity, String url, JSONObject jSONObject, boolean z) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        this.activity = activity;
        this.url = url;
        this.basePostData = jSONObject;
        this.showBackButton = z;
    }

    public final boolean getShowBackButton() {
        return this.showBackButton;
    }

    public final void setShowBackButton(boolean z) {
        this.showBackButton = z;
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

    public final ViewType getViewType() {
        ViewType viewType = this.viewType;
        if (viewType != null) {
            return viewType;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewType");
        return null;
    }

    public final void setViewType(ViewType viewType) {
        Intrinsics.checkNotNullParameter(viewType, "<set-?>");
        this.viewType = viewType;
    }

    protected final ButtonClickListener getButtonClickListener() {
        return this.buttonClickListener;
    }

    protected final void setButtonClickListener(ButtonClickListener buttonClickListener) {
        this.buttonClickListener = buttonClickListener;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: NewsV2View.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2View$ViewType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FrameView", "FullScreenView", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ViewType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ViewType[] $VALUES;
        public static final ViewType FrameView = new ViewType("FrameView", 0, "FrameView");
        public static final ViewType FullScreenView = new ViewType("FullScreenView", 1, "FullScreenView");
        private final String value;

        private static final /* synthetic */ ViewType[] $values() {
            return new ViewType[]{FrameView, FullScreenView};
        }

        public static EnumEntries<ViewType> getEntries() {
            return $ENTRIES;
        }

        private ViewType(String str, int i, String str2) {
            this.value = str2;
        }

        public final String getValue() {
            return this.value;
        }

        static {
            ViewType[] viewTypeArr$values = $values();
            $VALUES = viewTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(viewTypeArr$values);
        }

        public static ViewType valueOf(String str) {
            return (ViewType) Enum.valueOf(ViewType.class, str);
        }

        public static ViewType[] values() {
            return (ViewType[]) $VALUES.clone();
        }
    }

    public final void initialize() {
        onCreateView();
        onCreateWebView();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.hive.promotion.ui.news.NewsV2View$onCreateWebView$schemeHandler$1] */
    public void onCreateWebView() {
        if (this.webView == null) {
            return;
        }
        getWebView().setWebViewClient(new HiveWebViewClient(new HiveSchemeHandler() { // from class: com.hive.promotion.ui.news.NewsV2View$onCreateWebView$schemeHandler$1
            @Override // com.hive.webview.HiveSchemeHandler
            public boolean schemeEvent(WebView view, Scheme scheme) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(scheme, "scheme");
                if (NewsV2Activity.INSTANCE.isSchemeEventFuncInitialized()) {
                    return NewsV2Activity.INSTANCE.getSchemeEventFunc().invoke(scheme).booleanValue();
                }
                return super.schemeEvent(view, scheme);
            }
        }, this) { // from class: com.hive.promotion.ui.news.NewsV2View.onCreateWebView.1
            final /* synthetic */ NewsV2View this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(newsV2View$onCreateWebView$schemeHandler$1);
                this.this$0 = this;
            }

            @Override // com.hive.core.webview.HiveWebViewClient
            public void receivedErrorEvent(WebView view, int errorCode, String description, String failingUrl) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.this$0.showErrorPage();
            }
        });
        getWebView().setWebChromeClient(new WebChromeClient() { // from class: com.hive.promotion.ui.news.NewsV2View.onCreateWebView.2
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
        postWebView();
    }

    /* JADX INFO: renamed from: com.hive.promotion.ui.news.NewsV2View$onCreateWebView$3, reason: invalid class name */
    /* JADX INFO: compiled from: NewsV2View.kt */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"com/hive/promotion/ui/news/NewsV2View$onCreateWebView$3", "", "retry", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass3 {
        AnonymousClass3() {
        }

        @JavascriptInterface
        public final void retry() {
            Handler handler = new Handler(Looper.getMainLooper());
            final NewsV2View newsV2View = NewsV2View.this;
            handler.post(new Runnable() { // from class: com.hive.promotion.ui.news.NewsV2View$onCreateWebView$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NewsV2View.access$postWebView(newsV2View);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postWebView() {
        JSONObject jSONObject;
        if (StringsKt.isBlank(this.url) || (jSONObject = this.basePostData) == null) {
            return;
        }
        getWebView().setOauthToken(HiveLifecycle.INSTANCE.getAccount().getOauthToken());
        HiveWebView webView = getWebView();
        String str = this.url;
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        webView.postUrl(str, bytes);
    }

    public final void showErrorPage() {
        getWebView().stopLoading();
        String gameLanguage = Configuration.INSTANCE.getGameLanguage();
        getWebView().loadUrl("file:///android_res/raw/hive_error_embed_v2.html?lang=" + gameLanguage);
        getWebView().clearHistory();
    }

    public final void setOnButtonClickListener(ButtonClickListener listener) {
        if (listener != null) {
            this.buttonClickListener = listener;
        }
    }

    public final void onBackPressed() {
        if (getWebView().canGoBack()) {
            getWebView().goBack();
            return;
        }
        ButtonClickListener buttonClickListener = this.buttonClickListener;
        if (buttonClickListener != null) {
            buttonClickListener.onBack();
        }
        Activity activity = this.activity;
        if (activity instanceof NewsV2Activity) {
            ((NewsV2Activity) activity).unlockOrientation();
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.setUrl(this.url);
        savedState.setBasePostData(String.valueOf(this.basePostData));
        savedState.setShowBackButton(String.valueOf(this.showBackButton));
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            SavedState savedState = (SavedState) state;
            super.onRestoreInstanceState(savedState.getSuperState());
            String url = savedState.getUrl();
            if (url == null) {
                url = "";
            }
            this.url = url;
            String basePostData = savedState.getBasePostData();
            this.basePostData = new JSONObject(basePostData != null ? basePostData : "");
            String showBackButton = savedState.getShowBackButton();
            this.showBackButton = showBackButton != null ? Boolean.parseBoolean(showBackButton) : true;
            return;
        }
        super.onRestoreInstanceState(state);
    }

    public final void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putParcelable(KEY_SAVE_PARCEL, onSaveInstanceState());
        getWebView().saveState(outState);
    }

    public final void onRestoreInstanceState(Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(savedInstanceState, "savedInstanceState");
        onRestoreInstanceState(savedInstanceState.getParcelable(KEY_SAVE_PARCEL));
        WebBackForwardList webBackForwardListRestoreState = getWebView().restoreState(savedInstanceState);
        if (webBackForwardListRestoreState == null || webBackForwardListRestoreState.getSize() == 0) {
            postWebView();
        }
    }

    /* JADX INFO: compiled from: NewsV2View.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2View$SavedState;", "Landroidx/customview/view/AbsSavedState;", "superState", "Landroid/os/Parcelable;", "<init>", "(Landroid/os/Parcelable;)V", "source", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "url", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "basePostData", "getBasePostData", "setBasePostData", "showBackButton", "getShowBackButton", "setShowBackButton", "writeToParcel", "", "dest", "flags", "", k.M, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SavedState extends AbsSavedState {
        private String basePostData;
        private String showBackButton;
        private String url;
        public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.hive.promotion.ui.news.NewsV2View$SavedState$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public NewsV2View.SavedState createFromParcel(Parcel source, ClassLoader loader) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(loader, "loader");
                return new NewsV2View.SavedState(source, loader);
            }

            @Override // android.os.Parcelable.Creator
            public NewsV2View.SavedState createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new NewsV2View.SavedState(source, null);
            }

            @Override // android.os.Parcelable.Creator
            public NewsV2View.SavedState[] newArray(int size) {
                return newArray(size);
            }
        };

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            this.url = str;
        }

        public final String getBasePostData() {
            return this.basePostData;
        }

        public final void setBasePostData(String str) {
            this.basePostData = str;
        }

        public final String getShowBackButton() {
            return this.showBackButton;
        }

        public final void setShowBackButton(String str) {
            this.showBackButton = str;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable superState) {
            super(superState);
            Intrinsics.checkNotNullParameter(superState, "superState");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source, ClassLoader classLoader) {
            super(source, classLoader);
            Intrinsics.checkNotNullParameter(source, "source");
            this.url = source.readString();
            this.basePostData = source.readString();
            this.showBackButton = source.readString();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            super.writeToParcel(dest, flags);
            dest.writeString(this.url);
            dest.writeString(this.basePostData);
            dest.writeString(this.showBackButton);
        }
    }
}
