package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zziu extends zzit {
    private final Function2 zza;
    private final String zzb;

    public zziu(Function2 function2, String str, Object obj) {
        super(obj);
        this.zza = function2;
        this.zzb = str;
    }

    @Override // com.google.android.recaptcha.internal.zzit
    public final boolean zza(Object obj, Method method, Object[] objArr) {
        List listEmptyList;
        if (!Intrinsics.areEqual(method.getName(), this.zzb)) {
            return false;
        }
        zzyu zzyuVarZzf = zzyx.zzf();
        if (objArr != null) {
            ArrayList arrayList = new ArrayList(objArr.length);
            for (Object obj2 : objArr) {
                zzyv zzyvVarZzf = zzyw.zzf();
                zzyvVarZzf.zzw(obj2.toString());
                arrayList.add((zzyw) zzyvVarZzf.zzk());
            }
            listEmptyList = arrayList;
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        zzyuVarZzf.zze(listEmptyList);
        zzyx zzyxVar = (zzyx) zzyuVarZzf.zzk();
        Function2 function2 = this.zza;
        byte[] bArrZzd = zzyxVar.zzd();
        function2.invoke(objArr, zzpp.zzh().zzi(bArrZzd, 0, bArrZzd.length));
        return true;
    }
}
