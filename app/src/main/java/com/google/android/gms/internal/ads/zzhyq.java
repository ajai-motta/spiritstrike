package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhyq extends zzhvi {
    static final int[] zza = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzhvi zzd;
    private final zzhvi zze;
    private final int zzf;
    private final int zzg;

    private zzhyq(zzhvi zzhviVar, zzhvi zzhviVar2) {
        this.zzd = zzhviVar;
        this.zze = zzhviVar2;
        int iZzc = zzhviVar.zzc();
        this.zzf = iZzc;
        this.zzc = iZzc + zzhviVar2.zzc();
        this.zzg = Math.max(zzhviVar.zzf(), zzhviVar2.zzf()) + 1;
    }

    /* synthetic */ zzhyq(zzhvi zzhviVar, zzhvi zzhviVar2, byte[] bArr) {
        this(zzhviVar, zzhviVar2);
    }

    private static zzhvi zzD(zzhvi zzhviVar, zzhvi zzhviVar2) {
        int iZzc = zzhviVar.zzc();
        int iZzc2 = zzhviVar2.zzc();
        byte[] bArr = new byte[iZzc + iZzc2];
        zzhviVar.zzu(bArr, 0, 0, iZzc);
        zzhviVar2.zzu(bArr, 0, iZzc, iZzc2);
        return new zzhvg(bArr);
    }

    static zzhvi zzd(zzhvi zzhviVar, zzhvi zzhviVar2) {
        if (zzhviVar2.zzc() == 0) {
            return zzhviVar;
        }
        if (zzhviVar.zzc() == 0) {
            return zzhviVar2;
        }
        int iZzc = zzhviVar.zzc() + zzhviVar2.zzc();
        if (iZzc < 128) {
            return zzD(zzhviVar, zzhviVar2);
        }
        if (zzhviVar instanceof zzhyq) {
            zzhyq zzhyqVar = (zzhyq) zzhviVar;
            zzhvi zzhviVar3 = zzhyqVar.zze;
            if (zzhviVar3.zzc() + zzhviVar2.zzc() < 128) {
                return new zzhyq(zzhyqVar.zzd, zzD(zzhviVar3, zzhviVar2));
            }
            zzhvi zzhviVar4 = zzhyqVar.zzd;
            if (zzhviVar4.zzf() > zzhviVar3.zzf() && zzhyqVar.zzg > zzhviVar2.zzf()) {
                return new zzhyq(zzhviVar4, new zzhyq(zzhviVar3, zzhviVar2));
            }
        }
        return iZzc >= zzh(Math.max(zzhviVar.zzf(), zzhviVar2.zzf()) + 1) ? new zzhyq(zzhviVar, zzhviVar2) : zzhyo.zza(zzhviVar, zzhviVar2, new ArrayDeque());
    }

    static int zzh(int i) {
        int[] iArr = zza;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzhvi)) {
            return false;
        }
        zzhvi zzhviVar = (zzhvi) obj;
        int i = this.zzc;
        if (i != zzhviVar.zzc()) {
            return false;
        }
        if (i == 0) {
            return true;
        }
        int iZzy = zzy();
        int iZzy2 = zzhviVar.zzy();
        if (iZzy != 0 && iZzy2 != 0 && iZzy != iZzy2) {
            return false;
        }
        byte[] bArr = null;
        zzhyp zzhypVar = new zzhyp(this, bArr);
        zzhvf zzhvfVarZza = zzhypVar.next();
        zzhyp zzhypVar2 = new zzhyp(zzhviVar, bArr);
        zzhvf zzhvfVarZza2 = zzhypVar2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int iZzc = zzhvfVarZza.zzc() - i2;
            int iZzc2 = zzhvfVarZza2.zzc() - i3;
            int iMin = Math.min(iZzc, iZzc2);
            if (!(i2 == 0 ? zzhvfVarZza.zzh(zzhvfVarZza2, i3, iMin) : zzhvfVarZza2.zzh(zzhvfVarZza, i2, iMin))) {
                return false;
            }
            i4 += iMin;
            if (i4 >= i) {
                if (i4 == i) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzc) {
                zzhvfVarZza = zzhypVar.next();
                i2 = 0;
            } else {
                i2 += iMin;
                zzhvfVarZza = zzhvfVarZza;
            }
            if (iMin == iZzc2) {
                zzhvfVarZza2 = zzhypVar2.next();
                i3 = 0;
            } else {
                i3 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvi, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        return new zzhyn(this);
    }

    final /* synthetic */ zzhvi zzB() {
        return this.zzd;
    }

    final /* synthetic */ zzhvi zzC() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final byte zza(int i) {
        zzz(i, this.zzc);
        return zzb(i);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    final byte zzb(int i) {
        int i2 = this.zzf;
        return i < i2 ? this.zzd.zzb(i) : this.zze.zzb(i - i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zze.zze(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    protected final int zzf() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    protected final boolean zzg() {
        return this.zzc >= zzh(this.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final zzhvi zzi(int i, int i2) {
        int i3 = this.zzc;
        int iZzA = zzA(i, i2, i3);
        if (iZzA == 0) {
            return zzhvi.zzb;
        }
        if (iZzA == i3) {
            return this;
        }
        int i4 = this.zzf;
        if (i2 <= i4) {
            return this.zzd.zzi(i, i2);
        }
        int i5 = i2 - i4;
        if (i >= i4) {
            return this.zze.zzi(i - i4, i5);
        }
        zzhvi zzhviVar = this.zzd;
        return new zzhyq(zzhviVar.zzi(i, zzhviVar.zzc()), this.zze.zzi(0, i5));
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final ByteBuffer zzj() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    final void zzk(zzhuz zzhuzVar) throws IOException {
        this.zzd.zzk(zzhuzVar);
        this.zze.zzk(zzhuzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    protected final String zzl(Charset charset) {
        return new String(zzv(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final boolean zzm() {
        zzhvi zzhviVar = this.zzd;
        zzhvi zzhviVar2 = this.zze;
        return zzhviVar2.zzn(zzhviVar.zzn(0, 0, this.zzf), 0, zzhviVar2.zzc()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    protected final int zzn(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzn(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzn(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzn(this.zzd.zzn(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    protected final int zzo(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzo(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzo(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzo(this.zzd.zzo(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    public final zzhvn zzp() {
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        byte[] bArr = null;
        zzhyp zzhypVar = new zzhyp(this, bArr);
        while (zzhypVar.hasNext()) {
            arrayList.add(zzhypVar.next().zzj());
        }
        int i = zzhvn.zzf;
        int i2 = 0;
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            iRemaining += byteBuffer.remaining();
            i2 = byteBuffer.hasArray() ? i2 | 1 : byteBuffer.isDirect() ? i2 | 2 : i2 | 4;
        }
        return i2 == 2 ? new zzhvk(arrayList, iRemaining, true, bArr) : zzhvn.zzF(new zzhxe(arrayList), 4096);
    }

    @Override // com.google.android.gms.internal.ads.zzhvi
    /* JADX INFO: renamed from: zzq */
    public final zzhvd iterator() {
        return new zzhyn(this);
    }
}
