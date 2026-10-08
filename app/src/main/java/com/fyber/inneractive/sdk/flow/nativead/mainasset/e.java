package com.fyber.inneractive.sdk.flow.nativead.mainasset;

import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.response.nativead.i;
import com.fyber.inneractive.sdk.response.nativead.j;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {
    public static d a(r rVar, j jVar, InneractiveAdRequest inneractiveAdRequest, i iVar, String str, com.fyber.inneractive.sdk.flow.nativead.f fVar) {
        com.fyber.inneractive.sdk.response.nativead.c cVar;
        String str2;
        ArrayList arrayList = iVar.f1621a;
        if (arrayList != null && !arrayList.isEmpty()) {
            for (com.fyber.inneractive.sdk.response.nativead.f fVar2 : iVar.f1621a) {
                if (fVar2.f1618a == 3 && jVar.T.d()) {
                    return new f(fVar2, rVar, jVar, inneractiveAdRequest, str, fVar);
                }
                if (fVar2.f1618a == 2 && (cVar = fVar2.d) != null && (str2 = cVar.f1615a) != null && !str2.trim().isEmpty()) {
                    return new b(fVar2, fVar, jVar, rVar);
                }
            }
        }
        return null;
    }
}
