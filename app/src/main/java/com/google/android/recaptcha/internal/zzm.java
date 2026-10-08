package com.google.android.recaptcha.internal;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzm extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzgr zzc;
    final /* synthetic */ zzg zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ zzxn zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzm(zzgr zzgrVar, zzg zzgVar, long j, zzxn zzxnVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzgrVar;
        this.zzd = zzgVar;
        this.zze = j;
        this.zzf = zzxnVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzm(this.zzc, this.zzd, this.zze, this.zzf, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzm) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM7415constructorimpl;
        zzgr zzgrVar;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.zzb;
        try {
        } catch (zzcg e) {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(e));
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            zzgrVar = this.zzc;
            zzg zzgVar = this.zzd;
            long j = this.zze;
            zzxn zzxnVar = this.zzf;
            zzm zzmVar = this;
            this.zza = zzgrVar;
            this.zzb = 1;
            zzhf zzhfVar = new zzhf(zzgVar.zzk(), new zzd(zzgVar, j, zzxnVar, null), null);
            if (zzhfVar != coroutine_suspended) {
                obj = zzhfVar;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            ResultKt.throwOnFailure(obj);
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
            return Result.m7414boximpl(objM7415constructorimpl);
        }
        zzgrVar = (zzgr) this.zza;
        ResultKt.throwOnFailure(obj);
        this.zza = null;
        this.zzb = 2;
        if (((zzhf) obj).zza(zzgrVar.zza(), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        Result.Companion companion22 = Result.INSTANCE;
        objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        return Result.m7414boximpl(objM7415constructorimpl);
    }
}
