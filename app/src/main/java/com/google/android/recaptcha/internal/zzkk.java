package com.google.android.recaptcha.internal;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkk implements zzjt {
    public static final zzkk zza = new zzkk();

    private zzkk() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        if (zzztVarArr.length != 2) {
            throw new zzdm(4, 3, null);
        }
        Object objZza = zzizVar.zzc().zza(zzztVarArr[0]);
        if (true != (objZza instanceof Field)) {
            objZza = null;
        }
        Field field = (Field) objZza;
        if (field == null) {
            throw new zzdm(4, 5, null);
        }
        try {
            field.set(null, zzizVar.zzc().zza(zzztVarArr[1]));
        } catch (Exception e) {
            throw new zzdm(6, 11, e);
        }
    }
}
