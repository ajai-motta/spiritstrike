package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.os.Build;
import android.os.Process;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzqt {
    private static Boolean zza;
    private final zzlk zzb;
    private final Uri zzc;
    private final String zzd;
    private final String zze = "";

    public zzqt(zzlk zzlkVar, String str, String str2, boolean z) {
        this.zzb = zzlkVar;
        this.zzd = str;
        zzrz zzrzVarZza = zzsa.zza(zzlkVar.zzc());
        zzrzVarZza.zzb("phenotype");
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4);
        sb.append(DomExceptionUtils.SEPARATOR);
        sb.append(str);
        sb.append(".pb");
        zzrzVarZza.zzc(sb.toString());
        this.zzc = zzrzVarZza.zzd();
    }

    private static boolean zzf() {
        if (zza == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                zza = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Boolean bool = (Boolean) Preconditions.checkNotNull(Process.class.getMethod("isIsolated", new Class[0]).invoke(Process.class, new Object[0]));
                    bool.booleanValue();
                    zza = bool;
                } catch (ReflectiveOperationException unused) {
                    zza = false;
                }
            }
        }
        return zza.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final com.google.android.gms.internal.measurement.zzqs zza() {
        /*
            Method dump skipped, instruction units count: 618
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzqt.zza():com.google.android.gms.internal.measurement.zzqs");
    }

    final boolean zzb() {
        return this.zzb.zzd().zzb(false, zzabz.FILE);
    }

    public final ListenableFuture zzc(final zzqv zzqvVar) {
        return Futures.submit(new Callable() { // from class: com.google.android.gms.internal.measurement.zzqq
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                this.zza.zze(zzqvVar);
                return null;
            }
        }, this.zzb.zzg());
    }

    final ListenableFuture zzd(String str) {
        zzlk zzlkVar = this.zzb;
        return Futures.transform(zzlkVar.zzh().zza(this.zzd, ""), zzqp.zza, zzlkVar.zzg());
    }

    final /* synthetic */ Void zze(zzqv zzqvVar) {
        zzse zzseVar = new zzse();
        try {
            zzru zzruVarZzi = this.zzb.zzi();
            Uri uri = this.zzc;
            zzsv zzsvVarZzb = zzsv.zzb(zzqvVar);
            zzsvVarZzb.zzc(zzseVar);
            return null;
        } catch (IOException | RuntimeException e) {
            zzlz.zzb(Level.WARNING, this.zzb.zzg(), e, "Failed to update snapshot for %s flags may be stale.", this.zzd);
            return null;
        }
    }
}
