package com.bytedance.adsdk.ugeno.jpc;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ud {
    private final DataSetObservable qdl = new DataSetObservable();
    private DataSetObserver ud;

    public float qdl(int i) {
        return 1.0f;
    }

    public abstract int qdl();

    public int qdl(Object obj) {
        return -1;
    }

    public abstract boolean qdl(View view, Object obj);

    public Parcelable ud() {
        return null;
    }

    public Object qdl(ViewGroup viewGroup, int i) {
        return qdl((View) viewGroup, i);
    }

    public void qdl(ViewGroup viewGroup, int i, Object obj) {
        qdl((View) viewGroup, i, obj);
    }

    @Deprecated
    public Object qdl(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void qdl(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void lnr() {
        synchronized (this) {
            DataSetObserver dataSetObserver = this.ud;
            if (dataSetObserver != null) {
                dataSetObserver.onChanged();
            }
        }
        this.qdl.notifyChanged();
    }

    void qdl(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.ud = dataSetObserver;
        }
    }
}
