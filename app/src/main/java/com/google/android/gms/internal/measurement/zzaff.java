package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaff<T> implements zzafp<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzagg.zzp();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzafc zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzafz zzm;
    private final zzadg zzn;

    private zzaff(int[] iArr, Object[] objArr, int i, int i2, zzafc zzafcVar, boolean z, int[] iArr2, int i3, int i4, zzafh zzafhVar, zzaeo zzaeoVar, zzafz zzafzVar, zzadg zzadgVar, zzaex zzaexVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzafcVar instanceof zzadu;
        boolean z2 = false;
        if (zzadgVar != null && (zzafcVar instanceof zzadr)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzafzVar;
        this.zzn = zzadgVar;
        this.zzg = zzafcVar;
    }

    private final int zzA(int i) {
        return this.zzc[i + 1];
    }

    private final int zzB(int i) {
        return this.zzc[i + 2];
    }

    private static int zzC(int i) {
        return (i >>> 20) & 255;
    }

    private static boolean zzD(int i) {
        return (i & 536870912) != 0;
    }

    private static boolean zzE(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzadu) {
            return ((zzadu) obj).zzch();
        }
        return true;
    }

    private static void zzF(Object obj) {
        if (zzE(obj)) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        String.valueOf(strValueOf);
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(strValueOf)));
    }

    private static int zzG(Object obj, long j) {
        return ((Integer) zzagg.zzm(obj, j)).intValue();
    }

    private static long zzH(Object obj, long j) {
        return ((Long) zzagg.zzm(obj, j)).longValue();
    }

    private final boolean zzI(Object obj, Object obj2, int i) {
        return zzK(obj, i) == zzK(obj2, i);
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzK(obj, i) : (i3 & i4) != 0;
    }

    private final boolean zzK(Object obj, int i) {
        int iZzB = zzB(i);
        long j = iZzB & 1048575;
        if (j != 1048575) {
            return (zzagg.zzc(obj, j) & (1 << (iZzB >>> 20))) != 0;
        }
        int iZzA = zzA(i);
        long j2 = iZzA & 1048575;
        switch (zzC(iZzA)) {
            case 0:
                return Double.doubleToRawLongBits(zzagg.zzk(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzagg.zzi(obj, j2)) != 0;
            case 2:
                return zzagg.zze(obj, j2) != 0;
            case 3:
                return zzagg.zze(obj, j2) != 0;
            case 4:
                return zzagg.zzc(obj, j2) != 0;
            case 5:
                return zzagg.zze(obj, j2) != 0;
            case 6:
                return zzagg.zzc(obj, j2) != 0;
            case 7:
                return zzagg.zzg(obj, j2);
            case 8:
                Object objZzm = zzagg.zzm(obj, j2);
                return objZzm instanceof String ? !((String) objZzm).isEmpty() : objZzm instanceof zzacr ? !zzacr.zza.equals(objZzm) : zzR();
            case 9:
                return zzagg.zzm(obj, j2) != null;
            case 10:
                return !zzacr.zza.equals(zzagg.zzm(obj, j2));
            case 11:
                return zzagg.zzc(obj, j2) != 0;
            case 12:
                return zzagg.zzc(obj, j2) != 0;
            case 13:
                return zzagg.zzc(obj, j2) != 0;
            case 14:
                return zzagg.zze(obj, j2) != 0;
            case 15:
                return zzagg.zzc(obj, j2) != 0;
            case 16:
                return zzagg.zze(obj, j2) != 0;
            case 17:
                return zzagg.zzm(obj, j2) != null;
            default:
                return zzR();
        }
    }

    private final void zzL(Object obj, int i) {
        int iZzB = zzB(i);
        long j = 1048575 & iZzB;
        if (j == 1048575) {
            return;
        }
        zzagg.zzd(obj, j, (1 << (iZzB >>> 20)) | zzagg.zzc(obj, j));
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzagg.zzc(obj, (long) (zzB(i2) & 1048575)) == i;
    }

    private final boolean zzN(Object obj, Object obj2, int i) {
        long jZzB = zzB(i) & 1048575;
        return zzagg.zzc(obj, jZzB) == zzagg.zzc(obj2, jZzB);
    }

    private final void zzO(Object obj, int i, int i2) {
        zzagg.zzd(obj, zzB(i2) & 1048575, i);
    }

    private final int zzP(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzQ(i, 0);
    }

    private final int zzQ(int i, int i2) {
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

    private boolean zzR() {
        throw new IllegalArgumentException();
    }

    private static final int zzS(byte[] bArr, int i, int i2, zzagm zzagmVar, Class cls, zzacg zzacgVar) throws IOException {
        int i3;
        zzagm zzagmVar2 = zzagm.DOUBLE;
        switch (zzagmVar) {
            case DOUBLE:
                i3 = i + 8;
                zzacgVar.zzc = Double.valueOf(Double.longBitsToDouble(zzach.zze(bArr, i)));
                break;
            case FLOAT:
                i3 = i + 4;
                zzacgVar.zzc = Float.valueOf(Float.intBitsToFloat(zzach.zzd(bArr, i)));
                break;
            case INT64:
            case UINT64:
                int iZzc = zzach.zzc(bArr, i, zzacgVar);
                zzacgVar.zzc = Long.valueOf(zzacgVar.zzb);
                return iZzc;
            case INT32:
            case UINT32:
            case ENUM:
                int iZza = zzach.zza(bArr, i, zzacgVar);
                zzacgVar.zzc = Integer.valueOf(zzacgVar.zza);
                return iZza;
            case FIXED64:
            case SFIXED64:
                i3 = i + 8;
                zzacgVar.zzc = Long.valueOf(zzach.zze(bArr, i));
                break;
            case FIXED32:
            case SFIXED32:
                i3 = i + 4;
                zzacgVar.zzc = Integer.valueOf(zzach.zzd(bArr, i));
                break;
            case BOOL:
                int iZzc2 = zzach.zzc(bArr, i, zzacgVar);
                zzacgVar.zzc = Boolean.valueOf(zzacgVar.zzb != 0);
                return iZzc2;
            case STRING:
                return zzach.zzf(bArr, i, zzacgVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return zzach.zzh(zzafl.zza().zzb(cls), bArr, i, i2, zzacgVar);
            case BYTES:
                return zzach.zzg(bArr, i, zzacgVar);
            case SINT32:
                int iZza2 = zzach.zza(bArr, i, zzacgVar);
                zzacgVar.zzc = Integer.valueOf(zzacv.zzR(zzacgVar.zza));
                return iZza2;
            case SINT64:
                int iZzc3 = zzach.zzc(bArr, i, zzacgVar);
                zzacgVar.zzc = Long.valueOf(zzacv.zzS(zzacgVar.zzb));
                return iZzc3;
        }
        return i3;
    }

    private static final void zzT(int i, Object obj, zzago zzagoVar) throws IOException {
        if (obj instanceof String) {
            zzagoVar.zzm(i, (String) obj);
        } else {
            zzagoVar.zzn(i, (zzacr) obj);
        }
    }

    static zzaga zzh(Object obj) {
        zzadu zzaduVar = (zzadu) obj;
        zzaga zzagaVar = zzaduVar.zzc;
        if (zzagaVar != zzaga.zza()) {
            return zzagaVar;
        }
        zzaga zzagaVarZzb = zzaga.zzb();
        zzaduVar.zzc = zzagaVarZzb;
        return zzagaVarZzb;
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x038b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static com.google.android.gms.internal.measurement.zzaff zzm(java.lang.Class r33, com.google.android.gms.internal.measurement.zzaez r34, com.google.android.gms.internal.measurement.zzafh r35, com.google.android.gms.internal.measurement.zzaeo r36, com.google.android.gms.internal.measurement.zzafz r37, com.google.android.gms.internal.measurement.zzadg r38, com.google.android.gms.internal.measurement.zzaex r39) {
        /*
            Method dump skipped, instruction units count: 1012
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzm(java.lang.Class, com.google.android.gms.internal.measurement.zzaez, com.google.android.gms.internal.measurement.zzafh, com.google.android.gms.internal.measurement.zzaeo, com.google.android.gms.internal.measurement.zzafz, com.google.android.gms.internal.measurement.zzadg, com.google.android.gms.internal.measurement.zzaex):com.google.android.gms.internal.measurement.zzaff");
    }

    private static Field zzn(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(name).length() + 29 + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    private final void zzo(Object obj, Object obj2, int i) {
        if (zzK(obj2, i)) {
            int iZzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i2 = this.zzc[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i2);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzafp zzafpVarZzq = zzq(i);
            if (!zzK(obj, i)) {
                if (zzE(object)) {
                    Object objZza = zzafpVarZzq.zza();
                    zzafpVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzL(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object objZza2 = zzafpVarZzq.zza();
                zzafpVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzafpVarZzq.zzd(object2, object);
        }
    }

    private final void zzp(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int iZzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i3 = iArr[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i3);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzafp zzafpVarZzq = zzq(i);
            if (!zzM(obj, i2, i)) {
                if (zzE(object)) {
                    Object objZza = zzafpVarZzq.zza();
                    zzafpVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzO(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object objZza2 = zzafpVarZzq.zza();
                zzafpVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzafpVarZzq.zzd(object2, object);
        }
    }

    private final zzafp zzq(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzafp zzafpVar = (zzafp) objArr[i3];
        if (zzafpVar != null) {
            return zzafpVar;
        }
        zzafp zzafpVarZzb = zzafl.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzafpVarZzb;
        return zzafpVarZzb;
    }

    private final Object zzr(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzadz zzs(int i) {
        int i2 = i / 3;
        return (zzadz) this.zzd[i2 + i2 + 1];
    }

    private final Object zzt(Object obj, int i) {
        zzafp zzafpVarZzq = zzq(i);
        int iZzA = zzA(i) & 1048575;
        if (!zzK(obj, i)) {
            return zzafpVarZzq.zza();
        }
        Object object = zzb.getObject(obj, iZzA);
        if (zzE(object)) {
            return object;
        }
        Object objZza = zzafpVarZzq.zza();
        if (object != null) {
            zzafpVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzu(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzA(i) & 1048575, obj2);
        zzL(obj, i);
    }

    private final Object zzv(Object obj, int i, int i2) {
        zzafp zzafpVarZzq = zzq(i2);
        if (!zzM(obj, i, i2)) {
            return zzafpVarZzq.zza();
        }
        Object object = zzb.getObject(obj, zzA(i2) & 1048575);
        if (zzE(object)) {
            return object;
        }
        Object objZza = zzafpVarZzq.zza();
        if (object != null) {
            zzafpVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzw(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzA(i2) & 1048575, obj2);
        zzO(obj, i, i2);
    }

    private final Object zzx(Object obj, int i, Object obj2, zzafz zzafzVar, Object obj3) {
        zzadz zzadzVarZzs;
        int i2 = this.zzc[i];
        Object objZzm = zzagg.zzm(obj, zzA(i) & 1048575);
        if (objZzm == null || (zzadzVarZzs = zzs(i)) == null) {
            return obj2;
        }
        zzaeu zzaeuVarZze = ((zzaev) zzr(i)).zze();
        Iterator it = ((zzaew) objZzm).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzadzVarZzs.zza(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = zzafzVar.zzh(obj3);
                }
                int iZzc = zzaev.zzc(zzaeuVarZze, entry.getKey(), entry.getValue());
                zzacr zzacrVar = zzacr.zza;
                byte[] bArr = new byte[iZzc];
                int i3 = zzada.zzb;
                zzacx zzacxVar = new zzacx(bArr, 0, iZzc);
                try {
                    zzaev.zzb(zzacxVar, zzaeuVarZze, entry.getKey(), entry.getValue());
                    zzafzVar.zzd(obj2, i2, zzaco.zza(zzacxVar, bArr));
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    private static boolean zzy(Object obj, int i, zzafp zzafpVar) {
        return zzafpVar.zzl(zzagg.zzm(obj, i & 1048575));
    }

    private final void zzz(Object obj, int i, zzafo zzafoVar) throws IOException {
        long j = i & 1048575;
        if (zzD(i)) {
            zzagg.zzn(obj, j, zzafoVar.zzn());
        } else if (this.zzi) {
            zzagg.zzn(obj, j, zzafoVar.zzm());
        } else {
            zzagg.zzn(obj, j, zzafoVar.zzq());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final Object zza() {
        return ((zzadu) this.zzg).zzck();
    }

    /* JADX WARN: Code restructure failed: missing block: B:178:0x01c2, code lost:
    
        continue;
     */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzb(java.lang.Object r7, java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 680
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzb(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final int zzc(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int iHashCode = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int iZzA = zzA(i3);
            int iZzC = zzC(iZzA);
            if (iZzC <= 50 || iZzC >= 69) {
                long j = iZzA & 1048575;
                int iHashCode2 = 37;
                switch (iZzC) {
                    case 0:
                        i = iHashCode * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzagg.zzk(obj, j));
                        byte[] bArr = zzaed.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 1:
                        i = iHashCode * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzagg.zzi(obj, j));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 2:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr2 = zzaed.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 3:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr3 = zzaed.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 4:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzagg.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 5:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr4 = zzaed.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 6:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzagg.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 7:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzaed.zza(zzagg.zzg(obj, j));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 8:
                        i = iHashCode * 53;
                        iFloatToIntBits = ((String) zzagg.zzm(obj, j)).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 9:
                        i2 = iHashCode * 53;
                        Object objZzm = zzagg.zzm(obj, j);
                        if (objZzm != null) {
                            iHashCode2 = objZzm.hashCode();
                        }
                        iHashCode = i2 + iHashCode2;
                        break;
                    case 10:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzagg.zzm(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 11:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzagg.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 12:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzagg.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 13:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzagg.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 14:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr5 = zzaed.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 15:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzagg.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 16:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zzagg.zze(obj, j);
                        byte[] bArr6 = zzaed.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 17:
                        i2 = iHashCode * 53;
                        Object objZzm2 = zzagg.zzm(obj, j);
                        if (objZzm2 != null) {
                            iHashCode2 = objZzm2.hashCode();
                        }
                        iHashCode = i2 + iHashCode2;
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
                        i = iHashCode * 53;
                        iFloatToIntBits = zzagg.zzm(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 50:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzagg.zzm(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                }
            }
        }
        int i4 = this.zzl;
        while (true) {
            int[] iArr = this.zzj;
            if (i4 >= iArr.length) {
                int iHashCode3 = (iHashCode * 53) + ((zzadu) obj).zzc.hashCode();
                return this.zzh ? (iHashCode3 * 53) + ((zzadr) obj).zzb.zza.hashCode() : iHashCode3;
            }
            if (!zzM(obj, 0, iArr[i4])) {
                iHashCode = (iHashCode * 53) + zzagg.zzm(obj, zzA(r3) & 1048575).hashCode();
            }
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzd(Object obj, Object obj2) {
        zzF(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzafq.zzE(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzafq.zzD(this.zzn, obj, obj2);
                    return;
                }
                return;
            }
            int iZzA = zzA(i);
            int i2 = 1048575 & iZzA;
            int iZzC = zzC(iZzA);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzC) {
                case 0:
                    if (zzK(obj2, i)) {
                        zzagg.zzl(obj, j, zzagg.zzk(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 1:
                    if (zzK(obj2, i)) {
                        zzagg.zzj(obj, j, zzagg.zzi(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 2:
                    if (zzK(obj2, i)) {
                        zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 3:
                    if (zzK(obj2, i)) {
                        zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 4:
                    if (zzK(obj2, i)) {
                        zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 5:
                    if (zzK(obj2, i)) {
                        zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 6:
                    if (zzK(obj2, i)) {
                        zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 7:
                    if (zzK(obj2, i)) {
                        zzagg.zzh(obj, j, zzagg.zzg(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 8:
                    if (zzK(obj2, i)) {
                        zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 9:
                    zzo(obj, obj2, i);
                    break;
                case 10:
                    if (zzK(obj2, i)) {
                        zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 11:
                    if (zzK(obj2, i)) {
                        zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 12:
                    if (zzK(obj2, i)) {
                        zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 13:
                    if (zzK(obj2, i)) {
                        zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 14:
                    if (zzK(obj2, i)) {
                        zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 15:
                    if (zzK(obj2, i)) {
                        zzagg.zzd(obj, j, zzagg.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 16:
                    if (zzK(obj2, i)) {
                        zzagg.zzf(obj, j, zzagg.zze(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 17:
                    zzo(obj, obj2, i);
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
                    zzaef zzaefVarZzg = (zzaef) zzagg.zzm(obj, j);
                    zzaef zzaefVar = (zzaef) zzagg.zzm(obj2, j);
                    int size = zzaefVarZzg.size();
                    int size2 = zzaefVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzaefVarZzg.zza()) {
                            zzaefVarZzg = zzaefVarZzg.zzg(size2 + size);
                        }
                        zzaefVarZzg.addAll(zzaefVar);
                    }
                    if (size > 0) {
                        zzaefVar = zzaefVarZzg;
                    }
                    zzagg.zzn(obj, j, zzaefVar);
                    break;
                case 50:
                    int i4 = zzafq.zza;
                    zzagg.zzn(obj, j, zzaex.zzb(zzagg.zzm(obj, j), zzagg.zzm(obj2, j)));
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
                        zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                        zzO(obj, i3, i);
                    }
                    break;
                case 60:
                    zzp(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzagg.zzn(obj, j, zzagg.zzm(obj2, j));
                        zzO(obj, i3, i);
                    }
                    break;
                case 68:
                    zzp(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0560  */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v253, types: [int] */
    /* JADX WARN: Type inference failed for: r0v261 */
    /* JADX WARN: Type inference failed for: r0v263 */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v265 */
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
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v118, types: [int] */
    /* JADX WARN: Type inference failed for: r1v121, types: [int] */
    /* JADX WARN: Type inference failed for: r1v158 */
    /* JADX WARN: Type inference failed for: r1v161 */
    /* JADX WARN: Type inference failed for: r1v162 */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v166 */
    /* JADX WARN: Type inference failed for: r1v78, types: [int] */
    /* JADX WARN: Type inference failed for: r1v80 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v42, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49, types: [int] */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v78, types: [int] */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81, types: [int] */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r2v95 */
    /* JADX WARN: Type inference failed for: r2v96 */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28, types: [int] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v31, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v38, types: [int] */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v45, types: [int] */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r3v59 */
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
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v32, types: [int] */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v37 */
    /* JADX WARN: Type inference failed for: r4v39, types: [int] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zze(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 2214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zze(java.lang.Object):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(java.lang.Object r20, com.google.android.gms.internal.measurement.zzago r21) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1650
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzf(java.lang.Object, com.google.android.gms.internal.measurement.zzago):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:319:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzg(java.lang.Object r11, com.google.android.gms.internal.measurement.zzafo r12, com.google.android.gms.internal.measurement.zzadf r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzg(java.lang.Object, com.google.android.gms.internal.measurement.zzafo, com.google.android.gms.internal.measurement.zzadf):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:446:0x0b20, code lost:
    
        throw new com.google.android.gms.internal.measurement.zzaeh("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:546:0x0e35, code lost:
    
        if (r5 == 1048575) goto L548;
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x0e37, code lost:
    
        r10.putInt(r7, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:0x0e3b, code lost:
    
        r10 = r11.zzk;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:550:0x0e42, code lost:
    
        if (r10 >= r11.zzl) goto L667;
     */
    /* JADX WARN: Code restructure failed: missing block: B:551:0x0e44, code lost:
    
        r3 = (com.google.android.gms.internal.measurement.zzaga) zzx(r35, r11.zzj[r10], r3, r11.zzm, r35);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:552:0x0e5a, code lost:
    
        if (r3 == null) goto L554;
     */
    /* JADX WARN: Code restructure failed: missing block: B:553:0x0e5c, code lost:
    
        r11.zzm.zzi(r7, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:554:0x0e61, code lost:
    
        if (r6 != 0) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:556:0x0e65, code lost:
    
        if (r8 != r38) goto L558;
     */
    /* JADX WARN: Code restructure failed: missing block: B:559:0x0e6f, code lost:
    
        throw new com.google.android.gms.internal.measurement.zzaeh(r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:560:0x0e70, code lost:
    
        r1 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:561:0x0e74, code lost:
    
        if (r8 > r38) goto L564;
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x0e76, code lost:
    
        if (r9 != r6) goto L564;
     */
    /* JADX WARN: Code restructure failed: missing block: B:563:0x0e78, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:565:0x0e7e, code lost:
    
        throw new com.google.android.gms.internal.measurement.zzaeh(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0db1 A[PHI: r0 r5 r7 r8 r12 r21 r31
  0x0db1: PHI (r0v232 int) = 
  (r0v199 int)
  (r0v200 int)
  (r0v201 int)
  (r0v202 int)
  (r0v203 int)
  (r0v204 int)
  (r0v206 int)
  (r0v207 int)
  (r0v210 int)
  (r0v219 int)
  (r0v233 int)
 binds: [B:524:0x0d9a, B:521:0x0d78, B:517:0x0d56, B:514:0x0d38, B:511:0x0d1a, B:508:0x0cfb, B:501:0x0cd2, B:487:0x0c95, B:485:0x0c81, B:481:0x0c49, B:453:0x0b58] A[DONT_GENERATE, DONT_INLINE]
  0x0db1: PHI (r5v71 com.google.android.gms.internal.measurement.zzaff<T>) = 
  (r5v54 com.google.android.gms.internal.measurement.zzaff<T>)
  (r5v55 com.google.android.gms.internal.measurement.zzaff<T>)
  (r5v56 com.google.android.gms.internal.measurement.zzaff<T>)
  (r5v57 com.google.android.gms.internal.measurement.zzaff<T>)
  (r5v58 com.google.android.gms.internal.measurement.zzaff<T>)
  (r5v59 com.google.android.gms.internal.measurement.zzaff<T>)
  (r5v61 com.google.android.gms.internal.measurement.zzaff<T>)
  (r5v62 com.google.android.gms.internal.measurement.zzaff<T>)
  (r5v63 com.google.android.gms.internal.measurement.zzaff<T>)
  (r5v66 com.google.android.gms.internal.measurement.zzaff<T>)
  (r5v72 com.google.android.gms.internal.measurement.zzaff<T>)
 binds: [B:524:0x0d9a, B:521:0x0d78, B:517:0x0d56, B:514:0x0d38, B:511:0x0d1a, B:508:0x0cfb, B:501:0x0cd2, B:487:0x0c95, B:485:0x0c81, B:481:0x0c49, B:453:0x0b58] A[DONT_GENERATE, DONT_INLINE]
  0x0db1: PHI (r7v78 java.lang.Object) = 
  (r7v56 java.lang.Object)
  (r7v57 java.lang.Object)
  (r7v58 java.lang.Object)
  (r7v59 java.lang.Object)
  (r7v60 java.lang.Object)
  (r7v61 java.lang.Object)
  (r7v63 java.lang.Object)
  (r7v64 java.lang.Object)
  (r7v65 java.lang.Object)
  (r7v70 java.lang.Object)
  (r7v79 java.lang.Object)
 binds: [B:524:0x0d9a, B:521:0x0d78, B:517:0x0d56, B:514:0x0d38, B:511:0x0d1a, B:508:0x0cfb, B:501:0x0cd2, B:487:0x0c95, B:485:0x0c81, B:481:0x0c49, B:453:0x0b58] A[DONT_GENERATE, DONT_INLINE]
  0x0db1: PHI (r8v113 int) = 
  (r8v89 int)
  (r8v90 int)
  (r8v91 int)
  (r8v92 int)
  (r8v93 int)
  (r8v94 int)
  (r8v96 int)
  (r8v97 int)
  (r8v98 int)
  (r8v103 int)
  (r8v114 int)
 binds: [B:524:0x0d9a, B:521:0x0d78, B:517:0x0d56, B:514:0x0d38, B:511:0x0d1a, B:508:0x0cfb, B:501:0x0cd2, B:487:0x0c95, B:485:0x0c81, B:481:0x0c49, B:453:0x0b58] A[DONT_GENERATE, DONT_INLINE]
  0x0db1: PHI (r12v75 com.google.android.gms.internal.measurement.zzacg) = 
  (r12v50 com.google.android.gms.internal.measurement.zzacg)
  (r12v51 com.google.android.gms.internal.measurement.zzacg)
  (r12v52 com.google.android.gms.internal.measurement.zzacg)
  (r12v53 com.google.android.gms.internal.measurement.zzacg)
  (r12v54 com.google.android.gms.internal.measurement.zzacg)
  (r12v55 com.google.android.gms.internal.measurement.zzacg)
  (r12v57 com.google.android.gms.internal.measurement.zzacg)
  (r12v58 com.google.android.gms.internal.measurement.zzacg)
  (r12v60 com.google.android.gms.internal.measurement.zzacg)
  (r12v68 com.google.android.gms.internal.measurement.zzacg)
  (r12v76 com.google.android.gms.internal.measurement.zzacg)
 binds: [B:524:0x0d9a, B:521:0x0d78, B:517:0x0d56, B:514:0x0d38, B:511:0x0d1a, B:508:0x0cfb, B:501:0x0cd2, B:487:0x0c95, B:485:0x0c81, B:481:0x0c49, B:453:0x0b58] A[DONT_GENERATE, DONT_INLINE]
  0x0db1: PHI (r21v24 int) = 
  (r21v16 int)
  (r21v16 int)
  (r21v16 int)
  (r21v16 int)
  (r21v16 int)
  (r21v16 int)
  (r21v16 int)
  (r21v16 int)
  (r21v17 int)
  (r21v21 int)
  (r21v16 int)
 binds: [B:524:0x0d9a, B:521:0x0d78, B:517:0x0d56, B:514:0x0d38, B:511:0x0d1a, B:508:0x0cfb, B:501:0x0cd2, B:487:0x0c95, B:485:0x0c81, B:481:0x0c49, B:453:0x0b58] A[DONT_GENERATE, DONT_INLINE]
  0x0db1: PHI (r31v45 int) = 
  (r31v25 int)
  (r31v26 int)
  (r31v27 int)
  (r31v28 int)
  (r31v29 int)
  (r31v30 int)
  (r31v32 int)
  (r31v33 int)
  (r31v34 int)
  (r31v38 int)
  (r31v46 int)
 binds: [B:524:0x0d9a, B:521:0x0d78, B:517:0x0d56, B:514:0x0d38, B:511:0x0d1a, B:508:0x0cfb, B:501:0x0cd2, B:487:0x0c95, B:485:0x0c81, B:481:0x0c49, B:453:0x0b58] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0e07  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x09b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:612:0x0db4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:651:0x09c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:656:0x0dc6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzi(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.measurement.zzacg r40) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3856
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzi(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzacg):int");
    }

    @Override // com.google.android.gms.internal.measurement.zzafp
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzacg zzacgVar) throws IOException {
        zzi(obj, bArr, i, i2, 0, zzacgVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzk(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzk(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00cb  */
    @Override // com.google.android.gms.internal.measurement.zzafp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzl(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzaff.zzl(java.lang.Object):boolean");
    }
}
