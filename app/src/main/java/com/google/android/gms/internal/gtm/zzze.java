package com.google.android.gms.internal.gtm;

import androidx.work.WorkInfo;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzze extends zzzi {
    private final byte[] zza;
    private final int zzb;
    private int zzc;

    zzze(byte[] bArr, int i, int i2) {
        super(null);
        int length = bArr.length;
        if (((length - i2) | i2) < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i2)));
        }
        this.zza = bArr;
        this.zzc = 0;
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzI() {
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzJ(byte b) throws IOException {
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
            throw new zzzf(i2, this.zzb, 1, indexOutOfBoundsException);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzK(int i, boolean z) throws IOException {
        zzu(i << 3);
        zzJ(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzL(int i, zzyx zzyxVar) throws IOException {
        zzu((i << 3) | 2);
        zzu(zzyxVar.zzd());
        zzyxVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi, com.google.android.gms.internal.gtm.zzyp
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zze(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final int zzb() {
        return this.zzb - this.zzc;
    }

    public final void zze(byte[] bArr, int i, int i2) throws IOException {
        try {
            System.arraycopy(bArr, 0, this.zza, this.zzc, i2);
            this.zzc += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzzf(this.zzc, this.zzb, i2, e);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzh(int i, int i2) throws IOException {
        zzu((i << 3) | 5);
        zzi(i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzi(int i) throws IOException {
        int i2 = this.zzc;
        try {
            byte[] bArr = this.zza;
            bArr[i2] = (byte) i;
            bArr[i2 + 1] = (byte) (i >> 8);
            bArr[i2 + 2] = (byte) (i >> 16);
            bArr[i2 + 3] = (byte) (i >> 24);
            this.zzc = i2 + 4;
        } catch (IndexOutOfBoundsException e) {
            throw new zzzf(i2, this.zzb, 4, e);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzj(int i, long j) throws IOException {
        zzu((i << 3) | 1);
        zzk(j);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzk(long j) throws IOException {
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
            throw new zzzf(i, this.zzb, 8, e);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzl(int i, int i2) throws IOException {
        zzu(i << 3);
        zzm(i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzm(int i) throws IOException {
        if (i >= 0) {
            zzu(i);
        } else {
            zzw(i);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    final void zzn(int i, zzadl zzadlVar, zzadx zzadxVar) throws IOException {
        zzu((i << 3) | 2);
        zzu(((zzyh) zzadlVar).zzQ(zzadxVar));
        zzadxVar.zzj(zzadlVar, this.zze);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzo(int i, zzadl zzadlVar) throws IOException {
        zzu(11);
        zzt(2, i);
        zzu(26);
        zzu(zzadlVar.zzY());
        zzadlVar.zzax(this);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzp(int i, zzyx zzyxVar) throws IOException {
        zzu(11);
        zzt(2, i);
        zzL(3, zzyxVar);
        zzu(12);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzq(int i, String str) throws IOException {
        zzu((i << 3) | 2);
        zzr(str);
    }

    public final void zzr(String str) throws IOException {
        int i = this.zzc;
        try {
            int iZzC = zzC(str.length() * 3);
            int iZzC2 = zzC(str.length());
            if (iZzC2 != iZzC) {
                zzu(zzaew.zzc(str));
                byte[] bArr = this.zza;
                int i2 = this.zzc;
                this.zzc = zzaew.zzb(str, bArr, i2, this.zzb - i2);
                return;
            }
            int i3 = i + iZzC2;
            this.zzc = i3;
            int iZzb = zzaew.zzb(str, this.zza, i3, this.zzb - i3);
            this.zzc = i;
            zzu((iZzb - i) - iZzC2);
            this.zzc = iZzb;
        } catch (zzaev e) {
            this.zzc = i;
            zzE(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzzf(e2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzs(int i, int i2) throws IOException {
        zzu((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzt(int i, int i2) throws IOException {
        zzu(i << 3);
        zzu(i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzv(int i, long j) throws IOException {
        zzu(i << 3);
        zzw(j);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzu(int i) throws IOException {
        int i2;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i3 = this.zzc;
        while ((i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
            try {
                i2 = i3 + 1;
            } catch (IndexOutOfBoundsException e) {
                indexOutOfBoundsException = e;
                throw new zzzf(i3, this.zzb, 1, indexOutOfBoundsException);
            }
            try {
                this.zza[i3] = (byte) (i | 128);
                i >>>= 7;
                i3 = i2;
            } catch (IndexOutOfBoundsException e2) {
                indexOutOfBoundsException = e2;
                i3 = i2;
                throw new zzzf(i3, this.zzb, 1, indexOutOfBoundsException);
            }
        }
        i2 = i3 + 1;
        this.zza[i3] = (byte) i;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzw(long j) throws IOException {
        int i;
        IndexOutOfBoundsException indexOutOfBoundsException;
        int i2 = this.zzc;
        if (!zzzi.zzb || this.zzb - i2 < 10) {
            while ((j & (-128)) != 0) {
                try {
                    int i3 = i2 + 1;
                    try {
                        this.zza[i2] = (byte) (((int) j) | 128);
                        j >>>= 7;
                        i2 = i3;
                    } catch (IndexOutOfBoundsException e) {
                        e = e;
                        i2 = i3;
                        indexOutOfBoundsException = e;
                        throw new zzzf(i2, this.zzb, 1, indexOutOfBoundsException);
                    }
                } catch (IndexOutOfBoundsException e2) {
                    e = e2;
                }
            }
            i = i2 + 1;
            try {
                this.zza[i2] = (byte) j;
            } catch (IndexOutOfBoundsException e3) {
                indexOutOfBoundsException = e3;
                i2 = i;
                throw new zzzf(i2, this.zzb, 1, indexOutOfBoundsException);
            }
        } else {
            while ((j & (-128)) != 0) {
                zzaet.zzn(this.zza, i2, (byte) (((int) j) | 128));
                j >>>= 7;
                i2++;
            }
            i = i2 + 1;
            zzaet.zzn(this.zza, i2, (byte) j);
        }
        this.zzc = i;
    }
}
