package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzado<T> implements zzadx<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzaet.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzadl zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzaem zzm;
    private final zzabr zzn;

    private zzado(int[] iArr, Object[] objArr, int i, int i2, zzadl zzadlVar, boolean z, int[] iArr2, int i3, int i4, zzadr zzadrVar, zzacy zzacyVar, zzaem zzaemVar, zzabr zzabrVar, zzadg zzadgVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzadlVar instanceof zzacf;
        boolean z2 = false;
        if (zzabrVar != null && (zzadlVar instanceof zzacc)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzaemVar;
        this.zzn = zzabrVar;
        this.zzg = zzadlVar;
    }

    private final Object zzA(Object obj, int i) {
        zzadx zzadxVarZzx = zzx(i);
        int iZzu = zzu(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzadxVarZzx.zze();
        }
        Object object = zzb.getObject(obj, iZzu);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzadxVarZzx.zze();
        if (object != null) {
            zzadxVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzB(Object obj, int i, int i2) {
        zzadx zzadxVarZzx = zzx(i2);
        if (!zzR(obj, i, i2)) {
            return zzadxVarZzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i2) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzadxVarZzx.zze();
        if (object != null) {
            zzadxVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzC(Class cls, String str) {
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
            zzadx zzadxVarZzx = zzx(i);
            if (!zzN(obj, i)) {
                if (zzQ(object)) {
                    Object objZze = zzadxVarZzx.zze();
                    zzadxVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzH(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzadxVarZzx.zze();
                zzadxVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzadxVarZzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i) {
        int i2 = this.zzc[i];
        if (zzR(obj2, i2, i)) {
            int iZzu = zzu(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzu;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzadx zzadxVarZzx = zzx(i);
            if (!zzR(obj, i2, i)) {
                if (zzQ(object)) {
                    Object objZze = zzadxVarZzx.zze();
                    zzadxVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzI(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzQ(object2)) {
                Object objZze2 = zzadxVarZzx.zze();
                zzadxVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzadxVarZzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i, zzadw zzadwVar) throws IOException {
        long j = i & 1048575;
        if (zzM(i)) {
            zzaet.zzs(obj, j, zzadwVar.zzu());
        } else if (this.zzi) {
            zzaet.zzs(obj, j, zzadwVar.zzt());
        } else {
            zzaet.zzs(obj, j, zzadwVar.zzp());
        }
    }

    private final void zzH(Object obj, int i) {
        int iZzr = zzr(i);
        long j = 1048575 & iZzr;
        if (j == 1048575) {
            return;
        }
        zzaet.zzq(obj, j, (1 << (iZzr >>> 20)) | zzaet.zzc(obj, j));
    }

    private final void zzI(Object obj, int i, int i2) {
        zzaet.zzq(obj, zzr(i2) & 1048575, i);
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
            return (zzaet.zzc(obj, j) & (1 << (iZzr >>> 20))) != 0;
        }
        int iZzu = zzu(i);
        long j2 = iZzu & 1048575;
        switch (zzt(iZzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzaet.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzaet.zzb(obj, j2)) != 0;
            case 2:
                return zzaet.zzd(obj, j2) != 0;
            case 3:
                return zzaet.zzd(obj, j2) != 0;
            case 4:
                return zzaet.zzc(obj, j2) != 0;
            case 5:
                return zzaet.zzd(obj, j2) != 0;
            case 6:
                return zzaet.zzc(obj, j2) != 0;
            case 7:
                return zzaet.zzw(obj, j2);
            case 8:
                Object objZzf = zzaet.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzyx) {
                    return !zzyx.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzaet.zzf(obj, j2) != null;
            case 10:
                return !zzyx.zzb.equals(zzaet.zzf(obj, j2));
            case 11:
                return zzaet.zzc(obj, j2) != 0;
            case 12:
                return zzaet.zzc(obj, j2) != 0;
            case 13:
                return zzaet.zzc(obj, j2) != 0;
            case 14:
                return zzaet.zzd(obj, j2) != 0;
            case 15:
                return zzaet.zzc(obj, j2) != 0;
            case 16:
                return zzaet.zzd(obj, j2) != 0;
            case 17:
                return zzaet.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzN(obj, i) : (i3 & i4) != 0;
    }

    private static boolean zzP(Object obj, int i, zzadx zzadxVar) {
        return zzadxVar.zzl(zzaet.zzf(obj, i & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzacf) {
            return ((zzacf) obj).zzar();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i, int i2) {
        return zzaet.zzc(obj, (long) (zzr(i2) & 1048575)) == i;
    }

    private static boolean zzS(Object obj, long j) {
        return ((Boolean) zzaet.zzf(obj, j)).booleanValue();
    }

    private static final void zzT(int i, Object obj, zzaez zzaezVar) throws IOException {
        if (obj instanceof String) {
            zzaezVar.zzG(i, (String) obj);
        } else {
            zzaezVar.zzd(i, (zzyx) obj);
        }
    }

    static zzaen zzd(Object obj) {
        zzacf zzacfVar = (zzacf) obj;
        zzaen zzaenVar = zzacfVar.zzc;
        if (zzaenVar != zzaen.zzc()) {
            return zzaenVar;
        }
        zzaen zzaenVarZzf = zzaen.zzf();
        zzacfVar.zzc = zzaenVarZzf;
        return zzaenVarZzf;
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
    static com.google.android.gms.internal.gtm.zzado zzm(java.lang.Class r34, com.google.android.gms.internal.gtm.zzadi r35, com.google.android.gms.internal.gtm.zzadr r36, com.google.android.gms.internal.gtm.zzacy r37, com.google.android.gms.internal.gtm.zzaem r38, com.google.android.gms.internal.gtm.zzabr r39, com.google.android.gms.internal.gtm.zzadg r40) {
        /*
            Method dump skipped, instruction units count: 1036
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzado.zzm(java.lang.Class, com.google.android.gms.internal.gtm.zzadi, com.google.android.gms.internal.gtm.zzadr, com.google.android.gms.internal.gtm.zzacy, com.google.android.gms.internal.gtm.zzaem, com.google.android.gms.internal.gtm.zzabr, com.google.android.gms.internal.gtm.zzadg):com.google.android.gms.internal.gtm.zzado");
    }

    private static double zzn(Object obj, long j) {
        return ((Double) zzaet.zzf(obj, j)).doubleValue();
    }

    private static float zzo(Object obj, long j) {
        return ((Float) zzaet.zzf(obj, j)).floatValue();
    }

    private static int zzp(Object obj, long j) {
        return ((Integer) zzaet.zzf(obj, j)).intValue();
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

    private static int zzt(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzu(int i) {
        return this.zzc[i + 1];
    }

    private static long zzv(Object obj, long j) {
        return ((Long) zzaet.zzf(obj, j)).longValue();
    }

    private final zzacj zzw(int i) {
        int i2 = i / 3;
        return (zzacj) this.zzd[i2 + i2 + 1];
    }

    private final zzadx zzx(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzadx zzadxVar = (zzadx) objArr[i3];
        if (zzadxVar != null) {
            return zzadxVar;
        }
        zzadx zzadxVarZzb = zzadt.zza().zzb((Class) objArr[i3 + 1]);
        this.zzd[i3] = zzadxVarZzb;
        return zzadxVarZzb;
    }

    private final Object zzy(Object obj, int i, Object obj2, zzaem zzaemVar, Object obj3) {
        int i2 = this.zzc[i];
        Object objZzf = zzaet.zzf(obj, zzu(i) & 1048575);
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
    /* JADX WARN: Removed duplicated region for block: B:207:0x054e  */
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
    /* JADX WARN: Type inference failed for: r1v120, types: [int] */
    /* JADX WARN: Type inference failed for: r1v123, types: [int] */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v169 */
    /* JADX WARN: Type inference failed for: r1v170 */
    /* JADX WARN: Type inference failed for: r1v80, types: [int] */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v37 */
    /* JADX WARN: Type inference failed for: r2v38, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46, types: [int] */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55, types: [int] */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27, types: [int] */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v30, types: [int] */
    /* JADX WARN: Type inference failed for: r3v35 */
    /* JADX WARN: Type inference failed for: r3v39, types: [int] */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r3v46, types: [int] */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.gtm.zzadx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 2198
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzado.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.zzc.length; i4 += 3) {
            int iZzu = zzu(i4);
            int[] iArr = this.zzc;
            int i5 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iZzt) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzaet.zza(obj, j));
                    byte[] bArr = zzaco.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzaet.zzb(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = zzaet.zzd(obj, j);
                    byte[] bArr2 = zzaco.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = zzaet.zzd(obj, j);
                    byte[] bArr3 = zzaco.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = zzaet.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = zzaet.zzd(obj, j);
                    byte[] bArr4 = zzaco.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = zzaet.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = zzaco.zza(zzaet.zzw(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) zzaet.zzf(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objZzf = zzaet.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = zzaet.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = zzaet.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = zzaet.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = zzaet.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = zzaet.zzd(obj, j);
                    byte[] bArr5 = zzaco.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = zzaet.zzc(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = zzaet.zzd(obj, j);
                    byte[] bArr6 = zzaco.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objZzf2 = zzaet.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i3 = i2 + iHashCode;
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
                    i = i3 * 53;
                    iFloatToIntBits = zzaet.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    iFloatToIntBits = zzaet.zzf(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzn(obj, j));
                        byte[] bArr7 = zzaco.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzo(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr8 = zzaco.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr9 = zzaco.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr10 = zzaco.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzaco.zza(zzS(obj, j));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) zzaet.zzf(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzaet.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzaet.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr11 = zzaco.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzp(obj, j);
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = zzv(obj, j);
                        byte[] bArr12 = zzaco.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzR(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = zzaet.zzf(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i3 * 53) + ((zzacf) obj).zzc.hashCode();
        return this.zzh ? (iHashCode2 * 53) + ((zzacc) obj).zza.zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:556:0x0e34, code lost:
    
        if (r5 == 1048575) goto L558;
     */
    /* JADX WARN: Code restructure failed: missing block: B:557:0x0e36, code lost:
    
        r31.putInt(r35, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:558:0x0e3c, code lost:
    
        r11 = r34.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:560:0x0e41, code lost:
    
        if (r11 >= r34.zzl) goto L664;
     */
    /* JADX WARN: Code restructure failed: missing block: B:561:0x0e43, code lost:
    
        zzy(r35, r34.zzj[r11], null, r34.zzm, r35);
        r13 = (com.google.android.gms.internal.gtm.zzaen) null;
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:563:0x0e5b, code lost:
    
        if (r9 != 0) goto L568;
     */
    /* JADX WARN: Code restructure failed: missing block: B:564:0x0e5d, code lost:
    
        if (r10 != r8) goto L566;
     */
    /* JADX WARN: Code restructure failed: missing block: B:567:0x0e65, code lost:
    
        throw new com.google.android.gms.internal.gtm.zzacq("Failed to parse the message.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:568:0x0e66, code lost:
    
        if (r10 > r8) goto L571;
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x0e68, code lost:
    
        if (r12 != r9) goto L571;
     */
    /* JADX WARN: Code restructure failed: missing block: B:570:0x0e6a, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:572:0x0e70, code lost:
    
        throw new com.google.android.gms.internal.gtm.zzacq("Failed to parse the message.");
     */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0bce A[PHI: r0 r2 r11 r12 r23
  0x0bce: PHI (r0v144 int) = (r0v111 int), (r0v112 int), (r0v113 int), (r0v114 int), (r0v115 int), (r0v131 int), (r0v145 int) binds: [B:485:0x0bb7, B:482:0x0b99, B:479:0x0b7e, B:476:0x0b64, B:473:0x0b49, B:471:0x0b3f, B:413:0x09b3] A[DONT_GENERATE, DONT_INLINE]
  0x0bce: PHI (r2v95 boolean) = (r2v67 boolean), (r2v68 boolean), (r2v69 boolean), (r2v70 boolean), (r2v71 boolean), (r2v87 boolean), (r2v96 boolean) binds: [B:485:0x0bb7, B:482:0x0b99, B:479:0x0b7e, B:476:0x0b64, B:473:0x0b49, B:471:0x0b3f, B:413:0x09b3] A[DONT_GENERATE, DONT_INLINE]
  0x0bce: PHI (r11v45 com.google.android.gms.internal.gtm.zzyl) = 
  (r11v20 com.google.android.gms.internal.gtm.zzyl)
  (r11v21 com.google.android.gms.internal.gtm.zzyl)
  (r11v22 com.google.android.gms.internal.gtm.zzyl)
  (r11v23 com.google.android.gms.internal.gtm.zzyl)
  (r11v24 com.google.android.gms.internal.gtm.zzyl)
  (r11v34 com.google.android.gms.internal.gtm.zzyl)
  (r11v46 com.google.android.gms.internal.gtm.zzyl)
 binds: [B:485:0x0bb7, B:482:0x0b99, B:479:0x0b7e, B:476:0x0b64, B:473:0x0b49, B:471:0x0b3f, B:413:0x09b3] A[DONT_GENERATE, DONT_INLINE]
  0x0bce: PHI (r12v31 int) = (r12v17 int), (r12v17 int), (r12v17 int), (r12v17 int), (r12v17 int), (r12v23 int), (r12v17 int) binds: [B:485:0x0bb7, B:482:0x0b99, B:479:0x0b7e, B:476:0x0b64, B:473:0x0b49, B:471:0x0b3f, B:413:0x09b3] A[DONT_GENERATE, DONT_INLINE]
  0x0bce: PHI (r23v25 int) = (r23v7 int), (r23v8 int), (r23v9 int), (r23v10 int), (r23v11 int), (r23v18 int), (r23v26 int) binds: [B:485:0x0bb7, B:482:0x0b99, B:479:0x0b7e, B:476:0x0b64, B:473:0x0b49, B:471:0x0b3f, B:413:0x09b3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:489:0x0bd1  */
    /* JADX WARN: Removed duplicated region for block: B:490:0x0be3  */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0dec  */
    /* JADX WARN: Removed duplicated region for block: B:548:0x0df0  */
    /* JADX WARN: Removed duplicated region for block: B:551:0x0df7  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x093e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:654:0x0950 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzc(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.gtm.zzyl r40) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3882
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzado.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.gtm.zzyl):int");
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final Object zze() {
        return ((zzacf) this.zzg).zzae();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    @Override // com.google.android.gms.internal.gtm.zzadx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzado.zzf(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            int i2 = 1048575 & iZzu;
            int[] iArr = this.zzc;
            int iZzt = zzt(iZzu);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzt) {
                case 0:
                    if (zzN(obj2, i)) {
                        zzaet.zzo(obj, j, zzaet.zza(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i)) {
                        zzaet.zzp(obj, j, zzaet.zzb(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i)) {
                        zzaet.zzr(obj, j, zzaet.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i)) {
                        zzaet.zzr(obj, j, zzaet.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i)) {
                        zzaet.zzq(obj, j, zzaet.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i)) {
                        zzaet.zzr(obj, j, zzaet.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i)) {
                        zzaet.zzq(obj, j, zzaet.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i)) {
                        zzaet.zzm(obj, j, zzaet.zzw(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i)) {
                        zzaet.zzs(obj, j, zzaet.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 9:
                    zzE(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzaet.zzs(obj, j, zzaet.zzf(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i)) {
                        zzaet.zzq(obj, j, zzaet.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i)) {
                        zzaet.zzq(obj, j, zzaet.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i)) {
                        zzaet.zzq(obj, j, zzaet.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i)) {
                        zzaet.zzr(obj, j, zzaet.zzd(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i)) {
                        zzaet.zzq(obj, j, zzaet.zzc(obj2, j));
                        zzH(obj, i);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i)) {
                        zzaet.zzr(obj, j, zzaet.zzd(obj2, j));
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
                    zzacn zzacnVarZzd = (zzacn) zzaet.zzf(obj, j);
                    zzacn zzacnVar = (zzacn) zzaet.zzf(obj2, j);
                    int size = zzacnVarZzd.size();
                    int size2 = zzacnVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzacnVarZzd.zzc()) {
                            zzacnVarZzd = zzacnVarZzd.zzd(size2 + size);
                        }
                        zzacnVarZzd.addAll(zzacnVar);
                    }
                    if (size > 0) {
                        zzacnVar = zzacnVarZzd;
                    }
                    zzaet.zzs(obj, j, zzacnVar);
                    break;
                case 50:
                    int i4 = zzadz.zza;
                    zzaet.zzs(obj, j, zzadg.zzb(zzaet.zzf(obj, j), zzaet.zzf(obj2, j)));
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
                        zzaet.zzs(obj, j, zzaet.zzf(obj2, j));
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
                        zzaet.zzs(obj, j, zzaet.zzf(obj2, j));
                        zzI(obj, i3, i);
                    }
                    break;
                case 68:
                    zzF(obj, obj2, i);
                    break;
            }
        }
        zzadz.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzadz.zzp(this.zzn, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:196:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0193 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x018e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:411:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.gtm.zzadx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzh(java.lang.Object r12, com.google.android.gms.internal.gtm.zzadw r13, com.google.android.gms.internal.gtm.zzabq r14) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1894
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzado.zzh(java.lang.Object, com.google.android.gms.internal.gtm.zzadw, com.google.android.gms.internal.gtm.zzabq):void");
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final void zzi(Object obj, byte[] bArr, int i, int i2, zzyl zzylVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzylVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.gtm.zzadx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzj(java.lang.Object r24, com.google.android.gms.internal.gtm.zzaez r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1844
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzado.zzj(java.lang.Object, com.google.android.gms.internal.gtm.zzaez):void");
    }

    @Override // com.google.android.gms.internal.gtm.zzadx
    public final boolean zzk(Object obj, Object obj2) {
        boolean zZzJ;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzu = zzu(i);
            long j = iZzu & 1048575;
            switch (zzt(iZzu)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzaet.zza(obj, j)) != Double.doubleToLongBits(zzaet.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzaet.zzb(obj, j)) != Float.floatToIntBits(zzaet.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzaet.zzd(obj, j) != zzaet.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzaet.zzd(obj, j) != zzaet.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzaet.zzc(obj, j) != zzaet.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzaet.zzd(obj, j) != zzaet.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzaet.zzc(obj, j) != zzaet.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzaet.zzw(obj, j) != zzaet.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzadz.zzJ(zzaet.zzf(obj, j), zzaet.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzadz.zzJ(zzaet.zzf(obj, j), zzaet.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzadz.zzJ(zzaet.zzf(obj, j), zzaet.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzaet.zzc(obj, j) != zzaet.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzaet.zzc(obj, j) != zzaet.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzaet.zzc(obj, j) != zzaet.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzaet.zzd(obj, j) != zzaet.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzaet.zzc(obj, j) != zzaet.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzaet.zzd(obj, j) != zzaet.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzadz.zzJ(zzaet.zzf(obj, j), zzaet.zzf(obj2, j))) {
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
                    zZzJ = zzadz.zzJ(zzaet.zzf(obj, j), zzaet.zzf(obj2, j));
                    break;
                case 50:
                    zZzJ = zzadz.zzJ(zzaet.zzf(obj, j), zzaet.zzf(obj2, j));
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
                    if (zzaet.zzc(obj, jZzr) != zzaet.zzc(obj2, jZzr) || !zzadz.zzJ(zzaet.zzf(obj, j), zzaet.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzJ) {
                return false;
            }
        }
        if (!((zzacf) obj).zzc.equals(((zzacf) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzacc) obj).zza.equals(((zzacc) obj2).zza);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // com.google.android.gms.internal.gtm.zzadx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzl(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzado.zzl(java.lang.Object):boolean");
    }
}
