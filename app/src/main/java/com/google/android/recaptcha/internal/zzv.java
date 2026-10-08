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
final class zzv extends SuspendLambda implements Function2 {
    final /* synthetic */ zzx zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzv(zzx zzxVar, Continuation continuation) {
        super(2, continuation);
        this.zza = zzxVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzv(this.zza, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzv) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzx zzxVar = this.zza;
        String strZza = zzbs.zza(zzx.zzb(zzxVar));
        if (strZza.length() == 0) {
            if (Build.VERSION.SDK_INT > 34) {
                throw new zzcg(zzce.zzb, zzcd.zzaE, null, null, 12, null);
            }
            throw new zzcg(zzce.zzb, zzcd.zzaF, null, null, 12, null);
        }
        zzyu zzyuVarZzf = zzyx.zzf();
        zzyv zzyvVarZzf = zzyw.zzf();
        zzyvVarZzf.zzw(strZza);
        zzyuVarZzf.zze(CollectionsKt.listOf(zzyvVarZzf.zzk()));
        return zzas.zzb(zzxVar, (zzyx) zzyuVarZzf.zzk());
    }
}
