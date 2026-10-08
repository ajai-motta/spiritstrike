package com.hive.platformhelper;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016JF\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018¨\u0006("}, d2 = {"Lcom/hive/platformhelper/InAppBrowserData;", "", "url", "", "autoRedirectToExternalBrowser", "", "navigationColor", "urlBarHiding", "shareState", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "getAutoRedirectToExternalBrowser", "()Z", "setAutoRedirectToExternalBrowser", "(Z)V", "getNavigationColor", "setNavigationColor", "getUrlBarHiding", "()Ljava/lang/Boolean;", "setUrlBarHiding", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getShareState", "setShareState", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/hive/platformhelper/InAppBrowserData;", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class InAppBrowserData {
    private boolean autoRedirectToExternalBrowser;
    private String navigationColor;
    private Boolean shareState;
    private String url;
    private Boolean urlBarHiding;

    public InAppBrowserData(String url, boolean z, String str, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.autoRedirectToExternalBrowser = z;
        this.navigationColor = str;
        this.urlBarHiding = bool;
        this.shareState = bool2;
    }

    public static /* synthetic */ InAppBrowserData copy$default(InAppBrowserData inAppBrowserData, String str, boolean z, String str2, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inAppBrowserData.url;
        }
        if ((i & 2) != 0) {
            z = inAppBrowserData.autoRedirectToExternalBrowser;
        }
        boolean z2 = z;
        if ((i & 4) != 0) {
            str2 = inAppBrowserData.navigationColor;
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            bool = inAppBrowserData.urlBarHiding;
        }
        Boolean bool3 = bool;
        if ((i & 16) != 0) {
            bool2 = inAppBrowserData.shareState;
        }
        return inAppBrowserData.copy(str, z2, str3, bool3, bool2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getAutoRedirectToExternalBrowser() {
        return this.autoRedirectToExternalBrowser;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getNavigationColor() {
        return this.navigationColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Boolean getUrlBarHiding() {
        return this.urlBarHiding;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Boolean getShareState() {
        return this.shareState;
    }

    public final InAppBrowserData copy(String url, boolean autoRedirectToExternalBrowser, String navigationColor, Boolean urlBarHiding, Boolean shareState) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new InAppBrowserData(url, autoRedirectToExternalBrowser, navigationColor, urlBarHiding, shareState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InAppBrowserData)) {
            return false;
        }
        InAppBrowserData inAppBrowserData = (InAppBrowserData) other;
        return Intrinsics.areEqual(this.url, inAppBrowserData.url) && this.autoRedirectToExternalBrowser == inAppBrowserData.autoRedirectToExternalBrowser && Intrinsics.areEqual(this.navigationColor, inAppBrowserData.navigationColor) && Intrinsics.areEqual(this.urlBarHiding, inAppBrowserData.urlBarHiding) && Intrinsics.areEqual(this.shareState, inAppBrowserData.shareState);
    }

    public final boolean getAutoRedirectToExternalBrowser() {
        return this.autoRedirectToExternalBrowser;
    }

    public final String getNavigationColor() {
        return this.navigationColor;
    }

    public final Boolean getShareState() {
        return this.shareState;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Boolean getUrlBarHiding() {
        return this.urlBarHiding;
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.autoRedirectToExternalBrowser)) * 31;
        String str = this.navigationColor;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.urlBarHiding;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.shareState;
        return iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final void setAutoRedirectToExternalBrowser(boolean z) {
        this.autoRedirectToExternalBrowser = z;
    }

    public final void setNavigationColor(String str) {
        this.navigationColor = str;
    }

    public final void setShareState(Boolean bool) {
        this.shareState = bool;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final void setUrlBarHiding(Boolean bool) {
        this.urlBarHiding = bool;
    }

    public String toString() {
        return "InAppBrowserData(url=" + this.url + ", autoRedirectToExternalBrowser=" + this.autoRedirectToExternalBrowser + ", navigationColor=" + this.navigationColor + ", urlBarHiding=" + this.urlBarHiding + ", shareState=" + this.shareState + ')';
    }

    public /* synthetic */ InAppBrowserData(String str, boolean z, String str2, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : bool2);
    }
}
