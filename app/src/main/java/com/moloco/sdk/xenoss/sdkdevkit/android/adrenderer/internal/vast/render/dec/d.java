package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.l;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static final int g = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a f2955a;
    public List<String> b;
    public List<String> c;
    public List<String> d;
    public final h e;
    public final l f;

    public d(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, List<String> list, List<String> list2, List<String> list3, h buttonTracker, l vastTracker) {
        Intrinsics.checkNotNullParameter(customUserEventBuilderService, "customUserEventBuilderService");
        Intrinsics.checkNotNullParameter(buttonTracker, "buttonTracker");
        Intrinsics.checkNotNullParameter(vastTracker, "vastTracker");
        this.f2955a = customUserEventBuilderService;
        this.b = list;
        this.c = list2;
        this.d = list3;
        this.e = buttonTracker;
        this.f = vastTracker;
    }

    public final void a(a.AbstractC0526a.c button) {
        Intrinsics.checkNotNullParameter(button, "button");
        this.e.a(button);
    }

    public final void b() {
        List<String> list = this.d;
        if (list != null) {
            l.a.a(this.f, list, null, null, null, 14, null);
            this.d = null;
        }
    }

    public final void a(a.AbstractC0526a.c.EnumC0528a buttonType) {
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        this.e.a(buttonType);
    }

    public final void a(a.AbstractC0526a.f position) {
        Intrinsics.checkNotNullParameter(position, "position");
        List<String> list = this.b;
        if (list != null) {
            l.a.a(this.f, list, null, null, null, this.e.p(), this.f2955a, position, 14, null);
            this.b = null;
        }
    }

    public /* synthetic */ d(com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a aVar, List list, List list2, List list3, h hVar, l lVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, list, list2, list3, (i & 16) != 0 ? j.a() : hVar, (i & 32) != 0 ? n.b() : lVar);
    }

    public final void a() {
        List<String> list = this.c;
        if (list != null) {
            l.a.a(this.f, list, null, null, null, 14, null);
            this.c = null;
        }
    }
}
