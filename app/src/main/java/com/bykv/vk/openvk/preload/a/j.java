package com.bykv.vk.openvk.preload.a;

import com.bykv.vk.openvk.preload.a.i;
import com.bykv.vk.openvk.preload.a.l;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j<IN, OUT> extends l<IN, OUT> {
    private String d;

    protected abstract String a(IN in);

    protected abstract String a(IN in, Throwable th, String str);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bykv.vk.openvk.preload.a.d
    public final Object a(b<OUT> bVar, IN in) throws Throwable {
        new m(bVar);
        this.d = a(in);
        l.a aVar = a().get(this.d);
        while (aVar != null) {
            List<h> list = aVar.f786a;
            try {
                Object objA = c.a(list, bVar.f785a, this).a(in);
                return !a(list) ? objA : bVar.a(objA);
            } catch (i.a e) {
                Throwable cause = e.getCause();
                new m(bVar);
                this.d = a(in, cause, this.d);
                aVar = a().get(this.d);
            } catch (Throwable th) {
                new m(bVar);
                this.d = a(in, th, this.d);
                aVar = a().get(this.d);
            }
        }
        throw new IllegalArgumentException("can not found branch，branch name is：" + this.d);
    }
}
