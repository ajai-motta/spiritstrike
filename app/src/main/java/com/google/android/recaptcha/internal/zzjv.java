package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjv implements zzjt {
    public static final zzjv zza = new zzjv();

    private zzjv() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
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
            if (objZza instanceof String) {
                objZza = zzizVar.zzh().zza((String) objZza);
            }
            zzizVar.zzc().zze(i, zziy.zza(objZza));
        } catch (zzdm e) {
            throw e;
        } catch (Exception e2) {
            throw new zzdm(6, 8, e2);
        }
    }
}
