package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j;
import kotlin.Unit;

/* JADX INFO: loaded from: classes6.dex */
public final class p {
    public static final Unit a(j.b bVar, Modifier modifier, int i, int i2, Composer composer, int i3) {
        a(bVar, modifier, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j.b r19, androidx.compose.ui.Modifier r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            r0 = r19
            r1 = r22
            r2 = r23
            java.lang.String r3 = "imageResource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            r3 = 1666152349(0x634f779d, float:3.827095E21)
            r4 = r21
            androidx.compose.runtime.Composer r15 = r4.startRestartGroup(r3)
            r4 = r2 & 1
            if (r4 == 0) goto L1b
            r4 = r1 | 6
            goto L2b
        L1b:
            r4 = r1 & 6
            if (r4 != 0) goto L2a
            boolean r4 = r15.changed(r0)
            if (r4 == 0) goto L27
            r4 = 4
            goto L28
        L27:
            r4 = 2
        L28:
            r4 = r4 | r1
            goto L2b
        L2a:
            r4 = r1
        L2b:
            r5 = r2 & 2
            if (r5 == 0) goto L32
            r4 = r4 | 48
            goto L45
        L32:
            r6 = r1 & 48
            if (r6 != 0) goto L45
            r6 = r20
            boolean r7 = r15.changed(r6)
            if (r7 == 0) goto L41
            r7 = 32
            goto L43
        L41:
            r7 = 16
        L43:
            r4 = r4 | r7
            goto L47
        L45:
            r6 = r20
        L47:
            r7 = r4 & 19
            r8 = 18
            if (r7 != r8) goto L5a
            boolean r7 = r15.getSkipping()
            if (r7 != 0) goto L54
            goto L5a
        L54:
            r15.skipToGroupEnd()
            r18 = r15
            goto La7
        L5a:
            if (r5 == 0) goto L60
            androidx.compose.ui.Modifier$Companion r5 = androidx.compose.ui.Modifier.INSTANCE
            r14 = r5
            goto L61
        L60:
            r14 = r6
        L61:
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L6d
            r5 = -1
            java.lang.String r6 = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastResourceImage (VastResourceImage.kt:10)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r3, r4, r5, r6)
        L6d:
            int r3 = r19.f()
            float r3 = (float) r3
            float r3 = androidx.compose.ui.unit.Dp.m3887constructorimpl(r3)
            int r4 = r19.d()
            float r4 = (float) r4
            float r4 = androidx.compose.ui.unit.Dp.m3887constructorimpl(r4)
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m471sizeVpY3zN4(r14, r3, r4)
            java.lang.String r4 = r19.e()
            r3 = 48
            r16 = 1016(0x3f8, float:1.424E-42)
            r5 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r17 = r14
            r14 = r15
            r18 = r15
            r15 = r3
            coil.compose.SingletonAsyncImageKt.m4287AsyncImage3HmZ8SU(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto La5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        La5:
            r6 = r17
        La7:
            androidx.compose.runtime.ScopeUpdateScope r3 = r18.endRestartGroup()
            if (r3 == 0) goto Lb5
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.p$$ExternalSyntheticLambda0 r4 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.p$$ExternalSyntheticLambda0
            r4.<init>()
            r3.updateScope(r4)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.p.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j$b, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
