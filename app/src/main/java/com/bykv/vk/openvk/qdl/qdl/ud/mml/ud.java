package com.bykv.vk.openvk.qdl.qdl.ud.mml;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public class ud {
    public static long qdl(String str, String str2) {
        File fileLnr = lnr(str, str2);
        if (fileLnr.exists()) {
            return fileLnr.length();
        }
        File fileUd = ud(str, str2);
        if (fileUd.exists()) {
            return fileUd.length();
        }
        return 0L;
    }

    public static File ud(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2 + ".temp");
    }

    public static File lnr(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, str2);
    }

    public static void qdl(RandomAccessFile randomAccessFile, byte[] bArr, int i, int i2, String str) throws IOException {
        try {
            randomAccessFile.seek(i);
            randomAccessFile.write(bArr, 0, i2);
        } catch (Throwable unused) {
        }
    }
}
