package com.bytedance.adsdk.ud.mml;

import android.util.Pair;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class wd {
    private final mzz qdl;

    public wd(mzz mzzVar) {
        this.qdl = mzzVar;
    }

    Pair<lnr, InputStream> qdl(String str) {
        lnr lnrVar;
        try {
            File fileUd = ud(str);
            if (fileUd == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(fileUd);
            if (fileUd.getAbsolutePath().endsWith(".zip")) {
                lnrVar = lnr.ZIP;
            } else {
                lnrVar = lnr.JSON;
            }
            fileUd.getAbsolutePath();
            return new Pair<>(lnrVar, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    File qdl(String str, InputStream inputStream, lnr lnrVar) throws IOException {
        File file = new File(qdl(), qdl(str, lnrVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                    } else {
                        fileOutputStream.flush();
                        return file;
                    }
                }
            } finally {
                fileOutputStream.close();
            }
        } finally {
            inputStream.close();
        }
    }

    void qdl(String str, lnr lnrVar) {
        File file = new File(qdl(), qdl(str, lnrVar, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean zRenameTo = file.renameTo(file2);
        file2.toString();
        if (zRenameTo) {
            return;
        }
        file.getAbsolutePath();
        file2.getAbsolutePath();
    }

    private File ud(String str) throws FileNotFoundException {
        File file = new File(qdl(), qdl(str, lnr.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(qdl(), qdl(str, lnr.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File qdl() {
        File fileQdl = this.qdl.qdl();
        if (fileQdl.isFile()) {
            fileQdl.delete();
        }
        if (!fileQdl.exists()) {
            fileQdl.mkdirs();
        }
        return fileQdl;
    }

    private static String qdl(String str, lnr lnrVar, boolean z) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        sb.append(z ? lnrVar.qdl() : lnrVar.lnr);
        return sb.toString();
    }
}
