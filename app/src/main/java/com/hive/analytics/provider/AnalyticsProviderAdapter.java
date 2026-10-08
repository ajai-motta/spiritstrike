package com.hive.analytics.provider;

import android.content.Context;
import android.content.Intent;
import com.adjust.sdk.Constants;
import com.facebook.appevents.AppEventsConstants;
import com.hive.Analytics;
import com.hive.analytics.AnalyticsModule;
import com.hive.standalone.HiveLifecycle;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0014\b&\u0018\u0000 D2\u00020\u0001:\u0003BCDB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH&J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0010H&J\u0018\u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\tH&J\u0018\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001eH&J\u0018\u0010(\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*H&J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H&J(\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u0002002\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u000101H\u0016J\u0018\u00102\u001a\u00020 2\u0006\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0016J(\u00103\u001a\u00020 2\u0006\u0010/\u001a\u0002002\u0016\b\u0002\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u000101H\u0016J\b\u00104\u001a\u00020 H\u0016J\u0012\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u00107\u001a\u00020 2\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020\u0014H\u0016J\u0018\u0010;\u001a\u00020 2\u0006\u0010<\u001a\u00020\u00102\u0006\u0010=\u001a\u00020\u0010H\u0016J\b\u0010>\u001a\u00020 H\u0014J\b\u0010?\u001a\u00020 H\u0014J\u0012\u0010@\u001a\u00020 2\b\u0010'\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010A\u001a\u00020\tH\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0014X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017¨\u0006E"}, d2 = {"Lcom/hive/analytics/provider/AnalyticsProviderAdapter;", "", "providerType", "Lcom/hive/analytics/provider/AnalyticsProviderAdapter$AnalyticsProviderType;", "<init>", "(Lcom/hive/analytics/provider/AnalyticsProviderAdapter$AnalyticsProviderType;)V", "getProviderType", "()Lcom/hive/analytics/provider/AnalyticsProviderAdapter$AnalyticsProviderType;", "providerJsonObject", "Lorg/json/JSONObject;", "getProviderJsonObject", "()Lorg/json/JSONObject;", "providerJsonObject$delegate", "Lkotlin/Lazy;", "providerEvent", "", "", "getProviderEvent", "()Ljava/util/Map;", "isEnable", "", "()Z", "setEnable", "(Z)V", "isTrackUnder13", "setTrackUnder13", "init", "did", "analyticsId", "onCreateIntent", "Landroid/content/Intent;", "sendEvent", "", "eventName", "sendEventWithAttributes", "attributes", "onReferrerReceive", "context", "Landroid/content/Context;", "intent", "sendRevenueEvent", "analyticsRevenue", "Lcom/hive/Analytics$AnalyticsRevenue;", "sendAdRevenueEvent", "analyticsAdRevenue", "Lcom/hive/Analytics$AnalyticsAdRevenue;", "sendStandardEvent", "standardEventType", "Lcom/hive/analytics/provider/AnalyticsProviderAdapter$StandardEventType;", "", "sendStandardRevenueEvent", "sendAdStandardEvent", "trackUnder13", "setCustomUserId", "userId", "setConsent", "settings", "setEnableTracker", "enable", "onChangeProperty", "key", "value", "onResume", "onPause", "onNewIntent", "getProviderFromHiveConfig", "AnalyticsProviderType", "StandardEventType", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AnalyticsProviderAdapter {
    private static Intent createIntent;
    private boolean isEnable;
    private boolean isTrackUnder13;
    private final Map<String, String> providerEvent;

    /* JADX INFO: renamed from: providerJsonObject$delegate, reason: from kotlin metadata */
    private final Lazy providerJsonObject;
    private final AnalyticsProviderType providerType;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<AnalyticsProviderType, AnalyticsProviderAdapter> providerMap = new HashMap<>();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/hive/analytics/provider/AnalyticsProviderAdapter$AnalyticsProviderType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "ADJUST", "APPSFLYER", "SINGULAR", "FIREBASE", "AIRBRIDGE", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnalyticsProviderType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ AnalyticsProviderType[] $VALUES;
        private final String value;
        public static final AnalyticsProviderType ADJUST = new AnalyticsProviderType("ADJUST", 0, Constants.LOGTAG);
        public static final AnalyticsProviderType APPSFLYER = new AnalyticsProviderType("APPSFLYER", 1, "AppsFlyer");
        public static final AnalyticsProviderType SINGULAR = new AnalyticsProviderType("SINGULAR", 2, "Singular");
        public static final AnalyticsProviderType FIREBASE = new AnalyticsProviderType("FIREBASE", 3, "Firebase");
        public static final AnalyticsProviderType AIRBRIDGE = new AnalyticsProviderType("AIRBRIDGE", 4, "Airbridge");

        private static final /* synthetic */ AnalyticsProviderType[] $values() {
            return new AnalyticsProviderType[]{ADJUST, APPSFLYER, SINGULAR, FIREBASE, AIRBRIDGE};
        }

        static {
            AnalyticsProviderType[] analyticsProviderTypeArr$values = $values();
            $VALUES = analyticsProviderTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(analyticsProviderTypeArr$values);
        }

        private AnalyticsProviderType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<AnalyticsProviderType> getEntries() {
            return $ENTRIES;
        }

        public static AnalyticsProviderType valueOf(String str) {
            return (AnalyticsProviderType) Enum.valueOf(AnalyticsProviderType.class, str);
        }

        public static AnalyticsProviderType[] values() {
            return (AnalyticsProviderType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0006J\u001a\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0010J\u0016\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ&\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\b\u0002\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001fJ\u0016\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\nJ\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&J\u0016\u0010'\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u001aJ\u0006\u0010-\u001a\u00020\u000eJ\u0010\u0010.\u001a\u00020\u000e2\b\u0010/\u001a\u0004\u0018\u00010\u0010J\"\u00100\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00102\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u001002J\u0010\u00103\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\nJ\u0006\u00104\u001a\u00020\u000eJ\u0006\u00105\u001a\u00020\u000eJ\u0010\u00106\u001a\u00020\u000e2\b\u0010#\u001a\u0004\u0018\u00010\nJ\u0016\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\u0010J\u0010\u0010:\u001a\u00020\u00152\u0006\u0010;\u001a\u00020\u0010H\u0002R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/hive/analytics/provider/AnalyticsProviderAdapter$Companion;", "", "<init>", "()V", "providerMap", "Ljava/util/HashMap;", "Lcom/hive/analytics/provider/AnalyticsProviderAdapter$AnalyticsProviderType;", "Lcom/hive/analytics/provider/AnalyticsProviderAdapter;", "Lkotlin/collections/HashMap;", "createIntent", "Landroid/content/Intent;", com.unity3d.services.core.fid.Constants.GET_INSTANCE, "providerType", "initializeProviders", "", "did", "", "analyticsId", "setEnableProvider", "providerName", "isEnable", "", "sendEvents", "eventName", "sendEventWithAttributes", "attributes", "Lorg/json/JSONObject;", "sendStandardEvents", "standardEventType", "Lcom/hive/analytics/provider/AnalyticsProviderAdapter$StandardEventType;", "customAttribute", "", "onReferrerReceives", "context", "Landroid/content/Context;", "intent", "sendRevenueEvents", "analyticsRevenue", "Lcom/hive/Analytics$AnalyticsRevenue;", "sendStandardRevenueEvents", "sendAdRevenueEvents", "analyticsAdRevenue", "Lcom/hive/Analytics$AnalyticsAdRevenue;", "sendAdStandardEvents", HandleInvocationsFromAdViewer.KEY_AD_DATA, "setAgeGateUnder13", "setCustomUserId", "userId", "setConsent", "settings", "", "onCreate", "onResumed", "onPaused", "onNewIntent", "onChangeProperty", "key", "value", "findClassForName", "name", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean findClassForName(String name) {
            try {
                Class.forName(name);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void sendStandardEvents$default(Companion companion, StandardEventType standardEventType, Map map, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            companion.sendStandardEvents(standardEventType, map);
        }

        public final AnalyticsProviderAdapter getInstance(AnalyticsProviderType providerType) {
            Intrinsics.checkNotNullParameter(providerType, "providerType");
            AnalyticsModule provider$hive_service_release = AnalyticsModule.INSTANCE.getProvider$hive_service_release(providerType);
            if (provider$hive_service_release != null) {
                return provider$hive_service_release.getProviderModuleInstance();
            }
            return null;
        }

        public final void initializeProviders(String did, String analyticsId) {
            for (AnalyticsProviderType analyticsProviderType : AnalyticsProviderType.values()) {
                AnalyticsProviderAdapter companion = getInstance(analyticsProviderType);
                if (companion != null) {
                    companion.setEnable(companion.init(did, analyticsId, AnalyticsProviderAdapter.createIntent));
                }
            }
        }

        public final void onChangeProperty(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).onChangeProperty(key, value);
            }
        }

        public final void onCreate(Intent intent) {
            AnalyticsProviderAdapter.createIntent = intent;
        }

        public final void onNewIntent(Intent intent) {
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).onNewIntent(intent);
            }
        }

        public final void onPaused() {
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).onPause();
            }
        }

        public final void onReferrerReceives(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            for (AnalyticsProviderType analyticsProviderType : AnalyticsProviderType.values()) {
                AnalyticsProviderAdapter companion = getInstance(analyticsProviderType);
                if (companion != null) {
                    companion.onReferrerReceive(context, intent);
                }
            }
        }

        public final void onResumed() {
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).onResume();
            }
        }

        public final void sendAdRevenueEvents(Analytics.AnalyticsAdRevenue analyticsAdRevenue) {
            Intrinsics.checkNotNullParameter(analyticsAdRevenue, "analyticsAdRevenue");
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).sendAdRevenueEvent(analyticsAdRevenue);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void sendAdStandardEvents(org.json.JSONObject r5) {
            /*
                r4 = this;
                java.lang.String r0 = "adData"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                java.lang.String r0 = "eventType"
                java.lang.String r0 = r5.optString(r0)
                java.lang.String r1 = "optString(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                java.util.Locale r1 = java.util.Locale.ROOT
                java.lang.String r0 = r0.toLowerCase(r1)
                java.lang.String r1 = "toLowerCase(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                int r1 = r0.hashCode()
                r2 = -1148790971(0xffffffffbb86d745, float:-0.0041150176)
                if (r1 == r2) goto L44
                r2 = 94750088(0x5a5c588, float:1.5589087E-35)
                if (r1 == r2) goto L3b
                r2 = 450236012(0x1ad60e6c, float:8.8531625E-23)
                if (r1 == r2) goto L2f
                goto L4c
            L2f:
                java.lang.String r1 = "adimpression"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L38
                goto L4c
            L38:
                com.hive.analytics.provider.AnalyticsProviderAdapter$StandardEventType r0 = com.hive.analytics.provider.AnalyticsProviderAdapter.StandardEventType.AD_IMPRESSION
                goto L50
            L3b:
                java.lang.String r1 = "click"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L4c
                goto L4e
            L44:
                java.lang.String r1 = "adclick"
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L4e
            L4c:
                r0 = 0
                goto L50
            L4e:
                com.hive.analytics.provider.AnalyticsProviderAdapter$StandardEventType r0 = com.hive.analytics.provider.AnalyticsProviderAdapter.StandardEventType.AD_CLICK
            L50:
                if (r0 == 0) goto L7a
                com.hive.base.Android r1 = com.hive.base.Android.INSTANCE
                java.util.Map r5 = r1.jsonToMap(r5)
                java.util.HashMap r1 = com.hive.analytics.provider.AnalyticsProviderAdapter.access$getProviderMap$cp()
                java.util.Collection r1 = r1.values()
                java.util.Iterator r1 = r1.iterator()
            L64:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L79
                java.lang.Object r2 = r1.next()
                java.lang.String r3 = "next(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
                com.hive.analytics.provider.AnalyticsProviderAdapter r2 = (com.hive.analytics.provider.AnalyticsProviderAdapter) r2
                r2.sendAdStandardEvent(r0, r5)
                goto L64
            L79:
                return
            L7a:
                java.lang.String r5 = "Hive"
                java.lang.String r0 = "[AnalyticsProviderAdapter] sendAdStandardEvents event type is 'NONE'."
                android.util.Log.w(r5, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hive.analytics.provider.AnalyticsProviderAdapter.Companion.sendAdStandardEvents(org.json.JSONObject):void");
        }

        public final void sendEventWithAttributes(String eventName, JSONObject attributes) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).sendEventWithAttributes(eventName, attributes);
            }
        }

        public final void sendEvents(String eventName) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).sendEvent(eventName);
            }
        }

        public final void sendRevenueEvents(String eventName, Analytics.AnalyticsRevenue analyticsRevenue) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(analyticsRevenue, "analyticsRevenue");
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).sendRevenueEvent(eventName, analyticsRevenue);
            }
        }

        public final void sendStandardEvents(StandardEventType standardEventType, Map<String, ? extends Object> customAttribute) {
            Intrinsics.checkNotNullParameter(standardEventType, "standardEventType");
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).sendStandardEvent(standardEventType, customAttribute);
            }
        }

        public final void sendStandardRevenueEvents(StandardEventType standardEventType, Analytics.AnalyticsRevenue analyticsRevenue) {
            Intrinsics.checkNotNullParameter(standardEventType, "standardEventType");
            Intrinsics.checkNotNullParameter(analyticsRevenue, "analyticsRevenue");
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).sendStandardRevenueEvent(standardEventType, analyticsRevenue);
            }
        }

        public final void setAgeGateUnder13() {
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).trackUnder13();
            }
        }

        public final void setConsent(String providerName, Map<String, String> settings) {
            AnalyticsProviderType analyticsProviderType;
            AnalyticsProviderAdapter companion;
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            Intrinsics.checkNotNullParameter(settings, "settings");
            AnalyticsProviderType[] analyticsProviderTypeArrValues = AnalyticsProviderType.values();
            int length = analyticsProviderTypeArrValues.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    analyticsProviderType = null;
                    break;
                }
                analyticsProviderType = analyticsProviderTypeArrValues[i];
                String value = analyticsProviderType.getValue();
                Locale locale = Locale.ROOT;
                String lowerCase = value.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String lowerCase2 = providerName.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                    break;
                } else {
                    i++;
                }
            }
            if (analyticsProviderType == null || (companion = AnalyticsProviderAdapter.INSTANCE.getInstance(analyticsProviderType)) == null) {
                return;
            }
            companion.setConsent(settings);
        }

        public final void setCustomUserId(String userId) {
            for (Object obj : AnalyticsProviderAdapter.providerMap.values()) {
                Intrinsics.checkNotNullExpressionValue(obj, "next(...)");
                ((AnalyticsProviderAdapter) obj).setCustomUserId(userId);
            }
        }

        public final void setEnableProvider(String providerName, boolean isEnable) {
            AnalyticsProviderAdapter analyticsProviderAdapter;
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            for (AnalyticsProviderType analyticsProviderType : AnalyticsProviderType.values()) {
                if (StringsKt.equals(analyticsProviderType.getValue(), providerName, true) && (analyticsProviderAdapter = (AnalyticsProviderAdapter) AnalyticsProviderAdapter.providerMap.get(analyticsProviderType)) != null) {
                    analyticsProviderAdapter.setEnableTracker(isEnable);
                }
            }
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/hive/analytics/provider/AnalyticsProviderAdapter$StandardEventType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SIGN_IN", "SIGN_OUT", "PURCHASE_START", "PURCHASE_FINISH", "PURCHASE_CANCELED", "SUBSCRIBE", "AD_IMPRESSION", "AD_CLICK", "REVIEW", "SHARE", "NONE", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class StandardEventType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ StandardEventType[] $VALUES;
        private final String value;
        public static final StandardEventType SIGN_IN = new StandardEventType("SIGN_IN", 0, "SignIn");
        public static final StandardEventType SIGN_OUT = new StandardEventType("SIGN_OUT", 1, "SignOut");
        public static final StandardEventType PURCHASE_START = new StandardEventType("PURCHASE_START", 2, "PurchaseStart");
        public static final StandardEventType PURCHASE_FINISH = new StandardEventType("PURCHASE_FINISH", 3, "PurchaseFinish");
        public static final StandardEventType PURCHASE_CANCELED = new StandardEventType("PURCHASE_CANCELED", 4, "PurchaseCanceled");
        public static final StandardEventType SUBSCRIBE = new StandardEventType("SUBSCRIBE", 5, AppEventsConstants.EVENT_NAME_SUBSCRIBE);
        public static final StandardEventType AD_IMPRESSION = new StandardEventType("AD_IMPRESSION", 6, AppEventsConstants.EVENT_NAME_AD_IMPRESSION);
        public static final StandardEventType AD_CLICK = new StandardEventType("AD_CLICK", 7, AppEventsConstants.EVENT_NAME_AD_CLICK);
        public static final StandardEventType REVIEW = new StandardEventType("REVIEW", 8, "Review");
        public static final StandardEventType SHARE = new StandardEventType("SHARE", 9, "Share");
        public static final StandardEventType NONE = new StandardEventType("NONE", 10, "None");

        private static final /* synthetic */ StandardEventType[] $values() {
            return new StandardEventType[]{SIGN_IN, SIGN_OUT, PURCHASE_START, PURCHASE_FINISH, PURCHASE_CANCELED, SUBSCRIBE, AD_IMPRESSION, AD_CLICK, REVIEW, SHARE, NONE};
        }

        static {
            StandardEventType[] standardEventTypeArr$values = $values();
            $VALUES = standardEventTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(standardEventTypeArr$values);
        }

        private StandardEventType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<StandardEventType> getEntries() {
            return $ENTRIES;
        }

        public static StandardEventType valueOf(String str) {
            return (StandardEventType) Enum.valueOf(StandardEventType.class, str);
        }

        public static StandardEventType[] values() {
            return (StandardEventType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    public AnalyticsProviderAdapter(AnalyticsProviderType providerType) {
        Intrinsics.checkNotNullParameter(providerType, "providerType");
        this.providerType = providerType;
        this.providerJsonObject = LazyKt.lazy(new Function0() { // from class: com.hive.analytics.provider.AnalyticsProviderAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.getProviderFromHiveConfig();
            }
        });
        this.providerEvent = new LinkedHashMap();
        providerMap.put(providerType, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendAdStandardEvent$default(AnalyticsProviderAdapter analyticsProviderAdapter, StandardEventType standardEventType, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendAdStandardEvent");
        }
        if ((i & 2) != 0) {
            map = null;
        }
        analyticsProviderAdapter.sendAdStandardEvent(standardEventType, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendStandardEvent$default(AnalyticsProviderAdapter analyticsProviderAdapter, StandardEventType standardEventType, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendStandardEvent");
        }
        if ((i & 2) != 0) {
            map = null;
        }
        analyticsProviderAdapter.sendStandardEvent(standardEventType, map);
    }

    public final Map<String, String> getProviderEvent() {
        return this.providerEvent;
    }

    public JSONObject getProviderFromHiveConfig() {
        JSONObject hiveConfigProviders = HiveLifecycle.INSTANCE.getHiveConfigProviders();
        if (hiveConfigProviders != null) {
            try {
                Iterator<String> itKeys = hiveConfigProviders.keys();
                Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (StringsKt.equals(next, this.providerType.getValue(), true)) {
                        JSONObject jSONObject = hiveConfigProviders.getJSONObject(next);
                        Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                        return jSONObject;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return new JSONObject();
    }

    public final JSONObject getProviderJsonObject() {
        return (JSONObject) this.providerJsonObject.getValue();
    }

    public final AnalyticsProviderType getProviderType() {
        return this.providerType;
    }

    public abstract boolean init(String did, String analyticsId, Intent onCreateIntent);

    /* JADX INFO: renamed from: isEnable, reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    /* JADX INFO: renamed from: isTrackUnder13, reason: from getter */
    public final boolean getIsTrackUnder13() {
        return this.isTrackUnder13;
    }

    public void onChangeProperty(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    public void onNewIntent(Intent intent) {
    }

    public void onPause() {
    }

    public abstract void onReferrerReceive(Context context, Intent intent);

    public void onResume() {
    }

    public abstract void sendAdRevenueEvent(Analytics.AnalyticsAdRevenue analyticsAdRevenue);

    public void sendAdStandardEvent(StandardEventType standardEventType, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(standardEventType, "standardEventType");
    }

    public abstract void sendEvent(String eventName);

    public abstract void sendEventWithAttributes(String eventName, JSONObject attributes);

    public abstract void sendRevenueEvent(String eventName, Analytics.AnalyticsRevenue analyticsRevenue);

    public void sendStandardEvent(StandardEventType standardEventType, Map<String, ? extends Object> attributes) {
        Intrinsics.checkNotNullParameter(standardEventType, "standardEventType");
    }

    public void sendStandardRevenueEvent(StandardEventType standardEventType, Analytics.AnalyticsRevenue analyticsRevenue) {
        Intrinsics.checkNotNullParameter(standardEventType, "standardEventType");
        Intrinsics.checkNotNullParameter(analyticsRevenue, "analyticsRevenue");
    }

    public void setConsent(Map<String, String> settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
    }

    public void setCustomUserId(String userId) {
    }

    public final void setEnable(boolean z) {
        this.isEnable = z;
    }

    public void setEnableTracker(boolean enable) {
        this.isEnable = enable;
    }

    public final void setTrackUnder13(boolean z) {
        this.isTrackUnder13 = z;
    }

    public void trackUnder13() {
        this.isTrackUnder13 = true;
    }
}
