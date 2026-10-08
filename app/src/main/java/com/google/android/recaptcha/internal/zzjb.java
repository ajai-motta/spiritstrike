package com.google.android.recaptcha.internal;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjb {
    private final zzja zza;
    private final HashMap zzb;
    private final zzis zzc;
    private final zzdo zzd;

    public zzjb(zzis zzisVar, zzdo zzdoVar, zzct zzctVar) {
        this.zzc = zzisVar;
        this.zzd = zzdoVar;
        zzja zzjaVar = new zzja();
        this.zza = zzjaVar;
        HashMap map = new HashMap();
        this.zzb = map;
        zzjaVar.zzd(TTAdConstant.IMAGE_MODE_VERTICAL_IMG_173, map);
    }

    public final zzja zza() {
        return this.zza;
    }

    public final void zzb() {
        zzja zzjaVar = this.zza;
        zzjaVar.zzc();
        zzjaVar.zzd(TTAdConstant.IMAGE_MODE_VERTICAL_IMG_173, this.zzb);
    }

    public final zzdo zzc() {
        return this.zzd;
    }

    public final zzis zzd() {
        return this.zzc;
    }

    public final void zze(int i, Object obj) {
        this.zzb.put(Integer.valueOf(i - 2), obj);
    }
}
