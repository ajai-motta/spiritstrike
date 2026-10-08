package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdvt {
    private final String zze;
    private final zzdvn zzf;
    private final List zzb = new ArrayList();
    private boolean zzc = false;
    private boolean zzd = false;
    private final com.google.android.gms.ads.internal.util.zzg zza = com.google.android.gms.ads.internal.zzt.zzh().zzo();

    public zzdvt(String str, zzdvn zzdvnVar) {
        this.zze = str;
        this.zzf = zzdvnVar;
    }

    private final Map zzg() {
        Map mapZza = this.zzf.zza();
        mapZza.put("tms", Long.toString(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime(), 10));
        mapZza.put(ScarConstants.TOKEN_ID_KEY, this.zza.zzx() ? "" : this.zze);
        return mapZza;
    }

    public final synchronized void zza(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcq)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put(NativeProtocol.WEB_DIALOG_ACTION, "adapter_init_started");
            mapZzg.put("ancn", str);
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zzb(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcq)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put(NativeProtocol.WEB_DIALOG_ACTION, "adapter_init_finished");
            mapZzg.put("ancn", str);
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zzc(String str, String str2) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcq)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put(NativeProtocol.WEB_DIALOG_ACTION, "adapter_init_finished");
            mapZzg.put("ancn", str);
            mapZzg.put("rqe", str2);
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zzd(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcq)).booleanValue()) {
            Map mapZzg = zzg();
            mapZzg.put(NativeProtocol.WEB_DIALOG_ACTION, "aaia");
            mapZzg.put("aair", "MalformedJson");
            this.zzb.add(mapZzg);
        }
    }

    public final synchronized void zze() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcq)).booleanValue() && !this.zzc) {
            Map mapZzg = zzg();
            mapZzg.put(NativeProtocol.WEB_DIALOG_ACTION, "init_started");
            this.zzb.add(mapZzg);
            this.zzc = true;
        }
    }

    public final synchronized void zzf() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcq)).booleanValue() && !this.zzd) {
            Map mapZzg = zzg();
            mapZzg.put(NativeProtocol.WEB_DIALOG_ACTION, "init_finished");
            List list = this.zzb;
            list.add(mapZzg);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.zzf.zzb((Map) it.next());
            }
            this.zzd = true;
        }
    }
}
