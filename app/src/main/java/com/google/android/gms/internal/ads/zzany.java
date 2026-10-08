package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzany implements zzanq {
    final /* synthetic */ zzaoa zza;
    private final zzef zzb;
    private final SparseArray zzc;
    private final SparseIntArray zzd;
    private final int zze;

    public zzany(zzaoa zzaoaVar, int i) {
        Objects.requireNonNull(zzaoaVar);
        this.zza = zzaoaVar;
        this.zzb = new zzef(new byte[5], 5);
        this.zzc = new SparseArray();
        this.zzd = new SparseIntArray();
        this.zze = i;
    }

    @Override // com.google.android.gms.internal.ads.zzanq
    public final void zza(zzem zzemVar, zzadd zzaddVar, zzaoe zzaoeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzanq
    public final void zzb(zzeg zzegVar) {
        zzem zzemVar;
        int i;
        zzem zzemVar2;
        int i2;
        zzef zzefVar;
        int i3;
        if (zzegVar.zzs() == 2) {
            zzaoa zzaoaVar = this.zza;
            zzem zzemVar3 = (zzem) zzaoaVar.zzg().get(0);
            if ((zzegVar.zzs() & 128) != 0) {
                zzegVar.zzk(1);
                int iZzt = zzegVar.zzt();
                int i4 = 3;
                zzegVar.zzk(3);
                zzef zzefVar2 = this.zzb;
                zzegVar.zzl(zzefVar2, 2);
                zzefVar2.zzh(3);
                int i5 = 13;
                zzaoaVar.zzp(zzefVar2.zzj(13));
                zzegVar.zzl(zzefVar2, 2);
                int i6 = 4;
                zzefVar2.zzh(4);
                int i7 = 12;
                zzegVar.zzk(zzefVar2.zzj(12));
                SparseArray sparseArray = this.zzc;
                sparseArray.clear();
                SparseIntArray sparseIntArray = this.zzd;
                sparseIntArray.clear();
                int iZzd = zzegVar.zzd();
                while (iZzd > 0) {
                    int i8 = 5;
                    zzegVar.zzl(zzefVar2, 5);
                    int iZzj = zzefVar2.zzj(8);
                    zzefVar2.zzh(i4);
                    int iZzj2 = zzefVar2.zzj(i5);
                    zzefVar2.zzh(i6);
                    int iZzj3 = zzefVar2.zzj(i7);
                    int iZzg = zzegVar.zzg();
                    int i9 = iZzg + iZzj3;
                    String str = null;
                    ArrayList arrayList = null;
                    int i10 = -1;
                    int iZzs = 0;
                    while (zzegVar.zzg() < i9) {
                        int iZzs2 = zzegVar.zzs();
                        int iZzg2 = zzegVar.zzg() + zzegVar.zzs();
                        if (iZzg2 > i9) {
                            break;
                        }
                        if (iZzs2 == i8) {
                            long jZzz = zzegVar.zzz();
                            if (jZzz != 1094921523) {
                                if (jZzz != 1161904947) {
                                    if (jZzz != 1094921524) {
                                        if (jZzz == 1212503619) {
                                            i3 = 36;
                                            i10 = i3;
                                        }
                                        zzemVar2 = zzemVar3;
                                        i2 = iZzt;
                                        zzefVar = zzefVar2;
                                    }
                                    zzemVar2 = zzemVar3;
                                    i2 = iZzt;
                                    zzefVar = zzefVar2;
                                    i10 = 172;
                                }
                                zzemVar2 = zzemVar3;
                                i2 = iZzt;
                                zzefVar = zzefVar2;
                                i10 = 135;
                            }
                            zzemVar2 = zzemVar3;
                            i2 = iZzt;
                            zzefVar = zzefVar2;
                            i10 = 129;
                        } else {
                            if (iZzs2 != 106) {
                                if (iZzs2 != 122) {
                                    if (iZzs2 == 127) {
                                        int iZzs3 = zzegVar.zzs();
                                        if (iZzs3 != 21) {
                                            if (iZzs3 == 14) {
                                                i3 = 136;
                                            } else {
                                                if (iZzs3 == 33) {
                                                    i3 = 139;
                                                }
                                                zzemVar2 = zzemVar3;
                                                i2 = iZzt;
                                                zzefVar = zzefVar2;
                                            }
                                            i10 = i3;
                                            zzemVar2 = zzemVar3;
                                            i2 = iZzt;
                                            zzefVar = zzefVar2;
                                        }
                                        zzemVar2 = zzemVar3;
                                        i2 = iZzt;
                                        zzefVar = zzefVar2;
                                        i10 = 172;
                                    } else if (iZzs2 == 123) {
                                        i3 = TsExtractor.TS_STREAM_TYPE_DTS;
                                        i10 = i3;
                                        zzemVar2 = zzemVar3;
                                        i2 = iZzt;
                                        zzefVar = zzefVar2;
                                    } else if (iZzs2 == 10) {
                                        String strTrim = zzegVar.zzK(3, StandardCharsets.UTF_8).trim();
                                        iZzs = zzegVar.zzs();
                                        str = strTrim;
                                        zzemVar2 = zzemVar3;
                                        i2 = iZzt;
                                        zzefVar = zzefVar2;
                                    } else if (iZzs2 == 89) {
                                        ArrayList arrayList2 = new ArrayList();
                                        while (zzegVar.zzg() < iZzg2) {
                                            zzef zzefVar3 = zzefVar2;
                                            String strTrim2 = zzegVar.zzK(3, StandardCharsets.UTF_8).trim();
                                            int iZzs4 = zzegVar.zzs();
                                            zzem zzemVar4 = zzemVar3;
                                            byte[] bArr = new byte[4];
                                            zzegVar.zzm(bArr, 0, 4);
                                            arrayList2.add(new zzaob(strTrim2, iZzs4, bArr));
                                            zzemVar3 = zzemVar4;
                                            zzefVar2 = zzefVar3;
                                            iZzt = iZzt;
                                        }
                                        zzemVar2 = zzemVar3;
                                        i2 = iZzt;
                                        zzefVar = zzefVar2;
                                        arrayList = arrayList2;
                                        i10 = 89;
                                    } else {
                                        zzemVar2 = zzemVar3;
                                        i2 = iZzt;
                                        zzefVar = zzefVar2;
                                        if (iZzs2 == 111) {
                                            i10 = 257;
                                        }
                                    }
                                }
                                zzemVar2 = zzemVar3;
                                i2 = iZzt;
                                zzefVar = zzefVar2;
                                i10 = 135;
                            }
                            zzemVar2 = zzemVar3;
                            i2 = iZzt;
                            zzefVar = zzefVar2;
                            i10 = 129;
                        }
                        zzegVar.zzk(iZzg2 - zzegVar.zzg());
                        zzemVar3 = zzemVar2;
                        zzefVar2 = zzefVar;
                        iZzt = i2;
                        i8 = 5;
                    }
                    zzem zzemVar5 = zzemVar3;
                    int i11 = iZzt;
                    zzef zzefVar4 = zzefVar2;
                    zzegVar.zzh(i9);
                    zzaoc zzaocVar = new zzaoc(i10, str, iZzs, arrayList, Arrays.copyOfRange(zzegVar.zzi(), iZzg, i9));
                    if (iZzj == 6 || iZzj == 5) {
                        iZzj = zzaocVar.zza;
                    }
                    iZzd -= iZzj3 + 5;
                    if (!zzaoaVar.zzj().get(iZzj2)) {
                        zzaof zzaofVarZzb = zzaoaVar.zzh().zzb(iZzj, zzaocVar);
                        sparseIntArray.put(iZzj2, iZzj2);
                        sparseArray.put(iZzj2, zzaofVarZzb);
                    }
                    i6 = 4;
                    zzemVar3 = zzemVar5;
                    zzefVar2 = zzefVar4;
                    iZzt = i11;
                    i4 = 3;
                    i5 = 13;
                    i7 = 12;
                }
                zzem zzemVar6 = zzemVar3;
                int i12 = iZzt;
                int size = sparseIntArray.size();
                int i13 = 0;
                while (i13 < size) {
                    int iKeyAt = sparseIntArray.keyAt(i13);
                    int iValueAt = sparseIntArray.valueAt(i13);
                    zzaoaVar.zzj().put(iKeyAt, true);
                    zzaoaVar.zzk().put(iValueAt, true);
                    zzaof zzaofVar = (zzaof) sparseArray.valueAt(i13);
                    if (zzaofVar != null) {
                        i = i12;
                        zzemVar = zzemVar6;
                        zzaofVar.zza(zzemVar, zzaoaVar.zzl(), new zzaoe(i, iKeyAt, 8192));
                        zzaoaVar.zzi().put(iValueAt, zzaofVar);
                    } else {
                        zzemVar = zzemVar6;
                        i = i12;
                    }
                    i13++;
                    zzemVar6 = zzemVar;
                    i12 = i;
                }
                zzaoaVar.zzi().remove(this.zze);
                zzaoaVar.zzn(0);
                if (zzaoaVar.zzm() == 0) {
                    zzaoaVar.zzl().zzv();
                    zzaoaVar.zzo(true);
                }
            }
        }
    }
}
