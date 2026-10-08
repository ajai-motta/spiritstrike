package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzbdz;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfid implements zzfic {
    private final ConcurrentHashMap zza;
    private final zzfij zzb;
    private final zzfif zzc = new zzfif();

    public zzfid(zzfij zzfijVar) {
        this.zza = new ConcurrentHashMap(zzfijVar.zzd);
        this.zzb = zzfijVar;
    }

    private final void zzf() {
        Parcelable.Creator<zzfij> creator = zzfij.CREATOR;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgR)).booleanValue()) {
            StringBuilder sb = new StringBuilder();
            zzfij zzfijVar = this.zzb;
            sb.append(zzfijVar.zzb);
            sb.append(" PoolCollection");
            sb.append(this.zzc.zzg());
            int i = 0;
            for (Map.Entry entry : this.zza.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(((zzfim) entry.getKey()).hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < ((zzfib) entry.getValue()).zzc(); i2++) {
                    sb.append("[O]");
                }
                for (int iZzc = ((zzfib) entry.getValue()).zzc(); iZzc < zzfijVar.zzd; iZzc++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(((zzfib) entry.getValue()).zzg());
                sb.append("\n");
            }
            while (i < zzfijVar.zzc) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            String string = sb.toString();
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzd(string);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfic
    public final synchronized zzfil zza(zzfim zzfimVar) {
        zzfil zzfilVarZzb;
        zzfib zzfibVar = (zzfib) this.zza.get(zzfimVar);
        if (zzfibVar != null) {
            zzfilVarZzb = zzfibVar.zzb();
            if (zzfilVarZzb == null) {
                this.zzc.zzb();
            }
            zzfiz zzfizVarZzh = zzfibVar.zzh();
            if (zzfilVarZzb != null) {
                zzbdz.zzb.zzc zzcVarZzs = zzbdz.zzb.zzs();
                zzbdz.zzb.zza.C0306zza c0306zzaZzs = zzbdz.zzb.zza.zzs();
                c0306zzaZzs.zzc(zzbdz.zzb.zzd.IN_MEMORY);
                zzbdz.zzb.zze.zza zzaVarZzq = zzbdz.zzb.zze.zzq();
                zzaVarZzq.zzc(zzfizVarZzh.zza);
                zzaVarZzq.zzg(zzfizVarZzh.zzb);
                c0306zzaZzs.zzh(zzaVarZzq);
                zzcVarZzs.zzh(c0306zzaZzs);
                zzfilVarZzb.zza.zza().zzd().zzj(zzcVarZzs.zzbu());
            }
            zzf();
        } else {
            this.zzc.zza();
            zzf();
            zzfilVarZzb = null;
        }
        return zzfilVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfic
    public final synchronized boolean zzb(zzfim zzfimVar, zzfil zzfilVar) {
        boolean zZza;
        ConcurrentHashMap concurrentHashMap = this.zza;
        zzfib zzfibVar = (zzfib) concurrentHashMap.get(zzfimVar);
        zzfilVar.zzd = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
        if (zzfibVar == null) {
            zzfij zzfijVar = this.zzb;
            zzfib zzfibVar2 = new zzfib(zzfijVar.zzd, zzfijVar.zze * 1000);
            if (concurrentHashMap.size() == zzfijVar.zzc) {
                int i = zzfijVar.zzg;
                int i2 = i - 1;
                zzfim zzfimVar2 = null;
                if (i == 0) {
                    throw null;
                }
                long jZzd = Long.MAX_VALUE;
                if (i2 == 0) {
                    for (Map.Entry entry : concurrentHashMap.entrySet()) {
                        if (((zzfib) entry.getValue()).zzd() < jZzd) {
                            jZzd = ((zzfib) entry.getValue()).zzd();
                            zzfimVar2 = (zzfim) entry.getKey();
                        }
                    }
                    if (zzfimVar2 != null) {
                        concurrentHashMap.remove(zzfimVar2);
                    }
                } else if (i2 == 1) {
                    for (Map.Entry entry2 : concurrentHashMap.entrySet()) {
                        if (((zzfib) entry2.getValue()).zze() < jZzd) {
                            jZzd = ((zzfib) entry2.getValue()).zze();
                            zzfimVar2 = (zzfim) entry2.getKey();
                        }
                    }
                    if (zzfimVar2 != null) {
                        concurrentHashMap.remove(zzfimVar2);
                    }
                } else if (i2 == 2) {
                    int iZzf = Integer.MAX_VALUE;
                    for (Map.Entry entry3 : concurrentHashMap.entrySet()) {
                        if (((zzfib) entry3.getValue()).zzf() < iZzf) {
                            iZzf = ((zzfib) entry3.getValue()).zzf();
                            zzfimVar2 = (zzfim) entry3.getKey();
                        }
                    }
                    if (zzfimVar2 != null) {
                        concurrentHashMap.remove(zzfimVar2);
                    }
                }
                this.zzc.zzd();
            }
            concurrentHashMap.put(zzfimVar, zzfibVar2);
            this.zzc.zzc();
            zzfibVar = zzfibVar2;
        }
        zZza = zzfibVar.zza(zzfilVar);
        zzfif zzfifVar = this.zzc;
        zzfifVar.zze();
        zzfie zzfieVarZzf = zzfifVar.zzf();
        zzfiz zzfizVarZzh = zzfibVar.zzh();
        if (zzfilVar != null) {
            zzbdz.zzb.zzc zzcVarZzs = zzbdz.zzb.zzs();
            zzbdz.zzb.zza.C0306zza c0306zzaZzs = zzbdz.zzb.zza.zzs();
            c0306zzaZzs.zzc(zzbdz.zzb.zzd.IN_MEMORY);
            zzbdz.zzb.zzg.zza zzaVarZzs = zzbdz.zzb.zzg.zzs();
            zzaVarZzs.zzc(zzfieVarZzf.zza);
            zzaVarZzs.zzg(zzfieVarZzf.zzb);
            zzaVarZzs.zzk(zzfizVarZzh.zzb);
            c0306zzaZzs.zzn(zzaVarZzs);
            zzcVarZzs.zzh(c0306zzaZzs);
            zzfilVar.zza.zza().zzd().zzk(zzcVarZzs.zzbu());
        }
        zzf();
        return zZza;
    }

    @Override // com.google.android.gms.internal.ads.zzfic
    public final synchronized boolean zzc(zzfim zzfimVar) {
        zzfib zzfibVar = (zzfib) this.zza.get(zzfimVar);
        if (zzfibVar == null) {
            return true;
        }
        return zzfibVar.zzc() < this.zzb.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzfic
    @Deprecated
    public final zzfim zzd(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, com.google.android.gms.ads.internal.client.zzx zzxVar) {
        zzfij zzfijVar = this.zzb;
        return new zzfin(zzmVar, str, new zzbxm(zzfijVar.zza).zza().zzj, zzfijVar.zzf, zzxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfic
    public final zzfij zze() {
        return this.zzb;
    }
}
