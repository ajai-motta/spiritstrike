package com.bykv.vk.openvk.preload.geckox.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static byte[] f839a = {80, 75, 3, 4};
    private static byte[] b = {80, 75, 5, 6};

    public static void a(InputStream inputStream, String str, String str2) throws Exception {
        FileOutputStream fileOutputStream;
        Closeable closeable = null;
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            boolean z = false;
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        if (!z) {
                            inputStream.reset();
                            if (!a(inputStream)) {
                                throw new RuntimeException("not zip file  channel:".concat(String.valueOf(str2)));
                            }
                            throw new RuntimeException("unzip file: channel:".concat(String.valueOf(str2)));
                        }
                        CloseableUtils.close(zipInputStream);
                        return;
                    }
                    String name = nextEntry.getName();
                    if (!name.startsWith("__MACOSX/") && !name.equals(".DS_Store") && !name.contains("../")) {
                        if (!name.startsWith(str2 + File.separator)) {
                            throw new RuntimeException("the zip package outermost folder is not named by channel channel:".concat(String.valueOf(str2)));
                        }
                        if (nextEntry.isDirectory()) {
                            File file = new File(canonicalPath, name);
                            if (!file.getCanonicalPath().startsWith(canonicalPath)) {
                                throw new RuntimeException("directory traversal, dir:" + name + ", channel:" + str2);
                            }
                            file.mkdirs();
                        } else {
                            String canonicalPath2 = new File(canonicalPath, name).getCanonicalPath();
                            if (!canonicalPath2.startsWith(canonicalPath)) {
                                throw new RuntimeException("directory traversal, file name:".concat(String.valueOf(name)));
                            }
                            File file2 = new File(canonicalPath2);
                            file2.getParentFile().mkdirs();
                            try {
                                fileOutputStream = new FileOutputStream(file2);
                            } catch (Throwable th) {
                                th = th;
                            }
                            try {
                                b.a(zipInputStream, fileOutputStream);
                                CloseableUtils.close(fileOutputStream);
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = fileOutputStream;
                                CloseableUtils.close(closeable);
                                throw th;
                            }
                        }
                    }
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                    closeable = zipInputStream;
                    CloseableUtils.close(closeable);
                    throw th;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(java.io.InputStream r4) throws java.lang.Exception {
        /*
            r0 = 4
            byte[] r1 = new byte[r0]     // Catch: java.lang.Throwable -> L23
            r2 = 0
            int r3 = r4.read(r1, r2, r0)     // Catch: java.lang.Throwable -> L23
            if (r3 != r0) goto L1f
            byte[] r0 = com.bykv.vk.openvk.preload.geckox.utils.h.f839a     // Catch: java.lang.Throwable -> L23
            boolean r0 = java.util.Arrays.equals(r0, r1)     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto L1a
            byte[] r0 = com.bykv.vk.openvk.preload.geckox.utils.h.b     // Catch: java.lang.Throwable -> L23
            boolean r0 = java.util.Arrays.equals(r0, r1)     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L1b
        L1a:
            r2 = 1
        L1b:
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close(r4)
            return r2
        L1f:
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close(r4)
            return r2
        L23:
            r0 = move-exception
            com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils.close(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.utils.h.a(java.io.InputStream):boolean");
    }
}
