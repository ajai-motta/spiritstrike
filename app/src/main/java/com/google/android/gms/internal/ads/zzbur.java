package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbur extends NativeAd.Image {
    private final zzbii zzb;
    private final Drawable zzc;
    private final Uri zzd;
    private final double zze;
    private final int zzf;
    private final int zzg;

    public zzbur(zzbii zzbiiVar) {
        Uri uriZzc;
        double dZzd;
        int iZze;
        IObjectWrapper iObjectWrapperZzb;
        this.zzb = zzbiiVar;
        Map mapZzg = null;
        try {
            iObjectWrapperZzb = zzbiiVar.zzb();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
        }
        Drawable drawable = iObjectWrapperZzb != null ? (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzb) : null;
        this.zzc = drawable;
        try {
            uriZzc = this.zzb.zzc();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e2);
            uriZzc = null;
        }
        this.zzd = uriZzc;
        try {
            dZzd = this.zzb.zzd();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e3);
            dZzd = 1.0d;
        }
        this.zze = dZzd;
        int iZzf = -1;
        try {
            iZze = this.zzb.zze();
        } catch (RemoteException e4) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e4);
            iZze = -1;
        }
        this.zzf = iZze;
        try {
            iZzf = this.zzb.zzf();
        } catch (RemoteException e5) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e5);
        }
        this.zzg = iZzf;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzex)).booleanValue()) {
            try {
                mapZzg = this.zzb.zzg();
            } catch (RemoteException unused) {
            }
        }
        this.zza = mapZzg;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Drawable getDrawable() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final double getScale() {
        return this.zze;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final Uri getUri() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final int zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.Image
    public final int zzb() {
        return this.zzg;
    }
}
