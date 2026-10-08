package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzegz implements zzeha {
    static /* synthetic */ zzehf zzl(String str, String str2, String str3, zzehb zzehbVar, String str4, WebView webView, String str5, String str6, zzehc zzehcVar) {
        zzfpi zzfpiVarZza = zzfpi.zza("Google", str2);
        zzfph zzfphVarZzn = zzn("javascript");
        zzfoz zzfozVarZzp = zzp(zzehbVar.toString());
        zzfph zzfphVar = zzfph.NONE;
        if (zzfphVarZzn == zzfphVar) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid html session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzfozVarZzp == null) {
            String strValueOf = String.valueOf(zzehbVar);
            String.valueOf(strValueOf);
            String strValueOf2 = String.valueOf(strValueOf);
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid html session error; Unable to parse creative type: ".concat(strValueOf2));
            return null;
        }
        zzfph zzfphVarZzn2 = zzn(str4);
        if (zzfozVarZzp != zzfoz.VIDEO || zzfphVarZzn2 != zzfphVar) {
            zzfow zzfowVarZza = zzfow.zza(zzfpiVarZza, webView, str5, "");
            return new zzehf(zzfou.zze(zzfov.zza(zzfozVarZzp, zzo(zzehcVar.toString()), zzfphVarZzn, zzfphVarZzn2, true), zzfowVarZza), zzfowVarZza);
        }
        String.valueOf(str4);
        String strValueOf3 = String.valueOf(str4);
        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid html session error; Video events owner unknown for video creative: ".concat(strValueOf3));
        return null;
    }

    static /* synthetic */ zzehf zzm(String str, String str2, String str3, String str4, zzehb zzehbVar, WebView webView, String str5, String str6, zzehc zzehcVar) {
        zzfpi zzfpiVarZza = zzfpi.zza(str, str2);
        zzfph zzfphVarZzn = zzn("javascript");
        zzfph zzfphVarZzn2 = zzn(str4);
        zzfoz zzfozVarZzp = zzp(zzehbVar.toString());
        zzfph zzfphVar = zzfph.NONE;
        if (zzfphVarZzn == zzfphVar) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid js session error; Unable to parse impression owner: javascript");
            return null;
        }
        if (zzfozVarZzp == null) {
            String strValueOf = String.valueOf(zzehbVar);
            String.valueOf(strValueOf);
            String strValueOf2 = String.valueOf(strValueOf);
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid js session error; Unable to parse creative type: ".concat(strValueOf2));
            return null;
        }
        if (zzfozVarZzp != zzfoz.VIDEO || zzfphVarZzn2 != zzfphVar) {
            zzfow zzfowVarZzb = zzfow.zzb(zzfpiVarZza, webView, str5, "");
            return new zzehf(zzfou.zze(zzfov.zza(zzfozVarZzp, zzo(zzehcVar.toString()), zzfphVarZzn, zzfphVarZzn2, true), zzfowVarZzb), zzfowVarZzb);
        }
        String.valueOf(str4);
        String strValueOf3 = String.valueOf(str4);
        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid js session error; Video events owner unknown for video creative: ".concat(strValueOf3));
        return null;
    }

    private static zzfph zzn(String str) {
        return "native".equals(str) ? zzfph.NATIVE : "javascript".equals(str) ? zzfph.JAVASCRIPT : zzfph.NONE;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzfpc zzo(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1104128070(0xffffffffbe3057ba, float:-0.17220965)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2a
            r1 = 1318088141(0x4e906dcd, float:1.2115575E9)
            if (r0 == r1) goto L20
            r1 = 1988248512(0x768243c0, float:1.3210405E33)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "onePixel"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = r2
            goto L35
        L20:
            java.lang.String r0 = "definedByJavascript"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = r3
            goto L35
        L2a:
            java.lang.String r0 = "beginToRender"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = 0
            goto L35
        L34:
            r4 = -1
        L35:
            if (r4 == 0) goto L44
            if (r4 == r3) goto L41
            if (r4 == r2) goto L3e
            com.google.android.gms.internal.ads.zzfpc r4 = com.google.android.gms.internal.ads.zzfpc.UNSPECIFIED
            goto L46
        L3e:
            com.google.android.gms.internal.ads.zzfpc r4 = com.google.android.gms.internal.ads.zzfpc.ONE_PIXEL
            goto L46
        L41:
            com.google.android.gms.internal.ads.zzfpc r4 = com.google.android.gms.internal.ads.zzfpc.DEFINED_BY_JAVASCRIPT
            goto L46
        L44:
            com.google.android.gms.internal.ads.zzfpc r4 = com.google.android.gms.internal.ads.zzfpc.BEGIN_TO_RENDER
        L46:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzegz.zzo(java.lang.String):com.google.android.gms.internal.ads.zzfpc");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzfoz zzp(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -382745961(0xffffffffe92fc297, float:-1.3280059E25)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2a
            r1 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r0 == r1) goto L20
            r1 = 714893483(0x2a9c68ab, float:2.7783795E-13)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "nativeDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = r3
            goto L35
        L20:
            java.lang.String r0 = "video"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = r2
            goto L35
        L2a:
            java.lang.String r0 = "htmlDisplay"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L34
            r4 = 0
            goto L35
        L34:
            r4 = -1
        L35:
            if (r4 == 0) goto L43
            if (r4 == r3) goto L40
            if (r4 == r2) goto L3d
            r4 = 0
            return r4
        L3d:
            com.google.android.gms.internal.ads.zzfoz r4 = com.google.android.gms.internal.ads.zzfoz.VIDEO
            return r4
        L40:
            com.google.android.gms.internal.ads.zzfoz r4 = com.google.android.gms.internal.ads.zzfoz.NATIVE_DISPLAY
            return r4
        L43:
            com.google.android.gms.internal.ads.zzfoz r4 = com.google.android.gms.internal.ads.zzfoz.HTML_DISPLAY
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzegz.zzp(java.lang.String):com.google.android.gms.internal.ads.zzfoz");
    }

    private static final Object zzq(zzegy zzegyVar) {
        try {
            return zzegyVar.zza();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "omid exception");
            return null;
        }
    }

    private static final void zzr(Runnable runnable) {
        try {
            runnable.run();
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "omid exception");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final boolean zza(final Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfP)).booleanValue()) {
            Boolean bool = (Boolean) zzq(new zzegy() { // from class: com.google.android.gms.internal.ads.zzegx
                @Override // com.google.android.gms.internal.ads.zzegy
                public final /* synthetic */ Object zza() {
                    if (zzfos.zzb()) {
                        return true;
                    }
                    zzfos.zza(context);
                    return Boolean.valueOf(zzfos.zzb());
                }
            });
            return bool != null && bool.booleanValue();
        }
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Omid flag is disabled");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final String zzb(Context context) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfP)).booleanValue()) {
            return (String) zzq(zzego.zza);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final zzehf zzc(final String str, final WebView webView, String str2, String str3, final String str4, final zzehc zzehcVar, final zzehb zzehbVar, final String str5) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfP)).booleanValue() || !zzfos.zzb()) {
            return null;
        }
        final String str6 = "javascript";
        final String str7 = "Google";
        final String str8 = "";
        return (zzehf) zzq(new zzegy(str7, str, str6, zzehbVar, str4, webView, str5, str8, zzehcVar) { // from class: com.google.android.gms.internal.ads.zzegp
            private final /* synthetic */ String zzb;
            private final /* synthetic */ zzehb zzd;
            private final /* synthetic */ String zze;
            private final /* synthetic */ WebView zzf;
            private final /* synthetic */ String zzg;
            private final /* synthetic */ zzehc zzi;
            private final /* synthetic */ String zza = "Google";
            private final /* synthetic */ String zzc = "javascript";
            private final /* synthetic */ String zzh = "";

            {
                this.zzb = str;
                this.zzd = zzehbVar;
                this.zze = str4;
                this.zzf = webView;
                this.zzg = str5;
                this.zzi = zzehcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzegy
            public final /* synthetic */ Object zza() {
                return zzegz.zzl(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final zzehf zzd(final String str, final WebView webView, String str2, String str3, final String str4, final String str5, final zzehc zzehcVar, final zzehb zzehbVar, final String str6) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfP)).booleanValue() || !zzfos.zzb()) {
            return null;
        }
        final String str7 = "";
        final String str8 = "javascript";
        return (zzehf) zzq(new zzegy(str5, str, str8, str4, zzehbVar, webView, str6, str7, zzehcVar) { // from class: com.google.android.gms.internal.ads.zzegq
            private final /* synthetic */ String zza;
            private final /* synthetic */ String zzb;
            private final /* synthetic */ String zzd;
            private final /* synthetic */ zzehb zze;
            private final /* synthetic */ WebView zzf;
            private final /* synthetic */ String zzg;
            private final /* synthetic */ zzehc zzi;
            private final /* synthetic */ String zzc = "javascript";
            private final /* synthetic */ String zzh = "";

            {
                this.zzd = str4;
                this.zze = zzehbVar;
                this.zzf = webView;
                this.zzg = str6;
                this.zzi = zzehcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzegy
            public final /* synthetic */ Object zza() {
                return zzegz.zzm(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final void zze(final zzfou zzfouVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfP)).booleanValue() && zzfos.zzb()) {
            Objects.requireNonNull(zzfouVar);
            zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegn
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzfouVar.zza();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final void zzf(final zzfou zzfouVar) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfP)).booleanValue() && zzfos.zzb()) {
                    zzfouVar.zzc();
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final void zzg(final zzfou zzfouVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegs
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfP)).booleanValue() && zzfos.zzb()) {
                    zzfouVar.zzd(view, zzfpb.NOT_VISIBLE, "Ad overlay");
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final void zzh(final zzfou zzfouVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfP)).booleanValue() && zzfos.zzb()) {
                    zzfouVar.zzb(view);
                }
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final zzfpg zzi(final VersionInfoParcel versionInfoParcel, final WebView webView, boolean z) {
        final boolean z2 = true;
        return (zzfpg) zzq(new zzegy(webView, z2) { // from class: com.google.android.gms.internal.ads.zzegu
            private final /* synthetic */ WebView zzb;

            @Override // com.google.android.gms.internal.ads.zzegy
            public final /* synthetic */ Object zza() {
                VersionInfoParcel versionInfoParcel2 = this.zza;
                int i = versionInfoParcel2.buddyApkVersion;
                int i2 = versionInfoParcel2.clientJarVersion;
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 1 + String.valueOf(i2).length());
                sb.append(i);
                sb.append(".");
                sb.append(i2);
                return zzfpg.zza(zzfpi.zza("Google", sb.toString()), this.zzb, true);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final void zzj(final zzfpg zzfpgVar, final zzfpf zzfpfVar) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegv
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzfpgVar.zzb(zzfpfVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzeha
    public final void zzk(final zzfpg zzfpgVar, final View view) {
        zzr(new Runnable() { // from class: com.google.android.gms.internal.ads.zzegw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzfpgVar.zzd(view, zzfpb.NOT_VISIBLE, "Ad overlay");
            }
        });
    }
}
