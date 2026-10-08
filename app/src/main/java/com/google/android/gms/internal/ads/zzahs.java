package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.gms.internal.ads.zzada;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzahs implements zzada {
    public static final /* synthetic */ int zza = 0;
    private final zzeg zzb;
    private final zzadw zzc;
    private final zzads zzd;
    private final zzadu zze;
    private final zzaem zzf;
    private zzadd zzg;
    private zzaem zzh;
    private zzaem zzi;
    private int zzj;
    private zzap zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private int zzp;
    private zzahu zzq;
    private boolean zzr;

    static {
        int i = zzahq.zza;
    }

    public zzahs() {
        throw null;
    }

    public zzahs(int i) {
        this.zzb = new zzeg(10);
        this.zzc = new zzadw();
        this.zzd = new zzads();
        this.zzl = C.TIME_UNSET;
        this.zze = new zzadu();
        zzacx zzacxVar = new zzacx();
        this.zzf = zzacxVar;
        this.zzi = zzacxVar;
        this.zzo = -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0220  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput", "realTrackOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int zzh(com.google.android.gms.internal.ads.zzadb r36) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 747
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahs.zzh(com.google.android.gms.internal.ads.zzadb):int");
    }

    private final long zzi(long j) {
        return this.zzl + ((j * 1000000) / ((long) this.zzc.zzd));
    }

    private final boolean zzj(zzadb zzadbVar, boolean z) throws IOException {
        int iZzm;
        int i;
        int iZza;
        zzadbVar.zzl();
        long jZzn = zzadbVar.zzn();
        int i2 = true != z ? 131072 : 32768;
        if (jZzn == 0) {
            zzap zzapVarZza = this.zze.zza(zzadbVar, null, i2);
            this.zzk = zzapVarZza;
            if (zzapVarZza != null) {
                this.zzd.zza(zzapVarZza);
            }
            iZzm = (int) zzadbVar.zzm();
            if (!z) {
                zzadbVar.zzf(iZzm);
            }
            i = 0;
        } else {
            iZzm = 0;
            i = 0;
        }
        int i3 = i;
        int i4 = i3;
        while (true) {
            if (!zzk(zzadbVar)) {
                zzeg zzegVar = this.zzb;
                zzegVar.zzh(0);
                int iZzB = zzegVar.zzB();
                if ((i == 0 || zzm(iZzB, i)) && (iZza = zzadx.zza(iZzB)) != -1) {
                    i3++;
                    if (i3 != 1) {
                        if (i3 == 4) {
                            break;
                        }
                    } else {
                        this.zzc.zza(iZzB);
                        i = iZzB;
                    }
                    zzadbVar.zzk(iZza - 4);
                } else {
                    int i5 = i4 + 1;
                    if (i4 == i2) {
                        if (z) {
                            return false;
                        }
                        zzl();
                        throw new EOFException();
                    }
                    if (z) {
                        zzadbVar.zzl();
                        zzadbVar.zzk(iZzm + i5);
                    } else {
                        zzadbVar.zzf(1);
                    }
                    i3 = 0;
                    i4 = i5;
                    i = 0;
                }
            } else if (i3 <= 0) {
                zzl();
                throw new EOFException();
            }
        }
        if (z) {
            zzadbVar.zzf(iZzm + i4);
        } else {
            zzadbVar.zzl();
        }
        this.zzj = i;
        return true;
    }

    private final boolean zzk(zzadb zzadbVar) throws IOException {
        zzahu zzahuVar = this.zzq;
        if (zzahuVar != null) {
            long jZzf = zzahuVar.zzf();
            if (jZzf != -1 && zzadbVar.zzm() > jZzf - 4) {
                return true;
            }
        }
        try {
            return !zzadbVar.zzh(this.zzb.zzi(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final void zzl() {
        zzahu zzahuVar = this.zzq;
        if ((zzahuVar instanceof zzahn) && zzahuVar.zzb()) {
            long j = this.zzo;
            if (j == -1 || j == this.zzq.zzf()) {
                return;
            }
            this.zzq = ((zzahn) this.zzq).zzh(this.zzo);
            zzadd zzaddVar = this.zzg;
            zzaddVar.getClass();
            zzaddVar.zzw(this.zzq);
            this.zzh.getClass();
            this.zzq.zza();
        }
    }

    private static boolean zzm(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        return zzj(zzadbVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ List zzb() {
        return zzgpe.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zzg = zzaddVar;
        zzaem zzaemVarZzu = zzaddVar.zzu(0, 1);
        this.zzh = zzaemVarZzu;
        this.zzi = zzaemVarZzu;
        this.zzg.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        this.zzh.getClass();
        String str = zzep.zza;
        int iZzh = zzh(zzadbVar);
        if (iZzh == -1 && (this.zzq instanceof zzaho)) {
            if (this.zzq.zza() != zzi(this.zzm)) {
                throw null;
            }
        }
        return iZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        this.zzj = 0;
        this.zzl = C.TIME_UNSET;
        this.zzm = 0L;
        this.zzp = 0;
        zzahu zzahuVar = this.zzq;
        if (zzahuVar instanceof zzaho) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ zzada zzf() {
        return zzada.CC.$default$zzf(this);
    }

    public final void zzg() {
        this.zzr = true;
    }
}
