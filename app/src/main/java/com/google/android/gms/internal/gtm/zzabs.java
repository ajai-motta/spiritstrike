package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzabs extends zzabr {
    zzabs() {
    }

    @Override // com.google.android.gms.internal.gtm.zzabr
    final void zza(Object obj) {
        ((zzacc) obj).zza.zzi();
    }

    @Override // com.google.android.gms.internal.gtm.zzabr
    final void zzb(zzadw zzadwVar, Object obj, zzabq zzabqVar, zzabv zzabvVar) throws IOException {
        zzace zzaceVar = (zzace) obj;
        zzabvVar.zzk(zzaceVar.zzd, zzadwVar.zzs(zzaceVar.zzc.getClass(), zzabqVar));
    }

    @Override // com.google.android.gms.internal.gtm.zzabr
    final void zzc(zzaez zzaezVar, Map.Entry entry) throws IOException {
        zzacd zzacdVar = (zzacd) entry.getKey();
        if (!zzacdVar.zzd) {
            zzaex zzaexVar = zzaex.DOUBLE;
            switch (zzacdVar.zzc) {
                case DOUBLE:
                    zzaezVar.zzf(zzacdVar.zzb, ((Double) entry.getValue()).doubleValue());
                    break;
                case FLOAT:
                    zzaezVar.zzo(zzacdVar.zzb, ((Float) entry.getValue()).floatValue());
                    break;
                case INT64:
                    zzaezVar.zzt(zzacdVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case UINT64:
                    zzaezVar.zzK(zzacdVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case INT32:
                    zzaezVar.zzr(zzacdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case FIXED64:
                    zzaezVar.zzm(zzacdVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case FIXED32:
                    zzaezVar.zzk(zzacdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case BOOL:
                    zzaezVar.zzb(zzacdVar.zzb, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case STRING:
                    zzaezVar.zzG(zzacdVar.zzb, (String) entry.getValue());
                    break;
                case GROUP:
                    zzaezVar.zzq(zzacdVar.zzb, entry.getValue(), zzadt.zza().zzb(entry.getValue().getClass()));
                    break;
                case MESSAGE:
                    zzaezVar.zzv(zzacdVar.zzb, entry.getValue(), zzadt.zza().zzb(entry.getValue().getClass()));
                    break;
                case BYTES:
                    zzaezVar.zzd(zzacdVar.zzb, (zzyx) entry.getValue());
                    break;
                case UINT32:
                    zzaezVar.zzI(zzacdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case ENUM:
                    zzaezVar.zzr(zzacdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED32:
                    zzaezVar.zzx(zzacdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED64:
                    zzaezVar.zzz(zzacdVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
                case SINT32:
                    zzaezVar.zzB(zzacdVar.zzb, ((Integer) entry.getValue()).intValue());
                    break;
                case SINT64:
                    zzaezVar.zzD(zzacdVar.zzb, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        zzaex zzaexVar2 = zzaex.DOUBLE;
        switch (zzacdVar.zzc) {
            case DOUBLE:
                zzadz.zzt(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case FLOAT:
                zzadz.zzx(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case INT64:
                zzadz.zzA(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case UINT64:
                zzadz.zzI(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case INT32:
                zzadz.zzz(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case FIXED64:
                zzadz.zzw(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case FIXED32:
                zzadz.zzv(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case BOOL:
                zzadz.zzr(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case STRING:
                zzadz.zzG(zzacdVar.zzb, (List) entry.getValue(), zzaezVar);
                break;
            case GROUP:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzadz.zzy(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, zzadt.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case MESSAGE:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzadz.zzB(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, zzadt.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case BYTES:
                zzadz.zzs(zzacdVar.zzb, (List) entry.getValue(), zzaezVar);
                break;
            case UINT32:
                zzadz.zzH(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case ENUM:
                zzadz.zzz(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case SFIXED32:
                zzadz.zzC(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case SFIXED64:
                zzadz.zzD(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case SINT32:
                zzadz.zzE(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
            case SINT64:
                zzadz.zzF(zzacdVar.zzb, (List) entry.getValue(), zzaezVar, false);
                break;
        }
    }
}
