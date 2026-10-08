package com.google.android.gms.internal.ads;

import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfqk extends WebViewClient {
    final /* synthetic */ zzfqm zza;

    zzfqk(zzfqm zzfqmVar) {
        Objects.requireNonNull(zzfqmVar);
        this.zza = zzfqmVar;
    }

    @Override // android.webkit.WebViewClient
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        String string = renderProcessGoneDetail.toString();
        String strValueOf = String.valueOf(webView);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 36 + String.valueOf(strValueOf).length());
        sb.append("WebView renderer gone: ");
        sb.append(string);
        sb.append("for WebView: ");
        sb.append(strValueOf);
        Log.w("NativeBridge", sb.toString());
        zzfqm zzfqmVar = this.zza;
        if (zzfqmVar.zzd() == webView) {
            Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
            zzfqmVar.zzc(null);
        }
        webView.destroy();
        return true;
    }
}
