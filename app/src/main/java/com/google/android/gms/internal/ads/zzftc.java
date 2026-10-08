package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.common.util.Hex;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzftc {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final zzbaa zzd;

    public zzftc(Context context, zzbaa zzbaaVar) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzftd.zzd(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzftd.zzd(dir2, true);
        this.zza = dir2;
        this.zzd = zzbaaVar;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd.zza()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        int iZza = this.zzd.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 6);
        sb.append("FBAMTD");
        sb.append(iZza);
        return sb.toString();
    }

    private final String zzf() {
        int iZza = this.zzd.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 6);
        sb.append("LATMTD");
        sb.append(iZza);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(com.google.android.gms.internal.ads.zzbac r9, com.google.android.gms.internal.ads.zzfti r10) {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzftc.zza(com.google.android.gms.internal.ads.zzbac, com.google.android.gms.internal.ads.zzfti):boolean");
    }

    public final zzftb zzb(int i) {
        zzbai zzbaiVarZzc = zzc(1);
        if (zzbaiVarZzc == null) {
            return null;
        }
        String strZza = zzbaiVarZzc.zza();
        File fileZza = zzftd.zza(strZza, "pcam.jar", zzd());
        if (!fileZza.exists()) {
            fileZza = zzftd.zza(strZza, "pcam", zzd());
        }
        return new zzftb(zzbaiVarZzc, fileZza, zzftd.zza(strZza, "pcbc", zzd()), zzftd.zza(strZza, "pcopt", zzd()));
    }

    final zzbai zzc(int i) {
        String string = i == 1 ? this.zzc.getString(zzf(), null) : this.zzc.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzhvi zzhviVar = zzhvi.zzb;
            zzbai zzbaiVarZzg = zzbai.zzg(zzhvi.zzr(bArrStringToBytes, 0, bArrStringToBytes.length));
            String strZza = zzbaiVarZzg.zza();
            File fileZza = zzftd.zza(strZza, "pcam.jar", zzd());
            if (!fileZza.exists()) {
                fileZza = zzftd.zza(strZza, "pcam", zzd());
            }
            File fileZza2 = zzftd.zza(strZza, "pcbc", zzd());
            if (fileZza.exists()) {
                if (fileZza2.exists()) {
                    return zzbaiVarZzg;
                }
            }
        } catch (zzhxd unused) {
        }
        return null;
    }
}
