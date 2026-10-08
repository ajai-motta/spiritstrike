package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcal {
    private final Map zza = new HashMap();
    private final List zzb = new ArrayList();
    private final Context zzc;
    private final zzbzy zzd;

    zzcal(Context context, zzbzy zzbzyVar) {
        this.zzc = context;
        this.zzd = zzbzyVar;
    }

    final synchronized void zza(zzcaj zzcajVar) {
        this.zzb.add(zzcajVar);
    }

    final synchronized void zzb(String str) {
        Map map = this.zza;
        if (map.containsKey(str)) {
            return;
        }
        SharedPreferences defaultSharedPreferences = Objects.equals(str, "__default__") ? PreferenceManager.getDefaultSharedPreferences(this.zzc) : this.zzc.getSharedPreferences(str, 0);
        zzcai zzcaiVar = new zzcai(this, str);
        map.put(str, zzcaiVar);
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(zzcaiVar);
    }

    final /* synthetic */ void zzc(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            this.zzd.zzb();
        }
    }

    final /* synthetic */ List zzd() {
        return this.zzb;
    }
}
