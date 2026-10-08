package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzei extends ContinuationImpl {
    /* synthetic */ Object zza;
    final /* synthetic */ zzeq zzb;
    int zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzei(zzeq zzeqVar, Continuation continuation) {
        super(continuation);
        this.zzb = zzeqVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.zza = obj;
        this.zzc |= Integer.MIN_VALUE;
        Object objMo5051execute0E7RQCE = this.zzb.mo5051execute0E7RQCE(null, 0L, this);
        return objMo5051execute0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo5051execute0E7RQCE : Result.m7414boximpl(objMo5051execute0E7RQCE);
    }
}
