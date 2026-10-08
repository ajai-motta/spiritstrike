package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@ParametersAreNonnullByDefault
public final class zzbbl {
    int zza;
    private final Object zzb = new Object();
    private final List zzc = new LinkedList();

    public final boolean zza(zzbbk zzbbkVar) {
        synchronized (this.zzb) {
            return this.zzc.contains(zzbbkVar);
        }
    }

    public final boolean zzb(zzbbk zzbbkVar) {
        synchronized (this.zzb) {
            Iterator it = this.zzc.iterator();
            while (it.hasNext()) {
                zzbbk zzbbkVar2 = (zzbbk) it.next();
                if (com.google.android.gms.ads.internal.zzt.zzh().zzo().zzc()) {
                    if (!com.google.android.gms.ads.internal.zzt.zzh().zzo().zze() && !zzbbkVar.equals(zzbbkVar2) && zzbbkVar2.zzc().equals(zzbbkVar.zzc())) {
                        it.remove();
                        return true;
                    }
                } else if (!zzbbkVar.equals(zzbbkVar2) && zzbbkVar2.zzb().equals(zzbbkVar.zzb())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzbbk zzbbkVar) {
        synchronized (this.zzb) {
            List list = this.zzc;
            if (list.size() >= 10) {
                int size = list.size();
                StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 30);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                String string = sb.toString();
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzd(string);
                list.remove(0);
            }
            int i2 = this.zza;
            this.zza = i2 + 1;
            zzbbkVar.zzk(i2);
            zzbbkVar.zzh();
            list.add(zzbbkVar);
        }
    }
}
