package com.moloco.sdk.internal;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3028i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3029j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3030k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3031l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3035p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class l {
    public static final C3028i a(com.moloco.sdk.internal.ortb.model.j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        com.moloco.sdk.internal.ortb.model.l appName = jVar.getAppName();
        String strE = appName != null ? appName.e() : null;
        String ctaUrl = jVar.getCtaUrl();
        String ctaTrackingUrl = jVar.getCtaTrackingUrl();
        String impressionTrackingUrl = jVar.getImpressionTrackingUrl();
        String skipToDecTrackingUrl = jVar.getSkipToDecTrackingUrl();
        com.moloco.sdk.internal.ortb.model.l appName2 = jVar.getAppName();
        Integer numC = appName2 != null ? appName2.c() : null;
        com.moloco.sdk.internal.ortb.model.n decCta = jVar.getDecCta();
        C3031l c3031lA = decCta != null ? a(decCta) : null;
        com.moloco.sdk.internal.ortb.model.k decAppIcon = jVar.getDecAppIcon();
        C3029j c3029jA = decAppIcon != null ? a(decAppIcon) : null;
        com.moloco.sdk.internal.ortb.model.o decRating = jVar.getDecRating();
        return new C3028i(strE, ctaUrl, ctaTrackingUrl, impressionTrackingUrl, skipToDecTrackingUrl, numC, c3031lA, c3029jA, decRating != null ? a(decRating) : null);
    }

    public static final C3031l a(com.moloco.sdk.internal.ortb.model.n nVar) {
        Intrinsics.checkNotNullParameter(nVar, "<this>");
        Integer numT = nVar.t();
        String strN = nVar.n();
        Integer numL = nVar.l();
        Integer numP = nVar.p();
        com.moloco.sdk.internal.ortb.model.m mVarJ = nVar.j();
        return new C3031l(numT, strN, numL, numP, mVarJ != null ? a(mVarJ) : null, nVar.r(), nVar.h());
    }

    public static final C3029j a(com.moloco.sdk.internal.ortb.model.k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        Integer numH = kVar.h();
        String strD = kVar.d();
        com.moloco.sdk.internal.ortb.model.m mVarF = kVar.f();
        return new C3029j(numH, strD, mVarF != null ? a(mVarF) : null);
    }

    public static final C3035p a(com.moloco.sdk.internal.ortb.model.o oVar) {
        Intrinsics.checkNotNullParameter(oVar, "<this>");
        Float fL = oVar.l();
        String strJ = oVar.j();
        if (strJ == null) {
            strJ = "#FFFFFF00";
        }
        String str = strJ;
        String strF = oVar.f();
        if (strF == null) {
            strF = "#FF888888";
        }
        String str2 = strF;
        Integer numN = oVar.n();
        int iIntValue = numN != null ? numN.intValue() : 12;
        Integer numH = oVar.h();
        return new C3035p(fL, str, str2, iIntValue, numH != null ? numH.intValue() : 9);
    }

    public static final C3030k a(com.moloco.sdk.internal.ortb.model.m mVar) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(mVar, "<this>");
        List<com.moloco.sdk.internal.ortb.model.q> listF = mVar.f();
        if (listF != null) {
            listEmptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listF, 10));
            Iterator<T> it = listF.iterator();
            while (it.hasNext()) {
                listEmptyList.add(((com.moloco.sdk.internal.ortb.model.q) it.next()).b());
            }
        } else {
            listEmptyList = null;
        }
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return new C3030k(mVar.d(), listEmptyList);
    }
}
