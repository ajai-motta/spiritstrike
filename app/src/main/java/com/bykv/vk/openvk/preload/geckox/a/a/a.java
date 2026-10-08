package com.bykv.vk.openvk.preload.geckox.a.a;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f797a;
    final c b;
    private final b c;

    /* synthetic */ a(C0173a c0173a, byte b) {
        this(c0173a);
    }

    private a(C0173a c0173a) {
        this.f797a = c0173a.f798a;
        this.c = c0173a.b;
        this.b = c0173a.c;
    }

    public final b a() {
        return this.c;
    }

    /* JADX INFO: renamed from: com.bykv.vk.openvk.preload.geckox.a.a.a$a, reason: collision with other inner class name */
    public static final class C0173a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f798a;
        private b b = b.f799a;
        private c c;

        public final C0173a a() {
            this.f798a = 20;
            return this;
        }

        public final C0173a a(b bVar) {
            if (bVar == null) {
                bVar = b.f799a;
            }
            this.b = bVar;
            return this;
        }

        public final a b() {
            return new a(this, (byte) 0);
        }
    }
}
