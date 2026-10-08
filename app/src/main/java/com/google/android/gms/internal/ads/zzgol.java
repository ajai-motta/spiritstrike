package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgol extends zzgnx {
    final /* synthetic */ zzgon zza;
    private final Object zzb;
    private int zzc;

    zzgol(zzgon zzgonVar, int i) {
        Objects.requireNonNull(zzgonVar);
        this.zza = zzgonVar;
        this.zzb = zzgonVar.zzo(i);
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i != -1) {
            zzgon zzgonVar = this.zza;
            if (i < zzgonVar.size() && Objects.equals(this.zzb, zzgonVar.zzo(this.zzc))) {
                return;
            }
        }
        this.zzc = this.zza.zzi(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgnx, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgnx, java.util.Map.Entry
    public final Object getValue() {
        zzgon zzgonVar = this.zza;
        Map mapZzc = zzgonVar.zzc();
        if (mapZzc != null) {
            return mapZzc.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzgonVar.zzp(i);
    }

    @Override // com.google.android.gms.internal.ads.zzgnx, java.util.Map.Entry
    public final Object setValue(Object obj) {
        zzgon zzgonVar = this.zza;
        Map mapZzc = zzgonVar.zzc();
        if (mapZzc != null) {
            return mapZzc.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            zzgonVar.put(this.zzb, obj);
            return null;
        }
        Object objZzp = zzgonVar.zzp(i);
        zzgonVar.zzq(this.zzc, obj);
        return objZzp;
    }
}
