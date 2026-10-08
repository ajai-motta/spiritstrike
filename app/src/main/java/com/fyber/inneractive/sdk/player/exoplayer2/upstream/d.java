package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.SystemClock;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AssetManager f1445a;
    public final m b;
    public Uri c;
    public InputStream d;
    public long e;
    public boolean f;

    public d(Context context, m mVar) {
        this.f1445a = context.getAssets();
        this.b = mVar;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final long a(k kVar) throws c {
        try {
            Uri uri = kVar.f1451a;
            this.c = uri;
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(DomExceptionUtils.SEPARATOR)) {
                path = path.substring(1);
            }
            InputStream inputStreamOpen = this.f1445a.open(path, 1);
            this.d = inputStreamOpen;
            if (inputStreamOpen.skip(kVar.c) < kVar.c) {
                throw new EOFException();
            }
            long j = kVar.d;
            if (j != -1) {
                this.e = j;
            } else {
                long jAvailable = this.d.available();
                this.e = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.e = -1L;
                }
            }
            this.f = true;
            m mVar = this.b;
            if (mVar != null) {
                synchronized (mVar) {
                    if (mVar.b == 0) {
                        mVar.c = SystemClock.elapsedRealtime();
                    }
                    mVar.b++;
                }
            }
            return this.e;
        } catch (IOException e) {
            throw new c(e);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final void close() {
        this.c = null;
        try {
            try {
                InputStream inputStream = this.d;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                throw new c(e);
            }
        } finally {
            this.d = null;
            if (this.f) {
                this.f = false;
                m mVar = this.b;
                if (mVar != null) {
                    mVar.a();
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final int read(byte[] bArr, int i, int i2) throws c {
        if (i2 == 0) {
            return 0;
        }
        long j = this.e;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new c(e);
            }
        }
        int i3 = this.d.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.e == -1) {
                return -1;
            }
            throw new c(new EOFException());
        }
        long j2 = this.e;
        if (j2 != -1) {
            this.e = j2 - ((long) i3);
        }
        m mVar = this.b;
        if (mVar != null) {
            synchronized (mVar) {
                mVar.d += (long) i3;
            }
        }
        return i3;
    }

    @Override // com.fyber.inneractive.sdk.player.exoplayer2.upstream.h
    public final Uri a() {
        return this.c;
    }
}
