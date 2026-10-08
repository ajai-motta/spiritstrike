package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbm extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzhk zzc;
    final /* synthetic */ zzbo zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbm(zzhk zzhkVar, zzbo zzboVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzhkVar;
        this.zzd = zzboVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzbm(this.zzc, this.zzd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbm) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0043, code lost:
    
        if (com.google.android.recaptcha.internal.zzhj.zzb(r1, (com.google.android.recaptcha.internal.zzhf) r7, r6) == r0) goto L14;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.zzb
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L19
            if (r1 == r4) goto L11
            kotlin.ResultKt.throwOnFailure(r7)
            goto L46
        L11:
            java.lang.Object r1 = r6.zza
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r7)
            goto L36
        L19:
            kotlin.ResultKt.throwOnFailure(r7)
            com.google.android.recaptcha.internal.zzhk r1 = r6.zzc
            com.google.android.recaptcha.internal.zzbo r7 = r6.zzd
            r5 = r6
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6.zza = r1
            r6.zzb = r4
            com.google.android.recaptcha.internal.zzbf r4 = new com.google.android.recaptcha.internal.zzbf
            r4.<init>(r7, r2)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r7 = 38
            java.lang.Object r7 = com.google.android.recaptcha.internal.zzhj.zzd(r7, r3, r4, r5)
            if (r7 == r0) goto L49
        L36:
            com.google.android.recaptcha.internal.zzhf r7 = (com.google.android.recaptcha.internal.zzhf) r7
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r6.zza = r2
            r6.zzb = r3
            java.lang.Object r7 = com.google.android.recaptcha.internal.zzhj.zzb(r1, r7, r4)
            if (r7 != r0) goto L46
            goto L49
        L46:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L49:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbm.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
