package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbdn implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbdf zza;
    final /* synthetic */ zzcca zzb;
    final /* synthetic */ zzbdp zzc;

    zzbdn(zzbdp zzbdpVar, zzbdf zzbdfVar, zzcca zzccaVar) {
        this.zza = zzbdfVar;
        this.zzb = zzccaVar;
        Objects.requireNonNull(zzbdpVar);
        this.zzc = zzbdpVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbdp zzbdpVar = this.zzc;
        synchronized (zzbdpVar.zzf()) {
            if (zzbdpVar.zzd()) {
                return;
            }
            zzbdpVar.zze(true);
            final zzbde zzbdeVarZzc = zzbdpVar.zzc();
            if (zzbdeVarZzc == null) {
                return;
            }
            zzgus zzgusVar = zzcbv.zza;
            final zzbdf zzbdfVar = this.zza;
            final zzcca zzccaVar = this.zzb;
            final ListenableFuture listenableFutureZza = zzgusVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbdm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcca zzccaVar2 = zzccaVar;
                    zzbde zzbdeVar = zzbdeVarZzc;
                    zzbdn zzbdnVar = this.zza;
                    try {
                        zzbdh zzbdhVarZzq = zzbdeVar.zzq();
                        boolean zZzp = zzbdeVar.zzp();
                        zzbdf zzbdfVar2 = zzbdfVar;
                        zzbdc zzbdcVarZzf = zZzp ? zzbdhVarZzq.zzf(zzbdfVar2) : zzbdhVarZzq.zze(zzbdfVar2);
                        if (!zzbdcVarZzf.zza()) {
                            zzccaVar2.zzd(new RuntimeException("No entry contents."));
                            zzbdnVar.zzc.zzb();
                            return;
                        }
                        zzbdk zzbdkVar = new zzbdk(zzbdnVar, zzbdcVarZzf.zzb(), 1);
                        int i = zzbdkVar.read();
                        if (i == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        zzbdkVar.unread(i);
                        zzccaVar2.zzc(zzbdr.zza(zzbdkVar, zzbdcVarZzf.zzd(), zzbdcVarZzf.zzg(), zzbdcVarZzf.zzf(), zzbdcVarZzf.zze()));
                    } catch (RemoteException | IOException e) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to obtain a cache service instance.", e);
                        zzccaVar2.zzd(e);
                        zzbdnVar.zzc.zzb();
                    }
                }
            });
            zzccaVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbdl
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i = zzbdn.zzd;
                    if (zzccaVar.isCancelled()) {
                        listenableFutureZza.cancel(true);
                    }
                }
            }, zzcbv.zzg);
        }
    }
}
