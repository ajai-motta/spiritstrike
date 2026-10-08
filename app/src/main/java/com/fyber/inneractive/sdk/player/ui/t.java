package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends o {
    public t(Context context, h hVar, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(context, null, hVar, rVar, false, null);
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s
    public final void a(com.fyber.inneractive.sdk.flow.endcard.d dVar, b bVar) {
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l
    public final void b(int i, int i2) {
    }

    @Override // com.fyber.inneractive.sdk.player.ui.s, com.fyber.inneractive.sdk.player.ui.m
    public final boolean b() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l, com.fyber.inneractive.sdk.player.ui.s
    public View getEndCardView() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.o, com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyView() {
        return new View[0];
    }

    @Override // com.fyber.inneractive.sdk.player.ui.o, com.fyber.inneractive.sdk.player.ui.s
    public View[] getTrackingFriendlyViewObstructionPurposeOther() {
        return new View[0];
    }

    @Override // com.fyber.inneractive.sdk.player.ui.l
    public final void h(boolean z) {
    }

    @Override // com.fyber.inneractive.sdk.player.ui.o, com.fyber.inneractive.sdk.player.ui.s
    public final boolean i() {
        return false;
    }

    @Override // com.fyber.inneractive.sdk.player.ui.o
    public final void q() {
        setBackgroundColor(0);
        this.l = (ViewGroup) findViewById(R.id.ia_texture_view_host);
        removeView(findViewById(R.id.ia_video_progressbar));
        ImageView imageView = (ImageView) findViewById(R.id.ia_iv_mute_button);
        this.M = imageView;
        removeView(imageView);
        this.M = null;
        this.Q = findViewById(R.id.ia_buffering_overlay);
        TextView textView = (TextView) findViewById(R.id.ia_tv_call_to_action);
        this.L = textView;
        removeView(textView);
        this.L = null;
    }
}
