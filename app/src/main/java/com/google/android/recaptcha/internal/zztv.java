package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zztv<T> implements zzug<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzvc.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzts zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzuv zzm;
    private final zzrz zzn;

    private zztv(int[] iArr, Object[] objArr, int i, int i2, zzts zztsVar, boolean z, int[] iArr2, int i3, int i4, zzty zztyVar, zztf zztfVar, zzuv zzuvVar, zzrz zzrzVar, zztn zztnVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zztsVar instanceof zzsn;
        boolean z2 = false;
        if (zzrzVar != null && (zztsVar instanceof zzsk)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzuvVar;
        this.zzn = zzrzVar;
        this.zzg = zztsVar;
    }

    private final Object zzA(Object obj, int i) {
        zzug zzugVarZzx = zzx(i);
        int iZzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzugVarZzx.zze();
        }
        Object object = zzb.getObject(obj, iZzu);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzugVarZzx.zze();
        if (object != null) {
            zzugVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzug zzugVarZzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzugVarZzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i2) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzugVarZzx.zze();
        if (object != null) {
            zzugVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzE(Object obj, Object obj2, int i) {
        if (zzN(obj2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzug zzugVarZzx = zzx(i);
            if (!zzN(obj, i)) {
                if (zzQ(object)) {
                    Object objZze = zzugVarZzx.zze();
                    zzugVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzugVarZzx.zze();
                zzugVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzugVarZzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzR(obj2, i2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzug zzugVarZzx = zzx(i);
            if (!zzR(obj, i2, i)) {
                if (zzQ(object)) {
                    Object objZze = zzugVarZzx.zze();
                    zzugVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzI(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzugVarZzx.zze();
                zzugVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzugVarZzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i, zzuf zzufVar) throws IOException {
        long j = i & 1048575;
        if (zzM(i)) {
            zzvc.zzs(obj, j, zzufVar.zzs());
        } else if (this.zzi) {
            zzvc.zzs(obj, j, zzufVar.zzr());
        } else {
            zzvc.zzs(obj, j, zzufVar.zzp());
        }
    }

    private final void zzH(Object obj, int i) {
        int iZzr = zzr(i);
        long j = 1048575 & iZzr;
        if (j == 1048575) {
            return;
        }
        zzvc.zzq(obj, j, (1 << (iZzr >>> 20)) | zzvc.zzc(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzvc.zzq(obj, zzr(i2) & 1048575, i);
    }

    private final void zzJ(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzu(i) & 1048575, obj2);
        zzH(obj, i);
    }

    private final void zzK(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzu(i2) & 1048575, obj2);
        zzI(obj, i, i2);
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private static boolean zzM(int i) {
        return (i & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int iZzr = zzr(i);
        long j = iZzr & 1048575;
        if (j != 1048575) {
            return (zzvc.zzc(obj, j) & (1 << (iZzr >>> 20))) != 0;
        }
        int iZzu = zzu(i);
        long j2 = iZzu & 1048575;
        switch (zzt(iZzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzvc.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzvc.zzb(obj, j2)) != 0;
            case 2:
                return zzvc.zzd(obj, j2) != 0;
            case 3:
                return zzvc.zzd(obj, j2) != 0;
            case 4:
                return zzvc.zzc(obj, j2) != 0;
            case 5:
                return zzvc.zzd(obj, j2) != 0;
            case 6:
                return zzvc.zzc(obj, j2) != 0;
            case 7:
                return zzvc.zzw(obj, j2);
            case 8:
                Object objZzf = zzvc.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzqm) {
                    return !zzqm.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzvc.zzf(obj, j2) != null;
            case 10:
                return !zzqm.zzb.equals(zzvc.zzf(obj, j2));
            case 11:
                return zzvc.zzc(obj, j2) != 0;
            case 12:
                return zzvc.zzc(obj, j2) != 0;
            case 13:
                return zzvc.zzc(obj, j2) != 0;
            case 14:
                return zzvc.zzd(obj, j2) != 0;
            case 15:
                return zzvc.zzc(obj, j2) != 0;
            case 16:
                return zzvc.zzd(obj, j2) != 0;
            case 17:
                return zzvc.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzN(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzug zzugVar) {
        return zzugVar.zzl(zzvc.zzf(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzsn) {
            return ((zzsn) obj).zzL();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzvc.zzc(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzvc.zzf(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzvi zzviVar) throws IOException {
        if (obj instanceof String) {
            zzviVar.zzG(i, (String) obj);
        } else {
            zzviVar.zzd(i, (zzqm) obj);
        }
    }

    static zzuw zzd(Object obj) {
        zzsn zzsnVar = (zzsn) obj;
        zzuw zzuwVar = zzsnVar.zzc;
        if (zzuwVar != zzuw.zzc()) {
            return zzuwVar;
        }
        zzuw zzuwVarZzf = zzuw.zzf();
        zzsnVar.zzc = zzuwVarZzf;
        return zzuwVarZzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0391  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.recaptcha.internal.zztv zzm(java.lang.Class r34, com.google.android.recaptcha.internal.zztp r35, com.google.android.recaptcha.internal.zzty r36, com.google.android.recaptcha.internal.zztf r37, com.google.android.recaptcha.internal.zzuv r38, com.google.android.recaptcha.internal.zzrz r39, com.google.android.recaptcha.internal.zztn r40) {
        /*
            Method dump skipped, instruction units count: 1036
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zztv.zzm(java.lang.Class, com.google.android.recaptcha.internal.zztp, com.google.android.recaptcha.internal.zzty, com.google.android.recaptcha.internal.zztf, com.google.android.recaptcha.internal.zzuv, com.google.android.recaptcha.internal.zzrz, com.google.android.recaptcha.internal.zztn):com.google.android.recaptcha.internal.zztv");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzvc.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzvc.zzf(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzvc.zzf(obj, j)).intValue();
    }

    private final int zzq(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzs(i, 0);
    }

    private final int zzr(int i) {
        return this.zzc[i + 2];
    }

    private final int zzs(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
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

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzvc.zzf(obj, j)).longValue();
    }

    private final zzsr zzw(int i) {
        int i2 = i / 3;
        return (zzsr) this.zzd[i2 + i2 + 1];
    }

    private final zzug zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzug zzugVar = (zzug) objArr[i3];
        if (zzugVar != null) {
            return zzugVar;
        }
        zzug zzugVarZzb = zzuc.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzugVarZzb;
        return zzugVarZzb;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzuv zzuvVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzf = zzvc.zzf(obj, zzu(i) & 1048575);
        if (objZzf == null || zzw(i) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:207:0x054c  */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v256, types: [int] */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r0v281 */
    /* JADX WARN: Type inference failed for: r0v282 */
    /* JADX WARN: Type inference failed for: r0v283 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v118, types: [int] */
    /* JADX WARN: Type inference failed for: r1v121, types: [int] */
    /* JADX WARN: Type inference failed for: r1v160 */
    /* JADX WARN: Type inference failed for: r1v163 */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v167 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v78, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37, types: [int] */
    /* JADX WARN: Type inference failed for: r2v41, types: [int] */
    /* JADX WARN: Type inference failed for: r2v45, types: [int] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54, types: [int] */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v40, types: [int] */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v47, types: [int] */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v58 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.recaptcha.internal.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 2192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zztv.zza(java.lang.Object):int");
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iHashCode = (i4 * 53) + ((zzsn) obj).zzc.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzsk) obj).zzb.zza.hashCode() : iHashCode;
            }
            int iZzu = zzu(i3);
            int i5 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzt) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzvc.zza(obj, j));
                    byte[] bArr = zzsv.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzvc.zzb(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzvc.zzd(obj, j);
                    byte[] bArr2 = zzsv.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzvc.zzd(obj, j);
                    byte[] bArr3 = zzsv.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzvc.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzvc.zzd(obj, j);
                    byte[] bArr4 = zzsv.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzvc.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzsv.zza(zzvc.zzw(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzvc.zzf(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzf = zzvc.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode2 = objZzf.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzvc.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzvc.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzvc.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzvc.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzvc.zzd(obj, j);
                    byte[] bArr5 = zzsv.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzvc.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzvc.zzd(obj, j);
                    byte[] bArr6 = zzsv.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzf2 = zzvc.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode2 = objZzf2.hashCode();
                    }
                    i4 = i2 + iHashCode2;
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
                    i = i4 * 53;
                    iFloatToIntBits = zzvc.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzvc.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zzsv.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzo(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr8 = zzsv.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr9 = zzsv.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr10 = zzsv.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzsv.zza(zzS(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzvc.zzf(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzvc.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzvc.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr11 = zzsv.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr12 = zzsv.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzR(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzvc.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:543:0x0d46, code lost:
    
        if (r5 == r0) goto L545;
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:0x0d48, code lost:
    
        r13.putInt(r35, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:545:0x0d4c, code lost:
    
        r9 = r10.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x0d51, code lost:
    
        if (r9 >= r10.zzl) goto L657;
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:0x0d53, code lost:
    
        zzy(r35, r10.zzj[r9], null, r10.zzm, r35);
        r11 = (com.google.android.recaptcha.internal.zzuw) null;
        r9 = r9 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x0d6b, code lost:
    
        if (r8 != 0) goto L556;
     */
    /* JADX WARN: Code restructure failed: missing block: B:552:0x0d6f, code lost:
    
        if (r6 != r38) goto L554;
     */
    /* JADX WARN: Code restructure failed: missing block: B:555:0x0d77, code lost:
    
        throw new com.google.android.recaptcha.internal.zzsx("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:557:0x0d7a, code lost:
    
        if (r6 > r38) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:558:0x0d7c, code lost:
    
        if (r12 != r8) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:559:0x0d7e, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:561:0x0d84, code lost:
    
        throw new com.google.android.recaptcha.internal.zzsx("Failed to parse the message.");
     */
    /* JADX WARN: Removed duplicated region for block: B:496:0x0c04 A[PHI: r0 r1 r3 r4 r9 r12 r23
  0x0c04: PHI (r0v114 int) = (r0v80 int), (r0v81 int), (r0v82 int), (r0v83 int), (r0v84 int), (r0v88 int), (r0v102 int), (r0v115 int) binds: [B:494:0x0bed, B:491:0x0bcd, B:488:0x0bb0, B:485:0x0b93, B:482:0x0b76, B:480:0x0b6a, B:453:0x0aea, B:421:0x09d1] A[DONT_GENERATE, DONT_INLINE]
  0x0c04: PHI (r1v119 boolean) = 
  (r1v91 boolean)
  (r1v92 boolean)
  (r1v93 boolean)
  (r1v94 boolean)
  (r1v95 boolean)
  (r1v100 boolean)
  (r1v110 boolean)
  (r1v120 boolean)
 binds: [B:494:0x0bed, B:491:0x0bcd, B:488:0x0bb0, B:485:0x0b93, B:482:0x0b76, B:480:0x0b6a, B:453:0x0aea, B:421:0x09d1] A[DONT_GENERATE, DONT_INLINE]
  0x0c04: PHI (r3v54 int) = (r3v36 int), (r3v37 int), (r3v38 int), (r3v39 int), (r3v40 int), (r3v44 int), (r3v49 int), (r3v55 int) binds: [B:494:0x0bed, B:491:0x0bcd, B:488:0x0bb0, B:485:0x0b93, B:482:0x0b76, B:480:0x0b6a, B:453:0x0aea, B:421:0x09d1] A[DONT_GENERATE, DONT_INLINE]
  0x0c04: PHI (r4v82 sun.misc.Unsafe) = 
  (r4v64 sun.misc.Unsafe)
  (r4v65 sun.misc.Unsafe)
  (r4v66 sun.misc.Unsafe)
  (r4v67 sun.misc.Unsafe)
  (r4v68 sun.misc.Unsafe)
  (r4v72 sun.misc.Unsafe)
  (r4v77 sun.misc.Unsafe)
  (r4v83 sun.misc.Unsafe)
 binds: [B:494:0x0bed, B:491:0x0bcd, B:488:0x0bb0, B:485:0x0b93, B:482:0x0b76, B:480:0x0b6a, B:453:0x0aea, B:421:0x09d1] A[DONT_GENERATE, DONT_INLINE]
  0x0c04: PHI (r9v52 com.google.android.recaptcha.internal.zzqb) = 
  (r9v27 com.google.android.recaptcha.internal.zzqb)
  (r9v28 com.google.android.recaptcha.internal.zzqb)
  (r9v29 com.google.android.recaptcha.internal.zzqb)
  (r9v30 com.google.android.recaptcha.internal.zzqb)
  (r9v31 com.google.android.recaptcha.internal.zzqb)
  (r9v35 com.google.android.recaptcha.internal.zzqb)
  (r9v44 com.google.android.recaptcha.internal.zzqb)
  (r9v53 com.google.android.recaptcha.internal.zzqb)
 binds: [B:494:0x0bed, B:491:0x0bcd, B:488:0x0bb0, B:485:0x0b93, B:482:0x0b76, B:480:0x0b6a, B:453:0x0aea, B:421:0x09d1] A[DONT_GENERATE, DONT_INLINE]
  0x0c04: PHI (r12v47 int) = (r12v22 int), (r12v23 int), (r12v24 int), (r12v25 int), (r12v26 int), (r12v30 int), (r12v40 int), (r12v48 int) binds: [B:494:0x0bed, B:491:0x0bcd, B:488:0x0bb0, B:485:0x0b93, B:482:0x0b76, B:480:0x0b6a, B:453:0x0aea, B:421:0x09d1] A[DONT_GENERATE, DONT_INLINE]
  0x0c04: PHI (r23v14 int) = (r23v4 int), (r23v4 int), (r23v4 int), (r23v4 int), (r23v4 int), (r23v4 int), (r23v9 int), (r23v4 int) binds: [B:494:0x0bed, B:491:0x0bcd, B:488:0x0bb0, B:485:0x0b93, B:482:0x0b76, B:480:0x0b6a, B:453:0x0aea, B:421:0x09d1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:498:0x0c07  */
    /* JADX WARN: Removed duplicated region for block: B:499:0x0c1b  */
    /* JADX WARN: Removed duplicated region for block: B:539:0x0d18  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x095f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:647:0x0970 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzc(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.recaptcha.internal.zzqb r40) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zztv.zzc(java.lang.Object, byte[], int, int, int, com.google.android.recaptcha.internal.zzqb):int");
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final Object zze() {
        return ((zzsn) this.zzg).zzv();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    @Override // com.google.android.recaptcha.internal.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zztv.zzf(java.lang.Object):void");
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzui.zzq(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzui.zzp(this.zzn, obj, obj2);
                    return;
                }
                return;
            }
            int iZzu = zzu(i);
            int i2 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzt) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzvc.zzo(obj, j, zzvc.zza(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i)) {
                        zzvc.zzp(obj, j, zzvc.zzb(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i)) {
                        zzvc.zzr(obj, j, zzvc.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i)) {
                        zzvc.zzr(obj, j, zzvc.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i)) {
                        zzvc.zzq(obj, j, zzvc.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i)) {
                        zzvc.zzr(obj, j, zzvc.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i)) {
                        zzvc.zzq(obj, j, zzvc.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i)) {
                        zzvc.zzm(obj, j, zzvc.zzw(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i)) {
                        zzvc.zzs(obj, j, zzvc.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzvc.zzs(obj, j, zzvc.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i)) {
                        zzvc.zzq(obj, j, zzvc.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i)) {
                        zzvc.zzq(obj, j, zzvc.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i)) {
                        zzvc.zzq(obj, j, zzvc.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i)) {
                        zzvc.zzr(obj, j, zzvc.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i)) {
                        zzvc.zzq(obj, j, zzvc.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i)) {
                        zzvc.zzr(obj, j, zzvc.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 17:
                    zzE(obj, obj2, i);
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
                    zzsu zzsuVarZzd = (zzsu) zzvc.zzf(obj, j);
                    zzsu zzsuVar = (zzsu) zzvc.zzf(obj2, j);
                    int size = zzsuVarZzd.size();
                    int size2 = zzsuVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzsuVarZzd.zzc()) {
                            zzsuVarZzd = zzsuVarZzd.zzd(size2 + size);
                        }
                        zzsuVarZzd.addAll(zzsuVar);
                    }
                    if (size > 0) {
                        zzsuVar = zzsuVarZzd;
                    }
                    zzvc.zzs(obj, j, zzsuVar);
                    break;
                case 50:
                    int i4 = zzui.zza;
                    zzvc.zzs(obj, j, zztn.zzb(zzvc.zzf(obj, j), zzvc.zzf(obj2, j)));
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
                    if (zzR(obj2, i3, i)) {
                        zzvc.zzs(obj, j, zzvc.zzf(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 60:
                    zzF(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i3, i)) {
                        zzvc.zzs(obj, j, zzvc.zzf(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:187:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:391:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.recaptcha.internal.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r12, com.google.android.recaptcha.internal.zzuf r13, com.google.android.recaptcha.internal.zzry r14) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1812
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zztv.zzh(java.lang.Object, com.google.android.recaptcha.internal.zzuf, com.google.android.recaptcha.internal.zzry):void");
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzqb zzqbVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzqbVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0561  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0585  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x05cd  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0615  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0639  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x065c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x067f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01c2  */
    @Override // com.google.android.recaptcha.internal.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzj(java.lang.Object r24, com.google.android.recaptcha.internal.zzvi r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1894
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zztv.zzj(java.lang.Object, com.google.android.recaptcha.internal.zzvi):void");
    }

    @Override // com.google.android.recaptcha.internal.zzug
    public final boolean zzk(Object obj, Object obj2) {
        boolean zZzF;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            long j = iZzu & 1048575;
            switch (zzt(iZzu)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzvc.zza(obj, j)) != Double.doubleToLongBits(zzvc.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzvc.zzb(obj, j)) != Float.floatToIntBits(zzvc.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzvc.zzd(obj, j) != zzvc.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzvc.zzd(obj, j) != zzvc.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzvc.zzc(obj, j) != zzvc.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzvc.zzd(obj, j) != zzvc.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzvc.zzc(obj, j) != zzvc.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzvc.zzw(obj, j) != zzvc.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzui.zzF(zzvc.zzf(obj, j), zzvc.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzui.zzF(zzvc.zzf(obj, j), zzvc.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzui.zzF(zzvc.zzf(obj, j), zzvc.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzvc.zzc(obj, j) != zzvc.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzvc.zzc(obj, j) != zzvc.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzvc.zzc(obj, j) != zzvc.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzvc.zzd(obj, j) != zzvc.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzvc.zzc(obj, j) != zzvc.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzvc.zzd(obj, j) != zzvc.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzui.zzF(zzvc.zzf(obj, j), zzvc.zzf(obj2, j))) {
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
                    zZzF = zzui.zzF(zzvc.zzf(obj, j), zzvc.zzf(obj2, j));
                    break;
                case 50:
                    zZzF = zzui.zzF(zzvc.zzf(obj, j), zzvc.zzf(obj2, j));
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
                    long jZzr = zzr(i) & 1048575;
                    if (zzvc.zzc(obj, jZzr) != zzvc.zzc(obj2, jZzr) || !zzui.zzF(zzvc.zzf(obj, j), zzvc.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzF) {
                return false;
            }
        }
        if (!((zzsn) obj).zzc.equals(((zzsn) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzsk) obj).zzb.equals(((zzsk) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0099  */
    @Override // com.google.android.recaptcha.internal.zzug
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzl(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zztv.zzl(java.lang.Object):boolean");
    }
}
