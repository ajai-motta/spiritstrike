package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzev extends SuspendLambda implements Function1 {
    Object zza;
    int zzb;
    final /* synthetic */ zzgr zzc;
    final /* synthetic */ zzfp zzd;
    final /* synthetic */ zzye zze;
    final /* synthetic */ Ref.ObjectRef zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzev(zzgr zzgrVar, zzfp zzfpVar, zzye zzyeVar, Ref.ObjectRef objectRef, Continuation continuation) {
        super(1, continuation);
        this.zzc = zzgrVar;
        this.zzd = zzfpVar;
        this.zze = zzyeVar;
        this.zzf = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new zzev(this.zzc, this.zzd, this.zze, this.zzf, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return ((zzev) create((Continuation) obj)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r7v1, types: [T, com.google.android.recaptcha.internal.zzcg, java.lang.Throwable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        zzgr zzgrVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zzb;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                zzgrVar = this.zzc;
                zzfp zzfpVar = this.zzd;
                zzye zzyeVar = this.zze;
                zzev zzevVar = this;
                this.zza = zzgrVar;
                this.zzb = 1;
                obj = new zzhf(48, new zzes(zzfpVar, zzyeVar, null), null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    ResultKt.throwOnFailure(obj);
                    return (zzyg) obj;
                }
                zzgrVar = (zzgr) this.zza;
                ResultKt.throwOnFailure(obj);
            }
            this.zza = null;
            this.zzb = 2;
            obj = ((zzhf) obj).zza(zzgrVar.zza(), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            return (zzyg) obj;
        } catch (zzcg e) {
            this.zzf.element = e;
            throw e;
        }
    }
}
