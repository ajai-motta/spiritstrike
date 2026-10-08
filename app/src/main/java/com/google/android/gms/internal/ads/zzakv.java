package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import androidx.work.WorkInfo;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzakv {
    private final zzeg zza = new zzeg();
    private final int[] zzb = new int[256];
    private boolean zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    public final zzcm zza() {
        int i;
        if (this.zzd == 0 || this.zze == 0 || this.zzh == 0 || this.zzi == 0) {
            return null;
        }
        zzeg zzegVar = this.zza;
        if (zzegVar.zze() == 0 || zzegVar.zzg() != zzegVar.zze() || !this.zzc) {
            return null;
        }
        zzegVar.zzh(0);
        int i2 = this.zzh * this.zzi;
        int[] iArr = new int[i2];
        int i3 = 0;
        while (i3 < i2) {
            int iZzs = zzegVar.zzs();
            if (iZzs != 0) {
                i = i3 + 1;
                iArr[i3] = this.zzb[iZzs];
            } else {
                int iZzs2 = zzegVar.zzs();
                if (iZzs2 != 0) {
                    int iZzs3 = iZzs2 & 63;
                    if ((iZzs2 & 64) != 0) {
                        iZzs3 = (iZzs3 << 8) | zzegVar.zzs();
                    }
                    i = iZzs3 + i3;
                    Arrays.fill(iArr, i3, i, (iZzs2 & 128) == 0 ? this.zzb[0] : this.zzb[zzegVar.zzs()]);
                }
            }
            i3 = i;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iArr, this.zzh, this.zzi, Bitmap.Config.ARGB_8888);
        zzcl zzclVar = new zzcl();
        zzclVar.zzc(bitmapCreateBitmap);
        zzclVar.zzi(this.zzf / this.zzd);
        zzclVar.zzj(0);
        zzclVar.zzf(this.zzg / this.zze, 0);
        zzclVar.zzg(0);
        zzclVar.zzm(this.zzh / this.zzd);
        zzclVar.zzn(this.zzi / this.zze);
        return zzclVar.zzr();
    }

    public final void zzb() {
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zza.zza(0);
        this.zzc = false;
    }

    final /* synthetic */ void zzc(zzeg zzegVar, int i) {
        if (i % 5 != 2) {
            return;
        }
        zzegVar.zzk(2);
        int[] iArr = this.zzb;
        Arrays.fill(iArr, 0);
        int i2 = 0;
        for (int i3 = i / 5; i2 < i3; i3 = i3) {
            int iZzs = zzegVar.zzs();
            int iZzs2 = zzegVar.zzs();
            int iZzs3 = zzegVar.zzs();
            int iZzs4 = zzegVar.zzs();
            int iZzs5 = zzegVar.zzs();
            double d = iZzs2;
            int i4 = iZzs3 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            int i5 = iZzs4 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
            int i6 = iZzs5 << 24;
            String str = zzep.zza;
            double d2 = i4;
            double d3 = i5;
            iArr[iZzs] = (Math.max(0, Math.min((int) (d + (1.402d * d2)), 255)) << 16) | i6 | (Math.max(0, Math.min((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 255)) << 8) | Math.max(0, Math.min((int) (d + (d3 * 1.772d)), 255));
            i2++;
        }
        this.zzc = true;
    }

    final /* synthetic */ void zzd(zzeg zzegVar, int i) {
        int iZzx;
        if (i < 4) {
            return;
        }
        zzegVar.zzk(3);
        int i2 = i - 4;
        if ((zzegVar.zzs() & 128) != 0) {
            if (i2 < 7 || (iZzx = zzegVar.zzx()) < 4) {
                return;
            }
            this.zzh = zzegVar.zzt();
            this.zzi = zzegVar.zzt();
            this.zza.zza(iZzx - 4);
            i2 = i - 11;
        }
        zzeg zzegVar2 = this.zza;
        int iZzg = zzegVar2.zzg();
        int iZze = zzegVar2.zze();
        if (iZzg >= iZze || i2 <= 0) {
            return;
        }
        int iMin = Math.min(i2, iZze - iZzg);
        zzegVar.zzm(zzegVar2.zzi(), iZzg, iMin);
        zzegVar2.zzh(iZzg + iMin);
    }

    final /* synthetic */ void zze(zzeg zzegVar, int i) {
        if (i < 19) {
            return;
        }
        this.zzd = zzegVar.zzt();
        this.zze = zzegVar.zzt();
        zzegVar.zzk(11);
        this.zzf = zzegVar.zzt();
        this.zzg = zzegVar.zzt();
    }
}
