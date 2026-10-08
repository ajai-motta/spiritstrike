package com.google.android.gms.internal.play_billing;

import io.ktor.sse.ServerSentEventKt;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbi {
    private final zzbl zza;
    private boolean zzb;
    private long zzc;
    private long zzd;

    zzbi() {
        this.zza = zzbl.zzb();
    }

    public static zzbi zzb(zzbl zzblVar) {
        zzbi zzbiVar = new zzbi(zzblVar);
        zzbiVar.zze();
        return zzbiVar;
    }

    public static zzbi zzc(zzbl zzblVar) {
        return new zzbi(zzblVar);
    }

    private final long zzh() {
        return this.zzb ? (this.zza.zza() - this.zzd) + this.zzc : this.zzc;
    }

    public final String toString() {
        String str;
        long jZzh = zzh();
        TimeUnit timeUnit = TimeUnit.DAYS.convert(jZzh, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.DAYS : TimeUnit.HOURS.convert(jZzh, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.HOURS : TimeUnit.MINUTES.convert(jZzh, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MINUTES : TimeUnit.SECONDS.convert(jZzh, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.SECONDS : TimeUnit.MILLISECONDS.convert(jZzh, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MILLISECONDS : TimeUnit.MICROSECONDS.convert(jZzh, TimeUnit.NANOSECONDS) > 0 ? TimeUnit.MICROSECONDS : TimeUnit.NANOSECONDS;
        String str2 = String.format(Locale.ROOT, "%.4g", Double.valueOf(jZzh / TimeUnit.NANOSECONDS.convert(1L, timeUnit)));
        switch (zzbh.zza[timeUnit.ordinal()]) {
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
        return timeUnit.convert(zzh(), TimeUnit.NANOSECONDS);
    }

    public final zzbi zzd() {
        this.zzc = 0L;
        this.zzb = false;
        return this;
    }

    public final zzbi zze() {
        zzbg.zze(!this.zzb, "This stopwatch is already running.");
        this.zzb = true;
        this.zzd = this.zza.zza();
        return this;
    }

    public final zzbi zzf() {
        long jZza = this.zza.zza();
        zzbg.zze(this.zzb, "This stopwatch is already stopped.");
        this.zzb = false;
        this.zzc += jZza - this.zzd;
        return this;
    }

    public final boolean zzg() {
        return this.zzb;
    }

    zzbi(zzbl zzblVar) {
        zzbg.zzc(zzblVar, "ticker");
        this.zza = zzblVar;
    }
}
