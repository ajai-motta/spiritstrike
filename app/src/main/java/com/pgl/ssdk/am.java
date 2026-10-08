package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public abstract class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f3065a;
    private Context c;
    private int d;
    private int e;
    private byte[] f;
    private HttpURLConnection b = null;
    private int g = -1;
    private byte[] h = null;
    private int i = 10000;
    private int j = 0;
    private int k = 2;
    private boolean l = true;
    private Runnable m = new a();

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (am.this.c() || am.this.j >= am.this.k) {
                return;
            }
            am.c(am.this);
            ar.a(this);
        }
    }

    public am(Context context) {
        this.c = context;
    }

    static /* synthetic */ int c(am amVar) {
        int i = amVar.j;
        amVar.j = i + 1;
        return i;
    }

    abstract String a();

    abstract void a(int i, byte[] bArr);

    public static synchronized void a(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(f3065a)) {
            f3065a = str;
        }
    }

    private void b() {
        Object obj;
        if (this.b == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(f3065a)) {
                jSONObject.put("ipv6", f3065a);
            }
            if (!TextUtils.isEmpty(com.pgl.ssdk.ces.b.c())) {
                jSONObject.put("gaid", com.pgl.ssdk.ces.b.c());
            }
            jSONObject.put(TtmlNode.TAG_REGION, an.a());
            Pair<Integer, String> pairA = aq.a(jSONObject.toString());
            if (pairA == null || (obj = pairA.first) == null || pairA.second == null) {
                return;
            }
            this.b.addRequestProperty("cypher", String.valueOf(obj));
            this.b.addRequestProperty("transfer-param", (String) pairA.second);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ba A[Catch: all -> 0x00ce, PHI: r0
  0x00ba: PHI (r0v14 java.io.InputStream) = (r0v13 java.io.InputStream), (r0v20 java.io.InputStream) binds: [B:30:0x00b7, B:27:0x00b3] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #2 {all -> 0x00ce, blocks: (B:3:0x0004, B:5:0x0010, B:10:0x001f, B:12:0x0038, B:14:0x0040, B:15:0x0048, B:17:0x0051, B:19:0x0064, B:21:0x0081, B:23:0x0084, B:24:0x009a, B:33:0x00bd, B:32:0x00ba, B:18:0x005c), top: B:48:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c() {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.am.c():boolean");
    }

    private void a(int i) throws ProtocolException {
        this.b.setRequestMethod(i != 1 ? i != 3 ? i != 4 ? i != 5 ? i != 6 ? "GET" : "TRACE" : "HEAD" : "DELETE" : "PUT" : "POST");
    }

    private byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr, 0, 1024);
            if (i > 0) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public void a(int i, int i2, byte[] bArr) {
        b(i, i2, bArr);
        ar.a(this.m);
    }

    private void b(int i) {
        String str = i != 1 ? i != 2 ? "" : "application/octet-stream" : "application/json; charset=utf-8";
        if (!str.isEmpty()) {
            this.b.addRequestProperty("Content-Type", str);
        }
        String strB = an.b();
        if (strB != null) {
            this.b.addRequestProperty("x-pangle-target-idc", strB);
        }
        b();
        try {
            String language = Locale.getDefault().getLanguage();
            if (language.equalsIgnoreCase("zh")) {
                this.b.addRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, Locale.getDefault().toString() + "," + language + ";q=0.9");
                return;
            }
            this.b.addRequestProperty(HttpHeaders.ACCEPT_LANGUAGE, Locale.getDefault().toString() + "," + language + ";q=0.9,en-US;q=0.6,en;q=0.4");
        } catch (Throwable unused) {
        }
    }

    private void b(int i, int i2, byte[] bArr) {
        this.d = i;
        this.e = i2;
        this.f = bArr;
    }
}
