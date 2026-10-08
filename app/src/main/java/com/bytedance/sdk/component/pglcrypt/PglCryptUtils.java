package com.bytedance.sdk.component.pglcrypt;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class PglCryptUtils {
    public static final int BASE64_FAILED = 504;
    public static final int COMPRESS_FAILED = 503;
    public static final int CRYPT_OK = 0;
    public static final int CYPHER_VERSION = 4;
    public static final int DECRYPT_FAILED = 506;
    public static final int ENCRYPT_FAILED = 505;
    public static final int INPUT_INVALID = 502;
    public static final String KEY_CYPHER = "cypher";
    public static final String KEY_MESSAGE = "message";
    public static final int LOAD_SO_FAILED = 501;
    public static final int UNKNOWN_ERR = 507;
    private static volatile PglCryptUtils qdl = null;
    private static volatile boolean ud = true;

    public static native byte[] bc(int i, byte[] bArr);

    private PglCryptUtils() {
    }

    public static PglCryptUtils getInstance() {
        if (qdl == null) {
            synchronized (PglCryptUtils.class) {
                if (qdl == null) {
                    try {
                        System.loadLibrary("pglarmor");
                    } catch (Throwable unused) {
                        ud = false;
                    }
                    qdl = new PglCryptUtils();
                }
            }
        }
        return qdl;
    }

    public Pair<Integer, JSONObject> cypher4Encrypt(JSONObject jSONObject) throws Throwable {
        Pair<Integer, String> pairCypher4EncryptWithNoWrapBase64 = cypher4EncryptWithNoWrapBase64(jSONObject.toString());
        if (pairCypher4EncryptWithNoWrapBase64 == null) {
            return new Pair<>(507, null);
        }
        if (((Integer) pairCypher4EncryptWithNoWrapBase64.first).intValue() == 0) {
            JSONObject jSONObject2 = new JSONObject();
            String str = (String) pairCypher4EncryptWithNoWrapBase64.second;
            if (TextUtils.isEmpty(str)) {
                return new Pair<>(504, null);
            }
            jSONObject2.put("message", str);
            jSONObject2.put("cypher", 4);
            return new Pair<>(0, jSONObject2);
        }
        return new Pair<>(pairCypher4EncryptWithNoWrapBase64.first, null);
    }

    public Pair<Integer, String> cypher4EncryptWithNoWrapBase64(String str) throws Throwable {
        if (!ud) {
            return new Pair<>(501, null);
        }
        if (TextUtils.isEmpty(str)) {
            return new Pair<>(502, null);
        }
        byte[] bArrQdl = qdl(str);
        if (bArrQdl == null || bArrQdl.length == 0) {
            return new Pair<>(503, null);
        }
        Pair<Integer, byte[]> pairCypher4Encrypt = cypher4Encrypt(bArrQdl);
        if (pairCypher4Encrypt == null) {
            return new Pair<>(507, null);
        }
        if (((Integer) pairCypher4Encrypt.first).intValue() == 0) {
            String strEncodeToString = Base64.encodeToString((byte[]) pairCypher4Encrypt.second, 2);
            if (TextUtils.isEmpty(strEncodeToString)) {
                return new Pair<>(504, null);
            }
            return new Pair<>(0, strEncodeToString);
        }
        return new Pair<>(pairCypher4Encrypt.first, null);
    }

    public Pair<Integer, byte[]> cypher4Encrypt(byte[] bArr) {
        byte[] bArrBc;
        if (!ud) {
            return new Pair<>(501, null);
        }
        if (bArr == null || bArr.length == 0) {
            return new Pair<>(502, null);
        }
        try {
            bArrBc = bc(1010, bArr);
        } catch (Throwable th) {
            Log.e("ARMOR", th.toString());
            bArrBc = null;
        }
        if (bArrBc == null || bArrBc.length == 0) {
            return new Pair<>(505, null);
        }
        return new Pair<>(0, bArrBc);
    }

    public Pair<Integer, String> cypher4Decrypt(String str) throws Throwable {
        byte[] bArrBc;
        if (!ud) {
            return new Pair<>(501, null);
        }
        if (str == null || str.length() == 0) {
            return new Pair<>(502, null);
        }
        byte[] bArrDecode = Base64.decode(str, 0);
        if (bArrDecode == null || bArrDecode.length == 0) {
            return new Pair<>(504, null);
        }
        try {
            bArrBc = bc(1011, bArrDecode);
        } catch (Throwable th) {
            Log.e("ARMOR", th.toString());
            bArrBc = null;
        }
        if (bArrBc == null || bArrBc.length == 0) {
            return new Pair<>(506, null);
        }
        String strQdl = qdl(bArrBc);
        if (TextUtils.isEmpty(strQdl)) {
            return new Pair<>(503, null);
        }
        return new Pair<>(0, strQdl);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0066 A[Catch: Exception -> 0x0062, TRY_LEAVE, TryCatch #6 {Exception -> 0x0062, blocks: (B:35:0x005e, B:39:0x0066), top: B:48:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x005e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] qdl(java.lang.String r5) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "ARMOR"
            r1 = 0
            if (r5 == 0) goto L75
            int r2 = r5.length()
            if (r2 != 0) goto Ld
            goto L75
        Ld:
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L36
            r2.<init>()     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L36
            java.util.zip.GZIPOutputStream r3 = new java.util.zip.GZIPOutputStream     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2e java.lang.Exception -> L30
            java.lang.String r4 = "utf-8"
            byte[] r5 = r5.getBytes(r4)     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L5a
            r3.write(r5)     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L5a
            r3.close()     // Catch: java.lang.Exception -> L46
            byte[] r1 = r2.toByteArray()     // Catch: java.lang.Exception -> L46
            r2.close()     // Catch: java.lang.Exception -> L46
            goto L59
        L2c:
            r5 = move-exception
            goto L39
        L2e:
            r5 = move-exception
            goto L5c
        L30:
            r5 = move-exception
            r3 = r1
            goto L39
        L33:
            r5 = move-exception
            r2 = r1
            goto L5c
        L36:
            r5 = move-exception
            r2 = r1
            r3 = r2
        L39:
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L5a
            android.util.Log.e(r0, r5)     // Catch: java.lang.Throwable -> L5a
            if (r3 == 0) goto L48
            r3.close()     // Catch: java.lang.Exception -> L46
            goto L48
        L46:
            r5 = move-exception
            goto L52
        L48:
            if (r2 == 0) goto L59
            byte[] r1 = r2.toByteArray()     // Catch: java.lang.Exception -> L46
            r2.close()     // Catch: java.lang.Exception -> L46
            goto L59
        L52:
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r0, r5)
        L59:
            return r1
        L5a:
            r5 = move-exception
            r1 = r3
        L5c:
            if (r1 == 0) goto L64
            r1.close()     // Catch: java.lang.Exception -> L62
            goto L64
        L62:
            r1 = move-exception
            goto L6d
        L64:
            if (r2 == 0) goto L74
            r2.toByteArray()     // Catch: java.lang.Exception -> L62
            r2.close()     // Catch: java.lang.Exception -> L62
            goto L74
        L6d:
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r0, r1)
        L74:
            throw r5
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.pglcrypt.PglCryptUtils.qdl(java.lang.String):byte[]");
    }

    private static String qdl(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception exc;
        String str;
        GZIPInputStream gZIPInputStream2 = null;
        String string = null;
        gZIPInputStream2 = null;
        gZIPInputStream2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int i = gZIPInputStream.read(bArr2);
                            if (i != -1) {
                                byteArrayOutputStream.write(bArr2, 0, i);
                            } else {
                                string = byteArrayOutputStream.toString("utf-8");
                                byteArrayInputStream.close();
                                try {
                                    gZIPInputStream.close();
                                    byteArrayOutputStream.close();
                                    return string;
                                } catch (Exception e) {
                                    Log.e("ARMOR", e.toString());
                                    return string;
                                }
                            }
                        }
                    } catch (Exception e2) {
                        str = string;
                        gZIPInputStream2 = gZIPInputStream;
                        exc = e2;
                        Log.e("ARMOR", exc.toString());
                        if (gZIPInputStream2 != null) {
                            try {
                                gZIPInputStream2.close();
                            } catch (Exception e3) {
                                Log.e("ARMOR", e3.toString());
                                return str;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e4) {
                                Log.e("ARMOR", e4.toString());
                                throw th;
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    gZIPInputStream = gZIPInputStream2;
                    th = th3;
                }
            } catch (Exception e5) {
                exc = e5;
                str = null;
            }
        } catch (Exception e6) {
            byteArrayOutputStream = null;
            exc = e6;
            str = null;
        } catch (Throwable th4) {
            gZIPInputStream = null;
            th = th4;
            byteArrayOutputStream = null;
        }
    }
}
