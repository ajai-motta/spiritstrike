package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.slf4j.Marker;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzhvi implements Iterable<Byte>, Serializable {
    public static final zzhvi zzb = new zzhvg(zzhxb.zzb);
    private int zza = 0;

    static {
        int i = zzhuv.zza;
    }

    zzhvi() {
    }

    public static zzhvi zzr(byte[] bArr, int i, int i2) {
        zzA(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzhvg(bArr2);
    }

    public static zzhvi zzs(String str) {
        return new zzhvg(str.getBytes(zzhxb.zza));
    }

    public static zzhvi zzt(Iterable iterable) {
        int size;
        if (iterable instanceof Collection) {
            size = ((Collection) iterable).size();
        } else {
            Iterator it = iterable.iterator();
            size = 0;
            while (it.hasNext()) {
                it.next();
                size++;
            }
        }
        return size == 0 ? zzb : zzd(iterable.iterator(), size);
    }

    public static zzhvh zzx() {
        return new zzhvh(128);
    }

    static void zzz(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 11);
                sb.append("Index < 0: ");
                sb.append(i);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 18 + String.valueOf(i2).length());
            sb2.append("Index > length: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int iZzo = this.zza;
        if (iZzo == 0) {
            int iZzc = zzc();
            iZzo = zzo(iZzc, 0, iZzc);
            if (iZzo == 0) {
                iZzo = 1;
            }
            this.zza = iZzo;
        }
        return iZzo;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzc());
        objArr[2] = zzc() <= 50 ? zzhza.zza(this) : zzhza.zza(zzi(0, 47)).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte zza(int i);

    abstract byte zzb(int i);

    public abstract int zzc();

    protected abstract void zze(byte[] bArr, int i, int i2, int i3);

    protected abstract int zzf();

    protected abstract boolean zzg();

    public abstract zzhvi zzi(int i, int i2);

    public abstract ByteBuffer zzj();

    abstract void zzk(zzhuz zzhuzVar) throws IOException;

    protected abstract String zzl(Charset charset);

    public abstract boolean zzm();

    protected abstract int zzn(int i, int i2, int i3);

    protected abstract int zzo(int i, int i2, int i3);

    public abstract zzhvn zzp();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public zzhvd iterator() {
        return new zzhva(this);
    }

    @Deprecated
    public final void zzu(byte[] bArr, int i, int i2, int i3) {
        zzA(0, i3, zzc());
        zzA(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, 0, i2, i3);
        }
    }

    public final byte[] zzv() {
        int iZzc = zzc();
        if (iZzc == 0) {
            return zzhxb.zzb;
        }
        byte[] bArr = new byte[iZzc];
        zze(bArr, 0, 0, iZzc);
        return bArr;
    }

    public final String zzw() {
        return zzc() == 0 ? "" : zzl(zzhxb.zza);
    }

    protected final int zzy() {
        return this.zza;
    }

    private static zzhvi zzd(Iterator it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", Integer.valueOf(i)));
        }
        if (i == 1) {
            return (zzhvi) it.next();
        }
        int i2 = i >>> 1;
        zzhvi zzhviVarZzd = zzd(it, i2);
        zzhvi zzhviVarZzd2 = zzd(it, i - i2);
        if (Integer.MAX_VALUE - zzhviVarZzd.zzc() >= zzhviVarZzd2.zzc()) {
            return zzhyq.zzd(zzhviVarZzd, zzhviVarZzd2);
        }
        int iZzc = zzhviVarZzd.zzc();
        int iZzc2 = zzhviVarZzd2.zzc();
        StringBuilder sb = new StringBuilder(String.valueOf(iZzc).length() + 31 + String.valueOf(iZzc2).length());
        sb.append("ByteString would be too long: ");
        sb.append(iZzc);
        sb.append(Marker.ANY_NON_NULL_MARKER);
        sb.append(iZzc2);
        throw new IllegalArgumentException(sb.toString());
    }

    static int zzA(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + 44 + String.valueOf(i2).length());
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(i2).length() + 15 + String.valueOf(i3).length());
        sb3.append("End index: ");
        sb3.append(i2);
        sb3.append(" >= ");
        sb3.append(i3);
        throw new IndexOutOfBoundsException(sb3.toString());
    }
}
