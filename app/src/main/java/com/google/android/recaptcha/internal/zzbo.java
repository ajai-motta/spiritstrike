package com.google.android.recaptcha.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbo {
    public CompletableDeferred zza;
    private final Lazy zzb;
    private zzbp zzc;
    private final Lazy zzd;
    private long zze;
    private final Mutex zzf;
    private boolean zzg;

    public zzbo() {
        this(28800000L);
    }

    public static final /* synthetic */ zzcr zzb(zzbo zzboVar) {
        return (zzcr) zzboVar.zzb.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzl(kotlin.coroutines.Continuation r7) throws java.lang.Exception {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzbc
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzbc r0 = (com.google.android.recaptcha.internal.zzbc) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzbc r0 = new com.google.android.recaptcha.internal.zzbc
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5b
        L29:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L31:
            kotlin.ResultKt.throwOnFailure(r7)
            com.google.android.play.core.integrity.StandardIntegrityManager$PrepareIntegrityTokenRequest$Builder r7 = com.google.android.play.core.integrity.StandardIntegrityManager.PrepareIntegrityTokenRequest.builder()
            long r4 = r6.zze
            com.google.android.play.core.integrity.StandardIntegrityManager$PrepareIntegrityTokenRequest$Builder r7 = r7.setCloudProjectNumber(r4)
            com.google.android.play.core.integrity.StandardIntegrityManager$PrepareIntegrityTokenRequest r7 = r7.build()
            kotlin.Lazy r2 = r6.zzd
            java.lang.Object r2 = r2.getValue()
            com.google.android.play.core.integrity.StandardIntegrityManager r2 = (com.google.android.play.core.integrity.StandardIntegrityManager) r2
            com.google.android.gms.tasks.Task r7 = r2.prepareIntegrityToken(r7)
            kotlinx.coroutines.Deferred r7 = com.google.android.recaptcha.internal.zzdf.zza(r7)
            r0.zzc = r3
            java.lang.Object r7 = r7.await(r0)
            if (r7 != r1) goto L5b
            return r1
        L5b:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbo.zzl(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006d, code lost:
    
        if (r7 == r1) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzm(java.lang.String r6, kotlin.coroutines.Continuation r7) throws java.lang.Exception {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.google.android.recaptcha.internal.zzbg
            if (r0 == 0) goto L13
            r0 = r7
            com.google.android.recaptcha.internal.zzbg r0 = (com.google.android.recaptcha.internal.zzbg) r0
            int r1 = r0.zzc
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzc = r1
            goto L18
        L13:
            com.google.android.recaptcha.internal.zzbg r0 = new com.google.android.recaptcha.internal.zzbg
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.zza
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzc
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L70
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.String r6 = r0.zzd
            r2 = r6
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4e
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.CompletableDeferred r7 = r5.zzf()
            r0.zzd = r6
            r0.zzc = r4
            java.lang.Object r7 = r7.await(r0)
            if (r7 == r1) goto L77
        L4e:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenProvider r7 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider) r7
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest$Builder r2 = com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenRequest.builder()
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest$Builder r6 = r2.setRequestHash(r6)
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityTokenRequest r6 = r6.build()
            com.google.android.gms.tasks.Task r6 = r7.request(r6)
            kotlinx.coroutines.Deferred r6 = com.google.android.recaptcha.internal.zzdf.zza(r6)
            r7 = 0
            r0.zzd = r7
            r0.zzc = r3
            java.lang.Object r7 = r6.await(r0)
            if (r7 != r1) goto L70
            goto L77
        L70:
            com.google.android.play.core.integrity.StandardIntegrityManager$StandardIntegrityToken r7 = (com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityToken) r7
            java.lang.String r6 = r7.token()
            return r6
        L77:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbo.zzm(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object zze(Continuation continuation) {
        return new zzhg(new zzbn(this, null));
    }

    public final CompletableDeferred zzf() {
        CompletableDeferred completableDeferred = this.zza;
        if (completableDeferred != null) {
            return completableDeferred;
        }
        return null;
    }

    public final void zzj(long j) {
        this.zze = j;
    }

    public zzbo(long j) {
        int i = zzby.zza;
        this.zzb = LazyKt.lazy(zzbk.zza);
        this.zzc = zzbp.zza;
        this.zzd = LazyKt.lazy(zzbl.zza);
        this.zzf = MutexKt.Mutex$default(false, 1, null);
    }
}
