package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzzi extends zzyp {
    private static final Logger zza = Logger.getLogger(zzzi.class.getName());
    private static final boolean zzb = zzaet.zzx();
    public static final /* synthetic */ int zzf = 0;
    zzzj zze;

    private zzzi() {
        throw null;
    }

    /* synthetic */ zzzi(zzzh zzzhVar) {
    }

    static int zzA(zzadl zzadlVar, zzadx zzadxVar) {
        int iZzQ = ((zzyh) zzadlVar).zzQ(zzadxVar);
        return zzC(iZzQ) + iZzQ;
    }

    public static int zzB(String str) {
        int length;
        try {
            length = zzaew.zzc(str);
        } catch (zzaev unused) {
            length = str.getBytes(zzaco.zza).length;
        }
        return zzC(length) + length;
    }

    public static int zzC(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    public static int zzD(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    @Deprecated
    static int zzy(int i, zzadl zzadlVar, zzadx zzadxVar) {
        int iZzC = zzC(i << 3);
        return iZzC + iZzC + ((zzyh) zzadlVar).zzQ(zzadxVar);
    }

    public static int zzz(zzadl zzadlVar) {
        int iZzY = zzadlVar.zzY();
        return zzC(iZzY) + iZzY;
    }

    final void zzE(String str, zzaev zzaevVar) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzaevVar);
        byte[] bytes = str.getBytes(zzaco.zza);
        try {
            int length = bytes.length;
            zzu(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzzf(e);
        }
    }

    public abstract void zzI() throws IOException;

    public abstract void zzJ(byte b) throws IOException;

    public abstract void zzK(int i, boolean z) throws IOException;

    public abstract void zzL(int i, zzyx zzyxVar) throws IOException;

    @Override // com.google.android.gms.internal.gtm.zzyp
    public abstract void zza(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(long j) throws IOException;

    public abstract void zzl(int i, int i2) throws IOException;

    public abstract void zzm(int i) throws IOException;

    abstract void zzn(int i, zzadl zzadlVar, zzadx zzadxVar) throws IOException;

    public abstract void zzo(int i, zzadl zzadlVar) throws IOException;

    public abstract void zzp(int i, zzyx zzyxVar) throws IOException;

    public abstract void zzq(int i, String str) throws IOException;

    public abstract void zzs(int i, int i2) throws IOException;

    public abstract void zzt(int i, int i2) throws IOException;

    public abstract void zzu(int i) throws IOException;

    public abstract void zzv(int i, long j) throws IOException;

    public abstract void zzw(long j) throws IOException;
}
