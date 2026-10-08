package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zztx implements zzwk {
    public final zzwk zza;
    final /* synthetic */ zzty zzb;
    private boolean zzc;

    public zztx(zzty zztyVar, zzwk zzwkVar) {
        Objects.requireNonNull(zztyVar);
        this.zzb = zztyVar;
        this.zza = zzwkVar;
    }

    public final void zza() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final boolean zzb() {
        return !this.zzb.zzo() && this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003c  */
    @Override // com.google.android.gms.internal.ads.zzwk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzkj r12, com.google.android.gms.internal.ads.zzhh r13, int r14) {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzty r0 = r11.zzb
            boolean r1 = r0.zzo()
            r2 = -3
            if (r1 == 0) goto La
            return r2
        La:
            boolean r1 = r11.zzc
            r3 = 4
            r4 = -4
            if (r1 == 0) goto L14
            r13.zzg(r3)
            return r4
        L14:
            long r5 = r0.zzi()
            com.google.android.gms.internal.ads.zzwk r1 = r11.zza
            int r14 = r1.zzd(r12, r13, r14)
            r1 = -5
            r7 = -9223372036854775808
            if (r14 != r1) goto L4f
            com.google.android.gms.internal.ads.zzv r13 = r12.zzb
            r13.getClass()
            r14 = r13
            com.google.android.gms.internal.ads.zzv r14 = (com.google.android.gms.internal.ads.zzv) r14
            int r14 = r13.zzJ
            r2 = 0
            if (r14 != 0) goto L35
            int r14 = r13.zzK
            if (r14 == 0) goto L4e
            r14 = r2
        L35:
            long r3 = r0.zzb
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 == 0) goto L3c
            goto L3e
        L3c:
            int r2 = r13.zzK
        L3e:
            com.google.android.gms.internal.ads.zzt r13 = r13.zza()
            r13.zzH(r14)
            r13.zzI(r2)
            com.google.android.gms.internal.ads.zzv r13 = r13.zzM()
            r12.zzb = r13
        L4e:
            return r1
        L4f:
            long r0 = r0.zzb
            int r12 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r12 == 0) goto L71
            if (r14 != r4) goto L5d
            long r9 = r13.zze
            int r12 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r12 >= 0) goto L67
        L5d:
            if (r14 != r2) goto L71
            int r12 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r12 != 0) goto L71
            boolean r12 = r13.zzd
            if (r12 != 0) goto L71
        L67:
            r13.zza()
            r13.zzg(r3)
            r12 = 1
            r11.zzc = r12
            return r4
        L71:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztx.zzd(com.google.android.gms.internal.ads.zzkj, com.google.android.gms.internal.ads.zzhh, int):int");
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final int zze(long j) {
        if (this.zzb.zzo()) {
            return -3;
        }
        return this.zza.zze(j);
    }
}
