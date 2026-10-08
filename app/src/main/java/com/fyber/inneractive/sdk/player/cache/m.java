package com.fyber.inneractive.sdk.player.cache;

import com.fyber.inneractive.sdk.network.z;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f1235a;

    public m(n nVar) {
        this.f1235a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        File fileA = n.a(this.f1235a.f1236a, "fyb.vamp.vid.cache");
        if (fileA != null) {
            try {
                IAlog.a("VideoCache opening the cache in directory - %s", fileA);
                this.f1235a.b = g.a(fileA, 52428800L);
                g gVar = this.f1235a.b;
                gVar.getClass();
                IAlog.e("DiskLruCache delete cache", new Object[0]);
                gVar.close();
                l.a(gVar.f1230a);
                this.f1235a.b = g.a(fileA, 52428800L);
                g gVar2 = this.f1235a.b;
                synchronized (gVar2) {
                    j = gVar2.h;
                }
                IAlog.a("VideoCache opened the cache in directory - %s current size is %d", fileA, Long.valueOf(j));
                n nVar = this.f1235a;
                nVar.b.l = nVar;
                nVar.c = true;
            } catch (Throwable th) {
                z.a("Failed to open cache directory", th.getMessage(), null, null);
                IAlog.a("Failed to open cache directory", th, new Object[0]);
            }
        }
    }
}
