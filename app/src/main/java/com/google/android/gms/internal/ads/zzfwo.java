package com.google.android.gms.internal.ads;

import androidx.datastore.core.DataStore;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfwo implements zzfvh {
    private final CoroutineScope zza;
    private final Mutex zzb;
    private final Mutex zzc;
    private final Mutex zzd;
    private boolean zze;
    private zzfvf zzf;
    private boolean zzg;
    private final DataStore zzh;
    private final zzdss zzi;

    public zzfwo(DataStore adQualityDataStore, zzfwq coroutineScopeProvider, zzdss dataPinger, zzfvq clock) {
        Intrinsics.checkNotNullParameter(adQualityDataStore, "adQualityDataStore");
        Intrinsics.checkNotNullParameter(coroutineScopeProvider, "coroutineScopeProvider");
        Intrinsics.checkNotNullParameter(dataPinger, "dataPinger");
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.zzi = dataPinger;
        this.zza = coroutineScopeProvider.zza();
        this.zzb = MutexKt.Mutex$default(false, 1, null);
        this.zzc = MutexKt.Mutex$default(false, 1, null);
        this.zzd = MutexKt.Mutex$default(false, 1, null);
        this.zzh = adQualityDataStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzs(java.lang.String r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.google.android.gms.internal.ads.zzfvt
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.gms.internal.ads.zzfvt r0 = (com.google.android.gms.internal.ads.zzfvt) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfvt r0 = new com.google.android.gms.internal.ads.zzfvt
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.zzc
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zze
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r8 = r0.zza
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Throwable -> L31
            goto L72
        L31:
            r9 = move-exception
            goto L7e
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            java.lang.Object r8 = r0.zzb
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r2 = r0.zza
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r8
            r8 = r2
            goto L5a
        L49:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.sync.Mutex r9 = r7.zzd
            r0.zza = r8
            r0.zzb = r9
            r0.zze = r4
            java.lang.Object r2 = r9.lock(r5, r0)
            if (r2 == r1) goto L82
        L5a:
            androidx.datastore.core.DataStore r2 = r7.zzh     // Catch: java.lang.Throwable -> L7a
            com.google.android.gms.internal.ads.zzfvu r4 = new com.google.android.gms.internal.ads.zzfvu     // Catch: java.lang.Throwable -> L7a
            r4.<init>(r8, r5)     // Catch: java.lang.Throwable -> L7a
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> L7a
            r0.zza = r9     // Catch: java.lang.Throwable -> L7a
            r0.zzb = r5     // Catch: java.lang.Throwable -> L7a
            r0.zze = r3     // Catch: java.lang.Throwable -> L7a
            java.lang.Object r8 = r2.updateData(r4, r0)     // Catch: java.lang.Throwable -> L7a
            if (r8 == r1) goto L82
            r6 = r9
            r9 = r8
            r8 = r6
        L72:
            com.google.android.gms.internal.ads.zzfvk r9 = (com.google.android.gms.internal.ads.zzfvk) r9     // Catch: java.lang.Throwable -> L31
            r8.unlock(r5)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L7a:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L7e:
            r8.unlock(r5)
            throw r9
        L82:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzs(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzt(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfvw
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfvw r0 = (com.google.android.gms.internal.ads.zzfvw) r0
            int r1 = r0.zzd
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zzd = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfvw r0 = new com.google.android.gms.internal.ads.zzfvw
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.zzb
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zzd
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r0 = r0.zza
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L31
            goto L69
        L31:
            r8 = move-exception
            goto L75
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3b:
            java.lang.Object r2 = r0.zza
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r2
            goto L53
        L44:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r8 = r7.zzd
            r0.zza = r8
            r0.zzd = r4
            java.lang.Object r2 = r8.lock(r5, r0)
            if (r2 == r1) goto L79
        L53:
            androidx.datastore.core.DataStore r2 = r7.zzh     // Catch: java.lang.Throwable -> L71
            com.google.android.gms.internal.ads.zzfvx r4 = new com.google.android.gms.internal.ads.zzfvx     // Catch: java.lang.Throwable -> L71
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L71
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch: java.lang.Throwable -> L71
            r0.zza = r8     // Catch: java.lang.Throwable -> L71
            r0.zzd = r3     // Catch: java.lang.Throwable -> L71
            java.lang.Object r0 = r2.updateData(r4, r0)     // Catch: java.lang.Throwable -> L71
            if (r0 == r1) goto L79
            r6 = r0
            r0 = r8
            r8 = r6
        L69:
            com.google.android.gms.internal.ads.zzfvk r8 = (com.google.android.gms.internal.ads.zzfvk) r8     // Catch: java.lang.Throwable -> L31
            r0.unlock(r5)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L71:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L75:
            r0.unlock(r5)
            throw r8
        L79:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzt(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzu(long r6, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfvv
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfvv r0 = (com.google.android.gms.internal.ads.zzfvv) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfvv r0 = new com.google.android.gms.internal.ads.zzfvv
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.zzc
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zze
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            long r6 = r0.zza
            java.lang.Object r0 = r0.zzb
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4a
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r8 = r5.zzb
            r0.zzb = r8
            r0.zza = r6
            r0.zze = r3
            java.lang.Object r0 = r8.lock(r4, r0)
            if (r0 == r1) goto L7c
            r0 = r8
        L4a:
            com.google.android.gms.internal.ads.zzfvf r8 = r5.zzf     // Catch: java.lang.Throwable -> L77
            java.lang.String r1 = "adQualityDataBuilder"
            if (r8 != 0) goto L54
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch: java.lang.Throwable -> L77
            r8 = r4
        L54:
            com.google.android.gms.internal.ads.zzfvf r2 = r5.zzf     // Catch: java.lang.Throwable -> L77
            if (r2 != 0) goto L5c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch: java.lang.Throwable -> L77
            r2 = r4
        L5c:
            long r2 = r2.zzi()     // Catch: java.lang.Throwable -> L77
            long r6 = r6 - r2
            com.google.android.gms.internal.ads.zzfvf r2 = r5.zzf     // Catch: java.lang.Throwable -> L77
            if (r2 != 0) goto L69
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch: java.lang.Throwable -> L77
            r2 = r4
        L69:
            long r1 = r2.zzg()     // Catch: java.lang.Throwable -> L77
            long r6 = r6 - r1
            r8.zzb(r6)     // Catch: java.lang.Throwable -> L77
            r0.unlock(r4)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L77:
            r6 = move-exception
            r0.unlock(r4)
            throw r6
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzu(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzv(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfwa
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfwa r0 = (com.google.android.gms.internal.ads.zzfwa) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfwa r0 = new com.google.android.gms.internal.ads.zzfwa
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.zzc
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zze
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L53
            if (r2 == r5) goto L4b
            if (r2 == r4) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r0 = r0.zza
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L34
            goto L9d
        L34:
            r8 = move-exception
            goto La7
        L37:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3f:
            java.lang.Object r2 = r0.zzb
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            java.lang.Object r4 = r0.zza
            com.google.android.gms.internal.ads.zzfvg r4 = (com.google.android.gms.internal.ads.zzfvg) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L87
        L4b:
            java.lang.Object r2 = r0.zza
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L62
        L53:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r2 = r7.zzb
            r0.zza = r2
            r0.zze = r5
            java.lang.Object r8 = r2.lock(r6, r0)
            if (r8 == r1) goto Lb0
        L62:
            com.google.android.gms.internal.ads.zzfvf r8 = r7.zzf     // Catch: java.lang.Throwable -> Lab
            if (r8 != 0) goto L6c
            java.lang.String r8 = "adQualityDataBuilder"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)     // Catch: java.lang.Throwable -> Lab
            r8 = r6
        L6c:
            com.google.android.gms.internal.ads.zzhwo r8 = r8.zzbu()     // Catch: java.lang.Throwable -> Lab
            com.google.android.gms.internal.ads.zzfvg r8 = (com.google.android.gms.internal.ads.zzfvg) r8     // Catch: java.lang.Throwable -> Lab
            r2.unlock(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            kotlinx.coroutines.sync.Mutex r2 = r7.zzd
            r0.zza = r8
            r0.zzb = r2
            r0.zze = r4
            java.lang.Object r4 = r2.lock(r6, r0)
            if (r4 == r1) goto Lb0
            r4 = r8
        L87:
            androidx.datastore.core.DataStore r8 = r7.zzh     // Catch: java.lang.Throwable -> La5
            com.google.android.gms.internal.ads.zzfwb r5 = new com.google.android.gms.internal.ads.zzfwb     // Catch: java.lang.Throwable -> La5
            r5.<init>(r4, r6)     // Catch: java.lang.Throwable -> La5
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch: java.lang.Throwable -> La5
            r0.zza = r2     // Catch: java.lang.Throwable -> La5
            r0.zzb = r6     // Catch: java.lang.Throwable -> La5
            r0.zze = r3     // Catch: java.lang.Throwable -> La5
            java.lang.Object r8 = r8.updateData(r5, r0)     // Catch: java.lang.Throwable -> La5
            if (r8 == r1) goto Lb0
            r0 = r2
        L9d:
            com.google.android.gms.internal.ads.zzfvk r8 = (com.google.android.gms.internal.ads.zzfvk) r8     // Catch: java.lang.Throwable -> L34
            r0.unlock(r6)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        La5:
            r8 = move-exception
            r0 = r2
        La7:
            r0.unlock(r6)
            throw r8
        Lab:
            r8 = move-exception
            r2.unlock(r6)
            throw r8
        Lb0:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzv(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final boolean zzw(com.google.android.gms.internal.ads.zzfvg r9) {
        /*
            java.util.List r0 = r9.zzk()
            if (r0 == 0) goto Ld
            java.lang.Object r0 = kotlin.collections.CollectionsKt.lastOrNull(r0)
            java.lang.Long r0 = (java.lang.Long) r0
            goto Le
        Ld:
            r0 = 0
        Le:
            int r1 = r9.zzl()
            int r2 = r9.zzm()
            r3 = 1
            r4 = 0
            if (r1 <= r2) goto L22
            boolean r1 = r9.zzd()
            if (r1 != 0) goto L22
            r1 = r3
            goto L23
        L22:
            r1 = r4
        L23:
            if (r0 == 0) goto L38
            java.lang.Number r0 = (java.lang.Number) r0
            long r5 = r0.longValue()
            long r7 = r9.zzi()
            long r7 = r7 - r5
            r5 = 5000(0x1388, double:2.4703E-320)
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 <= 0) goto L38
            r9 = r3
            goto L39
        L38:
            r9 = r4
        L39:
            if (r1 != 0) goto L3f
            if (r9 == 0) goto L3e
            goto L3f
        L3e:
            return r4
        L3f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzw(com.google.android.gms.internal.ads.zzfvg):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zza() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwj(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzb(String gwsQueryId) {
        Intrinsics.checkNotNullParameter(gwsQueryId, "gwsQueryId");
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwd(this, gwsQueryId, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzc() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfvz(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzd() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwn(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zze() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwh(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzf() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwl(this, null), 3, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfvh
    public final void zzg() {
        BuildersKt__Builders_commonKt.launch$default(this.zza, null, null, new zzfwf(this, null), 3, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d0, code lost:
    
        if (zzt(r0) == r1) goto L49;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.android.gms.internal.ads.zzfwo] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzh(kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzh(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzi(java.lang.String r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.google.android.gms.internal.ads.zzfwc
            if (r0 == 0) goto L13
            r0 = r9
            com.google.android.gms.internal.ads.zzfwc r0 = (com.google.android.gms.internal.ads.zzfwc) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfwc r0 = new com.google.android.gms.internal.ads.zzfwc
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.zzc
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zze
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            long r1 = r0.zzb
            java.lang.Object r8 = r0.zza
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.String r0 = r0.zzf
            r5 = r0
            java.lang.String r5 = (java.lang.String) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto L57
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.sync.Mutex r9 = r7.zzb
            long r5 = java.lang.System.currentTimeMillis()
            r0.zzf = r8
            r0.zza = r9
            r0.zzb = r5
            r0.zze = r3
            java.lang.Object r0 = r9.lock(r4, r0)
            if (r0 == r1) goto L8d
            r0 = r8
            r8 = r9
            r1 = r5
        L57:
            boolean r9 = r7.zze     // Catch: java.lang.Throwable -> L88
            if (r9 == 0) goto L61
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L88
            r8.unlock(r4)
            return r9
        L61:
            r7.zze = r3     // Catch: java.lang.Throwable -> L88
            com.google.android.gms.internal.ads.zzfvg r9 = com.google.android.gms.internal.ads.zzfvg.zzp()     // Catch: java.lang.Throwable -> L88
            com.google.android.gms.internal.ads.zzhwi r9 = r9.zzcc()     // Catch: java.lang.Throwable -> L88
            java.lang.String r3 = "toBuilder(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)     // Catch: java.lang.Throwable -> L88
            com.google.android.gms.internal.ads.zzfvf r9 = (com.google.android.gms.internal.ads.zzfvf) r9     // Catch: java.lang.Throwable -> L88
            r7.zzf = r9     // Catch: java.lang.Throwable -> L88
            if (r9 != 0) goto L7c
            java.lang.String r9 = "adQualityDataBuilder"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)     // Catch: java.lang.Throwable -> L88
            r9 = r4
        L7c:
            r9.zza(r0)     // Catch: java.lang.Throwable -> L88
            r9.zzj(r1)     // Catch: java.lang.Throwable -> L88
            r8.unlock(r4)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L88:
            r9 = move-exception
            r8.unlock(r4)
            throw r9
        L8d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzi(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a5, code lost:
    
        if (zzv(r0) != r1) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0089 A[Catch: all -> 0x00ab, TryCatch #1 {all -> 0x00ab, blocks: (B:31:0x0085, B:33:0x0089, B:34:0x008f), top: B:50:0x0085 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzj(kotlin.coroutines.Continuation r11) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.google.android.gms.internal.ads.zzfvy
            if (r0 == 0) goto L13
            r0 = r11
            com.google.android.gms.internal.ads.zzfvy r0 = (com.google.android.gms.internal.ads.zzfvy) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfvy r0 = new com.google.android.gms.internal.ads.zzfvy
            r0.<init>(r10, r11)
        L18:
            java.lang.Object r11 = r0.zzc
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zze
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L52
            if (r2 == r6) goto L4a
            if (r2 == r5) goto L40
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            kotlin.ResultKt.throwOnFailure(r11)
            goto La8
        L34:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L3c:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L9f
        L40:
            long r5 = r0.zzb
            java.lang.Object r2 = r0.zza
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L85
        L4a:
            java.lang.Object r2 = r0.zza
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L61
        L52:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlinx.coroutines.sync.Mutex r2 = r10.zzc
            r0.zza = r2
            r0.zze = r6
            java.lang.Object r11 = r2.lock(r7, r0)
            if (r11 == r1) goto Lb5
        L61:
            boolean r11 = r10.zzg     // Catch: java.lang.Throwable -> Lb0
            if (r11 == 0) goto L6b
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lb0
            r2.unlock(r7)
            return r11
        L6b:
            r10.zzg = r6     // Catch: java.lang.Throwable -> Lb0
            kotlin.Unit r11 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> Lb0
            r2.unlock(r7)
            kotlinx.coroutines.sync.Mutex r2 = r10.zzb
            long r8 = java.lang.System.currentTimeMillis()
            r0.zza = r2
            r0.zzb = r8
            r0.zze = r5
            java.lang.Object r11 = r2.lock(r7, r0)
            if (r11 == r1) goto Lb5
            r5 = r8
        L85:
            com.google.android.gms.internal.ads.zzfvf r11 = r10.zzf     // Catch: java.lang.Throwable -> Lab
            if (r11 != 0) goto L8f
            java.lang.String r11 = "adQualityDataBuilder"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r11)     // Catch: java.lang.Throwable -> Lab
            r11 = r7
        L8f:
            r11.zzo(r5)     // Catch: java.lang.Throwable -> Lab
            r2.unlock(r7)
            r0.zza = r7
            r0.zze = r4
            java.lang.Object r11 = r10.zzu(r5, r0)
            if (r11 == r1) goto Lb5
        L9f:
            r0.zze = r3
            java.lang.Object r11 = r10.zzv(r0)
            if (r11 != r1) goto La8
            goto Lb5
        La8:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        Lab:
            r11 = move-exception
            r2.unlock(r7)
            throw r11
        Lb0:
            r11 = move-exception
            r2.unlock(r7)
            throw r11
        Lb5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzj(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007e A[Catch: all -> 0x011a, TRY_ENTER, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008a A[Catch: all -> 0x011a, TRY_ENTER, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cf A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d9 A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x010d A[Catch: all -> 0x011a, TryCatch #0 {all -> 0x011a, blocks: (B:28:0x0078, B:31:0x007e, B:32:0x0082, B:35:0x008a, B:37:0x008e, B:38:0x0092, B:40:0x00ae, B:41:0x00b2, B:43:0x00bb, B:45:0x00bf, B:46:0x00c3, B:47:0x00cb, B:49:0x00cf, B:50:0x00d3, B:52:0x00d9, B:54:0x00dd, B:55:0x00e1, B:57:0x00fd, B:58:0x0101, B:59:0x0109, B:61:0x010d, B:62:0x0111), top: B:72:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzk(kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzk(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00f6, code lost:
    
        if (zzs(r14, r0) == r1) goto L65;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0091 A[Catch: all -> 0x00fc, TRY_ENTER, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0099 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a7 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b7 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c2 A[Catch: all -> 0x00fc, TryCatch #1 {all -> 0x00fc, blocks: (B:32:0x008b, B:35:0x0091, B:36:0x0095, B:38:0x0099, B:39:0x009d, B:41:0x00a7, B:42:0x00ab, B:44:0x00b7, B:45:0x00bb, B:47:0x00c2, B:48:0x00c6), top: B:67:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzl(kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 263
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzl(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0100, code lost:
    
        if (zzs(r15, r0) == r1) goto L67;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0090 A[Catch: all -> 0x0106, TRY_ENTER, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a6 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b6 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c1 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:31:0x008a, B:34:0x0090, B:35:0x0094, B:37:0x0098, B:38:0x009c, B:40:0x00a6, B:41:0x00aa, B:43:0x00b6, B:44:0x00ba, B:46:0x00c1, B:47:0x00c5, B:49:0x00cc, B:50:0x00d0), top: B:68:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzm(kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzm(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object zzn(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.google.android.gms.internal.ads.zzfwe
            if (r0 == 0) goto L13
            r0 = r8
            com.google.android.gms.internal.ads.zzfwe r0 = (com.google.android.gms.internal.ads.zzfwe) r0
            int r1 = r0.zze
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.zze = r1
            goto L18
        L13:
            com.google.android.gms.internal.ads.zzfwe r0 = new com.google.android.gms.internal.ads.zzfwe
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.zzc
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.zze
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            long r1 = r0.zza
            java.lang.Object r0 = r0.zzb
            kotlinx.coroutines.sync.Mutex r0 = (kotlinx.coroutines.sync.Mutex) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4f
        L30:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L38:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.sync.Mutex r8 = r7.zzb
            long r5 = java.lang.System.currentTimeMillis()
            r0.zzb = r8
            r0.zza = r5
            r0.zze = r3
            java.lang.Object r0 = r8.lock(r4, r0)
            if (r0 == r1) goto L67
            r0 = r8
            r1 = r5
        L4f:
            com.google.android.gms.internal.ads.zzfvf r8 = r7.zzf     // Catch: java.lang.Throwable -> L62
            if (r8 != 0) goto L59
            java.lang.String r8 = "adQualityDataBuilder"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)     // Catch: java.lang.Throwable -> L62
            r8 = r4
        L59:
            r8.zzs(r1)     // Catch: java.lang.Throwable -> L62
            r0.unlock(r4)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L62:
            r8 = move-exception
            r0.unlock(r4)
            throw r8
        L67:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfwo.zzn(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
