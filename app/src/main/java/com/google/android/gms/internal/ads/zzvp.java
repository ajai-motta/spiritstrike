package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzvp implements zzzj, zzuj {
    final /* synthetic */ zzvy zza;
    private final long zzb;
    private final Uri zzc;
    private final zzgy zzd;
    private final zzvn zze;
    private final zzadd zzf;
    private final zzdf zzg;
    private final zzaea zzh;
    private volatile boolean zzi;
    private boolean zzj;
    private long zzk;
    private zzgf zzl;
    private zzaem zzm;
    private boolean zzn;

    public zzvp(zzvy zzvyVar, Uri uri, zzgb zzgbVar, zzvn zzvnVar, zzadd zzaddVar, zzdf zzdfVar) {
        Objects.requireNonNull(zzvyVar);
        this.zza = zzvyVar;
        this.zzc = uri;
        this.zzd = new zzgy(zzgbVar);
        this.zze = zzvnVar;
        this.zzf = zzaddVar;
        this.zzg = zzdfVar;
        this.zzh = new zzaea();
        this.zzj = true;
        this.zzb = zzul.zza();
        this.zzl = zzi(0L);
    }

    private final zzgf zzi(long j) {
        zzge zzgeVar = new zzge();
        zzgeVar.zza(this.zzc);
        zzgeVar.zzc(j);
        zzgeVar.zzd(6);
        zzgeVar.zzb(zzvy.zzb);
        return zzgeVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzzj
    public final void zzb() {
        this.zzi = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01b0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0222 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[LOOP:0: B:3:0x0002->B:124:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e7 A[EDGE_INSN: B:125:0x01e7->B:86:0x01e7 BREAK  A[LOOP:1: B:74:0x01ae->B:128:0x01ae], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a8 A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:6:0x0009, B:16:0x003a, B:17:0x003f, B:20:0x0058, B:21:0x005e, B:30:0x009d, B:32:0x00a8, B:34:0x00b4, B:36:0x00be, B:38:0x00ca, B:40:0x00d4, B:42:0x00e0, B:44:0x00ea, B:46:0x00fc, B:48:0x0106, B:49:0x010c, B:58:0x0149, B:59:0x0150, B:61:0x015d, B:63:0x0166, B:65:0x0181, B:67:0x0199, B:68:0x019c, B:70:0x01a0, B:52:0x0116, B:55:0x0134, B:25:0x006a, B:28:0x0088), top: B:113:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00be A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:6:0x0009, B:16:0x003a, B:17:0x003f, B:20:0x0058, B:21:0x005e, B:30:0x009d, B:32:0x00a8, B:34:0x00b4, B:36:0x00be, B:38:0x00ca, B:40:0x00d4, B:42:0x00e0, B:44:0x00ea, B:46:0x00fc, B:48:0x0106, B:49:0x010c, B:58:0x0149, B:59:0x0150, B:61:0x015d, B:63:0x0166, B:65:0x0181, B:67:0x0199, B:68:0x019c, B:70:0x01a0, B:52:0x0116, B:55:0x0134, B:25:0x006a, B:28:0x0088), top: B:113:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4 A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:6:0x0009, B:16:0x003a, B:17:0x003f, B:20:0x0058, B:21:0x005e, B:30:0x009d, B:32:0x00a8, B:34:0x00b4, B:36:0x00be, B:38:0x00ca, B:40:0x00d4, B:42:0x00e0, B:44:0x00ea, B:46:0x00fc, B:48:0x0106, B:49:0x010c, B:58:0x0149, B:59:0x0150, B:61:0x015d, B:63:0x0166, B:65:0x0181, B:67:0x0199, B:68:0x019c, B:70:0x01a0, B:52:0x0116, B:55:0x0134, B:25:0x006a, B:28:0x0088), top: B:113:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ea A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:6:0x0009, B:16:0x003a, B:17:0x003f, B:20:0x0058, B:21:0x005e, B:30:0x009d, B:32:0x00a8, B:34:0x00b4, B:36:0x00be, B:38:0x00ca, B:40:0x00d4, B:42:0x00e0, B:44:0x00ea, B:46:0x00fc, B:48:0x0106, B:49:0x010c, B:58:0x0149, B:59:0x0150, B:61:0x015d, B:63:0x0166, B:65:0x0181, B:67:0x0199, B:68:0x019c, B:70:0x01a0, B:52:0x0116, B:55:0x0134, B:25:0x006a, B:28:0x0088), top: B:113:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0106 A[Catch: all -> 0x0204, TRY_LEAVE, TryCatch #3 {all -> 0x0204, blocks: (B:6:0x0009, B:16:0x003a, B:17:0x003f, B:20:0x0058, B:21:0x005e, B:30:0x009d, B:32:0x00a8, B:34:0x00b4, B:36:0x00be, B:38:0x00ca, B:40:0x00d4, B:42:0x00e0, B:44:0x00ea, B:46:0x00fc, B:48:0x0106, B:49:0x010c, B:58:0x0149, B:59:0x0150, B:61:0x015d, B:63:0x0166, B:65:0x0181, B:67:0x0199, B:68:0x019c, B:70:0x01a0, B:52:0x0116, B:55:0x0134, B:25:0x006a, B:28:0x0088), top: B:113:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0149 A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:6:0x0009, B:16:0x003a, B:17:0x003f, B:20:0x0058, B:21:0x005e, B:30:0x009d, B:32:0x00a8, B:34:0x00b4, B:36:0x00be, B:38:0x00ca, B:40:0x00d4, B:42:0x00e0, B:44:0x00ea, B:46:0x00fc, B:48:0x0106, B:49:0x010c, B:58:0x0149, B:59:0x0150, B:61:0x015d, B:63:0x0166, B:65:0x0181, B:67:0x0199, B:68:0x019c, B:70:0x01a0, B:52:0x0116, B:55:0x0134, B:25:0x006a, B:28:0x0088), top: B:113:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015d A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:6:0x0009, B:16:0x003a, B:17:0x003f, B:20:0x0058, B:21:0x005e, B:30:0x009d, B:32:0x00a8, B:34:0x00b4, B:36:0x00be, B:38:0x00ca, B:40:0x00d4, B:42:0x00e0, B:44:0x00ea, B:46:0x00fc, B:48:0x0106, B:49:0x010c, B:58:0x0149, B:59:0x0150, B:61:0x015d, B:63:0x0166, B:65:0x0181, B:67:0x0199, B:68:0x019c, B:70:0x01a0, B:52:0x0116, B:55:0x0134, B:25:0x006a, B:28:0x0088), top: B:113:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0199 A[Catch: all -> 0x0204, TryCatch #3 {all -> 0x0204, blocks: (B:6:0x0009, B:16:0x003a, B:17:0x003f, B:20:0x0058, B:21:0x005e, B:30:0x009d, B:32:0x00a8, B:34:0x00b4, B:36:0x00be, B:38:0x00ca, B:40:0x00d4, B:42:0x00e0, B:44:0x00ea, B:46:0x00fc, B:48:0x0106, B:49:0x010c, B:58:0x0149, B:59:0x0150, B:61:0x015d, B:63:0x0166, B:65:0x0181, B:67:0x0199, B:68:0x019c, B:70:0x01a0, B:52:0x0116, B:55:0x0134, B:25:0x006a, B:28:0x0088), top: B:113:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01a0 A[Catch: all -> 0x0204, TRY_LEAVE, TryCatch #3 {all -> 0x0204, blocks: (B:6:0x0009, B:16:0x003a, B:17:0x003f, B:20:0x0058, B:21:0x005e, B:30:0x009d, B:32:0x00a8, B:34:0x00b4, B:36:0x00be, B:38:0x00ca, B:40:0x00d4, B:42:0x00e0, B:44:0x00ea, B:46:0x00fc, B:48:0x0106, B:49:0x010c, B:58:0x0149, B:59:0x0150, B:61:0x015d, B:63:0x0166, B:65:0x0181, B:67:0x0199, B:68:0x019c, B:70:0x01a0, B:52:0x0116, B:55:0x0134, B:25:0x006a, B:28:0x0088), top: B:113:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01eb  */
    @Override // com.google.android.gms.internal.ads.zzzj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzc() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 547
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvp.zzc():void");
    }

    final /* synthetic */ void zzd(long j, long j2) {
        this.zzh.zza = j;
        this.zzk = j2;
        this.zzj = true;
        this.zzn = false;
    }

    final /* synthetic */ long zze() {
        return this.zzb;
    }

    final /* synthetic */ zzgy zzf() {
        return this.zzd;
    }

    final /* synthetic */ long zzg() {
        return this.zzk;
    }

    final /* synthetic */ zzgf zzh() {
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzuj
    public final void zza(zzeg zzegVar) {
        long jMax = !this.zzn ? this.zzk : Math.max(this.zza.zzI(true), this.zzk);
        int iZzd = zzegVar.zzd();
        zzaem zzaemVar = this.zzm;
        zzaemVar.getClass();
        zzaemVar.zzz(zzegVar, iZzd);
        zzaemVar.zzx(jMax, 1, iZzd, 0, null);
        this.zzn = true;
    }
}
