package com.tnkfactory.ad;

import android.content.Context;
import com.tnkfactory.ad.pub.c1;
import com.tnkfactory.ad.pub.l;

/* JADX INFO: loaded from: classes6.dex */
public class InterstitialAdItem implements AdItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f3098a;
    public final Context b;

    public InterstitialAdItem(Context context, String str) {
        this.b = context;
        this.f3098a = l.a(this).a(str);
    }

    @Override // com.tnkfactory.ad.AdItem
    public void close() {
        this.f3098a.b();
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getPlacementId() {
        c1 c1Var = this.f3098a;
        if (c1Var != null) {
            return c1Var.f3115a;
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public String getTransactionId() {
        c1 c1Var = this.f3098a;
        if (c1Var != null) {
            return c1Var.d();
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public Object getValue(String str) {
        c1 c1Var = this.f3098a;
        if (c1Var != null) {
            return c1Var.c.get(str);
        }
        return null;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isEmpty() {
        c1 c1Var = this.f3098a;
        return c1Var == null || c1Var.d == 0;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isInvalidated() {
        c1 c1Var = this.f3098a;
        if (c1Var != null) {
            return c1Var.f();
        }
        return true;
    }

    @Override // com.tnkfactory.ad.AdItem
    public boolean isLoaded() {
        c1 c1Var = this.f3098a;
        if (c1Var != null) {
            return c1Var.g();
        }
        return false;
    }

    @Override // com.tnkfactory.ad.AdItem
    public void load() {
        c1 c1Var = this.f3098a;
        if (c1Var != null) {
            c1Var.a(this.b, true);
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setListener(AdListener adListener) {
        c1 c1Var = this.f3098a;
        if (c1Var != null) {
            c1Var.b = adListener;
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void setValue(String str, Object obj) {
        c1 c1Var = this.f3098a;
        if (c1Var != null) {
            c1Var.c.put(str, obj);
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show() {
        c1 c1Var = this.f3098a;
        if (c1Var != null) {
            c1Var.d(this.b);
        }
    }

    @Override // com.tnkfactory.ad.AdItem
    public void show(Context context) {
        c1 c1Var = this.f3098a;
        if (c1Var != null) {
            c1Var.d(context);
        }
    }

    public InterstitialAdItem(Context context, String str, AdListener adListener) {
        this(context, str);
        setListener(adListener);
    }
}
