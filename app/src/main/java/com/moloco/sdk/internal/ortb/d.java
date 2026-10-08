package com.moloco.sdk.internal.ortb;

import com.moloco.sdk.internal.ortb.model.e;
import com.moloco.sdk.internal.ortb.model.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f2100a = new Regex("\\$\\{AUCTION_PRICE\\}");

    public static final e a(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<this>");
        List<y> listB = eVar.b();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            List<com.moloco.sdk.internal.ortb.model.c> listB2 = ((y) it.next()).b();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listB2, 10));
            for (com.moloco.sdk.internal.ortb.model.c cVar : listB2) {
                float price = cVar.getPrice();
                String crid = cVar.getCrid();
                String strA = a(cVar.getAdm(), Float.valueOf(price));
                String burl = cVar.getBurl();
                arrayList2.add(new com.moloco.sdk.internal.ortb.model.c(strA, price, burl != null ? a(burl, Float.valueOf(price)) : null, cVar.getExt(), crid));
            }
            arrayList.add(new y(arrayList2));
        }
        return new e(arrayList);
    }

    public static final String a(String str, Float f) {
        String string;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Regex regex = f2100a;
        if (f == null || (string = f.toString()) == null) {
            string = "";
        }
        return regex.replace(str, string);
    }
}
