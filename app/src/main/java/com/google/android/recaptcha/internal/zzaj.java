package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaj extends zzg {
    private final List zza;
    private zzqm zzb;
    private final Map zzc;

    public zzaj() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ zzaj(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this.zza = CollectionsKt.listOf((Object[]) new zzar[]{new zzav(), new zzad(), new zzx(), new zzz(), new zzba(null, null, 3, null)});
        this.zzc = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzxx zzp(String str) {
        LinkedHashMap linkedHashMapEmptyMap;
        List list = (List) this.zzc.remove(str);
        if (list != null) {
            List<zzat> list2 = list;
            linkedHashMapEmptyMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
            for (zzat zzatVar : list2) {
                linkedHashMapEmptyMap.put(Integer.valueOf(zzatVar.zzb()), zzatVar);
            }
        } else {
            linkedHashMapEmptyMap = MapsKt.emptyMap();
        }
        zzyo zzyoVarZzr = zzr(linkedHashMapEmptyMap, str);
        zzxw zzxwVarZzf = zzxx.zzf();
        zzxwVarZzf.zze(str);
        zzxq zzxqVarZzf = zzxr.zzf();
        byte[] bArrZzd = zzyoVarZzr.zzd();
        zzxqVarZzf.zze(zzpp.zzh().zzi(bArrZzd, 0, bArrZzd.length));
        zzxwVarZzf.zzq(zzxqVarZzf);
        return (zzxx) zzxwVarZzf.zzk();
    }

    private final zzym zzq(zzat zzatVar) {
        zzqm zzqmVar;
        zzyk zzykVarZzf = zzym.zzf();
        zzykVarZzf.zzq(3);
        if (zzatVar instanceof zzal) {
            zzyx zzyxVarZza = ((zzal) zzatVar).zza();
            zzqm zzqmVar2 = this.zzb;
            zzqmVar = zzqmVar2 != null ? zzqmVar2 : null;
            byte[] bArrZzd = zzyxVarZza.zzd();
            zzykVarZzf.zzf(zzdn.zza(zzpp.zzh().zzi(bArrZzd, 0, bArrZzd.length), zzqmVar));
        } else {
            if (!(zzatVar instanceof zzak)) {
                throw new NoWhenBranchMatchedException();
            }
            zzyt zzytVarZza = ((zzak) zzatVar).zza();
            zzqm zzqmVar3 = this.zzb;
            zzqmVar = zzqmVar3 != null ? zzqmVar3 : null;
            byte[] bArrZzd2 = zzytVarZza.zzd();
            zzykVarZzf.zze(zzdn.zza(zzpp.zzh().zzi(bArrZzd2, 0, bArrZzd2.length), zzqmVar));
        }
        return (zzym) zzykVarZzf.zzk();
    }

    private final zzyo zzr(Map map, String str) {
        zzyn zzynVarZzf = zzyo.zzf();
        zzynVarZzf.zzq(str);
        List list = this.zza;
        ArrayList<zzar> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((zzar) obj).zzi()) {
                arrayList.add(obj);
            }
        }
        for (zzar zzarVar : arrayList) {
            if (!map.containsKey(Integer.valueOf(zzarVar.zza()))) {
                int iZza = zzarVar.zza();
                zzys zzysVarZzf = zzyt.zzf();
                zzysVarZzf.zzf(iZza);
                zzysVarZzf.zzr(13);
                zzysVarZzf.zzq(27);
                zzynVarZzf.zzf(zzq(new zzak(iZza, (zzyt) zzysVarZzf.zzk())));
            }
        }
        Collection collectionValues = map.values();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionValues, 10));
        Iterator it = collectionValues.iterator();
        while (it.hasNext()) {
            arrayList2.add(zzq((zzat) it.next()));
        }
        zzynVarZzf.zze(arrayList2);
        return (zzyo) zzynVarZzf.zzk();
    }

    @Override // com.google.android.recaptcha.internal.zzg
    protected final Object zza(String str, Continuation continuation) {
        return zzp(str);
    }

    @Override // com.google.android.recaptcha.internal.zzg
    protected final Object zzb(String str, Continuation continuation) {
        return new zzhg(new zzag(this, str, null));
    }

    @Override // com.google.android.recaptcha.internal.zzg
    protected final Object zzd(zzxn zzxnVar, Continuation continuation) {
        return new zzhg(new zzai(zzxnVar, this, null));
    }

    @Override // com.google.android.recaptcha.internal.zzg
    protected final void zzh(zzyg zzygVar) {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzar) it.next()).zzh(zzygVar);
        }
    }

    @Override // com.google.android.recaptcha.internal.zzg
    protected final int zzj() {
        return 35;
    }

    @Override // com.google.android.recaptcha.internal.zzg
    protected final int zzk() {
        return 34;
    }

    public final Map zzn() {
        return this.zzc;
    }
}
