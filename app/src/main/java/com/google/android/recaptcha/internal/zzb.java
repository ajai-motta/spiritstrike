package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzb extends SuspendLambda implements Function2 {
    int zza;
    final /* synthetic */ zzg zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ long zzd;
    private /* synthetic */ Object zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzb(zzg zzgVar, String str, long j, Continuation continuation) {
        super(2, continuation);
        this.zzb = zzgVar;
        this.zzc = str;
        this.zzd = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzb zzbVar = new zzb(this.zzb, this.zzc, this.zzd, continuation);
        zzbVar.zze = obj;
        return zzbVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzb) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        if (r12 != r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
    
        if (r12 != r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.zza
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L17
            if (r1 == r2) goto L13
            kotlin.ResultKt.throwOnFailure(r12)
            goto L76
        L13:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L61
            goto L58
        L17:
            java.lang.Object r1 = r11.zze
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch: java.lang.Exception -> L61
            goto L49
        L1f:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.zze
            r1 = r12
            com.google.android.recaptcha.internal.zzhk r1 = (com.google.android.recaptcha.internal.zzhk) r1
            com.google.android.recaptcha.internal.zzg r8 = r11.zzb     // Catch: java.lang.Exception -> L61
            java.lang.String r9 = r11.zzc     // Catch: java.lang.Exception -> L61
            long r6 = r11.zzd     // Catch: java.lang.Exception -> L61
            r12 = r11
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12     // Catch: java.lang.Exception -> L61
            r11.zze = r1     // Catch: java.lang.Exception -> L61
            r11.zza = r3     // Catch: java.lang.Exception -> L61
            int r12 = r8.zzj()     // Catch: java.lang.Exception -> L61
            com.google.android.recaptcha.internal.zzf r3 = new com.google.android.recaptcha.internal.zzf     // Catch: java.lang.Exception -> L61
            r10 = 0
            r5 = r3
            r5.<init>(r6, r8, r9, r10)     // Catch: java.lang.Exception -> L61
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3     // Catch: java.lang.Exception -> L61
            com.google.android.recaptcha.internal.zzhf r5 = new com.google.android.recaptcha.internal.zzhf     // Catch: java.lang.Exception -> L61
            r5.<init>(r12, r3, r4)     // Catch: java.lang.Exception -> L61
            if (r5 == r0) goto L75
            r12 = r5
        L49:
            com.google.android.recaptcha.internal.zzhf r12 = (com.google.android.recaptcha.internal.zzhf) r12     // Catch: java.lang.Exception -> L61
            r3 = r11
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch: java.lang.Exception -> L61
            r11.zze = r4     // Catch: java.lang.Exception -> L61
            r11.zza = r2     // Catch: java.lang.Exception -> L61
            java.lang.Object r12 = r12.zza(r1, r3)     // Catch: java.lang.Exception -> L61
            if (r12 == r0) goto L75
        L58:
            com.google.android.recaptcha.internal.zzxx r12 = (com.google.android.recaptcha.internal.zzxx) r12     // Catch: java.lang.Exception -> L61
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Exception -> L61
            java.lang.Object r12 = kotlin.Result.m7415constructorimpl(r12)     // Catch: java.lang.Exception -> L61
            goto L7a
        L61:
            kotlin.Result$Companion r12 = kotlin.Result.INSTANCE
            com.google.android.recaptcha.internal.zzg r12 = r11.zzb
            java.lang.String r1 = r11.zzc
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r11.zze = r4
            r3 = 3
            r11.zza = r3
            java.lang.Object r12 = r12.zza(r1, r2)
            if (r12 != r0) goto L76
        L75:
            return r0
        L76:
            java.lang.Object r12 = kotlin.Result.m7415constructorimpl(r12)
        L7a:
            kotlin.Result r12 = kotlin.Result.m7414boximpl(r12)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzb.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
