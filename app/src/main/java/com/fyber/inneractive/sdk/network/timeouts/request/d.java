package com.fyber.inneractive.sdk.network.timeouts.request;

import androidx.compose.animation.core.AnimationConstants;
import com.fyber.inneractive.sdk.config.global.features.j;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends a {
    public d(String str, j jVar, String str2) {
        super(str, jVar, str2);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(j jVar, String str) {
        return jVar.c(str, this.l);
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int b(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String strA = j.a(str, "min", "rat", j.e(str2));
        "read".equalsIgnoreCase(str);
        Integer numA = jVar.a(j.a(str, "min", "rat", "all_mediators"));
        int iIntValue = numA != null ? numA.intValue() : 5000;
        Integer numA2 = jVar.a(strA);
        return numA2 != null ? numA2.intValue() : iIntValue;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int c(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String strA = j.a(str, "rat", "perc", j.e(str2));
        String strA2 = j.a(str, "rat", "perc", "all_mediators");
        int iIntValue = "read".equalsIgnoreCase(str) ? 15 : 10;
        Integer numA = jVar.a(strA2);
        if (numA != null) {
            iIntValue = numA.intValue();
        }
        Integer numA2 = jVar.a(strA);
        return numA2 != null ? numA2.intValue() : iIntValue;
    }

    @Override // com.fyber.inneractive.sdk.network.timeouts.request.a
    public final int a(j jVar) {
        String str = this.l;
        jVar.getClass();
        String strA = j.a("timeout", "threshold", j.e(str));
        Integer numA = jVar.a(j.a("timeout", "threshold", "all_mediators"));
        int iIntValue = numA != null ? numA.intValue() : AnimationConstants.DefaultDurationMillis;
        Integer numA2 = jVar.a(strA);
        return numA2 != null ? numA2.intValue() : iIntValue;
    }
}
