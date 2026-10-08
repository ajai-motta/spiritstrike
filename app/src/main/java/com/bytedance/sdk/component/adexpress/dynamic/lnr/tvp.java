package com.bytedance.sdk.component.adexpress.dynamic.lnr;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.mo.xmv;
import com.facebook.appevents.AppEventsConstants;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: classes3.dex */
public class tvp extends FrameLayout implements jpc {
    private com.bytedance.sdk.component.adexpress.ud.exu fs;
    private View.OnTouchListener jpc;
    private com.bytedance.sdk.component.adexpress.dynamic.mml.wd lnr;
    private View mml;
    private String mo;
    private wd mzz;
    private Context qdl;
    private com.bytedance.sdk.component.adexpress.dynamic.mml.to rq;
    private boolean to;
    private int tvp;
    private com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz ud;
    private com.bytedance.sdk.component.adexpress.mo.jl wd;

    public tvp(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz mzzVar, com.bytedance.sdk.component.adexpress.dynamic.mml.wd wdVar) {
        super(context);
        this.qdl = context;
        this.ud = mzzVar;
        this.lnr = wdVar;
        wd();
    }

    public tvp(Context context, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz mzzVar, com.bytedance.sdk.component.adexpress.dynamic.mml.wd wdVar, com.bytedance.sdk.component.adexpress.dynamic.mml.to toVar, com.bytedance.sdk.component.adexpress.ud.exu exuVar) {
        super(context);
        this.qdl = context;
        this.ud = mzzVar;
        this.lnr = wdVar;
        this.rq = toVar;
        this.fs = exuVar;
        wd();
    }

