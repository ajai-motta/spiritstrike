package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzadd implements zzady {
    private static final zzadj zza = new zzadb();
    private final zzadj zzb;

    public zzadd() {
        zzadj zzadjVar = zza;
        int i = zzadt.zza;
        zzadc zzadcVar = new zzadc(zzabz.zza(), zzadjVar);
        byte[] bArr = zzaco.zzb;
        this.zzb = zzadcVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzady
    public final zzadx zza(Class cls) {
        int i = zzadz.zza;
        if (!zzacf.class.isAssignableFrom(cls)) {
            int i2 = zzadt.zza;
        }
        zzadi zzadiVarZzb = this.zzb.zzb(cls);
        if (zzadiVarZzb.zzb()) {
            int i3 = zzadt.zza;
            return zzadp.zzc(zzadz.zzm(), zzabt.zza(), zzadiVarZzb.zza());
        }
        int i4 = zzadt.zza;
        return zzado.zzm(cls, zzadiVarZzb, zzads.zza(), zzacz.zza(), zzadz.zzm(), zzadiVarZzb.zzc() + (-1) != 1 ? zzabt.zza() : null, zzadh.zza());
    }
}
