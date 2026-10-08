package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.applovin.impl.c2;

/* JADX INFO: loaded from: classes2.dex */
public class k extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c2 f316a;
    private boolean b;

    interface a {
        void a();

        void b();
    }

    public k(c2 c2Var, Context context) {
        super(context);
        this.f316a = c2Var;
        setClickable(false);
        setFocusable(false);
    }

    public boolean a() {
        return this.b;
    }

    public void b() {
        a(null);
    }

    public String getIdentifier() {
        return this.f316a.b();
    }

    public void a(a aVar) {
        if (this.b) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        Drawable drawableA = this.f316a.a();
        if (drawableA == null) {
            if (aVar != null) {
                aVar.b();
            }
        } else {
            setBackground(drawableA);
            this.b = true;
            if (aVar != null) {
                aVar.a();
            }
        }
    }
}
