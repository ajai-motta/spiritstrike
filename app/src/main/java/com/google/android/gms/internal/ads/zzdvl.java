package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdvl implements zzfkt {
    private final zzdvc zzb;
    private final Clock zzc;
    private final Map zza = new HashMap();
    private final Map zzd = new HashMap();

    public zzdvl(zzdvc zzdvcVar, Set set, Clock clock) {
        this.zzb = zzdvcVar;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzdvk zzdvkVar = (zzdvk) it.next();
            this.zzd.put(zzdvkVar.zzc(), zzdvkVar);
        }
        this.zzc = clock;
    }

    private final void zze(zzfkm zzfkmVar, boolean z) {
        zzdvk zzdvkVar = (zzdvk) this.zzd.get(zzfkmVar);
        if (zzdvkVar == null) {
            return;
        }
        String str = true != z ? "f." : "s.";
        Map map = this.zza;
        zzfkm zzfkmVarZzb = zzdvkVar.zzb();
        if (map.containsKey(zzfkmVarZzb)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) map.get(zzfkmVarZzb)).longValue();
            zzdvc zzdvcVar = this.zzb;
            String strZza = zzdvkVar.zza();
            int length = str.length();
            Map mapZzc = zzdvcVar.zzc();
            StringBuilder sb = new StringBuilder(length + String.valueOf(jElapsedRealtime).length());
            sb.append(str);
            sb.append(jElapsedRealtime);
            mapZzc.put("label.".concat(strZza), sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdP(zzfkm zzfkmVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdQ(zzfkm zzfkmVar, String str) {
        this.zza.put(zzfkmVar, Long.valueOf(this.zzc.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdR(zzfkm zzfkmVar, String str, Throwable th) {
        Map map = this.zza;
        if (map.containsKey(zzfkmVar)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) map.get(zzfkmVar)).longValue();
            Map mapZzc = this.zzb.zzc();
            String.valueOf(str);
            String strValueOf = String.valueOf(str);
            String string = Long.toString(jElapsedRealtime);
            String.valueOf(string);
            mapZzc.put("task.".concat(strValueOf), "f.".concat(String.valueOf(string)));
        }
        if (this.zzd.containsKey(zzfkmVar)) {
            zze(zzfkmVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdS(zzfkm zzfkmVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfkmVar)) {
            long jElapsedRealtime = this.zzc.elapsedRealtime() - ((Long) map.get(zzfkmVar)).longValue();
            Map mapZzc = this.zzb.zzc();
            String.valueOf(str);
            String strValueOf = String.valueOf(str);
            String string = Long.toString(jElapsedRealtime);
            String.valueOf(string);
            mapZzc.put("task.".concat(strValueOf), "s.".concat(String.valueOf(string)));
        }
        if (this.zzd.containsKey(zzfkmVar)) {
            zze(zzfkmVar, true);
        }
    }
}
