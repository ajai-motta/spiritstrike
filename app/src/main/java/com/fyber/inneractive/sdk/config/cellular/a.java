package com.fyber.inneractive.sdk.config.cellular;

import android.content.Context;
import com.fyber.inneractive.sdk.util.z0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f931a;
    public final CopyOnWriteArrayList c = new CopyOnWriteArrayList();
    public z0 b = z0.UNKNOWN;

    public a(Context context) {
        this.f931a = e.a(context);
    }

    @Override // com.fyber.inneractive.sdk.config.cellular.h
    public final void a(z0 z0Var) {
        this.b = z0Var;
        for (h hVar : this.c) {
            if (hVar != null) {
                hVar.a(this.b);
            }
        }
    }
}
