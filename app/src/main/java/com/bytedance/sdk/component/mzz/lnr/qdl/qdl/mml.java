package com.bytedance.sdk.component.mzz.lnr.qdl.qdl;

import com.google.android.exoplayer2.C;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
final class mml {
    static final Charset qdl = Charset.forName(C.ASCII_NAME);
    static final Charset ud = Charset.forName("UTF-8");

    static void qdl(File file) throws IOException {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            throw new IOException("not a readable directory: ".concat(String.valueOf(file)));
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                qdl(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: ".concat(String.valueOf(file2)));
            }
        }
    }
}
