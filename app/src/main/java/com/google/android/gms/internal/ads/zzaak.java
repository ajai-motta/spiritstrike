package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Surface;
import com.facebook.ads.AdError;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaak extends zzte implements zzaaz {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private int zzA;
    private int zzB;
    private int zzC;
    private zzlu zzD;
    private boolean zzE;
    private long zzF;
    private int zzG;
    private long zzH;
    private zzbv zzI;
    private zzbv zzJ;
    private int zzK;
    private int zzL;
    private zzaax zzM;
    private long zzN;
    private long zzO;
    private boolean zzP;
    private final Context zze;
    private final boolean zzf;
    private final zzabr zzg;
    private final boolean zzh;
    private final zzaba zzi;
    private final zzaay zzj;
    private final long zzk;
    private final PriorityQueue zzl;
    private zzaaj zzm;
    private boolean zzn;
    private boolean zzo;
    private zzabx zzp;
    private boolean zzq;
    private int zzr;
    private List zzs;
    private Surface zzt;
    private zzaam zzu;
    private zzeh zzv;
    private boolean zzw;
    private int zzx;
    private int zzy;
    private long zzz;

    protected zzaak(zzaai zzaaiVar) {
        super(2, zzaaiVar.zzg(), zzaaiVar.zzf(), false, 30.0f);
        Context applicationContext = zzaaiVar.zze().getApplicationContext();
        this.zze = applicationContext;
        this.zzp = null;
        this.zzg = new zzabr(zzaaiVar.zzh(), zzaaiVar.zzi());
        this.zzf = this.zzp == null;
        this.zzi = new zzaba(applicationContext, this, 0L);
        this.zzj = new zzaay();
        this.zzh = "NVIDIA".equals(Build.MANUFACTURER);
        this.zzv = zzeh.zza;
        this.zzx = 1;
        this.zzy = 0;
        this.zzI = zzbv.zza;
        this.zzL = 0;
        this.zzJ = null;
        this.zzK = -1000;
        this.zzN = C.TIME_UNSET;
        this.zzO = C.TIME_UNSET;
        this.zzl = new PriorityQueue();
        this.zzk = C.TIME_UNSET;
        this.zzD = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzat(com.google.android.gms.internal.ads.zzsy r11, com.google.android.gms.internal.ads.zzv r12) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaak.zzat(com.google.android.gms.internal.ads.zzsy, com.google.android.gms.internal.ads.zzv):int");
    }

    protected static int zzbg(zzsy zzsyVar, zzv zzvVar) {
        int i = zzvVar.zzp;
        if (i == -1) {
            return zzat(zzsyVar, zzvVar);
        }
        List list = zzvVar.zzr;
        int size = list.size();
        int length = 0;
        for (int i2 = 0; i2 < size; i2++) {
            length += ((byte[]) list.get(i2)).length;
        }
        return i + length;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0081 A[Catch: all -> 0x07aa, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x000d, B:9:0x0011, B:11:0x001f, B:514:0x07a2, B:42:0x0081, B:44:0x0087, B:47:0x0092, B:80:0x00fd, B:82:0x0103, B:507:0x078c, B:515:0x07a6), top: B:521:0x000d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected static final boolean zzbk(java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 2926
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaak.zzbk(java.lang.String):boolean");
    }

    protected static final boolean zzbl(zzsy zzsyVar) {
        return Build.VERSION.SDK_INT >= 35 && zzsyVar.zzh;
    }

    private static List zzbm(Context context, zztg zztgVar, zzv zzvVar, boolean z, boolean z2) throws zzti {
        String str = zzvVar.zzo;
        if (str == null) {
            return zzgpe.zzi();
        }
        if (Build.VERSION.SDK_INT >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(str) && !zzaah.zza(context)) {
            List listZzd = zztq.zzd(zztgVar, zzvVar, z, z2);
            if (!listZzd.isEmpty()) {
                return listZzd;
            }
        }
        return zztq.zzc(zztgVar, zzvVar, z, z2);
    }

    private final void zzbn(Object obj) throws zzib {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.zzt == surface) {
            if (surface != null) {
                zzbv();
                Surface surface2 = this.zzt;
                if (surface2 == null || !this.zzw) {
                    return;
                }
                this.zzg.zzg(surface2);
                return;
            }
            return;
        }
        this.zzt = surface;
        if (this.zzp == null) {
            this.zzi.zzd(surface);
        }
        this.zzw = false;
        int iZze = zze();
        zzsv zzsvVarZzaE = zzaE();
        if (zzsvVarZzaE != null && this.zzp == null) {
            zzsy zzsyVarZzaH = zzaH();
            zzsyVarZzaH.getClass();
            if (!zzbr(zzsyVarZzaH) || this.zzn) {
                zzaI();
                zzaA();
            } else {
                Surface surfaceZzbs = zzbs(zzsyVarZzaH);
                if (surfaceZzbs != null) {
                    zzsvVarZzaE.zzm(surfaceZzbs);
                } else {
                    if (Build.VERSION.SDK_INT < 35) {
                        throw new IllegalStateException();
                    }
                    zzsvVarZzaE.zzn();
                }
            }
        }
        if (surface != null) {
            zzbv();
        } else {
            this.zzJ = null;
            zzabx zzabxVar = this.zzp;
            if (zzabxVar != null) {
                zzabxVar.zzq();
            }
        }
        if (iZze == 2) {
            zzabx zzabxVar2 = this.zzp;
            if (zzabxVar2 != null) {
                zzabxVar2.zzw(true);
            } else {
                this.zzi.zzj(true);
            }
        }
    }

    private final boolean zzbo(zzhh zzhhVar) {
        if (zzdb() || zzhhVar.zzd() || this.zzO == C.TIME_UNSET) {
            return true;
        }
        return this.zzO - (zzhhVar.zze - zzbb()) <= 100000;
    }

    private final boolean zzbp(zzhh zzhhVar) {
        return zzhhVar.zze < zzG();
    }

    private final void zzbq(long j, long j2, zzv zzvVar) {
        zzaax zzaaxVar = this.zzM;
        if (zzaaxVar != null) {
            zzaaxVar.zzcS(j, j2, zzvVar, zzaG());
        }
    }

    private final boolean zzbr(zzsy zzsyVar) {
        if (this.zzp != null) {
            return true;
        }
        Surface surface = this.zzt;
        return (surface != null && surface.isValid()) || zzbl(zzsyVar) || zzbf(zzsyVar);
    }

    private final Surface zzbs(zzsy zzsyVar) {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            return zzabxVar.zzk();
        }
        Surface surface = this.zzt;
        if (surface != null) {
            return surface;
        }
        if (zzbl(zzsyVar)) {
            return null;
        }
        zzgmd.zzh(zzbf(zzsyVar));
        zzaam zzaamVar = this.zzu;
        if (zzaamVar != null) {
            if (zzaamVar.zza != zzsyVar.zzf) {
                zzbt();
            }
        }
        if (this.zzu == null) {
            this.zzu = zzaam.zzb(this.zze, zzsyVar.zzf);
        }
        return this.zzu;
    }

    private final void zzbt() {
        zzaam zzaamVar = this.zzu;
        if (zzaamVar != null) {
            zzaamVar.release();
            this.zzu = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull({"displaySurface"})
    /* JADX INFO: renamed from: zzbu, reason: merged with bridge method [inline-methods] */
    public final void zzbi() {
        this.zzg.zzg(this.zzt);
        this.zzw = true;
    }

    private final void zzbv() {
        zzbv zzbvVar = this.zzJ;
        if (zzbvVar != null) {
            this.zzg.zzf(zzbvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    protected final void zzA(long j, boolean z, boolean z2) throws zzib {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null && !z) {
            zzabxVar.zzg(true);
        }
        super.zzA(j, z, z2);
        if (this.zzp == null) {
            this.zzi.zzl();
        }
        if (z) {
            zzabx zzabxVar2 = this.zzp;
            if (zzabxVar2 != null) {
                zzabxVar2.zzw(false);
            } else {
                this.zzi.zzj(false);
            }
        }
        this.zzB = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    protected final void zzB() {
        this.zzA = 0;
        this.zzz = zzL().zzb();
        this.zzF = 0L;
        this.zzG = 0;
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zza();
        } else {
            this.zzi.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    protected final void zzC() {
        if (this.zzA > 0) {
            long jZzb = zzL().zzb();
            this.zzg.zzd(this.zzA, jZzb - this.zzz);
            this.zzA = 0;
            this.zzz = jZzb;
        }
        int i = this.zzG;
        if (i != 0) {
            this.zzg.zze(this.zzF, i);
            this.zzF = 0L;
            this.zzG = 0;
        }
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zzb();
        } else {
            this.zzi.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    protected final void zzD() {
        this.zzJ = null;
        this.zzO = C.TIME_UNSET;
        this.zzw = false;
        this.zzE = true;
        try {
            super.zzD();
        } finally {
            zzabr zzabrVar = this.zzg;
            zzabrVar.zzi(this.zza);
            zzabrVar.zzf(zzbv.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    protected final void zzE() {
        try {
            super.zzE();
        } finally {
            this.zzq = false;
            this.zzN = C.TIME_UNSET;
            zzbt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr
    protected final void zzF() {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar == null || !this.zzf) {
            return;
        }
        zzabxVar.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzln, com.google.android.gms.internal.ads.zzlp
    public final String zzS() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzln
    public final boolean zzU(long j) {
        long jZzaU = zzaU();
        return jZzaU == C.TIME_UNSET || j > jZzaU - zzbb();
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzln
    public final void zzV(float f, float f2) throws zzib {
        super.zzV(f, f2);
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zzm(f);
        } else {
            this.zzi.zzn(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzln
    public final void zzW() {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar == null) {
            this.zzi.zzh();
            return;
        }
        int i = this.zzr;
        if (i == 0 || i == 1) {
            this.zzr = 0;
        } else {
            zzabxVar.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzln
    public final void zzX(long j, long j2) throws zzib {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            try {
                zzabxVar.zzv(j, j2);
            } catch (zzabw e) {
                throw zzN(e, e.zza, false, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
            }
        }
        super.zzX(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzln
    public final boolean zzY() {
        boolean zZzaW = zzaW();
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            return zzabxVar.zzh(zZzaW);
        }
        if (zZzaW && zzaE() == null) {
            return true;
        }
        return this.zzi.zzi(zZzaW);
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzln
    public final boolean zzZ() {
        if (!super.zzZ()) {
            return false;
        }
        zzabx zzabxVar = this.zzp;
        return zzabxVar == null || zzabxVar.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final boolean zzaC(zzsy zzsyVar) {
        return zzbr(zzsyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final boolean zzaK() {
        zzsy zzsyVarZzaH = zzaH();
        if (this.zzp != null && zzsyVarZzaH != null) {
            String str = zzsyVarZzaH.zza;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.zzaK();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    @Override // com.google.android.gms.internal.ads.zzte
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final boolean zzaL() {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzv r0 = r12.zzaF()
            long r1 = r12.zzO
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = 0
            r7 = 1
            if (r5 == 0) goto L2d
            r8 = 1
            long r1 = r1 + r8
            long r8 = r12.zzbb()
            long r10 = r12.zzO
            long r8 = r8 + r10
            long r10 = r12.zzaM()
            long r10 = r10 + r1
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r1 = r1 - r8
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 <= 0) goto L2b
            goto L2d
        L2b:
            r1 = r6
            goto L2e
        L2d:
            r1 = r7
        L2e:
            com.google.android.gms.internal.ads.zzlu r2 = r12.zzD
            if (r2 != 0) goto L33
            goto L48
        L33:
            boolean r2 = r12.zzE
            if (r2 != 0) goto L48
            if (r0 == 0) goto L3d
            int r0 = r0.zzq
            if (r0 > 0) goto L48
        L3d:
            if (r1 != 0) goto L48
            long r0 = r12.zzba()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L48
            return r6
        L48:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaak.zzaL():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzaN() {
        super.zzaN();
        this.zzl.clear();
        this.zzC = 0;
        this.zzE = false;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final zzsx zzaP(Throwable th, zzsy zzsyVar) {
        return new zzaae(th, zzsyVar, this.zzt);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final boolean zzaQ(zzv zzvVar) throws zzib {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar == null || zzabxVar.zze()) {
            return true;
        }
        try {
            zzabxVar.zzd(zzvVar);
            return true;
        } catch (zzabw e) {
            throw zzN(e, zzvVar, false, AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzaR(zzhh zzhhVar) throws zzib {
        int iZzaS = zzaS(zzhhVar);
        if (Build.VERSION.SDK_INT < 34 || (iZzaS & 32) == 0) {
            this.zzC++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final int zzaS(zzhh zzhhVar) {
        return (Build.VERSION.SDK_INT < 34 || this.zzD == null || !zzbp(zzhhVar) || zzbo(zzhhVar)) ? 0 : 32;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final boolean zzaT(zzhh zzhhVar) {
        boolean z = false;
        if (zzbo(zzhhVar)) {
            return false;
        }
        if (zzbp(zzhhVar)) {
            if (zzhhVar.zze()) {
                return false;
            }
            if (zzhhVar.zzf()) {
                zzhhVar.zza();
                z = true;
            }
            if (z) {
                this.zza.zzd++;
            }
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzaV(long j) {
        super.zzaV(j);
        this.zzC--;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final int zzac(zztg zztgVar, zzv zzvVar) throws zzti {
        boolean z;
        String str = zzvVar.zzo;
        if (!zzas.zzb(str)) {
            return 128;
        }
        Context context = this.zze;
        int i = 0;
        boolean z2 = zzvVar.zzs != null;
        List listZzbm = zzbm(context, zztgVar, zzvVar, z2, false);
        if (z2 && listZzbm.isEmpty()) {
            listZzbm = zzbm(context, zztgVar, zzvVar, false, false);
        }
        if (listZzbm.isEmpty()) {
            return TsExtractor.TS_STREAM_TYPE_AC3;
        }
        if (!zzbd(zzvVar)) {
            return TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
        }
        zzsy zzsyVar = (zzsy) listZzbm.get(0);
        boolean zZzc = zzsyVar.zzc(zzvVar);
        if (zZzc) {
            z = true;
        } else {
            for (int i2 = 1; i2 < listZzbm.size(); i2++) {
                zzsy zzsyVar2 = (zzsy) listZzbm.get(i2);
                if (zzsyVar2.zzc(zzvVar)) {
                    zZzc = true;
                    z = false;
                    zzsyVar = zzsyVar2;
                    break;
                }
            }
            z = true;
        }
        int i3 = true != zZzc ? 3 : 4;
        int i4 = true != zzsyVar.zze(zzvVar) ? 8 : 16;
        int i5 = true != zzsyVar.zzg ? 0 : 64;
        int i6 = true != z ? 0 : 128;
        if (Build.VERSION.SDK_INT >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(str) && !zzaah.zza(context)) {
            i6 = 256;
        }
        if (zZzc) {
            List listZzbm2 = zzbm(context, zztgVar, zzvVar, z2, true);
            if (!listZzbm2.isEmpty()) {
                zzsy zzsyVar3 = (zzsy) zztq.zze(listZzbm2, zzvVar).get(0);
                if (zzsyVar3.zzc(zzvVar) && zzsyVar3.zze(zzvVar)) {
                    i = 32;
                }
            }
        }
        return i6 | i3 | i4 | i | i5;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final List zzad(zztg zztgVar, zzv zzvVar, boolean z) throws zzti {
        return zztq.zze(zzbm(this.zze, zztgVar, zzvVar, false, false), zzvVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0116, code lost:
    
        r3 = null;
     */
    @Override // com.google.android.gms.internal.ads.zzte
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final com.google.android.gms.internal.ads.zzss zzaf(com.google.android.gms.internal.ads.zzsy r21, com.google.android.gms.internal.ads.zzv r22, android.media.MediaCrypto r23, float r24) {
        /*
            Method dump skipped, instruction units count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaak.zzaf(com.google.android.gms.internal.ads.zzsy, com.google.android.gms.internal.ads.zzv, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzss");
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final zzht zzag(zzsy zzsyVar, zzv zzvVar, zzv zzvVar2) {
        int i;
        int i2;
        zzht zzhtVarZzf = zzsyVar.zzf(zzvVar, zzvVar2);
        int i3 = zzhtVarZzf.zze;
        zzaaj zzaajVar = this.zzm;
        zzaajVar.getClass();
        if (zzvVar2.zzv > zzaajVar.zza || zzvVar2.zzw > zzaajVar.zzb) {
            i3 |= 256;
        }
        if (zzbg(zzsyVar, zzvVar2) > zzaajVar.zzc) {
            i3 |= 64;
        }
        String str = zzsyVar.zza;
        if (i3 != 0) {
            i2 = i3;
            i = 0;
        } else {
            i = zzhtVarZzf.zzd;
            i2 = 0;
        }
        return new zzht(str, zzvVar, zzvVar2, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final float zzai(float f, zzv zzvVar, zzv[] zzvVarArr) {
        zzsy zzsyVarZzaH;
        float fMax = -1.0f;
        for (zzv zzvVar2 : zzvVarArr) {
            float f2 = zzvVar2.zzz;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        float f3 = fMax == -1.0f ? -1.0f : fMax * f;
        if (this.zzD == null || (zzsyVarZzaH = zzaH()) == null) {
            return f3;
        }
        float fZzh = zzsyVarZzaH.zzh(zzvVar.zzv, zzvVar.zzw);
        return f3 != -1.0f ? Math.max(f3, fZzh) : fZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzaj(String str, zzss zzssVar, long j, long j2) {
        this.zzg.zzb(str, j, j2);
        this.zzn = zzbk(str);
        zzsy zzsyVarZzaH = zzaH();
        zzsyVarZzaH.getClass();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 29 && MimeTypes.VIDEO_VP9.equals(zzsyVarZzaH.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrZzb = zzsyVarZzaH.zzb();
            int length = codecProfileLevelArrZzb.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (codecProfileLevelArrZzb[i].profile == 16384) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        this.zzo = z;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzak(String str) {
        this.zzg.zzh(str);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzal(Exception exc) {
        zzdt.zzf("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzj(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final zzht zzam(zzkj zzkjVar) throws zzib {
        zzht zzhtVarZzam = super.zzam(zzkjVar);
        zzv zzvVar = zzkjVar.zzb;
        zzvVar.getClass();
        this.zzg.zzc(zzvVar, zzhtVarZzam);
        return zzhtVarZzam;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzan(zzv zzvVar, MediaFormat mediaFormat) {
        zzsv zzsvVarZzaE = zzaE();
        if (zzsvVarZzaE != null) {
            zzsvVarZzaE.zzp(this.zzx);
        }
        mediaFormat.getClass();
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        int integer2 = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        float f = zzvVar.zzB;
        int i = zzvVar.zzA;
        if (i == 90 || i == 270) {
            f = 1.0f / f;
            int i2 = integer2;
            integer2 = integer;
            integer = i2;
        }
        this.zzI = new zzbv(integer, integer2, f);
        zzabx zzabxVar = this.zzp;
        if (zzabxVar == null || !this.zzP) {
            this.zzi.zze(zzvVar.zzz);
        } else {
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzt(integer);
            zztVarZza.zzu(integer2);
            zztVarZza.zzz(f);
            zzv zzvVarZzM = zztVarZza.zzM();
            int i3 = this.zzr;
            List listZzi = this.zzs;
            if (listZzi == null) {
                listZzi = zzgpe.zzi();
            }
            zzabxVar.zzs(1, zzvVarZzM, zzbc(), i3, listZzi);
            this.zzr = 2;
        }
        this.zzP = false;
    }

    @Override // com.google.android.gms.internal.ads.zzaaz
    public final boolean zzao(long j, long j2, long j3, boolean z, boolean z2) throws zzib {
        int iZzP;
        if (this.zzp != null && this.zzf) {
            j2 -= -this.zzN;
        }
        if (j >= -500000 || z || (iZzP = zzP(j2)) == 0) {
            return false;
        }
        if (z2) {
            zzhs zzhsVar = this.zza;
            int i = zzhsVar.zzd + iZzP;
            zzhsVar.zzd = i;
            zzhsVar.zzf += this.zzC;
            zzhsVar.zzd = i + this.zzl.size();
        } else {
            this.zza.zzj++;
            zzaw(iZzP + this.zzl.size(), this.zzC);
        }
        zzaJ();
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zzg(false);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzap() {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zzi();
            long jZzbc = this.zzN;
            if (jZzbc == C.TIME_UNSET) {
                jZzbc = zzbc();
                this.zzN = jZzbc;
            }
            this.zzp.zzo(-jZzbc);
        } else {
            this.zzi.zza(2);
        }
        this.zzP = true;
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzar() {
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            zzabxVar.zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final void zzas(zzhh zzhhVar) throws zzib {
        if (this.zzo) {
            ByteBuffer byteBuffer = zzhhVar.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zzsv zzsvVarZzaE = zzaE();
                        zzsvVarZzaE.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzsvVarZzaE.zzo(bundle);
                    }
                }
            }
        }
    }

    protected final void zzau(zzsv zzsvVar, int i, long j) {
        Trace.beginSection("skipVideoBuffer");
        zzsvVar.zzc(i, false);
        Trace.endSection();
        this.zza.zzf++;
    }

    protected final void zzav(zzsv zzsvVar, int i, long j) {
        Trace.beginSection("dropVideoBuffer");
        zzsvVar.zzc(i, false);
        Trace.endSection();
        zzaw(0, 1);
    }

    protected final void zzaw(int i, int i2) {
        zzhs zzhsVar = this.zza;
        zzhsVar.zzh += i;
        int i3 = i + i2;
        zzhsVar.zzg += i3;
        this.zzA += i3;
        int i4 = this.zzB + i3;
        this.zzB = i4;
        zzhsVar.zzi = Math.max(i4, zzhsVar.zzi);
    }

    protected final void zzax(long j) {
        zzhs zzhsVar = this.zza;
        zzhsVar.zzk += j;
        zzhsVar.zzl++;
        this.zzF += j;
        this.zzG++;
    }

    protected final void zzay(zzsv zzsvVar, int i, long j, long j2) {
        Trace.beginSection("releaseOutputBuffer");
        zzsvVar.zzd(i, j2);
        Trace.endSection();
        this.zza.zze++;
        this.zzB = 0;
        if (this.zzp == null) {
            zzbv zzbvVar = this.zzI;
            if (!zzbvVar.equals(zzbv.zza) && !zzbvVar.equals(this.zzJ)) {
                this.zzJ = zzbvVar;
                this.zzg.zzf(zzbvVar);
            }
            if (!this.zzi.zzf() || this.zzt == null) {
                return;
            }
            zzbi();
        }
    }

    protected final boolean zzbf(zzsy zzsyVar) {
        if (zzbk(zzsyVar.zza)) {
            return false;
        }
        return !zzsyVar.zzf || zzaam.zza(this.zze);
    }

    final /* synthetic */ Surface zzbj() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    protected final void zzy(boolean z, boolean z2) throws zzib {
        super.zzy(z, z2);
        zzJ();
        this.zzg.zza(this.zza);
        if (!this.zzq) {
            if (this.zzs != null && this.zzp == null) {
                zzaao zzaaoVar = new zzaao(this.zze, this.zzi);
                zzaaoVar.zza(true);
                long j = this.zzk;
                long j2 = C.TIME_UNSET;
                if (j != C.TIME_UNSET) {
                    j2 = -j;
                }
                zzaaoVar.zzc(j2);
                zzaaoVar.zzb(zzL());
                zzaaw zzaawVarZzd = zzaaoVar.zzd();
                zzaawVarZzd.zza(1);
                this.zzp = zzaawVarZzd.zzb(0);
            }
            this.zzq = true;
        }
        int i = !z2 ? 1 : 0;
        zzabx zzabxVar = this.zzp;
        if (zzabxVar == null) {
            zzaba zzabaVar = this.zzi;
            zzabaVar.zzg(zzL());
            zzabaVar.zza(i);
            return;
        }
        zzabxVar.zzc(new zzaaf(this), zzguz.zza());
        zzaax zzaaxVar = this.zzM;
        if (zzaaxVar != null) {
            this.zzp.zzl(zzaaxVar);
        }
        if (this.zzt != null && !this.zzv.equals(zzeh.zza)) {
            this.zzp.zzp(this.zzt, this.zzv);
        }
        this.zzp.zzr(this.zzy);
        this.zzp.zzm(zzaX());
        List list = this.zzs;
        if (list != null) {
            this.zzp.zzn(list);
        }
        this.zzr = i;
        zzaz();
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr
    protected final void zzz(zzv[] zzvVarArr, long j, long j2, zzuu zzuuVar) throws zzib {
        super.zzz(zzvVarArr, j, j2, zzuuVar);
        zzbf zzbfVarZzM = zzM();
        if (zzbfVarZzM.zzg()) {
            this.zzO = C.TIME_UNSET;
        } else {
            this.zzO = zzbfVarZzM.zzo(zzuuVar.zza, new zzbd()).zzd;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzte
    protected final boolean zzaq(long j, long j2, zzsv zzsvVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzv zzvVar) throws zzib {
        zzsvVar.getClass();
        long jZzbb = j3 - zzbb();
        int i4 = 0;
        while (true) {
            PriorityQueue priorityQueue = this.zzl;
            Long l = (Long) priorityQueue.peek();
            if (l == null || l.longValue() >= j3) {
                break;
            }
            priorityQueue.poll();
            i4++;
        }
        zzaw(i4, 0);
        zzabx zzabxVar = this.zzp;
        if (zzabxVar != null) {
            if (!z || z2) {
                return zzabxVar.zzu(j3, new zzaag(this, zzsvVar, i, jZzbb));
            }
            zzau(zzsvVar, i, jZzbb);
            return true;
        }
        zzaba zzabaVar = this.zzi;
        long jZzbc = zzbc();
        zzaay zzaayVar = this.zzj;
        int iZzk = zzabaVar.zzk(j3, j, j2, jZzbc, z, z2, zzaayVar);
        if (iZzk == 0) {
            long jZzc = zzL().zzc();
            zzbq(jZzbb, jZzc, zzvVar);
            zzay(zzsvVar, i, jZzbb, jZzc);
            zzax(zzaayVar.zza());
            return true;
        }
        if (iZzk != 1) {
            if (iZzk == 2) {
                zzav(zzsvVar, i, jZzbb);
                zzax(zzaayVar.zza());
                return true;
            }
            if (iZzk != 3) {
                return false;
            }
            zzau(zzsvVar, i, jZzbb);
            zzax(zzaayVar.zza());
            return true;
        }
        long jZzb = zzaayVar.zzb();
        long jZza = zzaayVar.zza();
        if (jZzb == this.zzH) {
            zzau(zzsvVar, i, jZzbb);
        } else {
            zzbq(jZzbb, jZzb, zzvVar);
            zzay(zzsvVar, i, jZzbb, jZzb);
        }
        zzax(jZza);
        this.zzH = jZzb;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzte, com.google.android.gms.internal.ads.zzhr, com.google.android.gms.internal.ads.zzli
    public final void zzx(int i, Object obj) throws zzib {
        if (i == 1) {
            zzbn(obj);
            return;
        }
        if (i == 7) {
            obj.getClass();
            zzaax zzaaxVar = (zzaax) obj;
            this.zzM = zzaaxVar;
            zzabx zzabxVar = this.zzp;
            if (zzabxVar != null) {
                zzabxVar.zzl(zzaaxVar);
                return;
            }
            return;
        }
        if (i == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            if (this.zzL != iIntValue) {
                this.zzL = iIntValue;
                return;
            }
            return;
        }
        if (i == 4) {
            obj.getClass();
            int iIntValue2 = ((Integer) obj).intValue();
            this.zzx = iIntValue2;
            zzsv zzsvVarZzaE = zzaE();
            if (zzsvVarZzaE != null) {
                zzsvVarZzaE.zzp(iIntValue2);
                return;
            }
            return;
        }
        if (i == 5) {
            obj.getClass();
            int iIntValue3 = ((Integer) obj).intValue();
            this.zzy = iIntValue3;
            zzabx zzabxVar2 = this.zzp;
            if (zzabxVar2 != null) {
                zzabxVar2.zzr(iIntValue3);
                return;
            } else {
                this.zzi.zzm(iIntValue3);
                return;
            }
        }
        if (i == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(zzbr.zza)) {
                zzabx zzabxVar3 = this.zzp;
                if (zzabxVar3 == null || !zzabxVar3.zze()) {
                    return;
                }
                zzabxVar3.zzf();
                return;
            }
            this.zzs = list;
            zzabx zzabxVar4 = this.zzp;
            if (zzabxVar4 != null) {
                zzabxVar4.zzn(list);
                return;
            }
            return;
        }
        if (i == 14) {
            obj.getClass();
            zzeh zzehVar = (zzeh) obj;
            if (zzehVar.zza() == 0 || zzehVar.zzb() == 0) {
                return;
            }
            this.zzv = zzehVar;
            zzabx zzabxVar5 = this.zzp;
            if (zzabxVar5 != null) {
                Surface surface = this.zzt;
                surface.getClass();
                zzabxVar5.zzp(surface, zzehVar);
                return;
            }
            return;
        }
        switch (i) {
            case 16:
                obj.getClass();
                this.zzK = ((Integer) obj).intValue();
                zzsv zzsvVarZzaE2 = zzaE();
                if (zzsvVarZzaE2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.zzK));
                    zzsvVarZzaE2.zzo(bundle);
                    break;
                }
                break;
            case 17:
                Surface surface2 = this.zzt;
                zzbn(null);
                obj.getClass();
                ((zzaak) obj).zzx(1, surface2);
                break;
            case 18:
                boolean z = this.zzD != null;
                zzlu zzluVar = (zzlu) obj;
                this.zzD = zzluVar;
                if (z != (zzluVar != null)) {
                    zzaZ();
                }
                break;
            default:
                super.zzx(i, obj);
                break;
        }
    }
}
