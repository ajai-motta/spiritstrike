package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.view.ViewCompat;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzalo {
    private boolean zzb;
    private boolean zzc;
    private int[] zzd;
    private int zze;
    private int zzf;
    private Rect zzg;
    private final int[] zza = new int[4];
    private int zzh = -1;
    private int zzi = -1;

    private static int zze(int[] iArr, int i) {
        if (i >= iArr.length) {
            i = 0;
        }
        return iArr[i];
    }

    private static int zzf(int i, int i2) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | ((i2 * 17) << 24);
    }

    private final void zzg(zzef zzefVar, boolean z, Rect rect, int[] iArr) {
        int i;
        int i2;
        int i3 = !z ? 1 : 0;
        int iWidth = rect.width();
        int i4 = i3 * iWidth;
        int iHeight = rect.height();
        while (true) {
            int i5 = 0;
            do {
                int iZzj = 0;
                for (int i6 = 1; iZzj < i6 && i6 <= 64; i6 <<= 2) {
                    if (zzefVar.zzc() < 4) {
                        i = -1;
                        i2 = 0;
                        break;
                    }
                    iZzj = (iZzj << 4) | zzefVar.zzj(4);
                }
                i = iZzj & 3;
                i2 = iZzj < 4 ? iWidth : iZzj >> 2;
                int iMin = Math.min(i2, iWidth - i5);
                if (iMin > 0) {
                    int i7 = i4 + iMin;
                    Arrays.fill(iArr, i4, i7, this.zza[i]);
                    i5 += iMin;
                    i4 = i7;
                }
            } while (i5 < iWidth);
            i3 += 2;
            if (i3 >= iHeight) {
                return;
            }
            i4 = i3 * iWidth;
            zzefVar.zzm();
        }
    }

    public final void zza(String str) {
        int i;
        String strTrim = str.trim();
        String str2 = zzep.zza;
        for (String str3 : strTrim.split("\\r?\\n", -1)) {
            if (str3.startsWith("palette: ")) {
                String[] strArrSplit = str3.substring(9).split(",", -1);
                this.zzd = new int[strArrSplit.length];
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    int[] iArr = this.zzd;
                    try {
                        i = Integer.parseInt(strArrSplit[i2].trim(), 16);
                    } catch (RuntimeException unused) {
                        i = 0;
                    }
                    iArr[i2] = i;
                }
            } else if (str3.startsWith("size: ")) {
                String[] strArrSplit2 = str3.substring(6).trim().split("x", -1);
                if (strArrSplit2.length == 2) {
                    try {
                        this.zze = Integer.parseInt(strArrSplit2[0]);
                        this.zzf = Integer.parseInt(strArrSplit2[1]);
                        this.zzb = true;
                    } catch (RuntimeException e) {
                        zzdt.zzd("VobsubParser", "Parsing IDX failed", e);
                    }
                }
            }
        }
    }

    public final void zzb(zzeg zzegVar) {
        int[] iArr = this.zzd;
        if (iArr == null || !this.zzb) {
            return;
        }
        zzegVar.zzk(zzegVar.zzt() - 2);
        int iZzt = zzegVar.zzt();
        while (zzegVar.zzg() < iZzt && zzegVar.zzd() > 0) {
            switch (zzegVar.zzs()) {
                case 0:
                case 1:
                case 2:
                    break;
                case 3:
                    if (zzegVar.zzd() < 2) {
                        return;
                    }
                    int iZzs = zzegVar.zzs();
                    int iZzs2 = zzegVar.zzs();
                    int[] iArr2 = this.zza;
                    iArr2[3] = zze(iArr, iZzs >> 4);
                    iArr2[2] = zze(iArr, iZzs & 15);
                    iArr2[1] = zze(iArr, iZzs2 >> 4);
                    iArr2[0] = zze(iArr, iZzs2 & 15);
                    this.zzc = true;
                    break;
                case 4:
                    if (zzegVar.zzd() < 2 || !this.zzc) {
                        return;
                    }
                    int iZzs3 = zzegVar.zzs();
                    int iZzs4 = zzegVar.zzs();
                    int[] iArr3 = this.zza;
                    iArr3[3] = zzf(iArr3[3], iZzs3 >> 4);
                    iArr3[2] = zzf(iArr3[2], iZzs3 & 15);
                    iArr3[1] = zzf(iArr3[1], iZzs4 >> 4);
                    iArr3[0] = zzf(iArr3[0], iZzs4 & 15);
                    break;
                case 5:
                    if (zzegVar.zzd() < 6) {
                        return;
                    }
                    int iZzs5 = zzegVar.zzs();
                    int iZzs6 = zzegVar.zzs();
                    int i = iZzs6 >> 4;
                    int iZzs7 = ((iZzs6 & 15) << 8) | zzegVar.zzs();
                    int iZzs8 = zzegVar.zzs();
                    int iZzs9 = zzegVar.zzs();
                    this.zzg = new Rect((iZzs5 << 4) | i, (iZzs8 << 4) | (iZzs9 >> 4), iZzs7 + 1, (((iZzs9 & 15) << 8) | zzegVar.zzs()) + 1);
                    break;
                case 6:
                    if (zzegVar.zzd() < 4) {
                        return;
                    }
                    this.zzh = zzegVar.zzt();
                    this.zzi = zzegVar.zzt();
                    break;
                default:
                    return;
            }
        }
    }

    public final zzcm zzc(zzeg zzegVar) {
        Rect rect;
        if (this.zzd == null || !this.zzb || !this.zzc || (rect = this.zzg) == null || this.zzh == -1 || this.zzi == -1 || rect.width() < 2 || this.zzg.height() < 2) {
            return null;
        }
        Rect rect2 = this.zzg;
        int[] iArr = new int[rect2.width() * rect2.height()];
        zzef zzefVar = new zzef();
        zzegVar.zzh(this.zzh);
        zzefVar.zza(zzegVar);
        zzg(zzefVar, true, rect2, iArr);
        zzegVar.zzh(this.zzi);
        zzefVar.zza(zzegVar);
        zzg(zzefVar, false, rect2, iArr);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888);
        zzcl zzclVar = new zzcl();
        zzclVar.zzc(bitmapCreateBitmap);
        zzclVar.zzi(rect2.left / this.zze);
        zzclVar.zzj(0);
        zzclVar.zzf(rect2.top / this.zzf, 0);
        zzclVar.zzg(0);
        zzclVar.zzm(rect2.width() / this.zze);
        zzclVar.zzn(rect2.height() / this.zzf);
        return zzclVar.zzr();
    }

    public final void zzd() {
        this.zzc = false;
        this.zzg = null;
        this.zzh = -1;
        this.zzi = -1;
    }
}
