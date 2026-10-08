package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzor implements zzpa {
    public static final zzgmv zza = zzop.zza;
    private static final Random zzb = new Random();
    private final zzbe zzc;
    private final zzbd zzd;
    private final HashMap zze;
    private zzoz zzf;
    private zzbf zzg;
    private String zzh;
    private long zzi;

    public zzor() {
        throw null;
    }

    public zzor(zzgmv zzgmvVar) {
        this.zzc = new zzbe();
        this.zzd = new zzbd();
        this.zze = new HashMap();
        this.zzg = zzbf.zza;
        this.zzi = -1L;
    }

    @RequiresNonNull({ServiceSpecificExtraArgs.CastExtraArgs.LISTENER})
    private final void zzl(zzmj zzmjVar) {
        if (zzmjVar.zzb.zzg()) {
            String str = this.zzh;
            if (str != null) {
                zzoq zzoqVar = (zzoq) this.zze.get(str);
                zzoqVar.getClass();
                zzm(zzoqVar);
                return;
            }
            return;
        }
        zzoq zzoqVar2 = (zzoq) this.zze.get(this.zzh);
        int i = zzmjVar.zzc;
        zzuu zzuuVar = zzmjVar.zzd;
        this.zzh = zzo(i, zzuuVar).zze();
        zzc(zzmjVar);
        if (zzuuVar == null || !zzuuVar.zzb()) {
            return;
        }
        if (zzoqVar2 != null) {
            if (zzoqVar2.zzg() == zzuuVar.zzd && zzoqVar2.zzh() != null) {
                zzuu zzuuVarZzh = zzoqVar2.zzh();
                if (zzuuVarZzh.zzb == zzuuVar.zzb) {
                    zzuu zzuuVarZzh2 = zzoqVar2.zzh();
                    if (zzuuVarZzh2.zzc == zzuuVar.zzc) {
                        return;
                    }
                }
            }
        }
        zzo(i, new zzuu(zzuuVar.zza, zzuuVar.zzd));
    }

    private final void zzm(zzoq zzoqVar) {
        if (zzoqVar.zzg() != -1) {
            this.zzi = zzoqVar.zzg();
        }
        this.zzh = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final long zzi() {
        zzoq zzoqVar = (zzoq) this.zze.get(this.zzh);
        return (zzoqVar == null || zzoqVar.zzg() == -1) ? this.zzi + 1 : zzoqVar.zzg();
    }

    private final zzoq zzo(int i, zzuu zzuuVar) {
        HashMap map = this.zze;
        long j = Long.MAX_VALUE;
        zzoq zzoqVar = null;
        for (zzoq zzoqVar2 : map.values()) {
            zzoqVar2.zzc(i, zzuuVar);
            if (zzoqVar2.zzb(i, zzuuVar)) {
                long jZzg = zzoqVar2.zzg();
                if (jZzg == -1 || jZzg < j) {
                    zzoqVar = zzoqVar2;
                    j = jZzg;
                } else if (jZzg == j) {
                    String str = zzep.zza;
                    if (zzoqVar.zzh() != null && zzoqVar2.zzh() != null) {
                        zzoqVar = zzoqVar2;
                    }
                }
            }
        }
        if (zzoqVar != null) {
            return zzoqVar;
        }
        String strZzp = zzp();
        zzoq zzoqVar3 = new zzoq(this, strZzp, i, zzuuVar);
        map.put(strZzp, zzoqVar3);
        return zzoqVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzp() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final void zza(zzoz zzozVar) {
        this.zzf = zzozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized String zzb(zzbf zzbfVar, zzuu zzuuVar) {
        return zzo(zzbfVar.zzo(zzuuVar.zza, this.zzd).zzc, zzuuVar).zze();
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized void zzc(zzmj zzmjVar) {
        zzoq zzoqVar;
        this.zzf.getClass();
        zzbf zzbfVar = zzmjVar.zzb;
        if (!zzbfVar.zzg()) {
            zzuu zzuuVar = zzmjVar.zzd;
            if (zzuuVar != null) {
                if (zzuuVar.zzd >= zzi() && ((zzoqVar = (zzoq) this.zze.get(this.zzh)) == null || zzoqVar.zzg() != -1 || zzoqVar.zzf() == zzmjVar.zzc)) {
                }
            }
            int i = zzmjVar.zzc;
            zzoq zzoqVarZzo = zzo(i, zzuuVar);
            if (this.zzh == null) {
                this.zzh = zzoqVarZzo.zze();
            }
            if (zzuuVar != null && zzuuVar.zzb()) {
                Object obj = zzuuVar.zza;
                long j = zzuuVar.zzd;
                int i2 = zzuuVar.zzb;
                zzoq zzoqVarZzo2 = zzo(i, new zzuu(obj, j, i2));
                if (!zzoqVarZzo2.zzi()) {
                    zzoqVarZzo2.zzj(true);
                    zzbd zzbdVar = this.zzd;
                    zzbfVar.zzo(obj, zzbdVar);
                    zzbdVar.zzc(i2);
                    Math.max(0L, zzep.zzp(0L) + zzep.zzp(0L));
                }
            }
            if (!zzoqVarZzo.zzi()) {
                zzoqVarZzo.zzj(true);
            }
            if (zzoqVarZzo.zze().equals(this.zzh) && !zzoqVarZzo.zzk()) {
                zzoqVarZzo.zzl(true);
                this.zzf.zzc(zzmjVar, zzoqVarZzo.zze());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized void zzd(zzmj zzmjVar) {
        this.zzf.getClass();
        zzbf zzbfVar = this.zzg;
        this.zzg = zzmjVar.zzb;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzoq zzoqVar = (zzoq) it.next();
            if (!zzoqVar.zza(zzbfVar, this.zzg) || zzoqVar.zzd(zzmjVar)) {
                it.remove();
                if (zzoqVar.zzi()) {
                    if (zzoqVar.zze().equals(this.zzh)) {
                        zzm(zzoqVar);
                    }
                    this.zzf.zzd(zzmjVar, zzoqVar.zze(), false);
                }
            }
        }
        zzl(zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized void zze(zzmj zzmjVar, int i) {
        this.zzf.getClass();
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzoq zzoqVar = (zzoq) it.next();
            if (zzoqVar.zzd(zzmjVar)) {
                it.remove();
                if (zzoqVar.zzi()) {
                    boolean zEquals = zzoqVar.zze().equals(this.zzh);
                    boolean z = false;
                    if (i == 0 && zEquals && zzoqVar.zzk()) {
                        z = true;
                    }
                    if (zEquals) {
                        zzm(zzoqVar);
                    }
                    this.zzf.zzd(zzmjVar, zzoqVar.zze(), z);
                }
            }
        }
        zzl(zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized String zzf() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzpa
    public final synchronized void zzg(zzmj zzmjVar) {
        zzoz zzozVar;
        String str = this.zzh;
        if (str != null) {
            zzoq zzoqVar = (zzoq) this.zze.get(str);
            zzoqVar.getClass();
            zzm(zzoqVar);
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzoq zzoqVar2 = (zzoq) it.next();
            it.remove();
            if (zzoqVar2.zzi() && (zzozVar = this.zzf) != null) {
                zzozVar.zzd(zzmjVar, zzoqVar2.zze(), false);
            }
        }
    }

    final /* synthetic */ zzbe zzj() {
        return this.zzc;
    }

    final /* synthetic */ zzbd zzk() {
        return this.zzd;
    }
}
