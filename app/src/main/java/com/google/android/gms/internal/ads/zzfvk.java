package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfvk extends zzhwo implements zzhya {
    private static final zzfvk zzb;
    private static volatile zzhyh zzc;
    private zzhxt zza = zzhxt.zza();

    static {
        zzfvk zzfvkVar = new zzfvk();
        zzb = zzfvkVar;
        zzhwo.zzbu(zzfvk.class, zzfvkVar);
    }

    private zzfvk() {
    }

    public static zzfvk zzc(InputStream inputStream) throws IOException {
        return (zzfvk) zzhwo.zzbW(zzb, inputStream);
    }

    public static zzfvk zzd() {
        return zzb;
    }

    public final int zza() {
        return this.zza.size();
    }

    public final Map zzb() {
        return Collections.unmodifiableMap(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"zza", zzfvj.zza});
        }
        if (iOrdinal == 3) {
            return new zzfvk();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfvi(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzc;
        if (zzhwjVar == null) {
            synchronized (zzfvk.class) {
                zzhwjVar = zzc;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzb);
                    zzc = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ Map zze() {
        if (!this.zza.zze()) {
            this.zza = this.zza.zzc();
        }
        return this.zza;
    }
}
