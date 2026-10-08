package com.fyber.inneractive.sdk.util;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.Reference;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v {
    public static byte[] a(InputStream inputStream) throws IOException {
        ByteBuffer byteBufferAllocateDirect = (ByteBuffer) f.b.f1651a.poll();
        if (byteBufferAllocateDirect == null) {
            byteBufferAllocateDirect = ByteBuffer.allocateDirect(16384);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArrArray = (byteBufferAllocateDirect == null || !byteBufferAllocateDirect.hasArray()) ? new byte[8192] : byteBufferAllocateDirect.array();
        while (true) {
            int i = inputStream.read(bArrArray, 0, bArrArray.length);
            if (i == -1) {
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                b(byteArrayOutputStream);
                f.b.f1651a.offer(byteBufferAllocateDirect);
                return byteArray;
            }
            byteArrayOutputStream.write(bArrArray, 0, i);
        }
    }

    public static StringBuffer b(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("stream required");
        }
        ByteBuffer byteBufferAllocateDirect = (ByteBuffer) f.b.f1651a.poll();
        if (byteBufferAllocateDirect == null) {
            byteBufferAllocateDirect = ByteBuffer.allocateDirect(16384);
        }
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArrArray = (byteBufferAllocateDirect == null || !byteBufferAllocateDirect.hasArray()) ? new byte[8192] : byteBufferAllocateDirect.array();
        int i = 0;
        while (i != -1) {
            stringBuffer.append(new String(bArrArray, 0, i));
            i = inputStream.read(bArrArray);
        }
        f.b.f1651a.offer(byteBufferAllocateDirect);
        return stringBuffer;
    }

    public static void b(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static String b(Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            return "------\r\n" + stringWriter.toString() + "------\r\n";
        } catch (Exception unused) {
            return "bad stackToString";
        }
    }

    public static void a(InputStream inputStream, FileOutputStream fileOutputStream) throws IOException {
        if (inputStream != null) {
            byte[] bArr = new byte[65536];
            int i = 0;
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 == -1) {
                    IAlog.a("Copied stream content length = %d", Integer.valueOf(i));
                    return;
                } else {
                    i += i2;
                    fileOutputStream.write(bArr, 0, i2);
                }
            }
        } else {
            throw new IOException("Unable to copy from or to a null stream.");
        }
    }

    public static void a(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        try {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        } catch (Exception unused) {
        }
    }

    public static Object a(Reference reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static int a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static int a(int i, int i2) {
        return Integer.compare(i, i2);
    }

    public static String a(Throwable th) {
        String message;
        if (th == null) {
            return null;
        }
        do {
            message = th.getMessage();
            th = th.getCause();
        } while (th != null);
        return message;
    }

    public static boolean a(String str) {
        return (TextUtils.isEmpty(str) || str.trim().isEmpty()) ? false : true;
    }

    public static String a(JSONObject jSONObject, String str) {
        return (jSONObject == null || jSONObject.isNull(str)) ? "" : jSONObject.optString(str);
    }
}
