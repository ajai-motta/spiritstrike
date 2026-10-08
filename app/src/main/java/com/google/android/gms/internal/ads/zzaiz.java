package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.internal.ads.zzada;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaiz implements zzada {
    public static final /* synthetic */ int zza = 0;
    private int zzA;
    private zzafz zzB;
    private final zzakg zzb;
    private final int zzc;
    private final zzeg zzd;
    private final zzeg zze;
    private final zzeg zzf;
    private final zzeg zzg;
    private final ArrayDeque zzh;
    private final zzajd zzi;
    private final List zzj;
    private zzgpe zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private int zzo;
    private zzeg zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private long zzw;
    private zzadd zzx;
    private zzaiy[] zzy;
    private long[][] zzz;

    static {
        int i = zzaiv.zza;
    }

    @Deprecated
    public zzaiz() {
        this(zzakg.zza, 16);
    }

    static /* synthetic */ long zzg(zzaji zzajiVar, long j, long j2) {
        int iZzk = zzk(zzajiVar, j);
        return iZzk == -1 ? j2 : Math.min(zzajiVar.zzc[iZzk], j2);
    }

    private final void zzi() {
        this.zzl = 0;
        this.zzo = 0;
    }

    private final void zzj(long j) throws zzat {
        zzap zzapVar;
        List list;
        int i;
        ArrayDeque arrayDeque;
        while (true) {
            ArrayDeque arrayDeque2 = this.zzh;
            if (arrayDeque2.isEmpty() || ((zzeu) arrayDeque2.peek()).zza != j) {
                break;
            }
            zzeu zzeuVar = (zzeu) arrayDeque2.pop();
            if (zzeuVar.zzd == 1836019574) {
                zzeu zzeuVarZzd = zzeuVar.zzd(Atom.TYPE_meta);
                new ArrayList();
                zzap zzapVarZze = zzeuVarZzd != null ? zzaik.zze(zzeuVarZzd) : null;
                ArrayList arrayList = new ArrayList();
                int i2 = 0;
                boolean z = this.zzA == 1;
                zzads zzadsVar = new zzads();
                zzev zzevVarZzc = zzeuVar.zzc(Atom.TYPE_udta);
                if (zzevVarZzc != null) {
                    zzap zzapVarZzc = zzaik.zzc(zzevVarZzc);
                    zzadsVar.zza(zzapVarZzc);
                    zzapVar = zzapVarZzc;
                } else {
                    zzapVar = null;
                }
                zzev zzevVarZzc2 = zzeuVar.zzc(Atom.TYPE_mvhd);
                zzevVarZzc2.getClass();
                zzap zzapVar2 = new zzap(C.TIME_UNSET, zzaik.zzd(zzevVarZzc2.zza));
                int i3 = this.zzc;
                List listZzb = zzaik.zzb(zzeuVar, zzadsVar, C.TIME_UNSET, null, 1 == (i3 & 1), z, zzaiw.zza, false);
                String strZza = zzaiu.zza(listZzb);
                int i4 = 0;
                int i5 = 0;
                long j2 = -9223372036854775807L;
                int size = -1;
                while (i4 < listZzb.size()) {
                    zzaji zzajiVar = (zzaji) listZzb.get(i4);
                    if (zzajiVar.zzb == 0) {
                        arrayDeque = arrayDeque2;
                        list = listZzb;
                        i = i4;
                    } else {
                        zzajf zzajfVar = zzajiVar.zza;
                        zzadd zzaddVar = this.zzx;
                        int i6 = i5 + 1;
                        list = listZzb;
                        int i7 = zzajfVar.zzb;
                        zzaiy zzaiyVar = new zzaiy(zzajfVar, zzajiVar, zzaddVar.zzu(i5, i7));
                        i = i4;
                        long j3 = zzajfVar.zze;
                        if (j3 == C.TIME_UNSET) {
                            j3 = zzajiVar.zzh;
                        }
                        arrayDeque = arrayDeque2;
                        zzaem zzaemVar = zzaiyVar.zzc;
                        long jMax = Math.max(j2, j3);
                        zzv zzvVar = zzajfVar.zzg;
                        String str = zzvVar.zzo;
                        int i8 = MimeTypes.AUDIO_TRUEHD.equals(str) ? zzajiVar.zze * 16 : zzajiVar.zze + 30;
                        zzt zztVarZza = zzvVar.zza();
                        zztVarZza.zzn(i8);
                        if (i7 == 2) {
                            int i9 = zzvVar.zzf;
                            if ((i3 & 8) != 0) {
                                i9 |= size == -1 ? 1 : 2;
                            }
                            zztVarZza.zzg(i9);
                            i7 = 2;
                        }
                        zzait.zzb(i7, zzadsVar, zztVarZza);
                        zzap zzapVar3 = zzvVar.zzl;
                        List list2 = this.zzj;
                        zzap[] zzapVarArr = new zzap[3];
                        zzapVarArr[0] = list2.isEmpty() ? null : new zzap(list2);
                        zzapVarArr[1] = zzapVar;
                        zzapVarArr[2] = zzapVar2;
                        zzait.zza(i7, zzapVarZze, zztVarZza, zzapVar3, zzapVarArr);
                        zztVarZza.zzl(strZza);
                        if (Objects.equals(str, MimeTypes.AUDIO_MPEG)) {
                            zzaiyVar.zzf = zztVarZza.zzM();
                        } else {
                            zzaemVar.zzu(zztVarZza.zzM());
                        }
                        if (i7 == 2 && size == -1) {
                            size = arrayList.size();
                        }
                        arrayList.add(zzaiyVar);
                        i5 = i6;
                        j2 = jMax;
                    }
                    i4 = i + 1;
                    listZzb = list;
                    arrayDeque2 = arrayDeque;
                    i2 = 0;
                }
                ArrayDeque arrayDeque3 = arrayDeque2;
                int i10 = -1;
                zzaiy[] zzaiyVarArr = (zzaiy[]) arrayList.toArray(new zzaiy[i2]);
                this.zzy = zzaiyVarArr;
                int length = zzaiyVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i11 = 0; i11 < zzaiyVarArr.length; i11++) {
                    jArr[i11] = new long[zzaiyVarArr[i11].zzb.zzb];
                    jArr2[i11] = zzaiyVarArr[i11].zzb.zzf[0];
                }
                int i12 = 0;
                long j4 = 0;
                int i13 = 0;
                while (i13 < zzaiyVarArr.length) {
                    long j5 = Long.MAX_VALUE;
                    int i14 = i10;
                    for (int i15 = i12; i15 < zzaiyVarArr.length; i15++) {
                        if (!zArr[i15]) {
                            long j6 = jArr2[i15];
                            if (j6 <= j5) {
                                i14 = i15;
                                j5 = j6;
                            }
                        }
                    }
                    int i16 = iArr[i14];
                    long[] jArr3 = jArr[i14];
                    jArr3[i16] = j4;
                    zzaji zzajiVar2 = zzaiyVarArr[i14].zzb;
                    zzaiy[] zzaiyVarArr2 = zzaiyVarArr;
                    long j7 = j2;
                    j4 += (long) zzajiVar2.zzd[i16];
                    int i17 = i16 + 1;
                    iArr[i14] = i17;
                    if (i17 < jArr3.length) {
                        jArr2[i14] = zzajiVar2.zzf[i17];
                    } else {
                        zArr[i14] = true;
                        i13++;
                    }
                    zzaiyVarArr = zzaiyVarArr2;
                    j2 = j7;
                    i12 = 0;
                    i10 = -1;
                }
                this.zzz = jArr;
                this.zzx.zzv();
                this.zzx.zzw(new zzaix(j2, this.zzy, size));
                arrayDeque3.clear();
                this.zzl = 2;
            } else if (!arrayDeque2.isEmpty()) {
                ((zzeu) arrayDeque2.peek()).zzb(zzeuVar);
            }
        }
        if (this.zzl != 2) {
            zzi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzk(zzaji zzajiVar, long j) {
        int iZza = zzajiVar.zza(j);
        return iZza == -1 ? zzajiVar.zzb(j) : iZza;
    }

    private static int zzl(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        zzaeh zzaehVarZzb = zzaje.zzb(zzadbVar, (this.zzc & 2) != 0);
        this.zzk = zzaehVarZzb != null ? zzgpe.zzj(zzaehVarZzb) : zzgpe.zzi();
        return zzaehVarZzb == null;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        if ((this.zzc & 16) == 0) {
            zzaddVar = new zzakj(zzaddVar, this.zzb);
        }
        this.zzx = zzaddVar;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        this.zzh.clear();
        this.zzo = 0;
        this.zzq = -1;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = false;
        if (j == 0) {
            if (this.zzl != 3) {
                zzi();
                return;
            } else {
                this.zzi.zza();
                this.zzj.clear();
                return;
            }
        }
        for (zzaiy zzaiyVar : this.zzy) {
            zzaji zzajiVar = zzaiyVar.zzb;
            int iZza = zzajiVar.zza(j2);
            if (iZza == -1) {
                iZza = zzajiVar.zzb(j2);
            }
            zzaiyVar.zze = iZza;
            zzaen zzaenVar = zzaiyVar.zzd;
            if (zzaenVar != null) {
                zzaenVar.zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ zzada zzf() {
        return zzada.CC.$default$zzf(this);
    }

    public zzaiz(zzakg zzakgVar, int i) {
        this.zzb = zzakgVar;
        this.zzc = i;
        this.zzk = zzgpe.zzi();
        this.zzl = (i & 4) != 0 ? 3 : 0;
        this.zzi = new zzajd();
        this.zzj = new ArrayList();
        this.zzg = new zzeg(16);
        this.zzh = new ArrayDeque();
        this.zzd = new zzeg(zzfm.zza);
        this.zze = new zzeg(6);
        this.zzf = new zzeg();
        this.zzq = -1;
        this.zzx = zzadd.zza;
        this.zzy = new zzaiy[0];
    }

    /* JADX WARN: Removed duplicated region for block: B:312:0x0098 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0092  */
    @Override // com.google.android.gms.internal.ads.zzada
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzadb r33, com.google.android.gms.internal.ads.zzaea r34) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiz.zzd(com.google.android.gms.internal.ads.zzadb, com.google.android.gms.internal.ads.zzaea):int");
    }
}
