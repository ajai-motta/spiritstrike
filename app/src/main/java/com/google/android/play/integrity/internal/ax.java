package com.google.android.play.integrity.internal;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
public final class ax implements bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1804a = new Object();
    private volatile bb b;
    private volatile Object c = f1804a;

    private ax(bb bbVar) {
        this.b = bbVar;
    }

    public static bb b(bb bbVar) {
        return bbVar instanceof ax ? bbVar : new ax(bbVar);
    }

    @Override // com.google.android.play.integrity.internal.bd, com.google.android.play.integrity.internal.bc
    public final Object a() {
        Object objA = this.c;
        Object obj = f1804a;
        if (objA == obj) {
            synchronized (this) {
                objA = this.c;
                if (objA == obj) {
                    objA = this.b.a();
                    Object obj2 = this.c;
                    if (obj2 != obj && obj2 != objA) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj2 + " & " + objA + ". This is likely due to a circular dependency.");
                    }
                    this.c = objA;
                    this.b = null;
                }
            }
        }
        return objA;
    }
}
