package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.TextUnit;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f2724a;
    public static final float b;
    public static final long c;
    public static final long d;
    public static final long e;
    public static final RoundedCornerShape f;

    static {
        float fM3887constructorimpl = Dp.m3887constructorimpl(24);
        f2724a = fM3887constructorimpl;
        b = Dp.m3887constructorimpl(4);
        c = TextUnit.INSTANCE.m4079getUnspecifiedXSAIIZE();
        d = DpKt.m3909DpSizeYgX7TsA(fM3887constructorimpl, fM3887constructorimpl);
        e = Color.m1644copywmQWz5c$default(Color.INSTANCE.m1675getGray0d7_KjU(), 0.2f, 0.0f, 0.0f, 0.0f, 14, null);
        f = RoundedCornerShapeKt.getCircleShape();
    }

    public static final float a() {
        return b;
    }

    public static final long b() {
        return d;
    }

    public static final float c() {
        return f2724a;
    }

    public static final long d() {
        return c;
    }

    public static final long e() {
        return e;
    }

    public static final RoundedCornerShape f() {
        return f;
    }
}
