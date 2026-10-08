package com.fyber.inneractive.sdk.protobuf;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b3 implements Map.Entry, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparable f1541a;
    public Object b;
    public final /* synthetic */ e3 c;

    public b3(e3 e3Var, Map.Entry entry) {
        Comparable comparable = (Comparable) entry.getKey();
        Object value = entry.getValue();
        this.c = e3Var;
        this.f1541a = comparable;
        this.b = value;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f1541a.compareTo(((b3) obj).f1541a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Comparable comparable = this.f1541a;
        Object key = entry.getKey();
        if (comparable != null ? comparable.equals(key) : key == null) {
            Object obj2 = this.b;
            Object value = entry.getValue();
            if (obj2 == null) {
                if (value == null) {
                    return true;
                }
            } else if (obj2.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f1541a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f1541a;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.b;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.c.a();
        Object obj2 = this.b;
        this.b = obj;
        return obj2;
    }

    public final String toString() {
        return this.f1541a + "=" + this.b;
    }

    public b3(e3 e3Var, Comparable comparable, Object obj) {
        this.c = e3Var;
        this.f1541a = comparable;
        this.b = obj;
    }
}
