package com.google.android.recaptcha.internal;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjy implements zzjt {
    public static final zzjy zza = new zzjy();

    private zzjy() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        int length = zzztVarArr.length;
        if (length < 2) {
            throw new zzdm(4, 3, null);
        }
        Class<?> clsZza = zzizVar.zzc().zza(zzztVarArr[0]);
        if (true != (clsZza instanceof Object)) {
            clsZza = null;
        }
        if (clsZza == null) {
            throw new zzdm(4, 5, null);
        }
        Class<?> cls = clsZza instanceof Class ? clsZza : clsZza.getClass();
        Object objZza = zzizVar.zzc().zza(zzztVarArr[1]);
        if (true != (objZza instanceof String)) {
            objZza = null;
        }
        String str = (String) objZza;
        if (str == null) {
            throw new zzdm(4, 5, null);
        }
        String strZza = zzizVar.zzh().zza(str);
        if (Intrinsics.areEqual(strZza, "forName")) {
            throw new zzdm(6, 48, null);
        }
        Class[] clsArrZzf = zzizVar.zzc().zzf(ArraysKt.toList(zzztVarArr).subList(2, length));
        try {
            zzizVar.zzc().zze(i, cls.getMethod(strZza, (Class[]) Arrays.copyOf(clsArrZzf, clsArrZzf.length)));
        } catch (Exception e) {
            throw new zzdm(6, 13, e);
        }
    }
}
