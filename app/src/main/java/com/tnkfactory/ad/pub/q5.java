package com.tnkfactory.ad.pub;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes6.dex */
public final class q5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f3183a;
    public final /* synthetic */ int b;
    public final /* synthetic */ ImageView c;

    public q5(c cVar, int i, ImageView imageView) {
        this.f3183a = cVar;
        this.b = i;
        this.c = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (TextUtils.isEmpty(((s4) this.f3183a.k0.get(this.b)).b)) {
                return;
            }
            this.c.post(new p5(this, Drawable.createFromStream((InputStream) new URL(((s4) this.f3183a.k0.get(this.b)).b).getContent(), "src")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
