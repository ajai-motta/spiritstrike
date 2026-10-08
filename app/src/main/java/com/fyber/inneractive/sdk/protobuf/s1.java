package com.fyber.inneractive.sdk.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class s1 extends t1 {
    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final void a(Object obj, long j) {
        ((c) ((k1) x3.e(obj, j))).f1542a = false;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final List b(Object obj, long j) {
        k1 k1Var = (k1) x3.e(obj, j);
        if (((c) k1Var).f1542a) {
            return k1Var;
        }
        int size = k1Var.size();
        k1 k1VarB = k1Var.b(size == 0 ? 10 : size * 2);
        x3.a(j, obj, k1VarB);
        return k1VarB;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final void a(long j, Object obj, Object obj2) {
        k1 k1VarB = (k1) x3.e(obj, j);
        k1 k1Var = (k1) x3.e(obj2, j);
        int size = k1VarB.size();
        int size2 = k1Var.size();
        if (size > 0 && size2 > 0) {
            if (!((c) k1VarB).f1542a) {
                k1VarB = k1VarB.b(size2 + size);
            }
            k1VarB.addAll(k1Var);
        }
        if (size > 0) {
            k1Var = k1VarB;
        }
        x3.a(j, obj, k1Var);
    }
}
