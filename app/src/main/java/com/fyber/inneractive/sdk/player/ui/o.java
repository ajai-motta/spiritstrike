package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.ui.IAsmoothProgressBar;
import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class o extends l {
    public ViewGroup J;
    public TextView K;
    public TextView L;
    public ImageView M;
    public ImageView N;
    public IAsmoothProgressBar O;
    public View P;
    public View Q;
    public View R;
    public TextView S;
    public TextView T;

    public o(Context context, com.fyber.inneractive.sdk.flow.g gVar, a aVar, com.fyber.inneractive.sdk.config.global.r rVar, boolean z, String str) {
        super(context, gVar, aVar, rVar, str);
        this.P = null;
        this.z.inflate(R.layout.ia_layout_video_view, (ViewGroup) this, true);
        q();
        com.fyber.inneractive.sdk.flow.g gVar2 = this.A;
        if (gVar2 != null) {
            IFyberAdIdentifier.Corner corner = IFyberAdIdentifier.Corner.BOTTOM_LEFT;
            IFyberAdIdentifier iFyberAdIdentifier = gVar2.d;
            iFyberAdIdentifier.k = corner;
            iFyberAdIdentifier.a(this);
        }
        h(z);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l, com.fyber.inneractive.sdk.player.ui.s
    public final void a(int i, int i2) {
        IAsmoothProgressBar iAsmoothProgressBar = this.O;
        if (iAsmoothProgressBar == null) {
            return;
        }
        iAsmoothProgressBar.setMax(i);
        super.a(i, i2);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void b(boolean z) {
        TextView textView = this.S;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public final void c() {
        this.h = true;
        j();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.e
    public final void d() {
        this.h = false;
        k();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s, com.fyber.inneractive.sdk.player.ui.m
    public final void destroy() {
        super.destroy();
        k kVar = this.D;
        if (kVar != null) {
            removeCallbacks(kVar);
            this.D = null;
        }
        p();
        ViewGroup viewGroup = this.l;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void e(boolean z) {
        View view = this.R;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void f(boolean z) {
        IAsmoothProgressBar iAsmoothProgressBar = this.O;
        if (iAsmoothProgressBar != null) {
            iAsmoothProgressBar.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void g(boolean z) {
        TextView textView = this.T;
        if (textView != null) {
            textView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyView() {
        return new View[]{this.L, this.S, this.T, this.M, this.O, this.P, this.u};
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyViewObstructionPurposeOther() {
        return new View[]{this.K, this.J};
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void h() {
        g(false);
        d(false);
        f(false);
        TextView textView = this.L;
        if (textView != null) {
            textView.setVisibility(4);
        }
        ImageView imageView = this.N;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
        c(false);
        a(false, (String) null);
        b(false);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public boolean i() {
        TextView textView = this.T;
        return textView != null && textView.getVisibility() == 0 && this.T.isEnabled();
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final boolean l() {
        return this.S == null && this.O == null;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void m() {
        ImageView imageView = this.N;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.N.setSelected(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void n() {
        ImageView imageView = this.N;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.N.setSelected(false);
        }
    }

    public void q() {
        this.l = (ViewGroup) findViewById(R.id.ia_texture_view_host);
        this.q = (ViewGroup) findViewById(R.id.ia_default_endcard_video_overlay);
        this.r = (ViewGroup) findViewById(R.id.ia_endcard_video_overlay);
        this.m = (Button) findViewById(R.id.ia_b_end_card_call_to_action);
        TextView textView = (TextView) findViewById(R.id.ia_endcard_tv_app_info_button);
        this.u = textView;
        a(textView, 10);
        a(this.m, 8);
        a(this.l, 7);
        a(this.q, -1);
        this.N = (ImageView) findViewById(R.id.ia_iv_expand_collapse_button);
        this.R = findViewById(R.id.ia_paused_video_overlay);
        this.K = (TextView) findViewById(R.id.ia_tv_app_info_button);
        this.L = (TextView) findViewById(R.id.ia_tv_call_to_action);
        this.O = (IAsmoothProgressBar) findViewById(R.id.ia_video_progressbar);
        this.J = (ViewGroup) findViewById(R.id.ia_identifier_overlay);
        this.P = findViewById(R.id.ia_click_overlay);
        this.O.setVisibility(0);
        ImageView imageView = (ImageView) findViewById(R.id.ia_iv_mute_button);
        this.M = imageView;
        imageView.setVisibility(0);
        this.Q = findViewById(R.id.ia_buffering_overlay);
        this.S = (TextView) findViewById(R.id.ia_tv_remaining_time);
        this.T = (TextView) findViewById(R.id.ia_tv_skip);
        a(this, 7);
        a(this.L, 3);
        a(this.M, 1);
        a(this.K, 10);
        a(this.N, 5);
        a(this.R, 9);
        a(this.T, 6);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setAppInfoButtonRound(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setBackgroundResource(R.drawable.ia_bg_circle_overlay);
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        layoutParams.width = (int) getContext().getResources().getDimension(R.dimen.ia_image_control_size);
        layoutParams.height = (int) getContext().getResources().getDimension(R.dimen.ia_image_control_size);
        textView.setLayoutParams(layoutParams);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setMuteButtonState(boolean z) {
        ImageView imageView = this.M;
        if (imageView != null) {
            imageView.setSelected(z);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setRemainingTime(String str) {
        TextView textView = this.S;
        if (textView != null) {
            textView.setText(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public void setSkipText(String str) {
        if (this.T != null) {
            try {
                Integer.parseInt(str);
                int i = R.string.ia_video_before_skip_format;
                str = String.format(Locale.US, IAConfigManager.O.v.a().getString(i), Integer.valueOf(Integer.parseInt(str)));
            } catch (Exception unused) {
            }
            this.T.setText(str);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void c(boolean z) {
        ViewGroup viewGroup = this.J;
        if (viewGroup != null) {
            viewGroup.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void d(boolean z) {
        ImageView imageView = this.M;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 4);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void g() {
        TextView textView = this.T;
        if (textView != null) {
            textView.setEnabled(true);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l
    public final void a(int i) {
        IAsmoothProgressBar iAsmoothProgressBar = this.O;
        if (iAsmoothProgressBar != null) {
            iAsmoothProgressBar.setProgress(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    @Override // com.fyber.inneractive.sdk.player.ui.s
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(boolean r5, com.fyber.inneractive.sdk.ignite.m r6) {
        /*
            r4 = this;
            android.widget.TextView r0 = r4.L
            if (r0 == 0) goto L74
            com.fyber.inneractive.sdk.config.global.r r1 = r4.v
            r2 = 0
            if (r1 == 0) goto L28
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.u> r3 = com.fyber.inneractive.sdk.config.global.features.u.class
            com.fyber.inneractive.sdk.config.global.features.h r1 = r1.a(r3)
            if (r1 == 0) goto L28
            com.fyber.inneractive.sdk.config.global.r r1 = r4.v
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.u> r3 = com.fyber.inneractive.sdk.config.global.features.u.class
            com.fyber.inneractive.sdk.config.global.features.h r1 = r1.a(r3)
            com.fyber.inneractive.sdk.config.global.features.u r1 = (com.fyber.inneractive.sdk.config.global.features.u) r1
            java.lang.String r3 = "cta_text_all_caps"
            java.lang.Boolean r1 = r1.c(r3)
            if (r1 == 0) goto L28
            boolean r1 = r1.booleanValue()
            goto L29
        L28:
            r1 = r2
        L29:
            r0.setAllCaps(r1)
            android.widget.TextView r0 = r4.L
            com.fyber.inneractive.sdk.config.IAConfigManager r1 = com.fyber.inneractive.sdk.config.IAConfigManager.O
            com.fyber.inneractive.sdk.ignite.h r1 = r1.E
            boolean r1 = r1.n()
            if (r1 == 0) goto L4a
            r6.getClass()
            com.fyber.inneractive.sdk.ignite.m r1 = com.fyber.inneractive.sdk.ignite.m.TRUE_SINGLE_TAP
            if (r6 != r1) goto L4a
            android.content.Context r6 = r4.getContext()
            int r1 = com.fyber.inneractive.sdk.R.string.ia_video_instant_install_text
            java.lang.String r6 = r6.getString(r1)
            goto L5e
        L4a:
            java.lang.String r6 = r4.getLocalizedCtaButtonText()
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 == 0) goto L5e
            android.content.Context r6 = r4.getContext()
            int r1 = com.fyber.inneractive.sdk.R.string.ia_video_install_now_text
            java.lang.String r6 = r6.getString(r1)
        L5e:
            java.lang.String r1 = r4.w
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L68
            java.lang.String r6 = r4.w
        L68:
            r0.setText(r6)
            android.widget.TextView r6 = r4.L
            if (r5 == 0) goto L70
            goto L71
        L70:
            r2 = 4
        L71:
            r6.setVisibility(r2)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.ui.o.a(boolean, com.fyber.inneractive.sdk.ignite.m):void");
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z, String str) {
        TextView textView;
        TextView textView2 = this.K;
        if (textView2 != null) {
            textView2.setText(str);
            if (str != null && str.length() == 1) {
                setAppInfoButtonRound(this.K);
            }
            if (z && (textView = this.L) != null) {
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                layoutParams.width = -2;
                this.L.setLayoutParams(layoutParams);
                this.L.setTextSize(0, getResources().getDimension(R.dimen.ia_video_overlay_text_large_for_cta));
            }
            this.K.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(boolean z) {
        View view = this.Q;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }
}
