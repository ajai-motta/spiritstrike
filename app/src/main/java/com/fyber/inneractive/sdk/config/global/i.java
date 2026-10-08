package com.fyber.inneractive.sdk.config.global;

import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f949a = new HashSet();
    public final boolean b;

    public i(JSONArray jSONArray, boolean z) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                long jOptLong = jSONArray.optLong(i);
                if (jOptLong != 0) {
                    this.f949a.add(Long.valueOf(jOptLong));
                }
            }
        }
        this.b = z;
    }

    @Override // com.fyber.inneractive.sdk.config.global.d
    public final boolean a(e eVar) {
        if (this.f949a.isEmpty() || eVar.b == null) {
            return false;
        }
        Iterator it = this.f949a.iterator();
        while (it.hasNext()) {
            if (((Long) it.next()).equals(eVar.b)) {
                return !this.b;
            }
        }
        return this.b;
    }

    public final String toString() {
        return String.format("%s - %s include: %b", "pub_id", this.f949a, Boolean.valueOf(this.b));
    }
}
