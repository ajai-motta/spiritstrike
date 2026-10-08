package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaaq implements zzabx {
    final /* synthetic */ zzaaw zza;
    private zzgpe zzb;
    private zzv zzc;
    private long zzd;
    private long zze;
    private int zzf;

    public zzaaq(zzaaw zzaawVar, Context context, int i) {
        Objects.requireNonNull(zzaawVar);
        this.zza = zzaawVar;
        zzep.zzS(context);
        this.zzb = zzgpe.zzi();
        this.zze = C.TIME_UNSET;
        zzabu zzabuVar = zzabu.zzb;
    }

    private static final void zzy(zzv zzvVar) {
        zzt zztVarZza = zzvVar.zza();
        zztVarZza.zzC(zzaaw.zzC(zzvVar.zzE));
        zztVarZza.zzM();
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zza() {
        zzaaw zzaawVar = this.zza;
        if (zzaawVar.zzt()) {
            zzaawVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzb() {
        zzaaw zzaawVar = this.zza;
        if (zzaawVar.zzt()) {
            zzaawVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzc(zzabu zzabuVar, Executor executor) {
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzd(zzv zzvVar) throws zzabw {
        return this.zza.zzi(zzvVar, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zze() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzg(boolean z) {
        this.zze = C.TIME_UNSET;
        this.zza.zzm(z);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzh(boolean z) {
        return this.zza.zzj(false);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzi() {
        zzaaw zzaawVar = this.zza;
        zzaawVar.zzA(this.zze);
        if (zzaawVar.zzy() >= zzaawVar.zzz()) {
            zzaawVar.zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzj() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final Surface zzk() {
        zzgmd.zzh(false);
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzl(zzaax zzaaxVar) {
        this.zza.zzp(zzaaxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzm(float f) {
        this.zza.zzq(f);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzn(List list) {
        if (this.zzb.equals(list)) {
            return;
        }
        this.zzb = zzgpe.zzq(list);
        zzv zzvVar = this.zzc;
        if (zzvVar != null) {
            zzy(zzvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzo(long j) {
        this.zzd = j;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzp(Surface surface, zzeh zzehVar) {
        this.zza.zzc(surface, zzehVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzq() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzr(int i) {
        this.zza.zzr(i);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzs(int i, zzv zzvVar, long j, int i2, List list) {
        zzgmd.zzh(false);
        this.zzb = zzgpe.zzq(list);
        this.zzc = zzvVar;
        zzaaw zzaawVar = this.zza;
        zzaawVar.zzA(C.TIME_UNSET);
        zzy(zzvVar);
        long j2 = this.zze;
        long j3 = -4611686018427387904L;
        if (zzaawVar.zzt()) {
            if (j2 != C.TIME_UNSET) {
                j3 = j2 + 1;
            }
        } else if (j2 != C.TIME_UNSET) {
            return;
        }
        zzaawVar.zzw().zza(j3, new zzaav(j + this.zzd, i2, j3));
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzt() {
        zzaaw zzaawVar = this.zza;
        if (zzaawVar.zzw().zzc() == 0) {
            zzaawVar.zzo();
            return;
        }
        zzel zzelVar = new zzel(10);
        boolean z = true;
        while (zzaawVar.zzw().zzc() > 0) {
            zzaav zzaavVar = (zzaav) zzaawVar.zzw().zzd();
            zzaavVar.getClass();
            if (z) {
                int i = zzaavVar.zzb;
                if (i == 0 || i == 1) {
                    zzaavVar = new zzaav(zzaavVar.zza, 0, zzaavVar.zzc);
                } else {
                    zzaawVar.zzo();
                }
            }
            zzelVar.zza(zzaavVar.zzc, zzaavVar);
            z = false;
        }
        zzaawVar.zzx(zzelVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final boolean zzu(long j, zzabv zzabvVar) {
        int i;
        zzgmd.zzh(false);
        long j2 = j + this.zzd;
        zzaaw zzaawVar = this.zza;
        long jZzb = zzaawVar.zzv().zzb(j2);
        if (jZzb == C.TIME_UNSET || zzaawVar.zzu() == C.TIME_UNSET || jZzb >= zzaawVar.zzu() || (i = this.zzf) >= 2) {
            if (zzaawVar.zzs()) {
                throw null;
            }
            return false;
        }
        this.zzf = i + 1;
        zzabvVar.zzb();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzv(long j, long j2) throws zzabw {
        this.zza.zzl(j + this.zzd, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzw(boolean z) {
        zzaaw zzaawVar = this.zza;
        if (zzaawVar.zzt()) {
            zzaawVar.zzn(z);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzabx
    public final void zzx() {
        this.zza.zzg();
    }
}
