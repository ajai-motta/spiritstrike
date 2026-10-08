package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzuc extends zztt {
    private final HashMap zza = new HashMap();
    private Handler zzb;
    private zzgz zzc;

    protected zzuc() {
    }

    @Override // com.google.android.gms.internal.ads.zztt
    protected final void zzM() {
        for (zzub zzubVar : this.zza.values()) {
            zzubVar.zza.zzq(zzubVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztt
    protected void zza(zzgz zzgzVar) {
        this.zzc = zzgzVar;
        this.zzb = zzep.zzc(null);
    }

    @Override // com.google.android.gms.internal.ads.zztt
    protected final void zzc() {
        for (zzub zzubVar : this.zza.values()) {
            zzubVar.zza.zzr(zzubVar.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zztt
    protected void zzd() {
        HashMap map = this.zza;
        for (zzub zzubVar : map.values()) {
            zzuw zzuwVar = zzubVar.zza;
            zzuwVar.zzs(zzubVar.zzb);
            zzua zzuaVar = zzubVar.zzc;
            zzuwVar.zzm(zzuaVar);
            zzuwVar.zzo(zzuaVar);
        }
        map.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public void zzt() throws IOException {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((zzub) it.next()).zza.zzt();
        }
    }

    protected abstract void zzu(Object obj, zzuw zzuwVar, zzbf zzbfVar);

    protected final void zzv(final Object obj, zzuw zzuwVar) {
        HashMap map = this.zza;
        zzgmd.zza(!map.containsKey(obj));
        zzuv zzuvVar = new zzuv() { // from class: com.google.android.gms.internal.ads.zztz
            @Override // com.google.android.gms.internal.ads.zzuv
            public final /* synthetic */ void zza(zzuw zzuwVar2, zzbf zzbfVar) {
                this.zza.zzu(obj, zzuwVar2, zzbfVar);
            }
        };
        zzua zzuaVar = new zzua(this, obj);
        map.put(obj, new zzub(zzuwVar, zzuvVar, zzuaVar));
        Handler handler = this.zzb;
        handler.getClass();
        zzuwVar.zzl(handler, zzuaVar);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zzuwVar.zzn(handler2, zzuaVar);
        zzuwVar.zzp(zzuvVar, this.zzc, zzk());
        if (zzj()) {
            return;
        }
        zzuwVar.zzr(zzuvVar);
    }

    protected int zzw(Object obj, int i) {
        return 0;
    }

    protected zzuu zzx(Object obj, zzuu zzuuVar) {
        throw null;
    }

    protected long zzy(Object obj, long j, zzuu zzuuVar) {
        return j;
    }
}
