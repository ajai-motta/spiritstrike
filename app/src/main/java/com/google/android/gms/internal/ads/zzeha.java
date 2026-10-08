package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public interface zzeha {
    boolean zza(Context context);

    String zzb(Context context);

    zzehf zzc(String str, WebView webView, String str2, String str3, String str4, zzehc zzehcVar, zzehb zzehbVar, String str5);

    zzehf zzd(String str, WebView webView, String str2, String str3, String str4, String str5, zzehc zzehcVar, zzehb zzehbVar, String str6);

    void zze(zzfou zzfouVar);

    void zzf(zzfou zzfouVar);

    void zzg(zzfou zzfouVar, View view);

    void zzh(zzfou zzfouVar, View view);

    zzfpg zzi(VersionInfoParcel versionInfoParcel, WebView webView, boolean z);

    void zzj(zzfpg zzfpgVar, zzfpf zzfpfVar);

    void zzk(zzfpg zzfpgVar, View view);
}
