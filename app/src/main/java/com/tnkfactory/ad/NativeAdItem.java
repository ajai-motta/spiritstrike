package com.tnkfactory.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tnkfactory.ad.pub.c1;
import com.tnkfactory.ad.pub.e1;
import com.tnkfactory.ad.pub.h1;
import com.tnkfactory.ad.pub.l;

/* JADX INFO: loaded from: classes6.dex */
public class NativeAdItem implements AdItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f3100a;
    public final Context b;

    public NativeAdItem(Context context, String str) {
        this.b = context;
        this.f3100a = l.a(this).a(str);
    }

    public void attach(ViewGroup viewGroup, NativeViewBinder nativeViewBinder) {
        this.f3100a.a(viewGroup, nativeViewBinder);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void close() {
    }

    public String getAdDesc() {
        return this.f3100a.e.t;
    }

    public Bitmap getAdIconBitmap() {
        e1 e1Var = (e1) this.f3100a.e.g0.get(h1.a("c77c0895e65f"));
        if (e1Var != null) {
            return e1Var.f3124a;
        }
        return null;
    }

    public Bitmap getAdMarkBitmap() {
        e1 e1Var = (e1) this.f3100a.e.g0.get(h1.a("c77c0c97fb5a"));
        if (e1Var != null) {
            return e1Var.f3124a;
        }
        return null;
    }

    public float getAdRating() {
        return this.f3100a.e.v;
    }

    public String getAdTitle() {
        return this.f3100a.e.s;
    }

    public View getImageView(Context context) {
        return this.f3100a.b(context);
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getPlacementId() {
        c1 c1Var = this.f3100a;
        if (c1Var != null) {
            return c1Var.f3115a;
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getTransactionId() {
        c1 c1Var = this.f3100a;
        if (c1Var != null) {
            return c1Var.d();
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public Object getValue(String str) {
        c1 c1Var = this.f3100a;
        if (c1Var != null) {
            return c1Var.c.get(str);
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isEmpty() {
        c1 c1Var = this.f3100a;
        return c1Var == null || c1Var.d == 0;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isInvalidated() {
        c1 c1Var = this.f3100a;
        if (c1Var != null) {
            return c1Var.f();
        }
        return true;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isLoaded() {
        c1 c1Var = this.f3100a;
        if (c1Var != null) {
            return c1Var.g();
        }
        return false;
    }

    @Override // com.tnkfactory.ad.AdItem
    public void load() {
        c1 c1Var = this.f3100a;
        if (c1Var != null) {
            c1Var.a(this.b, true);
        }
    }

    public void loadCallbackOnIoThread() {
        c1 c1Var = this.f3100a;
        if (c1Var != null) {
            c1Var.a(this.b, false);
        }
    }

    public void sendImpression(Context context) {
        this.f3100a.c(context);
    }

    public void setAdEventView(ViewGroup viewGroup) {
        this.f3100a.a(viewGroup);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setListener(AdListener adListener) {
        c1 c1Var = this.f3100a;
        if (c1Var != null) {
            c1Var.b = adListener;
        }
    }

    public void setPolicyEventView(View view) {
        this.f3100a.a(view);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setValue(String str, Object obj) {
        c1 c1Var = this.f3100a;
        if (c1Var != null) {
            c1Var.c.put(str, obj);
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show() {
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show(Context context) {
    }

    public NativeAdItem(Context context, String str, AdListener adListener) {
        this(context, str);
        setListener(adListener);
    }
}
