package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzvy implements zzus, zzadd, zzzf, zzzk, zzwi {
    private static final Map zzb;
    private static final zzv zzc;
    private zzvx zzA;
    private zzaed zzB;
    private long zzC;
    private boolean zzD;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private int zzI;
    private boolean zzJ;
    private long zzK;
    private boolean zzM;
    private int zzN;
    private boolean zzO;
    private boolean zzP;
    private final Uri zzd;
    private final zzgb zze;
    private final zzrz zzf;
    private final zzve zzg;
    private final zzru zzh;
    private final zzvq zzi;
    private final zzyv zzj;
    private final long zzk;
    private final long zzl;
    private final zzvn zzn;
    private zzur zzs;
    private zzagf zzt;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;
    private final zzzn zzm = new zzzn("ProgressiveMediaPeriod");
    private final zzdf zzo = new zzdf(zzdc.zza);
    private final Runnable zzp = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvu
        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.zza.zzD();
        }
    };
    private final Runnable zzq = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvr
        @Override // java.lang.Runnable
        public final /* synthetic */ void run() {
            this.zza.zzE();
        }
    };
    private final Handler zzr = zzep.zzc(null);
    private zzvw[] zzv = new zzvw[0];
    private zzwj[] zzu = new zzwj[0];
    private long zzL = C.TIME_UNSET;
    private int zzE = 1;

    static {
        HashMap map = new HashMap();
        map.put(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_NAME, "1");
        zzb = Collections.unmodifiableMap(map);
        zzt zztVar = new zzt();
        zztVar.zza("icy");
        zztVar.zzm(MimeTypes.APPLICATION_ICY);
        zzc = zztVar.zzM();
    }

    public zzvy(Uri uri, zzgb zzgbVar, zzvn zzvnVar, zzrz zzrzVar, zzru zzruVar, zzze zzzeVar, zzve zzveVar, zzvq zzvqVar, zzyv zzyvVar, String str, int i, int i2, zzv zzvVar, long j, zzzt zzztVar) {
        this.zzd = uri;
        this.zze = zzgbVar;
        this.zzf = zzrzVar;
        this.zzh = zzruVar;
        this.zzg = zzveVar;
        this.zzi = zzvqVar;
        this.zzj = zzyvVar;
        this.zzk = i;
        this.zzn = zzvnVar;
        this.zzl = j;
    }

    private final void zzR(int i) {
        zzaa();
        zzvx zzvxVar = this.zzA;
        boolean[] zArr = zzvxVar.zzd;
        if (zArr[i]) {
            return;
        }
        zzv zzvVarZza = zzvxVar.zza.zza(i).zza(0);
        this.zzg.zzh(new zzuq(1, zzas.zzg(zzvVarZza.zzo), zzvVarZza, 0, null, zzep.zzp(this.zzK), C.TIME_UNSET));
        zArr[i] = true;
    }

    private final void zzS(int i) {
        zzaa();
        if (this.zzM) {
            if ((!this.zzy || this.zzA.zzb[i]) && !this.zzu[i].zzl(false)) {
                this.zzL = 0L;
                this.zzM = false;
                this.zzG = true;
                this.zzK = 0L;
                this.zzN = 0;
                for (zzwj zzwjVar : this.zzu) {
                    zzwjVar.zzb(false);
                }
                zzur zzurVar = this.zzs;
                zzurVar.getClass();
                zzurVar.zzs(this);
            }
        }
    }

    private final boolean zzT() {
        return this.zzG || zzZ();
    }

    private final zzaem zzU(zzvw zzvwVar) {
        int length = this.zzu.length;
        for (int i = 0; i < length; i++) {
            if (zzvwVar.equals(this.zzv[i])) {
                return this.zzu[i];
            }
        }
        if (this.zzw) {
            int i2 = zzvwVar.zza;
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 55);
            sb.append("Extractor added new track (id=");
            sb.append(i2);
            sb.append(") after finishing tracks.");
            zzdt.zzc("ProgressiveMediaPeriod", sb.toString());
            return new zzacx();
        }
        zzwj zzwjVar = new zzwj(this.zzj, this.zzf, this.zzh);
        zzwjVar.zzt(this);
        int i3 = length + 1;
        zzvw[] zzvwVarArr = (zzvw[]) Arrays.copyOf(this.zzv, i3);
        zzvwVarArr[length] = zzvwVar;
        String str = zzep.zza;
        this.zzv = zzvwVarArr;
        zzwj[] zzwjVarArr = (zzwj[]) Arrays.copyOf(this.zzu, i3);
        zzwjVarArr[length] = zzwjVar;
        this.zzu = zzwjVarArr;
        return zzwjVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzV, reason: merged with bridge method [inline-methods] */
    public final void zzD() {
        int i;
        if (this.zzP || this.zzx || !this.zzw || this.zzB == null) {
            return;
        }
        for (zzwj zzwjVar : this.zzu) {
            if (zzwjVar.zzi() == null) {
                return;
            }
        }
        this.zzo.zzb();
        int length = this.zzu.length;
        zzbg[] zzbgVarArr = new zzbg[length];
        boolean[] zArr = new boolean[length];
        for (int i2 = 0; i2 < length; i2++) {
            zzv zzvVarZzi = this.zzu[i2].zzi();
            zzvVarZzi.getClass();
            String str = zzvVarZzi.zzo;
            boolean zZza = zzas.zza(str);
            boolean z = zZza || zzas.zzb(str);
            zArr[i2] = z;
            this.zzy = z | this.zzy;
            this.zzz = this.zzl != C.TIME_UNSET && length == 1 && zzas.zzc(str);
            zzagf zzagfVar = this.zzt;
            if (zzagfVar != null) {
                if (zZza || this.zzv[i2].zzb) {
                    zzap zzapVar = zzvVarZzi.zzl;
                    zzap zzapVar2 = zzapVar == null ? new zzap(C.TIME_UNSET, zzagfVar) : zzapVar.zzg(zzagfVar);
                    zzt zztVarZza = zzvVarZzi.zza();
                    zztVarZza.zzk(zzapVar2);
                    zzvVarZzi = zztVarZza.zzM();
                }
                if (zZza && zzvVarZzi.zzh == -1 && zzvVarZzi.zzi == -1 && (i = zzagfVar.zza) != -1) {
                    zzt zztVarZza2 = zzvVarZzi.zza();
                    zztVarZza2.zzh(i);
                    zzvVarZzi = zztVarZza2.zzM();
                }
            }
            zzv zzvVarZzb = zzvVarZzi.zzb(this.zzf.zzb(zzvVarZzi));
            zzbgVarArr[i2] = new zzbg(Integer.toString(i2), zzvVarZzb);
            this.zzH = zzvVarZzb.zzu | this.zzH;
        }
        this.zzA = new zzvx(new zzwv(zzbgVarArr), zArr);
        if (this.zzz && this.zzC == C.TIME_UNSET) {
            this.zzC = this.zzl;
            this.zzB = new zzvo(this, this.zzB);
        }
        this.zzi.zzb(this.zzC, this.zzB, this.zzD);
        this.zzx = true;
        zzur zzurVar = this.zzs;
        zzurVar.getClass();
        zzurVar.zzp(this);
    }

    private final void zzW() {
        zzvp zzvpVar = new zzvp(this, this.zzd, this.zze, this.zzn, this, this.zzo);
        if (this.zzx) {
            zzgmd.zzh(zzZ());
            long j = this.zzC;
            if (j != C.TIME_UNSET && this.zzL > j) {
                this.zzO = true;
                this.zzL = C.TIME_UNSET;
                return;
            }
            zzaed zzaedVar = this.zzB;
            zzaedVar.getClass();
            zzvpVar.zzd(zzaedVar.zzc(this.zzL).zza.zzc, this.zzL);
            for (zzwj zzwjVar : this.zzu) {
                zzwjVar.zzc(this.zzL);
            }
            this.zzL = C.TIME_UNSET;
        }
        this.zzN = zzX();
        this.zzm.zzd(zzvpVar, this, zzze.zza(this.zzE));
    }

    private final int zzX() {
        int iZzd = 0;
        for (zzwj zzwjVar : this.zzu) {
            iZzd += zzwjVar.zzd();
        }
        return iZzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzY(boolean r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = -9223372036854775808
        L3:
            com.google.android.gms.internal.ads.zzwj[] r3 = r6.zzu
            int r4 = r3.length
            if (r0 >= r4) goto L25
            if (r7 != 0) goto L18
            com.google.android.gms.internal.ads.zzvx r4 = r6.zzA
            r4.getClass()
            r5 = r4
            com.google.android.gms.internal.ads.zzvx r5 = (com.google.android.gms.internal.ads.zzvx) r5
            boolean[] r4 = r4.zzc
            boolean r4 = r4[r0]
            if (r4 == 0) goto L22
        L18:
            r3 = r3[r0]
            long r3 = r3.zzj()
            long r1 = java.lang.Math.max(r1, r3)
        L22:
            int r0 = r0 + 1
            goto L3
        L25:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvy.zzY(boolean):long");
    }

    private final boolean zzZ() {
        return this.zzL != C.TIME_UNSET;
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    private final void zzaa() {
        zzgmd.zzh(this.zzx);
        this.zzA.getClass();
        this.zzB.getClass();
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ void zzA(zzzj zzzjVar, long j, long j2, boolean z) {
        zzvp zzvpVar = (zzvp) zzzjVar;
        zzgy zzgyVarZzf = zzvpVar.zzf();
        zzul zzulVar = new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j2, zzgyVarZzf.zzf());
        zzvpVar.zze();
        this.zzg.zzf(zzulVar, new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)));
        if (z) {
            return;
        }
        for (zzwj zzwjVar : this.zzu) {
            zzwjVar.zzb(false);
        }
        if (this.zzI > 0) {
            zzur zzurVar = this.zzs;
            zzurVar.getClass();
            zzurVar.zzs(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ void zzB(zzzj zzzjVar, long j, long j2) {
        zzvp zzvpVar = (zzvp) zzzjVar;
        if (this.zzC == C.TIME_UNSET && this.zzB != null) {
            long jZzY = zzY(true);
            long j3 = jZzY == Long.MIN_VALUE ? 0L : jZzY + 10000;
            this.zzC = j3;
            this.zzi.zzb(j3, this.zzB, this.zzD);
        }
        zzgy zzgyVarZzf = zzvpVar.zzf();
        zzul zzulVar = new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j2, zzgyVarZzf.zzf());
        zzvpVar.zze();
        this.zzg.zze(zzulVar, new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)));
        this.zzO = true;
        zzur zzurVar = this.zzs;
        zzurVar.getClass();
        zzurVar.zzs(this);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ void zzC(zzzj zzzjVar, long j, long j2, int i) {
        zzvp zzvpVar = (zzvp) zzzjVar;
        zzgy zzgyVarZzf = zzvpVar.zzf();
        this.zzg.zzd(i == 0 ? new zzul(zzvpVar.zze(), zzvpVar.zzh(), j) : new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j2, zzgyVarZzf.zzf()), new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)), i);
    }

    final /* synthetic */ void zzG() {
        this.zzJ = true;
    }

    final /* synthetic */ void zzH() {
        this.zzr.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzG();
            }
        });
    }

    final /* synthetic */ long zzI(boolean z) {
        return zzY(true);
    }

    final /* synthetic */ long zzL() {
        return this.zzk;
    }

    final /* synthetic */ Runnable zzM() {
        return this.zzq;
    }

    final /* synthetic */ Handler zzN() {
        return this.zzr;
    }

    final /* synthetic */ zzagf zzO() {
        return this.zzt;
    }

    final /* synthetic */ void zzP(zzagf zzagfVar) {
        this.zzt = zzagfVar;
    }

    final /* synthetic */ long zzQ() {
        return this.zzC;
    }

    public final void zza() {
        if (this.zzx) {
            for (zzwj zzwjVar : this.zzu) {
                zzwjVar.zze();
            }
        }
        this.zzm.zzg(this);
        this.zzr.removeCallbacksAndMessages(null);
        this.zzs = null;
        this.zzP = true;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzb(zzur zzurVar, long j) {
        this.zzs = zzurVar;
        this.zzo.zza();
        zzW();
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzc() throws IOException {
        zzr();
        if (this.zzO && !this.zzx) {
            throw zzat.zzb("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final zzwv zzd() {
        zzaa();
        return this.zzA.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zze(zzyk[] zzykVarArr, boolean[] zArr, zzwk[] zzwkVarArr, boolean[] zArr2, long j) {
        zzyk zzykVar;
        zzaa();
        zzvx zzvxVar = this.zzA;
        zzwv zzwvVar = zzvxVar.zza;
        boolean[] zArr3 = zzvxVar.zzc;
        int i = this.zzI;
        int i2 = 0;
        for (int i3 = 0; i3 < zzykVarArr.length; i3++) {
            zzwk zzwkVar = zzwkVarArr[i3];
            if (zzwkVar != null && (zzykVarArr[i3] == null || !zArr[i3])) {
                int iZza = ((zzvv) zzwkVar).zza();
                zzgmd.zzh(zArr3[iZza]);
                this.zzI--;
                zArr3[iZza] = false;
                zzwkVarArr[i3] = null;
            }
        }
        boolean z = !this.zzF ? j == 0 || this.zzz : i != 0;
        for (int i4 = 0; i4 < zzykVarArr.length; i4++) {
            if (zzwkVarArr[i4] == null && (zzykVar = zzykVarArr[i4]) != null) {
                zzgmd.zzh(zzykVar.zze() == 1);
                zzgmd.zzh(zzykVar.zzf(0) == 0);
                int iZzb = zzwvVar.zzb(zzykVar.zza());
                zzgmd.zzh(!zArr3[iZzb]);
                this.zzI++;
                zArr3[iZzb] = true;
                this.zzH = zzykVar.zzc().zzu | this.zzH;
                zzwkVarArr[i4] = new zzvv(this, iZzb);
                zArr2[i4] = true;
                if (!z) {
                    zzwj zzwjVar = this.zzu[iZzb];
                    z = (zzwjVar.zzh() == 0 || zzwjVar.zzo(j, true)) ? false : true;
                }
            }
        }
        if (this.zzI == 0) {
            this.zzM = false;
            this.zzG = false;
            this.zzH = false;
            zzzn zzznVar = this.zzm;
            if (zzznVar.zze()) {
                zzwj[] zzwjVarArr = this.zzu;
                int length = zzwjVarArr.length;
                while (i2 < length) {
                    zzwjVarArr[i2].zzs();
                    i2++;
                }
                zzznVar.zzf();
            } else {
                this.zzO = false;
                for (zzwj zzwjVar2 : this.zzu) {
                    zzwjVar2.zzb(false);
                }
            }
        } else if (z) {
            j = zzj(j);
            while (i2 < zzwkVarArr.length) {
                if (zzwkVarArr[i2] != null) {
                    zArr2[i2] = true;
                }
                i2++;
            }
        }
        this.zzF = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzf(long j, boolean z) {
        if (this.zzz) {
            return;
        }
        zzaa();
        if (zzZ()) {
            return;
        }
        boolean[] zArr = this.zzA.zzc;
        int length = this.zzu.length;
        for (int i = 0; i < length; i++) {
            this.zzu[i].zzr(j, false, zArr[i]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzh() {
        if (this.zzH) {
            this.zzH = false;
        } else {
            if (!this.zzG) {
                return C.TIME_UNSET;
            }
            if (!this.zzO && zzX() <= this.zzN) {
                return C.TIME_UNSET;
            }
            this.zzG = false;
        }
        return this.zzK;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        long jZzY;
        zzaa();
        if (this.zzO || this.zzI == 0) {
            return Long.MIN_VALUE;
        }
        if (zzZ()) {
            return this.zzL;
        }
        if (this.zzy) {
            int length = this.zzu.length;
            jZzY = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                zzvx zzvxVar = this.zzA;
                if (zzvxVar.zzb[i] && zzvxVar.zzc[i] && !this.zzu[i].zzk()) {
                    jZzY = Math.min(jZzY, this.zzu[i].zzj());
                }
            }
        } else {
            jZzY = Long.MAX_VALUE;
        }
        if (jZzY == Long.MAX_VALUE) {
            jZzY = zzY(false);
        }
        return jZzY == Long.MIN_VALUE ? this.zzK : jZzY;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    @Override // com.google.android.gms.internal.ads.zzus
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzj(long r9) {
        /*
            r8 = this;
            r8.zzaa()
            com.google.android.gms.internal.ads.zzvx r0 = r8.zzA
            boolean[] r0 = r0.zzb
            com.google.android.gms.internal.ads.zzaed r1 = r8.zzB
            boolean r1 = r1.zzb()
            r2 = 1
            if (r2 == r1) goto L12
            r9 = 0
        L12:
            r1 = 0
            r8.zzG = r1
            long r2 = r8.zzK
            r8.zzK = r9
            boolean r4 = r8.zzZ()
            if (r4 == 0) goto L22
            r8.zzL = r9
            return r9
        L22:
            int r4 = r8.zzE
            r5 = 7
            if (r4 == r5) goto L69
            boolean r4 = r8.zzO
            if (r4 != 0) goto L33
            com.google.android.gms.internal.ads.zzzn r4 = r8.zzm
            boolean r4 = r4.zze()
            if (r4 == 0) goto L69
        L33:
            com.google.android.gms.internal.ads.zzwj[] r4 = r8.zzu
            int r4 = r4.length
            r5 = r1
        L37:
            if (r5 >= r4) goto L9b
            com.google.android.gms.internal.ads.zzwj[] r6 = r8.zzu
            r6 = r6[r5]
            int r7 = r6.zzh()
            if (r7 != 0) goto L48
            int r7 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r7 != 0) goto L48
            goto L66
        L48:
            boolean r7 = r8.zzz
            if (r7 == 0) goto L55
            int r7 = r6.zzg()
            boolean r6 = r6.zzn(r7)
            goto L5b
        L55:
            boolean r7 = r8.zzO
            boolean r6 = r6.zzo(r9, r7)
        L5b:
            if (r6 != 0) goto L66
            boolean r6 = r0[r5]
            if (r6 != 0) goto L69
            boolean r6 = r8.zzy
            if (r6 != 0) goto L66
            goto L69
        L66:
            int r5 = r5 + 1
            goto L37
        L69:
            r8.zzM = r1
            r8.zzL = r9
            r8.zzO = r1
            r8.zzH = r1
            com.google.android.gms.internal.ads.zzzn r0 = r8.zzm
            boolean r2 = r0.zze()
            if (r2 == 0) goto L8a
            com.google.android.gms.internal.ads.zzwj[] r2 = r8.zzu
            int r3 = r2.length
        L7c:
            if (r1 >= r3) goto L86
            r4 = r2[r1]
            r4.zzs()
            int r1 = r1 + 1
            goto L7c
        L86:
            r0.zzf()
            goto L9b
        L8a:
            r0.zzc()
            com.google.android.gms.internal.ads.zzwj[] r0 = r8.zzu
            int r2 = r0.length
            r3 = r1
        L91:
            if (r3 >= r2) goto L9b
            r4 = r0[r3]
            r4.zzb(r1)
            int r3 = r3 + 1
            goto L91
        L9b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvy.zzj(long):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00db  */
    @Override // com.google.android.gms.internal.ads.zzus
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzk(long r28, com.google.android.gms.internal.ads.zzlv r30) {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvy.zzk(long, com.google.android.gms.internal.ads.zzlv):long");
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        if (this.zzO) {
            return false;
        }
        zzzn zzznVar = this.zzm;
        if (zzznVar.zzb() || this.zzM) {
            return false;
        }
        if (this.zzx && this.zzI == 0) {
            return false;
        }
        boolean zZza = this.zzo.zza();
        if (zzznVar.zze()) {
            return zZza;
        }
        zzW();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        return this.zzm.zze() && this.zzo.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzzk
    public final void zzo() {
        for (zzwj zzwjVar : this.zzu) {
            zzwjVar.zza();
        }
        this.zzn.zzb();
    }

    final boolean zzp(int i) {
        return !zzT() && this.zzu[i].zzl(this.zzO);
    }

    final void zzq(int i) throws IOException {
        this.zzu[i].zzf();
        zzr();
    }

    final void zzr() throws IOException {
        this.zzm.zzh(zzze.zza(this.zzE));
    }

    final int zzs(int i, zzkj zzkjVar, zzhh zzhhVar, int i2) {
        if (zzT()) {
            return -3;
        }
        zzR(i);
        int iZzm = this.zzu[i].zzm(zzkjVar, zzhhVar, i2, this.zzO);
        if (iZzm == -3) {
            zzS(i);
        }
        return iZzm;
    }

    final int zzt(int i, long j) {
        if (zzT()) {
            return 0;
        }
        zzR(i);
        zzwj zzwjVar = this.zzu[i];
        int iZzp = zzwjVar.zzp(j, this.zzO);
        zzwjVar.zzq(iZzp);
        if (iZzp != 0) {
            return iZzp;
        }
        zzS(i);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final zzaem zzu(int i, int i2) {
        return zzU(new zzvw(i, false));
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzv() {
        this.zzw = true;
        this.zzr.post(this.zzp);
    }

    @Override // com.google.android.gms.internal.ads.zzadd
    public final void zzw(final zzaed zzaedVar) {
        this.zzr.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvs
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzF(zzaedVar);
            }
        });
    }

    final zzaem zzx() {
        return zzU(new zzvw(0, true));
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final void zzy(zzv zzvVar) {
        this.zzr.post(this.zzp);
    }

    @Override // com.google.android.gms.internal.ads.zzzf
    public final /* bridge */ /* synthetic */ zzzh zzz(zzzj zzzjVar, long j, long j2, IOException iOException, int i) {
        long jMin;
        zzzh zzzhVarZza;
        zzaed zzaedVar;
        zzvp zzvpVar = (zzvp) zzzjVar;
        zzgy zzgyVarZzf = zzvpVar.zzf();
        zzul zzulVar = new zzul(zzvpVar.zze(), zzvpVar.zzh(), zzgyVarZzf.zzg(), zzgyVarZzf.zzh(), j, j2, zzgyVarZzf.zzf());
        zzvpVar.zzg();
        String str = zzep.zza;
        if ((iOException instanceof zzat) || (iOException instanceof FileNotFoundException) || (iOException instanceof zzgp) || (iOException instanceof zzzm)) {
            jMin = -9223372036854775807L;
            break;
        }
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof zzgc) && ((zzgc) cause).zza == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
        }
        jMin = Math.min((i - 1) * 1000, 5000);
        if (jMin == C.TIME_UNSET) {
            zzzhVarZza = zzzn.zzb;
        } else {
            int iZzX = zzX();
            boolean z = iZzX > this.zzN;
            if (this.zzJ || !((zzaedVar = this.zzB) == null || zzaedVar.zza() == C.TIME_UNSET)) {
                this.zzN = iZzX;
            } else {
                boolean z2 = this.zzx;
                if (!z2 || zzT()) {
                    this.zzG = z2;
                    this.zzK = 0L;
                    this.zzN = 0;
                    for (zzwj zzwjVar : this.zzu) {
                        zzwjVar.zzb(false);
                    }
                    zzvpVar.zzd(0L, 0L);
                } else {
                    this.zzM = true;
                    zzzhVarZza = zzzn.zza;
                }
            }
            zzzhVarZza = zzzn.zza(z, jMin);
        }
        boolean z3 = !zzzhVarZza.zza();
        this.zzg.zzg(zzulVar, new zzuq(1, -1, null, 0, null, zzep.zzp(zzvpVar.zzg()), zzep.zzp(this.zzC)), iOException, z3);
        if (z3) {
            zzvpVar.zze();
        }
        return zzzhVarZza;
    }

    final /* synthetic */ void zzE() {
        if (this.zzP) {
            return;
        }
        zzur zzurVar = this.zzs;
        zzurVar.getClass();
        zzurVar.zzs(this);
    }

    final /* synthetic */ void zzF(zzaed zzaedVar) {
        this.zzB = this.zzt == null ? zzaedVar : new zzaec(C.TIME_UNSET, 0L);
        this.zzC = zzaedVar.zza();
        boolean z = false;
        if (!this.zzJ && zzaedVar.zza() == C.TIME_UNSET) {
            z = true;
        }
        this.zzD = z;
        this.zzE = true == z ? 7 : 1;
        if (this.zzx) {
            this.zzi.zzb(this.zzC, zzaedVar, z);
        } else {
            zzD();
        }
    }
}
