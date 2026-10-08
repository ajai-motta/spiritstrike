package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfa extends zzet {
    private static final Object zza = new Object();
    private static zzfa zzb;
    private Context zzc;
    private zzby zzd;
    private zzew zzh;
    private zzdf zzi;
    private volatile zzbx zzk;
    private boolean zze = true;
    private boolean zzf = false;
    private boolean zzg = true;
    private final zzeu zzl = new zzeu(this);
    private boolean zzj = false;

    private zzfa() {
    }

    public static zzfa zzg() {
        if (zzb == null) {
            zzb = new zzfa();
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzm() {
        return this.zzj || !this.zzg;
    }

    @Override // com.google.android.gms.tagmanager.zzet
    public final synchronized void zza() {
        if (this.zzf) {
            this.zzk.zze(new zzev(this));
        } else {
            zzdc.zzb.zzd("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zze = true;
        }
    }

    @Override // com.google.android.gms.tagmanager.zzet
    public final synchronized void zzb() {
        if (zzm()) {
            return;
        }
        this.zzh.zzb();
    }

    @Override // com.google.android.gms.tagmanager.zzet
    public final synchronized void zzc(boolean z) {
        zzi(this.zzj, z);
    }

    final synchronized zzby zzf() {
        if (this.zzd == null) {
            if (this.zzc == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzd = new zzdr(this.zzl, this.zzc);
        }
        if (this.zzh == null) {
            zzey zzeyVar = new zzey(this, null);
            this.zzh = zzeyVar;
            zzeyVar.zzc(1800000L);
        }
        this.zzf = true;
        if (this.zze) {
            zza();
            this.zze = false;
        }
        if (this.zzi == null) {
            zzdf zzdfVar = new zzdf(this);
            this.zzi = zzdfVar;
            Context context = this.zzc;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(zzdfVar, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
            intentFilter2.addCategory(context.getPackageName());
            context.registerReceiver(zzdfVar, intentFilter2);
        }
        return this.zzd;
    }

    final synchronized void zzi(boolean z, boolean z2) {
        boolean zZzm = zzm();
        this.zzj = z;
        this.zzg = z2;
        if (zzm() == zZzm) {
            return;
        }
        if (zzm()) {
            this.zzh.zza();
            zzdc.zzb.zzd("PowerSaveMode initiated.");
        } else {
            this.zzh.zzc(1800000L);
            zzdc.zzb.zzd("PowerSaveMode terminated.");
        }
    }

    final synchronized void zzl(Context context, zzbx zzbxVar) {
        if (this.zzc == null) {
            this.zzc = context.getApplicationContext();
            if (this.zzk == null) {
                this.zzk = zzbxVar;
            }
        }
    }
}
