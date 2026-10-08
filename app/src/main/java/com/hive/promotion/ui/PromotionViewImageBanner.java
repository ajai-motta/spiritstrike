package com.hive.promotion.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.ExtentionsKt;
import com.hive.core.Logger;
import com.hive.core.webview.HiveWebView;
import com.hive.promotion.PromotionCustomViewRoundedCorner;
import com.hive.promotion.R;
import com.hive.promotion.ui.PromotionView;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PromotionViewImageBanner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0010\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010 J\u0015\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u0007H\u0010¢\u0006\u0002\b&J\u0012\u0010'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\r\u0010*\u001a\u00020+H\u0010¢\u0006\u0002\b,J\b\u0010-\u001a\u00020\"H\u0003J\b\u0010.\u001a\u00020\"H\u0017J\b\u0010/\u001a\u00020\"H\u0016J\b\u00100\u001a\u00020\"H\u0002J\b\u00101\u001a\u00020\"H\u0002J\u0010\u00102\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003J \u00103\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u000e\u00104\u001a\u00020\"2\u0006\u00105\u001a\u00020\u0011J\u001a\u00106\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020\"H\u0002J\b\u0010<\u001a\u00020\"H\u0002J\b\u0010=\u001a\u00020\"H\u0002J\b\u0010>\u001a\u00020\"H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/hive/promotion/ui/PromotionViewImageBanner;", "Lcom/hive/promotion/ui/PromotionView;", "activity", "Landroid/app/Activity;", "webViewInfo", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "showAlways", "", "<init>", "(Landroid/app/Activity;Lcom/hive/promotion/ui/PromotionView$WebViewInfo;Ljava/lang/String;)V", "dontShowAgainPeriod", "", "(Landroid/app/Activity;Lcom/hive/promotion/ui/PromotionView$WebViewInfo;Ljava/lang/String;I)V", "imageView", "Landroid/widget/ImageView;", "imageBannerInstance", "targetMainLayout", "Landroid/widget/FrameLayout;", "isOnForce", "", "isOnClose", "remainTimeTitleTextView", "Landroid/widget/TextView;", "remainTimeTextView", "forceBtn", "Landroidx/appcompat/widget/AppCompatImageView;", "forceTextView", "closeBtn", "mLastClickTime", "", "mDontShowAgainPeriod", "promotionViewImageViewBanner", "Lcom/hive/promotion/ui/PromotionViewImageBanner$PromotionViewImageBannerListener;", "setOnPromotionViewImageBannerListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "onCreateView", "url", "onCreateView$hive_promotion_release", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreateWebView", "Lcom/hive/core/webview/HiveWebView;", "onCreateWebView$hive_promotion_release", "setupImageView", "show", "reCreate", "drawRemainTimeLayout", "setAutoTextSize", "drawOutline", "updateForceTextIfBanner", "addViewSelf", "mMainLayout", "isViewInside", "v", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "startForceOnAnimation", "startForceOffAnimation", "startCloseOnAnimation", "startCloseOffAnimation", k.M, "PromotionViewImageBannerListener", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionViewImageBanner extends PromotionView {
    private static final long MIN_CLICK_INTERVAL = 1000;
    private AppCompatImageView closeBtn;
    private AppCompatImageView forceBtn;
    private TextView forceTextView;
    private PromotionViewImageBanner imageBannerInstance;
    private ImageView imageView;
    private boolean isOnClose;
    private boolean isOnForce;
    private int mDontShowAgainPeriod;
    private long mLastClickTime;
    private PromotionViewImageBannerListener promotionViewImageViewBanner;
    private TextView remainTimeTextView;
    private TextView remainTimeTitleTextView;
    private FrameLayout targetMainLayout;

    /* JADX INFO: compiled from: PromotionViewImageBanner.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/hive/promotion/ui/PromotionViewImageBanner$PromotionViewImageBannerListener;", "", "onTouch", "", "webViewInfo", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "onLoadingComplete", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface PromotionViewImageBannerListener {
        void onLoadingComplete(PromotionView.WebViewInfo webViewInfo);

        void onTouch(PromotionView.WebViewInfo webViewInfo);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionViewImageBanner(Activity activity, PromotionView.WebViewInfo webViewInfo, String showAlways) {
        super(activity, webViewInfo, showAlways);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        Intrinsics.checkNotNullParameter(showAlways, "showAlways");
        this.mDontShowAgainPeriod = -1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PromotionViewImageBanner(Activity activity, PromotionView.WebViewInfo webViewInfo, String showAlways, int i) {
        this(activity, webViewInfo, showAlways);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        Intrinsics.checkNotNullParameter(showAlways, "showAlways");
        this.mDontShowAgainPeriod = i;
        TextView textView = this.forceTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
            textView = null;
        }
        updateForceTextIfBanner(webViewInfo, textView, i);
    }

    public final void setOnPromotionViewImageBannerListener(PromotionViewImageBannerListener listener) {
        if (listener != null) {
            this.promotionViewImageViewBanner = listener;
        }
    }

    @Override // com.hive.promotion.ui.PromotionView
    public void onCreateView$hive_promotion_release(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Context resourceContext = ExtentionsKt.getResourceContext(getMActivity());
        View viewInflate = View.inflate(resourceContext, Resource.INSTANCE.getLayoutId(resourceContext, "promotion_view_banner"), this);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.hive.promotion.ui.PromotionView");
        setMRoot$hive_promotion_release((PromotionView) viewInflate);
        this.imageView = (ImageView) getMRoot$hive_promotion_release().findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_custom_imageview"));
        setMWebView(new HiveWebView(getMActivity()));
        this.remainTimeTitleTextView = (TextView) getMRoot$hive_promotion_release().findViewById(Resource.INSTANCE.getViewId(getMActivity(), "remain_time_title_textView"));
        this.remainTimeTextView = (TextView) getMRoot$hive_promotion_release().findViewById(Resource.INSTANCE.getViewId(getMActivity(), "remain_time_textView"));
        setupImageView();
        drawRemainTimeLayout();
        drawOutline(getMWebViewInfo());
        setAutoTextSize();
        PromotionView.WebViewInfo mWebViewInfo$hive_promotion_release = getMWebViewInfo();
        TextView textView = this.forceTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
            textView = null;
        }
        updateForceTextIfBanner(mWebViewInfo$hive_promotion_release, textView, this.mDontShowAgainPeriod);
        this.imageBannerInstance = this;
        setVisibility(4);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setAutoTextSize();
        PromotionView.WebViewInfo mWebViewInfo$hive_promotion_release = getMWebViewInfo();
        TextView textView = this.forceTextView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
            textView = null;
        }
        updateForceTextIfBanner(mWebViewInfo$hive_promotion_release, textView, this.mDontShowAgainPeriod);
    }

    @Override // com.hive.promotion.ui.PromotionView
    public HiveWebView onCreateWebView$hive_promotion_release() {
        View viewFindViewById = getMRoot$hive_promotion_release().findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_custom_webview"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        HiveWebView hiveWebView = (HiveWebView) viewFindViewById;
        hiveWebView.setVisibility(8);
        return hiveWebView;
    }

    private final void setupImageView() {
        View viewFindViewById = getMRoot$hive_promotion_release().findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_banner_child_layout"));
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        constraintLayout.getLayoutParams().width = -2;
        constraintLayout.getLayoutParams().height = -2;
        View viewFindViewById2 = getMRoot$hive_promotion_release().findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_banner_child_layout_top"));
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        ((PromotionCustomViewRoundedCorner) viewFindViewById2).setVisibility(8);
        View viewFindViewById3 = getMRoot$hive_promotion_release().findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_custom_webview"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.webkit.WebView");
        ((WebView) viewFindViewById3).setVisibility(8);
        View viewFindViewById4 = getMRoot$hive_promotion_release().findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_spinner"));
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.ProgressBar");
        setPromotion_view_spinner((ProgressBar) viewFindViewById4);
        ProgressBar promotion_view_spinner = getPromotion_view_spinner();
        if (promotion_view_spinner != null) {
            promotion_view_spinner.setVisibility(8);
        }
        ImageView imageView = this.imageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.promotion.ui.PromotionViewImageBanner$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PromotionViewImageBanner.setupImageView$lambda$1(this.f$0, view, motionEvent);
            }
        });
        ImageView imageView3 = this.imageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupImageView$lambda$1(PromotionViewImageBanner promotionViewImageBanner, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (SystemClock.elapsedRealtime() - promotionViewImageBanner.mLastClickTime < 1000) {
                return false;
            }
            promotionViewImageBanner.mLastClickTime = SystemClock.elapsedRealtime();
            PromotionViewImageBannerListener promotionViewImageBannerListener = promotionViewImageBanner.promotionViewImageViewBanner;
            if (promotionViewImageBannerListener != null) {
                promotionViewImageBannerListener.onTouch(promotionViewImageBanner.getMWebViewInfo());
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [T, java.lang.String] */
    @Override // com.hive.promotion.ui.PromotionView
    public void show() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        PromotionView.WebViewInfo.BannerDetail bannerDetail = getMWebViewInfo().getBannerDetail();
        if (bannerDetail != null) {
            objectRef.element = Util.INSTANCE.isPortrait(getMActivity()) ? bannerDetail.getPortImageUrl() : bannerDetail.getLandImageUrl();
            CharSequence charSequence = (CharSequence) objectRef.element;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                objectRef.element = bannerDetail.getImageUrl();
            }
        }
        RequestBuilder requestBuilderListener = Glide.with(getMActivity()).load((String) objectRef.element).onlyRetrieveFromCache(false).timeout(3000).listener(new RequestListener<Drawable>() { // from class: com.hive.promotion.ui.PromotionViewImageBanner.show.2
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                PromotionView.ButtonClickedListener buttonClickedListener;
                FrameLayout frameLayout;
                Intrinsics.checkNotNullParameter(target, "target");
                Logger.INSTANCE.w(PromotionView.INSTANCE.getTAG(), "show(" + objectRef.element + ") onLoadFailed()\nGlideException: " + e);
                if (this.targetMainLayout != null && (frameLayout = this.targetMainLayout) != null) {
                    frameLayout.setVisibility(0);
                }
                PromotionViewImageBanner promotionViewImageBanner = this.imageBannerInstance;
                if (promotionViewImageBanner != null) {
                    promotionViewImageBanner.setVisibility(0);
                }
                if (this.getButtonClickedListener() != null && (buttonClickedListener = this.getButtonClickedListener()) != null) {
                    buttonClickedListener.onClose();
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                FrameLayout frameLayout;
                Intrinsics.checkNotNullParameter(resource, "resource");
                Intrinsics.checkNotNullParameter(model, "model");
                Intrinsics.checkNotNullParameter(dataSource, "dataSource");
                Logger.INSTANCE.d(PromotionView.INSTANCE.getTAG(), "show(" + objectRef.element + ") onResourceReady()\n");
                if (this.targetMainLayout != null && (frameLayout = this.targetMainLayout) != null) {
                    frameLayout.setVisibility(0);
                }
                PromotionViewImageBanner promotionViewImageBanner = this.imageBannerInstance;
                if (promotionViewImageBanner != null) {
                    promotionViewImageBanner.setVisibility(0);
                }
                PromotionViewImageBannerListener promotionViewImageBannerListener = this.promotionViewImageViewBanner;
                if (promotionViewImageBannerListener != null) {
                    promotionViewImageBannerListener.onLoadingComplete(this.getMWebViewInfo());
                }
                return false;
            }
        });
        ImageView imageView = this.imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            imageView = null;
        }
        requestBuilderListener.into(imageView);
    }

    @Override // com.hive.promotion.ui.PromotionView
    public void reCreate() {
        removeAllViewsInLayout();
        String mUrl$hive_promotion_release = getMUrl();
        if (mUrl$hive_promotion_release == null) {
            mUrl$hive_promotion_release = "";
        }
        onCreateView$hive_promotion_release(mUrl$hive_promotion_release);
        show();
    }

    private final void drawRemainTimeLayout() {
        PromotionView.WebViewInfo.BannerDetail.EventPeriod eventPeriod;
        PromotionView.WebViewInfo.BannerDetail.EventPeriod eventPeriod2;
        PromotionView.WebViewInfo.BannerDetail.EventPeriod eventPeriod3;
        PromotionView.WebViewInfo.BannerDetail.EventPeriod eventPeriod4;
        PromotionView.WebViewInfo.BannerDetail.EventPeriod eventPeriod5;
        PromotionView.WebViewInfo.BannerDetail bannerDetail = getMWebViewInfo().getBannerDetail();
        String time = null;
        if (TextUtils.equals(str, (bannerDetail == null || (eventPeriod5 = bannerDetail.getEventPeriod()) == null) ? null : eventPeriod5.getVisiable())) {
            PromotionView.WebViewInfo.BannerDetail bannerDetail2 = getMWebViewInfo().getBannerDetail();
            String message = (bannerDetail2 == null || (eventPeriod4 = bannerDetail2.getEventPeriod()) == null) ? null : eventPeriod4.getMessage();
            if (message == null || StringsKt.isBlank(message)) {
                return;
            }
            PromotionView.WebViewInfo.BannerDetail bannerDetail3 = getMWebViewInfo().getBannerDetail();
            String time2 = (bannerDetail3 == null || (eventPeriod3 = bannerDetail3.getEventPeriod()) == null) ? null : eventPeriod3.getTime();
            if (time2 == null || StringsKt.isBlank(time2)) {
                return;
            }
            View viewFindViewById = getMRoot$hive_promotion_release().findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_banner_remain_time_layout"));
            Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
            ((ConstraintLayout) viewFindViewById).setVisibility(0);
            TextView textView = this.remainTimeTitleTextView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remainTimeTitleTextView");
                textView = null;
            }
            PromotionView.WebViewInfo.BannerDetail bannerDetail4 = getMWebViewInfo().getBannerDetail();
            textView.setText((bannerDetail4 == null || (eventPeriod2 = bannerDetail4.getEventPeriod()) == null) ? null : eventPeriod2.getMessage());
            TextView textView2 = this.remainTimeTextView;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("remainTimeTextView");
                textView2 = null;
            }
            PromotionView.WebViewInfo.BannerDetail bannerDetail5 = getMWebViewInfo().getBannerDetail();
            if (bannerDetail5 != null && (eventPeriod = bannerDetail5.getEventPeriod()) != null) {
                time = eventPeriod.getTime();
            }
            textView2.setText(time);
        }
    }

    private final void setAutoTextSize() {
        if (getViewTreeObserver().isAlive()) {
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.hive.promotion.ui.PromotionViewImageBanner.setAutoTextSize.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    AppCompatImageView appCompatImageView = PromotionViewImageBanner.this.forceBtn;
                    TextView textView = null;
                    if (appCompatImageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("forceBtn");
                        appCompatImageView = null;
                    }
                    if (appCompatImageView.getMeasuredHeight() == 0) {
                        return true;
                    }
                    if (PromotionViewImageBanner.this.getViewTreeObserver().isAlive()) {
                        PromotionViewImageBanner.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    }
                    boolean z = PromotionViewImageBanner.this.getResources().getBoolean(R.bool.com_hive_sdk_ui_is_tablet);
                    float f = z ? 0.55f : 0.46f;
                    float f2 = z ? 0.9f : 0.86f;
                    AppCompatImageView appCompatImageView2 = PromotionViewImageBanner.this.forceBtn;
                    if (appCompatImageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("forceBtn");
                        appCompatImageView2 = null;
                    }
                    float measuredHeight = (appCompatImageView2.getMeasuredHeight() * f) / PromotionViewImageBanner.this.getResources().getDisplayMetrics().scaledDensity;
                    TextView textView2 = PromotionViewImageBanner.this.forceTextView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
                        textView2 = null;
                    }
                    textView2.setTextSize(measuredHeight);
                    TextView textView3 = PromotionViewImageBanner.this.remainTimeTitleTextView;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("remainTimeTitleTextView");
                        textView3 = null;
                    }
                    float f3 = measuredHeight * f2;
                    textView3.setTextSize(f3);
                    TextView textView4 = PromotionViewImageBanner.this.remainTimeTextView;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("remainTimeTextView");
                    } else {
                        textView = textView4;
                    }
                    textView.setTextSize(f3);
                    return false;
                }
            });
        }
    }

    private final void drawOutline(final PromotionView.WebViewInfo webViewInfo) {
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_banner_force_layout"));
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.forceBtn = (AppCompatImageView) findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_banner_force_btn"));
        this.forceTextView = (TextView) findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_banner_force_textview"));
        ((ConstraintLayout) viewFindViewById).setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.promotion.ui.PromotionViewImageBanner$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PromotionViewImageBanner.drawOutline$lambda$3(this.f$0, webViewInfo, view, motionEvent);
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_banner_close_btn"));
        this.closeBtn = appCompatImageView;
        if (appCompatImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            appCompatImageView = null;
        }
        appCompatImageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.promotion.ui.PromotionViewImageBanner$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PromotionViewImageBanner.drawOutline$lambda$4(this.f$0, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean drawOutline$lambda$3(PromotionViewImageBanner promotionViewImageBanner, PromotionView.WebViewInfo webViewInfo, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                if (promotionViewImageBanner.isViewInside(view, event)) {
                    if (!promotionViewImageBanner.isOnForce) {
                        promotionViewImageBanner.isOnForce = true;
                        promotionViewImageBanner.startForceOnAnimation();
                    }
                } else if (promotionViewImageBanner.isOnForce) {
                    promotionViewImageBanner.isOnForce = false;
                    promotionViewImageBanner.startForceOffAnimation();
                }
            } else if (promotionViewImageBanner.isOnForce) {
                promotionViewImageBanner.isOnForce = false;
                if (promotionViewImageBanner.isViewInside(view, event) && promotionViewImageBanner.getButtonClickedListener() != null) {
                    PromotionView.ButtonClickedListener buttonClickedListener = promotionViewImageBanner.getButtonClickedListener();
                    if (buttonClickedListener != null) {
                        buttonClickedListener.onForce(webViewInfo.getTypeWebView(), webViewInfo.getPid());
                    }
                    PromotionView.ButtonClickedListener buttonClickedListener2 = promotionViewImageBanner.getButtonClickedListener();
                    if (buttonClickedListener2 != null) {
                        buttonClickedListener2.onClose();
                    }
                    promotionViewImageBanner.setButtonClickedListener(null);
                }
            }
        } else if (!promotionViewImageBanner.isOnForce) {
            promotionViewImageBanner.isOnForce = true;
            promotionViewImageBanner.startForceOnAnimation();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean drawOutline$lambda$4(PromotionViewImageBanner promotionViewImageBanner, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                if (promotionViewImageBanner.isViewInside(view, event)) {
                    if (!promotionViewImageBanner.isOnClose) {
                        promotionViewImageBanner.isOnClose = true;
                        promotionViewImageBanner.startCloseOnAnimation();
                    }
                } else if (promotionViewImageBanner.isOnClose) {
                    promotionViewImageBanner.isOnClose = false;
                    promotionViewImageBanner.startCloseOffAnimation();
                }
            } else if (promotionViewImageBanner.isOnClose) {
                promotionViewImageBanner.isOnClose = false;
                if (promotionViewImageBanner.isViewInside(view, event) && promotionViewImageBanner.getButtonClickedListener() != null) {
                    PromotionView.ButtonClickedListener buttonClickedListener = promotionViewImageBanner.getButtonClickedListener();
                    if (buttonClickedListener != null) {
                        buttonClickedListener.onClose();
                    }
                    promotionViewImageBanner.setButtonClickedListener(null);
                }
            }
        } else if (!promotionViewImageBanner.isOnClose) {
            promotionViewImageBanner.isOnClose = true;
            promotionViewImageBanner.startCloseOnAnimation();
        }
        return true;
    }

    private final void updateForceTextIfBanner(PromotionView.WebViewInfo webViewInfo, TextView forceTextView, int dontShowAgainPeriod) {
        if (1 > dontShowAgainPeriod || dontShowAgainPeriod >= 8) {
            dontShowAgainPeriod = 1;
        }
        if (dontShowAgainPeriod > 1) {
            String string = Resource.INSTANCE.getString(getMActivity(), "hive_promotion_style_banner_dont_show_again_period_" + dontShowAgainPeriod);
            if (string != null) {
                forceTextView.setText(string);
                return;
            }
            return;
        }
        String string2 = Resource.INSTANCE.getString(getMActivity(), "hive_promotion_style_banner");
        if (string2 != null) {
            forceTextView.setText(string2);
        }
    }

    public final void addViewSelf(FrameLayout mMainLayout) {
        Intrinsics.checkNotNullParameter(mMainLayout, "mMainLayout");
        this.targetMainLayout = mMainLayout;
    }

    private final boolean isViewInside(View v, MotionEvent e) {
        return v != null && e.getX() >= 0.0f && e.getY() >= 0.0f && e.getX() <= ((float) v.getMeasuredWidth()) && e.getY() <= ((float) v.getMeasuredHeight());
    }

    private final void startForceOnAnimation() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(getMActivity(), Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_banner_force_from_off_to_on"));
        TextView textView = null;
        if (animatedVectorDrawableCompatCreate != null) {
            AppCompatImageView appCompatImageView = this.forceBtn;
            if (appCompatImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forceBtn");
                appCompatImageView = null;
            }
            appCompatImageView.setImageDrawable(animatedVectorDrawableCompatCreate);
            animatedVectorDrawableCompatCreate.start();
        }
        TextView textView2 = this.forceTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
        } else {
            textView = textView2;
        }
        textView.setTextColor(Resource.INSTANCE.getColor(getMActivity(), "com_hive_sdk_promotion_banner_force_text_on_color"));
    }

    private final void startForceOffAnimation() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(getMActivity(), Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_banner_force_from_on_to_off"));
        TextView textView = null;
        if (animatedVectorDrawableCompatCreate != null) {
            AppCompatImageView appCompatImageView = this.forceBtn;
            if (appCompatImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("forceBtn");
                appCompatImageView = null;
            }
            appCompatImageView.setImageDrawable(animatedVectorDrawableCompatCreate);
            animatedVectorDrawableCompatCreate.start();
        }
        TextView textView2 = this.forceTextView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
        } else {
            textView = textView2;
        }
        textView.setTextColor(Resource.INSTANCE.getColor(getMActivity(), "com_hive_sdk_promotion_banner_force_text_off_color"));
    }

    private final void startCloseOnAnimation() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(getMActivity(), Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_banner_close_from_down_to_up"));
        if (animatedVectorDrawableCompatCreate != null) {
            AppCompatImageView appCompatImageView = this.closeBtn;
            if (appCompatImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
                appCompatImageView = null;
            }
            appCompatImageView.setImageDrawable(animatedVectorDrawableCompatCreate);
            animatedVectorDrawableCompatCreate.start();
        }
    }

    private final void startCloseOffAnimation() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(getMActivity(), Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_banner_close_from_up_to_down"));
        if (animatedVectorDrawableCompatCreate != null) {
            AppCompatImageView appCompatImageView = this.closeBtn;
            if (appCompatImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
                appCompatImageView = null;
            }
            appCompatImageView.setImageDrawable(animatedVectorDrawableCompatCreate);
            animatedVectorDrawableCompatCreate.start();
        }
    }
}
