package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfo extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzfp zzc;
    private /* synthetic */ Object zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfo(long j, zzfp zzfpVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = j;
        this.zzc = zzfpVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzfo zzfoVar = new zzfo(this.zzb, this.zzc, continuation);
        zzfoVar.zzd = obj;
        return zzfoVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfo) create((zzgr) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            if (this.zza != 0) {
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                zzgr zzgrVar = (zzgr) this.zzd;
                this.zza = 1;
                obj = TimeoutKt.withTimeout(this.zzb, new zzfn(zzgrVar, this.zzc, null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return (zzxn) obj;
        } catch (zzcg e) {
            if (Intrinsics.areEqual(e.zzb(), zzce.zzc)) {
                throw this.zzc.zzt(e, e);
            }
            throw e;
        } catch (TimeoutCancellationException e2) {
            throw this.zzc.zzt(e2, new zzcg(zzce.zzc, zzcd.zzb, e2.getMessage(), null, 8, null));
        } catch (Exception e3) {
            throw this.zzc.zzt(e3, new zzcg(zzce.zzc, zzcd.zzaz, e3.getMessage(), null, 8, null));
        }
    }
}
