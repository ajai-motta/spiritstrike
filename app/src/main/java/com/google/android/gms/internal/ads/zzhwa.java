package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhwa extends zzhvz {
    zzhwa() {
    }

    @Override // com.google.android.gms.internal.ads.zzhvz
    final void zza(Object obj) {
        ((zzhwk) obj).zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzhvz
    final void zzb(zzhzr zzhzrVar, Map.Entry entry) throws IOException {
        zzhwl zzhwlVar = (zzhwl) entry.getKey();
        if (!zzhwlVar.zzc) {
            zzhzp zzhzpVar = zzhzp.DOUBLE;
            switch (zzhwlVar.zzb) {
                case DOUBLE:
                    zzhzrVar.zzf(zzhwlVar.zza, ((Double) entry.getValue()).doubleValue());
                    break;
                case FLOAT:
                    zzhzrVar.zze(zzhwlVar.zza, ((Float) entry.getValue()).floatValue());
                    break;
                case INT64:
                    zzhzrVar.zzc(zzhwlVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case UINT64:
                    zzhzrVar.zzh(zzhwlVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case INT32:
                    zzhzrVar.zzi(zzhwlVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case FIXED64:
                    zzhzrVar.zzj(zzhwlVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case FIXED32:
                    zzhzrVar.zzk(zzhwlVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case BOOL:
                    zzhzrVar.zzl(zzhwlVar.zza, ((Boolean) entry.getValue()).booleanValue());
                    break;
                case STRING:
                    zzhzrVar.zzm(zzhwlVar.zza, (String) entry.getValue());
                    break;
                case GROUP:
                    zzhzrVar.zzs(zzhwlVar.zza, entry.getValue(), zzhyj.zza().zzb(entry.getValue().getClass()));
                    break;
                case MESSAGE:
                    zzhzrVar.zzr(zzhwlVar.zza, entry.getValue(), zzhyj.zza().zzb(entry.getValue().getClass()));
                    break;
                case BYTES:
                    zzhzrVar.zzn(zzhwlVar.zza, (zzhvi) entry.getValue());
                    break;
                case UINT32:
                    zzhzrVar.zzo(zzhwlVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case ENUM:
                    zzhzrVar.zzi(zzhwlVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED32:
                    zzhzrVar.zzb(zzhwlVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SFIXED64:
                    zzhzrVar.zzd(zzhwlVar.zza, ((Long) entry.getValue()).longValue());
                    break;
                case SINT32:
                    zzhzrVar.zzp(zzhwlVar.zza, ((Integer) entry.getValue()).intValue());
                    break;
                case SINT64:
                    zzhzrVar.zzq(zzhwlVar.zza, ((Long) entry.getValue()).longValue());
                    break;
            }
        }
        zzhzp zzhzpVar2 = zzhzp.DOUBLE;
        switch (zzhwlVar.zzb) {
            case DOUBLE:
                zzhyt.zza(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case FLOAT:
                zzhyt.zzb(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case INT64:
                zzhyt.zzc(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case UINT64:
                zzhyt.zzd(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case INT32:
                zzhyt.zzh(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case FIXED64:
                zzhyt.zzf(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case FIXED32:
                zzhyt.zzk(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case BOOL:
                zzhyt.zzn(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case STRING:
                zzhyt.zzo(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar);
                break;
            case GROUP:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    zzhyt.zzr(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhyj.zza().zzb(list.get(0).getClass()));
                    break;
                }
                break;
            case MESSAGE:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    zzhyt.zzq(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhyj.zza().zzb(list2.get(0).getClass()));
                    break;
                }
                break;
            case BYTES:
                zzhyt.zzp(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar);
                break;
            case UINT32:
                zzhyt.zzi(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case ENUM:
                zzhyt.zzh(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case SFIXED32:
                zzhyt.zzl(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case SFIXED64:
                zzhyt.zzg(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case SINT32:
                zzhyt.zzj(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
            case SINT64:
                zzhyt.zze(zzhwlVar.zza, (List) entry.getValue(), zzhzrVar, zzhwlVar.zzd);
                break;
        }
    }
}
