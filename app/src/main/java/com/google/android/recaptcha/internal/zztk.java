package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zztk implements zzuh {
    private static final zztq zza = new zzti();
    private final zztq zzb;

    public zztk() {
        zztq zztqVar = zza;
        int i = zzuc.zza;
        zztj zztjVar = new zztj(zzsg.zza(), zztqVar);
        byte[] bArr = zzsv.zzb;
        this.zzb = zztjVar;
    }

    @Override // com.google.android.recaptcha.internal.zzuh
    public final zzug zza(Class cls) {
        int i = zzui.zza;
        if (!zzsn.class.isAssignableFrom(cls)) {
            int i2 = zzuc.zza;
        }
        zztp zztpVarZzb = this.zzb.zzb(cls);
        if (zztpVarZzb.zzb()) {
            int i3 = zzuc.zza;
            return zztw.zzc(zzui.zzm(), zzsb.zza(), zztpVarZzb.zza());
        }
        int i4 = zzuc.zza;
        return zztv.zzm(cls, zztpVarZzb, zztz.zza(), zztg.zza(), zzui.zzm(), zztpVarZzb.zzc() + (-1) != 1 ? zzsb.zza() : null, zzto.zza());
    }
}
