package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzvi implements zzus, zzur {
    private final zzus[] zza;
    private final boolean[] zzb;
    private zzur zzf;
    private zzwv zzg;
    private final ArrayList zzd = new ArrayList();
    private final HashMap zze = new HashMap();
    private zzwm zzi = new zzue(zzgpe.zzi(), zzgpe.zzi());
    private final IdentityHashMap zzc = new IdentityHashMap();
    private zzus[] zzh = new zzus[0];

    public zzvi(zzuf zzufVar, long[] jArr, zzus... zzusVarArr) {
        this.zza = zzusVarArr;
        this.zzb = new boolean[zzusVarArr.length];
        for (int i = 0; i < zzusVarArr.length; i++) {
            long j = jArr[i];
            if (j != 0) {
                this.zzb[i] = true;
                this.zza[i] = new zzws(zzusVarArr[i], j);
            }
        }
    }

    public final zzus zza(int i) {
        return this.zzb[i] ? ((zzws) this.zza[i]).zza() : this.zza[i];
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzb(zzur zzurVar, long j) {
        this.zzf = zzurVar;
        ArrayList arrayList = this.zzd;
        zzus[] zzusVarArr = this.zza;
        Collections.addAll(arrayList, zzusVarArr);
        for (zzus zzusVar : zzusVarArr) {
            zzusVar.zzb(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzc() throws IOException {
        int i = 0;
        while (true) {
            zzus[] zzusVarArr = this.zza;
            if (i >= zzusVarArr.length) {
                return;
            }
            zzusVarArr[i].zzc();
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zze(zzyk[] zzykVarArr, boolean[] zArr, zzwk[] zzwkVarArr, boolean[] zArr2, long j) {
        int length;
        ArrayList arrayList;
        int length2 = zzykVarArr.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i = 0;
        int i2 = 0;
        while (true) {
            length = zzykVarArr.length;
            if (i2 >= length) {
                break;
            }
            zzwk zzwkVar = zzwkVarArr[i2];
            Integer num = zzwkVar == null ? null : (Integer) this.zzc.get(zzwkVar);
            iArr[i2] = num == null ? -1 : num.intValue();
            zzyk zzykVar = zzykVarArr[i2];
            if (zzykVar != null) {
                String str = zzykVar.zza().zzb;
                iArr2[i2] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i2] = -1;
            }
            i2++;
        }
        IdentityHashMap identityHashMap = this.zzc;
        identityHashMap.clear();
        zzus[] zzusVarArr = this.zza;
        zzwk[] zzwkVarArr2 = new zzwk[length];
        zzwk[] zzwkVarArr3 = new zzwk[length];
        zzyk[] zzykVarArr2 = new zzyk[length];
        ArrayList arrayList2 = new ArrayList(zzusVarArr.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < zzusVarArr.length) {
            int i4 = i;
            while (i4 < zzykVarArr.length) {
                zzwkVarArr3[i4] = iArr[i4] == i3 ? zzwkVarArr[i4] : null;
                if (iArr2[i4] == i3) {
                    zzyk zzykVar2 = zzykVarArr[i4];
                    zzykVar2.getClass();
                    arrayList = arrayList2;
                    zzbg zzbgVar = (zzbg) this.zze.get(zzykVar2.zza());
                    zzbgVar.getClass();
                    zzykVarArr2[i4] = new zzvh(zzykVar2, zzbgVar);
                } else {
                    arrayList = arrayList2;
                    zzykVarArr2[i4] = null;
                }
                i4++;
                arrayList2 = arrayList;
            }
            ArrayList arrayList3 = arrayList2;
            int i5 = i3;
            zzyk[] zzykVarArr3 = zzykVarArr2;
            zzwk[] zzwkVarArr4 = zzwkVarArr3;
            long jZze = zzusVarArr[i3].zze(zzykVarArr2, zArr, zzwkVarArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = jZze;
            } else if (jZze != j2) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzykVarArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    zzwk zzwkVar2 = zzwkVarArr4[i6];
                    zzwkVar2.getClass();
                    zzwkVarArr2[i6] = zzwkVar2;
                    identityHashMap.put(zzwkVar2, Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    zzgmd.zzh(zzwkVarArr4[i6] == null);
                }
            }
            if (z) {
                arrayList3.add(zzusVarArr[i5]);
            }
            i3 = i5 + 1;
            arrayList2 = arrayList3;
            zzykVarArr2 = zzykVarArr3;
            zzwkVarArr3 = zzwkVarArr4;
            i = 0;
        }
        int i7 = i;
        ArrayList arrayList4 = arrayList2;
        System.arraycopy(zzwkVarArr2, i7, zzwkVarArr, i7, length);
        this.zzh = (zzus[]) arrayList4.toArray(new zzus[i7]);
        this.zzi = new zzue(arrayList4, zzgqe.zzc(arrayList4, zzvg.zza));
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final void zzf(long j, boolean z) {
        for (zzus zzusVar : this.zzh) {
            zzusVar.zzf(j, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
        this.zzi.zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzh() {
        long j = -9223372036854775807L;
        for (zzus zzusVar : this.zzh) {
            long jZzh = zzusVar.zzh();
            if (jZzh == C.TIME_UNSET) {
                if (j != C.TIME_UNSET && zzusVar.zzj(j) != j) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j == C.TIME_UNSET) {
                for (zzus zzusVar2 : this.zzh) {
                    if (zzusVar2 == zzusVar) {
                        break;
                    }
                    if (zzusVar2.zzj(jZzh) != jZzh) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j = jZzh;
            } else if (jZzh != j) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        return this.zzi.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzj(long j) {
        long jZzj = this.zzh[0].zzj(j);
        int i = 1;
        while (true) {
            zzus[] zzusVarArr = this.zzh;
            if (i >= zzusVarArr.length) {
                return jZzj;
            }
            if (zzusVarArr[i].zzj(jZzj) != jZzj) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final long zzk(long j, zzlv zzlvVar) {
        zzus[] zzusVarArr = this.zzh;
        return (zzusVarArr.length > 0 ? zzusVarArr[0] : this.zza[0]).zzk(j, zzlvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        return this.zzi.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        ArrayList arrayList = this.zzd;
        if (arrayList.isEmpty()) {
            return this.zzi.zzm(zzknVar);
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzus) arrayList.get(i)).zzm(zzknVar);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzus, com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        return this.zzi.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzur
    public final void zzp(zzus zzusVar) {
        ArrayList arrayList = this.zzd;
        arrayList.remove(zzusVar);
        if (arrayList.isEmpty()) {
            zzus[] zzusVarArr = this.zza;
            int i = 0;
            for (zzus zzusVar2 : zzusVarArr) {
                i += zzusVar2.zzd().zzb;
            }
            zzbg[] zzbgVarArr = new zzbg[i];
            int i2 = 0;
            for (int i3 = 0; i3 < zzusVarArr.length; i3++) {
                zzwv zzwvVarZzd = zzusVarArr[i3].zzd();
                int i4 = zzwvVarZzd.zzb;
                int i5 = 0;
                while (i5 < i4) {
                    zzbg zzbgVarZza = zzwvVarZzd.zza(i5);
                    int i6 = zzbgVarZza.zza;
                    zzv[] zzvVarArr = new zzv[i6];
                    int i7 = 0;
                    while (i7 < i6) {
                        zzv zzvVarZza = zzbgVarZza.zza(i7);
                        zzt zztVarZza = zzvVarZza.zza();
                        String str = zzvVarZza.zza;
                        if (str == null) {
                            str = "";
                        }
                        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 1 + str.length());
                        sb.append(i3);
                        sb.append(":");
                        sb.append(str);
                        zztVarZza.zza(sb.toString());
                        zzvVarArr[i7] = zztVarZza.zzM();
                        i7++;
                        zzusVarArr = zzusVarArr;
                    }
                    zzus[] zzusVarArr2 = zzusVarArr;
                    String str2 = zzbgVarZza.zzb;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i3).length() + 1 + String.valueOf(str2).length());
                    sb2.append(i3);
                    sb2.append(":");
                    sb2.append(str2);
                    zzbg zzbgVar = new zzbg(sb2.toString(), zzvVarArr);
                    this.zze.put(zzbgVar, zzbgVarZza);
                    zzbgVarArr[i2] = zzbgVar;
                    i5++;
                    i2++;
                    zzusVarArr = zzusVarArr2;
                }
            }
            this.zzg = new zzwv(zzbgVarArr);
            zzur zzurVar = this.zzf;
            zzurVar.getClass();
            zzurVar.zzp(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwl
    public final /* bridge */ /* synthetic */ void zzs(zzwm zzwmVar) {
        zzur zzurVar = this.zzf;
        zzurVar.getClass();
        zzurVar.zzs(this);
    }

    @Override // com.google.android.gms.internal.ads.zzus
    public final zzwv zzd() {
        zzwv zzwvVar = this.zzg;
        zzwvVar.getClass();
        return zzwvVar;
    }
}
