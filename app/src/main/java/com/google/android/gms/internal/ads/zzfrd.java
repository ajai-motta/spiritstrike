package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzfrd extends zzfre {
    protected final HashSet zza;
    protected final JSONObject zzb;
    protected final long zzc;

    public zzfrd(zzfqw zzfqwVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfqwVar);
        this.zza = new HashSet(hashSet);
        this.zzb = jSONObject;
        this.zzc = j;
    }
}
