package com.fyber.inneractive.sdk.flow.nativead;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.network.u0;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements c, s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CountDownLatch f1075a;
    public final e b;
    public final List d;
    public ArrayList c = new ArrayList();
    public final ArrayList e = new ArrayList();
    public final ArrayList f = new ArrayList();
    public b g = b.UNINITIALIZED;

    public h(ArrayList arrayList, e eVar) {
        this.d = arrayList;
        this.b = eVar;
    }

    @Override // com.fyber.inneractive.sdk.flow.nativead.c
    public final boolean a() {
        return this.g == b.LOADING;
    }

    @Override // com.fyber.inneractive.sdk.flow.nativead.c
    public final void b() throws Throwable {
        com.fyber.inneractive.sdk.response.nativead.c cVar;
        String str;
        if (this.d.isEmpty()) {
            this.g = b.FAILED;
            c();
            return;
        }
        Iterator it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.fyber.inneractive.sdk.response.nativead.f fVar = (com.fyber.inneractive.sdk.response.nativead.f) it.next();
            if (fVar == null || (cVar = fVar.d) == null || (str = cVar.f1615a) == null || str.trim().isEmpty()) {
                IAlog.f("%sImage asset not downloadable. imageAssetId: %s, imageObject: %s", IAlog.a(this), Integer.valueOf(fVar.f1618a), fVar.d);
                this.e.add(fVar);
            } else {
                ArrayList arrayList = this.c;
                if (arrayList != null) {
                    arrayList.add(new u0(new t(fVar, this), IAConfigManager.O.v.f957a, new com.fyber.inneractive.sdk.cache.d(fVar.d.f1615a)));
                }
            }
        }
        ArrayList arrayList2 = this.c;
        if (arrayList2 == null || arrayList2.isEmpty()) {
            this.g = b.FAILED;
            c();
            return;
        }
        this.g = b.LOADING;
        this.f1075a = new CountDownLatch(this.c.size());
        Iterator it2 = this.c.iterator();
        while (it2.hasNext()) {
            IAConfigManager.O.s.a((u0) it2.next());
        }
    }

    public final void c() throws Throwable {
        e eVar = this.b;
        if (eVar != null) {
            ArrayList arrayList = this.f;
            ArrayList<com.fyber.inneractive.sdk.response.nativead.f> arrayList2 = this.e;
            if (!arrayList.isEmpty()) {
                eVar.f1072a.d.addAll(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                for (com.fyber.inneractive.sdk.response.nativead.f fVar : arrayList2) {
                    IAlog.f("%sFailed to load image asset. id: %s, imageObj: %s", f.m, Integer.valueOf(fVar.f1618a), fVar.d);
                }
            }
            eVar.f1072a.a();
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.nativead.c
    public final void destroy() {
        ArrayList arrayList = this.c;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((u0) it.next()).f1217a = true;
            }
            this.c.clear();
        }
        this.c = null;
        this.g = b.DESTROYED;
    }

    @Override // com.fyber.inneractive.sdk.flow.nativead.s
    public final void a(g gVar, Exception exc, com.fyber.inneractive.sdk.response.nativead.f fVar) throws Throwable {
        if (gVar != null) {
            this.f.add(gVar);
        } else {
            this.e.add(fVar);
        }
        CountDownLatch countDownLatch = this.f1075a;
        if (countDownLatch == null) {
            return;
        }
        countDownLatch.countDown();
        if (this.f1075a.getCount() == 0) {
            this.g = b.LOADED;
            c();
        }
    }
}
