package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaal extends HandlerThread implements Handler.Callback {
    private zzdi zza;
    private Handler zzb;
    private Error zzc;
    private RuntimeException zzd;
    private zzaam zze;

    public zzaal() {
        super("ExoPlayer:PlaceholderSurface");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i == 1) {
                try {
                    try {
                        int i2 = message.arg1;
                        zzdi zzdiVar = this.zza;
                        zzdiVar.getClass();
                        zzdiVar.zza(i2);
                        this.zze = new zzaam(this, this.zza.zzc(), i2 != 0, null);
                        synchronized (this) {
                            notify();
                        }
                    } catch (Error e) {
                        zzdt.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                        this.zzc = e;
                        synchronized (this) {
                            notify();
                        }
                    } catch (RuntimeException e2) {
                        zzdt.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                        this.zzd = e2;
                        synchronized (this) {
                            notify();
                        }
                    }
                } catch (zzdj e3) {
                    zzdt.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.zzd = new IllegalStateException(e3);
                    synchronized (this) {
                        notify();
                    }
                }
            } else if (i == 2) {
                try {
                    zzdi zzdiVar2 = this.zza;
                    zzdiVar2.getClass();
                    zzdiVar2.zzb();
                } finally {
                    try {
                    } finally {
                    }
                }
                return true;
            }
            return true;
        } catch (Throwable th) {
            synchronized (this) {
                notify();
                throw th;
            }
        }
    }

    public final zzaam zza(int i) {
        boolean z;
        start();
        this.zzb = new Handler(getLooper(), this);
        this.zza = new zzdi(this.zzb, null);
        synchronized (this) {
            z = false;
            this.zzb.obtainMessage(1, i, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.zzc;
        if (error != null) {
            throw error;
        }
        zzaam zzaamVar = this.zze;
        zzaamVar.getClass();
        return zzaamVar;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        handler.getClass();
        handler.sendEmptyMessage(2);
    }
}
