package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils;

import android.content.res.Resources;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.unit.IntSize;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f2725a = new c();
    public static final int b = 0;

    public final float a(int i) {
        return i / Resources.getSystem().getDisplayMetrics().density;
    }

    public final a.AbstractC0526a.g b(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return new a.AbstractC0526a.g(a(IntSize.m4047getWidthimpl(layoutCoordinates.mo3154getSizeYbymL2g())), a(IntSize.m4046getHeightimpl(layoutCoordinates.mo3154getSizeYbymL2g())));
    }

    public final a.AbstractC0526a.f a(LayoutCoordinates layoutCoordinates) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        return new a.AbstractC0526a.f(a((int) Offset.m1408getXimpl(LayoutCoordinatesKt.positionInRoot(layoutCoordinates))), a((int) Offset.m1409getYimpl(LayoutCoordinatesKt.positionInRoot(layoutCoordinates))));
    }

    public final a.AbstractC0526a.f a(long j) {
        return new a.AbstractC0526a.f(a((int) Offset.m1408getXimpl(j)), a((int) Offset.m1409getYimpl(j)));
    }

    public final a.AbstractC0526a.c a(LayoutCoordinates layoutCoordinates, a.AbstractC0526a.c.EnumC0528a buttonType) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        Intrinsics.checkNotNullParameter(buttonType, "buttonType");
        return new a.AbstractC0526a.c(buttonType, a(layoutCoordinates), b(layoutCoordinates));
    }

    public final boolean a(a.AbstractC0526a.c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        return cVar.f().c() > 0.0f && cVar.f().d() > 0.0f;
    }
}
