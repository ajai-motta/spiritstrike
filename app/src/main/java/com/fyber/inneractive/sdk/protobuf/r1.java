package com.fyber.inneractive.sdk.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class r1 extends t1 {
    public static final Class c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final void a(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) x3.e(obj, j);
        if (list instanceof q1) {
            objUnmodifiableList = ((q1) list).a();
        } else {
            if (c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof n2) && (list instanceof k1)) {
                c cVar = (c) ((k1) list);
                if (cVar.f1542a) {
                    cVar.f1542a = false;
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        x3.a(j, obj, objUnmodifiableList);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final List b(Object obj, long j) {
        return a(obj, j, 10);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.t1
    public final void a(long j, Object obj, Object obj2) {
        List list = (List) x3.e(obj2, j);
        List listA = a(obj, j, list.size());
        int size = listA.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            listA.addAll(list);
        }
        if (size > 0) {
            list = listA;
        }
        x3.a(j, obj, list);
    }

    public static List a(Object obj, long j, int i) {
        List list;
        List arrayList;
        List list2 = (List) x3.e(obj, j);
        if (list2.isEmpty()) {
            if (list2 instanceof q1) {
                arrayList = new p1(i);
            } else if ((list2 instanceof n2) && (list2 instanceof k1)) {
                arrayList = ((k1) list2).b(i);
            } else {
                arrayList = new ArrayList(i);
            }
            x3.a(j, obj, arrayList);
            return arrayList;
        }
        if (c.isAssignableFrom(list2.getClass())) {
            ArrayList arrayList2 = new ArrayList(list2.size() + i);
            arrayList2.addAll(list2);
            x3.a(j, obj, arrayList2);
            list = arrayList2;
        } else if (list2 instanceof r3) {
            p1 p1Var = new p1(list2.size() + i);
            p1Var.addAll((r3) list2);
            x3.a(j, obj, p1Var);
            list = p1Var;
        } else {
            if (!(list2 instanceof n2) || !(list2 instanceof k1)) {
                return list2;
            }
            k1 k1Var = (k1) list2;
            if (((c) k1Var).f1542a) {
                return list2;
            }
            k1 k1VarB = k1Var.b(list2.size() + i);
            x3.a(j, obj, k1VarB);
            return k1VarB;
        }
        return list;
    }
}
