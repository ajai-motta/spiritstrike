package com.google.android.recaptcha.internal;

import android.os.Build;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzau extends SuspendLambda implements Function2 {
    final /* synthetic */ zzav zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzau(zzav zzavVar, Continuation continuation) {
        super(2, continuation);
        this.zza = zzavVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzau(this.zza, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzau) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzav zzavVar = this.zza;
        int i = Build.VERSION.SDK_INT;
        zzyu zzyuVarZzf = zzyx.zzf();
        zzyv zzyvVarZzf = zzyw.zzf();
        zzyvVarZzf.zzw(String.valueOf(i));
        zzyuVarZzf.zze(CollectionsKt.listOf(zzyvVarZzf.zzk()));
        return zzas.zzb(zzavVar, (zzyx) zzyuVarZzf.zzk());
    }
}
