package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfn extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzgr zzc;
    final /* synthetic */ zzfp zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfn(zzgr zzgrVar, zzfp zzfpVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzgrVar;
        this.zzd = zzfpVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzfn(this.zzc, this.zzd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfn) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0046, code lost:
    
        if (r6 == r0) goto L14;
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
            int r1 = r5.zzb
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L18
            if (r1 == r3) goto L10
            kotlin.ResultKt.throwOnFailure(r6)
            goto L49
        L10:
            java.lang.Object r1 = r5.zza
            com.google.android.recaptcha.internal.zzgr r1 = (com.google.android.recaptcha.internal.zzgr) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L34
        L18:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.recaptcha.internal.zzgr r1 = r5.zzc
            com.google.android.recaptcha.internal.zzfp r6 = r5.zzd
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.zza = r1
            r5.zzb = r3
            com.google.android.recaptcha.internal.zzez r3 = new com.google.android.recaptcha.internal.zzez
            r3.<init>(r6, r2)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            com.google.android.recaptcha.internal.zzhg r6 = new com.google.android.recaptcha.internal.zzhg
            r6.<init>(r3)
            if (r6 == r0) goto L4c
        L34:
            com.google.android.recaptcha.internal.zzhg r6 = (com.google.android.recaptcha.internal.zzhg) r6
            r3 = r5
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r5.zza = r2
            r2 = 2
            r5.zzb = r2
            com.google.android.recaptcha.internal.zzhk r1 = r1.zza()
            java.lang.Object r6 = r6.zza(r1, r3)
            if (r6 != r0) goto L49
            goto L4c
        L49:
            com.google.android.recaptcha.internal.zzxn r6 = (com.google.android.recaptcha.internal.zzxn) r6
            return r6
        L4c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzfn.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
