package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcfk extends zzcfe implements zzgz {
    private static final AtomicInteger zzo = new AtomicInteger(0);
    private String zzd;
    private final zzcdq zze;
    private boolean zzf;
    private final zzcfj zzg;
    private final zzcen zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk;
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzcfk(zzcdr zzcdrVar, zzcdq zzcdqVar) {
        super(zzcdrVar);
        this.zze = zzcdqVar;
        this.zzg = new zzcfj();
        this.zzh = new zzcen();
        this.zzk = new Object();
        this.zzl = (String) zzgmb.zzd(zzcdrVar != null ? zzcdrVar.zzn() : null).zza("");
        this.zzm = zzcdrVar != null ? zzcdrVar.zzp() : 0;
        zzo.incrementAndGet();
    }

    public static int zzr() {
        return zzo.get();
    }

    protected static final String zzv(String str) {
        String strZzf = com.google.android.gms.ads.internal.util.client.zzf.zzf(str);
        String.valueOf(strZzf);
        return "cache:".concat(String.valueOf(strZzf));
    }

    private final void zzx() {
        int iZza = (int) this.zzg.zza();
        int iZza2 = (int) this.zzh.zza(this.zzi);
        int iPosition = this.zzi.position();
        int iRound = Math.round(iZza2 * (iPosition / iZza));
        int iZzP = zzcdi.zzP();
        int iZzQ = zzcdi.zzQ();
        String str = this.zzd;
        zzn(str, zzv(str), iPosition, iZza, iRound, iZza2, iRound > 0, iZzP, iZzQ);
    }

    @Override // com.google.android.gms.internal.ads.zzcfe, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzo.decrementAndGet();
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final void zza(zzgb zzgbVar, zzgf zzgfVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final void zzb(zzgb zzgbVar, zzgf zzgfVar, boolean z) {
        if (zzgbVar instanceof zzgm) {
            this.zzg.zzb((zzgm) zzgbVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final void zzc(zzgb zzgbVar, zzgf zzgfVar, boolean z, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzgz
    public final void zzd(zzgb zzgbVar, zzgf zzgfVar, boolean z) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00bb, code lost:
    
        r30.zzn = true;
        zzp(r31, r4, (int) r30.zzh.zza(r30.zzi));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ee, code lost:
    
        return true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:? -> B:48:0x0165). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzcfe
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zze(java.lang.String r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcfk.zze(java.lang.String):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzcfe
    public final void zzl() {
        this.zzf = true;
    }

    public final String zzs() {
        return this.zzd;
    }

    public final boolean zzt() {
        return this.zzn;
    }

    public final ByteBuffer zzu() {
        synchronized (this.zzk) {
            ByteBuffer byteBuffer = this.zzi;
            if (byteBuffer != null && !this.zzj) {
                byteBuffer.flip();
                this.zzj = true;
            }
            this.zzf = true;
        }
        return this.zzi;
    }
}
