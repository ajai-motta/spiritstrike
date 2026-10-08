package com.hive.ui.common.view;

import android.app.Activity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import com.hive.core.webview.HiveWebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"com/hive/ui/common/view/HiveView$onCreateWebView$1$3", "", "retry", "", "json", "", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveView$onCreateWebView$1$3 {
    final /* synthetic */ HiveWebView $this_with;
    final /* synthetic */ HiveView this$0;

    HiveView$onCreateWebView$1$3(HiveView hiveView, HiveWebView hiveWebView) {
        this.this$0 = hiveView;
        this.$this_with = hiveWebView;
    }

    @JavascriptInterface
    public final void retry() {
        Log.d("JS", "retry no params");
        Activity activity = this.this$0.getActivity();
        final HiveWebView hiveWebView = this.$this_with;
        activity.runOnUiThread(new Runnable() { // from class: com.hive.ui.common.view.HiveView$onCreateWebView$1$3$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                hiveWebView.reload();
            }
        });
    }

    @JavascriptInterface
    public final void retry(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Log.d("JS", "retry with params: " + json);
        Activity activity = this.this$0.getActivity();
        final HiveWebView hiveWebView = this.$this_with;
        activity.runOnUiThread(new Runnable() { // from class: com.hive.ui.common.view.HiveView$onCreateWebView$1$3$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                hiveWebView.reload();
            }
        });
    }
}
