package com.google.android.recaptcha.internal;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfx extends SuspendLambda implements Function2 {
    Object zza;
    int zzb;
    final /* synthetic */ zzgb zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ CompletableDeferred zze;
    private /* synthetic */ Object zzf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfx(zzgb zzgbVar, long j, CompletableDeferred completableDeferred, Continuation continuation) {
        super(2, continuation);
        this.zzc = zzgbVar;
        this.zzd = j;
        this.zze = completableDeferred;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        zzfx zzfxVar = new zzfx(this.zzc, this.zzd, this.zze, continuation);
        zzfxVar.zzf = obj;
        return zzfxVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return ((zzfx) create((zzgr) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0087 A[Catch: zzcg -> 0x0017, PHI: r1 r10
  0x0087: PHI (r1v7 com.google.android.recaptcha.internal.zzgr) = (r1v6 com.google.android.recaptcha.internal.zzgr), (r1v14 com.google.android.recaptcha.internal.zzgr) binds: [B:29:0x0085, B:12:0x001e] A[DONT_GENERATE, DONT_INLINE]
  0x0087: PHI (r10v12 java.lang.Object) = (r10v11 java.lang.Object), (r10v0 java.lang.Object) binds: [B:29:0x0085, B:12:0x001e] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {zzcg -> 0x0017, blocks: (B:7:0x0012, B:33:0x009c, B:12:0x001e, B:30:0x0087, B:15:0x0026, B:28:0x006d, B:18:0x0032, B:25:0x0057, B:21:0x003e), top: B:39:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
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
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L36
            if (r1 == r5) goto L2a
            if (r1 == r4) goto L22
            if (r1 == r3) goto L1a
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            goto L9c
        L17:
            r10 = move-exception
            goto Lb5
        L1a:
            java.lang.Object r1 = r9.zzf
            com.google.android.recaptcha.internal.zzgr r1 = (com.google.android.recaptcha.internal.zzgr) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            goto L87
        L22:
            java.lang.Object r1 = r9.zzf
            com.google.android.recaptcha.internal.zzgr r1 = (com.google.android.recaptcha.internal.zzgr) r1
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            goto L6d
        L2a:
            java.lang.Object r1 = r9.zza
            com.google.android.recaptcha.internal.zzgr r1 = (com.google.android.recaptcha.internal.zzgr) r1
            java.lang.Object r5 = r9.zzf
            com.google.android.recaptcha.internal.zzgr r5 = (com.google.android.recaptcha.internal.zzgr) r5
            kotlin.ResultKt.throwOnFailure(r10)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            goto L57
        L36:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.zzf
            r1 = r10
            com.google.android.recaptcha.internal.zzgr r1 = (com.google.android.recaptcha.internal.zzgr) r1
            com.google.android.recaptcha.internal.zzgb r10 = r9.zzc     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            com.google.android.recaptcha.internal.zzfp r10 = com.google.android.recaptcha.internal.zzgb.zzf(r10)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            long r6 = r9.zzd     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r8 = r9
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r9.zzf = r1     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r9.zza = r1     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r9.zzb = r5     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            java.lang.Object r10 = r10.zzp(r6, r8)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            if (r10 != r0) goto L56
            goto Lb4
        L56:
            r5 = r1
        L57:
            com.google.android.recaptcha.internal.zzhf r10 = (com.google.android.recaptcha.internal.zzhf) r10     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r6 = r9
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r9.zzf = r5     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r9.zza = r2     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r9.zzb = r4     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            com.google.android.recaptcha.internal.zzhk r1 = r1.zza()     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            java.lang.Object r10 = r10.zza(r1, r6)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            if (r10 == r0) goto Lb4
            r1 = r5
        L6d:
            com.google.android.recaptcha.internal.zzxn r10 = (com.google.android.recaptcha.internal.zzxn) r10     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            com.google.android.recaptcha.internal.zzgb r4 = r9.zzc     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            com.google.android.recaptcha.internal.zzgb.zzl(r4, r10)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            com.google.android.recaptcha.internal.zzfp r4 = com.google.android.recaptcha.internal.zzgb.zzf(r4)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            long r5 = r9.zzd     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r7 = r9
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r9.zzf = r1     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r9.zzb = r3     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            java.lang.Object r10 = r4.zzn(r10, r5, r7)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            if (r10 == r0) goto Lb4
        L87:
            com.google.android.recaptcha.internal.zzhg r10 = (com.google.android.recaptcha.internal.zzhg) r10     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r3 = r9
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r9.zzf = r2     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            r2 = 4
            r9.zzb = r2     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            com.google.android.recaptcha.internal.zzhk r1 = r1.zza()     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            java.lang.Object r10 = r10.zza(r1, r3)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            if (r10 != r0) goto L9c
            goto Lb4
        L9c:
            com.google.android.recaptcha.internal.zzgb r10 = r9.zzc     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            com.google.android.recaptcha.internal.zzds r0 = com.google.android.recaptcha.internal.zzdv.zzb()     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            com.google.android.recaptcha.internal.zzdv r0 = (com.google.android.recaptcha.internal.zzdv) r0     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            com.google.android.recaptcha.internal.zzgb.zzn(r10, r0)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            kotlinx.coroutines.CompletableDeferred r10 = r9.zze     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            boolean r10 = r10.complete(r0)     // Catch: com.google.android.recaptcha.internal.zzcg -> L17
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r10)
            return r10
        Lb4:
            return r0
        Lb5:
            com.google.android.recaptcha.internal.zzgb r0 = r9.zzc
            com.google.android.recaptcha.internal.zzgb.zzm(r0, r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzfx.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
