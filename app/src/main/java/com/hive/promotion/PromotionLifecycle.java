package com.hive.promotion;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import com.hive.HiveActivity;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.OnActivityLifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromotionLifecycle.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J*\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¨\u0006\u001a"}, d2 = {"Lcom/hive/promotion/PromotionLifecycle;", "Lcom/hive/standalone/HiveLifecycle$HiveLifecycleListener;", "Lcom/hive/ui/OnActivityLifecycle;", "<init>", "()V", "onSetupFinished", "", "onInitializeFinished", "onSignIn", "hiveAccount", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "onSignOut", "onNetworkAvailable", "isAvailable", "", "onActivityResult", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromotionLifecycle extends OnActivityLifecycle implements HiveLifecycle.HiveLifecycleListener {
    public PromotionLifecycle() {
        HiveLifecycle.registerHiveLifecycleListeners(this);
        HiveActivity.registerHiveActivityLifecycleListeners(this);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onAgreement() {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onAgreement(this);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onProcessUri(String str) {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onProcessUri(this, str);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onReset() {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onReset(this);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onSetupFinished() {
        PromotionImpl.INSTANCE.initialize();
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onInitializeFinished() {
        PromotionImpl.INSTANCE.initialize();
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onSignIn(HiveLifecycle.HiveAccount hiveAccount) {
        Intrinsics.checkNotNullParameter(hiveAccount, "hiveAccount");
        PromotionImpl.INSTANCE.setProgressedLogin$hive_promotion_release(true);
        PromotionImpl.INSTANCE.updatePromotionData();
        PromotionImpl.INSTANCE.requestLogin();
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onSignOut() {
        PromotionImpl.INSTANCE.setProgressedLogin$hive_promotion_release(false);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onNetworkAvailable(boolean isAvailable) {
        PromotionImpl.INSTANCE.onNetworkAvailable(isAvailable);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PromotionImpl.INSTANCE.onActivityResult(activity, requestCode, resultCode, data);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        PromotionImpl.INSTANCE.onConfigurationChanged(activity, newConfig);
    }
}
