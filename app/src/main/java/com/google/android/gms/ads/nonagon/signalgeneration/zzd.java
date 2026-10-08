package com.google.android.gms.ads.nonagon.signalgeneration;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzd {
    private SharedPreferences zza;
    private SharedPreferences.Editor zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    zzd(Context context) {
        this.zzc = context;
    }

    private final void zzk() {
        synchronized (this.zzd) {
            if (this.zza != null) {
                return;
            }
            SharedPreferences sharedPreferences = this.zzc.getSharedPreferences("query_info_shared_prefs", 0);
            this.zza = sharedPreferences;
            this.zzb = sharedPreferences.edit();
        }
    }

    public final void zza(String str, String str2) {
        zzk();
        synchronized (this.zzd) {
            this.zzb.putString(str, str2).commit();
        }
    }

    public final String zzb(String str) {
        String string;
        zzk();
        synchronized (this.zzd) {
            string = this.zza.getString(str, null);
            this.zzb.remove(str).commit();
        }
        return string;
    }

    public final boolean zzc(String str) {
        boolean zContains;
        zzk();
        synchronized (this.zzd) {
            zContains = this.zza.contains(str);
        }
        return zContains;
    }

    public final void zzd(String str, int i, String str2, int i2) {
        zzk();
        synchronized (this.zzd) {
            this.zzb.putString("pn", str).putInt("vc", i).putString("dm", str2).putInt("aav", i2).commit();
        }
    }

    public final String zze() {
        String string;
        zzk();
        synchronized (this.zzd) {
            string = this.zza.getString("pn", null);
        }
        return string;
    }

    public final int zzf() {
        int i;
        zzk();
        synchronized (this.zzd) {
            i = this.zza.getInt("vc", -1);
        }
        return i;
    }

    public final String zzg() {
        String string;
        zzk();
        synchronized (this.zzd) {
            string = this.zza.getString("dm", null);
        }
        return string;
    }

    public final int zzh() {
        int i;
        zzk();
        synchronized (this.zzd) {
            i = this.zza.getInt("aav", -1);
        }
        return i;
    }

    public final void zzi() {
        zzk();
        synchronized (this.zzd) {
            this.zzb.clear().commit();
        }
    }

    public final Map zzj() {
        HashMap map;
        zzk();
        synchronized (this.zzd) {
            Map<String, ?> all = this.zza.getAll();
            map = new HashMap();
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if ((entry.getValue() instanceof String) && !Objects.equals(entry.getKey(), "pn") && !Objects.equals(entry.getKey(), "vc") && !Objects.equals(entry.getKey(), "dm") && !Objects.equals(entry.getKey(), "aav")) {
                    map.put(entry.getKey(), (String) entry.getValue());
                }
            }
        }
        return map;
    }
}
