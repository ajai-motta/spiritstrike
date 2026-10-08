package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdhw extends zzcto {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdfz zze;
    private final zzdjl zzf;
    private final zzcuj zzg;
    private final zzfsc zzh;
    private final zzczb zzi;
    private final zzcbn zzj;
    private final zzdvi zzk;
    private boolean zzl;

    zzdhw(zzctn zzctnVar, Context context, @Nullable zzcgy zzcgyVar, zzdfz zzdfzVar, zzdjl zzdjlVar, zzcuj zzcujVar, zzfsc zzfscVar, zzczb zzczbVar, zzcbn zzcbnVar, zzdvi zzdviVar) {
        super(zzctnVar);
        this.zzl = false;
        this.zzc = context;
        this.zzd = new WeakReference(zzcgyVar);
        this.zze = zzdfzVar;
        this.zzf = zzdjlVar;
        this.zzg = zzcujVar;
        this.zzh = zzfscVar;
        this.zzi = zzczbVar;
        this.zzj = zzcbnVar;
        this.zzk = zzdviVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcgy zzcgyVar = (zzcgy) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhk)).booleanValue()) {
                if (!this.zzl && zzcgyVar != null) {
                    zzgus zzgusVar = zzcbv.zzf;
                    Objects.requireNonNull(zzcgyVar);
                    zzgusVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdhv
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzcgyVar.destroy();
                        }
                    });
                }
            } else if (zzcgyVar != null) {
                zzcgyVar.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zza(boolean r7, @javax.annotation.Nullable android.app.Activity r8) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdhw.zza(boolean, android.app.Activity):boolean");
    }

    public final boolean zzb() {
        return this.zzg.zzl();
    }
}
