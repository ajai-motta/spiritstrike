package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Optional;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzasx {
    public final zzars zza;
    public final zzast zzb;
    public final zzasq zzc;
    public final zzasl zzd;

    public zzasx(zzars zzarsVar, zzast zzastVar, zzasl zzaslVar) {
        int[] iArr = {343945053, 300943123, 276960570, 1098387973, 1376531620, 1545514151, 271059426, 857490000, 454333378};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        this.zza = zzarsVar;
        this.zzb = zzastVar;
        this.zzd = zzaslVar;
        this.zzc = new zzasq((i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)) ^ (i8 % 454333378));
    }

    public final Optional zza() {
        zzarm zzarmVar;
        try {
            ArrayDeque arrayDeque = this.zzc.zza;
            if (arrayDeque.isEmpty()) {
                throw new zzasp();
            }
            zzasn zzasnVar = (zzasn) arrayDeque.pop();
            long j = zzasnVar.zza;
            long j2 = zzasnVar.zzb;
            long j3 = zzasnVar.zzc;
            zzast zzastVar = this.zzb;
            if (zzastVar.zzb < j2) {
                return Optional.of(zzarm.zzG);
            }
            this.zzd.zza(j);
            if (j3 == 0) {
                while (zzastVar.zzb > j2) {
                    zzastVar.zzc();
                }
            }
            return Optional.empty();
        } catch (zzasj e) {
            e = e;
            throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
        } catch (zzask e2) {
            e = e2;
            throw new AssertionError(zzase.zza("CEiv6BFfPnitUE+D"), e);
        } catch (zzasp unused) {
            zzarmVar = zzarm.zzw;
            return Optional.of(zzarmVar);
        } catch (zzasr unused2) {
            zzarmVar = zzarm.zzG;
            return Optional.of(zzarmVar);
        }
    }
}
