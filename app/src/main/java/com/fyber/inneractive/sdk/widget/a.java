package com.fyber.inneractive.sdk.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PorterDuff.Mode f1725a = PorterDuff.Mode.SRC_IN;

    public static void a(ImageView imageView, ColorStateList colorStateList) {
        imageView.setImageTintList(colorStateList);
    }
}
