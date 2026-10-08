package com.hive.ui.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.core.Logger;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.R;
import com.hive.ui.common.model.HiveCustomViewBannerData;
import com.hive.ui.common.model.HiveFullscreenViewData;
import com.hive.ui.common.model.HiveViewData;
import com.hive.ui.common.model.OnClosedListener;
import com.hive.ui.common.view.HiveCustomViewBanner;
import com.hive.ui.common.view.HiveFullscreenView;
import com.hive.ui.common.view.HiveView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/hive/ui/common/HiveUi;", "Lcom/hive/ui/OnActivityLifecycle;", "activity", "Landroid/app/Activity;", "hiveViewData", "Lcom/hive/ui/common/model/HiveViewData;", "<init>", "(Landroid/app/Activity;Lcom/hive/ui/common/model/HiveViewData;)V", "TAG", "", "kotlin.jvm.PlatformType", "launcherActivity", "hiveView", "Lcom/hive/ui/common/view/HiveView;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/ui/common/model/OnClosedListener;", "addOnClosedListener", "show", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "", "onDestroy", "onClosed", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveUi extends OnActivityLifecycle {
    private final String TAG;
    private final Activity activity;
    private HiveView hiveView;
    private final HiveViewData hiveViewData;
    private Activity launcherActivity;
    private OnClosedListener listener;

    public HiveUi(Activity activity, HiveViewData hiveViewData) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(hiveViewData, "hiveViewData");
        this.activity = activity;
        this.hiveViewData = hiveViewData;
        this.TAG = "HiveUi";
    }

    public final HiveUi addOnClosedListener(OnClosedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        return this;
    }

    public final void show() {
        Logger.INSTANCE.d(this.TAG, "show()");
        Intent intent = new Intent();
        if (this.hiveViewData instanceof HiveFullscreenViewData) {
            intent.putExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, true);
        }
        HiveUiActivity.INSTANCE.launch(this.activity, intent, this);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        HiveFullscreenView hiveFullscreenView;
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.launcherActivity = activity;
        activity.setContentView(R.layout.hive_socialv4_ui);
        FrameLayout frameLayout = (FrameLayout) activity.findViewById(R.id.socialv4_layout);
        HiveViewData hiveViewData = this.hiveViewData;
        if (hiveViewData instanceof HiveCustomViewBannerData) {
            hiveFullscreenView = new HiveCustomViewBanner(activity, (HiveCustomViewBannerData) this.hiveViewData, new OnClosedListener() { // from class: com.hive.ui.common.HiveUi.onCreate.1
                @Override // com.hive.ui.common.model.OnClosedListener
                public void onClosed() {
                    HiveUi.this.onClosed();
                }
            });
        } else {
            hiveFullscreenView = hiveViewData instanceof HiveFullscreenViewData ? new HiveFullscreenView(activity, (HiveFullscreenViewData) this.hiveViewData, new OnClosedListener() { // from class: com.hive.ui.common.HiveUi.onCreate.2
                @Override // com.hive.ui.common.model.OnClosedListener
                public void onClosed() {
                    HiveUi.this.onClosed();
                }
            }) : null;
        }
        this.hiveView = hiveFullscreenView;
        if (hiveFullscreenView != null) {
            frameLayout.addView(hiveFullscreenView);
        } else {
            Logger.INSTANCE.w(this.TAG, "HiveView did not create. will finish()");
            activity.finish();
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public boolean onBackPressed() {
        Logger.INSTANCE.d(this.TAG, "onBackPressed()");
        HiveView hiveView = this.hiveView;
        if (hiveView != null && hiveView.canGoBack()) {
            Logger.INSTANCE.d("[HiveView] onBackPressed goBack()");
            HiveView hiveView2 = this.hiveView;
            if (hiveView2 != null) {
                hiveView2.goBack();
            }
        } else {
            Logger.INSTANCE.d("[HiveView] onBackPressed activity finish()");
            onClosed();
        }
        return true;
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.INSTANCE.d(this.TAG, "onDestroy()");
        if (getIsCalledFinish() || getIsRecreated()) {
            return;
        }
        Logger.INSTANCE.d(this.TAG, "unexpected onDestroy()");
        OnClosedListener onClosedListener = this.listener;
        if (onClosedListener != null) {
            onClosedListener.onClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosed() {
        Logger.INSTANCE.d(this.TAG, "onClosed()");
        OnClosedListener onClosedListener = this.listener;
        if (onClosedListener != null) {
            onClosedListener.onClosed();
        }
        Activity activity = this.launcherActivity;
        if (activity != null) {
            activity.finish();
        }
    }
}
