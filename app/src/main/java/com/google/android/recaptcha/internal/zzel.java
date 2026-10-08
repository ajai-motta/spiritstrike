package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzel extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzeq zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ RecaptchaAction zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzel(zzeq zzeqVar, long j, RecaptchaAction recaptchaAction, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzeqVar;
        this.zzc = j;
        this.zzd = recaptchaAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzel zzelVar = new zzel(this.zzb, this.zzc, this.zzd, continuation);
        zzelVar.zze = obj;
        return zzelVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzel) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM7415constructorimpl;
        zzhk zzhkVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zza;
        try {
        } catch (zzcg e) {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(e.zzc()));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            zzhkVar = (zzhk) this.zze;
            Result.Companion companion2 = Result.INSTANCE;
            zzeq zzeqVar = this.zzb;
            long j = this.zzc;
            RecaptchaAction recaptchaAction = this.zzd;
            zzel zzelVar = this;
            this.zze = zzhkVar;
            this.zza = 1;
            zzhf zzhfVar = new zzhf(9, new zzeo(zzeqVar, j, recaptchaAction, null), null);
            if (zzhfVar != coroutine_suspended) {
                obj = zzhfVar;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            ResultKt.throwOnFailure(obj);
            objM7415constructorimpl = Result.m7415constructorimpl(obj);
            return Result.m7414boximpl(objM7415constructorimpl);
        }
        zzhkVar = (zzhk) this.zze;
        ResultKt.throwOnFailure(obj);
        this.zze = null;
        this.zza = 2;
        obj = ((zzhf) obj).zza(zzhkVar, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        objM7415constructorimpl = Result.m7415constructorimpl(obj);
        return Result.m7414boximpl(objM7415constructorimpl);
    }
}
