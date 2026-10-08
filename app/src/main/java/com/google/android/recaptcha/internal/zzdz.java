package com.google.android.recaptcha.internal;

import android.app.Application;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaException;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdz {
    private static zzeh zza;

    public static final zzeh zza(Application application) {
        zzeh zzehVar = zza;
        if (zzehVar == null) {
            zzehVar = new zzeh(application);
        }
        if (zza == null) {
            zza = zzehVar;
        }
        return zzehVar;
    }

    public static final Object zzb(Application application, String str, long j, Continuation continuation) throws RecaptchaException, TimeoutCancellationException, ApiException {
        return zzeh.zzd(zza(application), str, j, null, null, continuation, 12, null);
    }

    public static final Task zzc(Application application, String str, long j) throws RecaptchaException, TimeoutCancellationException, ApiException {
        return zzbv.zza(BuildersKt__Builders_commonKt.async$default(zza(application).zza().zza(), null, null, new zzdx(application, str, j, null), 3, null));
    }

    public static final Object zzd(Application application, String str, Continuation continuation) throws RecaptchaException, ApiException {
        return zzeh.zzd(zza(application), str, 0L, null, zzdq.zzb, continuation, 2, null);
    }

    public static final Task zze(Application application, String str) throws RecaptchaException, ApiException {
        return zzbv.zza(BuildersKt__Builders_commonKt.async$default(zza(application).zza().zza(), null, null, new zzdy(application, str, null), 3, null));
    }
}
