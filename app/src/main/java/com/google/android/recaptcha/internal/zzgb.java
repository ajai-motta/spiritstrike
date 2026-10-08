package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaAction;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgb implements zzdw {
    private final zzfp zza;
    private CompletableDeferred zzb = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
    private final Lazy zzc;
    private zzcg zzd;
    private zzxn zze;
    private zzdv zzf;

    public zzgb(zzfp zzfpVar, zzct zzctVar) {
        this.zza = zzfpVar;
        int i = zzby.zza;
        this.zzc = LazyKt.lazy(zzfv.zza);
        this.zzf = zzdv.zza;
    }

    public static final /* synthetic */ zzcr zzd(zzgb zzgbVar) {
        return (zzcr) zzgbVar.zzc.getValue();
    }

    public static final /* synthetic */ boolean zzo(zzgb zzgbVar, Exception exc) {
        if (!(exc instanceof zzcg)) {
            return true;
        }
        zzcg zzcgVar = (zzcg) exc;
        return (Intrinsics.areEqual(zzcgVar.zzb(), zzce.zzd) || Intrinsics.areEqual(zzcgVar.zzb(), zzce.zze) || Intrinsics.areEqual(zzcgVar.zzb(), zzce.zzf)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzp(kotlin.jvm.functions.Function1 r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.google.android.recaptcha.internal.zzfr
            if (r0 == 0) goto L13
            r0 = r6
            com.google.android.recaptcha.internal.zzfr r0 = (com.google.android.recaptcha.internal.zzfr) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzfr r0 = new com.google.android.recaptcha.internal.zzfr
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            com.google.android.recaptcha.internal.zzcs r5 = r0.zzd
            r0 = r5
            com.google.android.recaptcha.internal.zzcs r0 = (com.google.android.recaptcha.internal.zzcs) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L49
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.recaptcha.internal.zzcs r6 = new com.google.android.recaptcha.internal.zzcs
            r6.<init>()
            r0.zzd = r6
            r0.zzc = r3
            java.lang.Object r5 = r5.invoke(r0)
            if (r5 == r1) goto L57
            r5 = r6
        L49:
            r5.zzc()
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r5 = r5.zza(r6)
            java.lang.Long r5 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r5)
            return r5
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzgb.zzp(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzq(long j, Continuation continuation) {
        return new zzhg(new zzga(this, j, null));
    }

    @Override // com.google.android.recaptcha.internal.zzdw
    public final Object zza(String str, RecaptchaAction recaptchaAction, long j, Continuation continuation) {
        return new zzhg(new zzfq(this, j, str, recaptchaAction, null));
    }

    @Override // com.google.android.recaptcha.internal.zzdw
    public final Object zzb(long j, Continuation continuation) {
        return zzq(j, continuation);
    }

    public final zzdv zze() {
        return this.zzf;
    }
}
