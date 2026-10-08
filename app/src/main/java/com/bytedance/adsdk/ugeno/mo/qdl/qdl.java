package com.bytedance.adsdk.ugeno.mo.qdl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.internal.view.SupportMenu;
import com.bytedance.adsdk.ugeno.mo.mml;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class qdl extends LinearLayout {
    private String fs;
    private boolean jpc;
    protected int lnr;
    private List<View> mml;
    private int mo;
    private int mzz;
    protected Context qdl;
    private float rq;
    private float to;
    private int tvp;
    protected int ud;
    private int wd;

    public abstract Drawable ud(int i);

    public qdl(Context context) {
        super(context);
        this.mzz = SupportMenu.CATEGORY_MASK;
        this.mo = -16776961;
        this.wd = 5;
        this.ud = 40;
        this.lnr = 20;
        this.fs = "row";
        this.qdl = context;
        this.mml = new ArrayList();
        setOrientation(0);
    }

    public void setIndicatorX(float f) {
        this.to = f;
    }

    public void setIndicatorY(float f) {
        this.rq = f;
    }

    public void setIndicatorDirection(String str) {
        this.fs = str;
        if (TextUtils.equals(str, "column")) {
            setOrientation(1);
        } else {
            setOrientation(0);
        }
    }

    public void setIndicatorWidth(int i) {
        this.ud = i;
    }

    public void setIndicatorHeight(int i) {
        this.lnr = i;
    }

    public void qdl(int i, int i2) {
        Iterator<View> it = this.mml.iterator();
        while (it.hasNext()) {
            it.next().setBackground(ud(this.mo));
        }
        if (i < 0 || i >= this.mml.size()) {
            i = 0;
        }
        if (this.mml.size() > 0) {
            this.mml.get(i).setBackground(ud(this.mzz));
            this.tvp = i2;
        }
    }

    public int getSize() {
        return this.mml.size();
    }

    public void qdl() {
        post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.mo.qdl.qdl.1
            @Override // java.lang.Runnable
            public void run() {
                qdl.this.mml();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mml() {
        FrameLayout frameLayout = (FrameLayout) getParent();
        if (frameLayout == null) {
            return;
        }
        float width = frameLayout.getWidth();
        float height = frameLayout.getHeight();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        float width2 = getWidth();
        layoutParams.topMargin = (int) (((int) ((height * r5) / 100.0f)) - ((getHeight() * this.rq) / 100.0f));
        layoutParams.leftMargin = (int) (((int) ((width * r0) / 100.0f)) - ((width2 * this.to) / 100.0f));
        setLayoutParams(layoutParams);
    }

    public void setSelectedColor(int i) {
        this.mzz = i;
    }

    public void setLoop(boolean z) {
        this.jpc = z;
    }

    public void setUnSelectedColor(int i) {
        this.mo = i;
    }

    public void qdl(int i) {
        if (this instanceof ud) {
            this.lnr = this.ud;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ud, this.lnr);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.wd;
            layoutParams.bottomMargin = this.wd;
        } else {
            layoutParams.leftMargin = this.wd;
            layoutParams.rightMargin = this.wd;
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.ud, this.lnr);
        if (getOrientation() == 1) {
            layoutParams2.topMargin = this.wd;
            layoutParams2.bottomMargin = this.wd;
        } else {
            layoutParams2.leftMargin = this.wd;
            layoutParams2.rightMargin = this.wd;
        }
        int iQdl = mml.qdl(this.jpc, this.tvp, this.mml.size());
        int iQdl2 = mml.qdl(this.jpc, i, this.mml.size());
        if (this.mml.size() == 0) {
            iQdl2 = 0;
        }
        if (!this.mml.isEmpty() && mml.qdl(iQdl, this.mml) && mml.qdl(iQdl2, this.mml)) {
            this.mml.get(iQdl).setBackground(ud(this.mo));
            this.mml.get(iQdl).setLayoutParams(layoutParams2);
            this.mml.get(iQdl2).setBackground(ud(this.mzz));
            this.mml.get(iQdl2).setLayoutParams(layoutParams);
            this.tvp = i;
        }
    }

    public void ud() {
        View view = new View(getContext());
        view.setClickable(false);
        if (this instanceof ud) {
            this.lnr = this.ud;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.ud, this.lnr);
        if (getOrientation() == 1) {
            layoutParams.topMargin = this.wd;
            layoutParams.bottomMargin = this.wd;
        } else {
            layoutParams.leftMargin = this.wd;
            layoutParams.rightMargin = this.wd;
        }
        addView(view, layoutParams);
        view.setBackground(ud(this.mo));
        this.mml.add(view);
    }

    public void lnr() {
        this.mml.clear();
        removeAllViews();
    }
}
