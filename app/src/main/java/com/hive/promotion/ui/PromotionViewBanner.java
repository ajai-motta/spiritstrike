package com.hive.promotion.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.hive.core.ExtentionsKt;
import com.hive.core.webview.HiveWebView;
import com.hive.logger.LoggerImpl;
import com.hive.promotion.PromotionCustomViewRoundedCorner;
import com.hive.promotion.R;
import com.hive.promotion.ui.PromotionView;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: PromotionViewBanner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0010¢\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\r\u0010\u001b\u001a\u00020\u001cH\u0010¢\u0006\u0002\b\u001dJ\u0012\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H\u0003J \u0010#\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010$\u001a\u00020\u000e2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002J\b\u0010+\u001a\u00020\u0017H\u0002J\b\u0010,\u001a\u00020\u0017H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/hive/promotion/ui/PromotionViewBanner;", "Lcom/hive/promotion/ui/PromotionView;", "activity", "Landroid/app/Activity;", "webViewInfo", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "showAlways", "", "<init>", "(Landroid/app/Activity;Lcom/hive/promotion/ui/PromotionView$WebViewInfo;Ljava/lang/String;)V", "dontShowAgainPeriod", "", "(Landroid/app/Activity;Lcom/hive/promotion/ui/PromotionView$WebViewInfo;Ljava/lang/String;I)V", "isOnForce", "", "isOnClose", "forceBtn", "Landroidx/appcompat/widget/AppCompatImageView;", "forceTextView", "Landroid/widget/TextView;", "closeBtn", "mDontShowAgainPeriod", "onCreateView", "", "url", "onCreateView$hive_promotion_release", "showWebView", "onCreateWebView", "Lcom/hive/core/webview/HiveWebView;", "onCreateWebView$hive_promotion_release", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "setAutoTextSize", "drawOutline", "updateForceTextIfBanner", "isViewInside", "v", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "startForceOnAnimation", "startForceOffAnimation", "startCloseOnAnimation", "startCloseOffAnimation", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionViewBanner extends PromotionView {
    private AppCompatImageView closeBtn;
    private AppCompatImageView forceBtn;
    private TextView forceTextView;
    private boolean isOnClose;
    private boolean isOnForce;
    private int mDontShowAgainPeriod;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionViewBanner(Activity activity, PromotionView.WebViewInfo webViewInfo, String showAlways) {
        super(activity, webViewInfo, showAlways);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        Intrinsics.checkNotNullParameter(showAlways, "showAlways");
        this.mDontShowAgainPeriod = -1;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PromotionViewBanner(Activity activity, PromotionView.WebViewInfo webViewInfo, String showAlways, int i) {
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

    @Override // com.hive.promotion.ui.PromotionView
    public void onCreateView$hive_promotion_release(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Context resourceContext = ExtentionsKt.getResourceContext(getMActivity());
        View viewInflate = View.inflate(resourceContext, Resource.INSTANCE.getLayoutId(resourceContext, "promotion_view_banner"), this);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.hive.promotion.ui.PromotionView");
        setMRoot$hive_promotion_release((PromotionView) viewInflate);
        setMUrl$hive_promotion_release(url);
        String mUrl$hive_promotion_release = getMUrl();
        if (mUrl$hive_promotion_release == null) {
            mUrl$hive_promotion_release = "";
        }
        showWebView(mUrl$hive_promotion_release);
        drawOutline(getMWebViewInfo());
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
    public void showWebView(String url) {
        int i;
        Intrinsics.checkNotNullParameter(url, "url");
        super.showWebView(url);
        boolean z = getResources().getBoolean(R.bool.com_hive_sdk_ui_is_tablet);
        Point screenSize = Util.INSTANCE.getScreenSize(getMActivity());
        if (z) {
            i = (screenSize.y * 30) / 976;
        } else {
            i = (screenSize.x * 95) / 480;
        }
        getMWebView().setInitialScale(i);
    }

    @Override // com.hive.promotion.ui.PromotionView
    public HiveWebView onCreateWebView$hive_promotion_release() {
        Object objM7415constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            boolean zIsPortrait = Util.INSTANCE.isPortrait(getMActivity());
            int portImageWidth = zIsPortrait ? getMWebViewInfo().getPortImageWidth() : getMWebViewInfo().getLandImageWidth();
            int portImageHeight = zIsPortrait ? getMWebViewInfo().getPortImageHeight() : getMWebViewInfo().getLandImageHeight();
            if (portImageWidth != 0 && portImageHeight != 0) {
                View viewFindViewById = getMRoot$hive_promotion_release().findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_banner_child_layout_top"));
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                ViewGroup.LayoutParams layoutParams = ((PromotionCustomViewRoundedCorner) viewFindViewById).getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                StringBuilder sb = new StringBuilder();
                sb.append(portImageWidth);
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(portImageHeight);
                ((ConstraintLayout.LayoutParams) layoutParams).dimensionRatio = sb.toString();
            }
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            LoggerImpl.INSTANCE.w("[PromotionViewBanner] onCreateWebView - failed calculate ratio. (" + thM7418exceptionOrNullimpl + ')');
        }
        View viewFindViewById2 = getMRoot$hive_promotion_release().findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_custom_webview"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        HiveWebView hiveWebView = (HiveWebView) viewFindViewById2;
        hiveWebView.setVerticalScrollBarEnabled(false);
        hiveWebView.setHorizontalScrollBarEnabled(false);
        hiveWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.promotion.ui.PromotionViewBanner$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PromotionViewBanner.onCreateWebView$lambda$2(view, motionEvent);
            }
        });
        View viewFindViewById3 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_spinner"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ProgressBar");
        setPromotion_view_spinner((ProgressBar) viewFindViewById3);
        return hiveWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateWebView$lambda$2(View view, MotionEvent motionEvent) {
        return motionEvent.getAction() == 2;
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

    private final void setAutoTextSize() {
        if (getViewTreeObserver().isAlive()) {
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.hive.promotion.ui.PromotionViewBanner.setAutoTextSize.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    AppCompatImageView appCompatImageView = PromotionViewBanner.this.forceBtn;
                    TextView textView = null;
                    if (appCompatImageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("forceBtn");
                        appCompatImageView = null;
                    }
                    if (appCompatImageView.getMeasuredHeight() == 0) {
                        return true;
                    }
                    if (PromotionViewBanner.this.getViewTreeObserver().isAlive()) {
                        PromotionViewBanner.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    }
                    float f = PromotionViewBanner.this.getResources().getBoolean(R.bool.com_hive_sdk_ui_is_tablet) ? 0.55f : 0.46f;
                    AppCompatImageView appCompatImageView2 = PromotionViewBanner.this.forceBtn;
                    if (appCompatImageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("forceBtn");
                        appCompatImageView2 = null;
                    }
                    float measuredHeight = (appCompatImageView2.getMeasuredHeight() * f) / PromotionViewBanner.this.getResources().getDisplayMetrics().scaledDensity;
                    TextView textView2 = PromotionViewBanner.this.forceTextView;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("forceTextView");
                    } else {
                        textView = textView2;
                    }
                    textView.setTextSize(measuredHeight);
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
        ((ConstraintLayout) viewFindViewById).setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.promotion.ui.PromotionViewBanner$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PromotionViewBanner.drawOutline$lambda$3(this.f$0, webViewInfo, view, motionEvent);
            }
        });
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_banner_close_btn"));
        this.closeBtn = appCompatImageView;
        if (appCompatImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            appCompatImageView = null;
        }
        appCompatImageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.promotion.ui.PromotionViewBanner$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PromotionViewBanner.drawOutline$lambda$4(this.f$0, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean drawOutline$lambda$3(PromotionViewBanner promotionViewBanner, PromotionView.WebViewInfo webViewInfo, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                if (promotionViewBanner.isViewInside(view, event)) {
                    if (!promotionViewBanner.isOnForce) {
                        promotionViewBanner.isOnForce = true;
                        promotionViewBanner.startForceOnAnimation();
                    }
                } else if (promotionViewBanner.isOnForce) {
                    promotionViewBanner.isOnForce = false;
                    promotionViewBanner.startForceOffAnimation();
                }
            } else if (promotionViewBanner.isOnForce) {
                promotionViewBanner.isOnForce = false;
                if (promotionViewBanner.isViewInside(view, event) && promotionViewBanner.getButtonClickedListener() != null) {
                    PromotionView.ButtonClickedListener buttonClickedListener = promotionViewBanner.getButtonClickedListener();
                    if (buttonClickedListener != null) {
                        buttonClickedListener.onForce(webViewInfo.getTypeWebView(), webViewInfo.getPid());
                    }
                    PromotionView.ButtonClickedListener buttonClickedListener2 = promotionViewBanner.getButtonClickedListener();
                    if (buttonClickedListener2 != null) {
                        buttonClickedListener2.onClose();
                    }
                    promotionViewBanner.setButtonClickedListener(null);
                }
            }
        } else if (!promotionViewBanner.isOnForce) {
            promotionViewBanner.isOnForce = true;
            promotionViewBanner.startForceOnAnimation();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean drawOutline$lambda$4(PromotionViewBanner promotionViewBanner, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                if (promotionViewBanner.isViewInside(view, event)) {
                    if (!promotionViewBanner.isOnClose) {
                        promotionViewBanner.isOnClose = true;
                        promotionViewBanner.startCloseOnAnimation();
                    }
                } else if (promotionViewBanner.isOnClose) {
                    promotionViewBanner.isOnClose = false;
                    promotionViewBanner.startCloseOffAnimation();
                }
            } else if (promotionViewBanner.isOnClose) {
                promotionViewBanner.isOnClose = false;
                if (promotionViewBanner.isViewInside(view, event) && promotionViewBanner.getButtonClickedListener() != null) {
                    PromotionView.ButtonClickedListener buttonClickedListener = promotionViewBanner.getButtonClickedListener();
                    if (buttonClickedListener != null) {
                        buttonClickedListener.onClose();
                    }
                    promotionViewBanner.setButtonClickedListener(null);
                }
            }
        } else if (!promotionViewBanner.isOnClose) {
            promotionViewBanner.isOnClose = true;
            promotionViewBanner.startCloseOnAnimation();
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
