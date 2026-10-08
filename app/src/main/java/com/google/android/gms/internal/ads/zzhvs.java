package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhvs extends zzhvp {
    private final OutputStream zzg;

    zzhvs(OutputStream outputStream, int i) {
        super(i);
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.zzg = outputStream;
    }

    private final void zzH(int i) throws IOException {
        if (this.zzb - this.zzc < i) {
            zzI();
        }
    }

    private final void zzI() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzJ(int i, int i2) throws IOException {
        zzs((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzK(int i, int i2) throws IOException {
        zzH(20);
        zzd(i << 3);
        if (i2 >= 0) {
            zzd(i2);
        } else {
            zze(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzL(int i, int i2) throws IOException {
        zzH(20);
        zzd(i << 3);
        zzd(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzM(int i, int i2) throws IOException {
        zzH(14);
        zzd((i << 3) | 5);
        zzf(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzN(int i, long j) throws IOException {
        zzH(20);
        zzd(i << 3);
        zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt, com.google.android.gms.internal.ads.zzhuz
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzw(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzh(int i, long j) throws IOException {
        zzH(18);
        zzd((i << 3) | 1);
        zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzi(int i, boolean z) throws IOException {
        zzH(11);
        zzd(i << 3);
        zzc(z ? (byte) 1 : (byte) 0);
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
        if (this.zzc == this.zzb) {
            zzI();
        }
        zzc(b);
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
    public final void zzs(int i) throws IOException {
        zzH(5);
        zzd(i);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzt(int i) throws IOException {
        zzH(4);
        zzf(i);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzu(long j) throws IOException {
        zzH(10);
        zze(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzv(long j) throws IOException {
        zzH(8);
        zzg(j);
    }

    public final void zzw(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzb;
        int i4 = this.zzc;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, this.zza, i4, i2);
            this.zzc += i2;
            this.zzd += i2;
            return;
        }
        byte[] bArr2 = this.zza;
        System.arraycopy(bArr, i, bArr2, i4, i5);
        int i6 = i + i5;
        this.zzc = i3;
        this.zzd += i5;
        zzI();
        int i7 = i2 - i5;
        if (i7 <= i3) {
            System.arraycopy(bArr, i6, bArr2, 0, i7);
            this.zzc = i7;
        } else {
            this.zzg.write(bArr, i6, i7);
        }
        this.zzd += i7;
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzx(String str) throws IOException {
        int iZzc;
        try {
            int length = str.length() * 3;
            int iZzA = zzA(length);
            int i = iZzA + length;
            int i2 = this.zzb;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iZzd = zzhzo.zzd(str, bArr, 0, length);
                zzs(iZzd);
                zzw(bArr, 0, iZzd);
                return;
            }
            if (i > i2 - this.zzc) {
                zzI();
            }
            int iZzA2 = zzA(str.length());
            int i3 = this.zzc;
            try {
                if (iZzA2 == iZzA) {
                    int i4 = i3 + iZzA2;
                    this.zzc = i4;
                    int iZzd2 = zzhzo.zzd(str, this.zza, i4, i2 - i4);
                    this.zzc = i3;
                    iZzc = (iZzd2 - i3) - iZzA2;
                    zzd(iZzc);
                    this.zzc = iZzd2;
                } else {
                    iZzc = zzhzo.zzc(str);
                    zzd(iZzc);
                    this.zzc = zzhzo.zzd(str, this.zza, this.zzc, iZzc);
                }
                this.zzd += iZzc;
            } catch (zzhzn e) {
                this.zzd -= this.zzc - i3;
                this.zzc = i3;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new zzhvr(e2);
            }
        } catch (zzhzn e3) {
            zzF(str, e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvt
    public final void zzy() throws IOException {
        if (this.zzc > 0) {
            zzI();
        }
    }
}
