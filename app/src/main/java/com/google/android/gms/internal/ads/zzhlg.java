package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhlg extends zzhwo implements zzhya {
    private static final zzhlg zzc;
    private static volatile zzhyh zzd;
    private int zza;
    private zzhxa zzb = zzbM();

    static {
        zzhlg zzhlgVar = new zzhlg();
        zzc = zzhlgVar;
        zzhwo.zzbu(zzhlg.class, zzhlgVar);
    }

    private zzhlg() {
    }

    public static zzhlg zze(byte[] bArr, zzhvy zzhvyVar) throws zzhxd {
        return (zzhlg) zzhwo.zzbV(zzc, bArr, zzhvyVar);
    }

    public static zzhlg zzg(InputStream inputStream, zzhvy zzhvyVar) throws IOException {
        return (zzhlg) zzhwo.zzbX(zzc, inputStream, zzhvyVar);
    }

    public static zzhld zzh() {
        return (zzhld) zzc.zzbn();
    }

    public final int zza() {
        return this.zza;
    }

    public final List zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zzb.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzhlf zzd(int i) {
        return (zzhlf) this.zzb.get(i);
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zza", "zzb", zzhlf.class});
        }
        if (iOrdinal == 3) {
            return new zzhlg();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhld(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzd;
        if (zzhwjVar == null) {
            synchronized (zzhlg.class) {
                zzhwjVar = zzd;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzc);
                    zzd = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzi(int i) {
        this.zza = i;
    }

    final /* synthetic */ void zzj(zzhlf zzhlfVar) {
        zzhlfVar.getClass();
        zzhxa zzhxaVar = this.zzb;
        if (!zzhxaVar.zza()) {
            this.zzb = zzhwo.zzbN(zzhxaVar);
        }
        this.zzb.add(zzhlfVar);
    }
}
