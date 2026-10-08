package com.pgl.ssdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.pgl.ssdk.ces.out.PglSSCallBack;
import com.pgl.ssdk.ces.out.PglSSManager;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f3083a = 28800;
    public static int b = 5;

    public static long a(long j, InputStream inputStream) throws IOException {
        if (j != -1) {
            return j;
        }
        byte[] bArr = new byte[8192];
        long j2 = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return j2;
            }
            j2 += (long) i;
        }
    }

    public static long b() {
        Context contextA = z.a();
        if (contextA == null) {
            return 0L;
        }
        long jA = ax.a(contextA, "pgl_frt", 0L);
        if (jA != 0) {
            return jA;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        ax.b(contextA, "pgl_frt", jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static synchronized void c() {
        if (d()) {
            String strC = v.c();
            if (TextUtils.isEmpty(strC)) {
                return;
            }
            File file = new File(strC);
            if (file.exists()) {
                JSONObject jSONObjectA = a(file, true);
                jSONObjectA.put("apk_info", v.b());
                jSONObjectA.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, ab.d(z.a()));
                PglSSManager pglSSManager = PglSSManager.getInstance();
                if (pglSSManager == null) {
                    au.a(String.valueOf(jSONObjectA));
                    return;
                }
                PglSSCallBack pglCallBack = pglSSManager.getPglCallBack();
                if (pglCallBack != null) {
                    pglCallBack.reportSoftDecData("detailed_app_info", jSONObjectA.toString());
                }
            }
        }
    }

    private static boolean d() {
        int iA = ax.a(z.a(), "pgl_is_hit", 0);
        au.a("hitsTimes " + iA);
        if (iA > 0) {
            return false;
        }
        long jCurrentTimeMillis = (System.currentTimeMillis() / 1000) - b();
        au.a("runningTime ".concat(String.valueOf(jCurrentTimeMillis)));
        if (jCurrentTimeMillis < f3083a) {
            return false;
        }
        ax.b(z.a(), "pgl_is_hit", 1);
        return e();
    }

    private static boolean e() {
        boolean z = b == 100;
        return !z ? ((int) ((Math.random() * 100.0d) + 1.0d)) <= b : z;
    }

    public static void a(JSONObject jSONObject, String str, List<String> list, boolean z) {
        if (jSONObject == null || list == null || list.isEmpty()) {
            return;
        }
        if (z) {
            try {
                jSONObject.put(str + "_size", list.size());
            } catch (JSONException unused) {
                return;
            }
        }
        jSONObject.put(str, n.a(list));
    }

    private static JSONObject a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : list) {
            if (str.endsWith(".png")) {
                arrayList2.add(str.substring(0, str.lastIndexOf(".png")));
            } else if (str.endsWith(".xml")) {
                arrayList.add(str.substring(0, str.lastIndexOf(".xml")));
            } else {
                arrayList3.add(str);
            }
        }
        a(jSONObject, "xml", arrayList, true);
        a(jSONObject, "png", arrayList2, true);
        a(jSONObject, "other", arrayList3, true);
        return jSONObject;
    }

    public static JSONObject a() throws JSONException {
        String[] strArr;
        Context contextA = z.a();
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (contextA == null) {
            return jSONObject;
        }
        ApplicationInfo applicationInfo = contextA.getApplicationInfo();
        String str = applicationInfo.nativeLibraryDir;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                    for (File file2 : fileArrListFiles) {
                        arrayList.add(file2.getName());
                    }
                }
                if ("arm64".equals(file.getName())) {
                    a(jSONObject2, "v8a", arrayList, false);
                } else {
                    a(jSONObject2, "v7a", arrayList, false);
                }
                if (jSONObject2.length() > 0) {
                    jSONObject.put("lib", jSONObject2);
                }
            }
        }
        if (!arrayList.isEmpty() || (strArr = applicationInfo.splitPublicSourceDirs) == null) {
            return jSONObject;
        }
        for (String str2 : strArr) {
            if (str2.endsWith("armeabi-v7a.apk") || str2.endsWith("arm64_v8a.apk")) {
                File file3 = new File(str2);
                return file3.exists() ? a(file3, false) : jSONObject;
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01a8 A[EXC_TOP_SPLITTER, PHI: r0 r8
  0x01a8: PHI (r0v2 org.json.JSONObject) = (r0v4 org.json.JSONObject), (r0v10 org.json.JSONObject), (r0v10 org.json.JSONObject), (r0v10 org.json.JSONObject) binds: [B:89:0x01a5, B:80:0x018e, B:82:0x0194, B:83:0x0196] A[DONT_GENERATE, DONT_INLINE]
  0x01a8: PHI (r8v1 java.util.zip.ZipFile) = (r8v2 java.util.zip.ZipFile), (r8v4 java.util.zip.ZipFile), (r8v4 java.util.zip.ZipFile), (r8v4 java.util.zip.ZipFile) binds: [B:89:0x01a5, B:80:0x018e, B:82:0x0194, B:83:0x0196] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(java.io.File r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.f.a(java.io.File, boolean):org.json.JSONObject");
    }
}
