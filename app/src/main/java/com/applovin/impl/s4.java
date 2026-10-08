package com.applovin.impl;

import android.content.Context;
import android.text.SpannedString;
import com.applovin.impl.p0;
import com.applovin.impl.r2;

/* JADX INFO: loaded from: classes2.dex */
public class s4 extends r2 {
    private final p0.a n;
    private final Context o;
    private final boolean p;

    public s4(p0.a aVar, boolean z, Context context) {
        super(r2.c.RIGHT_DETAIL);
        this.n = aVar;
        this.o = context;
        this.c = new SpannedString(aVar.a());
        this.p = z;
    }

    @Override // com.applovin.impl.r2
    public SpannedString f() {
        return new SpannedString(this.n.a(this.o));
    }

    @Override // com.applovin.impl.r2
    public boolean o() {
        return false;
    }

    @Override // com.applovin.impl.r2
    public boolean p() {
        Boolean boolB = this.n.b(this.o);
        if (boolB != null) {
            return boolB.equals(Boolean.valueOf(this.p));
        }
        return false;
    }
}
