package com.google.android.gms.internal.gtm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzrh {
    private final List zza = new ArrayList();
    private final Map zzb = new HashMap();
    private String zzc = "";
    private int zzd = 0;

    private zzrh() {
    }

    public final zzrg zza() {
        return new zzrg(this.zza, this.zzb, this.zzc, this.zzd, null);
    }

    public final zzrh zzb(zzre zzreVar) {
        String strZzm = com.google.android.gms.tagmanager.zzfp.zzm(com.google.android.gms.tagmanager.zzfp.zzk((zzap) zzreVar.zzc().get(zzb.INSTANCE_NAME.toString())));
        List arrayList = (List) this.zzb.get(strZzm);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.zzb.put(strZzm, arrayList);
        }
        arrayList.add(zzreVar);
        return this;
    }

    public final zzrh zzc(zzri zzriVar) {
        this.zza.add(zzriVar);
        return this;
    }

    public final zzrh zzd(int i) {
        this.zzd = i;
        return this;
    }

    public final zzrh zze(String str) {
        this.zzc = str;
        return this;
    }

    /* synthetic */ zzrh(zzrl zzrlVar) {
    }
}
