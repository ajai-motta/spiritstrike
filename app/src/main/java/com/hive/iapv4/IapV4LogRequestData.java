package com.hive.iapv4;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.Analytics;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IapV4LogRequestData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/hive/iapv4/IapV4LogRequestData;", "Ljava/io/Serializable;", "url", "", "originalJson", "analyticsRevenue", "Lcom/hive/Analytics$AnalyticsRevenue;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/hive/Analytics$AnalyticsRevenue;)V", "getUrl", "()Ljava/lang/String;", InAppPurchaseConstants.METHOD_GET_ORIGINAL_JSON, "getAnalyticsRevenue", "()Lcom/hive/Analytics$AnalyticsRevenue;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-iapv4-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class IapV4LogRequestData implements Serializable {
    private final Analytics.AnalyticsRevenue analyticsRevenue;
    private final String originalJson;
    private final String url;

    public static /* synthetic */ IapV4LogRequestData copy$default(IapV4LogRequestData iapV4LogRequestData, String str, String str2, Analytics.AnalyticsRevenue analyticsRevenue, int i, Object obj) {
        if ((i & 1) != 0) {
            str = iapV4LogRequestData.url;
        }
        if ((i & 2) != 0) {
            str2 = iapV4LogRequestData.originalJson;
        }
        if ((i & 4) != 0) {
            analyticsRevenue = iapV4LogRequestData.analyticsRevenue;
        }
        return iapV4LogRequestData.copy(str, str2, analyticsRevenue);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOriginalJson() {
        return this.originalJson;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Analytics.AnalyticsRevenue getAnalyticsRevenue() {
        return this.analyticsRevenue;
    }

    public final IapV4LogRequestData copy(String url, String originalJson, Analytics.AnalyticsRevenue analyticsRevenue) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(originalJson, "originalJson");
        return new IapV4LogRequestData(url, originalJson, analyticsRevenue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IapV4LogRequestData)) {
            return false;
        }
        IapV4LogRequestData iapV4LogRequestData = (IapV4LogRequestData) other;
        return Intrinsics.areEqual(this.url, iapV4LogRequestData.url) && Intrinsics.areEqual(this.originalJson, iapV4LogRequestData.originalJson) && Intrinsics.areEqual(this.analyticsRevenue, iapV4LogRequestData.analyticsRevenue);
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + this.originalJson.hashCode()) * 31;
        Analytics.AnalyticsRevenue analyticsRevenue = this.analyticsRevenue;
        return iHashCode + (analyticsRevenue == null ? 0 : analyticsRevenue.hashCode());
    }

    public String toString() {
        return "IapV4LogRequestData(url=" + this.url + ", originalJson=" + this.originalJson + ", analyticsRevenue=" + this.analyticsRevenue + ')';
    }

    public IapV4LogRequestData(String url, String originalJson, Analytics.AnalyticsRevenue analyticsRevenue) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(originalJson, "originalJson");
        this.url = url;
        this.originalJson = originalJson;
        this.analyticsRevenue = analyticsRevenue;
    }

    public final Analytics.AnalyticsRevenue getAnalyticsRevenue() {
        return this.analyticsRevenue;
    }

    public final String getOriginalJson() {
        return this.originalJson;
    }

    public final String getUrl() {
        return this.url;
    }
}
