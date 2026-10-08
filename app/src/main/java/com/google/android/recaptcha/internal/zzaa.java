package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaa extends SuspendLambda implements Function2 {
    final /* synthetic */ zzad zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaa(zzad zzadVar, Continuation continuation) {
        super(2, continuation);
        this.zza = zzadVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzaa(this.zza, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzaa) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzad zzadVar = this.zza;
        String strZza = zzad.zzb(zzadVar).zza();
        zzyu zzyuVarZzf = zzyx.zzf();
        zzyv zzyvVarZzf = zzyw.zzf();
        zzyvVarZzf.zzw(strZza);
        zzyuVarZzf.zze(CollectionsKt.listOf(zzyvVarZzf.zzk()));
        return zzas.zzb(zzadVar, (zzyx) zzyuVarZzf.zzk());
    }
}
