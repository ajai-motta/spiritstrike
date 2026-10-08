package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbb extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzbo zzb;
    final /* synthetic */ String zzc;
    private /* synthetic */ Object zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbb(zzbo zzboVar, String str, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzboVar;
        this.zzc = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzbb zzbbVar = new zzbb(this.zzb, this.zzc, continuation);
        zzbbVar.zzd = obj;
        return zzbbVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzbb) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0072 A[RETURN] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Exception {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.zza
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L25
            if (r1 == r4) goto L1d
            if (r1 == r3) goto L15
            kotlin.ResultKt.throwOnFailure(r8)
            if (r1 == r2) goto L62
            goto L73
        L15:
            java.lang.Object r1 = r7.zzd
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L52
        L1d:
            java.lang.Object r1 = r7.zzd
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L42
            goto L3e
        L25:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.zzd
            r1 = r8
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            com.google.android.recaptcha.internal.zzbo r8 = r7.zzb     // Catch: java.lang.Exception -> L42
            java.lang.String r5 = r7.zzc     // Catch: java.lang.Exception -> L42
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Exception -> L42
            r7.zzd = r1     // Catch: java.lang.Exception -> L42
            r7.zza = r4     // Catch: java.lang.Exception -> L42
            java.lang.Object r8 = com.google.android.recaptcha.internal.zzbo.zzd(r8, r5, r6)     // Catch: java.lang.Exception -> L42
            if (r8 == r0) goto L41
        L3e:
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L42
            goto L75
        L41:
            return r0
        L42:
            com.google.android.recaptcha.internal.zzbo r8 = r7.zzb
            r4 = r7
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r7.zzd = r1
            r7.zza = r3
            java.lang.Object r8 = r8.zze(r4)
            if (r8 != r0) goto L52
            return r0
        L52:
            com.google.android.recaptcha.internal.zzhg r8 = (com.google.android.recaptcha.internal.zzhg) r8
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            r7.zzd = r4
            r7.zza = r2
            java.lang.Object r8 = r8.zza(r1, r3)
            if (r8 == r0) goto L76
        L62:
            com.google.android.recaptcha.internal.zzbo r8 = r7.zzb
            java.lang.String r1 = r7.zzc
            r2 = r7
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 4
            r7.zza = r3
            java.lang.Object r8 = com.google.android.recaptcha.internal.zzbo.zzd(r8, r1, r2)
            if (r8 != r0) goto L73
            return r0
        L73:
            java.lang.String r8 = (java.lang.String) r8
        L75:
            return r8
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbb.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
