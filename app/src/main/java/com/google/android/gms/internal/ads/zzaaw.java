package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import com.google.android.exoplayer2.C;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaaw implements zzbt {
    private final Context zza;
    private final zzbs zzb;
    private final SparseArray zzc;
    private final boolean zzd;
    private final zzabx zze;
    private final zzdc zzf;
    private final CopyOnWriteArraySet zzg;
    private final long zzh;
    private final zzabb zzi;
    private zzel zzj = new zzel(10);
    private zzv zzk;
    private zzdm zzl;
    private Pair zzm;
    private int zzn;
    private int zzo;
    private long zzp;
    private long zzq;
    private int zzr;

    /* synthetic */ zzaaw(zzaao zzaaoVar, byte[] bArr) {
        this.zza = zzaaoVar.zze();
        zzbs zzbsVarZzg = zzaaoVar.zzg();
        zzbsVarZzg.getClass();
        this.zzb = zzbsVarZzg;
        this.zzc = new SparseArray();
        zzgpe.zzi();
        this.zzd = zzaaoVar.zzh();
        zzdc zzdcVarZzi = zzaaoVar.zzi();
        this.zzf = zzdcVarZzi;
        this.zzh = zzaaoVar.zzj() != C.TIME_UNSET ? -zzaaoVar.zzj() : -9223372036854775807L;
        zzabb zzabbVarZzk = zzaaoVar.zzk();
        this.zzi = zzabbVarZzk;
        this.zze = new zzaab(zzaaoVar.zzf(), zzabbVarZzk, zzdcVarZzi);
        new zzaan(this);
        this.zzg = new CopyOnWriteArraySet();
        this.zzk = new zzt().zzM();
        this.zzp = C.TIME_UNSET;
        this.zzq = C.TIME_UNSET;
        this.zzr = -1;
        this.zzo = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final zzi zzC(zzi zziVar) {
        return (zziVar == null || !zziVar.zzf()) ? zzi.zza : zziVar;
    }

    final /* synthetic */ void zzA(long j) {
        this.zzq = j;
    }

    public final void zza(int i) {
        this.zzr = 1;
    }

    public final zzabx zzb(int i) {
        SparseArray sparseArray = this.zzc;
        if (zzep.zza(sparseArray, 0)) {
            return (zzabx) sparseArray.get(0);
        }
        zzaaq zzaaqVar = new zzaaq(this, this.zza, 0);
        this.zzg.add(zzaaqVar);
        sparseArray.put(0, zzaaqVar);
        return zzaaqVar;
    }

    public final void zzc(Surface surface, zzeh zzehVar) {
        Pair pair = this.zzm;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((zzeh) this.zzm.second).equals(zzehVar)) {
            return;
        }
        this.zzm = Pair.create(surface, zzehVar);
        zzehVar.zza();
        zzehVar.zzb();
    }

    public final void zzd() {
        zzeh zzehVar = zzeh.zza;
        zzehVar.zza();
        zzehVar.zzb();
        this.zzm = null;
    }

    public final void zze() {
        this.zze.zza();
    }

    public final void zzf() {
        this.zze.zzb();
    }

    public final void zzg() {
        if (this.zzo == 2) {
            return;
        }
        zzdm zzdmVar = this.zzl;
        if (zzdmVar != null) {
            zzdmVar.zzl(null);
        }
        this.zzm = null;
        this.zzo = 2;
    }

    final /* synthetic */ void zzh() {
        this.zzn--;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0060 A[Catch: zzdj -> 0x0095, TRY_LEAVE, TryCatch #0 {zzdj -> 0x0095, blocks: (B:7:0x0012, B:9:0x0017, B:11:0x001d, B:14:0x0024, B:16:0x0032, B:18:0x0038, B:21:0x003f, B:26:0x0060), top: B:36:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ boolean zzi(com.google.android.gms.internal.ads.zzv r11, int r12) throws com.google.android.gms.internal.ads.zzabw {
        /*
            r10 = this;
            int r12 = r10.zzo
            r0 = 1
            r1 = 0
            if (r12 != 0) goto L8
            r12 = r0
            goto L9
        L8:
            r12 = r1
        L9:
            com.google.android.gms.internal.ads.zzgmd.zzh(r12)
            com.google.android.gms.internal.ads.zzi r12 = r11.zzE
            com.google.android.gms.internal.ads.zzi r12 = zzC(r12)
            int r2 = r12.zzd     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            r3 = 7
            if (r2 != r3) goto L32
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            r4 = 34
            if (r2 >= r4) goto L31
            boolean r2 = com.google.android.gms.internal.ads.zzdk.zzd()     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            if (r2 != 0) goto L24
            goto L31
        L24:
            com.google.android.gms.internal.ads.zzh r12 = r12.zzd()     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            r0 = 6
            r12.zzc(r0)     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            com.google.android.gms.internal.ads.zzi r12 = r12.zzg()     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            goto L62
        L31:
            r2 = r3
        L32:
            boolean r3 = com.google.android.gms.internal.ads.zzdk.zzc(r2)     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            if (r3 != 0) goto L59
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            r4 = 29
            if (r3 >= r4) goto L3f
            goto L59
        L3f:
            java.lang.String r12 = "PlaybackVidGraphWrapper"
            java.lang.String r3 = "Color transfer %d is not supported. Falling back to OpenGl tone mapping."
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            r0[r1] = r2     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            java.lang.String r1 = com.google.android.gms.internal.ads.zzep.zza     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            java.util.Locale r1 = java.util.Locale.US     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            java.lang.String r0 = java.lang.String.format(r1, r3, r0)     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            com.google.android.gms.internal.ads.zzdt.zzc(r12, r0)     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            com.google.android.gms.internal.ads.zzi r12 = com.google.android.gms.internal.ads.zzi.zza     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
            goto L62
        L59:
            r0 = 2
            if (r2 == r0) goto L60
            r0 = 10
            if (r2 != r0) goto L62
        L60:
            com.google.android.gms.internal.ads.zzi r12 = com.google.android.gms.internal.ads.zzi.zza     // Catch: com.google.android.gms.internal.ads.zzdj -> L95
        L62:
            r2 = r12
            com.google.android.gms.internal.ads.zzdc r12 = r10.zzf
            android.os.Looper r0 = android.os.Looper.myLooper()
            r0.getClass()
            r1 = r0
            android.os.Looper r1 = (android.os.Looper) r1
            r9 = 0
            com.google.android.gms.internal.ads.zzdm r12 = r12.zzd(r0, r9)
            r10.zzl = r12
            com.google.android.gms.internal.ads.zzbs r0 = r10.zzb     // Catch: com.google.android.gms.internal.ads.zzbo -> L8e
            android.content.Context r1 = r10.zza     // Catch: com.google.android.gms.internal.ads.zzbo -> L8e
            com.google.android.gms.internal.ads.zzl r3 = com.google.android.gms.internal.ads.zzl.zzb     // Catch: com.google.android.gms.internal.ads.zzbo -> L8e
            com.google.android.gms.internal.ads.zzdm r12 = r10.zzl     // Catch: com.google.android.gms.internal.ads.zzbo -> L8e
            java.util.Objects.requireNonNull(r12)     // Catch: com.google.android.gms.internal.ads.zzbo -> L8e
            com.google.android.gms.internal.ads.zzaap r5 = new com.google.android.gms.internal.ads.zzaap     // Catch: com.google.android.gms.internal.ads.zzbo -> L8e
            r5.<init>()     // Catch: com.google.android.gms.internal.ads.zzbo -> L8e
            r6 = 0
            r8 = 0
            r4 = r10
            r0.zza(r1, r2, r3, r4, r5, r6, r8)     // Catch: com.google.android.gms.internal.ads.zzbo -> L8e
            throw r9     // Catch: com.google.android.gms.internal.ads.zzbo -> L8e
        L8e:
            r12 = move-exception
            com.google.android.gms.internal.ads.zzabw r0 = new com.google.android.gms.internal.ads.zzabw
            r0.<init>(r12, r11)
            throw r0
        L95:
            r12 = move-exception
            com.google.android.gms.internal.ads.zzabw r0 = new com.google.android.gms.internal.ads.zzabw
            r0.<init>(r12, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaw.zzi(com.google.android.gms.internal.ads.zzv, int):boolean");
    }

    final /* synthetic */ boolean zzj(boolean z) {
        return this.zze.zzh(false);
    }

    final /* synthetic */ void zzk() {
        this.zze.zzi();
    }

    final /* synthetic */ void zzl(long j, long j2) throws zzabw {
        this.zze.zzv(j, j2);
    }

    final /* synthetic */ void zzm(boolean z) {
        if (this.zzo == 1) {
            this.zzn++;
            zzabx zzabxVar = this.zze;
            zzabxVar.zzg(z);
            while (this.zzj.zzc() > 1) {
                this.zzj.zzd();
            }
            if (this.zzj.zzc() == 1) {
                zzaav zzaavVar = (zzaav) this.zzj.zzd();
                zzaavVar.getClass();
                zzabxVar.zzs(1, this.zzk, zzaavVar.zza, zzaavVar.zzb, zzgpe.zzi());
            }
            this.zzp = C.TIME_UNSET;
            this.zzq = C.TIME_UNSET;
            zzdm zzdmVar = this.zzl;
            zzdmVar.getClass();
            zzdmVar.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzaar
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzh();
                }
            });
        }
    }

    final /* synthetic */ void zzn(boolean z) {
        this.zze.zzw(z);
    }

    final /* synthetic */ void zzo() {
        this.zze.zzt();
    }

    final /* synthetic */ void zzp(zzaax zzaaxVar) {
        this.zze.zzl(zzaaxVar);
    }

    final /* synthetic */ void zzq(float f) {
        this.zzi.zzc(f);
        this.zze.zzm(f);
    }

    final /* synthetic */ void zzr(int i) {
        this.zze.zzr(i);
    }

    final /* synthetic */ boolean zzs() {
        int i = this.zzr;
        return i != -1 && i == 0;
    }

    final /* synthetic */ boolean zzt() {
        return this.zzd;
    }

    final /* synthetic */ long zzu() {
        return this.zzh;
    }

    final /* synthetic */ zzabb zzv() {
        return this.zzi;
    }

    final /* synthetic */ zzel zzw() {
        return this.zzj;
    }

    final /* synthetic */ void zzx(zzel zzelVar) {
        this.zzj = zzelVar;
    }

    final /* synthetic */ long zzy() {
        return this.zzp;
    }

    final /* synthetic */ long zzz() {
        return this.zzq;
    }
}
