package com.apm.insight.l;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Writer f216a;
    private final List<a> b = new ArrayList();

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f217a = new a("EMPTY_ARRAY", 0);
        public static final a b = new a("NONEMPTY_ARRAY", 1);
        public static final a c = new a("EMPTY_OBJECT", 2);
        public static final a d = new a("DANGLING_KEY", 3);
        public static final a e = new a("NONEMPTY_OBJECT", 4);
        public static final a f = new a("NULL", 5);

        private a(String str, int i) {
        }
    }

    private h(Writer writer) {
        this.f216a = writer;
    }

    private h a() throws JSONException, IOException {
        return a(a.f217a, "[");
    }

    private h b() throws JSONException, IOException {
        a aVar = a.f217a;
        a aVar2 = a.b;
        return a("]");
    }

    private h c() throws JSONException, IOException {
        return a(a.c, "{");
    }

    private h d() throws JSONException, IOException {
        a aVar = a.c;
        a aVar2 = a.e;
        return a("}");
    }

    private h a(a aVar, String str) throws JSONException, IOException {
        f();
        this.b.add(aVar);
        this.f216a.write(str);
        return this;
    }

    private h a(String str) throws JSONException, IOException {
        e();
        this.b.remove(r0.size() - 1);
        this.f216a.write(str);
        return this;
    }

    private a e() throws JSONException {
        return this.b.get(r0.size() - 1);
    }

    private void a(a aVar) {
        this.b.set(r0.size() - 1, aVar);
    }

    private h a(Object obj) throws JSONException, IOException {
        if (obj instanceof JSONArray) {
            a((JSONArray) obj);
            return this;
        }
        if (obj instanceof JSONObject) {
            a((JSONObject) obj);
            return this;
        }
        f();
        if (obj == null || obj == JSONObject.NULL) {
            this.f216a.write(AbstractJsonLexerKt.NULL);
        } else if (obj instanceof Boolean) {
            this.f216a.write(String.valueOf(obj));
        } else if (obj instanceof Number) {
            this.f216a.write(JSONObject.numberToString((Number) obj));
        } else {
            b(obj.toString());
        }
        return this;
    }

    private void b(String str) throws IOException {
        this.f216a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\f') {
                this.f216a.write("\\f");
            } else if (cCharAt == '\r') {
                this.f216a.write("\\r");
            } else {
                if (cCharAt == '\"' || cCharAt == '/' || cCharAt == '\\') {
                    this.f216a.write(92);
                } else {
                    switch (cCharAt) {
                        case '\b':
                            this.f216a.write("\\b");
                            continue;
                        case '\t':
                            this.f216a.write("\\t");
                            continue;
                        case '\n':
                            this.f216a.write("\\n");
                            continue;
                        default:
                            if (cCharAt <= 31) {
                                this.f216a.write(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                            }
                            break;
                    }
                }
                this.f216a.write(cCharAt);
            }
        }
        this.f216a.write("\"");
    }

    private void f() throws JSONException, IOException {
        if (this.b.isEmpty()) {
            return;
        }
        a aVarE = e();
        if (aVarE == a.f217a) {
            a(a.b);
            return;
        }
        if (aVarE == a.b) {
            this.f216a.write(44);
        } else if (aVarE == a.d) {
            this.f216a.write(":");
            a(a.e);
        } else if (aVarE != a.f) {
            throw new JSONException("Nesting problem");
        }
    }

    public final String toString() {
        return "";
    }

    public static void a(JSONObject jSONObject, Writer writer) throws Throwable {
        new h(writer).a(jSONObject);
        writer.flush();
    }

    public static void a(JSONArray jSONArray, Writer writer) throws Throwable {
        new h(writer).a(jSONArray);
        writer.flush();
    }

    private void a(JSONObject jSONObject) throws JSONException, IOException {
        c();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            c(next).a(jSONObject.get(next));
        }
        d();
    }

    private void a(JSONArray jSONArray) throws JSONException, IOException {
        a();
        for (int i = 0; i < jSONArray.length(); i++) {
            a(jSONArray.get(i));
        }
        b();
    }

    private h c(String str) throws JSONException, IOException {
        a aVarE = e();
        if (aVarE == a.e) {
            this.f216a.write(44);
        } else if (aVarE != a.c) {
            throw new JSONException("Nesting problem");
        }
        a(a.d);
        b(str);
        return this;
    }
}
