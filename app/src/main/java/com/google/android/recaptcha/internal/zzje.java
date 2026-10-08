package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzje implements zzjt {
    public static final zzje zza = new zzje();

    private zzje() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        if (zzztVarArr.length != 3) {
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
        Object objZza3 = zzizVar.zzc().zza(zzztVarArr[2]);
        if (true != (objZza3 instanceof Object)) {
            objZza3 = null;
        }
        if (objZza3 == null) {
            throw new zzdm(4, 5, null);
        }
        try {
            Array.set(objZza, iIntValue, objZza3);
        } catch (Exception e) {
            if (!(e instanceof ArrayIndexOutOfBoundsException)) {
                throw new zzdm(4, 25, e);
            }
            throw new zzdm(4, 22, e);
        }
    }
}
