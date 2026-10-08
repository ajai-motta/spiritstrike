package com.tnkfactory.ad.pub;

import android.content.Context;
import com.tnkfactory.framework.vo.ValueObject;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class k5 extends b {
    public final c c;

    public k5(Context context, c cVar) {
        super(context, cVar.e);
        this.c = cVar;
    }

    public final void a(int i, HashMap map, t tVar) {
        ValueObject valueObject = new ValueObject();
        valueObject.add((Map<String, Object>) map);
        String strA = h1.a("d66d03d8e0");
        String strA2 = h1.a("d66a0e95ec42825dfa7b614c1df638a086df17102b4b");
        c cVar = this.c;
        s0 s0Var = new s0(this.b, this.f3109a, strA, strA2, new Object[]{cVar.c, cVar.g, Integer.valueOf(i), valueObject}, null);
        s0Var.i = null;
        if (tVar != null) {
            s0Var.g = new a(tVar);
        }
        s0Var.start();
    }
}
