package com.fyber.inneractive.sdk.model.vast;

import com.fyber.inneractive.sdk.util.w1;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends g {
    public String i;

    public a0() {
        this.f = 1;
    }

    public static a0 c(Node node) {
        a0 a0Var = new a0();
        super.b(node);
        a0Var.i = w1.a(w1.d(node, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.g));
        return a0Var;
    }
}
