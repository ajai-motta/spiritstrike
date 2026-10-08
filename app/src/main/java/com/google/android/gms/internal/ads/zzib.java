package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzib extends zzau {
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final zzv zzf;
    public final int zzg;
    public final zzuu zzh;
    final boolean zzi;

    private zzib(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, null, false);
    }

    public static zzib zza(IOException iOException, int i) {
        return new zzib(0, iOException, i);
    }

    public static zzib zzb(Throwable th, String str, int i, zzv zzvVar, int i2, zzuu zzuuVar, boolean z, int i3) {
        return new zzib(1, th, null, i3, str, i, zzvVar, zzvVar == null ? 4 : i2, zzuuVar, z);
    }

    public static zzib zzc(RuntimeException runtimeException, int i) {
        return new zzib(2, runtimeException, i);
    }

    final zzib zzd(zzuu zzuuVar) {
        String message = getMessage();
        String str = zzep.zza;
        return new zzib(message, getCause(), this.zza, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, zzuuVar, this.zzb, this.zzi);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private zzib(int i, Throwable th, String str, int i2, String str2, int i3, zzv zzvVar, int i4, zzuu zzuuVar, boolean z) {
        String string;
        String str3;
        if (i == 0) {
            string = "Source error";
        } else if (i != 1) {
            string = "Unexpected runtime error";
        } else {
            String strValueOf = String.valueOf(zzvVar);
            String str4 = zzep.zza;
            if (i4 == 0) {
                str3 = "NO";
            } else if (i4 == 1) {
                str3 = "NO_UNSUPPORTED_TYPE";
            } else if (i4 == 2) {
                str3 = "NO_UNSUPPORTED_DRM";
            } else if (i4 == 3) {
                str3 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i4 != 4) {
                    throw new IllegalStateException();
                }
                str3 = "YES";
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 14 + String.valueOf(i3).length() + 9 + String.valueOf(strValueOf).length() + 19 + str3.length());
            sb.append(str2);
            sb.append(" error, index=");
            sb.append(i3);
            sb.append(", format=");
            sb.append(strValueOf);
            sb.append(", format_supported=");
            sb.append(str3);
            string = sb.toString();
        }
        this(TextUtils.isEmpty(null) ? string : string.concat(": null"), th, i2, i, str2, i3, zzvVar, i4, zzuuVar, SystemClock.elapsedRealtime(), z);
    }

    private zzib(String str, Throwable th, int i, int i2, String str2, int i3, zzv zzvVar, int i4, zzuu zzuuVar, long j, boolean z) {
        int i5;
        boolean z2;
        super(str, th, i, Bundle.EMPTY, j);
        if (z) {
            i5 = i2;
            if (i5 == 1) {
                i5 = 1;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            i5 = i2;
            z2 = true;
        }
        zzgmd.zza(z2);
        zzgmd.zza(th != null);
        this.zzc = i5;
        this.zzd = str2;
        this.zze = i3;
        this.zzf = zzvVar;
        this.zzg = i4;
        this.zzh = zzuuVar;
        this.zzi = z;
    }
}
