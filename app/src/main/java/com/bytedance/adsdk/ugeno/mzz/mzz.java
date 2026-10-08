package com.bytedance.adsdk.ugeno.mzz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.mzz.mml;
import com.bytedance.adsdk.ugeno.wd.wd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class mzz extends ViewGroup implements com.bytedance.adsdk.ugeno.mzz.qdl {
    private mml bjy;
    private int[] exu;
    private int fs;
    private mml.qdl jl;
    private Drawable jpc;
    private List<lnr> jtx;
    private int lnr;
    private int mml;
    private int mo;
    private int mzz;
    private int qdl;
    private SparseIntArray rdp;
    private int rq;
    private int to;
    private int tvp;
    private int ud;
    private Drawable wd;
    private com.bytedance.adsdk.ugeno.mml yt;

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int qdl(View view) {
        return 0;
    }

    public mzz(Context context) {
        super(context, null);
        this.mo = -1;
        this.bjy = new mml(this);
        this.jtx = new ArrayList();
        this.jl = new mml.qdl();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        com.bytedance.adsdk.ugeno.mml mmlVar = this.yt;
        if (mmlVar != null) {
            int[] iArrQdl = mmlVar.qdl(i, i2);
            qdl(iArrQdl[0], iArrQdl[1]);
        } else {
            qdl(i, i2);
        }
        com.bytedance.adsdk.ugeno.mml mmlVar2 = this.yt;
        if (mmlVar2 != null) {
            mmlVar2.mzz();
        }
    }

    private void qdl(int i, int i2) {
        if (this.rdp == null) {
            this.rdp = new SparseIntArray(getChildCount());
        }
        if (this.bjy.ud(this.rdp)) {
            this.exu = this.bjy.qdl(this.rdp);
        }
        int i3 = this.qdl;
        if (i3 == 0 || i3 == 1) {
            ud(i, i2);
        } else if (i3 == 2 || i3 == 3) {
            lnr(i, i2);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.qdl);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public View qdl(int i) {
        return getChildAt(i);
    }

    public View lnr(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.exu;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public View ud(int i) {
        return lnr(i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.rdp == null) {
            this.rdp = new SparseIntArray(getChildCount());
        }
        this.exu = this.bjy.qdl(view, i, layoutParams, this.rdp);
        super.addView(view, i, layoutParams);
    }

    private void ud(int i, int i2) {
        this.jtx.clear();
        this.jl.qdl();
        this.bjy.qdl(this.jl, i, i2);
        this.jtx = this.jl.qdl;
        this.bjy.qdl(i, i2);
        if (this.mml == 3) {
            for (lnr lnrVar : this.jtx) {
                int iMax = Integer.MIN_VALUE;
                for (int i3 = 0; i3 < lnrVar.jpc; i3++) {
                    View viewLnr = lnr(lnrVar.bjy + i3);
                    if (viewLnr != null && viewLnr.getVisibility() != 8) {
                        qdl qdlVar = (qdl) viewLnr.getLayoutParams();
                        if (this.ud != 2) {
                            iMax = Math.max(iMax, viewLnr.getMeasuredHeight() + Math.max(lnrVar.fs - viewLnr.getBaseline(), qdlVar.topMargin) + qdlVar.bottomMargin);
                        } else {
                            iMax = Math.max(iMax, viewLnr.getMeasuredHeight() + qdlVar.topMargin + Math.max((lnrVar.fs - viewLnr.getMeasuredHeight()) + viewLnr.getBaseline(), qdlVar.bottomMargin));
                        }
                    }
                }
                lnrVar.wd = iMax;
            }
        }
        this.bjy.ud(i, i2, getPaddingTop() + getPaddingBottom());
        this.bjy.qdl();
        qdl(this.qdl, i, i2, this.jl.ud);
    }

    private void lnr(int i, int i2) {
        this.jtx.clear();
        this.jl.qdl();
        this.bjy.ud(this.jl, i, i2);
        this.jtx = this.jl.qdl;
        this.bjy.qdl(i, i2);
        this.bjy.ud(i, i2, getPaddingLeft() + getPaddingRight());
        this.bjy.qdl();
        qdl(this.qdl, i, i2, this.jl.ud);
    }

    private void qdl(int i, int i2, int i3, int i4) {
        int sumOfCrossSize;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else if (i == 2 || i == 3) {
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i)));
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else {
            throw new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i3, i4);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else {
            throw new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int getLargestMainSize() {
        Iterator<lnr> it = this.jtx.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().mzz);
        }
        return iMax;
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int getSumOfCrossSize() {
        int i;
        int i2;
        int size = this.jtx.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            lnr lnrVar = this.jtx.get(i4);
            if (mml(i4)) {
                if (qdl()) {
                    i2 = this.rq;
                } else {
                    i2 = this.fs;
                }
                i3 += i2;
            }
            if (mo(i4)) {
                if (qdl()) {
                    i = this.rq;
                } else {
                    i = this.fs;
                }
                i3 += i;
            }
            i3 += lnrVar.wd;
        }
        return i3;
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public boolean qdl() {
        int i = this.qdl;
        return i == 0 || i == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        com.bytedance.adsdk.ugeno.mml mmlVar = this.yt;
        if (mmlVar != null) {
            mmlVar.mo();
        }
        int iQdl = wd.qdl(this);
        int i5 = this.qdl;
        if (i5 == 0) {
            qdl(iQdl == 1, i, i2, i3, i4);
        } else if (i5 == 1) {
            qdl(iQdl != 1, i, i2, i3, i4);
        } else if (i5 == 2) {
            z2 = iQdl == 1;
            qdl(this.ud == 2 ? !z2 : z2, false, i, i2, i3, i4);
        } else if (i5 == 3) {
            z2 = iQdl == 1;
            qdl(this.ud == 2 ? !z2 : z2, true, i, i2, i3, i4);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.qdl);
        }
        com.bytedance.adsdk.ugeno.mml mmlVar2 = this.yt;
        if (mmlVar2 != null) {
            mmlVar2.qdl(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instruction units count: 556
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.mzz.mzz.qdl(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void qdl(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instruction units count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.mzz.mzz.qdl(boolean, boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.jpc == null && this.wd == null) {
            return;
        }
        if (this.tvp == 0 && this.to == 0) {
            return;
        }
        int iQdl = wd.qdl(this);
        int i = this.qdl;
        if (i == 0) {
            qdl(canvas, iQdl == 1, this.ud == 2);
            return;
        }
        if (i == 1) {
            qdl(canvas, iQdl != 1, this.ud == 2);
            return;
        }
        if (i == 2) {
            boolean z = iQdl == 1;
            if (this.ud == 2) {
                z = !z;
            }
            ud(canvas, z, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z2 = iQdl == 1;
        if (this.ud == 2) {
            z2 = !z2;
        }
        ud(canvas, z2, true);
    }

    private void qdl(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.jtx.size();
        for (int i3 = 0; i3 < size; i3++) {
            lnr lnrVar = this.jtx.get(i3);
            for (int i4 = 0; i4 < lnrVar.jpc; i4++) {
                int i5 = lnrVar.bjy + i4;
                View viewLnr = lnr(i5);
                if (viewLnr != null && viewLnr.getVisibility() != 8) {
                    qdl qdlVar = (qdl) viewLnr.getLayoutParams();
                    if (mml(i5, i4)) {
                        if (z) {
                            left = viewLnr.getRight() + qdlVar.rightMargin;
                        } else {
                            left = (viewLnr.getLeft() - qdlVar.leftMargin) - this.fs;
                        }
                        qdl(canvas, left, lnrVar.ud, lnrVar.wd);
                    }
                    if (i4 == lnrVar.jpc - 1 && (this.to & 4) > 0) {
                        if (z) {
                            right = (viewLnr.getLeft() - qdlVar.leftMargin) - this.fs;
                        } else {
                            right = viewLnr.getRight() + qdlVar.rightMargin;
                        }
                        qdl(canvas, right, lnrVar.ud, lnrVar.wd);
                    }
                }
            }
            if (mml(i3)) {
                if (z2) {
                    i2 = lnrVar.mml;
                } else {
                    i2 = lnrVar.ud - this.rq;
                }
                ud(canvas, paddingLeft, i2, iMax);
            }
            if (mo(i3) && (this.tvp & 4) > 0) {
                if (z2) {
                    i = lnrVar.ud - this.rq;
                } else {
                    i = lnrVar.mml;
                }
                ud(canvas, paddingLeft, i, iMax);
            }
        }
    }

    private void ud(Canvas canvas, boolean z, boolean z2) {
        int i;
        int i2;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.jtx.size();
        for (int i3 = 0; i3 < size; i3++) {
            lnr lnrVar = this.jtx.get(i3);
            for (int i4 = 0; i4 < lnrVar.jpc; i4++) {
                int i5 = lnrVar.bjy + i4;
                View viewLnr = lnr(i5);
                if (viewLnr != null && viewLnr.getVisibility() != 8) {
                    qdl qdlVar = (qdl) viewLnr.getLayoutParams();
                    if (mml(i5, i4)) {
                        if (z2) {
                            top = viewLnr.getBottom() + qdlVar.bottomMargin;
                        } else {
                            top = (viewLnr.getTop() - qdlVar.topMargin) - this.rq;
                        }
                        ud(canvas, lnrVar.qdl, top, lnrVar.wd);
                    }
                    if (i4 == lnrVar.jpc - 1 && (this.tvp & 4) > 0) {
                        if (z2) {
                            bottom = (viewLnr.getTop() - qdlVar.topMargin) - this.rq;
                        } else {
                            bottom = viewLnr.getBottom() + qdlVar.bottomMargin;
                        }
                        ud(canvas, lnrVar.qdl, bottom, lnrVar.wd);
                    }
                }
            }
            if (mml(i3)) {
                if (z) {
                    i2 = lnrVar.lnr;
                } else {
                    i2 = lnrVar.qdl - this.fs;
                }
                qdl(canvas, i2, paddingTop, iMax);
            }
            if (mo(i3) && (this.to & 4) > 0) {
                if (z) {
                    i = lnrVar.qdl - this.fs;
                } else {
                    i = lnrVar.lnr;
                }
                qdl(canvas, i, paddingTop, iMax);
            }
        }
    }

    private void qdl(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.jpc;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.fs + i, i3 + i2);
        this.jpc.draw(canvas);
    }

    private void ud(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.wd;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.rq + i2);
        this.wd.draw(canvas);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof qdl;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof qdl) {
            return new qdl((qdl) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new qdl((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new qdl(layoutParams);
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int getFlexDirection() {
        return this.qdl;
    }

    public void setFlexDirection(int i) {
        if (this.qdl != i) {
            this.qdl = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int getFlexWrap() {
        return this.ud;
    }

    public void setFlexWrap(int i) {
        if (this.ud != i) {
            this.ud = i;
            requestLayout();
        }
    }

    public int getJustifyContent() {
        return this.lnr;
    }

    public void setJustifyContent(int i) {
        if (this.lnr != i) {
            this.lnr = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int getAlignItems() {
        return this.mml;
    }

    public void setAlignItems(int i) {
        if (this.mml != i) {
            this.mml = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int getAlignContent() {
        return this.mzz;
    }

    public void setAlignContent(int i) {
        if (this.mzz != i) {
            this.mzz = i;
            requestLayout();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int getMaxLine() {
        return this.mo;
    }

    public void setMaxLine(int i) {
        if (this.mo != i) {
            this.mo = i;
            requestLayout();
        }
    }

    public List<lnr> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.jtx.size());
        for (lnr lnrVar : this.jtx) {
            if (lnrVar.ud() != 0) {
                arrayList.add(lnrVar);
            }
        }
        return arrayList;
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int qdl(View view, int i, int i2) {
        int i3;
        int i4;
        if (qdl()) {
            i3 = mml(i, i2) ? this.fs : 0;
            if ((this.to & 4) <= 0) {
                return i3;
            }
            i4 = this.fs;
        } else {
            i3 = mml(i, i2) ? this.rq : 0;
            if ((this.tvp & 4) <= 0) {
                return i3;
            }
            i4 = this.rq;
        }
        return i3 + i4;
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public void qdl(lnr lnrVar) {
        if (qdl()) {
            if ((this.to & 4) > 0) {
                lnrVar.mzz += this.fs;
                lnrVar.mo += this.fs;
                return;
            }
            return;
        }
        if ((this.tvp & 4) > 0) {
            lnrVar.mzz += this.rq;
            lnrVar.mo += this.rq;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int qdl(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public int ud(int i, int i2, int i3) {
        return getChildMeasureSpec(i, i2, i3);
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public void qdl(View view, int i, int i2, lnr lnrVar) {
        if (mml(i, i2)) {
            if (qdl()) {
                lnrVar.mzz += this.fs;
                lnrVar.mo += this.fs;
            } else {
                lnrVar.mzz += this.rq;
                lnrVar.mo += this.rq;
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public void setFlexLines(List<lnr> list) {
        this.jtx = list;
    }

    @Override // com.bytedance.adsdk.ugeno.mzz.qdl
    public List<lnr> getFlexLinesInternal() {
        return this.jtx;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.wd;
    }

    public Drawable getDividerDrawableVertical() {
        return this.jpc;
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.wd) {
            return;
        }
        this.wd = drawable;
        if (drawable != null) {
            this.rq = drawable.getIntrinsicHeight();
        } else {
            this.rq = 0;
        }
        ud();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.jpc) {
            return;
        }
        this.jpc = drawable;
        if (drawable != null) {
            this.fs = drawable.getIntrinsicWidth();
        } else {
            this.fs = 0;
        }
        ud();
        requestLayout();
    }

    public int getShowDividerVertical() {
        return this.to;
    }

    public int getShowDividerHorizontal() {
        return this.tvp;
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerVertical(int i) {
        if (i != this.to) {
            this.to = i;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.tvp) {
            this.tvp = i;
            requestLayout();
        }
    }

    private void ud() {
        if (this.wd == null && this.jpc == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean mml(int i, int i2) {
        return mzz(i, i2) ? qdl() ? (this.to & 1) != 0 : (this.tvp & 1) != 0 : qdl() ? (this.to & 2) != 0 : (this.tvp & 2) != 0;
    }

    private boolean mzz(int i, int i2) {
        for (int i3 = 1; i3 <= i2; i3++) {
            View viewLnr = lnr(i - i3);
            if (viewLnr != null && viewLnr.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean mml(int i) {
        if (i >= 0 && i < this.jtx.size()) {
            if (mzz(i)) {
                return qdl() ? (this.tvp & 1) != 0 : (this.to & 1) != 0;
            }
            if (qdl()) {
                return (this.tvp & 2) != 0;
            }
            if ((this.to & 2) != 0) {
                return true;
            }
        }
        return false;
    }

    private boolean mzz(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (this.jtx.get(i2).ud() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean mo(int i) {
        if (i >= 0 && i < this.jtx.size()) {
            for (int i2 = i + 1; i2 < this.jtx.size(); i2++) {
                if (this.jtx.get(i2).ud() > 0) {
                    return false;
                }
            }
            if (qdl()) {
                return (this.tvp & 4) != 0;
            }
            if ((this.to & 4) != 0) {
                return true;
            }
        }
        return false;
    }

    public static class qdl extends ViewGroup.MarginLayoutParams implements ud {
        public static final Parcelable.Creator<qdl> CREATOR = new Parcelable.Creator<qdl>() { // from class: com.bytedance.adsdk.ugeno.mzz.mzz.qdl.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public qdl createFromParcel(Parcel parcel) {
                return new qdl(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public qdl[] newArray(int i) {
                return new qdl[i];
            }
        };
        private int jpc;
        private float lnr;
        private int mml;
        private int mo;
        private float mzz;
        private int qdl;
        private boolean to;
        private int tvp;
        private float ud;
        private int wd;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public qdl(qdl qdlVar) {
            super((ViewGroup.MarginLayoutParams) qdlVar);
            this.qdl = 1;
            this.ud = 0.0f;
            this.lnr = 0.0f;
            this.mml = -1;
            this.mzz = -1.0f;
            this.mo = -1;
            this.wd = -1;
            this.jpc = ViewCompat.MEASURED_SIZE_MASK;
            this.tvp = ViewCompat.MEASURED_SIZE_MASK;
            this.qdl = qdlVar.qdl;
            this.ud = qdlVar.ud;
            this.lnr = qdlVar.lnr;
            this.mml = qdlVar.mml;
            this.mzz = qdlVar.mzz;
            this.mo = qdlVar.mo;
            this.wd = qdlVar.wd;
            this.jpc = qdlVar.jpc;
            this.tvp = qdlVar.tvp;
            this.to = qdlVar.to;
        }

        public qdl(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.qdl = 1;
            this.ud = 0.0f;
            this.lnr = 0.0f;
            this.mml = -1;
            this.mzz = -1.0f;
            this.mo = -1;
            this.wd = -1;
            this.jpc = ViewCompat.MEASURED_SIZE_MASK;
            this.tvp = ViewCompat.MEASURED_SIZE_MASK;
        }

        public qdl(int i, int i2) {
            super(new ViewGroup.LayoutParams(i, i2));
            this.qdl = 1;
            this.ud = 0.0f;
            this.lnr = 0.0f;
            this.mml = -1;
            this.mzz = -1.0f;
            this.mo = -1;
            this.wd = -1;
            this.jpc = ViewCompat.MEASURED_SIZE_MASK;
            this.tvp = ViewCompat.MEASURED_SIZE_MASK;
        }

        public qdl(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.qdl = 1;
            this.ud = 0.0f;
            this.lnr = 0.0f;
            this.mml = -1;
            this.mzz = -1.0f;
            this.mo = -1;
            this.wd = -1;
            this.jpc = ViewCompat.MEASURED_SIZE_MASK;
            this.tvp = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int qdl() {
            return this.width;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int ud() {
            return this.height;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int lnr() {
            return this.qdl;
        }

        public void lnr(int i) {
            this.qdl = i;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public float mml() {
            return this.ud;
        }

        public void qdl(float f) {
            this.ud = f;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public float mzz() {
            return this.lnr;
        }

        public void ud(float f) {
            this.lnr = f;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int mo() {
            return this.mml;
        }

        public void mml(int i) {
            this.mml = i;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int wd() {
            return this.mo;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public void qdl(int i) {
            this.mo = i;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int jpc() {
            return this.wd;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public void ud(int i) {
            this.wd = i;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int tvp() {
            return this.jpc;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int to() {
            return this.tvp;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public boolean rq() {
            return this.to;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public float fs() {
            return this.mzz;
        }

        public void lnr(float f) {
            this.mzz = f;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int exu() {
            return this.leftMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int rdp() {
            return this.topMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int bjy() {
            return this.rightMargin;
        }

        @Override // com.bytedance.adsdk.ugeno.mzz.ud
        public int jtx() {
            return this.bottomMargin;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.qdl);
            parcel.writeFloat(this.ud);
            parcel.writeFloat(this.lnr);
            parcel.writeInt(this.mml);
            parcel.writeFloat(this.mzz);
            parcel.writeInt(this.mo);
            parcel.writeInt(this.wd);
            parcel.writeInt(this.jpc);
            parcel.writeInt(this.tvp);
            parcel.writeByte(this.to ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
        }

        protected qdl(Parcel parcel) {
            super(0, 0);
            this.qdl = 1;
            this.ud = 0.0f;
            this.lnr = 0.0f;
            this.mml = -1;
            this.mzz = -1.0f;
            this.mo = -1;
            this.wd = -1;
            this.jpc = ViewCompat.MEASURED_SIZE_MASK;
            this.tvp = ViewCompat.MEASURED_SIZE_MASK;
            this.qdl = parcel.readInt();
            this.ud = parcel.readFloat();
            this.lnr = parcel.readFloat();
            this.mml = parcel.readInt();
            this.mzz = parcel.readFloat();
            this.mo = parcel.readInt();
            this.wd = parcel.readInt();
            this.jpc = parcel.readInt();
            this.tvp = parcel.readInt();
            this.to = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
        }
    }

    public void qdl(com.bytedance.adsdk.ugeno.ud.lnr lnrVar) {
        this.yt = lnrVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.adsdk.ugeno.mml mmlVar = this.yt;
        if (mmlVar != null) {
            mmlVar.wd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.adsdk.ugeno.mml mmlVar = this.yt;
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
        com.bytedance.adsdk.ugeno.mml mmlVar = this.yt;
        if (mmlVar != null) {
            mmlVar.ud(i, i2, i3, i4);
        }
    }
}
