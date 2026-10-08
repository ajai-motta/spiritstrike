package com.fyber.inneractive.sdk.nativead;

import com.fyber.inneractive.sdk.network.z;
import com.fyber.inneractive.sdk.player.cache.g;
import com.fyber.inneractive.sdk.player.cache.l;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1188a;

    public a(b bVar) {
        this.f1188a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        File fileA = b.a(this.f1188a);
        if (fileA != null) {
            try {
                IAlog.a("NativeCache opening the cache in directory - %s", fileA);
                this.f1188a.b = g.a(fileA, 41943040L);
                g gVar = this.f1188a.b;
                gVar.getClass();
                IAlog.e("DiskLruCache delete cache", new Object[0]);
                gVar.close();
                l.a(gVar.f1230a);
                this.f1188a.b = g.a(fileA, 41943040L);
                g gVar2 = this.f1188a.b;
                synchronized (gVar2) {
                    j = gVar2.h;
                }
                IAlog.a("NativeCache opened the cache in directory - %s current size is %d", fileA, Long.valueOf(j));
                b bVar = this.f1188a;
                bVar.b.l = bVar;
                bVar.c = true;
            } catch (Throwable th) {
                z.a("Failed to open cache directory", th.getMessage(), null, null);
                IAlog.a("Failed to open cache directory", th, new Object[0]);
            }
        }
    }
}
