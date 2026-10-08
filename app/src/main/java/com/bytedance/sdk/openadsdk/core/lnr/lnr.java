package com.bytedance.sdk.openadsdk.core.lnr;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.yt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class lnr implements View.OnClickListener, View.OnTouchListener {
    private static float lnr = 0.0f;
    private static float mml = 0.0f;
    private static long mzz = 0;
    private static float qdl = 0.0f;
    private static float ud = 0.0f;
    protected static int vu = 8;
    protected View kdv;
    protected float aaj = -1.0f;
    protected float jyq = -1.0f;
    protected float oth = -1.0f;
    protected float ljh = -1.0f;
    protected long bch = -1;
    protected long uw = -1;
    protected int xmv = -1;
    protected int bqt = -1024;
    protected int koa = -1;
    protected boolean rc = true;
    public SparseArray<qdl> ekw = new SparseArray<>();
    private int mo = 0;
    private int wd = 0;

    protected abstract void qdl(View view, float f, float f2, float f3, float f4, SparseArray<qdl> sparseArray, boolean z);

    static {
        if (yt.qdl() != null) {
            vu = yt.ud();
        }
        qdl = 0.0f;
        ud = 0.0f;
        lnr = 0.0f;
        mml = 0.0f;
        mzz = 0L;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.bytedance.sdk.openadsdk.core.settings.wd.qdl()) {
            qdl(view, this.aaj, this.jyq, this.oth, this.ljh, this.ekw, this.rc);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r14, android.view.MotionEvent r15) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.lnr.lnr.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private boolean qdl(View view, Point point) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (ud.ud(childAt)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return view.isShown() && point.x >= iArr[0] && point.x <= iArr[0] + childAt.getWidth() && point.y >= iArr[1] && point.y <= iArr[1] + childAt.getHeight();
                }
                if (qdl(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static class qdl {
        public double lnr;
        public long mml;
        public int qdl;
        public double ud;

        public qdl(int i, double d, double d2, long j) {
            this.qdl = i;
            this.ud = d;
            this.lnr = d2;
            this.mml = j;
        }
    }

    public boolean mo() {
        return this.rc;
    }
}
