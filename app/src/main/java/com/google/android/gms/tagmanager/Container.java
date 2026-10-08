package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.gtm.zzrg;
import com.google.android.gms.internal.gtm.zzrk;
import com.google.android.gms.internal.gtm.zzrm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
public class Container {
    private final Context zza;
    private final String zzb;
    private final DataLayer zzc;
    private zzep zzd;
    private Map zze;
    private Map zzf;
    private volatile long zzg;
    private volatile String zzh;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    Container(Context context, DataLayer dataLayer, String str, long j, com.google.android.gms.internal.gtm.zzah zzahVar) {
        this.zze = new HashMap();
        this.zzf = new HashMap();
        this.zzh = "";
        this.zza = context;
        this.zzc = dataLayer;
        this.zzb = str;
        this.zzg = j;
        com.google.android.gms.internal.gtm.zzz zzzVarZzc = zzahVar.zzc();
        zzzVarZzc.getClass();
        try {
            zzg(zzrm.zzb(zzzVarZzc));
        } catch (zzrk e) {
            Log.e("GoogleTagManager", "Not loading resource: " + zzzVarZzc.toString() + " because it is invalid: " + e.toString());
        }
        if (zzahVar.zza() != 0) {
            com.google.android.gms.internal.gtm.zzaf[] zzafVarArr = (com.google.android.gms.internal.gtm.zzaf[]) zzahVar.zzi().toArray(new com.google.android.gms.internal.gtm.zzaf[0]);
            zzep zzepVarZzf = zzf();
            if (zzepVarZzf == null) {
                Log.e("GoogleTagManager", "evaluateTags called for closed container.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.gtm.zzaf zzafVar : zzafVarArr) {
                arrayList.add(zzafVar);
            }
            zzepVarZzf.zze(arrayList);
        }
    }

    private final synchronized zzep zzf() {
        return this.zzd;
    }

    private final void zzg(zzrg zzrgVar) {
        this.zzh = zzrgVar.zzb();
        zzh(new zzep((Context) Preconditions.checkNotNull(this.zza), zzrgVar, (DataLayer) Preconditions.checkNotNull(this.zzc), new zzs(this, null), new zzt(this, null), new zzdg()));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzc.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", Preconditions.checkNotNull(this.zzb)));
        }
    }

    private final synchronized void zzh(zzep zzepVar) {
        this.zzd = zzepVar;
    }

    public boolean getBoolean(String str) {
        zzep zzepVarZzf = zzf();
        if (zzepVarZzf == null) {
            Log.e("GoogleTagManager", "getBoolean called for closed container.");
            zzfp.zze().booleanValue();
            return false;
        }
        try {
            return zzfp.zzf(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) zzepVarZzf.zza(str).zza())).booleanValue();
        } catch (Exception e) {
            Log.e("GoogleTagManager", "Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            zzfp.zze().booleanValue();
            return false;
        }
    }

    public String getContainerId() {
        return this.zzb;
    }

    public double getDouble(String str) {
        zzep zzepVarZzf = zzf();
        if (zzepVarZzf == null) {
            Log.e("GoogleTagManager", "getDouble called for closed container.");
            return zzfp.zzg().doubleValue();
        }
        try {
            return zzfp.zzh(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) zzepVarZzf.zza(str).zza())).doubleValue();
        } catch (Exception e) {
            Log.e("GoogleTagManager", "Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzfp.zzg().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzg;
    }

    public long getLong(String str) {
        zzep zzepVarZzf = zzf();
        if (zzepVarZzf == null) {
            Log.e("GoogleTagManager", "getLong called for closed container.");
            zzfp.zzi().longValue();
            return 0L;
        }
        try {
            return zzfp.zzj(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) zzepVarZzf.zza(str).zza())).longValue();
        } catch (Exception e) {
            Log.e("GoogleTagManager", "Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            zzfp.zzi().longValue();
            return 0L;
        }
    }

    public String getString(String str) {
        zzep zzepVarZzf = zzf();
        if (zzepVarZzf == null) {
            Log.e("GoogleTagManager", "getString called for closed container.");
            return zzfp.zzl();
        }
        try {
            return zzfp.zzm(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) zzepVarZzf.zza(str).zza()));
        } catch (Exception e) {
            Log.e("GoogleTagManager", "Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzfp.zzl();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String str, FunctionCallMacroCallback functionCallMacroCallback) {
        if (functionCallMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zze) {
            this.zze.put(str, functionCallMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String str, FunctionCallTagCallback functionCallTagCallback) {
        if (functionCallTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzf) {
            this.zzf.put(str, functionCallTagCallback);
        }
    }

    public void unregisterFunctionCallMacroCallback(String str) {
        synchronized (this.zze) {
            this.zze.remove(str);
        }
    }

    public void unregisterFunctionCallTagCallback(String str) {
        synchronized (this.zzf) {
            this.zzf.remove(str);
        }
    }

    final FunctionCallMacroCallback zza(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zze) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zze.get(str);
        }
        return functionCallMacroCallback;
    }

    public final FunctionCallTagCallback zzb(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzf) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzf.get(str);
        }
        return functionCallTagCallback;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final void zzd(String str) {
        zzep zzepVarZzf = zzf();
        if (zzepVarZzf == null) {
            Log.e("GoogleTagManager", "evaluateTags called for closed container.");
        } else {
            zzepVarZzf.zzc(str);
        }
    }

    final void zze() {
        this.zzd = null;
    }

    Container(Context context, DataLayer dataLayer, String str, long j, zzrg zzrgVar) {
        this.zze = new HashMap();
        this.zzf = new HashMap();
        this.zzh = "";
        this.zza = context;
        this.zzc = dataLayer;
        this.zzb = str;
        this.zzg = 0L;
        zzg(zzrgVar);
    }
}
