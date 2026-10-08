package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgo<T> implements zzgv<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzho.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgl zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzhh zzl;
    private final zzev zzm;

    private zzgo(int[] iArr, Object[] objArr, int i, int i2, zzgl zzglVar, boolean z, int[] iArr2, int i3, int i4, zzgq zzgqVar, zzfy zzfyVar, zzhh zzhhVar, zzev zzevVar, zzgg zzggVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzevVar != null && (zzglVar instanceof zzff)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzhhVar;
        this.zzm = zzevVar;
        this.zzg = zzglVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgv zzgvVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzgvVarZzv.zze();
                    zzgvVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgvVarZzv.zze();
                zzgvVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgvVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzgv zzgvVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzgvVarZzv.zze();
                    zzgvVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgvVarZzv.zze();
                zzgvVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgvVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzho.zzq(obj, j, (1 << (iZzp >>> 20)) | zzho.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzho.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return (zzho.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzho.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzho.zzb(obj, j2)) != 0;
            case 2:
                return zzho.zzd(obj, j2) != 0;
            case 3:
                return zzho.zzd(obj, j2) != 0;
            case 4:
                return zzho.zzc(obj, j2) != 0;
            case 5:
                return zzho.zzd(obj, j2) != 0;
            case 6:
                return zzho.zzc(obj, j2) != 0;
            case 7:
                return zzho.zzw(obj, j2);
            case 8:
                Object objZzf = zzho.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzei) {
                    return !zzei.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzho.zzf(obj, j2) != null;
            case 10:
                return !zzei.zzb.equals(zzho.zzf(obj, j2));
            case 11:
                return zzho.zzc(obj, j2) != 0;
            case 12:
                return zzho.zzc(obj, j2) != 0;
            case 13:
                return zzho.zzc(obj, j2) != 0;
            case 14:
                return zzho.zzd(obj, j2) != 0;
            case 15:
                return zzho.zzc(obj, j2) != 0;
            case 16:
                return zzho.zzd(obj, j2) != 0;
            case 17:
                return zzho.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzI(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzgv zzgvVar) {
        return zzgvVar.zzk(zzho.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzfi) {
            return ((zzfi) obj).zzz();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzho.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzho.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhu zzhuVar) throws IOException {
        if (obj instanceof String) {
            zzhuVar.zzG(i, (String) obj);
        } else {
            zzhuVar.zzd(i, (zzei) obj);
        }
    }

    static zzhi zzd(Object obj) {
        zzfi zzfiVar = (zzfi) obj;
        zzhi zzhiVar = zzfiVar.zzc;
        if (zzhiVar != zzhi.zzc()) {
            return zzhiVar;
        }
        zzhi zzhiVarZzf = zzhi.zzf();
        zzfiVar.zzc = zzhiVarZzf;
        return zzhiVarZzf;
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
    static com.google.android.gms.internal.play_billing.zzgo zzl(java.lang.Class r34, com.google.android.gms.internal.play_billing.zzgi r35, com.google.android.gms.internal.play_billing.zzgq r36, com.google.android.gms.internal.play_billing.zzfy r37, com.google.android.gms.internal.play_billing.zzhh r38, com.google.android.gms.internal.play_billing.zzev r39, com.google.android.gms.internal.play_billing.zzgg r40) {
        /*
            Method dump skipped, instruction units count: 1036
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzgi, com.google.android.gms.internal.play_billing.zzgq, com.google.android.gms.internal.play_billing.zzfy, com.google.android.gms.internal.play_billing.zzhh, com.google.android.gms.internal.play_billing.zzev, com.google.android.gms.internal.play_billing.zzgg):com.google.android.gms.internal.play_billing.zzgo");
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzho.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzho.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzho.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzho.zzf(obj, j)).longValue();
    }

    private final zzfl zzu(int i) {
        int i2 = i / 3;
        return (zzfl) this.zzd[i2 + i2 + 1];
    }

    private final zzgv zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgv zzgvVar = (zzgv) objArr[i3];
        if (zzgvVar != null) {
            return zzgvVar;
        }
        zzgv zzgvVarZzb = zzgs.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzgvVarZzb;
        return zzgvVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzgv zzgvVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzgvVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgvVarZzv.zze();
        if (object != null) {
            zzgvVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzgv zzgvVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzgvVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgvVarZzv.zze();
        if (object != null) {
            zzgvVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
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
    @Override // com.google.android.gms.internal.play_billing.zzgv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 2192
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
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
                int iHashCode = (i4 * 53) + ((zzfi) obj).zzc.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzff) obj).zzb.zza.hashCode() : iHashCode;
            }
            int iZzs = zzs(i3);
            int i5 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzr) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzho.zza(obj, j));
                    byte[] bArr = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzho.zzb(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr2 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr3 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr4 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzfo.zza(zzho.zzw(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzho.zzf(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzf = zzho.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode2 = objZzf.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr5 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr6 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzf2 = zzho.zzf(obj, j);
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
                    iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzfo.zza(zzN(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzho.zzf(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:528:0x0d3a, code lost:
    
        if (r6 == 1048575) goto L530;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x0d3c, code lost:
    
        r11.putInt(r7, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:530:0x0d40, code lost:
    
        r2 = r8.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:532:0x0d44, code lost:
    
        if (r2 >= r8.zzk) goto L647;
     */
    /* JADX WARN: Code restructure failed: missing block: B:533:0x0d46, code lost:
    
        r3 = r8.zzi;
        r5 = r8.zzc;
        r3 = r3[r2];
        r5 = r5[r3];
        r5 = com.google.android.gms.internal.play_billing.zzho.zzf(r7, r8.zzs(r3) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:534:0x0d58, code lost:
    
        if (r5 != null) goto L536;
     */
    /* JADX WARN: Code restructure failed: missing block: B:537:0x0d5f, code lost:
    
        if (r8.zzu(r3) != null) goto L648;
     */
    /* JADX WARN: Code restructure failed: missing block: B:538:0x0d61, code lost:
    
        r3 = (com.google.android.gms.internal.play_billing.zzhi) null;
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:539:0x0d68, code lost:
    
        r5 = (com.google.android.gms.internal.play_billing.zzgf) r5;
        r0 = (com.google.android.gms.internal.play_billing.zzge) r8.zzw(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:540:0x0d70, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:542:0x0d73, code lost:
    
        if (r9 != 0) goto L548;
     */
    /* JADX WARN: Code restructure failed: missing block: B:544:0x0d77, code lost:
    
        if (r1 != r37) goto L546;
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x0d7f, code lost:
    
        throw new com.google.android.gms.internal.play_billing.zzfq("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:549:0x0d82, code lost:
    
        if (r1 > r37) goto L552;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x0d84, code lost:
    
        if (r4 != r9) goto L552;
     */
    /* JADX WARN: Code restructure failed: missing block: B:551:0x0d86, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:553:0x0d8c, code lost:
    
        throw new com.google.android.gms.internal.play_billing.zzfq("Failed to parse the message.");
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:508:0x0cb8 A[PHI: r0 r6 r7 r8 r11 r19 r27
  0x0cb8: PHI (r0v97 int) = 
  (r0v74 int)
  (r0v75 int)
  (r0v76 int)
  (r0v77 int)
  (r0v78 int)
  (r0v79 int)
  (r0v80 int)
  (r0v81 int)
  (r0v83 int)
  (r0v88 int)
  (r0v93 int)
  (r0v98 int)
 binds: [B:506:0x0ca1, B:503:0x0c79, B:500:0x0c55, B:497:0x0c31, B:494:0x0c0d, B:491:0x0be8, B:484:0x0bbb, B:470:0x0b7a, B:468:0x0b5f, B:464:0x0b27, B:440:0x0a6b, B:436:0x0a28] A[DONT_GENERATE, DONT_INLINE]
  0x0cb8: PHI (r6v77 com.google.android.gms.internal.play_billing.zzdw) = 
  (r6v51 com.google.android.gms.internal.play_billing.zzdw)
  (r6v52 com.google.android.gms.internal.play_billing.zzdw)
  (r6v53 com.google.android.gms.internal.play_billing.zzdw)
  (r6v54 com.google.android.gms.internal.play_billing.zzdw)
  (r6v55 com.google.android.gms.internal.play_billing.zzdw)
  (r6v56 com.google.android.gms.internal.play_billing.zzdw)
  (r6v57 com.google.android.gms.internal.play_billing.zzdw)
  (r6v58 com.google.android.gms.internal.play_billing.zzdw)
  (r6v60 com.google.android.gms.internal.play_billing.zzdw)
  (r6v67 com.google.android.gms.internal.play_billing.zzdw)
  (r6v72 com.google.android.gms.internal.play_billing.zzdw)
  (r6v78 com.google.android.gms.internal.play_billing.zzdw)
 binds: [B:506:0x0ca1, B:503:0x0c79, B:500:0x0c55, B:497:0x0c31, B:494:0x0c0d, B:491:0x0be8, B:484:0x0bbb, B:470:0x0b7a, B:468:0x0b5f, B:464:0x0b27, B:440:0x0a6b, B:436:0x0a28] A[DONT_GENERATE, DONT_INLINE]
  0x0cb8: PHI (r7v26 java.lang.Object) = 
  (r7v5 java.lang.Object)
  (r7v6 java.lang.Object)
  (r7v7 java.lang.Object)
  (r7v8 java.lang.Object)
  (r7v9 java.lang.Object)
  (r7v10 java.lang.Object)
  (r7v11 java.lang.Object)
  (r7v12 java.lang.Object)
  (r7v13 java.lang.Object)
  (r7v18 java.lang.Object)
  (r7v23 java.lang.Object)
  (r7v27 java.lang.Object)
 binds: [B:506:0x0ca1, B:503:0x0c79, B:500:0x0c55, B:497:0x0c31, B:494:0x0c0d, B:491:0x0be8, B:484:0x0bbb, B:470:0x0b7a, B:468:0x0b5f, B:464:0x0b27, B:440:0x0a6b, B:436:0x0a28] A[DONT_GENERATE, DONT_INLINE]
  0x0cb8: PHI (r8v91 com.google.android.gms.internal.play_billing.zzgo<T>) = 
  (r8v68 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v69 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v70 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v71 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v72 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v73 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v74 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v75 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v76 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v81 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v86 com.google.android.gms.internal.play_billing.zzgo<T>)
  (r8v92 com.google.android.gms.internal.play_billing.zzgo<T>)
 binds: [B:506:0x0ca1, B:503:0x0c79, B:500:0x0c55, B:497:0x0c31, B:494:0x0c0d, B:491:0x0be8, B:484:0x0bbb, B:470:0x0b7a, B:468:0x0b5f, B:464:0x0b27, B:440:0x0a6b, B:436:0x0a28] A[DONT_GENERATE, DONT_INLINE]
  0x0cb8: PHI (r11v72 sun.misc.Unsafe) = 
  (r11v47 sun.misc.Unsafe)
  (r11v48 sun.misc.Unsafe)
  (r11v49 sun.misc.Unsafe)
  (r11v50 sun.misc.Unsafe)
  (r11v51 sun.misc.Unsafe)
  (r11v52 sun.misc.Unsafe)
  (r11v53 sun.misc.Unsafe)
  (r11v54 sun.misc.Unsafe)
  (r11v55 sun.misc.Unsafe)
  (r11v63 sun.misc.Unsafe)
  (r11v68 sun.misc.Unsafe)
  (r11v73 sun.misc.Unsafe)
 binds: [B:506:0x0ca1, B:503:0x0c79, B:500:0x0c55, B:497:0x0c31, B:494:0x0c0d, B:491:0x0be8, B:484:0x0bbb, B:470:0x0b7a, B:468:0x0b5f, B:464:0x0b27, B:440:0x0a6b, B:436:0x0a28] A[DONT_GENERATE, DONT_INLINE]
  0x0cb8: PHI (r19v63 int) = 
  (r19v41 int)
  (r19v42 int)
  (r19v43 int)
  (r19v44 int)
  (r19v45 int)
  (r19v46 int)
  (r19v47 int)
  (r19v48 int)
  (r19v49 int)
  (r19v55 int)
  (r19v60 int)
  (r19v64 int)
 binds: [B:506:0x0ca1, B:503:0x0c79, B:500:0x0c55, B:497:0x0c31, B:494:0x0c0d, B:491:0x0be8, B:484:0x0bbb, B:470:0x0b7a, B:468:0x0b5f, B:464:0x0b27, B:440:0x0a6b, B:436:0x0a28] A[DONT_GENERATE, DONT_INLINE]
  0x0cb8: PHI (r27v27 int) = 
  (r27v8 int)
  (r27v9 int)
  (r27v10 int)
  (r27v11 int)
  (r27v12 int)
  (r27v13 int)
  (r27v14 int)
  (r27v15 int)
  (r27v16 int)
  (r27v20 int)
  (r27v24 int)
  (r27v28 int)
 binds: [B:506:0x0ca1, B:503:0x0c79, B:500:0x0c55, B:497:0x0c31, B:494:0x0c0d, B:491:0x0be8, B:484:0x0bbb, B:470:0x0b7a, B:468:0x0b5f, B:464:0x0b27, B:440:0x0a6b, B:436:0x0a28] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:517:0x0ce6  */
    /* JADX WARN: Removed duplicated region for block: B:524:0x0d10  */
    /* JADX WARN: Removed duplicated region for block: B:594:0x09ad A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:597:0x0cbb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:600:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:636:0x09c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:639:0x0ccf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.play_billing.zzdw r39) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3614
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzdw):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final Object zze() {
        return ((zzfi) this.zzg).zzo();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzf(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzgx.zzp(this.zzl, obj, obj2);
                if (this.zzh) {
                    zzgx.zzo(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
            int iZzs = zzs(i);
            int i2 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzho.zzo(obj, j, zzho.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i)) {
                        zzho.zzp(obj, j, zzho.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i)) {
                        zzho.zzm(obj, j, zzho.zzw(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i)) {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i);
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
                    zzfn zzfnVarZzd = (zzfn) zzho.zzf(obj, j);
                    zzfn zzfnVar = (zzfn) zzho.zzf(obj2, j);
                    int size = zzfnVarZzd.size();
                    int size2 = zzfnVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzfnVarZzd.zzc()) {
                            zzfnVarZzd = zzfnVarZzd.zzd(size2 + size);
                        }
                        zzfnVarZzd.addAll(zzfnVar);
                    }
                    if (size > 0) {
                        zzfnVar = zzfnVarZzd;
                    }
                    zzho.zzs(obj, j, zzfnVar);
                    break;
                case 50:
                    int i4 = zzgx.zza;
                    zzho.zzs(obj, j, zzgg.zza(zzho.zzf(obj, j), zzho.zzf(obj2, j)));
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
                    if (zzM(obj2, i3, i)) {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzdw zzdwVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzdwVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzi(java.lang.Object r20, com.google.android.gms.internal.play_billing.zzhu r21) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1620
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzi(java.lang.Object, com.google.android.gms.internal.play_billing.zzhu):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzho.zza(obj, j)) != Double.doubleToLongBits(zzho.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzho.zzb(obj, j)) != Float.floatToIntBits(zzho.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzho.zzw(obj, j) != zzho.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
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
                    zZzE = zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j));
                    break;
                case 50:
                    zZzE = zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j));
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
                    long jZzp = zzp(i) & 1048575;
                    if (zzho.zzc(obj, jZzp) != zzho.zzc(obj2, jZzp) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzE) {
                return false;
            }
        }
        if (!((zzfi) obj).zzc.equals(((zzfi) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzff) obj).zzb.equals(((zzff) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0099  */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzk(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzk(java.lang.Object):boolean");
    }
}
