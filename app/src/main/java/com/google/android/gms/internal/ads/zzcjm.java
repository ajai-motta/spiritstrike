package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcjm implements zzawv {
    private final Context zza;
    private final zzfxp zzb;

    zzcjm(Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdg)).intValue();
        int i = iIntValue != 1 ? (iIntValue == 2 || iIntValue != 3) ? 3 : 4 : 2;
        zzfyk zzfykVarZze = zzfyl.zze();
        zzfykVarZze.zza(((Float) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdn)).floatValue());
        zzfyl zzfylVar = (zzfyl) zzfykVarZze.zzbu();
        zzfym zzfymVarZze = zzfyn.zze();
        zzfymVarZze.zza(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdo)).booleanValue());
        zzfymVarZze.zzb(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdq)).longValue());
        zzfyn zzfynVar = (zzfyn) zzfymVarZze.zzbu();
        zzfxs zzfxsVarZzs = zzfxt.zzs();
        zzfxsVarZzs.zzi(i);
        zzfxsVarZzs.zzb(versionInfoParcel.afmaVersion);
        zzfxsVarZzs.zza(((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcK)).booleanValue());
        zzfxsVarZzs.zzh(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdd)).intValue() == -1);
        zzfxsVarZzs.zzg(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdf)).intValue());
        zzfxsVarZzs.zze(((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdp)).longValue());
        zzfxsVarZzs.zzd(((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzde)).intValue());
        zzfxsVarZzs.zzc(zzfylVar);
        zzfxsVarZzs.zzf(zzfynVar);
        zzfxp zzfxpVarZza = zzfxp.zza(context, zzcbv.zza, (zzfxt) zzfxsVarZzs.zzbu());
        this.zzb = zzfxpVarZza;
        zzfxpVarZza.zzb();
    }

    public final String zza() {
        int iZzh = this.zzb.zzh() - 1;
        return iZzh != 1 ? iZzh != 2 ? iZzh != 3 ? "uns" : "3.0" : "2.0" : "1.0";
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzd(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        this.zzb.zzg(motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    @Deprecated
    public final void zze(int i, int i2, int i3) {
        com.google.android.gms.ads.internal.client.zzbb.zza();
        Context context = this.zza;
        float fZzC = com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i);
        com.google.android.gms.ads.internal.client.zzbb.zza();
        float fZzC2 = com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i2);
        zzfxp zzfxpVar = this.zzb;
        long j = i3;
        MotionEvent motionEventObtain = MotionEvent.obtain(0L, j, 0, fZzC, fZzC2, 0);
        zzfxpVar.zzg(motionEventObtain);
        motionEventObtain.recycle();
        com.google.android.gms.ads.internal.client.zzbb.zza();
        float fZzC3 = com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i);
        com.google.android.gms.ads.internal.client.zzbb.zza();
        MotionEvent motionEventObtain2 = MotionEvent.obtain(0L, j, 2, fZzC3, com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i2), 0);
        zzfxpVar.zzg(motionEventObtain2);
        motionEventObtain2.recycle();
        com.google.android.gms.ads.internal.client.zzbb.zza();
        float fZzC4 = com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i);
        com.google.android.gms.ads.internal.client.zzbb.zza();
        MotionEvent motionEventObtain3 = MotionEvent.obtain(0L, j, 1, fZzC4, com.google.android.gms.ads.internal.util.client.zzf.zzC(context, i2), 0);
        zzfxpVar.zzg(motionEventObtain3);
        motionEventObtain3.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final String zzf(Context context, String str, View view, Activity activity) {
        return this.zzb.zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final String zzg(Context context, String str, View view) {
        return this.zzb.zze(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzh(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzi(StackTraceElement[] stackTraceElementArr) {
        this.zzb.zzf(Arrays.asList(stackTraceElementArr));
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final String zzj(Context context, View view, Activity activity) {
        return this.zzb.zzd(context, null, view, activity);
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final String zzk(Context context) {
        return this.zzb.zzc(context);
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final String zzl(Context context) {
        return this.zzb.zzc(context);
    }
}
