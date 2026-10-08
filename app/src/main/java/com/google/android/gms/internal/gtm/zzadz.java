package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzadz {
    public static final /* synthetic */ int zza = 0;
    private static final zzaem zzb;

    static {
        int i = zzadt.zza;
        zzb = new zzaeo();
    }

    public static void zzA(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzu(i, list, z);
    }

    public static void zzB(int i, List list, zzaez zzaezVar, zzadx zzadxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzzj) zzaezVar).zzv(i, list.get(i2), zzadxVar);
        }
    }

    public static void zzC(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzy(i, list, z);
    }

    public static void zzD(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzA(i, list, z);
    }

    public static void zzE(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzC(i, list, z);
    }

    public static void zzF(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzE(i, list, z);
    }

    public static void zzG(int i, List list, zzaez zzaezVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzH(i, list);
    }

    public static void zzH(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzJ(i, list, z);
    }

    public static void zzI(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzL(i, list, z);
    }

    static boolean zzJ(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int iZzD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzacg) {
            zzacg zzacgVar = (zzacg) list;
            iZzD = 0;
            while (i < size) {
                iZzD += zzzi.zzD(zzacgVar.zze(i));
                i++;
            }
        } else {
            iZzD = 0;
            while (i < size) {
                iZzD += zzzi.zzD(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzD;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzzi.zzC(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzzi.zzC(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int iZzD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzacg) {
            zzacg zzacgVar = (zzacg) list;
            iZzD = 0;
            while (i < size) {
                iZzD += zzzi.zzD(zzacgVar.zze(i));
                i++;
            }
        } else {
            iZzD = 0;
            while (i < size) {
                iZzD += zzzi.zzD(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzD;
    }

    static int zzg(List list) {
        int iZzD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzada) {
            zzada zzadaVar = (zzada) list;
            iZzD = 0;
            while (i < size) {
                iZzD += zzzi.zzD(zzadaVar.zze(i));
                i++;
            }
        } else {
            iZzD = 0;
            while (i < size) {
                iZzD += zzzi.zzD(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzD;
    }

    static int zzh(int i, Object obj, zzadx zzadxVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzacw)) {
            return zzzi.zzC(i2) + zzzi.zzA((zzadl) obj, zzadxVar);
        }
        int iZzC = zzzi.zzC(i2);
        int iZza = ((zzacw) obj).zza();
        return iZzC + zzzi.zzC(iZza) + iZza;
    }

    static int zzi(List list) {
        int iZzC;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzacg) {
            zzacg zzacgVar = (zzacg) list;
            iZzC = 0;
            while (i < size) {
                int iZze = zzacgVar.zze(i);
                iZzC += zzzi.zzC((iZze >> 31) ^ (iZze + iZze));
                i++;
            }
        } else {
            iZzC = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzC += zzzi.zzC((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
        }
        return iZzC;
    }

    static int zzj(List list) {
        int iZzD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzada) {
            zzada zzadaVar = (zzada) list;
            iZzD = 0;
            while (i < size) {
                long jZze = zzadaVar.zze(i);
                iZzD += zzzi.zzD((jZze >> 63) ^ (jZze + jZze));
                i++;
            }
        } else {
            iZzD = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzD += zzzi.zzD((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
        }
        return iZzD;
    }

    static int zzk(List list) {
        int iZzC;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzacg) {
            zzacg zzacgVar = (zzacg) list;
            iZzC = 0;
            while (i < size) {
                iZzC += zzzi.zzC(zzacgVar.zze(i));
                i++;
            }
        } else {
            iZzC = 0;
            while (i < size) {
                iZzC += zzzi.zzC(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzC;
    }

    static int zzl(List list) {
        int iZzD;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzada) {
            zzada zzadaVar = (zzada) list;
            iZzD = 0;
            while (i < size) {
                iZzD += zzzi.zzD(zzadaVar.zze(i));
                i++;
            }
        } else {
            iZzD = 0;
            while (i < size) {
                iZzD += zzzi.zzD(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzD;
    }

    public static zzaem zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, List list, zzacj zzacjVar, Object obj2, zzaem zzaemVar) {
        if (zzacjVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (zzacjVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj2 = zzo(obj, i, iIntValue, obj2, zzaemVar);
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
                if (!zzacjVar.zza(iIntValue2)) {
                    obj2 = zzo(obj, i, iIntValue2, obj2, zzaemVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    static Object zzo(Object obj, int i, int i2, Object obj2, zzaem zzaemVar) {
        if (obj2 == null) {
            obj2 = zzaemVar.zza(obj);
        }
        zzaemVar.zzh(obj2, i, i2);
        return obj2;
    }

    static void zzp(zzabr zzabrVar, Object obj, Object obj2) {
        zzabv zzabvVar = ((zzacc) obj2).zza;
        if (zzabvVar.zza.isEmpty()) {
            return;
        }
        ((zzacc) obj).zzU().zzj(zzabvVar);
    }

    static void zzq(zzaem zzaemVar, Object obj, Object obj2) {
        zzacf zzacfVar = (zzacf) obj;
        zzaen zzaenVarZze = zzacfVar.zzc;
        zzaen zzaenVar = ((zzacf) obj2).zzc;
        if (!zzaen.zzc().equals(zzaenVar)) {
            if (zzaen.zzc().equals(zzaenVarZze)) {
                zzaenVarZze = zzaen.zze(zzaenVarZze, zzaenVar);
            } else {
                zzaenVarZze.zzd(zzaenVar);
            }
        }
        zzacfVar.zzc = zzaenVarZze;
    }

    public static void zzr(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzc(i, list, z);
    }

    public static void zzs(int i, List list, zzaez zzaezVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zze(i, list);
    }

    public static void zzt(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzg(i, list, z);
    }

    public static void zzu(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzj(i, list, z);
    }

    public static void zzv(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzl(i, list, z);
    }

    public static void zzw(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzn(i, list, z);
    }

    public static void zzx(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzp(i, list, z);
    }

    public static void zzy(int i, List list, zzaez zzaezVar, zzadx zzadxVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((zzzj) zzaezVar).zzq(i, list.get(i2), zzadxVar);
        }
    }

    public static void zzz(int i, List list, zzaez zzaezVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzaezVar.zzs(i, list, z);
    }
}
