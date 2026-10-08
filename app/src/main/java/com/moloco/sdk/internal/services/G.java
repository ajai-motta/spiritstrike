package com.moloco.sdk.internal.services;

import android.content.Context;
import com.moloco.sdk.common_adapter_internal.ScreenData;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class G implements F {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2284a;

    public G(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f2284a = context;
    }

    @Override // com.moloco.sdk.internal.services.F
    public E a() {
        ScreenData screenDataInvoke = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.s.a(this.f2284a).invoke();
        float widthDp = screenDataInvoke.getWidthDp();
        return new E(screenDataInvoke.getWidthPx(), widthDp, screenDataInvoke.getHeightPx(), screenDataInvoke.getHeightDp(), screenDataInvoke.getPxRatio(), screenDataInvoke.getDpi(), this.f2284a.getResources().getDisplayMetrics().xdpi, this.f2284a.getResources().getDisplayMetrics().ydpi);
    }

    @Override // com.moloco.sdk.internal.services.F
    public H b() {
        int i = this.f2284a.getResources().getConfiguration().orientation;
        return i != 1 ? i != 2 ? H.f2285a : H.c : H.b;
    }

    public final Context c() {
        return this.f2284a;
    }

    @Override // com.moloco.sdk.internal.services.F
    @Deprecated(message = "Use screenInfo() instead", replaceWith = @ReplaceWith(expression = "screenInfo()", imports = {}))
    public E invoke() {
        return a();
    }
}
