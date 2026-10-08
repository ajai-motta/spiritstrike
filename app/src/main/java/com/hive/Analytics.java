package com.hive;

import androidx.compose.animation.core.ComplexDouble$$ExternalSyntheticBackport0;
import com.adjust.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.analytics.AnalyticsImpl;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.hive.analytics.provider.attributes.AnalyticsAttributes;
import com.hive.base.DataModel;
import com.hive.logger.LoggerImpl;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006;<=>?@B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0018H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0019H\u0007J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0016H\u0007J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0016H\u0007J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u0005H\u0007J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010$\u001a\u00020%H\u0007J\b\u0010&\u001a\u00020\u001bH\u0007J\u0010\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)H\u0007J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u0019H\u0007J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0005H\u0007J$\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u00052\u0012\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000502H\u0007J\u001c\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005022\u0006\u00100\u001a\u00020\u0005H\u0007J$\u00104\u001a\u00020\u001b2\b\b\u0002\u00105\u001a\u00020\u00162\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u000209H\u0007J\u001a\u0010:\u001a\u00020\u001b2\b\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u000209H\u0007R$\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/hive/Analytics;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "remainAnalyticsLogCount", "", "getRemainAnalyticsLogCount$annotations", "getRemainAnalyticsLogCount", "()I", "CONSENT_TYPE_AD_STORAGE", "CONSENT_TYPE_AD_USER_DATA", "CONSENT_TYPE_AD_PERSONALIZATION", "CONSENT_TYPE_ANALYTICS_STORAGE", "CONSENT_GRANTED", "CONSENT_DENIED", "sendAnalyticsLog", "", "logData", "", "Lorg/json/JSONObject;", "setEnableTracker", "", "trackingType", "Lcom/hive/Analytics$TrackingType;", "isEnable", "setEnableTrackerWithName", "name", "sendEvent", "event", "sendEventWithAttributes", "attributes", "Lcom/hive/analytics/provider/attributes/AnalyticsAttributes;", "sendTutorialComplete", "sendAdRevenueEvent", "analyticsAdRevenue", "Lcom/hive/Analytics$AnalyticsAdRevenue;", "sendAdStandardEvent", HandleInvocationsFromAdViewer.KEY_AD_DATA, "sendUserEntryFunnelsLogs", "funnelTrack", "optionTag", "setConsent", "providerName", "settings", "", "getConsent", "showConsentModeIfRequire", "checkCmp", "consentMode", "Lcom/hive/Analytics$ConsentMode;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/Analytics$ConsentModeListener;", "showConsentMode", "ConsentMode", "ConsentModeListener", "TrackingType", "Tracker", "AnalyticsRevenue", "AnalyticsAdRevenue", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Analytics {
    public static final String CONSENT_DENIED = "denied";
    public static final String CONSENT_GRANTED = "granted";
    public static final String CONSENT_TYPE_AD_PERSONALIZATION = "ad_personalization";
    public static final String CONSENT_TYPE_AD_STORAGE = "ad_storage";
    public static final String CONSENT_TYPE_AD_USER_DATA = "ad_user_data";
    public static final String CONSENT_TYPE_ANALYTICS_STORAGE = "analytics_storage";
    public static final Analytics INSTANCE = new Analytics();
    private static final String TAG = "Analytics";

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003JE\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006)"}, d2 = {"Lcom/hive/Analytics$AnalyticsAdRevenue;", "", AnalyticsProviderAdjust.EventKeys.revenue, "", "adPlatform", "", HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID, "adType", "adPlacement", "currency", "<init>", "(DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRevenue", "()D", "setRevenue", "(D)V", "getAdPlatform", "()Ljava/lang/String;", "setAdPlatform", "(Ljava/lang/String;)V", "getAdUnitId", "setAdUnitId", "getAdType", "setAdType", "getAdPlacement", "setAdPlacement", "getCurrency", "setCurrency", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class AnalyticsAdRevenue {
        private String adPlacement;
        private String adPlatform;
        private String adType;
        private String adUnitId;
        private String currency;
        private double revenue;

        public AnalyticsAdRevenue() {
            this(0.0d, null, null, null, null, null, 63, null);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final double getRevenue() {
            return this.revenue;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getAdPlatform() {
            return this.adPlatform;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAdUnitId() {
            return this.adUnitId;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAdType() {
            return this.adType;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getAdPlacement() {
            return this.adPlacement;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getCurrency() {
            return this.currency;
        }

        public final AnalyticsAdRevenue copy(double revenue, String adPlatform, String adUnitId, String adType, String adPlacement, String currency) {
            Intrinsics.checkNotNullParameter(adPlatform, "adPlatform");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(adType, "adType");
            Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
            Intrinsics.checkNotNullParameter(currency, "currency");
            return new AnalyticsAdRevenue(revenue, adPlatform, adUnitId, adType, adPlacement, currency);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnalyticsAdRevenue)) {
                return false;
            }
            AnalyticsAdRevenue analyticsAdRevenue = (AnalyticsAdRevenue) other;
            return Double.compare(this.revenue, analyticsAdRevenue.revenue) == 0 && Intrinsics.areEqual(this.adPlatform, analyticsAdRevenue.adPlatform) && Intrinsics.areEqual(this.adUnitId, analyticsAdRevenue.adUnitId) && Intrinsics.areEqual(this.adType, analyticsAdRevenue.adType) && Intrinsics.areEqual(this.adPlacement, analyticsAdRevenue.adPlacement) && Intrinsics.areEqual(this.currency, analyticsAdRevenue.currency);
        }

        public final String getAdPlacement() {
            return this.adPlacement;
        }

        public final String getAdPlatform() {
            return this.adPlatform;
        }

        public final String getAdType() {
            return this.adType;
        }

        public final String getAdUnitId() {
            return this.adUnitId;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final double getRevenue() {
            return this.revenue;
        }

        public int hashCode() {
            return (((((((((ComplexDouble$$ExternalSyntheticBackport0.m(this.revenue) * 31) + this.adPlatform.hashCode()) * 31) + this.adUnitId.hashCode()) * 31) + this.adType.hashCode()) * 31) + this.adPlacement.hashCode()) * 31) + this.currency.hashCode();
        }

        public final void setAdPlacement(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adPlacement = str;
        }

        public final void setAdPlatform(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adPlatform = str;
        }

        public final void setAdType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adType = str;
        }

        public final void setAdUnitId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.adUnitId = str;
        }

        public final void setCurrency(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.currency = str;
        }

        public final void setRevenue(double d) {
            this.revenue = d;
        }

        public String toString() {
            return "AnalyticsAdRevenue(revenue=" + this.revenue + ", adPlatform=" + this.adPlatform + ", adUnitId=" + this.adUnitId + ", adType=" + this.adType + ", adPlacement=" + this.adPlacement + ", currency=" + this.currency + ')';
        }

        public AnalyticsAdRevenue(double d, String adPlatform, String adUnitId, String adType, String adPlacement, String currency) {
            Intrinsics.checkNotNullParameter(adPlatform, "adPlatform");
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(adType, "adType");
            Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
            Intrinsics.checkNotNullParameter(currency, "currency");
            this.revenue = d;
            this.adPlatform = adPlatform;
            this.adUnitId = adUnitId;
            this.adType = adType;
            this.adPlacement = adPlacement;
            this.currency = currency;
        }

        public /* synthetic */ AnalyticsAdRevenue(double d, String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0.0d : d, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) == 0 ? str4 : "", (i & 32) != 0 ? "USD" : str5);
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 C2\u00020\u0001:\u0001CB{\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010+\u001a\u00020,H\u0002J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020.J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J}\u0010<\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@HÖ\u0003J\t\u0010A\u001a\u00020\fHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014¨\u0006D"}, d2 = {"Lcom/hive/Analytics$AnalyticsRevenue;", "Ljava/io/Serializable;", AnalyticsProviderAdjust.EventKeys.pid, "", "title", "description", "currency", "amountMicros", "", "formattedString", "price", "itemCount", "", "refId", "productType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getPid", "()Ljava/lang/String;", "setPid", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getDescription", "setDescription", "getCurrency", "setCurrency", "getAmountMicros", "()J", "setAmountMicros", "(J)V", "getFormattedString", "setFormattedString", "getPrice", "setPrice", "getItemCount", "()I", "setItemCount", "(I)V", "getRefId", "setRefId", "getProductType", InAppPurchaseConstants.METHOD_SET_PRODUCT_TYPE, "readObjectNoData", "", "getRevenue", "", "getPriceFloat", "", "getPriceDouble", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class AnalyticsRevenue implements Serializable {
        private static final long serialVersionUID = 4325983;
        private long amountMicros;
        private String currency;
        private String description;
        private String formattedString;
        private int itemCount;
        private String pid;
        private String price;
        private String productType;
        private String refId;
        private String title;

        public AnalyticsRevenue() {
            this(null, null, null, null, 0L, null, null, 0, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
        }

        private final void readObjectNoData() {
            this.amountMicros = 0L;
            this.itemCount = 1;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPid() {
            return this.pid;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final String getProductType() {
            return this.productType;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getDescription() {
            return this.description;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCurrency() {
            return this.currency;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final long getAmountMicros() {
            return this.amountMicros;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getFormattedString() {
            return this.formattedString;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final String getPrice() {
            return this.price;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final int getItemCount() {
            return this.itemCount;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final String getRefId() {
            return this.refId;
        }

        public final AnalyticsRevenue copy(String pid, String title, String description, String currency, long amountMicros, String formattedString, String price, int itemCount, String refId, String productType) {
            return new AnalyticsRevenue(pid, title, description, currency, amountMicros, formattedString, price, itemCount, refId, productType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnalyticsRevenue)) {
                return false;
            }
            AnalyticsRevenue analyticsRevenue = (AnalyticsRevenue) other;
            return Intrinsics.areEqual(this.pid, analyticsRevenue.pid) && Intrinsics.areEqual(this.title, analyticsRevenue.title) && Intrinsics.areEqual(this.description, analyticsRevenue.description) && Intrinsics.areEqual(this.currency, analyticsRevenue.currency) && this.amountMicros == analyticsRevenue.amountMicros && Intrinsics.areEqual(this.formattedString, analyticsRevenue.formattedString) && Intrinsics.areEqual(this.price, analyticsRevenue.price) && this.itemCount == analyticsRevenue.itemCount && Intrinsics.areEqual(this.refId, analyticsRevenue.refId) && Intrinsics.areEqual(this.productType, analyticsRevenue.productType);
        }

        public final long getAmountMicros() {
            return this.amountMicros;
        }

        public final String getCurrency() {
            return this.currency;
        }

        public final String getDescription() {
            return this.description;
        }

        public final String getFormattedString() {
            return this.formattedString;
        }

        public final int getItemCount() {
            return this.itemCount;
        }

        public final String getPid() {
            return this.pid;
        }

        public final String getPrice() {
            return this.price;
        }

        public final double getPriceDouble() {
            String str = this.price;
            if (str != null) {
                try {
                    return NumberFormat.getInstance().parse(this.price).doubleValue();
                } catch (Exception unused) {
                    Double dValueOf = Double.valueOf(new Regex("[^0-9.]").replace(str, ""));
                    Intrinsics.checkNotNullExpressionValue(dValueOf, "valueOf(...)");
                    return dValueOf.doubleValue();
                }
            }
            long j = this.amountMicros;
            if (j != 0) {
                return j / 1000000.0d;
            }
            String str2 = this.formattedString;
            if (str2 == null) {
                return 0.0d;
            }
            Double dValueOf2 = Double.valueOf(new Regex("[^0-9.]").replace(str2, ""));
            Intrinsics.checkNotNullExpressionValue(dValueOf2, "valueOf(...)");
            return dValueOf2.doubleValue();
        }

        public final float getPriceFloat() {
            String str = this.price;
            if (str != null) {
                try {
                    return NumberFormat.getInstance().parse(str).floatValue();
                } catch (Exception unused) {
                    Float fValueOf = Float.valueOf(new Regex("[^0-9.]").replace(str, ""));
                    Intrinsics.checkNotNullExpressionValue(fValueOf, "valueOf(...)");
                    return fValueOf.floatValue();
                }
            }
            long j = this.amountMicros;
            if (j != 0) {
                return j / 1000000.0f;
            }
            String str2 = this.formattedString;
            if (str2 == null) {
                return 0.0f;
            }
            Float fValueOf2 = Float.valueOf(new Regex("[^0-9.]").replace(str2, ""));
            Intrinsics.checkNotNullExpressionValue(fValueOf2, "valueOf(...)");
            return fValueOf2.floatValue();
        }

        public final String getProductType() {
            return this.productType;
        }

        public final String getRefId() {
            return this.refId;
        }

        public final double getRevenue() {
            return getPriceDouble() * ((double) this.itemCount);
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.pid;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            String str2 = this.title;
            int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.description;
            int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.currency;
            int iHashCode4 = (((iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + UByte$$ExternalSyntheticBackport0.m(this.amountMicros)) * 31;
            String str5 = this.formattedString;
            int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.price;
            int iHashCode6 = (((iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.itemCount) * 31;
            String str7 = this.refId;
            int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
            String str8 = this.productType;
            return iHashCode7 + (str8 != null ? str8.hashCode() : 0);
        }

        public final void setAmountMicros(long j) {
            this.amountMicros = j;
        }

        public final void setCurrency(String str) {
            this.currency = str;
        }

        public final void setDescription(String str) {
            this.description = str;
        }

        public final void setFormattedString(String str) {
            this.formattedString = str;
        }

        public final void setItemCount(int i) {
            this.itemCount = i;
        }

        public final void setPid(String str) {
            this.pid = str;
        }

        public final void setPrice(String str) {
            this.price = str;
        }

        public final void setProductType(String str) {
            this.productType = str;
        }

        public final void setRefId(String str) {
            this.refId = str;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public String toString() {
            return "AnalyticsRevenue(pid=" + this.pid + ", title=" + this.title + ", description=" + this.description + ", currency=" + this.currency + ", amountMicros=" + this.amountMicros + ", formattedString=" + this.formattedString + ", price=" + this.price + ", itemCount=" + this.itemCount + ", refId=" + this.refId + ", productType=" + this.productType + ')';
        }

        public AnalyticsRevenue(String str, String str2, String str3, String str4, long j, String str5, String str6, int i, String str7, String str8) {
            this.pid = str;
            this.title = str2;
            this.description = str3;
            this.currency = str4;
            this.amountMicros = j;
            this.formattedString = str5;
            this.price = str6;
            this.itemCount = i;
            this.refId = str7;
            this.productType = str8;
        }

        public /* synthetic */ AnalyticsRevenue(String str, String str2, String str3, String str4, long j, String str5, String str6, int i, String str7, String str8, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? 0L : j, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? 1 : i, (i2 & 256) != 0 ? null : str7, (i2 & 512) == 0 ? str8 : null);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0004\u0017\u0018\u0019\u001aB?\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/hive/Analytics$ConsentMode;", "", "title", "", "companyName", "privacyPolicy", "adUserData", "Lcom/hive/Analytics$ConsentMode$ConsentForm;", "adPersonalization", "analyticsStorage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/hive/Analytics$ConsentMode$ConsentForm;Lcom/hive/Analytics$ConsentMode$ConsentForm;Lcom/hive/Analytics$ConsentMode$ConsentForm;)V", "getTitle", "()Ljava/lang/String;", "getCompanyName", "getPrivacyPolicy", "getAdUserData", "()Lcom/hive/Analytics$ConsentMode$ConsentForm;", "getAdPersonalization", "getAnalyticsStorage", "toJson", "Lorg/json/JSONObject;", InAppPurchaseConstants.METHOD_TO_STRING, "ConsentStatus", "ConsentForm", "Builder", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ConsentMode {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ConsentForm adPersonalization;
        private final ConsentForm adUserData;
        private final ConsentForm analyticsStorage;
        private final String companyName;
        private final String privacyPolicy;
        private final String title;

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\tJ\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/hive/Analytics$ConsentMode$Builder;", "", "<init>", "()V", "title", "", "companyName", "privacyPolicy", "adUserData", "Lcom/hive/Analytics$ConsentMode$ConsentForm;", "adPersonalization", "analyticsStorage", "setTitle", "", "setCompanyName", "setPrivacyPolicy", "url", "setAdUserData", "form", "setAdPersonalization", "setAnalyticsStorage", InAppPurchaseConstants.METHOD_BUILD, "Lcom/hive/Analytics$ConsentMode;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Builder {
            private ConsentForm adPersonalization;
            private ConsentForm adUserData;
            private ConsentForm analyticsStorage;
            private String title = "";
            private String companyName = com.hive.core.Configuration.INSTANCE.getCompanyName();
            private String privacyPolicy = "";

            public final ConsentMode build() {
                return new ConsentMode(this.title, this.companyName, this.privacyPolicy, this.adUserData, this.adPersonalization, this.analyticsStorage, null);
            }

            public final void setAdPersonalization(ConsentForm form) {
                Intrinsics.checkNotNullParameter(form, "form");
                this.adPersonalization = form;
            }

            public final void setAdUserData(ConsentForm form) {
                Intrinsics.checkNotNullParameter(form, "form");
                this.adUserData = form;
            }

            public final void setAnalyticsStorage(ConsentForm form) {
                Intrinsics.checkNotNullParameter(form, "form");
                this.analyticsStorage = form;
            }

            public final void setCompanyName(String companyName) {
                Intrinsics.checkNotNullParameter(companyName, "companyName");
                this.companyName = companyName;
            }

            public final void setPrivacyPolicy(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                this.privacyPolicy = url;
            }

            public final void setTitle(String title) {
                Intrinsics.checkNotNullParameter(title, "title");
                this.title = title;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/Analytics$ConsentMode$Companion;", "", "<init>", "()V", "fromJson", "Lcom/hive/Analytics$ConsentMode;", "json", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ConsentMode fromJson(JSONObject json) {
                ConsentForm consentFormFromJson;
                ConsentForm consentFormFromJson2;
                ConsentForm consentFormFromJson3;
                if (json == null) {
                    return null;
                }
                Builder builder = new Builder();
                String strOptString = json.optString("title");
                Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                builder.setTitle(strOptString);
                String strOptString2 = json.optString("companyName");
                Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                builder.setCompanyName(strOptString2);
                String strOptString3 = json.optString("privacyPolicy");
                Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                builder.setPrivacyPolicy(strOptString3);
                JSONObject jSONObjectOptJSONObject = json.optJSONObject("adUserData");
                if (jSONObjectOptJSONObject != null && (consentFormFromJson3 = ConsentForm.INSTANCE.fromJson(jSONObjectOptJSONObject)) != null) {
                    builder.setAdUserData(consentFormFromJson3);
                }
                JSONObject jSONObjectOptJSONObject2 = json.optJSONObject("adPersonalization");
                if (jSONObjectOptJSONObject2 != null && (consentFormFromJson2 = ConsentForm.INSTANCE.fromJson(jSONObjectOptJSONObject2)) != null) {
                    builder.setAdPersonalization(consentFormFromJson2);
                }
                JSONObject jSONObjectOptJSONObject3 = json.optJSONObject("analyticsStorage");
                if (jSONObjectOptJSONObject3 != null && (consentFormFromJson = ConsentForm.INSTANCE.fromJson(jSONObjectOptJSONObject3)) != null) {
                    builder.setAnalyticsStorage(consentFormFromJson);
                }
                return builder.build();
            }

            private Companion() {
            }
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010!\u001a\u00020\u0003H\u0016J\u0006\u0010\"\u001a\u00020#R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\u0005R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\u0005R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/hive/Analytics$ConsentMode$ConsentForm;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "retentionPeriod", "", "getRetentionPeriod", "()I", "setRetentionPeriod", "(I)V", "title", "getTitle", "setTitle", "content", "getContent", "setContent", "consentStatus", "Lcom/hive/Analytics$ConsentMode$ConsentStatus;", "getConsentStatus", "()Lcom/hive/Analytics$ConsentMode$ConsentStatus;", "setConsentStatus", "(Lcom/hive/Analytics$ConsentMode$ConsentStatus;)V", "subForms", "", "getSubForms", "()Ljava/util/List;", "setSubForms", "(Ljava/util/List;)V", InAppPurchaseConstants.METHOD_TO_STRING, "toJson", "Lorg/json/JSONObject;", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ConsentForm {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private ConsentStatus consentStatus;
            private String content;
            private String id;
            private int retentionPeriod;
            private List<ConsentForm> subForms;
            private String title;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/Analytics$ConsentMode$ConsentForm$Companion;", "", "<init>", "()V", "fromJson", "Lcom/hive/Analytics$ConsentMode$ConsentForm;", "json", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final ConsentForm fromJson(JSONObject json) {
                    Object objM7415constructorimpl;
                    ConsentStatus consentStatus;
                    Intrinsics.checkNotNullParameter(json, "json");
                    String strOptString = json.optString("id");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    ConsentForm consentForm = new ConsentForm(strOptString);
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        consentForm.setRetentionPeriod(json.optInt("retentionPeriod", 0));
                        String strOptString2 = json.optString("title");
                        Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                        consentForm.setTitle(strOptString2);
                        String strOptString3 = json.optString("content");
                        Intrinsics.checkNotNullExpressionValue(strOptString3, "optString(...)");
                        consentForm.setContent(strOptString3);
                        String strOptString4 = json.optString("consentStatus");
                        if (StringsKt.isBlank(strOptString4)) {
                            consentStatus = new ConsentStatus(consentForm.getId());
                        } else {
                            try {
                                objM7415constructorimpl = Result.m7415constructorimpl(ConsentStatus.INSTANCE.fromJson(new JSONObject(strOptString4)));
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.INSTANCE;
                                objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
                            }
                            ConsentStatus consentStatus2 = new ConsentStatus(consentForm.getId());
                            if (Result.m7421isFailureimpl(objM7415constructorimpl)) {
                                objM7415constructorimpl = consentStatus2;
                            }
                            consentStatus = (ConsentStatus) objM7415constructorimpl;
                        }
                        consentForm.setConsentStatus(consentStatus);
                        JSONArray jSONArrayOptJSONArray = json.optJSONArray("subForms");
                        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                            ArrayList arrayList = new ArrayList();
                            int length = jSONArrayOptJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                try {
                                    Result.Companion companion3 = Result.INSTANCE;
                                    JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                                    Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                                    Result.m7415constructorimpl(Boolean.valueOf(arrayList.add(ConsentForm.INSTANCE.fromJson(jSONObject))));
                                } catch (Throwable th2) {
                                    Result.Companion companion4 = Result.INSTANCE;
                                    Result.m7415constructorimpl(ResultKt.createFailure(th2));
                                }
                            }
                            consentForm.setSubForms(arrayList);
                        }
                        Result.m7415constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th3) {
                        Result.Companion companion5 = Result.INSTANCE;
                        Result.m7415constructorimpl(ResultKt.createFailure(th3));
                    }
                    return consentForm;
                }

                private Companion() {
                }
            }

            public ConsentForm() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public final ConsentStatus getConsentStatus() {
                return this.consentStatus;
            }

            public final String getContent() {
                return this.content;
            }

            public final String getId() {
                return this.id;
            }

            public final int getRetentionPeriod() {
                return this.retentionPeriod;
            }

            public final List<ConsentForm> getSubForms() {
                return this.subForms;
            }

            public final String getTitle() {
                return this.title;
            }

            public final void setConsentStatus(ConsentStatus consentStatus) {
                Intrinsics.checkNotNullParameter(consentStatus, "<set-?>");
                this.consentStatus = consentStatus;
            }

            public final void setContent(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.content = str;
            }

            public final void setId(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.id = str;
            }

            public final void setRetentionPeriod(int i) {
                this.retentionPeriod = i;
            }

            public final void setSubForms(List<ConsentForm> list) {
                this.subForms = list;
            }

            public final void setTitle(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.title = str;
            }

            public final JSONObject toJson() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", this.id);
                jSONObject.put("retentionPeriod", this.retentionPeriod);
                jSONObject.put("title", this.title);
                jSONObject.put("content", this.content);
                jSONObject.put("consentStatus", this.consentStatus.toJson());
                List<ConsentForm> list = this.subForms;
                if (list != null) {
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((ConsentForm) it.next()).toJson());
                    }
                    jSONObject.put("subForms", new JSONArray((Collection) arrayList));
                }
                return jSONObject;
            }

            public String toString() {
                StringBuilder sb = new StringBuilder("ConsentForm[");
                sb.append(this.id);
                sb.append("] - retentionPeriod: ");
                sb.append(this.retentionPeriod);
                sb.append("\n    title: ");
                sb.append(this.title);
                sb.append("\n    content: ");
                sb.append(this.content);
                sb.append("\n    consentStatus: ");
                sb.append(this.consentStatus);
                sb.append("\n    subForms.size: ");
                List<ConsentForm> list = this.subForms;
                sb.append(list != null ? Integer.valueOf(list.size()) : null);
                sb.append('\n');
                return sb.toString();
            }

            public ConsentForm(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
                this.title = "";
                this.content = "";
                this.consentStatus = new ConsentStatus(this.id);
            }

            public /* synthetic */ ConsentForm(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str);
            }
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u000b\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u0003H\u0016J\u0006\u0010\u001e\u001a\u00020\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\u0005R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Lcom/hive/Analytics$ConsentMode$ConsentStatus;", "", "id", "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", Analytics.CONSENT_GRANTED, "getGranted", "setGranted", "consentDate", "", "getConsentDate", "()J", "setConsentDate", "(J)V", "expiredDate", "getExpiredDate", "setExpiredDate", "isGranted", "", "", "isExpired", "shouldShow", "consent", "retentionPeriod", "", InAppPurchaseConstants.METHOD_TO_STRING, "toJson", "Lorg/json/JSONObject;", k.M, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ConsentStatus {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private long consentDate;
            private long expiredDate;
            private String granted;
            private String id;

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/hive/Analytics$ConsentMode$ConsentStatus$Companion;", "", "<init>", "()V", "fromJson", "Lcom/hive/Analytics$ConsentMode$ConsentStatus;", "json", "Lorg/json/JSONObject;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final ConsentStatus fromJson(JSONObject json) {
                    Intrinsics.checkNotNullParameter(json, "json");
                    String strOptString = json.optString("id");
                    Intrinsics.checkNotNullExpressionValue(strOptString, "optString(...)");
                    ConsentStatus consentStatus = new ConsentStatus(strOptString);
                    String strOptString2 = json.optString(Analytics.CONSENT_GRANTED, Analytics.CONSENT_DENIED);
                    Intrinsics.checkNotNullExpressionValue(strOptString2, "optString(...)");
                    consentStatus.setGranted(strOptString2);
                    consentStatus.setConsentDate(json.optLong("consentDate", 0L));
                    consentStatus.setExpiredDate(json.optLong("expiredDate", 0L));
                    return consentStatus;
                }

                private Companion() {
                }
            }

            public ConsentStatus() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public final void consent(int retentionPeriod) {
                Calendar calendar = Calendar.getInstance();
                this.consentDate = calendar.getTimeInMillis();
                calendar.add(2, retentionPeriod);
                this.expiredDate = calendar.getTimeInMillis();
            }

            public final long getConsentDate() {
                return this.consentDate;
            }

            public final long getExpiredDate() {
                return this.expiredDate;
            }

            public final String getGranted() {
                return this.granted;
            }

            public final String getId() {
                return this.id;
            }

            public final boolean isExpired() {
                return Calendar.getInstance().getTimeInMillis() > this.expiredDate;
            }

            public final boolean isGranted() {
                return Intrinsics.areEqual(this.granted, Analytics.CONSENT_GRANTED);
            }

            public final void setConsentDate(long j) {
                this.consentDate = j;
            }

            public final void setExpiredDate(long j) {
                this.expiredDate = j;
            }

            public final void setGranted(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.granted = str;
            }

            public final void setId(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.id = str;
            }

            public final boolean shouldShow() {
                return this.expiredDate == 0 || isExpired();
            }

            public final JSONObject toJson() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", this.id);
                jSONObject.put(Analytics.CONSENT_GRANTED, this.granted);
                jSONObject.put("consentDate", this.consentDate);
                jSONObject.put("expiredDate", this.expiredDate);
                return jSONObject;
            }

            public String toString() {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.US);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(this.consentDate);
                String str = simpleDateFormat.format(calendar.getTime());
                calendar.setTimeInMillis(this.expiredDate);
                return "ConsentStatus[" + this.id + "]\n    granted(" + this.granted + ")\n    consentDate: " + str + "\n    expiredDate: " + simpleDateFormat.format(calendar.getTime()) + '\n';
            }

            public ConsentStatus(String id) {
                Intrinsics.checkNotNullParameter(id, "id");
                this.id = id;
                this.granted = Analytics.CONSENT_DENIED;
            }

            public final void setGranted(boolean isGranted) {
                this.granted = isGranted ? Analytics.CONSENT_GRANTED : Analytics.CONSENT_DENIED;
            }

            public /* synthetic */ ConsentStatus(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? "" : str);
            }
        }

        public /* synthetic */ ConsentMode(String str, String str2, String str3, ConsentForm consentForm, ConsentForm consentForm2, ConsentForm consentForm3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, consentForm, consentForm2, consentForm3);
        }

        public final ConsentForm getAdPersonalization() {
            return this.adPersonalization;
        }

        public final ConsentForm getAdUserData() {
            return this.adUserData;
        }

        public final ConsentForm getAnalyticsStorage() {
            return this.analyticsStorage;
        }

        public final String getCompanyName() {
            return this.companyName;
        }

        public final String getPrivacyPolicy() {
            return this.privacyPolicy;
        }

        public final String getTitle() {
            return this.title;
        }

        public final JSONObject toJson() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("title", this.title);
            jSONObject.put("companyName", this.companyName);
            jSONObject.put("privacyPolicy", this.privacyPolicy);
            ConsentForm consentForm = this.adUserData;
            if (consentForm != null) {
                jSONObject.put("adUserData", consentForm.toJson());
            }
            ConsentForm consentForm2 = this.adPersonalization;
            if (consentForm2 != null) {
                jSONObject.put("adPersonalization", consentForm2.toJson());
            }
            ConsentForm consentForm3 = this.analyticsStorage;
            if (consentForm3 != null) {
                jSONObject.put("analyticsStorage", consentForm3.toJson());
            }
            return jSONObject;
        }

        public String toString() {
            return StringsKt.trimIndent("\n                title = " + this.title + "\n                companyName = " + this.companyName + "\n                privacyPolicy = " + this.privacyPolicy + "\n                adUserData = [\n                    " + this.adUserData + "\n                ]\n                adPersonalization = [\n                    " + this.adPersonalization + "\n                ]\n                analyticsStorage = [\n                    " + this.analyticsStorage + "\n                ]\n            ");
        }

        private ConsentMode(String str, String str2, String str3, ConsentForm consentForm, ConsentForm consentForm2, ConsentForm consentForm3) {
            this.title = str;
            this.companyName = str2;
            this.privacyPolicy = str3;
            this.adUserData = consentForm;
            this.adPersonalization = consentForm2;
            this.analyticsStorage = consentForm3;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, d2 = {"Lcom/hive/Analytics$ConsentModeListener;", "", "onConsentModeDismissed", "", "result", "Lcom/hive/ResultAPI;", "statusList", "", "Lcom/hive/Analytics$ConsentMode$ConsentStatus;", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ConsentModeListener {
        void onConsentModeDismissed(ResultAPI result, List<ConsentMode.ConsentStatus> statusList);
    }

    @Deprecated(message = "4.14.0.0")
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R&\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/hive/Analytics$Tracker;", "Lcom/hive/base/DataModel;", "trackingType", "Lcom/hive/Analytics$TrackingType;", "name", "", "id", "key", "<init>", "(Lcom/hive/Analytics$TrackingType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTrackingType", "()Lcom/hive/Analytics$TrackingType;", "setTrackingType", "(Lcom/hive/Analytics$TrackingType;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getId", "setId", "getKey", "setKey", "trackerEvents", "", "getTrackerEvents", "()Ljava/util/Map;", "setTrackerEvents", "(Ljava/util/Map;)V", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Tracker extends DataModel {
        private String id;
        private String key;
        private String name;
        private Map<String, String> trackerEvents;
        private TrackingType trackingType;

        public Tracker(TrackingType trackingType, String name, String id, String key) {
            Intrinsics.checkNotNullParameter(trackingType, "trackingType");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(key, "key");
            this.trackerEvents = new HashMap();
            this.trackingType = trackingType;
            this.name = name;
            this.id = id;
            this.key = key;
        }

        public final String getId() {
            return this.id;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getName() {
            return this.name;
        }

        public final Map<String, String> getTrackerEvents() {
            return this.trackerEvents;
        }

        public final TrackingType getTrackingType() {
            return this.trackingType;
        }

        public final void setId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.id = str;
        }

        public final void setKey(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.key = str;
        }

        public final void setName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.name = str;
        }

        public final void setTrackerEvents(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.trackerEvents = map;
        }

        public final void setTrackingType(TrackingType trackingType) {
            Intrinsics.checkNotNullParameter(trackingType, "<set-?>");
            this.trackingType = trackingType;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/hive/Analytics$TrackingType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SINGULAR", "ADJUST", "APPSFLYER", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Deprecated(message = "4.14.0.0")
    public static final class TrackingType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TrackingType[] $VALUES;
        private final String value;
        public static final TrackingType SINGULAR = new TrackingType("SINGULAR", 0, "Singular");
        public static final TrackingType ADJUST = new TrackingType("ADJUST", 1, Constants.LOGTAG);
        public static final TrackingType APPSFLYER = new TrackingType("APPSFLYER", 2, "AppsFlyer");

        private static final /* synthetic */ TrackingType[] $values() {
            return new TrackingType[]{SINGULAR, ADJUST, APPSFLYER};
        }

        static {
            TrackingType[] trackingTypeArr$values = $values();
            $VALUES = trackingTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(trackingTypeArr$values);
        }

        private TrackingType(String str, int i, String str2) {
            this.value = str2;
        }

        public static EnumEntries<TrackingType> getEntries() {
            return $ENTRIES;
        }

        public static TrackingType valueOf(String str) {
            return (TrackingType) Enum.valueOf(TrackingType.class, str);
        }

        public static TrackingType[] values() {
            return (TrackingType[]) $VALUES.clone();
        }

        public final String getValue() {
            return this.value;
        }
    }

    private Analytics() {
    }

    @JvmStatic
    public static final Map<String, String> getConsent(String providerName) {
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        LoggerImpl loggerImpl = LoggerImpl.INSTANCE;
        String str = TAG;
        loggerImpl.apiCalledLog(str, "providerName: " + providerName);
        Map<String, String> consent = AnalyticsImpl.INSTANCE.getConsent(providerName);
        loggerImpl.apiReturnLog(str, consent.toString());
        return consent;
    }

    public static final int getRemainAnalyticsLogCount() {
        return AnalyticsImpl.INSTANCE.remainAnalyticsLogCount();
    }

    @JvmStatic
    public static /* synthetic */ void getRemainAnalyticsLogCount$annotations() {
    }

    public static final String getTAG() {
        return TAG;
    }

    @JvmStatic
    public static /* synthetic */ void getTAG$annotations() {
    }

    @JvmStatic
    public static final void sendAdRevenueEvent(AnalyticsAdRevenue analyticsAdRevenue) {
        Intrinsics.checkNotNullParameter(analyticsAdRevenue, "analyticsAdRevenue");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("analyticsAdRevenue = %s", Arrays.copyOf(new Object[]{analyticsAdRevenue.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl.INSTANCE.apiCalledLog(TAG, str);
        AnalyticsImpl.INSTANCE.sendAdRevenueEvent(analyticsAdRevenue);
    }

    @JvmStatic
    public static final void sendAdStandardEvent(JSONObject adData) {
        Intrinsics.checkNotNullParameter(adData, "adData");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("adData = %s", Arrays.copyOf(new Object[]{adData.toString()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl.INSTANCE.apiCalledLog(TAG, str);
        AnalyticsImpl.INSTANCE.sendAdStandardEvent(adData);
    }

    @JvmStatic
    public static final boolean sendAnalyticsLog(Map<String, ? extends Object> logData) {
        Intrinsics.checkNotNullParameter(logData, "logData");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(String.format("logData = %s", Arrays.copyOf(new Object[]{logData}, 1)), "format(...)");
        return AnalyticsImpl.INSTANCE.sendAnalyticsLog(logData);
    }

    @JvmStatic
    public static final void sendEvent(String event) {
        Intrinsics.checkNotNullParameter(event, "event");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("event = %s", Arrays.copyOf(new Object[]{event}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl.INSTANCE.apiCalledLog(TAG, str);
        AnalyticsImpl.INSTANCE.sendEvent(event);
    }

    @JvmStatic
    public static final void sendEventWithAttributes(String event, AnalyticsAttributes attributes) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("event = %s, attributes = %s", Arrays.copyOf(new Object[]{event, attributes}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl.INSTANCE.apiCalledLog(TAG, str);
        AnalyticsImpl.INSTANCE.sendEventWithAttributes(event, attributes.toJson());
    }

    @JvmStatic
    public static final void sendTutorialComplete() {
        sendEvent(AnalyticsImpl.AnalyticsDefineEvent.TUTORIAL_COMPLETE.getValue());
    }

    @JvmStatic
    public static final void sendUserEntryFunnelsLogs(String funnelTrack, String optionTag) {
        Intrinsics.checkNotNullParameter(funnelTrack, "funnelTrack");
        Intrinsics.checkNotNullParameter(optionTag, "optionTag");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("funnelTrack = %s", Arrays.copyOf(new Object[]{funnelTrack}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl.INSTANCE.apiCalledLog(TAG, str);
        AnalyticsImpl.INSTANCE.sendUserEntryFunnelsLogs(funnelTrack, optionTag);
    }

    @JvmStatic
    public static final void setConsent(String providerName, Map<String, String> settings) {
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        Intrinsics.checkNotNullParameter(settings, "settings");
        LoggerImpl.INSTANCE.apiCalledLog(TAG, "[" + providerName + "]: " + settings);
        AnalyticsImpl.INSTANCE.setConsent(providerName, settings);
    }

    @Deprecated(message = "Deprecated 4.14.0")
    @JvmStatic
    public static final void setEnableTracker(TrackingType trackingType, boolean isEnable) {
        Intrinsics.checkNotNullParameter(trackingType, "trackingType");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("trackingType = %s, isEnable = %b", Arrays.copyOf(new Object[]{trackingType.getValue(), Boolean.valueOf(isEnable)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl.INSTANCE.apiCalledLog(TAG, str);
        AnalyticsImpl.INSTANCE.setEnableProvider(trackingType.getValue(), isEnable);
    }

    @JvmStatic
    public static final void setEnableTrackerWithName(String name, boolean isEnable) {
        Intrinsics.checkNotNullParameter(name, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("name = %s, isEnable = %b", Arrays.copyOf(new Object[]{name, Boolean.valueOf(isEnable)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl.INSTANCE.apiCalledLog(TAG, str);
        AnalyticsImpl.INSTANCE.setEnableProvider(name, isEnable);
    }

    @JvmStatic
    public static final void showConsentMode(ConsentMode consentMode, ConsentModeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("consentMode = %s", Arrays.copyOf(new Object[]{consentMode}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl.INSTANCE.apiCalledLog(TAG, str);
        AnalyticsImpl.INSTANCE.showConsentMode(consentMode, listener);
    }

    @JvmStatic
    public static final void showConsentModeIfRequire(boolean checkCmp, ConsentMode consentMode, ConsentModeListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("consentMode = %s", Arrays.copyOf(new Object[]{consentMode}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        LoggerImpl.INSTANCE.apiCalledLog(TAG, str);
        AnalyticsImpl.INSTANCE.showConsentModeIfRequire(checkCmp, consentMode, listener);
    }

    public static /* synthetic */ void showConsentModeIfRequire$default(boolean z, ConsentMode consentMode, ConsentModeListener consentModeListener, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        showConsentModeIfRequire(z, consentMode, consentModeListener);
    }

    @JvmStatic
    public static final boolean sendAnalyticsLog(JSONObject logData) {
        Intrinsics.checkNotNullParameter(logData, "logData");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(String.format("logData = %s", Arrays.copyOf(new Object[]{logData}, 1)), "format(...)");
        return AnalyticsImpl.INSTANCE.sendAnalyticsLog(logData);
    }
}
