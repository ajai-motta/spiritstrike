package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
public class TagManager {
    private static TagManager zza;
    private final Context zzb;
    private final DataLayer zzc;
    private final zzet zzd;
    private final ConcurrentMap zze;
    private final zzak zzf;

    TagManager(Context context, zzfj zzfjVar, DataLayer dataLayer, zzet zzetVar) {
        Context applicationContext = context.getApplicationContext();
        this.zzb = applicationContext;
        this.zzd = zzetVar;
        this.zze = new ConcurrentHashMap();
        this.zzc = dataLayer;
        dataLayer.zzg(new zzfg(this));
        dataLayer.zzg(new zzg(applicationContext));
        this.zzf = new zzak();
        Preconditions.checkNotNull(applicationContext);
        applicationContext.registerComponentCallbacks(new zzfi(this));
        Preconditions.checkNotNull(applicationContext);
        zzd.zzb(applicationContext);
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zza == null) {
                if (context == null) {
                    Log.e("GoogleTagManager", "TagManager.getInstance requires non-null context.");
                    throw null;
                }
                zza = new TagManager(context, new zzfh(), new DataLayer(new zzaz(context)), zzfa.zzg());
            }
            tagManager = zza;
        }
        return tagManager;
    }

    static /* bridge */ /* synthetic */ void zzb(TagManager tagManager, String str) {
        Preconditions.checkNotNull(tagManager.zze);
        Iterator it = tagManager.zze.values().iterator();
        while (it.hasNext()) {
            ((zzx) it.next()).zzd(str);
        }
    }

    public void dispatch() {
        this.zzd.zza();
    }

    public DataLayer getDataLayer() {
        return this.zzc;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i) {
        zzag zzagVar = new zzag(this.zzb, this, null, str, i, this.zzf);
        zzagVar.zzl();
        return zzagVar;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i) {
        zzag zzagVar = new zzag(this.zzb, this, null, str, i, this.zzf);
        zzagVar.zzm();
        return zzagVar;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i) {
        zzag zzagVar = new zzag(this.zzb, this, null, str, i, this.zzf);
        zzagVar.zzn();
        return zzagVar;
    }

    public void setVerboseLoggingEnabled(boolean z) {
        int i = true != z ? 5 : 2;
        zzdc.zza = i;
        zzdc.zzb.zzc(i);
    }

    public final int zza(zzx zzxVar) {
        this.zze.put(zzxVar.zza(), zzxVar);
        return this.zze.size();
    }

    public final boolean zzc(zzx zzxVar) {
        return this.zze.remove(zzxVar.zza()) != null;
    }

    final synchronized boolean zzd(Uri uri) {
        zzdv zzdvVarZza = zzdv.zza();
        if (!zzdvVarZza.zzd(uri)) {
            return false;
        }
        String strZzc = zzdvVarZza.zzc();
        int iZze = zzdvVarZza.zze();
        int i = iZze - 1;
        if (iZze == 0) {
            throw null;
        }
        if (i == 0) {
            zzx zzxVar = (zzx) this.zze.get(strZzc);
            if (zzxVar != null) {
                zzxVar.zze(null);
                zzxVar.refresh();
            }
        } else if (i == 1 || i == 2) {
            for (String str : this.zze.keySet()) {
                zzx zzxVar2 = (zzx) this.zze.get(str);
                if (str.equals(strZzc)) {
                    zzxVar2.zze(zzdvVarZza.zzb());
                    zzxVar2.refresh();
                } else if (zzxVar2.zzb() != null) {
                    zzxVar2.zze(null);
                    zzxVar2.refresh();
                }
            }
        }
        return true;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String str, int i, Handler handler) {
        zzag zzagVar = new zzag(this.zzb, this, handler.getLooper(), str, i, this.zzf);
        zzagVar.zzl();
        return zzagVar;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String str, int i, Handler handler) {
        zzag zzagVar = new zzag(this.zzb, this, handler.getLooper(), str, i, this.zzf);
        zzagVar.zzm();
        return zzagVar;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String str, int i, Handler handler) {
        zzag zzagVar = new zzag(this.zzb, this, handler.getLooper(), str, i, this.zzf);
        zzagVar.zzn();
        return zzagVar;
    }
}
