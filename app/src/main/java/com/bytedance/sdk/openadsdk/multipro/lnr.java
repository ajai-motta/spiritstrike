package com.bytedance.sdk.openadsdk.multipro;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.component.utils.jyq;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private static boolean qdl = true;
    private static final AtomicBoolean ud = new AtomicBoolean(false);

    public static void qdl(Context context) {
        if (context != null && qdl && ud.compareAndSet(false, true)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (jyq.qdl(context)) {
                        ud(context);
                        return;
                    }
                    String strUd = jyq.ud(context);
                    try {
                        if (TextUtils.isEmpty(strUd)) {
                            strUd = context.getPackageName() + Process.myPid();
                        }
                        WebView.setDataDirectorySuffix(strUd);
                    } catch (IllegalStateException unused) {
                        qdl(strUd);
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th) {
                aaj.lnr(th.getMessage(), new Object[0]);
            }
        }
    }

    public static void qdl() {
        qdl = false;
    }

    private static void qdl(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void ud(android.content.Context r3) throws java.lang.Throwable {
        /*
            java.lang.String r0 = ud()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto Le
            java.lang.String r0 = "webview"
            goto L19
        Le:
            java.lang.String r1 = "webview_"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r0 = r1.concat(r0)
        L19:
            r1 = 0
            java.io.File r3 = r3.getDir(r0, r1)
            java.lang.String r3 = r3.getPath()
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "webview_data.lock"
            r0.<init>(r3, r1)
            r0.getAbsolutePath()
            boolean r3 = r0.exists()
            if (r3 != 0) goto L34
            return
        L34:
            r3 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.lang.String r2 = "rw"
            r1.<init>(r0, r2)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6c
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch: java.lang.Exception -> L6d java.lang.Throwable -> L85
            if (r2 == 0) goto L49
            java.nio.channels.FileLock r3 = r2.tryLock()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L65
            goto L49
        L47:
            r3 = move-exception
            goto L88
        L49:
            if (r3 == 0) goto L4f
            r3.close()     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L65
            goto L52
        L4f:
            qdl(r0)     // Catch: java.lang.Throwable -> L47 java.lang.Exception -> L65
        L52:
            if (r2 == 0) goto L5c
            r2.close()     // Catch: java.lang.Throwable -> L58
            goto L5c
        L58:
            r3 = move-exception
            r3.getMessage()
        L5c:
            r1.close()     // Catch: java.lang.Throwable -> L60
            return
        L60:
            r3 = move-exception
            r3.getMessage()
            return
        L65:
            r3 = r2
            goto L6d
        L67:
            r0 = move-exception
            r1 = r3
            r2 = r1
        L6a:
            r3 = r0
            goto L88
        L6c:
            r1 = r3
        L6d:
            qdl(r0)     // Catch: java.lang.Throwable -> L85
            if (r3 == 0) goto L7a
            r3.close()     // Catch: java.lang.Throwable -> L76
            goto L7a
        L76:
            r3 = move-exception
            r3.getMessage()
        L7a:
            if (r1 == 0) goto L84
            r1.close()     // Catch: java.lang.Throwable -> L80
            return
        L80:
            r3 = move-exception
            r3.getMessage()
        L84:
            return
        L85:
            r0 = move-exception
            r2 = r3
            goto L6a
        L88:
            if (r2 == 0) goto L92
            r2.close()     // Catch: java.lang.Throwable -> L8e
            goto L92
        L8e:
            r0 = move-exception
            r0.getMessage()
        L92:
            if (r1 == 0) goto L9c
            r1.close()     // Catch: java.lang.Throwable -> L98
            goto L9c
        L98:
            r0 = move-exception
            r0.getMessage()
        L9c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.lnr.ud(android.content.Context):void");
    }

    private static void qdl(File file) {
        qdl(file, file.exists() ? file.delete() : false);
    }

    private static void qdl(File file, boolean z) {
        if (!z || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            aaj.lnr("TTAD.TTMultiInitHelper", e.getMessage());
        }
    }

    private static String ud() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }
}
