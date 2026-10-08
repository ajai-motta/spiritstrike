package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzcai implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzcal zza;
    private final String zzb;

    public zzcai(zzcal zzcalVar, String str) {
        Objects.requireNonNull(zzcalVar);
        this.zza = zzcalVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        zzcal zzcalVar = this.zza;
        synchronized (zzcalVar) {
            Iterator it = zzcalVar.zzd().iterator();
            while (it.hasNext()) {
                ((zzcaj) it.next()).zza(sharedPreferences, this.zzb, str);
            }
        }
    }
}
