package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f1463a;
    public final File b;

    public c(File file) {
        this.f1463a = file;
        this.b = new File(file.getPath() + ".bak");
    }

    public final FileInputStream a() {
        if (this.b.exists()) {
            this.f1463a.delete();
            this.b.renameTo(this.f1463a);
        }
        return new FileInputStream(this.f1463a);
    }

    public final b b() throws IOException {
        if (this.f1463a.exists()) {
            if (this.b.exists()) {
                this.f1463a.delete();
            } else if (!this.f1463a.renameTo(this.b)) {
                Log.w("AtomicFile", "Couldn't rename file " + this.f1463a + " to backup file " + this.b);
            }
        }
        try {
            return new b(this.f1463a);
        } catch (FileNotFoundException unused) {
            if (!this.f1463a.getParentFile().mkdirs()) {
                throw new IOException("Couldn't create directory " + this.f1463a);
            }
            try {
                return new b(this.f1463a);
            } catch (FileNotFoundException unused2) {
                throw new IOException("Couldn't create " + this.f1463a);
            }
        }
    }
}
