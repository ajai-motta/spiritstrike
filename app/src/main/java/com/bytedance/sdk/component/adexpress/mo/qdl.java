package com.bytedance.sdk.component.adexpress.mo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.sdk.component.utils.koa;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class qdl extends TextSwitcher implements ViewSwitcher.ViewFactory, koa.qdl {
    private int exu;
    private int fs;
    private int jpc;
    private int lnr;
    private final int mml;
    private TextView mo;
    private Context mzz;
    Animation.AnimationListener qdl;
    private Handler rdp;
    private int rq;
    private int to;
    private float tvp;
    private List<String> ud;
    private int wd;

    public qdl(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.ud = new ArrayList();
        this.lnr = 0;
        this.mml = 1;
        this.rdp = new koa(Looper.getMainLooper(), this);
        this.qdl = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.mo.qdl.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (qdl.this.mo != null) {
                    qdl.this.mo.setText("");
                }
            }
        };
        this.mzz = context;
        this.jpc = i;
        this.tvp = f;
        this.to = i2;
        this.exu = i3;
        lnr();
    }

    private void lnr() {
        setFactory(this);
    }

    public void setAnimationType(int i) {
        this.fs = i;
    }

    public void setAnimationDuration(int i) {
        this.wd = i;
    }

    public void qdl() {
        int i = this.fs;
        if (i == 1) {
            setInAnimation(getContext(), com.bytedance.sdk.component.utils.ljh.tvp(this.mzz, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), com.bytedance.sdk.component.utils.ljh.tvp(this.mzz, "tt_text_animation_y_out"));
        } else if (i == 0) {
            setInAnimation(getContext(), com.bytedance.sdk.component.utils.ljh.tvp(this.mzz, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), com.bytedance.sdk.component.utils.ljh.tvp(this.mzz, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.qdl);
            getOutAnimation().setAnimationListener(this.qdl);
        }
        this.rdp.sendEmptyMessage(1);
    }

    public void setAnimationText(List<String> list) {
        this.ud = list;
    }

    public void ud() {
        List<String> list = this.ud;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = this.lnr;
        this.lnr = i + 1;
        this.rq = i;
        setText(this.ud.get(i));
        if (this.lnr > this.ud.size() - 1) {
            this.lnr = 0;
        }
    }

    public void setTextColor(int i) {
        this.jpc = i;
    }

    public void setTextSize(float f) {
        this.tvp = f;
    }

    public void setMaxLines(int i) {
        this.to = i;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.mo = textView;
        textView.setTextColor(this.jpc);
        this.mo.setTextSize(this.tvp);
        this.mo.setMaxLines(this.to);
        this.mo.setTextAlignment(this.exu);
        return this.mo;
    }

    @Override // com.bytedance.sdk.component.utils.koa.qdl
    public void qdl(Message message) {
        if (message.what != 1) {
            return;
        }
        ud();
        this.rdp.sendEmptyMessageDelayed(1, this.wd);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(com.bytedance.sdk.component.adexpress.dynamic.mzz.rq.ud(this.ud.get(this.rq), this.tvp, false)[0], 1073741824), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.rdp.removeMessages(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.rdp.sendEmptyMessageDelayed(1, this.wd);
    }
}
