package com.hive.ui.common.model;

import android.webkit.WebChromeClient;
import com.hive.core.OauthToken;
import com.hive.core.webview.SchemeHandler;
import kotlin.Metadata;

/* JADX INFO: compiled from: HiveViewData.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/hive/ui/common/model/HiveViewData;", "", "<init>", "()V", "url", "", "getUrl", "()Ljava/lang/String;", "postData", "getPostData", "token", "Lcom/hive/core/OauthToken;", "getToken", "()Lcom/hive/core/OauthToken;", "schemeHandler", "Lcom/hive/core/webview/SchemeHandler;", "getSchemeHandler", "()Lcom/hive/core/webview/SchemeHandler;", "chromeClient", "Landroid/webkit/WebChromeClient;", "getChromeClient", "()Landroid/webkit/WebChromeClient;", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class HiveViewData {
    public abstract WebChromeClient getChromeClient();

    public abstract String getPostData();

    public abstract SchemeHandler getSchemeHandler();

    public abstract OauthToken getToken();

    public abstract String getUrl();
}
