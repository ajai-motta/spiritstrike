package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhxp implements zzhxx {
    private final zzhxx[] zza;

    zzhxp(zzhxx... zzhxxVarArr) {
        this.zza = zzhxxVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzhxx
    public final boolean zzb(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.zza[i].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzhxx
    public final zzhxw zzc(Class cls) {
        for (int i = 0; i < 2; i++) {
            zzhxx zzhxxVar = this.zza[i];
            if (zzhxxVar.zzb(cls)) {
                return zzhxxVar.zzc(cls);
            }
        }
        String name = cls.getName();
        String.valueOf(name);
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(name)));
    }
}
