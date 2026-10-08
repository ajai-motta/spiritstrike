package com.google.android.gms.internal.measurement;

import com.adjust.sdk.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@23.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzba {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v124, types: [com.google.android.gms.internal.measurement.zzao] */
    /* JADX WARN: Type inference failed for: r1v25, types: [com.google.android.gms.internal.measurement.zzas] */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.google.android.gms.internal.measurement.zzae] */
    /* JADX WARN: Type inference failed for: r1v41 */
    /* JADX WARN: Type inference failed for: r1v43, types: [com.google.android.gms.internal.measurement.zzao] */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.google.android.gms.internal.measurement.zzae] */
    public static zzao zza(String str, zzae zzaeVar, zzg zzgVar, List list) {
        String str2;
        String str3;
        byte b;
        ?? zzaeVar2;
        String strZzc;
        double dZzh;
        zzae zzaeVar3;
        zzai zzaiVar;
        switch (str.hashCode()) {
            case -1776922004:
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                b = str.equals(str2) ? Ascii.DC2 : (byte) -1;
                break;
            case -1354795244:
                str3 = "filter";
                if (str.equals("concat")) {
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = 0;
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                break;
            case -1274492040:
                str3 = "filter";
                if (str.equals(str3)) {
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    b = 2;
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    b = 10;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case -895859076:
                if (str.equals("splice")) {
                    b = 17;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    b = 3;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    b = 6;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    b = 19;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 107868:
                if (str.equals("map")) {
                    b = 7;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 111185:
                if (str.equals("pop")) {
                    b = 8;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 3267882:
                if (str.equals("join")) {
                    b = 5;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 3452698:
                if (str.equals(Constants.PUSH)) {
                    b = 9;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 3536116:
                if (str.equals("some")) {
                    b = Ascii.SI;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 3536286:
                if (str.equals("sort")) {
                    b = Ascii.DLE;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 96891675:
                if (str.equals("every")) {
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                    b = 1;
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 109407362:
                if (str.equals("shift")) {
                    b = Ascii.CR;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 109526418:
                if (str.equals("slice")) {
                    b = Ascii.SO;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    b = Ascii.VT;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    b = Ascii.FF;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    b = 4;
                    str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                    str3 = "filter";
                }
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
            default:
                str2 = InAppPurchaseConstants.METHOD_TO_STRING;
                str3 = "filter";
                break;
        }
        String str4 = str2;
        String str5 = str3;
        double dZzh2 = 0.0d;
        switch (b) {
            case 0:
                zzaeVar2 = (zzae) zzaeVar.zzt();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        zzao zzaoVarZza = zzgVar.zza((zzao) it.next());
                        if (zzaoVarZza instanceof zzag) {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                        int iZzh = zzaeVar2.zzh();
                        if (zzaoVarZza instanceof zzae) {
                            zzae zzaeVar4 = (zzae) zzaoVarZza;
                            Iterator itZzg = zzaeVar4.zzg();
                            while (itZzg.hasNext()) {
                                Integer num = (Integer) itZzg.next();
                                zzaeVar2.zzn(num.intValue() + iZzh, zzaeVar4.zzl(num.intValue()));
                            }
                        } else {
                            zzaeVar2.zzn(iZzh, zzaoVarZza);
                        }
                    }
                }
                return zzaeVar2;
            case 1:
                zzh.zza("every", 1, list);
                zzao zzaoVarZza2 = zzgVar.zza((zzao) list.get(0));
                if (!(zzaoVarZza2 instanceof zzan)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzh() != 0 && zzc(zzaeVar, zzgVar, (zzan) zzaoVarZza2, false, true).zzh() != zzaeVar.zzh()) {
                    return zzao.zzl;
                }
                return zzao.zzk;
            case 2:
                zzh.zza(str5, 1, list);
                zzao zzaoVarZza3 = zzgVar.zza((zzao) list.get(0));
                if (!(zzaoVarZza3 instanceof zzan)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzi() == 0) {
                    return new zzae();
                }
                zzae zzaeVar5 = (zzae) zzaeVar.zzt();
                zzae zzaeVarZzc = zzc(zzaeVar, zzgVar, (zzan) zzaoVarZza3, null, true);
                zzaeVar2 = new zzae();
                Iterator itZzg2 = zzaeVarZzc.zzg();
                while (itZzg2.hasNext()) {
                    zzaeVar2.zzn(zzaeVar2.zzh(), zzaeVar5.zzl(((Integer) itZzg2.next()).intValue()));
                }
                return zzaeVar2;
            case 3:
                zzh.zza("forEach", 1, list);
                zzao zzaoVarZza4 = zzgVar.zza((zzao) list.get(0));
                if (!(zzaoVarZza4 instanceof zzan)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzi() == 0) {
                    return zzao.zzf;
                }
                zzc(zzaeVar, zzgVar, (zzan) zzaoVarZza4, null, null);
                return zzao.zzf;
            case 4:
                zzh.zzc("indexOf", 2, list);
                zzao zzaoVarZza5 = zzao.zzf;
                if (!list.isEmpty()) {
                    zzaoVarZza5 = zzgVar.zza((zzao) list.get(0));
                }
                if (list.size() > 1) {
                    double dZzi = zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue());
                    if (dZzi >= zzaeVar.zzh()) {
                        return new zzah(Double.valueOf(-1.0d));
                    }
                    dZzh2 = dZzi < 0.0d ? ((double) zzaeVar.zzh()) + dZzi : dZzi;
                }
                Iterator itZzg3 = zzaeVar.zzg();
                while (itZzg3.hasNext()) {
                    int iIntValue = ((Integer) itZzg3.next()).intValue();
                    double d = iIntValue;
                    if (d >= dZzh2 && zzh.zzf(zzaeVar.zzl(iIntValue), zzaoVarZza5)) {
                        return new zzah(Double.valueOf(d));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 5:
                zzh.zzc("join", 1, list);
                if (zzaeVar.zzh() == 0) {
                    return zzao.zzm;
                }
                if (list.isEmpty()) {
                    strZzc = ",";
                } else {
                    zzao zzaoVarZza6 = zzgVar.zza((zzao) list.get(0));
                    strZzc = ((zzaoVarZza6 instanceof zzam) || (zzaoVarZza6 instanceof zzat)) ? "" : zzaoVarZza6.zzc();
                }
                zzaeVar2 = new zzas(zzaeVar.zzs(strZzc));
                return zzaeVar2;
            case 6:
                zzh.zzc("lastIndexOf", 2, list);
                zzao zzaoVarZza7 = zzao.zzf;
                if (!list.isEmpty()) {
                    zzaoVarZza7 = zzgVar.zza((zzao) list.get(0));
                }
                int iZzh2 = zzaeVar.zzh() - 1;
                if (list.size() > 1) {
                    zzao zzaoVarZza8 = zzgVar.zza((zzao) list.get(1));
                    dZzh = Double.isNaN(zzaoVarZza8.zzd().doubleValue()) ? zzaeVar.zzh() - 1 : zzh.zzi(zzaoVarZza8.zzd().doubleValue());
                    if (dZzh < 0.0d) {
                        dZzh += (double) zzaeVar.zzh();
                    }
                } else {
                    dZzh = iZzh2;
                }
                if (dZzh < 0.0d) {
                    return new zzah(Double.valueOf(-1.0d));
                }
                for (int iMin = (int) Math.min(zzaeVar.zzh(), dZzh); iMin >= 0; iMin--) {
                    if (zzaeVar.zzo(iMin) && zzh.zzf(zzaeVar.zzl(iMin), zzaoVarZza7)) {
                        return new zzah(Double.valueOf(iMin));
                    }
                }
                return new zzah(Double.valueOf(-1.0d));
            case 7:
                zzh.zza("map", 1, list);
                zzao zzaoVarZza9 = zzgVar.zza((zzao) list.get(0));
                if (zzaoVarZza9 instanceof zzan) {
                    return zzaeVar.zzh() == 0 ? new zzae() : zzc(zzaeVar, zzgVar, (zzan) zzaoVarZza9, null, null);
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 8:
                zzh.zza("pop", 0, list);
                int iZzh3 = zzaeVar.zzh();
                if (iZzh3 == 0) {
                    return zzao.zzf;
                }
                int i = iZzh3 - 1;
                zzaeVar2 = zzaeVar.zzl(i);
                zzaeVar.zzr(i);
                return zzaeVar2;
            case 9:
                if (!list.isEmpty()) {
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        zzaeVar.zzn(zzaeVar.zzh(), zzgVar.zza((zzao) it2.next()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzh()));
            case 10:
                return zzb(zzaeVar, zzgVar, list, true);
            case 11:
                return zzb(zzaeVar, zzgVar, list, false);
            case 12:
                zzaeVar3 = zzaeVar;
                zzh.zza("reverse", 0, list);
                int iZzh4 = zzaeVar.zzh();
                if (iZzh4 != 0) {
                    for (int i2 = 0; i2 < iZzh4 / 2; i2++) {
                        if (zzaeVar3.zzo(i2)) {
                            zzao zzaoVarZzl = zzaeVar3.zzl(i2);
                            zzaeVar3.zzn(i2, null);
                            int i3 = (iZzh4 - 1) - i2;
                            if (zzaeVar3.zzo(i3)) {
                                zzaeVar3.zzn(i2, zzaeVar3.zzl(i3));
                            }
                            zzaeVar3.zzn(i3, zzaoVarZzl);
                        }
                    }
                }
                return zzaeVar3;
            case 13:
                zzh.zza("shift", 0, list);
                if (zzaeVar.zzh() == 0) {
                    return zzao.zzf;
                }
                zzao zzaoVarZzl2 = zzaeVar.zzl(0);
                zzaeVar.zzr(0);
                return zzaoVarZzl2;
            case 14:
                zzh.zzc("slice", 2, list);
                if (list.isEmpty()) {
                    return zzaeVar.zzt();
                }
                double dZzh3 = zzaeVar.zzh();
                double dZzi2 = zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue());
                double dMax = dZzi2 < 0.0d ? Math.max(dZzi2 + dZzh3, 0.0d) : Math.min(dZzi2, dZzh3);
                if (list.size() == 2) {
                    double dZzi3 = zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue());
                    dZzh3 = dZzi3 < 0.0d ? Math.max(dZzh3 + dZzi3, 0.0d) : Math.min(dZzh3, dZzi3);
                }
                zzae zzaeVar6 = new zzae();
                for (int i4 = (int) dMax; i4 < dZzh3; i4++) {
                    zzaeVar6.zzn(zzaeVar6.zzh(), zzaeVar.zzl(i4));
                }
                return zzaeVar6;
            case 15:
                zzh.zza("some", 1, list);
                zzao zzaoVarZza10 = zzgVar.zza((zzao) list.get(0));
                if (!(zzaoVarZza10 instanceof zzai)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (zzaeVar.zzh() == 0) {
                    return zzao.zzl;
                }
                zzai zzaiVar2 = (zzai) zzaoVarZza10;
                Iterator itZzg4 = zzaeVar.zzg();
                while (itZzg4.hasNext()) {
                    int iIntValue2 = ((Integer) itZzg4.next()).intValue();
                    if (zzaeVar.zzo(iIntValue2) && zzaiVar2.zza(zzgVar, Arrays.asList(zzaeVar.zzl(iIntValue2), new zzah(Double.valueOf(iIntValue2)), zzaeVar)).zze().booleanValue()) {
                        return zzao.zzk;
                    }
                }
                return zzao.zzl;
            case 16:
                zzaeVar3 = zzaeVar;
                zzh.zzc("sort", 1, list);
                if (zzaeVar.zzh() >= 2) {
                    List listZzb = zzaeVar.zzb();
                    if (list.isEmpty()) {
                        zzaiVar = null;
                    } else {
                        zzao zzaoVarZza11 = zzgVar.zza((zzao) list.get(0));
                        if (!(zzaoVarZza11 instanceof zzai)) {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                        zzaiVar = (zzai) zzaoVarZza11;
                    }
                    Collections.sort(listZzb, new zzaz(zzaiVar, zzgVar));
                    zzaeVar.zzp();
                    Iterator it3 = listZzb.iterator();
                    int i5 = 0;
                    while (it3.hasNext()) {
                        zzaeVar3.zzn(i5, (zzao) it3.next());
                        i5++;
                    }
                }
                return zzaeVar3;
            case 17:
                if (list.isEmpty()) {
                    return new zzae();
                }
                int iZzi = (int) zzh.zzi(zzgVar.zza((zzao) list.get(0)).zzd().doubleValue());
                if (iZzi < 0) {
                    iZzi = Math.max(0, iZzi + zzaeVar.zzh());
                } else if (iZzi > zzaeVar.zzh()) {
                    iZzi = zzaeVar.zzh();
                }
                int iZzh5 = zzaeVar.zzh();
                zzae zzaeVar7 = new zzae();
                if (list.size() > 1) {
                    int iMax = Math.max(0, (int) zzh.zzi(zzgVar.zza((zzao) list.get(1)).zzd().doubleValue()));
                    if (iMax > 0) {
                        for (int i6 = iZzi; i6 < Math.min(iZzh5, iZzi + iMax); i6++) {
                            zzaeVar7.zzn(zzaeVar7.zzh(), zzaeVar.zzl(iZzi));
                            zzaeVar.zzr(iZzi);
                        }
                    }
                    if (list.size() > 2) {
                        for (int i7 = 2; i7 < list.size(); i7++) {
                            zzao zzaoVarZza12 = zzgVar.zza((zzao) list.get(i7));
                            if (zzaoVarZza12 instanceof zzag) {
                                throw new IllegalArgumentException("Failed to parse elements to add");
                            }
                            zzaeVar.zzq((iZzi + i7) - 2, zzaoVarZza12);
                        }
                    }
                } else {
                    while (iZzi < iZzh5) {
                        zzaeVar7.zzn(zzaeVar7.zzh(), zzaeVar.zzl(iZzi));
                        zzaeVar.zzn(iZzi, null);
                        iZzi++;
                    }
                }
                return zzaeVar7;
            case 18:
                zzh.zza(str4, 0, list);
                return new zzas(zzaeVar.zzs(","));
            case 19:
                if (!list.isEmpty()) {
                    zzae zzaeVar8 = new zzae();
                    Iterator it4 = list.iterator();
                    while (it4.hasNext()) {
                        zzao zzaoVarZza13 = zzgVar.zza((zzao) it4.next());
                        if (zzaoVarZza13 instanceof zzag) {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                        zzaeVar8.zzn(zzaeVar8.zzh(), zzaoVarZza13);
                    }
                    int iZzh6 = zzaeVar8.zzh();
                    Iterator itZzg5 = zzaeVar.zzg();
                    while (itZzg5.hasNext()) {
                        Integer num2 = (Integer) itZzg5.next();
                        zzaeVar8.zzn(num2.intValue() + iZzh6, zzaeVar.zzl(num2.intValue()));
                    }
                    zzaeVar.zzp();
                    Iterator itZzg6 = zzaeVar8.zzg();
                    while (itZzg6.hasNext()) {
                        Integer num3 = (Integer) itZzg6.next();
                        zzaeVar.zzn(num3.intValue(), zzaeVar8.zzl(num3.intValue()));
                    }
                }
                return new zzah(Double.valueOf(zzaeVar.zzh()));
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    private static zzao zzb(zzae zzaeVar, zzg zzgVar, List list, boolean z) {
        zzao zzaoVarZza;
        zzh.zzb("reduce", 1, list);
        zzh.zzc("reduce", 2, list);
        zzao zzaoVarZza2 = zzgVar.zza((zzao) list.get(0));
        if (!(zzaoVarZza2 instanceof zzai)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            zzaoVarZza = zzgVar.zza((zzao) list.get(1));
            if (zzaoVarZza instanceof zzag) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (zzaeVar.zzh() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzaoVarZza = null;
        }
        zzai zzaiVar = (zzai) zzaoVarZza2;
        int iZzh = zzaeVar.zzh();
        int i = z ? 0 : iZzh - 1;
        int i2 = z ? iZzh - 1 : 0;
        int i3 = true == z ? 1 : -1;
        if (zzaoVarZza == null) {
            zzaoVarZza = zzaeVar.zzl(i);
            i += i3;
        }
        while ((i2 - i) * i3 >= 0) {
            if (zzaeVar.zzo(i)) {
                zzaoVarZza = zzaiVar.zza(zzgVar, Arrays.asList(zzaoVarZza, zzaeVar.zzl(i), new zzah(Double.valueOf(i)), zzaeVar));
                if (zzaoVarZza instanceof zzag) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i3;
            } else {
                i += i3;
            }
        }
        return zzaoVarZza;
    }

    private static zzae zzc(zzae zzaeVar, zzg zzgVar, zzai zzaiVar, Boolean bool, Boolean bool2) {
        zzae zzaeVar2 = new zzae();
        Iterator itZzg = zzaeVar.zzg();
        while (itZzg.hasNext()) {
            int iIntValue = ((Integer) itZzg.next()).intValue();
            if (zzaeVar.zzo(iIntValue)) {
                zzao zzaoVarZza = zzaiVar.zza(zzgVar, Arrays.asList(zzaeVar.zzl(iIntValue), new zzah(Double.valueOf(iIntValue)), zzaeVar));
                if (zzaoVarZza.zze().equals(bool)) {
                    break;
                }
                if (bool2 == null || zzaoVarZza.zze().equals(bool2)) {
                    zzaeVar2.zzn(iIntValue, zzaoVarZza);
                }
            }
        }
        return zzaeVar2;
    }
}
