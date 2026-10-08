package com.bykv.vk.openvk.preload.a;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class i implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected e f785a;
    private int b;
    private List<h> c;
    private d d;

    i(List<h> list, int i, e eVar, d dVar) {
        this.c = list;
        this.b = i;
        this.f785a = eVar;
        this.d = dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.a.b
    public final Object a(Object obj) throws Exception {
        d dVar = this.d;
        if (dVar != null) {
            dVar.c = obj;
            this.d.e();
        }
        if (this.b >= this.c.size()) {
            return obj;
        }
        h hVar = this.c.get(this.b);
        Class<? extends d> cls = hVar.f783a;
        d dVar2 = (d) this.f785a.a(cls);
        if (dVar2 == null) {
            throw new IllegalArgumentException("interceptor == null , index = " + obj + " , class: " + cls);
        }
        com.bykv.vk.openvk.preload.a.b.a aVarA = hVar.a();
        i iVar = new i(this.c, this.b + 1, this.f785a, dVar2);
        dVar2.a(iVar, this.d, obj, aVarA, hVar.b());
        dVar2.c();
        try {
            Object objA = dVar2.a(iVar, obj);
            dVar2.d();
            return objA;
        } catch (a e) {
            dVar2.c(e.getCause());
            throw e;
        } catch (Throwable th) {
            dVar2.b(th);
            throw new a(th);
        }
    }

    @Override // com.bykv.vk.openvk.preload.a.b
    public final Object a(Class cls) {
        d dVarC = c(cls);
        if (dVarC == null) {
            throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
        }
        return dVarC.b;
    }

    @Override // com.bykv.vk.openvk.preload.a.b
    public final Object b(Class cls) {
        d dVarC = c(cls);
        if (dVarC == null) {
            throw new IllegalArgumentException("can not find pre Interceptor , class:".concat(String.valueOf(cls)));
        }
        return dVarC.c;
    }

    private d c(Class cls) {
        d dVar = this.d;
        while (dVar != null && dVar.getClass() != cls) {
            dVar = dVar.f781a;
        }
        return dVar;
    }

    static final class a extends Exception {
        a(Throwable th) {
            super(th);
        }
    }
}
