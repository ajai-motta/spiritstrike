package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class q8 {
    public static final q8 f = new q8();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q8 f581a;
    private final String b;
    private final Map c;
    protected String d;
    protected final List e;

    public q8(String str, Map map, q8 q8Var) {
        this.f581a = q8Var;
        this.b = str;
        this.c = Collections.unmodifiableMap(map);
        this.e = new ArrayList();
    }

    public Map a() {
        return this.c;
    }

    public List b() {
        return Collections.unmodifiableList(this.e);
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.d;
    }

    public String toString() {
        return "XmlNode{elementName='" + this.b + "', text='" + this.d + "', attributes=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public List a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        ArrayList arrayList = new ArrayList(this.e.size());
        for (q8 q8Var : this.e) {
            if (str.equalsIgnoreCase(q8Var.c())) {
                arrayList.add(q8Var);
            }
        }
        return arrayList;
    }

    public q8 b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        if (this.e.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        while (!arrayList.isEmpty()) {
            q8 q8Var = (q8) arrayList.get(0);
            arrayList.remove(0);
            if (str.equalsIgnoreCase(q8Var.c())) {
                return q8Var;
            }
            arrayList.addAll(q8Var.b());
        }
        return null;
    }

    public q8 c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified.");
        }
        for (q8 q8Var : this.e) {
            if (str.equalsIgnoreCase(q8Var.c())) {
                return q8Var;
            }
        }
        return null;
    }

    private q8() {
        this.f581a = null;
        this.b = "";
        this.c = Collections.emptyMap();
        this.d = "";
        this.e = Collections.emptyList();
    }
}
