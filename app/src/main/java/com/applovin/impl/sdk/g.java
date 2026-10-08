package com.applovin.impl.sdk;

import com.applovin.impl.l1;
import com.applovin.impl.y2;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k f628a;
    private final Map b = new HashMap();
    private final Object c = new Object();
    private final Map d = new HashMap();
    private final Object e = new Object();

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f629a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;
        private final String f;
        private final String g;
        private long h;
        private final ArrayDeque i;

        public String b() {
            return this.d;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.e;
        }

        public String e() {
            return this.f;
        }

        public String f() {
            return this.g;
        }

        public String g() {
            return this.b;
        }

        public String h() {
            return this.f;
        }

        public c i() {
            return (c) this.i.getLast();
        }

        public String toString() {
            return "AdInfo{state='" + i() + "', adUnitId='" + this.f629a + "', format='" + this.b + "', adapterName='" + this.c + "', adapterClass='" + this.d + "', adapterVersion='" + this.e + "', bCode='" + this.f + "', creativeId='" + this.g + "', updated=" + this.h + AbstractJsonLexerKt.END_OBJ;
        }

        private b(y2 y2Var, c cVar) {
            this.i = new ArrayDeque();
            this.f629a = y2Var.getAdUnitId();
            this.b = y2Var.getFormat().getLabel();
            this.c = y2Var.c();
            this.d = y2Var.b();
            this.e = y2Var.z();
            this.f = y2Var.B();
            this.g = y2Var.getCreativeId();
            a(cVar);
        }

        public String a() {
            return this.f629a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(c cVar) {
            this.h = System.currentTimeMillis();
            this.i.add(cVar);
        }
    }

    public enum c {
        LOADING("loading"),
        LOAD("load"),
        SHOW("show"),
        HIDE("hide"),
        CLICK("click"),
        DESTROY("destroy"),
        SHOW_ERROR("show_error");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f630a;

        c(String str) {
            this.f630a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f630a;
        }
    }

    public interface d {
        void a(b bVar);
    }

    g(k kVar) {
        this.f628a = kVar;
        a();
    }

    public void a(y2 y2Var, c cVar) {
        synchronized (this.e) {
            String strB = y2Var.B();
            b bVar = (b) this.d.get(strB);
            if (bVar == null) {
                if (cVar == c.DESTROY) {
                    return;
                }
                bVar = new b(y2Var, cVar);
                this.d.put(strB, bVar);
            } else if (bVar.i() == cVar) {
                return;
            } else {
                bVar.a(cVar);
            }
            if (cVar == c.DESTROY) {
                this.d.remove(strB);
            }
            a(bVar, cVar);
        }
    }

    public void a() {
        synchronized (this.c) {
            for (c cVar : c.values()) {
                this.b.put(cVar, new HashSet());
            }
        }
    }

    public void a(d dVar, Set set) {
        synchronized (this.c) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                a((c) it.next()).add(dVar);
            }
        }
    }

    public void a(d dVar) {
        synchronized (this.c) {
            Iterator it = this.b.keySet().iterator();
            while (it.hasNext()) {
                a((c) it.next()).remove(dVar);
            }
        }
    }

    private Set a(c cVar) {
        synchronized (this.c) {
            Set set = (Set) this.b.get(cVar);
            if (l1.a(set)) {
                return set;
            }
            return new HashSet();
        }
    }

    private void a(b bVar, c cVar) {
        synchronized (this.c) {
            Iterator it = a(cVar).iterator();
            while (it.hasNext()) {
                ((d) it.next()).a(bVar);
            }
        }
    }
}
