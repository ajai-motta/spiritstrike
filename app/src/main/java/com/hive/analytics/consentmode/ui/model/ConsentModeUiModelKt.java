package com.hive.analytics.consentmode.ui.model;

import com.hive.Analytics;
import com.hive.analytics.consentmode.ui.model.ConsentFormUiModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConsentModeUiModel.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, d2 = {"genConsentModeUiModel", "Lcom/hive/analytics/consentmode/ui/model/ConsentModeUiModel;", "Lcom/hive/Analytics$ConsentMode;", "updateFromUiModel", "", "uiModel", "findConsentFormById", "Lcom/hive/Analytics$ConsentMode$ConsentForm;", "id", "", "hive-analytics-consent-mode_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ConsentModeUiModelKt {
    /* JADX WARN: Removed duplicated region for block: B:16:0x008d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.hive.analytics.consentmode.ui.model.ConsentModeUiModel genConsentModeUiModel(com.hive.Analytics.ConsentMode r13) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.analytics.consentmode.ui.model.ConsentModeUiModelKt.genConsentModeUiModel(com.hive.Analytics$ConsentMode):com.hive.analytics.consentmode.ui.model.ConsentModeUiModel");
    }

    public static final void updateFromUiModel(Analytics.ConsentMode consentMode, ConsentModeUiModel uiModel) {
        Intrinsics.checkNotNullParameter(consentMode, "<this>");
        Intrinsics.checkNotNullParameter(uiModel, "uiModel");
        for (ConsentFormUiModel consentFormUiModel : uiModel.getFormList()) {
            if (consentFormUiModel instanceof ConsentFormUiModel.Item) {
                ConsentFormUiModel.Item item = (ConsentFormUiModel.Item) consentFormUiModel;
                Analytics.ConsentMode.ConsentForm consentFormFindConsentFormById = findConsentFormById(consentMode, item.getId());
                if (consentFormFindConsentFormById != null) {
                    consentFormFindConsentFormById.getConsentStatus().setGranted(item.getIsChecked());
                }
            } else {
                if (!(consentFormUiModel instanceof ConsentFormUiModel.Group)) {
                    throw new NoWhenBranchMatchedException();
                }
                ConsentFormUiModel.Group group = (ConsentFormUiModel.Group) consentFormUiModel;
                Analytics.ConsentMode.ConsentForm consentFormFindConsentFormById2 = findConsentFormById(consentMode, group.getId());
                if (consentFormFindConsentFormById2 != null) {
                    consentFormFindConsentFormById2.getConsentStatus().setGranted(group.getIsChecked());
                    for (ConsentFormUiModel.Item item2 : group.getSubItems()) {
                        List<Analytics.ConsentMode.ConsentForm> subForms = consentFormFindConsentFormById2.getSubForms();
                        Analytics.ConsentMode.ConsentForm consentForm = null;
                        Object obj = null;
                        if (subForms != null) {
                            Iterator<T> it = subForms.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Object next = it.next();
                                if (Intrinsics.areEqual(((Analytics.ConsentMode.ConsentForm) next).getId(), item2.getId())) {
                                    obj = next;
                                    break;
                                }
                            }
                            consentForm = (Analytics.ConsentMode.ConsentForm) obj;
                        }
                        if (consentForm != null) {
                            consentForm.getConsentStatus().setGranted(item2.getIsChecked());
                        }
                    }
                }
            }
        }
    }

    private static final Analytics.ConsentMode.ConsentForm findConsentFormById(Analytics.ConsentMode consentMode, String str) {
        List<Analytics.ConsentMode.ConsentForm> subForms;
        Analytics.ConsentMode.ConsentForm adUserData = consentMode.getAdUserData();
        Object obj = null;
        if (Intrinsics.areEqual(adUserData != null ? adUserData.getId() : null, str)) {
            return consentMode.getAdUserData();
        }
        Analytics.ConsentMode.ConsentForm adPersonalization = consentMode.getAdPersonalization();
        if (Intrinsics.areEqual(adPersonalization != null ? adPersonalization.getId() : null, str)) {
            return consentMode.getAdPersonalization();
        }
        Analytics.ConsentMode.ConsentForm analyticsStorage = consentMode.getAnalyticsStorage();
        if (Intrinsics.areEqual(analyticsStorage != null ? analyticsStorage.getId() : null, str)) {
            return consentMode.getAnalyticsStorage();
        }
        Analytics.ConsentMode.ConsentForm adPersonalization2 = consentMode.getAdPersonalization();
        if (adPersonalization2 == null || (subForms = adPersonalization2.getSubForms()) == null) {
            return null;
        }
        Iterator<T> it = subForms.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (Intrinsics.areEqual(((Analytics.ConsentMode.ConsentForm) next).getId(), str)) {
                obj = next;
                break;
            }
        }
        return (Analytics.ConsentMode.ConsentForm) obj;
    }
}
