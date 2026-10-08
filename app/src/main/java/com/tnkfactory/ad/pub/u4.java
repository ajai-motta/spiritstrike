package com.tnkfactory.ad.pub;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes6.dex */
public final class u4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s4 f3204a;
    public final /* synthetic */ ImageView b;

    public u4(s4 s4Var, ImageView imageView) {
        this.f3204a = s4Var;
        this.b = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (TextUtils.isEmpty(this.f3204a.b)) {
                return;
            }
            this.b.post(new t4(this, Drawable.createFromStream((InputStream) new URL(this.f3204a.b).getContent(), "src")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
