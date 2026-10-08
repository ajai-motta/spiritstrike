package com.google.android.recaptcha.internal;

import java.util.Timer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgv extends SuspendLambda implements Function2 {
    final /* synthetic */ zzgz zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgv(zzgz zzgzVar, Continuation continuation) {
        super(2, continuation);
        this.zza = zzgzVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzgv(this.zza, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzgv) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzgz zzgzVar = this.zza;
        synchronized (zzgs.class) {
            zzgo zzgoVar = zzgzVar.zzc;
            if (zzgoVar != null && zzgoVar.zzb() == 0) {
                Timer timer = zzgz.zza;
                if (timer != null) {
                    timer.cancel();
                }
                zzgz.zza = null;
            }
            zzgzVar.zzf();
            Unit unit = Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}
