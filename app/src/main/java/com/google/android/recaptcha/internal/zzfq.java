package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfq extends SuspendLambda implements Function2 {
    Object zza;
    double zzb;
    int zzc;
    final /* synthetic */ zzgb zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ String zzf;
    final /* synthetic */ RecaptchaAction zzg;
    private /* synthetic */ Object zzh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfq(zzgb zzgbVar, long j, String str, RecaptchaAction recaptchaAction, Continuation continuation) {
        super(2, continuation);
        this.zzd = zzgbVar;
        this.zze = j;
        this.zzf = str;
        this.zzg = recaptchaAction;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzfq zzfqVar = new zzfq(this.zzd, this.zze, this.zzf, this.zzg, continuation);
        zzfqVar.zzh = obj;
        return zzfqVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfq) create((zzhk) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0135 A[Catch: Exception -> 0x014a, zzcg -> 0x014c, PHI: r1 r3 r12
  0x0135: PHI (r1v25 com.google.android.recaptcha.internal.zzhk) = (r1v22 com.google.android.recaptcha.internal.zzhk), (r1v27 com.google.android.recaptcha.internal.zzhk) binds: [B:49:0x0133, B:6:0x0019] A[DONT_GENERATE, DONT_INLINE]
  0x0135: PHI (r3v20 com.google.android.recaptcha.internal.zzyg) = (r3v19 com.google.android.recaptcha.internal.zzyg), (r3v22 com.google.android.recaptcha.internal.zzyg) binds: [B:49:0x0133, B:6:0x0019] A[DONT_GENERATE, DONT_INLINE]
  0x0135: PHI (r12v28 java.lang.Object) = (r12v27 java.lang.Object), (r12v0 java.lang.Object) binds: [B:49:0x0133, B:6:0x0019] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {zzcg -> 0x014c, Exception -> 0x014a, blocks: (B:58:0x014e, B:59:0x0151, B:6:0x0019, B:50:0x0135, B:9:0x0022, B:48:0x011c, B:12:0x002f, B:45:0x0109, B:15:0x003a, B:39:0x00de, B:42:0x00ef, B:18:0x0049, B:36:0x00c9, B:21:0x0052, B:33:0x009a, B:24:0x005e, B:30:0x0087, B:27:0x006a), top: B:64:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0148  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzfq.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
