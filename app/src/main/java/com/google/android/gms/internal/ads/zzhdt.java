package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhdt extends zzhtn {
    public static final zzhtg zzb(zzhul zzhulVar) throws IOException {
        String strZzh;
        int iZzm = zzhulVar.zzm();
        zzhtg zzhtgVarZze = zze(zzhulVar, iZzm);
        if (zzhtgVarZze == null) {
            return zzd(zzhulVar, iZzm);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzhulVar.zzf()) {
                if (zzhtgVarZze instanceof zzhti) {
                    strZzh = zzhulVar.zzh();
                    if (!zzhdv.zza(strZzh)) {
                        throw new IOException("illegal characters in string");
                    }
                } else {
                    strZzh = null;
                }
                int iZzm2 = zzhulVar.zzm();
                zzhtg zzhtgVarZze2 = zze(zzhulVar, iZzm2);
                zzhtg zzhtgVarZzd = zzhtgVarZze2 == null ? zzd(zzhulVar, iZzm2) : zzhtgVarZze2;
                if (zzhtgVarZze instanceof zzhtf) {
                    ((zzhtf) zzhtgVarZze).zza(zzhtgVarZzd);
                } else {
                    zzhti zzhtiVar = (zzhti) zzhtgVarZze;
                    if (zzhtiVar.zzc(strZzh)) {
                        String.valueOf(strZzh);
                        throw new IOException("duplicate key: ".concat(String.valueOf(strZzh)));
                    }
                    zzhtiVar.zza(strZzh, zzhtgVarZzd);
                }
                if (zzhtgVarZze2 != null) {
                    arrayDeque.addLast(zzhtgVarZze);
                    if (arrayDeque.size() > 100) {
                        throw new IOException("too many recursions");
                    }
                    zzhtgVarZze = zzhtgVarZzd;
                } else {
                    continue;
                }
            } else {
                if (zzhtgVarZze instanceof zzhtf) {
                    zzhulVar.zzc();
                } else {
                    zzhulVar.zze();
                }
                if (arrayDeque.isEmpty()) {
                    return zzhtgVarZze;
                }
                zzhtgVarZze = (zzhtg) arrayDeque.removeLast();
            }
        }
    }

    private static final zzhtg zzd(zzhul zzhulVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 5) {
            String strZzi = zzhulVar.zzi();
            if (zzhdv.zza(strZzi)) {
                return new zzhtk(strZzi);
            }
            throw new IOException("illegal characters in string");
        }
        if (i2 == 6) {
            return new zzhtk(new zzhdu(zzhulVar.zzi()));
        }
        if (i2 == 7) {
            return new zzhtk(Boolean.valueOf(zzhulVar.zzj()));
        }
        if (i2 != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(zzhum.zza(i)));
        }
        zzhulVar.zzk();
        return zzhth.zza;
    }

    @Nullable
    private static final zzhtg zze(zzhul zzhulVar, int i) throws IOException {
        int i2 = i - 1;
        if (i2 == 0) {
            zzhulVar.zzb();
            return new zzhtf();
        }
        if (i2 != 2) {
            return null;
        }
        zzhulVar.zzd();
        return new zzhti();
    }

    @Override // com.google.android.gms.internal.ads.zzhtn
    public final /* bridge */ /* synthetic */ void zza(zzhun zzhunVar, Object obj) throws IOException {
        throw null;
    }
}
