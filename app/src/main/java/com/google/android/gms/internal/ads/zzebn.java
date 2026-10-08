package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzebn extends zzebu {
    private final Context zzg;
    private final Executor zzh;

    public zzebn(Context context, Executor executor) {
        this.zzg = context;
        this.zzh = executor;
        this.zzf = new zzbwm(context, com.google.android.gms.ads.internal.zzt.zzs().zza(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zze(this.zze, ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznX)).booleanValue() ? new zzebt(this.zza, this.zze) : new zzebs(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zzd(new zzecj(1));
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "RemoteAdRequestClientTask.onConnected");
                    this.zza.zzd(new zzecj(1));
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzebu, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzd("Cannot connect to remote service, fallback to local instance.");
        this.zza.zzd(new zzecj(1));
    }

    public final ListenableFuture zza(zzbxj zzbxjVar) {
        synchronized (this.zzb) {
            if (this.zzc) {
                return this.zza;
            }
            this.zzc = true;
            this.zze = zzbxjVar;
            this.zzf.checkAvailabilityAndConnect();
            zzcca zzccaVar = this.zza;
            zzccaVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzebm
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzb();
                }
            }, zzcbv.zzg);
            zzc(this.zzg, zzccaVar, this.zzh);
            return zzccaVar;
        }
    }
}
