package com.google.android.recaptcha.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjf implements zzjt {
    public static final zzjf zza = new zzjf();

    private zzjf() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        if (zzztVarArr.length != 3) {
            throw new zzdm(4, 3, null);
        }
        Object objZza = zzizVar.zzc().zza(zzztVarArr[0]);
        if (true != (objZza instanceof Integer)) {
            objZza = null;
        }
        Integer num = (Integer) objZza;
        if (num == null) {
            throw new zzdm(4, 5, null);
        }
        int iIntValue = num.intValue();
        if (iIntValue == 0) {
            throw new zzdm(4, 6, null);
        }
        Object objZza2 = zzizVar.zzc().zza(zzztVarArr[1]);
        if (true != (objZza2 instanceof Object)) {
            objZza2 = null;
        }
        if (objZza2 == null) {
            throw new zzdm(4, 5, null);
        }
        Object objZza3 = zzizVar.zzc().zza(zzztVarArr[2]);
        if (true != (objZza3 instanceof Object)) {
            objZza3 = null;
        }
        if (objZza3 == null) {
            throw new zzdm(4, 5, null);
        }
        if (Intrinsics.areEqual(objZza2, objZza3)) {
            zzizVar.zzg(zzizVar.zza() + iIntValue);
        }
    }
}
