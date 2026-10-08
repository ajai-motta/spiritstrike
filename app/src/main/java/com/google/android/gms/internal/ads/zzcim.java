package com.google.android.gms.internal.ads;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzcim extends zzcil {
    public zzcim(zzcgy zzcgyVar, zzbdt zzbdtVar, boolean z, zzegj zzegjVar) {
        super(zzcgyVar, zzbdtVar, z, zzegjVar);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzaa(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
