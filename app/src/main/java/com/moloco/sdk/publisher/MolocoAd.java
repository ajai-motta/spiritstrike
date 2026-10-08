package com.moloco.sdk.publisher;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J:\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÇ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001a\u001a\u00020\u001bH×\u0001J\t\u0010\u001c\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/moloco/sdk/publisher/MolocoAd;", "", "networkName", "", HandleInvocationsFromAdViewer.KEY_AD_UNIT_ID, AnalyticsProviderAdjust.EventKeys.revenue, "", "creativeId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)V", "getNetworkName", "()Ljava/lang/String;", "getAdUnitId", "getRevenue", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getCreativeId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;)Lcom/moloco/sdk/publisher/MolocoAd;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "moloco-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class MolocoAd {
    public static final int $stable = 0;
    private final String adUnitId;
    private final String creativeId;
    private final String networkName;
    private final Float revenue;

    public MolocoAd(String networkName, String adUnitId, Float f, String str) {
        Intrinsics.checkNotNullParameter(networkName, "networkName");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        this.networkName = networkName;
        this.adUnitId = adUnitId;
        this.revenue = f;
        this.creativeId = str;
    }

    public static /* synthetic */ MolocoAd copy$default(MolocoAd molocoAd, String str, String str2, Float f, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = molocoAd.networkName;
        }
        if ((i & 2) != 0) {
            str2 = molocoAd.adUnitId;
        }
        if ((i & 4) != 0) {
            f = molocoAd.revenue;
        }
        if ((i & 8) != 0) {
            str3 = molocoAd.creativeId;
        }
        return molocoAd.copy(str, str2, f, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNetworkName() {
        return this.networkName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAdUnitId() {
        return this.adUnitId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Float getRevenue() {
        return this.revenue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCreativeId() {
        return this.creativeId;
    }

    public final MolocoAd copy(String networkName, String adUnitId, Float revenue, String creativeId) {
        Intrinsics.checkNotNullParameter(networkName, "networkName");
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        return new MolocoAd(networkName, adUnitId, revenue, creativeId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MolocoAd)) {
            return false;
        }
        MolocoAd molocoAd = (MolocoAd) other;
        return Intrinsics.areEqual(this.networkName, molocoAd.networkName) && Intrinsics.areEqual(this.adUnitId, molocoAd.adUnitId) && Intrinsics.areEqual((Object) this.revenue, (Object) molocoAd.revenue) && Intrinsics.areEqual(this.creativeId, molocoAd.creativeId);
    }

    public final String getAdUnitId() {
        return this.adUnitId;
    }

    public final String getCreativeId() {
        return this.creativeId;
    }

    public final String getNetworkName() {
        return this.networkName;
    }

    public final Float getRevenue() {
        return this.revenue;
    }

    public int hashCode() {
        int iHashCode = ((this.networkName.hashCode() * 31) + this.adUnitId.hashCode()) * 31;
        Float f = this.revenue;
        int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
        String str = this.creativeId;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "MolocoAd(networkName=" + this.networkName + ", adUnitId=" + this.adUnitId + ", revenue=" + this.revenue + ", creativeId=" + this.creativeId + ')';
    }

    public /* synthetic */ MolocoAd(String str, String str2, Float f, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : f, (i & 8) != 0 ? null : str3);
    }
}
