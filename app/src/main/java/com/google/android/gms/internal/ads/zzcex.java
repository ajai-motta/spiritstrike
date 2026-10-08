package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcex implements Iterable {
    private final List zza = new ArrayList();

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    public final boolean zza(zzcdr zzcdrVar) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcew zzcewVar = (zzcew) it.next();
            if (zzcewVar.zza == zzcdrVar) {
                arrayList.add(zzcewVar);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((zzcew) it2.next()).zzb.zzl();
        }
        return true;
    }

    final zzcew zzb(zzcdr zzcdrVar) {
        Iterator it = iterator();
        while (it.hasNext()) {
            zzcew zzcewVar = (zzcew) it.next();
            if (zzcewVar.zza == zzcdrVar) {
                return zzcewVar;
            }
        }
        return null;
    }

    public final void zzc(zzcew zzcewVar) {
        this.zza.add(zzcewVar);
    }

    public final void zzd(zzcew zzcewVar) {
        this.zza.remove(zzcewVar);
    }
}
