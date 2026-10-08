package com.apm.insight.runtime;

import android.text.TextUtils;
import com.apm.insight.b.h;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h.a f252a;

    public static void a(h.a aVar) {
        f252a = aVar;
    }

    private static JSONArray b(String str) throws Throwable {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            bufferedReader = new BufferedReader(new FileReader(str));
            try {
                File file = new File(str);
                if (file.length() > 512000) {
                    bufferedReader.skip(file.length() - 512000);
                }
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        jSONArray.put(line);
                    } else {
                        com.apm.insight.a.a((Closeable) bufferedReader);
                        return jSONArray;
                    }
                }
            } catch (IOException unused) {
                com.apm.insight.a.a((Closeable) bufferedReader);
                return null;
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                com.apm.insight.a.a((Closeable) bufferedReader2);
                throw th;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONArray a(String str) {
        if (!com.apm.insight.e.v()) {
            return null;
        }
        if (f252a != null && com.apm.insight.e.f().equals(str)) {
            try {
                return b(f252a.b());
            } catch (Throwable th) {
                com.apm.insight.c.a();
                j.a(th, "NPTH_CATCH");
            }
        }
        try {
            return b(com.apm.insight.a.a(str, com.apm.insight.e.i().getLogcatDumpCount(), com.apm.insight.e.i().getLogcatLevel()).getAbsolutePath());
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            j.a(th2, "NPTH_CATCH");
            return null;
        }
    }
}
