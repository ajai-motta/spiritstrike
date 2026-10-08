package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzji implements zzjt {
    public static final zzji zza = new zzji();

    private zzji() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        boolean z = true;
        if (zzztVarArr.length != 1) {
            throw new zzdm(4, 3, null);
        }
        Object objZza = zzizVar.zzc().zza(zzztVarArr[0]);
        if (true != (objZza instanceof Object)) {
            objZza = null;
        }
        if (objZza == null) {
            throw new zzdm(4, 5, null);
        }
        try {
            try {
                if (objZza instanceof String) {
                    objZza = zzizVar.zzh().zza((String) objZza);
                }
                zzja zzjaVarZzc = zzizVar.zzc();
                try {
                    zziy.zza(objZza);
                } catch (zzdm e) {
                    if (e.zzb() == 8 || e.zzb() == 6) {
                        z = false;
                    } else if (e.zzb() != 47) {
                        throw e;
                    }
                }
                zzjaVarZzc.zze(i, Boolean.valueOf(z));
            } catch (Exception e2) {
                throw new zzdm(6, 8, e2);
            }
        } catch (zzdm e3) {
            throw e3;
        }
    }
}
