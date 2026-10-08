package com.google.android.recaptcha.internal;

import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdj {
    private Object zza;
    private final Mutex zzb = MutexKt.Mutex$default(false, 1, null);

    public zzdj(Object obj) {
        this.zza = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zza(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzdg
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzdg r0 = (com.google.android.recaptcha.internal.zzdg) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdg r0 = new com.google.android.recaptcha.internal.zzdg
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.zza
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            com.google.android.recaptcha.internal.zzmc r0 = r0.zze
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r0
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.zzb
            r2 = r6
            com.google.android.recaptcha.internal.zzmc r2 = (com.google.android.recaptcha.internal.zzmc) r2
            r0.zze = r2
            r0.zza = r7
            r0.zzd = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 == r1) goto L61
        L4e:
            java.lang.Object r0 = r5.zza     // Catch: java.lang.Throwable -> L5c
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r6)     // Catch: java.lang.Throwable -> L5c
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch: java.lang.Throwable -> L5c
            r7.unlock(r4)
            return r6
        L5c:
            r6 = move-exception
            r7.unlock(r4)
            throw r6
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdj.zza(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzb(java.lang.Object[] r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzdh
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzdh r0 = (com.google.android.recaptcha.internal.zzdh) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdh r0 = new com.google.android.recaptcha.internal.zzdh
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r6 = r0.zza
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            com.google.android.recaptcha.internal.zzmc[] r0 = r0.zze
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r0
            goto L50
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3c:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.zzb
            r2 = r6
            com.google.android.recaptcha.internal.zzmc[] r2 = (com.google.android.recaptcha.internal.zzmc[]) r2
            r0.zze = r2
            r0.zza = r7
            r0.zzd = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 == r1) goto L63
        L50:
            java.lang.Object r0 = r5.zza     // Catch: java.lang.Throwable -> L5e
            boolean r6 = kotlin.collections.ArraysKt.contains(r6, r0)     // Catch: java.lang.Throwable -> L5e
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)     // Catch: java.lang.Throwable -> L5e
            r7.unlock(r4)
            return r6
        L5e:
            r6 = move-exception
            r7.unlock(r4)
            throw r6
        L63:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdj.zzb(java.lang.Object[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzc(java.lang.Object r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzdi
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzdi r0 = (com.google.android.recaptcha.internal.zzdi) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzdi r0 = new com.google.android.recaptcha.internal.zzdi
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.zza
            kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
            com.google.android.recaptcha.internal.zzmc r0 = r0.zze
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = r6
            r6 = r0
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3a:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.sync.Mutex r7 = r5.zzb
            r2 = r6
            com.google.android.recaptcha.internal.zzmc r2 = (com.google.android.recaptcha.internal.zzmc) r2
            r0.zze = r2
            r0.zza = r7
            r0.zzd = r3
            java.lang.Object r0 = r7.lock(r4, r0)
            if (r0 == r1) goto L5d
        L4e:
            r5.zza = r6     // Catch: java.lang.Throwable -> L58
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L58
            r7.unlock(r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L58:
            r6 = move-exception
            r7.unlock(r4)
            throw r6
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzdj.zzc(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
