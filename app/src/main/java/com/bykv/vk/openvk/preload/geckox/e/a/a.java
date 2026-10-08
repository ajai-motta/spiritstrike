package com.bykv.vk.openvk.preload.geckox.e.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f813a;

    protected abstract InputStream a(File file, String str) throws IOException;

    protected abstract boolean b(File file, String str) throws IOException;

    public a(File file) {
        this.f813a = file;
    }

    public final InputStream a(String str) throws IOException {
        return a(this.f813a, str);
    }

    public final boolean b(String str) throws IOException {
        return b(this.f813a, str);
    }
}
