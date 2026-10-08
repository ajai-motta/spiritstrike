package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzap extends zzacc implements zzadm {
    private static final zzacl zzd = new zzaj();
    private static final zzap zze;
    private int zzf;
    private long zzn;
    private boolean zzo;
    private boolean zzr;
    private byte zzs = 2;
    private int zzg = 1;
    private String zzh = "";
    private zzacn zzi = zzai();
    private zzacn zzj = zzai();
    private zzacn zzk = zzai();
    private String zzl = "";
    private String zzm = "";
    private zzacn zzp = zzai();
    private zzack zzq = zzah();

    static {
        zzap zzapVar = new zzap();
        zze = zzapVar;
        zzacf.zzao(zzap.class, zzapVar);
    }

    private zzap() {
    }

    static /* synthetic */ void zzA(zzap zzapVar, zzap zzapVar2) {
        zzapVar2.getClass();
        zzacn zzacnVar = zzapVar.zzp;
        if (!zzacnVar.zzc()) {
            zzapVar.zzp = zzacf.zzaj(zzacnVar);
        }
        zzapVar.zzp.add(zzapVar2);
    }

    static /* synthetic */ void zzG(zzap zzapVar, boolean z) {
        zzapVar.zzf |= 32;
        zzapVar.zzo = z;
    }

    static /* synthetic */ void zzH(zzap zzapVar, boolean z) {
        zzapVar.zzf |= 64;
        zzapVar.zzr = z;
    }

    static /* synthetic */ void zzI(zzap zzapVar, String str) {
        str.getClass();
        zzapVar.zzf |= 8;
        zzapVar.zzm = str;
    }

    static /* synthetic */ void zzJ(zzap zzapVar, long j) {
        zzapVar.zzf |= 16;
        zzapVar.zzn = j;
    }

    static /* synthetic */ void zzK(zzap zzapVar, String str) {
        str.getClass();
        zzapVar.zzf |= 4;
        zzapVar.zzl = str;
    }

    static /* synthetic */ void zzL(zzap zzapVar, String str) {
        str.getClass();
        zzapVar.zzf |= 2;
        zzapVar.zzh = str;
    }

    static /* synthetic */ void zzP(zzap zzapVar, int i) {
        zzapVar.zzg = i;
        zzapVar.zzf |= 1;
    }

    private final void zzas() {
        zzacn zzacnVar = this.zzi;
        if (zzacnVar.zzc()) {
            return;
        }
        this.zzi = zzacf.zzaj(zzacnVar);
    }

    private final void zzat() {
        zzacn zzacnVar = this.zzj;
        if (zzacnVar.zzc()) {
            return;
        }
        this.zzj = zzacf.zzaj(zzacnVar);
    }

    private final void zzau() {
        zzacn zzacnVar = this.zzk;
        if (zzacnVar.zzc()) {
            return;
        }
        this.zzk = zzacf.zzaj(zzacnVar);
    }

    public static zzak zzg() {
        return (zzak) zze.zzZ();
    }

    public static zzap zzi() {
        return zze;
    }

    static /* synthetic */ void zzt(zzap zzapVar, Iterable iterable) {
        zzack zzackVar = zzapVar.zzq;
        if (!zzackVar.zzc()) {
            int size = zzackVar.size();
            zzapVar.zzq = zzackVar.zzd(size + size);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzapVar.zzq.zzh(((zzam) it.next()).zza());
        }
    }

    static /* synthetic */ void zzu(zzap zzapVar, Iterable iterable) {
        zzapVar.zzas();
        zzyh.zzS(iterable, zzapVar.zzi);
    }

    static /* synthetic */ void zzv(zzap zzapVar, Iterable iterable) {
        zzapVar.zzat();
        zzyh.zzS(iterable, zzapVar.zzj);
    }

    static /* synthetic */ void zzw(zzap zzapVar, Iterable iterable) {
        zzapVar.zzau();
        zzyh.zzS(iterable, zzapVar.zzk);
    }

    static /* synthetic */ void zzx(zzap zzapVar, zzap zzapVar2) {
        zzapVar2.getClass();
        zzapVar.zzas();
        zzapVar.zzi.add(zzapVar2);
    }

    static /* synthetic */ void zzy(zzap zzapVar, zzap zzapVar2) {
        zzapVar2.getClass();
        zzapVar.zzat();
        zzapVar.zzj.add(zzapVar2);
    }

    static /* synthetic */ void zzz(zzap zzapVar, zzap zzapVar2) {
        zzapVar2.getClass();
        zzapVar.zzau();
        zzapVar.zzk.add(zzapVar2);
    }

    public final boolean zzM() {
        return this.zzo;
    }

    public final boolean zzN() {
        return this.zzr;
    }

    public final int zzO() {
        int iZza = zzao.zza(this.zzg);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zza() {
        return this.zzi.size();
    }

    public final int zzc() {
        return this.zzj.size();
    }

    public final int zzd() {
        return this.zzk.size();
    }

    public final int zze() {
        return this.zzp.size();
    }

    public final long zzf() {
        return this.zzn;
    }

    public final zzap zzj(int i) {
        return (zzap) this.zzi.get(i);
    }

    public final zzap zzk(int i) {
        return (zzap) this.zzj.get(i);
    }

    public final zzap zzl(int i) {
        return (zzap) this.zzk.get(i);
    }

    public final zzap zzm(int i) {
        return (zzap) this.zzp.get(i);
    }

    public final String zzn() {
        return this.zzm;
    }

    public final String zzo() {
        return this.zzl;
    }

    public final String zzp() {
        return this.zzh;
    }

    public final List zzq() {
        return new zzacm(this.zzq, zzd);
    }

    public final List zzr() {
        return this.zzi;
    }

    public final List zzs() {
        return this.zzp;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzs);
        }
        if (i2 == 2) {
            return zzal(zze, "\u0004\f\u0000\u0001\u0001\f\f\u0000\u0005\u0005\u0001ᴌ\u0000\u0002ဈ\u0001\u0003Л\u0004Л\u0005Л\u0006ဈ\u0002\u0007ဈ\u0003\bဂ\u0004\tဇ\u0006\nࠞ\u000bЛ\fဇ\u0005", new Object[]{"zzf", "zzg", zzan.zza, "zzh", "zzi", zzap.class, "zzj", zzap.class, "zzk", zzap.class, "zzl", "zzm", "zzn", "zzr", "zzq", zzal.zza, "zzp", zzap.class, "zzo"});
        }
        if (i2 == 3) {
            return new zzap();
        }
        zzaq zzaqVar = null;
        if (i2 == 4) {
            return new zzak(zzaqVar);
        }
        if (i2 == 5) {
            return zze;
        }
        this.zzs = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
