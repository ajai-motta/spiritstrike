package com.bytedance.sdk.component.adexpress.mo;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: classes3.dex */
public class jpc extends oth {
    private ImageView lnr;
    private ImageView mml;
    private AnimatorSet mo;
    private int mzz;
    private TextView qdl;
    private ImageView ud;

    @Override // com.bytedance.sdk.component.adexpress.mo.oth
    protected void qdl(Context context) {
    }

    public jpc(Context context) {
        super(context);
        this.mo = new AnimatorSet();
        ud(context);
    }

    private void ud(Context context) {
        addView(com.bytedance.sdk.component.adexpress.lnr.qdl.ud(context));
        this.ud = (ImageView) findViewById(2097610751);
        this.lnr = (ImageView) findViewById(2097610750);
        this.mml = (ImageView) findViewById(2097610749);
        this.qdl = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.qdl == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.qdl.setText(str);
    }

    private void mml() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    public float getAlphaColor() {
        return this.mzz;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + 195;
        this.mml.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
        int i3 = ((i + 20) % 60) + 195;
        this.lnr.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
        int i4 = ((i + 40) % 60) + 195;
        this.ud.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
    }

    @Override // com.bytedance.sdk.component.adexpress.mo.oth
    public void qdl() {
        mml();
    }

    @Override // com.bytedance.sdk.component.adexpress.mo.oth
    public void ud() {
        this.mo.cancel();
    }
}
