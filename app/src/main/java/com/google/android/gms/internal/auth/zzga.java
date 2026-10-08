package com.google.android.gms.internal.auth;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
/* JADX INFO: loaded from: classes9.dex */
final class zzga<T> implements zzgi<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhj.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    private zzga(int[] iArr, Object[] objArr, int i, int i2, zzfx zzfxVar, int i3, boolean z, int[] iArr2, int i4, int i5, zzgc zzgcVar, zzfl zzflVar, zzgz zzgzVar, zzem zzemVar, zzfs zzfsVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzh = iArr2;
        this.zzi = i4;
        this.zzj = i5;
        this.zzn = zzgcVar;
        this.zzk = zzflVar;
        this.zzl = zzgzVar;
        this.zzm = zzemVar;
        this.zzg = zzfxVar;
        this.zzo = zzfsVar;
    }

    private final void zzA(Object obj, int i, int i2) {
        zzhj.zzn(obj, zzl(i2) & 1048575, i);
    }

    private final void zzB(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzo(i) & 1048575, obj2);
        zzz(obj, i);
    }

    private final void zzC(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzo(i2) & 1048575, obj2);
        zzA(obj, i, i2);
    }

    private final boolean zzD(Object obj, Object obj2, int i) {
        return zzE(obj, i) == zzE(obj2, i);
    }

    private final boolean zzE(Object obj, int i) {
        int iZzl = zzl(i);
        long j = iZzl & 1048575;
        if (j != 1048575) {
            return (zzhj.zzc(obj, j) & (1 << (iZzl >>> 20))) != 0;
        }
        int iZzo = zzo(i);
        long j2 = iZzo & 1048575;
        switch (zzn(iZzo)) {
            case 0:
                return Double.doubleToRawLongBits(zzhj.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhj.zzb(obj, j2)) != 0;
            case 2:
                return zzhj.zzd(obj, j2) != 0;
            case 3:
                return zzhj.zzd(obj, j2) != 0;
            case 4:
                return zzhj.zzc(obj, j2) != 0;
            case 5:
                return zzhj.zzd(obj, j2) != 0;
            case 6:
                return zzhj.zzc(obj, j2) != 0;
            case 7:
                return zzhj.zzt(obj, j2);
            case 8:
                Object objZzf = zzhj.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzef) {
                    return !zzef.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhj.zzf(obj, j2) != null;
            case 10:
                return !zzef.zzb.equals(zzhj.zzf(obj, j2));
            case 11:
                return zzhj.zzc(obj, j2) != 0;
            case 12:
                return zzhj.zzc(obj, j2) != 0;
            case 13:
                return zzhj.zzc(obj, j2) != 0;
            case 14:
                return zzhj.zzd(obj, j2) != 0;
            case 15:
                return zzhj.zzc(obj, j2) != 0;
            case 16:
                return zzhj.zzd(obj, j2) != 0;
            case 17:
                return zzhj.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzF(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzE(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzG(Object obj, int i, zzgi zzgiVar) {
        return zzgiVar.zzi(zzhj.zzf(obj, i & 1048575));
    }

    private static boolean zzH(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzev) {
            return ((zzev) obj).zzm();
        }
        return true;
    }

    private final boolean zzI(Object obj, int i, int i2) {
        return zzhj.zzc(obj, (long) (zzl(i2) & 1048575)) == i;
    }

    static zzha zzc(Object obj) {
        zzev zzevVar = (zzev) obj;
        zzha zzhaVar = zzevVar.zzc;
        if (zzhaVar != zzha.zza()) {
            return zzhaVar;
        }
        zzha zzhaVarZzd = zzha.zzd();
        zzevVar.zzc = zzhaVarZzd;
        return zzhaVarZzd;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x026d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.auth.zzga zzj(java.lang.Class r31, com.google.android.gms.internal.auth.zzfu r32, com.google.android.gms.internal.auth.zzgc r33, com.google.android.gms.internal.auth.zzfl r34, com.google.android.gms.internal.auth.zzgz r35, com.google.android.gms.internal.auth.zzem r36, com.google.android.gms.internal.auth.zzfs r37) {
        /*
            Method dump skipped, instruction units count: 1007
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzj(java.lang.Class, com.google.android.gms.internal.auth.zzfu, com.google.android.gms.internal.auth.zzgc, com.google.android.gms.internal.auth.zzfl, com.google.android.gms.internal.auth.zzgz, com.google.android.gms.internal.auth.zzem, com.google.android.gms.internal.auth.zzfs):com.google.android.gms.internal.auth.zzga");
    }

    private static int zzk(Object obj, long j) {
        return ((Integer) zzhj.zzf(obj, j)).intValue();
    }

    private final int zzl(int i) {
        return this.zzc[i + 2];
    }

    private final int zzm(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static int zzn(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzo(int i) {
        return this.zzc[i + 1];
    }

    private static long zzp(Object obj, long j) {
        return ((Long) zzhj.zzf(obj, j)).longValue();
    }

    private final zzey zzq(int i) {
        int i2 = i / 3;
        return (zzey) this.zzd[i2 + i2 + 1];
    }

    private final zzgi zzr(int i) {
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgi zzgiVar = (zzgi) this.zzd[i3];
        if (zzgiVar != null) {
            return zzgiVar;
        }
        zzgi zzgiVarZzb = zzgf.zza().zzb((Class) this.zzd[i3 + 1]);
        this.zzd[i3] = zzgiVarZzb;
        return zzgiVarZzb;
    }

    private final Object zzs(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzt(Object obj, int i) {
        zzgi zzgiVarZzr = zzr(i);
        int iZzo = zzo(i) & 1048575;
        if (!zzE(obj, i)) {
            return zzgiVarZzr.zzd();
        }
        Object object = zzb.getObject(obj, iZzo);
        if (zzH(object)) {
            return object;
        }
        Object objZzd = zzgiVarZzr.zzd();
        if (object != null) {
            zzgiVarZzr.zzf(objZzd, object);
        }
        return objZzd;
    }

    private final Object zzu(Object obj, int i, int i2) {
        zzgi zzgiVarZzr = zzr(i2);
        if (!zzI(obj, i, i2)) {
            return zzgiVarZzr.zzd();
        }
        Object object = zzb.getObject(obj, zzo(i2) & 1048575);
        if (zzH(object)) {
            return object;
        }
        Object objZzd = zzgiVarZzr.zzd();
        if (object != null) {
            zzgiVarZzr.zzf(objZzd, object);
        }
        return objZzd;
    }

    private static Field zzv(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static void zzw(Object obj) {
        if (!zzH(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzx(Object obj, Object obj2, int i) {
        if (zzE(obj2, i)) {
            int iZzo = zzo(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzo;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgi zzgiVarZzr = zzr(i);
            if (!zzE(obj, i)) {
                if (zzH(object)) {
                    Object objZzd = zzgiVarZzr.zzd();
                    zzgiVarZzr.zzf(objZzd, object);
                    unsafe.putObject(obj, j, objZzd);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzz(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzH(object2)) {
                Object objZzd2 = zzgiVarZzr.zzd();
                zzgiVarZzr.zzf(objZzd2, object2);
                unsafe.putObject(obj, j, objZzd2);
                object2 = objZzd2;
            }
            zzgiVarZzr.zzf(object2, object);
        }
    }

    private final void zzy(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzI(obj2, i2, i)) {
            int iZzo = zzo(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzo;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgi zzgiVarZzr = zzr(i);
            if (!zzI(obj, i2, i)) {
                if (zzH(object)) {
                    Object objZzd = zzgiVarZzr.zzd();
                    zzgiVarZzr.zzf(objZzd, object);
                    unsafe.putObject(obj, j, objZzd);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzA(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzH(object2)) {
                Object objZzd2 = zzgiVarZzr.zzd();
                zzgiVarZzr.zzf(objZzd2, object2);
                unsafe.putObject(obj, j, objZzd2);
                object2 = objZzd2;
            }
            zzgiVarZzr.zzf(object2, object);
        }
    }

    private final void zzz(Object obj, int i) {
        int iZzl = zzl(i);
        long j = 1048575 & iZzl;
        if (j == 1048575) {
            return;
        }
        zzhj.zzn(obj, j, (1 << (iZzl >>> 20)) | zzhj.zzc(obj, j));
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final int zza(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int length = this.zzc.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iZzo = zzo(i3);
            int i4 = this.zzc[i3];
            long j = 1048575 & iZzo;
            int iHashCode = 37;
            switch (zzn(iZzo)) {
                case 0:
                    i = i2 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhj.zza(obj, j));
                    byte[] bArr = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i2 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhj.zzb(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr2 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr3 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr4 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i2 * 53;
                    iFloatToIntBits = zzfa.zza(zzhj.zzt(obj, j));
                    i2 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i2 * 53;
                    iFloatToIntBits = ((String) zzhj.zzf(obj, j)).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 9:
                    Object objZzf = zzhj.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr5 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzc(obj, j);
                    i2 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i2 * 53;
                    jDoubleToLongBits = zzhj.zzd(obj, j);
                    byte[] bArr6 = zzfa.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i2 = i + iFloatToIntBits;
                    break;
                case 17:
                    Object objZzf2 = zzhj.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i2 * 53;
                    iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                    i2 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(((Double) zzhj.zzf(obj, j)).doubleValue());
                        byte[] bArr7 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = Float.floatToIntBits(((Float) zzhj.zzf(obj, j)).floatValue());
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr8 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr9 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr10 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzfa.zza(((Boolean) zzhj.zzf(obj, j)).booleanValue());
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = ((String) zzhj.zzf(obj, j)).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr11 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzk(obj, j);
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        jDoubleToLongBits = zzp(obj, j);
                        byte[] bArr12 = zzfa.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i2 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzI(obj, i4, i3)) {
                        i = i2 * 53;
                        iFloatToIntBits = zzhj.zzf(obj, j).hashCode();
                        i2 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        return (i2 * 53) + this.zzl.zzb(obj).hashCode();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:452:0x09ae A[PHI: r0 r7 r8 r9 r10 r11 r14 r25
  0x09ae: PHI (r0v34 com.google.android.gms.internal.auth.zzga<T>) = 
  (r0v1 com.google.android.gms.internal.auth.zzga<T>)
  (r0v1 com.google.android.gms.internal.auth.zzga<T>)
  (r0v1 com.google.android.gms.internal.auth.zzga<T>)
  (r0v30 com.google.android.gms.internal.auth.zzga<T>)
  (r0v32 com.google.android.gms.internal.auth.zzga<T>)
  (r0v1 com.google.android.gms.internal.auth.zzga<T>)
 binds: [B:442:0x0967, B:426:0x090e, B:410:0x08bc, B:334:0x0765, B:284:0x069d, B:181:0x0453] A[DONT_GENERATE, DONT_INLINE]
  0x09ae: PHI (r7v33 int) = (r7v7 int), (r7v8 int), (r7v9 int), (r7v24 int), (r7v27 int), (r7v37 int) binds: [B:442:0x0967, B:426:0x090e, B:410:0x08bc, B:334:0x0765, B:284:0x069d, B:181:0x0453] A[DONT_GENERATE, DONT_INLINE]
  0x09ae: PHI (r8v97 sun.misc.Unsafe) = 
  (r8v49 sun.misc.Unsafe)
  (r8v50 sun.misc.Unsafe)
  (r8v51 sun.misc.Unsafe)
  (r8v91 sun.misc.Unsafe)
  (r8v93 sun.misc.Unsafe)
  (r8v100 sun.misc.Unsafe)
 binds: [B:442:0x0967, B:426:0x090e, B:410:0x08bc, B:334:0x0765, B:284:0x069d, B:181:0x0453] A[DONT_GENERATE, DONT_INLINE]
  0x09ae: PHI (r9v80 int) = (r9v37 int), (r9v38 int), (r9v39 int), (r9v71 int), (r9v74 int), (r9v82 int) binds: [B:442:0x0967, B:426:0x090e, B:410:0x08bc, B:334:0x0765, B:284:0x069d, B:181:0x0453] A[DONT_GENERATE, DONT_INLINE]
  0x09ae: PHI (r10v79 int) = (r10v41 int), (r10v42 int), (r10v43 int), (r10v70 int), (r10v73 int), (r10v82 int) binds: [B:442:0x0967, B:426:0x090e, B:410:0x08bc, B:334:0x0765, B:284:0x069d, B:181:0x0453] A[DONT_GENERATE, DONT_INLINE]
  0x09ae: PHI (r11v41 int) = (r11v13 int), (r11v14 int), (r11v15 int), (r11v32 int), (r11v35 int), (r11v44 int) binds: [B:442:0x0967, B:426:0x090e, B:410:0x08bc, B:334:0x0765, B:284:0x069d, B:181:0x0453] A[DONT_GENERATE, DONT_INLINE]
  0x09ae: PHI (r14v41 int) = (r14v17 int), (r14v18 int), (r14v19 int), (r14v31 int), (r14v33 int), (r14v43 int) binds: [B:442:0x0967, B:426:0x090e, B:410:0x08bc, B:334:0x0765, B:284:0x069d, B:181:0x0453] A[DONT_GENERATE, DONT_INLINE]
  0x09ae: PHI (r25v39 int) = (r25v13 int), (r25v14 int), (r25v15 int), (r25v30 int), (r25v33 int), (r25v41 int) binds: [B:442:0x0967, B:426:0x090e, B:410:0x08bc, B:334:0x0765, B:284:0x069d, B:181:0x0453] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:539:0x0c9d A[PHI: r1 r5 r6 r7 r8 r17 r20 r26
  0x0c9d: PHI (r1v178 int) = 
  (r1v159 int)
  (r1v160 int)
  (r1v161 int)
  (r1v162 int)
  (r1v163 int)
  (r1v164 int)
  (r1v166 int)
  (r1v169 int)
  (r1v173 int)
  (r1v179 int)
 binds: [B:537:0x0c86, B:534:0x0c60, B:531:0x0c3e, B:528:0x0c1c, B:525:0x0bfa, B:522:0x0bd7, B:520:0x0bc5, B:496:0x0b42, B:492:0x0b01, B:469:0x0a29] A[DONT_GENERATE, DONT_INLINE]
  0x0c9d: PHI (r5v102 com.google.android.gms.internal.auth.zzdt) = 
  (r5v85 com.google.android.gms.internal.auth.zzdt)
  (r5v86 com.google.android.gms.internal.auth.zzdt)
  (r5v87 com.google.android.gms.internal.auth.zzdt)
  (r5v88 com.google.android.gms.internal.auth.zzdt)
  (r5v89 com.google.android.gms.internal.auth.zzdt)
  (r5v90 com.google.android.gms.internal.auth.zzdt)
  (r5v92 com.google.android.gms.internal.auth.zzdt)
  (r5v94 com.google.android.gms.internal.auth.zzdt)
  (r5v97 com.google.android.gms.internal.auth.zzdt)
  (r5v103 com.google.android.gms.internal.auth.zzdt)
 binds: [B:537:0x0c86, B:534:0x0c60, B:531:0x0c3e, B:528:0x0c1c, B:525:0x0bfa, B:522:0x0bd7, B:520:0x0bc5, B:496:0x0b42, B:492:0x0b01, B:469:0x0a29] A[DONT_GENERATE, DONT_INLINE]
  0x0c9d: PHI (r6v73 int) = 
  (r6v48 int)
  (r6v49 int)
  (r6v50 int)
  (r6v51 int)
  (r6v52 int)
  (r6v53 int)
  (r6v55 int)
  (r6v58 int)
  (r6v65 int)
  (r6v74 int)
 binds: [B:537:0x0c86, B:534:0x0c60, B:531:0x0c3e, B:528:0x0c1c, B:525:0x0bfa, B:522:0x0bd7, B:520:0x0bc5, B:496:0x0b42, B:492:0x0b01, B:469:0x0a29] A[DONT_GENERATE, DONT_INLINE]
  0x0c9d: PHI (r7v60 java.lang.Object) = 
  (r7v42 java.lang.Object)
  (r7v43 java.lang.Object)
  (r7v44 java.lang.Object)
  (r7v45 java.lang.Object)
  (r7v46 java.lang.Object)
  (r7v47 java.lang.Object)
  (r7v49 java.lang.Object)
  (r7v51 java.lang.Object)
  (r7v55 java.lang.Object)
  (r7v61 java.lang.Object)
 binds: [B:537:0x0c86, B:534:0x0c60, B:531:0x0c3e, B:528:0x0c1c, B:525:0x0bfa, B:522:0x0bd7, B:520:0x0bc5, B:496:0x0b42, B:492:0x0b01, B:469:0x0a29] A[DONT_GENERATE, DONT_INLINE]
  0x0c9d: PHI (r8v137 int) = 
  (r8v102 int)
  (r8v103 int)
  (r8v104 int)
  (r8v105 int)
  (r8v106 int)
  (r8v107 int)
  (r8v109 int)
  (r8v116 int)
  (r8v127 int)
  (r8v138 int)
 binds: [B:537:0x0c86, B:534:0x0c60, B:531:0x0c3e, B:528:0x0c1c, B:525:0x0bfa, B:522:0x0bd7, B:520:0x0bc5, B:496:0x0b42, B:492:0x0b01, B:469:0x0a29] A[DONT_GENERATE, DONT_INLINE]
  0x0c9d: PHI (r17v28 int) = 
  (r17v13 int)
  (r17v14 int)
  (r17v15 int)
  (r17v16 int)
  (r17v17 int)
  (r17v18 int)
  (r17v20 int)
  (r17v22 int)
  (r17v24 int)
  (r17v29 int)
 binds: [B:537:0x0c86, B:534:0x0c60, B:531:0x0c3e, B:528:0x0c1c, B:525:0x0bfa, B:522:0x0bd7, B:520:0x0bc5, B:496:0x0b42, B:492:0x0b01, B:469:0x0a29] A[DONT_GENERATE, DONT_INLINE]
  0x0c9d: PHI (r20v28 int) = 
  (r20v12 int)
  (r20v13 int)
  (r20v14 int)
  (r20v15 int)
  (r20v16 int)
  (r20v17 int)
  (r20v19 int)
  (r20v22 int)
  (r20v24 int)
  (r20v29 int)
 binds: [B:537:0x0c86, B:534:0x0c60, B:531:0x0c3e, B:528:0x0c1c, B:525:0x0bfa, B:522:0x0bd7, B:520:0x0bc5, B:496:0x0b42, B:492:0x0b01, B:469:0x0a29] A[DONT_GENERATE, DONT_INLINE]
  0x0c9d: PHI (r26v14 sun.misc.Unsafe) = 
  (r26v9 sun.misc.Unsafe)
  (r26v9 sun.misc.Unsafe)
  (r26v9 sun.misc.Unsafe)
  (r26v9 sun.misc.Unsafe)
  (r26v9 sun.misc.Unsafe)
  (r26v9 sun.misc.Unsafe)
  (r26v10 sun.misc.Unsafe)
  (r26v9 sun.misc.Unsafe)
  (r26v9 sun.misc.Unsafe)
  (r26v9 sun.misc.Unsafe)
 binds: [B:537:0x0c86, B:534:0x0c60, B:531:0x0c3e, B:528:0x0c1c, B:525:0x0bfa, B:522:0x0bd7, B:520:0x0bc5, B:496:0x0b42, B:492:0x0b01, B:469:0x0a29] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:610:0x09b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:613:0x0ca0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:615:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:656:0x09c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:657:0x0cb7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzb(java.lang.Object r40, byte[] r41, int r42, int r43, int r44, com.google.android.gms.internal.auth.zzdt r45) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3542
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzb(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.auth.zzdt):int");
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final Object zzd() {
        return ((zzev) this.zzg).zzc();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006c  */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zze(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zze(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzf(Object obj, Object obj2) {
        zzw(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzo = zzo(i);
            int i2 = this.zzc[i];
            long j = 1048575 & iZzo;
            switch (zzn(iZzo)) {
                case 0:
                    if (zzE(obj2, i)) {
                        zzhj.zzl(obj, j, zzhj.zza(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 1:
                    if (zzE(obj2, i)) {
                        zzhj.zzm(obj, j, zzhj.zzb(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 2:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 3:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 4:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 5:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 6:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 7:
                    if (zzE(obj2, i)) {
                        zzhj.zzk(obj, j, zzhj.zzt(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 8:
                    if (zzE(obj2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 9:
                    zzx(obj, obj2, i);
                    break;
                case 10:
                    if (zzE(obj2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 11:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 12:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 13:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 14:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 15:
                    if (zzE(obj2, i)) {
                        zzhj.zzn(obj, j, zzhj.zzc(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 16:
                    if (zzE(obj2, i)) {
                        zzhj.zzo(obj, j, zzhj.zzd(obj2, j));
                        zzz(obj, i);
                    }
                    break;
                case 17:
                    zzx(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzk.zzb(obj, obj2, j);
                    break;
                case 50:
                    int i3 = zzgk.zza;
                    zzhj.zzp(obj, j, zzfs.zza(zzhj.zzf(obj, j), zzhj.zzf(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzI(obj2, i2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                    }
                    break;
                case 60:
                    zzy(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzI(obj2, i2, i)) {
                        zzhj.zzp(obj, j, zzhj.zzf(obj2, j));
                        zzA(obj, i2, i);
                    }
                    break;
                case 68:
                    zzy(obj, obj2, i);
                    break;
            }
        }
        zzgk.zzd(this.zzl, obj, obj2);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final void zzg(Object obj, byte[] bArr, int i, int i2, zzdt zzdtVar) throws IOException {
        zzb(obj, bArr, i, i2, 0, zzdtVar);
    }

    @Override // com.google.android.gms.internal.auth.zzgi
    public final boolean zzh(Object obj, Object obj2) {
        boolean zZzf;
        int length = this.zzc.length;
        for (int i = 0; i < length; i += 3) {
            int iZzo = zzo(i);
            long j = iZzo & 1048575;
            switch (zzn(iZzo)) {
                case 0:
                    if (!zzD(obj, obj2, i) || Double.doubleToLongBits(zzhj.zza(obj, j)) != Double.doubleToLongBits(zzhj.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzD(obj, obj2, i) || Float.floatToIntBits(zzhj.zzb(obj, j)) != Float.floatToIntBits(zzhj.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzD(obj, obj2, i) || zzhj.zzt(obj, j) != zzhj.zzt(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzD(obj, obj2, i) || zzhj.zzc(obj, j) != zzhj.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzD(obj, obj2, i) || zzhj.zzd(obj, j) != zzhj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzD(obj, obj2, i) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzf = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                    break;
                case 50:
                    zZzf = zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzl = zzl(i) & 1048575;
                    if (zzhj.zzc(obj, jZzl) != zzhj.zzc(obj2, jZzl) || !zzgk.zzf(zzhj.zzf(obj, j), zzhj.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzf) {
                return false;
            }
        }
        return this.zzl.zzb(obj).equals(this.zzl.zzb(obj2));
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // com.google.android.gms.internal.auth.zzgi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzi(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzga.zzi(java.lang.Object):boolean");
    }
}
