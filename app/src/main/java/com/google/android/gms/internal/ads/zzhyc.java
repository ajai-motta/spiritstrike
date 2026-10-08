package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhyc<T> implements zzhyr<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhzj.zzt();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzhxz zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhzc zzm;
    private final zzhvz zzn;

    private zzhyc(int[] iArr, Object[] objArr, int i, int i2, zzhxz zzhxzVar, boolean z, int[] iArr2, int i3, int i4, zzhyf zzhyfVar, zzhxl zzhxlVar, zzhzc zzhzcVar, zzhvz zzhvzVar, zzhxu zzhxuVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzhxzVar instanceof zzhwo;
        boolean z2 = false;
        if (zzhvzVar != null && (zzhxzVar instanceof zzhwk)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzhzcVar;
        this.zzn = zzhvzVar;
        this.zzg = zzhxzVar;
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
        if (obj instanceof zzhwo) {
            return ((zzhwo) obj).zzaX();
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

    private static double zzG(Object obj, long j) {
        return ((Double) zzhzj.zzn(obj, j)).doubleValue();
    }

    private static float zzH(Object obj, long j) {
        return ((Float) zzhzj.zzn(obj, j)).floatValue();
    }

    private static int zzI(Object obj, long j) {
        return ((Integer) zzhzj.zzn(obj, j)).intValue();
    }

    private static long zzJ(Object obj, long j) {
        return ((Long) zzhzj.zzn(obj, j)).longValue();
    }

    private static boolean zzK(Object obj, long j) {
        return ((Boolean) zzhzj.zzn(obj, j)).booleanValue();
    }

    private final boolean zzL(Object obj, Object obj2, int i) {
        return zzN(obj, i) == zzN(obj2, i);
    }

    private final boolean zzM(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? zzN(obj, i) : (i3 & i4) != 0;
    }

    private final boolean zzN(Object obj, int i) {
        int iZzB = zzB(i);
        long j = iZzB & 1048575;
        if (j != 1048575) {
            return (zzhzj.zzd(obj, j) & (1 << (iZzB >>> 20))) != 0;
        }
        int iZzA = zzA(i);
        long j2 = iZzA & 1048575;
        switch (zzC(iZzA)) {
            case 0:
                return Double.doubleToRawLongBits(zzhzj.zzl(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhzj.zzj(obj, j2)) != 0;
            case 2:
                return zzhzj.zzf(obj, j2) != 0;
            case 3:
                return zzhzj.zzf(obj, j2) != 0;
            case 4:
                return zzhzj.zzd(obj, j2) != 0;
            case 5:
                return zzhzj.zzf(obj, j2) != 0;
            case 6:
                return zzhzj.zzd(obj, j2) != 0;
            case 7:
                return zzhzj.zzh(obj, j2);
            case 8:
                Object objZzn = zzhzj.zzn(obj, j2);
                if (objZzn instanceof String) {
                    return !((String) objZzn).isEmpty();
                }
                if (objZzn instanceof zzhvi) {
                    return !zzhvi.zzb.equals(objZzn);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhzj.zzn(obj, j2) != null;
            case 10:
                return !zzhvi.zzb.equals(zzhzj.zzn(obj, j2));
            case 11:
                return zzhzj.zzd(obj, j2) != 0;
            case 12:
                return zzhzj.zzd(obj, j2) != 0;
            case 13:
                return zzhzj.zzd(obj, j2) != 0;
            case 14:
                return zzhzj.zzf(obj, j2) != 0;
            case 15:
                return zzhzj.zzd(obj, j2) != 0;
            case 16:
                return zzhzj.zzf(obj, j2) != 0;
            case 17:
                return zzhzj.zzn(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzO(Object obj, int i) {
        int iZzB = zzB(i);
        long j = 1048575 & iZzB;
        if (j == 1048575) {
            return;
        }
        zzhzj.zze(obj, j, (1 << (iZzB >>> 20)) | zzhzj.zzd(obj, j));
    }

    private final boolean zzP(Object obj, int i, int i2) {
        return zzhzj.zzd(obj, (long) (zzB(i2) & 1048575)) == i;
    }

    private final void zzQ(Object obj, int i, int i2) {
        zzhzj.zze(obj, zzB(i2) & 1048575, i);
    }

    private final int zzR(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzS(i, 0);
    }

    private final int zzS(int i, int i2) {
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

    private static final int zzT(byte[] bArr, int i, int i2, zzhzp zzhzpVar, Class cls, zzhuw zzhuwVar) throws IOException {
        int i3;
        zzhzp zzhzpVar2 = zzhzp.DOUBLE;
        switch (zzhzpVar) {
            case DOUBLE:
                i3 = i + 8;
                zzhuwVar.zzc = Double.valueOf(Double.longBitsToDouble(zzhux.zze(bArr, i)));
                break;
            case FLOAT:
                i3 = i + 4;
                zzhuwVar.zzc = Float.valueOf(Float.intBitsToFloat(zzhux.zzd(bArr, i)));
                break;
            case INT64:
            case UINT64:
                int iZzc = zzhux.zzc(bArr, i, zzhuwVar);
                zzhuwVar.zzc = Long.valueOf(zzhuwVar.zzb);
                return iZzc;
            case INT32:
            case UINT32:
            case ENUM:
                int iZza = zzhux.zza(bArr, i, zzhuwVar);
                zzhuwVar.zzc = Integer.valueOf(zzhuwVar.zza);
                return iZza;
            case FIXED64:
            case SFIXED64:
                i3 = i + 8;
                zzhuwVar.zzc = Long.valueOf(zzhux.zze(bArr, i));
                break;
            case FIXED32:
            case SFIXED32:
                i3 = i + 4;
                zzhuwVar.zzc = Integer.valueOf(zzhux.zzd(bArr, i));
                break;
            case BOOL:
                int iZzc2 = zzhux.zzc(bArr, i, zzhuwVar);
                zzhuwVar.zzc = Boolean.valueOf(zzhuwVar.zzb != 0);
                return iZzc2;
            case STRING:
                return zzhux.zzf(bArr, i, zzhuwVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return zzhux.zzh(zzhyj.zza().zzb(cls), bArr, i, i2, zzhuwVar);
            case BYTES:
                return zzhux.zzg(bArr, i, zzhuwVar);
            case SINT32:
                int iZza2 = zzhux.zza(bArr, i, zzhuwVar);
                zzhuwVar.zzc = Integer.valueOf(zzhvn.zzK(zzhuwVar.zza));
                return iZza2;
            case SINT64:
                int iZzc3 = zzhux.zzc(bArr, i, zzhuwVar);
                zzhuwVar.zzc = Long.valueOf(zzhvn.zzL(zzhuwVar.zzb));
                return iZzc3;
        }
        return i3;
    }

    private static final void zzU(int i, Object obj, zzhzr zzhzrVar) throws IOException {
        if (obj instanceof String) {
            zzhzrVar.zzm(i, (String) obj);
        } else {
            zzhzrVar.zzn(i, (zzhvi) obj);
        }
    }

    static zzhzd zzh(Object obj) {
        zzhwo zzhwoVar = (zzhwo) obj;
        zzhzd zzhzdVar = zzhwoVar.zzt;
        if (zzhzdVar != zzhzd.zza()) {
            return zzhzdVar;
        }
        zzhzd zzhzdVarZzb = zzhzd.zzb();
        zzhwoVar.zzt = zzhzdVarZzb;
        return zzhzdVarZzb;
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
    static com.google.android.gms.internal.ads.zzhyc zzm(java.lang.Class r34, com.google.android.gms.internal.ads.zzhxw r35, com.google.android.gms.internal.ads.zzhyf r36, com.google.android.gms.internal.ads.zzhxl r37, com.google.android.gms.internal.ads.zzhzc r38, com.google.android.gms.internal.ads.zzhvz r39, com.google.android.gms.internal.ads.zzhxu r40) {
        /*
            Method dump skipped, instruction units count: 1036
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyc.zzm(java.lang.Class, com.google.android.gms.internal.ads.zzhxw, com.google.android.gms.internal.ads.zzhyf, com.google.android.gms.internal.ads.zzhxl, com.google.android.gms.internal.ads.zzhzc, com.google.android.gms.internal.ads.zzhvz, com.google.android.gms.internal.ads.zzhxu):com.google.android.gms.internal.ads.zzhyc");
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
        if (zzN(obj2, i)) {
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
            zzhyr zzhyrVarZzq = zzq(i);
            if (!zzN(obj, i)) {
                if (zzE(object)) {
                    Object objZza = zzhyrVarZzq.zza();
                    zzhyrVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzO(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object objZza2 = zzhyrVarZzq.zza();
                zzhyrVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzhyrVarZzq.zzd(object2, object);
        }
    }

    private final void zzp(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzP(obj2, i2, i)) {
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
            zzhyr zzhyrVarZzq = zzq(i);
            if (!zzP(obj, i2, i)) {
                if (zzE(object)) {
                    Object objZza = zzhyrVarZzq.zza();
                    zzhyrVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzQ(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object objZza2 = zzhyrVarZzq.zza();
                zzhyrVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzhyrVarZzq.zzd(object2, object);
        }
    }

    private final zzhyr zzq(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzhyr zzhyrVar = (zzhyr) objArr[i3];
        if (zzhyrVar != null) {
            return zzhyrVar;
        }
        zzhyr zzhyrVarZzb = zzhyj.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzhyrVarZzb;
        return zzhyrVarZzb;
    }

    private final Object zzr(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zzhwu zzs(int i) {
        int i2 = i / 3;
        return (zzhwu) this.zzd[i2 + i2 + 1];
    }

    private final Object zzt(Object obj, int i) {
        zzhyr zzhyrVarZzq = zzq(i);
        int iZzA = zzA(i) & 1048575;
        if (!zzN(obj, i)) {
            return zzhyrVarZzq.zza();
        }
        Object object = zzb.getObject(obj, iZzA);
        if (zzE(object)) {
            return object;
        }
        Object objZza = zzhyrVarZzq.zza();
        if (object != null) {
            zzhyrVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzu(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzA(i) & 1048575, obj2);
        zzO(obj, i);
    }

    private final Object zzv(Object obj, int i, int i2) {
        zzhyr zzhyrVarZzq = zzq(i2);
        if (!zzP(obj, i, i2)) {
            return zzhyrVarZzq.zza();
        }
        Object object = zzb.getObject(obj, zzA(i2) & 1048575);
        if (zzE(object)) {
            return object;
        }
        Object objZza = zzhyrVarZzq.zza();
        if (object != null) {
            zzhyrVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzw(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzA(i2) & 1048575, obj2);
        zzQ(obj, i, i2);
    }

    private final Object zzx(Object obj, int i, Object obj2, zzhzc zzhzcVar, Object obj3) {
        zzhwu zzhwuVarZzs;
        int i2 = this.zzc[i];
        Object objZzn = zzhzj.zzn(obj, zzA(i) & 1048575);
        if (objZzn == null || (zzhwuVarZzs = zzs(i)) == null) {
            return obj2;
        }
        zzhxr zzhxrVarZze = ((zzhxs) zzr(i)).zze();
        Iterator it = ((zzhxt) objZzn).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zzhwuVarZzs.zza(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = zzhzcVar.zzh(obj3);
                }
                int iZzc = zzhxs.zzc(zzhxrVarZze, entry.getKey(), entry.getValue());
                zzhvi zzhviVar = zzhvi.zzb;
                byte[] bArr = new byte[iZzc];
                int i3 = zzhvt.zzf;
                zzhvq zzhvqVar = new zzhvq(bArr, 0, iZzc);
                try {
                    zzhxs.zzb(zzhvqVar, zzhxrVarZze, entry.getKey(), entry.getValue());
                    zzhzcVar.zzd(obj2, i2, zzhve.zza(zzhvqVar, bArr));
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    private static boolean zzy(Object obj, int i, zzhyr zzhyrVar) {
        return zzhyrVar.zzl(zzhzj.zzn(obj, i & 1048575));
    }

    private final void zzz(Object obj, int i, zzhym zzhymVar) throws IOException {
        long j = i & 1048575;
        if (zzD(i)) {
            zzhzj.zzo(obj, j, zzhymVar.zzn());
        } else if (this.zzi) {
            zzhzj.zzo(obj, j, zzhymVar.zzm());
        } else {
            zzhzj.zzo(obj, j, zzhymVar.zzq());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhyr
    public final Object zza() {
        return ((zzhwo) this.zzg).zzbg();
    }

    @Override // com.google.android.gms.internal.ads.zzhyr
    public final boolean zzb(Object obj, Object obj2) {
        boolean zZzG;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzA = zzA(i);
            long j = iZzA & 1048575;
            switch (zzC(iZzA)) {
                case 0:
                    if (!zzL(obj, obj2, i) || Double.doubleToLongBits(zzhzj.zzl(obj, j)) != Double.doubleToLongBits(zzhzj.zzl(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i) || Float.floatToIntBits(zzhzj.zzj(obj, j)) != Float.floatToIntBits(zzhzj.zzj(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i) || zzhzj.zzf(obj, j) != zzhzj.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i) || zzhzj.zzf(obj, j) != zzhzj.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i) || zzhzj.zzf(obj, j) != zzhzj.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i) || zzhzj.zzh(obj, j) != zzhzj.zzh(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i) || !zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i) || !zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i) || !zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i) || zzhzj.zzf(obj, j) != zzhzj.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i) || zzhzj.zzd(obj, j) != zzhzj.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i) || zzhzj.zzf(obj, j) != zzhzj.zzf(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i) || !zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j))) {
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
                    zZzG = zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j));
                    break;
                case 50:
                    zZzG = zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j));
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
                    long jZzB = zzB(i) & 1048575;
                    if (zzhzj.zzd(obj, jZzB) != zzhzj.zzd(obj2, jZzB) || !zzhyt.zzG(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzG) {
                return false;
            }
        }
        if (!((zzhwo) obj).zzt.equals(((zzhwo) obj2).zzt)) {
            return false;
        }
        if (this.zzh) {
            return ((zzhwk) obj).zza.equals(((zzhwk) obj2).zza);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzhyr
    public final int zzc(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iHashCode = (i4 * 53) + ((zzhwo) obj).zzt.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzhwk) obj).zza.zza.hashCode() : iHashCode;
            }
            int iZzA = zzA(i3);
            int i5 = 1048575 & iZzA;
            int iZzC = zzC(iZzA);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzC) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhzj.zzl(obj, j));
                    byte[] bArr = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhzj.zzj(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhzj.zzf(obj, j);
                    byte[] bArr2 = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhzj.zzf(obj, j);
                    byte[] bArr3 = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhzj.zzf(obj, j);
                    byte[] bArr4 = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzhxb.zzb(zzhzj.zzh(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzhzj.zzn(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzn = zzhzj.zzn(obj, j);
                    if (objZzn != null) {
                        iHashCode2 = objZzn.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhzj.zzf(obj, j);
                    byte[] bArr5 = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzd(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzhzj.zzf(obj, j);
                    byte[] bArr6 = zzhxb.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzn2 = zzhzj.zzn(obj, j);
                    if (objZzn2 != null) {
                        iHashCode2 = objZzn2.hashCode();
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
                    iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzG(obj, j));
                        byte[] bArr7 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzH(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr8 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr9 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr10 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzhxb.zzb(zzK(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzhzj.zzn(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr11 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzI(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzJ(obj, j);
                        byte[] bArr12 = zzhxb.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzP(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzhzj.zzn(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhyr
    public final void zzd(Object obj, Object obj2) {
        zzF(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzhyt.zzI(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzhyt.zzH(this.zzn, obj, obj2);
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
                    if (zzN(obj2, i)) {
                        zzhzj.zzm(obj, j, zzhzj.zzl(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i)) {
                        zzhzj.zzk(obj, j, zzhzj.zzj(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i)) {
                        zzhzj.zzg(obj, j, zzhzj.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i)) {
                        zzhzj.zzg(obj, j, zzhzj.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i)) {
                        zzhzj.zzg(obj, j, zzhzj.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i)) {
                        zzhzj.zzi(obj, j, zzhzj.zzh(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i)) {
                        zzhzj.zzo(obj, j, zzhzj.zzn(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 9:
                    zzo(obj, obj2, i);
                    break;
                case 10:
                    if (zzN(obj2, i)) {
                        zzhzj.zzo(obj, j, zzhzj.zzn(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i)) {
                        zzhzj.zzg(obj, j, zzhzj.zzf(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i)) {
                        zzhzj.zze(obj, j, zzhzj.zzd(obj2, j));
                        zzO(obj, i);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i)) {
                        zzhzj.zzg(obj, j, zzhzj.zzf(obj2, j));
                        zzO(obj, i);
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
                    zzhxa zzhxaVarZzh = (zzhxa) zzhzj.zzn(obj, j);
                    zzhxa zzhxaVar = (zzhxa) zzhzj.zzn(obj2, j);
                    int size = zzhxaVarZzh.size();
                    int size2 = zzhxaVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzhxaVarZzh.zza()) {
                            zzhxaVarZzh = zzhxaVarZzh.zzh(size2 + size);
                        }
                        zzhxaVarZzh.addAll(zzhxaVar);
                    }
                    if (size > 0) {
                        zzhxaVar = zzhxaVarZzh;
                    }
                    zzhzj.zzo(obj, j, zzhxaVar);
                    break;
                case 50:
                    int i4 = zzhyt.zza;
                    zzhzj.zzo(obj, j, zzhxu.zzb(zzhzj.zzn(obj, j), zzhzj.zzn(obj2, j)));
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
                    if (zzP(obj2, i3, i)) {
                        zzhzj.zzo(obj, j, zzhzj.zzn(obj2, j));
                        zzQ(obj, i3, i);
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
                    if (zzP(obj2, i3, i)) {
                        zzhzj.zzo(obj, j, zzhzj.zzn(obj2, j));
                        zzQ(obj, i3, i);
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
    /* JADX WARN: Removed duplicated region for block: B:207:0x0556  */
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
    /* JADX WARN: Type inference failed for: r2v31, types: [int] */
    /* JADX WARN: Type inference failed for: r2v39, types: [int] */
    /* JADX WARN: Type inference failed for: r2v43, types: [int] */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52, types: [int] */
    /* JADX WARN: Type inference failed for: r2v80 */
    /* JADX WARN: Type inference failed for: r2v81, types: [int] */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84, types: [int] */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r2v95 */
    /* JADX WARN: Type inference failed for: r2v96 */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r2v98 */
    /* JADX WARN: Type inference failed for: r2v99 */
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
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30, types: [int] */
    /* JADX WARN: Type inference failed for: r4v34 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v37, types: [int] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v59 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v60 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.ads.zzhyr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zze(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 2202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyc.zze(java.lang.Object):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0496  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04bb  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x051e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x053f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x05a1  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0245  */
    @Override // com.google.android.gms.internal.ads.zzhyr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(java.lang.Object r22, com.google.android.gms.internal.ads.zzhzr r23) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyc.zzf(java.lang.Object, com.google.android.gms.internal.ads.zzhzr):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:319:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhyr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzg(java.lang.Object r11, com.google.android.gms.internal.ads.zzhym r12, com.google.android.gms.internal.ads.zzhvy r13) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyc.zzg(java.lang.Object, com.google.android.gms.internal.ads.zzhym, com.google.android.gms.internal.ads.zzhvy):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:446:0x0af7, code lost:
    
        throw new com.google.android.gms.internal.ads.zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:547:0x0e3a, code lost:
    
        if (r5 == 1048575) goto L549;
     */
    /* JADX WARN: Code restructure failed: missing block: B:548:0x0e3c, code lost:
    
        r10.putInt(r11, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:549:0x0e40, code lost:
    
        r8 = r14.zzk;
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:551:0x0e47, code lost:
    
        if (r8 >= r14.zzl) goto L666;
     */
    /* JADX WARN: Code restructure failed: missing block: B:552:0x0e49, code lost:
    
        r3 = (com.google.android.gms.internal.ads.zzhzd) zzx(r35, r14.zzj[r8], r3, r14.zzm, r35);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:553:0x0e5f, code lost:
    
        if (r3 == null) goto L555;
     */
    /* JADX WARN: Code restructure failed: missing block: B:554:0x0e61, code lost:
    
        r14.zzm.zzi(r11, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:555:0x0e66, code lost:
    
        if (r6 != 0) goto L560;
     */
    /* JADX WARN: Code restructure failed: missing block: B:556:0x0e68, code lost:
    
        if (r7 != r12) goto L558;
     */
    /* JADX WARN: Code restructure failed: missing block: B:559:0x0e72, code lost:
    
        throw new com.google.android.gms.internal.ads.zzhxd(r20);
     */
    /* JADX WARN: Code restructure failed: missing block: B:560:0x0e73, code lost:
    
        r1 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:561:0x0e75, code lost:
    
        if (r7 > r12) goto L564;
     */
    /* JADX WARN: Code restructure failed: missing block: B:562:0x0e77, code lost:
    
        if (r9 != r6) goto L564;
     */
    /* JADX WARN: Code restructure failed: missing block: B:563:0x0e79, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:565:0x0e7f, code lost:
    
        throw new com.google.android.gms.internal.ads.zzhxd(r1);
     */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0db3 A[PHI: r0 r8 r10 r11 r14 r20 r21 r31
  0x0db3: PHI (r0v211 int) = 
  (r0v178 int)
  (r0v179 int)
  (r0v180 int)
  (r0v181 int)
  (r0v182 int)
  (r0v183 int)
  (r0v184 int)
  (r0v185 int)
  (r0v188 int)
  (r0v198 int)
  (r0v212 int)
 binds: [B:524:0x0d9c, B:521:0x0d77, B:518:0x0d56, B:515:0x0d35, B:512:0x0d14, B:509:0x0cf2, B:502:0x0cc8, B:488:0x0c88, B:486:0x0c6f, B:482:0x0c35, B:453:0x0b2b] A[DONT_GENERATE, DONT_INLINE]
  0x0db3: PHI (r8v112 int) = 
  (r8v90 int)
  (r8v91 int)
  (r8v92 int)
  (r8v93 int)
  (r8v94 int)
  (r8v95 int)
  (r8v96 int)
  (r8v97 int)
  (r8v98 int)
  (r8v103 int)
  (r8v113 int)
 binds: [B:524:0x0d9c, B:521:0x0d77, B:518:0x0d56, B:515:0x0d35, B:512:0x0d14, B:509:0x0cf2, B:502:0x0cc8, B:488:0x0c88, B:486:0x0c6f, B:482:0x0c35, B:453:0x0b2b] A[DONT_GENERATE, DONT_INLINE]
  0x0db3: PHI (r10v60 sun.misc.Unsafe) = 
  (r10v37 sun.misc.Unsafe)
  (r10v38 sun.misc.Unsafe)
  (r10v39 sun.misc.Unsafe)
  (r10v40 sun.misc.Unsafe)
  (r10v41 sun.misc.Unsafe)
  (r10v42 sun.misc.Unsafe)
  (r10v43 sun.misc.Unsafe)
  (r10v44 sun.misc.Unsafe)
  (r10v45 sun.misc.Unsafe)
  (r10v50 sun.misc.Unsafe)
  (r10v61 sun.misc.Unsafe)
 binds: [B:524:0x0d9c, B:521:0x0d77, B:518:0x0d56, B:515:0x0d35, B:512:0x0d14, B:509:0x0cf2, B:502:0x0cc8, B:488:0x0c88, B:486:0x0c6f, B:482:0x0c35, B:453:0x0b2b] A[DONT_GENERATE, DONT_INLINE]
  0x0db3: PHI (r11v84 java.lang.Object) = 
  (r11v61 java.lang.Object)
  (r11v62 java.lang.Object)
  (r11v63 java.lang.Object)
  (r11v64 java.lang.Object)
  (r11v65 java.lang.Object)
  (r11v66 java.lang.Object)
  (r11v67 java.lang.Object)
  (r11v68 java.lang.Object)
  (r11v70 java.lang.Object)
  (r11v79 java.lang.Object)
  (r11v85 java.lang.Object)
 binds: [B:524:0x0d9c, B:521:0x0d77, B:518:0x0d56, B:515:0x0d35, B:512:0x0d14, B:509:0x0cf2, B:502:0x0cc8, B:488:0x0c88, B:486:0x0c6f, B:482:0x0c35, B:453:0x0b2b] A[DONT_GENERATE, DONT_INLINE]
  0x0db3: PHI (r14v90 com.google.android.gms.internal.ads.zzhyc<T>) = 
  (r14v70 com.google.android.gms.internal.ads.zzhyc<T>)
  (r14v71 com.google.android.gms.internal.ads.zzhyc<T>)
  (r14v72 com.google.android.gms.internal.ads.zzhyc<T>)
  (r14v73 com.google.android.gms.internal.ads.zzhyc<T>)
  (r14v74 com.google.android.gms.internal.ads.zzhyc<T>)
  (r14v75 com.google.android.gms.internal.ads.zzhyc<T>)
  (r14v76 com.google.android.gms.internal.ads.zzhyc<T>)
  (r14v77 com.google.android.gms.internal.ads.zzhyc<T>)
  (r14v78 com.google.android.gms.internal.ads.zzhyc<T>)
  (r14v82 com.google.android.gms.internal.ads.zzhyc<T>)
  (r14v91 com.google.android.gms.internal.ads.zzhyc<T>)
 binds: [B:524:0x0d9c, B:521:0x0d77, B:518:0x0d56, B:515:0x0d35, B:512:0x0d14, B:509:0x0cf2, B:502:0x0cc8, B:488:0x0c88, B:486:0x0c6f, B:482:0x0c35, B:453:0x0b2b] A[DONT_GENERATE, DONT_INLINE]
  0x0db3: PHI (r20v38 java.lang.String) = 
  (r20v16 java.lang.String)
  (r20v17 java.lang.String)
  (r20v18 java.lang.String)
  (r20v19 java.lang.String)
  (r20v20 java.lang.String)
  (r20v21 java.lang.String)
  (r20v22 java.lang.String)
  (r20v23 java.lang.String)
  (r20v24 java.lang.String)
  (r20v29 java.lang.String)
  (r20v39 java.lang.String)
 binds: [B:524:0x0d9c, B:521:0x0d77, B:518:0x0d56, B:515:0x0d35, B:512:0x0d14, B:509:0x0cf2, B:502:0x0cc8, B:488:0x0c88, B:486:0x0c6f, B:482:0x0c35, B:453:0x0b2b] A[DONT_GENERATE, DONT_INLINE]
  0x0db3: PHI (r21v38 int) = 
  (r21v30 int)
  (r21v30 int)
  (r21v30 int)
  (r21v30 int)
  (r21v30 int)
  (r21v30 int)
  (r21v30 int)
  (r21v30 int)
  (r21v31 int)
  (r21v35 int)
  (r21v30 int)
 binds: [B:524:0x0d9c, B:521:0x0d77, B:518:0x0d56, B:515:0x0d35, B:512:0x0d14, B:509:0x0cf2, B:502:0x0cc8, B:488:0x0c88, B:486:0x0c6f, B:482:0x0c35, B:453:0x0b2b] A[DONT_GENERATE, DONT_INLINE]
  0x0db3: PHI (r31v44 int) = 
  (r31v26 int)
  (r31v27 int)
  (r31v28 int)
  (r31v29 int)
  (r31v30 int)
  (r31v31 int)
  (r31v32 int)
  (r31v33 int)
  (r31v34 int)
  (r31v38 int)
  (r31v45 int)
 binds: [B:524:0x0d9c, B:521:0x0d77, B:518:0x0d56, B:515:0x0d35, B:512:0x0d14, B:509:0x0cf2, B:502:0x0cc8, B:488:0x0c88, B:486:0x0c6f, B:482:0x0c35, B:453:0x0b2b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:528:0x0db6  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x0dc9  */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0e09  */
    /* JADX WARN: Removed duplicated region for block: B:606:0x09a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:650:0x09ba A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzi(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.ads.zzhuw r40) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3856
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyc.zzi(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzhuw):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhyr
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzhuw zzhuwVar) throws IOException {
        zzi(obj, bArr, i, i2, 0, zzhuwVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    @Override // com.google.android.gms.internal.ads.zzhyr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzk(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyc.zzk(java.lang.Object):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00cc  */
    @Override // com.google.android.gms.internal.ads.zzhyr
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzl(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhyc.zzl(java.lang.Object):boolean");
    }
}
