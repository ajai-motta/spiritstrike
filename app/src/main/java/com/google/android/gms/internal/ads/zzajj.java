package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzajj implements zzaeh {
    public final int zza;
    public final zzgsr zzb;

    public zzajj(int i, int[] iArr) {
        this.zza = i;
        this.zzb = iArr != null ? zzgsr.zzb(iArr) : zzgsr.zza();
    }

    public final String toString() {
        zzgsr zzgsrVar = this.zzb;
        ArrayList arrayList = new ArrayList(zzgsrVar.zzc());
        for (int i = 0; i < zzgsrVar.zzc(); i++) {
            arrayList.add(zzep.zzx(zzgsrVar.zzd(i)));
        }
        String strZzx = zzep.zzx(this.zza);
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder(strZzx.length() + 37 + string.length() + 1);
        sb.append("UnsupportedBrands{major=");
        sb.append(strZzx);
        sb.append(", compatible=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }
}
