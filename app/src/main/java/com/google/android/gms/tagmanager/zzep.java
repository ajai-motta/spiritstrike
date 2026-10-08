package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.gtm.zzre;
import com.google.android.gms.internal.gtm.zzrg;
import com.google.android.gms.internal.gtm.zzri;
import com.google.android.gms.internal.gtm.zzrm;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzep {
    private static final zzdn zza = new zzdn(zzfp.zza(), true);
    private final zzrg zzb;
    private final Map zzc;
    private final Map zzd;
    private final Map zze;
    private final Set zzf;
    private final DataLayer zzg;
    private final Map zzh;
    private volatile String zzi;
    private int zzj;
    private final zzcw zzk;
    private final zzcw zzl;

    public zzep(Context context, zzrg zzrgVar, DataLayer dataLayer, zzal zzalVar, zzal zzalVar2, zzdg zzdgVar) {
        this.zzb = zzrgVar;
        HashSet<zzri> hashSet = new HashSet(zzrgVar.zzc());
        this.zzf = hashSet;
        this.zzg = dataLayer;
        this.zzk = new zzcw(1048576, new zzei(this));
        this.zzl = new zzcw(1048576, new zzej(this));
        HashMap map = new HashMap();
        this.zzc = map;
        zzj(map, new zzo(context));
        zzj(map, new zzam(zzalVar2));
        zzj(map, new zzba(dataLayer));
        zzj(map, new zzfq(context, dataLayer));
        HashMap map2 = new HashMap();
        this.zzd = map2;
        zzj(map2, new zzaj());
        zzj(map2, new zzbm());
        zzj(map2, new zzbn());
        zzj(map2, new zzbr());
        zzj(map2, new zzbs());
        zzj(map2, new zzcy());
        zzj(map2, new zzcz());
        zzj(map2, new zzdz());
        zzj(map2, new zzfe());
        HashMap map3 = new HashMap();
        this.zze = map3;
        zzj(map3, new zze(zzd.zzb(context)));
        zzj(map3, new zzf(zzd.zzb(context)));
        zzj(map3, new zzh(context));
        zzj(map3, new zzi(context));
        zzj(map3, new zzj(context));
        zzj(map3, new zzk(context));
        zzj(map3, new zzl(context));
        zzj(map3, new zzr());
        zzj(map3, new zzai(zzrgVar.zzb()));
        zzj(map3, new zzam(zzalVar));
        zzj(map3, new zzat(dataLayer));
        zzj(map3, new zzbd(context));
        zzj(map3, new zzbe());
        zzj(map3, new zzbl());
        zzj(map3, new zzbo(this));
        zzj(map3, new zzbt());
        zzj(map3, new zzbu());
        zzj(map3, new zzcr(context));
        zzj(map3, new zzct());
        zzj(map3, new zzcx());
        zzj(map3, new zzdd());
        zzj(map3, new zzde(context));
        zzj(map3, new zzdo());
        zzj(map3, new zzds());
        zzj(map3, new zzdw());
        zzj(map3, new zzdy());
        zzj(map3, new zzea(context));
        zzj(map3, new zzeq());
        zzj(map3, new zzer());
        zzj(map3, new zzfk());
        zzj(map3, new zzfr());
        this.zzh = new HashMap();
        for (zzri zzriVar : hashSet) {
            for (int i = 0; i < zzriVar.zza().size(); i++) {
                zzre zzreVar = (zzre) zzriVar.zza().get(i);
                zzeo zzeoVarZzg = zzg(this.zzh, zzh(zzreVar));
                zzeoVarZzg.zzk(zzriVar);
                zzeoVarZzg.zzg(zzriVar, zzreVar);
                zzeoVarZzg.zzh(zzriVar, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
            }
            for (int i2 = 0; i2 < zzriVar.zzf().size(); i2++) {
                zzre zzreVar2 = (zzre) zzriVar.zzf().get(i2);
                zzeo zzeoVarZzg2 = zzg(this.zzh, zzh(zzreVar2));
                zzeoVarZzg2.zzk(zzriVar);
                zzeoVarZzg2.zzi(zzriVar, zzreVar2);
                zzeoVarZzg2.zzj(zzriVar, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
            }
        }
        for (Map.Entry entry : this.zzb.zzd().entrySet()) {
            for (zzre zzreVar3 : (List) entry.getValue()) {
                if (!zzfp.zzf(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) zzreVar3.zzc().get(com.google.android.gms.internal.gtm.zzb.NOT_DEFAULT_MACRO.toString()))).booleanValue()) {
                    zzg(this.zzh, (String) entry.getKey()).zzl(zzreVar3);
                }
            }
        }
    }

    private static zzeo zzg(Map map, String str) {
        zzeo zzeoVar = (zzeo) map.get(str);
        if (zzeoVar != null) {
            return zzeoVar;
        }
        zzeo zzeoVar2 = new zzeo();
        map.put(str, zzeoVar2);
        return zzeoVar2;
    }

    private static String zzh(zzre zzreVar) {
        return zzfp.zzm(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) zzreVar.zzc().get(com.google.android.gms.internal.gtm.zzb.INSTANCE_NAME.toString())));
    }

    private final String zzi() {
        if (this.zzj <= 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.zzj));
        for (int i = 2; i < this.zzj; i++) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }

    private static void zzj(Map map, zzbp zzbpVar) {
        if (map.containsKey(zzbpVar.zze())) {
            throw new IllegalArgumentException("Duplicate function type name: ".concat(String.valueOf(zzbpVar.zze())));
        }
        map.put(zzbpVar.zze(), zzbpVar);
    }

    private final void zzk(com.google.android.gms.internal.gtm.zzap zzapVar, Set set) {
        zzdn zzdnVarZzo;
        if (zzapVar == null || (zzdnVarZzo = zzo(zzapVar, set, new zzdl())) == zza) {
            return;
        }
        Object objZzk = zzfp.zzk((com.google.android.gms.internal.gtm.zzap) zzdnVarZzo.zza());
        if (objZzk instanceof Map) {
            this.zzg.push((Map) objZzk);
            return;
        }
        if (!(objZzk instanceof List)) {
            Log.w("GoogleTagManager", "pushAfterEvaluate: value not a Map or List");
            return;
        }
        for (Object obj : (List) objZzk) {
            if (obj instanceof Map) {
                this.zzg.push((Map) obj);
            } else {
                Log.w("GoogleTagManager", "pushAfterEvaluate: value not a Map");
            }
        }
    }

    private final zzdn zzl(Set set, Set set2, zzem zzemVar, zzdk zzdkVar) {
        zzdn zzdnVar;
        Set hashSet = new HashSet();
        Set hashSet2 = new HashSet();
        Iterator it = set.iterator();
        while (true) {
            boolean z = true;
            while (it.hasNext()) {
                zzri zzriVar = (zzri) it.next();
                zzdj zzdjVar = new zzdj();
                Iterator it2 = zzriVar.zzd().iterator();
                while (true) {
                    boolean z2 = true;
                    while (true) {
                        if (!it2.hasNext()) {
                            Iterator it3 = zzriVar.zze().iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    zzfp.zzb(true);
                                    zzdnVar = new zzdn(true, z2);
                                    break;
                                }
                                zzdn zzdnVarZzf = zzf((zzre) it3.next(), set2, new zzdi());
                                if (!((Boolean) zzdnVarZzf.zza()).booleanValue()) {
                                    zzfp.zzb(false);
                                    zzdnVar = new zzdn(false, zzdnVarZzf.zzb());
                                    break;
                                }
                                z2 = z2 && zzdnVarZzf.zzb();
                            }
                        } else {
                            zzdn zzdnVarZzf2 = zzf((zzre) it2.next(), set2, new zzdi());
                            if (((Boolean) zzdnVarZzf2.zza()).booleanValue()) {
                                zzfp.zzb(false);
                                zzdnVar = new zzdn(false, zzdnVarZzf2.zzb());
                                break;
                            }
                            if (!z2 || !zzdnVarZzf2.zzb()) {
                                z2 = false;
                            }
                        }
                    }
                }
                if (((Boolean) zzdnVar.zza()).booleanValue()) {
                    zzemVar.zza(zzriVar, hashSet, hashSet2, zzdjVar);
                }
                if (!z || !zzdnVar.zzb()) {
                    z = false;
                }
            }
            hashSet.removeAll(hashSet2);
            return new zzdn(hashSet, z);
        }
    }

    private final zzdn zzm(String str, Set set, zzdh zzdhVar) {
        zzre zzreVarZza;
        this.zzj++;
        zzen zzenVar = (zzen) this.zzl.zza(str);
        if (zzenVar != null) {
            zzk(zzenVar.zzb(), set);
            this.zzj--;
            return zzenVar.zzc();
        }
        zzeo zzeoVar = (zzeo) this.zzh.get(str);
        if (zzeoVar == null) {
            Log.e("GoogleTagManager", zzi() + "Invalid macro: " + str);
            this.zzj = this.zzj + (-1);
            return zza;
        }
        zzdn zzdnVarZzl = zzl(zzeoVar.zzf(), set, new zzek(this, zzeoVar.zzc(), zzeoVar.zzb(), zzeoVar.zze(), zzeoVar.zzd()), new zzdk());
        if (((Set) zzdnVarZzl.zza()).isEmpty()) {
            zzreVarZza = zzeoVar.zza();
        } else {
            if (((Set) zzdnVarZzl.zza()).size() > 1) {
                Log.w("GoogleTagManager", zzi() + "Multiple macros active for macroName " + str);
            }
            zzreVarZza = (zzre) ((Set) zzdnVarZzl.zza()).iterator().next();
        }
        if (zzreVarZza == null) {
            this.zzj--;
            return zza;
        }
        zzdn zzdnVarZzn = zzn(this.zze, zzreVarZza, set, new zzdi());
        boolean z = zzdnVarZzl.zzb() && zzdnVarZzn.zzb();
        zzdn zzdnVar = zza;
        if (zzdnVarZzn != zzdnVar) {
            zzdnVar = new zzdn((com.google.android.gms.internal.gtm.zzap) zzdnVarZzn.zza(), z);
        }
        com.google.android.gms.internal.gtm.zzap zzapVarZza = zzreVarZza.zza();
        if (zzdnVar.zzb()) {
            this.zzl.zzb(str, new zzen(zzdnVar, zzapVarZza));
        }
        zzk(zzapVarZza, set);
        this.zzj--;
        return zzdnVar;
    }

    private final zzdn zzn(Map map, zzre zzreVar, Set set, zzdi zzdiVar) {
        com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) zzreVar.zzc().get(com.google.android.gms.internal.gtm.zzb.FUNCTION.toString());
        if (zzapVar == null) {
            Log.e("GoogleTagManager", "No function id in properties");
            return zza;
        }
        String strZzn = zzapVar.zzn();
        zzbp zzbpVar = (zzbp) map.get(strZzn);
        if (zzbpVar == null) {
            Log.e("GoogleTagManager", String.valueOf(strZzn).concat(" has no backing implementation."));
            return zza;
        }
        zzdn zzdnVar = (zzdn) this.zzk.zza(zzreVar);
        if (zzdnVar != null) {
            return zzdnVar;
        }
        HashMap map2 = new HashMap();
        boolean z = true;
        for (Map.Entry entry : zzreVar.zzc().entrySet()) {
            com.google.android.gms.internal.gtm.zzap zzapVar2 = (com.google.android.gms.internal.gtm.zzap) entry.getValue();
            zzdn zzdnVarZzo = zzo(zzapVar2, set, new zzdl());
            zzdn zzdnVar2 = zza;
            if (zzdnVarZzo == zzdnVar2) {
                return zzdnVar2;
            }
            if (zzdnVarZzo.zzb()) {
                zzreVar.zzd((String) entry.getKey(), (com.google.android.gms.internal.gtm.zzap) zzdnVarZzo.zza());
            } else {
                z = false;
            }
            map2.put((String) entry.getKey(), (com.google.android.gms.internal.gtm.zzap) zzdnVarZzo.zza());
        }
        if (zzbpVar.zzg(map2.keySet())) {
            boolean z2 = z && zzbpVar.zzb();
            zzdn zzdnVar3 = new zzdn(zzbpVar.zza(map2), z2);
            if (z2) {
                this.zzk.zzb(zzreVar, zzdnVar3);
            }
            return zzdnVar3;
        }
        Log.e("GoogleTagManager", "Incorrect keys for function " + strZzn + " required " + zzbpVar.zzf().toString() + " had " + String.valueOf(map2.keySet()));
        return zza;
    }

    private final zzdn zzo(com.google.android.gms.internal.gtm.zzap zzapVar, Set set, zzdl zzdlVar) {
        if (!zzapVar.zzN()) {
            return new zzdn(zzapVar, true);
        }
        int iZzO = zzapVar.zzO();
        if (iZzO == 2) {
            com.google.android.gms.internal.gtm.zzak zzakVar = (com.google.android.gms.internal.gtm.zzak) zzrm.zza(zzapVar).zzaa();
            zzakVar.zzj();
            for (int i = 0; i < zzapVar.zza(); i++) {
                zzdn zzdnVarZzo = zzo(zzapVar.zzj(i), set, new zzdl());
                zzdn zzdnVar = zza;
                if (zzdnVarZzo == zzdnVar) {
                    return zzdnVar;
                }
                zzakVar.zze((com.google.android.gms.internal.gtm.zzap) zzdnVarZzo.zza());
            }
            return new zzdn((com.google.android.gms.internal.gtm.zzap) zzakVar.zzD(), false);
        }
        if (iZzO == 3) {
            com.google.android.gms.internal.gtm.zzak zzakVar2 = (com.google.android.gms.internal.gtm.zzak) zzrm.zza(zzapVar).zzaa();
            if (zzapVar.zzc() != zzapVar.zzd()) {
                Log.e("GoogleTagManager", "Invalid serving value: ".concat(zzapVar.toString()));
                return zza;
            }
            zzakVar2.zzk();
            zzakVar2.zzl();
            for (int i2 = 0; i2 < zzapVar.zzc(); i2++) {
                zzdn zzdnVarZzo2 = zzo(zzapVar.zzk(i2), set, new zzdl());
                zzdn zzdnVarZzo3 = zzo(zzapVar.zzl(i2), set, new zzdl());
                zzdn zzdnVar2 = zza;
                if (zzdnVarZzo2 == zzdnVar2 || zzdnVarZzo3 == zzdnVar2) {
                    return zzdnVar2;
                }
                zzakVar2.zzf((com.google.android.gms.internal.gtm.zzap) zzdnVarZzo2.zza());
                zzakVar2.zzg((com.google.android.gms.internal.gtm.zzap) zzdnVarZzo3.zza());
            }
            return new zzdn((com.google.android.gms.internal.gtm.zzap) zzakVar2.zzD(), false);
        }
        if (iZzO != 4) {
            if (iZzO != 7) {
                Log.e("GoogleTagManager", "Unknown type: ".concat(Integer.toString(zzapVar.zzO())));
                return zza;
            }
            com.google.android.gms.internal.gtm.zzak zzakVar3 = (com.google.android.gms.internal.gtm.zzak) zzrm.zza(zzapVar).zzaa();
            zzakVar3.zzm();
            for (int i3 = 0; i3 < zzapVar.zze(); i3++) {
                zzdn zzdnVarZzo4 = zzo(zzapVar.zzm(i3), set, new zzdl());
                zzdn zzdnVar3 = zza;
                if (zzdnVarZzo4 == zzdnVar3) {
                    return zzdnVar3;
                }
                zzakVar3.zzh((com.google.android.gms.internal.gtm.zzap) zzdnVarZzo4.zza());
            }
            return new zzdn((com.google.android.gms.internal.gtm.zzap) zzakVar3.zzD(), false);
        }
        if (set.contains(zzapVar.zzo())) {
            Log.e("GoogleTagManager", "Macro cycle detected.  Current macro reference: " + zzapVar.zzo() + ".  Previous macro references: " + set.toString() + ".");
            return zza;
        }
        set.add(zzapVar.zzo());
        zzdn zzdnVarZzm = zzm(zzapVar.zzo(), set, new zzdh());
        for (com.google.android.gms.internal.gtm.zzam zzamVar : (com.google.android.gms.internal.gtm.zzam[]) zzapVar.zzq().toArray(new com.google.android.gms.internal.gtm.zzam[0])) {
            if (!(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) zzdnVarZzm.zza()) instanceof String)) {
                Log.e("GoogleTagManager", "Escaping can only be applied to strings.");
            } else if (zzamVar.ordinal() == 11) {
                try {
                    zzdnVarZzm = new zzdn(zzfp.zzb(zzfs.zza(zzfp.zzm(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) zzdnVarZzm.zza())))), zzdnVarZzm.zzb());
                } catch (UnsupportedEncodingException e) {
                    Log.e("GoogleTagManager", "Escape URI: unsupported encoding", e);
                }
            }
        }
        set.remove(zzapVar.zzo());
        return zzdnVarZzm;
    }

    public final zzdn zza(String str) {
        this.zzj = 0;
        return zzm(str, new HashSet(), new zzdh());
    }

    final synchronized String zzb() {
        return this.zzi;
    }

    public final synchronized void zzc(String str) {
        zzd(str);
        zzdk zzdkVar = new zzdk();
        Iterator it = ((Set) zzl(this.zzf, new HashSet(), new zzel(this), zzdkVar).zza()).iterator();
        while (it.hasNext()) {
            zzn(this.zzc, (zzre) it.next(), new HashSet(), new zzdi());
        }
        zzd(null);
    }

    final synchronized void zzd(String str) {
        this.zzi = str;
    }

    public final synchronized void zze(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.google.android.gms.internal.gtm.zzaf zzafVar = (com.google.android.gms.internal.gtm.zzaf) it.next();
            if (zzafVar.zzf() && zzafVar.zzd().startsWith("gaExperiment:")) {
                DataLayer dataLayer = this.zzg;
                if (zzafVar.zze()) {
                    Iterator it2 = zzafVar.zza().zze().iterator();
                    while (it2.hasNext()) {
                        dataLayer.zzd(zzfp.zzm(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) it2.next())));
                    }
                    Iterator it3 = zzafVar.zza().zzf().iterator();
                    while (true) {
                        Map<String, Object> map = null;
                        if (!it3.hasNext()) {
                            break;
                        }
                        Object objZzk = zzfp.zzk((com.google.android.gms.internal.gtm.zzap) it3.next());
                        if (objZzk instanceof Map) {
                            map = (Map) objZzk;
                        } else {
                            Log.w("GoogleTagManager", "value: " + String.valueOf(objZzk) + " is not a map value, ignored.");
                        }
                        if (map != null) {
                            dataLayer.push(map);
                        }
                    }
                    for (com.google.android.gms.internal.gtm.zzt zztVar : zzafVar.zza().zzd()) {
                        if (zztVar.zzh()) {
                            Object objValueOf = dataLayer.get(zztVar.zzf());
                            Long lValueOf = !(objValueOf instanceof Number) ? null : Long.valueOf(((Number) objValueOf).longValue());
                            long jZzd = zztVar.zzd();
                            long jZzc = zztVar.zzc();
                            if (!zztVar.zzg() || lValueOf == null || lValueOf.longValue() < jZzd || lValueOf.longValue() > jZzc) {
                                if (jZzd <= jZzc) {
                                    objValueOf = Long.valueOf(Math.round((Math.random() * (jZzc - jZzd)) + jZzd));
                                } else {
                                    Log.w("GoogleTagManager", "GaExperimentRandom: random range invalid");
                                }
                            }
                            dataLayer.zzd(zztVar.zzf());
                            Map mapZza = dataLayer.zza(zztVar.zzf(), objValueOf);
                            if (zztVar.zza() > 0) {
                                if (mapZza.containsKey("gtm")) {
                                    Object obj = mapZza.get("gtm");
                                    if (obj instanceof Map) {
                                        ((Map) obj).put("lifetime", Long.valueOf(zztVar.zza()));
                                    } else {
                                        Log.w("GoogleTagManager", "GaExperimentRandom: gtm not a map");
                                    }
                                } else {
                                    mapZza.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(zztVar.zza())));
                                }
                            }
                            dataLayer.push(mapZza);
                        } else {
                            Log.w("GoogleTagManager", "GaExperimentRandom: No key");
                        }
                    }
                } else {
                    Log.w("GoogleTagManager", "supplemental missing experimentSupplemental");
                }
            } else {
                zzdc.zzb.zzd("Ignored supplemental: ".concat(String.valueOf(String.valueOf(zzafVar))));
            }
        }
    }

    final zzdn zzf(zzre zzreVar, Set set, zzdi zzdiVar) {
        zzdn zzdnVarZzn = zzn(this.zzd, zzreVar, set, zzdiVar);
        Boolean boolZzf = zzfp.zzf(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) zzdnVarZzn.zza()));
        zzfp.zzb(boolZzf);
        return new zzdn(boolZzf, zzdnVarZzn.zzb());
    }
}
