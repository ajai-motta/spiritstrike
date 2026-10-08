package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzggm implements zzggf {
    private final Context zza;
    private final zzifb zzb;
    private final zzggu zzc;
    private final zzgjd zzd;
    private final ExecutorService zze;
    private final zzgfg zzf;
    private final zzfrs zzg;

    zzggm(Context context, zzifb zzifbVar, zzggu zzgguVar, zzgjd zzgjdVar, ExecutorService executorService, zzgfg zzgfgVar, zzfrs zzfrsVar) {
        this.zza = context;
        this.zzb = zzifbVar;
        this.zzc = zzgguVar;
        this.zzd = zzgjdVar;
        this.zze = executorService;
        this.zzf = zzgfgVar;
        this.zzg = zzfrsVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzfzy zzf(int i) {
        zzfzx zzfzxVarZzd = zzfzy.zzd();
        zzfzxVarZzd.zze(i);
        return (zzfzy) zzfzxVarZzd.zzbu();
    }

    @Override // com.google.android.gms.internal.ads.zzggf
    public final ListenableFuture zza() {
        final zzifb zzifbVar = this.zzb;
        Objects.requireNonNull(zzifbVar);
        Callable callable = new Callable() { // from class: com.google.android.gms.internal.ads.zzggh
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return zzifbVar.zzb();
            }
        };
        ExecutorService executorService = this.zze;
        zzgua zzguaVar = (zzgua) zzgui.zzg((zzgua) zzgui.zzk((zzgua) zzgui.zzj((zzgua) zzgui.zzk(zzgua.zzw(zzgui.zzd(callable, executorService)), new zzglu() { // from class: com.google.android.gms.internal.ads.zzggl
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                this.zza.zzb((zzbaa) obj);
                return new Integer(0);
            }
        }, zzguz.zza()), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzggi
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc((Integer) obj);
            }
        }, zzguz.zza()), new zzglu() { // from class: com.google.android.gms.internal.ads.zzggj
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj) {
                return this.zza.zzd((zzgaa) obj);
            }
        }, executorService), zzggg.class, zzggk.zza, zzguz.zza());
        this.zzd.zze(15202, zzguaVar);
        return zzguaVar;
    }

    final /* synthetic */ int zzb(zzbaa zzbaaVar) {
        if (zzfsp.zza(zzbaaVar)) {
            return 0;
        }
        this.zzd.zzc(15204, zzbaaVar.name());
        throw new zzggg(null);
    }

    final /* synthetic */ ListenableFuture zzc(Integer num) {
        return this.zzc.zza();
    }

    final /* synthetic */ zzfzy zzd(zzgaa zzgaaVar) {
        String strZza = zzgaaVar.zza().zza();
        String strZzb = zzgaaVar.zza().zzb();
        zzgjb zzgjbVarZza = this.zzd.zza(15203);
        try {
            zzgjbVarZza.zza();
            zzftg zzftgVarZza = zzfsb.zza(this.zza, 1, (zzbaa) this.zzb.zzb(), strZza, strZzb, "1", this.zzg);
            zzgjbVarZza.zzc();
            int i = 2;
            if (zzftgVarZza.zzc == 2) {
                this.zzd.zzb(15208);
                return zzf(4);
            }
            byte[] bArr = zzftgVarZza.zzb;
            if (bArr == null || bArr.length == 0) {
                this.zzd.zzb(5010);
                return zzf(8);
            }
            try {
                zzbac zzbacVarZze = zzbac.zze(bArr, zzhvy.zzb());
                if (zzbacVarZze.zza().zza().isEmpty() || zzbacVarZze.zza().zzb().isEmpty() || zzbacVarZze.zzc().zzv().length == 0) {
                    this.zzd.zzb(15207);
                } else {
                    if (zzgaaVar.equals(zzgaa.zze()) || !TextUtils.equals(zzgaaVar.zza().zza(), zzbacVarZze.zza().zza()) || !TextUtils.equals(zzgaaVar.zza().zzb(), zzbacVarZze.zza().zzb())) {
                        int i2 = zzftgVarZza.zzc;
                        if (i2 == 4) {
                            if (!this.zzf.zza(zzbacVarZze.zzb().zzv())) {
                                this.zzd.zzb(15206);
                                return zzf(12);
                            }
                            i2 = 4;
                        }
                        zzfzx zzfzxVarZzd = zzfzy.zzd();
                        if (i2 == 2) {
                            i = 4;
                        } else if (i2 != 3) {
                            i = i2 != 4 ? i2 != 6 ? 1 : 5 : 3;
                        }
                        zzfzxVarZzd.zze(i);
                        zzfzz zzfzzVarZzd = zzgaa.zzd();
                        zzfzzVarZzd.zza(zzbacVarZze.zza());
                        zzfzzVarZzd.zzc((zzbaa) this.zzb.zzb());
                        zzfzxVarZzd.zza((zzgaa) zzfzzVarZzd.zzbu());
                        zzfzxVarZzd.zzd(zzbacVarZze.zzb());
                        zzfzxVarZzd.zzc(zzbacVarZze.zzc());
                        return (zzfzy) zzfzxVarZzd.zzbu();
                    }
                    this.zzd.zzb(15209);
                }
                return zzf(11);
            } catch (zzhxd e) {
                this.zzd.zzd(15205, e);
                return zzf(9);
            } catch (NullPointerException unused) {
                this.zzd.zzb(15210);
                return zzf(10);
            }
        } catch (Throwable th) {
            try {
                zzgjbVarZza.zzb(th);
                throw th;
            } catch (Throwable th2) {
                zzgjbVarZza.zzc();
                throw th2;
            }
        }
    }
}
