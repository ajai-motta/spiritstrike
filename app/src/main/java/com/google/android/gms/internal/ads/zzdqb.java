package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzdqb implements zzbhv {
    final /* synthetic */ String zza = NativeCustomFormatAd.ASSET_NAME_VIDEO;
    final /* synthetic */ zzdqc zzb;

    zzdqb(zzdqc zzdqcVar, String str) {
        Objects.requireNonNull(zzdqcVar);
        this.zzb = zzdqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zza() {
        zzdqc zzdqcVar = this.zzb;
        if (zzdqcVar.zzc() != null) {
            zzdqcVar.zzc().zza(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzb(MotionEvent motionEvent) {
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final JSONObject zzc() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final JSONObject zzd() {
        return null;
    }
}
