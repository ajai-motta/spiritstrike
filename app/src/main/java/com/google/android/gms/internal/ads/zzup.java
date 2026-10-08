package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzup extends zzwx {
    private final boolean zzb;
    private final zzbe zzc;
    private final zzbd zzd;
    private zzun zze;
    private zzum zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzup(zzuw zzuwVar, boolean z) {
        boolean z2;
        super(zzuwVar);
        if (z) {
            zzuwVar.zzI();
            z2 = true;
        } else {
            z2 = false;
        }
        this.zzb = z2;
        this.zzc = new zzbe();
        this.zzd = new zzbd();
        zzuwVar.zzH();
        this.zze = zzun.zzp(zzuwVar.zzJ());
    }

    private final Object zzK(Object obj) {
        return (this.zze.zzs() == null || !obj.equals(zzun.zzc)) ? obj : this.zze.zzs();
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final boolean zzL(long j) {
        zzum zzumVar = this.zzf;
        int iZze = this.zze.zze(zzumVar.zza.zza);
        if (iZze == -1) {
            return false;
        }
        zzun zzunVar = this.zze;
        zzbd zzbdVar = this.zzd;
        zzunVar.zzd(iZze, zzbdVar, false);
        long j2 = zzbdVar.zzd;
        if (j2 != C.TIME_UNSET && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        zzumVar.zzo(j);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zztt, com.google.android.gms.internal.ads.zzuw
    public final void zzA(zzak zzakVar) {
        if (this.zzi) {
            this.zze = this.zze.zzr(new zzwt(this.zze.zzb, zzakVar));
        } else {
            this.zze = zzun.zzp(zzakVar);
        }
        this.zza.zzA(zzakVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    public final void zzB() {
        if (this.zzb) {
            return;
        }
        this.zzg = true;
        zzv(null, ((zzwx) this).zza);
    }

    @Override // com.google.android.gms.internal.ads.zzwx, com.google.android.gms.internal.ads.zzuw
    /* JADX INFO: renamed from: zzC, reason: merged with bridge method [inline-methods] */
    public final zzum zzG(zzuu zzuuVar, zzyv zzyvVar, long j) {
        zzum zzumVar = new zzum(zzuuVar, zzyvVar, j);
        zzumVar.zzr(this.zza);
        if (this.zzh) {
            zzumVar.zzt(zzuuVar.zza(zzK(zzuuVar.zza)));
        } else {
            this.zzf = zzumVar;
            if (!this.zzg) {
                this.zzg = true;
                zzv(null, ((zzwx) this).zza);
            }
        }
        return zzumVar;
    }

    @Override // com.google.android.gms.internal.ads.zzwx, com.google.android.gms.internal.ads.zzuw
    public final void zzD(zzus zzusVar) {
        ((zzum) zzusVar).zzu();
        if (zzusVar == this.zzf) {
            this.zzf = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005d  */
    @Override // com.google.android.gms.internal.ads.zzwx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzE(com.google.android.gms.internal.ads.zzbf r12) {
        /*
            r11 = this;
            boolean r0 = r11.zzh
            r1 = 0
            if (r0 == 0) goto L1a
            com.google.android.gms.internal.ads.zzun r0 = r11.zze
            com.google.android.gms.internal.ads.zzun r12 = r0.zzr(r12)
            r11.zze = r12
            com.google.android.gms.internal.ads.zzum r12 = r11.zzf
            if (r12 == 0) goto L97
            long r2 = r12.zzq()
            r11.zzL(r2)
            goto L97
        L1a:
            boolean r0 = r12.zzg()
            if (r0 == 0) goto L36
            boolean r0 = r11.zzi
            if (r0 == 0) goto L2b
            com.google.android.gms.internal.ads.zzun r0 = r11.zze
            com.google.android.gms.internal.ads.zzun r12 = r0.zzr(r12)
            goto L33
        L2b:
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzbe.zza
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzun.zzc
            com.google.android.gms.internal.ads.zzun r12 = com.google.android.gms.internal.ads.zzun.zzq(r12, r0, r2)
        L33:
            r11.zze = r12
            goto L97
        L36:
            com.google.android.gms.internal.ads.zzbe r3 = r11.zzc
            r0 = 0
            r4 = 0
            r12.zzb(r0, r3, r4)
            java.lang.Object r8 = r3.zzb
            com.google.android.gms.internal.ads.zzum r2 = r11.zzf
            if (r2 == 0) goto L5d
            long r6 = r2.zza()
            com.google.android.gms.internal.ads.zzun r9 = r11.zze
            com.google.android.gms.internal.ads.zzbd r10 = r11.zzd
            com.google.android.gms.internal.ads.zzuu r2 = r2.zza
            java.lang.Object r2 = r2.zza
            r9.zzo(r2, r10)
            com.google.android.gms.internal.ads.zzun r2 = r11.zze
            r2.zzb(r0, r3, r4)
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 == 0) goto L5d
            goto L5e
        L5d:
            r6 = r4
        L5e:
            com.google.android.gms.internal.ads.zzbd r4 = r11.zzd
            r5 = 0
            r2 = r12
            android.util.Pair r0 = r2.zzm(r3, r4, r5, r6)
            java.lang.Object r2 = r0.first
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r3 = r0.longValue()
            boolean r0 = r11.zzi
            if (r0 == 0) goto L7b
            com.google.android.gms.internal.ads.zzun r0 = r11.zze
            com.google.android.gms.internal.ads.zzun r12 = r0.zzr(r12)
            goto L7f
        L7b:
            com.google.android.gms.internal.ads.zzun r12 = com.google.android.gms.internal.ads.zzun.zzq(r12, r8, r2)
        L7f:
            r11.zze = r12
            com.google.android.gms.internal.ads.zzum r12 = r11.zzf
            if (r12 == 0) goto L97
            boolean r0 = r11.zzL(r3)
            if (r0 == 0) goto L97
            com.google.android.gms.internal.ads.zzuu r12 = r12.zza
            java.lang.Object r0 = r12.zza
            java.lang.Object r0 = r11.zzK(r0)
            com.google.android.gms.internal.ads.zzuu r1 = r12.zza(r0)
        L97:
            r12 = 1
            r11.zzi = r12
            r11.zzh = r12
            com.google.android.gms.internal.ads.zzun r12 = r11.zze
            r11.zze(r12)
            if (r1 == 0) goto Lae
            com.google.android.gms.internal.ads.zzum r12 = r11.zzf
            r12.getClass()
            r0 = r12
            com.google.android.gms.internal.ads.zzum r0 = (com.google.android.gms.internal.ads.zzum) r0
            r12.zzt(r1)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzup.zzE(com.google.android.gms.internal.ads.zzbf):void");
    }

    @Override // com.google.android.gms.internal.ads.zzwx
    protected final zzuu zzF(zzuu zzuuVar) {
        Object objZzs = this.zze.zzs();
        Object obj = zzuuVar.zza;
        if (objZzs != null && this.zze.zzs().equals(obj)) {
            obj = zzun.zzc;
        }
        return zzuuVar.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzuc, com.google.android.gms.internal.ads.zztt
    public final void zzd() {
        this.zzh = false;
        this.zzg = false;
        super.zzd();
    }

    public final zzbf zzz() {
        return this.zze;
    }
}
