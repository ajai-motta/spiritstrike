package com.google.android.gms.internal.ads;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.C;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzafp extends zzafr {
    private long zzb;
    private long[] zzc;
    private long[] zzd;

    public zzafp() {
        super(new zzacx());
        this.zzb = C.TIME_UNSET;
        this.zzc = new long[0];
        this.zzd = new long[0];
    }

    private static Double zzg(zzeg zzegVar) {
        return Double.valueOf(Double.longBitsToDouble(zzegVar.zzD()));
    }

    private static String zzh(zzeg zzegVar) {
        int iZzt = zzegVar.zzt();
        int iZzg = zzegVar.zzg();
        zzegVar.zzk(iZzt);
        return new String(zzegVar.zzi(), iZzg, iZzt);
    }

    private static HashMap zzi(zzeg zzegVar) {
        int iZzH = zzegVar.zzH();
        HashMap map = new HashMap(iZzH);
        for (int i = 0; i < iZzH; i++) {
            String strZzh = zzh(zzegVar);
            Object objZzj = zzj(zzegVar, zzegVar.zzs());
            if (objZzj != null) {
                map.put(strZzh, objZzj);
            }
        }
        return map;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    protected final boolean zza(zzeg zzegVar) {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    protected final boolean zzb(zzeg zzegVar, long j) {
        if (zzegVar.zzs() == 2 && "onMetaData".equals(zzh(zzegVar)) && zzegVar.zzd() != 0 && zzegVar.zzs() == 8) {
            HashMap mapZzi = zzi(zzegVar);
            Object obj = mapZzi.get(TypedValues.TransitionType.S_DURATION);
            if (obj instanceof Double) {
                double dDoubleValue = ((Double) obj).doubleValue();
                if (dDoubleValue > 0.0d) {
                    this.zzb = (long) (dDoubleValue * 1000000.0d);
                }
            }
            Object obj2 = mapZzi.get("keyframes");
            if (obj2 instanceof Map) {
                Map map = (Map) obj2;
                Object obj3 = map.get("filepositions");
                Object obj4 = map.get("times");
                if ((obj3 instanceof List) && (obj4 instanceof List)) {
                    List list = (List) obj3;
                    List list2 = (List) obj4;
                    int size = list2.size();
                    this.zzc = new long[size];
                    this.zzd = new long[size];
                    for (int i = 0; i < size; i++) {
                        Object obj5 = list.get(i);
                        Object obj6 = list2.get(i);
                        if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                            this.zzc = new long[0];
                            this.zzd = new long[0];
                            break;
                        }
                        this.zzc[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.zzd[i] = ((Double) obj5).longValue();
                    }
                }
            }
        }
        return false;
    }

    public final long zzc() {
        return this.zzb;
    }

    public final long[] zzd() {
        return this.zzc;
    }

    public final long[] zze() {
        return this.zzd;
    }

    private static Object zzj(zzeg zzegVar, int i) {
        if (i == 0) {
            return zzg(zzegVar);
        }
        if (i == 1) {
            return Boolean.valueOf(zzegVar.zzs() == 1);
        }
        if (i == 2) {
            return zzh(zzegVar);
        }
        if (i != 3) {
            if (i == 8) {
                return zzi(zzegVar);
            }
            if (i != 10) {
                if (i != 11) {
                    return null;
                }
                Date date = new Date((long) zzg(zzegVar).doubleValue());
                zzegVar.zzk(2);
                return date;
            }
            int iZzH = zzegVar.zzH();
            ArrayList arrayList = new ArrayList(iZzH);
            for (int i2 = 0; i2 < iZzH; i2++) {
                Object objZzj = zzj(zzegVar, zzegVar.zzs());
                if (objZzj != null) {
                    arrayList.add(objZzj);
                }
            }
            return arrayList;
        }
        HashMap map = new HashMap();
        while (true) {
            String strZzh = zzh(zzegVar);
            int iZzs = zzegVar.zzs();
            if (iZzs == 9) {
                return map;
            }
            Object objZzj2 = zzj(zzegVar, iZzs);
            if (objZzj2 != null) {
                map.put(strZzh, objZzj2);
            }
        }
    }
}
