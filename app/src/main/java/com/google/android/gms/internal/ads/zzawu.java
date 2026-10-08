package com.google.android.gms.internal.ads;

import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzawu {
    protected volatile Boolean zzb;
    private final zzayd zzc;
    private static final ConditionVariable zzd = new ConditionVariable();
    protected static volatile zzfto zza = null;
    private static volatile Random zze = null;

    public zzawu(zzayd zzaydVar) {
        this.zzc = zzaydVar;
        zzaydVar.zzd().execute(new zzawt(this));
    }

    public static final int zzd() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (RuntimeException unused) {
            if (zze == null) {
                synchronized (zzawu.class) {
                    if (zze == null) {
                        zze = new Random();
                    }
                }
            }
            return zze.nextInt();
        }
    }

    public final void zza(int i, int i2, long j, String str, Exception exc) {
        try {
            zzd.block();
            if (!this.zzb.booleanValue() || zza == null) {
                return;
            }
            zzati zzatiVarZza = zzatm.zza();
            zzatiVarZza.zza(this.zzc.zza.getPackageName());
            zzatiVarZza.zzb(j);
            if (str != null) {
                zzatiVarZza.zze(str);
            }
            if (exc != null) {
                StringWriter stringWriter = new StringWriter();
                exc.printStackTrace(new PrintWriter(stringWriter));
                zzatiVarZza.zzc(stringWriter.toString());
                zzatiVarZza.zzd(exc.getClass().getName());
            }
            zzftn zzftnVarZza = zza.zza(((zzatm) zzatiVarZza.zzbu()).zzaN());
            zzftnVarZza.zzc(i);
            if (i2 != -1) {
                zzftnVarZza.zzb(i2);
            }
            zzftnVarZza.zza();
        } catch (Exception unused) {
        }
    }

    final /* synthetic */ zzayd zzb() {
        return this.zzc;
    }
}
