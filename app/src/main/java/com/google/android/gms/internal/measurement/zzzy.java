package com.google.android.gms.internal.measurement;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzzy extends zzaaa {
    private final zzzj zza;
    private final zzzj zzb;
    private final int[] zzc;
    private final int zzd;

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    /* synthetic */ zzzy(com.google.android.gms.internal.measurement.zzzj r9, com.google.android.gms.internal.measurement.zzzj r10, byte[] r11) {
        /*
            r8 = this;
            r11 = 0
            r8.<init>(r11)
            r11 = r9
            com.google.android.gms.internal.measurement.zzzj r11 = (com.google.android.gms.internal.measurement.zzzj) r11
            r8.zza = r9
            r9 = r10
            com.google.android.gms.internal.measurement.zzzj r9 = (com.google.android.gms.internal.measurement.zzzj) r9
            r8.zzb = r10
            int r9 = r10.zza()
            r10 = 28
            r11 = 0
            r0 = 1
            if (r9 > r10) goto L1a
            r10 = r0
            goto L1b
        L1a:
            r10 = r11
        L1b:
            java.lang.String r1 = "metadata size too large"
            com.google.android.gms.internal.measurement.zzabr.zzb(r10, r1)
            int[] r9 = new int[r9]
            r8.zzc = r9
            r1 = 0
            r10 = r11
            r3 = r10
        L28:
            int r4 = r9.length
            if (r10 >= r4) goto L6c
            com.google.android.gms.internal.measurement.zzyl r4 = r8.zzd(r10)
            long r5 = r4.zzi()
            long r5 = r5 | r1
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 != 0) goto L63
            r1 = r11
        L39:
            r2 = -1
            if (r1 >= r3) goto L4e
            r7 = r9[r1]
            r7 = r7 & 31
            com.google.android.gms.internal.measurement.zzyl r7 = r8.zzd(r7)
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L4b
            goto L4f
        L4b:
            int r1 = r1 + 1
            goto L39
        L4e:
            r1 = r2
        L4f:
            if (r1 == r2) goto L63
            boolean r2 = r4.zzf()
            if (r2 == 0) goto L5f
            r2 = r9[r1]
            int r4 = r10 + 4
            int r4 = r0 << r4
            r2 = r2 | r4
            goto L60
        L5f:
            r2 = r10
        L60:
            r9[r1] = r2
            goto L68
        L63:
            int r1 = r3 + 1
            r9[r3] = r10
            r3 = r1
        L68:
            int r10 = r10 + 1
            r1 = r5
            goto L28
        L6c:
            r8.zzd = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzzy.<init>(com.google.android.gms.internal.measurement.zzzj, com.google.android.gms.internal.measurement.zzzj, byte[]):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzyl zzd(int i) {
        zzzj zzzjVar = this.zza;
        int iZza = zzzjVar.zza();
        if (i >= iZza) {
            zzzjVar = this.zzb;
            i -= iZza;
        }
        return zzzjVar.zzb(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final Object zze(int i) {
        zzzj zzzjVar = this.zza;
        int iZza = zzzjVar.zza();
        if (i >= iZza) {
            zzzjVar = this.zzb;
            i -= iZza;
        }
        return zzzjVar.zzc(i);
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final void zza(zzzq zzzqVar, Object obj) {
        for (int i = 0; i < this.zzd; i++) {
            int i2 = this.zzc[i];
            zzyl zzylVarZzd = zzd(i2 & 31);
            if (zzylVarZzd.zzf()) {
                zzzqVar.zzb(zzylVarZzd, new zzzx(this, zzylVarZzd, i2, null), obj);
            } else {
                zzzqVar.zza(zzylVarZzd, zzylVarZzd.zze(zze(i2)), obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final int zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzaaa
    public final Set zzc() {
        return new zzzw(this);
    }

    final /* synthetic */ int[] zzf() {
        return this.zzc;
    }

    final /* synthetic */ int zzg() {
        return this.zzd;
    }
}
