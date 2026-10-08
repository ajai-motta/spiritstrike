package com.google.android.gms.internal.ads;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhvk extends zzhvn {
    private final Iterable zza;
    private final Iterator zzg;
    private ByteBuffer zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private long zzo;
    private long zzp;

    /* synthetic */ zzhvk(Iterable iterable, int i, boolean z, byte[] bArr) {
        super(null);
        this.zzk = Integer.MAX_VALUE;
        this.zzi = i;
        this.zza = iterable;
        this.zzg = iterable.iterator();
        this.zzm = 0;
        if (i != 0) {
            zzO();
            return;
        }
        this.zzh = zzhxb.zzc;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = 0L;
    }

    private final void zzN() throws zzhxd {
        if (!this.zzg.hasNext()) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        zzO();
    }

    private final void zzO() {
        ByteBuffer byteBuffer = (ByteBuffer) this.zzg.next();
        this.zzh = byteBuffer;
        this.zzm += (int) (this.zzn - this.zzo);
        long jPosition = byteBuffer.position();
        this.zzn = jPosition;
        this.zzo = jPosition;
        this.zzp = this.zzh.limit();
        long jZzs = zzhzj.zzs(this.zzh);
        this.zzn += jZzs;
        this.zzo += jZzs;
        this.zzp += jZzs;
    }

    private final void zzP() {
        int i = this.zzi + this.zzj;
        this.zzi = i;
        int i2 = this.zzk;
        if (i <= i2) {
            this.zzj = 0;
            return;
        }
        int i3 = i - i2;
        this.zzj = i3;
        this.zzi = i - i3;
    }

    private final void zzQ(byte[] bArr, int i, int i2) throws IOException {
        if (i2 > zzR()) {
            if (i2 > 0) {
                throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            return;
        }
        int i3 = i2;
        while (i3 > 0) {
            if (this.zzp - this.zzn == 0) {
                zzN();
            }
            int iMin = Math.min(i3, (int) (this.zzp - this.zzn));
            long j = iMin;
            zzhzj.zzq(this.zzn, bArr, i2 - i3, j);
            i3 -= iMin;
            this.zzn += j;
        }
    }

    private final int zzR() {
        return (int) ((((long) (this.zzi - this.zzm)) - this.zzn) + this.zzo);
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final void zzA(int i) {
        this.zzk = i;
        zzP();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final boolean zzB() throws IOException {
        return (((long) this.zzm) + this.zzn) - this.zzo == ((long) this.zzi);
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzC() {
        return (int) ((((long) this.zzm) + this.zzn) - this.zzo);
    }

    public final byte zzD() throws IOException {
        if (this.zzp - this.zzn == 0) {
            zzN();
        }
        long j = this.zzn;
        this.zzn = 1 + j;
        return zzhzj.zzr(j);
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zza() throws IOException {
        if (zzB()) {
            this.zzl = 0;
            return 0;
        }
        int iZzu = zzu();
        this.zzl = iZzu;
        if ((iZzu >>> 3) != 0) {
            return iZzu;
        }
        throw new zzhxd("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final void zzb(int i) throws zzhxd {
        if (this.zzl != i) {
            throw new zzhxd("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final double zzd() throws IOException {
        return Double.longBitsToDouble(zzy());
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final float zze() throws IOException {
        return Float.intBitsToFloat(zzx());
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final long zzf() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final long zzg() throws IOException {
        return zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzh() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final long zzi() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzj() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final boolean zzk() throws IOException {
        return zzv() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final String zzl() throws IOException {
        int iZzu = zzu();
        if (iZzu > 0) {
            long j = this.zzp;
            long j2 = this.zzn;
            long j3 = iZzu;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[iZzu];
                zzhzj.zzq(j2, bArr, 0L, j3);
                String str = new String(bArr, zzhxb.zza);
                this.zzn += j3;
                return str;
            }
        }
        if (iZzu > 0 && iZzu <= zzR()) {
            byte[] bArr2 = new byte[iZzu];
            zzQ(bArr2, 0, iZzu);
            return new String(bArr2, zzhxb.zza);
        }
        if (iZzu == 0) {
            return "";
        }
        if (iZzu < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final String zzm() throws IOException {
        int iZzu = zzu();
        if (iZzu > 0) {
            long j = this.zzp;
            long j2 = this.zzn;
            long j3 = iZzu;
            if (j3 <= j - j2) {
                String strZze = zzhzo.zze(this.zzh, (int) (j2 - this.zzo), iZzu);
                this.zzn += j3;
                return strZze;
            }
        }
        if (iZzu >= 0 && iZzu <= zzR()) {
            byte[] bArr = new byte[iZzu];
            zzQ(bArr, 0, iZzu);
            return zzhzo.zzf(bArr, 0, iZzu);
        }
        if (iZzu == 0) {
            return "";
        }
        if (iZzu <= 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final zzhvi zzn() throws IOException {
        int iZzu = zzu();
        if (iZzu > 0) {
            long j = this.zzp;
            long j2 = this.zzn;
            long j3 = iZzu;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[iZzu];
                zzhzj.zzq(j2, bArr, 0L, j3);
                this.zzn += j3;
                zzhvi zzhviVar = zzhvi.zzb;
                return new zzhvg(bArr);
            }
        }
        if (iZzu > 0 && iZzu <= zzR()) {
            byte[] bArr2 = new byte[iZzu];
            zzQ(bArr2, 0, iZzu);
            zzhvi zzhviVar2 = zzhvi.zzb;
            return new zzhvg(bArr2);
        }
        if (iZzu == 0) {
            return zzhvi.zzb;
        }
        if (iZzu < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzo() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzp() throws IOException {
        return zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzq() throws IOException {
        return zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final long zzr() throws IOException {
        return zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzs() throws IOException {
        return zzK(zzu());
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final long zzt() throws IOException {
        return zzL(zzv());
    }

    final long zzw() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZzD = zzD();
            j |= ((long) (bZzD & 127)) << i;
            if ((bZzD & 128) == 0) {
                return j;
            }
        }
        throw new zzhxd("CodedInputStream encountered a malformed varint.");
    }

    public final int zzx() throws IOException {
        long j = this.zzp;
        long j2 = this.zzn;
        if (j - j2 < 4) {
            int iZzD = zzD() & 255;
            int iZzD2 = (zzD() & 255) << 8;
            return iZzD | iZzD2 | ((zzD() & 255) << 16) | ((zzD() & 255) << 24);
        }
        this.zzn = 4 + j2;
        int iZzr = zzhzj.zzr(j2) & 255;
        int iZzr2 = (zzhzj.zzr(1 + j2) & 255) << 8;
        return iZzr | iZzr2 | ((zzhzj.zzr(2 + j2) & 255) << 16) | ((zzhzj.zzr(j2 + 3) & 255) << 24);
    }

    public final long zzy() throws IOException {
        long j = this.zzp;
        long j2 = this.zzn;
        if (j - j2 < 8) {
            long jZzD = ((long) zzD()) & 255;
            long jZzD2 = (((long) zzD()) & 255) << 8;
            long jZzD3 = (((long) zzD()) & 255) << 16;
            long jZzD4 = (((long) zzD()) & 255) << 24;
            long jZzD5 = (((long) zzD()) & 255) << 32;
            long jZzD6 = (((long) zzD()) & 255) << 40;
            return jZzD | jZzD2 | jZzD3 | jZzD4 | jZzD5 | jZzD6 | ((((long) zzD()) & 255) << 48) | ((((long) zzD()) & 255) << 56);
        }
        this.zzn = 8 + j2;
        long jZzr = ((long) zzhzj.zzr(j2)) & 255;
        long jZzr2 = (((long) zzhzj.zzr(1 + j2)) & 255) << 8;
        long jZzr3 = (((long) zzhzj.zzr(j2 + 2)) & 255) << 16;
        long jZzr4 = (((long) zzhzj.zzr(3 + j2)) & 255) << 24;
        long jZzr5 = (((long) zzhzj.zzr(j2 + 4)) & 255) << 32;
        long jZzr6 = (((long) zzhzj.zzr(j2 + 5)) & 255) << 40;
        return jZzr5 | jZzr | jZzr2 | jZzr3 | jZzr4 | jZzr6 | ((((long) zzhzj.zzr(j2 + 6)) & 255) << 48) | ((((long) zzhzj.zzr(j2 + 7)) & 255) << 56);
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final int zzz(int i) throws zzhxd {
        if (i < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int iZzC = i + zzC();
        int i2 = this.zzk;
        if (iZzC > i2) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.zzk = iZzC;
        zzP();
        return i2;
    }

    public final void zzE(int i) throws IOException {
        if (i >= 0) {
            if (i <= (((long) (this.zzi - this.zzm)) - this.zzn) + this.zzo) {
                while (i > 0) {
                    if (this.zzp - this.zzn == 0) {
                        zzN();
                    }
                    int iMin = Math.min(i, (int) (this.zzp - this.zzn));
                    i -= iMin;
                    this.zzn += (long) iMin;
                }
                return;
            }
        }
        if (i >= 0) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.gms.internal.ads.zzhvn
    public final boolean zzc(int i) throws IOException {
        int i2 = i & 7;
        if (i2 == 0) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (zzD() >= 0) {
                    return true;
                }
            }
            throw new zzhxd("CodedInputStream encountered a malformed varint.");
        }
        if (i2 == 1) {
            zzE(8);
            return true;
        }
        if (i2 == 2) {
            zzE(zzu());
            return true;
        }
        if (i2 == 3) {
            zzJ();
            zzb(((i >>> 3) << 3) | 4);
            return true;
        }
        if (i2 == 4) {
            zzI();
            return false;
        }
        if (i2 != 5) {
            throw new zzhxc("Protocol message tag had invalid wire type.");
        }
        zzE(4);
        return true;
    }

    public final int zzu() throws IOException {
        int i;
        long j = this.zzn;
        if (this.zzp != j) {
            long j2 = j + 1;
            byte bZzr = zzhzj.zzr(j);
            if (bZzr >= 0) {
                this.zzn++;
                return bZzr;
            }
            if (this.zzp - this.zzn >= 10) {
                long j3 = 2 + j;
                int iZzr = (zzhzj.zzr(j2) << 7) ^ bZzr;
                if (iZzr < 0) {
                    i = iZzr ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                } else {
                    long j4 = 3 + j;
                    int iZzr2 = (zzhzj.zzr(j3) << Ascii.SO) ^ iZzr;
                    if (iZzr2 >= 0) {
                        i = iZzr2 ^ 16256;
                    } else {
                        long j5 = 4 + j;
                        int iZzr3 = iZzr2 ^ (zzhzj.zzr(j4) << Ascii.NAK);
                        if (iZzr3 < 0) {
                            i = (-2080896) ^ iZzr3;
                        } else {
                            j4 = 5 + j;
                            byte bZzr2 = zzhzj.zzr(j5);
                            int i2 = (iZzr3 ^ (bZzr2 << Ascii.FS)) ^ 266354560;
                            if (bZzr2 < 0) {
                                j5 = 6 + j;
                                if (zzhzj.zzr(j4) < 0) {
                                    j4 = 7 + j;
                                    if (zzhzj.zzr(j5) < 0) {
                                        j5 = 8 + j;
                                        if (zzhzj.zzr(j4) < 0) {
                                            j4 = 9 + j;
                                            if (zzhzj.zzr(j5) < 0) {
                                                long j6 = j + 10;
                                                if (zzhzj.zzr(j4) >= 0) {
                                                    i = i2;
                                                    j3 = j6;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i2;
                            }
                            i = i2;
                        }
                        j3 = j5;
                    }
                    j3 = j4;
                }
                this.zzn = j3;
                return i;
            }
        }
        return (int) zzw();
    }

    public final long zzv() throws IOException {
        long j;
        long j2;
        long j3 = this.zzn;
        if (this.zzp != j3) {
            long j4 = j3 + 1;
            byte bZzr = zzhzj.zzr(j3);
            if (bZzr >= 0) {
                this.zzn++;
                return bZzr;
            }
            if (this.zzp - this.zzn >= 10) {
                long j5 = 2 + j3;
                int iZzr = (zzhzj.zzr(j4) << 7) ^ bZzr;
                if (iZzr < 0) {
                    j = iZzr ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                } else {
                    long j6 = 3 + j3;
                    int iZzr2 = (zzhzj.zzr(j5) << Ascii.SO) ^ iZzr;
                    if (iZzr2 >= 0) {
                        j = iZzr2 ^ 16256;
                    } else {
                        long j7 = 4 + j3;
                        int iZzr3 = iZzr2 ^ (zzhzj.zzr(j6) << Ascii.NAK);
                        if (iZzr3 < 0) {
                            j = (-2080896) ^ iZzr3;
                            j5 = j7;
                        } else {
                            j6 = 5 + j3;
                            long jZzr = (((long) zzhzj.zzr(j7)) << 28) ^ ((long) iZzr3);
                            if (jZzr >= 0) {
                                j = 266354560 ^ jZzr;
                            } else {
                                long j8 = 6 + j3;
                                long jZzr2 = jZzr ^ (((long) zzhzj.zzr(j6)) << 35);
                                if (jZzr2 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    long j9 = 7 + j3;
                                    long jZzr3 = jZzr2 ^ (((long) zzhzj.zzr(j8)) << 42);
                                    if (jZzr3 >= 0) {
                                        j = 4363953127296L ^ jZzr3;
                                    } else {
                                        j8 = 8 + j3;
                                        jZzr2 = jZzr3 ^ (((long) zzhzj.zzr(j9)) << 49);
                                        if (jZzr2 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            j9 = 9 + j3;
                                            long jZzr4 = (jZzr2 ^ (((long) zzhzj.zzr(j8)) << 56)) ^ 71499008037633920L;
                                            if (jZzr4 < 0) {
                                                long j10 = j3 + 10;
                                                if (zzhzj.zzr(j9) >= 0) {
                                                    j = jZzr4;
                                                    j5 = j10;
                                                }
                                            } else {
                                                j = jZzr4;
                                            }
                                        }
                                    }
                                    j5 = j9;
                                }
                                j = j2 ^ jZzr2;
                                j5 = j8;
                            }
                        }
                    }
                    j5 = j6;
                }
                this.zzn = j5;
                return j;
            }
        }
        return zzw();
    }
}
