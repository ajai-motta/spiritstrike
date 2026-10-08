package com.hive.promotion.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.hive.core.webview.HiveWebView;
import com.hive.promotion.ui.PromotionView;
import com.hive.ui.Resource;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PromotionCustomViewBanner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u000bJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\rH\u0010¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u000fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006'"}, d2 = {"Lcom/hive/promotion/ui/PromotionCustomViewBanner;", "Lcom/hive/promotion/ui/PromotionView;", "activity", "Landroid/app/Activity;", "url", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "webViewInfo", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "showAlways", "(Landroid/app/Activity;Lcom/hive/promotion/ui/PromotionView$WebViewInfo;Ljava/lang/String;)V", "myWebView", "Lcom/hive/core/webview/HiveWebView;", "btnPrev", "Landroid/widget/ImageView;", "getBtnPrev$hive_promotion_release", "()Landroid/widget/ImageView;", "setBtnPrev$hive_promotion_release", "(Landroid/widget/ImageView;)V", "btnNext", "getBtnNext$hive_promotion_release", "setBtnNext$hive_promotion_release", "btnRefresh", "getBtnRefresh$hive_promotion_release", "setBtnRefresh$hive_promotion_release", "btnClose", "getBtnClose$hive_promotion_release", "setBtnClose$hive_promotion_release", "onCreateView", "", "onCreateView$hive_promotion_release", "onCreateWebView", "onCreateWebView$hive_promotion_release", "initButtons", "updateButtons", "view", "isEnabled", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionCustomViewBanner extends PromotionView {
    public ImageView btnClose;
    public ImageView btnNext;
    public ImageView btnPrev;
    public ImageView btnRefresh;
    private HiveWebView myWebView;

    public final ImageView getBtnPrev$hive_promotion_release() {
        ImageView imageView = this.btnPrev;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnPrev");
        return null;
    }

    public final void setBtnPrev$hive_promotion_release(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.btnPrev = imageView;
    }

    public final ImageView getBtnNext$hive_promotion_release() {
        ImageView imageView = this.btnNext;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnNext");
        return null;
    }

    public final void setBtnNext$hive_promotion_release(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.btnNext = imageView;
    }

    public final ImageView getBtnRefresh$hive_promotion_release() {
        ImageView imageView = this.btnRefresh;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnRefresh");
        return null;
    }

    public final void setBtnRefresh$hive_promotion_release(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.btnRefresh = imageView;
    }

    public final ImageView getBtnClose$hive_promotion_release() {
        ImageView imageView = this.btnClose;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnClose");
        return null;
    }

    public final void setBtnClose$hive_promotion_release(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.btnClose = imageView;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionCustomViewBanner(Activity activity, String url) {
        super(activity, url);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionCustomViewBanner(Activity activity, PromotionView.WebViewInfo webViewInfo, String showAlways) {
        super(activity, webViewInfo, showAlways);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        Intrinsics.checkNotNullParameter(showAlways, "showAlways");
    }

    @Override // com.hive.promotion.ui.PromotionView
    public void onCreateView$hive_promotion_release(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        View viewInflate = View.inflate(getMActivity(), Resource.INSTANCE.getLayoutId(getMActivity(), "promotion_customview_v2_banner"), this);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.hive.promotion.ui.PromotionView");
        setMRoot$hive_promotion_release((PromotionView) viewInflate);
        showWebView(url);
        initButtons();
    }

    @Override // com.hive.promotion.ui.PromotionView
    public HiveWebView onCreateWebView$hive_promotion_release() {
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_webview"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        HiveWebView hiveWebView = (HiveWebView) viewFindViewById;
        this.myWebView = hiveWebView;
        View viewFindViewById2 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_spinner"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
        setPromotion_view_spinner((ProgressBar) viewFindViewById2);
        View viewFindViewById3 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_loadingbar"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ProgressBar");
        setPromotion_customview_loading_progress((ProgressBar) viewFindViewById3);
        return hiveWebView;
    }

    private final void initButtons() {
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_bottom"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_bg"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout2 = (LinearLayout) viewFindViewById2;
        View viewFindViewById3 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_btn_prev"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        setBtnPrev$hive_promotion_release((ImageView) viewFindViewById3);
        View viewFindViewById4 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_btn_next"));
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        setBtnNext$hive_promotion_release((ImageView) viewFindViewById4);
        View viewFindViewById5 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_btn_refresh"));
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        setBtnRefresh$hive_promotion_release((ImageView) viewFindViewById5);
        View viewFindViewById6 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_btn_close"));
        Intrinsics.checkNotNull(viewFindViewById6, "null cannot be cast to non-null type android.widget.ImageView");
        setBtnClose$hive_promotion_release((ImageView) viewFindViewById6);
        PromotionView.WebViewInfo.ViewAppearance appearance = getMWebViewInfo().getAppearance();
        if (appearance != null) {
            Drawable current = linearLayout2.getBackground().getCurrent();
            Intrinsics.checkNotNull(current, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            ((GradientDrawable) current).setColor(Color.parseColor(appearance.getFrameColor()));
            linearLayout.setBackgroundColor(Color.parseColor(appearance.getNavbarColor()));
            getBtnPrev$hive_promotion_release().setColorFilter(Color.parseColor(appearance.getFrameColor()));
            getBtnNext$hive_promotion_release().setColorFilter(Color.parseColor(appearance.getFrameColor()));
            getBtnRefresh$hive_promotion_release().setColorFilter(Color.parseColor(appearance.getFrameColor()));
            getBtnClose$hive_promotion_release().setColorFilter(Color.parseColor(appearance.getFrameColor()));
            TouchEffectKt.setTouchEffect(getBtnPrev$hive_promotion_release(), (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.PromotionCustomViewBanner$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionCustomViewBanner.initButtons$lambda$4$lambda$0(this.f$0, (View) obj);
                }
            } : null);
            TouchEffectKt.setTouchEffect(getBtnNext$hive_promotion_release(), (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.PromotionCustomViewBanner$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionCustomViewBanner.initButtons$lambda$4$lambda$1(this.f$0, (View) obj);
                }
            } : null);
            TouchEffectKt.setTouchEffect(getBtnRefresh$hive_promotion_release(), (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.PromotionCustomViewBanner$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionCustomViewBanner.initButtons$lambda$4$lambda$2(this.f$0, (View) obj);
                }
            } : null);
            TouchEffectKt.setTouchEffect(getBtnClose$hive_promotion_release(), (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.PromotionCustomViewBanner$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionCustomViewBanner.initButtons$lambda$4$lambda$3(this.f$0, (View) obj);
                }
            } : null);
        }
        getBtnPrev$hive_promotion_release().setImageResource(Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_customview_btn_prev_vector"));
        getBtnNext$hive_promotion_release().setImageResource(Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_customview_btn_next_vector"));
        getBtnRefresh$hive_promotion_release().setImageResource(Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_customview_btn_refresh_vector"));
        getBtnClose$hive_promotion_release().setImageResource(Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_customview_btn_close_vector"));
        setMWebViewHistoryListener(new PromotionView.PromotionWebViewHistoryListener() { // from class: com.hive.promotion.ui.PromotionCustomViewBanner.initButtons.2
            @Override // com.hive.promotion.ui.PromotionView.PromotionWebViewHistoryListener
            public void checkHistoryAndUpdateButtons() {
                HiveWebView hiveWebView = PromotionCustomViewBanner.this.myWebView;
                if (hiveWebView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("myWebView");
                    hiveWebView = null;
                }
                WebBackForwardList webBackForwardListCopyBackForwardList = hiveWebView.copyBackForwardList();
                Intrinsics.checkNotNullExpressionValue(webBackForwardListCopyBackForwardList, "copyBackForwardList(...)");
                if (webBackForwardListCopyBackForwardList.getSize() == 0) {
                    PromotionCustomViewBanner promotionCustomViewBanner = PromotionCustomViewBanner.this;
                    promotionCustomViewBanner.updateButtons(promotionCustomViewBanner.getBtnPrev$hive_promotion_release(), false);
                    PromotionCustomViewBanner promotionCustomViewBanner2 = PromotionCustomViewBanner.this;
                    promotionCustomViewBanner2.updateButtons(promotionCustomViewBanner2.getBtnNext$hive_promotion_release(), false);
                    PromotionCustomViewBanner promotionCustomViewBanner3 = PromotionCustomViewBanner.this;
                    promotionCustomViewBanner3.updateButtons(promotionCustomViewBanner3.getBtnRefresh$hive_promotion_release(), true);
                    return;
                }
                WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex());
                if (itemAtIndex != null) {
                    String url = itemAtIndex.getUrl();
                    Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
                    if (StringsKt.contains$default((CharSequence) url, (CharSequence) "hive_error_embed.html", false, 2, (Object) null)) {
                        PromotionCustomViewBanner promotionCustomViewBanner4 = PromotionCustomViewBanner.this;
                        promotionCustomViewBanner4.updateButtons(promotionCustomViewBanner4.getBtnPrev$hive_promotion_release(), false);
                        PromotionCustomViewBanner promotionCustomViewBanner5 = PromotionCustomViewBanner.this;
                        promotionCustomViewBanner5.updateButtons(promotionCustomViewBanner5.getBtnNext$hive_promotion_release(), false);
                        PromotionCustomViewBanner promotionCustomViewBanner6 = PromotionCustomViewBanner.this;
                        promotionCustomViewBanner6.updateButtons(promotionCustomViewBanner6.getBtnRefresh$hive_promotion_release(), false);
                        return;
                    }
                }
                if (PromotionCustomViewBanner.this.getBackUrlIndex() == 0) {
                    PromotionCustomViewBanner promotionCustomViewBanner7 = PromotionCustomViewBanner.this;
                    promotionCustomViewBanner7.updateButtons(promotionCustomViewBanner7.getBtnPrev$hive_promotion_release(), false);
                } else {
                    PromotionCustomViewBanner promotionCustomViewBanner8 = PromotionCustomViewBanner.this;
                    promotionCustomViewBanner8.updateButtons(promotionCustomViewBanner8.getBtnPrev$hive_promotion_release(), true);
                }
                if (PromotionCustomViewBanner.this.getForwardUrlIndex() == 0) {
                    PromotionCustomViewBanner promotionCustomViewBanner9 = PromotionCustomViewBanner.this;
                    promotionCustomViewBanner9.updateButtons(promotionCustomViewBanner9.getBtnNext$hive_promotion_release(), false);
                } else {
                    PromotionCustomViewBanner promotionCustomViewBanner10 = PromotionCustomViewBanner.this;
                    promotionCustomViewBanner10.updateButtons(promotionCustomViewBanner10.getBtnNext$hive_promotion_release(), true);
                }
                PromotionCustomViewBanner promotionCustomViewBanner11 = PromotionCustomViewBanner.this;
                promotionCustomViewBanner11.updateButtons(promotionCustomViewBanner11.getBtnRefresh$hive_promotion_release(), true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$4$lambda$0(PromotionCustomViewBanner promotionCustomViewBanner, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (promotionCustomViewBanner.getBackUrlIndex() != 0) {
            HiveWebView hiveWebView = promotionCustomViewBanner.myWebView;
            if (hiveWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("myWebView");
                hiveWebView = null;
            }
            hiveWebView.goBackOrForward(promotionCustomViewBanner.getBackUrlIndex());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$4$lambda$1(PromotionCustomViewBanner promotionCustomViewBanner, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (promotionCustomViewBanner.getForwardUrlIndex() != 0) {
            HiveWebView hiveWebView = promotionCustomViewBanner.myWebView;
            if (hiveWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("myWebView");
                hiveWebView = null;
            }
            hiveWebView.goBackOrForward(promotionCustomViewBanner.getForwardUrlIndex());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$4$lambda$2(PromotionCustomViewBanner promotionCustomViewBanner, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        HiveWebView hiveWebView = promotionCustomViewBanner.myWebView;
        if (hiveWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myWebView");
            hiveWebView = null;
        }
        hiveWebView.reload();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$4$lambda$3(PromotionCustomViewBanner promotionCustomViewBanner, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (promotionCustomViewBanner.getMWebViewHistoryListener() != null) {
            promotionCustomViewBanner.setMWebViewHistoryListener(null);
        }
        PromotionView.ButtonClickedListener buttonClickedListener = promotionCustomViewBanner.getButtonClickedListener();
        if (buttonClickedListener != null) {
            buttonClickedListener.onClose();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateButtons(ImageView view, boolean isEnabled) {
        view.setEnabled(isEnabled);
        if (isEnabled) {
            PromotionView.WebViewInfo.ViewAppearance appearance = getMWebViewInfo().getAppearance();
            view.setColorFilter(Color.parseColor(appearance != null ? appearance.getFrameColor() : null));
        } else {
            PromotionView.WebViewInfo.ViewAppearance appearance2 = getMWebViewInfo().getAppearance();
            view.setColorFilter(Color.parseColor(appearance2 != null ? appearance2.getNavbarButtonInactiveColor() : null));
        }
    }
}
