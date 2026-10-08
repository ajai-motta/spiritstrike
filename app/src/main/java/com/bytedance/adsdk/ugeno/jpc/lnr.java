package com.bytedance.adsdk.ugeno.jpc;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class lnr extends ViewGroup {
    private float aaj;
    private int ag;
    private VelocityTracker ax;
    private boolean bch;
    private mo bjy;
    private int bqt;
    private List<Object> car;
    private int cx;
    private int dk;
    private int ekw;
    private final Runnable en;
    private int exc;
    private Scroller exu;
    private float fco;
    private ClassLoader fs;
    private EdgeEffect gt;
    private int gy;
    private float hkc;
    private float hzv;
    private ArrayList<View> ijp;
    private boolean irn;
    private boolean jjk;
    private int jl;
    private final ud jpc;
    private int jtx;
    private float jyq;
    private int kdv;
    private boolean koa;
    private int ljh;
    com.bytedance.adsdk.ugeno.jpc.ud lnr;
    private int lte;
    private mzz mlb;
    int mml;
    private float mrf;
    private int nz;
    private int om;
    private int oth;
    private int qdl;
    private int rc;
    private boolean rdp;
    private Parcelable rq;
    private mml sy;
    private List<mml> taz;
    private mml tid;
    private int to;
    private final Rect tvp;
    private boolean uw;
    private boolean vu;
    private EdgeEffect wak;
    private int wc;
    private final ArrayList<ud> wd;
    private boolean xi;
    private boolean xmv;
    private boolean yh;
    private Drawable yt;
    private int zlt;
    static final int[] ud = {R.attr.layout_gravity};
    private static final Comparator<ud> mzz = new Comparator<ud>() { // from class: com.bytedance.adsdk.ugeno.jpc.lnr.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public int compare(ud udVar, ud udVar2) {
            return udVar.ud - udVar2.ud;
        }
    };
    private static final Interpolator mo = new Interpolator() { // from class: com.bytedance.adsdk.ugeno.jpc.lnr.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private static final jpc zy = new jpc();

    public interface mml {
        void fs(int i);

        void qdl(int i, float f, int i2);

        void rq(int i);
    }

    public interface mzz {
        void qdl(View view, float f);
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface qdl {
    }

    static class ud {
        boolean lnr;
        float mml;
        float mzz;
        Object qdl;
        int ud;

        ud() {
        }
    }

    public lnr(Context context) {
        super(context);
        this.wd = new ArrayList<>();
        this.jpc = new ud();
        this.tvp = new Rect();
        this.to = -1;
        this.rq = null;
        this.fs = null;
        this.aaj = -3.4028235E38f;
        this.jyq = Float.MAX_VALUE;
        this.bqt = 1;
        this.gy = -1;
        this.irn = true;
        this.xi = false;
        this.en = new Runnable() { // from class: com.bytedance.adsdk.ugeno.jpc.lnr.3
            @Override // java.lang.Runnable
            public void run() {
                lnr.this.setScrollState(0);
                lnr.this.lnr();
            }
        };
        this.nz = 0;
        qdl();
    }

    void qdl() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.exu = new Scroller(context, mo);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.ekw = viewConfiguration.getScaledPagingTouchSlop();
        this.ag = (int) (400.0f * f);
        this.wc = viewConfiguration.getScaledMaximumFlingVelocity();
        this.wak = new EdgeEffect(context);
        this.gt = new EdgeEffect(context);
        this.om = (int) (25.0f * f);
        this.cx = (int) (2.0f * f);
        this.rc = (int) (f * 16.0f);
    }

    public void setScroller(Scroller scroller) {
        this.exu = scroller;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.en);
        Scroller scroller = this.exu;
        if (scroller != null && !scroller.isFinished()) {
            this.exu.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.nz == i) {
            return;
        }
        this.nz = i;
        if (this.mlb != null) {
            ud(i != 0);
        }
        mo(i);
    }

    public void setAdapter(com.bytedance.adsdk.ugeno.jpc.ud udVar) {
        com.bytedance.adsdk.ugeno.jpc.ud udVar2 = this.lnr;
        if (udVar2 != null) {
            udVar2.qdl((DataSetObserver) null);
            for (int i = 0; i < this.wd.size(); i++) {
                ud udVar3 = this.wd.get(i);
                this.lnr.qdl((ViewGroup) this, udVar3.ud, udVar3.qdl);
            }
            this.wd.clear();
            mo();
            this.mml = 0;
            scrollTo(0, 0);
        }
        this.lnr = udVar;
        this.qdl = 0;
        if (udVar != null) {
            if (this.bjy == null) {
                this.bjy = new mo();
            }
            this.lnr.qdl((DataSetObserver) this.bjy);
            this.xmv = false;
            boolean z = this.irn;
            this.irn = true;
            this.qdl = this.lnr.qdl();
            int i2 = this.to;
            if (i2 >= 0) {
                qdl(i2, false, true);
                this.to = -1;
                this.rq = null;
                this.fs = null;
            } else if (!z) {
                lnr();
            } else {
                requestLayout();
            }
        }
        List<Object> list = this.car;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.car.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.car.get(i3);
        }
    }

    private void mo() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0182lnr) getChildAt(i).getLayoutParams()).qdl) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public com.bytedance.adsdk.ugeno.jpc.ud getAdapter() {
        return this.lnr;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.xmv = false;
        qdl(i, !this.irn, false);
    }

    public void qdl(int i, boolean z) {
        this.xmv = false;
        qdl(i, z, false);
    }

    public int getCurrentItem() {
        return this.mml;
    }

    void qdl(int i, boolean z, boolean z2) {
        qdl(i, z, z2, 0);
    }

    void qdl(int i, boolean z, boolean z2, int i2) {
        com.bytedance.adsdk.ugeno.jpc.ud udVar = this.lnr;
        if (udVar == null || udVar.qdl() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.mml == i && this.wd.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.lnr.qdl()) {
            i = this.lnr.qdl() - 1;
        }
        int i3 = this.bqt;
        int i4 = this.mml;
        if (i > i4 + i3 || i < i4 - i3) {
            for (int i5 = 0; i5 < this.wd.size(); i5++) {
                this.wd.get(i5).lnr = true;
            }
        }
        boolean z3 = this.mml != i;
        if (this.irn) {
            this.mml = i;
            if (z3) {
                mzz(i);
            }
            requestLayout();
            return;
        }
        qdl(i);
        qdl(i, z, i2, z3);
    }

    private void qdl(int i, boolean z, int i2, boolean z2) {
        ud udVarUd = ud(i);
        int clientWidth = udVarUd != null ? (int) (getClientWidth() * Math.max(this.aaj, Math.min(udVarUd.mzz, this.jyq))) : 0;
        if (z) {
            qdl(clientWidth, 0, i2);
            if (z2) {
                mzz(i);
                return;
            }
            return;
        }
        if (z2) {
            mzz(i);
        }
        qdl(false);
        scrollTo(clientWidth, 0);
        mml(clientWidth);
    }

    @Deprecated
    public void setOnPageChangeListener(mml mmlVar) {
        this.tid = mmlVar;
    }

    public void qdl(mml mmlVar) {
        if (this.taz == null) {
            this.taz = new ArrayList();
        }
        this.taz.add(mmlVar);
    }

    public void ud(mml mmlVar) {
        List<mml> list = this.taz;
        if (list != null) {
            list.remove(mmlVar);
        }
    }

    public void qdl(boolean z, mzz mzzVar) {
        qdl(z, mzzVar, 2);
    }

    public void qdl(boolean z, mzz mzzVar, int i) {
        boolean z2 = mzzVar != null;
        boolean z3 = z2 != (this.mlb != null);
        this.mlb = mzzVar;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.dk = z ? 2 : 1;
            this.lte = i;
        } else {
            this.dk = 0;
        }
        if (z3) {
            lnr();
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.dk == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0182lnr) this.ijp.get(i2).getLayoutParams()).mo;
    }

    public int getOffscreenPageLimit() {
        return this.bqt;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.bqt) {
            this.bqt = i;
            lnr();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.jtx;
        this.jtx = i;
        int width = getWidth();
        qdl(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.jtx;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.yt = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.yt;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.yt;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    float qdl(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    void qdl(int i, int i2, int i3) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        Scroller scroller = this.exu;
        if (scroller != null && !scroller.isFinished()) {
            scrollX = this.rdp ? this.exu.getCurrX() : this.exu.getStartX();
            this.exu.abortAnimation();
            setScrollingCacheEnabled(false);
        } else {
            scrollX = getScrollX();
        }
        int i4 = scrollX;
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            qdl(false);
            lnr();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i7 = clientWidth / 2;
        float f = clientWidth;
        float f2 = i7;
        float fQdl = f2 + (qdl(Math.min(1.0f, (Math.abs(i5) * 1.0f) / f)) * f2);
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fQdl / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i5) / ((f * this.lnr.qdl(this.mml)) + this.jtx)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.rdp = false;
        this.exu.startScroll(i4, scrollY, i5, i6, iMin);
        postInvalidateOnAnimation();
    }

    ud qdl(int i, int i2) {
        ud udVar = new ud();
        udVar.ud = i;
        udVar.qdl = this.lnr.qdl((ViewGroup) this, i);
        udVar.mml = this.lnr.qdl(i);
        if (i2 < 0 || i2 >= this.wd.size()) {
            this.wd.add(udVar);
        } else {
            this.wd.add(i2, udVar);
        }
        return udVar;
    }

    void ud() {
        int iQdl = this.lnr.qdl();
        this.qdl = iQdl;
        boolean z = this.wd.size() < (this.bqt * 2) + 1 && this.wd.size() < iQdl;
        int iMax = this.mml;
        int i = 0;
        while (i < this.wd.size()) {
            ud udVar = this.wd.get(i);
            int iQdl2 = this.lnr.qdl(udVar.qdl);
            if (iQdl2 != -1) {
                if (iQdl2 == -2) {
                    this.wd.remove(i);
                    i--;
                    this.lnr.qdl((ViewGroup) this, udVar.ud, udVar.qdl);
                    if (this.mml == udVar.ud) {
                        iMax = Math.max(0, Math.min(this.mml, iQdl - 1));
                    }
                } else if (udVar.ud != iQdl2) {
                    if (udVar.ud == this.mml) {
                        iMax = iQdl2;
                    }
                    udVar.ud = iQdl2;
                }
                z = true;
            }
            i++;
        }
        Collections.sort(this.wd, mzz);
        if (z) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                C0182lnr c0182lnr = (C0182lnr) getChildAt(i2).getLayoutParams();
                if (!c0182lnr.qdl) {
                    c0182lnr.lnr = 0.0f;
                }
            }
            qdl(iMax, false, true);
            requestLayout();
        }
    }

    void lnr() {
        qdl(this.mml);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0065, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f5 A[PHI: r7 r10 r15
  0x00f5: PHI (r7v6 int) = (r7v5 int), (r7v4 int), (r7v9 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
  0x00f5: PHI (r10v9 int) = (r10v1 int), (r10v8 int), (r10v12 int) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]
  0x00f5: PHI (r15v7 float) = (r15v5 float), (r15v6 float), (r15v4 float) binds: [B:62:0x00ea, B:59:0x00d4, B:53:0x00be] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void qdl(int r18) {
        /*
            Method dump skipped, instruction units count: 593
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.jpc.lnr.qdl(int):void");
    }

    private void wd() {
        if (this.dk != 0) {
            ArrayList<View> arrayList = this.ijp;
            if (arrayList == null) {
                this.ijp = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ijp.add(getChildAt(i));
            }
            Collections.sort(this.ijp, zy);
        }
    }

    private void qdl(ud udVar, int i, ud udVar2) {
        ud udVar3;
        ud udVar4;
        int iQdl = this.lnr.qdl();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.jtx / clientWidth : 0.0f;
        if (udVar2 != null) {
            int i2 = udVar2.ud;
            if (i2 < udVar.ud) {
                float fQdl = udVar2.mzz + udVar2.mml + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= udVar.ud && i4 < this.wd.size()) {
                    ud udVar5 = this.wd.get(i4);
                    while (true) {
                        udVar4 = udVar5;
                        if (i3 <= udVar4.ud || i4 >= this.wd.size() - 1) {
                            break;
                        }
                        i4++;
                        udVar5 = this.wd.get(i4);
                    }
                    while (i3 < udVar4.ud) {
                        fQdl += this.lnr.qdl(i3) + f;
                        i3++;
                    }
                    udVar4.mzz = fQdl;
                    fQdl += udVar4.mml + f;
                    i3++;
                }
            } else if (i2 > udVar.ud) {
                int size = this.wd.size() - 1;
                float fQdl2 = udVar2.mzz;
                while (true) {
                    i2--;
                    if (i2 < udVar.ud || size < 0) {
                        break;
                    }
                    ud udVar6 = this.wd.get(size);
                    while (true) {
                        udVar3 = udVar6;
                        if (i2 >= udVar3.ud || size <= 0) {
                            break;
                        }
                        size--;
                        udVar6 = this.wd.get(size);
                    }
                    while (i2 > udVar3.ud) {
                        fQdl2 -= this.lnr.qdl(i2) + f;
                        i2--;
                    }
                    fQdl2 -= udVar3.mml + f;
                    udVar3.mzz = fQdl2;
                }
            }
        }
        int size2 = this.wd.size();
        float fQdl3 = udVar.mzz;
        int i5 = udVar.ud - 1;
        this.aaj = udVar.ud == 0 ? udVar.mzz : -3.4028235E38f;
        int i6 = iQdl - 1;
        this.jyq = udVar.ud == i6 ? (udVar.mzz + udVar.mml) - 1.0f : Float.MAX_VALUE;
        int i7 = i - 1;
        while (i7 >= 0) {
            ud udVar7 = this.wd.get(i7);
            while (i5 > udVar7.ud) {
                fQdl3 -= this.lnr.qdl(i5) + f;
                i5--;
            }
            fQdl3 -= udVar7.mml + f;
            udVar7.mzz = fQdl3;
            if (udVar7.ud == 0) {
                this.aaj = fQdl3;
            }
            i7--;
            i5--;
        }
        float fQdl4 = udVar.mzz + udVar.mml + f;
        int i8 = udVar.ud + 1;
        int i9 = i + 1;
        while (i9 < size2) {
            ud udVar8 = this.wd.get(i9);
            while (i8 < udVar8.ud) {
                fQdl4 += this.lnr.qdl(i8) + f;
                i8++;
            }
            if (udVar8.ud == i6) {
                this.jyq = (udVar8.mml + fQdl4) - 1.0f;
            }
            udVar8.mzz = fQdl4;
            fQdl4 += udVar8.mml + f;
            i9++;
            i8++;
        }
        this.xi = false;
    }

    public static class wd extends com.bytedance.adsdk.ugeno.jpc.qdl {
        public static final Parcelable.Creator<wd> CREATOR = new Parcelable.ClassLoaderCreator<wd>() { // from class: com.bytedance.adsdk.ugeno.jpc.lnr.wd.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public wd createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new wd(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public wd createFromParcel(Parcel parcel) {
                return new wd(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
            public wd[] newArray(int i) {
                return new wd[i];
            }
        };
        Parcelable lnr;
        ClassLoader mml;
        int ud;

        public wd(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // com.bytedance.adsdk.ugeno.jpc.qdl, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.ud);
            parcel.writeParcelable(this.lnr, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.ud + "}";
        }

        wd(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.ud = parcel.readInt();
            this.lnr = parcel.readParcelable(classLoader);
            this.mml = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        wd wdVar = new wd(super.onSaveInstanceState());
        wdVar.ud = this.mml;
        com.bytedance.adsdk.ugeno.jpc.ud udVar = this.lnr;
        if (udVar != null) {
            wdVar.lnr = udVar.ud();
        }
        return wdVar;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof wd)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        wd wdVar = (wd) parcelable;
        super.onRestoreInstanceState(wdVar.qdl());
        if (this.lnr != null) {
            qdl(wdVar.ud, false, true);
            return;
        }
        this.to = wdVar.ud;
        this.rq = wdVar.lnr;
        this.fs = wdVar.mml;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        C0182lnr c0182lnr = (C0182lnr) layoutParams;
        c0182lnr.qdl |= lnr(view);
        if (this.bch) {
            if (c0182lnr != null && c0182lnr.qdl) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            c0182lnr.mml = true;
            addViewInLayout(view, i, layoutParams);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private static boolean lnr(View view) {
        return view.getClass().getAnnotation(qdl.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.bch) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    ud qdl(View view) {
        for (int i = 0; i < this.wd.size(); i++) {
            ud udVar = this.wd.get(i);
            if (this.lnr.qdl(view, udVar.qdl)) {
                return udVar;
            }
        }
        return null;
    }

    ud ud(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } else {
                return qdl(view);
            }
        }
    }

    ud ud(int i) {
        for (int i2 = 0; i2 < this.wd.size(); i2++) {
            ud udVar = this.wd.get(i2);
            if (udVar.ud == i) {
                return udVar;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.irn = true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        C0182lnr c0182lnr;
        C0182lnr c0182lnr2;
        int i3;
        int i4;
        int i5;
        boolean z = false;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.kdv = Math.min(measuredWidth / 10, this.rc);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i6 = 0;
        while (true) {
            boolean z2 = true;
            int i7 = 1073741824;
            if (i6 >= childCount) {
                break;
            }
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8 && (c0182lnr2 = (C0182lnr) childAt.getLayoutParams()) != null && c0182lnr2.qdl) {
                int i8 = c0182lnr2.ud & 7;
                int i9 = c0182lnr2.ud & 112;
                boolean z3 = (i9 == 48 || i9 == 80) ? true : z;
                if (i8 != 3 && i8 != 5) {
                    z2 = z;
                }
                int i10 = Integer.MIN_VALUE;
                if (z3) {
                    i3 = Integer.MIN_VALUE;
                    i10 = 1073741824;
                } else {
                    i3 = z2 ? 1073741824 : Integer.MIN_VALUE;
                }
                if (c0182lnr2.width != -2) {
                    i4 = c0182lnr2.width != -1 ? c0182lnr2.width : paddingLeft;
                    i10 = 1073741824;
                } else {
                    i4 = paddingLeft;
                }
                if (c0182lnr2.height != -2) {
                    i5 = c0182lnr2.height != -1 ? c0182lnr2.height : measuredHeight;
                } else {
                    i5 = measuredHeight;
                    i7 = i3;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i4, i10), View.MeasureSpec.makeMeasureSpec(i5, i7));
                if (z3) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z2) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i6++;
            z = false;
        }
        this.oth = View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.ljh = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.bch = true;
        lnr();
        this.bch = false;
        int childCount2 = getChildCount();
        for (int i11 = 0; i11 < childCount2; i11++) {
            View childAt2 = getChildAt(i11);
            if (childAt2.getVisibility() != 8 && ((c0182lnr = (C0182lnr) childAt2.getLayoutParams()) == null || !c0182lnr.qdl)) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * c0182lnr.lnr), 1073741824), this.ljh);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            int i5 = this.jtx;
            qdl(i, i3, i5, i5);
        }
    }

    private void qdl(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.wd.isEmpty()) {
            if (!this.exu.isFinished()) {
                this.exu.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)) * (((i - getPaddingLeft()) - getPaddingRight()) + i3)), getScrollY());
                return;
            }
        }
        ud udVarUd = ud(this.mml);
        int iMin = (int) ((udVarUd != null ? Math.min(udVarUd.mzz, this.jyq) : 0.0f) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            qdl(false);
            scrollTo(iMin, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.jpc.lnr.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void computeScroll() {
        this.rdp = true;
        if (!this.exu.isFinished() && this.exu.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.exu.getCurrX();
            int currY = this.exu.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!mml(currX)) {
                    this.exu.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            postInvalidateOnAnimation();
            return;
        }
        qdl(true);
    }

    private boolean mml(int i) {
        if (this.wd.size() == 0) {
            if (this.irn) {
                return false;
            }
            this.jjk = false;
            qdl(0, 0.0f, 0);
            if (this.jjk) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ud udVarTvp = tvp();
        int clientWidth = getClientWidth();
        int i2 = this.jtx;
        int i3 = clientWidth + i2;
        float f = clientWidth;
        int i4 = udVarTvp.ud;
        float f2 = ((i / f) - udVarTvp.mzz) / (udVarTvp.mml + (i2 / f));
        this.jjk = false;
        qdl(i4, f2, (int) (i3 * f2));
        if (this.jjk) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void qdl(int r13, float r14, int r15) {
        /*
            r12 = this;
            int r0 = r12.zlt
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L6a
            int r0 = r12.getScrollX()
            int r3 = r12.getPaddingLeft()
            int r4 = r12.getPaddingRight()
            int r5 = r12.getWidth()
            int r6 = r12.getChildCount()
            r7 = r1
        L1b:
            if (r7 >= r6) goto L6a
            android.view.View r8 = r12.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r9 = r8.getLayoutParams()
            com.bytedance.adsdk.ugeno.jpc.lnr$lnr r9 = (com.bytedance.adsdk.ugeno.jpc.lnr.C0182lnr) r9
            boolean r10 = r9.qdl
            if (r10 == 0) goto L67
            int r9 = r9.ud
            r9 = r9 & 7
            if (r9 == r2) goto L4c
            r10 = 3
            if (r9 == r10) goto L46
            r10 = 5
            if (r9 == r10) goto L39
            r9 = r3
            goto L5b
        L39:
            int r9 = r5 - r4
            int r10 = r8.getMeasuredWidth()
            int r9 = r9 - r10
            int r10 = r8.getMeasuredWidth()
            int r4 = r4 + r10
            goto L58
        L46:
            int r9 = r8.getWidth()
            int r9 = r9 + r3
            goto L5b
        L4c:
            int r9 = r8.getMeasuredWidth()
            int r9 = r5 - r9
            int r9 = r9 / 2
            int r9 = java.lang.Math.max(r9, r3)
        L58:
            r11 = r9
            r9 = r3
            r3 = r11
        L5b:
            int r3 = r3 + r0
            int r10 = r8.getLeft()
            int r3 = r3 - r10
            if (r3 == 0) goto L66
            r8.offsetLeftAndRight(r3)
        L66:
            r3 = r9
        L67:
            int r7 = r7 + 1
            goto L1b
        L6a:
            r12.ud(r13, r14, r15)
            com.bytedance.adsdk.ugeno.jpc.lnr$mzz r13 = r12.mlb
            if (r13 == 0) goto L9d
            int r13 = r12.getScrollX()
            int r14 = r12.getChildCount()
        L79:
            if (r1 >= r14) goto L9d
            android.view.View r15 = r12.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r0 = r15.getLayoutParams()
            com.bytedance.adsdk.ugeno.jpc.lnr$lnr r0 = (com.bytedance.adsdk.ugeno.jpc.lnr.C0182lnr) r0
            boolean r0 = r0.qdl
            if (r0 != 0) goto L9a
            int r0 = r15.getLeft()
            int r0 = r0 - r13
            float r0 = (float) r0
            int r3 = r12.getClientWidth()
            float r3 = (float) r3
            float r0 = r0 / r3
            com.bytedance.adsdk.ugeno.jpc.lnr$mzz r3 = r12.mlb
            r3.qdl(r15, r0)
        L9a:
            int r1 = r1 + 1
            goto L79
        L9d:
            r12.jjk = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.jpc.lnr.qdl(int, float, int):void");
    }

    private void ud(int i, float f, int i2) {
        mml mmlVar = this.tid;
        if (mmlVar != null) {
            mmlVar.qdl(i, f, i2);
        }
        List<mml> list = this.taz;
        if (list != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                mml mmlVar2 = this.taz.get(i3);
                if (mmlVar2 != null) {
                    mmlVar2.qdl(i, f, i2);
                }
            }
        }
        mml mmlVar3 = this.sy;
        if (mmlVar3 != null) {
            mmlVar3.qdl(i, f, i2);
        }
    }

    private void mzz(int i) {
        mml mmlVar = this.tid;
        if (mmlVar != null) {
            mmlVar.rq(i);
        }
        List<mml> list = this.taz;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                mml mmlVar2 = this.taz.get(i2);
                if (mmlVar2 != null) {
                    mmlVar2.rq(i);
                }
            }
        }
        mml mmlVar3 = this.sy;
        if (mmlVar3 != null) {
            mmlVar3.rq(i);
        }
    }

    private void mo(int i) {
        mml mmlVar = this.tid;
        if (mmlVar != null) {
            mmlVar.fs(i);
        }
        List<mml> list = this.taz;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                mml mmlVar2 = this.taz.get(i2);
                if (mmlVar2 != null) {
                    mmlVar2.fs(i);
                }
            }
        }
        mml mmlVar3 = this.sy;
        if (mmlVar3 != null) {
            mmlVar3.fs(i);
        }
    }

    private void qdl(boolean z) {
        boolean z2 = this.nz == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.exu.isFinished()) {
                this.exu.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.exu.getCurrX();
                int currY = this.exu.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        mml(currX);
                    }
                }
            }
        }
        this.xmv = false;
        for (int i = 0; i < this.wd.size(); i++) {
            ud udVar = this.wd.get(i);
            if (udVar.lnr) {
                udVar.lnr = false;
                z2 = true;
            }
        }
        if (z2) {
            if (z) {
                postOnAnimation(this.en);
            } else {
                this.en.run();
            }
        }
    }

    private boolean qdl(float f, float f2) {
        if (f >= this.kdv || f2 <= 0.0f) {
            return f > ((float) (getWidth() - this.kdv)) && f2 < 0.0f;
        }
        return true;
    }

    private void ud(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.lte : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int iFindPointerIndex;
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            jpc();
            return false;
        }
        if (action != 0) {
            if (this.koa) {
                return true;
            }
            if (this.vu) {
                return false;
            }
        }
        if (action == 0) {
            float x = motionEvent.getX();
            this.fco = x;
            this.hkc = x;
            float y = motionEvent.getY();
            this.mrf = y;
            this.hzv = y;
            this.gy = motionEvent.getPointerId(0);
            this.vu = false;
            this.rdp = true;
            this.exu.computeScrollOffset();
            if (this.nz == 2 && Math.abs(this.exu.getFinalX() - this.exu.getCurrX()) > this.cx) {
                this.exu.abortAnimation();
                this.xmv = false;
                lnr();
                this.koa = true;
                lnr(true);
                setScrollState(1);
            } else {
                qdl(false);
                this.koa = false;
            }
        } else if (action == 2) {
            int i = this.gy;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                float x2 = motionEvent.getX(iFindPointerIndex);
                float f = x2 - this.hkc;
                float fAbs = Math.abs(f);
                float y2 = motionEvent.getY(iFindPointerIndex);
                float fAbs2 = Math.abs(y2 - this.mrf);
                if (f != 0.0f && !qdl(this.hkc, f) && qdl(this, false, (int) f, (int) x2, (int) y2)) {
                    this.hkc = x2;
                    this.hzv = y2;
                    this.vu = true;
                    return false;
                }
                int i2 = this.ekw;
                if (fAbs > i2 && fAbs * 0.5f > fAbs2) {
                    this.koa = true;
                    lnr(true);
                    setScrollState(1);
                    this.hkc = f > 0.0f ? this.fco + this.ekw : this.fco - this.ekw;
                    this.hzv = y2;
                    setScrollingCacheEnabled(true);
                } else if (fAbs2 > i2) {
                    this.vu = true;
                }
                if (this.koa && ud(x2)) {
                    postInvalidateOnAnimation();
                }
            }
        } else if (action == 6) {
            qdl(motionEvent);
        }
        if (this.ax == null) {
            this.ax = VelocityTracker.obtain();
        }
        this.ax.addMovement(motionEvent);
        return this.koa;
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0141  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r9) {
        /*
            Method dump skipped, instruction units count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.jpc.lnr.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private boolean jpc() {
        this.gy = -1;
        to();
        this.wak.onRelease();
        this.gt.onRelease();
        return this.wak.isFinished() || this.gt.isFinished();
    }

    private void lnr(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean ud(float f) {
        boolean z;
        boolean z2;
        float f2 = this.hkc - f;
        this.hkc = f;
        float scrollX = getScrollX() + f2;
        float clientWidth = getClientWidth();
        float f3 = this.aaj * clientWidth;
        float f4 = this.jyq * clientWidth;
        boolean z3 = false;
        ud udVar = this.wd.get(0);
        ArrayList<ud> arrayList = this.wd;
        ud udVar2 = arrayList.get(arrayList.size() - 1);
        if (udVar.ud != 0) {
            f3 = udVar.mzz * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (udVar2.ud != this.lnr.qdl() - 1) {
            f4 = udVar2.mzz * clientWidth;
            z2 = false;
        } else {
            z2 = true;
        }
        if (scrollX < f3) {
            if (z) {
                this.wak.onPull(Math.abs(f3 - scrollX) / clientWidth);
                z3 = true;
            }
            scrollX = f3;
        } else if (scrollX > f4) {
            if (z2) {
                this.gt.onPull(Math.abs(scrollX - f4) / clientWidth);
                z3 = true;
            }
            scrollX = f4;
        }
        int i = (int) scrollX;
        this.hkc += scrollX - i;
        scrollTo(i, getScrollY());
        mml(i);
        return z3;
    }

    private ud tvp() {
        int i;
        int clientWidth = getClientWidth();
        float f = 0.0f;
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f2 = clientWidth > 0 ? this.jtx / clientWidth : 0.0f;
        int i2 = 0;
        boolean z = true;
        ud udVar = null;
        int i3 = -1;
        float f3 = 0.0f;
        while (i2 < this.wd.size()) {
            ud udVar2 = this.wd.get(i2);
            if (!z && udVar2.ud != (i = i3 + 1)) {
                udVar2 = this.jpc;
                udVar2.mzz = f + f3 + f2;
                udVar2.ud = i;
                udVar2.mml = this.lnr.qdl(udVar2.ud);
                i2--;
            }
            ud udVar3 = udVar2;
            f = udVar3.mzz;
            float f4 = udVar3.mml + f + f2;
            if (!z && scrollX < f) {
                return udVar;
            }
            if (scrollX < f4 || i2 == this.wd.size() - 1) {
                return udVar3;
            }
            int i4 = udVar3.ud;
            float f5 = udVar3.mml;
            i2++;
            z = false;
            i3 = i4;
            f3 = f5;
            udVar = udVar3;
        }
        return udVar;
    }

    private int qdl(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.om || Math.abs(i2) <= this.ag) {
            i += (int) (f + (i >= this.mml ? 0.4f : 0.6f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.wd.size() <= 0) {
            return i;
        }
        return Math.max(this.wd.get(0).ud, Math.min(i, this.wd.get(r4.size() - 1).ud));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean zDraw;
        com.bytedance.adsdk.ugeno.jpc.ud udVar;
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && (udVar = this.lnr) != null && udVar.qdl() > 1)) {
            if (this.wak.isFinished()) {
                zDraw = false;
            } else {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.aaj * width);
                this.wak.setSize(height, width);
                zDraw = this.wak.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.gt.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.jyq + 1.0f)) * width2);
                this.gt.setSize(height2, width2);
                zDraw |= this.gt.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
            if (zDraw) {
                postInvalidateOnAnimation();
                return;
            }
            return;
        }
        this.wak.finish();
        this.gt.finish();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        float f3;
        super.onDraw(canvas);
        if (this.jtx <= 0 || this.yt == null || this.wd.size() <= 0 || this.lnr == null) {
            return;
        }
        int scrollX = getScrollX();
        float width = getWidth();
        float f4 = this.jtx / width;
        int i = 0;
        ud udVar = this.wd.get(0);
        float f5 = udVar.mzz;
        int size = this.wd.size();
        int i2 = udVar.ud;
        int i3 = this.wd.get(size - 1).ud;
        while (i2 < i3) {
            while (i2 > udVar.ud && i < size) {
                i++;
                udVar = this.wd.get(i);
            }
            if (i2 == udVar.ud) {
                f2 = (udVar.mzz + udVar.mml) * width;
                f = udVar.mzz + udVar.mml + f4;
            } else {
                float fQdl = this.lnr.qdl(i2);
                float f6 = (f5 + fQdl) * width;
                f = f5 + fQdl + f4;
                f2 = f6;
            }
            if (this.jtx + f2 > scrollX) {
                f3 = f4;
                this.yt.setBounds(Math.round(f2), this.jl, Math.round(this.jtx + f2), this.exc);
                this.yt.draw(canvas);
            } else {
                f3 = f4;
            }
            if (f2 > scrollX + r2) {
                return;
            }
            i2++;
            f5 = f;
            f4 = f3;
        }
    }

    private void qdl(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.gy) {
            int i = actionIndex == 0 ? 1 : 0;
            this.hkc = motionEvent.getX(i);
            this.gy = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.ax;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void to() {
        this.koa = false;
        this.vu = false;
        VelocityTracker velocityTracker = this.ax;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.ax = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.uw != z) {
            this.uw = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.lnr == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        return i < 0 ? scrollX > ((int) (((float) clientWidth) * this.aaj)) : i > 0 && scrollX < ((int) (((float) clientWidth) * this.jyq));
    }

    protected boolean qdl(View view, boolean z, int i, int i2, int i3) {
        int i4;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i5 = i2 + scrollX;
                if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && (i4 = i3 + scrollY) >= childAt.getTop() && i4 < childAt.getBottom() && qdl(childAt, true, i, i5 - childAt.getLeft(), i4 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || qdl(keyEvent);
    }

    public boolean qdl(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                if (keyEvent.hasModifiers(2)) {
                    return mml();
                }
                return lnr(17);
            }
            if (keyCode == 22) {
                if (keyEvent.hasModifiers(2)) {
                    return mzz();
                }
                return lnr(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return lnr(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return lnr(1);
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean lnr(int r5) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.jpc.lnr.lnr(int):boolean");
    }

    private Rect qdl(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    boolean mml() {
        int i = this.mml;
        if (i <= 0) {
            return false;
        }
        qdl(i - 1, true);
        return true;
    }

    boolean mzz() {
        com.bytedance.adsdk.ugeno.jpc.ud udVar = this.lnr;
        if (udVar == null || this.mml >= udVar.qdl() - 1) {
            return false;
        }
        qdl(this.mml + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ud udVarQdl;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (udVarQdl = qdl(childAt)) != null && udVarQdl.ud == this.mml) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) || arrayList == null) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ud udVarQdl;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (udVarQdl = qdl(childAt)) != null && udVarQdl.ud == this.mml) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3;
        int i4;
        ud udVarQdl;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = childCount;
            i2 = 0;
            i4 = 1;
        } else {
            i2 = childCount - 1;
            i3 = -1;
            i4 = -1;
        }
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (udVarQdl = qdl(childAt)) != null && udVarQdl.ud == this.mml && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i4;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ud udVarQdl;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (udVarQdl = qdl(childAt)) != null && udVarQdl.ud == this.mml && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0182lnr();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0182lnr) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0182lnr(getContext(), attributeSet);
    }

    private class mo extends DataSetObserver {
        mo() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            lnr.this.ud();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            lnr.this.ud();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.jpc.lnr$lnr, reason: collision with other inner class name */
    public static class C0182lnr extends ViewGroup.LayoutParams {
        float lnr;
        boolean mml;
        int mo;
        int mzz;
        public boolean qdl;
        public int ud;

        public C0182lnr() {
            super(-1, -1);
            this.lnr = 0.0f;
        }

        public C0182lnr(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.lnr = 0.0f;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, lnr.ud);
            this.ud = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class jpc implements Comparator<View> {
        jpc() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            C0182lnr c0182lnr = (C0182lnr) view.getLayoutParams();
            C0182lnr c0182lnr2 = (C0182lnr) view2.getLayoutParams();
            if (c0182lnr.qdl != c0182lnr2.qdl) {
                return c0182lnr.qdl ? 1 : -1;
            }
            return c0182lnr.mzz - c0182lnr2.mzz;
        }
    }
}
