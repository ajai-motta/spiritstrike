package com.fyber.inneractive.sdk.flow.endcard;

import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f1058a = new ArrayList();
    public final ArrayList b = new ArrayList();
    public int c = -1;
    public final g d = new g();

    public final b a() {
        int i = this.c;
        if (i >= 0) {
            return (b) this.f1058a.get(i);
        }
        return null;
    }

    public final b a(com.fyber.inneractive.sdk.model.vast.i iVar) {
        for (b bVar : this.b) {
            if (bVar.i() == iVar) {
                return bVar;
            }
        }
        return null;
    }

    public final void a(b bVar) {
        if (((bVar instanceof o) || (bVar instanceof d)) && this.f1058a.contains(bVar)) {
            return;
        }
        this.f1058a.add(bVar);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f1058a.sort(this.d);
        } else {
            Collections.sort(this.f1058a, this.d);
        }
    }
}
