package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzicl extends zzhwo implements zzhya {
    private static final zzicl zzl;
    private static volatile zzhyh zzm;
    private int zza;
    private int zzb;
    private zzibm zzd;
    private zzibq zze;
    private int zzf;
    private int zzi;
    private byte zzk = 2;
    private String zzc = "";
    private zzhww zzg = zzbC();
    private String zzh = "";
    private zzhxa zzj = zzhwo.zzbM();

    static {
        zzicl zziclVar = new zzicl();
        zzl = zziclVar;
        zzhwo.zzbu(zzicl.class, zziclVar);
    }

    private zzicl() {
    }

    public static zzick zze() {
        return (zzick) zzl.zzbn();
    }

    public final String zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzj.size();
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        byte[] bArr = null;
        switch (zzhwnVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzk);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzk = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzbv(zzl, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\b᠌\u0006\t\u001a", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzici.zza, "zzj"});
            case NEW_MUTABLE_INSTANCE:
                return new zzicl();
            case NEW_BUILDER:
                return new zzick(bArr);
            case GET_DEFAULT_INSTANCE:
                return zzl;
            case GET_PARSER:
                zzhyh zzhwjVar = zzm;
                if (zzhwjVar == null) {
                    synchronized (zzicl.class) {
                        zzhwjVar = zzm;
                        if (zzhwjVar == null) {
                            zzhwjVar = new zzhwj(zzl);
                            zzm = zzhwjVar;
                        }
                        break;
                    }
                }
                return zzhwjVar;
            default:
                throw null;
        }
    }

    final /* synthetic */ void zzg(int i) {
        this.zza |= 1;
        this.zzb = i;
    }

    final /* synthetic */ void zzh(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzc = str;
    }

    final /* synthetic */ void zzi(zzibm zzibmVar) {
        zzibmVar.getClass();
        this.zzd = zzibmVar;
        this.zza |= 4;
    }

    final /* synthetic */ void zzj(String str) {
        str.getClass();
        zzhxa zzhxaVar = this.zzj;
        if (!zzhxaVar.zza()) {
            this.zzj = zzhwo.zzbN(zzhxaVar);
        }
        this.zzj.add(str);
    }

    final /* synthetic */ void zzl(int i) {
        this.zzi = i - 1;
        this.zza |= 64;
    }
}
