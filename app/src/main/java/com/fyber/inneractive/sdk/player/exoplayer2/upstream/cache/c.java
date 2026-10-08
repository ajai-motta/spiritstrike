package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import com.fyber.inneractive.sdk.player.exoplayer2.util.p;
import com.fyber.inneractive.sdk.player.exoplayer2.util.z;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f1435a;
    public final long b = 10485760;
    public final int c = CacheDataSink.DEFAULT_BUFFER_SIZE;
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.k d;
    public File e;
    public OutputStream f;
    public FileOutputStream g;
    public long h;
    public long i;
    public p j;

    public c(l lVar) {
        this.f1435a = lVar;
    }

    public final void a() {
        OutputStream outputStream = this.f;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            this.g.getFD().sync();
            z.a(this.f);
            this.f = null;
            File file = this.e;
            this.e = null;
            l lVar = this.f1435a;
            synchronized (lVar) {
                m mVarA = m.a(file, lVar.d);
                if (mVarA == null) {
                    throw new IllegalStateException();
                }
                if (!lVar.c.containsKey(mVarA.f1439a)) {
                    throw new IllegalStateException();
                }
                if (file.exists()) {
                    if (file.length() == 0) {
                        file.delete();
                        return;
                    }
                    long jA = lVar.a(mVarA.f1439a);
                    if (jA != -1 && mVarA.b + mVarA.c > jA) {
                        throw new IllegalStateException();
                    }
                    lVar.a(mVarA);
                    lVar.d.b();
                    lVar.notifyAll();
                }
            }
        } catch (Throwable th) {
            z.a(this.f);
            this.f = null;
            File file2 = this.e;
            this.e = null;
            file2.delete();
            throw th;
        }
    }

    public final void b() {
        File file;
        long j = this.d.d;
        long jMin = j == -1 ? this.b : Math.min(j - this.i, this.b);
        l lVar = this.f1435a;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = this.d;
        String str = kVar.e;
        long j2 = kVar.b + this.i;
        synchronized (lVar) {
            if (!lVar.c.containsKey(str)) {
                throw new IllegalStateException();
            }
            if (!lVar.f1444a.exists()) {
                lVar.a();
                lVar.f1444a.mkdirs();
            }
            lVar.b.a(lVar, jMin);
            File file2 = lVar.f1444a;
            i iVar = lVar.d;
            h hVarA = (h) iVar.f1441a.get(str);
            if (hVarA == null) {
                hVarA = iVar.a(str, -1L);
            }
            int i = hVarA.f1440a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            Pattern pattern = m.g;
            file = new File(file2, i + "." + j2 + "." + jCurrentTimeMillis + ".v3.exo");
        }
        this.e = file;
        FileOutputStream fileOutputStream = new FileOutputStream(this.e);
        this.g = fileOutputStream;
        if (this.c > 0) {
            p pVar = this.j;
            if (pVar == null) {
                this.j = new p(this.g, this.c);
            } else {
                pVar.a(fileOutputStream);
            }
            this.f = this.j;
        } else {
            this.f = fileOutputStream;
        }
        this.h = 0L;
    }
}
