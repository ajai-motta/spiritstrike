package com.hive.promotion.ui;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.hive.core.webview.HiveWebView;
import com.hive.promotion.ui.PromotionView;
import com.hive.promotion.ui.news.NewsV2Activity;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.Resource;
import com.hive.ui.common.controller.HiveUiOrientationController;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PromotionCustomViewFullscreen.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u000bJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\u001fJ\r\u0010 \u001a\u00020\rH\u0010¢\u0006\u0002\b!J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020&H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u000fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u000fX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006'"}, d2 = {"Lcom/hive/promotion/ui/PromotionCustomViewFullscreen;", "Lcom/hive/promotion/ui/PromotionView;", "activity", "Landroid/app/Activity;", "url", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "webViewInfo", "Lcom/hive/promotion/ui/PromotionView$WebViewInfo;", "showAlways", "(Landroid/app/Activity;Lcom/hive/promotion/ui/PromotionView$WebViewInfo;Ljava/lang/String;)V", "myWebView", "Lcom/hive/core/webview/HiveWebView;", "btnPrev", "Landroid/widget/ImageView;", "getBtnPrev$hive_promotion_release", "()Landroid/widget/ImageView;", "setBtnPrev$hive_promotion_release", "(Landroid/widget/ImageView;)V", "btnNext", "getBtnNext$hive_promotion_release", "setBtnNext$hive_promotion_release", "btnRefresh", "getBtnRefresh$hive_promotion_release", "setBtnRefresh$hive_promotion_release", "btnClose", "getBtnClose$hive_promotion_release", "setBtnClose$hive_promotion_release", "onCreateView", "", "onCreateView$hive_promotion_release", "onCreateWebView", "onCreateWebView$hive_promotion_release", "initButtons", "updateButtons", "view", "isEnabled", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionCustomViewFullscreen extends PromotionView {
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
    public PromotionCustomViewFullscreen(Activity activity, String url) {
        super(activity, url);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionCustomViewFullscreen(Activity activity, PromotionView.WebViewInfo webViewInfo, String showAlways) {
        super(activity, webViewInfo, showAlways);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(webViewInfo, "webViewInfo");
        Intrinsics.checkNotNullParameter(showAlways, "showAlways");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0078  */
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
            java.lang.String r3 = "promotion_customview_v2_full"
            int r1 = r1.getLayoutId(r2, r3)
            r2 = r4
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            android.view.View r0 = android.view.View.inflate(r0, r1, r2)
            java.lang.String r1 = "null cannot be cast to non-null type com.hive.promotion.ui.PromotionView"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            com.hive.promotion.ui.PromotionView r0 = (com.hive.promotion.ui.PromotionView) r0
            r4.setMRoot$hive_promotion_release(r0)
            r4.showWebView(r5)
            r4.initButtons()
            android.app.Activity r5 = r4.getMActivity()
            boolean r0 = r5 instanceof com.hive.ui.HiveUiActivity
            if (r0 != 0) goto L3c
            boolean r0 = r5 instanceof com.hive.promotion.ui.news.NewsV2Activity
            if (r0 == 0) goto L8d
        L3c:
            com.hive.promotion.ui.PromotionView$WebViewInfo r0 = r4.getMWebViewInfo()
            java.lang.String r0 = r0.getDisplayOrientation()
            int r1 = r0.hashCode()
            r2 = -77725029(0xfffffffffb5e029b, float:-1.15274275E36)
            if (r1 == r2) goto L70
            r2 = 2044801(0x1f3381, float:2.865377E-39)
            if (r1 == r2) goto L64
            r2 = 1511893915(0x5a1dab9b, float:1.1095063E16)
            if (r1 == r2) goto L58
            goto L78
        L58:
            java.lang.String r1 = "PORTRAIT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L61
            goto L78
        L61:
            com.hive.core.configuration.HiveOrientation r0 = com.hive.core.configuration.HiveOrientation.PORTRAIT
            goto L81
        L64:
            java.lang.String r1 = "BOTH"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L6d
            goto L78
        L6d:
            com.hive.core.configuration.HiveOrientation r0 = com.hive.core.configuration.HiveOrientation.ALL
            goto L81
        L70:
            java.lang.String r1 = "LANDSCAPE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L7f
        L78:
            com.hive.core.Configuration r0 = com.hive.core.Configuration.INSTANCE
            com.hive.core.configuration.HiveOrientation r0 = r0.getHiveOrientation()
            goto L81
        L7f:
            com.hive.core.configuration.HiveOrientation r0 = com.hive.core.configuration.HiveOrientation.LANDSCAPE
        L81:
            r1 = r5
            com.hive.ui.common.controller.HiveUiOrientationController r1 = (com.hive.ui.common.controller.HiveUiOrientationController) r1
            com.hive.ui.Util r2 = com.hive.ui.Util.INSTANCE
            int r5 = r2.getSystemScreenOrientation(r5, r0)
            r1.lockOrientation(r5)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.ui.PromotionCustomViewFullscreen.onCreateView$hive_promotion_release(java.lang.String):void");
    }

    @Override // com.hive.promotion.ui.PromotionView
    public HiveWebView onCreateWebView$hive_promotion_release() {
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_webview"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        this.myWebView = (HiveWebView) viewFindViewById;
        View viewFindViewById2 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_view_spinner"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ProgressBar");
        setPromotion_view_spinner((ProgressBar) viewFindViewById2);
        View viewFindViewById3 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_loadingbar"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ProgressBar");
        setPromotion_customview_loading_progress((ProgressBar) viewFindViewById3);
        HiveWebView hiveWebView = this.myWebView;
        if (hiveWebView != null) {
            return hiveWebView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("myWebView");
        return null;
    }

    private final void initButtons() {
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_bottom"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById;
        View viewFindViewById2 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_btn_prev"));
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        setBtnPrev$hive_promotion_release((ImageView) viewFindViewById2);
        View viewFindViewById3 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_btn_next"));
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        setBtnNext$hive_promotion_release((ImageView) viewFindViewById3);
        View viewFindViewById4 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_btn_refresh"));
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type android.widget.ImageView");
        setBtnRefresh$hive_promotion_release((ImageView) viewFindViewById4);
        View viewFindViewById5 = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "promotion_customview_v2_btn_close"));
        Intrinsics.checkNotNull(viewFindViewById5, "null cannot be cast to non-null type android.widget.ImageView");
        setBtnClose$hive_promotion_release((ImageView) viewFindViewById5);
        PromotionView.WebViewInfo.ViewAppearance appearance = getMWebViewInfo().getAppearance();
        if (appearance != null) {
            linearLayout.setBackgroundColor(Color.parseColor(appearance.getNavbarColor()));
            getBtnPrev$hive_promotion_release().setColorFilter(Color.parseColor(appearance.getFrameColor()));
            getBtnNext$hive_promotion_release().setColorFilter(Color.parseColor(appearance.getFrameColor()));
            getBtnRefresh$hive_promotion_release().setColorFilter(Color.parseColor(appearance.getFrameColor()));
            getBtnClose$hive_promotion_release().setColorFilter(Color.parseColor(appearance.getFrameColor()));
            TouchEffectKt.setTouchEffect(getBtnPrev$hive_promotion_release(), (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.PromotionCustomViewFullscreen$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionCustomViewFullscreen.initButtons$lambda$4$lambda$0(this.f$0, (View) obj);
                }
            } : null);
            TouchEffectKt.setTouchEffect(getBtnNext$hive_promotion_release(), (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.PromotionCustomViewFullscreen$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionCustomViewFullscreen.initButtons$lambda$4$lambda$1(this.f$0, (View) obj);
                }
            } : null);
            TouchEffectKt.setTouchEffect(getBtnRefresh$hive_promotion_release(), (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.PromotionCustomViewFullscreen$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionCustomViewFullscreen.initButtons$lambda$4$lambda$2(this.f$0, (View) obj);
                }
            } : null);
            TouchEffectKt.setTouchEffect(getBtnClose$hive_promotion_release(), (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? Color.parseColor(appearance.getFrameColor()) : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.promotion.ui.PromotionCustomViewFullscreen$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PromotionCustomViewFullscreen.initButtons$lambda$4$lambda$3(this.f$0, (View) obj);
                }
            } : null);
        }
        getBtnPrev$hive_promotion_release().setImageResource(Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_customview_btn_prev_vector"));
        getBtnNext$hive_promotion_release().setImageResource(Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_customview_btn_next_vector"));
        getBtnRefresh$hive_promotion_release().setImageResource(Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_customview_btn_refresh_vector"));
        getBtnClose$hive_promotion_release().setImageResource(Resource.INSTANCE.getDrawableId(getMActivity(), "promotion_customview_btn_close_vector"));
        setMWebViewHistoryListener(new PromotionView.PromotionWebViewHistoryListener() { // from class: com.hive.promotion.ui.PromotionCustomViewFullscreen.initButtons.2
            @Override // com.hive.promotion.ui.PromotionView.PromotionWebViewHistoryListener
            public void checkHistoryAndUpdateButtons() {
                HiveWebView hiveWebView = PromotionCustomViewFullscreen.this.myWebView;
                if (hiveWebView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("myWebView");
                    hiveWebView = null;
                }
                WebBackForwardList webBackForwardListCopyBackForwardList = hiveWebView.copyBackForwardList();
                Intrinsics.checkNotNullExpressionValue(webBackForwardListCopyBackForwardList, "copyBackForwardList(...)");
                if (webBackForwardListCopyBackForwardList.getSize() == 0) {
                    PromotionCustomViewFullscreen promotionCustomViewFullscreen = PromotionCustomViewFullscreen.this;
                    promotionCustomViewFullscreen.updateButtons(promotionCustomViewFullscreen.getBtnPrev$hive_promotion_release(), false);
                    PromotionCustomViewFullscreen promotionCustomViewFullscreen2 = PromotionCustomViewFullscreen.this;
                    promotionCustomViewFullscreen2.updateButtons(promotionCustomViewFullscreen2.getBtnNext$hive_promotion_release(), false);
                    PromotionCustomViewFullscreen promotionCustomViewFullscreen3 = PromotionCustomViewFullscreen.this;
                    promotionCustomViewFullscreen3.updateButtons(promotionCustomViewFullscreen3.getBtnRefresh$hive_promotion_release(), true);
                    return;
                }
                WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(webBackForwardListCopyBackForwardList.getCurrentIndex());
                if (itemAtIndex != null) {
                    String url = itemAtIndex.getUrl();
                    Intrinsics.checkNotNullExpressionValue(url, "getUrl(...)");
                    if (StringsKt.contains$default((CharSequence) url, (CharSequence) "hive_error_embed.html", false, 2, (Object) null)) {
                        PromotionCustomViewFullscreen promotionCustomViewFullscreen4 = PromotionCustomViewFullscreen.this;
                        promotionCustomViewFullscreen4.updateButtons(promotionCustomViewFullscreen4.getBtnPrev$hive_promotion_release(), false);
                        PromotionCustomViewFullscreen promotionCustomViewFullscreen5 = PromotionCustomViewFullscreen.this;
                        promotionCustomViewFullscreen5.updateButtons(promotionCustomViewFullscreen5.getBtnNext$hive_promotion_release(), false);
                        PromotionCustomViewFullscreen promotionCustomViewFullscreen6 = PromotionCustomViewFullscreen.this;
                        promotionCustomViewFullscreen6.updateButtons(promotionCustomViewFullscreen6.getBtnRefresh$hive_promotion_release(), false);
                        return;
                    }
                }
                if (PromotionCustomViewFullscreen.this.getBackUrlIndex() == 0) {
                    PromotionCustomViewFullscreen promotionCustomViewFullscreen7 = PromotionCustomViewFullscreen.this;
                    promotionCustomViewFullscreen7.updateButtons(promotionCustomViewFullscreen7.getBtnPrev$hive_promotion_release(), false);
                } else {
                    PromotionCustomViewFullscreen promotionCustomViewFullscreen8 = PromotionCustomViewFullscreen.this;
                    promotionCustomViewFullscreen8.updateButtons(promotionCustomViewFullscreen8.getBtnPrev$hive_promotion_release(), true);
                }
                if (PromotionCustomViewFullscreen.this.getForwardUrlIndex() == 0) {
                    PromotionCustomViewFullscreen promotionCustomViewFullscreen9 = PromotionCustomViewFullscreen.this;
                    promotionCustomViewFullscreen9.updateButtons(promotionCustomViewFullscreen9.getBtnNext$hive_promotion_release(), false);
                } else {
                    PromotionCustomViewFullscreen promotionCustomViewFullscreen10 = PromotionCustomViewFullscreen.this;
                    promotionCustomViewFullscreen10.updateButtons(promotionCustomViewFullscreen10.getBtnNext$hive_promotion_release(), true);
                }
                PromotionCustomViewFullscreen promotionCustomViewFullscreen11 = PromotionCustomViewFullscreen.this;
                promotionCustomViewFullscreen11.updateButtons(promotionCustomViewFullscreen11.getBtnRefresh$hive_promotion_release(), true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$4$lambda$0(PromotionCustomViewFullscreen promotionCustomViewFullscreen, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (promotionCustomViewFullscreen.getBackUrlIndex() != 0) {
            HiveWebView hiveWebView = promotionCustomViewFullscreen.myWebView;
            if (hiveWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("myWebView");
                hiveWebView = null;
            }
            hiveWebView.goBackOrForward(promotionCustomViewFullscreen.getBackUrlIndex());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$4$lambda$1(PromotionCustomViewFullscreen promotionCustomViewFullscreen, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (promotionCustomViewFullscreen.getForwardUrlIndex() != 0) {
            HiveWebView hiveWebView = promotionCustomViewFullscreen.myWebView;
            if (hiveWebView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("myWebView");
                hiveWebView = null;
            }
            hiveWebView.goBackOrForward(promotionCustomViewFullscreen.getForwardUrlIndex());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$4$lambda$2(PromotionCustomViewFullscreen promotionCustomViewFullscreen, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        HiveWebView hiveWebView = promotionCustomViewFullscreen.myWebView;
        if (hiveWebView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myWebView");
            hiveWebView = null;
        }
        hiveWebView.reload();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initButtons$lambda$4$lambda$3(PromotionCustomViewFullscreen promotionCustomViewFullscreen, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (promotionCustomViewFullscreen.getMWebViewHistoryListener() != null) {
            promotionCustomViewFullscreen.setMWebViewHistoryListener(null);
        }
        ComponentCallbacks2 mActivity$hive_promotion_release = promotionCustomViewFullscreen.getMActivity();
        if ((mActivity$hive_promotion_release instanceof HiveUiActivity) || (mActivity$hive_promotion_release instanceof NewsV2Activity)) {
            ((HiveUiOrientationController) mActivity$hive_promotion_release).unlockOrientation();
        }
        PromotionView.ButtonClickedListener buttonClickedListener = promotionCustomViewFullscreen.getButtonClickedListener();
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
