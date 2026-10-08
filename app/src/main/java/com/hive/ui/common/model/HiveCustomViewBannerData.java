package com.hive.ui.common.model;

import android.webkit.WebChromeClient;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.core.OauthToken;
import com.hive.core.webview.SchemeHandler;
import com.hive.ui.common.view.HiveCustomViewBanner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveCustomViewBannerData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\fHÆ\u0003JI\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/hive/ui/common/model/HiveCustomViewBannerData;", "Lcom/hive/ui/common/model/HiveViewData;", "appearance", "Lcom/hive/ui/common/view/HiveCustomViewBanner$ViewAppearance;", "url", "", "postData", "token", "Lcom/hive/core/OauthToken;", "schemeHandler", "Lcom/hive/core/webview/SchemeHandler;", "chromeClient", "Landroid/webkit/WebChromeClient;", "<init>", "(Lcom/hive/ui/common/view/HiveCustomViewBanner$ViewAppearance;Ljava/lang/String;Ljava/lang/String;Lcom/hive/core/OauthToken;Lcom/hive/core/webview/SchemeHandler;Landroid/webkit/WebChromeClient;)V", "getAppearance", "()Lcom/hive/ui/common/view/HiveCustomViewBanner$ViewAppearance;", "getUrl", "()Ljava/lang/String;", "getPostData", "getToken", "()Lcom/hive/core/OauthToken;", "getSchemeHandler", "()Lcom/hive/core/webview/SchemeHandler;", "getChromeClient", "()Landroid/webkit/WebChromeClient;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HiveCustomViewBannerData extends HiveViewData {
    private final HiveCustomViewBanner.ViewAppearance appearance;
    private final WebChromeClient chromeClient;
    private final String postData;
    private final SchemeHandler schemeHandler;
    private final OauthToken token;
    private final String url;

    public static /* synthetic */ HiveCustomViewBannerData copy$default(HiveCustomViewBannerData hiveCustomViewBannerData, HiveCustomViewBanner.ViewAppearance viewAppearance, String str, String str2, OauthToken oauthToken, SchemeHandler schemeHandler, WebChromeClient webChromeClient, int i, Object obj) {
        if ((i & 1) != 0) {
            viewAppearance = hiveCustomViewBannerData.appearance;
        }
        if ((i & 2) != 0) {
            str = hiveCustomViewBannerData.url;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            str2 = hiveCustomViewBannerData.postData;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            oauthToken = hiveCustomViewBannerData.token;
        }
        OauthToken oauthToken2 = oauthToken;
        if ((i & 16) != 0) {
            schemeHandler = hiveCustomViewBannerData.schemeHandler;
        }
        SchemeHandler schemeHandler2 = schemeHandler;
        if ((i & 32) != 0) {
            webChromeClient = hiveCustomViewBannerData.chromeClient;
        }
        return hiveCustomViewBannerData.copy(viewAppearance, str3, str4, oauthToken2, schemeHandler2, webChromeClient);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final HiveCustomViewBanner.ViewAppearance getAppearance() {
        return this.appearance;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPostData() {
        return this.postData;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final OauthToken getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final SchemeHandler getSchemeHandler() {
        return this.schemeHandler;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final WebChromeClient getChromeClient() {
        return this.chromeClient;
    }

    public final HiveCustomViewBannerData copy(HiveCustomViewBanner.ViewAppearance appearance, String url, String postData, OauthToken token, SchemeHandler schemeHandler, WebChromeClient chromeClient) {
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(schemeHandler, "schemeHandler");
        return new HiveCustomViewBannerData(appearance, url, postData, token, schemeHandler, chromeClient);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HiveCustomViewBannerData)) {
            return false;
        }
        HiveCustomViewBannerData hiveCustomViewBannerData = (HiveCustomViewBannerData) other;
        return Intrinsics.areEqual(this.appearance, hiveCustomViewBannerData.appearance) && Intrinsics.areEqual(this.url, hiveCustomViewBannerData.url) && Intrinsics.areEqual(this.postData, hiveCustomViewBannerData.postData) && Intrinsics.areEqual(this.token, hiveCustomViewBannerData.token) && Intrinsics.areEqual(this.schemeHandler, hiveCustomViewBannerData.schemeHandler) && Intrinsics.areEqual(this.chromeClient, hiveCustomViewBannerData.chromeClient);
    }

    public int hashCode() {
        int iHashCode = ((((this.appearance.hashCode() * 31) + this.url.hashCode()) * 31) + this.postData.hashCode()) * 31;
        OauthToken oauthToken = this.token;
        int iHashCode2 = (((iHashCode + (oauthToken == null ? 0 : oauthToken.hashCode())) * 31) + this.schemeHandler.hashCode()) * 31;
        WebChromeClient webChromeClient = this.chromeClient;
        return iHashCode2 + (webChromeClient != null ? webChromeClient.hashCode() : 0);
    }

    public String toString() {
        return "HiveCustomViewBannerData(appearance=" + this.appearance + ", url=" + this.url + ", postData=" + this.postData + ", token=" + this.token + ", schemeHandler=" + this.schemeHandler + ", chromeClient=" + this.chromeClient + ')';
    }

    public final HiveCustomViewBanner.ViewAppearance getAppearance() {
        return this.appearance;
    }

    @Override // com.hive.ui.common.model.HiveViewData
    public String getUrl() {
        return this.url;
    }

    @Override // com.hive.ui.common.model.HiveViewData
    public String getPostData() {
        return this.postData;
    }

    @Override // com.hive.ui.common.model.HiveViewData
    public OauthToken getToken() {
        return this.token;
    }

    @Override // com.hive.ui.common.model.HiveViewData
    public SchemeHandler getSchemeHandler() {
        return this.schemeHandler;
    }

    @Override // com.hive.ui.common.model.HiveViewData
    public WebChromeClient getChromeClient() {
        return this.chromeClient;
    }

    public HiveCustomViewBannerData(HiveCustomViewBanner.ViewAppearance appearance, String url, String postData, OauthToken oauthToken, SchemeHandler schemeHandler, WebChromeClient webChromeClient) {
        Intrinsics.checkNotNullParameter(appearance, "appearance");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(schemeHandler, "schemeHandler");
        this.appearance = appearance;
        this.url = url;
        this.postData = postData;
        this.token = oauthToken;
        this.schemeHandler = schemeHandler;
        this.chromeClient = webChromeClient;
    }
}
