package com.bytedance.sdk.openadsdk.core.exu.ud;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.koa;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.widget.exc;
import com.bytedance.sdk.openadsdk.core.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.jtx;
import com.bytedance.sdk.openadsdk.utils.rq;
import com.google.android.exoplayer2.ExoPlayer;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class mml extends mzz {
    private TextView ag;
    private TextView ax;
    private float blf;
    private float bx;
    private int car;
    private View cx;
    private int dk;
    private ColorStateList en;
    private final Rect ew;
    private TextView fco;
    private final exc fzn;
    private float gg;
    private View gt;
    private View gy;
    private int ijp;
    private SeekBar irn;
    private float ji;
    private TextView jjk;
    private final Rect jnw;
    private final Rect jut;
    private final Rect kab;
    private final View.OnTouchListener lq;
    private int lte;
    private int mlb;
    private ImageView mrf;
    private float nz;
    private ImageView om;
    private final int qk;
    private int ra;
    private ColorStateList rzg;
    private boolean sy;
    private final koa taz;
    private boolean tid;
    private final int tqd;
    private TextView wak;
    private TextView wc;
    private TextView xi;
    private ImageView yh;
    private ImageView zlt;
    private ColorStateList zvv;
    private final Rect zy;

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz, com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud
    public /* bridge */ /* synthetic */ void qdl(ljh ljhVar, WeakReference weakReference, boolean z) {
        qdl(ljhVar, (WeakReference<Context>) weakReference, z);
    }

    public mml(Context context, ViewGroup viewGroup, boolean z, int i, ljh ljhVar, com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr lnrVar, boolean z2) {
        super(context, viewGroup, z, i, ljhVar, lnrVar, z2);
        this.taz = new koa(this);
        this.tid = false;
        this.sy = false;
        this.car = 0;
        this.mlb = 0;
        this.lte = 0;
        this.dk = 0;
        this.ijp = 0;
        this.zy = new Rect();
        this.kab = new Rect();
        this.ra = 0;
        this.lq = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.mml.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked == 2) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                } else if (actionMasked == 3) {
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                }
                return false;
            }
        };
        this.ew = new Rect();
        this.jut = new Rect();
        this.jnw = new Rect();
        this.xmv = yt.qdl().getApplicationContext();
        mml(z2);
        this.lnr = viewGroup;
        this.jyq = z;
        exc excVar = new exc(this);
        this.fzn = excVar;
        excVar.qdl(this.jyq);
        DisplayMetrics displayMetrics = this.xmv.getResources().getDisplayMetrics();
        this.qk = displayMetrics.widthPixels;
        this.tqd = displayMetrics.heightPixels;
        this.bch = i;
        this.kdv = lnrVar;
        this.uw = ljhVar;
        mml(8);
        qdl(context, this.lnr);
        mml();
        fs();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    protected void qdl(Context context, View view) {
        super.qdl(context, view);
        this.fco = (TextView) view.findViewById(jtx.yre);
        this.mrf = (ImageView) view.findViewById(jtx.hcs);
        this.gy = view.findViewById(jtx.od);
        this.om = (ImageView) view.findViewById(jtx.vm);
        this.ax = (TextView) view.findViewById(jtx.kj);
        this.ag = (TextView) view.findViewById(jtx.nts);
        this.wc = (TextView) view.findViewById(jtx.vr);
        this.cx = view.findViewById(jtx.se);
        this.yh = (ImageView) view.findViewById(jtx.vc);
        TextView textView = (TextView) view.findViewById(jtx.fge);
        this.wak = textView;
        textView.setText(com.bytedance.sdk.component.utils.ljh.qdl(context, "tt_video_retry_des_txt"));
        this.irn = (SeekBar) view.findViewById(jtx.hvi);
        this.xi = (TextView) view.findViewById(jtx.uvi);
        this.jjk = (TextView) view.findViewById(jtx.gsv);
        this.gt = view.findViewById(jtx.auu);
        this.zlt = (ImageView) view.findViewById(jtx.oz);
        this.tvp = view.findViewById(jtx.syy);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    protected void mml() {
        super.mml();
        this.fzn.qdl(this.lnr);
        ax.qdl((View) this.mrf, (this.jyq || (this.bch & 1) == 1) ? 8 : 0);
        this.mrf.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.mml.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (mml.this.jtx()) {
                    mml.this.koa.lnr(mml.this, view);
                }
            }
        });
        ax.qdl((View) this.fco, (!this.jyq || (this.bch & 2) == 2) ? 0 : 8);
        this.fco.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.mml.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (mml.this.jtx()) {
                    mml.this.koa.mml(mml.this, view);
                }
            }
        });
        this.om.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.mml.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (mml.this.jtx()) {
                    mml.this.koa.mzz(mml.this, view);
                }
            }
        });
        this.yh.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.mml.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                mml.this.ud(false, true);
                mml.this.jpc();
                mml.this.wd();
                mml.this.jtx();
            }
        });
        this.zlt.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.mml.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (mml.this.jtx()) {
                    mml.this.koa.ud(mml.this, view);
                }
            }
        });
        this.irn.setThumbOffset(0);
        this.irn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.bytedance.sdk.openadsdk.core.exu.ud.mml.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (!mml.this.tid && mml.this.xmv != null) {
                    seekBar.setThumb(rq.qdl(yt.qdl(), "tt_seek_thumb_normal"));
                }
                if (mml.this.jtx()) {
                    seekBar.setThumbOffset(0);
                    mml.this.koa.qdl(mml.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!mml.this.tid && mml.this.xmv != null) {
                    seekBar.setThumb(rq.qdl(yt.qdl(), "tt_seek_thumb_press"));
                }
                if (mml.this.jtx()) {
                    seekBar.setThumbOffset(0);
                    mml.this.koa.ud(mml.this, seekBar.getProgress());
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (mml.this.jtx()) {
                    mml.this.koa.qdl(mml.this, i, z);
                }
            }
        });
        this.irn.setOnTouchListener(this.lq);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void mzz() {
        this.taz.removeMessages(1);
        this.taz.sendMessageDelayed(this.taz.obtainMessage(1), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void mo() {
        this.taz.removeMessages(1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void ud(boolean z) {
        int i = to() ? this.tqd : this.yt;
        int iUd = to() ? this.qk : this.jl;
        if (this.aaj <= 0 || this.exc <= 0 || i <= 0) {
            return;
        }
        if (!jyq() && !to() && (this.bch & 8) != 8) {
            iUd = ax.ud(this.xmv, 228.0f);
        }
        int i2 = (int) (this.aaj * ((i * 1.0f) / this.exc));
        if (i2 > iUd) {
            i = (int) (this.exc * ((iUd * 1.0f) / this.aaj));
        } else {
            iUd = i2;
        }
        if (!z && !to()) {
            i = this.yt;
            iUd = this.jl;
        }
        this.mml.qdl(i, iUd);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void qdl(String str) {
        TextView textView = this.ax;
        if (textView != null) {
            textView.setText(str);
        }
        TextView textView2 = this.ag;
        if (textView2 != null) {
            textView2.setText(str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void qdl(int i) {
        View view = this.gt;
        if (view == null || view.getVisibility() != 0) {
            this.irn.setProgress(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void qdl(long j, long j2) {
        this.xi.setText(com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl(j2));
        this.jjk.setText(com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl(j));
        this.irn.setProgress(com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl(j, j2));
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void wd() {
        ax.mo(this.mo);
        ax.mo(this.wd);
        ax.mzz(this.cx);
        if (this.jpc != null && this.uw != null && this.uw.tdy() != null && this.uw.tdy().to() != null) {
            ax.mo(this.jpc);
            com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.uw.tdy().to(), this.uw.tdy().lnr(), this.uw.tdy().ud(), this.jpc, this.uw);
        }
        if (this.mzz.getVisibility() == 0) {
            ax.qdl((View) this.mzz, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz, com.bykv.vk.openvk.qdl.qdl.qdl.mml.ud
    public void qdl() {
        qdl(false, this.jyq);
        exc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void qdl(long j) {
        this.jjk.setText(com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl(j));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void qdl(ljh ljhVar, WeakReference<Context> weakReference, boolean z) {
        String strHvi;
        String strQdl;
        if (ljhVar == null) {
            return;
        }
        qdl(this.lnr, yt.qdl());
        qdl(false, this.jyq);
        ax.qdl(this.to, 0);
        ax.qdl((View) this.rq, 0);
        ax.qdl(this.fs, 0);
        if (this.rq != null && this.uw != null && this.uw.tdy() != null && this.uw.tdy().to() != null) {
            com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.uw.tdy().to(), this.uw.tdy().lnr(), this.uw.tdy().ud(), this.rq, this.uw);
        }
        if (!TextUtils.isEmpty(ljhVar.ca())) {
            strHvi = ljhVar.ca();
        } else if (!TextUtils.isEmpty(ljhVar.gsv())) {
            strHvi = ljhVar.gsv();
        } else if (TextUtils.isEmpty(ljhVar.hvi())) {
            strHvi = "";
        } else {
            strHvi = ljhVar.hvi();
        }
        if (this.uw != null && this.uw.hcs() != null && this.uw.hcs().qdl() != null) {
            ax.qdl((View) this.exu, 0);
            ax.qdl((View) this.rdp, 4);
            if (this.exu != null) {
                com.bytedance.sdk.openadsdk.jl.ud.ud().qdl(this.uw.hcs(), this.exu, ljhVar);
                this.exu.setOnClickListener(this.ekw);
                this.exu.setOnTouchListener(this.ekw);
            }
        } else if (!TextUtils.isEmpty(strHvi)) {
            ax.qdl((View) this.exu, 4);
            ax.qdl((View) this.rdp, 0);
            if (this.rdp != null) {
                this.rdp.setText(strHvi.substring(0, 1));
                this.rdp.setOnClickListener(this.ekw);
                this.rdp.setOnTouchListener(this.ekw);
            }
        }
        if (this.bjy != null && !TextUtils.isEmpty(strHvi)) {
            this.bjy.setText(strHvi);
        }
        ax.qdl((View) this.bjy, 0);
        ax.qdl((View) this.jtx, 0);
        int iYgv = ljhVar.ygv();
        if (iYgv == 4) {
            strQdl = com.bytedance.sdk.component.utils.ljh.qdl(this.xmv, "tt_video_download_apk");
        } else if (iYgv == 5) {
            strQdl = com.bytedance.sdk.component.utils.ljh.qdl(this.xmv, "tt_video_dial_phone");
        } else {
            strQdl = com.bytedance.sdk.component.utils.ljh.qdl(this.xmv, "tt_video_mobile_go_detail");
        }
        if (this.jtx != null) {
            this.jtx.setText(strQdl);
            this.jtx.setOnClickListener(this.ekw);
            this.jtx.setOnTouchListener(this.ekw);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void jpc() {
        ax.mzz(this.mo);
        ax.mzz(this.cx);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void tvp() {
        this.irn.setProgress(0);
        this.irn.setSecondaryProgress(0);
        this.xi.setText(com.bytedance.sdk.component.utils.ljh.qdl(this.xmv, "tt_00_00"));
        this.jjk.setText(com.bytedance.sdk.component.utils.ljh.qdl(this.xmv, "tt_00_00"));
        mml(8);
        if (bch()) {
            this.mml.setVisibility(8);
        }
        if (this.jpc != null) {
            this.jpc.setImageDrawable(null);
        }
        mml(8);
        ax.qdl(this.gt, 8);
        ax.qdl(this.to, 8);
        ax.qdl((View) this.rq, 8);
        ax.qdl(this.fs, 8);
        ax.qdl((View) this.exu, 8);
        ax.qdl((View) this.rdp, 8);
        ax.qdl((View) this.bjy, 8);
        if (this.bqt != null) {
            this.bqt.qdl(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz, com.bytedance.sdk.openadsdk.core.widget.aaj.ud
    public boolean to() {
        return this.tid;
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void qdl(ViewGroup viewGroup) {
        if (viewGroup != null && (this.lnr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            this.tid = true;
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lnr.getLayoutParams();
            this.mlb = marginLayoutParams.leftMargin;
            this.car = marginLayoutParams.topMargin;
            this.lte = marginLayoutParams.width;
            this.dk = marginLayoutParams.height;
            marginLayoutParams.width = -1;
            marginLayoutParams.height = -1;
            marginLayoutParams.topMargin = 0;
            marginLayoutParams.leftMargin = 0;
            this.lnr.setLayoutParams(marginLayoutParams);
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                int[] rules = layoutParams2.getRules();
                this.ijp = rules.length > 0 ? rules[3] : 0;
                layoutParams2.addRule(3, 0);
                viewGroup.setLayoutParams(layoutParams2);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                this.zy.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                ax.qdl(viewGroup, 0, 0, 0, 0);
            }
            ud(true);
            this.zlt.setImageDrawable(com.bytedance.sdk.component.utils.ljh.lnr(this.xmv, "tt_shrink_video"));
            this.irn.setThumb(rq.qdl(this.xmv, "tt_seek_thumb_fullscreen_selector"));
            this.irn.setThumbOffset(0);
            com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl((View) this.lnr, false);
            mzz(this.tid);
            ax.qdl(this.gy, 8);
            if (!this.jyq) {
                ax.qdl((View) this.mrf, 8);
                ax.qdl((View) this.fco, 8);
            } else if ((this.bch & 1) == 1) {
                ax.qdl((View) this.mrf, 8);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void ud(ViewGroup viewGroup) {
        if (viewGroup == null || this.lnr == null || !(this.lnr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        this.tid = false;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.lnr.getLayoutParams();
        marginLayoutParams.width = this.lte;
        marginLayoutParams.height = this.dk;
        marginLayoutParams.leftMargin = this.mlb;
        marginLayoutParams.topMargin = this.car;
        this.lnr.setLayoutParams(marginLayoutParams);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.addRule(3, this.ijp);
            viewGroup.setLayoutParams(layoutParams2);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ax.qdl(viewGroup, this.zy.left, this.zy.top, this.zy.right, this.zy.bottom);
        }
        ud(true);
        this.zlt.setImageDrawable(com.bytedance.sdk.component.utils.ljh.lnr(this.xmv, "tt_enlarge_video"));
        this.irn.setThumb(rq.qdl(this.xmv, "tt_seek_thumb_normal"));
        this.irn.setThumbOffset(0);
        com.bykv.vk.openvk.qdl.qdl.ud.mml.qdl.qdl((View) this.lnr, true);
        mzz(this.tid);
        ax.qdl(this.gy, 8);
        if ((this.bch & 2) == 2) {
            ax.qdl((View) this.fco, 0);
        }
    }

    private void mzz(boolean z) {
        if (z) {
            uw();
        } else {
            xmv();
        }
    }

    private void uw() {
        DisplayMetrics displayMetrics = this.xmv.getResources().getDisplayMetrics();
        TextView textView = this.jjk;
        if (textView != null) {
            this.gg = textView.getTextSize();
            this.jjk.setTextSize(2, 14.0f);
            ColorStateList textColors = this.jjk.getTextColors();
            this.rzg = textColors;
            if (textColors != null) {
                this.jjk.setTextColor(-1);
            }
            this.ji = this.jjk.getAlpha();
            this.jjk.setAlpha(0.85f);
            this.jjk.setShadowLayer(0.0f, ax.ud(this.xmv, 0.5f), ax.ud(this.xmv, 0.5f), com.bytedance.sdk.component.utils.ljh.wd(this.xmv, "tt_b2000000"));
            ViewGroup.LayoutParams layoutParams = this.jjk.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.ew.set(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                ax.qdl(this.jjk, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.ew.top, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.ew.bottom);
            }
        }
        TextView textView2 = this.xi;
        if (textView2 != null) {
            this.blf = textView2.getTextSize();
            this.xi.setTextSize(2, 14.0f);
            ColorStateList textColors2 = this.xi.getTextColors();
            this.zvv = textColors2;
            if (textColors2 != null) {
                this.xi.setTextColor(-1);
            }
            this.bx = this.xi.getAlpha();
            this.xi.setAlpha(0.85f);
            this.xi.setShadowLayer(0.0f, ax.ud(this.xmv, 0.5f), ax.ud(this.xmv, 0.5f), com.bytedance.sdk.component.utils.ljh.wd(this.xmv, "tt_b2000000"));
            ViewGroup.LayoutParams layoutParams2 = this.xi.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                this.jut.set(marginLayoutParams2.leftMargin, marginLayoutParams2.topMargin, marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                ax.qdl(this.xi, (int) TypedValue.applyDimension(1, 14.0f, displayMetrics), this.jut.top, this.jut.right, this.jut.bottom);
            }
        }
        ImageView imageView = this.zlt;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams3;
                this.jnw.set(marginLayoutParams3.leftMargin, marginLayoutParams3.topMargin, marginLayoutParams3.rightMargin, marginLayoutParams3.bottomMargin);
                ax.qdl(this.zlt, this.jnw.left, this.jnw.top, (int) TypedValue.applyDimension(1, 16.0f, displayMetrics), this.jnw.bottom);
            }
        }
        ImageView imageView2 = this.zlt;
        if (imageView2 != null) {
            imageView2.setImageDrawable(com.bytedance.sdk.component.utils.ljh.lnr(this.xmv, "tt_shrink_fullscreen"));
        }
        TextView textView3 = this.ag;
        if (textView3 != null) {
            ColorStateList textColors3 = textView3.getTextColors();
            this.en = textColors3;
            if (textColors3 != null) {
                this.ag.setTextColor(-1);
            }
            this.nz = this.ag.getAlpha();
            this.ag.setAlpha(0.85f);
            ViewGroup.LayoutParams layoutParams4 = this.ag.getLayoutParams();
            if (layoutParams4 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) layoutParams4;
                this.kab.set(marginLayoutParams4.leftMargin, marginLayoutParams4.topMargin, marginLayoutParams4.rightMargin, marginLayoutParams4.bottomMargin);
                ax.qdl(this.ag, (int) TypedValue.applyDimension(1, 1.0f, displayMetrics), this.jut.top, this.jut.right, this.jut.bottom);
            }
        }
        View view = this.gy;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams5 = view.getLayoutParams();
            this.ra = layoutParams5.height;
            layoutParams5.height = (int) TypedValue.applyDimension(1, 49.0f, displayMetrics);
            this.gy.setLayoutParams(layoutParams5);
            this.gy.setBackgroundResource(com.bytedance.sdk.component.utils.ljh.mml(this.xmv, "tt_shadow_fullscreen_top"));
        }
        ud(false, true);
    }

    private void xmv() {
        TextView textView = this.jjk;
        if (textView != null) {
            textView.setTextSize(0, this.gg);
            ColorStateList colorStateList = this.rzg;
            if (colorStateList != null) {
                this.jjk.setTextColor(colorStateList);
            }
            this.jjk.setAlpha(this.ji);
            this.jjk.setShadowLayer(ax.ud(this.xmv, 1.0f), 0.0f, 0.0f, com.bytedance.sdk.component.utils.ljh.wd(this.xmv, "tt_72000000"));
            ax.qdl(this.jjk, this.ew.left, this.ew.top, this.ew.right, this.ew.bottom);
        }
        TextView textView2 = this.xi;
        if (textView2 != null) {
            textView2.setTextSize(0, this.blf);
            ColorStateList colorStateList2 = this.zvv;
            if (colorStateList2 != null) {
                this.xi.setTextColor(colorStateList2);
            }
            this.xi.setAlpha(this.bx);
            this.xi.setShadowLayer(ax.ud(this.xmv, 1.0f), 0.0f, 0.0f, com.bytedance.sdk.component.utils.ljh.wd(this.xmv, "tt_72000000"));
            ax.qdl(this.xi, this.jut.left, this.jut.top, this.jut.right, this.jut.bottom);
        }
        ImageView imageView = this.zlt;
        if (imageView != null) {
            ax.qdl(imageView, this.jnw.left, this.jnw.top, this.jnw.right, this.jnw.bottom);
        }
        ImageView imageView2 = this.zlt;
        if (imageView2 != null) {
            imageView2.setImageDrawable(com.bytedance.sdk.component.utils.ljh.lnr(this.xmv, "tt_enlarge_video"));
        }
        TextView textView3 = this.ag;
        if (textView3 != null) {
            ColorStateList colorStateList3 = this.en;
            if (colorStateList3 != null) {
                textView3.setTextColor(colorStateList3);
            }
            this.ag.setAlpha(this.nz);
            ax.qdl(this.ag, this.jut.left, this.jut.top, this.jut.right, this.jut.bottom);
        }
        View view = this.gy;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = this.ra;
            this.gy.setLayoutParams(layoutParams);
            this.gy.setBackground(rq.qdl(this.xmv, "tt_video_black_desc_gradient"));
        }
        ud(false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz, com.bytedance.sdk.component.utils.koa.qdl
    public void qdl(Message message) {
        if (message.what != 1) {
            return;
        }
        rq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void qdl(boolean z, boolean z2, boolean z3) {
        ax.qdl(this.gt, 0);
        if (this.tid) {
            ax.qdl(this.gy, 0);
            ax.qdl((View) this.ag, 0);
        } else if (z3) {
            ax.qdl(this.gy, 8);
        }
        ax.qdl((View) this.mzz, (!z || this.mo.getVisibility() == 0) ? 8 : 0);
        if (!this.jyq && !this.tid) {
            if ((this.bch & 1) != 1 && !z3) {
                ax.qdl((View) this.mrf, 0);
            }
            ax.qdl((View) this.fco, z3 ? 8 : 0);
        }
        ax.qdl((View) this.xi, 0);
        ax.qdl((View) this.jjk, 0);
        ax.qdl((View) this.irn, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void qdl(boolean z, boolean z2) {
        ax.qdl(this.gt, 8);
        ax.qdl(this.gy, 8);
        ax.qdl((View) this.mzz, 8);
        if (!this.jyq && !this.tid) {
            ax.qdl((View) this.mrf, 8);
            if ((this.bch & 2) != 2) {
                ax.qdl((View) this.fco, 8);
            }
        } else if ((this.bch & 1) == 1) {
            ax.qdl((View) this.mrf, 8);
        }
        if (z2) {
            ax.qdl((View) this.mrf, 8);
            ax.qdl((View) this.fco, 8);
        }
        lnr(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz, com.bytedance.sdk.openadsdk.core.widget.aaj.ud
    public void rq() {
        qdl(true, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public boolean ud(int i) {
        SeekBar seekBar = this.irn;
        return seekBar != null && i > seekBar.getSecondaryProgress();
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz
    public void lnr(boolean z) {
        TextView textView;
        TextView textView2;
        int i;
        if (this.ax != null) {
            if (this.jyq) {
                textView2 = this.ax;
            } else {
                textView = this.ax;
                if (z) {
                    i = 0;
                    ax.qdl((View) textView, i);
                }
                textView2 = textView;
            }
            textView = textView2;
            i = 8;
            ax.qdl((View) textView, i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.exu.ud.mzz, com.bytedance.sdk.openadsdk.core.widget.exc.qdl
    public void qdl(View view, boolean z) {
        if (to()) {
            String str = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
            if (this.uw != null && !TextUtils.isEmpty(this.uw.gsv())) {
                qdl(this.uw.gsv());
            }
            this.wc.setText(str);
        } else {
            qdl("");
            this.wc.setText("");
        }
        if (this.vu) {
            return;
        }
        lnr(this.jyq && !this.tid);
        if (jtx()) {
            this.koa.qdl(this, view, true, this.mo.getVisibility() != 0);
        }
    }
}
