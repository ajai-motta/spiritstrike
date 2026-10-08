package com.fyber.inneractive.sdk.player.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.r0;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.g1;
import com.fyber.inneractive.sdk.util.h1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends RelativeLayout implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1 f1523a;
    public final int b;
    public s0 c;
    public UnitDisplayType d;
    public boolean e;
    public boolean f;
    public n g;
    public boolean h;

    public e(Context context) {
        super(context, null, 0);
        this.f1523a = new g1();
        this.b = 0;
        this.e = false;
        this.f = false;
        this.h = false;
        this.b = Math.min(com.fyber.inneractive.sdk.util.o.e(), com.fyber.inneractive.sdk.util.o.d());
    }

    public abstract void a(h1 h1Var, int i, int i2);

    @Override // com.fyber.inneractive.sdk.player.ui.m
    public boolean a() {
        return false;
    }

    public void c() {
        this.h = true;
    }

    public void d() {
        this.h = false;
    }

    public final void e() {
        boolean globalVisibleRect = isShown() && hasWindowFocus() && this.f && !this.h;
        if (globalVisibleRect) {
            globalVisibleRect = getGlobalVisibleRect(new Rect());
        }
        if (globalVisibleRect == this.e || this.g == null) {
            return;
        }
        IAlog.a("%supdateVisibility changing to %s", IAlog.a(this), Boolean.valueOf(globalVisibleRect));
        this.e = globalVisibleRect;
        this.g.a(globalVisibleRect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        IAlog.a("%sGot onAttachedToWindow: mIsAttached = %s", IAlog.a(this), Boolean.valueOf(this.f));
        this.f = true;
        n nVar = this.g;
        if (nVar != null) {
            nVar.a();
        }
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IAlog.a("%sGot onDetachedFromWindow: mIsAttached = %s", IAlog.a(this), Boolean.valueOf(this.f));
        this.f = false;
        n nVar = this.g;
        if (nVar != null) {
            nVar.c();
        }
        e();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (equals(view)) {
            IAlog.a("%sgot onVisibilityChanged with %d", IAlog.a(this), Integer.valueOf(i));
            e();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        IAlog.a("%sgot onWindowFocusChanged with: %s", IAlog.a(this), Boolean.valueOf(z));
        com.fyber.inneractive.sdk.util.r.b.postDelayed(new d(this, z), 500L);
    }

    public void setListener(n nVar) {
        this.g = nVar;
    }

    public void setUnitConfig(s0 s0Var) {
        this.c = s0Var;
        r0 r0Var = (r0) s0Var;
        this.d = r0Var.e == null ? r0Var.f.j : UnitDisplayType.DEFAULT;
    }
}
