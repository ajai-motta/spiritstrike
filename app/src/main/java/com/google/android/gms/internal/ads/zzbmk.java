package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hive.core.Configuration;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbmk implements zzblx {
    private final com.google.android.gms.ads.internal.zzb zza;
    private final zzdvi zzb;
    private final zzbuh zzd;
    private final zzefy zze;
    private final zzcpe zzf;
    private final zzcxn zzg;
    private com.google.android.gms.ads.internal.util.client.zzu zzc = null;
    private com.google.android.gms.ads.internal.overlay.zzaa zzh = null;
    private final zzgus zzi = zzcbv.zzg;

    public zzbmk(com.google.android.gms.ads.internal.zzb zzbVar, zzbuh zzbuhVar, zzefy zzefyVar, zzdvi zzdviVar, zzcpe zzcpeVar, zzcxn zzcxnVar) {
        this.zza = zzbVar;
        this.zzd = zzbuhVar;
        this.zze = zzefyVar;
        this.zzb = zzdviVar;
        this.zzf = zzcpeVar;
        this.zzg = zzcxnVar;
    }

    public static boolean zzb(Map map) {
        return "1".equals(map.get("custom_close"));
    }

    public static int zzc(Map map) {
        String str = (String) map.get("o");
        if (str == null) {
            return -1;
        }
        if (TtmlNode.TAG_P.equalsIgnoreCase(str)) {
            return 7;
        }
        if ("l".equalsIgnoreCase(str)) {
            return 6;
        }
        return "c".equalsIgnoreCase(str) ? 14 : -1;
    }

    static Uri zzd(Context context, zzaxa zzaxaVar, Uri uri, View view, Activity activity, zzfgr zzfgrVar) {
        if (zzaxaVar == null) {
            return uri;
        }
        try {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmY)).booleanValue() || zzfgrVar == null) {
                if (zzaxaVar.zze(uri)) {
                    uri = zzaxaVar.zzd(uri, context, view, activity);
                }
            } else if (zzaxaVar.zze(uri)) {
                uri = zzfgrVar.zza(uri, context, view, activity);
            }
        } catch (zzaxb unused) {
        } catch (Exception e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "OpenGmsgHandler.maybeAddClickSignalsToUri");
        }
        return uri;
    }

    static Uri zze(Uri uri) {
        try {
            if (uri.getQueryParameter("aclk_ms") != null) {
                return uri.buildUpon().appendQueryParameter("aclk_upms", String.valueOf(SystemClock.uptimeMillis())).build();
            }
        } catch (UnsupportedOperationException e) {
            String string = uri.toString();
            String.valueOf(string);
            String strValueOf = String.valueOf(string);
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Error adding click uptime parameter to url: ".concat(strValueOf), e);
        }
        return uri;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:182:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0153, code lost:
    
        if (r0.getPackageName().equals(r1) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x015a, code lost:
    
        if (com.google.android.gms.internal.ads.zzbfv.zza(r0) == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0177, code lost:
    
        zzl(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x017e, code lost:
    
        if (android.text.TextUtils.isEmpty(r30) == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0180, code lost:
    
        r0 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Cannot open browser with null or empty url");
        zzm(7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x018b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x018c, code lost:
    
        r0 = zze(zzd(r10.getContext(), r10.zzS(), android.net.Uri.parse(r30), r10.zzE(), r10.zzj(), r10.zzT()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01ac, code lost:
    
        if (r12 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01b0, code lost:
    
        if (r29.zze == null) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01be, code lost:
    
        if (zzi(r31, r10.getContext(), r0.toString(), r13) != false) goto L182;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01c0, code lost:
    
        r29.zzh = new com.google.android.gms.internal.ads.zzbmh(r29);
        r1 = (com.google.android.gms.internal.ads.zzcio) r31;
        r18 = r0.toString();
        r3 = r29.zzh;
        r4 = new android.os.Bundle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01e7, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(com.google.android.gms.internal.ads.zzbeu.zzfn)).booleanValue() == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01f1, code lost:
    
        if (r32.containsKey("cct_init_h") == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01f3, code lost:
    
        r4.putInt("h", java.lang.Integer.parseInt((java.lang.String) r32.get("cct_init_h")));
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0203, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0204, code lost:
    
        com.google.android.gms.ads.internal.util.zze.zzb("Invalid cct initial height parameter.", r0);
        com.google.android.gms.ads.internal.zzt.zzh().zzg(r0, "OpenGmsgHandler.getChromeCustomTabConfigBundle");
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0363  */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(java.lang.String r30, com.google.android.gms.ads.internal.client.zza r31, java.util.Map r32, java.lang.String r33) {
        /*
            Method dump skipped, instruction units count: 1206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbmk.zzf(java.lang.String, com.google.android.gms.ads.internal.client.zza, java.util.Map, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x006e, code lost:
    
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(com.google.android.gms.internal.ads.zzbeu.zzjt)).booleanValue() != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:
    
        if ((android.os.Build.VERSION.SDK_INT < 33 ? ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(com.google.android.gms.internal.ads.zzbeu.zzjo)).booleanValue() : ((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(com.google.android.gms.internal.ads.zzbeu.zzjn)).booleanValue()) != false) goto L54;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzi(com.google.android.gms.ads.internal.client.zza r10, android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbmk.zzi(com.google.android.gms.ads.internal.client.zza, android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    private final void zzj(Context context, String str, String str2) {
        zzefy zzefyVar = this.zze;
        zzefyVar.zzd(str);
        zzdvi zzdviVar = this.zzb;
        if (zzdviVar != null) {
            zzegj.zzk(context, zzdviVar, zzefyVar, str, "dialog_not_shown", zzgph.zzb("dialog_not_shown_reason", str2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0157, code lost:
    
        r22 = r7;
        r11 = r16;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0160  */
    /* JADX WARN: Type inference failed for: r2v10, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v22, types: [android.content.Intent] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzk(com.google.android.gms.ads.internal.client.zza r21, java.util.Map r22, boolean r23, java.lang.String r24, boolean r25, boolean r26) {
        /*
            Method dump skipped, instruction units count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbmk.zzk(com.google.android.gms.ads.internal.client.zza, java.util.Map, boolean, java.lang.String, boolean, boolean):void");
    }

    private final void zzl(boolean z) {
        zzbuh zzbuhVar = this.zzd;
        if (zzbuhVar != null) {
            zzbuhVar.zzb(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzm, reason: merged with bridge method [inline-methods] */
    public final void zzg(int i) {
        zzdvi zzdviVar;
        String str;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfh)).booleanValue() || (zzdviVar = this.zzb) == null) {
            return;
        }
        zzdvh zzdvhVarZza = zzdviVar.zza();
        zzdvhVarZza.zzc(NativeProtocol.WEB_DIALOG_ACTION, "cct_action");
        switch (i) {
            case 2:
                str = "CONTEXT_NOT_AN_ACTIVITY";
                break;
            case 3:
                str = "CONTEXT_NULL";
                break;
            case 4:
                str = "CCT_NOT_SUPPORTED";
                break;
            case 5:
                str = "CCT_READY_TO_OPEN";
                break;
            case 6:
                str = "ACTIVITY_NOT_FOUND";
                break;
            case 7:
                str = "EMPTY_URL";
                break;
            case 8:
                str = Configuration.HIVE_COUNTRY_DEFAULT;
                break;
            case 9:
                str = "WRONG_EXP_SETUP";
                break;
            default:
                str = "OPT_OUT";
                break;
        }
        zzdvhVarZza.zzc("cct_open_status", str);
        zzdvhVarZza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcpe zzcpeVar;
        com.google.android.gms.ads.internal.client.zza zzaVar = (com.google.android.gms.ads.internal.client.zza) obj;
        String str = (String) map.get("u");
        Map map2 = new HashMap();
        zzcgy zzcgyVar = (zzcgy) zzaVar;
        if (zzcgyVar.zzC() != null) {
            map2 = zzcgyVar.zzC().zzaw;
        }
        String strZza = zzcah.zza(str, zzcgyVar.getContext(), true, map2);
        String str2 = (String) map.get("a");
        if (str2 == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Action missing from an open GMSG.");
            return;
        }
        com.google.android.gms.ads.internal.zzb zzbVar = this.zza;
        if (zzbVar == null || zzbVar.zzb()) {
            zzgui.zzr((((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlb)).booleanValue() && (zzcpeVar = this.zzf) != null && zzcpe.zzc(strZza)) ? zzcpeVar.zzb(strZza, com.google.android.gms.ads.internal.client.zzbb.zze()) : zzgui.zza(strZza), new zzbmg(this, map, zzaVar, str2), this.zzi);
        } else {
            zzbVar.zzc(strZza);
        }
    }
}
