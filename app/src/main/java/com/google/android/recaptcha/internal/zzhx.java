package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhx extends SuspendLambda implements Function2 {
    final /* synthetic */ zzib zza;
    final /* synthetic */ String zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhx(zzib zzibVar, String str, Continuation continuation) {
        super(2, continuation);
        this.zza = zzibVar;
        this.zzb = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzhx(this.zza, this.zzb, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzhx) create((zzgr) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzib zzibVar = this.zza;
        zzbt zzbtVarZza = zzib.zza(zzibVar);
        String str = this.zzb;
        if (!zzbtVarZza.zzd(str)) {
            throw new zzcg(zzce.zzk, zzcd.zzS, null, null, 12, null);
        }
        try {
            String strZza = zzib.zza(zzibVar).zza(str);
            if (strZza != null) {
                return strZza;
            }
            throw new zzcg(zzce.zzk, zzcd.zzS, null, null, 12, null);
        } catch (Exception e) {
            throw new zzcg(zzce.zzk, zzcd.zzR, e.getMessage(), null, 8, null);
        }
    }
}
