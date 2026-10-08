package com.bytedance.sdk.openadsdk.multipro.qdl;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.mo.qdl.mo;
import com.bytedance.sdk.openadsdk.core.mzz;
import com.bytedance.sdk.openadsdk.multipro.mml;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    public static mo qdl;
    private static final ConcurrentHashMap<String, Object> ud = new ConcurrentHashMap<>();

    /* JADX WARN: Removed duplicated region for block: B:6:0x0009 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:3:0x0002, B:4:0x0005, B:6:0x0009, B:8:0x000f, B:9:0x001f), top: B:14:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.mo.qdl.mo qdl(android.content.Context r1) {
        /*
            if (r1 != 0) goto L5
            com.bytedance.sdk.openadsdk.core.yt.qdl()     // Catch: java.lang.Throwable -> L26
        L5:
            com.bytedance.sdk.component.mo.qdl.mo r1 = com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L2b
            boolean r1 = com.bytedance.sdk.openadsdk.multipro.ud.lnr()     // Catch: java.lang.Throwable -> L26
            if (r1 == 0) goto L1f
            com.bytedance.sdk.openadsdk.multipro.aidl.qdl r1 = com.bytedance.sdk.openadsdk.multipro.aidl.qdl.qdl()     // Catch: java.lang.Throwable -> L26
            r0 = 5
            android.os.IBinder r1 = r1.qdl(r0)     // Catch: java.lang.Throwable -> L26
            com.bytedance.sdk.component.mo.qdl.mo r1 = com.bytedance.sdk.openadsdk.multipro.aidl.qdl.mo.qdl(r1)     // Catch: java.lang.Throwable -> L26
            com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl = r1     // Catch: java.lang.Throwable -> L26
            goto L2b
        L1f:
            com.bytedance.sdk.openadsdk.multipro.aidl.qdl.mo r1 = com.bytedance.sdk.openadsdk.multipro.aidl.qdl.mo.ud()     // Catch: java.lang.Throwable -> L26
            com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl = r1     // Catch: java.lang.Throwable -> L26
            goto L2b
        L26:
            java.lang.String r1 = "binder error"
            com.bytedance.sdk.openadsdk.utils.gy.jpc(r1)
        L2b:
            com.bytedance.sdk.component.mo.qdl.mo r1 = com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl(android.content.Context):com.bytedance.sdk.component.mo.qdl.mo");
    }

    private static String qdl() {
        return mml.ud + "/t_db/ttopensdk.db/";
    }

    public static void qdl(Context context, String str, ContentValues contentValues) {
        if (contentValues == null || TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (qdl(str)) {
            if (!com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                mzz.qdl(context).qdl().qdl(str, (String) null, contentValues);
                return;
            }
            mo moVarQdl = qdl(context);
            if (moVarQdl != null) {
                moVarQdl.qdl(Uri.parse(qdl() + str), contentValues);
            }
        }
    }

    public static int qdl(Context context, String str, String str2, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        synchronized (qdl(str)) {
            if (!com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                return mzz.qdl(context).qdl().qdl(str, str2, strArr);
            }
            mo moVarQdl = qdl(context);
            if (moVarQdl != null) {
                return moVarQdl.qdl(Uri.parse(qdl() + str), str2, strArr);
            }
            return 0;
        }
    }

    public static int qdl(Context context, String str, ContentValues contentValues, String str2, String[] strArr) {
        if (contentValues != null && !TextUtils.isEmpty(str)) {
            synchronized (qdl(str)) {
                if (!com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                    return mzz.qdl(context).qdl().qdl(str, contentValues, str2, strArr);
                }
                mo moVarQdl = qdl(context);
                if (moVarQdl != null) {
                    return moVarQdl.qdl(Uri.parse(qdl() + str), contentValues, str2, strArr);
                }
            }
        }
        return 0;
    }

    public static Map<String, List<String>> qdl(Context context, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (qdl(str)) {
            if (!com.bytedance.sdk.openadsdk.multipro.ud.lnr()) {
                return qdl(mzz.qdl(context).qdl().qdl(str, strArr, str2, strArr2, str3, str4, str5));
            }
            mo moVarQdl = qdl(context);
            if (moVarQdl != null) {
                return moVarQdl.qdl(Uri.parse(qdl() + str), strArr, str2, strArr2, str5);
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.util.List<java.lang.String>> qdl(android.database.Cursor r6) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r6 == 0) goto L47
            java.lang.String[] r1 = r6.getColumnNames()     // Catch: java.lang.Throwable -> L42
        Lb:
            int r2 = r6.getCount()     // Catch: java.lang.Throwable -> L42
            if (r2 <= 0) goto L3f
            boolean r2 = r6.moveToNext()     // Catch: java.lang.Throwable -> L42
            if (r2 == 0) goto L3f
            int r2 = r1.length     // Catch: java.lang.Throwable -> L42
            r3 = 0
        L19:
            if (r3 >= r2) goto Lb
            r4 = r1[r3]     // Catch: java.lang.Throwable -> L42
            boolean r5 = r0.containsKey(r4)     // Catch: java.lang.Throwable -> L42
            if (r5 != 0) goto L2b
            java.util.LinkedList r5 = new java.util.LinkedList     // Catch: java.lang.Throwable -> L42
            r5.<init>()     // Catch: java.lang.Throwable -> L42
            r0.put(r4, r5)     // Catch: java.lang.Throwable -> L42
        L2b:
            java.lang.Object r5 = r0.get(r4)     // Catch: java.lang.Throwable -> L42
            java.util.List r5 = (java.util.List) r5     // Catch: java.lang.Throwable -> L42
            int r4 = r6.getColumnIndex(r4)     // Catch: java.lang.Throwable -> L42
            java.lang.String r4 = r6.getString(r4)     // Catch: java.lang.Throwable -> L42
            r5.add(r4)     // Catch: java.lang.Throwable -> L42
            int r3 = r3 + 1
            goto L19
        L3f:
            if (r6 == 0) goto L47
            goto L44
        L42:
            if (r6 == 0) goto L47
        L44:
            r6.close()
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.qdl.qdl.qdl(android.database.Cursor):java.util.Map");
    }

    private static Object qdl(String str) {
        Object obj;
        ConcurrentHashMap<String, Object> concurrentHashMap = ud;
        Object obj2 = concurrentHashMap.get(str);
        if (obj2 != null) {
            return obj2;
        }
        synchronized (qdl.class) {
            obj = concurrentHashMap.get(str);
            if (obj == null) {
                obj = new Object();
                concurrentHashMap.put(str, obj);
            }
        }
        return obj;
    }
}
