package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzazk extends zzazr {
    public zzazk(zzayd zzaydVar, String str, String str2, zzauc zzaucVar, int i, int i2) {
        super(zzaydVar, "cOth2BAAthu6X8KDmzC58653OwqftcurhEiV9l+3uxMh7KBnOgbdhGM0zSnSPufi", "2EDSTVCwfkpT+1duJ+umEyNIZ3jEP0NWyK78oeLPLhI=", zzaucVar, i, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        zzauc zzaucVar = this.zzd;
        synchronized (zzaucVar) {
            zzaxy zzaxyVar = new zzaxy((String) this.zze.invoke(null, new Object[0]));
            zzaucVar.zzF(zzaxyVar.zza.longValue());
            zzaucVar.zzG(zzaxyVar.zzb.longValue());
        }
    }
}
