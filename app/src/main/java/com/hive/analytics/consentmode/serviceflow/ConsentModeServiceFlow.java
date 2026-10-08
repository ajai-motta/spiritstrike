package com.hive.analytics.consentmode.serviceflow;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Analytics;
import com.hive.ResultAPI;
import com.hive.analytics.consentmode.ui.ConsentModeUi;
import com.hive.analytics.consentmode.ui.model.ConsentModeUiModel;
import com.hive.analytics.consentmode.ui.model.ConsentModeUiModelKt;
import com.hive.analytics.consentmode.ui.model.OnConsentModeUiListener;
import com.hive.core.ExtentionsKt;
import com.hive.logger.LoggerImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ConsentModeServiceFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/hive/analytics/consentmode/serviceflow/ConsentModeServiceFlow;", "", "activity", "Landroid/app/Activity;", "consentMode", "Lcom/hive/Analytics$ConsentMode;", "<init>", "(Landroid/app/Activity;Lcom/hive/Analytics$ConsentMode;)V", "consentModeUi", "Lcom/hive/analytics/consentmode/ui/ConsentModeUi;", "getConsentModeUi", "()Lcom/hive/analytics/consentmode/ui/ConsentModeUi;", "show", "", "isRequire", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Analytics$ConsentModeListener;", "openUrl", "parentActivity", "url", "", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConsentModeServiceFlow {
    private final Activity activity;
    private final Analytics.ConsentMode consentMode;
    private final ConsentModeUi consentModeUi;

    public ConsentModeServiceFlow(Activity activity, Analytics.ConsentMode consentMode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(consentMode, "consentMode");
        this.activity = activity;
        this.consentMode = consentMode;
        this.consentModeUi = new ConsentModeUi(activity, ConsentModeUiModelKt.genConsentModeUiModel(consentMode));
    }

    public final ConsentModeUi getConsentModeUi() {
        return this.consentModeUi;
    }

    public static /* synthetic */ void show$default(ConsentModeServiceFlow consentModeServiceFlow, boolean z, Analytics.ConsentModeListener consentModeListener, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        consentModeServiceFlow.show(z, consentModeListener);
    }

    public final void show(boolean isRequire, Analytics.ConsentModeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[ConsentModeServiceFlow] show()");
        this.consentModeUi.show(isRequire, new AnonymousClass1(listener, isRequire));
    }

    /* JADX INFO: renamed from: com.hive.analytics.consentmode.serviceflow.ConsentModeServiceFlow$show$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConsentModeServiceFlow.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/hive/analytics/consentmode/serviceflow/ConsentModeServiceFlow$show$1", "Lcom/hive/analytics/consentmode/ui/model/OnConsentModeUiListener;", "onSubmit", "", "consentModeUiModel", "Lcom/hive/analytics/consentmode/ui/model/ConsentModeUiModel;", "onPrivacyPolicy", "onClose", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements OnConsentModeUiListener {
        final /* synthetic */ boolean $isRequire;
        final /* synthetic */ Analytics.ConsentModeListener $listener;

        AnonymousClass1(Analytics.ConsentModeListener consentModeListener, boolean z) {
            this.$listener = consentModeListener;
            this.$isRequire = z;
        }

        @Override // com.hive.analytics.consentmode.ui.model.OnConsentModeUiListener
        public void onSubmit(ConsentModeUiModel consentModeUiModel) {
            Intrinsics.checkNotNullParameter(consentModeUiModel, "consentModeUiModel");
            ConsentModeUiModelKt.updateFromUiModel(ConsentModeServiceFlow.this.consentMode, consentModeUiModel);
            ArrayList arrayList = new ArrayList();
            Analytics.ConsentMode.ConsentForm adUserData = ConsentModeServiceFlow.this.consentMode.getAdUserData();
            if (adUserData != null) {
                Analytics.ConsentMode.ConsentStatus consentStatus = adUserData.getConsentStatus();
                consentStatus.consent(adUserData.getRetentionPeriod());
                arrayList.add(consentStatus);
            }
            Analytics.ConsentMode.ConsentForm adPersonalization = ConsentModeServiceFlow.this.consentMode.getAdPersonalization();
            if (adPersonalization != null) {
                Analytics.ConsentMode.ConsentStatus consentStatus2 = adPersonalization.getConsentStatus();
                consentStatus2.consent(adPersonalization.getRetentionPeriod());
                arrayList.add(consentStatus2);
                List<Analytics.ConsentMode.ConsentForm> subForms = adPersonalization.getSubForms();
                if (subForms != null) {
                    for (Analytics.ConsentMode.ConsentForm consentForm : subForms) {
                        Analytics.ConsentMode.ConsentStatus consentStatus3 = consentForm.getConsentStatus();
                        consentStatus3.consent(consentForm.getRetentionPeriod());
                        arrayList.add(consentStatus3);
                    }
                }
            }
            Analytics.ConsentMode.ConsentForm analyticsStorage = ConsentModeServiceFlow.this.consentMode.getAnalyticsStorage();
            if (analyticsStorage != null) {
                Analytics.ConsentMode.ConsentStatus consentStatus4 = analyticsStorage.getConsentStatus();
                consentStatus4.consent(analyticsStorage.getRetentionPeriod());
                arrayList.add(consentStatus4);
            }
            ConsentModeServiceFlow.this.getConsentModeUi().finish();
            this.$listener.onConsentModeDismissed(new ResultAPI(), arrayList);
        }

        @Override // com.hive.analytics.consentmode.ui.model.OnConsentModeUiListener
        public void onPrivacyPolicy() {
            ConsentModeServiceFlow consentModeServiceFlow = ConsentModeServiceFlow.this;
            consentModeServiceFlow.openUrl(consentModeServiceFlow.activity, ConsentModeServiceFlow.this.consentMode.getPrivacyPolicy());
        }

        @Override // com.hive.analytics.consentmode.ui.model.OnConsentModeUiListener
        public void onClose() {
            if (this.$isRequire) {
                Handler handler = new Handler(Looper.getMainLooper());
                final ConsentModeServiceFlow consentModeServiceFlow = ConsentModeServiceFlow.this;
                final Analytics.ConsentModeListener consentModeListener = this.$listener;
                handler.post(new Runnable() { // from class: com.hive.analytics.consentmode.serviceflow.ConsentModeServiceFlow$show$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        consentModeServiceFlow.show(true, consentModeListener);
                    }
                });
                return;
            }
            ConsentModeServiceFlow.this.getConsentModeUi().finish();
            this.$listener.onConsentModeDismissed(new ResultAPI(-6, ResultAPI.Code.AnalyticsConsentModeCanceled), new ArrayList());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openUrl(Activity parentActivity, String url) {
        LoggerImpl.INSTANCE.d("[ConsentModeServiceFlow] openUrl: " + url);
        if (StringsKt.isBlank(url)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(url));
        ExtentionsKt.startActivityCatching$default(this.activity, intent, null, 2, null);
    }
}
