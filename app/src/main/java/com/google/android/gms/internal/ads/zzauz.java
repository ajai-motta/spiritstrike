package com.google.android.gms.internal.ads;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzauz extends zzhwo implements zzhya {
    private static final zzauz zzbe;
    private static volatile zzhyh zzbf;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzH;
    private long zzI;
    private long zzJ;
    private long zzL;
    private zzavb zzO;
    private int zza;
    private zzauu zzaF;
    private zzaus zzaG;
    private long zzaM;
    private long zzaN;
    private zzauk zzaQ;
    private zzaum zzaR;
    private int zzaU;
    private long zzaV;
    private boolean zzaY;
    private zzauw zzag;
    private zzauy zzai;
    private int zzat;
    private int zzau;
    private int zzav;
    private int zzaw;
    private zzavo zzax;
    private int zzb;
    private long zzba;
    private zzavm zzbb;
    private int zzc;
    private int zzd;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;
    private String zze = "";
    private String zzf = "";
    private String zzu = "";
    private String zzE = "";
    private String zzF = "D";
    private String zzG = "";
    private String zzK = "";
    private long zzM = -1;
    private long zzN = -1;
    private long zzP = -1;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private long zzU = -1;
    private String zzV = "D";
    private String zzW = "D";
    private long zzX = -1;
    private int zzY = 1000;
    private int zzZ = 1000;
    private long zzaa = -1;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private long zzae = -1;
    private int zzaf = 1000;
    private zzhxa zzah = zzbM();
    private long zzaj = -1;
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private long zzap = -1;
    private long zzaq = -1;
    private String zzar = "D";
    private long zzas = -1;
    private long zzay = -1;
    private int zzaz = 1000;
    private int zzaA = 1000;
    private String zzaB = "D";
    private zzhxa zzaC = zzbM();
    private int zzaD = 1000;
    private zzhxa zzaE = zzbM();
    private String zzaH = "";
    private long zzaI = -1;
    private long zzaJ = -1;
    private long zzaK = -1;
    private long zzaL = -1;
    private long zzaO = -1;
    private String zzaP = "";
    private long zzaS = -1;
    private long zzaT = -1;
    private String zzaW = "";
    private int zzaX = 2;
    private String zzaZ = "";
    private long zzbc = -1;
    private String zzbd = "";

    static {
        zzauz zzauzVar = new zzauz();
        zzbe = zzauzVar;
        zzhwo.zzbu(zzauz.class, zzauzVar);
    }

    private zzauz() {
    }

    public static zzauz zzi(byte[] bArr, zzhvy zzhvyVar) throws zzhxd {
        return (zzauz) zzhwo.zzbV(zzbe, bArr, zzhvyVar);
    }

    public static zzauc zzj() {
        return (zzauc) zzbe.zzbn();
    }

    public static zzauz zzk() {
        return zzbe;
    }

    final /* synthetic */ void zzA(String str) {
        str.getClass();
        this.zza |= 16777216;
        this.zzG = str;
    }

    final /* synthetic */ void zzB(long j) {
        this.zza |= 33554432;
        this.zzH = j;
    }

    final /* synthetic */ void zzC(long j) {
        this.zza |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        this.zzI = j;
    }

    final /* synthetic */ void zzD(long j) {
        this.zza |= C.BUFFER_FLAG_FIRST_SAMPLE;
        this.zzJ = j;
    }

    final /* synthetic */ void zzE(String str) {
        str.getClass();
        this.zza |= 268435456;
        this.zzK = str;
    }

    final /* synthetic */ void zzF(long j) {
        this.zza |= 536870912;
        this.zzL = j;
    }

    final /* synthetic */ void zzG(long j) {
        this.zza |= 1073741824;
        this.zzM = j;
    }

    final /* synthetic */ void zzH(long j) {
        this.zza |= Integer.MIN_VALUE;
        this.zzN = j;
    }

    final /* synthetic */ void zzI(long j) {
        this.zzb |= 2;
        this.zzP = j;
    }

    final /* synthetic */ void zzJ(long j) {
        this.zzb |= 4;
        this.zzQ = j;
    }

    final /* synthetic */ void zzK(long j) {
        this.zzb |= 8;
        this.zzR = j;
    }

    final /* synthetic */ void zzL(long j) {
        this.zzb |= 16;
        this.zzS = j;
    }

    final /* synthetic */ void zzM(long j) {
        this.zzb |= 32;
        this.zzT = j;
    }

    final /* synthetic */ void zzN(long j) {
        this.zzb |= 64;
        this.zzU = j;
    }

    final /* synthetic */ void zzO(String str) {
        str.getClass();
        this.zzb |= 128;
        this.zzV = str;
    }

    final /* synthetic */ void zzP(String str) {
        str.getClass();
        this.zzb |= 256;
        this.zzW = str;
    }

    final /* synthetic */ void zzQ(long j) {
        this.zzb |= 4096;
        this.zzaa = j;
    }

    final /* synthetic */ void zzR(long j) {
        this.zzb |= 8192;
        this.zzab = j;
    }

    final /* synthetic */ void zzS(long j) {
        this.zzb |= 16384;
        this.zzac = j;
    }

    final /* synthetic */ void zzT(zzauw zzauwVar) {
        zzauwVar.getClass();
        this.zzag = zzauwVar;
        this.zzb |= 262144;
    }

    final /* synthetic */ void zzU(zzauw zzauwVar) {
        zzauwVar.getClass();
        zzhxa zzhxaVar = this.zzah;
        if (!zzhxaVar.zza()) {
            this.zzah = zzhwo.zzbN(zzhxaVar);
        }
        this.zzah.add(zzauwVar);
    }

    final /* synthetic */ void zzV() {
        this.zzah = zzbM();
    }

    final /* synthetic */ void zzW(zzauy zzauyVar) {
        zzauyVar.getClass();
        this.zzai = zzauyVar;
        this.zzb |= 524288;
    }

    final /* synthetic */ void zzX(long j) {
        this.zzb |= 1048576;
        this.zzaj = j;
    }

    final /* synthetic */ void zzY(long j) {
        this.zzb |= 2097152;
        this.zzak = j;
    }

    final /* synthetic */ void zzZ(long j) {
        this.zzb |= 4194304;
        this.zzal = j;
    }

    public final boolean zza() {
        return (this.zza & 4194304) != 0;
    }

    final /* synthetic */ void zzaa(long j) {
        this.zzb |= 8388608;
        this.zzam = j;
    }

    final /* synthetic */ void zzab(long j) {
        this.zzb |= 16777216;
        this.zzan = j;
    }

    final /* synthetic */ void zzac(long j) {
        this.zzb |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        this.zzap = j;
    }

    final /* synthetic */ void zzad(long j) {
        this.zzb |= C.BUFFER_FLAG_FIRST_SAMPLE;
        this.zzaq = j;
    }

    final /* synthetic */ void zzae(String str) {
        str.getClass();
        this.zzb |= 268435456;
        this.zzar = str;
    }

    final /* synthetic */ void zzaf(String str) {
        str.getClass();
        this.zzc |= 1024;
        this.zzaH = str;
    }

    final /* synthetic */ void zzag(long j) {
        this.zzc |= 2048;
        this.zzaI = j;
    }

    final /* synthetic */ void zzah(long j) {
        this.zzc |= 4096;
        this.zzaJ = j;
    }

    final /* synthetic */ void zzai(long j) {
        this.zzc |= 8192;
        this.zzaK = j;
    }

    final /* synthetic */ void zzaj(long j) {
        this.zzc |= 16384;
        this.zzaL = j;
    }

    final /* synthetic */ void zzak(String str) {
        str.getClass();
        this.zzc |= 262144;
        this.zzaP = str;
    }

    final /* synthetic */ void zzal(long j) {
        this.zzc |= 4194304;
        this.zzaT = j;
    }

    final /* synthetic */ void zzam(long j) {
        this.zzc |= 536870912;
        this.zzba = j;
    }

    final /* synthetic */ void zzan(zzavm zzavmVar) {
        zzavmVar.getClass();
        this.zzbb = zzavmVar;
        this.zzc |= 1073741824;
    }

    final /* synthetic */ void zzap(int i) {
        this.zzY = i - 1;
        this.zzb |= 1024;
    }

    final /* synthetic */ void zzaq(int i) {
        this.zzZ = i - 1;
        this.zzb |= 2048;
    }

    final /* synthetic */ void zzar(int i) {
        this.zzaf = i - 1;
        this.zzb |= 131072;
    }

    final /* synthetic */ void zzas(int i) {
        this.zzaz = i - 1;
        this.zzc |= 16;
    }

    final /* synthetic */ void zzat(int i) {
        this.zzaA = i - 1;
        this.zzc |= 32;
    }

    final /* synthetic */ void zzau(int i) {
        this.zzaU = i - 1;
        this.zzc |= 8388608;
    }

    public final String zzb() {
        return this.zzE;
    }

    public final boolean zzc() {
        return (this.zzb & 1048576) != 0;
    }

    public final long zzd() {
        return this.zzaj;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zzhwu zzhwuVar = zzavh.zza;
            return zzbv(zzbe, "\u0001d\u0000\u0004\u0001Įd\u0000\u0003\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂX\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈY\u0019ဂ]\u001a᠌Z\u001bဈ\u0016\u001cဇ[\u001dဈ\u0018\u001eဈ\\\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌AEဉBFဂCGဂ8Hဂ9I᠌DJဂ)Kဈ\u0017L᠌EMဈFN\u001bO᠌GP\u001bQဉHRဈJSဂKTဂLUဂMVဂNWဂOXဂQYဈRZဉS[ဉT\\ဂU]ဂV^᠌W_᠌@`ဉIaဂPÉဉ^ĭဂ_Įဈ`", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzaV", "zzC", "zzD", "zzaW", "zzba", "zzaX", zzaug.zza, "zzE", "zzaY", "zzG", "zzaZ", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzah", zzauw.class, "zzT", "zzU", "zzV", "zzW", "zzY", zzhwuVar, "zzZ", zzhwuVar, "zzag", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", zzhwuVar, "zzai", "zzaj", "zzak", "zzal", "zzam", "zzap", "zzaq", "zzas", "zzat", zzavg.zza, "zzau", zzavk.zza, "zzar", "zzaw", zzaud.zza, "zzax", "zzay", "zzan", "zzao", "zzaz", zzhwuVar, "zzX", "zzF", "zzaA", zzhwuVar, "zzaB", "zzaC", zzauq.class, "zzaD", zzhwuVar, "zzaE", zzauf.class, "zzaF", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaO", "zzaP", "zzaQ", "zzaR", "zzaS", "zzaT", "zzaU", zzaun.zza, "zzav", zzauh.zza, "zzaG", "zzaN", "zzbb", "zzbc", "zzbd"});
        }
        if (iOrdinal == 3) {
            return new zzauz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzauc(bArr);
        }
        if (iOrdinal == 5) {
            return zzbe;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzbf;
        if (zzhwjVar == null) {
            synchronized (zzauz.class) {
                zzhwjVar = zzbf;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzbe);
                    zzbf = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    public final long zze() {
        return this.zzan;
    }

    public final boolean zzg() {
        return (this.zzc & 1073741824) != 0;
    }

    public final zzavm zzh() {
        zzavm zzavmVar = this.zzbb;
        return zzavmVar == null ? zzavm.zze() : zzavmVar;
    }

    final /* synthetic */ void zzl(String str) {
        str.getClass();
        this.zza |= 1;
        this.zze = str;
    }

    final /* synthetic */ void zzm(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzf = str;
    }

    final /* synthetic */ void zzn(long j) {
        this.zza |= 4;
        this.zzg = j;
    }

    final /* synthetic */ void zzo(long j) {
        this.zza |= 16;
        this.zzi = j;
    }

    final /* synthetic */ void zzp(long j) {
        this.zza |= 32;
        this.zzj = j;
    }

    final /* synthetic */ void zzq(long j) {
        this.zza |= 1024;
        this.zzo = j;
    }

    final /* synthetic */ void zzr(long j) {
        this.zza |= 2048;
        this.zzp = j;
    }

    final /* synthetic */ void zzs(long j) {
        this.zza |= 8192;
        this.zzv = j;
    }

    final /* synthetic */ void zzt(long j) {
        this.zza |= 16384;
        this.zzw = j;
    }

    final /* synthetic */ void zzu(long j) {
        this.zza |= 32768;
        this.zzx = j;
    }

    final /* synthetic */ void zzv(long j) {
        this.zza |= 65536;
        this.zzy = j;
    }

    final /* synthetic */ void zzw(long j) {
        this.zza |= 524288;
        this.zzB = j;
    }

    final /* synthetic */ void zzx(long j) {
        this.zza |= 1048576;
        this.zzC = j;
    }

    final /* synthetic */ void zzy(long j) {
        this.zza |= 2097152;
        this.zzD = j;
    }

    final /* synthetic */ void zzz(String str) {
        str.getClass();
        this.zza |= 4194304;
        this.zzE = str;
    }
}
