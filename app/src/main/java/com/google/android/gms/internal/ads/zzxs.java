package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzxs extends zzbk {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private final SparseArray zzh;
    private final SparseBooleanArray zzi;

    public zzxs() {
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
    }

    final /* synthetic */ boolean zzA() {
        return this.zzb;
    }

    final /* synthetic */ boolean zzB() {
        return this.zzc;
    }

    final /* synthetic */ boolean zzC() {
        return this.zzd;
    }

    final /* synthetic */ boolean zzD() {
        return this.zze;
    }

    final /* synthetic */ boolean zzE() {
        return this.zzf;
    }

    final /* synthetic */ boolean zzF() {
        return this.zzg;
    }

    final /* synthetic */ SparseArray zzG() {
        return this.zzh;
    }

    final /* synthetic */ SparseBooleanArray zzH() {
        return this.zzi;
    }

    protected final zzxs zzx(zzbl zzblVar) {
        super.zza(zzblVar);
        return this;
    }

    public final zzxs zzy(int i, boolean z) {
        SparseBooleanArray sparseBooleanArray = this.zzi;
        if (sparseBooleanArray.get(i) != z) {
            if (z) {
                sparseBooleanArray.put(i, true);
            } else {
                sparseBooleanArray.delete(i);
            }
        }
        return this;
    }

    final /* synthetic */ boolean zzz() {
        return this.zza;
    }

    /* synthetic */ zzxs(zzxt zzxtVar, byte[] bArr) {
        super(zzxtVar);
        this.zza = zzxtVar.zzK;
        this.zzb = zzxtVar.zzM;
        this.zzc = zzxtVar.zzO;
        this.zzd = zzxtVar.zzT;
        this.zze = zzxtVar.zzU;
        this.zzf = zzxtVar.zzV;
        this.zzg = zzxtVar.zzX;
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        while (true) {
            SparseArray sparseArrayZze = zzxtVar.zze();
            if (i < sparseArrayZze.size()) {
                sparseArray.put(sparseArrayZze.keyAt(i), new HashMap((Map) sparseArrayZze.valueAt(i)));
                i++;
            } else {
                this.zzh = sparseArray;
                this.zzi = zzxtVar.zzf().clone();
                return;
            }
        }
    }
}
