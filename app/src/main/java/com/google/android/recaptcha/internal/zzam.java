package com.google.android.recaptcha.internal;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class zzam {
    public static /* synthetic */ Object zza(zzar zzarVar, String str, Continuation continuation) {
        return new zzhg(new zzao(zzarVar, str, null));
    }

    public static /* synthetic */ Object zzc(zzar zzarVar, zzxp zzxpVar, Continuation continuation) {
        return new zzhg(new zzaq(null));
    }

    public static /* synthetic */ Object zzd(zzar zzarVar, Exception exc, Continuation continuation) {
        int i = true != (exc instanceof TimeoutCancellationException) ? 2 : 27;
        int iZza = zzarVar.zza();
        zzys zzysVarZzf = zzyt.zzf();
        zzysVarZzf.zzf(iZza);
        zzysVarZzf.zzr(13);
        zzysVarZzf.zzq(i);
        return zzas.zza(zzarVar, (zzyt) zzysVarZzf.zzk());
    }
}
