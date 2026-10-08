package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzap extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzar zzb;
    final /* synthetic */ zzxp zzc;
    private /* synthetic */ Object zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzap(zzar zzarVar, zzxp zzxpVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzarVar;
        this.zzc = zzxpVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzap zzapVar = new zzap(this.zzb, this.zzc, continuation);
        zzapVar.zzd = obj;
        return zzapVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzap) create((zzgr) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
    
        if (((com.google.android.recaptcha.internal.zzhg) r6).zza(r1.zza(), r5) == r0) goto L14;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.zza
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 == r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r6)
            goto L46
        Lf:
            java.lang.Object r1 = r5.zzd
            com.google.android.recaptcha.internal.zzgr r1 = (com.google.android.recaptcha.internal.zzgr) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L30
        L17:
            kotlin.ResultKt.throwOnFailure(r6)
            java.lang.Object r6 = r5.zzd
            r1 = r6
            com.google.android.recaptcha.internal.zzgr r1 = (com.google.android.recaptcha.internal.zzgr) r1
            com.google.android.recaptcha.internal.zzar r6 = r5.zzb
            com.google.android.recaptcha.internal.zzxp r3 = r5.zzc
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.zzd = r1
            r5.zza = r2
            java.lang.Object r6 = r6.zzf(r3, r4)
            if (r6 == r0) goto L49
        L30:
            com.google.android.recaptcha.internal.zzhg r6 = (com.google.android.recaptcha.internal.zzhg) r6
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 0
            r5.zzd = r3
            r3 = 2
            r5.zza = r3
            com.google.android.recaptcha.internal.zzhk r1 = r1.zza()
            java.lang.Object r6 = r6.zza(r1, r2)
            if (r6 != r0) goto L46
            goto L49
        L46:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L49:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzap.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
