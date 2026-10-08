package com.google.android.recaptcha.internal;

import android.app.Application;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.api.ApiException;
import com.google.android.recaptcha.RecaptchaException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeh {
    private final Application zza;
    private final Mutex zzb = MutexKt.Mutex$default(false, 1, null);
    private zzeq zzc;
    private final Lazy zzd;

    public zzeh(Application application) {
        this.zza = application;
        int i = zzby.zza;
        this.zzd = LazyKt.lazy(zzef.zza);
        zzdp.zza(application);
    }

    public static /* synthetic */ Object zzd(zzeh zzehVar, String str, long j, zzdw zzdwVar, zzdq zzdqVar, Continuation continuation, int i, Object obj) throws RecaptchaException, TimeoutCancellationException, ApiException {
        if ((i & 8) != 0) {
            zzdqVar = zzdq.zza;
        }
        zzdq zzdqVar2 = zzdqVar;
        if ((i & 2) != 0) {
            j = 10000;
        }
        return zzehVar.zzc(str, j, null, zzdqVar2, continuation);
    }

    public static final /* synthetic */ void zzf(zzeh zzehVar, long j) throws zzcg {
        if (j < 5000) {
            throw new zzcg(zzce.zzj, zzcd.zzI, null, null, 12, null);
        }
        if (ContextCompat.checkSelfPermission(zzehVar.zza, "android.permission.INTERNET") != 0) {
            throw new zzcg(zzce.zzc, zzcd.zzao, null, null, 12, null);
        }
    }

    public final zzcr zza() {
        return (zzcr) this.zzd.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzc(java.lang.String r18, long r19, com.google.android.recaptcha.internal.zzdw r21, com.google.android.recaptcha.internal.zzdq r22, kotlin.coroutines.Continuation r23) throws java.lang.Throwable {
        /*
            r17 = this;
            r9 = r17
            r0 = r23
            boolean r1 = r0 instanceof com.google.android.recaptcha.internal.zzea
            if (r1 == 0) goto L17
            r1 = r0
            com.google.android.recaptcha.internal.zzea r1 = (com.google.android.recaptcha.internal.zzea) r1
            int r2 = r1.zzg
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.zzg = r2
            goto L1c
        L17:
            com.google.android.recaptcha.internal.zzea r1 = new com.google.android.recaptcha.internal.zzea
            r1.<init>(r9, r0)
        L1c:
            r0 = r1
            java.lang.Object r1 = r0.zze
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzg
            r3 = 1
            r11 = 2
            r12 = 0
            if (r2 == 0) goto L5e
            if (r2 == r3) goto L43
            if (r2 != r11) goto L3b
            java.lang.Object r0 = r0.zza
            r2 = r0
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r1)     // Catch: java.lang.Throwable -> L38
            goto Lbb
        L38:
            r0 = move-exception
            goto Lc3
        L3b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L43:
            long r2 = r0.zzd
            java.lang.Object r4 = r0.zzc
            kotlinx.coroutines.sync.Mutex r4 = (kotlinx.coroutines.sync.Mutex) r4
            com.google.android.recaptcha.internal.zzdq r5 = r0.zzh
            r6 = r5
            com.google.android.recaptcha.internal.zzdq r6 = (com.google.android.recaptcha.internal.zzdq) r6
            java.lang.Object r6 = r0.zzb
            r6 = r12
            com.google.android.recaptcha.internal.zzdw r6 = (com.google.android.recaptcha.internal.zzdw) r6
            java.lang.Object r6 = r0.zza
            java.lang.String r6 = (java.lang.String) r6
            kotlin.ResultKt.throwOnFailure(r1)
            r14 = r4
            r13 = r6
            r6 = r2
            goto L7f
        L5e:
            kotlin.ResultKt.throwOnFailure(r1)
            kotlinx.coroutines.sync.Mutex r1 = r9.zzb
            r2 = r18
            r0.zza = r2
            r0.zzb = r12
            r4 = r22
            r0.zzh = r4
            r0.zzc = r1
            r5 = r19
            r0.zzd = r5
            r0.zzg = r3
            java.lang.Object r3 = r1.lock(r12, r0)
            if (r3 == r10) goto Lc7
            r14 = r1
            r13 = r2
            r6 = r5
            r5 = r4
        L7f:
            com.google.android.recaptcha.internal.zzdq r1 = com.google.android.recaptcha.internal.zzdq.zza     // Catch: java.lang.Throwable -> Lc1
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)     // Catch: java.lang.Throwable -> Lc1
            if (r1 == 0) goto L8a
            r1 = 3
        L88:
            r15 = r1
            goto L95
        L8a:
            com.google.android.recaptcha.internal.zzdq r1 = com.google.android.recaptcha.internal.zzdq.zzb     // Catch: java.lang.Throwable -> Lc1
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r1)     // Catch: java.lang.Throwable -> Lc1
            if (r1 == 0) goto L94
            r1 = 4
            goto L88
        L94:
            r15 = r11
        L95:
            com.google.android.recaptcha.internal.zzed r16 = new com.google.android.recaptcha.internal.zzed     // Catch: java.lang.Throwable -> Lc1
            r8 = 0
            r1 = r16
            r2 = r17
            r3 = r13
            r4 = r12
            r1.<init>(r2, r3, r4, r5, r6, r8)     // Catch: java.lang.Throwable -> Lc1
            r1 = r16
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1     // Catch: java.lang.Throwable -> Lc1
            r0.zza = r14     // Catch: java.lang.Throwable -> Lc1
            r0.zzb = r12     // Catch: java.lang.Throwable -> Lc1
            r0.zzh = r12     // Catch: java.lang.Throwable -> Lc1
            r0.zzc = r12     // Catch: java.lang.Throwable -> Lc1
            r0.zzg = r11     // Catch: java.lang.Throwable -> Lc1
            com.google.android.recaptcha.internal.zzhh r2 = new com.google.android.recaptcha.internal.zzhh     // Catch: java.lang.Throwable -> Lc1
            r2.<init>(r13, r15)     // Catch: java.lang.Throwable -> Lc1
            java.lang.Object r1 = r1.invoke(r2, r0)     // Catch: java.lang.Throwable -> Lc1
            if (r1 == r10) goto Lc7
            r2 = r14
        Lbb:
            com.google.android.recaptcha.internal.zzeq r1 = (com.google.android.recaptcha.internal.zzeq) r1     // Catch: java.lang.Throwable -> L38
            r2.unlock(r12)
            return r1
        Lc1:
            r0 = move-exception
            r2 = r14
        Lc3:
            r2.unlock(r12)
            throw r0
        Lc7:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzeh.zzc(java.lang.String, long, com.google.android.recaptcha.internal.zzdw, com.google.android.recaptcha.internal.zzdq, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
