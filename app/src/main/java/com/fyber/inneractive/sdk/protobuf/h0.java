package com.fyber.inneractive.sdk.protobuf;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 {
    public static volatile h0 b;
    public static final h0 c = new h0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f1556a = Collections.emptyMap();

    public static h0 a() {
        h0 h0Var = b;
        if (h0Var == null) {
            synchronized (h0.class) {
                h0Var = b;
                if (h0Var == null) {
                    Class cls = f0.f1552a;
                    h0 h0Var2 = null;
                    if (cls != null) {
                        try {
                            h0Var2 = (h0) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    if (h0Var2 == null) {
                        h0Var2 = c;
                    }
                    b = h0Var2;
                    h0Var = h0Var2;
                }
            }
        }
        return h0Var;
    }

    public final x0 a(int i, d2 d2Var) {
        return (x0) this.f1556a.get(new g0(i, d2Var));
    }
}
