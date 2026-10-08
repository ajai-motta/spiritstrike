package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjq implements zzjt {
    public static final zzjq zza = new zzjq();

    private zzjq() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        if (zzztVarArr.length != 2) {
            throw new zzdm(4, 3, null);
        }
        Object objZza = zzizVar.zzc().zza(zzztVarArr[0]);
        if (true != (objZza instanceof Object)) {
            objZza = null;
        }
        if (objZza == null) {
            throw new zzdm(4, 5, null);
        }
        Object objZza2 = zzizVar.zzc().zza(zzztVarArr[1]);
        if (true != (objZza2 instanceof Integer)) {
            objZza2 = null;
        }
        Integer num = (Integer) objZza2;
        if (num == null) {
            throw new zzdm(4, 5, null);
        }
        int iIntValue = num.intValue();
        try {
            if (objZza instanceof String) {
                objZza = zzizVar.zzh().zza((String) objZza);
            }
            zzizVar.zzc().zze(i, Array.newInstance((Class<?>) zziy.zza(objZza), iIntValue));
        } catch (Exception e) {
            throw new zzdm(6, 21, e);
        }
    }
}
