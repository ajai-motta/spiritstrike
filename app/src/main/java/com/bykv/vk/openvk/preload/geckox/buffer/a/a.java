package com.bykv.vk.openvk.preload.geckox.buffer.a;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f805a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public int g;

    public static com.bykv.vk.openvk.preload.geckox.buffer.a a(File file, long j) throws IOException {
        com.bykv.vk.openvk.preload.geckox.buffer.a aVarB = b(file, j);
        new StringBuilder("buffer type:").append(aVarB.getClass());
        return aVarB;
    }

    private static com.bykv.vk.openvk.preload.geckox.buffer.a b(File file, long j) throws IOException {
        if (j <= 0) {
            try {
                return new b(file);
            } catch (Exception e) {
                throw new IOException("create FileBuffer failed! file:" + file.getAbsolutePath() + " caused by:" + e.getMessage(), e);
            }
        }
        try {
            return new c(j, file);
        } catch (Exception e2) {
            throw new RuntimeException("create random access file failed! file:" + file.getAbsolutePath() + " caused by:" + e2.getMessage(), e2);
        }
    }
}
