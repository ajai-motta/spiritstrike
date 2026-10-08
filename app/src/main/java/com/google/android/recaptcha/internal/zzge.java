package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzge implements zzdw {
    private final zzfp zza;
    private zzdv zzb = zzdv.zza;
    private zzxn zzc;

    public zzge(zzfp zzfpVar) {
        this.zza = zzfpVar;
    }

    @Override // com.google.android.recaptcha.internal.zzdw
    public final Object zza(String str, RecaptchaAction recaptchaAction, long j, Continuation continuation) {
        return new zzhg(new zzgc(this, j, str, recaptchaAction, null));
    }

    @Override // com.google.android.recaptcha.internal.zzdw
    public final Object zzb(long j, Continuation continuation) {
        return new zzhg(new zzgd(this, j, null));
    }
}
