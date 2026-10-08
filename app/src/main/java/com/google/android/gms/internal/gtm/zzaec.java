package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaec implements Iterator {
    final /* synthetic */ zzaef zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzaec(zzaef zzaefVar, zzaee zzaeeVar) {
        this.zza = zzaefVar;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzc.entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzaef zzaefVar = this.zza;
        if (i >= zzaefVar.zzb) {
            return !zzaefVar.zzc.isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzaef zzaefVar = this.zza;
        return i < zzaefVar.zzb ? (zzaeb) zzaefVar.zza[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        this.zza.zzo();
        int i = this.zzb;
        zzaef zzaefVar = this.zza;
        if (i >= zzaefVar.zzb) {
            zza().remove();
        } else {
            this.zzb = i - 1;
            zzaefVar.zzm(i);
        }
    }
}
