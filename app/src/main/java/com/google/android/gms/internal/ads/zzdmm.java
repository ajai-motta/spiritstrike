package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdmm implements zzbhv {
    final /* synthetic */ zzdnn zza;
    final /* synthetic */ ViewGroup zzb;

    zzdmm(zzdnn zzdnnVar, ViewGroup viewGroup) {
        this.zza = zzdnnVar;
        this.zzb = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zza() {
        zzgpe zzgpeVar = zzdml.zza;
        zzdnn zzdnnVar = this.zza;
        Map mapZzk = zzdnnVar.zzk();
        if (mapZzk == null) {
            return;
        }
        int size = zzgpeVar.size();
        int i = 0;
        while (i < size) {
            Object obj = mapZzk.get((String) zzgpeVar.get(i));
            i++;
            if (obj != null) {
                zzdnnVar.onClick(this.zzb);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzb(MotionEvent motionEvent) {
        this.zza.onTouch(null, motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final JSONObject zzc() {
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final JSONObject zzd() {
        return this.zza.zzq();
    }
}
