package com.google.android.gms.ads.nonagon.signalgeneration;

import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbeu;
import com.google.android.gms.internal.ads.zzbvx;
import com.google.android.gms.internal.ads.zzguf;
import java.util.ArrayList;
import java.util.Objects;
import javax.annotation.Nonnull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzae implements zzguf {
    final /* synthetic */ zzbvx zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzau zzc;

    zzae(zzau zzauVar, zzbvx zzbvxVar, boolean z) {
        this.zza = zzbvxVar;
        this.zzb = z;
        Objects.requireNonNull(zzauVar);
        this.zzc = zzauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        try {
            zzbvx zzbvxVar = this.zza;
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 16);
            sb.append("Internal error: ");
            sb.append(message);
            zzbvxVar.zzf(sb.toString());
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(@Nonnull Object obj) {
        ArrayList<Uri> arrayList = (ArrayList) obj;
        try {
            this.zza.zze(arrayList);
            zzau zzauVar = this.zzc;
            if (zzauVar.zzC() || this.zzb) {
                for (Uri uri : arrayList) {
                    if (zzauVar.zzc(uri)) {
                        zzauVar.zzB().zzb(zzau.zzZ(uri, zzauVar.zzM(), "1").toString(), null, null, null);
                    } else {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzhZ)).booleanValue()) {
                            zzauVar.zzB().zzb(uri.toString(), null, null, null);
                        }
                    }
                }
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("", e);
        }
    }
}
