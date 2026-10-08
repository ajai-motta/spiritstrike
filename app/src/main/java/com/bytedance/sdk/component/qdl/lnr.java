package com.bytedance.sdk.component.qdl;

/* JADX INFO: loaded from: classes3.dex */
public abstract class lnr<P, R> extends com.bytedance.sdk.component.qdl.ud<P, R> {
    private mzz lnr;
    private boolean qdl = true;
    private qdl ud;

    interface qdl {
        void qdl(Object obj);

        void qdl(Throwable th);
    }

    public interface ud {
        lnr qdl();
    }

    protected abstract void qdl(P p, mzz mzzVar) throws Exception;

    @Override // com.bytedance.sdk.component.qdl.ud
    public /* bridge */ /* synthetic */ String qdl() {
        return super.qdl();
    }

    protected final void qdl(R r) {
        if (mo()) {
            this.ud.qdl(r);
            mml();
        }
    }

    protected final void qdl(Throwable th) {
        if (mo()) {
            this.ud.qdl(th);
            mml();
        }
    }

    protected final void lnr() {
        qdl((Throwable) null);
    }

    protected void mml() {
        this.qdl = false;
        this.lnr = null;
    }

    void qdl(P p, mzz mzzVar, qdl qdlVar) throws Exception {
        this.lnr = mzzVar;
        this.ud = qdlVar;
        qdl(p, mzzVar);
    }

    void mzz() {
        mml();
    }

    private boolean mo() {
        if (this.qdl) {
            return true;
        }
        jpc.qdl(new IllegalStateException("Jsb async call already finished: " + qdl() + ", hashcode: " + hashCode()));
        return false;
    }
}
