package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzidk extends zzhwo implements zzhya {
    private static final zzidk zzp;
    private static volatile zzhyh zzu;
    private int zza;
    private boolean zzh;
    private double zzi;
    private int zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private String zzb = "";
    private String zzc = "";
    private int zzd = 4;
    private zzhxa zze = zzhwo.zzbM();
    private String zzf = "";
    private String zzg = "";
    private zzhxa zzj = zzbM();

    static {
        zzidk zzidkVar = new zzidk();
        zzp = zzidkVar;
        zzhwo.zzbu(zzidk.class, zzidkVar);
    }

    private zzidk() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzp, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0002\u0003\u001a\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007က\u0006\b\u001b\tဈ\u0001\n᠌\u0007\u000bဇ\b\fဇ\t\rဇ\n\u000eဇ\u000b", new Object[]{"zza", "zzb", "zzd", zzidj.zza, "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzidi.class, "zzc", "zzk", zzidg.zza, "zzl", "zzm", "zzn", "zzo"});
        }
        if (iOrdinal == 3) {
            return new zzidk();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzidf(bArr);
        }
        if (iOrdinal == 5) {
            return zzp;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzu;
        if (zzhwjVar == null) {
            synchronized (zzidk.class) {
                zzhwjVar = zzu;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzp);
                    zzu = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
