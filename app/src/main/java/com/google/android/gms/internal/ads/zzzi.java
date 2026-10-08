package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzzi extends Handler implements Runnable {
    final /* synthetic */ zzzn zza;
    private final zzzj zzb;
    private final long zzc;
    private zzzf zzd;
    private IOException zze;
    private int zzf;
    private Thread zzg;
    private boolean zzh;
    private volatile boolean zzi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzzi(zzzn zzznVar, Looper looper, zzzj zzzjVar, zzzf zzzfVar, int i, long j) {
        super(looper);
        Objects.requireNonNull(zzznVar);
        this.zza = zzznVar;
        this.zzb = zzzjVar;
        this.zzd = zzzfVar;
        this.zzc = j;
    }

    private final void zzd() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j = jElapsedRealtime - this.zzc;
        zzzf zzzfVar = this.zzd;
        zzzfVar.getClass();
        zzzfVar.zzC(this.zzb, jElapsedRealtime, j, this.zzf);
        this.zze = null;
        zzzn zzznVar = this.zza;
        zzzi zzziVarZzj = zzznVar.zzj();
        zzziVarZzj.getClass();
        zzznVar.zzi().execute(zzziVarZzj);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.zzi) {
            return;
        }
        if (message.what == 1) {
            zzd();
            return;
        }
        if (message.what == 4) {
            throw ((Error) message.obj);
        }
        zzzn zzznVar = this.zza;
        zzznVar.zzk(null);
        long j = this.zzc;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = jElapsedRealtime - j;
        zzzf zzzfVar = this.zzd;
        zzzfVar.getClass();
        if (this.zzh) {
            zzzfVar.zzA(this.zzb, jElapsedRealtime, j2, false);
            return;
        }
        int i = message.what;
        if (i == 2) {
            try {
                zzzfVar.zzB(this.zzb, jElapsedRealtime, j2);
                return;
            } catch (RuntimeException e) {
                zzdt.zzf("LoadTask", "Unexpected exception handling load completed", e);
                this.zza.zzl(new zzzm(e));
                return;
            }
        }
        if (i != 3) {
            return;
        }
        IOException iOException = (IOException) message.obj;
        this.zze = iOException;
        int i2 = this.zzf + 1;
        this.zzf = i2;
        zzzh zzzhVarZzz = zzzfVar.zzz(this.zzb, jElapsedRealtime, j2, iOException, i2);
        if (zzzhVarZzz.zzb() == 3) {
            zzznVar.zzl(this.zze);
        } else if (zzzhVarZzz.zzb() != 2) {
            if (zzzhVarZzz.zzb() == 1) {
                this.zzf = 1;
            }
            zzb(zzzhVarZzz.zzc() != C.TIME_UNSET ? zzzhVarZzz.zzc() : Math.min((this.zzf - 1) * 1000, 5000));
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        try {
            synchronized (this) {
                z = !this.zzh;
                this.zzg = Thread.currentThread();
            }
            if (z) {
                zzzj zzzjVar = this.zzb;
                String simpleName = zzzjVar.getClass().getSimpleName();
                StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 5);
                sb.append("load:");
                sb.append(simpleName);
                Trace.beginSection(sb.toString());
                try {
                    zzzjVar.zzc();
                    Trace.endSection();
                } catch (Throwable th) {
                    Trace.endSection();
                    throw th;
                }
            }
            synchronized (this) {
                this.zzg = null;
                Thread.interrupted();
            }
            if (this.zzi) {
                return;
            }
            sendEmptyMessage(2);
        } catch (IOException e) {
            if (this.zzi) {
                return;
            }
            obtainMessage(3, e).sendToTarget();
        } catch (Error e2) {
            if (!this.zzi) {
                zzdt.zzf("LoadTask", "Unexpected error loading stream", e2);
                obtainMessage(4, e2).sendToTarget();
            }
            throw e2;
        } catch (Exception e3) {
            if (this.zzi) {
                return;
            }
            zzdt.zzf("LoadTask", "Unexpected exception loading stream", e3);
            obtainMessage(3, new zzzm(e3)).sendToTarget();
        } catch (OutOfMemoryError e4) {
            if (this.zzi) {
                return;
            }
            zzdt.zzf("LoadTask", "OutOfMemory error loading stream", e4);
            obtainMessage(3, new zzzm(e4)).sendToTarget();
        }
    }

    public final void zza(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null && this.zzf > i) {
            throw iOException;
        }
    }

    public final void zzb(long j) {
        zzzn zzznVar = this.zza;
        zzgmd.zzh(zzznVar.zzj() == null);
        zzznVar.zzk(this);
        if (j > 0) {
            sendEmptyMessageDelayed(1, j);
        } else {
            zzd();
        }
    }

    public final void zzc(boolean z) {
        this.zzi = z;
        this.zze = null;
        if (hasMessages(1)) {
            this.zzh = true;
            removeMessages(1);
            if (!z) {
                sendEmptyMessage(2);
            }
        } else {
            synchronized (this) {
                this.zzh = true;
                this.zzb.zzb();
                Thread thread = this.zzg;
                if (thread != null) {
                    thread.interrupt();
                }
            }
        }
        if (z) {
            this.zza.zzk(null);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            zzzf zzzfVar = this.zzd;
            zzzfVar.getClass();
            zzzfVar.zzA(this.zzb, jElapsedRealtime, jElapsedRealtime - this.zzc, true);
            this.zzd = null;
        }
    }
}
