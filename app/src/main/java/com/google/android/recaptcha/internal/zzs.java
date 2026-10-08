package com.google.android.recaptcha.internal;

import com.google.android.gms.recaptchabase.InitRequest;
import com.google.android.gms.recaptchabase.RecaptchaBase;
import com.google.android.gms.recaptchabase.RecaptchaBaseClient;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzs extends SuspendLambda implements Function2 {
    final /* synthetic */ zzu zza;
    final /* synthetic */ zzxn zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzs(zzu zzuVar, zzxn zzxnVar, Continuation continuation) {
        super(2, continuation);
        this.zza = zzuVar;
        this.zzb = zzxnVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzs(this.zza, this.zzb, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzs) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        zzu zzuVar = this.zza;
        if (!zzuVar.zza.zzb(zzu.zzl(zzuVar))) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m7414boximpl(Result.m7415constructorimpl(ResultKt.createFailure(new zzcg(zzce.zzb, zzcd.zzar, null, null, 12, null))));
        }
        zzxn zzxnVar = this.zzb;
        if (!zzxnVar.zzR() || zzxnVar.zzg().zzf().zzn()) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m7414boximpl(Result.m7415constructorimpl(ResultKt.createFailure(new zzcg(zzce.zzb, zzcd.zzaD, null, null, 12, null))));
        }
        zzuVar.zzb = zzxnVar.zzg().zzf().zzm();
        InitRequest initRequestBuild = new InitRequest.Builder().build();
        RecaptchaBaseClient client = RecaptchaBase.getClient(zzu.zzl(zzuVar));
        Intrinsics.checkNotNull(initRequestBuild);
        zzuVar.zzc = zzdf.zza(client.init(initRequestBuild));
        Result.Companion companion3 = Result.INSTANCE;
        return Result.m7414boximpl(Result.m7415constructorimpl(Unit.INSTANCE));
    }
}
