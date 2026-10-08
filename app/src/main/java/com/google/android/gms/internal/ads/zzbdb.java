package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbdb {
    private ScheduledFuture zza = null;
    private final Runnable zzb = new zzbcx(this);
    private final Object zzc = new Object();
    private zzbde zzd;
    private Context zze;
    private zzbdh zzf;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzl, reason: merged with bridge method [inline-methods] */
    public final void zzf() {
        synchronized (this.zzc) {
            if (this.zze != null && this.zzd == null) {
                zzbde zzbdeVarZze = zze(new zzbcz(this), new zzbda(this));
                this.zzd = zzbdeVarZze;
                zzbdeVarZze.checkAvailabilityAndConnect();
            }
        }
    }

    public final void zza(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.zzc) {
            if (this.zze != null) {
                return;
            }
            this.zze = context.getApplicationContext();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeO)).booleanValue()) {
                zzf();
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeN)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzg().zzb(new zzbcy(this));
                }
            }
        }
    }

    public final void zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeP)).booleanValue()) {
            synchronized (this.zzc) {
                zzf();
                ScheduledFuture scheduledFuture = this.zza;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                this.zza = zzcbv.zzd.schedule(this.zzb, ((Long) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzeQ)).longValue(), TimeUnit.MILLISECONDS);
            }
        }
    }

    public final zzbdc zzc(zzbdf zzbdfVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return new zzbdc();
            }
            try {
                if (this.zzd.zzp()) {
                    return this.zzf.zzf(zzbdfVar);
                }
                return this.zzf.zze(zzbdfVar);
            } catch (RemoteException e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to call into cache service.", e);
                return new zzbdc();
            }
        }
    }

    public final long zzd(zzbdf zzbdfVar) {
        synchronized (this.zzc) {
            if (this.zzf == null) {
                return -2L;
            }
            if (this.zzd.zzp()) {
                try {
                    return this.zzf.zzg(zzbdfVar);
                } catch (RemoteException e) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to call into cache service.", e);
                }
            }
            return -2L;
        }
    }

    protected final synchronized zzbde zze(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzbde(this.zze, com.google.android.gms.ads.internal.zzt.zzs().zza(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    final /* synthetic */ void zzg() {
        synchronized (this.zzc) {
            zzbde zzbdeVar = this.zzd;
            if (zzbdeVar == null) {
                return;
            }
            if (zzbdeVar.isConnected() || this.zzd.isConnecting()) {
                this.zzd.disconnect();
            }
            this.zzd = null;
            this.zzf = null;
            Binder.flushPendingCommands();
        }
    }

    final /* synthetic */ Object zzh() {
        return this.zzc;
    }

    final /* synthetic */ zzbde zzi() {
        return this.zzd;
    }

    final /* synthetic */ void zzj(zzbde zzbdeVar) {
        this.zzd = null;
    }

    final /* synthetic */ void zzk(zzbdh zzbdhVar) {
        this.zzf = zzbdhVar;
    }
}
