package com.fyber.inneractive.sdk.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.network.w0;
import com.fyber.inneractive.sdk.ui.IFyberAdIdentifier;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.o;

/* JADX INFO: loaded from: classes3.dex */
public class FyberAdIdentifierLocal extends IFyberAdIdentifier implements View.OnClickListener {
    public ImageView m;
    public TextView n;
    public boolean o;
    public Animator p;
    public float q;
    public Bitmap r;

    public FyberAdIdentifierLocal(r rVar) {
        super(rVar);
        this.o = false;
        this.q = 0.0f;
    }

    @Override // com.fyber.inneractive.sdk.ui.IFyberAdIdentifier
    public final void a(ViewGroup viewGroup) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.ia_identifier_overlay);
        int i = 0;
        ViewGroup viewGroup3 = (ViewGroup) layoutInflaterFrom.inflate(R.layout.ia_layout_fyber_ad_identifier, viewGroup2, false);
        this.m = (ImageView) viewGroup3.findViewById(R.id.ia_fyber_identifier_image);
        TextView textView = (TextView) viewGroup3.findViewById(R.id.ia_fyber_identifier_text);
        this.n = textView;
        if (this.j) {
            int i2 = this.b;
            int i3 = this.c;
            if (textView != null && textView.getLayoutParams() != null) {
                textView.getLayoutParams().width = o.b(i2);
                textView.getLayoutParams().height = o.b(i3);
            }
            ImageView imageView = this.m;
            int i4 = this.d;
            int i5 = this.e;
            if (imageView != null && imageView.getLayoutParams() != null) {
                imageView.getLayoutParams().width = o.b(i4);
                imageView.getLayoutParams().height = o.b(i5);
            }
            TextView textView2 = this.n;
            int i6 = this.f;
            if (textView2 instanceof TextView) {
                textView2.setTextSize(i6);
            }
            a(this.m, this.g);
            this.n.setOnClickListener(this);
            this.n.setText(this.h);
            String str = this.i;
            if (!TextUtils.isEmpty(str)) {
                IAConfigManager.O.s.a(new w0(new b(this), viewGroup2.getContext(), new com.fyber.inneractive.sdk.cache.b(str)));
            }
        }
        IFyberAdIdentifier.Corner corner = this.k;
        if (corner == IFyberAdIdentifier.Corner.TOP_LEFT || corner == IFyberAdIdentifier.Corner.BOTTOM_LEFT) {
            viewGroup3.removeView(this.n);
            viewGroup3.addView(this.n);
            viewGroup3.setLayoutDirection(0);
        }
        viewGroup3.addOnLayoutChangeListener(new c(this));
        this.m.setOnClickListener(this);
        a();
        viewGroup2.addView(viewGroup3);
        IFyberAdIdentifier.Corner corner2 = this.k;
        corner2.getClass();
        int i7 = j.f1641a[corner2.ordinal()];
        if (i7 == 1) {
            i = 51;
        } else if (i7 == 2) {
            i = 53;
        } else if (i7 == 3) {
            i = 83;
        } else if (i7 == 4) {
            i = 85;
        }
        o.a(viewGroup3, i);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view != this.m) {
            if (view == this.n && this.l == com.fyber.inneractive.sdk.config.global.features.a.OPEN) {
                a();
                IFyberAdIdentifier.ClickListener clickListener = this.f1630a;
                if (clickListener != null) {
                    clickListener.a();
                    return;
                }
                return;
            }
            return;
        }
        if (this.p != null) {
            return;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ImageView imageView = this.m;
        Property property = View.ROTATION_X;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) property, 90.0f);
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.m, "imageAlpha", 255, 25);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(objectAnimatorOfFloat, objectAnimatorOfInt);
        animatorSet2.addListener(new d(this, animatorSet));
        animatorSet2.setDuration(225L);
        this.p = animatorSet2;
        animatorSet2.start();
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.m, (Property<ImageView, Float>) property, 0.0f);
        ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this.m, "imageAlpha", 25, 255);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playTogether(objectAnimatorOfFloat2, objectAnimatorOfInt2);
        animatorSet3.setDuration(225L);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.n, (Property<TextView, Float>) View.TRANSLATION_X, this.o ? this.q : 0.0f);
        objectAnimatorOfFloat3.setDuration(450L);
        animatorSet.setDuration(450L);
        animatorSet.playTogether(objectAnimatorOfFloat3, animatorSet3);
        animatorSet.addListener(new e(this));
    }

    public final void a() {
        this.o = false;
        this.m.setImageResource(R.drawable.ia_fyber_info_button);
        a(this.m, this.g);
        Animator animator = this.p;
        if (animator != null) {
            animator.removeAllListeners();
            this.p = null;
        }
    }

    public static void a(ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                com.fyber.inneractive.sdk.widget.a.a(imageView, ColorStateList.valueOf(Color.parseColor(str)));
                return;
            } catch (Exception unused) {
                IAlog.f("could not parse color %s", str);
                return;
            }
        }
        com.fyber.inneractive.sdk.widget.a.a(imageView, null);
    }
}
