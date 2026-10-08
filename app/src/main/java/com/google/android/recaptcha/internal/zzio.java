package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzio extends SuspendLambda implements Function2 {
    Object zza;
    Object zzb;
    int zzc;
    final /* synthetic */ zziz zzd;
    final /* synthetic */ zzip zze;
    final /* synthetic */ String zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzio(zziz zzizVar, zzip zzipVar, String str, Continuation continuation) {
        super(2, continuation);
        this.zzd = zzizVar;
        this.zze = zzipVar;
        this.zzf = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzio(this.zzd, this.zze, this.zzf, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzio) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0082, code lost:
    
        if (r7.zze.zzh(r8, r7.zzd, r7) != r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.zzc
            r2 = 1
            if (r1 == 0) goto L1c
            if (r1 == r2) goto L10
            kotlin.ResultKt.throwOnFailure(r8)
            goto L85
        L10:
            java.lang.Object r1 = r7.zzb
            com.google.android.recaptcha.internal.zzmf r1 = (com.google.android.recaptcha.internal.zzmf) r1
            java.lang.Object r2 = r7.zza
            com.google.android.recaptcha.internal.zzzq r2 = (com.google.android.recaptcha.internal.zzzq) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Exception -> L6e
            goto L5e
        L1c:
            kotlin.ResultKt.throwOnFailure(r8)
            com.google.android.recaptcha.internal.zziz r8 = r7.zzd
            com.google.android.recaptcha.internal.zzcs r1 = new com.google.android.recaptcha.internal.zzcs
            r1.<init>()
            r8.zza = r1
            java.lang.String r1 = r7.zzf     // Catch: java.lang.Exception -> L6e
            com.google.android.recaptcha.internal.zzpp r3 = com.google.android.recaptcha.internal.zzpp.zzh()     // Catch: java.lang.Exception -> L6e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch: java.lang.Exception -> L6e
            byte[] r1 = r3.zzj(r1)     // Catch: java.lang.Exception -> L6e
            com.google.android.recaptcha.internal.zzzq r1 = com.google.android.recaptcha.internal.zzzq.zzi(r1)     // Catch: java.lang.Exception -> L6e
            r1.zzf()     // Catch: java.lang.Exception -> L6e
            com.google.android.recaptcha.internal.zzip r3 = r7.zze     // Catch: java.lang.Exception -> L6e
            com.google.android.recaptcha.internal.zzkt r4 = com.google.android.recaptcha.internal.zzip.zzb(r3)     // Catch: java.lang.Exception -> L6e
            com.google.android.recaptcha.internal.zzzo r4 = r4.zza(r1)     // Catch: java.lang.Exception -> L6e
            com.google.android.recaptcha.internal.zzmf r5 = com.google.android.recaptcha.internal.zzmf.zzb()     // Catch: java.lang.Exception -> L6e
            java.util.List r4 = r4.zzi()     // Catch: java.lang.Exception -> L6e
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: java.lang.Exception -> L6e
            r7.zza = r1     // Catch: java.lang.Exception -> L6e
            r7.zzb = r5     // Catch: java.lang.Exception -> L6e
            r7.zzc = r2     // Catch: java.lang.Exception -> L6e
            java.lang.Object r8 = com.google.android.recaptcha.internal.zzip.zzc(r3, r4, r8, r6)     // Catch: java.lang.Exception -> L6e
            if (r8 == r0) goto L84
            r2 = r1
            r1 = r5
        L5e:
            r1.zzf()     // Catch: java.lang.Exception -> L6e
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MICROSECONDS     // Catch: java.lang.Exception -> L6e
            long r3 = r1.zza(r8)     // Catch: java.lang.Exception -> L6e
            kotlin.coroutines.jvm.internal.Boxing.boxLong(r3)     // Catch: java.lang.Exception -> L6e
            r2.zzf()     // Catch: java.lang.Exception -> L6e
            goto L85
        L6e:
            r8 = move-exception
            com.google.android.recaptcha.internal.zzip r1 = r7.zze
            com.google.android.recaptcha.internal.zziz r2 = r7.zzd
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 0
            r7.zza = r4
            r7.zzb = r4
            r4 = 2
            r7.zzc = r4
            java.lang.Object r8 = com.google.android.recaptcha.internal.zzip.zzd(r1, r8, r2, r3)
            if (r8 != r0) goto L85
        L84:
            return r0
        L85:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzio.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
