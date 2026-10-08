package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzyq {
    public static final zzyq zzc = new zzym();
    public static final zzyq zzd = new zzym();

    protected zzyq() {
    }

    static zzyq zzc(zzyq zzyqVar, zzyq zzyqVar2) {
        zzyq zzyqVar3;
        zzyq zzyqVar4;
        return zzyqVar == null ? zzyqVar2 : (zzyqVar2 == null || zzyqVar == (zzyqVar3 = zzc) || zzyqVar2 == (zzyqVar4 = zzd)) ? zzyqVar : (zzyqVar2 == zzyqVar3 || zzyqVar == zzyqVar4) ? zzyqVar2 : new zzyn(zzyqVar, zzyqVar2);
    }

    protected abstract void zzb();
}
