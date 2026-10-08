package com.facebook.ads.redexgen.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.f7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2066f7 extends AnimatorListenerAdapter {
    public final /* synthetic */ C09293c A00;

    public C2066f7(C09293c c09293c) {
        this.A00 = c09293c;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.A00.A00.A04.postDelayed(new C1174Di(this), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }
}
