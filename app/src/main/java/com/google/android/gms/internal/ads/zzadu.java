package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzadu {
    private final zzeg zza = new zzeg(10);

    private final boolean zzb(zzadb zzadbVar, int i) throws IOException {
        int i2;
        int i3 = 0;
        do {
            int i4 = i3 % 10;
            if (i4 == 0) {
                if (i3 != 0) {
                    zzeg zzegVar = this.zza;
                    System.arraycopy(zzegVar.zzi(), 10, zzegVar.zzi(), 0, 9);
                }
                i2 = 0;
            } else {
                i2 = i4;
            }
            int i5 = i3 != 0 ? 1 : 10;
            try {
                zzeg zzegVar2 = this.zza;
                int i6 = i4 + 10;
                zzadbVar.zzi(zzegVar2.zzi(), i6 - i5, i5);
                zzegVar2.zzh(i2);
                zzegVar2.zzf(i6);
                if (zzegVar2.zzq() == 4801587) {
                    return true;
                }
                if (zzadx.zza(zzegVar2.zzr()) != -1) {
                    return false;
                }
                if (i3 == 0) {
                    zzegVar2.zzc(20);
                }
                i3++;
            } catch (EOFException unused) {
            }
        } while (i3 <= i);
        return false;
    }

    public final zzap zza(zzadb zzadbVar, zzagm zzagmVar, int i) throws IOException {
        zzap zzapVarZza = null;
        int i2 = 0;
        while (zzb(zzadbVar, i)) {
            zzeg zzegVar = this.zza;
            int iZzg = zzegVar.zzg();
            zzegVar.zzk(6);
            int iZzG = zzegVar.zzG();
            int i3 = iZzG + 10;
            if (zzapVarZza == null) {
                byte[] bArr = new byte[i3];
                System.arraycopy(zzegVar.zzi(), iZzg, bArr, 0, 10);
                zzadbVar.zzi(bArr, 10, iZzG);
                zzapVarZza = zzagp.zza(bArr, i3, zzagmVar, new zzaga());
            } else {
                zzadbVar.zzk(iZzG);
            }
            i2 += i3;
        }
        zzadbVar.zzl();
        zzadbVar.zzk(i2);
        return zzapVarZza;
    }
}
