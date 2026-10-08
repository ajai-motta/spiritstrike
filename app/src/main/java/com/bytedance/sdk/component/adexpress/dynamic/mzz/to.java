package com.bytedance.sdk.component.adexpress.dynamic.mzz;

import com.bytedance.sdk.component.adexpress.dynamic.mzz.ud;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class to {
    public static float qdl(float f) {
        return (float) Math.ceil((f * 16.0f) / 16.0f);
    }

    public static List<ud.qdl> qdl(float f, List<ud.qdl> list) {
        ArrayList<ud.qdl> arrayList = new ArrayList();
        Iterator<ud.qdl> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add((ud.qdl) it.next().clone());
        }
        boolean z = true;
        int i = 0;
        int i2 = 0;
        for (ud.qdl qdlVar : arrayList) {
            if (qdlVar.ud) {
                i = (int) (i + qdlVar.qdl);
            } else {
                i2 = (int) (i2 + qdlVar.qdl);
                z = false;
            }
        }
        if (z && f > i) {
            return arrayList;
        }
        float f2 = i;
        float f3 = f < f2 ? f / f2 : 1.0f;
        float f4 = f > f2 ? (f - f2) / i2 : 0.0f;
        if (f4 > 1.0f) {
            ArrayList arrayList2 = new ArrayList();
            boolean z2 = false;
            for (ud.qdl qdlVar2 : arrayList) {
                if (!qdlVar2.ud && qdlVar2.lnr != 0.0f && qdlVar2.qdl * f4 > qdlVar2.lnr) {
                    qdlVar2.qdl = qdlVar2.lnr;
                    qdlVar2.ud = true;
                    z2 = true;
                }
                arrayList2.add(qdlVar2);
            }
            if (z2) {
                return qdl(f, arrayList2);
            }
        }
        int i3 = 0;
        for (ud.qdl qdlVar3 : arrayList) {
            if (qdlVar3.ud) {
                qdlVar3.qdl = qdl(qdlVar3.qdl * f3);
            } else {
                qdlVar3.qdl = qdl(qdlVar3.qdl * f4);
            }
            i3 = (int) (i3 + qdlVar3.qdl);
        }
        float f5 = i3;
        if (f5 < f) {
            float f6 = f - f5;
            for (int size = 0; size < arrayList.size() && f6 > 0.0f; size = (size + 1) % arrayList.size()) {
                ud.qdl qdlVar4 = (ud.qdl) arrayList.get(size);
                if ((f < f2 && qdlVar4.ud) || (f > f2 && !qdlVar4.ud)) {
                    qdlVar4.qdl += 0.0625f;
                    f6 -= 0.0625f;
                }
            }
        }
        return arrayList;
    }
}
