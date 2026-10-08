package com.google.android.recaptcha.internal;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgr {
    private final zzhk zza;
    private final Integer zzb;
    private final String zzc;
    private final long zzd;
    private final Lazy zze;
    private final int zzf;

    public zzgr(zzhk zzhkVar, int i, Integer num) {
        this.zza = zzhkVar;
        this.zzf = i;
        this.zzb = num;
        int i2 = zzby.zza;
        this.zze = LazyKt.lazy(zzgq.zza);
        zzd();
        this.zzc = zzvl.zzc(zzvl.zzb(System.currentTimeMillis()));
        zzd();
        this.zzd = System.currentTimeMillis();
    }

    private final zzdk zzd() {
        return (zzdk) this.zze.getValue();
    }

    private final zzwk zze(int i) {
        zzwk zzwkVarZzj = zzwn.zzj();
        zzwkVarZzj.zzA(this.zzf);
        int i2 = zzgl.zza;
        zzwkVarZzj.zzr(zzgl.zza());
        zzhk zzhkVar = this.zza;
        zzwkVarZzj.zzy(zzhkVar.zzb());
        zzwkVarZzj.zzu(zzhkVar.zza().zza());
        zzwkVarZzj.zzB(zzhkVar.zza().zzc());
        zzwkVarZzj.zzC(i);
        zzwkVarZzj.zzx(this.zzc);
        zzd();
        zzwkVarZzj.zzs(System.currentTimeMillis() - this.zzd);
        Integer num = this.zzb;
        if (num != null) {
            zzwkVarZzj.zzw(num.intValue());
        }
        return zzwkVarZzj;
    }

    public final zzhk zza() {
        return this.zza;
    }

    public final void zzb() {
        zzwk zzwkVarZze = zze(3);
        int i = zzgl.zza;
        zzgl.zzb(zzwkVarZze, this.zza.zza().zzb(), null);
    }

    public final void zzc(zzcg zzcgVar) {
        zzvy zzvyVarZzg = zzwa.zzg();
        zzvyVarZzg.zzr(String.valueOf(zzcgVar.zzb().zza()));
        zzvyVarZzg.zze(zzcgVar.zza().zza());
        zzvyVarZzg.zzq(zzcgVar.zzc().getErrorCode().getErrorCode());
        String strZzd = zzcgVar.zzd();
        if (strZzd != null) {
            zzvyVarZzg.zzf(strZzd);
        }
        zzwk zzwkVarZze = zze(4);
        zzhk zzhkVar = this.zza;
        int i = zzgl.zza;
        zzgl.zzb(zzwkVarZze, zzhkVar.zza().zzb(), (zzwa) zzvyVarZzg.zzk());
    }
}
