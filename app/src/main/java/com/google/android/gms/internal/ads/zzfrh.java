package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfrh extends zzfrd {
    public zzfrh(zzfqw zzfqwVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfqwVar, hashSet, jSONObject, j);
    }

    private final void zzc(String str) {
        zzfps zzfpsVarZza = zzfps.zza();
        if (zzfpsVarZza != null) {
            for (zzfoy zzfoyVar : zzfpsVarZza.zze()) {
                if (this.zza.contains(zzfoyVar.zzh())) {
                    zzfoyVar.zzg().zzi(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfre, android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfre
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
