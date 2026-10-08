package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.facebook.ads.AdError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.unity3d.services.core.di.ServiceProvider;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfsa implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzfsu zza;
    private final String zzb;
    private final String zzc;
    private final zzbaa zzd;
    private final LinkedBlockingQueue zze;
    private final HandlerThread zzf;
    private final zzfrs zzg;
    private final long zzh;

    public zzfsa(Context context, int i, zzbaa zzbaaVar, String str, String str2, String str3, zzfrs zzfrsVar) {
        this.zzb = str;
        this.zzd = zzbaaVar;
        this.zzc = str2;
        this.zzg = zzfrsVar;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zzf = handlerThread;
        handlerThread.start();
        this.zzh = System.currentTimeMillis();
        zzfsu zzfsuVar = new zzfsu(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzfsuVar;
        this.zze = new LinkedBlockingQueue();
        zzfsuVar.checkAvailabilityAndConnect();
    }

    private final void zzd(int i, long j, Exception exc) {
        zzfrs zzfrsVar = this.zzg;
        if (zzfrsVar != null) {
            zzfrsVar.zzc(i, System.currentTimeMillis() - j, exc);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzfsz zzfszVarZzc = zzc();
        if (zzfszVarZzc != null) {
            try {
                zzftg zzftgVarZzg = zzfszVarZzc.zzg(new zzfte(1, this.zzd, this.zzb, this.zzc));
                zzd(5011, this.zzh, null);
                this.zze.put(zzftgVarZzg);
            } finally {
                try {
                } finally {
                }
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzd(4012, this.zzh, null);
            this.zze.put(new zzftg(null, 1));
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        try {
            zzd(4011, this.zzh, null);
            this.zze.put(new zzftg(null, 1));
        } catch (InterruptedException unused) {
        }
    }

    public final zzftg zza(int i) {
        zzftg zzftgVar;
        try {
            zzftgVar = (zzftg) this.zze.poll(ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzd(AdError.INTERSTITIAL_AD_TIMEOUT, this.zzh, e);
            zzftgVar = null;
        }
        zzd(3004, this.zzh, null);
        if (zzftgVar != null) {
            if (zzftgVar.zzc == 7) {
                zzfrs.zzg(3);
            } else {
                zzfrs.zzg(2);
            }
        }
        return zzftgVar == null ? new zzftg(null, 1) : zzftgVar;
    }

    public final void zzb() {
        zzfsu zzfsuVar = this.zza;
        if (zzfsuVar != null) {
            if (zzfsuVar.isConnected() || zzfsuVar.isConnecting()) {
                zzfsuVar.disconnect();
            }
        }
    }

    protected final zzfsz zzc() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