    private void wd() {
        setBackgroundColor(0);
        setClipChildren(false);
        setClipToPadding(false);
        this.mo = this.lnr.wc();
        this.tvp = this.lnr.yh();
        this.to = this.lnr.tid();
        wd wdVarQdl = to.qdl(this.qdl, this.ud, this.lnr, this.rq, this.fs);
        this.mzz = wdVarQdl;
        if (wdVarQdl != null) {
            this.mml = wdVarQdl.lnr();
            if (this.lnr.om()) {
                setBackgroundColor(Color.parseColor("#50000000"));
            }
            if (TextUtils.equals(this.mo, "6")) {
                if (this.lnr.sy() && !TextUtils.isEmpty(this.lnr.car())) {
                    this.wd = new com.bytedance.sdk.component.adexpress.mo.jl(this.qdl, com.bytedance.sdk.component.adexpress.dynamic.mml.wd.qdl(this.lnr.car()));
                } else {
                    this.wd = new com.bytedance.sdk.component.adexpress.mo.jl(this.qdl, Color.parseColor("#99000000"));
                }
                FrameLayout frameLayout = new FrameLayout(this.qdl);
                frameLayout.addView(this.wd, new FrameLayout.LayoutParams(-1, -1));
                frameLayout.setClipChildren(true);
                addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
                post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.lnr.tvp.1
                    @Override // java.lang.Runnable
                    public void run() {
                        tvp.this.wd.ud();
                    }
                });
            }
            if (qdl(this.mo) && com.bytedance.sdk.component.adexpress.mml.ud()) {
                int color = Color.parseColor("#99000000");
                if (this.lnr.sy() && !TextUtils.isEmpty(this.lnr.car())) {
                    try {
                        color = com.bytedance.sdk.component.adexpress.dynamic.mml.wd.qdl(this.lnr.car());
                    } catch (Exception unused) {
                    }
                }
                View view = new View(this.qdl);
                view.setBackgroundColor(color);
                addView(view, new FrameLayout.LayoutParams(-1, -1));
            }
            addView(this.mzz.lnr());
            qdl(this.mzz.lnr());
            setVisibility(0);
        }
    }

    private boolean qdl(String str) {
        return TextUtils.equals(str, "24") || TextUtils.equals(str, "23") || TextUtils.equals(str, "25") || TextUtils.equals(str, "22") || TextUtils.equals(str, "1");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.jpc instanceof com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.lnr) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void qdl(ViewGroup viewGroup) {
        if (this.mml == null) {
            return;
        }
        String str = this.mo;
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 48:
                if (str.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                    b = 0;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    b = 1;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b = 2;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    b = 3;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    b = 4;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    b = 5;
                }
                break;
            case 56:
                if (str.equals("8")) {
                    b = 6;
                }
                break;
            case 57:
                if (str.equals("9")) {
                    b = 7;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    b = 8;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    b = 9;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    b = 10;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    b = Ascii.VT;
                }
                break;
            case 1571:
                if (str.equals("14")) {
                    b = Ascii.FF;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    b = Ascii.CR;
                }
                break;
            case 1574:
                if (str.equals("17")) {
                    b = Ascii.SO;
                }
                break;
            case 1575:
                if (str.equals("18")) {
                    b = Ascii.SI;
                }
                break;
            case 1598:
                if (str.equals("20")) {
                    b = Ascii.DLE;
                }
                break;
            case 1600:
                if (str.equals("22")) {
                    b = 17;
                }
                break;
            case 1601:
                if (str.equals("23")) {
                    b = Ascii.DC2;
                }
                break;
            case 1602:
                if (str.equals("24")) {
                    b = 19;
                }
                break;
            case 1603:
                if (str.equals("25")) {
                    b = Ascii.DC4;
                }
                break;
            case 1607:
                if (str.equals("29")) {
                    b = Ascii.NAK;
                }
                break;
        }
        switch (b) {
            case 0:
                this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.mzz(this, this.tvp);
                setBackgroundColor(Color.parseColor("#80000000"));
                break;
            case 1:
            case 4:
                if (!this.lnr.sy() || TextUtils.isEmpty(this.lnr.car())) {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.mo(this);
                break;
            case 2:
            case 5:
                setBackgroundColor(Color.parseColor("#80000000"));
                this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.ud(this, this);
                break;
            case 3:
                if (this.lnr.sy() && !TextUtils.isEmpty(this.lnr.car())) {
                    setBackgroundColor(com.bytedance.sdk.component.adexpress.dynamic.mml.wd.qdl(this.lnr.car()));
                } else {
                    setBackgroundColor(Color.parseColor("#80000000"));
                }
                this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.lnr(this);
                this.mml.setTag(2);
                break;
            case 6:
            case 9:
                this.ud.setClipChildren(false);
                this.ud.setClipChildren(false);
                ViewGroup viewGroup2 = (ViewGroup) this.ud.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.mo(this);
                break;
            case 7:
            case 14:
                this.mml.setTag(2);
                break;
            case 8:
                this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.mml(this, this.tvp, this.to);
                break;
            case 10:
                this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.lnr(this);
                this.mml.setTag(2);
                break;
            case 11:
            case 19:
                if (this.mo.equals("24") && com.bytedance.sdk.component.adexpress.mml.ud()) {
                    this.ud.setClipChildren(false);
                    this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.mo(this);
                } else {
                    this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.mzz(this, this.tvp);
                }
                break;
            case 12:
                this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.ud(this, this);
                break;
            case 13:
                View view = this.mml;
                if (view != null && (view instanceof com.bytedance.sdk.component.adexpress.mo.exc) && ((com.bytedance.sdk.component.adexpress.mo.exc) view).getShakeLayout() != null) {
                    ((com.bytedance.sdk.component.adexpress.mo.exc) this.mml).getShakeLayout().setTag(2);
                }
                this.mml.setTag(2);
                break;
            case 15:
                View view2 = this.mml;
                if (view2 != null && (view2 instanceof xmv) && ((xmv) view2).getWriggleLayout() != null) {
                    ((xmv) this.mml).getWriggleLayout().setTag(2);
                }
                this.mml.setTag(2);
                break;
            case 16:
                this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.qdl(this, this.tvp, viewGroup);
                break;
            case 17:
                if (com.bytedance.sdk.component.adexpress.mml.ud()) {
                    this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.jpc(this, this.to);
                } else {
                    this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.wd(this, this.tvp, viewGroup);
                }
                break;
            case 18:
                if (com.bytedance.sdk.component.adexpress.mml.ud()) {
                    this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.mo(this);
                }
                break;
            case 20:
                if (com.bytedance.sdk.component.adexpress.mml.ud()) {
                    this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.jpc(this, this.to);
                }
                break;
            case 21:
                View view3 = this.mml;
                if (view3 != null && (view3 instanceof com.bytedance.sdk.component.adexpress.mo.mo) && ((com.bytedance.sdk.component.adexpress.mo.mo) view3).getShakeView() != null) {
                    ((com.bytedance.sdk.component.adexpress.mo.mo) this.mml).getShakeView().setTag(2);
                }
                this.jpc = new com.bytedance.sdk.component.adexpress.dynamic.lnr.qdl.mzz(this, this.tvp);
                break;
        }
        View.OnTouchListener onTouchListener = this.jpc;
        if (onTouchListener != null) {
            setOnTouchListener(onTouchListener);
        }
        if (jpc()) {
            this.mml.setTag(2);
            setOnClickListener((View.OnClickListener) this.ud.getDynamicClickListener());
        }
    }

    private boolean jpc() {
        return (this.lnr.tid() || TextUtils.equals("9", this.mo) || TextUtils.equals("16", this.mo) || TextUtils.equals("17", this.mo) || TextUtils.equals("18", this.mo) || TextUtils.equals("20", this.mo) || TextUtils.equals("29", this.mo) || TextUtils.equals("10", this.mo)) ? false : true;
    }

    public void lnr() {
        wd wdVar = this.mzz;
        if (wdVar != null) {
            wdVar.qdl();
        }
    }

    public void mml() {
        wd wdVar = this.mzz;
        if (wdVar != null) {
            wdVar.ud();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            wd wdVar = this.mzz;
            if (wdVar != null) {
                wdVar.ud();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void mzz() {
        if (this.mml != null && TextUtils.equals(this.mo, "2")) {
            View view = this.mml;
            if (view instanceof com.bytedance.sdk.component.adexpress.mo.lnr) {
                ((com.bytedance.sdk.component.adexpress.mo.lnr) view).lnr();
            }
        }
    }

    public void mo() {
        if (this.mml != null && TextUtils.equals(this.mo, "2")) {
            View view = this.mml;
            if (view instanceof com.bytedance.sdk.component.adexpress.mo.lnr) {
                ((com.bytedance.sdk.component.adexpress.mo.lnr) view).mml();
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.lnr.jpc
    public void qdl() {
        if (TextUtils.equals(this.mo, "6")) {
            com.bytedance.sdk.component.adexpress.mo.jl jlVar = this.wd;
            if (jlVar != null) {
                jlVar.lnr();
                postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.lnr.tvp.2
                    @Override // java.lang.Runnable
                    public void run() {
                        tvp.this.tvp();
                    }
                }, 300L);
                return;
            }
            return;
        }
        if (TextUtils.equals(this.mo, "20")) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.lnr.tvp.3
                @Override // java.lang.Runnable
                public void run() {
                    tvp.this.tvp();
                }
            }, 400L);
        } else {
            tvp();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.lnr.jpc
    public void ud() {
        if (jpc()) {
            setOnClickListener((View.OnClickListener) this.ud.getDynamicClickListener());
            performClick();
            if (this.lnr.fzn()) {
                return;
            }
            setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tvp() {
        if (this.jpc != null) {
            setOnClickListener((View.OnClickListener) this.ud.getDynamicClickListener());
            performClick();
            if (this.lnr.fzn()) {
                return;
            }
            setVisibility(8);
        }
    }
}
