package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzpd {
    public static final zzpd zza;
    public final int zzb;
    public final int zzc;
    private final zzgpo zzd;

    static {
        zzpd zzpdVar;
        if (Build.VERSION.SDK_INT >= 33) {
            zzgpn zzgpnVar = new zzgpn();
            for (int i = 1; i <= 10; i++) {
                zzgpnVar.zzf(Integer.valueOf(zzep.zzB(i)));
            }
            zzpdVar = new zzpd(2, zzgpnVar.zzi());
        } else {
            zzpdVar = new zzpd(2, 10);
        }
        zza = zzpdVar;
    }

    public zzpd(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = null;
    }

    public zzpd(int i, Set set) {
        this.zzb = i;
        zzgpo zzgpoVarZzo = zzgpo.zzo(set);
        this.zzd = zzgpoVarZzo;
        zzgrs it = zzgpoVarZzo.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.zzc = iMax;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzpd)) {
            return false;
        }
        zzpd zzpdVar = (zzpd) obj;
        return this.zzb == zzpdVar.zzb && this.zzc == zzpdVar.zzc && Objects.equals(this.zzd, zzpdVar.zzd);
    }

    public final int hashCode() {
        zzgpo zzgpoVar = this.zzd;
        return (((this.zzb * 31) + this.zzc) * 31) + (zzgpoVar == null ? 0 : zzgpoVar.hashCode());
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int i = this.zzb;
        int length = String.valueOf(i).length();
        int i2 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 38 + String.valueOf(i2).length() + 15 + String.valueOf(strValueOf).length() + 1);
        sb.append("AudioProfile[format=");
        sb.append(i);
        sb.append(", maxChannelCount=");
        sb.append(i2);
        sb.append(", channelMasks=");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    public final boolean zza(int i) {
        zzgpo zzgpoVar = this.zzd;
        if (zzgpoVar == null) {
            return i <= this.zzc;
        }
        int iZzB = zzep.zzB(i);
        if (iZzB == 0) {
            return false;
        }
        return zzgpoVar.contains(Integer.valueOf(iZzB));
    }

    public final int zzb(int i, zzd zzdVar) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (Build.VERSION.SDK_INT < 29) {
            Integer num = (Integer) zzpe.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
            num.getClass();
            return num.intValue();
        }
        int i2 = this.zzb;
        for (int i3 = 10; i3 > 0; i3--) {
            int iZzB = zzep.zzB(i3);
            if (iZzB != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i2).setSampleRate(i).setChannelMask(iZzB).build(), zzdVar.zza())) {
                return i3;
            }
        }
        return 0;
    }
}
