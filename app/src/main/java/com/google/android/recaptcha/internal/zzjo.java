package com.google.android.recaptcha.internal;

import java.lang.reflect.Proxy;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjo implements zzjt {
    public static final zzjo zza = new zzjo();

    private zzjo() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, final zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        final int iIntValue;
        int length = zzztVarArr.length;
        if (length != 4 && length != 5) {
            throw new zzdm(4, 3, null);
        }
        Object objZza = zzizVar.zzc().zza(zzztVarArr[0]);
        if (true != (objZza instanceof String)) {
            objZza = null;
        }
        final String str = (String) objZza;
        if (str == null) {
            throw new zzdm(4, 5, null);
        }
        Object objZza2 = zzizVar.zzc().zza(zzztVarArr[1]);
        if (true != (objZza2 instanceof Object)) {
            objZza2 = null;
        }
        if (objZza2 == null) {
            throw new zzdm(4, 5, null);
        }
        Object objZza3 = zzizVar.zzc().zza(zzztVarArr[2]);
        if (true != (objZza3 instanceof String)) {
            objZza3 = null;
        }
        String str2 = (String) objZza3;
        if (str2 == null) {
            throw new zzdm(4, 5, null);
        }
        String strZza = zzizVar.zzh().zza(str2);
        Object objZza4 = zzizVar.zzc().zza(zzztVarArr[3]);
        if (length == 5) {
            Object objZza5 = zzizVar.zzc().zza(zzztVarArr[4]);
            if (true != (objZza5 instanceof Integer)) {
                objZza5 = null;
            }
            Integer num = (Integer) objZza5;
            if (num == null) {
                throw new zzdm(4, 5, null);
            }
            iIntValue = num.intValue();
        } else {
            iIntValue = -1;
        }
        try {
            if (objZza2 instanceof String) {
                objZza2 = zzizVar.zzh().zza((String) objZza2);
            }
            Class clsZza = zziy.zza(objZza2);
            zzizVar.zzc().zze(i, Proxy.newProxyInstance(clsZza.getClassLoader(), new Class[]{clsZza}, new zziu(new Function2() { // from class: com.google.android.recaptcha.internal.zzjn
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    zziz zzizVar2 = zzizVar;
                    Object[] objArr = (Object[]) obj;
                    zzizVar2.zzi().zzb(str, (String) obj2);
                    int i2 = iIntValue;
                    if (i2 != -1) {
                        zzizVar2.zzc().zze(i2, objArr);
                    }
                    return Unit.INSTANCE;
                }
            }, strZza, objZza4)));
        } catch (Exception e) {
            throw new zzdm(6, 20, e);
        }
    }
}
