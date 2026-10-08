package com.google.android.recaptcha.internal;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzid extends SuspendLambda implements Function2 {
    final /* synthetic */ zzif zza;
    final /* synthetic */ zzcy zzb;
    final /* synthetic */ zzye zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzid(zzif zzifVar, zzcy zzcyVar, zzye zzyeVar, Continuation continuation) {
        super(2, continuation);
        this.zza = zzifVar;
        this.zzb = zzcyVar;
        this.zzc = zzyeVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzid(this.zza, this.zzb, this.zzc, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzid) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzhl zzhlVarZza = null;
        try {
            try {
                try {
                    zzhlVarZza = zzif.zza(this.zza).zza(this.zzb.zzd());
                    zzhlVarZza.zzc();
                    zzhlVarZza.zze(this.zzc.zzd());
                    zzyg zzygVar = (zzyg) zzhlVarZza.zza(zzyg.zzi());
                    zzhlVarZza.zzd();
                    return zzygVar;
                } catch (zzcg e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw new zzcg(zzce.zzc, zzcd.zzF, e2.getMessage(), null, 8, null);
            }
        } catch (Throwable th) {
            if (zzhlVarZza != null) {
                zzhlVarZza.zzd();
            }
            throw th;
        }
    }
}
