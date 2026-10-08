package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
@Deprecated
public final class zzbfa {
    public static final void zza(zzbez zzbezVar, zzbex zzbexVar) {
        if (zzbexVar.zzb() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzbexVar.zzc())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        zzbezVar.zza(zzbexVar.zzb(), zzbexVar.zzc(), zzbexVar.zza(), zzbexVar.zzd());
    }
}
