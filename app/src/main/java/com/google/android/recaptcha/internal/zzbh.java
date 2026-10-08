package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbh extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzbo zzc;
    final /* synthetic */ zzhk zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbh(zzbo zzboVar, zzhk zzhkVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzboVar;
        this.zzd = zzhkVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzbh(this.zzc, this.zzd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbh) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003f, code lost:
    
        if (((com.google.android.recaptcha.internal.zzhg) r5).zza(r1, r4) == r0) goto L14;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.zzb
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 == r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r5)
            goto L42
        Lf:
            java.lang.Object r1 = r4.zza
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r5)
            goto L30
        L17:
            kotlin.ResultKt.throwOnFailure(r5)
            com.google.android.recaptcha.internal.zzbo r5 = r4.zzc
            com.google.android.recaptcha.internal.zzbp r1 = com.google.android.recaptcha.internal.zzbp.zza
            com.google.android.recaptcha.internal.zzbo.zzi(r5, r1)
            com.google.android.recaptcha.internal.zzhk r1 = r4.zzd
            r3 = r4
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4.zza = r1
            r4.zzb = r2
            java.lang.Object r5 = r5.zze(r3)
            if (r5 == r0) goto L45
        L30:
            com.google.android.recaptcha.internal.zzhg r5 = (com.google.android.recaptcha.internal.zzhg) r5
            r2 = r4
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 0
            r4.zza = r3
            r3 = 2
            r4.zzb = r3
            java.lang.Object r5 = r5.zza(r1, r2)
            if (r5 != r0) goto L42
            goto L45
        L42:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbh.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
