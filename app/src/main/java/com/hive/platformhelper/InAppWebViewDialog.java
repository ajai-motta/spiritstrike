package com.hive.platformhelper;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.activity.OnBackPressedCallback;
import com.hive.core.Logger;
import com.hive.ui.common.model.HiveFullscreenViewData;
import com.hive.ui.common.model.OnClosedListener;
import com.hive.ui.common.view.HiveFullscreenView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/hive/platformhelper/InAppWebViewDialog;", "Landroidx/activity/ComponentDialog;", "activity", "Landroid/app/Activity;", "hiveViewData", "Lcom/hive/ui/common/model/HiveFullscreenViewData;", "<init>", "(Landroid/app/Activity;Lcom/hive/ui/common/model/HiveFullscreenViewData;)V", "getActivity", "()Landroid/app/Activity;", "getHiveViewData", "()Lcom/hive/ui/common/model/HiveFullscreenViewData;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InAppWebViewDialog extends ComponentDialog {
    private final Activity activity;
    private final HiveFullscreenViewData hiveViewData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InAppWebViewDialog(Activity activity, HiveFullscreenViewData hiveViewData) {
        super(activity, R.style.Theme.Translucent.NoTitleBar.Fullscreen);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(hiveViewData, "hiveViewData");
        this.activity = activity;
        this.hiveViewData = hiveViewData;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final HiveFullscreenViewData getHiveViewData() {
        return this.hiveViewData;
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(false);
        final HiveFullscreenView hiveFullscreenView = new HiveFullscreenView(this.activity, this.hiveViewData, new OnClosedListener() { // from class: com.hive.platformhelper.InAppWebViewDialog$onCreate$hiveView$1
            @Override // com.hive.ui.common.model.OnClosedListener
            public void onClosed() {
                this.this$0.dismiss();
            }
        });
        setContentView(hiveFullscreenView, new ViewGroup.LayoutParams(-1, -1));
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.hive.platformhelper.InAppWebViewDialog.onCreate.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (hiveFullscreenView.canGoBack()) {
                    Logger.INSTANCE.d("[InAppWebViewDialog] onBackPressed: goBack()");
                    hiveFullscreenView.goBack();
                } else {
                    Logger.INSTANCE.d("[InAppWebViewDialog] onBackPressed: dismiss dialog.");
                    this.dismiss();
                }
            }
        });
    }
}
