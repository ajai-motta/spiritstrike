package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzkz implements zzvf, zzrv {
    final /* synthetic */ zzle zza;
    private final zzlb zzb;

    public zzkz(zzle zzleVar, zzlb zzlbVar) {
        Objects.requireNonNull(zzleVar);
        this.zza = zzleVar;
        this.zzb = zzlbVar;
    }

    private final Pair zzf(int i, zzuu zzuuVar) {
        zzuu zzuuVarZza;
        zzuu zzuuVar2 = null;
        if (zzuuVar != null) {
            zzlb zzlbVar = this.zzb;
            int i2 = 0;
            while (true) {
                List list = zzlbVar.zzc;
                if (i2 >= list.size()) {
                    zzuuVarZza = null;
                    break;
                }
                if (((zzuu) list.get(i2)).zzd == zzuuVar.zzd) {
                    Object obj = zzuuVar.zza;
                    Object obj2 = zzlbVar.zzb;
                    int i3 = zzll.zzb;
                    zzuuVarZza = zzuuVar.zza(Pair.create(obj2, obj));
                    break;
                }
                i2++;
            }
            if (zzuuVarZza == null) {
                return null;
            }
            zzuuVar2 = zzuuVarZza;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzuuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcT(int i, zzuu zzuuVar, final zzul zzulVar, final zzuq zzuqVar, final int i2) {
        final Pair pairZzf = zzf(0, zzuuVar);
        if (pairZzf != null) {
            zzle zzleVar = this.zza;
            zzleVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzky
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzcT(((Integer) pair.first).intValue(), (zzuu) pair.second, zzulVar, zzuqVar, i2);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcU(int i, zzuu zzuuVar, final zzul zzulVar, final zzuq zzuqVar) {
        final Pair pairZzf = zzf(0, zzuuVar);
        if (pairZzf != null) {
            zzle zzleVar = this.zza;
            zzleVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzku
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzcU(((Integer) pair.first).intValue(), (zzuu) pair.second, zzulVar, zzuqVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcV(int i, zzuu zzuuVar, final zzul zzulVar, final zzuq zzuqVar) {
        final Pair pairZzf = zzf(0, zzuuVar);
        if (pairZzf != null) {
            zzle zzleVar = this.zza;
            zzleVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkv
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzcV(((Integer) pair.first).intValue(), (zzuu) pair.second, zzulVar, zzuqVar);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcW(int i, zzuu zzuuVar, final zzul zzulVar, final zzuq zzuqVar, final IOException iOException, final boolean z) {
        final Pair pairZzf = zzf(0, zzuuVar);
        if (pairZzf != null) {
            zzle zzleVar = this.zza;
            zzleVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzcW(((Integer) pair.first).intValue(), (zzuu) pair.second, zzulVar, zzuqVar, iOException, z);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvf
    public final void zzcX(int i, zzuu zzuuVar, final zzuq zzuqVar) {
        final Pair pairZzf = zzf(0, zzuuVar);
        if (pairZzf != null) {
            zzle zzleVar = this.zza;
            zzleVar.zzk().zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    Pair pair = pairZzf;
                    this.zza.zza.zzj().zzcX(((Integer) pair.first).intValue(), (zzuu) pair.second, zzuqVar);
                }
            });
        }
    }
}
