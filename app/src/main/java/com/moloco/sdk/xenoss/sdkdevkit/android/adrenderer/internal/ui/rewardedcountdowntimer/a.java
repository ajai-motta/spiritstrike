package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.moloco.sdk.internal.ortb.model.i;
import kotlin.Unit;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static final Unit a(i iVar, int i, int i2, int i3, Composer composer, int i4) {
        a(iVar, i, i2, composer, i3 | 1);
        return Unit.INSTANCE;
    }

    public static final Unit b() {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0262  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final com.moloco.sdk.internal.ortb.model.i r23, final int r24, final int r25, androidx.compose.runtime.Composer r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 634
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.rewardedcountdowntimer.a.a(com.moloco.sdk.internal.ortb.model.i, int, int, androidx.compose.runtime.Composer, int):void");
    }

    public static final Unit b(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.setTestTag(semantics, str);
        return Unit.INSTANCE;
    }

    public static final Unit a(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.setTestTag(semantics, str);
        return Unit.INSTANCE;
    }

    public static final Unit a() {
        return Unit.INSTANCE;
    }

    public static final float a(int i, int i2) {
        return ((float) UnsignedKt.uintToDouble(i)) / ((float) UnsignedKt.uintToDouble(i2));
    }
}
