package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbij extends NativeAd.Image {
    private final zzbii zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;
    private final int zze;
    private final int zzf;

    public zzbij(zzbii zzbiiVar) {
        double dZzd;
        int iZze;
        IObjectWrapper iObjectWrapperZzb;
        this.zza = zzbiiVar;
        Uri uriZzc = null;
        try {
            iObjectWrapperZzb = zzbiiVar.zzb();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
        }
        Drawable drawable = iObjectWrapperZzb != null ? (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzb) : null;
        this.zzb = drawable;
        try {
            uriZzc = this.zza.zzc();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e2);
        }
        this.zzc = uriZzc;
        try {
            dZzd = this.zza.zzd();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e3);
            dZzd = 1.0d;
        }
        this.zzd = dZzd;
        int iZzf = -1;
        try {
            iZze = this.zza.zze();
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e4);
            iZze = -1;
        }
        this.zze = iZze;
        try {
            iZzf = this.zza.zzf();
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e5);
        }
        this.zzf = iZzf;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final double getScale() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final Uri getUri() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.formats.NativeAd.Image
    public final int zzb() {
        return this.zzf;
    }
}
