package com.google.android.recaptcha.internal;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import kotlin.collections.ArraysKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkf implements zzjt {
    public static final zzkf zza = new zzkf();

    private zzkf() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        int length = zzztVarArr.length;
        if (length == 0) {
            throw new zzdm(4, 3, null);
        }
        Constructor<?> constructorZza = zzizVar.zzc().zza(zzztVarArr[0]);
        if (true != (constructorZza instanceof Object)) {
            constructorZza = null;
        }
        if (constructorZza == null) {
            throw new zzdm(4, 5, null);
        }
        Constructor<?> constructor = constructorZza instanceof Constructor ? constructorZza : constructorZza.getClass().getConstructor(new Class[0]);
        Object[] objArrZzg = zzizVar.zzc().zzg(ArraysKt.toList(zzztVarArr).subList(1, length));
        try {
            zzizVar.zzc().zze(i, constructor.newInstance(Arrays.copyOf(objArrZzg, objArrZzg.length)));
        } catch (Exception e) {
            throw new zzdm(6, 14, e);
        }
    }
}
