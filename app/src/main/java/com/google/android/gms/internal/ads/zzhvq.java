package com.google.android.gms.internal.ads;

import androidx.work.WorkInfo;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhvq extends zzhvt {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    zzhvq(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzJ(int i, int i2) throws IOException {
        zzs((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzK(int i, int i2) throws IOException {
        zzs(i << 3);
        zzr(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzL(int i, int i2) throws IOException {
        zzs(i << 3);
        zzs(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzM(int i, int i2) throws IOException {
        zzs((i << 3) | 5);
        zzt(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzN(int i, long j) throws IOException {
        zzs(i << 3);
        zzu(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt, com.google.android.gms.internal.ads.zzhuz
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzw(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzh(int i, long j) throws IOException {
        zzs((i << 3) | 1);
        zzv(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzi(int i, boolean z) throws IOException {
        zzs(i << 3);
        zzq(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzj(int i, String str) throws IOException {
        zzs((i << 3) | 2);
        zzx(str);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzk(int i, zzhvi zzhviVar) throws IOException {
        zzs((i << 3) | 2);
        zzl(zzhviVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzl(zzhvi zzhviVar) throws IOException {
        zzs(zzhviVar.zzc());
        zzhviVar.zzk(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzm(byte[] bArr, int i, int i2) throws IOException {
        zzs(i2);
        zzw(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzn(int i, zzhxz zzhxzVar) throws IOException {
        zzs(11);
        zzL(2, i);
        zzs(26);
        zzp(zzhxzVar);
        zzs(12);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzo(int i, zzhvi zzhviVar) throws IOException {
        zzs(11);
        zzL(2, i);
        zzk(3, zzhviVar);
        zzs(12);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzp(zzhxz zzhxzVar) throws IOException {
        zzs(zzhxzVar.zzbr());
        zzhxzVar.zzdc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzq(byte b) throws IOException {
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i;
        int i2 = this.zzc;
        try {
            i = i2 + 1;
        } catch (IndexOutOfBoundsException e) {
            indexOutOfBoundsException = e;
        }
        try {
            this.zza[i2] = b;
            this.zzc = i;
        } catch (IndexOutOfBoundsException e2) {
            indexOutOfBoundsException = e2;
            i2 = i;
            throw new zzhvr(i2, this.zzb, 1, indexOutOfBoundsException);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzr(int i) throws IOException {
        if (i >= 0) {
            zzs(i);
        } else {
            zzu(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzt(int i) throws IOException {
        int i2 = this.zzc;
        try {
            byte[] bArr = this.zza;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.zzc = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzhvr(i2, this.zzb, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzv(long j) throws IOException {
        int i = this.zzc;
        try {
            byte[] bArr = this.zza;
            bArr[i] = (byte) j;
            bArr[i + 1] = (byte) (j >> 8);
            bArr[i + 2] = (byte) (j >> 16);
            bArr[i + 3] = (byte) (j >> 24);
            bArr[i + 4] = (byte) (j >> 32);
            bArr[i + 5] = (byte) (j >> 40);
            bArr[i + 6] = (byte) (j >> 48);
            bArr[i + 7] = (byte) (j >> 56);
            this.zzc = i + 8;
        } catch (IndexOutOfBoundsException e) {
            throw new zzhvr(i, this.zzb, 8, e);
        }
    }

    public final void zzw(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, i, this.zza, this.zzc, i2);
            this.zzc += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzhvr(this.zzc, this.zzb, i2, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzx(String str) throws IOException {
        int i = this.zzc;
        try {
            int iZzA = zzA(str.length() * 3);
            int iZzA2 = zzA(str.length());
            if (iZzA2 != iZzA) {
                zzs(zzhzo.zzc(str));
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = zzhzo.zzd(str, bArr, i2, this.zzb - i2);
                return;
            }
            int i3 = i + iZzA2;
            this.zzc = i3;
            int iZzd = zzhzo.zzd(str, this.zza, i3, this.zzb - i3);
            this.zzc = i;
            zzs((iZzd - i) - iZzA2);
            this.zzc = iZzd;
        } catch (zzhzn e) {
            this.zzc = i;
            zzF(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzhvr(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzy() {
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzs(int i) throws IOException {
        int i2;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i3 = this.zzc;
        while ((i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
            try {
                i2 = i3 + 1;
            } catch (IndexOutOfBoundsException e) {
                indexOutOfBoundsException = e;
                throw new zzhvr(i3, this.zzb, 1, indexOutOfBoundsException);
            }
            try {
                this.zza[i3] = (byte) (i | 128);
                i >>>= 7;
                i3 = i2;
            } catch (IndexOutOfBoundsException e2) {
                indexOutOfBoundsException = e2;
                i3 = i2;
                throw new zzhvr(i3, this.zzb, 1, indexOutOfBoundsException);
            }
        }
        i2 = i3 + 1;
        this.zza[i3] = (byte) i;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzu(long j) throws IOException {
        int i;
        IndexOutOfBoundsException indexOutOfBoundsException;
        boolean z = zzhvt.zzb;
        int i2 = this.zzc;
        if (!z || this.zzb - i2 < 10) {
            while ((j & (-128)) != 0) {
                try {
                    int i3 = i2 + 1;
                    try {
                        this.zza[i2] = (byte) (((int) j) | 128);
                        j >>>= 7;
                        i2 = i3;
                    } catch (IndexOutOfBoundsException e) {
                        indexOutOfBoundsException = e;
                        i2 = i3;
                        throw new zzhvr(i2, this.zzb, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    indexOutOfBoundsException = e2;
                }
            }
            i = i2 + 1;
            try {
                this.zza[i2] = (byte) j;
            } catch (IndexOutOfBoundsException e3) {
                indexOutOfBoundsException = e3;
                i2 = i;
                throw new zzhvr(i2, this.zzb, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j & (-128)) != 0) {
                zzhzj.zzp(this.zza, i2, (byte) (((int) j) | 128));
                j >>>= 7;
                i2++;
            }
            i = i2 + 1;
            zzhzj.zzp(this.zza, i2, (byte) j);
        }
        this.zzc = i;
    }
}
