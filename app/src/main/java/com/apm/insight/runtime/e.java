package com.apm.insight.runtime;

import com.apm.insight.entity.Header;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private static final e b = new e() { // from class: com.apm.insight.runtime.e.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Header f249a = null;

        @Override // com.apm.insight.runtime.e
        public final Object b(String str) {
            if (this.f249a == null) {
                this.f249a = Header.b(com.apm.insight.e.g());
            }
            return this.f249a.f().opt(str);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f248a;

    e() {
        this(b);
    }

    private e(e eVar) {
        this.f248a = eVar;
    }

    public Object b(String str) {
        e eVar = this.f248a;
        if (eVar != null) {
            return eVar.b(str);
        }
        return null;
    }

    public Object a(String str) {
        e eVar = this.f248a;
        if (eVar != null) {
            return eVar.a(str);
        }
        return null;
    }
}
