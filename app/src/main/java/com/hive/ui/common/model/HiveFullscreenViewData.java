package com.hive.ui.common.model;

import android.webkit.WebChromeClient;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.hive.core.OauthToken;
import com.hive.core.webview.SchemeHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveFullscreenViewData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/hive/ui/common/model/HiveFullscreenViewData;", "Lcom/hive/ui/common/model/HiveViewData;", "url", "", "postData", "token", "Lcom/hive/core/OauthToken;", "schemeHandler", "Lcom/hive/core/webview/SchemeHandler;", "chromeClient", "Landroid/webkit/WebChromeClient;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/hive/core/OauthToken;Lcom/hive/core/webview/SchemeHandler;Landroid/webkit/WebChromeClient;)V", "getUrl", "()Ljava/lang/String;", "getPostData", "getToken", "()Lcom/hive/core/OauthToken;", "getSchemeHandler", "()Lcom/hive/core/webview/SchemeHandler;", "getChromeClient", "()Landroid/webkit/WebChromeClient;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class HiveFullscreenViewData extends HiveViewData {
    private final WebChromeClient chromeClient;
    private final String postData;
    private final SchemeHandler schemeHandler;
    private final OauthToken token;
    private final String url;

    public static /* synthetic */ HiveFullscreenViewData copy$default(HiveFullscreenViewData hiveFullscreenViewData, String str, String str2, OauthToken oauthToken, SchemeHandler schemeHandler, WebChromeClient webChromeClient, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hiveFullscreenViewData.url;
        }
        if ((i & 2) != 0) {
            str2 = hiveFullscreenViewData.postData;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            oauthToken = hiveFullscreenViewData.token;
        }
        OauthToken oauthToken2 = oauthToken;
        if ((i & 8) != 0) {
            schemeHandler = hiveFullscreenViewData.schemeHandler;
        }
        SchemeHandler schemeHandler2 = schemeHandler;
        if ((i & 16) != 0) {
            webChromeClient = hiveFullscreenViewData.chromeClient;
        }
        return hiveFullscreenViewData.copy(str, str3, oauthToken2, schemeHandler2, webChromeClient);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getPostData() {
        return this.postData;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final OauthToken getToken() {
        return this.token;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final SchemeHandler getSchemeHandler() {
        return this.schemeHandler;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final WebChromeClient getChromeClient() {
        return this.chromeClient;
    }

    public final HiveFullscreenViewData copy(String url, String postData, OauthToken token, SchemeHandler schemeHandler, WebChromeClient chromeClient) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(schemeHandler, "schemeHandler");
        return new HiveFullscreenViewData(url, postData, token, schemeHandler, chromeClient);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HiveFullscreenViewData)) {
            return false;
        }
        HiveFullscreenViewData hiveFullscreenViewData = (HiveFullscreenViewData) other;
        return Intrinsics.areEqual(this.url, hiveFullscreenViewData.url) && Intrinsics.areEqual(this.postData, hiveFullscreenViewData.postData) && Intrinsics.areEqual(this.token, hiveFullscreenViewData.token) && Intrinsics.areEqual(this.schemeHandler, hiveFullscreenViewData.schemeHandler) && Intrinsics.areEqual(this.chromeClient, hiveFullscreenViewData.chromeClient);
    }

    public int hashCode() {
        int iHashCode = ((this.url.hashCode() * 31) + this.postData.hashCode()) * 31;
        OauthToken oauthToken = this.token;
        int iHashCode2 = (((iHashCode + (oauthToken == null ? 0 : oauthToken.hashCode())) * 31) + this.schemeHandler.hashCode()) * 31;
        WebChromeClient webChromeClient = this.chromeClient;
        return iHashCode2 + (webChromeClient != null ? webChromeClient.hashCode() : 0);
    }

    public String toString() {
        return "HiveFullscreenViewData(url=" + this.url + ", postData=" + this.postData + ", token=" + this.token + ", schemeHandler=" + this.schemeHandler + ", chromeClient=" + this.chromeClient + ')';
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

    public HiveFullscreenViewData(String url, String postData, OauthToken oauthToken, SchemeHandler schemeHandler, WebChromeClient webChromeClient) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(postData, "postData");
        Intrinsics.checkNotNullParameter(schemeHandler, "schemeHandler");
        this.url = url;
        this.postData = postData;
        this.token = oauthToken;
        this.schemeHandler = schemeHandler;
        this.chromeClient = webChromeClient;
    }
}
