package com.hive.promotion;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.adxcorp.ads.mediation.util.ReportUtil;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.ResultAPI;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.base.Property;
import com.hive.core.Logger;
import com.hive.core.Scheme;
import com.hive.core.webview.HiveWebView;
import com.hive.logger.LoggerImpl;
import com.hive.promotion.ui.PromotionView;
import com.hive.promotion.ui.PromotionViewExternalBrowser;
import com.hive.promotion.ui.PromotionViewFrame;
import com.hive.promotion.ui.PromotionViewFullscreen;
import com.hive.promotion.ui.PromotionViewImageBanner;
import com.hive.promotion.ui.PromotionViewInAppBrowser;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.ArrayList;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: PromotionDialog.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 U2\u00020\u0001:\u0003TUVB1\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0019H\u0016J\b\u0010@\u001a\u00020>H\u0016J\u0006\u0010A\u001a\u00020>J\b\u0010B\u001a\u00020>H\u0016J\n\u0010C\u001a\u0004\u0018\u00010DH\u0002J\u0006\u0010E\u001a\u00020>J\u0006\u0010F\u001a\u00020>J\u0010\u0010G\u001a\u00020>2\b\u0010H\u001a\u0004\u0018\u00010&J\u0006\u0010G\u001a\u00020>J\u0006\u0010I\u001a\u00020>J\u0016\u0010J\u001a\u00020>2\u0006\u0010K\u001a\u00020&2\u0006\u0010L\u001a\u00020&J\u000e\u0010M\u001a\u00020>2\u0006\u0010K\u001a\u00020&J\u000e\u0010N\u001a\u00020>2\u0006\u0010O\u001a\u00020PJ\u000e\u0010Q\u001a\u00020>2\u0006\u0010O\u001a\u00020PJ\u0010\u0010R\u001a\u00020>2\u0006\u0010S\u001a\u00020DH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR&\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00190\u001eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R,\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020&0%X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00107\u001a\u000208X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<¨\u0006W"}, d2 = {"Lcom/hive/promotion/PromotionDialog;", "Landroid/app/Dialog;", "activity", "Landroid/app/Activity;", "webViewInfoList", "Ljava/util/ArrayList;", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/promotion/PromotionDialog$PromotionDialogListener;", "<init>", "(Landroid/app/Activity;Ljava/util/ArrayList;Lcom/hive/promotion/PromotionDialog$PromotionDialogListener;)V", "getActivity", "()Landroid/app/Activity;", "getWebViewInfoList", "()Ljava/util/ArrayList;", "getListener", "()Lcom/hive/promotion/PromotionDialog$PromotionDialogListener;", "mMainLayout", "Landroid/widget/FrameLayout;", "getMMainLayout", "()Landroid/widget/FrameLayout;", "setMMainLayout", "(Landroid/widget/FrameLayout;)V", "isForced", "", "()Z", "setForced", "(Z)V", "schemeEventFunc", "Lkotlin/Function1;", "Lcom/hive/core/Scheme;", "getSchemeEventFunc", "()Lkotlin/jvm/functions/Function1;", "setSchemeEventFunc", "(Lkotlin/jvm/functions/Function1;)V", "generatePostDataFunc", "Lkotlin/Function2;", "", "getGeneratePostDataFunc", "()Lkotlin/jvm/functions/Function2;", "setGeneratePostDataFunc", "(Lkotlin/jvm/functions/Function2;)V", "promotionViewImageBannerListener", "Lcom/hive/promotion/ui/PromotionViewImageBanner$PromotionViewImageBannerListener;", "getPromotionViewImageBannerListener", "()Lcom/hive/promotion/ui/PromotionViewImageBanner$PromotionViewImageBannerListener;", "setPromotionViewImageBannerListener", "(Lcom/hive/promotion/ui/PromotionViewImageBanner$PromotionViewImageBannerListener;)V", "promotionWebChromeClient", "Landroid/webkit/WebChromeClient;", "getPromotionWebChromeClient", "()Landroid/webkit/WebChromeClient;", "setPromotionWebChromeClient", "(Landroid/webkit/WebChromeClient;)V", "bannerDontShowAgainPeriod", "", "getBannerDontShowAgainPeriod", "()I", "setBannerDontShowAgainPeriod", "(I)V", "onWindowFocusChanged", "", "hasFocus", "onBackPressed", "onConfigurationChanged", "show", "createPromotionView", "Lcom/hive/promotion/ui/PromotionView;", "dismissMercury", "dismissOfferwall", "closeView", "scheme", "closeViewAll", "showNewFullScreenView", "url", AdUnitActivity.EXTRA_ORIENTATION, "showFrameView", "onPlaybackStart", "resultAPI", "Lcom/hive/ResultAPI;", "onPlaybackFinish", "internalShowPromotionView", "view", "PromotionDialogListener", k.M, "Builder", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionDialog extends Dialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "PromotionDialog";
    private final Activity activity;
    private int bannerDontShowAgainPeriod;
    public Function2<? super PromotionView.WebViewInfo, ? super String, String> generatePostDataFunc;
    private boolean isForced;
    private final PromotionDialogListener listener;
    private FrameLayout mMainLayout;
    private PromotionViewImageBanner.PromotionViewImageBannerListener promotionViewImageBannerListener;
    private WebChromeClient promotionWebChromeClient;
    public Function1<? super Scheme, Boolean> schemeEventFunc;
    private final ArrayList<PromotionView.WebViewInfo> webViewInfoList;

    /* JADX INFO: compiled from: PromotionDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/hive/promotion/PromotionDialog$PromotionDialogListener;", "", "needDialogClosed", "", "result", "Lcom/hive/ResultAPI;", "scheme", "", "onDialogShow", "onPlaybackStart", "onPlaybackFinish", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PromotionDialogListener {
        void needDialogClosed(ResultAPI result);

        void needDialogClosed(ResultAPI result, String scheme);

        void onDialogShow();

        void onPlaybackFinish(ResultAPI result);

        void onPlaybackStart(ResultAPI result);
    }

    public /* synthetic */ PromotionDialog(Activity activity, ArrayList arrayList, PromotionDialogListener promotionDialogListener, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, arrayList, promotionDialogListener);
    }

    private PromotionDialog(Activity activity, ArrayList<PromotionView.WebViewInfo> arrayList, PromotionDialogListener promotionDialogListener) {
        super(activity, android.R.style.Theme.Translucent.NoTitleBar);
        this.activity = activity;
        this.webViewInfoList = arrayList;
        this.listener = promotionDialogListener;
        this.bannerDontShowAgainPeriod = -1;
        setCancelable(false);
        Resource resource = Resource.INSTANCE;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        setContentView(resource.getLayoutId(context, "promotion_dialog"));
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(activity, "promotion_dialog"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.FrameLayout");
        this.mMainLayout = (FrameLayout) viewFindViewById;
        Util.INSTANCE.hideSystemUI(getWindow());
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final PromotionDialogListener getListener() {
        return this.listener;
    }

    public final ArrayList<PromotionView.WebViewInfo> getWebViewInfoList() {
        return this.webViewInfoList;
    }

    public final FrameLayout getMMainLayout() {
        return this.mMainLayout;
    }

    public final void setMMainLayout(FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.mMainLayout = frameLayout;
    }

    /* JADX INFO: renamed from: isForced, reason: from getter */
    public final boolean getIsForced() {
        return this.isForced;
    }

    public final void setForced(boolean z) {
        this.isForced = z;
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

    public final Function2<PromotionView.WebViewInfo, String, String> getGeneratePostDataFunc() {
        Function2 function2 = this.generatePostDataFunc;
        if (function2 != null) {
            return function2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("generatePostDataFunc");
        return null;
    }

    public final void setGeneratePostDataFunc(Function2<? super PromotionView.WebViewInfo, ? super String, String> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.generatePostDataFunc = function2;
    }

    public final PromotionViewImageBanner.PromotionViewImageBannerListener getPromotionViewImageBannerListener() {
        return this.promotionViewImageBannerListener;
    }

    public final void setPromotionViewImageBannerListener(PromotionViewImageBanner.PromotionViewImageBannerListener promotionViewImageBannerListener) {
        this.promotionViewImageBannerListener = promotionViewImageBannerListener;
    }

    public final WebChromeClient getPromotionWebChromeClient() {
        return this.promotionWebChromeClient;
    }

    public final void setPromotionWebChromeClient(WebChromeClient webChromeClient) {
        this.promotionWebChromeClient = webChromeClient;
    }

    public final int getBannerDontShowAgainPeriod() {
        return this.bannerDontShowAgainPeriod;
    }

    public final void setBannerDontShowAgainPeriod(int i) {
        this.bannerDontShowAgainPeriod = i;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Util.INSTANCE.hideSystemUI(getWindow());
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.mMainLayout.getChildCount() > 0) {
            View childAt = this.mMainLayout.getChildAt(r0.getChildCount() - 1);
            if (childAt != null) {
                HiveWebView webView = ((PromotionView) childAt).getWebView();
                if (webView != null) {
                    if (webView.canGoBack()) {
                        LoggerImpl.INSTANCE.d(TAG, "webview can go back");
                        webView.goBack();
                    } else {
                        LoggerImpl.INSTANCE.d(TAG, "webview can not go back");
                        this.mMainLayout.removeViewAt(r0.getChildCount() - 1);
                    }
                } else {
                    this.mMainLayout.removeViewAt(r0.getChildCount() - 1);
                }
            }
            if (this.mMainLayout.getChildCount() == 0) {
                closeView();
            }
            Activity activity = this.activity;
            if (activity instanceof HiveUiActivity) {
                ((HiveUiActivity) activity).unlockOrientation();
            }
        }
        super.onBackPressed();
    }

    public final void onConfigurationChanged() {
        LoggerImpl.INSTANCE.i(TAG, "Call onConfigurationChanged()");
        int childCount = this.mMainLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.mMainLayout.getChildAt(i);
            if (!(childAt instanceof PromotionViewInAppBrowser) && !(childAt instanceof PromotionViewExternalBrowser)) {
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type com.hive.promotion.ui.PromotionView");
                ((PromotionView) childAt).reCreate();
            }
        }
    }

    @Override // android.app.Dialog
    public void show() {
        LoggerImpl.INSTANCE.i(TAG, "Call show()");
        PromotionView promotionViewCreatePromotionView = createPromotionView();
        if (promotionViewCreatePromotionView != null) {
            if (promotionViewCreatePromotionView instanceof PromotionViewImageBanner) {
                ((PromotionViewImageBanner) promotionViewCreatePromotionView).addViewSelf(this.mMainLayout);
                this.mMainLayout.setVisibility(4);
            }
            promotionViewCreatePromotionView.show();
            this.mMainLayout.addView(promotionViewCreatePromotionView);
            if (this.mMainLayout.getChildCount() == 0) {
                this.listener.needDialogClosed(new ResultAPI());
                return;
            } else {
                super.show();
                this.listener.onDialogShow();
                return;
            }
        }
        this.listener.needDialogClosed(new ResultAPI());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x020f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.hive.promotion.ui.PromotionView createPromotionView() {
        /*
            Method dump skipped, instruction units count: 656
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionDialog.createPromotionView():com.hive.promotion.ui.PromotionView");
    }

    public final void dismissMercury() {
        super.dismiss();
    }

    public final void dismissOfferwall() {
        super.dismiss();
    }

    public final void closeView(String scheme) {
        this.mMainLayout.removeAllViews();
        PromotionView promotionViewCreatePromotionView = createPromotionView();
        if (promotionViewCreatePromotionView != null) {
            promotionViewCreatePromotionView.show();
            this.mMainLayout.addView(promotionViewCreatePromotionView);
            return;
        }
        String str = scheme;
        if (str == null || str.length() == 0) {
            this.listener.needDialogClosed(new ResultAPI());
        } else {
            this.listener.needDialogClosed(new ResultAPI(), scheme);
        }
    }

    public final void closeView() {
        closeView("");
    }

    public final void closeViewAll() {
        this.mMainLayout.removeAllViews();
        this.listener.needDialogClosed(new ResultAPI());
    }

    public final void showNewFullScreenView(String url, String orientation) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.mMainLayout.removeAllViews();
        internalShowPromotionView(new PromotionViewFullscreen(this.activity, url, orientation));
    }

    public final void showFrameView(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.mMainLayout.removeAllViews();
        internalShowPromotionView(new PromotionViewFrame(this.activity, url));
    }

    public final void onPlaybackStart(ResultAPI resultAPI) {
        Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
        this.listener.onPlaybackStart(resultAPI);
    }

    public final void onPlaybackFinish(ResultAPI resultAPI) {
        Intrinsics.checkNotNullParameter(resultAPI, "resultAPI");
        this.listener.onPlaybackFinish(resultAPI);
    }

    private final void internalShowPromotionView(PromotionView view) {
        view.setOnButtonClickedListener(new PromotionView.ButtonClickedListener() { // from class: com.hive.promotion.PromotionDialog.internalShowPromotionView.1
            @Override // com.hive.promotion.ui.PromotionView.ButtonClickedListener
            public void onForce(String type, int pid) {
                Intrinsics.checkNotNullParameter(type, "type");
            }

            @Override // com.hive.promotion.ui.PromotionView.ButtonClickedListener
            public void onClose() {
                PromotionDialog.this.closeView();
            }
        });
        if (this.schemeEventFunc != null) {
            view.setSchemeEventFunc(getSchemeEventFunc());
        }
        view.setPromotionWebChromeClient(this.promotionWebChromeClient);
        view.show();
        this.mMainLayout.addView(view);
    }

    /* JADX INFO: compiled from: PromotionDialog.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\nJ\b\u0010\u0010\u001a\u00020\nH\u0002J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0005J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\u0006\u0010!\u001a\u00020\u001aJ\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005R\u0019\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006#"}, d2 = {"Lcom/hive/promotion/PromotionDialog$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "memorizeOffAutoParams", "", "typeWebView", AnalyticsProviderAdjust.EventKeys.pid, "", "getOffAutoParams", "checkSavedToday", "checkDontShowAgainPeriodData", "getYearAndDayOfYearFromMilliseconds", "Lkotlin/Pair;", "ms", "", "saveDontShowAgainPidList", "pidStr", "saveDontShowAgainPeriodDataList", TypedValues.CycleType.S_WAVE_PERIOD, "getDontShowAgainPidListFromType", "Lorg/json/JSONArray;", "webViewTypeValue", "contentsKey", "getDontShowAgainPidList", "getDontShowAgainPeriodPidList", "savePidOpenInfoJsonString", "getTodayYearMonthDate", "getPidOpenInfo", "getPidOpenCountString", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return PromotionDialog.TAG;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0059  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void memorizeOffAutoParams(java.lang.String r9, int r10) {
            /*
                r8 = this;
                java.lang.String r0 = "typeWebView"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                java.lang.String r0 = r8.getTodayYearMonthDate()
                int r1 = r9.hashCode()
                r2 = -1396342996(0xffffffffacc57f2c, float:-5.6131957E-12)
                java.lang.String r3 = "offauto"
                if (r1 == r2) goto L50
                r2 = 3377875(0x338ad3, float:4.733411E-39)
                if (r1 == r2) goto L28
                r2 = 3537154(0x35f902, float:4.956608E-39)
                if (r1 == r2) goto L1f
                goto L75
            L1f:
                java.lang.String r1 = "spot"
                boolean r1 = r9.equals(r1)
                if (r1 != 0) goto L59
                goto L75
            L28:
                java.lang.String r1 = "news"
                boolean r1 = r9.equals(r1)
                if (r1 != 0) goto L31
                goto L75
            L31:
                com.hive.base.Property$Companion r10 = com.hive.base.Property.INSTANCE
                com.hive.base.Property r1 = r10.getINSTANCE()
                java.lang.StringBuilder r10 = new java.lang.StringBuilder
                r10.<init>(r3)
                r10.append(r9)
                r7 = 0
                r10.append(r7)
                java.lang.String r2 = r10.toString()
                r5 = 4
                r6 = 0
                r4 = 0
                r3 = r0
                com.hive.base.Property.setValue$default(r1, r2, r3, r4, r5, r6)
                r10 = r7
                goto L75
            L50:
                java.lang.String r1 = "banner"
                boolean r1 = r9.equals(r1)
                if (r1 != 0) goto L59
                goto L75
            L59:
                com.hive.base.Property$Companion r1 = com.hive.base.Property.INSTANCE
                com.hive.base.Property r1 = r1.getINSTANCE()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>(r3)
                r2.append(r9)
                r2.append(r10)
                java.lang.String r2 = r2.toString()
                r5 = 4
                r6 = 0
                r4 = 0
                r3 = r0
                com.hive.base.Property.setValue$default(r1, r2, r3, r4, r5, r6)
            L75:
                com.hive.logger.LoggerImpl r1 = com.hive.logger.LoggerImpl.INSTANCE
                java.lang.String r2 = r8.getTAG()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "memorizeOffAutoParams. typeWebView : "
                r3.<init>(r4)
                r3.append(r9)
                java.lang.String r9 = ", pid : "
                r3.append(r9)
                r3.append(r10)
                java.lang.String r9 = ", today : "
                r3.append(r9)
                r3.append(r0)
                java.lang.String r9 = r3.toString()
                r1.i(r2, r9)
                com.hive.base.Property$Companion r9 = com.hive.base.Property.INSTANCE
                com.hive.base.Property r9 = r9.getINSTANCE()
                r9.writeProperties()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionDialog.Companion.memorizeOffAutoParams(java.lang.String, int):void");
        }

        public final String getOffAutoParams(String typeWebView, int pid) {
            String value;
            Intrinsics.checkNotNullParameter(typeWebView, "typeWebView");
            int iHashCode = typeWebView.hashCode();
            if (iHashCode != -1396342996) {
                if (iHashCode == 3377875) {
                    if (!typeWebView.equals("news")) {
                        return "";
                    }
                    value = Property.INSTANCE.getINSTANCE().getValue("offauto" + typeWebView + 0);
                    if (value == null) {
                        return "";
                    }
                    return value;
                }
                if (iHashCode != 3537154 || !typeWebView.equals("spot")) {
                    return "";
                }
            } else if (!typeWebView.equals(ReportUtil.INVENTORY_TYPE_BANNER)) {
                return "";
            }
            value = Property.INSTANCE.getINSTANCE().getValue("offauto" + typeWebView + pid);
            if (value == null) {
                return "";
            }
            return value;
        }

        public final void checkSavedToday() {
            String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.DONT_SHOW_PID_LIST_SAVED_DATE, "");
            String todayYearMonthDate = getTodayYearMonthDate();
            LoggerImpl.INSTANCE.i("checkSavedToday, savedToday : " + value + ", today : " + todayYearMonthDate);
            if (Intrinsics.areEqual(value, todayYearMonthDate)) {
                return;
            }
            Property.INSTANCE.getINSTANCE().removeValue(PromotionKeys.DONT_SHOW_AGAIN_CLICK_PID);
            checkDontShowAgainPeriodData();
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PromotionKeys.DONT_SHOW_PID_LIST_SAVED_DATE, todayYearMonthDate, null, 4, null);
            Property.INSTANCE.getINSTANCE().writeProperties();
        }

        private final void checkDontShowAgainPeriodData() {
            String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.DONT_SHOW_AGAIN_CLICK_PERIOD_DATA, "");
            if (value.length() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    Pair<Integer, Integer> yearAndDayOfYearFromMilliseconds = PromotionDialog.INSTANCE.getYearAndDayOfYearFromMilliseconds(System.currentTimeMillis());
                    JSONArray jSONArray2 = new JSONArray(value);
                    int length = jSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        int iOptInt = jSONArray2.getJSONObject(i).optInt(TypedValues.CycleType.S_WAVE_PERIOD);
                        Pair<Integer, Integer> yearAndDayOfYearFromMilliseconds2 = PromotionDialog.INSTANCE.getYearAndDayOfYearFromMilliseconds(jSONArray2.getJSONObject(i).optLong("clickDate"));
                        if (yearAndDayOfYearFromMilliseconds.getFirst().intValue() <= yearAndDayOfYearFromMilliseconds2.getFirst().intValue() && yearAndDayOfYearFromMilliseconds.getSecond().intValue() - yearAndDayOfYearFromMilliseconds2.getSecond().intValue() < iOptInt) {
                            jSONArray.put(jSONArray2.getJSONObject(i));
                        }
                    }
                    Property.setValue$default(Property.INSTANCE.getINSTANCE(), PromotionKeys.DONT_SHOW_AGAIN_CLICK_PERIOD_DATA, jSONArray.toString(), null, 4, null);
                    Property.INSTANCE.getINSTANCE().writeProperties();
                } catch (Exception e) {
                    LoggerImpl.INSTANCE.i("checkDontShowAgainPeriodData, exception : " + e);
                }
            }
        }

        private final Pair<Integer, Integer> getYearAndDayOfYearFromMilliseconds(long ms) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(ms);
            return new Pair<>(Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(6)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void saveDontShowAgainPidList(String pidStr) {
            JSONArray jSONArray;
            String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.DONT_SHOW_AGAIN_CLICK_PID, "");
            try {
                if (value.length() > 0) {
                    jSONArray = new JSONArray(value).put(pidStr);
                } else {
                    jSONArray = new JSONArray().put(pidStr);
                }
            } catch (Exception unused) {
                jSONArray = new JSONArray();
            }
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PromotionKeys.DONT_SHOW_AGAIN_CLICK_PID, jSONArray.toString(), null, 4, null);
            Property.INSTANCE.getINSTANCE().writeProperties();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void saveDontShowAgainPeriodDataList(String pidStr, int period) {
            JSONArray jSONArray;
            String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.DONT_SHOW_AGAIN_CLICK_PERIOD_DATA, "");
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AnalyticsProviderAdjust.EventKeys.pid, pidStr);
                if (1 > period || period >= 8) {
                    period = 1;
                }
                jSONObject.put(TypedValues.CycleType.S_WAVE_PERIOD, period);
                jSONObject.put("clickDate", System.currentTimeMillis());
                if (value.length() > 0) {
                    jSONArray = new JSONArray(value).put(jSONObject);
                } else {
                    jSONArray = new JSONArray().put(jSONObject);
                }
            } catch (Exception unused) {
                jSONArray = new JSONArray();
            }
            Property.setValue$default(Property.INSTANCE.getINSTANCE(), PromotionKeys.DONT_SHOW_AGAIN_CLICK_PERIOD_DATA, jSONArray.toString(), null, 4, null);
            Property.INSTANCE.getINSTANCE().writeProperties();
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        
            if (r3.equals("banner_detail") == false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
        
            if (r3.equals(com.adxcorp.ads.mediation.util.ReportUtil.INVENTORY_TYPE_BANNER) == false) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
        
            return getDontShowAgainPeriodPidList();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final org.json.JSONArray getDontShowAgainPidListFromType(java.lang.String r3, java.lang.String r4) {
            /*
                r2 = this;
                java.lang.String r0 = "webViewTypeValue"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                int r0 = r3.hashCode()
                r1 = -1396342996(0xffffffffacc57f2c, float:-5.6131957E-12)
                if (r0 == r1) goto L59
                r1 = 3537154(0x35f902, float:4.956608E-39)
                if (r0 == r1) goto L22
                r4 = 1030450372(0x3d6b6cc4, float:0.057476774)
                if (r0 == r4) goto L19
                goto L61
            L19:
                java.lang.String r4 = "banner_detail"
                boolean r3 = r3.equals(r4)
                if (r3 == 0) goto L61
                goto L66
            L22:
                java.lang.String r0 = "spot"
                boolean r3 = r3.equals(r0)
                if (r3 != 0) goto L2b
                goto L61
            L2b:
                r3 = r4
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                if (r3 == 0) goto L54
                int r3 = r3.length()
                if (r3 != 0) goto L37
                goto L54
            L37:
                java.util.Locale r3 = java.util.Locale.US
                java.lang.String r0 = "US"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                java.lang.String r3 = r4.toLowerCase(r3)
                java.lang.String r4 = "toLowerCase(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                java.lang.String r4 = "ad"
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r4)
                if (r3 == 0) goto L54
                org.json.JSONArray r3 = r2.getDontShowAgainPeriodPidList()
                goto L6a
            L54:
                org.json.JSONArray r3 = r2.getDontShowAgainPidList()
                goto L6a
            L59:
                java.lang.String r4 = "banner"
                boolean r3 = r3.equals(r4)
                if (r3 != 0) goto L66
            L61:
                org.json.JSONArray r3 = r2.getDontShowAgainPidList()
                goto L6a
            L66:
                org.json.JSONArray r3 = r2.getDontShowAgainPeriodPidList()
            L6a:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.PromotionDialog.Companion.getDontShowAgainPidListFromType(java.lang.String, java.lang.String):org.json.JSONArray");
        }

        private final JSONArray getDontShowAgainPidList() {
            String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.DONT_SHOW_AGAIN_CLICK_PID, "");
            if (value.length() > 0) {
                try {
                    return new JSONArray(value);
                } catch (Exception unused) {
                    Property.INSTANCE.getINSTANCE().removeValue(PromotionKeys.DONT_SHOW_AGAIN_CLICK_PID);
                    Property.INSTANCE.getINSTANCE().writeProperties();
                    return new JSONArray();
                }
            }
            return new JSONArray();
        }

        private final JSONArray getDontShowAgainPeriodPidList() {
            String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.DONT_SHOW_AGAIN_CLICK_PERIOD_DATA, "");
            if (value.length() > 0) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = new JSONArray(value);
                    int length = jSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        jSONArray.put(jSONArray2.optJSONObject(i).optString(AnalyticsProviderAdjust.EventKeys.pid));
                    }
                    return jSONArray;
                } catch (Exception unused) {
                    return new JSONArray();
                }
            }
            return new JSONArray();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [T, org.json.JSONArray] */
        /* JADX WARN: Type inference failed for: r0v19, types: [T, org.json.JSONArray] */
        /* JADX WARN: Type inference failed for: r8v3, types: [T, org.json.JSONArray] */
        public final void savePidOpenInfoJsonString(String pidStr) {
            Object objM7415constructorimpl;
            Object objM7415constructorimpl2;
            JSONArray jSONArray;
            Object objM7415constructorimpl3;
            JSONArray jSONArray2;
            String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.PID_OPEN_INFO, "");
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            JSONArray jSONArray3 = null;
            if (value.length() == 0) {
                objectRef.element = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    jSONObject.put(AnalyticsProviderAdjust.EventKeys.pid, pidStr);
                    jSONObject.put("count", "1");
                    if (objectRef.element == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("jsonArray");
                        jSONArray2 = null;
                    } else {
                        jSONArray2 = (JSONArray) objectRef.element;
                    }
                    objM7415constructorimpl3 = Result.m7415constructorimpl(jSONArray2.put(jSONObject));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM7415constructorimpl3 = Result.m7415constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl3);
                if (thM7418exceptionOrNullimpl != null) {
                    Logger.INSTANCE.w("savePidOpenInfoJsonString savedPidOpenInfoString.isEmpty() failed: " + thM7418exceptionOrNullimpl);
                }
            } else {
                boolean z = false;
                try {
                    Result.Companion companion3 = Result.INSTANCE;
                    ?? jSONArray4 = new JSONArray(value);
                    int length = jSONArray4.length();
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            JSONObject jSONObjectOptJSONObject = jSONArray4.optJSONObject(i);
                            if (jSONObjectOptJSONObject != null && Intrinsics.areEqual(jSONObjectOptJSONObject.optString(AnalyticsProviderAdjust.EventKeys.pid), pidStr)) {
                                jSONObjectOptJSONObject.put("count", String.valueOf(jSONObjectOptJSONObject.optInt("count") + 1));
                                z = true;
                                break;
                            }
                            i++;
                        } else {
                            break;
                        }
                    }
                    objectRef.element = jSONArray4;
                    objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion4 = Result.INSTANCE;
                    objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th2));
                }
                Throwable thM7418exceptionOrNullimpl2 = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
                if (thM7418exceptionOrNullimpl2 != null) {
                    Logger.INSTANCE.w("savePidOpenInfoJsonString failed: " + thM7418exceptionOrNullimpl2);
                    objectRef.element = new JSONArray();
                }
                if (!z) {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        Result.Companion companion5 = Result.INSTANCE;
                        jSONObject2.put(AnalyticsProviderAdjust.EventKeys.pid, pidStr);
                        jSONObject2.put("count", "1");
                        if (objectRef.element == 0) {
                            Intrinsics.throwUninitializedPropertyAccessException("jsonArray");
                            jSONArray = null;
                        } else {
                            jSONArray = (JSONArray) objectRef.element;
                        }
                        objM7415constructorimpl2 = Result.m7415constructorimpl(jSONArray.put(jSONObject2));
                    } catch (Throwable th3) {
                        Result.Companion companion6 = Result.INSTANCE;
                        objM7415constructorimpl2 = Result.m7415constructorimpl(ResultKt.createFailure(th3));
                    }
                    Throwable thM7418exceptionOrNullimpl3 = Result.m7418exceptionOrNullimpl(objM7415constructorimpl2);
                    if (thM7418exceptionOrNullimpl3 != null) {
                        Logger.INSTANCE.w("savePidOpenInfoJsonString isMatching.not() failed: " + thM7418exceptionOrNullimpl3);
                    }
                }
            }
            Property instance = Property.INSTANCE.getINSTANCE();
            if (objectRef.element == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("jsonArray");
            } else {
                jSONArray3 = (JSONArray) objectRef.element;
            }
            Property.setValue$default(instance, PromotionKeys.PID_OPEN_INFO, jSONArray3.toString(), null, 4, null);
            Property.INSTANCE.getINSTANCE().writeProperties();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getTodayYearMonthDate() {
            StringBuilder sb = new StringBuilder();
            sb.append(Calendar.getInstance().get(1));
            sb.append(Calendar.getInstance().get(2));
            sb.append('1');
            sb.append(Calendar.getInstance().get(5));
            return sb.toString();
        }

        public final JSONArray getPidOpenInfo() {
            String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.PID_OPEN_INFO, "");
            if (value.length() == 0) {
                return new JSONArray();
            }
            try {
                return new JSONArray(value);
            } catch (Exception unused) {
                Property.INSTANCE.getINSTANCE().removeValue(PromotionKeys.PID_OPEN_INFO);
                Property.INSTANCE.getINSTANCE().writeProperties();
                return new JSONArray();
            }
        }

        public final String getPidOpenCountString(String pidStr) {
            Object objM7415constructorimpl;
            Intrinsics.checkNotNullParameter(pidStr, "pidStr");
            String value = Property.INSTANCE.getINSTANCE().getValue(PromotionKeys.PID_OPEN_INFO, "");
            if (value.length() == 0) {
                return "";
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                JSONArray jSONArray = new JSONArray(value);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null && Intrinsics.areEqual(jSONObjectOptJSONObject.optString(AnalyticsProviderAdjust.EventKeys.pid), pidStr)) {
                        String strOptString = jSONObjectOptJSONObject.optString("count");
                        Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                        return strOptString;
                    }
                }
                objM7415constructorimpl = Result.m7415constructorimpl(jSONArray);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
            if (thM7418exceptionOrNullimpl != null) {
                Logger.INSTANCE.w("getPidOpenCountString failed: " + thM7418exceptionOrNullimpl);
            }
            return "";
        }
    }

    /* JADX INFO: compiled from: PromotionDialog.kt */
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u001a\u0010\u0015\u001a\u00020\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00140\u0017J \u0010\u0019\u001a\u00020\u00002\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001aJ\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\rR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lcom/hive/promotion/PromotionDialog$Builder;", "", "activity", "Landroid/app/Activity;", "webViewInfoList", "Ljava/util/ArrayList;", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "Lkotlin/collections/ArrayList;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/promotion/PromotionDialog$PromotionDialogListener;", "<init>", "(Landroid/app/Activity;Ljava/util/ArrayList;Lcom/hive/promotion/PromotionDialog$PromotionDialogListener;)V", "promotionDialog", "Lcom/hive/promotion/PromotionDialog;", "getPromotionDialog", "()Lcom/hive/promotion/PromotionDialog;", "setPromotionDialog", "(Lcom/hive/promotion/PromotionDialog;)V", "setForced", "isForced", "", "setSchemeEventFunc", InneractiveMediationDefs.GENDER_FEMALE, "Lkotlin/Function1;", "Lcom/hive/core/Scheme;", "setGeneratePostDataFunc", "Lkotlin/Function2;", "", "setImageBannerListener", "Lcom/hive/promotion/ui/PromotionViewImageBanner$PromotionViewImageBannerListener;", "setPromotionWebChromeClient", "webChromeClient", "Landroid/webkit/WebChromeClient;", "setBannerDontShowAgainPeriod", TypedValues.CycleType.S_WAVE_PERIOD, "", InAppPurchaseConstants.METHOD_BUILD, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private PromotionDialog promotionDialog;

        public Builder(Activity activity, ArrayList<PromotionView.WebViewInfo> webViewInfoList, PromotionDialogListener listener) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(webViewInfoList, "webViewInfoList");
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.promotionDialog = new PromotionDialog(activity, webViewInfoList, listener, null);
        }

        public final PromotionDialog getPromotionDialog() {
            return this.promotionDialog;
        }

        public final void setPromotionDialog(PromotionDialog promotionDialog) {
            Intrinsics.checkNotNullParameter(promotionDialog, "<set-?>");
            this.promotionDialog = promotionDialog;
        }

        public final Builder setForced(boolean isForced) {
            this.promotionDialog.setForced(isForced);
            return this;
        }

        public final Builder setSchemeEventFunc(Function1<? super Scheme, Boolean> f) {
            Intrinsics.checkNotNullParameter(f, "f");
            this.promotionDialog.setSchemeEventFunc(f);
            return this;
        }

        public final Builder setGeneratePostDataFunc(Function2<? super PromotionView.WebViewInfo, ? super String, String> f) {
            Intrinsics.checkNotNullParameter(f, "f");
            this.promotionDialog.setGeneratePostDataFunc(f);
            return this;
        }

        public final Builder setImageBannerListener(PromotionViewImageBanner.PromotionViewImageBannerListener listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            this.promotionDialog.setPromotionViewImageBannerListener(listener);
            return this;
        }

        public final Builder setPromotionWebChromeClient(WebChromeClient webChromeClient) {
            Intrinsics.checkNotNullParameter(webChromeClient, "webChromeClient");
            this.promotionDialog.setPromotionWebChromeClient(webChromeClient);
            return this;
        }

        public final Builder setBannerDontShowAgainPeriod(int period) {
            this.promotionDialog.setBannerDontShowAgainPeriod(period);
            return this;
        }

        /* JADX INFO: renamed from: build, reason: from getter */
        public final PromotionDialog getPromotionDialog() {
            return this.promotionDialog;
        }
    }
}
