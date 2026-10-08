package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzlw extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzly zzc;
    final /* synthetic */ zzgr zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzlw(zzly zzlyVar, zzgr zzgrVar, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzlyVar;
        this.zzd = zzgrVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new zzlw(this.zzc, this.zzd, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzlw) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.withTimeout(com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, new com.google.android.recaptcha.internal.zzlv(r9.zzc, r9.zzd, null), r9) == r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.zzb
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L1e
            goto L4a
        L12:
            java.lang.Object r0 = r9.zza
            com.google.android.recaptcha.internal.zzcg r0 = (com.google.android.recaptcha.internal.zzcg) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L7e
        L1a:
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> L1e
            goto L30
        L1e:
            r10 = move-exception
            goto L4d
        L20:
            kotlin.ResultKt.throwOnFailure(r10)
            com.google.android.recaptcha.internal.zzly r10 = r9.zzc     // Catch: java.lang.Exception -> L1e
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Exception -> L1e
            r9.zzb = r3     // Catch: java.lang.Exception -> L1e
            java.lang.Object r10 = r10.zzw(r1)     // Catch: java.lang.Exception -> L1e
            if (r10 == r0) goto L7c
        L30:
            com.google.android.recaptcha.internal.zzlv r10 = new com.google.android.recaptcha.internal.zzlv     // Catch: java.lang.Exception -> L1e
            com.google.android.recaptcha.internal.zzly r1 = r9.zzc     // Catch: java.lang.Exception -> L1e
            com.google.android.recaptcha.internal.zzgr r3 = r9.zzd     // Catch: java.lang.Exception -> L1e
            r4 = 0
            r10.<init>(r1, r3, r4)     // Catch: java.lang.Exception -> L1e
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10     // Catch: java.lang.Exception -> L1e
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1     // Catch: java.lang.Exception -> L1e
            r9.zzb = r2     // Catch: java.lang.Exception -> L1e
            r2 = 20000(0x4e20, double:9.8813E-320)
            java.lang.Object r10 = kotlinx.coroutines.TimeoutKt.withTimeout(r2, r10, r1)     // Catch: java.lang.Exception -> L1e
            if (r10 != r0) goto L4a
            goto L7c
        L4a:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L4d:
            r10.getMessage()
            com.google.android.recaptcha.internal.zzcg r8 = new com.google.android.recaptcha.internal.zzcg
            com.google.android.recaptcha.internal.zzce r2 = com.google.android.recaptcha.internal.zzce.zzb
            com.google.android.recaptcha.internal.zzcd r3 = com.google.android.recaptcha.internal.zzcd.zzV
            java.lang.String r4 = r10.getMessage()
            r6 = 8
            r7 = 0
            r5 = 0
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6, r7)
            com.google.android.recaptcha.internal.zzcg r10 = com.google.android.recaptcha.internal.zzh.zza(r10, r8)
            com.google.android.recaptcha.internal.zzly r1 = r9.zzc
            com.google.android.recaptcha.internal.zzdj r1 = r1.zzn()
            com.google.android.recaptcha.internal.zzmc r2 = com.google.android.recaptcha.internal.zzmc.zza
            r3 = r9
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r9.zza = r10
            r4 = 3
            r9.zzb = r4
            java.lang.Object r1 = r1.zzc(r2, r3)
            if (r1 != r0) goto L7d
        L7c:
            return r0
        L7d:
            r0 = r10
        L7e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzlw.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
