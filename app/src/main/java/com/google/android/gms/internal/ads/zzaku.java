package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.work.WorkInfo;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaku implements zzaki {
    private static final byte[] zza = {0, 7, 8, Ascii.SI};
    private static final byte[] zzb = {0, 119, -120, -1};
    private static final byte[] zzc = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    private final Paint zzd;
    private final Paint zze;
    private final Canvas zzf;
    private final zzakn zzg;
    private final zzakm zzh;
    private final zzakt zzi;
    private Bitmap zzj;

    public zzaku(List list) {
        zzeg zzegVar = new zzeg((byte[]) list.get(0));
        int iZzt = zzegVar.zzt();
        int iZzt2 = zzegVar.zzt();
        Paint paint = new Paint();
        this.zzd = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.zze = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.zzf = new Canvas();
        this.zzg = new zzakn(AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 575, 0, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, 0, 575);
        this.zzh = new zzakm(0, zzd(), zze(), zzf());
        this.zzi = new zzakt(iZzt, iZzt2);
    }

    private static zzakm zzb(zzef zzefVar, int i) {
        int iZzj;
        int iZzj2;
        int iZzj3;
        int iZzj4;
        int i2 = 8;
        int iZzj5 = zzefVar.zzj(8);
        zzefVar.zzh(8);
        int[] iArrZzd = zzd();
        int[] iArrZze = zze();
        int[] iArrZzf = zzf();
        int i3 = i - 2;
        while (i3 > 0) {
            int iZzj6 = zzefVar.zzj(i2);
            int iZzj7 = zzefVar.zzj(i2);
            int[] iArr = (iZzj7 & 128) != 0 ? iArrZzd : (iZzj7 & 64) != 0 ? iArrZze : iArrZzf;
            if ((iZzj7 & 1) != 0) {
                iZzj3 = zzefVar.zzj(i2);
                iZzj4 = zzefVar.zzj(i2);
                iZzj = zzefVar.zzj(i2);
                iZzj2 = zzefVar.zzj(i2);
                i3 -= 6;
            } else {
                int iZzj8 = zzefVar.zzj(6) << 2;
                int iZzj9 = zzefVar.zzj(4) << 4;
                i3 -= 4;
                iZzj = zzefVar.zzj(4) << 4;
                iZzj2 = zzefVar.zzj(2) << 6;
                iZzj3 = iZzj8;
                iZzj4 = iZzj9;
            }
            if (iZzj3 == 0) {
                iZzj2 = 255;
            }
            if (iZzj3 == 0) {
                iZzj = 0;
            }
            if (iZzj3 == 0) {
                iZzj4 = 0;
            }
            int i4 = iZzj + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            double d = iZzj3;
            String str = zzep.zza;
            double d2 = iZzj4 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            double d3 = i4;
            iArr[iZzj6] = zzg((byte) (255 - (iZzj2 & 255)), Math.max(0, Math.min((int) (d + (1.402d * d2)), 255)), Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)), Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255)));
            iZzj5 = iZzj5;
            i2 = 8;
        }
        return new zzakm(iZzj5, iArrZzd, iArrZze, iArrZzf);
    }

    private static zzako zzc(zzef zzefVar) {
        byte[] bArr;
        int iZzj = zzefVar.zzj(16);
        zzefVar.zzh(4);
        int iZzj2 = zzefVar.zzj(2);
        boolean zZzi = zzefVar.zzi();
        zzefVar.zzh(1);
        byte[] bArr2 = zzep.zzb;
        if (iZzj2 != 1) {
            if (iZzj2 == 0) {
                int iZzj3 = zzefVar.zzj(16);
                int iZzj4 = zzefVar.zzj(16);
                if (iZzj3 > 0) {
                    bArr2 = new byte[iZzj3];
                    zzefVar.zzn(bArr2, 0, iZzj3);
                }
                if (iZzj4 > 0) {
                    bArr = new byte[iZzj4];
                    zzefVar.zzn(bArr, 0, iZzj4);
                }
            }
            return new zzako(iZzj, zZzi, bArr2, bArr);
        }
        zzefVar.zzh(zzefVar.zzj(8) * 16);
        bArr = bArr2;
        return new zzako(iZzj, zZzi, bArr2, bArr);
    }

    private static int[] zzd() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] zze() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            int i2 = i & 4;
            int i3 = i & 2;
            int i4 = i & 1;
            if (i < 8) {
                iArr[i] = zzg(255, 1 != i4 ? 0 : 255, i3 != 0 ? 255 : 0, i2 != 0 ? 255 : 0);
            } else {
                iArr[i] = zzg(255, 1 != i4 ? 0 : 127, i3 != 0 ? 127 : 0, i2 == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    private static int[] zzf() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i = 0; i < 256; i++) {
            if (i < 8) {
                iArr[i] = zzg(63, 1 != (i & 1) ? 0 : 255, (i & 2) != 0 ? 255 : 0, (i & 4) == 0 ? 0 : 255);
            } else {
                int i2 = i & 136;
                if (i2 == 0) {
                    iArr[i] = zzg(255, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 8) {
                    iArr[i] = zzg(127, (1 != (i & 1) ? 0 : 85) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 4) == 0 ? 0 : 85) + ((i & 64) == 0 ? 0 : 170));
                } else if (i2 == 128) {
                    iArr[i] = zzg(255, (1 != (i & 1) ? 0 : 43) + 127 + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + 127 + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + 127 + ((i & 64) == 0 ? 0 : 85));
                } else if (i2 == 136) {
                    iArr[i] = zzg(255, (1 != (i & 1) ? 0 : 43) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 4) == 0 ? 0 : 43) + ((i & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    private static int zzg(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01ef A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0228 A[LOOP:3: B:88:0x0172->B:119:0x0228, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0222 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzh(byte[] r24, int[] r25, int r26, int r27, int r28, android.graphics.Paint r29, android.graphics.Canvas r30) {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaku.zzh(byte[], int[], int, int, int, android.graphics.Paint, android.graphics.Canvas):void");
    }

    private static byte[] zzi(int i, int i2, zzef zzefVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) zzefVar.zzj(i2);
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(byte[] bArr, int i, int i2, zzakh zzakhVar, zzdg zzdgVar) {
        zzaka zzakaVar;
        char c;
        char c2;
        char c3;
        int i3;
        zzakt zzaktVar;
        zzakn zzaknVar;
        int i4;
        int i5;
        ArrayList arrayList;
        int i6;
        zzakr zzakrVar;
        int i7;
        int i8;
        zzakr zzakrVar2;
        int i9;
        int iZzj;
        int iZzj2;
        int iZzj3;
        int iZzj4;
        int i10;
        int iZzj5;
        zzef zzefVar = new zzef(bArr, i + i2);
        zzefVar.zzf(i);
        while (zzefVar.zzc() >= 48 && zzefVar.zzj(8) == 15) {
            zzakt zzaktVar2 = this.zzi;
            int iZzj6 = zzefVar.zzj(8);
            int iZzj7 = zzefVar.zzj(16);
            int iZzj8 = zzefVar.zzj(16);
            int iZze = zzefVar.zze() + iZzj8;
            if (iZzj8 * 8 > zzefVar.zzc()) {
                zzdt.zzc("DvbParser", "Data field length exceeds limit");
                zzefVar.zzh(zzefVar.zzc());
            } else {
                switch (iZzj6) {
                    case 16:
                        if (iZzj7 == zzaktVar2.zza) {
                            zzakp zzakpVar = zzaktVar2.zzi;
                            int iZzj9 = zzefVar.zzj(8);
                            int iZzj10 = zzefVar.zzj(4);
                            int iZzj11 = zzefVar.zzj(2);
                            zzefVar.zzh(2);
                            SparseArray sparseArray = new SparseArray();
                            for (int i11 = iZzj8 - 2; i11 > 0; i11 -= 6) {
                                int iZzj12 = zzefVar.zzj(8);
                                zzefVar.zzh(8);
                                sparseArray.put(iZzj12, new zzakq(zzefVar.zzj(16), zzefVar.zzj(16)));
                            }
                            zzakp zzakpVar2 = new zzakp(iZzj9, iZzj10, iZzj11, sparseArray);
                            if (zzakpVar2.zzb != 0) {
                                zzaktVar2.zzi = zzakpVar2;
                                zzaktVar2.zzc.clear();
                                zzaktVar2.zzd.clear();
                                zzaktVar2.zze.clear();
                            } else if (zzakpVar != null) {
                                if (zzakpVar.zza != zzakpVar2.zza) {
                                    zzaktVar2.zzi = zzakpVar2;
                                }
                            }
                        }
                        break;
                    case 17:
                        zzakp zzakpVar3 = zzaktVar2.zzi;
                        if (iZzj7 == zzaktVar2.zza && zzakpVar3 != null) {
                            int iZzj13 = zzefVar.zzj(8);
                            zzefVar.zzh(4);
                            boolean zZzi = zzefVar.zzi();
                            zzefVar.zzh(3);
                            int iZzj14 = zzefVar.zzj(16);
                            int iZzj15 = zzefVar.zzj(16);
                            int iZzj16 = zzefVar.zzj(3);
                            int iZzj17 = zzefVar.zzj(3);
                            zzefVar.zzh(2);
                            int iZzj18 = zzefVar.zzj(8);
                            int iZzj19 = zzefVar.zzj(8);
                            int iZzj20 = zzefVar.zzj(4);
                            int iZzj21 = zzefVar.zzj(2);
                            zzefVar.zzh(2);
                            int i12 = iZzj8 - 10;
                            SparseArray sparseArray2 = new SparseArray();
                            while (i12 > 0) {
                                int iZzj22 = zzefVar.zzj(16);
                                int iZzj23 = zzefVar.zzj(2);
                                int iZzj24 = zzefVar.zzj(2);
                                int iZzj25 = zzefVar.zzj(12);
                                zzefVar.zzh(4);
                                int iZzj26 = zzefVar.zzj(12);
                                int i13 = i12 - 6;
                                if (iZzj23 == 1) {
                                    i12 -= 8;
                                    i9 = iZzj23;
                                    iZzj = zzefVar.zzj(8);
                                    iZzj2 = zzefVar.zzj(8);
                                } else if (iZzj23 == 2) {
                                    iZzj23 = 2;
                                    i12 -= 8;
                                    i9 = iZzj23;
                                    iZzj = zzefVar.zzj(8);
                                    iZzj2 = zzefVar.zzj(8);
                                } else {
                                    i9 = iZzj23;
                                    i12 = i13;
                                    iZzj = 0;
                                    iZzj2 = 0;
                                }
                                sparseArray2.put(iZzj22, new zzaks(i9, iZzj24, iZzj25, iZzj26, iZzj, iZzj2));
                            }
                            zzakr zzakrVar3 = new zzakr(iZzj13, zZzi, iZzj14, iZzj15, iZzj16, iZzj17, iZzj18, iZzj19, iZzj20, iZzj21, sparseArray2);
                            if (zzakpVar3.zzb == 0 && (zzakrVar2 = (zzakr) zzaktVar2.zzc.get(zzakrVar3.zza)) != null) {
                                int i14 = 0;
                                while (true) {
                                    SparseArray sparseArray3 = zzakrVar2.zzj;
                                    if (i14 < sparseArray3.size()) {
                                        zzakrVar3.zzj.put(sparseArray3.keyAt(i14), (zzaks) sparseArray3.valueAt(i14));
                                        i14++;
                                    }
                                }
                            }
                            zzaktVar2.zzc.put(zzakrVar3.zza, zzakrVar3);
                        }
                        break;
                    case 18:
                        if (iZzj7 == zzaktVar2.zza) {
                            zzakm zzakmVarZzb = zzb(zzefVar, iZzj8);
                            zzaktVar2.zzd.put(zzakmVarZzb.zza, zzakmVarZzb);
                        } else if (iZzj7 == zzaktVar2.zzb) {
                            zzakm zzakmVarZzb2 = zzb(zzefVar, iZzj8);
                            zzaktVar2.zzf.put(zzakmVarZzb2.zza, zzakmVarZzb2);
                        }
                        break;
                    case 19:
                        if (iZzj7 == zzaktVar2.zza) {
                            zzako zzakoVarZzc = zzc(zzefVar);
                            zzaktVar2.zze.put(zzakoVarZzc.zza, zzakoVarZzc);
                        } else if (iZzj7 == zzaktVar2.zzb) {
                            zzako zzakoVarZzc2 = zzc(zzefVar);
                            zzaktVar2.zzg.put(zzakoVarZzc2.zza, zzakoVarZzc2);
                        }
                        break;
                    case 20:
                        if (iZzj7 == zzaktVar2.zza) {
                            zzefVar.zzh(4);
                            boolean zZzi2 = zzefVar.zzi();
                            zzefVar.zzh(3);
                            int iZzj27 = zzefVar.zzj(16);
                            int iZzj28 = zzefVar.zzj(16);
                            if (zZzi2) {
                                int iZzj29 = zzefVar.zzj(16);
                                iZzj3 = zzefVar.zzj(16);
                                iZzj5 = zzefVar.zzj(16);
                                iZzj4 = zzefVar.zzj(16);
                                i10 = iZzj29;
                            } else {
                                iZzj3 = iZzj27;
                                iZzj4 = iZzj28;
                                i10 = 0;
                                iZzj5 = 0;
                            }
                            zzaktVar2.zzh = new zzakn(iZzj27, iZzj28, i10, iZzj3, iZzj5, iZzj4);
                        }
                        break;
                }
                zzefVar.zzo(iZze - zzefVar.zze());
            }
        }
        zzakt zzaktVar3 = this.zzi;
        zzakp zzakpVar4 = zzaktVar3.zzi;
        if (zzakpVar4 == null) {
            zzakaVar = new zzaka(zzgpe.zzi(), C.TIME_UNSET, C.TIME_UNSET);
        } else {
            zzakn zzaknVar2 = zzaktVar3.zzh;
            if (zzaknVar2 == null) {
                zzaknVar2 = this.zzg;
            }
            Bitmap bitmap = this.zzj;
            if (bitmap == null || zzaknVar2.zza + 1 != bitmap.getWidth() || zzaknVar2.zzb + 1 != this.zzj.getHeight()) {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(zzaknVar2.zza + 1, zzaknVar2.zzb + 1, Bitmap.Config.ARGB_8888);
                this.zzj = bitmapCreateBitmap;
                this.zzf.setBitmap(bitmapCreateBitmap);
            }
            ArrayList arrayList2 = new ArrayList();
            SparseArray sparseArray4 = zzakpVar4.zzc;
            int i15 = 0;
            while (i15 < sparseArray4.size()) {
                Canvas canvas = this.zzf;
                canvas.save();
                zzakq zzakqVar = (zzakq) sparseArray4.valueAt(i15);
                zzakr zzakrVar4 = (zzakr) zzaktVar3.zzc.get(sparseArray4.keyAt(i15));
                int i16 = zzakqVar.zza + zzaknVar2.zzc;
                int i17 = zzakqVar.zzb + zzaknVar2.zze;
                int i18 = zzakrVar4.zzc;
                int i19 = i16 + i18;
                int iMin = Math.min(i19, zzaknVar2.zzd);
                int i20 = zzakrVar4.zzd;
                int i21 = i17 + i20;
                canvas.clipRect(i16, i17, iMin, Math.min(i21, zzaknVar2.zzf));
                int i22 = zzakrVar4.zzf;
                zzakm zzakmVar = (zzakm) zzaktVar3.zzd.get(i22);
                if (zzakmVar == null && (zzakmVar = (zzakm) zzaktVar3.zzf.get(i22)) == null) {
                    zzakmVar = this.zzh;
                }
                SparseArray sparseArray5 = zzakrVar4.zzj;
                SparseArray sparseArray6 = sparseArray4;
                int i23 = i19;
                int i24 = 0;
                while (i24 < sparseArray5.size()) {
                    int iKeyAt = sparseArray5.keyAt(i24);
                    SparseArray sparseArray7 = sparseArray5;
                    zzaks zzaksVar = (zzaks) sparseArray5.valueAt(i24);
                    int i25 = i18;
                    zzako zzakoVar = (zzako) zzaktVar3.zze.get(iKeyAt);
                    if (zzakoVar == null) {
                        zzakoVar = (zzako) zzaktVar3.zzg.get(iKeyAt);
                    }
                    if (zzakoVar != null) {
                        Paint paint = zzakoVar.zzb ? null : this.zzd;
                        int i26 = zzakrVar4.zze;
                        zzaktVar = zzaktVar3;
                        int i27 = zzaksVar.zza + i16;
                        int i28 = zzaksVar.zzb + i17;
                        int i29 = i16;
                        int[] iArr = i26 == 3 ? zzakmVar.zzd : i26 == 2 ? zzakmVar.zzc : zzakmVar.zzb;
                        i5 = i15;
                        i7 = i23;
                        arrayList = arrayList2;
                        zzaknVar = zzaknVar2;
                        i8 = i25;
                        i6 = i29;
                        i4 = i20;
                        zzakrVar = zzakrVar4;
                        zzh(zzakoVar.zzc, iArr, i26, i27, i28, paint, canvas);
                        zzh(zzakoVar.zzd, iArr, i26, i27, i28 + 1, paint, canvas);
                    } else {
                        zzaktVar = zzaktVar3;
                        zzaknVar = zzaknVar2;
                        i4 = i20;
                        i5 = i15;
                        arrayList = arrayList2;
                        i6 = i16;
                        zzakrVar = zzakrVar4;
                        i7 = i23;
                        i8 = i25;
                    }
                    i24++;
                    i16 = i6;
                    zzakrVar4 = zzakrVar;
                    i23 = i7;
                    sparseArray5 = sparseArray7;
                    zzaktVar3 = zzaktVar;
                    i15 = i5;
                    arrayList2 = arrayList;
                    zzaknVar2 = zzaknVar;
                    i20 = i4;
                    i18 = i8;
                }
                zzakt zzaktVar4 = zzaktVar3;
                zzakn zzaknVar3 = zzaknVar2;
                int i30 = i20;
                int i31 = i15;
                ArrayList arrayList3 = arrayList2;
                int i32 = i18;
                int i33 = i16;
                zzakr zzakrVar5 = zzakrVar4;
                int i34 = i23;
                float f = i17;
                float f2 = i33;
                if (zzakrVar5.zzb) {
                    int i35 = zzakrVar5.zze;
                    if (i35 == 3) {
                        i3 = zzakmVar.zzd[zzakrVar5.zzg];
                        c3 = 2;
                    } else {
                        c3 = 2;
                        i3 = i35 == 2 ? zzakmVar.zzc[zzakrVar5.zzh] : zzakmVar.zzb[zzakrVar5.zzi];
                    }
                    Paint paint2 = this.zze;
                    paint2.setColor(i3);
                    float f3 = i21;
                    float f4 = i34;
                    c = c3;
                    c2 = 3;
                    canvas.drawRect(f2, f, f4, f3, paint2);
                } else {
                    c = 2;
                    c2 = 3;
                }
                zzcl zzclVar = new zzcl();
                zzclVar.zzc(Bitmap.createBitmap(this.zzj, i33, i17, i32, i30));
                zzaknVar2 = zzaknVar3;
                float f5 = zzaknVar2.zza;
                zzclVar.zzi(f2 / f5);
                zzclVar.zzj(0);
                float f6 = zzaknVar2.zzb;
                zzclVar.zzf(f / f6, 0);
                zzclVar.zzg(0);
                zzclVar.zzm(i32 / f5);
                zzclVar.zzn(i30 / f6);
                arrayList3.add(zzclVar.zzr());
                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                canvas.restore();
                sparseArray4 = sparseArray6;
                arrayList2 = arrayList3;
                i15 = i31 + 1;
                zzaktVar3 = zzaktVar4;
            }
            zzakaVar = new zzaka(arrayList2, C.TIME_UNSET, C.TIME_UNSET);
        }
        zzdgVar.zza(zzakaVar);
    }
}
