package com.google.android.gms.tagmanager;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Looper;
import android.util.Log;
import androidx.work.PeriodicWorkRequest;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.gtm.zzfx;
import com.google.android.gms.internal.gtm.zzrb;
import com.google.android.gms.internal.gtm.zzrc;
import com.google.android.gms.internal.gtm.zzrg;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzag extends BasePendingResult {
    private final Clock zza;
    private final zzac zzb;
    private final Looper zzc;
    private final zzdx zzd;
    private final int zze;
    private final Context zzf;
    private final TagManager zzg;
    private final String zzh;
    private final zzah zzi;
    private zzae zzj;
    private volatile zzx zzk;
    private volatile boolean zzl;
    private com.google.android.gms.internal.gtm.zzah zzm;
    private long zzn;
    private String zzo;
    private zzad zzp;
    private zzz zzq;

    public zzag(Context context, TagManager tagManager, Looper looper, String str, int i, zzak zzakVar) {
        zzeh zzehVar = new zzeh(context, str);
        zzee zzeeVar = new zzee(context, str, zzakVar, null, null);
        new HashMap();
        zzfx.zza().zza(2);
        DefaultClock.getInstance();
        new HashMap();
        Clock defaultClock = DefaultClock.getInstance();
        zzda zzdaVar = new zzda(1, 5, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS, 5000L, "refreshing", DefaultClock.getInstance());
        zzah zzahVar = new zzah(context, str);
        super(looper == null ? Looper.getMainLooper() : looper);
        this.zzf = context;
        this.zzg = tagManager;
        this.zzc = looper == null ? Looper.getMainLooper() : looper;
        this.zzh = str;
        this.zze = i;
        this.zzj = zzehVar;
        this.zzp = zzeeVar;
        this.zzb = new zzac(this, null);
        this.zzm = com.google.android.gms.internal.gtm.zzah.zzf();
        this.zza = defaultClock;
        this.zzd = zzdaVar;
        this.zzi = zzahVar;
        if (zzv()) {
            zzo(zzdv.zza().zzb());
        }
        zzakVar.zza();
    }

    static /* bridge */ /* synthetic */ boolean zzp(zzag zzagVar) {
        boolean z = zzagVar.zzl;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzr(long j) {
        zzad zzadVar = this.zzp;
        if (zzadVar == null) {
            Log.w("GoogleTagManager", "Refresh requested, but no network load scheduler.");
        } else {
            zzadVar.zza(j, this.zzm.zzh());
        }
    }

    private final void zzs(boolean z) {
        zzaf zzafVar = null;
        this.zzj.zzd(new zzaa(this, zzafVar));
        this.zzp.zzc(new zzab(this, zzafVar));
        zzrg zzrgVarZza = this.zzj.zza(this.zze);
        if (zzrgVarZza != null) {
            TagManager tagManager = this.zzg;
            this.zzk = new zzx(tagManager, this.zzc, new Container(this.zzf, tagManager.getDataLayer(), this.zzh, 0L, zzrgVarZza), this.zzb);
        }
        this.zzq = new zzz(this, z);
        if (zzv()) {
            this.zzp.zza(0L, "");
        } else {
            this.zzj.zzb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzt(com.google.android.gms.internal.gtm.zzah zzahVar) {
        if (this.zzj != null) {
            zzrb zzrbVarZze = zzrc.zze();
            zzrbVarZze.zzc(0L);
            zzrbVarZze.zza(com.google.android.gms.internal.gtm.zzz.zzk());
            zzrbVarZze.zzc(this.zzn);
            zzrbVarZze.zza(com.google.android.gms.internal.gtm.zzz.zzk());
            zzrbVarZze.zzb(zzahVar);
            this.zzj.zzc((zzrc) zzrbVarZze.zzD());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void zzu(com.google.android.gms.internal.gtm.zzah zzahVar, long j, boolean z) {
        if (!isReady() || this.zzk != null) {
            this.zzm = zzahVar;
            this.zzn = j;
            long jZza = this.zzi.zza();
            zzr(Math.max(0L, Math.min(jZza, (this.zzn + jZza) - this.zza.currentTimeMillis())));
            Context context = this.zzf;
            TagManager tagManager = this.zzg;
            Container container = new Container(context, tagManager.getDataLayer(), this.zzh, j, zzahVar);
            if (this.zzk == null) {
                this.zzk = new zzx(this.zzg, this.zzc, container, this.zzb);
            } else {
                this.zzk.zzc(container);
            }
            if (!isReady() && this.zzq.zza(container)) {
                setResult(this.zzk);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzv() {
        zzdv zzdvVarZza = zzdv.zza();
        return (zzdvVarZza.zze() == 2 || zzdvVarZza.zze() == 3) && this.zzh.equals(zzdvVarZza.zzc());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final ContainerHolder createFailedResult(Status status) {
        if (this.zzk != null) {
            return this.zzk;
        }
        if (status == Status.RESULT_TIMEOUT) {
            Log.e("GoogleTagManager", "timer expired: setting result to failure");
        }
        return new zzx(status);
    }

    final synchronized String zzh() {
        return this.zzo;
    }

    public final void zzl() {
        zzrg zzrgVarZza = this.zzj.zza(this.zze);
        if (zzrgVarZza != null) {
            Context context = this.zzf;
            TagManager tagManager = this.zzg;
            setResult(new zzx(this.zzg, this.zzc, new Container(context, tagManager.getDataLayer(), this.zzh, 0L, zzrgVarZza), new zzy(this)));
        } else {
            Log.e("GoogleTagManager", "Default was requested, but no default container was found");
            setResult(createFailedResult(new Status(10, "Default was requested, but no default container was found", (PendingIntent) null)));
        }
        this.zzp = null;
        this.zzj = null;
    }

    public final void zzm() {
        zzs(true);
    }

    public final void zzn() {
        zzs(false);
    }

    final synchronized void zzo(String str) {
        this.zzo = str;
        zzad zzadVar = this.zzp;
        if (zzadVar != null) {
            zzadVar.zzb(str);
        }
    }
}
