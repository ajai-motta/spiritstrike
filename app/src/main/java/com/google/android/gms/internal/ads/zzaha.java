package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzao;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaha implements zzao {
    public final float zza;
    public final int zzb;

    public zzaha(float f, int i) {
        this.zza = f;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaha zzahaVar = (zzaha) obj;
            if (this.zza == zzahaVar.zza && this.zzb == zzahaVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToIntBits(this.zza) + 527) * 31) + this.zzb;
    }

    public final String toString() {
        float f = this.zza;
        int length = String.valueOf(f).length();
        int i = this.zzb;
        StringBuilder sb = new StringBuilder(length + 47 + String.valueOf(i).length());
        sb.append("smta: captureFrameRate=");
        sb.append(f);
        sb.append(", svcTemporalLayerCount=");
        sb.append(i);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public /* synthetic */ void zza(zzam zzamVar) {
        zzao.CC.$default$zza(this, zzamVar);
    }
}
