package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.internal.ads.zzada;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzahk implements zzada {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb;
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final byte[] zze;
    private static final UUID zzf;
    private static final Map zzg;
    private long zzA;
    private long zzB;
    private boolean zzC;
    private boolean zzD;
    private zzahj zzE;
    private boolean zzF;
    private int zzG;
    private long zzH;
    private final SparseArray zzI;
    private boolean zzJ;
    private long zzK;
    private int zzL;
    private long zzM;
    private int zzN;
    private boolean zzO;
    private long zzP;
    private long zzQ;
    private long zzR;
    private boolean zzS;
    private int zzT;
    private long zzU;
    private long zzV;
    private int zzW;
    private int zzX;
    private int[] zzY;
    private int zzZ;
    private int zzaa;
    private int zzab;
    private int zzac;
    private boolean zzad;
    private long zzae;
    private int zzaf;
    private int zzag;
    private int zzah;
    private boolean zzai;
    private boolean zzaj;
    private boolean zzak;
    private int zzal;
    private byte zzam;
    private boolean zzan;
    private zzadd zzao;
    private final zzahd zzap;
    private final zzahm zzh;
    private final SparseArray zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final zzakg zzl;
    private final zzeg zzm;
    private final zzeg zzn;
    private final zzeg zzo;
    private final zzeg zzp;
    private final zzeg zzq;
    private final zzeg zzr;
    private final zzeg zzs;
    private final zzeg zzt;
    private final zzeg zzu;
    private final zzeg zzv;
    private ByteBuffer zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        int i = zzahg.zza;
        zzb = new byte[]{49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
        String str = zzep.zza;
        zzc = "Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text".getBytes(StandardCharsets.UTF_8);
        zzd = new byte[]{68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
        zze = new byte[]{87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
        zzf = new UUID(72057594037932032L, -9223371306706625679L);
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        zzg = Collections.unmodifiableMap(map);
    }

    @Deprecated
    public zzahk() {
        this(new zzahd(), 2, zzakg.zza);
    }

    private final void zzA() {
        if (!this.zzD) {
            return;
        }
        int i = 0;
        while (true) {
            SparseArray sparseArray = this.zzi;
            if (i >= sparseArray.size()) {
                zzadd zzaddVar = this.zzao;
                zzaddVar.getClass();
                zzaddVar.zzv();
                this.zzD = false;
                return;
            }
            if (((zzahj) sparseArray.valueAt(i)).zzV) {
                return;
            } else {
                i++;
            }
        }
    }

    @EnsuresNonNull({"currentTrack"})
    private final void zzp(int i) throws zzat {
        if (this.zzE != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 32);
        sb.append("Element ");
        sb.append(i);
        sb.append(" must be in a TrackEntry");
        throw zzat.zzb(sb.toString(), null);
    }

    private final void zzq(int i) throws zzat {
        if (this.zzJ) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 26);
        sb.append("Element ");
        sb.append(i);
        sb.append(" must be in a Cues");
        throw zzat.zzb(sb.toString(), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f6  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"#1.output"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzr(com.google.android.gms.internal.ads.zzahj r18, long r19, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahk.zzr(com.google.android.gms.internal.ads.zzahj, long, int, int, int):void");
    }

    private final void zzs(zzadb zzadbVar, int i) throws IOException {
        zzeg zzegVar = this.zzo;
        if (zzegVar.zze() >= i) {
            return;
        }
        if (zzegVar.zzj() < i) {
            int iZzj = zzegVar.zzj();
            zzegVar.zzc(Math.max(iZzj + iZzj, i));
        }
        zzadbVar.zzc(zzegVar.zzi(), zzegVar.zze(), i - zzegVar.zze());
        zzegVar.zzf(i);
    }

    @RequiresNonNull({"#2.output"})
    private final int zzt(zzadb zzadbVar, zzahj zzahjVar, int i, boolean z) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(zzahjVar.zzc)) {
            zzv(zzadbVar, zzb, i);
            int i3 = this.zzag;
            zzu();
            return i3;
        }
        if ("S_TEXT/ASS".equals(zzahjVar.zzc) || "S_TEXT/SSA".equals(zzahjVar.zzc)) {
            zzv(zzadbVar, zzd, i);
            int i4 = this.zzag;
            zzu();
            return i4;
        }
        if ("S_TEXT/WEBVTT".equals(zzahjVar.zzc)) {
            zzv(zzadbVar, zze, i);
            int i5 = this.zzag;
            zzu();
            return i5;
        }
        if (zzahjVar.zzV) {
            zzahjVar.zzZ.getClass();
            int i6 = zzacz.zza;
            zzeg zzegVar = new zzeg(i);
            if (zzadbVar.zzh(zzegVar.zzi(), 0, i, true)) {
                zzadbVar.zzl();
                if (zzacz.zza(zzegVar.zzr()) == 1 && zzegVar.zzd() >= 10) {
                    byte[] bArr = new byte[10];
                    zzegVar.zzm(bArr, 0, 10);
                    zzegVar.zzh(0);
                    int iZzc = zzacz.zzc(bArr);
                    if (zzegVar.zzd() >= iZzc + 4) {
                        zzegVar.zzk(iZzc);
                        if (zzacz.zza(zzegVar.zzB()) == 2) {
                            zzt zztVarZza = zzahjVar.zzZ.zza();
                            zztVarZza.zzm(MimeTypes.AUDIO_DTS_HD);
                            zzahjVar.zzZ = zztVarZza.zzM();
                        }
                    }
                }
            }
            zzahjVar.zzY.zzu(zzahjVar.zzZ);
            zzahjVar.zzV = false;
            zzA();
        }
        zzaem zzaemVar = zzahjVar.zzY;
        if (!this.zzai) {
            if (zzahjVar.zzh) {
                this.zzab &= -1073741825;
                if (!this.zzaj) {
                    zzeg zzegVar2 = this.zzo;
                    zzadbVar.zzc(zzegVar2.zzi(), 0, 1);
                    this.zzaf++;
                    if ((zzegVar2.zzi()[0] & 128) == 128) {
                        throw zzat.zzb("Extension bit is set in signal byte", null);
                    }
                    this.zzam = zzegVar2.zzi()[0];
                    this.zzaj = true;
                }
                byte b = this.zzam;
                if ((b & 1) == 1) {
                    int i7 = b & 2;
                    this.zzab |= 1073741824;
                    if (!this.zzan) {
                        zzeg zzegVar3 = this.zzt;
                        zzadbVar.zzc(zzegVar3.zzi(), 0, 8);
                        this.zzaf += 8;
                        this.zzan = true;
                        zzeg zzegVar4 = this.zzo;
                        zzegVar4.zzi()[0] = (byte) ((i7 != 2 ? 0 : 128) | 8);
                        zzegVar4.zzh(0);
                        zzaemVar.zzw(zzegVar4, 1, 1);
                        this.zzag++;
                        zzegVar3.zzh(0);
                        zzaemVar.zzw(zzegVar3, 8, 1);
                        this.zzag += 8;
                    }
                    if (i7 == 2) {
                        if (!this.zzak) {
                            zzeg zzegVar5 = this.zzo;
                            zzadbVar.zzc(zzegVar5.zzi(), 0, 1);
                            this.zzaf++;
                            zzegVar5.zzh(0);
                            this.zzal = zzegVar5.zzs();
                            this.zzak = true;
                        }
                        int i8 = this.zzal * 4;
                        zzeg zzegVar6 = this.zzo;
                        zzegVar6.zza(i8);
                        zzadbVar.zzc(zzegVar6.zzi(), 0, i8);
                        this.zzaf += i8;
                        int i9 = (this.zzal >> 1) + 1;
                        int i10 = (i9 * 6) + 2;
                        ByteBuffer byteBuffer = this.zzw;
                        if (byteBuffer == null || byteBuffer.capacity() < i10) {
                            this.zzw = ByteBuffer.allocate(i10);
                        }
                        this.zzw.position(0);
                        this.zzw.putShort((short) i9);
                        int i11 = 0;
                        int i12 = 0;
                        while (true) {
                            i2 = this.zzal;
                            if (i11 >= i2) {
                                break;
                            }
                            int iZzH = zzegVar6.zzH();
                            int i13 = iZzH - i12;
                            if (i11 % 2 == 0) {
                                this.zzw.putShort((short) i13);
                            } else {
                                this.zzw.putInt(i13);
                            }
                            i11++;
                            i12 = iZzH;
                        }
                        int i14 = (i - this.zzaf) - i12;
                        if ((i2 & 1) == 1) {
                            this.zzw.putInt(i14);
                        } else {
                            this.zzw.putShort((short) i14);
                            this.zzw.putInt(0);
                        }
                        zzeg zzegVar7 = this.zzu;
                        zzegVar7.zzb(this.zzw.array(), i10);
                        zzaemVar.zzw(zzegVar7, i10, 1);
                        this.zzag += i10;
                    }
                }
            } else {
                byte[] bArr2 = zzahjVar.zzi;
                if (bArr2 != null) {
                    this.zzr.zzb(bArr2, bArr2.length);
                }
            }
            if (!"A_OPUS".equals(zzahjVar.zzc) ? zzahjVar.zzg > 0 : z) {
                this.zzab |= 268435456;
                this.zzv.zza(0);
                int iZze = (this.zzr.zze() + i) - this.zzaf;
                zzeg zzegVar8 = this.zzo;
                zzegVar8.zza(4);
                zzegVar8.zzi()[0] = (byte) ((iZze >> 24) & 255);
                zzegVar8.zzi()[1] = (byte) ((iZze >> 16) & 255);
                zzegVar8.zzi()[2] = (byte) ((iZze >> 8) & 255);
                zzegVar8.zzi()[3] = (byte) (iZze & 255);
                zzaemVar.zzw(zzegVar8, 4, 2);
                this.zzag += 4;
            }
            this.zzai = true;
        }
        zzeg zzegVar9 = this.zzr;
        int iZze2 = i + zzegVar9.zze();
        if (!"V_MPEG4/ISO/AVC".equals(zzahjVar.zzc) && !"V_MPEGH/ISO/HEVC".equals(zzahjVar.zzc)) {
            if (zzahjVar.zzU != null) {
                zzgmd.zzh(zzegVar9.zze() == 0);
                zzahjVar.zzU.zzb(zzadbVar);
            }
            while (true) {
                int i15 = this.zzaf;
                if (i15 >= iZze2) {
                    break;
                }
                int iZzx = zzx(zzadbVar, zzaemVar, iZze2 - i15);
                this.zzaf += iZzx;
                this.zzag += iZzx;
            }
        } else {
            zzeg zzegVar10 = this.zzn;
            byte[] bArrZzi = zzegVar10.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 0;
            bArrZzi[2] = 0;
            int i16 = zzahjVar.zzaa;
            int i17 = 4 - i16;
            while (this.zzaf < iZze2) {
                int i18 = this.zzah;
                if (i18 == 0) {
                    int iMin = Math.min(i16, zzegVar9.zzd());
                    zzadbVar.zzc(bArrZzi, i17 + iMin, i16 - iMin);
                    if (iMin > 0) {
                        zzegVar9.zzm(bArrZzi, i17, iMin);
                    }
                    this.zzaf += i16;
                    zzegVar10.zzh(0);
                    this.zzah = zzegVar10.zzH();
                    zzeg zzegVar11 = this.zzm;
                    zzegVar11.zzh(0);
                    zzaemVar.zzz(zzegVar11, 4);
                    this.zzag += 4;
                } else {
                    int iZzx2 = zzx(zzadbVar, zzaemVar, i18);
                    this.zzaf += iZzx2;
                    this.zzag += iZzx2;
                    this.zzah -= iZzx2;
                }
            }
        }
        if ("A_VORBIS".equals(zzahjVar.zzc)) {
            zzeg zzegVar12 = this.zzp;
            zzegVar12.zzh(0);
            zzaemVar.zzz(zzegVar12, 4);
            this.zzag += 4;
        }
        int i19 = this.zzag;
        zzu();
        return i19;
    }

    private final void zzu() {
        this.zzaf = 0;
        this.zzag = 0;
        this.zzah = 0;
        this.zzai = false;
        this.zzaj = false;
        this.zzak = false;
        this.zzal = 0;
        this.zzam = (byte) 0;
        this.zzan = false;
        this.zzr.zza(0);
    }

    private final void zzv(zzadb zzadbVar, byte[] bArr, int i) throws IOException {
        int length = bArr.length;
        int i2 = length + i;
        zzeg zzegVar = this.zzs;
        if (zzegVar.zzj() < i2) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, i2 + i);
            zzegVar.zzb(bArrCopyOf, bArrCopyOf.length);
        } else {
            System.arraycopy(bArr, 0, zzegVar.zzi(), 0, length);
        }
        zzadbVar.zzc(zzegVar.zzi(), length, i);
        zzegVar.zzh(0);
        zzegVar.zzf(i2);
    }

    private static byte[] zzw(long j, String str, long j2) {
        zzgmd.zza(j != C.TIME_UNSET);
        Locale locale = Locale.US;
        int i = (int) (j / 3600000000L);
        Integer numValueOf = Integer.valueOf(i);
        long j3 = j - (((long) i) * 3600000000L);
        int i2 = (int) (j3 / 60000000);
        Integer numValueOf2 = Integer.valueOf(i2);
        long j4 = j3 - (((long) i2) * 60000000);
        int i3 = (int) (j4 / 1000000);
        String str2 = String.format(locale, str, numValueOf, numValueOf2, Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2)));
        String str3 = zzep.zza;
        return str2.getBytes(StandardCharsets.UTF_8);
    }

    private final int zzx(zzadb zzadbVar, zzaem zzaemVar, int i) throws IOException {
        zzeg zzegVar = this.zzr;
        int iZzd = zzegVar.zzd();
        if (iZzd <= 0) {
            return zzaemVar.zzy(zzadbVar, i, false);
        }
        int iMin = Math.min(i, iZzd);
        zzaemVar.zzz(zzegVar, iMin);
        return iMin;
    }

    private final long zzy(long j) throws zzat {
        long j2 = this.zzz;
        if (j2 != C.TIME_UNSET) {
            return zzep.zzt(j, j2, 1000L, RoundingMode.DOWN);
        }
        throw zzat.zzb("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private static int[] zzz(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        int length = iArr.length;
        return length >= i ? iArr : new int[Math.max(length + length, i)];
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        return new zzahl().zza(zzadbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ List zzb() {
        return zzgpe.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        if (this.zzk) {
            zzaddVar = new zzakj(zzaddVar, this.zzl);
        }
        this.zzao = zzaddVar;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        int i = 0;
        this.zzS = false;
        while (!this.zzS) {
            if (this.zzap.zzc(zzadbVar)) {
                long jZzn = zzadbVar.zzn();
                if (this.zzO) {
                    this.zzQ = jZzn;
                    zzaeaVar.zza = this.zzP;
                    this.zzO = false;
                    return 1;
                }
                if (this.zzF) {
                    long j = this.zzQ;
                    if (j != -1) {
                        zzaeaVar.zza = j;
                        this.zzQ = -1L;
                        return 1;
                    }
                }
            } else {
                while (true) {
                    SparseArray sparseArray = this.zzi;
                    if (i >= sparseArray.size()) {
                        return -1;
                    }
                    zzahj zzahjVar = (zzahj) sparseArray.valueAt(i);
                    zzahjVar.zzb();
                    zzaen zzaenVar = zzahjVar.zzU;
                    if (zzaenVar != null) {
                        zzaenVar.zzd(zzahjVar.zzY, zzahjVar.zzj);
                    }
                    i++;
                }
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        this.zzR = C.TIME_UNSET;
        int i = 0;
        this.zzT = 0;
        this.zzap.zzb();
        this.zzh.zza();
        zzu();
        this.zzJ = false;
        this.zzK = C.TIME_UNSET;
        this.zzL = -1;
        this.zzM = -1L;
        while (true) {
            SparseArray sparseArray = this.zzi;
            if (i >= sparseArray.size()) {
                return;
            }
            zzaen zzaenVar = ((zzahj) sparseArray.valueAt(i)).zzU;
            if (zzaenVar != null) {
                zzaenVar.zza();
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ zzada zzf() {
        return zzada.CC.$default$zzf(this);
    }

    zzahk(zzahd zzahdVar, int i, zzakg zzakgVar) {
        this.zzy = -1L;
        this.zzz = C.TIME_UNSET;
        this.zzA = C.TIME_UNSET;
        this.zzB = C.TIME_UNSET;
        this.zzK = C.TIME_UNSET;
        this.zzL = -1;
        this.zzM = -1L;
        this.zzN = -1;
        this.zzP = -1L;
        this.zzQ = -1L;
        this.zzR = C.TIME_UNSET;
        this.zzap = zzahdVar;
        zzahdVar.zza(new zzahf(this, null));
        this.zzl = zzakgVar;
        this.zzI = new SparseArray();
        this.zzj = 1 == ((i & 1) ^ 1);
        this.zzk = (i & 2) == 0;
        this.zzh = new zzahm();
        this.zzi = new SparseArray();
        this.zzo = new zzeg(4);
        this.zzp = new zzeg(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzq = new zzeg(4);
        this.zzm = new zzeg(zzfm.zza);
        this.zzn = new zzeg(4);
        this.zzr = new zzeg();
        this.zzs = new zzeg();
        this.zzt = new zzeg(8);
        this.zzu = new zzeg();
        this.zzv = new zzeg();
        this.zzY = new int[1];
        this.zzD = true;
    }

    protected final void zzg(int i, long j, long j2) throws zzat {
        zzadd zzaddVar = this.zzao;
        zzaddVar.getClass();
        if (i == 160) {
            this.zzad = false;
            this.zzae = 0L;
            return;
        }
        if (i == 174) {
            zzahj zzahjVar = new zzahj();
            this.zzE = zzahjVar;
            zzahjVar.zza = this.zzC;
            return;
        }
        if (i == 183) {
            zzq(i);
            this.zzL = -1;
            this.zzM = -1L;
            return;
        }
        if (i == 187) {
            zzq(i);
            this.zzK = C.TIME_UNSET;
            return;
        }
        if (i == 19899) {
            this.zzG = -1;
            this.zzH = -1L;
            return;
        }
        if (i == 20533) {
            zzp(i);
            this.zzE.zzh = true;
            return;
        }
        if (i == 21968) {
            zzp(i);
            this.zzE.zzy = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.zzy;
            if (j3 != -1 && j3 != j) {
                throw zzat.zzb("Multiple Segment elements not supported", null);
            }
            this.zzy = j;
            this.zzx = j2;
            return;
        }
        if (i == 475249515) {
            this.zzJ = true;
            return;
        }
        if (i == 524531317 && !this.zzF) {
            if (this.zzj && this.zzP != -1) {
                this.zzO = true;
            } else {
                zzaddVar.zzw(new zzaec(this.zzB, 0L));
                this.zzF = true;
            }
        }
    }

    protected final void zzk(int i, String str) throws zzat {
        if (i == 134) {
            zzp(i);
            this.zzE.zzc = str;
            return;
        }
        if (i != 17026) {
            if (i == 21358) {
                zzp(i);
                this.zzE.zzb = str;
                return;
            } else {
                if (i != 2274716) {
                    return;
                }
                zzp(i);
                this.zzE.zze(str);
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            this.zzC = Objects.equals(str, "webm");
            return;
        }
        StringBuilder sb = new StringBuilder(str.length() + 22);
        sb.append("DocType ");
        sb.append(str);
        sb.append(" not supported");
        throw zzat.zzb(sb.toString(), null);
    }

    protected final void zzl(int i, int i2, zzadb zzadbVar) throws IOException {
        zzahj zzahjVar;
        int i3;
        zzahj zzahjVar2;
        zzahj zzahjVar3;
        long j;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i;
        int i10 = 1;
        int i11 = 0;
        if (i9 != 161 && i9 != 163) {
            if (i9 == 165) {
                if (this.zzT != 2) {
                    return;
                }
                zzahj zzahjVar4 = (zzahj) this.zzi.get(this.zzZ);
                if (this.zzac != 4 || !"V_VP9".equals(zzahjVar4.zzc)) {
                    zzadbVar.zzf(i2);
                    return;
                }
                zzeg zzegVar = this.zzv;
                zzegVar.zza(i2);
                zzadbVar.zzc(zzegVar.zzi(), 0, i2);
                return;
            }
            if (i9 == 16877) {
                zzp(i);
                zzahj zzahjVar5 = this.zzE;
                if (zzahjVar5.zzc() != 1685485123 && zzahjVar5.zzc() != 1685480259) {
                    zzadbVar.zzf(i2);
                    return;
                } else {
                    zzahjVar5.zzO = new byte[i2];
                    zzadbVar.zzc(zzahjVar5.zzO, 0, i2);
                    return;
                }
            }
            if (i9 == 16981) {
                zzp(i);
                zzahj zzahjVar6 = this.zzE;
                zzahjVar6.zzi = new byte[i2];
                zzadbVar.zzc(zzahjVar6.zzi, 0, i2);
                return;
            }
            if (i9 == 18402) {
                byte[] bArr = new byte[i2];
                zzadbVar.zzc(bArr, 0, i2);
                zzp(i);
                this.zzE.zzj = new zzael(1, bArr, 0, 0);
                return;
            }
            if (i9 == 21419) {
                zzeg zzegVar2 = this.zzq;
                Arrays.fill(zzegVar2.zzi(), (byte) 0);
                zzadbVar.zzc(zzegVar2.zzi(), 4 - i2, i2);
                zzegVar2.zzh(0);
                this.zzG = (int) zzegVar2.zzz();
                return;
            }
            if (i9 == 25506) {
                zzp(i);
                zzahj zzahjVar7 = this.zzE;
                zzahjVar7.zzk = new byte[i2];
                zzadbVar.zzc(zzahjVar7.zzk, 0, i2);
                return;
            }
            if (i9 != 30322) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 15);
                sb.append("Unexpected id: ");
                sb.append(i9);
                throw zzat.zzb(sb.toString(), null);
            }
            zzp(i);
            zzahj zzahjVar8 = this.zzE;
            zzahjVar8.zzw = new byte[i2];
            zzadbVar.zzc(zzahjVar8.zzw, 0, i2);
            return;
        }
        int i12 = 8;
        if (this.zzT == 0) {
            zzahm zzahmVar = this.zzh;
            this.zzZ = (int) zzahmVar.zzb(zzadbVar, false, true, 8);
            this.zzaa = zzahmVar.zzc();
            this.zzV = C.TIME_UNSET;
            this.zzT = 1;
            this.zzo.zza(0);
        }
        zzahj zzahjVar9 = (zzahj) this.zzi.get(this.zzZ);
        if (zzahjVar9 == null) {
            zzadbVar.zzf(i2 - this.zzaa);
            this.zzT = 0;
            return;
        }
        zzahjVar9.zzb();
        if (this.zzT == 1) {
            zzs(zzadbVar, 3);
            zzeg zzegVar3 = this.zzo;
            int i13 = (zzegVar3.zzi()[2] & 6) >> 1;
            if (i13 == 0) {
                this.zzX = 1;
                int[] iArrZzz = zzz(this.zzY, 1);
                this.zzY = iArrZzz;
                iArrZzz[0] = (i2 - this.zzaa) - 3;
            } else {
                zzs(zzadbVar, 4);
                int i14 = (zzegVar3.zzi()[3] & 255) + 1;
                this.zzX = i14;
                int[] iArrZzz2 = zzz(this.zzY, i14);
                this.zzY = iArrZzz2;
                if (i13 == 2) {
                    int i15 = (i2 - this.zzaa) - 4;
                    int i16 = this.zzX;
                    Arrays.fill(iArrZzz2, 0, i16, i15 / i16);
                } else {
                    if (i13 != 1) {
                        if (i13 != 3) {
                            throw zzat.zzb("Unexpected lacing value: 2", null);
                        }
                        int i17 = 0;
                        int i18 = 0;
                        int i19 = 4;
                        while (true) {
                            int i20 = this.zzX - 1;
                            if (i17 >= i20) {
                                zzahjVar2 = zzahjVar9;
                                this.zzY[i20] = ((i2 - this.zzaa) - i19) - i18;
                                break;
                            }
                            this.zzY[i17] = i11;
                            int i21 = i19 + 1;
                            zzs(zzadbVar, i21);
                            if (zzegVar3.zzi()[i19] == 0) {
                                throw zzat.zzb("No valid varint length mask found", null);
                            }
                            int i22 = i11;
                            while (true) {
                                if (i22 >= i12) {
                                    zzahjVar3 = zzahjVar9;
                                    j = 0;
                                    break;
                                }
                                int i23 = i10 << (7 - i22);
                                if ((zzegVar3.zzi()[i19] & i23) != 0) {
                                    i21 += i22;
                                    zzs(zzadbVar, i21);
                                    j = zzegVar3.zzi()[i19] & 255 & (~i23);
                                    int i24 = i19 + 1;
                                    while (i24 < i21) {
                                        j = (j << i12) | ((long) (zzegVar3.zzi()[i24] & 255));
                                        i24++;
                                        zzahjVar9 = zzahjVar9;
                                        i12 = 8;
                                    }
                                    zzahjVar3 = zzahjVar9;
                                    if (i17 > 0) {
                                        j -= (1 << ((i22 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i22++;
                                    i10 = 1;
                                    i12 = 8;
                                }
                            }
                            i19 = i21;
                            if (j < -2147483648L || j > 2147483647L) {
                                break;
                            }
                            int[] iArr = this.zzY;
                            int i25 = (int) j;
                            if (i17 != 0) {
                                i25 += iArr[i17 - 1];
                            }
                            iArr[i17] = i25;
                            i18 += i25;
                            i17++;
                            zzahjVar9 = zzahjVar3;
                            i10 = 1;
                            i11 = 0;
                            i12 = 8;
                        }
                        throw zzat.zzb("EBML lacing sample size out of range.", null);
                    }
                    int i26 = 0;
                    int i27 = 0;
                    int i28 = 4;
                    while (true) {
                        i4 = this.zzX - 1;
                        if (i26 >= i4) {
                            break;
                        }
                        this.zzY[i26] = 0;
                        while (true) {
                            i5 = i28 + 1;
                            zzs(zzadbVar, i5);
                            int i29 = zzegVar3.zzi()[i28] & 255;
                            int[] iArr2 = this.zzY;
                            i6 = iArr2[i26] + i29;
                            iArr2[i26] = i6;
                            if (i29 != 255) {
                                break;
                            } else {
                                i28 = i5;
                            }
                        }
                        i27 += i6;
                        i26++;
                        i28 = i5;
                    }
                    this.zzY[i4] = ((i2 - this.zzaa) - i28) - i27;
                }
            }
            zzahjVar2 = zzahjVar9;
            this.zzU = this.zzR + zzy((zzegVar3.zzi()[0] << 8) | (zzegVar3.zzi()[1] & 255));
            zzahjVar = zzahjVar2;
            if (zzahjVar.zze != 1) {
                if (i9 == 163) {
                    i7 = 2;
                    if ((zzegVar3.zzi()[2] & 128) == 128) {
                        i9 = 163;
                    } else {
                        i9 = 163;
                    }
                } else {
                    i7 = 2;
                }
                i8 = 0;
                this.zzab = i8;
                this.zzT = i7;
                this.zzW = 0;
                i3 = 163;
            } else {
                i7 = 2;
            }
            i8 = 1;
            this.zzab = i8;
            this.zzT = i7;
            this.zzW = 0;
            i3 = 163;
        } else {
            zzahjVar = zzahjVar9;
            i3 = 163;
        }
        if (i9 == i3) {
            while (true) {
                int i30 = this.zzW;
                if (i30 >= this.zzX) {
                    this.zzT = 0;
                    return;
                }
                zzr(zzahjVar, ((long) ((this.zzW * zzahjVar.zzf) / 1000)) + this.zzU, this.zzab, zzt(zzadbVar, zzahjVar, this.zzY[i30], false), 0);
                this.zzW++;
            }
        } else {
            while (true) {
                int i31 = this.zzW;
                if (i31 >= this.zzX) {
                    return;
                }
                int[] iArr3 = this.zzY;
                iArr3[i31] = zzt(zzadbVar, zzahjVar, iArr3[i31], true);
                this.zzW++;
            }
        }
    }

    public zzahk(zzakg zzakgVar, int i) {
        this(new zzahd(), 0, zzakgVar);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    protected final void zzh(int i) throws zzat {
        int i2;
        int i3;
        zzadd zzaddVar = this.zzao;
        zzaddVar.getClass();
        byte b = 8;
        if (i == 160) {
            if (this.zzT == 2) {
                zzahj zzahjVar = (zzahj) this.zzi.get(this.zzZ);
                zzahjVar.zzb();
                if (this.zzae > 0 && "A_OPUS".equals(zzahjVar.zzc)) {
                    zzeg zzegVar = this.zzv;
                    byte[] bArrArray = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzae).array();
                    zzegVar.zzb(bArrArray, bArrArray.length);
                }
                int i4 = 0;
                for (int i5 = 0; i5 < this.zzX; i5++) {
                    i4 += this.zzY[i5];
                }
                int i6 = 0;
                while (i6 < this.zzX) {
                    long j = this.zzU + ((long) ((zzahjVar.zzf * i6) / 1000));
                    int i7 = this.zzab;
                    if (i6 == 0) {
                        if (!this.zzad) {
                            i7 |= 1;
                        }
                        i2 = 0;
                    } else {
                        i2 = i6;
                    }
                    int i8 = this.zzY[i2];
                    int i9 = i4 - i8;
                    zzr(zzahjVar, j, i7, i8, i9);
                    i6 = i2 + 1;
                    i4 = i9;
                }
                this.zzT = 0;
                return;
            }
            return;
        }
        if (i != 174) {
            if (i == 183) {
                zzq(i);
                if (this.zzK == C.TIME_UNSET || (i3 = this.zzL) == -1 || this.zzM == -1) {
                    return;
                }
                SparseArray sparseArray = this.zzI;
                List arrayList = (List) sparseArray.get(i3);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    sparseArray.put(this.zzL, arrayList);
                }
                arrayList.add(new zzahh(this.zzK, this.zzy + this.zzM));
                return;
            }
            if (i == 19899) {
                int i10 = this.zzG;
                if (i10 != -1) {
                    long j2 = this.zzH;
                    if (j2 != -1) {
                        if (i10 == 475249515) {
                            this.zzP = j2;
                            return;
                        }
                        return;
                    }
                }
                throw zzat.zzb("Mandatory element SeekID or SeekPosition not found", null);
            }
            if (i == 25152) {
                zzp(i);
                zzahj zzahjVar2 = this.zzE;
                if (zzahjVar2.zzh) {
                    if (zzahjVar2.zzj == null) {
                        throw zzat.zzb("Encrypted Track found but ContentEncKeyID was not found", null);
                    }
                    zzahjVar2.zzl = new zzq(null, new zzp(zzg.zza, null, "video/webm", this.zzE.zzj.zzb));
                    return;
                }
                return;
            }
            if (i == 28032) {
                zzp(i);
                zzahj zzahjVar3 = this.zzE;
                if (zzahjVar3.zzh && zzahjVar3.zzi != null) {
                    throw zzat.zzb("Combining encryption and compression is not supported", null);
                }
                return;
            }
            if (i == 357149030) {
                if (this.zzz == C.TIME_UNSET) {
                    this.zzz = 1000000L;
                }
                long j3 = this.zzA;
                if (j3 != C.TIME_UNSET) {
                    this.zzB = zzy(j3);
                    return;
                }
                return;
            }
            if (i != 374648427) {
                if (i != 475249515) {
                    return;
                }
                if (!this.zzF) {
                    int i11 = 0;
                    while (true) {
                        SparseArray sparseArray2 = this.zzI;
                        if (i11 >= sparseArray2.size()) {
                            break;
                        }
                        if (((List) sparseArray2.valueAt(i11)).isEmpty()) {
                            i11++;
                        } else {
                            if (this.zzB == C.TIME_UNSET) {
                                break;
                            }
                            for (int i12 = 0; i12 < sparseArray2.size(); i12++) {
                                Collections.sort((List) sparseArray2.valueAt(i12));
                            }
                            this.zzao.zzw(new zzahi(sparseArray2, this.zzB, this.zzN, this.zzy, this.zzx));
                        }
                    }
                    this.zzao.zzw(new zzaec(this.zzB, 0L));
                    this.zzF = true;
                }
                this.zzJ = false;
                return;
            }
            SparseArray sparseArray3 = this.zzi;
            if (sparseArray3.size() == 0) {
                throw zzat.zzb("No valid tracks were found", null);
            }
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int i16 = -1;
            for (int i17 = 0; i17 < sparseArray3.size(); i17++) {
                zzahj zzahjVar4 = (zzahj) sparseArray3.valueAt(i17);
                int i18 = zzahjVar4.zze;
                if (i18 == 2) {
                    if (zzahjVar4.zzX) {
                        i13 = zzahjVar4.zzd;
                    }
                    if (i14 == -1) {
                        i14 = zzahjVar4.zzd;
                    }
                } else if (i18 == 1) {
                    if (zzahjVar4.zzX) {
                        i15 = zzahjVar4.zzd;
                    }
                    if (i16 == -1) {
                        i16 = zzahjVar4.zzd;
                    }
                }
            }
            if (i13 != -1) {
                this.zzN = i13;
            } else if (i14 != -1) {
                this.zzN = i14;
            } else if (i15 != -1) {
                this.zzN = i15;
            } else if (i16 != -1) {
                this.zzN = i16;
            } else {
                this.zzN = sparseArray3.size() > 0 ? ((zzahj) sparseArray3.valueAt(0)).zzd : -1;
            }
            zzA();
            return;
        }
        zzahj zzahjVar5 = this.zzE;
        zzahjVar5.getClass();
        String str = zzahjVar5.zzc;
        if (str == null) {
            throw zzat.zzb("CodecId is missing in TrackEntry element", null);
        }
        switch (str.hashCode()) {
            case -2095576542:
                b = str.equals("V_MPEG4/ISO/AP") ? (byte) 6 : (byte) -1;
                break;
            case -2095575984:
                b = str.equals("V_MPEG4/ISO/SP") ? (byte) 4 : (byte) -1;
                break;
            case -1985379776:
                b = str.equals("A_MS/ACM") ? Ascii.ETB : (byte) -1;
                break;
            case -1784763192:
                b = str.equals("A_TRUEHD") ? Ascii.DC2 : (byte) -1;
                break;
            case -1730367663:
                b = str.equals("A_VORBIS") ? Ascii.FF : (byte) -1;
                break;
            case -1482641358:
                b = str.equals("A_MPEG/L2") ? Ascii.SO : (byte) -1;
                break;
            case -1482641357:
                b = str.equals("A_MPEG/L3") ? Ascii.SI : (byte) -1;
                break;
            case -1373388978:
                b = str.equals("V_MS/VFW/FOURCC") ? (byte) 9 : (byte) -1;
                break;
            case -933872740:
                b = str.equals("S_DVBSUB") ? (byte) 33 : (byte) -1;
                break;
            case -538363189:
                b = str.equals("V_MPEG4/ISO/ASP") ? (byte) 5 : (byte) -1;
                break;
            case -538363109:
                b = str.equals("V_MPEG4/ISO/AVC") ? (byte) 7 : (byte) -1;
                break;
            case -425012669:
                b = str.equals("S_VOBSUB") ? Ascii.US : (byte) -1;
                break;
            case -356037306:
                b = str.equals("A_DTS/LOSSLESS") ? Ascii.NAK : (byte) -1;
                break;
            case 62923557:
                b = str.equals("A_AAC") ? Ascii.CR : (byte) -1;
                break;
            case 62923603:
                b = str.equals("A_AC3") ? Ascii.DLE : (byte) -1;
                break;
            case 62927045:
                b = str.equals("A_DTS") ? (byte) 19 : (byte) -1;
                break;
            case 82318131:
                b = str.equals("V_AV1") ? (byte) 2 : (byte) -1;
                break;
            case 82338133:
                b = str.equals("V_VP8") ? (byte) 0 : (byte) -1;
                break;
            case 82338134:
                b = str.equals("V_VP9") ? (byte) 1 : (byte) -1;
                break;
            case 99146302:
                b = str.equals("S_HDMV/PGS") ? (byte) 32 : (byte) -1;
                break;
            case 444813526:
                b = str.equals("V_THEORA") ? (byte) 10 : (byte) -1;
                break;
            case 542569478:
                b = str.equals("A_DTS/EXPRESS") ? Ascii.DC4 : (byte) -1;
                break;
            case 635596514:
                b = str.equals("A_PCM/FLOAT/IEEE") ? Ascii.SUB : (byte) -1;
                break;
            case 725948237:
                b = str.equals("A_PCM/INT/BIG") ? Ascii.EM : (byte) -1;
                break;
            case 725957860:
                b = str.equals("A_PCM/INT/LIT") ? Ascii.CAN : (byte) -1;
                break;
            case 738597099:
                b = str.equals("S_TEXT/ASS") ? Ascii.FS : (byte) -1;
                break;
            case 738614379:
                b = str.equals("S_TEXT/SSA") ? Ascii.GS : (byte) -1;
                break;
            case 855502857:
                if (!str.equals("V_MPEGH/ISO/HEVC")) {
                    b = -1;
                }
                break;
            case 1045209816:
                b = str.equals("S_TEXT/WEBVTT") ? Ascii.RS : (byte) -1;
                break;
            case 1422270023:
                b = str.equals("S_TEXT/UTF8") ? Ascii.ESC : (byte) -1;
                break;
            case 1809237540:
                b = str.equals("V_MPEG2") ? (byte) 3 : (byte) -1;
                break;
            case 1950749482:
                b = str.equals("A_EAC3") ? (byte) 17 : (byte) -1;
                break;
            case 1950789798:
                b = str.equals("A_FLAC") ? Ascii.SYN : (byte) -1;
                break;
            case 1951062397:
                b = str.equals("A_OPUS") ? Ascii.VT : (byte) -1;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
                zzahjVar5.zza(zzaddVar, zzahjVar5.zzd);
                this.zzi.put(zzahjVar5.zzd, zzahjVar5);
                break;
        }
        this.zzE = null;
    }

    protected final void zzj(int i, double d) throws zzat {
        if (i == 181) {
            zzp(i);
            this.zzE.zzR = (int) d;
            return;
        }
        if (i == 17545) {
            this.zzA = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                zzp(i);
                this.zzE.zzE = (float) d;
                break;
            case 21970:
                zzp(i);
                this.zzE.zzF = (float) d;
                break;
            case 21971:
                zzp(i);
                this.zzE.zzG = (float) d;
                break;
            case 21972:
                zzp(i);
                this.zzE.zzH = (float) d;
                break;
            case 21973:
                zzp(i);
                this.zzE.zzI = (float) d;
                break;
            case 21974:
                zzp(i);
                this.zzE.zzJ = (float) d;
                break;
            case 21975:
                zzp(i);
                this.zzE.zzK = (float) d;
                break;
            case 21976:
                zzp(i);
                this.zzE.zzL = (float) d;
                break;
            case 21977:
                zzp(i);
                this.zzE.zzM = (float) d;
                break;
            case 21978:
                zzp(i);
                this.zzE.zzN = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        zzp(i);
                        this.zzE.zzt = (float) d;
                        break;
                    case 30324:
                        zzp(i);
                        this.zzE.zzu = (float) d;
                        break;
                    case 30325:
                        zzp(i);
                        this.zzE.zzv = (float) d;
                        break;
                }
                break;
        }
    }

    protected final void zzi(int i, long j) throws zzat {
        boolean z;
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 35);
            sb.append("ContentEncodingOrder ");
            sb.append(j);
            sb.append(" not supported");
            throw zzat.zzb(sb.toString(), null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(j).length() + 35);
            sb2.append("ContentEncodingScope ");
            sb2.append(j);
            sb2.append(" not supported");
            throw zzat.zzb(sb2.toString(), null);
        }
        switch (i) {
            case 131:
                int i2 = (int) j;
                if (i2 == 1) {
                    zzp(i);
                    this.zzE.zze = 2;
                    return;
                }
                if (i2 == 2) {
                    zzp(i);
                    this.zzE.zze = 1;
                    return;
                } else if (i2 == 17) {
                    zzp(i);
                    this.zzE.zze = 3;
                    return;
                } else if (i2 != 33) {
                    zzp(i);
                    this.zzE.zze = -1;
                    return;
                } else {
                    zzp(i);
                    this.zzE.zze = 5;
                    return;
                }
            case 136:
                z = j == 1;
                zzp(i);
                this.zzE.zzX = z;
                return;
            case 155:
                this.zzV = zzy(j);
                return;
            case 159:
                zzp(i);
                this.zzE.zzP = (int) j;
                return;
            case 176:
                zzp(i);
                this.zzE.zzm = (int) j;
                return;
            case 179:
                zzq(i);
                this.zzK = zzy(j);
                return;
            case 186:
                zzp(i);
                this.zzE.zzn = (int) j;
                return;
            case 215:
                zzp(i);
                this.zzE.zzd = (int) j;
                return;
            case 231:
                this.zzR = zzy(j);
                return;
            case 238:
                this.zzac = (int) j;
                return;
            case 241:
                zzq(i);
                if (this.zzM == -1) {
                    this.zzM = j;
                    return;
                }
                return;
            case 247:
                zzq(i);
                this.zzL = (int) j;
                return;
            case 251:
                this.zzad = true;
                return;
            case 16871:
                zzp(i);
                this.zzE.zzd((int) j);
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(String.valueOf(j).length() + 30);
                sb3.append("ContentCompAlgo ");
                sb3.append(j);
                sb3.append(" not supported");
                throw zzat.zzb(sb3.toString(), null);
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb4 = new StringBuilder(String.valueOf(j).length() + 33);
                    sb4.append("DocTypeReadVersion ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw zzat.zzb(sb4.toString(), null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(String.valueOf(j).length() + 30);
                sb5.append("EBMLReadVersion ");
                sb5.append(j);
                sb5.append(" not supported");
                throw zzat.zzb(sb5.toString(), null);
            case 18401:
                if (j == 5) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(String.valueOf(j).length() + 29);
                sb6.append("ContentEncAlgo ");
                sb6.append(j);
                sb6.append(" not supported");
                throw zzat.zzb(sb6.toString(), null);
            case 18408:
                if (j == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(String.valueOf(j).length() + 36);
                sb7.append("AESSettingsCipherMode ");
                sb7.append(j);
                sb7.append(" not supported");
                throw zzat.zzb(sb7.toString(), null);
            case 21420:
                this.zzH = j + this.zzy;
                return;
            case 21432:
                int i3 = (int) j;
                zzp(i);
                if (i3 == 0) {
                    this.zzE.zzx = 0;
                    return;
                }
                if (i3 == 1) {
                    this.zzE.zzx = 2;
                    return;
                } else if (i3 == 3) {
                    this.zzE.zzx = 1;
                    return;
                } else {
                    if (i3 != 15) {
                        return;
                    }
                    this.zzE.zzx = 3;
                    return;
                }
            case 21680:
                zzp(i);
                this.zzE.zzp = (int) j;
                return;
            case 21682:
                zzp(i);
                this.zzE.zzr = (int) j;
                return;
            case 21690:
                zzp(i);
                this.zzE.zzq = (int) j;
                return;
            case 21930:
                z = j == 1;
                zzp(i);
                this.zzE.zzW = z;
                return;
            case 21938:
                zzp(i);
                zzahj zzahjVar = this.zzE;
                zzahjVar.zzy = true;
                zzahjVar.zzo = (int) j;
                return;
            case 21998:
                zzp(i);
                this.zzE.zzg = (int) j;
                return;
            case 22186:
                zzp(i);
                this.zzE.zzS = j;
                return;
            case 22203:
                zzp(i);
                this.zzE.zzT = j;
                return;
            case 25188:
                zzp(i);
                this.zzE.zzQ = (int) j;
                return;
            case 30114:
                this.zzae = j;
                return;
            case 30321:
                int i4 = (int) j;
                zzp(i);
                if (i4 == 0) {
                    this.zzE.zzs = 0;
                    return;
                }
                if (i4 == 1) {
                    this.zzE.zzs = 1;
                    return;
                } else if (i4 == 2) {
                    this.zzE.zzs = 2;
                    return;
                } else {
                    if (i4 != 3) {
                        return;
                    }
                    this.zzE.zzs = 3;
                    return;
                }
            case 2352003:
                zzp(i);
                this.zzE.zzf = (int) j;
                return;
            case 2807729:
                this.zzz = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i5 = (int) j;
                        zzp(i);
                        if (i5 == 1) {
                            this.zzE.zzB = 2;
                            return;
                        } else {
                            if (i5 != 2) {
                                return;
                            }
                            this.zzE.zzB = 1;
                            return;
                        }
                    case 21946:
                        zzp(i);
                        int iZzc = zzi.zzc((int) j);
                        if (iZzc != -1) {
                            this.zzE.zzA = iZzc;
                            return;
                        }
                        return;
                    case 21947:
                        zzp(i);
                        this.zzE.zzy = true;
                        int iZzb = zzi.zzb((int) j);
                        if (iZzb != -1) {
                            this.zzE.zzz = iZzb;
                            return;
                        }
                        return;
                    case 21948:
                        zzp(i);
                        this.zzE.zzC = (int) j;
                        return;
                    case 21949:
                        zzp(i);
                        this.zzE.zzD = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }
}
