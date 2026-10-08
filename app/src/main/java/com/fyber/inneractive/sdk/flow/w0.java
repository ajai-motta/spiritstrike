package com.fyber.inneractive.sdk.flow;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.external.MediaView;
import com.fyber.inneractive.sdk.external.NativeAdContent;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class w0 extends x implements NativeAdContent, com.fyber.inneractive.sdk.flow.nativead.u {
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public Uri l;
    public Uri m;
    public MediaView n;
    public Float o;
    public Float p;
    public final ArrayList q;
    public com.fyber.inneractive.sdk.flow.nativead.r r;
    public t0 s;
    public final HashMap t;
    public com.fyber.inneractive.sdk.flow.nativead.j u;
    public com.fyber.inneractive.sdk.flow.nativead.a v;
    public final ArrayList w;
    public final ArrayList x;

    public w0(com.fyber.inneractive.sdk.config.s0 s0Var, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(s0Var, rVar);
        this.q = new ArrayList();
        this.t = new HashMap();
        this.w = new ArrayList();
        this.x = new ArrayList();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.lang.String r7) {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.w0.b(java.lang.String):void");
    }

    @Override // com.fyber.inneractive.sdk.external.NativeAdContent
    public final void bindMediaView(MediaView mediaView) {
        this.n = mediaView;
        com.fyber.inneractive.sdk.flow.nativead.a aVar = this.v;
        if (aVar != null) {
            aVar.bind(mediaView);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final void destroy() {
        t0 t0Var = this.s;
        if (t0Var != null) {
            t0Var.destroy();
            this.s = null;
        }
        com.fyber.inneractive.sdk.flow.nativead.j jVar = this.u;
        if (jVar != null) {
            jVar.b = null;
            jVar.c.f1083a = null;
            this.u = null;
        }
        if (this.v != null) {
            this.v = null;
        }
        for (View view : this.q) {
            if (view != null) {
                view.setOnClickListener(null);
            }
        }
        for (View view2 : this.q) {
            if (view2 != null) {
                view2.setOnTouchListener(null);
            }
        }
        this.r = null;
        this.q.clear();
        this.k = null;
        this.o = null;
        this.l = null;
        this.g = null;
        this.m = null;
        this.n = null;
        this.h = null;
        this.j = null;
        this.i = null;
        this.p = null;
        this.t.clear();
        this.w.clear();
        this.x.clear();
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final boolean e() {
        return (this.m == null && this.n == null) ? false : true;
    }

    @Override // com.fyber.inneractive.sdk.external.NativeAdContent
    public final String getAdCallToAction() {
        return this.i;
    }

    @Override // com.fyber.inneractive.sdk.external.NativeAdContent
    public final String getAdDescription() {
        return this.h;
    }

    @Override // com.fyber.inneractive.sdk.external.NativeAdContent
    public final String getAdTitle() {
        return this.g;
    }

    @Override // com.fyber.inneractive.sdk.external.NativeAdContent
    public final String getAdvertiserName() {
        return this.j;
    }

    @Override // com.fyber.inneractive.sdk.external.NativeAdContent
    public final Uri getAppIcon() {
        return this.l;
    }

    @Override // com.fyber.inneractive.sdk.external.NativeAdContent
    public final Float getMediaAspectRatio() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.external.NativeAdContent
    public final MediaView getMediaView() {
        return this.n;
    }

    @Override // com.fyber.inneractive.sdk.external.NativeAdContent
    public final String getPrice() {
        return this.k;
    }

    @Override // com.fyber.inneractive.sdk.external.NativeAdContent
    public final Float getRating() {
        return this.o;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public boolean isVideoAd() {
        return this.s != null;
    }

    @Override // com.fyber.inneractive.sdk.external.NativeAdContent
    public final void registerViewsForInteraction(ViewGroup viewGroup, MediaView mediaView, ImageView imageView, Collection collection) {
        this.q.clear();
        if (collection != null) {
            this.q.addAll(collection);
        }
        if (viewGroup != null && !this.q.contains(viewGroup)) {
            this.q.add(viewGroup);
        }
        if (mediaView != null && !this.q.contains(mediaView)) {
            this.q.add(mediaView);
        }
        if (imageView != null && !this.q.contains(imageView)) {
            this.q.add(imageView);
        }
        MediaView mediaView2 = this.n;
        if (mediaView2 == null || mediaView2.getContext() == null) {
            IAlog.b("%sCould not attach NativeAdViewGestureDetector, MediaView or its context are null", "w0");
            return;
        }
        this.r = new com.fyber.inneractive.sdk.flow.nativead.r(this.n.getContext(), this);
        for (View view : this.q) {
            if (view != null) {
                view.setOnTouchListener(this.r);
            }
        }
    }
}
