package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbou;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbqd implements zzbou, zzbqc {
    private final zzbqc zza;
    private final HashSet zzb = new HashSet();

    public zzbqd(zzbqc zzbqcVar) {
        this.zza = zzbqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbou, com.google.android.gms.internal.ads.zzbpf
    public final void zza(String str) {
        this.zza.zza(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbou, com.google.android.gms.internal.ads.zzbpf
    public /* synthetic */ void zzb(String str, JSONObject jSONObject) {
        zzc(str, jSONObject.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbou, com.google.android.gms.internal.ads.zzbpf
    public /* synthetic */ void zzc(String str, String str2) {
        zzbou.CC.$default$zzc(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbou, com.google.android.gms.internal.ads.zzbot
    public /* synthetic */ void zzd(String str, JSONObject jSONObject) {
        zzbou.CC.$default$zzd(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbou, com.google.android.gms.internal.ads.zzbot
    public /* synthetic */ void zze(String str, Map map) {
        zzbou.CC.$default$zze(this, str, map);
    }

    public final void zzf() {
        HashSet<AbstractMap.SimpleEntry> hashSet = this.zzb;
        for (AbstractMap.SimpleEntry simpleEntry : hashSet) {
            String string = ((zzblx) simpleEntry.getValue()).toString();
            String.valueOf(string);
            com.google.android.gms.ads.internal.util.zze.zza("Unregistering eventhandler: ".concat(String.valueOf(string)));
            this.zza.zzn((String) simpleEntry.getKey(), (zzblx) simpleEntry.getValue());
        }
        hashSet.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzbqc
    public final void zzm(String str, zzblx zzblxVar) {
        this.zza.zzm(str, zzblxVar);
        this.zzb.add(new AbstractMap.SimpleEntry(str, zzblxVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbqc
    public final void zzn(String str, zzblx zzblxVar) {
        this.zza.zzn(str, zzblxVar);
        this.zzb.remove(new AbstractMap.SimpleEntry(str, zzblxVar));
    }
}
