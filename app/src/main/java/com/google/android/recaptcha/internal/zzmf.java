package com.google.android.recaptcha.internal;

import io.ktor.sse.ServerSentEventKt;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmf {
    private boolean zza;
    private long zzb;
    private long zzc;

    zzmf() {
        int i = zzmi.zzb;
    }

    public static zzmf zzb() {
        zzmf zzmfVar = new zzmf();
        zzmfVar.zze();
        return zzmfVar;
    }

    public static zzmf zzc() {
        return new zzmf();
    }

    private final long zzg() {
        return this.zza ? (System.nanoTime() - this.zzc) + this.zzb : this.zzb;
    }

    public final String toString() {
        String str;
        long jZzg = zzg();
        TimeUnit timeUnit = TimeUnit.DAYS.convert(jZzg, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.DAYS : TimeUnit.HOURS.convert(jZzg, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.HOURS : TimeUnit.MINUTES.convert(jZzg, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MINUTES : TimeUnit.SECONDS.convert(jZzg, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.SECONDS : TimeUnit.MILLISECONDS.convert(jZzg, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MILLISECONDS : TimeUnit.MICROSECONDS.convert(jZzg, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MICROSECONDS : TimeUnit.NANOSECONDS;
        String str2 = String.format(Locale.ROOT, "%.4g", Double.valueOf(jZzg / TimeUnit.NANOSECONDS.convert(1L, timeUnit)));
        switch (zzme.zza[timeUnit.ordinal()]) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "μs";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "min";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                throw new AssertionError();
        }
        return str2 + ServerSentEventKt.SPACE + str;
    }

    public final long zza(TimeUnit timeUnit) {
        return timeUnit.convert(zzg(), TimeUnit.NANOSECONDS);
    }

    public final zzmf zzd() {
        this.zzb = 0L;
        this.zza = false;
        return this;
    }

    public final zzmf zze() {
        zzmd.zze(!this.zza, "This stopwatch is already running.");
        this.zza = true;
        this.zzc = System.nanoTime();
        return this;
    }

    public final zzmf zzf() {
        long jNanoTime = System.nanoTime();
        zzmd.zze(this.zza, "This stopwatch is already stopped.");
        this.zza = false;
        this.zzb += jNanoTime - this.zzc;
        return this;
    }
}
