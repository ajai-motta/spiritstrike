package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.internal.gtm.zzbu;
import com.google.android.gms.internal.gtm.zzeh;
import com.google.android.gms.internal.gtm.zzen;
import com.google.android.gms.internal.gtm.zzfd;
import com.google.android.gms.internal.gtm.zzfe;
import com.google.android.gms.internal.gtm.zzfg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class GoogleAnalytics extends zza {
    private static List zzb = new ArrayList();
    private boolean zzc;
    private final Set zzd;
    private boolean zze;
    private boolean zzf;
    private volatile boolean zzg;
    private boolean zzh;

    public GoogleAnalytics(zzbu zzbuVar) {
        super(zzbuVar);
        this.zzd = new HashSet();
    }

    public static GoogleAnalytics getInstance(Context context) {
        return zzbu.zzg(context).zzc();
    }

    public static void zzf() {
        synchronized (GoogleAnalytics.class) {
            List list = zzb;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                zzb = null;
            }
        }
    }

    public void dispatchLocalHits() {
        zzb().zzf().zzc();
    }

    public void enableAutoActivityReports(Application application) {
        if (this.zze) {
            return;
        }
        application.registerActivityLifecycleCallbacks(new zze(this));
        this.zze = true;
    }

    public boolean getAppOptOut() {
        return this.zzg;
    }

    @Deprecated
    public Logger getLogger() {
        return zzen.zza();
    }

    public boolean isDryRunEnabled() {
        return this.zzf;
    }

    public Tracker newTracker(int i) {
        Tracker tracker;
        zzfe zzfeVar;
        synchronized (this) {
            tracker = new Tracker(zzb(), null, null);
            if (i > 0 && (zzfeVar = (zzfe) new zzfd(zzb()).zza(i)) != null) {
                tracker.zzm(zzfeVar);
            }
            tracker.zzW();
        }
        return tracker;
    }

    public void reportActivityStart(Activity activity) {
        if (this.zze) {
            return;
        }
        zzh(activity);
    }

    public void reportActivityStop(Activity activity) {
        if (this.zze) {
            return;
        }
        zzi(activity);
    }

    public void setAppOptOut(boolean z) {
        this.zzg = z;
        if (this.zzg) {
            zzb().zzf().zzg();
        }
    }

    public void setDryRun(boolean z) {
        this.zzf = z;
    }

    public void setLocalDispatchPeriod(int i) {
        zzb().zzf().zzl(i);
    }

    @Deprecated
    public void setLogger(Logger logger) {
        zzen.zzc(logger);
        if (this.zzh) {
            return;
        }
        Log.i((String) zzeh.zzb.zzb(), "GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + ((String) zzeh.zzb.zzb()) + " DEBUG");
        this.zzh = true;
    }

    public final void zzg() {
        zzfg zzfgVarZzq = zzb().zzq();
        zzfgVarZzq.zzf();
        if (zzfgVarZzq.zze()) {
            setDryRun(zzfgVarZzq.zzc());
        }
        zzfgVarZzq.zzf();
        this.zzc = true;
    }

    final void zzh(Activity activity) {
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            ((zzv) it.next()).zza(activity);
        }
    }

    final void zzi(Activity activity) {
        Iterator it = this.zzd.iterator();
        while (it.hasNext()) {
            ((zzv) it.next()).zzb(activity);
        }
    }

    public final boolean zzj() {
        return this.zzc;
    }

    final void zzk(zzv zzvVar) {
        this.zzd.add(zzvVar);
        Context contextZza = zzb().zza();
        if (contextZza instanceof Application) {
            enableAutoActivityReports((Application) contextZza);
        }
    }

    final void zzl(zzv zzvVar) {
        this.zzd.remove(zzvVar);
    }

    public Tracker newTracker(String str) {
        Tracker tracker;
        synchronized (this) {
            tracker = new Tracker(zzb(), str, null);
            tracker.zzW();
        }
        return tracker;
    }
}
