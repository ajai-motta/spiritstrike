package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfle implements zzflc {
    private final Context zza;
    private final int zzp;
    private long zzb = 0;
    private long zzc = -1;
    private boolean zzd = false;
    private int zzq = 2;
    private int zzr = 2;
    private int zze = 0;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private zzflr zzj = zzflr.SCAR_REQUEST_TYPE_UNSPECIFIED;
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private boolean zzn = false;
    private boolean zzo = false;

    zzfle(Context context, int i) {
        this.zza = context;
        this.zzp = i;
    }

    final /* synthetic */ long zzA() {
        return this.zzb;
    }

    final /* synthetic */ long zzB() {
        return this.zzc;
    }

    final /* synthetic */ boolean zzC() {
        return this.zzd;
    }

    final /* synthetic */ int zzD() {
        return this.zze;
    }

    final /* synthetic */ String zzE() {
        return this.zzf;
    }

    final /* synthetic */ String zzF() {
        return this.zzg;
    }

    final /* synthetic */ String zzG() {
        return this.zzh;
    }

    final /* synthetic */ String zzH() {
        return this.zzi;
    }

    final /* synthetic */ zzflr zzI() {
        return this.zzj;
    }

    final /* synthetic */ String zzJ() {
        return this.zzk;
    }

    final /* synthetic */ String zzK() {
        return this.zzl;
    }

    final /* synthetic */ String zzL() {
        return this.zzm;
    }

    public final synchronized zzfle zzM(int i) {
        this.zzq = i;
        return this;
    }

    final /* synthetic */ int zzN() {
        return this.zzp;
    }

    final /* synthetic */ int zzO() {
        return this.zzq;
    }

    final /* synthetic */ int zzP() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final /* bridge */ /* synthetic */ zzflc zza() {
        zzq();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final synchronized boolean zzb() {
        return this.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final /* bridge */ /* synthetic */ zzflc zzc() {
        zzr();
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final /* bridge */ /* synthetic */ zzflc zzd(boolean z) {
        zzs(z);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final /* bridge */ /* synthetic */ zzflc zze(String str) {
        zzt(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final /* bridge */ /* synthetic */ zzflc zzf(zzflr zzflrVar) {
        zzu(zzflrVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final /* bridge */ /* synthetic */ zzflc zzg(zzfge zzfgeVar) {
        zzv(zzfgeVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final /* bridge */ /* synthetic */ zzflc zzh(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzw(zzeVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final /* bridge */ /* synthetic */ zzflc zzi(String str) {
        zzx(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final /* bridge */ /* synthetic */ zzflc zzj(Throwable th) {
        zzy(th);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final /* bridge */ /* synthetic */ zzflc zzk(String str) {
        zzz(str);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final boolean zzl() {
        return !TextUtils.isEmpty(this.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final synchronized zzflf zzm() {
        if (this.zzn) {
            return null;
        }
        this.zzn = true;
        if (!this.zzo) {
            zzq();
        }
        if (this.zzc < 0) {
            zzr();
        }
        return new zzflf(this, null);
    }

    @Override // com.google.android.gms.internal.ads.zzflc
    public final /* bridge */ /* synthetic */ zzflc zzp(int i) {
        zzM(i);
        return this;
    }

    public final synchronized zzfle zzq() {
        Configuration configuration;
        com.google.android.gms.ads.internal.util.zzz zzzVarZzf = com.google.android.gms.ads.internal.zzt.zzf();
        Context context = this.zza;
        this.zze = zzzVarZzf.zzm(context);
        Resources resources = context.getResources();
        int i = 2;
        if (resources != null && (configuration = resources.getConfiguration()) != null) {
            i = configuration.orientation == 2 ? 4 : 3;
        }
        this.zzr = i;
        this.zzb = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
        this.zzo = true;
        return this;
    }

    public final synchronized zzfle zzr() {
        this.zzc = com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime();
        return this;
    }

    public final synchronized zzfle zzs(boolean z) {
        this.zzd = z;
        return this;
    }

    public final synchronized zzfle zzt(String str) {
        this.zzi = str;
        return this;
    }

    public final synchronized zzfle zzu(zzflr zzflrVar) {
        this.zzj = zzflrVar;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        r2.zzg = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized com.google.android.gms.internal.ads.zzfle zzv(com.google.android.gms.internal.ads.zzfge r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzffx r0 = r3.zzb     // Catch: java.lang.Throwable -> L2b
            java.lang.String r0 = r0.zzb     // Catch: java.lang.Throwable -> L2b
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L2b
            if (r1 != 0) goto Ld
            r2.zzf = r0     // Catch: java.lang.Throwable -> L2b
        Ld:
            java.util.List r3 = r3.zza     // Catch: java.lang.Throwable -> L2b
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L2b
        L13:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L2b
            if (r0 == 0) goto L29
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L2b
            com.google.android.gms.internal.ads.zzffu r0 = (com.google.android.gms.internal.ads.zzffu) r0     // Catch: java.lang.Throwable -> L2b
            java.lang.String r0 = r0.zzab     // Catch: java.lang.Throwable -> L2b
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L2b
            if (r1 != 0) goto L13
            r2.zzg = r0     // Catch: java.lang.Throwable -> L2b
        L29:
            monitor-exit(r2)
            return r2
        L2b:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfle.zzv(com.google.android.gms.internal.ads.zzfge):com.google.android.gms.internal.ads.zzfle");
    }

    public final synchronized zzfle zzw(com.google.android.gms.ads.internal.client.zze zzeVar) {
        IBinder iBinder = zzeVar.zze;
        if (iBinder != null) {
            zzcyh zzcyhVar = (zzcyh) iBinder;
            String strZzk = zzcyhVar.zzk();
            if (!TextUtils.isEmpty(strZzk)) {
                this.zzf = strZzk;
            }
            String strZzf = zzcyhVar.zzf();
            if (!TextUtils.isEmpty(strZzf)) {
                this.zzg = strZzf;
            }
        }
        return this;
    }

    public final synchronized zzfle zzx(String str) {
        this.zzh = str;
        return this;
    }

    public final synchronized zzfle zzy(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjI)).booleanValue()) {
            this.zzl = zzbwf.zzf(th);
            this.zzk = (String) zzgms.zza(zzglr.zzc('\n')).zzd(zzbwf.zze(th)).iterator().next();
        }
        return this;
    }

    public final synchronized zzfle zzz(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjI)).booleanValue()) {
            this.zzm = str;
        }
        return this;
    }
}
