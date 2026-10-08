package com.hive.analytics.provider.adjust;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustConfig;
import com.adjust.sdk.AdjustDeeplink;
import com.adjust.sdk.AdjustEvent;
import com.adjust.sdk.AdjustReferrerReceiver;
import com.adjust.sdk.AdjustThirdPartySharing;
import com.adjust.sdk.LogLevel;
import com.facebook.appevents.AppEventsConstants;
import com.hive.Analytics;
import com.hive.analytics.provider.AnalyticsProviderAdapter;
import com.hive.base.Property;
import com.hive.base.PropertyKeys;
import com.hive.core.Configuration;
import com.hive.core.HiveCoreInitializer;
import com.hive.core.HiveKeys;
import com.hive.core.configuration.HiveZoneType;
import com.hive.logger.LoggerImpl;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AnalyticsProviderAdjust.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u00019B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0019H\u0016J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010,\u001a\u00020\u001bH\u0014J\b\u0010-\u001a\u00020\u001bH\u0014J\u0012\u0010.\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0014J\u0010\u0010/\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010\u0019J\u001c\u00100\u001a\u00020\u001b2\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000502H\u0016J\u0010\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u0015H\u0016J\u0018\u00105\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012¨\u0006:"}, d2 = {"Lcom/hive/analytics/provider/adjust/AnalyticsProviderAdjust;", "Lcom/hive/analytics/provider/AnalyticsProviderAdapter;", "<init>", "()V", "KEY_key", "", "KEY_events", "KEY_event", "KEY_name", "KEY_value", "KEY", "getKEY", "()Ljava/lang/String;", "KEY$delegate", "Lkotlin/Lazy;", AnalyticsProviderAdjust.KEY_events, "Lorg/json/JSONArray;", "getEvents", "()Lorg/json/JSONArray;", "events$delegate", "init", "", "did", "analyticsId", "onCreateIntent", "Landroid/content/Intent;", "sendEvent", "", "eventName", "sendEventWithAttributes", "attributes", "Lorg/json/JSONObject;", "onReferrerReceive", "context", "Landroid/content/Context;", "intent", "sendRevenueEvent", "analyticsRevenue", "Lcom/hive/Analytics$AnalyticsRevenue;", "sendAdRevenueEvent", "analyticsAdRevenue", "Lcom/hive/Analytics$AnalyticsAdRevenue;", "setCustomUserId", "userId", "onResume", "onPause", "onNewIntent", "trackDeeplink", "setConsent", "settings", "", "setEnableTracker", "enable", "onChangeProperty", "key", "value", "setProviderEventData", "EventKeys", "hive-analytics-provider-adjust_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnalyticsProviderAdjust extends AnalyticsProviderAdapter {
    private static final String KEY_event = "event";
    private static final String KEY_events = "events";
    private static final String KEY_key = "@key";
    private static final String KEY_name = "@name";
    private static final String KEY_value = "@value";
    public static final AnalyticsProviderAdjust INSTANCE = new AnalyticsProviderAdjust();

    /* JADX INFO: renamed from: KEY$delegate, reason: from kotlin metadata */
    private static final Lazy KEY = LazyKt.lazy(new Function0() { // from class: com.hive.analytics.provider.adjust.AnalyticsProviderAdjust$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AnalyticsProviderAdjust.KEY_delegate$lambda$1();
        }
    });

    /* JADX INFO: renamed from: events$delegate, reason: from kotlin metadata */
    private static final Lazy events = LazyKt.lazy(new Function0() { // from class: com.hive.analytics.provider.adjust.AnalyticsProviderAdjust$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AnalyticsProviderAdjust.events_delegate$lambda$5();
        }
    });

    /* JADX INFO: compiled from: AnalyticsProviderAdjust.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HiveZoneType.values().length];
            try {
                iArr[HiveZoneType.REAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private AnalyticsProviderAdjust() {
        super(AnalyticsProviderAdapter.AnalyticsProviderType.ADJUST);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String KEY_delegate$lambda$1() {
        String adjustKey = Configuration.INSTANCE.getAdjustKey();
        if (!(!StringsKt.isBlank(adjustKey))) {
            adjustKey = null;
        }
        return adjustKey == null ? INSTANCE.getProviderJsonObject().optString(KEY_key, "") : adjustKey;
    }

    private final String getKEY() {
        Object value = KEY.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (String) value;
    }

    private final JSONArray getEvents() {
        return (JSONArray) events.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JSONArray events_delegate$lambda$5() {
        JSONArray jSONArray;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = INSTANCE.getProviderJsonObject().optJSONObject(KEY_events);
        if (jSONObjectOptJSONObject2 == null || (jSONArray = jSONObjectOptJSONObject2.optJSONArray("event")) == null) {
            jSONArray = new JSONArray();
            if (jSONObjectOptJSONObject2 != null && (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("event")) != null) {
                jSONArray.put(jSONObjectOptJSONObject);
            }
        }
        return jSONArray;
    }

    /* JADX INFO: compiled from: AnalyticsProviderAdjust.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/hive/analytics/provider/adjust/AnalyticsProviderAdjust$EventKeys;", "", "<init>", "()V", "price", "", "currency", "orderId", EventKeys.pid, "title", "serverId", "quantity", EventKeys.revenue, "hive-analytics-provider-adjust_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EventKeys {
        public static final EventKeys INSTANCE = new EventKeys();
        public static final String currency = "currency";
        public static final String orderId = "order_id";
        public static final String pid = "pid";
        public static final String price = "price";
        public static final String quantity = "quantity";
        public static final String revenue = "revenue";
        public static final String serverId = "server_id";
        public static final String title = "title";

        private EventKeys() {
        }
    }

    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public boolean init(String did, String analyticsId, Intent onCreateIntent) {
        setProviderEventData();
        if (StringsKt.isBlank(getKEY())) {
            Log.e("HIVE", "Adjust key empty ");
            return false;
        }
        Context initContext = HiveCoreInitializer.INSTANCE.getInitContext();
        AdjustConfig adjustConfig = new AdjustConfig(initContext, getKEY(), WhenMappings.$EnumSwitchMapping$0[Configuration.INSTANCE.getZone().ordinal()] == 1 ? AdjustConfig.ENVIRONMENT_PRODUCTION : AdjustConfig.ENVIRONMENT_SANDBOX, true);
        if (did != null) {
            Adjust.addGlobalCallbackParameter(HiveKeys.KEY_did.getValue(), did);
        }
        if (analyticsId != null) {
            Adjust.addGlobalCallbackParameter(HiveKeys.KEY_analyticsId.getValue(), analyticsId);
        }
        Adjust.addGlobalCallbackParameter(HiveKeys.KEY_serverId.getValue(), Configuration.INSTANCE.getServerId());
        Adjust.addGlobalCallbackParameter(HiveKeys.KEY_hiveCountry.getValue(), Configuration.INSTANCE.getHiveCountry());
        Adjust.addGlobalCallbackParameter(HiveKeys.KEY_appId.getValue(), Configuration.INSTANCE.getAppId());
        if (com.hive.Configuration.getUseLog()) {
            adjustConfig.setLogLevel(LogLevel.VERBOSE);
        }
        LoggerImpl.INSTANCE.d("[AnalyticsProviderAdjust] init did " + did + ", analyticsId : " + analyticsId + ", serverId : " + Configuration.INSTANCE.getServerId() + ", hiveCountry : " + Configuration.INSTANCE.getHiveCountry() + ", appId : " + Configuration.INSTANCE.getAppId());
        Adjust.enable();
        Adjust.initSdk(adjustConfig);
        Adjust.setPushToken(Property.INSTANCE.getINSTANCE().getValue(PropertyKeys.Push_REGID_FCM, ""), initContext);
        trackDeeplink(onCreateIntent);
        Adjust.onResume();
        return true;
    }

    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public void sendEvent(String eventName) {
        String str;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        if (getIsEnable() && (!getProviderEvent().isEmpty()) && (str = getProviderEvent().get(eventName)) != null) {
            LoggerImpl.INSTANCE.d("[AnalyticsProviderAdjust] sendEvent : " + eventName);
            Adjust.trackEvent(new AdjustEvent(str));
        }
    }

    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public void sendEventWithAttributes(String eventName, JSONObject attributes) {
        String str;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        if (getIsEnable() && (!getProviderEvent().isEmpty()) && (str = getProviderEvent().get(eventName)) != null) {
            AdjustEvent adjustEvent = new AdjustEvent(str);
            JSONObject jSONObjectOptJSONObject = attributes.optJSONObject("customAttributes");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        String next = itKeys.next();
                        adjustEvent.addCallbackParameter(next, jSONObjectOptJSONObject.get(next).toString());
                        Result.m7415constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        Result.m7415constructorimpl(ResultKt.createFailure(th));
                    }
                }
            }
            LoggerImpl.INSTANCE.d("[AnalyticsProviderAdjust] sendEventWithAttributes eventName : " + eventName + ", original attributes :  " + attributes + ", customAttributes : " + jSONObjectOptJSONObject);
            Adjust.trackEvent(adjustEvent);
        }
    }

    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public void onReferrerReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        new AdjustReferrerReceiver().onReceive(context, intent);
    }

    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public void sendRevenueEvent(String eventName, Analytics.AnalyticsRevenue analyticsRevenue) {
        String str;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(analyticsRevenue, "analyticsRevenue");
        if (!getIsEnable() || (str = getProviderEvent().get(eventName)) == null) {
            return;
        }
        AdjustEvent adjustEvent = new AdjustEvent(str);
        adjustEvent.setRevenue(analyticsRevenue.getPriceDouble(), analyticsRevenue.getCurrency());
        adjustEvent.setDeduplicationId(analyticsRevenue.getRefId());
        adjustEvent.addCallbackParameter("price", String.valueOf(analyticsRevenue.getPriceDouble()));
        adjustEvent.addCallbackParameter("currency", analyticsRevenue.getCurrency());
        adjustEvent.addCallbackParameter(EventKeys.orderId, analyticsRevenue.getRefId());
        adjustEvent.addCallbackParameter(EventKeys.pid, analyticsRevenue.getPid());
        adjustEvent.addCallbackParameter("title", analyticsRevenue.getTitle());
        adjustEvent.addCallbackParameter("server_id", Configuration.INSTANCE.getServerId());
        adjustEvent.addCallbackParameter("quantity", String.valueOf(analyticsRevenue.getItemCount()));
        adjustEvent.addCallbackParameter(EventKeys.revenue, String.valueOf(analyticsRevenue.getRevenue()));
        LoggerImpl.INSTANCE.d("[AnalyticsProviderAdjust] sendRevenueEvent event token : " + str);
        Adjust.trackEvent(adjustEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sendAdRevenueEvent(com.hive.Analytics.AnalyticsAdRevenue r8) {
        /*
            r7 = this;
            java.lang.String r0 = "analyticsAdRevenue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            boolean r0 = r7.getIsEnable()
            if (r0 == 0) goto Lb4
            double r0 = r8.getRevenue()
            java.lang.String r2 = r8.getAdPlatform()
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r2 = r2.toLowerCase(r3)
            java.lang.String r3 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            int r3 = r2.hashCode()
            switch(r3) {
                case 96437: goto L44;
                case 2989204: goto L38;
                case 3075962: goto L2f;
                case 92602838: goto L26;
                default: goto L25;
            }
        L25:
            goto L50
        L26:
            java.lang.String r3 = "ad(x)"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L4d
            goto L50
        L2f:
            java.lang.String r3 = "daro"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L41
            goto L50
        L38:
            java.lang.String r3 = "adiz"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L41
            goto L50
        L41:
            java.lang.String r2 = "admob_sdk"
            goto L54
        L44:
            java.lang.String r3 = "adx"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L4d
            goto L50
        L4d:
            java.lang.String r2 = "adx_sdk"
            goto L54
        L50:
            java.lang.String r2 = r8.getAdPlatform()
        L54:
            com.adjust.sdk.AdjustAdRevenue r3 = new com.adjust.sdk.AdjustAdRevenue
            r3.<init>(r2)
            java.lang.Double r4 = java.lang.Double.valueOf(r0)
            java.lang.String r5 = r8.getCurrency()
            r3.setRevenue(r4, r5)
            java.lang.String r4 = r8.getAdUnitId()
            r3.setAdRevenueUnit(r4)
            java.lang.String r4 = r8.getAdPlacement()
            r3.setAdRevenuePlacement(r4)
            com.hive.logger.LoggerImpl r4 = com.hive.logger.LoggerImpl.INSTANCE
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "[AnalyticsProviderAdjust] sendAdRevenueEvent adPlatform "
            r5.<init>(r6)
            r5.append(r2)
            java.lang.String r2 = ", adUnitId : "
            r5.append(r2)
            java.lang.String r2 = r8.getAdUnitId()
            r5.append(r2)
            java.lang.String r2 = ", adPlacement : "
            r5.append(r2)
            java.lang.String r2 = r8.getAdPlacement()
            r5.append(r2)
            java.lang.String r2 = ", revenue : "
            r5.append(r2)
            r5.append(r0)
            java.lang.String r0 = ", currency : "
            r5.append(r0)
            java.lang.String r8 = r8.getCurrency()
            r5.append(r8)
            java.lang.String r8 = r5.toString()
            r4.d(r8)
            com.adjust.sdk.Adjust.trackAdRevenue(r3)
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.analytics.provider.adjust.AnalyticsProviderAdjust.sendAdRevenueEvent(com.hive.Analytics$AnalyticsAdRevenue):void");
    }

    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public void setCustomUserId(String userId) {
        if (!TextUtils.isEmpty(userId)) {
            Adjust.addGlobalCallbackParameter("vid", userId);
        } else {
            Adjust.removeGlobalCallbackParameter("vid");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public void onResume() {
        if (getIsEnable()) {
            Adjust.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public void onPause() {
        if (getIsEnable()) {
            Adjust.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public void onNewIntent(Intent intent) {
        if (getIsEnable()) {
            trackDeeplink(intent);
        }
    }

    public final void trackDeeplink(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return;
        }
        Adjust.processDeeplink(new AdjustDeeplink(data), HiveCoreInitializer.INSTANCE.getInitContext());
    }

    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public void setConsent(Map<String, String> settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        boolean zAreEqual = Intrinsics.areEqual(settings.get(Analytics.CONSENT_TYPE_AD_USER_DATA), Analytics.CONSENT_GRANTED);
        boolean zAreEqual2 = Intrinsics.areEqual(settings.get(Analytics.CONSENT_TYPE_AD_PERSONALIZATION), Analytics.CONSENT_GRANTED);
        if (!zAreEqual && !zAreEqual2) {
            LoggerImpl.INSTANCE.d("[AnalyticsProviderAdjust] setConsent: trackThirdPartySharing false");
            Adjust.trackThirdPartySharing(new AdjustThirdPartySharing(false));
            return;
        }
        LoggerImpl.INSTANCE.d("[AnalyticsProviderAdjust] setConsent: adUserData(" + zAreEqual + "), adPersonalization(" + zAreEqual2 + ") ");
        AdjustThirdPartySharing adjustThirdPartySharing = new AdjustThirdPartySharing(true);
        adjustThirdPartySharing.addGranularOption("google_dma", Analytics.CONSENT_TYPE_AD_USER_DATA, zAreEqual ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        adjustThirdPartySharing.addGranularOption("google_dma", Analytics.CONSENT_TYPE_AD_PERSONALIZATION, zAreEqual ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Adjust.trackThirdPartySharing(adjustThirdPartySharing);
        Adjust.trackMeasurementConsent(zAreEqual2);
    }

    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public void setEnableTracker(boolean enable) {
        super.setEnableTracker(enable);
        if (enable) {
            Adjust.enable();
        } else {
            Adjust.disable();
        }
    }

    @Override // com.hive.analytics.provider.AnalyticsProviderAdapter
    public void onChangeProperty(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Adjust.addGlobalCallbackParameter(key, value);
    }

    private final void setProviderEventData() {
        int length = getEvents().length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = getEvents().optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                try {
                    String string = jSONObjectOptJSONObject.getString(KEY_name);
                    String string2 = jSONObjectOptJSONObject.getString(KEY_value);
                    Intrinsics.checkNotNull(string);
                    if (!StringsKt.isBlank(string)) {
                        Intrinsics.checkNotNull(string2);
                        if (!StringsKt.isBlank(string2)) {
                            INSTANCE.getProviderEvent().put(string, string2);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
