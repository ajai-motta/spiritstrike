package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.net.Uri;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.e0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.fyber.inneractive.sdk.player.exoplayer2.upstream.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f1437a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h b;
    public final e0 c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.h d;
    public final boolean e = false;
    public final boolean f = true;
    public final boolean g = false;
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.h h;
    public boolean i;
    public Uri j;
    public int k;
    public String l;
    public long m;
    public long n;
    public m o;
    public boolean p;
    public boolean q;

    public e(l lVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar2, c cVar) {
        this.f1437a = lVar;
        this.b = hVar2;
        this.d = hVar;
        if (cVar != null) {
            this.c = new e0(hVar, cVar);
        } else {
            this.c = null;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar) throws IOException {
        try {
            Uri uri = kVar.f1451a;
            this.j = uri;
            this.k = kVar.f;
            String string = kVar.e;
            if (string == null) {
                string = uri.toString();
            }
            this.l = string;
            this.m = kVar.c;
            boolean z = (this.f && this.p) || (kVar.d == -1 && this.g);
            this.q = z;
            long j = kVar.d;
            if (j != -1 || z) {
                this.n = j;
            } else {
                long jA = this.f1437a.a(string);
                this.n = jA;
                if (jA != -1) {
                    long j2 = jA - kVar.c;
                    this.n = j2;
                    if (j2 <= 0) {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.upstream.i();
                    }
                }
            }
            a(true);
            return this.n;
        } catch (IOException e) {
            if (this.h == this.b || (e instanceof a)) {
                this.p = true;
            }
            throw e;
        }
    }

    public final void b() {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar = this.h;
        if (hVar == null) {
            return;
        }
        try {
            hVar.close();
            this.h = null;
            this.i = false;
            m mVar = this.o;
            if (mVar != null) {
                l lVar = this.f1437a;
                synchronized (lVar) {
                    if (mVar != lVar.c.remove(mVar.f1439a)) {
                        throw new IllegalStateException();
                    }
                    lVar.notifyAll();
                }
                this.o = null;
            }
        } catch (Throwable th) {
            m mVar2 = this.o;
            if (mVar2 != null) {
                this.f1437a.b(mVar2);
                this.o = null;
            }
            throw th;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() throws IOException {
        this.j = null;
        try {
            b();
        } catch (IOException e) {
            if (this.h == this.b || (e instanceof a)) {
                this.p = true;
            }
            throw e;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.n == 0) {
            return -1;
        }
        try {
            int i3 = this.h.read(bArr, i, i2);
            if (i3 >= 0) {
                long j = i3;
                this.m += j;
                long j2 = this.n;
                if (j2 != -1) {
                    this.n = j2 - j;
                }
            } else {
                if (this.i) {
                    a(this.m);
                    this.n = 0L;
                }
                b();
                long j3 = this.n;
                if ((j3 > 0 || j3 == -1) && a(false)) {
                    return read(bArr, i, i2);
                }
            }
            return i3;
        } catch (IOException e) {
            if (this.h == this.b || (e instanceof a)) {
                this.p = true;
            }
            throw e;
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.h hVar = this.h;
        return hVar == this.d ? hVar.a() : this.j;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(boolean r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache.e.a(boolean):boolean");
    }

    public final void a(long j) {
        if (this.h == this.c) {
            l lVar = this.f1437a;
            String str = this.l;
            synchronized (lVar) {
                i iVar = lVar.d;
                h hVar = (h) iVar.f1441a.get(str);
                if (hVar == null) {
                    iVar.a(str, j);
                } else if (hVar.d != j) {
                    hVar.d = j;
                    iVar.f = true;
                }
                lVar.d.b();
            }
        }
    }
}
