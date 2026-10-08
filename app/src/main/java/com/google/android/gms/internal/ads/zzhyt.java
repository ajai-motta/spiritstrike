package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhyt {
    public static final /* synthetic */ int zza = 0;
    private static final zzhzc zzb;

    static {
        int i = zzhuv.zza;
        zzb = new zzhze();
    }

    static int zzA(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzhvt.zzA(i << 3) + 4);
    }

    static int zzB(List list) {
        return list.size() * 8;
    }

    static int zzC(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzhvt.zzA(i << 3) + 8);
    }

    static int zzD(int i, Object obj, zzhyr zzhyrVar) {
        int iZzA;
        int iZzaT;
        int iZzA2;
        int i2 = i << 3;
        if (obj instanceof zzhxj) {
            iZzA = zzhvt.zzA(i2);
            iZzaT = ((zzhxj) obj).zzb();
            iZzA2 = zzhvt.zzA(iZzaT);
        } else {
            iZzA = zzhvt.zzA(i2);
            iZzaT = ((zzhur) obj).zzaT(zzhyrVar);
            iZzA2 = zzhvt.zzA(iZzaT);
        }
        return iZzA + iZzA2 + iZzaT;
    }

    @Deprecated
    static int zzE(int i, zzhxz zzhxzVar, zzhyr zzhyrVar) {
        int iZzA = zzhvt.zzA(i << 3);
        return iZzA + iZzA + ((zzhur) zzhxzVar).zzaT(zzhyrVar);
    }

    public static zzhzc zzF() {
        return zzb;
    }

    static boolean zzG(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static void zzH(zzhvz zzhvzVar, Object obj, Object obj2) {
        if (((zzhwk) obj2).zza.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzI(zzhzc zzhzcVar, Object obj, Object obj2) {
        zzhwo zzhwoVar = (zzhwo) obj;
        zzhzd zzhzdVarZzc = zzhwoVar.zzt;
        zzhzd zzhzdVar = ((zzhwo) obj2).zzt;
        if (!zzhzd.zza().equals(zzhzdVar)) {
            if (zzhzd.zza().equals(zzhzdVarZzc)) {
                zzhzdVarZzc = zzhzd.zzc(zzhzdVarZzc, zzhzdVar);
            } else {
                zzhzdVarZzc.zzm(zzhzdVar);
            }
        }
        zzhwoVar.zzt = zzhzdVarZzc;
    }

    static Object zzJ(Object obj, int i, List list, zzhwu zzhwuVar, Object obj2, zzhzc zzhzcVar) {
        if (zzhwuVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (zzhwuVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj2 = zzK(obj, i, iIntValue, obj2, zzhzcVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzhwuVar.zza(iIntValue2)) {
                    obj2 = zzK(obj, i, iIntValue2, obj2, zzhzcVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzK(Object obj, int i, int i2, Object obj2, zzhzc zzhzcVar) {
        if (obj2 == null) {
            obj2 = zzhzcVar.zzh(obj);
        }
        zzhzcVar.zza(obj2, i, i2);
        return obj2;
    }

    public static void zza(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzC(i, list, z);
    }

    public static void zzb(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzB(i, list, z);
    }

    public static void zzc(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzy(i, list, z);
    }

    public static void zzd(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzz(i, list, z);
    }

    public static void zze(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzL(i, list, z);
    }

    public static void zzf(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzA(i, list, z);
    }

    public static void zzg(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzJ(i, list, z);
    }

    public static void zzh(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzw(i, list, z);
    }

    public static void zzi(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzH(i, list, z);
    }

    public static void zzj(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzK(i, list, z);
    }

    public static void zzk(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzx(i, list, z);
    }

    public static void zzl(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzI(i, list, z);
    }

    public static void zzm(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzD(i, list, z);
    }

    public static void zzn(int i, List list, zzhzr zzhzrVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzE(i, list, z);
    }

    public static void zzo(int i, List list, zzhzr zzhzrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzF(i, list);
    }

    public static void zzp(int i, List list, zzhzr zzhzrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhzrVar.zzG(i, list);
    }

    public static void zzq(int i, List list, zzhzr zzhzrVar, zzhyr zzhyrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzhvu) zzhzrVar).zzr(i, list.get(i2), zzhyrVar);
        }
    }

    public static void zzr(int i, List list, zzhzr zzhzrVar, zzhyr zzhyrVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzhvu) zzhzrVar).zzs(i, list.get(i2), zzhyrVar);
        }
    }

    static int zzs(List list) {
        int iZzB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhxn) {
            zzhxn zzhxnVar = (zzhxn) list;
            iZzB = 0;
            while (i < size) {
                iZzB += zzhvt.zzB(zzhxnVar.zzc(i));
                i++;
            }
        } else {
            iZzB = 0;
            while (i < size) {
                iZzB += zzhvt.zzB(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzB;
    }

    static int zzt(List list) {
        int iZzB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhxn) {
            zzhxn zzhxnVar = (zzhxn) list;
            iZzB = 0;
            while (i < size) {
                iZzB += zzhvt.zzB(zzhxnVar.zzc(i));
                i++;
            }
        } else {
            iZzB = 0;
            while (i < size) {
                iZzB += zzhvt.zzB(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzB;
    }

    static int zzu(List list) {
        int iZzB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhxn) {
            zzhxn zzhxnVar = (zzhxn) list;
            iZzB = 0;
            while (i < size) {
                long jZzc = zzhxnVar.zzc(i);
                iZzB += zzhvt.zzB((jZzc >> 63) ^ (jZzc + jZzc));
                i++;
            }
        } else {
            iZzB = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzB += zzhvt.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzB;
    }

    static int zzv(List list) {
        int iZzB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhwp) {
            zzhwp zzhwpVar = (zzhwp) list;
            iZzB = 0;
            while (i < size) {
                iZzB += zzhvt.zzB(zzhwpVar.zzf(i));
                i++;
            }
        } else {
            iZzB = 0;
            while (i < size) {
                iZzB += zzhvt.zzB(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzB;
    }

    static int zzw(List list) {
        int iZzB;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhwp) {
            zzhwp zzhwpVar = (zzhwp) list;
            iZzB = 0;
            while (i < size) {
                iZzB += zzhvt.zzB(zzhwpVar.zzf(i));
                i++;
            }
        } else {
            iZzB = 0;
            while (i < size) {
                iZzB += zzhvt.zzB(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzB;
    }

    static int zzx(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhwp) {
            zzhwp zzhwpVar = (zzhwp) list;
            iZzA = 0;
            while (i < size) {
                iZzA += zzhvt.zzA(zzhwpVar.zzf(i));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                iZzA += zzhvt.zzA(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzA;
    }

    static int zzy(List list) {
        int iZzA;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhwp) {
            zzhwp zzhwpVar = (zzhwp) list;
            iZzA = 0;
            while (i < size) {
                int iZzf = zzhwpVar.zzf(i);
                iZzA += zzhvt.zzA((iZzf >> 31) ^ (iZzf + iZzf));
                i++;
            }
        } else {
            iZzA = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzA += zzhvt.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzA;
    }

    static int zzz(List list) {
        return list.size() * 4;
    }
}
