package com.fyber.inneractive.sdk.response.nativead;

import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends com.fyber.inneractive.sdk.response.e {
    public i N;

    @Override // com.fyber.inneractive.sdk.response.e
    public final InneractiveErrorCode a(InneractiveAdRequest inneractiveAdRequest, r rVar) {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.response.e
    public final InneractiveErrorCode b() {
        return null;
    }

    public final e c() {
        ArrayList<f> arrayList;
        i iVar = this.N;
        if (iVar == null || (arrayList = iVar.f1621a) == null) {
            fVar = null;
        } else {
            for (f fVar : arrayList) {
                if (fVar.c != null) {
                    break;
                }
            }
            fVar = null;
        }
        if (fVar != null) {
            return fVar.c;
        }
        return null;
    }

    public final boolean d() {
        String str;
        e eVarC = c();
        return (eVarC == null || (str = eVarC.f1617a) == null || str.isEmpty()) ? false : true;
    }
}
