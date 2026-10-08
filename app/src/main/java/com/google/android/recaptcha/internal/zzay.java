package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzay extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzba zzb;
    final /* synthetic */ zzxp zzc;
    private /* synthetic */ Object zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzay(zzba zzbaVar, zzxp zzxpVar, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzbaVar;
        this.zzc = zzxpVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzay zzayVar = new zzay(this.zzb, this.zzc, continuation);
        zzayVar.zzd = obj;
        return zzayVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzay) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0073, code lost:
    
        if (((com.google.android.recaptcha.internal.zzhg) r9).zza(r1, r8) == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.zza
            r2 = 1
            if (r1 == 0) goto L17
            if (r1 == r2) goto Lf
            kotlin.ResultKt.throwOnFailure(r9)
            goto L76
        Lf:
            java.lang.Object r1 = r8.zzd
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r9)
            goto L64
        L17:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.Object r9 = r8.zzd
            r1 = r9
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            com.google.android.recaptcha.internal.zzba r9 = r8.zzb
            com.google.android.recaptcha.internal.zzda r3 = com.google.android.recaptcha.internal.zzba.zzk(r9)
            android.app.Application r4 = com.google.android.recaptcha.internal.zzba.zzb(r9)
            android.content.Context r4 = (android.content.Context) r4
            boolean r3 = r3.zzb(r4)
            if (r3 == 0) goto L7a
            com.google.android.recaptcha.internal.zzxp r3 = r8.zzc
            long r4 = r3.zzf()
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L7a
            com.google.android.recaptcha.internal.zzqm r4 = r3.zzg()
            java.lang.String r4 = com.google.android.recaptcha.internal.zzba.zzl(r9, r4)
            com.google.android.recaptcha.internal.zzba.zzn(r9, r4)
            com.google.android.recaptcha.internal.zzbo r4 = com.google.android.recaptcha.internal.zzba.zzj(r9)
            long r5 = r3.zzf()
            r4.zzj(r5)
            com.google.android.recaptcha.internal.zzbo r9 = com.google.android.recaptcha.internal.zzba.zzj(r9)
            r3 = r8
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r8.zzd = r1
            r8.zza = r2
            java.lang.Object r9 = r9.zze(r3)
            if (r9 == r0) goto L79
        L64:
            com.google.android.recaptcha.internal.zzhg r9 = (com.google.android.recaptcha.internal.zzhg) r9
            r2 = r8
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 0
            r8.zzd = r3
            r3 = 2
            r8.zza = r3
            java.lang.Object r9 = r9.zza(r1, r2)
            if (r9 != r0) goto L76
            goto L79
        L76:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L79:
            return r0
        L7a:
            r0 = 0
            r9.zzo(r0)
            com.google.android.recaptcha.internal.zzcg r9 = new com.google.android.recaptcha.internal.zzcg
            com.google.android.recaptcha.internal.zzce r2 = com.google.android.recaptcha.internal.zzce.zzb
            com.google.android.recaptcha.internal.zzcd r3 = com.google.android.recaptcha.internal.zzcd.zzab
            r6 = 12
            r7 = 0
            r4 = 0
            r5 = 0
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzay.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
