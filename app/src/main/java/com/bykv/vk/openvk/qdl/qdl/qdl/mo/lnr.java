package com.bykv.vk.openvk.qdl.qdl.qdl.mo;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class lnr extends mzz implements SurfaceHolder.Callback, ud {
    private static final ArrayList<mo> lnr = new ArrayList<>();
    private ud.qdl mml;
    private WeakReference<qdl> qdl;
    private mo ud;

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud
    public View getView() {
        return this;
    }

    public lnr(Context context) {
        super(context);
        qdl();
    }

    private void qdl() {
        mo moVar = new mo(this);
        this.ud = moVar;
        lnr.add(moVar);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud
    public void qdl(qdl qdlVar) {
        this.qdl = new WeakReference<>(qdlVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<mo> it = lnr.iterator();
        while (it.hasNext()) {
            mo next = it.next();
            if (next != null && next.qdl() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.ud);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud
    public void qdl(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<qdl> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().qdl(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        WeakReference<qdl> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().qdl(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference<qdl> weakReference = this.qdl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.qdl.get().ud(surfaceHolder);
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(ud.qdl qdlVar) {
        this.mml = qdlVar;
    }
}
