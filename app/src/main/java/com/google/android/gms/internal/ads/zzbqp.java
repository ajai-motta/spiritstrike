package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public final class zzbqp {
    static final com.google.android.gms.ads.internal.util.zzbc zza = new zzbqn();
    static final com.google.android.gms.ads.internal.util.zzbc zzb = new zzbqo();
    private final zzbqb zzc;

    public zzbqp(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable zzflp zzflpVar) {
        this.zzc = new zzbqb(context, versionInfoParcel, str, zza, zzb, zzflpVar);
    }

    public final zzbqf zza(String str, zzbqi zzbqiVar, zzbqh zzbqhVar) {
        return new zzbqt(this.zzc, str, zzbqiVar, zzbqhVar);
    }

    public final zzbqy zzb() {
        return new zzbqy(this.zzc);
    }
}
