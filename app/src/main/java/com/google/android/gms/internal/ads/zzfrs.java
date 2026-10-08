package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzfrs {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzf = 1;
    private final Context zzb;
    private final Executor zzc;
    private final Task zzd;
    private final boolean zze;

    public zzfrs(Context context, Executor executor, Task task, boolean z) {
        this.zzb = context;
        this.zzc = executor;
        this.zzd = task;
        this.zze = z;
    }

    public static zzfrs zza(final Context context, Executor executor, boolean z) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        if (z) {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfro
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i = zzfrs.zza;
                    taskCompletionSource.setResult(zzfto.zzb(context, "GLAS", null));
                }
            });
        } else {
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfrq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i = zzfrs.zza;
                    taskCompletionSource.setResult(zzfto.zzc());
                }
            });
        }
        return new zzfrs(context, executor, taskCompletionSource.getTask(), z);
    }

    static void zzg(int i) {
        zzf = i;
    }

    private final Task zzh(final int i, long j, Exception exc, String str, Map map, String str2) {
        if (!this.zze) {
            return this.zzd.continueWith(this.zzc, zzfrr.zza);
        }
        Context context = this.zzb;
        final zzati zzatiVarZza = zzatm.zza();
        zzatiVarZza.zza(context.getPackageName());
        zzatiVarZza.zzb(j);
        zzatiVarZza.zzg(zzf);
        if (exc != null) {
            int i2 = zzgna.zza;
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            zzatiVarZza.zzc(stringWriter.toString());
            zzatiVarZza.zzd(exc.getClass().getName());
        }
        if (str2 != null) {
            zzatiVarZza.zze(str2);
        }
        if (str != null) {
            zzatiVarZza.zzf(str);
        }
        return this.zzd.continueWith(this.zzc, new Continuation() { // from class: com.google.android.gms.internal.ads.zzfrp
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                int i3 = zzfrs.zza;
                if (!task.isSuccessful()) {
                    return false;
                }
                int i4 = i;
                zzftn zzftnVarZza = ((zzfto) task.getResult()).zza(((zzatm) zzatiVarZza.zzbu()).zzaN());
                zzftnVarZza.zzc(i4);
                zzftnVarZza.zza();
                return true;
            }
        });
    }

    public Task zzb(int i, long j) {
        return zzh(i, j, null, null, null, null);
    }

    public Task zzc(int i, long j, Exception exc) {
        return zzh(i, j, exc, null, null, null);
    }

    public final Task zzd(int i, long j, String str, Map map) {
        return zzh(i, j, null, str, null, null);
    }

    public Task zze(int i, String str) {
        return zzh(i, 0L, null, null, null, str);
    }

    public final Task zzf(int i, long j, String str) {
        return zzh(i, j, null, null, null, str);
    }
}
