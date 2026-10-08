package com.hive.promotion.ui.news;

import android.app.Activity;
import android.view.ViewGroup;
import com.hive.promotion.R;
import com.hive.promotion.ui.news.NewsV2View;
import com.hive.ui.Util;
import com.hive.ui.view.HiveAnimationButton;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: NewsV2FullScreenView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/hive/promotion/ui/news/NewsV2FullScreenView;", "Lcom/hive/promotion/ui/news/NewsV2View;", "activity", "Landroid/app/Activity;", "url", "", "basePostData", "Lorg/json/JSONObject;", "showBackButton", "", AdUnitActivity.EXTRA_ORIENTATION, "<init>", "(Landroid/app/Activity;Ljava/lang/String;Lorg/json/JSONObject;ZLjava/lang/String;)V", "getOrientation", "()Ljava/lang/String;", "rootView", "Landroid/view/ViewGroup;", "backBtn", "Lcom/hive/ui/view/HiveAnimationButton;", "closeBtn", "onCreateView", "", "onAttachedToWindow", "initBackButton", "initCloseButton", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NewsV2FullScreenView extends NewsV2View {
    private HiveAnimationButton backBtn;
    private HiveAnimationButton closeBtn;
    private final String orientation;
    private ViewGroup rootView;

    public /* synthetic */ NewsV2FullScreenView(Activity activity, String str, JSONObject jSONObject, boolean z, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : jSONObject, (i & 8) != 0 ? true : z, (i & 16) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewsV2FullScreenView(Activity activity, String url, JSONObject jSONObject, boolean z, String orientation) {
        super(activity, url, jSONObject, z);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.orientation = orientation;
        setViewType(NewsV2View.ViewType.FullScreenView);
        initialize();
    }

    public final String getOrientation() {
        return this.orientation;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    @Override // com.hive.promotion.ui.news.NewsV2View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreateView() {
        /*
            r4 = this;
            android.app.Activity r0 = r4.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            int r1 = com.hive.promotion.R.layout.news_v2_fullscreen_view
            r2 = r4
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            android.view.View r0 = android.view.View.inflate(r0, r1, r2)
            java.lang.String r1 = "null cannot be cast to non-null type android.view.ViewGroup"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r4.rootView = r0
            if (r0 != 0) goto L20
            java.lang.String r0 = "rootView"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        L20:
            int r1 = com.hive.promotion.R.id.webView
            android.view.View r0 = r0.findViewById(r1)
            com.hive.core.webview.HiveWebView r0 = (com.hive.core.webview.HiveWebView) r0
            r4.setWebView(r0)
            r4.initBackButton()
            r4.initCloseButton()
            android.app.Activity r0 = r4.getActivity()
            boolean r0 = r0 instanceof com.hive.promotion.ui.news.NewsV2Activity
            if (r0 == 0) goto L96
            java.lang.String r0 = r4.orientation
            java.util.Locale r1 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toUpperCase(r1)
            java.lang.String r1 = "toUpperCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            int r1 = r0.hashCode()
            r2 = -77725029(0xfffffffffb5e029b, float:-1.15274275E36)
            if (r1 == r2) goto L72
            r2 = 2044801(0x1f3381, float:2.865377E-39)
            if (r1 == r2) goto L66
            r2 = 1511893915(0x5a1dab9b, float:1.1095063E16)
            if (r1 == r2) goto L5a
            goto L7a
        L5a:
            java.lang.String r1 = "PORTRAIT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L63
            goto L7a
        L63:
            com.hive.core.configuration.HiveOrientation r0 = com.hive.core.configuration.HiveOrientation.PORTRAIT
            goto L83
        L66:
            java.lang.String r1 = "BOTH"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L6f
            goto L7a
        L6f:
            com.hive.core.configuration.HiveOrientation r0 = com.hive.core.configuration.HiveOrientation.ALL
            goto L83
        L72:
            java.lang.String r1 = "LANDSCAPE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L81
        L7a:
            com.hive.core.Configuration r0 = com.hive.core.Configuration.INSTANCE
            com.hive.core.configuration.HiveOrientation r0 = r0.getHiveOrientation()
            goto L83
        L81:
            com.hive.core.configuration.HiveOrientation r0 = com.hive.core.configuration.HiveOrientation.LANDSCAPE
        L83:
            android.app.Activity r1 = r4.getActivity()
            com.hive.promotion.ui.news.NewsV2Activity r1 = (com.hive.promotion.ui.news.NewsV2Activity) r1
            com.hive.ui.Util r2 = com.hive.ui.Util.INSTANCE
            android.app.Activity r3 = r4.getActivity()
            int r0 = r2.getSystemScreenOrientation(r3, r0)
            r1.lockOrientation(r0)
        L96:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.promotion.ui.news.NewsV2FullScreenView.onCreateView():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Util util = Util.INSTANCE;
        ViewGroup viewGroup = this.rootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            viewGroup = null;
        }
        util.setDisplayCutoutNever(viewGroup);
        Util util2 = Util.INSTANCE;
        ViewGroup viewGroup3 = this.rootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
        } else {
            viewGroup2 = viewGroup3;
        }
        util2.setOnDisplayCutoutNever(viewGroup2);
    }

    private final void initBackButton() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            viewGroup = null;
        }
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) viewGroup.findViewById(R.id.back_imageView);
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.promotion.ui.news.NewsV2FullScreenView$initBackButton$1$1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                this.this$0.onBackPressed();
            }
        });
        hiveAnimationButton.setVisibility(getShowBackButton() ? 0 : 4);
        this.backBtn = hiveAnimationButton;
    }

    private final void initCloseButton() {
        ViewGroup viewGroup = this.rootView;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
            viewGroup = null;
        }
        HiveAnimationButton hiveAnimationButton = (HiveAnimationButton) viewGroup.findViewById(R.id.close_imageView);
        hiveAnimationButton.setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.promotion.ui.news.NewsV2FullScreenView$initCloseButton$1$1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                this.this$0.getActivity().finish();
            }
        });
        this.closeBtn = hiveAnimationButton;
    }
}
