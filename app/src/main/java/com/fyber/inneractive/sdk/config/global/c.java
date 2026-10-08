package com.fyber.inneractive.sdk.config.global;

import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f944a = new HashSet();
    public final boolean b;

    public c(JSONArray jSONArray, boolean z) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                long jOptLong = jSONArray.optLong(i);
                if (jOptLong != 0) {
                    this.f944a.add(Long.valueOf(jOptLong));
                }
            }
        }
        this.b = z;
    }

    @Override // com.fyber.inneractive.sdk.config.global.d
    public final boolean a(e eVar) {
        if (this.f944a.isEmpty() || eVar.f945a == null) {
            return false;
        }
        Iterator it = this.f944a.iterator();
        while (it.hasNext()) {
            if (((Long) it.next()).equals(eVar.f945a)) {
                return !this.b;
            }
        }
        return this.b;
    }

    public final String toString() {
        return String.format("%s - %s include: %b", "demand", this.f944a, Boolean.valueOf(this.b));
    }
}
