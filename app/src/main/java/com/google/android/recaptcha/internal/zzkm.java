package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkm implements zzjt {
    public static final zzkm zza = new zzkm();

    private zzkm() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        Integer numValueOf;
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
        if (objZza instanceof Integer) {
            numValueOf = Integer.valueOf(((Number) objZza).intValue() - iIntValue);
        } else {
            if (!(objZza instanceof int[])) {
                throw new zzdm(4, 5, null);
            }
            int[] iArr = (int[]) objZza;
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int i2 : iArr) {
                arrayList.add(Integer.valueOf(i2 - iIntValue));
            }
            numValueOf = (Serializable) arrayList.toArray(new Integer[0]);
        }
        zzizVar.zzc().zze(i, numValueOf);
    }
}
