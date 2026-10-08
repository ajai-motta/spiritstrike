package com.hive.module.interfaces.analytics;

import android.app.Activity;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Analytics;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&J\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H&R\u0018\u0010\u0004\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/hive/module/interfaces/analytics/ConsentMode;", "Lcom/hive/module/HiveModule;", "getHiveModuleName", "", "defaultPrivacyPolicyUrl", "getDefaultPrivacyPolicyUrl", "()Ljava/lang/String;", "setDefaultPrivacyPolicyUrl", "(Ljava/lang/String;)V", "showConsentModeIfRequire", "", "activity", "Landroid/app/Activity;", "checkCmp", "", "consentMode", "Lcom/hive/Analytics$ConsentMode;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Analytics$ConsentModeListener;", "showConsentMode", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ConsentMode extends HiveModule {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getHiveModuleName(ConsentMode consentMode) {
            return HiveModuleName.INSTANCE.getAnalytics_Consent_Mode();
        }

        public static /* synthetic */ void showConsentModeIfRequire$default(ConsentMode consentMode, Activity activity, boolean z, Analytics.ConsentMode consentMode2, Analytics.ConsentModeListener consentModeListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showConsentModeIfRequire");
            }
            if ((i & 2) != 0) {
                z = true;
            }
            consentMode.showConsentModeIfRequire(activity, z, consentMode2, consentModeListener);
        }
    }

    String getDefaultPrivacyPolicyUrl();

    @Override // com.hive.module.HiveModule
    String getHiveModuleName();

    void setDefaultPrivacyPolicyUrl(String str);

    void showConsentMode(Activity activity, Analytics.ConsentMode consentMode, Analytics.ConsentModeListener listener);

    void showConsentModeIfRequire(Activity activity, boolean checkCmp, Analytics.ConsentMode consentMode, Analytics.ConsentModeListener listener);
}
