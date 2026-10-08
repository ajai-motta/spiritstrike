package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgew {
    private final zzght zza;
    private final zzggf zzb;
    private final zzggu zzc;
    private final zzgjd zzd;

    zzgew(zzght zzghtVar, zzggf zzggfVar, zzggu zzgguVar, zzgjd zzgjdVar) {
        this.zza = zzghtVar;
        this.zzb = zzggfVar;
        this.zzc = zzgguVar;
        this.zzd = zzgjdVar;
    }

    final ListenableFuture zza() {
        return (zzgua) zzgui.zzg((zzgua) zzgui.zzg((zzgua) zzgui.zzg((zzgua) zzgui.zzj((zzgua) zzgui.zzk((zzgua) zzgui.zzg(zzgua.zzw(this.zzc.zza()), Throwable.class, zzgeu.zza, zzguz.zza()), new zzglu() { // from class: com.google.android.gms.internal.ads.zzgej
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                this.zza.zzb((zzgaa) obj);
                return new Integer(0);
            }
        }, zzguz.zza()), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzgel
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc((Integer) obj);
            }
        }, zzguz.zza()), zzgeh.class, zzgem.zza, zzguz.zza()), zzgeg.class, zzgen.zza, zzguz.zza()), zzgei.class, zzgeo.zza, zzguz.zza());
    }

    final /* synthetic */ int zzb(zzgaa zzgaaVar) {
        if (this.zza.zza(zzgaaVar)) {
            return 0;
        }
        throw new zzgeh(null);
    }

    final /* synthetic */ ListenableFuture zzc(Integer num) {
        zzgua zzguaVar = (zzgua) zzgui.zzk((zzgua) zzgui.zzj((zzgua) zzgui.zzk(zzgua.zzw(this.zzb.zza()), new zzglu(this) { // from class: com.google.android.gms.internal.ads.zzgep
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                zzfzy zzfzyVar = (zzfzy) obj;
                int iZzj = zzfzyVar.zzj() - 1;
                if (iZzj == 1 || iZzj == 2) {
                    return zzfzyVar;
                }
                if (iZzj != 3) {
                    throw new zzgeg(zzfzyVar.zzj() - 1);
                }
                throw new zzgei(zzfzyVar.zzj() - 1);
            }
        }, zzguz.zza()), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzgeq
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzd((zzfzy) obj);
            }
        }, zzguz.zza()), zzger.zza, zzguz.zza());
        this.zzd.zze(1002, zzguaVar);
        return zzguaVar;
    }

    final /* synthetic */ ListenableFuture zzd(final zzfzy zzfzyVar) {
        if (zzfzyVar.zzj() == 2) {
            return (zzgua) zzgui.zzj(zzgua.zzw(this.zzc.zzd(zzfzyVar.zzb().zzv())), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzges
                @Override // com.google.android.gms.internal.ads.zzgtq
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return this.zza.zze(zzfzyVar, (Void) obj);
                }
            }, zzguz.zza());
        }
        if (zzfzyVar.zzj() == 3) {
            return (zzgua) zzgui.zzj((zzgua) zzgui.zzj(zzgua.zzw(this.zzc.zzb(zzgaa.zze())), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzget
                @Override // com.google.android.gms.internal.ads.zzgtq
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return this.zza.zzf(zzfzyVar, (Void) obj);
                }
            }, zzguz.zza()), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzgek
                @Override // com.google.android.gms.internal.ads.zzgtq
                public final /* synthetic */ ListenableFuture zza(Object obj) {
                    return this.zza.zzg(zzfzyVar, (List) obj);
                }
            }, zzguz.zza());
        }
        throw new AssertionError("Unreachable");
    }

    final /* synthetic */ ListenableFuture zze(zzfzy zzfzyVar, Void r2) {
        return this.zzc.zzb(zzfzyVar.zza());
    }

    final /* synthetic */ ListenableFuture zzf(zzfzy zzfzyVar, Void r4) {
        byte[] bArrZzv = zzfzyVar.zzb().zzv();
        zzggu zzgguVar = this.zzc;
        return zzgui.zzl(zzgguVar.zzd(bArrZzv), zzgguVar.zzf(zzfzyVar.zzc().zzv()));
    }

    final /* synthetic */ ListenableFuture zzg(zzfzy zzfzyVar, List list) {
        return this.zzc.zzb(zzfzyVar.zza());
    }
}
