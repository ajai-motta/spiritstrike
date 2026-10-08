package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzys {
    public final int zza;
    public final zzlq[] zzb;
    public final zzyk[] zzc;
    public final zzbn zzd;
    public final Object zze;

    public zzys(zzlq[] zzlqVarArr, zzyk[] zzykVarArr, zzbn zzbnVar, Object obj) {
        int length = zzlqVarArr.length;
        zzgmd.zza(length == zzykVarArr.length);
        this.zzb = zzlqVarArr;
        this.zzc = (zzyk[]) zzykVarArr.clone();
        this.zzd = zzbnVar;
        this.zze = obj;
        this.zza = length;
    }

    public final boolean zza(int i) {
        return this.zzb[i] != null;
    }

    public final boolean zzb(zzys zzysVar, int i) {
        return zzysVar != null && Objects.equals(this.zzb[i], zzysVar.zzb[i]) && Objects.equals(this.zzc[i], zzysVar.zzc[i]);
    }
}
