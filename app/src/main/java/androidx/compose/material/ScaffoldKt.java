package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¢\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0013\b\u0002\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\u0019\b\u0002\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u00102\u0013\b\u0002\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u00102\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192 \b\u0002\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00192\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\b\b\u0002\u0010&\u001a\u00020\"2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001a£\u0001\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u00172\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.2\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\t0\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\b.H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\u001a!\u00103\u001a\u00020\r2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u0014H\u0007¢\u0006\u0002\u00107\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00068"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "Scaffold", "", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "bottomBar", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "isFloatingActionButtonDocked", "", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "isFabDocked", "fabPosition", "Landroidx/compose/ui/UiComposable;", "snackbar", "fab", "ScaffoldLayout-MDYNRJg", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ScaffoldKt {
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = Dp.m3887constructorimpl(16);

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1569641925);
        ComposerKt.sourceInformation(composer, "C(rememberScaffoldState)63@2263L39,64@2347L32,65@2399L62:Scaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "C(remember):Composables.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) objRememberedValue2;
        composer.endReplaceableGroup();
        return scaffoldState;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03f2  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04da  */
    /* JADX WARN: Removed duplicated region for block: B:294:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0144  */
    /* JADX INFO: renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m1158Scaffold27mzLpw(androidx.compose.ui.Modifier r39, androidx.compose.material.ScaffoldState r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, int r45, boolean r46, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, boolean r48, androidx.compose.ui.graphics.Shape r49, float r50, long r51, long r53, long r55, long r57, long r59, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, androidx.compose.runtime.Composer r62, final int r63, final int r64, final int r65) {
        /*
            Method dump skipped, instruction units count: 1279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m1158Scaffold27mzLpw(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ScaffoldLayout-MDYNRJg, reason: not valid java name */
    public static final void m1159ScaffoldLayoutMDYNRJg(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1401632215);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScaffoldLayout)P(4,3:c#material.FabPosition,6,1,5,2)236@10234L4498,236@10217L4515:Scaffold.kt#jmzs0o");
        int i5 = (i2 & 14) == 0 ? (composerStartRestartGroup.changed(z) ? 4 : 2) | i2 : i2;
        if ((i2 & 112) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i5 |= composerStartRestartGroup.changed(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i5 |= composerStartRestartGroup.changed(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i5 |= composerStartRestartGroup.changed(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i5 |= composerStartRestartGroup.changed(function23) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i5 |= composerStartRestartGroup.changed(function24) ? 1048576 : 524288;
        }
        final int i6 = i5;
        if ((i6 & 2995931) != 599186 || !composerStartRestartGroup.getSkipping()) {
            Object[] objArr = {function2, function22, function23, FabPosition.m1071boximpl(i), Boolean.valueOf(z), function24, function3};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = false;
            for (int i7 = 0; i7 < 7; i7++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i7]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                i3 = 1;
                i4 = 0;
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1161invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1161invoke0kLqBqw(final SubcomposeMeasureScope SubcomposeLayout, long j) {
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        final int iM3831getMaxWidthimpl = Constraints.m3831getMaxWidthimpl(j);
                        final int iM3830getMaxHeightimpl = Constraints.m3830getMaxHeightimpl(j);
                        final long jM3822copyZbe2FdA$default = Constraints.m3822copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        final Function2<Composer, Integer, Unit> function25 = function2;
                        final Function2<Composer, Integer, Unit> function26 = function22;
                        final Function2<Composer, Integer, Unit> function27 = function23;
                        final int i8 = i;
                        final boolean z2 = z;
                        final Function2<Composer, Integer, Unit> function28 = function24;
                        final int i9 = i6;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.CC.layout$default(SubcomposeLayout, iM3831getMaxWidthimpl, iM3830getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                                invoke2(placementScope);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Placeable.PlacementScope layout) {
                                Object obj;
                                Object obj2;
                                final FabPlacement fabPlacement;
                                int i10;
                                Object obj3;
                                Integer numValueOf;
                                int iIntValue;
                                int height;
                                int i11;
                                int height2;
                                Object obj4;
                                Object obj5;
                                int i12;
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                List<Measurable> listSubcompose = SubcomposeLayout.subcompose(ScaffoldLayoutContent.TopBar, function25);
                                long j2 = jM3822copyZbe2FdA$default;
                                ArrayList arrayList = new ArrayList(listSubcompose.size());
                                int size = listSubcompose.size();
                                for (int i13 = 0; i13 < size; i13++) {
                                    arrayList.add(listSubcompose.get(i13).mo3152measureBRTryo0(j2));
                                }
                                ArrayList arrayList2 = arrayList;
                                if (arrayList2.isEmpty()) {
                                    obj = null;
                                } else {
                                    obj = arrayList2.get(0);
                                    int height3 = ((Placeable) obj).getHeight();
                                    int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                                    if (1 <= lastIndex) {
                                        int i14 = 1;
                                        while (true) {
                                            Object obj6 = arrayList2.get(i14);
                                            int height4 = ((Placeable) obj6).getHeight();
                                            if (height3 < height4) {
                                                obj = obj6;
                                                height3 = height4;
                                            }
                                            if (i14 == lastIndex) {
                                                break;
                                            } else {
                                                i14++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable = (Placeable) obj;
                                int height5 = placeable != null ? placeable.getHeight() : 0;
                                List<Measurable> listSubcompose2 = SubcomposeLayout.subcompose(ScaffoldLayoutContent.Snackbar, function26);
                                long j3 = jM3822copyZbe2FdA$default;
                                ArrayList arrayList3 = new ArrayList(listSubcompose2.size());
                                int size2 = listSubcompose2.size();
                                for (int i15 = 0; i15 < size2; i15++) {
                                    arrayList3.add(listSubcompose2.get(i15).mo3152measureBRTryo0(j3));
                                }
                                ArrayList arrayList4 = arrayList3;
                                if (arrayList4.isEmpty()) {
                                    obj2 = null;
                                } else {
                                    obj2 = arrayList4.get(0);
                                    int height6 = ((Placeable) obj2).getHeight();
                                    int lastIndex2 = CollectionsKt.getLastIndex(arrayList4);
                                    if (1 <= lastIndex2) {
                                        int i16 = 1;
                                        while (true) {
                                            Object obj7 = arrayList4.get(i16);
                                            int height7 = ((Placeable) obj7).getHeight();
                                            if (height6 < height7) {
                                                obj2 = obj7;
                                                height6 = height7;
                                            }
                                            if (i16 == lastIndex2) {
                                                break;
                                            } else {
                                                i16++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable2 = (Placeable) obj2;
                                int height8 = placeable2 != null ? placeable2.getHeight() : 0;
                                List<Measurable> listSubcompose3 = SubcomposeLayout.subcompose(ScaffoldLayoutContent.Fab, function27);
                                long j4 = jM3822copyZbe2FdA$default;
                                ArrayList arrayList5 = new ArrayList();
                                Iterator<T> it = listSubcompose3.iterator();
                                while (it.hasNext()) {
                                    Placeable placeableMo3152measureBRTryo0 = ((Measurable) it.next()).mo3152measureBRTryo0(j4);
                                    if (placeableMo3152measureBRTryo0.getHeight() == 0 || placeableMo3152measureBRTryo0.getWidth() == 0) {
                                        placeableMo3152measureBRTryo0 = null;
                                    }
                                    if (placeableMo3152measureBRTryo0 != null) {
                                        arrayList5.add(placeableMo3152measureBRTryo0);
                                    }
                                }
                                ArrayList arrayList6 = arrayList5;
                                if (!(!arrayList6.isEmpty())) {
                                    fabPlacement = null;
                                } else {
                                    if (arrayList6.isEmpty()) {
                                        obj4 = null;
                                    } else {
                                        obj4 = arrayList6.get(0);
                                        int width = ((Placeable) obj4).getWidth();
                                        int lastIndex3 = CollectionsKt.getLastIndex(arrayList6);
                                        if (1 <= lastIndex3) {
                                            int i17 = 1;
                                            while (true) {
                                                Object obj8 = arrayList6.get(i17);
                                                int width2 = ((Placeable) obj8).getWidth();
                                                if (width < width2) {
                                                    obj4 = obj8;
                                                    width = width2;
                                                }
                                                if (i17 == lastIndex3) {
                                                    break;
                                                } else {
                                                    i17++;
                                                }
                                            }
                                        }
                                    }
                                    Intrinsics.checkNotNull(obj4);
                                    int width3 = ((Placeable) obj4).getWidth();
                                    if (arrayList6.isEmpty()) {
                                        obj5 = null;
                                    } else {
                                        obj5 = arrayList6.get(0);
                                        int height9 = ((Placeable) obj5).getHeight();
                                        int lastIndex4 = CollectionsKt.getLastIndex(arrayList6);
                                        if (1 <= lastIndex4) {
                                            int i18 = 1;
                                            while (true) {
                                                Object obj9 = arrayList6.get(i18);
                                                int height10 = ((Placeable) obj9).getHeight();
                                                if (height9 < height10) {
                                                    height9 = height10;
                                                    obj5 = obj9;
                                                }
                                                if (i18 == lastIndex4) {
                                                    break;
                                                } else {
                                                    i18++;
                                                }
                                            }
                                        }
                                    }
                                    Intrinsics.checkNotNull(obj5);
                                    int height11 = ((Placeable) obj5).getHeight();
                                    if (FabPosition.m1074equalsimpl0(i8, FabPosition.INSTANCE.m1079getEnd5ygKITE())) {
                                        i12 = SubcomposeLayout.getLayoutDirection() == LayoutDirection.Ltr ? (iM3831getMaxWidthimpl - SubcomposeLayout.mo311roundToPx0680j_4(ScaffoldKt.FabSpacing)) - width3 : SubcomposeLayout.mo311roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                    } else {
                                        i12 = (iM3831getMaxWidthimpl - width3) / 2;
                                    }
                                    fabPlacement = new FabPlacement(z2, i12, width3, height11);
                                }
                                SubcomposeMeasureScope subcomposeMeasureScope = SubcomposeLayout;
                                ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                                final Function2<Composer, Integer, Unit> function29 = function28;
                                final int i19 = i9;
                                List<Measurable> listSubcompose4 = subcomposeMeasureScope.subcompose(scaffoldLayoutContent, ComposableLambdaKt.composableLambdaInstance(1529070963, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bottomBarPlaceables$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i20) {
                                        ComposerKt.sourceInformation(composer2, "C285@12279L144:Scaffold.kt#jmzs0o");
                                        if ((i20 & 11) != 2 || !composer2.getSkipping()) {
                                            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ScaffoldKt.getLocalFabPlacement().provides(fabPlacement)}, function29, composer2, ((i19 >> 15) & 112) | 8);
                                        } else {
                                            composer2.skipToGroupEnd();
                                        }
                                    }
                                }));
                                long j5 = jM3822copyZbe2FdA$default;
                                ArrayList arrayList7 = new ArrayList(listSubcompose4.size());
                                int size3 = listSubcompose4.size();
                                for (int i20 = 0; i20 < size3; i20++) {
                                    arrayList7.add(listSubcompose4.get(i20).mo3152measureBRTryo0(j5));
                                }
                                ArrayList arrayList8 = arrayList7;
                                if (arrayList8.isEmpty()) {
                                    obj3 = null;
                                    i10 = 0;
                                } else {
                                    i10 = 0;
                                    obj3 = arrayList8.get(0);
                                    int height12 = ((Placeable) obj3).getHeight();
                                    int lastIndex5 = CollectionsKt.getLastIndex(arrayList8);
                                    if (1 <= lastIndex5) {
                                        int i21 = 1;
                                        while (true) {
                                            Object obj10 = arrayList8.get(i21);
                                            int height13 = ((Placeable) obj10).getHeight();
                                            if (height12 < height13) {
                                                obj3 = obj10;
                                                height12 = height13;
                                            }
                                            if (i21 == lastIndex5) {
                                                break;
                                            } else {
                                                i21++;
                                            }
                                        }
                                    }
                                }
                                Placeable placeable3 = (Placeable) obj3;
                                final int height14 = placeable3 != null ? placeable3.getHeight() : i10;
                                if (fabPlacement != null) {
                                    SubcomposeMeasureScope subcomposeMeasureScope2 = SubcomposeLayout;
                                    boolean z3 = z2;
                                    if (height14 == 0) {
                                        height = fabPlacement.getHeight();
                                        i11 = subcomposeMeasureScope2.mo311roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                    } else if (z3) {
                                        height2 = height14 + (fabPlacement.getHeight() / 2);
                                        numValueOf = Integer.valueOf(height2);
                                    } else {
                                        height = fabPlacement.getHeight() + height14;
                                        i11 = subcomposeMeasureScope2.mo311roundToPx0680j_4(ScaffoldKt.FabSpacing);
                                    }
                                    height2 = height + i11;
                                    numValueOf = Integer.valueOf(height2);
                                } else {
                                    numValueOf = null;
                                }
                                if (height8 != 0) {
                                    iIntValue = height8 + (numValueOf != null ? numValueOf.intValue() : height14);
                                } else {
                                    iIntValue = i10;
                                }
                                int i22 = iM3830getMaxHeightimpl - height5;
                                SubcomposeMeasureScope subcomposeMeasureScope3 = SubcomposeLayout;
                                ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                                final SubcomposeMeasureScope subcomposeMeasureScope4 = SubcomposeLayout;
                                final Function3<PaddingValues, Composer, Integer, Unit> function33 = function32;
                                final int i23 = i9;
                                List<Measurable> listSubcompose5 = subcomposeMeasureScope3.subcompose(scaffoldLayoutContent2, ComposableLambdaKt.composableLambdaInstance(-1132241596, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                        invoke(composer2, num.intValue());
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(Composer composer2, int i24) {
                                        ComposerKt.sourceInformation(composer2, "C317@13701L21:Scaffold.kt#jmzs0o");
                                        if ((i24 & 11) != 2 || !composer2.getSkipping()) {
                                            function33.invoke(PaddingKt.m425PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, subcomposeMeasureScope4.mo314toDpu2uoSUM(height14), 7, null), composer2, Integer.valueOf((i23 >> 6) & 112));
                                        } else {
                                            composer2.skipToGroupEnd();
                                        }
                                    }
                                }));
                                long j6 = jM3822copyZbe2FdA$default;
                                ArrayList arrayList9 = new ArrayList(listSubcompose5.size());
                                int size4 = listSubcompose5.size();
                                int i24 = 0;
                                while (i24 < size4) {
                                    arrayList9.add(listSubcompose5.get(i24).mo3152measureBRTryo0(Constraints.m3822copyZbe2FdA$default(j6, 0, 0, 0, i22, 7, null)));
                                    i24++;
                                    listSubcompose5 = listSubcompose5;
                                    size4 = size4;
                                    j6 = j6;
                                }
                                ArrayList arrayList10 = arrayList9;
                                int i25 = 0;
                                for (int size5 = arrayList10.size(); i25 < size5; size5 = size5) {
                                    Placeable.PlacementScope.place$default(layout, (Placeable) arrayList10.get(i25), 0, height5, 0.0f, 4, null);
                                    i25++;
                                    height14 = height14;
                                }
                                int i26 = height14;
                                int size6 = arrayList2.size();
                                for (int i27 = 0; i27 < size6; i27++) {
                                    Placeable.PlacementScope.place$default(layout, (Placeable) arrayList2.get(i27), 0, 0, 0.0f, 4, null);
                                }
                                int i28 = iM3830getMaxHeightimpl;
                                int size7 = arrayList4.size();
                                for (int i29 = 0; i29 < size7; i29++) {
                                    Placeable.PlacementScope.place$default(layout, (Placeable) arrayList4.get(i29), 0, i28 - iIntValue, 0.0f, 4, null);
                                }
                                int i30 = iM3830getMaxHeightimpl;
                                int size8 = arrayList8.size();
                                for (int i31 = 0; i31 < size8; i31++) {
                                    Placeable.PlacementScope.place$default(layout, (Placeable) arrayList8.get(i31), 0, i30 - i26, 0.0f, 4, null);
                                }
                                if (fabPlacement != null) {
                                    int i32 = iM3830getMaxHeightimpl;
                                    int size9 = arrayList6.size();
                                    for (int i33 = 0; i33 < size9; i33++) {
                                        Placeable placeable4 = (Placeable) arrayList6.get(i33);
                                        int left = fabPlacement.getLeft();
                                        Intrinsics.checkNotNull(numValueOf);
                                        Placeable.PlacementScope.place$default(layout, placeable4, left, i32 - numValueOf.intValue(), 0.0f, 4, null);
                                    }
                                    Unit unit = Unit.INSTANCE;
                                    Unit unit2 = Unit.INSTANCE;
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                i3 = 1;
                i4 = 0;
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) objRememberedValue, composerStartRestartGroup, i4, i3);
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                invoke(composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer2, int i8) {
                ScaffoldKt.m1159ScaffoldLayoutMDYNRJg(z, i, function2, function3, function22, function23, function24, composer2, i2 | 1);
            }
        });
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
