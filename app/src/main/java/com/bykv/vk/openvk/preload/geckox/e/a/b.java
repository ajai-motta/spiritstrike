package com.bykv.vk.openvk.preload.geckox.e.a;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    public b(File file) {
        super(file);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.e.a.a
    protected final InputStream a(File file, String str) throws IOException {
        new File(str).getCanonicalPath();
        return null;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.e.a.a
    protected final boolean b(File file, String str) throws IOException {
        new File(str).getCanonicalPath();
        return false;
    }
}
