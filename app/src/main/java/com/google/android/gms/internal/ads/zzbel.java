package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzbel {
    private final int zza;
    private final String zzb;
    private final Object zzc;
    private final Object zzd;

    /* synthetic */ zzbel(int i, String str, Object obj, Object obj2, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        com.google.android.gms.ads.internal.client.zzbd.zzb().zza(this);
    }

    public static zzbel zzh(int i, String str, int i2, int i3) {
        return new zzbeh(1, str, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static zzbel zzi(int i, String str, long j, long j2) {
        return new zzbei(1, str, Long.valueOf(j), Long.valueOf(j2));
    }

    public static zzbel zzj(int i, String str, float f, float f2) {
        return new zzbej(1, str, Float.valueOf(f), Float.valueOf(f2));
    }

    public static zzbel zzk(int i, String str) {
        zzbek zzbekVar = new zzbek(1, "gads:sdk_core_constants:experiment_id", null, null);
        com.google.android.gms.ads.internal.client.zzbd.zzb().zzb(zzbekVar);
        return zzbekVar;
    }

    public static zzbel zzl(int i, String str) {
        zzbek zzbekVar = new zzbek(1, "gads:sdk_core_constants_service:experiment_id", null, null);
        com.google.android.gms.ads.internal.client.zzbd.zzb().zzc(zzbekVar);
        return zzbekVar;
    }

    public abstract Object zza(Bundle bundle);

    public abstract void zzb(SharedPreferences.Editor editor, Object obj);

    protected abstract Object zzc(JSONObject jSONObject);

    protected abstract Object zzd(SharedPreferences sharedPreferences);

    public final String zze() {
        return this.zzb;
    }

    public final Object zzf() {
        return com.google.android.gms.ads.internal.client.zzbd.zzc().zzb() ? this.zzd : this.zzc;
    }

    public final Object zzg() {
        return com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(this);
    }

    public final int zzm() {
        return this.zza;
    }
}
