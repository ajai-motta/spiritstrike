package com.pgl.ssdk;

import java.io.BufferedInputStream;

/* JADX INFO: loaded from: classes6.dex */
public class af {
    private static void a(byte[] bArr, int i, byte[] bArr2) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ bArr2[i2 % bArr2.length]);
        }
    }

    private static String a(BufferedInputStream bufferedInputStream) {
        int i;
        if (bufferedInputStream == null) {
            return "";
        }
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        do {
            try {
                i = bufferedInputStream.read(bArr);
                if (i > 0) {
                    sb.append(new String(bArr, 0, i));
                }
            } catch (Exception unused) {
            }
        } while (i >= 4096);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0065 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0060 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(java.lang.String r5) throws java.lang.Throwable {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L5b
            java.lang.String r2 = "sh"
            java.lang.Process r1 = r1.exec(r2)     // Catch: java.lang.Throwable -> L48 java.lang.Exception -> L5b
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L5c
            java.io.OutputStream r3 = r1.getOutputStream()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L5c
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L5c
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L44
            java.io.InputStream r4 = r1.getInputStream()     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L44
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L40 java.lang.Exception -> L44
            byte[] r5 = r5.getBytes()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L5e
            r2.write(r5)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L5e
            r5 = 10
            r2.write(r5)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L5e
            r2.flush()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L5e
            r2.close()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L5e
            r1.waitFor()     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L5e
            java.lang.String r5 = a(r3)     // Catch: java.lang.Throwable -> L3e java.lang.Exception -> L5e
            r2.close()     // Catch: java.io.IOException -> L39
        L39:
            r3.close()     // Catch: java.io.IOException -> L3c
        L3c:
            r0 = r5
            goto L6b
        L3e:
            r5 = move-exception
            goto L42
        L40:
            r5 = move-exception
            r3 = r0
        L42:
            r0 = r2
            goto L4b
        L44:
            r3 = r0
            goto L5e
        L46:
            r5 = move-exception
            goto L4a
        L48:
            r5 = move-exception
            r1 = r0
        L4a:
            r3 = r0
        L4b:
            if (r0 == 0) goto L50
            r0.close()     // Catch: java.io.IOException -> L50
        L50:
            if (r3 == 0) goto L55
            r3.close()     // Catch: java.io.IOException -> L55
        L55:
            if (r1 == 0) goto L5a
            r1.destroy()
        L5a:
            throw r5
        L5b:
            r1 = r0
        L5c:
            r2 = r0
            r3 = r2
        L5e:
            if (r2 == 0) goto L63
            r2.close()     // Catch: java.io.IOException -> L63
        L63:
            if (r3 == 0) goto L68
            r3.close()     // Catch: java.io.IOException -> L68
        L68:
            if (r1 != 0) goto L6b
            goto L6e
        L6b:
            r1.destroy()
        L6e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.af.a(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized java.lang.String a(android.content.Context r9) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.af.a(android.content.Context):java.lang.String");
    }
}
