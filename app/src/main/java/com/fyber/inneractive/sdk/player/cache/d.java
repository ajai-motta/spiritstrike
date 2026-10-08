package com.fyber.inneractive.sdk.player.cache;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f1228a;
    public final boolean[] b;
    public boolean c;
    public final /* synthetic */ g d;

    public d(g gVar, e eVar) {
        this.d = gVar;
        this.f1228a = eVar;
        this.b = eVar.c ? null : new boolean[gVar.g];
    }

    public final void a(byte[] bArr) {
        OutputStream cVar;
        FileOutputStream fileOutputStream;
        g gVar = this.d;
        if (gVar.g <= 0) {
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.d.g);
        }
        synchronized (gVar) {
            e eVar = this.f1228a;
            if (eVar.d != this) {
                throw new IllegalStateException();
            }
            if (!eVar.c) {
                this.b[0] = true;
            }
            File fileB = eVar.b(0);
            try {
                fileOutputStream = new FileOutputStream(fileB);
            } catch (FileNotFoundException unused) {
                this.d.f1230a.mkdirs();
                try {
                    fileOutputStream = new FileOutputStream(fileB);
                } catch (FileNotFoundException unused2) {
                    cVar = g.q;
                }
            }
            cVar = new c(this, fileOutputStream);
        }
        try {
            cVar.write(bArr);
            Charset charset = l.f1234a;
            try {
                cVar.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused3) {
            }
        } catch (Throwable th) {
            Charset charset2 = l.f1234a;
            if (cVar != null) {
                try {
                    cVar.close();
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    public final void a() {
        if (this.c) {
            g.a(this.d, this, false);
            this.d.c(this.f1228a.f1229a);
        } else {
            g.a(this.d, this, true);
        }
    }
}
