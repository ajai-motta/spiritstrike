package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes3.dex */
public class rdp extends View {
    private final qdl qdl;
    private View ud;

    public interface qdl {
        View qdl(Context context);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public rdp(Context context, qdl qdlVar) {
        super(context);
        this.qdl = qdlVar;
        qdl();
    }

    private void qdl() {
        setVisibility(8);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        View view = this.ud;
        if (view != null) {
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            ud();
        }
    }

    private View ud() {
        qdl qdlVar;
        if (this.ud == null && (qdlVar = this.qdl) != null) {
            this.ud = qdlVar.qdl(getContext());
            qdl(this.ud, (ViewGroup) getParent());
        }
        return this.ud;
    }

    private void qdl(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }
}
