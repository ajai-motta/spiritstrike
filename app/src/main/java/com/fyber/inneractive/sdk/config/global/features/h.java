package com.fyber.inneractive.sdk.config.global.features;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends com.fyber.inneractive.sdk.config.global.p {
    public String b;
    public HashMap c = new HashMap();
    public HashMap d = new HashMap();

    public h(String str) {
        this.b = str;
    }

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final String a(String str, String str2) {
        String strB;
        Iterator it = this.d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                strB = null;
                break;
            }
            strB = ((com.fyber.inneractive.sdk.config.global.k) this.d.get((String) it.next())).b(str);
            if (strB != null) {
                break;
            }
        }
        if (strB != null) {
            return strB;
        }
        com.fyber.inneractive.sdk.config.global.n nVar = this.f953a;
        return nVar != null ? nVar.a(str, str2) : str2;
    }

    public abstract h b();

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final String b(String str) {
        return a(str, null);
    }

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final Boolean c(String str) {
        Boolean boolC;
        Iterator it = this.d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                boolC = null;
                break;
            }
            boolC = ((com.fyber.inneractive.sdk.config.global.k) this.d.get((String) it.next())).c(str);
            if (boolC != null) {
                break;
            }
        }
        return boolC == null ? super.c(str) : boolC;
    }

    public final String toString() {
        return String.format("id: %s, params: %s exp: %s", this.b, this.f953a, this.c);
    }

    @Override // com.fyber.inneractive.sdk.config.global.p, com.fyber.inneractive.sdk.config.global.n
    public final Integer a(String str) {
        Integer numA;
        Iterator it = this.d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                numA = null;
                break;
            }
            numA = ((com.fyber.inneractive.sdk.config.global.k) this.d.get((String) it.next())).a(str);
            if (numA != null) {
                break;
            }
        }
        return numA == null ? super.a(str) : numA;
    }

    public final void a(h hVar) {
        hVar.b = this.b;
        hVar.f953a = this.f953a;
        hVar.c = new HashMap(this.c);
        hVar.d = new HashMap(this.d);
    }
}
