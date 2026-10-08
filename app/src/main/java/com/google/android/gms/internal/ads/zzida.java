package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzida extends zzhwo implements zzhya {
    private static final zzida zzR;
    private static volatile zzhyh zzS;
    private zzicw zzA;
    private zzibc zzC;
    private zziau zzE;
    private zzibv zzG;
    private int zzH;
    private long zzK;
    private zzicz zzL;
    private zzica zzM;
    private zzict zzO;
    private int zza;
    private int zzb;
    private int zzc;
    private zziay zzg;
    private zzicg zzk;
    private boolean zzl;
    private boolean zzo;
    private boolean zzp;
    private zzicn zzv;
    private boolean zzw;
    private byte zzQ = 2;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private zzhxa zzh = zzbM();
    private zzhxa zzi = zzbM();
    private String zzj = "";
    private zzhxa zzm = zzhwo.zzbM();
    private String zzn = "";
    private zzhvi zzu = zzhvi.zzb;
    private String zzx = "";
    private zzhxa zzy = zzhwo.zzbM();
    private zzhxa zzz = zzhwo.zzbM();
    private zzhxa zzB = zzbM();
    private String zzD = "";
    private zzhxa zzF = zzbM();
    private zzhxa zzI = zzbM();
    private zzhxa zzJ = zzbM();
    private String zzN = "";
    private zzhxa zzP = zzbM();

    static {
        zzida zzidaVar = new zzida();
        zzR = zzidaVar;
        zzhwo.zzbu(zzida.class, zzidaVar);
    }

    private zzida() {
    }

    public static zziaw zzg() {
        return (zziaw) zzR.zzbn();
    }

    public final String zzc() {
        return this.zzd;
    }

    public final List zzd() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        byte[] bArr = null;
        switch (zzhwnVar) {
            case GET_MEMOIZED_IS_INITIALIZED:
                return Byte.valueOf(this.zzQ);
            case SET_MEMOIZED_IS_INITIALIZED:
                this.zzQ = obj == null ? (byte) 0 : (byte) 1;
                return null;
            case BUILD_MESSAGE_INFO:
                return zzbv(zzR, "\u0001%\u0000\u0001\u0001%%\u0000\n\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\n᠌\u0000\u000b᠌\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013\u001b\u001b\u001cဉ\u0014\u001d᠌\u0015\u001e\u001b\u001f\u001b ဂ\u0016!ဉ\u0017\"ဉ\u0018#ဈ\u0019$ဉ\u001a%\u001b", new Object[]{"zza", "zzd", "zze", "zzf", "zzh", zzicl.class, "zzl", "zzm", "zzn", "zzo", "zzp", "zzb", zzich.zza, "zzc", zziav.zza, "zzg", "zzj", "zzk", "zzu", "zzi", zzide.class, "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", zzidk.class, "zzC", "zzD", "zzE", "zzF", zzibg.class, "zzG", "zzH", zzicu.zza, "zzI", zziby.class, "zzJ", zzicd.class, "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", zzicq.class});
            case NEW_MUTABLE_INSTANCE:
                return new zzida();
            case NEW_BUILDER:
                return new zziaw(bArr);
            case GET_DEFAULT_INSTANCE:
                return zzR;
            case GET_PARSER:
                zzhyh zzhwjVar = zzS;
                if (zzhwjVar == null) {
                    synchronized (zzida.class) {
                        zzhwjVar = zzS;
                        if (zzhwjVar == null) {
                            zzhwjVar = new zzhwj(zzR);
                            zzS = zzhwjVar;
                        }
                        break;
                    }
                }
                return zzhwjVar;
            default:
                throw null;
        }
    }

    public final String zze() {
        return this.zzj;
    }

    final /* synthetic */ void zzh(String str) {
        this.zza |= 4;
        this.zzd = str;
    }

    final /* synthetic */ void zzi(String str) {
        this.zza |= 8;
        this.zze = str;
    }

    final /* synthetic */ void zzj(zziay zziayVar) {
        zziayVar.getClass();
        this.zzg = zziayVar;
        this.zza |= 32;
    }

    final /* synthetic */ void zzk(zzicl zziclVar) {
        zziclVar.getClass();
        zzhxa zzhxaVar = this.zzh;
        if (!zzhxaVar.zza()) {
            this.zzh = zzhwo.zzbN(zzhxaVar);
        }
        this.zzh.add(zziclVar);
    }

    final /* synthetic */ void zzl(String str) {
        this.zza |= 64;
        this.zzj = str;
    }

    final /* synthetic */ void zzm() {
        this.zza &= -65;
        this.zzj = zzR.zzj;
    }

    final /* synthetic */ void zzn(zzicg zzicgVar) {
        zzicgVar.getClass();
        this.zzk = zzicgVar;
        this.zza |= 128;
    }

    final /* synthetic */ void zzo(zzicn zzicnVar) {
        zzicnVar.getClass();
        this.zzv = zzicnVar;
        this.zza |= 8192;
    }

    final /* synthetic */ void zzp(Iterable iterable) {
        zzhxa zzhxaVar = this.zzy;
        if (!zzhxaVar.zza()) {
            this.zzy = zzhwo.zzbN(zzhxaVar);
        }
        zzhur.zzaW(iterable, this.zzy);
    }

    final /* synthetic */ void zzq(Iterable iterable) {
        zzhxa zzhxaVar = this.zzz;
        if (!zzhxaVar.zza()) {
            this.zzz = zzhwo.zzbN(zzhxaVar);
        }
        zzhur.zzaW(iterable, this.zzz);
    }

    final /* synthetic */ void zzs(int i) {
        this.zzb = i - 1;
        this.zza |= 1;
    }
}
