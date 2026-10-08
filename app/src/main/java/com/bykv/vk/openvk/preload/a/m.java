package com.bykv.vk.openvk.preload.a;

/* JADX INFO: loaded from: classes2.dex */
final class m<IN> implements b<IN> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b<IN> f788a;

    public m(b<IN> bVar) {
        this.f788a = bVar;
    }

    @Override // com.bykv.vk.openvk.preload.a.b
    public final Object a(IN in) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // com.bykv.vk.openvk.preload.a.b
    public final <I> I a(Class<? extends d<I, ?>> cls) {
        return (I) this.f788a.a((Class) cls);
    }

    @Override // com.bykv.vk.openvk.preload.a.b
    public final <O> O b(Class<? extends d<?, O>> cls) {
        return (O) this.f788a.b(cls);
    }
}
