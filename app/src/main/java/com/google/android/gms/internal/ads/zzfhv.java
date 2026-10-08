package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfhv implements zzcyr {
    private final HashSet zza = new HashSet();
    private final Context zzb;
    private final zzcbn zzc;

    public zzfhv(Context context, zzcbn zzcbnVar) {
        this.zzb = context;
        this.zzc = zzcbnVar;
    }

    public final synchronized void zzb(HashSet hashSet) {
        HashSet hashSet2 = this.zza;
        hashSet2.clear();
        hashSet2.addAll(hashSet);
    }

    public final Bundle zzc() {
        return this.zzc.zzn(this.zzb, this);
    }

    @Override // com.google.android.gms.internal.ads.zzcyr
    public final synchronized void zzdN(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (zzeVar.zza != 3) {
            this.zzc.zzc(this.zza);
        }
    }
}
