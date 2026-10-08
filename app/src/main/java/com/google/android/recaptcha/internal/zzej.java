package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzej extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzeq zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzej(zzeq zzeqVar, Continuation continuation) {
        super(continuation);
        this.zzb = zzeqVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objMo5052executegIAlus = this.zzb.mo5052executegIAlus(null, this);
        return objMo5052executegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo5052executegIAlus : Result.m7414boximpl(objMo5052executegIAlus);
    }
}
