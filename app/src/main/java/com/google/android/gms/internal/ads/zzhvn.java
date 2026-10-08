package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhvn {
    private static volatile int zza = 100;
    public static final /* synthetic */ int zzf = 0;
    int zzb;
    int zzc;
    final int zzd = zza;
    Object zze;

    private zzhvn() {
    }

    /* synthetic */ zzhvn(byte[] bArr) {
    }

    public static zzhvn zzF(InputStream inputStream, int i) {
        if (inputStream != null) {
            return new zzhvl(inputStream, 4096, null);
        }
        byte[] bArr = zzhxb.zzb;
        int length = bArr.length;
        return zzG(bArr, 0, 0, false);
    }

    static zzhvn zzG(byte[] bArr, int i, int i2, boolean z) {
        zzhvj zzhvjVar = new zzhvj(bArr, i, i2, z, null);
        try {
            zzhvjVar.zzz(i2);
            return zzhvjVar;
        } catch (zzhxd e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzK(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long zzL(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    public static int zzM(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw new zzhxd("CodedInputStream encountered a malformed varint.");
    }

    public abstract void zzA(int i);

    public abstract boolean zzB() throws IOException;

    public abstract int zzC();

    public final void zzH() throws zzhxd {
        if (this.zzb + this.zzc >= this.zzd) {
            throw new zzhxd("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    public final void zzI() throws zzhxd {
        if (this.zzc == 0) {
            zzb(0);
        }
    }

    public final void zzJ() throws IOException {
        int iZza;
        do {
            iZza = zza();
            if (iZza == 0) {
                return;
            }
            zzH();
            this.zzc++;
            this.zzc--;
        } while (zzc(iZza));
    }

    public abstract int zza() throws IOException;

    public abstract void zzb(int i) throws zzhxd;

    public abstract boolean zzc(int i) throws IOException;

    public abstract double zzd() throws IOException;

    public abstract float zze() throws IOException;

    public abstract long zzf() throws IOException;

    public abstract long zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract long zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract boolean zzk() throws IOException;

    public abstract String zzl() throws IOException;

    public abstract String zzm() throws IOException;

    public abstract zzhvi zzn() throws IOException;

    public abstract int zzo() throws IOException;

    public abstract int zzp() throws IOException;

    public abstract int zzq() throws IOException;

    public abstract long zzr() throws IOException;

    public abstract int zzs() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract int zzz(int i) throws zzhxd;
}
