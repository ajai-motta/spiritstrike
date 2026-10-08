package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import com.google.android.exoplayer2.C;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f1444a;
    public final j b;
    public final i d;
    public a f;
    public final HashMap c = new HashMap();
    public final HashMap e = new HashMap();

    public l(File file, j jVar) {
        this.f1444a = file;
        this.b = jVar;
        this.d = new i(file);
        ConditionVariable conditionVariable = new ConditionVariable();
        new k(this, conditionVariable).start();
        conditionVariable.block();
    }

    public final synchronized m a(String str, long j) {
        m mVarA;
        m mVar;
        a aVar = this.f;
        if (aVar != null) {
            throw aVar;
        }
        h hVar = (h) this.d.f1441a.get(str);
        if (hVar == null) {
            mVar = new m(str, j, -1L, C.TIME_UNSET, null);
        } else {
            while (true) {
                mVarA = hVar.a(j);
                if (!mVarA.d || mVarA.e.length() == mVarA.c) {
                    break;
                }
                a();
            }
            mVar = mVarA;
        }
        if (!mVar.d) {
            if (this.c.containsKey(str)) {
                return null;
            }
            this.c.put(str, mVar);
            return mVar;
        }
        h hVar2 = (h) this.d.f1441a.get(str);
        if (!hVar2.c.remove(mVar)) {
            throw new IllegalStateException();
        }
        int i = hVar2.f1440a;
        if (!mVar.d) {
            throw new IllegalStateException();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        File parentFile = mVar.e.getParentFile();
        long j2 = mVar.b;
        Pattern pattern = m.g;
        File file = new File(parentFile, i + "." + j2 + "." + jCurrentTimeMillis + ".v3.exo");
        m mVar2 = new m(mVar.f1439a, mVar.b, mVar.c, jCurrentTimeMillis, file);
        if (!mVar.e.renameTo(file)) {
            throw new a("Renaming of " + mVar.e + " to " + file + " failed.");
        }
        hVar2.c.add(mVar2);
        ArrayList arrayList = (ArrayList) this.e.get(mVar.f1439a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                j jVar = (j) arrayList.get(size);
                jVar.f1442a.remove(mVar);
                jVar.b -= mVar.c;
                jVar.f1442a.add(mVar2);
                jVar.b += mVar2.c;
                jVar.a(this, 0L);
            }
        }
        j jVar2 = this.b;
        jVar2.f1442a.remove(mVar);
        jVar2.b -= mVar.c;
        jVar2.f1442a.add(mVar2);
        jVar2.b += mVar2.c;
        jVar2.a(this, 0L);
        return mVar2;
    }

    public final synchronized void b(m mVar) {
        if (mVar != this.c.remove(mVar.f1439a)) {
            throw new IllegalStateException();
        }
        notifyAll();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l.a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.l):void");
    }

    public final void a(m mVar) {
        i iVar = this.d;
        String str = mVar.f1439a;
        h hVarA = (h) iVar.f1441a.get(str);
        if (hVarA == null) {
            hVarA = iVar.a(str, -1L);
        }
        hVarA.c.add(mVar);
        ArrayList arrayList = (ArrayList) this.e.get(mVar.f1439a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                j jVar = (j) arrayList.get(size);
                jVar.f1442a.add(mVar);
                jVar.b += mVar.c;
                jVar.a(this, 0L);
            }
        }
        j jVar2 = this.b;
        jVar2.f1442a.add(mVar);
        jVar2.b += mVar.c;
        jVar2.a(this, 0L);
    }

    public final void a(g gVar, boolean z) throws Throwable {
        h hVar = (h) this.d.f1441a.get(gVar.f1439a);
        if (hVar == null || !hVar.c.remove(gVar)) {
            return;
        }
        gVar.e.delete();
        if (z && hVar.c.isEmpty()) {
            i iVar = this.d;
            h hVar2 = (h) iVar.f1441a.remove(hVar.b);
            if (hVar2 != null) {
                if (hVar2.c.isEmpty()) {
                    iVar.b.remove(hVar2.f1440a);
                    iVar.f = true;
                } else {
                    throw new IllegalStateException();
                }
            }
            this.d.b();
        }
        ArrayList arrayList = (ArrayList) this.e.get(gVar.f1439a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                j jVar = (j) arrayList.get(size);
                jVar.f1442a.remove(gVar);
                jVar.b -= gVar.c;
            }
        }
        j jVar2 = this.b;
        jVar2.f1442a.remove(gVar);
        jVar2.b -= gVar.c;
    }

    public final void a() throws Throwable {
        LinkedList linkedList = new LinkedList();
        Iterator it = this.d.f1441a.values().iterator();
        while (it.hasNext()) {
            for (g gVar : ((h) it.next()).c) {
                if (gVar.e.length() != gVar.c) {
                    linkedList.add(gVar);
                }
            }
        }
        Iterator it2 = linkedList.iterator();
        while (it2.hasNext()) {
            a((g) it2.next(), false);
        }
        this.d.a();
        this.d.b();
    }

    public final synchronized long a(String str) {
        h hVar;
        hVar = (h) this.d.f1441a.get(str);
        return hVar == null ? -1L : hVar.d;
    }
}
