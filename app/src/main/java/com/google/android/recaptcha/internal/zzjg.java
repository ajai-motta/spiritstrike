package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjg implements zzjt {
    public static final zzjg zza = new zzjg();

    private zzjg() {
    }

    @Override // com.google.android.recaptcha.internal.zzjt
    public final void zza(int i, zziz zzizVar, zzzt... zzztVarArr) throws zzdm {
        if (zzztVarArr.length == 0) {
            throw new zzdm(4, 3, null);
        }
        zzyu zzyuVarZzf = zzyx.zzf();
        for (zzzt zzztVar : zzztVarArr) {
            Object objZza = zzizVar.zzc().zza(zzztVar);
            if (objZza == null) {
                throw new zzdm(4, 4, null);
            }
            zzyv zzyvVarZzf = zzyw.zzf();
            if (objZza instanceof Integer) {
                zzyvVarZzf.zzu(((Number) objZza).intValue());
            } else if (objZza instanceof Short) {
                zzyvVarZzf.zzt(((Number) objZza).shortValue());
            } else if (objZza instanceof Byte) {
                zzyvVarZzf.zzf(zzqm.zzl(new byte[]{((Number) objZza).byteValue()}, 0, 1));
            } else if (objZza instanceof Long) {
                zzyvVarZzf.zzv(((Number) objZza).longValue());
            } else if (objZza instanceof Double) {
                zzyvVarZzf.zzr(((Number) objZza).doubleValue());
            } else if (objZza instanceof Float) {
                zzyvVarZzf.zzs(((Number) objZza).floatValue());
            } else if (objZza instanceof Boolean) {
                zzyvVarZzf.zze(((Boolean) objZza).booleanValue());
            } else if (objZza instanceof Character) {
                zzyvVarZzf.zzq(String.valueOf(((Character) objZza).charValue()));
            } else if (objZza instanceof String) {
                zzyvVarZzf.zzw((String) objZza);
            } else {
                zzyvVarZzf.zzw(objZza.toString());
            }
            zzyuVarZzf.zzf((zzyw) zzyvVarZzf.zzk());
        }
        zzja zzjaVarZzc = zzizVar.zzc();
        byte[] bArrZzd = ((zzyx) zzyuVarZzf.zzk()).zzd();
        zzjaVarZzc.zze(i, zzpp.zzh().zzi(bArrZzd, 0, bArrZzd.length));
    }
}
