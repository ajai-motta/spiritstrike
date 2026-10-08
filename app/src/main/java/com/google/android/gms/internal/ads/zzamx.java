package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzamx implements zzamq {
    private final zzant zza;
    private long zzf;
    private String zzh;
    private zzaem zzi;
    private zzamw zzj;
    private boolean zzk;
    private boolean zzm;
    private final String zzb = MimeTypes.VIDEO_MP2T;
    private final boolean[] zzg = new boolean[3];
    private final zzanh zzc = new zzanh(7, 128);
    private final zzanh zzd = new zzanh(8, 128);
    private final zzanh zze = new zzanh(6, 128);
    private long zzl = C.TIME_UNSET;
    private final zzeg zzn = new zzeg();

    public zzamx(zzant zzantVar, boolean z, boolean z2, String str) {
        this.zza = zzantVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(long j, int i, long j2) {
        if (!this.zzk) {
            this.zzc.zzc(i);
            this.zzd.zzc(i);
        }
        this.zze.zzc(i);
        this.zzj.zzd(j, i, j2, this.zzm);
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzg(byte[] bArr, int i, int i2) {
        if (!this.zzk) {
            this.zzc.zzd(bArr, i, i2);
            this.zzd.zzd(bArr, i, i2);
        }
        this.zze.zzd(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzf = 0L;
        this.zzm = false;
        this.zzl = C.TIME_UNSET;
        zzfm.zzi(this.zzg);
        this.zzc.zza();
        this.zzd.zza();
        this.zze.zza();
        this.zza.zze();
        zzamw zzamwVar = this.zzj;
        if (zzamwVar != null) {
            zzamwVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzh = zzaoeVar.zzc();
        zzaem zzaemVarZzu = zzaddVar.zzu(zzaoeVar.zzb(), 2);
        this.zzi = zzaemVarZzu;
        this.zzj = new zzamw(zzaemVarZzu, false, false);
        this.zza.zza(zzaddVar, zzaoeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzl = j;
        int i2 = i & 2;
        this.zzm = (i2 != 0) | this.zzm;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    @Override // com.google.android.gms.internal.ads.zzamq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(com.google.android.gms.internal.ads.zzeg r16) {
        /*
            r15 = this;
            r7 = r15
            com.google.android.gms.internal.ads.zzaem r0 = r7.zzi
            r0.getClass()
            java.lang.String r0 = com.google.android.gms.internal.ads.zzep.zza
            int r0 = r16.zzg()
            int r8 = r16.zze()
            byte[] r9 = r16.zzi()
            long r1 = r7.zzf
            int r3 = r16.zzd()
            long r3 = (long) r3
            long r1 = r1 + r3
            r7.zzf = r1
            com.google.android.gms.internal.ads.zzaem r1 = r7.zzi
            int r2 = r16.zzd()
            r3 = r16
            r1.zzz(r3, r2)
        L29:
            boolean[] r1 = r7.zzg
            int r1 = com.google.android.gms.internal.ads.zzfm.zzh(r9, r0, r8, r1)
            if (r1 == r8) goto L6a
            int r2 = r1 + 3
            r2 = r9[r2]
            r10 = r2 & 31
            r2 = 3
            if (r1 <= 0) goto L44
            int r3 = r1 + (-1)
            r4 = r9[r3]
            if (r4 != 0) goto L44
            r2 = 4
            r12 = r2
            r11 = r3
            goto L46
        L44:
            r11 = r1
            r12 = r2
        L46:
            int r1 = r11 - r0
            if (r1 <= 0) goto L4d
            r15.zzg(r9, r0, r11)
        L4d:
            int r3 = r8 - r11
            long r4 = r7.zzf
            long r13 = (long) r3
            long r13 = r4 - r13
            if (r1 >= 0) goto L58
            int r0 = -r1
            goto L59
        L58:
            r0 = 0
        L59:
            r4 = r0
            long r5 = r7.zzl
            r0 = r15
            r1 = r13
            r0.zzh(r1, r3, r4, r5)
            long r4 = r7.zzl
            r3 = r10
            r0.zzf(r1, r3, r4)
            int r0 = r11 + r12
            goto L29
        L6a:
            r15.zzg(r9, r0, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamx.zzd(com.google.android.gms.internal.ads.zzeg):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
        this.zzi.getClass();
        String str = zzep.zza;
        if (z) {
            this.zza.zzd();
            zzh(this.zzf, 0, 0, this.zzl);
            zzf(this.zzf, 9, this.zzl);
            zzh(this.zzf, 0, 0, this.zzl);
        }
    }

    @RequiresNonNull({"output", "sampleReader"})
    private final void zzh(long j, int i, int i2, long j2) {
        if (!this.zzk) {
            zzanh zzanhVar = this.zzc;
            zzanhVar.zze(i2);
            zzanh zzanhVar2 = this.zzd;
            zzanhVar2.zze(i2);
            if (this.zzk) {
                if (zzanhVar.zzb()) {
                    zzfl zzflVarZzd = zzfm.zzd(zzanhVar.zza, 4, zzanhVar.zzb);
                    this.zza.zzb(zzflVarZzd.zzm);
                    this.zzj.zza(zzflVarZzd);
                    zzanhVar.zza();
                } else if (zzanhVar2.zzb()) {
                    this.zzj.zzb(zzfm.zzg(zzanhVar2.zza, 4, zzanhVar2.zzb));
                    zzanhVar2.zza();
                }
            } else if (zzanhVar.zzb() && zzanhVar2.zzb()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(Arrays.copyOf(zzanhVar.zza, zzanhVar.zzb));
                arrayList.add(Arrays.copyOf(zzanhVar2.zza, zzanhVar2.zzb));
                zzfl zzflVarZzd2 = zzfm.zzd(zzanhVar.zza, 4, zzanhVar.zzb);
                zzfk zzfkVarZzg = zzfm.zzg(zzanhVar2.zza, 4, zzanhVar2.zzb);
                String strZza = zzdd.zza(zzflVarZzd2.zza, zzflVarZzd2.zzb, zzflVarZzd2.zzc);
                zzaem zzaemVar = this.zzi;
                zzt zztVar = new zzt();
                zztVar.zza(this.zzh);
                zztVar.zzl(this.zzb);
                zztVar.zzm("video/avc");
                zztVar.zzj(strZza);
                zztVar.zzt(zzflVarZzd2.zze);
                zztVar.zzu(zzflVarZzd2.zzf);
                zzh zzhVar = new zzh();
                zzhVar.zza(zzflVarZzd2.zzj);
                zzhVar.zzb(zzflVarZzd2.zzk);
                zzhVar.zzc(zzflVarZzd2.zzl);
                zzhVar.zze(zzflVarZzd2.zzh + 8);
                zzhVar.zzf(zzflVarZzd2.zzi + 8);
                zztVar.zzC(zzhVar.zzg());
                zztVar.zzz(zzflVarZzd2.zzg);
                zztVar.zzp(arrayList);
                int i3 = zzflVarZzd2.zzm;
                zztVar.zzo(i3);
                zzaemVar.zzu(zztVar.zzM());
                this.zzk = true;
                this.zza.zzb(i3);
                this.zzj.zza(zzflVarZzd2);
                this.zzj.zzb(zzfkVarZzg);
                zzanhVar.zza();
                zzanhVar2.zza();
            }
        }
        zzanh zzanhVar3 = this.zze;
        if (zzanhVar3.zze(i2)) {
            int iZza = zzfm.zza(zzanhVar3.zza, zzanhVar3.zzb);
            zzeg zzegVar = this.zzn;
            zzegVar.zzb(zzanhVar3.zza, iZza);
            zzegVar.zzh(4);
            this.zza.zzc(j2, zzegVar);
        }
        if (this.zzj.zze(j, i, this.zzk)) {
            this.zzm = false;
        }
    }
}
