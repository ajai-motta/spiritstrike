package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbdz;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzefh implements zzfkt {
    private final zzeev zza;
    private final zzeez zzb;

    zzefh(zzeev zzeevVar, zzeez zzeezVar) {
        this.zza = zzeevVar;
        this.zzb = zzeezVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdP(zzfkm zzfkmVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdQ(zzfkm zzfkmVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgL)).booleanValue()) {
            if (zzfkm.RENDERER == zzfkmVar) {
                this.zza.zzg(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime());
                return;
            }
            if (zzfkm.PRELOADED_LOADER == zzfkmVar || zzfkm.SERVER_TRANSACTION == zzfkmVar) {
                zzeev zzeevVar = this.zza;
                zzeevVar.zza(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime());
                final zzeez zzeezVar = this.zzb;
                final long jZzb = zzeevVar.zzb();
                zzeezVar.zza.zza(new zzfjx() { // from class: com.google.android.gms.internal.ads.zzeey
                    @Override // com.google.android.gms.internal.ads.zzfjx
                    public final /* synthetic */ Object zza(Object obj) {
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                        if (zzeezVar.zzf()) {
                            return null;
                        }
                        long j = jZzb;
                        zzbdz.zzaf.zza.C0305zza c0305zzaZzz = zzbdz.zzaf.zza.zzz();
                        c0305zzaZzz.zzad(j);
                        byte[] bArrZzaN = c0305zzaZzz.zzbu().zzaN();
                        zzefg.zzf(sQLiteDatabase, false, false);
                        zzefg.zze(sQLiteDatabase, j, bArrZzaN);
                        return null;
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdR(zzfkm zzfkmVar, String str, Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgL)).booleanValue() && zzfkm.RENDERER == zzfkmVar) {
            zzeev zzeevVar = this.zza;
            if (zzeevVar.zzh() != 0) {
                zzeevVar.zzi(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - zzeevVar.zzh());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdS(zzfkm zzfkmVar, String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgL)).booleanValue() && zzfkm.RENDERER == zzfkmVar) {
            zzeev zzeevVar = this.zza;
            if (zzeevVar.zzh() != 0) {
                zzeevVar.zzi(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime() - zzeevVar.zzh());
            }
        }
    }
}
