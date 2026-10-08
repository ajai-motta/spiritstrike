package com.bykv.vk.openvk.preload.geckox.e;

import android.content.Context;
import android.text.TextUtils;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, a> f814a = new HashMap();
    private AtomicBoolean b = new AtomicBoolean(false);
    private String c;

    public b(Context context, String str, File file) {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("access key empty");
        }
        if (file == null) {
            this.c = new File(context.getFilesDir(), "gecko_offline_res_x" + File.separator + str).getAbsolutePath();
            return;
        }
        this.c = new File(file, str).getAbsolutePath();
    }

    public final String a() {
        return this.c;
    }

    public final InputStream a(String str) throws Exception {
        if (this.b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).a(str);
    }

    public final int b(String str) throws Exception {
        if (this.b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).c(str);
    }

    public final boolean c(String str) throws Exception {
        if (this.b.get()) {
            throw new RuntimeException("released");
        }
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("relativePath empty");
        }
        return d(str.trim()).b(str);
    }

    private a d(String str) {
        a aVar;
        int iIndexOf = str.indexOf(DomExceptionUtils.SEPARATOR);
        if (iIndexOf == -1) {
            new RuntimeException("channel：".concat(String.valueOf(str)));
        }
        String strSubstring = str.substring(0, iIndexOf);
        synchronized (this.f814a) {
            aVar = this.f814a.get(strSubstring);
            if (aVar == null) {
                aVar = new a(this.c, strSubstring);
                this.f814a.put(strSubstring, aVar);
            }
        }
        return aVar;
    }

    public final Map<String, Long> b() {
        HashMap map = new HashMap();
        synchronized (this.f814a) {
            Collection<a> collectionValues = this.f814a.values();
            if (collectionValues == null) {
                return map;
            }
            for (a aVar : collectionValues) {
                map.put(aVar.b(), aVar.a());
            }
            return map;
        }
    }

    public final void c() throws Exception {
        if (this.b.getAndSet(true)) {
            return;
        }
        synchronized (this.f814a) {
            Iterator<a> it = this.f814a.values().iterator();
            while (it.hasNext()) {
                it.next().c();
            }
            this.f814a.clear();
        }
    }
}
