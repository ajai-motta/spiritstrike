package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzzg extends zzzd {
    private final OutputStream zzg;

    zzzg(OutputStream outputStream, int i) {
        super(i);
        this.zzg = outputStream;
    }

    private final void zzG() throws IOException {
        this.zzg.write(this.zza, 0, this.zzc);
        this.zzc = 0;
    }

    private final void zzH(int i) throws IOException {
        if (this.zzb - this.zzc < i) {
            zzG();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzI() throws IOException {
        if (this.zzc > 0) {
            zzG();
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzJ(byte b) throws IOException {
        if (this.zzc == this.zzb) {
            zzG();
        }
        zzc(b);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzK(int i, boolean z) throws IOException {
        zzH(11);
        zzf(i << 3);
        zzc(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzL(int i, zzyx zzyxVar) throws IOException {
        zzu((i << 3) | 2);
        zzu(zzyxVar.zzd());
        zzyxVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi, com.google.android.gms.internal.gtm.zzyp
    public final void zza(byte[] bArr, int i, int i2) throws IOException {
        zzr(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzh(int i, int i2) throws IOException {
        zzH(14);
        zzf((i << 3) | 5);
        zzd(i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzi(int i) throws IOException {
        zzH(4);
        zzd(i);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzj(int i, long j) throws IOException {
        zzH(18);
        zzf((i << 3) | 1);
        zze(j);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzk(long j) throws IOException {
        zzH(8);
        zze(j);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzl(int i, int i2) throws IOException {
        zzH(20);
        zzf(i << 3);
        if (i2 >= 0) {
            zzf(i2);
        } else {
            zzg(i2);
        }
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
        zzx(str);
    }

    public final void zzr(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.zzb;
        int i4 = this.zzc;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, 0, this.zza, i4, i2);
            this.zzc += i2;
            this.zzd += i2;
            return;
        }
        System.arraycopy(bArr, 0, this.zza, i4, i5);
        this.zzc = this.zzb;
        this.zzd += i5;
        zzG();
        int i6 = i2 - i5;
        if (i6 <= this.zzb) {
            System.arraycopy(bArr, i5, this.zza, 0, i6);
            this.zzc = i6;
        } else {
            this.zzg.write(bArr, i5, i6);
        }
        this.zzd += i6;
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzs(int i, int i2) throws IOException {
        zzu((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzt(int i, int i2) throws IOException {
        zzH(20);
        zzf(i << 3);
        zzf(i2);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzu(int i) throws IOException {
        zzH(5);
        zzf(i);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzv(int i, long j) throws IOException {
        zzH(20);
        zzf(i << 3);
        zzg(j);
    }

    @Override // com.google.android.gms.internal.gtm.zzzi
    public final void zzw(long j) throws IOException {
        zzH(10);
        zzg(j);
    }

    public final void zzx(String str) throws IOException {
        int iZzc;
        try {
            int length = str.length() * 3;
            int iZzC = zzC(length);
            int i = iZzC + length;
            int i2 = this.zzb;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iZzb = zzaew.zzb(str, bArr, 0, length);
                zzu(iZzb);
                zzr(bArr, 0, iZzb);
                return;
            }
            if (i > i2 - this.zzc) {
                zzG();
            }
            int iZzC2 = zzC(str.length());
            int i3 = this.zzc;
            try {
                if (iZzC2 == iZzC) {
                    int i4 = i3 + iZzC2;
                    this.zzc = i4;
                    int iZzb2 = zzaew.zzb(str, this.zza, i4, this.zzb - i4);
                    this.zzc = i3;
                    iZzc = (iZzb2 - i3) - iZzC2;
                    zzf(iZzc);
                    this.zzc = iZzb2;
                } else {
                    iZzc = zzaew.zzc(str);
                    zzf(iZzc);
                    this.zzc = zzaew.zzb(str, this.zza, this.zzc, iZzc);
                }
                this.zzd += iZzc;
            } catch (zzaev e) {
                this.zzd -= this.zzc - i3;
                this.zzc = i3;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new zzzf(e2);
            }
        } catch (zzaev e3) {
            zzE(str, e3);
        }
    }
}
