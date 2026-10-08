package com.hive.analytics.consentmode;

import android.app.Activity;
import androidx.preference.PreferenceManager;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.Analytics;
import com.hive.ResultAPI;
import com.hive.analytics.consentmode.serviceflow.ConsentModeServiceFlow;
import com.hive.core.Configuration;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.Product;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.ModuleCheckName;
import com.hive.module.interfaces.analytics.ConsentMode;
import com.hive.module.interfaces.analytics.ProviderAdjust;
import com.hive.module.interfaces.analytics.ProviderAirbridge;
import com.hive.module.interfaces.analytics.ProviderAppsFlyer;
import com.hive.module.interfaces.analytics.ProviderFirebase;
import com.hive.module.interfaces.analytics.ProviderSingular;
import com.hive.ui.Resource;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ConsentMode.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016H\u0016J\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u0011H\u0002J\u0010\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006%"}, d2 = {"Lcom/hive/analytics/consentmode/ConsentMode;", "Lcom/hive/module/interfaces/analytics/ConsentMode;", "<init>", "()V", "defaultPrivacyPolicyUrl", "", "getDefaultPrivacyPolicyUrl", "()Ljava/lang/String;", "setDefaultPrivacyPolicyUrl", "(Ljava/lang/String;)V", "showConsentModeIfRequire", "", "activity", "Landroid/app/Activity;", "checkCmp", "", "consentMode", "Lcom/hive/Analytics$ConsentMode;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Analytics$ConsentModeListener;", "showConsentMode", "getVersionInfo", "", "updateConsentStatus", "statusList", "", "Lcom/hive/Analytics$ConsentMode$ConsentStatus;", "shouldShowUI", "convertHtmlStyleString", "localCompanyName", "origin", "convertHtmlStyleConsentForm", "Lcom/hive/Analytics$ConsentMode$ConsentForm;", "consentForm", "convertHtmlStyleConsentMode", "resBasedConsentMode", "readCmpSettings", "hive-analytics-consent-mode_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConsentMode implements com.hive.module.interfaces.analytics.ConsentMode {
    public static final ConsentMode INSTANCE = new ConsentMode();
    private static String defaultPrivacyPolicyUrl = "";

    private ConsentMode() {
    }

    @Override // com.hive.module.interfaces.analytics.ConsentMode, com.hive.module.HiveModule
    public String getHiveModuleName() {
        return ConsentMode.DefaultImpls.getHiveModuleName(this);
    }

    @Override // com.hive.module.interfaces.analytics.ConsentMode
    public String getDefaultPrivacyPolicyUrl() {
        return defaultPrivacyPolicyUrl;
    }

    @Override // com.hive.module.interfaces.analytics.ConsentMode
    public void setDefaultPrivacyPolicyUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        defaultPrivacyPolicyUrl = str;
    }

    @Override // com.hive.module.interfaces.analytics.ConsentMode
    public void showConsentModeIfRequire(Activity activity, boolean checkCmp, Analytics.ConsentMode consentMode, final Analytics.ConsentModeListener listener) {
        Analytics.ConsentMode consentModeResBasedConsentMode;
        List<Analytics.ConsentMode.ConsentStatus> cmpSettings;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[ConsentMode] showConsentModeIfRequire");
        if (checkCmp && (cmpSettings = readCmpSettings()) != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(cmpSettings);
            listener.onConsentModeDismissed(new ResultAPI(), arrayList);
            return;
        }
        if (consentMode == null || (consentModeResBasedConsentMode = INSTANCE.convertHtmlStyleConsentMode(consentMode)) == null) {
            consentModeResBasedConsentMode = resBasedConsentMode();
        }
        LoggerImpl.INSTANCE.d("[ConsentMode] localConsentMode: \n" + consentModeResBasedConsentMode);
        List<Analytics.ConsentMode.ConsentStatus> listLoadConsentStatus$hive_analytics_consent_mode_release = ConsentModeProperty.INSTANCE.loadConsentStatus$hive_analytics_consent_mode_release();
        if (listLoadConsentStatus$hive_analytics_consent_mode_release != null) {
            updateConsentStatus(consentModeResBasedConsentMode, listLoadConsentStatus$hive_analytics_consent_mode_release);
        }
        if (shouldShowUI(consentModeResBasedConsentMode)) {
            LoggerImpl.INSTANCE.d("[ConsentMode] showConsentModeIfRequire Local Data: \n" + consentModeResBasedConsentMode);
            new ConsentModeServiceFlow(activity, consentModeResBasedConsentMode).show(true, new Analytics.ConsentModeListener() { // from class: com.hive.analytics.consentmode.ConsentMode.showConsentModeIfRequire.2
                @Override // com.hive.Analytics.ConsentModeListener
                public void onConsentModeDismissed(ResultAPI result, List<Analytics.ConsentMode.ConsentStatus> statusList) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    Intrinsics.checkNotNullParameter(statusList, "statusList");
                    StringBuilder sb = new StringBuilder("statusList: ");
                    Iterator<T> it = statusList.iterator();
                    while (it.hasNext()) {
                        sb.append("\n" + ((Analytics.ConsentMode.ConsentStatus) it.next()));
                    }
                    LoggerImpl.INSTANCE.d("[ConsentMode] showConsentModeIfRequire onConsentModeDismissed(" + result + "): \n" + ((Object) sb));
                    if (result.isSuccess()) {
                        ConsentModeProperty.INSTANCE.writeConsentStatus$hive_analytics_consent_mode_release(statusList);
                    }
                    listener.onConsentModeDismissed(result, statusList);
                }
            });
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Analytics.ConsentMode.ConsentForm adUserData = consentModeResBasedConsentMode.getAdUserData();
        if (adUserData != null) {
            arrayList2.add(adUserData.getConsentStatus());
        }
        Analytics.ConsentMode.ConsentForm adPersonalization = consentModeResBasedConsentMode.getAdPersonalization();
        if (adPersonalization != null) {
            arrayList2.add(adPersonalization.getConsentStatus());
            List<Analytics.ConsentMode.ConsentForm> subForms = adPersonalization.getSubForms();
            if (subForms != null) {
                Iterator<T> it = subForms.iterator();
                while (it.hasNext()) {
                    arrayList2.add(((Analytics.ConsentMode.ConsentForm) it.next()).getConsentStatus());
                }
            }
        }
        Analytics.ConsentMode.ConsentForm analyticsStorage = consentModeResBasedConsentMode.getAnalyticsStorage();
        if (analyticsStorage != null) {
            arrayList2.add(analyticsStorage.getConsentStatus());
        }
        listener.onConsentModeDismissed(new ResultAPI(), arrayList2);
    }

    @Override // com.hive.module.interfaces.analytics.ConsentMode
    public void showConsentMode(Activity activity, Analytics.ConsentMode consentMode, final Analytics.ConsentModeListener listener) {
        Analytics.ConsentMode consentModeResBasedConsentMode;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(listener, "listener");
        LoggerImpl.INSTANCE.d("[ConsentMode] showConsentMode");
        if (consentMode == null || (consentModeResBasedConsentMode = INSTANCE.convertHtmlStyleConsentMode(consentMode)) == null) {
            consentModeResBasedConsentMode = resBasedConsentMode();
        }
        LoggerImpl.INSTANCE.d("[ConsentMode] localConsentMode: \n" + consentModeResBasedConsentMode);
        List<Analytics.ConsentMode.ConsentStatus> listLoadConsentStatus$hive_analytics_consent_mode_release = ConsentModeProperty.INSTANCE.loadConsentStatus$hive_analytics_consent_mode_release();
        if (listLoadConsentStatus$hive_analytics_consent_mode_release != null) {
            updateConsentStatus(consentModeResBasedConsentMode, listLoadConsentStatus$hive_analytics_consent_mode_release);
        }
        LoggerImpl.INSTANCE.d("[ConsentMode] showConsentMode Local Data: \n" + consentModeResBasedConsentMode);
        new ConsentModeServiceFlow(activity, consentModeResBasedConsentMode).show(false, new Analytics.ConsentModeListener() { // from class: com.hive.analytics.consentmode.ConsentMode.showConsentMode.1
            @Override // com.hive.Analytics.ConsentModeListener
            public void onConsentModeDismissed(ResultAPI result, List<Analytics.ConsentMode.ConsentStatus> statusList) {
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(statusList, "statusList");
                StringBuilder sb = new StringBuilder("statusList: ");
                Iterator<T> it = statusList.iterator();
                while (it.hasNext()) {
                    sb.append("\n" + ((Analytics.ConsentMode.ConsentStatus) it.next()));
                }
                LoggerImpl.INSTANCE.d("[ConsentMode] showConsentMode onConsentModeDismissed(" + result + "): \n" + ((Object) sb));
                if (result.isSuccess()) {
                    ConsentModeProperty.INSTANCE.writeConsentStatus$hive_analytics_consent_mode_release(statusList);
                }
                listener.onConsentModeDismissed(result, statusList);
            }
        });
    }

    @Override // com.hive.module.HiveModule
    public Map<String, String> getVersionInfo() {
        HashMap map = new HashMap();
        map.put(ModuleCheckName.INSTANCE.getHive_Analytics_Consent_Mode(), "26.2.0");
        return map;
    }

    private final void updateConsentStatus(Analytics.ConsentMode consentMode, List<Analytics.ConsentMode.ConsentStatus> statusList) {
        Object next;
        Object next2;
        Object next3;
        Analytics.ConsentMode.ConsentForm adUserData = consentMode.getAdUserData();
        Object obj = null;
        if (adUserData != null) {
            Iterator<T> it = statusList.iterator();
            while (true) {
                if (it.hasNext()) {
                    next3 = it.next();
                    if (Intrinsics.areEqual(((Analytics.ConsentMode.ConsentStatus) next3).getId(), adUserData.getId())) {
                        break;
                    }
                } else {
                    next3 = null;
                    break;
                }
            }
            Analytics.ConsentMode.ConsentStatus consentStatus = (Analytics.ConsentMode.ConsentStatus) next3;
            if (consentStatus != null) {
                adUserData.setConsentStatus(consentStatus);
            }
        }
        Analytics.ConsentMode.ConsentForm adPersonalization = consentMode.getAdPersonalization();
        if (adPersonalization != null) {
            List<Analytics.ConsentMode.ConsentStatus> list = statusList;
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (it2.hasNext()) {
                    next = it2.next();
                    if (Intrinsics.areEqual(((Analytics.ConsentMode.ConsentStatus) next).getId(), adPersonalization.getId())) {
                        break;
                    }
                } else {
                    next = null;
                    break;
                }
            }
            Analytics.ConsentMode.ConsentStatus consentStatus2 = (Analytics.ConsentMode.ConsentStatus) next;
            if (consentStatus2 != null) {
                adPersonalization.setConsentStatus(consentStatus2);
            }
            List<Analytics.ConsentMode.ConsentForm> subForms = adPersonalization.getSubForms();
            if (subForms != null) {
                for (Analytics.ConsentMode.ConsentForm consentForm : subForms) {
                    Iterator<T> it3 = list.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            next2 = it3.next();
                            if (Intrinsics.areEqual(((Analytics.ConsentMode.ConsentStatus) next2).getId(), consentForm.getId())) {
                                break;
                            }
                        } else {
                            next2 = null;
                            break;
                        }
                    }
                    Analytics.ConsentMode.ConsentStatus consentStatus3 = (Analytics.ConsentMode.ConsentStatus) next2;
                    if (consentStatus3 != null) {
                        consentForm.setConsentStatus(consentStatus3);
                    }
                }
            }
        }
        Analytics.ConsentMode.ConsentForm analyticsStorage = consentMode.getAnalyticsStorage();
        if (analyticsStorage != null) {
            Iterator<T> it4 = statusList.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                Object next4 = it4.next();
                if (Intrinsics.areEqual(((Analytics.ConsentMode.ConsentStatus) next4).getId(), analyticsStorage.getId())) {
                    obj = next4;
                    break;
                }
            }
            Analytics.ConsentMode.ConsentStatus consentStatus4 = (Analytics.ConsentMode.ConsentStatus) obj;
            if (consentStatus4 != null) {
                analyticsStorage.setConsentStatus(consentStatus4);
            }
        }
    }

    private final boolean shouldShowUI(Analytics.ConsentMode consentMode) {
        List<Analytics.ConsentMode.ConsentForm> subForms;
        Analytics.ConsentMode.ConsentStatus consentStatus;
        Analytics.ConsentMode.ConsentStatus consentStatus2;
        Analytics.ConsentMode.ConsentStatus consentStatus3;
        Analytics.ConsentMode.ConsentForm adUserData = consentMode.getAdUserData();
        if (adUserData != null && (consentStatus3 = adUserData.getConsentStatus()) != null && consentStatus3.shouldShow()) {
            return true;
        }
        Analytics.ConsentMode.ConsentForm adPersonalization = consentMode.getAdPersonalization();
        if (adPersonalization != null && (consentStatus2 = adPersonalization.getConsentStatus()) != null && consentStatus2.shouldShow()) {
            return true;
        }
        Analytics.ConsentMode.ConsentForm analyticsStorage = consentMode.getAnalyticsStorage();
        if (analyticsStorage != null && (consentStatus = analyticsStorage.getConsentStatus()) != null && consentStatus.shouldShow()) {
            return true;
        }
        Analytics.ConsentMode.ConsentForm adPersonalization2 = consentMode.getAdPersonalization();
        if (adPersonalization2 != null && (subForms = adPersonalization2.getSubForms()) != null) {
            List<Analytics.ConsentMode.ConsentForm> list = subForms;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((Analytics.ConsentMode.ConsentForm) it.next()).getConsentStatus().shouldShow()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final String convertHtmlStyleString(String localCompanyName, String origin) {
        Regex regex = new Regex("\\((https?://[^)]+)\\)");
        List<String> lines = TextStreamsKt.readLines(new StringReader(origin));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(lines, 10));
        Iterator<T> it = lines.iterator();
        while (it.hasNext()) {
            arrayList.add(regex.replace((String) it.next(), new Function1() { // from class: com.hive.analytics.consentmode.ConsentMode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ConsentMode.convertHtmlStyleString$lambda$22$lambda$21((MatchResult) obj);
                }
            }));
        }
        return StringsKt.replace$default(CollectionsKt.joinToString$default(arrayList, "<br>", null, null, 0, null, null, 62, null), "[companyName]", localCompanyName, false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence convertHtmlStyleString$lambda$22$lambda$21(MatchResult match) {
        Intrinsics.checkNotNullParameter(match, "match");
        String str = match.getGroupValues().get(1);
        return "(<a href=\"" + str + "\">" + str + "</a>)";
    }

    private final Analytics.ConsentMode.ConsentForm convertHtmlStyleConsentForm(String localCompanyName, Analytics.ConsentMode.ConsentForm consentForm) {
        List<Analytics.ConsentMode.ConsentForm> mutableList;
        consentForm.setTitle(convertHtmlStyleString(localCompanyName, consentForm.getTitle()));
        consentForm.setContent(convertHtmlStyleString(localCompanyName, consentForm.getContent()));
        List<Analytics.ConsentMode.ConsentForm> subForms = consentForm.getSubForms();
        if (subForms != null) {
            List<Analytics.ConsentMode.ConsentForm> list = subForms;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.convertHtmlStyleConsentForm(localCompanyName, (Analytics.ConsentMode.ConsentForm) it.next()));
            }
            mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        } else {
            mutableList = null;
        }
        consentForm.setSubForms(mutableList);
        return consentForm;
    }

    private final Analytics.ConsentMode convertHtmlStyleConsentMode(Analytics.ConsentMode consentMode) {
        String companyName = consentMode.getCompanyName();
        Analytics.ConsentMode.Builder builder = new Analytics.ConsentMode.Builder();
        builder.setTitle(convertHtmlStyleString(companyName, consentMode.getTitle()));
        builder.setCompanyName(companyName);
        builder.setPrivacyPolicy(consentMode.getPrivacyPolicy());
        Analytics.ConsentMode.ConsentForm adUserData = consentMode.getAdUserData();
        if (adUserData != null) {
            builder.setAdUserData(INSTANCE.convertHtmlStyleConsentForm(companyName, adUserData));
        }
        Analytics.ConsentMode.ConsentForm adPersonalization = consentMode.getAdPersonalization();
        if (adPersonalization != null) {
            builder.setAdPersonalization(INSTANCE.convertHtmlStyleConsentForm(companyName, adPersonalization));
        }
        Analytics.ConsentMode.ConsentForm analyticsStorage = consentMode.getAnalyticsStorage();
        if (analyticsStorage != null) {
            builder.setAnalyticsStorage(INSTANCE.convertHtmlStyleConsentForm(companyName, analyticsStorage));
        }
        return builder.build();
    }

    private final Analytics.ConsentMode resBasedConsentMode() {
        String defaultPrivacyPolicyUrl2;
        String companyName = Configuration.INSTANCE.getCompanyName();
        if (!(!StringsKt.isBlank(companyName))) {
            companyName = null;
        }
        if (companyName == null) {
            int companyIndex = Configuration.INSTANCE.getCompanyIndex();
            if (companyIndex == 1) {
                companyName = "Com2uS";
            } else if (companyIndex == 2) {
                companyName = "Com2uS Holdings";
            } else {
                companyName = Product.INSTANCE.getApplicationName();
            }
        }
        Analytics.ConsentMode.Builder builder = new Analytics.ConsentMode.Builder();
        builder.setTitle(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_title"));
        builder.setCompanyName(companyName);
        int companyIndex2 = Configuration.INSTANCE.getCompanyIndex();
        if (companyIndex2 == 1) {
            defaultPrivacyPolicyUrl2 = "https://terms.withhive.com/terms/policy/view/M121/T75";
        } else if (companyIndex2 == 2) {
            defaultPrivacyPolicyUrl2 = "https://terms.withhive.com/terms/policy/view/M25/T74";
        } else {
            defaultPrivacyPolicyUrl2 = INSTANCE.getDefaultPrivacyPolicyUrl();
        }
        builder.setPrivacyPolicy(defaultPrivacyPolicyUrl2);
        Analytics.ConsentMode.ConsentForm consentForm = new Analytics.ConsentMode.ConsentForm(Analytics.CONSENT_TYPE_AD_USER_DATA);
        consentForm.setRetentionPeriod(14);
        consentForm.setTitle(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_ad_user_data_title"));
        consentForm.setContent(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_ad_user_data_content"));
        builder.setAdUserData(consentForm);
        Analytics.ConsentMode.ConsentForm consentForm2 = new Analytics.ConsentMode.ConsentForm(Analytics.CONSENT_TYPE_AD_PERSONALIZATION);
        consentForm2.setRetentionPeriod(14);
        consentForm2.setTitle(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_ad_personalization_title"));
        consentForm2.setContent(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_ad_personalization_content"));
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = ProviderFirebase.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof ProviderFirebase)) {
            hiveModule = null;
        }
        if (!(hiveModule instanceof ProviderFirebase)) {
            hiveModule = null;
        }
        if (((ProviderFirebase) hiveModule) != null) {
            if (consentForm2.getSubForms() == null) {
                consentForm2.setSubForms(new ArrayList());
            }
            List<Analytics.ConsentMode.ConsentForm> subForms = consentForm2.getSubForms();
            if (subForms != null) {
                Analytics.ConsentMode.ConsentForm consentForm3 = new Analytics.ConsentMode.ConsentForm("google");
                consentForm3.setRetentionPeriod(14);
                consentForm3.setTitle("Google Firebase");
                consentForm3.setContent(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_ad_personalization_content_google"));
                subForms.add(consentForm3);
            }
        }
        HiveModuleManager hiveModuleManager2 = HiveModuleManager.INSTANCE;
        String name2 = ProviderAppsFlyer.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        HiveModule hiveModule2 = hiveModuleManager2.getHiveModule(name2);
        if (!(hiveModule2 instanceof ProviderAppsFlyer)) {
            hiveModule2 = null;
        }
        if (!(hiveModule2 instanceof ProviderAppsFlyer)) {
            hiveModule2 = null;
        }
        if (((ProviderAppsFlyer) hiveModule2) != null) {
            if (consentForm2.getSubForms() == null) {
                consentForm2.setSubForms(new ArrayList());
            }
            List<Analytics.ConsentMode.ConsentForm> subForms2 = consentForm2.getSubForms();
            if (subForms2 != null) {
                Analytics.ConsentMode.ConsentForm consentForm4 = new Analytics.ConsentMode.ConsentForm("appsflyer");
                consentForm4.setRetentionPeriod(14);
                consentForm4.setTitle("Appsflyer");
                consentForm4.setContent(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_ad_personalization_content_appsflyer"));
                subForms2.add(consentForm4);
            }
        }
        HiveModuleManager hiveModuleManager3 = HiveModuleManager.INSTANCE;
        String name3 = ProviderAdjust.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
        HiveModule hiveModule3 = hiveModuleManager3.getHiveModule(name3);
        if (!(hiveModule3 instanceof ProviderAdjust)) {
            hiveModule3 = null;
        }
        if (!(hiveModule3 instanceof ProviderAdjust)) {
            hiveModule3 = null;
        }
        if (((ProviderAdjust) hiveModule3) != null) {
            if (consentForm2.getSubForms() == null) {
                consentForm2.setSubForms(new ArrayList());
            }
            List<Analytics.ConsentMode.ConsentForm> subForms3 = consentForm2.getSubForms();
            if (subForms3 != null) {
                Analytics.ConsentMode.ConsentForm consentForm5 = new Analytics.ConsentMode.ConsentForm("adjust");
                consentForm5.setRetentionPeriod(14);
                consentForm5.setTitle(Constants.LOGTAG);
                consentForm5.setContent(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_ad_personalization_content_adjust"));
                subForms3.add(consentForm5);
            }
        }
        HiveModuleManager hiveModuleManager4 = HiveModuleManager.INSTANCE;
        String name4 = ProviderSingular.class.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "getName(...)");
        HiveModule hiveModule4 = hiveModuleManager4.getHiveModule(name4);
        if (!(hiveModule4 instanceof ProviderSingular)) {
            hiveModule4 = null;
        }
        if (!(hiveModule4 instanceof ProviderSingular)) {
            hiveModule4 = null;
        }
        if (((ProviderSingular) hiveModule4) != null) {
            if (consentForm2.getSubForms() == null) {
                consentForm2.setSubForms(new ArrayList());
            }
            List<Analytics.ConsentMode.ConsentForm> subForms4 = consentForm2.getSubForms();
            if (subForms4 != null) {
                Analytics.ConsentMode.ConsentForm consentForm6 = new Analytics.ConsentMode.ConsentForm("singular");
                consentForm6.setRetentionPeriod(14);
                consentForm6.setTitle("Singular");
                consentForm6.setContent(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_ad_personalization_content_singular"));
                subForms4.add(consentForm6);
            }
        }
        HiveModuleManager hiveModuleManager5 = HiveModuleManager.INSTANCE;
        String name5 = ProviderAirbridge.class.getName();
        Intrinsics.checkNotNullExpressionValue(name5, "getName(...)");
        HiveModule hiveModule5 = hiveModuleManager5.getHiveModule(name5);
        if (!(hiveModule5 instanceof ProviderAirbridge)) {
            hiveModule5 = null;
        }
        if (!(hiveModule5 instanceof ProviderAirbridge)) {
            hiveModule5 = null;
        }
        if (((ProviderAirbridge) hiveModule5) != null) {
            if (consentForm2.getSubForms() == null) {
                consentForm2.setSubForms(new ArrayList());
            }
            List<Analytics.ConsentMode.ConsentForm> subForms5 = consentForm2.getSubForms();
            if (subForms5 != null) {
                Analytics.ConsentMode.ConsentForm consentForm7 = new Analytics.ConsentMode.ConsentForm("airbridge");
                consentForm7.setRetentionPeriod(14);
                consentForm7.setTitle("Airbridge");
                consentForm7.setContent(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_ad_personalization_content_airbridge"));
                subForms5.add(consentForm7);
            }
        }
        builder.setAdPersonalization(consentForm2);
        HiveModuleManager hiveModuleManager6 = HiveModuleManager.INSTANCE;
        String name6 = ProviderFirebase.class.getName();
        Intrinsics.checkNotNullExpressionValue(name6, "getName(...)");
        HiveModule hiveModule6 = hiveModuleManager6.getHiveModule(name6);
        if (!(hiveModule6 instanceof ProviderFirebase)) {
            hiveModule6 = null;
        }
        if (((ProviderFirebase) (hiveModule6 instanceof ProviderFirebase ? hiveModule6 : null)) != null) {
            Analytics.ConsentMode.ConsentForm consentForm8 = new Analytics.ConsentMode.ConsentForm(Analytics.CONSENT_TYPE_ANALYTICS_STORAGE);
            consentForm8.setRetentionPeriod(14);
            consentForm8.setTitle(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_analytics_storage_title"));
            consentForm8.setContent(resBasedConsentMode$getRes(companyName, "hive_consent_mode_text_analytics_storage_content"));
            builder.setAnalyticsStorage(consentForm8);
        }
        return builder.build();
    }

    private static final String resBasedConsentMode$getRes(String str, String str2) {
        String string = Resource.INSTANCE.getString(str2);
        if (string == null) {
            string = "";
        }
        return INSTANCE.convertHtmlStyleString(str, string);
    }

    private final List<Analytics.ConsentMode.ConsentStatus> readCmpSettings() {
        Object objM7415constructorimpl;
        Object objM7415constructorimpl2;
        String str;
        Map<String, ?> all = PreferenceManager.getDefaultSharedPreferences(HiveCoreInitializer.INSTANCE.getInitContext()).getAll();
        try {
            Result.Companion companion = Result.INSTANCE;
            Object obj = all.get("IABTCF_PurposeConsents");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            objM7415constructorimpl = Result.m7415constructorimpl((String) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
            objM7415constructorimpl = null;
        }
        String str2 = (String) objM7415constructorimpl;
        try {
            Result.Companion companion3 = Result.INSTANCE;
            Object obj2 = all.get("IABTCF_VendorConsents");
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            objM7415constructorimpl2 = Result.m7415constructorimpl((String) obj2);
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.INSTANCE;
            objM7415constructorimpl2 = Result.m7415constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m7421isFailureimpl(objM7415constructorimpl2)) {
            objM7415constructorimpl2 = null;
        }
        String str3 = (String) objM7415constructorimpl2;
        String str4 = str2;
        if (str4 == null || StringsKt.isBlank(str4) || (str = str3) == null || StringsKt.isBlank(str)) {
            LoggerImpl.INSTANCE.d("[ConsentMode] readCmpSettings: TCF data is null");
            return null;
        }
        LoggerImpl.INSTANCE.d("[ConsentMode] readCmpSettings: TCF data\n    purposeConsents(" + str2 + ")\n    vendorConsents(" + str3 + ')');
        Character orNull = StringsKt.getOrNull(str, 754);
        if (orNull == null || orNull.charValue() != '1') {
            LoggerImpl.INSTANCE.d("[ConsentMode] readCmpSettings: isIncludeGoogleVendor == false");
            return null;
        }
        boolean z = false;
        Character orNull2 = StringsKt.getOrNull(str4, 0);
        boolean z2 = orNull2 != null && orNull2.charValue() == '1';
        Character orNull3 = StringsKt.getOrNull(str4, 2);
        boolean z3 = orNull3 != null && orNull3.charValue() == '1';
        Character orNull4 = StringsKt.getOrNull(str4, 3);
        boolean z4 = orNull4 != null && orNull4.charValue() == '1';
        Character orNull5 = StringsKt.getOrNull(str4, 6);
        boolean z5 = orNull5 != null && orNull5.charValue() == '1';
        Character orNull6 = StringsKt.getOrNull(str4, 7);
        boolean z6 = orNull6 != null && orNull6.charValue() == '1';
        boolean z7 = z3 && z4;
        if (z5 && z6) {
            z = true;
        }
        ArrayList arrayList = new ArrayList();
        Analytics.ConsentMode.ConsentStatus consentStatus = new Analytics.ConsentMode.ConsentStatus(Analytics.CONSENT_TYPE_AD_USER_DATA);
        String str5 = Analytics.CONSENT_GRANTED;
        consentStatus.setGranted(z2 ? Analytics.CONSENT_GRANTED : Analytics.CONSENT_DENIED);
        consentStatus.consent(14);
        arrayList.add(consentStatus);
        Analytics.ConsentMode.ConsentStatus consentStatus2 = new Analytics.ConsentMode.ConsentStatus(Analytics.CONSENT_TYPE_AD_PERSONALIZATION);
        consentStatus2.setGranted(z7 ? Analytics.CONSENT_GRANTED : Analytics.CONSENT_DENIED);
        consentStatus2.consent(14);
        arrayList.add(consentStatus2);
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"google", "appsflyer", "adjust", "singular", "airbridge"}).iterator();
        while (it.hasNext()) {
            Analytics.ConsentMode.ConsentStatus consentStatus3 = new Analytics.ConsentMode.ConsentStatus((String) it.next());
            consentStatus3.setGranted(z7 ? Analytics.CONSENT_GRANTED : Analytics.CONSENT_DENIED);
            consentStatus3.consent(14);
            arrayList.add(consentStatus3);
        }
        Analytics.ConsentMode.ConsentStatus consentStatus4 = new Analytics.ConsentMode.ConsentStatus(Analytics.CONSENT_TYPE_ANALYTICS_STORAGE);
        if (!z) {
            str5 = Analytics.CONSENT_DENIED;
        }
        consentStatus4.setGranted(str5);
        consentStatus4.consent(14);
        arrayList.add(consentStatus4);
        LoggerImpl.INSTANCE.d("[ConsentMode] readCmpSettings: \n" + arrayList);
        return arrayList;
    }
}
