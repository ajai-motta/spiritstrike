package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzln;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhr implements zzln, zzlp {
    private final int zzb;
    private zzlq zzd;
    private int zze;
    private zzpc zzf;
    private zzdc zzg;
    private int zzh;
    private zzwk zzi;
    private zzv[] zzj;
    private long zzk;
    private long zzl;
    private boolean zzn;
    private boolean zzo;
    private zzuu zzq;
    private zzlo zzr;
    private final Object zza = new Object();
    private final zzkj zzc = new zzkj();
    private long zzm = Long.MIN_VALUE;
    private zzbf zzp = zzbf.zza;

    public zzhr(int i) {
        this.zzb = i;
    }

    private final void zzac(long j, boolean z, boolean z2) throws zzib {
        this.zzn = false;
        this.zzl = j;
        this.zzm = j;
        if (!z2) {
            z2 = zzP(j) != 0;
        }
        zzA(j, z, z2);
    }

    protected void zzA(long j, boolean z, boolean z2) throws zzib {
        throw null;
    }

    protected void zzB() throws zzib {
    }

    protected void zzC() {
    }

    protected void zzD() {
        throw null;
    }

    protected void zzE() {
    }

    protected void zzF() {
    }

    protected final long zzG() {
        return this.zzl;
    }

    protected final zzkj zzH() {
        zzkj zzkjVar = this.zzc;
        zzkjVar.zza = null;
        zzkjVar.zzb = null;
        return zzkjVar;
    }

    protected final zzbf zzM() {
        return this.zzp;
    }

    protected final zzib zzN(Throwable th, zzv zzvVar, boolean z, int i) {
        int iZzab = 4;
        if (zzvVar != null && !this.zzo) {
            this.zzo = true;
            try {
                iZzab = zzab(zzvVar) & 7;
            } catch (zzib unused) {
            } finally {
                this.zzo = false;
            }
        }
        return zzib.zzb(th, zzS(), this.zze, zzvVar, iZzab, this.zzq, z, i);
    }

    protected final int zzO(zzkj zzkjVar, zzhh zzhhVar, int i) {
        zzwk zzwkVar = this.zzi;
        zzwkVar.getClass();
        int iZzd = zzwkVar.zzd(zzkjVar, zzhhVar, i);
        if (iZzd == -4) {
            if (zzhhVar.zzb()) {
                this.zzm = Long.MIN_VALUE;
                return this.zzn ? -4 : -3;
            }
            long j = zzhhVar.zze + this.zzk;
            zzhhVar.zze = j;
            this.zzm = Math.max(this.zzm, j);
        } else if (iZzd == -5) {
            zzv zzvVar = zzkjVar.zzb;
            zzvVar.getClass();
            long j2 = zzvVar.zzt;
            if (j2 != Long.MAX_VALUE) {
                zzt zztVarZza = zzvVar.zza();
                zztVarZza.zzr(j2 + this.zzk);
                zzkjVar.zzb = zztVarZza.zzM();
                return -5;
            }
        }
        return iZzd;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzR() {
        zzlo zzloVar;
        synchronized (this.zza) {
            zzloVar = this.zzr;
        }
        if (zzloVar != null) {
            zzloVar.zza(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public /* synthetic */ long zzT(long j, long j2) {
        return zzln.CC.$default$zzT(this, j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public /* synthetic */ boolean zzU(long j) {
        return zzln.CC.$default$zzU(this, j);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public /* synthetic */ void zzV(float f, float f2) throws zzib {
        zzln.CC.$default$zzV(this, f, f2);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public /* synthetic */ void zzW() {
        zzln.CC.$default$zzW(this);
    }

    @Override // com.google.android.gms.internal.ads.zzln, com.google.android.gms.internal.ads.zzlp
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final zzlp zzb() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzc(int i, zzpc zzpcVar, zzdc zzdcVar) {
        this.zze = i;
        this.zzf = zzpcVar;
        this.zzg = zzdcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzcY() throws zzib {
        zzgmd.zzh(this.zzh == 1);
        this.zzh = 2;
        zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzcZ(zzv[] zzvVarArr, zzwk zzwkVar, long j, long j2, zzuu zzuuVar) throws zzib {
        zzgmd.zzh(!this.zzn);
        this.zzi = zzwkVar;
        this.zzq = zzuuVar;
        if (this.zzm == Long.MIN_VALUE) {
            this.zzm = j;
        }
        this.zzj = zzvVarArr;
        this.zzk = j2;
        zzz(zzvVarArr, j, j2, zzuuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public zzko zzd() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final zzwk zzda() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final boolean zzdb() {
        return this.zzm == Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final int zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzf(zzlq zzlqVar, zzv[] zzvVarArr, zzwk zzwkVar, long j, boolean z, boolean z2, long j2, long j3, zzuu zzuuVar) throws zzib {
        zzgmd.zzh(this.zzh == 0);
        this.zzd = zzlqVar;
        this.zzq = zzuuVar;
        this.zzh = 1;
        zzy(z, z2);
        zzcZ(zzvVarArr, zzwkVar, j2, j3, zzuuVar);
        zzac(j2, z, true);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final long zzk() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzl() {
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final boolean zzm() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzo(zzbf zzbfVar) {
        if (Objects.equals(this.zzp, zzbfVar)) {
            return;
        }
        this.zzp = zzbfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzp(long j, boolean z) throws zzib {
        zzac(j, false, z);
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzq() {
        zzgmd.zzh(this.zzh == 2);
        this.zzh = 1;
        zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzr() {
        zzgmd.zzh(this.zzh == 1);
        zzkj zzkjVar = this.zzc;
        zzkjVar.zza = null;
        zzkjVar.zzb = null;
        this.zzh = 0;
        this.zzi = null;
        this.zzj = null;
        this.zzn = false;
        zzD();
        this.zzq = null;
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzs() {
        zzgmd.zzh(this.zzh == 0);
        zzkj zzkjVar = this.zzc;
        zzkjVar.zza = null;
        zzkjVar.zzb = null;
        zzE();
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzt() {
        zzgmd.zzh(this.zzh == 0);
        zzF();
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public int zzu() throws zzib {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public final void zzv(zzlo zzloVar) {
        synchronized (this.zza) {
            this.zzr = zzloVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public final void zzw() {
        synchronized (this.zza) {
            this.zzr = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzli
    public void zzx(int i, Object obj) throws zzib {
    }

    protected void zzy(boolean z, boolean z2) throws zzib {
    }

    protected void zzz(zzv[] zzvVarArr, long j, long j2, zzuu zzuuVar) throws zzib {
    }

    protected final zzv[] zzI() {
        zzv[] zzvVarArr = this.zzj;
        zzvVarArr.getClass();
        return zzvVarArr;
    }

    protected final zzlq zzJ() {
        zzlq zzlqVar = this.zzd;
        zzlqVar.getClass();
        return zzlqVar;
    }

    protected final zzpc zzK() {
        zzpc zzpcVar = this.zzf;
        zzpcVar.getClass();
        return zzpcVar;
    }

    protected final zzdc zzL() {
        zzdc zzdcVar = this.zzg;
        zzdcVar.getClass();
        return zzdcVar;
    }

    protected final int zzP(long j) {
        zzwk zzwkVar = this.zzi;
        zzwkVar.getClass();
        return zzwkVar.zze(j - this.zzk);
    }

    protected final boolean zzQ() {
        if (zzdb()) {
            return this.zzn;
        }
        zzwk zzwkVar = this.zzi;
        zzwkVar.getClass();
        return zzwkVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzln
    public final void zzn() throws IOException {
        zzwk zzwkVar = this.zzi;
        zzwkVar.getClass();
        zzwkVar.zzc();
    }
}
