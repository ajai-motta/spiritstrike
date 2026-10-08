package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbbs implements Runnable {
    final ValueCallback zza;
    final /* synthetic */ zzbbk zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzbbu zze;

    zzbbs(zzbbu zzbbuVar, final zzbbk zzbbkVar, final WebView webView, final boolean z) {
        this.zzb = zzbbkVar;
        this.zzc = webView;
        this.zzd = z;
        Objects.requireNonNull(zzbbuVar);
        this.zze = zzbbuVar;
        this.zza = new ValueCallback() { // from class: com.google.android.gms.internal.ads.zzbbr
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(Object obj) {
                this.zza.zze.zzd(zzbbkVar, webView, (String) obj, z);
            }
        };
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView webView = this.zzc;
        if (webView.getSettings().getJavaScriptEnabled()) {
            try {
                webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
