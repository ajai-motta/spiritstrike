package com.bykv.vk.openvk.qdl.qdl.qdl.mo;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud;

/* JADX INFO: loaded from: classes2.dex */
public class mml extends TextureView implements TextureView.SurfaceTextureListener, ud {
    private qdl qdl;
    private ud.qdl ud;

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud
    public SurfaceHolder getHolder() {
        return null;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud
    public View getView() {
        return this;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public mml(Context context) {
        this(context, null);
    }

    public mml(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud
    public void qdl(qdl qdlVar) {
        this.qdl = qdlVar;
        setSurfaceTextureListener(this);
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.qdl.mo.ud
    public void qdl(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.TextureView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.TextureView, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        qdl qdlVar = this.qdl;
        if (qdlVar != null) {
            qdlVar.qdl(surfaceTexture, i, i2);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        qdl qdlVar = this.qdl;
        if (qdlVar != null) {
            return qdlVar.qdl(surfaceTexture);
        }
        return false;
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
    }

    public void setWindowVisibilityChangedListener(ud.qdl qdlVar) {
        this.ud = qdlVar;
    }
}
