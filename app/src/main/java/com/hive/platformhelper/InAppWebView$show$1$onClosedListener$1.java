package com.hive.platformhelper;

import com.hive.PlatformHelper;
import com.hive.ResultAPI;
import com.hive.logger.LoggerImpl;
import com.hive.ui.common.model.OnClosedListener;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/hive/platformhelper/InAppWebView$show$1$onClosedListener$1", "Lcom/hive/ui/common/model/OnClosedListener;", "onClosed", "", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InAppWebView$show$1$onClosedListener$1 implements OnClosedListener {
    final /* synthetic */ PlatformHelper.InAppWebViewListener $listener;

    public InAppWebView$show$1$onClosedListener$1(PlatformHelper.InAppWebViewListener inAppWebViewListener) {
        this.$listener = inAppWebViewListener;
    }

    @Override // com.hive.ui.common.model.OnClosedListener
    public void onClosed() {
        LoggerImpl.INSTANCE.i("InAppWebView show() onClosed");
        this.$listener.onInAppWebView(new ResultAPI());
    }
}
