package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeo extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzeq zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ RecaptchaAction zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzeo(zzeq zzeqVar, long j, RecaptchaAction recaptchaAction, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzeqVar;
        this.zzc = j;
        this.zzd = recaptchaAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzeo zzeoVar = new zzeo(this.zzb, this.zzc, this.zzd, continuation);
        zzeoVar.zze = obj;
        return zzeoVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzeo) create((zzgr) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[Catch: Exception -> 0x000f, zzcg -> 0x0011, TryCatch #2 {zzcg -> 0x0011, Exception -> 0x000f, blocks: (B:5:0x000b, B:20:0x005c, B:23:0x0068, B:24:0x0077, B:12:0x0018, B:17:0x0046, B:15:0x0024), top: B:29:0x0007 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.zza
            r2 = 1
            if (r1 == 0) goto L1c
            if (r1 == r2) goto L14
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            goto L5c
        Lf:
            r10 = move-exception
            goto L79
        L11:
            r10 = move-exception
            goto L8c
        L14:
            java.lang.Object r1 = r9.zze
            com.google.android.recaptcha.internal.zzgr r1 = (com.google.android.recaptcha.internal.zzgr) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            goto L46
        L1c:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.zze
            r1 = r10
            com.google.android.recaptcha.internal.zzgr r1 = (com.google.android.recaptcha.internal.zzgr) r1
            com.google.android.recaptcha.internal.zzeq r10 = r9.zzb     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            long r6 = r9.zzc     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            com.google.android.recaptcha.RecaptchaAction r5 = r9.zzd     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            com.google.android.recaptcha.internal.zzeq.zzd(r10, r6, r5)     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            com.google.android.recaptcha.internal.zzdw r3 = com.google.android.recaptcha.internal.zzeq.zza(r10)     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            com.google.android.recaptcha.internal.zzhk r10 = r1.zza()     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            java.lang.String r4 = r10.zzb()     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            r8 = r9
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            r9.zze = r1     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            r9.zza = r2     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            java.lang.Object r10 = r3.zza(r4, r5, r6, r8)     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            if (r10 == r0) goto L78
        L46:
            com.google.android.recaptcha.internal.zzhg r10 = (com.google.android.recaptcha.internal.zzhg) r10     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            r3 = 0
            r9.zze = r3     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            r3 = 2
            r9.zza = r3     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            com.google.android.recaptcha.internal.zzhk r1 = r1.zza()     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            java.lang.Object r10 = r10.zza(r1, r2)     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            if (r10 != r0) goto L5c
            return r0
        L5c:
            java.lang.String r10 = (java.lang.String) r10     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            r0 = r10
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            int r0 = r0.length()     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            if (r0 == 0) goto L68
            return r10
        L68:
            com.google.android.recaptcha.internal.zzcg r10 = new com.google.android.recaptcha.internal.zzcg     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            com.google.android.recaptcha.internal.zzce r2 = com.google.android.recaptcha.internal.zzce.zzb     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            com.google.android.recaptcha.internal.zzcd r3 = com.google.android.recaptcha.internal.zzcd.zzaW     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            r6 = 12
            r7 = 0
            r4 = 0
            r5 = 0
            r1 = r10
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
            throw r10     // Catch: java.lang.Exception -> Lf com.google.android.recaptcha.internal.zzcg -> L11
        L78:
            return r0
        L79:
            com.google.android.recaptcha.internal.zzcg r7 = new com.google.android.recaptcha.internal.zzcg
            com.google.android.recaptcha.internal.zzce r1 = com.google.android.recaptcha.internal.zzce.zzb
            com.google.android.recaptcha.internal.zzcd r2 = com.google.android.recaptcha.internal.zzcd.zzX
            java.lang.String r3 = r10.getMessage()
            r5 = 8
            r6 = 0
            r4 = 0
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            throw r7
        L8c:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzeo.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
