package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzew extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzfp zzd;
    final /* synthetic */ zzgr zze;
    final /* synthetic */ zzye zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzew(long j, zzfp zzfpVar, zzgr zzgrVar, zzye zzyeVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = j;
        this.zzd = zzfpVar;
        this.zze = zzgrVar;
        this.zzf = zzyeVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzew(this.zzc, this.zzd, this.zze, this.zzf, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzew) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objZzc;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        Ref.ObjectRef objectRef = this.zzb;
        try {
            if (objectRef != 0) {
                Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.zza;
                ResultKt.throwOnFailure(obj);
                objZzc = obj;
                objectRef = objectRef2;
            } else {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                this.zza = objectRef3;
                this.zzb = 1;
                objZzc = zzcx.zzc(this.zzc, 20, 100L, 1000L, 2.0d, new zzev(this.zze, this.zzd, this.zzf, objectRef3, null), this);
                objectRef = objectRef3;
                if (objZzc == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return (zzyg) objZzc;
        } catch (Exception e) {
            zzcg zzcgVar = (zzcg) objectRef.element;
            if (zzcgVar == null) {
                throw zzfp.zzd(this.zzd, e);
            }
            throw zzcgVar;
        }
    }
}
