package com.bykv.vk.openvk.preload.a;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Class<? extends d> f783a;
    private com.bykv.vk.openvk.preload.a.b.a b;
    private Object[] c;

    /* synthetic */ h(a aVar, byte b) {
        this(aVar);
    }

    private h(a aVar) {
        this.f783a = aVar.f784a;
        this.b = aVar.b;
        this.c = aVar.c;
        if (this.f783a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }

    final com.bykv.vk.openvk.preload.a.b.a a() {
        return this.b;
    }

    final Object[] b() {
        return this.c;
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<? extends d> f784a;
        private com.bykv.vk.openvk.preload.a.b.a b;
        private Object[] c;

        private a() {
        }

        public static a a() {
            return new a();
        }

        public final a a(Class<? extends d> cls) {
            if (cls == null) {
                throw new IllegalArgumentException("interceptor class == null");
            }
            this.f784a = cls;
            return this;
        }

        public final a a(com.bykv.vk.openvk.preload.a.b.a aVar) {
            this.b = aVar;
            return this;
        }

        public final a a(Object... objArr) {
            this.c = objArr;
            return this;
        }

        public final h b() {
            return new h(this, (byte) 0);
        }
    }
}
