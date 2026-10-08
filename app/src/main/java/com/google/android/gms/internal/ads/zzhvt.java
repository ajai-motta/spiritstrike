package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhvt extends zzhuz {
    private static final Logger zza = Logger.getLogger(zzhvt.class.getName());
    private static final boolean zzb = zzhzj.zza();
    public static final /* synthetic */ int zzf = 0;
    Object zze;

    private zzhvt() {
        throw null;
    }

    /* synthetic */ zzhvt(byte[] bArr) {
    }

    public static int zzA(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzB(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    public static int zzC(String str) {
        int length;
        try {
            length = zzhzo.zzc(str);
        } catch (zzhzn unused) {
            length = str.getBytes(zzhxb.zza).length;
        }
        return zzA(length) + length;
    }

    public static int zzD(zzhxz zzhxzVar) {
        int iZzbr = zzhxzVar.zzbr();
        return zzA(iZzbr) + iZzbr;
    }

    static int zzz(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public final void zzE() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void zzF(String str, zzhzn zzhznVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzhznVar);
        byte[] bytes = str.getBytes(zzhxb.zza);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzhvr(e);
        }
    }

    public abstract void zzJ(int i, int i2) throws IOException;

    public abstract void zzK(int i, int i2) throws IOException;

    public abstract void zzL(int i, int i2) throws IOException;

    public abstract void zzM(int i, int i2) throws IOException;

    public abstract void zzN(int i, long j) throws IOException;

    @Override // com.google.android.gms.internal.ads.zzhuz
    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzi(int i, boolean z) throws IOException;

    public abstract void zzj(int i, String str) throws IOException;

    public abstract void zzk(int i, zzhvi zzhviVar) throws IOException;

    public abstract void zzl(zzhvi zzhviVar) throws IOException;

    abstract void zzm(byte[] bArr, int i, int i2) throws IOException;

    public abstract void zzn(int i, zzhxz zzhxzVar) throws IOException;

    public abstract void zzo(int i, zzhvi zzhviVar) throws IOException;

    public abstract void zzp(zzhxz zzhxzVar) throws IOException;

    public abstract void zzq(byte b) throws IOException;

    public abstract void zzr(int i) throws IOException;

    public abstract void zzs(int i) throws IOException;

    public abstract void zzt(int i) throws IOException;

    public abstract void zzu(long j) throws IOException;

    public abstract void zzv(long j) throws IOException;

    public abstract void zzx(String str) throws IOException;

    public abstract void zzy() throws IOException;
}
