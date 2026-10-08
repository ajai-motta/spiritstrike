package com.google.android.play.integrity.internal;

import android.os.IBinder;
import android.os.IInterface;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
final class aa extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IBinder f1791a;
    final /* synthetic */ ad b;

    aa(ad adVar, IBinder iBinder) {
        this.f1791a = iBinder;
        this.b = adVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        this.b.f1793a.o = (IInterface) this.b.f1793a.j.a(this.f1791a);
        ae.r(this.b.f1793a);
        this.b.f1793a.h = false;
        Iterator it = this.b.f1793a.e.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.b.f1793a.e.clear();
    }
}
