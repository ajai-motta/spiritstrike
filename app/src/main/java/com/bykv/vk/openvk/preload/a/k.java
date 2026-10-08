package com.bykv.vk.openvk.preload.a;

import com.bykv.vk.openvk.preload.a.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k<IN, OUT> extends d<IN, OUT> {
    private IN d;

    protected abstract boolean a(Throwable th);

    @Override // com.bykv.vk.openvk.preload.a.d
    public final Object a(b<OUT> bVar, IN in) throws Throwable {
        this.d = in;
        try {
            return bVar.a(a());
        } catch (i.a e) {
            return a((b) bVar, e.getCause());
        } catch (Throwable th) {
            return a((b) bVar, th);
        }
    }

    protected final IN g() {
        return this.d;
    }

    private Object a(b<OUT> bVar, Throwable th) throws Throwable {
        while (a(th)) {
            try {
                return bVar.a(a());
            } catch (i.a e) {
                th = e.getCause();
            } catch (Throwable th2) {
                th = th2;
            }
        }
        throw th;
    }

    protected OUT a() {
        return this.d;
    }
}
