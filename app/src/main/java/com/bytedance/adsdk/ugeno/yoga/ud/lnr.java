package com.bytedance.adsdk.ugeno.yoga.ud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.mml;
import com.bytedance.adsdk.ugeno.qdl.jpc;
import com.bytedance.adsdk.ugeno.qdl.wd;
import com.bytedance.adsdk.ugeno.yoga.exu;
import com.bytedance.adsdk.ugeno.yoga.mo;
import com.bytedance.adsdk.ugeno.yoga.mzz;
import com.bytedance.adsdk.ugeno.yoga.rdp;
import com.bytedance.adsdk.ugeno.yoga.rq;
import com.bytedance.adsdk.ugeno.yoga.to;
import com.bytedance.adsdk.ugeno.yoga.tvp;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class lnr extends ViewGroup implements wd, com.bytedance.adsdk.ugeno.ud.ud {
    private mml lnr;
    private jpc mml;
    private final Map<View, to> qdl;
    private final to ud;

    public lnr(Context context) {
        this(context, null, 0);
    }

    public lnr(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mml = new jpc(this);
        to toVarQdl = rq.qdl();
        this.ud = toVarQdl;
        this.qdl = new HashMap();
        toVarQdl.qdl(this);
        toVarQdl.qdl((com.bytedance.adsdk.ugeno.yoga.wd) new ud());
        qdl((qdl) generateDefaultLayoutParams(), toVarQdl, this);
    }

    public to getYogaNode() {
        return this.ud;
    }

    public to qdl(View view) {
        return this.qdl.get(view);
    }

    @Override // com.bytedance.adsdk.ugeno.ud.ud
    public void qdl(int i) {
        to toVar = this.ud;
        if (toVar != null) {
            qdl(toVar, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ud.ud
    public void ud(int i) {
        to toVar = this.ud;
        if (toVar != null) {
            ud(toVar, i);
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ud.ud
    public void qdl(View view, int i) {
        to toVarQdl;
        if (view == null || (toVarQdl = qdl(view)) == null) {
            return;
        }
        qdl(toVarQdl, i);
        view.requestLayout();
    }

    @Override // com.bytedance.adsdk.ugeno.ud.ud
    public void ud(View view, int i) {
        to toVarQdl;
        if (view == null || (toVarQdl = qdl(view)) == null) {
            return;
        }
        ud(toVarQdl, i);
        view.requestLayout();
    }

    private void qdl(to toVar, int i) {
        if (i == -1) {
            toVar.mzz(100.0f);
        } else if (i == -2) {
            toVar.mml();
        } else {
            toVar.mml(i);
        }
    }

    private void ud(to toVar, int i) {
        if (i == -1) {
            toVar.wd(100.0f);
        } else if (i == -2) {
            toVar.mzz();
        } else {
            toVar.mo(i);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ud.ud
    public void lnr(View view, int i) {
        mml(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        to toVarQdl;
        this.ud.qdl((com.bytedance.adsdk.ugeno.yoga.wd) null);
        if (view instanceof com.bytedance.adsdk.ugeno.yoga.ud.ud) {
            throw null;
        }
        super.addView(view, i, layoutParams);
        if (this.qdl.containsKey(view)) {
            return;
        }
        if (view instanceof lnr) {
            toVarQdl = ((lnr) view).getYogaNode();
        } else {
            if (this.qdl.containsKey(view)) {
                toVarQdl = this.qdl.get(view);
            } else {
                toVarQdl = rq.qdl();
            }
            toVarQdl.qdl(view);
            toVarQdl.qdl((com.bytedance.adsdk.ugeno.yoga.wd) new ud());
        }
        qdl((qdl) view.getLayoutParams(), toVarQdl, view);
        this.qdl.put(view, toVarQdl);
        if (view.getVisibility() == 8) {
            view.setTag(151060224, Integer.valueOf(this.ud.qdl()));
        } else {
            to toVar = this.ud;
            toVar.qdl(toVarQdl, toVar.qdl());
        }
    }

    public void mml(View view, int i) {
        int iQdl;
        view.setVisibility(i);
        try {
            to toVar = this.qdl.get(view);
            Object tag = view.getTag(151060224);
            if (i != 0) {
                if (i != 8 || (iQdl = this.ud.qdl(toVar)) == -1) {
                    return;
                }
                this.ud.ud(iQdl);
                view.setTag(151060224, Integer.valueOf(iQdl));
                qdl(this.ud);
                return;
            }
            if (tag == null || this.ud.qdl(toVar) != -1) {
                return;
            }
            int iIntValue = ((Integer) tag).intValue();
            if (iIntValue < this.ud.qdl()) {
                this.ud.qdl(this.qdl.get(view), iIntValue);
            } else {
                this.ud.qdl(this.qdl.get(view), this.ud.qdl());
            }
            qdl(this.ud);
        } catch (Throwable unused) {
        }
    }

    private void qdl(to toVar) {
        if (toVar.ud() != null) {
            qdl(toVar.ud());
        } else {
            toVar.qdl(Float.NaN, Float.NaN);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        qdl(view, false);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        qdl(getChildAt(i), false);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view) {
        qdl(view, true);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            qdl(getChildAt(i3), false);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            qdl(getChildAt(i3), true);
        }
        super.removeViewsInLayout(i, i2);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            qdl(getChildAt(i), false);
        }
        super.removeAllViews();
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            qdl(getChildAt(i), true);
        }
        super.removeAllViewsInLayout();
    }

    private void qdl(View view, boolean z) {
        try {
            to toVar = this.qdl.get(view);
            if (toVar == null) {
                return;
            }
            to toVarUd = toVar.ud();
            int i = 0;
            while (true) {
                if (i >= toVarUd.qdl()) {
                    break;
                }
                if (toVarUd.qdl(i).equals(toVar)) {
                    toVarUd.ud(i);
                    break;
                }
                i++;
            }
            toVar.qdl((Object) null);
            this.qdl.remove(view);
            if (z) {
                this.ud.qdl(Float.NaN, Float.NaN);
            }
        } catch (Throwable unused) {
        }
    }

    private void qdl(to toVar, float f, float f2) {
        View view = (View) toVar.to();
        if (view != null && view != this) {
            if (view.getVisibility() == 8) {
                return;
            }
            int iRound = Math.round(toVar.mo() + f);
            int iRound2 = Math.round(toVar.wd() + f2);
            view.measure(View.MeasureSpec.makeMeasureSpec(Math.round(toVar.jpc()), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.round(toVar.tvp()), 1073741824));
            view.layout(iRound, iRound2, view.getMeasuredWidth() + iRound, view.getMeasuredHeight() + iRound2);
        }
        int iQdl = toVar.qdl();
        for (int i = 0; i < iQdl; i++) {
            if (equals(view)) {
                qdl(toVar.qdl(i), f, f2);
            } else if (!(view instanceof lnr)) {
                qdl(toVar.qdl(i), toVar.mo() + f, toVar.wd() + f2);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mml mmlVar = this.lnr;
        if (mmlVar != null) {
            mmlVar.qdl(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mml mmlVar = this.lnr;
        if (mmlVar != null) {
            mmlVar.ud(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        mml mmlVar = this.lnr;
        if (mmlVar != null) {
            mmlVar.mo();
        }
        if (!(getParent() instanceof lnr)) {
            qdl(View.MeasureSpec.makeMeasureSpec(i3 - i, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - i2, 1073741824));
        }
        qdl(this.ud, 0.0f, 0.0f);
        mml mmlVar2 = this.lnr;
        if (mmlVar2 != null) {
            mmlVar2.qdl(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (!(getParent() instanceof lnr)) {
            qdl(i, i2);
        }
        mml mmlVar = this.lnr;
        if (mmlVar != null) {
            int[] iArrQdl = mmlVar.qdl(i, i2);
            setMeasuredDimension(iArrQdl[0], iArrQdl[1]);
        } else {
            setMeasuredDimension(Math.round(this.ud.jpc()), Math.round(this.ud.tvp()));
        }
        mml mmlVar2 = this.lnr;
        if (mmlVar2 != null) {
            mmlVar2.mzz();
        }
    }

    private void qdl(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == 1073741824) {
            this.ud.mo(size2);
        }
        if (mode == 1073741824) {
            this.ud.mml(size);
        }
        if (mode2 == Integer.MIN_VALUE) {
            this.ud.rq(size2);
        }
        if (mode == Integer.MIN_VALUE) {
            this.ud.to(size);
        }
        this.ud.qdl(Float.NaN, Float.NaN);
    }

    protected static void qdl(qdl qdlVar, to toVar, View view) {
        if (view.getResources().getConfiguration().getLayoutDirection() == 1) {
            toVar.qdl(com.bytedance.adsdk.ugeno.yoga.lnr.RTL);
        }
        Drawable background = view.getBackground();
        if (background != null) {
            if (background.getPadding(new Rect())) {
                toVar.ud(com.bytedance.adsdk.ugeno.yoga.mml.LEFT, r0.left);
                toVar.ud(com.bytedance.adsdk.ugeno.yoga.mml.TOP, r0.top);
                toVar.ud(com.bytedance.adsdk.ugeno.yoga.mml.RIGHT, r0.right);
                toVar.ud(com.bytedance.adsdk.ugeno.yoga.mml.BOTTOM, r0.bottom);
            }
        }
        for (int i = 0; i < qdlVar.qdl.size(); i++) {
            int iKeyAt = qdlVar.qdl.keyAt(i);
            float fFloatValue = qdlVar.qdl.valueAt(i).floatValue();
            if (iKeyAt == 4) {
                toVar.lnr(com.bytedance.adsdk.ugeno.yoga.qdl.qdl(Math.round(fFloatValue)));
            } else if (iKeyAt == 0) {
                toVar.qdl(com.bytedance.adsdk.ugeno.yoga.qdl.qdl(Math.round(fFloatValue)));
            } else if (iKeyAt == 9) {
                toVar.ud(com.bytedance.adsdk.ugeno.yoga.qdl.qdl(Math.round(fFloatValue)));
            } else if (iKeyAt == 25) {
                toVar.fs(fFloatValue);
            } else if (iKeyAt == 8) {
                if (fFloatValue < 0.0f) {
                    toVar.lnr();
                } else {
                    toVar.lnr(fFloatValue);
                }
            } else if (iKeyAt == 1) {
                toVar.qdl(mzz.qdl(Math.round(fFloatValue)));
            } else if (iKeyAt == 6) {
                toVar.qdl(fFloatValue);
            } else if (iKeyAt == 7) {
                toVar.ud(fFloatValue);
            } else if (iKeyAt == 16) {
                if (fFloatValue == -1.0f) {
                    toVar.wd(100.0f);
                } else if (fFloatValue == -2.0f) {
                    toVar.mzz();
                } else {
                    toVar.mo(fFloatValue);
                }
            } else if (iKeyAt == 18) {
                toVar.qdl(com.bytedance.adsdk.ugeno.yoga.mml.LEFT, fFloatValue);
            } else if (iKeyAt == 3) {
                toVar.qdl(mo.qdl(Math.round(fFloatValue)));
            } else if (iKeyAt == 17) {
                toVar.qdl(com.bytedance.adsdk.ugeno.yoga.mml.TOP, fFloatValue);
            } else if (iKeyAt == 20) {
                toVar.qdl(com.bytedance.adsdk.ugeno.yoga.mml.RIGHT, fFloatValue);
            } else if (iKeyAt == 19) {
                toVar.qdl(com.bytedance.adsdk.ugeno.yoga.mml.BOTTOM, fFloatValue);
            } else if (iKeyAt == 28) {
                toVar.tvp(fFloatValue);
            } else if (iKeyAt == 27) {
                toVar.jpc(fFloatValue);
            } else if (iKeyAt == 22) {
                toVar.ud(com.bytedance.adsdk.ugeno.yoga.mml.LEFT, fFloatValue);
            } else if (iKeyAt == 21) {
                toVar.ud(com.bytedance.adsdk.ugeno.yoga.mml.TOP, fFloatValue);
            } else if (iKeyAt == 24) {
                toVar.ud(com.bytedance.adsdk.ugeno.yoga.mml.RIGHT, fFloatValue);
            } else if (iKeyAt == 23) {
                toVar.ud(com.bytedance.adsdk.ugeno.yoga.mml.BOTTOM, fFloatValue);
            } else if (iKeyAt == 11) {
                toVar.lnr(com.bytedance.adsdk.ugeno.yoga.mml.LEFT, fFloatValue);
            } else if (iKeyAt == 10) {
                toVar.lnr(com.bytedance.adsdk.ugeno.yoga.mml.TOP, fFloatValue);
            } else if (iKeyAt == 13) {
                toVar.lnr(com.bytedance.adsdk.ugeno.yoga.mml.RIGHT, fFloatValue);
            } else if (iKeyAt == 12) {
                toVar.lnr(com.bytedance.adsdk.ugeno.yoga.mml.BOTTOM, fFloatValue);
            } else if (iKeyAt == 14) {
                toVar.qdl(exu.qdl(Math.round(fFloatValue)));
            } else if (iKeyAt == 15) {
                if (fFloatValue == -1.0f) {
                    toVar.mzz(100.0f);
                } else if (fFloatValue == -2.0f) {
                    toVar.mml();
                } else {
                    toVar.mml(fFloatValue);
                }
            } else if (iKeyAt == 2) {
                toVar.qdl(rdp.qdl(Math.round(fFloatValue)));
            }
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new qdl(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new qdl(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof qdl;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mml mmlVar = this.lnr;
        if (mmlVar != null) {
            mmlVar.wd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mml mmlVar = this.lnr;
        if (mmlVar != null) {
            mmlVar.jpc();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mml mmlVar = this.lnr;
        if (mmlVar != null) {
            mmlVar.ud(i, i2, i3, i4);
        }
    }

    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
        this.lnr = lnrVar;
    }

    public void setBorderRadius(float f) {
        this.mml.qdl(f);
    }

    public float getBorderRadius() {
        return this.mml.qdl();
    }

    public void setRipple(float f) {
        jpc jpcVar = this.mml;
        if (jpcVar != null) {
            jpcVar.ud(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.wd
    public float getRipple() {
        return this.mml.getRipple();
    }

    public void setShine(float f) {
        jpc jpcVar = this.mml;
        if (jpcVar != null) {
            jpcVar.lnr(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.wd
    public float getShine() {
        return this.mml.getShine();
    }

    public void setStretch(float f) {
        jpc jpcVar = this.mml;
        if (jpcVar != null) {
            jpcVar.mml(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.wd
    public float getStretch() {
        return this.mml.getStretch();
    }

    public void setRubIn(float f) {
        jpc jpcVar = this.mml;
        if (jpcVar != null) {
            jpcVar.mzz(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.wd
    public float getRubIn() {
        return this.mml.getRubIn();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.mml.qdl(i);
    }

    public static class qdl extends ViewGroup.LayoutParams {
        private float bjy;
        private float exc;
        private float exu;
        private float fs;
        private float jl;
        private float jpc;
        private float jtx;
        private float lnr;
        private float mml;
        private float mo;
        private float mzz;
        SparseArray<Float> qdl;
        private float rdp;
        private float rq;
        private float to;
        private float tvp;
        SparseArray<String> ud;
        private float wd;
        private float yt;

        public qdl(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            if (layoutParams instanceof qdl) {
                qdl qdlVar = (qdl) layoutParams;
                this.qdl = qdlVar.qdl.clone();
                this.ud = qdlVar.ud.clone();
                return;
            }
            this.qdl = new SparseArray<>();
            this.ud = new SparseArray<>();
            if (layoutParams.width >= 0) {
                this.qdl.put(15, Float.valueOf(this.width));
            }
            if (layoutParams.height >= 0) {
                this.qdl.put(16, Float.valueOf(this.height));
            }
        }

        public qdl(int i, int i2) {
            super(i, i2);
            this.qdl = new SparseArray<>();
            this.ud = new SparseArray<>();
            if (i == -2 || i == -1 || i >= 0) {
                this.qdl.put(15, Float.valueOf(i));
            }
            if (i2 == -2 || i2 == -1 || i2 >= 0) {
                this.qdl.put(16, Float.valueOf(i2));
            }
        }

        public void qdl(float f) {
            this.wd = f;
            this.qdl.put(5, Float.valueOf(f));
        }

        public void ud(float f) {
            this.jpc = f;
            this.qdl.put(6, Float.valueOf(f));
        }

        public void lnr(float f) {
            this.tvp = f;
            this.qdl.put(7, Float.valueOf(f));
        }

        public void mml(float f) {
            this.to = f;
            this.qdl.put(8, Float.valueOf(f));
        }

        public void mzz(float f) {
            this.rq = f;
            this.qdl.put(9, Float.valueOf(f));
        }

        public void mo(float f) {
            this.fs = f;
            this.qdl.put(14, Float.valueOf(f));
        }

        public void wd(float f) {
            this.exu = f;
            this.qdl.put(10, Float.valueOf(f));
        }

        public void jpc(float f) {
            this.rdp = f;
            this.qdl.put(11, Float.valueOf(f));
        }

        public void tvp(float f) {
            this.bjy = f;
            this.qdl.put(12, Float.valueOf(f));
        }

        public void to(float f) {
            this.jtx = f;
            this.qdl.put(13, Float.valueOf(f));
        }

        public void rq(float f) {
            this.lnr = f;
            this.qdl.put(17, Float.valueOf(f));
        }

        public void fs(float f) {
            this.mml = f;
            this.qdl.put(18, Float.valueOf(f));
        }

        public void exu(float f) {
            this.mzz = f;
            this.qdl.put(19, Float.valueOf(f));
        }

        public void rdp(float f) {
            this.mo = f;
            this.qdl.put(20, Float.valueOf(f));
        }

        public void bjy(float f) {
            this.yt = f;
            this.qdl.put(25, Float.valueOf(f));
        }

        public void jtx(float f) {
            this.jl = f;
            this.qdl.put(27, Float.valueOf(f));
        }

        public void yt(float f) {
            this.exc = f;
            this.qdl.put(28, Float.valueOf(f));
        }
    }

    public static class ud implements com.bytedance.adsdk.ugeno.yoga.wd {
        @Override // com.bytedance.adsdk.ugeno.yoga.wd
        public long qdl(to toVar, float f, com.bytedance.adsdk.ugeno.yoga.jpc jpcVar, float f2, com.bytedance.adsdk.ugeno.yoga.jpc jpcVar2) {
            View view = (View) toVar.to();
            if (view == null || (view instanceof lnr)) {
                return tvp.qdl(0, 0);
            }
            view.measure(View.MeasureSpec.makeMeasureSpec((int) f, qdl(jpcVar)), View.MeasureSpec.makeMeasureSpec((int) f2, qdl(jpcVar2)));
            return tvp.qdl(view.getMeasuredWidth(), view.getMeasuredHeight());
        }

        private int qdl(com.bytedance.adsdk.ugeno.yoga.jpc jpcVar) {
            if (jpcVar == com.bytedance.adsdk.ugeno.yoga.jpc.AT_MOST) {
                return Integer.MIN_VALUE;
            }
            return jpcVar == com.bytedance.adsdk.ugeno.yoga.jpc.EXACTLY ? 1073741824 : 0;
        }
    }
}
