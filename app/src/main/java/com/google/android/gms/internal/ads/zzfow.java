package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfow {
    private final zzfpi zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final String zze;
    private final String zzf;
    private final zzfox zzg;

    private zzfow(zzfpi zzfpiVar, WebView webView, String str, List list, String str2, String str3, zzfox zzfoxVar) {
        this.zza = zzfpiVar;
        this.zzb = webView;
        this.zzg = zzfoxVar;
        this.zzf = str2;
        this.zze = str3;
    }

    public static zzfow zza(zzfpi zzfpiVar, WebView webView, String str, String str2) {
        if (str2 != null) {
            zzfqs.zzd(str2, 256, "CustomReferenceData is greater than 256 characters");
        }
        return new zzfow(zzfpiVar, webView, null, null, str, str2, zzfox.HTML);
    }

    public static zzfow zzb(zzfpi zzfpiVar, WebView webView, String str, String str2) {
        zzfqs.zzd("", 256, "CustomReferenceData is greater than 256 characters");
        return new zzfow(zzfpiVar, webView, null, null, str, "", zzfox.JAVASCRIPT);
    }

    public final zzfpi zzc() {
        return this.zza;
    }

    public final List zzd() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zze() {
        return Collections.unmodifiableMap(this.zzd);
    }

    public final WebView zzf() {
        return this.zzb;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final String zzh() {
        return this.zze;
    }

    public final zzfox zzi() {
        return this.zzg;
    }
}
