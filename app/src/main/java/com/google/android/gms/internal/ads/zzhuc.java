package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhuc extends zzhtn {
    static final zzhuc zza = new zzhuc();

    private zzhuc() {
    }

    @Override // com.google.android.gms.internal.ads.zzhtn
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final void zza(zzhun zzhunVar, zzhtg zzhtgVar) throws IOException {
        if (zzhtgVar == null || (zzhtgVar instanceof zzhth)) {
            zzhunVar.zzj();
            return;
        }
        if (zzhtgVar instanceof zzhtk) {
            zzhtk zzhtkVarZzg = zzhtgVar.zzg();
            if (zzhtkVarZzg.zzc()) {
                zzhunVar.zzi(zzhtkVarZzg.zzh());
                return;
            } else if (zzhtkVarZzg.zza()) {
                zzhunVar.zzh(zzhtkVarZzg.zzb());
                return;
            } else {
                zzhunVar.zzg(zzhtkVarZzg.zzd());
                return;
            }
        }
        if (zzhtgVar instanceof zzhtf) {
            zzhunVar.zzb();
            Iterator it = zzhtgVar.zzf().iterator();
            while (it.hasNext()) {
                zza(zzhunVar, (zzhtg) it.next());
            }
            zzhunVar.zzc();
            return;
        }
        if (!(zzhtgVar instanceof zzhti)) {
            String strValueOf = String.valueOf(zzhtgVar.getClass());
            String.valueOf(strValueOf);
            throw new IllegalArgumentException("Couldn't write ".concat(String.valueOf(strValueOf)));
        }
        zzhunVar.zzd();
        for (Map.Entry entry : zzhtgVar.zze().zzb()) {
            zzhunVar.zzf((String) entry.getKey());
            zza(zzhunVar, (zzhtg) entry.getValue());
        }
        zzhunVar.zze();
    }
}
