package com.bykv.vk.openvk.preload.geckox.utils;

import android.os.Process;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static boolean a(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        Integer.valueOf(Process.myPid());
        Thread.currentThread().toString();
        new StringBuilder(", file:").append(file.getAbsolutePath());
        return d(file);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean d(java.io.File r7) {
        /*
            r0 = 1
            if (r7 == 0) goto L36
            boolean r1 = r7.exists()
            if (r1 != 0) goto La
            goto L36
        La:
            boolean r1 = r7.isDirectory()
            r2 = 0
            if (r1 == 0) goto L2e
            java.io.File[] r1 = r7.listFiles()
            if (r1 == 0) goto L2e
            int r3 = r1.length
            r5 = r0
            r4 = r2
        L1a:
            if (r4 >= r3) goto L2c
            r6 = r1[r4]
            if (r5 == 0) goto L28
            boolean r5 = d(r6)
            if (r5 == 0) goto L28
            r5 = r0
            goto L29
        L28:
            r5 = r2
        L29:
            int r4 = r4 + 1
            goto L1a
        L2c:
            if (r5 == 0) goto L35
        L2e:
            boolean r7 = r7.delete()
            if (r7 == 0) goto L35
            return r0
        L35:
            return r2
        L36:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.utils.b.d(java.io.File):boolean");
    }

    public static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        byte[] bArr = new byte[1024];
        while (true) {
            int i = bufferedInputStream.read(bArr);
            if (i != -1) {
                bufferedOutputStream.write(bArr, 0, i);
            } else {
                bufferedOutputStream.flush();
                return;
            }
        }
    }

    public static List<File> b(File file) {
        File[] fileArrListFiles;
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
            return null;
        }
        List<File> listAsList = Arrays.asList(fileArrListFiles);
        final HashMap map = new HashMap();
        for (File file2 : listAsList) {
            map.put(file2, Long.valueOf(file2.lastModified()));
        }
        Collections.sort(listAsList, new Comparator<File>() { // from class: com.bykv.vk.openvk.preload.geckox.utils.b.1
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(File file3, File file4) {
                File file5 = file3;
                File file6 = file4;
                if (file5 == null && file6 == null) {
                    return 0;
                }
                if (file5 == null) {
                    return 1;
                }
                if (file6 == null) {
                    return -1;
                }
                return Long.compare(((Long) map.get(file5)).longValue(), ((Long) map.get(file6)).longValue());
            }
        });
        return listAsList;
    }

    public static boolean c(File file) {
        if (file.isDirectory()) {
            for (String str : file.list()) {
                if (!c(new File(file, str))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String a(InputStream inputStream) {
        BufferedReader bufferedReader;
        try {
            StringBuilder sb = new StringBuilder();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                } catch (Throwable unused) {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return null;
                }
            }
            String string = sb.toString();
            try {
                bufferedReader.close();
            } catch (Throwable unused4) {
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable unused5) {
                }
            }
            return string;
        } catch (Throwable unused6) {
            bufferedReader = null;
        }
    }
}
