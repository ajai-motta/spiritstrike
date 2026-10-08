package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3036q;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f2702a = ColorKt.Color$default(71, 118, 238, 0, 8, null);
    public static final long b = Color.INSTANCE.m1682getWhite0d7_KjU();

    public static final class a implements Function3<RowScope, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2703a;
        public final /* synthetic */ Integer b;
        public final /* synthetic */ long c;

        public a(String str, Integer num, long j) {
            this.f2703a = str;
            this.b = num;
            this.c = j;
        }

        public final void a(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-469621531, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.RotatingGradientButton.<anonymous> (DEC.kt:232)");
            }
            String str = this.f2703a;
            if (str == null) {
                str = "";
            }
            Integer num = this.b;
            TextUnit textUnitM4058boximpl = num != null ? TextUnit.m4058boximpl(TextUnitKt.getSp(num.intValue())) : null;
            composer.startReplaceableGroup(-1245054604);
            long jM3536getFontSizeXSAIIZE = textUnitM4058boximpl == null ? MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getButton().m3536getFontSizeXSAIIZE() : textUnitM4058boximpl.getPackedValue();
            composer.endReplaceableGroup();
            TextKt.m1258TextfLXpl1I(str, null, this.c, jM3536getFontSizeXSAIIZE, null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, TextOverflow.INSTANCE.m3817getEllipsisgIe3tQ8(), false, 1, null, null, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 3120, 55250);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            a(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(Modifier modifier, String str, Function0 function0, C3036q c3036q, int i, int i2, Composer composer, int i3) {
        a(modifier, str, function0, c3036q, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final Unit a(int i, Composer composer, int i2) {
        a(composer, i | 1);
        return Unit.INSTANCE;
    }

    public static final Unit a(String str, Function0 function0, Integer num, Integer num2, List list, boolean z, long j, long j2, int i, boolean z2, int i2, int i3, Composer composer, int i4) {
        a(str, function0, num, num2, list, z, j, j2, i, z2, composer, i2 | 1, i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x046b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x04de  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x054d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0555  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x055a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0596  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x059b  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05a0  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(androidx.compose.ui.Modifier r36, final java.lang.String r37, final kotlin.jvm.functions.Function0<kotlin.Unit> r38, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3036q r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 1545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.p.a(androidx.compose.ui.Modifier, java.lang.String, kotlin.jvm.functions.Function0, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.q, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:146:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final java.lang.String r41, final kotlin.jvm.functions.Function0<kotlin.Unit> r42, final java.lang.Integer r43, final java.lang.Integer r44, final java.util.List<java.lang.String> r45, final boolean r46, final long r47, final long r49, final int r51, boolean r52, androidx.compose.runtime.Composer r53, final int r54, final int r55) {
        /*
            Method dump skipped, instruction units count: 771
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.p.a(java.lang.String, kotlin.jvm.functions.Function0, java.lang.Integer, java.lang.Integer, java.util.List, boolean, long, long, int, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void a(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-227963495);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-227963495, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.DECPreview (DEC.kt:248)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, l.f2695a.a(), composerStartRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.p$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return p.a(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final float a(State<Float> state) {
        return state.getValue().floatValue();
    }
}
