package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlt extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzhk zzc;
    final /* synthetic */ zzly zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzlt(zzhk zzhkVar, zzly zzlyVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzhkVar;
        this.zzd = zzlyVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzlt(this.zzc, this.zzd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzlt) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
    
        if (com.google.android.recaptcha.internal.zzhj.zzb(r1, (com.google.android.recaptcha.internal.zzhf) r6, r5) == r0) goto L14;
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
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L18
            if (r1 == r2) goto L10
            kotlin.ResultKt.throwOnFailure(r6)
            goto L47
        L10:
            java.lang.Object r1 = r5.zza
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r6)
            goto L36
        L18:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.recaptcha.internal.zzhk r1 = r5.zzc
            com.google.android.recaptcha.internal.zzly r6 = r5.zzd
            r4 = r5
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5.zza = r1
            r5.zzb = r2
            com.google.android.recaptcha.internal.zzlx r2 = new com.google.android.recaptcha.internal.zzlx
            r2.<init>(r6, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            com.google.android.recaptcha.internal.zzhf r6 = new com.google.android.recaptcha.internal.zzhf
            r4 = 42
            r6.<init>(r4, r2, r3)
            if (r6 == r0) goto L4a
        L36:
            com.google.android.recaptcha.internal.zzhf r6 = (com.google.android.recaptcha.internal.zzhf) r6
            r2 = r5
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r5.zza = r3
            r3 = 2
            r5.zzb = r3
            java.lang.Object r6 = com.google.android.recaptcha.internal.zzhj.zzb(r1, r6, r2)
            if (r6 != r0) goto L47
            goto L4a
        L47:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L4a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzlt.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
