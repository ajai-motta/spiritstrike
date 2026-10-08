package com.bytedance.sdk.component.wd.ud;

import android.text.TextUtils;
import com.adxcorp.util.ADXLogUtil;
import com.bytedance.sdk.component.ud.qdl.fs;
import com.bytedance.sdk.component.ud.qdl.rq;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends lnr {
    public File qdl;
    private volatile boolean to;
    public File ud;

    public qdl(rq rqVar) {
        super(rqVar);
    }

    public void qdl(String str, String str2) {
        File file = new File(str);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        this.qdl = new File(str, str2);
        this.ud = new File(str, str2 + ".temp");
    }

    public void qdl(final com.bytedance.sdk.component.wd.qdl.qdl qdlVar) {
        File file = this.qdl;
        if (file == null || this.ud == null) {
            if (qdlVar != null) {
                qdlVar.qdl(this, new IOException("File info is null, please exec setFileInfo(String dir, String fileName)"));
                return;
            }
            return;
        }
        if (file.exists() && this.qdl.length() != 0 && qdlVar != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            com.bytedance.sdk.component.wd.ud udVar = new com.bytedance.sdk.component.wd.ud(true, 200, ADXLogUtil.EVENT_LOAD_SUCCESS, null, null, jCurrentTimeMillis, jCurrentTimeMillis);
            udVar.qdl(this.qdl);
            qdlVar.qdl(this, udVar);
            return;
        }
        long length = this.ud.length();
        final long j = length >= 0 ? length : 0L;
        fs.qdl qdlVar2 = new fs.qdl();
        qdlVar2.qdl((Object) lnr());
        ud(HttpHeaders.RANGE, "bytes=" + j + "-");
        if (TextUtils.isEmpty(this.jpc)) {
            qdlVar.qdl(this, new IOException("Url is Empty"));
            return;
        }
        try {
            qdlVar2.ud(this.jpc);
            if (!TextUtils.isEmpty(this.mzz)) {
                qdlVar2.qdl(this.mzz);
            }
            if (this.mo > 0) {
                qdlVar2.qdl(this.mo);
            }
            qdl(qdlVar2);
            com.bytedance.sdk.component.ud.qdl.ud udVarQdl = this.lnr.qdl(qdlVar2.qdl().ud());
            if (udVarQdl == null) {
                qdlVar.qdl(this, new IOException("new call error"));
            } else {
                udVarQdl.qdl(new com.bytedance.sdk.component.ud.qdl.lnr() { // from class: com.bytedance.sdk.component.wd.ud.qdl.1
                    @Override // com.bytedance.sdk.component.ud.qdl.lnr
                    public void qdl(com.bytedance.sdk.component.ud.qdl.ud udVar2, IOException iOException) {
                        com.bytedance.sdk.component.wd.qdl.qdl qdlVar3 = qdlVar;
                        if (qdlVar3 != null) {
                            qdlVar3.qdl(qdl.this, iOException);
                        }
                        qdl.this.mzz();
                    }

                    /* JADX WARN: Removed duplicated region for block: B:140:0x0191 A[SYNTHETIC] */
                    /* JADX WARN: Removed duplicated region for block: B:55:0x0158  */
                    @Override // com.bytedance.sdk.component.ud.qdl.lnr
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public void qdl(com.bytedance.sdk.component.ud.qdl.ud r19, com.bytedance.sdk.component.ud.qdl.rdp r20) throws java.io.IOException {
                        /*
                            Method dump skipped, instruction units count: 597
                            To view this dump change 'Code comments level' option to 'DEBUG'
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.wd.ud.qdl.AnonymousClass1.qdl(com.bytedance.sdk.component.ud.qdl.ud, com.bytedance.sdk.component.ud.qdl.rdp):void");
                    }
                });
            }
        } catch (IllegalArgumentException unused) {
            qdlVar.qdl(this, new IOException("Url is not a valid HTTP or HTTPS URL"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x01d5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a1 A[Catch: all -> 0x0237, TryCatch #11 {all -> 0x0237, blocks: (B:67:0x0182, B:69:0x0188, B:71:0x018c, B:72:0x0192, B:73:0x0199, B:75:0x01a1, B:77:0x01b1, B:82:0x01c4, B:85:0x01cd, B:86:0x01d4, B:81:0x01ba, B:89:0x01da, B:97:0x01f2, B:99:0x01fa, B:101:0x0204, B:103:0x020e, B:113:0x0228, B:94:0x01e8), top: B:172:0x0182 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.sdk.component.wd.ud qdl() {
        /*
            Method dump skipped, instruction units count: 608
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.wd.ud.qdl.qdl():com.bytedance.sdk.component.wd.ud");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean mzz(Map<String, String> map) {
        if (TextUtils.equals(map.get(HttpHeaders.ACCEPT_RANGES), "bytes") || TextUtils.equals(map.get("accept-ranges"), "bytes")) {
            return true;
        }
        String str = map.get(HttpHeaders.CONTENT_RANGE);
        if (TextUtils.isEmpty(str)) {
            str = map.get("content-range");
        }
        return str != null && str.startsWith("bytes");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long mo(Map<String, String> map) {
        String str;
        if (map.containsKey("content-length")) {
            str = map.get("content-length");
        } else {
            str = map.containsKey(HttpHeaders.CONTENT_LENGTH) ? map.get(HttpHeaders.CONTENT_LENGTH) : null;
        }
        if (TextUtils.isEmpty(str) || str == null) {
            return 0L;
        }
        try {
            return Long.valueOf(str).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean wd(Map<String, String> map) {
        return TextUtils.equals(map.get(HttpHeaders.CONTENT_ENCODING), "gzip");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mzz() {
        try {
            this.qdl.delete();
        } catch (Throwable unused) {
        }
        try {
            this.ud.delete();
        } catch (Throwable unused2) {
        }
    }

    @Override // com.bytedance.sdk.component.wd.ud.lnr
    public void ud() {
        this.to = true;
        super.ud();
    }
}
