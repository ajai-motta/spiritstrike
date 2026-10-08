package com.tnkfactory.ad.pub;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class i5 extends RelativeLayout {
    public boolean A;
    public boolean B;
    public c C;
    public String D;
    public ArrayList E;
    public final w4 F;
    public final x4 G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RelativeLayout f3143a;
    public final r5 b;
    public RelativeLayout.LayoutParams c;
    public final ToggleButton d;
    public final ToggleButton e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final TextView i;
    public final TextView j;
    public int k;
    public final boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public f5 s;
    public h5 t;
    public y4 u;
    public z4 v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public i5(Context context, int i, boolean z, int i2) {
        super(context);
        this.c = null;
        this.k = 0;
        this.m = false;
        this.n = true;
        this.o = true;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.F = new w4(this);
        this.G = new x4(this);
        this.l = z;
        if (z) {
            this.r = true;
        }
        this.c = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f3143a = relativeLayout;
        relativeLayout.setLayoutParams(this.c);
        addView(relativeLayout);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        r5 r5Var = new r5(context);
        this.b = r5Var;
        r5Var.setLayoutParams(layoutParams);
        r5Var.setVideoPlayListener(new a5(this, context));
        relativeLayout.addView(r5Var);
        if (z) {
            r5Var.setLooping(true);
            r5Var.setMute(true);
            return;
        }
        int iApplyDimension = (int) TypedValue.applyDimension(1, 50.0f, context.getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iApplyDimension, iApplyDimension);
        layoutParams2.addRule(13);
        ToggleButton toggleButton = new ToggleButton(context);
        this.d = toggleButton;
        toggleButton.setLayoutParams(layoutParams2);
        toggleButton.setText((CharSequence) null);
        toggleButton.setTextOn(null);
        toggleButton.setTextOff(null);
        toggleButton.setBackgroundResource(R.drawable.btn_video_play);
        toggleButton.setOnClickListener(new b5(this));
        relativeLayout.addView(toggleButton);
        int iApplyDimension2 = (int) TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(iApplyDimension2, iApplyDimension2);
        if ((i2 & 1) == 0) {
            layoutParams3.addRule(11);
        } else {
            layoutParams3.addRule(9);
        }
        if ((i2 & 2) == 0) {
            layoutParams3.addRule(10);
        } else {
            layoutParams3.addRule(12);
        }
        int i3 = iApplyDimension2 / 4;
        layoutParams3.rightMargin = i3;
        layoutParams3.topMargin = i3;
        layoutParams3.leftMargin = i3;
        layoutParams3.bottomMargin = i3;
        ToggleButton toggleButton2 = new ToggleButton(context);
        this.e = toggleButton2;
        toggleButton2.setLayoutParams(layoutParams3);
        toggleButton2.setText((CharSequence) null);
        toggleButton2.setTextOn(null);
        toggleButton2.setTextOff(null);
        toggleButton2.setBackgroundResource(R.drawable.btn_video_volume);
        toggleButton2.setOnClickListener(new c5(this));
        relativeLayout.addView(toggleButton2);
        toggleButton2.setChecked(this.p);
        toggleButton2.setSelected(this.p);
        if ((i & 1) != 0) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 2.0f, context.getResources().getDisplayMetrics()));
            layoutParams4.addRule(12);
            ImageView imageView = new ImageView(context);
            this.h = imageView;
            imageView.setLayoutParams(layoutParams4);
            imageView.setBackgroundColor(0);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(-16729344), 3, 1);
            clipDrawable.setLevel(0);
            imageView.setImageDrawable(clipDrawable);
            addView(imageView);
        }
        if ((i & 2) != 0) {
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams5.addRule(12);
            layoutParams5.addRule(9);
            layoutParams5.leftMargin = 10;
            layoutParams5.bottomMargin = 10;
            TextView textView = new TextView(context);
            this.i = textView;
            textView.setLayoutParams(layoutParams5);
            textView.setTextColor(-1);
            textView.setTextSize(14.0f);
            relativeLayout.addView(textView);
        }
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(10);
        layoutParams6.addRule(9);
        layoutParams6.leftMargin = 10;
        layoutParams6.topMargin = 10;
        TextView textView2 = new TextView(context);
        this.j = textView2;
        textView2.setLayoutParams(layoutParams6);
        textView2.setTextColor(-1);
        textView2.setTextSize(18.0f);
        relativeLayout.addView(textView2);
        int iApplyDimension3 = (int) TypedValue.applyDimension(1, 40.0f, context.getResources().getDisplayMetrics());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(iApplyDimension3, iApplyDimension3);
        ImageView imageView2 = new ImageView(context);
        this.f = imageView2;
        imageView2.setLayoutParams(layoutParams7);
        imageView2.setOnClickListener(new d5(this, context));
        relativeLayout.addView(imageView2);
        ImageView imageView3 = new ImageView(context);
        this.g = imageView3;
        imageView3.setOnClickListener(new e5(this));
        imageView3.setClickable(false);
        relativeLayout.addView(imageView3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPanelVisible(boolean z) {
        this.o = z;
        int i = z ? 0 : 4;
        if (this.C.j0 == null) {
            ToggleButton toggleButton = this.d;
            if (toggleButton != null && toggleButton.getVisibility() != i) {
                this.d.setVisibility(i);
                if (i == 4) {
                    this.d.startAnimation(q0.b(2));
                }
            }
        } else {
            this.d.setVisibility(4);
        }
        ToggleButton toggleButton2 = this.e;
        if (toggleButton2 != null) {
            toggleButton2.setVisibility(i);
        }
        TextView textView = this.i;
        if (textView != null) {
            if (this.B) {
                textView.setVisibility(0);
            } else {
                textView.setVisibility(i);
            }
        }
    }

    public final void a(long j) {
        removeCallbacks(this.F);
        if (j > 0) {
            postDelayed(this.F, j);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.u == null) {
            this.u = new y4(this);
            getViewTreeObserver().addOnGlobalLayoutListener(this.u);
        }
        if (this.v == null) {
            this.v = new z4(this);
            getViewTreeObserver().addOnScrollChangedListener(this.v);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.u != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.u);
            this.u = null;
        }
        if (this.v != null) {
            getViewTreeObserver().removeOnScrollChangedListener(this.v);
            this.v = null;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && this.q) {
            setPanelVisible(true);
            a(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
        return true;
    }

    public void setAdData(c cVar) {
        this.C = cVar;
    }

    public void setAutoStart(boolean z) {
        this.m = z;
        if (z) {
            this.r = true;
        }
    }

    public void setKeepRatio(boolean z) {
        this.n = z;
    }

    public void setMediaPath(String str) {
        this.b.setMediaPath(str);
    }

    public void setMuteOnStart(boolean z) {
        this.p = z;
        ToggleButton toggleButton = this.e;
        if (toggleButton != null) {
            toggleButton.setChecked(z);
            this.e.setSelected(this.p);
        }
    }

    public void setVideoActionListener(f5 f5Var) {
        this.s = f5Var;
    }

    public void setVideoFrameLayoutParams(RelativeLayout.LayoutParams layoutParams) {
        this.c = layoutParams;
    }

    public void setVideoProgressListener(h5 h5Var) {
        this.t = h5Var;
    }

    public void setVideoClipRound(int i) {
        this.f3143a.setOutlineProvider(new i4(i));
    }

    public final void a() {
        ToggleButton toggleButton = this.d;
        if (toggleButton != null) {
            toggleButton.setChecked(false);
        }
        r5 r5Var = this.b;
        if (r5Var == null || !this.q) {
            return;
        }
        MediaPlayer mediaPlayer = r5Var.f3188a;
        if (mediaPlayer != null) {
            r5Var.h = 4;
            if (mediaPlayer.isPlaying()) {
                r5Var.f3188a.pause();
                CountDownTimer countDownTimer = r5Var.m;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
            }
            g5 g5Var = r5Var.l;
            if (g5Var != null) {
                r5Var.f3188a.getCurrentPosition();
                a5 a5Var = (a5) g5Var;
                i5 i5Var = a5Var.b;
                i5Var.q = false;
                i5Var.removeCallbacks(i5Var.G);
                z1 z1Var = a5Var.b.C.j0;
                if (z1Var != null && !z1Var.i.isEmpty()) {
                    k4 k4VarA = k4.a();
                    ArrayList arrayList = a5Var.b.C.j0.i;
                    k4VarA.getClass();
                    k4.a(arrayList);
                }
            }
            r5Var.getPlayCurrentTime();
        }
        setPanelVisible(true);
        a(-1L);
    }

    public final void a(Context context, ImageView imageView, c cVar) {
        ArrayList arrayList = cVar.k0;
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        s4 s4Var = null;
        for (int i = 0; i < cVar.k0.size(); i++) {
            ArrayList arrayList2 = cVar.k0;
            if (arrayList2 != null && (((s4) arrayList2.get(i)).h.equals("ad") || ((s4) cVar.k0.get(i)).h.equals("ad_1") || ((s4) cVar.k0.get(i)).h.equals("ad_2"))) {
                s4Var = (s4) cVar.k0.get(i);
                this.D = s4Var.e;
                this.E = s4Var.c;
            }
        }
        if (s4Var != null) {
            new Thread(new u4(s4Var, imageView)).start();
        }
        int iApplyDimension = -1;
        int iApplyDimension2 = (s4Var == null || s4Var.g.isEmpty()) ? -1 : (int) TypedValue.applyDimension(0, Integer.parseInt(s4Var.g), context.getResources().getDisplayMetrics());
        if (s4Var != null && !s4Var.i.isEmpty()) {
            iApplyDimension = (int) TypedValue.applyDimension(0, Integer.parseInt(s4Var.i), context.getResources().getDisplayMetrics());
        }
        if (s4Var != null && !s4Var.d.isEmpty()) {
            k4 k4VarA = k4.a();
            ArrayList arrayList3 = s4Var.d;
            k4VarA.getClass();
            k4.a(arrayList3);
        }
        if (iApplyDimension2 > 0 || iApplyDimension > 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iApplyDimension2, iApplyDimension);
            if (!s4Var.f3193a.isEmpty()) {
                String str = s4Var.f3193a;
                str.getClass();
                if (str.equals("left")) {
                    layoutParams.addRule(9);
                } else if (str.equals(TtmlNode.RIGHT)) {
                    layoutParams.addRule(11);
                }
            }
            if (!s4Var.f.isEmpty()) {
                String str2 = s4Var.f;
                str2.getClass();
                if (str2.equals("bottom")) {
                    layoutParams.addRule(12);
                } else if (str2.equals(ViewHierarchyConstants.DIMENSION_TOP_KEY)) {
                    layoutParams.addRule(10);
                }
            }
            imageView.setLayoutParams(layoutParams);
        }
    }

    public static void a(String str, int i) {
        try {
            new Thread(new v4(str, i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
