package com.moloco.sdk.internal.services.events;

import com.moloco.sdk.UserIntent;
import com.moloco.sdk.internal.services.E;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2349a = "CustomUserEventBuilderServiceImpl";
    public static final String b = "user_ad_interaction_ext";

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2350a;

        static {
            int[] iArr = new int[a.AbstractC0526a.c.EnumC0528a.values().length];
            try {
                iArr[a.AbstractC0526a.c.EnumC0528a.f3033a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[a.AbstractC0526a.c.EnumC0528a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[a.AbstractC0526a.c.EnumC0528a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[a.AbstractC0526a.c.EnumC0528a.d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[a.AbstractC0526a.c.EnumC0528a.e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[a.AbstractC0526a.c.EnumC0528a.f.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[a.AbstractC0526a.c.EnumC0528a.g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[a.AbstractC0526a.c.EnumC0528a.h.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[a.AbstractC0526a.c.EnumC0528a.i.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            f2350a = iArr;
        }
    }

    public static final UserIntent.UserAdInteractionExt.Button.Type a(a.AbstractC0526a.c.EnumC0528a enumC0528a) {
        Intrinsics.checkNotNullParameter(enumC0528a, "<this>");
        switch (a.f2350a[enumC0528a.ordinal()]) {
            case 1:
                return UserIntent.UserAdInteractionExt.Button.Type.NONE;
            case 2:
                return UserIntent.UserAdInteractionExt.Button.Type.CLOSE;
            case 3:
                return UserIntent.UserAdInteractionExt.Button.Type.SKIP;
            case 4:
                return UserIntent.UserAdInteractionExt.Button.Type.DEC_SKIP;
            case 5:
                return UserIntent.UserAdInteractionExt.Button.Type.MUTE;
            case 6:
                return UserIntent.UserAdInteractionExt.Button.Type.UNMUTE;
            case 7:
                return UserIntent.UserAdInteractionExt.Button.Type.CTA;
            case 8:
                return UserIntent.UserAdInteractionExt.Button.Type.REPLAY;
            case 9:
                return UserIntent.UserAdInteractionExt.Button.Type.AD_BADGE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final UserIntent.UserAdInteractionExt.Position a(a.AbstractC0526a.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        UserIntent.UserAdInteractionExt.Position.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.Position.newBuilder();
        builderNewBuilder.setX(fVar.c());
        builderNewBuilder.setY(fVar.d());
        UserIntent.UserAdInteractionExt.Position positionBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(positionBuild, "build(...)");
        return positionBuild;
    }

    public static final UserIntent.UserAdInteractionExt.Size a(a.AbstractC0526a.g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        UserIntent.UserAdInteractionExt.Size.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.Size.newBuilder();
        builderNewBuilder.setW(gVar.d());
        builderNewBuilder.setH(gVar.c());
        UserIntent.UserAdInteractionExt.Size sizeBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(sizeBuild, "build(...)");
        return sizeBuild;
    }

    public static final UserIntent.UserAdInteractionExt.Size a(E e) {
        Intrinsics.checkNotNullParameter(e, "<this>");
        UserIntent.UserAdInteractionExt.Size.Builder builderNewBuilder = UserIntent.UserAdInteractionExt.Size.newBuilder();
        builderNewBuilder.setW(e.m());
        builderNewBuilder.setH(e.k());
        UserIntent.UserAdInteractionExt.Size sizeBuild = builderNewBuilder.build();
        Intrinsics.checkNotNullExpressionValue(sizeBuild, "build(...)");
        return sizeBuild;
    }
}
