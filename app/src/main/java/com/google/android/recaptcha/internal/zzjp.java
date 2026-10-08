package com.google.android.recaptcha.internal;

import java.lang.reflect.Proxy;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjp implements zzjt {
    public static final zzjp zza = new zzjp();

    private zzjp() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        int length = zzztVarArr.length;
        if (length != 4 && length != 5) {
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
        Object objZza2 = zzizVar.zzc().zza(zzztVarArr[1]);
        if (true != (objZza2 instanceof Integer)) {
            objZza2 = null;
        }
        Integer num2 = (Integer) objZza2;
        if (num2 == null) {
            throw new zzdm(4, 5, null);
        }
        int iIntValue2 = num2.intValue();
        Object objZza3 = zzizVar.zzc().zza(zzztVarArr[2]);
        if (true != (objZza3 instanceof String)) {
            objZza3 = null;
        }
        String str = (String) objZza3;
        if (str == null) {
            throw new zzdm(4, 5, null);
        }
        String strZza = zzizVar.zzh().zza(str);
        Object objZza4 = zzizVar.zzc().zza(zzztVarArr[3]);
        if (true != (objZza4 instanceof String)) {
            objZza4 = null;
        }
        String str2 = (String) objZza4;
        if (str2 == null) {
            throw new zzdm(4, 5, null);
        }
        String strZza2 = zzizVar.zzh().zza(str2);
        Object objZza5 = length == 5 ? zzizVar.zzc().zza(zzztVarArr[4]) : null;
        zziv zzivVar = new zziv(iIntValue2);
        try {
            Class clsZza = zziy.zza(strZza);
            zzizVar.zzc().zze(iIntValue, Proxy.newProxyInstance(clsZza.getClassLoader(), new Class[]{clsZza}, new zziw(zzivVar, strZza2, objZza5)));
            zzizVar.zzc().zze(i, zzivVar);
        } catch (Exception e) {
            throw new zzdm(6, 20, e);
        }
    }
}
