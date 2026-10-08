package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfdo implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;
    private final zzifq zzc;

    private zzfdo(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
        this.zzc = zzifqVar3;
    }

    public static zzfdo zzc(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3) {
        return new zzfdo(zzifqVar, zzifqVar2, zzifqVar3);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00a5  */
    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzfdm zzb() {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzifq r0 = r8.zza
            java.lang.Object r0 = r0.zzb()
            android.content.Context r0 = (android.content.Context) r0
            com.google.android.gms.internal.ads.zzifq r1 = r8.zzb
            java.lang.Object r1 = r1.zzb()
            com.google.android.gms.internal.ads.zzfhy r1 = (com.google.android.gms.internal.ads.zzfhy) r1
            com.google.android.gms.internal.ads.zzifq r2 = r8.zzc
            java.lang.Object r2 = r2.zzb()
            com.google.android.gms.internal.ads.zzfiq r2 = (com.google.android.gms.internal.ads.zzfiq) r2
            com.google.android.gms.internal.ads.zzbel r3 = com.google.android.gms.internal.ads.zzbeu.zzgQ
            com.google.android.gms.internal.ads.zzbes r4 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L37
            com.google.android.gms.internal.ads.zzcbj r3 = com.google.android.gms.ads.internal.zzt.zzh()
            com.google.android.gms.ads.internal.util.zzg r3 = r3.zzo()
            com.google.android.gms.internal.ads.zzcbe r3 = r3.zzi()
            goto L43
        L37:
            com.google.android.gms.internal.ads.zzcbj r3 = com.google.android.gms.ads.internal.zzt.zzh()
            com.google.android.gms.ads.internal.util.zzg r3 = r3.zzo()
            com.google.android.gms.internal.ads.zzcbe r3 = r3.zzj()
        L43:
            r4 = 0
            if (r3 == 0) goto L4d
            boolean r3 = r3.zzi()
            if (r3 == 0) goto L4d
            r4 = 1
        L4d:
            com.google.android.gms.internal.ads.zzbel r3 = com.google.android.gms.internal.ads.zzbeu.zzhg
            com.google.android.gms.internal.ads.zzbes r5 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r3 = r5.zzd(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 <= 0) goto La5
            com.google.android.gms.internal.ads.zzbel r3 = com.google.android.gms.internal.ads.zzbeu.zzgP
            com.google.android.gms.internal.ads.zzbes r5 = com.google.android.gms.ads.internal.client.zzbd.zzc()
            java.lang.Object r3 = r5.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L73
            if (r4 == 0) goto La5
        L73:
            com.google.android.gms.internal.ads.zzfco r3 = new com.google.android.gms.internal.ads.zzfco
            r3.<init>()
            com.google.android.gms.internal.ads.zzfig r4 = com.google.android.gms.internal.ads.zzfig.AppOpen
            com.google.android.gms.internal.ads.zzfcp r5 = new com.google.android.gms.internal.ads.zzfcp
            r5.<init>(r3)
            com.google.android.gms.internal.ads.zzfip r0 = r2.zza(r4, r0, r1, r5)
            com.google.android.gms.internal.ads.zzfct r7 = new com.google.android.gms.internal.ads.zzfct
            com.google.android.gms.internal.ads.zzfdd r2 = new com.google.android.gms.internal.ads.zzfdd
            com.google.android.gms.internal.ads.zzfdc r1 = new com.google.android.gms.internal.ads.zzfdc
            r1.<init>()
            r2.<init>(r1)
            com.google.android.gms.internal.ads.zzfic r1 = r0.zza
            com.google.android.gms.internal.ads.zzfcz r3 = new com.google.android.gms.internal.ads.zzfcz
            com.google.android.gms.internal.ads.zzgus r6 = com.google.android.gms.internal.ads.zzcbv.zza
            r3.<init>(r1, r6)
            com.google.android.gms.internal.ads.zzfiy r4 = r0.zzb
            com.google.android.gms.internal.ads.zzfij r0 = r1.zze()
            java.lang.String r5 = r0.zzf
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            goto Laa
        La5:
            com.google.android.gms.internal.ads.zzfdc r7 = new com.google.android.gms.internal.ads.zzfdc
            r7.<init>()
        Laa:
            com.google.android.gms.internal.ads.zzfdm r7 = (com.google.android.gms.internal.ads.zzfdm) r7
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdo.zzb():com.google.android.gms.internal.ads.zzfdm");
    }
}
