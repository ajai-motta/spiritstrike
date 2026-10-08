package com.hive.promotion.ui;

import android.app.Activity;
import android.view.View;
import com.hive.core.webview.HiveWebView;
import com.hive.promotion.R;
import com.hive.promotion.ui.PromotionView;
import com.hive.ui.Resource;
import com.hive.ui.Util;
import com.hive.ui.view.HiveAnimationButton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromotionViewFrame.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\nJ\r\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/hive/promotion/ui/PromotionViewFrame;", "Lcom/hive/promotion/ui/PromotionView;", "activity", "Landroid/app/Activity;", "url", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "onCreateView", "", "onCreateView$hive_promotion_release", "onCreateWebView", "Lcom/hive/core/webview/HiveWebView;", "onCreateWebView$hive_promotion_release", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionViewFrame extends PromotionView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionViewFrame(Activity activity, String url) {
        super(activity, url);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // com.hive.promotion.ui.PromotionView
    public void onCreateView$hive_promotion_release(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        View viewInflate = View.inflate(getMActivity(), Resource.INSTANCE.getLayoutId(getMActivity(), "promotion_view_frame"), this);
        Intrinsics.checkNotNull(viewInflate, "null cannot be cast to non-null type com.hive.promotion.ui.PromotionView");
        setMRoot$hive_promotion_release((PromotionView) viewInflate);
        ((HiveAnimationButton) getMRoot$hive_promotion_release().findViewById(R.id.frame_close_btn)).setOnClickedListener(new HiveAnimationButton.OnClickedListener() { // from class: com.hive.promotion.ui.PromotionViewFrame$onCreateView$1
            @Override // com.hive.ui.view.HiveAnimationButton.OnClickedListener
            public void onClick() {
                PromotionView.ButtonClickedListener buttonClickedListener = this.this$0.getButtonClickedListener();
                if (buttonClickedListener != null) {
                    buttonClickedListener.onClose();
                }
            }
        });
        RoundedCornerView roundedCornerView = (RoundedCornerView) getMRoot$hive_promotion_release().findViewById(R.id.rounded_corner);
        if (Util.INSTANCE.isPortrait(getMActivity())) {
            roundedCornerView.setScaledCornerSize(1, 439.0f, 8.5f);
        } else {
            roundedCornerView.setScaledCornerSize(0, 456.0f, 8.5f);
        }
        showWebView(url);
    }

    @Override // com.hive.promotion.ui.PromotionView
    public HiveWebView onCreateWebView$hive_promotion_release() {
        View viewFindViewById = findViewById(Resource.INSTANCE.getViewId(getMActivity(), "webView"));
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type com.hive.core.webview.HiveWebView");
        return (HiveWebView) viewFindViewById;
    }
}
