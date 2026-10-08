package com.fyber.inneractive.sdk.nativead;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.player.cache.f;
import com.fyber.inneractive.sdk.player.cache.g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.o;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements f {
    public static final b f = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f1189a;
    public g b;
    public boolean c = false;
    public final CopyOnWriteArrayList d = new CopyOnWriteArrayList();
    public final a e = new a(this);

    public static File a(b bVar) {
        String externalStorageState;
        File externalCacheDir;
        String externalStorageState2 = "";
        Context context = bVar.f1189a;
        if (context != null && !TextUtils.isEmpty("assets")) {
            if (o.f1662a != null && o.a("android.permission.WRITE_EXTERNAL_STORAGE")) {
                try {
                    externalStorageState = Environment.getExternalStorageState();
                } catch (Throwable unused) {
                    externalStorageState = "";
                }
                if ("mounted".equals(externalStorageState)) {
                    try {
                        externalStorageState2 = Environment.getExternalStorageState();
                    } catch (Throwable unused2) {
                    }
                    if (("mounted".equals(externalStorageState2) || "mounted_ro".equals(externalStorageState2)) && (externalCacheDir = context.getExternalCacheDir()) != null && externalCacheDir.getFreeSpace() > 41943040) {
                        return new File(context.getExternalCacheDir(), "assets");
                    }
                }
            }
            File cacheDir = context.getCacheDir();
            if (cacheDir != null && cacheDir.getFreeSpace() > 41943040) {
                return new File(context.getCacheDir(), "assets");
            }
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.cache.f
    public final boolean a(String str) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equalsIgnoreCase(str)) {
                return false;
            }
        }
        return true;
    }

    public final void a() {
        boolean z;
        g gVar = this.b;
        if (gVar != null) {
            synchronized (gVar) {
                z = gVar.i == null;
            }
            if (!z) {
                try {
                    this.b.close();
                    this.c = false;
                    return;
                } catch (Throwable th) {
                    IAlog.f("%s: destroy: Error closing cache: %s", "NativeCache", th);
                    return;
                }
            }
        }
        IAlog.c("%s: destroy: cache already closed or not exists", "NativeCache");
    }
}
