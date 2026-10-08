package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzamz implements zzamq {
    private final zzant zza;
    private String zzb;
    private zzaem zzc;
    private zzamy zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzanh zzg = new zzanh(32, 128);
    private final zzanh zzh = new zzanh(33, 128);
    private final zzanh zzi = new zzanh(34, 128);
    private final zzanh zzj = new zzanh(39, 128);
    private final zzanh zzk = new zzanh(40, 128);
    private long zzm = C.TIME_UNSET;
    private final zzeg zzn = new zzeg();

    public zzamz(zzant zzantVar, String str) {
        this.zza = zzantVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(long j, int i, int i2, long j2) {
        this.zzd.zzb(j, i, i2, j2, this.zze);
        if (!this.zze) {
            this.zzg.zzc(i2);
            this.zzh.zzc(i2);
            this.zzi.zzc(i2);
        }
        this.zzj.zzc(i2);
        this.zzk.zzc(i2);
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzg(byte[] bArr, int i, int i2) {
        this.zzd.zzc(bArr, i, i2);
        if (!this.zze) {
            this.zzg.zzd(bArr, i, i2);
            this.zzh.zzd(bArr, i, i2);
            this.zzi.zzd(bArr, i, i2);
        }
        this.zzj.zzd(bArr, i, i2);
        this.zzk.zzd(bArr, i, i2);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private final void zzh(long j, int i, int i2, long j2) {
        this.zzd.zzd(j, i, this.zze);
        if (!this.zze) {
            zzanh zzanhVar = this.zzg;
            zzanhVar.zze(i2);
            zzanh zzanhVar2 = this.zzh;
            zzanhVar2.zze(i2);
            zzanh zzanhVar3 = this.zzi;
            zzanhVar3.zze(i2);
            if (zzanhVar.zzb() && zzanhVar2.zzb() && zzanhVar3.zzb()) {
                String str = this.zzb;
                int i3 = zzanhVar.zzb;
                byte[] bArr = new byte[zzanhVar2.zzb + i3 + zzanhVar3.zzb];
                System.arraycopy(zzanhVar.zza, 0, bArr, 0, i3);
                System.arraycopy(zzanhVar2.zza, 0, bArr, zzanhVar.zzb, zzanhVar2.zzb);
                System.arraycopy(zzanhVar3.zza, 0, bArr, zzanhVar.zzb + zzanhVar2.zzb, zzanhVar3.zzb);
                String strZzb = null;
                zzfg zzfgVarZzf = zzfm.zzf(zzanhVar2.zza, 3, zzanhVar2.zzb, null);
                zzfb zzfbVar = zzfgVarZzf.zzb;
                if (zzfbVar != null) {
                    int i4 = zzfbVar.zzf;
                    int[] iArr = zzfbVar.zze;
                    int i5 = zzfbVar.zzd;
                    strZzb = zzdd.zzb(zzfbVar.zza, zzfbVar.zzb, zzfbVar.zzc, i5, iArr, i4);
                }
                zzt zztVar = new zzt();
                zztVar.zza(str);
                zztVar.zzl(MimeTypes.VIDEO_MP2T);
                zztVar.zzm("video/hevc");
                zztVar.zzj(strZzb);
                zztVar.zzt(zzfgVarZzf.zze);
                zztVar.zzu(zzfgVarZzf.zzf);
                zztVar.zzv(zzfgVarZzf.zzg);
                zztVar.zzw(zzfgVarZzf.zzh);
                zzh zzhVar = new zzh();
                zzhVar.zza(zzfgVarZzf.zzk);
                zzhVar.zzb(zzfgVarZzf.zzl);
                zzhVar.zzc(zzfgVarZzf.zzm);
                zzhVar.zze(zzfgVarZzf.zzc + 8);
                zzhVar.zzf(zzfgVarZzf.zzd + 8);
                zztVar.zzC(zzhVar.zzg());
                zztVar.zzz(zzfgVarZzf.zzi);
                zztVar.zzo(zzfgVarZzf.zzj);
                zztVar.zzD(zzfgVarZzf.zza + 1);
                zztVar.zzp(Collections.singletonList(bArr));
                zzv zzvVarZzM = zztVar.zzM();
                this.zzc.zzu(zzvVarZzM);
                int i6 = zzvVarZzM.zzq;
                zzgmd.zzh(i6 != -1);
                this.zza.zzb(i6);
                this.zze = true;
            }
        }
        zzanh zzanhVar4 = this.zzj;
        if (zzanhVar4.zze(i2)) {
            int iZza = zzfm.zza(zzanhVar4.zza, zzanhVar4.zzb);
            zzeg zzegVar = this.zzn;
            zzegVar.zzb(zzanhVar4.zza, iZza);
            zzegVar.zzk(5);
            this.zza.zzc(j2, zzegVar);
        }
        zzanh zzanhVar5 = this.zzk;
        if (zzanhVar5.zze(i2)) {
            int iZza2 = zzfm.zza(zzanhVar5.zza, zzanhVar5.zzb);
            zzeg zzegVar2 = this.zzn;
            zzegVar2.zzb(zzanhVar5.zza, iZza2);
            zzegVar2.zzk(5);
            this.zza.zzc(j2, zzegVar2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzl = 0L;
        this.zzm = C.TIME_UNSET;
        zzfm.zzi(this.zzf);
        this.zzg.zza();
        this.zzh.zza();
        this.zzi.zza();
        this.zzj.zza();
        this.zzk.zza();
        this.zza.zze();
        zzamy zzamyVar = this.zzd;
        if (zzamyVar != null) {
            zzamyVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzb = zzaoeVar.zzc();
        zzaem zzaemVarZzu = zzaddVar.zzu(zzaoeVar.zzb(), 2);
        this.zzc = zzaemVarZzu;
        this.zzd = new zzamy(zzaemVarZzu);
        this.zza.zza(zzaddVar, zzaoeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzm = j;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    @Override // com.google.android.gms.internal.ads.zzamq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(com.google.android.gms.internal.ads.zzeg r18) {
        /*
            r17 = this;
            r7 = r17
            com.google.android.gms.internal.ads.zzaem r0 = r7.zzc
            r0.getClass()
            java.lang.String r0 = com.google.android.gms.internal.ads.zzep.zza
        L9:
            int r0 = r18.zzd()
            if (r0 <= 0) goto L7b
            int r0 = r18.zzg()
            int r8 = r18.zze()
            byte[] r9 = r18.zzi()
            long r1 = r7.zzl
            int r3 = r18.zzd()
            long r3 = (long) r3
            long r1 = r1 + r3
            r7.zzl = r1
            com.google.android.gms.internal.ads.zzaem r1 = r7.zzc
            int r2 = r18.zzd()
            r10 = r18
            r1.zzz(r10, r2)
        L30:
            if (r0 >= r8) goto L9
            boolean[] r1 = r7.zzf
            int r1 = com.google.android.gms.internal.ads.zzfm.zzh(r9, r0, r8, r1)
            if (r1 == r8) goto L78
            int r2 = r1 + 3
            r2 = r9[r2]
            r2 = r2 & 126(0x7e, float:1.77E-43)
            r3 = 3
            if (r1 <= 0) goto L4d
            int r4 = r1 + (-1)
            r5 = r9[r4]
            if (r5 != 0) goto L4d
            r3 = 4
            r12 = r3
            r11 = r4
            goto L4f
        L4d:
            r11 = r1
            r12 = r3
        L4f:
            int r1 = r11 - r0
            if (r1 <= 0) goto L56
            r7.zzg(r9, r0, r11)
        L56:
            int r13 = r8 - r11
            long r3 = r7.zzl
            long r5 = (long) r13
            long r14 = r3 - r5
            if (r1 >= 0) goto L61
            int r0 = -r1
            goto L62
        L61:
            r0 = 0
        L62:
            r4 = r0
            int r16 = r2 >> 1
            long r5 = r7.zzm
            r0 = r17
            r1 = r14
            r3 = r13
            r0.zzh(r1, r3, r4, r5)
            long r5 = r7.zzm
            r4 = r16
            r0.zzf(r1, r3, r4, r5)
            int r0 = r11 + r12
            goto L30
        L78:
            r7.zzg(r9, r0, r8)
        L7b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamz.zzd(com.google.android.gms.internal.ads.zzeg):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
        this.zzc.getClass();
        String str = zzep.zza;
        if (z) {
            this.zza.zzd();
            zzh(this.zzl, 0, 0, this.zzm);
            zzf(this.zzl, 0, 48, this.zzm);
        }
    }
}
