package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme;

import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Colors f2722a;
    public static final Colors b;

    static {
        long jF = a.f();
        long jF2 = a.f();
        Color.Companion companion = Color.INSTANCE;
        f2722a = ColorsKt.m1011darkColors2qZNXz8$default(jF, jF2, companion.m1682getWhite0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 4088, null);
        b = ColorsKt.m1012lightColors2qZNXz8((4088 & 1) != 0 ? ColorKt.Color(4284612846L) : a.f(), (4088 & 2) != 0 ? ColorKt.Color(4281794739L) : a.f(), (4088 & 4) != 0 ? ColorKt.Color(4278442694L) : companion.m1682getWhite0d7_KjU(), (4088 & 8) != 0 ? ColorKt.Color(4278290310L) : 0L, (4088 & 16) != 0 ? Color.INSTANCE.m1682getWhite0d7_KjU() : 0L, (4088 & 32) != 0 ? Color.INSTANCE.m1682getWhite0d7_KjU() : 0L, (4088 & 64) != 0 ? ColorKt.Color(4289724448L) : 0L, (4088 & 128) != 0 ? Color.INSTANCE.m1682getWhite0d7_KjU() : 0L, (4088 & 256) != 0 ? Color.INSTANCE.m1671getBlack0d7_KjU() : 0L, (4088 & 512) != 0 ? Color.INSTANCE.m1671getBlack0d7_KjU() : 0L, (4088 & 1024) != 0 ? Color.INSTANCE.m1671getBlack0d7_KjU() : 0L, (4088 & 2048) != 0 ? Color.INSTANCE.m1682getWhite0d7_KjU() : 0L);
    }

    public static final Unit a(boolean z, Function2 function2, int i, int i2, Composer composer, int i3) {
        a(z, function2, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final boolean r8, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r9, androidx.compose.runtime.Composer r10, final int r11, final int r12) {
        /*
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 156854067(0x9596733, float:2.6168949E-33)
            androidx.compose.runtime.Composer r10 = r10.startRestartGroup(r0)
            r1 = r11 & 6
            if (r1 != 0) goto L1f
            r1 = r12 & 1
            if (r1 != 0) goto L1c
            boolean r1 = r10.changed(r8)
            if (r1 == 0) goto L1c
            r1 = 4
            goto L1d
        L1c:
            r1 = 2
        L1d:
            r1 = r1 | r11
            goto L20
        L1f:
            r1 = r11
        L20:
            r2 = r12 & 2
            if (r2 == 0) goto L27
            r1 = r1 | 48
            goto L37
        L27:
            r2 = r11 & 48
            if (r2 != 0) goto L37
            boolean r2 = r10.changed(r9)
            if (r2 == 0) goto L34
            r2 = 32
            goto L36
        L34:
            r2 = 16
        L36:
            r1 = r1 | r2
        L37:
            r2 = r1 & 19
            r3 = 18
            if (r2 != r3) goto L48
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L44
            goto L48
        L44:
            r10.skipToGroupEnd()
            goto L9d
        L48:
            r10.startDefaults()
            r2 = r11 & 1
            if (r2 == 0) goto L5e
            boolean r2 = r10.getDefaultsInvalid()
            if (r2 == 0) goto L56
            goto L5e
        L56:
            r10.skipToGroupEnd()
            r2 = r12 & 1
            if (r2 == 0) goto L69
            goto L67
        L5e:
            r2 = r12 & 1
            if (r2 == 0) goto L69
            r8 = 0
            boolean r8 = androidx.compose.foundation.DarkThemeKt.isSystemInDarkTheme(r10, r8)
        L67:
            r1 = r1 & (-15)
        L69:
            r10.endDefaults()
            boolean r2 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r2 == 0) goto L78
            r2 = -1
            java.lang.String r3 = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.Theme (Theme.kt:31)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r1, r2, r3)
        L78:
            if (r8 == 0) goto L7d
            androidx.compose.material.Colors r0 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.f2722a
            goto L7f
        L7d:
            androidx.compose.material.Colors r0 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.b
        L7f:
            androidx.compose.material.Typography r2 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.d.a()
            androidx.compose.material.Shapes r3 = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.b.a()
            int r1 = r1 << 6
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r6 = r1 | 432(0x1b0, float:6.05E-43)
            r7 = 0
            r1 = r0
            r4 = r9
            r5 = r10
            androidx.compose.material.MaterialThemeKt.MaterialTheme(r1, r2, r3, r4, r5, r6, r7)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L9d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L9d:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 == 0) goto Lab
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c$$ExternalSyntheticLambda0 r0 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c$$ExternalSyntheticLambda0
            r0.<init>()
            r10.updateScope(r0)
        Lab:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.a(boolean, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }
}
