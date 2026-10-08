package com.applovin.impl;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class s1 {
    private final String b;
    private final Map c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f592a = UUID.randomUUID().toString();
    private final long d = System.currentTimeMillis();

    public s1(String str, Map map) {
        this.b = str;
        this.c = map;
    }

    public long a() {
        return this.d;
    }

    public String b() {
        return this.f592a;
    }

    public String c() {
        return this.b;
    }

    public Map d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        s1 s1Var = (s1) obj;
        if (this.d == s1Var.d && Objects.equals(this.b, s1Var.b) && Objects.equals(this.c, s1Var.c)) {
            return Objects.equals(this.f592a, s1Var.f592a);
        }
        return false;
    }

    public int hashCode() {
        String str = this.b;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.c;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        long j = this.d;
        int i = (iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31;
        String str2 = this.f592a;
        return i + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Event{name='" + this.b + "', id='" + this.f592a + "', creationTimestampMillis=" + this.d + ", parameters=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
