package com.hive.analytics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.hive.HiveActivity;
import com.hive.analytics.AnalyticsImpl;
import com.hive.analytics.logger.RemoteLoggerV2;
import com.hive.analytics.provider.AnalyticsProviderAdapter;
import com.hive.configuration.ConfigurationImpl;
import com.hive.core.Configuration;
import com.hive.core.NetworkObserver;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.OnActivityLifecycle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¨\u0006\u001b"}, d2 = {"Lcom/hive/analytics/AnalyticsLifeCycle;", "Lcom/hive/standalone/HiveLifecycle$HiveLifecycleListener;", "Lcom/hive/ui/OnActivityLifecycle;", "<init>", "()V", "analyticsInit", "", "onAgreement", "onSetupFinished", "onInitializeFinished", "onSignIn", "hiveAccount", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "onSignOut", "onNetworkAvailable", "isAvailable", "", "onCreate", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "onPause", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsLifeCycle extends OnActivityLifecycle implements HiveLifecycle.HiveLifecycleListener {
    public AnalyticsLifeCycle() {
        HiveLifecycle.registerHiveLifecycleListeners(this);
        HiveActivity.registerHiveActivityLifecycleListeners(this);
    }

    private final void analyticsInit() {
        String analyticsId = Configuration.INSTANCE.getAnalyticsId();
        AnalyticsImpl analyticsImpl = AnalyticsImpl.INSTANCE;
        HiveLifecycle hiveLifecycle = HiveLifecycle.INSTANCE;
        analyticsImpl.initialize(hiveLifecycle.getAccount().getDid(), analyticsId);
        analyticsImpl.setTransferReadyState(hiveLifecycle.getNetworkAvailable());
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onAgreement() {
        if (ConfigurationImpl.INSTANCE.isAgreementDetermineBaseAccount()) {
            analyticsInit();
        }
        AnalyticsImpl.INSTANCE.sendUserEntryFunnelsLogs(AnalyticsImpl.FunnelsTrack.AGREEMENT_POPUP);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        NetworkObserver networkObserver = NetworkObserver.INSTANCE;
        AnalyticsImpl analyticsImpl = AnalyticsImpl.INSTANCE;
        networkObserver.attach(analyticsImpl.getNetworkResponseObserver());
        analyticsImpl.onCreate(activity.getIntent());
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onInitializeFinished() {
        analyticsInit();
        AnalyticsImpl.INSTANCE.sendDeviceInfoLog();
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onNetworkAvailable(boolean isAvailable) {
        AnalyticsImpl.INSTANCE.setTransferReadyState(isAvailable);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AnalyticsImpl.INSTANCE.onNewIntent(activity, intent);
        RemoteLoggerV2.INSTANCE.onNewIntent(activity, intent);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AnalyticsImpl.INSTANCE.onPause(activity);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onProcessUri(String str) {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onProcessUri(this, str);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onReset() {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onReset(this);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AnalyticsImpl.INSTANCE.onResume(activity);
        RemoteLoggerV2.INSTANCE.onResume(activity);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onSetupFinished() {
        if (!ConfigurationImpl.INSTANCE.isAgreementDetermineBaseAccount()) {
            analyticsInit();
        }
        AnalyticsImpl.INSTANCE.sendDeviceInfoLog();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSignIn(com.hive.standalone.HiveLifecycle.HiveAccount r5) {
        /*
            r4 = this;
            java.lang.String r0 = "hiveAccount"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.hive.core.NetworkObserver r0 = com.hive.core.NetworkObserver.INSTANCE
            com.hive.analytics.AnalyticsImpl r1 = com.hive.analytics.AnalyticsImpl.INSTANCE
            kotlin.jvm.functions.Function1 r2 = r1.getNetworkResponseObserver()
            r0.detach(r2)
            java.lang.String r0 = r5.getVid()
            r2 = 0
            if (r0 == 0) goto L21
            boolean r3 = kotlin.text.StringsKt.isBlank(r0)
            if (r3 != 0) goto L1e
            goto L1f
        L1e:
            r0 = r2
        L1f:
            if (r0 != 0) goto L2f
        L21:
            java.lang.String r0 = r5.getUid()
            if (r0 == 0) goto L2e
            boolean r5 = kotlin.text.StringsKt.isBlank(r0)
            if (r5 != 0) goto L2e
            goto L2f
        L2e:
            r0 = r2
        L2f:
            if (r0 == 0) goto L34
            r1.setCustomUserId(r0)
        L34:
            com.hive.analytics.AnalyticsImpl$FunnelsTrack r5 = com.hive.analytics.AnalyticsImpl.FunnelsTrack.LOGIN
            r1.sendUserEntryFunnelsLogs(r5)
            r1.activateConCurrentUserLog()
            com.hive.analytics.provider.AnalyticsProviderAdapter$StandardEventType r5 = com.hive.analytics.provider.AnalyticsProviderAdapter.StandardEventType.SIGN_IN
            r0 = 2
            com.hive.analytics.AnalyticsImpl.sendStandardEvent$default(r1, r5, r2, r0, r2)
            r1.sendDeviceInfoLog()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.analytics.AnalyticsLifeCycle.onSignIn(com.hive.standalone.HiveLifecycle$HiveAccount):void");
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onSignOut() {
        AnalyticsImpl analyticsImpl = AnalyticsImpl.INSTANCE;
        analyticsImpl.setCustomUserId(null);
        analyticsImpl.deactivateConcurrentUserLog();
        AnalyticsImpl.sendStandardEvent$default(analyticsImpl, AnalyticsProviderAdapter.StandardEventType.SIGN_OUT, null, 2, null);
    }
}
