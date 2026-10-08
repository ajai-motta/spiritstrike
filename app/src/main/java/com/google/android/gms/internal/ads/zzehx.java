package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzehx implements zzdjl {
    private final VersionInfoParcel zza;
    private final ListenableFuture zzb;
    private final zzffu zzc;
    private final zzcgy zzd;
    private final zzfgn zze;
    private final zzbma zzf;
    private final boolean zzg;
    private final zzegj zzh;
    private final zzdvi zzi;

    zzehx(VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzffu zzffuVar, zzcgy zzcgyVar, zzfgn zzfgnVar, boolean z, zzbma zzbmaVar, zzegj zzegjVar, zzdvi zzdviVar) {
        this.zza = versionInfoParcel;
        this.zzb = listenableFuture;
        this.zzc = zzffuVar;
        this.zzd = zzcgyVar;
        this.zze = zzfgnVar;
        this.zzg = z;
        this.zzf = zzbmaVar;
        this.zzh = zzegjVar;
        this.zzi = zzdviVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0075  */
    @Override // com.google.android.gms.internal.ads.zzdjl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(boolean r27, android.content.Context r28, com.google.android.gms.internal.ads.zzczb r29) {
        /*
            r26 = this;
            r0 = r26
            com.google.common.util.concurrent.ListenableFuture r1 = r0.zzb
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzgui.zzt(r1)
            com.google.android.gms.internal.ads.zzcqr r1 = (com.google.android.gms.internal.ads.zzcqr) r1
            com.google.android.gms.internal.ads.zzcgy r6 = r0.zzd
            r15 = 1
            r6.zzag(r15)
            com.google.android.gms.ads.internal.zzl r10 = new com.google.android.gms.ads.internal.zzl
            boolean r2 = r0.zzg
            if (r2 == 0) goto L1f
            com.google.android.gms.internal.ads.zzbma r3 = r0.zzf
            boolean r3 = r3.zzc(r15)
            r17 = r3
            goto L21
        L1f:
            r17 = r15
        L21:
            r3 = 0
            if (r2 == 0) goto L2f
            com.google.android.gms.internal.ads.zzbma r4 = r0.zzf
            boolean r4 = r4.zzd()
            if (r4 == 0) goto L2f
            r19 = r15
            goto L31
        L2f:
            r19 = r3
        L31:
            if (r2 == 0) goto L3a
            com.google.android.gms.internal.ads.zzbma r2 = r0.zzf
            float r2 = r2.zze()
            goto L3b
        L3a:
            r2 = 0
        L3b:
            r20 = r2
            com.google.android.gms.internal.ads.zzffu r2 = r0.zzc
            boolean r3 = r2.zzO
            r24 = 0
            r18 = 1
            r21 = -1
            r16 = r10
            r22 = r27
            r23 = r3
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24)
            if (r29 == 0) goto L55
            r29.zzb()
        L55:
            com.google.android.gms.ads.internal.zzt.zzb()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r14 = new com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
            com.google.android.gms.internal.ads.zzdja r4 = r1.zzj()
            int r1 = r2.zzQ
            r3 = -1
            if (r1 == r3) goto L64
            goto L7c
        L64:
            com.google.android.gms.internal.ads.zzfgn r3 = r0.zze
            com.google.android.gms.ads.internal.client.zzx r3 = r3.zzk
            if (r3 == 0) goto L75
            int r3 = r3.zza
            if (r3 != r15) goto L70
            r1 = 7
            goto L7c
        L70:
            r5 = 2
            if (r3 != r5) goto L75
            r1 = 6
            goto L7c
        L75:
            int r3 = com.google.android.gms.ads.internal.util.zze.zza
            java.lang.String r3 = "Error setting app open orientation; no targeting orientation available."
            com.google.android.gms.ads.internal.util.client.zzo.zzd(r3)
        L7c:
            r7 = r1
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r8 = r0.zza
            java.lang.String r9 = r2.zzB
            com.google.android.gms.internal.ads.zzffz r1 = r2.zzs
            java.lang.String r11 = r1.zzb
            java.lang.String r12 = r1.zza
            com.google.android.gms.internal.ads.zzfgn r1 = r0.zze
            boolean r2 = r2.zzb()
            if (r2 == 0) goto L92
            com.google.android.gms.internal.ads.zzegj r2 = r0.zzh
            goto L93
        L92:
            r2 = 0
        L93:
            r16 = r2
            java.lang.String r13 = r1.zzg
            java.lang.String r1 = r6.zzn()
            r3 = 0
            r5 = 0
            r2 = r14
            r25 = r14
            r14 = r29
            r15 = r16
            r16 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            com.google.android.gms.internal.ads.zzdvi r1 = r0.zzi
            r2 = r28
            r3 = r25
            r4 = 1
            com.google.android.gms.ads.internal.overlay.zzn.zza(r2, r3, r4, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehx.zza(boolean, android.content.Context, com.google.android.gms.internal.ads.zzczb):void");
    }

    @Override // com.google.android.gms.internal.ads.zzdjl
    public final zzffu zzb() {
        return this.zzc;
    }
}
