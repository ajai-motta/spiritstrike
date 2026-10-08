package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public final class zzbqg {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzbqp zzc;
    private zzbqp zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    private static final boolean zzd(Context context) {
        if (((Boolean) zzbhe.zzc.zze()).booleanValue()) {
            return Arrays.asList(((String) zzbhe.zzd.zze()).split(",")).contains(com.google.android.gms.ads.internal.util.zzs.zzm(zzc(context)).zza().toLowerCase(Locale.ROOT));
        }
        return false;
    }

    public final zzbqp zza(Context context, VersionInfoParcel versionInfoParcel, zzflp zzflpVar) {
        zzbqp zzbqpVar;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzbqp(zzc(context), versionInfoParcel, zzd(context) ? (String) zzbhe.zzb.zze() : (String) zzbhe.zzf.zze(), zzflpVar);
            }
            zzbqpVar = this.zzd;
        }
        return zzbqpVar;
    }

    public final zzbqp zzb(Context context, VersionInfoParcel versionInfoParcel, zzflp zzflpVar) {
        zzbqp zzbqpVar;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzbqp(zzc(context), versionInfoParcel, zzd(context) ? ((Boolean) zzbha.zzg.zze()).booleanValue() ? (String) zzbhe.zza.zze() : (String) zzbhe.zze.zze() : ((Boolean) zzbha.zzf.zze()).booleanValue() ? (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zza) : (String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzb), zzflpVar);
            }
            zzbqpVar = this.zzc;
        }
        return zzbqpVar;
    }
}
