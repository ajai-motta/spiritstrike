package com.google.android.recaptcha.internal;

import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzz implements zzar {
    public static final /* synthetic */ zzyw zzb(zzz zzzVar, String str) {
        zzyv zzyvVarZzf = zzyw.zzf();
        zzyvVarZzf.zzw(str);
        return (zzyw) zzyvVarZzf.zzk();
    }

    @Override // com.google.android.recaptcha.internal.zzar
    public final int zza() {
        return 11;
    }

    @Override // com.google.android.recaptcha.internal.zzar
    public final /* synthetic */ Object zzc(String str, Continuation continuation) {
        return zzam.zza(this, str, continuation);
    }

    @Override // com.google.android.recaptcha.internal.zzar
    public final /* synthetic */ Object zzd(zzxp zzxpVar, Continuation continuation) {
        return zzhj.zzd(36, zza(), new zzap(this, zzxpVar, null), continuation);
    }

    @Override // com.google.android.recaptcha.internal.zzar
    public final Object zze(String str, Continuation continuation) {
        return new zzhg(new zzy(this, null));
    }

    @Override // com.google.android.recaptcha.internal.zzar
    public final /* synthetic */ Object zzf(zzxp zzxpVar, Continuation continuation) {
        return zzam.zzc(this, zzxpVar, continuation);
    }

    @Override // com.google.android.recaptcha.internal.zzar
    public final /* synthetic */ Object zzg(Exception exc, Continuation continuation) {
        return zzam.zzd(this, exc, continuation);
    }

    @Override // com.google.android.recaptcha.internal.zzar
    public final /* synthetic */ void zzh(zzyg zzygVar) {
    }

    @Override // com.google.android.recaptcha.internal.zzar
    public final boolean zzi() {
        return true;
    }
}
