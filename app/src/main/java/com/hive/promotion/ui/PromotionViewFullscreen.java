package com.hive.promotion.ui;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.ColorStateList;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.hive.core.webview.HiveWebView;
import com.hive.promotion.ui.PromotionView;
import com.hive.promotion.ui.news.NewsV2Activity;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.Resource;
import com.hive.ui.common.controller.HiveUiOrientationController;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromotionViewFullscreen.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\fB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0010J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u0018J\r\u0010\u0019\u001a\u00020\u001aH\u0010¢\u0006\u0002\b\u001bJ\b\u0010\u001c\u001a\u00020\u0017H\u0003J\u001a\u0010\u001d\u001a\u00020\t2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/hive/promotion/ui/PromotionViewFullscreen;", "Lcom/hive/promotion/ui/PromotionView;", "activity", "Landroid/app/Activity;", "url", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "useCutout", "", "(Landroid/app/Activity;Ljava/lang/String;Z)V", AdUnitActivity.EXTRA_ORIENTATION, "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "webViewInfo", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "showAlways", "(Landroid/app/Activity;Lcom/hive/promotion/ui/PromotionView$WebViewInfo;Ljava/lang/String;)V", "closeBtn", "Landroidx/appcompat/widget/AppCompatImageView;", "isOnClose", "defaultCloseButtonMargin", "", "onCreateView", "", "onCreateView$hive_promotion_release", "onCreateWebView", "Lcom/hive/core/webview/HiveWebView;", "onCreateWebView$hive_promotion_release", "drawCloseButton", "isViewInside", "v", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "startCloseOnAnimation", "startCloseOffAnimation", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionViewFullscreen extends PromotionView {
    private AppCompatImageView closeBtn;
    private int defaultCloseButtonMargin;
    private boolean isOnClose;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionViewFullscreen(Activity activity, String url) {
        super(activity, url);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionViewFullscreen(Activity activity, String url, boolean z) {
        super(activity, url, z);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionViewFullscreen(Activity activity, String url, String orientation) {
        super(activity, url, orientation);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionViewFullscreen(Activity activity, PromotionView.WebViewInfo webViewInfo, String showAlways) {
        super(activity, webViewInfo, showAlways);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        Intrinsics.checkNotNullParameter(showAlways, "showAlways");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.hive.promotion.ui.PromotionView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreateView$hive_promotion_release(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.app.Activity r0 = r4.getMActivity()
            android.content.Context r0 = (android.content.Context) r0
            com.hive.ui.Resource r1 = com.hive.ui.Resource.INSTANCE
            android.app.Activity r2 = r4.getMActivity()
            android.content.Context r2 = (android.content.Context) r2
            java.lang.String r3 = "promotion_view_full"
            int r1 = r1.getLayoutId(r2, r3)
            r2 = r4
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            android.view.View r0 = android.view.View.inflate(r0, r1, r2)
            java.lang.String r1 = "null cannot be cast to non-null type com.hive.promotion.ui.PromotionView"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            com.hive.promotion.ui.PromotionView r0 = (com.hive.promotion.ui.PromotionView) r0
            r4.setMRoot$hive_promotion_release(r0)
            r4.showWebView(r5)
            r4.drawCloseButton()
            android.app.Activity r5 = r4.getMActivity()
            boolean r0 = r5 instanceof com.hive.ui.HiveUiActivity
            if (r0 != 0) goto L3c
            boolean r0 = r5 instanceof com.hive.promotion.ui.news.NewsV2Activity
            if (r0 == 0) goto L89
        L3c:
            java.lang.String r0 = r4.getDisplayOrientation()
            int r1 = r0.hashCode()
            r2 = -77725029(0xfffffffffb5e029b, float:-1.15274275E36)
            if (r1 == r2) goto L6c
            r2 = 2044801(0x1f3381, float:2.865377E-39)
            if (r1 == r2) goto L60
            r2 = 1511893915(0x5a1dab9b, float:1.1095063E16)
            if (r1 == r2) goto L54
            goto L74
        L54:
            java.lang.String r1 = "PORTRAIT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L5d
            goto L74
        L5d:
            com.hive.core.configuration.HiveOrientation r0 = com.hive.core.configuration.HiveOrientation.PORTRAIT
            goto L7d
        L60:
            java.lang.String r1 = "BOTH"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L69
            goto L74
        L69:
            com.hive.core.configuration.HiveOrientation r0 = com.hive.core.configuration.HiveOrientation.ALL
            goto L7d
        L6c:
            java.lang.String r1 = "LANDSCAPE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7b
        L74:
            com.hive.core.Configuration r0 = com.hive.core.Configuration.INSTANCE
            com.hive.core.configuration.HiveOrientation r0 = r0.getHiveOrientation()
            goto L7d
        L7b:
            com.hive.core.configuration.HiveOrientation r0 = com.hive.core.configuration.HiveOrientation.LANDSCAPE
        L7d:
            r1 = r5
            com.hive.ui.common.controller.HiveUiOrientationController r1 = (com.hive.ui.common.controller.HiveUiOrientationController) r1
            com.hive.ui.Util r2 = com.hive.ui.Util.INSTANCE
            int r5 = r2.getSystemScreenOrientation(r5, r0)
            r1.lockOrientation(r5)
        L89:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.ui.PromotionViewFullscreen.onCreateView$hive_promotion_release(java.lang.String):void");
    }

    @Override // com.hive.promotion.ui.PromotionView
    public HiveWebView onCreateWebView$hive_promotion_release() {
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_full_webview"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        HiveWebView hiveWebView = (HiveWebView) viewFindViewById;
        View viewFindViewById2 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_spinner"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
        setPromotion_view_spinner((ProgressBar) viewFindViewById2);
        View viewFindViewById3 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_full_loadingbar"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ProgressBar");
        ProgressBar progressBar = (ProgressBar) viewFindViewById3;
        progressBar.setProgressTintList(ColorStateList.valueOf(-16742945));
        progressBar.setProgressBackgroundTintList(ColorStateList.valueOf(-2302756));
        progressBar.setScaleY(4.0f);
        setPromotion_view_full_loadingbar(progressBar);
        return hiveWebView;
    }

    private final void drawCloseButton() {
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "iv_promotion_view_full_close_button"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewFindViewById;
        this.closeBtn = appCompatImageView;
        if (appCompatImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            appCompatImageView = null;
        }
        appCompatImageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.promotion.ui.PromotionViewFullscreen$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PromotionViewFullscreen.drawCloseButton$lambda$1(this.f$0, view, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean drawCloseButton$lambda$1(PromotionViewFullscreen promotionViewFullscreen, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    return false;
                }
                if (promotionViewFullscreen.isViewInside(view, event)) {
                    if (!promotionViewFullscreen.isOnClose) {
                        promotionViewFullscreen.isOnClose = true;
                        promotionViewFullscreen.startCloseOnAnimation();
                    }
                } else if (promotionViewFullscreen.isOnClose) {
                    promotionViewFullscreen.isOnClose = false;
                    promotionViewFullscreen.startCloseOffAnimation();
                }
            } else if (promotionViewFullscreen.isOnClose) {
                promotionViewFullscreen.isOnClose = false;
                if (promotionViewFullscreen.isViewInside(view, event)) {
                    ComponentCallbacks2 mActivity$hive_promotion_release = promotionViewFullscreen.getMActivity();
                    if ((mActivity$hive_promotion_release instanceof HiveUiActivity) || (mActivity$hive_promotion_release instanceof NewsV2Activity)) {
                        ((HiveUiOrientationController) mActivity$hive_promotion_release).unlockOrientation();
                    }
                    PromotionView.ButtonClickedListener buttonClickedListener = promotionViewFullscreen.getButtonClickedListener();
                    if (buttonClickedListener != null) {
                        buttonClickedListener.onClose();
                    }
                }
            }
        } else if (!promotionViewFullscreen.isOnClose) {
            promotionViewFullscreen.isOnClose = true;
            promotionViewFullscreen.startCloseOnAnimation();
        }
        return true;
    }

    private final boolean isViewInside(View v, MotionEvent e) {
        return v != null && e.getX() >= 0.0f && e.getY() >= 0.0f && e.getX() <= ((float) v.getMeasuredWidth()) && e.getY() <= ((float) v.getMeasuredHeight());
    }

    private final void startCloseOnAnimation() {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(getMActivity(), Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_news_fullscreen_close_from_down_to_up"));
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
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(getMActivity(), Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_news_fullscreen_close_from_up_to_down"));
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
