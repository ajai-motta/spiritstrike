package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzsa extends zzrz {
    zzsa() {
    }

    @Override // com.google.android.recaptcha.internal.zzrz
    final void zza(Object obj) {
        ((zzsk) obj).zzb.zzg();
    }

    @Override // com.google.android.recaptcha.internal.zzrz
    final void zzb(zzvi zzviVar, Map.Entry entry) throws IOException {
        zzsl zzslVar = (zzsl) entry.getKey();
        zzvg zzvgVar = zzvg.DOUBLE;
        switch (zzslVar.zzb) {
            case DOUBLE:
                zzviVar.zzf(zzslVar.zza, ((Double) entry.getValue()).doubleValue());
                break;
            case FLOAT:
                zzviVar.zzo(zzslVar.zza, ((Float) entry.getValue()).floatValue());
                break;
            case INT64:
                zzviVar.zzt(zzslVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case UINT64:
                zzviVar.zzK(zzslVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case INT32:
                zzviVar.zzr(zzslVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case FIXED64:
                zzviVar.zzm(zzslVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case FIXED32:
                zzviVar.zzk(zzslVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case BOOL:
                zzviVar.zzb(zzslVar.zza, ((Boolean) entry.getValue()).booleanValue());
                break;
            case STRING:
                zzviVar.zzG(zzslVar.zza, (String) entry.getValue());
                break;
            case GROUP:
                zzviVar.zzq(zzslVar.zza, entry.getValue(), zzuc.zza().zzb(entry.getValue().getClass()));
                break;
            case MESSAGE:
                zzviVar.zzv(zzslVar.zza, entry.getValue(), zzuc.zza().zzb(entry.getValue().getClass()));
                break;
            case BYTES:
                zzviVar.zzd(zzslVar.zza, (zzqm) entry.getValue());
                break;
            case UINT32:
                zzviVar.zzI(zzslVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case ENUM:
                zzviVar.zzr(zzslVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case SFIXED32:
                zzviVar.zzx(zzslVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case SFIXED64:
                zzviVar.zzz(zzslVar.zza, ((Long) entry.getValue()).longValue());
                break;
            case SINT32:
                zzviVar.zzB(zzslVar.zza, ((Integer) entry.getValue()).intValue());
                break;
            case SINT64:
                zzviVar.zzD(zzslVar.zza, ((Long) entry.getValue()).longValue());
                break;
        }
    }
}
