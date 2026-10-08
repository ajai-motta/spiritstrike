package com.hive.promotion.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.hive.HiveActivity;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.webview.HiveWebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: PromotionViewExternalBrowser.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0010¢\u0006\u0002\b\nJ\r\u0010\u000b\u001a\u00020\fH\u0010¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/hive/promotion/ui/PromotionViewExternalBrowser;", "Lcom/hive/promotion/ui/PromotionView;", "activity", "Landroid/app/Activity;", "url", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "onCreateView", "", "onCreateView$hive_promotion_release", "onCreateWebView", "Lcom/hive/core/webview/HiveWebView;", "onCreateWebView$hive_promotion_release", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionViewExternalBrowser extends PromotionView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionViewExternalBrowser(Activity activity, String url) {
        super(activity, url);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(url, "url");
    }

    @Override // com.hive.promotion.ui.PromotionView
    public void onCreateView$hive_promotion_release(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(url));
        ExtentionsKt.startActivityCatching$default(HiveActivity.INSTANCE.getRecentActivity(), intent, null, 2, null);
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new PromotionViewExternalBrowser$onCreateView$1(this, null), 3, null);
    }

    @Override // com.hive.promotion.ui.PromotionView
    public HiveWebView onCreateWebView$hive_promotion_release() {
        return new HiveWebView(HiveCoreInitializer.INSTANCE.getInitContext());
    }
}
