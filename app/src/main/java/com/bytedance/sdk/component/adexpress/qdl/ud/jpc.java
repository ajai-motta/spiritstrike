package com.bytedance.sdk.component.adexpress.qdl.ud;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class jpc {
    private static com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdl;

    public static void qdl() {
        FileInputStream fileInputStream = null;
        try {
            File file = new File(mzz.jpc(), "temp_pkg_info.json");
            long length = file.length();
            Long lValueOf = Long.valueOf(length);
            lValueOf.getClass();
            if (length > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    fileInputStream2.read(bArr);
                    com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVarQdl = com.bytedance.sdk.component.adexpress.qdl.lnr.qdl.qdl(new JSONObject(new String(bArr, "utf-8")));
                    if (qdlVarQdl != null) {
                        qdl = qdlVarQdl;
                        qdlVarQdl.lnr();
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable unused) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return;
                        } catch (IOException unused2) {
                            return;
                        }
                    }
                    return;
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable unused4) {
        }
    }

    public static synchronized com.bytedance.sdk.component.adexpress.qdl.lnr.qdl ud() {
        return qdl;
    }

    public static synchronized void qdl(com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar) {
        if (qdlVar != null) {
            if (qdlVar.jpc()) {
                qdl = qdlVar;
            }
        }
    }

    public static void lnr() {
        mzz.qdl(mzz.jpc(), ud(), "temp_pkg_info.json");
    }

    public static boolean qdl(String str) {
        return mzz.qdl(ud(), str);
    }

    public static boolean ud(com.bytedance.sdk.component.adexpress.qdl.lnr.qdl qdlVar) {
        return mzz.lnr(ud(), qdlVar);
    }

    public static void mml() {
        mzz.ud(mzz.jpc(), ud(), "temp_pkg_info.json");
        qdl = null;
    }
}
