package com.google.android.gms.internal.ads;

import android.os.AsyncTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzfre extends AsyncTask {
    private zzfrf zza;
    protected final zzfqw zzd;

    public zzfre(zzfqw zzfqwVar) {
        this.zzd = zzfqwVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        zzfrf zzfrfVar = this.zza;
        if (zzfrfVar != null) {
            zzfrfVar.zzb(this);
        }
    }

    public final void zzb(zzfrf zzfrfVar) {
        this.zza = zzfrfVar;
    }
}
