package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzrm {
    public static zzap zza(zzap zzapVar) {
        zzak zzakVarZzg = zzap.zzg();
        zzakVarZzg.zzt(1);
        zzakVarZzg.zzt(zzapVar.zzO());
        zzakVarZzg.zzi();
        zzakVarZzg.zza(zzapVar.zzq());
        zzakVarZzg.zzo(zzapVar.zzN());
        return (zzap) zzakVarZzg.zzD();
    }

    public static zzrg zzb(zzz zzzVar) throws zzrk {
        zzap[] zzapVarArr = new zzap[zzzVar.zzf()];
        for (int i = 0; i < zzzVar.zzf(); i++) {
            zze(i, zzzVar, zzapVarArr, new HashSet(0));
        }
        zzrh zzrhVar = new zzrh(null);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < zzzVar.zze(); i2++) {
            arrayList.add(zzf(zzzVar.zzi(i2), zzzVar, zzapVarArr));
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < zzzVar.zzc(); i3++) {
            arrayList2.add(zzf(zzzVar.zzh(i3), zzzVar, zzapVarArr));
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i4 = 0; i4 < zzzVar.zza(); i4++) {
            zzre zzreVarZzf = zzf(zzzVar.zzg(i4), zzzVar, zzapVarArr);
            zzrhVar.zzb(zzreVarZzf);
            arrayList3.add(zzreVarZzf);
        }
        for (zzab zzabVar : zzzVar.zzq()) {
            zzrj zzrjVar = new zzrj(null);
            Iterator it = zzabVar.zzh().iterator();
            while (it.hasNext()) {
                zzrjVar.zzg((zzre) arrayList2.get(((Integer) it.next()).intValue()));
            }
            Iterator it2 = zzabVar.zzg().iterator();
            while (it2.hasNext()) {
                zzrjVar.zzf((zzre) arrayList2.get(((Integer) it2.next()).intValue()));
            }
            Iterator it3 = zzabVar.zze().iterator();
            while (it3.hasNext()) {
                zzrjVar.zzd((zzre) arrayList.get(((Integer) it3.next()).intValue()));
            }
            Iterator it4 = zzabVar.zzf().iterator();
            while (it4.hasNext()) {
                zzrjVar.zze(zzzVar.zzm(((Integer) it4.next()).intValue()).zzp());
            }
            Iterator it5 = zzabVar.zzk().iterator();
            while (it5.hasNext()) {
                zzrjVar.zzj((zzre) arrayList.get(((Integer) it5.next()).intValue()));
            }
            Iterator it6 = zzabVar.zzl().iterator();
            while (it6.hasNext()) {
                zzrjVar.zzk(zzzVar.zzm(((Integer) it6.next()).intValue()).zzp());
            }
            Iterator it7 = zzabVar.zzc().iterator();
            while (it7.hasNext()) {
                zzrjVar.zzb((zzre) arrayList3.get(((Integer) it7.next()).intValue()));
            }
            Iterator it8 = zzabVar.zzd().iterator();
            while (it8.hasNext()) {
                zzrjVar.zzc(zzzVar.zzm(((Integer) it8.next()).intValue()).zzp());
            }
            Iterator it9 = zzabVar.zzi().iterator();
            while (it9.hasNext()) {
                zzrjVar.zzh((zzre) arrayList3.get(((Integer) it9.next()).intValue()));
            }
            Iterator it10 = zzabVar.zzj().iterator();
            while (it10.hasNext()) {
                zzrjVar.zzi(zzzVar.zzm(((Integer) it10.next()).intValue()).zzp());
            }
            zzrhVar.zzc(zzrjVar.zza());
        }
        zzrhVar.zze(zzzVar.zzn());
        zzrhVar.zzd(zzzVar.zzd());
        return zzrhVar.zza();
    }

    public static void zzc(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    private static zzad zzd(zzap zzapVar) throws zzrk {
        if (!zzapVar.zzW(zzad.zza)) {
            zzh("Expected a ServingValue and didn't get one. Value is: ".concat(String.valueOf(String.valueOf(zzapVar))));
        }
        return (zzad) zzapVar.zzV(zzad.zza);
    }

    private static zzap zze(int i, zzz zzzVar, zzap[] zzapVarArr, Set set) throws zzrk {
        zzak zzakVar;
        Integer numValueOf = Integer.valueOf(i);
        if (set.contains(numValueOf)) {
            zzh("Value cycle detected.  Current value reference: " + i + ".  Previous value references: " + set.toString() + ".");
        }
        zzak zzakVar2 = (zzak) ((zzap) zzg(zzzVar.zzr(), i, "values")).zzaa();
        zzap zzapVar = zzapVarArr[i];
        if (zzapVar != null) {
            return zzapVar;
        }
        set.add(numValueOf);
        int iZzu = zzakVar2.zzu();
        if (iZzu != 2) {
            if (iZzu == 3) {
                zzakVar = (zzak) zza((zzap) zzakVar2.zzD()).zzaa();
                zzad zzadVarZzd = zzd((zzap) zzakVar2.zzD());
                if (zzadVarZzd.zzc() != zzadVarZzd.zzd()) {
                    zzh("Uneven map keys (" + zzadVarZzd.zzc() + ") and map values (" + zzadVarZzd.zzd() + ")");
                }
                zzakVar.zzk();
                zzakVar.zzl();
                Iterator it = zzadVarZzd.zzg().iterator();
                while (it.hasNext()) {
                    zzakVar.zzf(zze(((Integer) it.next()).intValue(), zzzVar, zzapVarArr, set));
                }
                Iterator it2 = zzadVarZzd.zzh().iterator();
                while (it2.hasNext()) {
                    zzakVar.zzg(zze(((Integer) it2.next()).intValue(), zzzVar, zzapVarArr, set));
                }
            } else if (iZzu == 4) {
                zzakVar = (zzak) zza((zzap) zzakVar2.zzD()).zzaa();
                zzakVar.zzr(com.google.android.gms.tagmanager.zzfp.zzm(com.google.android.gms.tagmanager.zzfp.zzk(zze(zzd((zzap) zzakVar2.zzD()).zza(), zzzVar, zzapVarArr, set))));
            } else if (iZzu == 7) {
                zzakVar = (zzak) zza((zzap) zzakVar2.zzD()).zzaa();
                zzad zzadVarZzd2 = zzd((zzap) zzakVar2.zzD());
                zzakVar.zzm();
                Iterator it3 = zzadVarZzd2.zzi().iterator();
                while (it3.hasNext()) {
                    zzakVar.zzh(zze(((Integer) it3.next()).intValue(), zzzVar, zzapVarArr, set));
                }
            }
            zzakVar2 = zzakVar;
        } else {
            zzad zzadVarZzd3 = zzd((zzap) zzakVar2.zzD());
            zzakVar2 = (zzak) zza((zzap) zzakVar2.zzD()).zzaa();
            zzakVar2.zzj();
            Iterator it4 = zzadVarZzd3.zzf().iterator();
            while (it4.hasNext()) {
                zzakVar2.zze(zze(((Integer) it4.next()).intValue(), zzzVar, zzapVarArr, set));
            }
        }
        zzapVarArr[i] = (zzap) zzakVar2.zzD();
        set.remove(Integer.valueOf(i));
        return (zzap) zzakVar2.zzD();
    }

    private static zzre zzf(zzr zzrVar, zzz zzzVar, zzap[] zzapVarArr) throws zzrk {
        zzrf zzrfVar = new zzrf(null);
        Iterator it = zzrVar.zzc().iterator();
        while (it.hasNext()) {
            zzx zzxVar = (zzx) zzg(zzzVar.zzp(), ((Integer) it.next()).intValue(), "properties");
            String str = (String) zzg(zzzVar.zzo(), zzxVar.zza(), UserMetadata.KEYDATA_FILENAME);
            int iZzc = zzxVar.zzc();
            if (iZzc < 0 || iZzc >= zzapVarArr.length) {
                zzh("Index out of bounds detected: " + iZzc + " in values");
            }
            zzap zzapVar = zzapVarArr[iZzc];
            if (zzb.PUSH_AFTER_EVALUATE.toString().equals(str)) {
                zzrfVar.zzc(zzapVar);
            } else {
                zzrfVar.zzb(str, zzapVar);
            }
        }
        return zzrfVar.zza();
    }

    private static Object zzg(List list, int i, String str) throws zzrk {
        if (i < 0 || i >= list.size()) {
            zzh("Index out of bounds detected: " + i + " in " + str);
        }
        return list.get(i);
    }

    private static void zzh(String str) throws zzrk {
        Log.e("GoogleTagManager", str);
        throw new zzrk(str);
    }
}
