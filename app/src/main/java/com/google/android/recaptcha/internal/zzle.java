package com.google.android.recaptcha.internal;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.internal.AssetHelper;
import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzle extends WebViewClient {
    final /* synthetic */ zzly zza;

    zzle(zzly zzlyVar) {
        this.zza = zzlyVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        System.currentTimeMillis();
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        long jZza = this.zza.zzg.zza(TimeUnit.MICROSECONDS);
        int i = zzco.zza;
        zzco.zza(zzcp.zzb.zza(), jZza);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Use onReceivedError(WebView,request,error) instead")
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        zzly zzlyVar = this.zza;
        zzce zzceVar = zzce.zzc;
        zzcd zzcdVar = (zzcd) zzlyVar.zzc.get(Integer.valueOf(i));
        if (zzcdVar == null) {
            zzcdVar = zzcd.zzM;
        }
        zzcg zzcgVar = new zzcg(zzceVar, zzcdVar, null, null, 12, null);
        zzlyVar.zzz().hashCode();
        zzcgVar.getMessage();
        zzlyVar.zzz().completeExceptionally(zzcgVar);
    }

    @Override // android.webkit.WebViewClient
    @Deprecated(message = "Use shouldInterceptRequest(WebView,WebResourceRequest) instead")
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        zzly zzlyVar = this.zza;
        Uri uri = Uri.parse(str);
        zzly.zzq(zzlyVar);
        Intrinsics.checkNotNull(uri);
        if (!zzig.zzc(uri) || zzly.zzq(zzlyVar).zza(uri)) {
            return super.shouldInterceptRequest(webView, str);
        }
        zzcg zzcgVar = new zzcg(zzce.zzb, zzcd.zzQ, null, null, 12, null);
        zzlyVar.zzz().hashCode();
        uri.toString();
        zzlyVar.zzz().completeExceptionally(zzcgVar);
        return new WebResourceResponse(AssetHelper.DEFAULT_MIME_TYPE, "UTF-8", new ByteArrayInputStream(new byte[0]));
    }
}
