package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzamm implements zzamq {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final String zze;
    private final int zzf;
    private final String zzg;
    private String zzh;
    private zzaem zzi;
    private zzaem zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzr;
    private boolean zzs;
    private int zzu;
    private zzaem zzw;
    private long zzx;
    private final zzef zzc = new zzef(new byte[7], 7);
    private final zzeg zzd = new zzeg(Arrays.copyOf(zza, 10));
    private int zzp = -1;
    private int zzq = -1;
    private long zzt = C.TIME_UNSET;
    private long zzv = C.TIME_UNSET;

    public zzamm(boolean z, String str, int i, String str2) {
        this.zzb = z;
        this.zze = str;
        this.zzf = i;
        this.zzg = str2;
        zzi();
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzo = false;
        zzi();
    }

    private final boolean zzh(zzeg zzegVar, byte[] bArr, int i) {
        int iMin = Math.min(zzegVar.zzd(), i - this.zzl);
        zzegVar.zzm(bArr, this.zzl, iMin);
        int i2 = this.zzl + iMin;
        this.zzl = i2;
        return i2 == i;
    }

    private final void zzi() {
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = 256;
    }

    private final void zzj(zzaem zzaemVar, long j, int i, int i2) {
        this.zzk = 4;
        this.zzl = i;
        this.zzw = zzaemVar;
        this.zzx = j;
        this.zzu = i2;
    }

    private final void zzk() {
        this.zzk = 3;
        this.zzl = 0;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static final boolean zzm(zzeg zzegVar, byte[] bArr, int i) {
        if (zzegVar.zzd() < i) {
            return false;
        }
        zzegVar.zzm(bArr, 0, i);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzv = C.TIME_UNSET;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzh = zzaoeVar.zzc();
        zzaem zzaemVarZzu = zzaddVar.zzu(zzaoeVar.zzb(), 1);
        this.zzi = zzaemVarZzu;
        this.zzw = zzaemVarZzu;
        if (!this.zzb) {
            this.zzj = new zzacx();
            return;
        }
        zzaoeVar.zza();
        zzaem zzaemVarZzu2 = zzaddVar.zzu(zzaoeVar.zzb(), 5);
        this.zzj = zzaemVarZzu2;
        zzt zztVar = new zzt();
        zztVar.zza(zzaoeVar.zzc());
        zztVar.zzl(this.zzg);
        zztVar.zzm(MimeTypes.APPLICATION_ID3);
        zzaemVarZzu2.zzu(zztVar.zzM());
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzv = j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x025e, code lost:
    
        if (r17.zzo != false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0260, code lost:
    
        r17.zzk = 1;
        r17.zzl = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0266, code lost:
    
        zzk();
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0269, code lost:
    
        r18.zzh(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x024c, code lost:
    
        r17.zzr = (r14 & 8) >> 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0255, code lost:
    
        if (1 == ((r14 & 1) ^ 1)) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0257, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0259, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x025a, code lost:
    
        r17.zzn = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:144:0x024c A[EDGE_INSN: B:144:0x024c->B:95:0x024c BREAK  A[LOOP:1: B:49:0x01a7->B:170:0x01a7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0204  */
    @Override // com.google.android.gms.internal.ads.zzamq
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzd(com.google.android.gms.internal.ads.zzeg r18) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamm.zzd(com.google.android.gms.internal.ads.zzeg):void");
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
    }
}
