package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhyw implements Iterator {
    final /* synthetic */ zzhyy zza;
    private int zzb;
    private boolean zzc;
    private Iterator zzd;

    /* synthetic */ zzhyw(zzhyy zzhyyVar, byte[] bArr) {
        Objects.requireNonNull(zzhyyVar);
        this.zza = zzhyyVar;
        this.zzb = -1;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = this.zza.zzk().entrySet().iterator();
        }
        return this.zzd;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb + 1;
        zzhyy zzhyyVar = this.zza;
        if (i >= zzhyyVar.zzj()) {
            return !zzhyyVar.zzk().isEmpty() && zza().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        zzhyy zzhyyVar = this.zza;
        return i < zzhyyVar.zzj() ? (zzhyv) zzhyyVar.zzi()[i] : (Map.Entry) zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzhyy zzhyyVar = this.zza;
        zzhyyVar.zzh();
        int i = this.zzb;
        if (i >= zzhyyVar.zzj()) {
            zza().remove();
        } else {
            this.zzb = i - 1;
            zzhyyVar.zzg(i);
        }
    }
}
