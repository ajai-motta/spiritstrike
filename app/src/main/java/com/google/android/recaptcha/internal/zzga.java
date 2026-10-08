package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzga extends SuspendLambda implements Function2 {
    final /* synthetic */ zzgb zza;
    final /* synthetic */ long zzb;
    private /* synthetic */ Object zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzga(zzgb zzgbVar, long j, Continuation continuation) {
        super(2, continuation);
        this.zza = zzgbVar;
        this.zzb = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzga zzgaVar = new zzga(this.zza, this.zzb, continuation);
        zzgaVar.zzc = obj;
        return zzgaVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzga) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzhk zzhkVar = (zzhk) this.zzc;
        zzgb zzgbVar = this.zza;
        if (Intrinsics.areEqual(zzgbVar.zze(), zzdv.zzb) || Intrinsics.areEqual(zzgbVar.zze(), zzdv.zzc)) {
            return Unit.INSTANCE;
        }
        if (Intrinsics.areEqual(zzgbVar.zze(), zzdv.zzd) && !zzgb.zzo(zzgbVar, zzgbVar.zzd)) {
            return Unit.INSTANCE;
        }
        zzgbVar.zzf = zzdv.zzc;
        CompletableDeferred completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        zzgbVar.zzb = completableDeferredCompletableDeferred$default;
        BuildersKt__Builders_commonKt.launch$default(zzgb.zzd(zzgbVar).zza(), null, null, new zzfz(zzgbVar, completableDeferredCompletableDeferred$default, zzhkVar, this.zzb, null), 3, null);
        return Unit.INSTANCE;
    }
}
