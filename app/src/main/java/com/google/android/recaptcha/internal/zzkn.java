package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkn implements zzjt {
    public static final zzkn zza = new zzkn();

    private zzkn() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        if (zzztVarArr.length != 2) {
            throw new zzdm(4, 3, null);
        }
        Object objZza = zzizVar.zzc().zza(zzztVarArr[0]);
        if (true != (objZza instanceof int[])) {
            objZza = null;
        }
        int[] iArr = (int[]) objZza;
        if (iArr == null) {
            throw new zzdm(4, 5, null);
        }
        Object objZza2 = zzizVar.zzc().zza(zzztVarArr[1]);
        if (true != (objZza2 instanceof String)) {
            objZza2 = null;
        }
        String str = (String) objZza2;
        if (str == null) {
            throw new zzdm(4, 5, null);
        }
        zzja zzjaVarZzc = zzizVar.zzc();
        StringBuilder sb = new StringBuilder();
        try {
            for (int i2 : iArr) {
                sb.append(str.charAt(i2));
            }
            zzjaVarZzc.zze(i, sb.toString());
        } catch (Exception e) {
            throw new zzdm(4, 22, e);
        }
    }
}
