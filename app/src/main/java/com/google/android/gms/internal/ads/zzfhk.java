package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfhk {
    public static void zza(int i, Throwable th, String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 20);
        sb.append("Ad failed to load : ");
        sb.append(i);
        String string = sb.toString();
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh(string);
        com.google.android.gms.ads.internal.util.zze.zzb(str, th);
        if (i == 3) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzh().zzh(th, str);
    }

    public static void zzb(Context context, boolean z) {
        if (z) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("This request is sent from a test device.");
            return;
        }
        com.google.android.gms.ads.internal.client.zzbb.zza();
        String strZzD = com.google.android.gms.ads.internal.util.client.zzf.zzD(context);
        StringBuilder sb = new StringBuilder(String.valueOf(strZzD).length() + 102);
        sb.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        sb.append(strZzD);
        sb.append("\")) to get test ads on this device.");
        String string = sb.toString();
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh(string);
    }
}
