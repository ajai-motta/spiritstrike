package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aá\u0002\u0010\u0003\u001a\u00020\u00042\u001c\u0010\u0005\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\u0019\b\u0002\u0010\u0010\u001a\u0013\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2\u0015\b\u0002\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00012 \b\u0002\u0010\u001e\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\b\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u001f\u001a\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u00182\b\b\u0002\u0010!\u001a\u00020\u00012\b\b\u0002\u0010\"\u001a\u00020\u001b2\b\b\u0002\u0010#\u001a\u00020\u001b2\b\b\u0002\u0010$\u001a\u00020\u001b2\b\b\u0002\u0010%\u001a\u00020\u001b2\b\b\u0002\u0010&\u001a\u00020\u001b2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*\u001aÈ\u0001\u0010+\u001a\u00020\u00042\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2&\u0010,\u001a\"\u0012\u0013\u0012\u00110(¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2&\u00100\u001a\"\u0012\u0013\u0012\u001101¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0002\b\b2\u0013\u0010\u0012\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f¢\u0006\u0002\b\b2\u0011\u0010\u0010\u001a\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\b2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00142\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u000207H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u00109\u001a+\u0010:\u001a\u00020\r2\b\b\u0002\u0010;\u001a\u00020<2\b\b\u0002\u0010=\u001a\u0002072\b\b\u0002\u0010>\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010?\u001a;\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020B2\u000e\b\u0002\u0010C\u001a\b\u0012\u0004\u0012\u0002050D2\u0014\b\u0002\u0010E\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00160\u0006H\u0007¢\u0006\u0002\u0010F\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006G"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffold", "", "sheetContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetGesturesEnabled", "", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "contentColor", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffoldLayout", TtmlNode.TAG_BODY, "Lkotlin/ParameterName;", "name", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "Landroidx/compose/runtime/State;", "", "sheetState", "Landroidx/compose/material/BottomSheetState;", "BottomSheetScaffoldLayout-KCBPh4w", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FILandroidx/compose/runtime/State;Landroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "rememberBottomSheetScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "initialValue", "Landroidx/compose/material/BottomSheetValue;", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BottomSheetScaffoldKt {
    private static final float FabSpacing = Dp.m3887constructorimpl(16);

    @ExperimentalMaterialApi
    public static final BottomSheetState rememberBottomSheetState(final BottomSheetValue initialValue, final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> function1, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        composer.startReplaceableGroup(1808153344);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetState)P(2)163@5857L371:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            };
        }
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m1312rememberSaveable(new Object[]{animationSpec}, (Saver) BottomSheetState.INSTANCE.Saver(animationSpec, function1), (String) null, (Function0) new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomSheetState invoke() {
                return new BottomSheetState(initialValue, animationSpec, function1);
            }
        }, composer, 72, 4);
        composer.endReplaceableGroup();
        return bottomSheetState;
    }

    @ExperimentalMaterialApi
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1353009744);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetScaffoldState)P(1)203@7102L39,204@7184L35,205@7264L32,207@7338L248:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, composer, 6, 6);
        }
        if ((i2 & 4) != 0) {
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
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "C(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(drawerState) | composer.changed(bottomSheetState) | composer.changed(snackbarHostState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new BottomSheetScaffoldState(drawerState, bottomSheetState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) objRememberedValue2;
        composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x040c  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x04a0  */
    /* JADX WARN: Removed duplicated region for block: B:338:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:342:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:347:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x04f7  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0502  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0518  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x0576  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x05c5  */
    /* JADX WARN: Removed duplicated region for block: B:366:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:369:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x05fb  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:377:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013e  */
    @androidx.compose.material.ExperimentalMaterialApi
    /* JADX INFO: renamed from: BottomSheetScaffold-bGncdBI, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m932BottomSheetScaffoldbGncdBI(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.ui.Modifier r46, androidx.compose.material.BottomSheetScaffoldState r47, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r49, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, int r51, boolean r52, androidx.compose.ui.graphics.Shape r53, float r54, long r55, long r57, float r59, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, boolean r61, androidx.compose.ui.graphics.Shape r62, float r63, long r64, long r66, long r68, long r70, long r72, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r74, androidx.compose.runtime.Composer r75, final int r76, final int r77, final int r78, final int r79) {
        /*
            Method dump skipped, instruction units count: 1746
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m932BottomSheetScaffoldbGncdBI(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomSheetScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BottomSheetScaffold_bGncdBI$lambda-4, reason: not valid java name */
    public static final Float m934BottomSheetScaffold_bGncdBI$lambda4(MutableState<Float> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: BottomSheetScaffoldLayout-KCBPh4w, reason: not valid java name */
    public static final void m933BottomSheetScaffoldLayoutKCBPh4w(final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final float f, final int i, final State<Float> state, final BottomSheetState bottomSheetState, Composer composer, final int i2) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(499725572);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheetScaffoldLayout)P(8!3,7,5:c#ui.unit.Dp,3:c#material.FabPosition)429@17635L2479,429@17618L2496:BottomSheetScaffold.kt#jmzs0o");
        int i3 = (i2 & 14) == 0 ? (composerStartRestartGroup.changed(function2) ? 4 : 2) | i2 : i2;
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(function3) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(function32) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= composerStartRestartGroup.changed(function22) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(function23) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(state) ? 8388608 : 4194304;
        }
        if ((234881024 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(bottomSheetState) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        final int i4 = i3;
        if ((i4 & 191739611) != 38347922 || !composerStartRestartGroup.getSkipping()) {
            Object[] objArr = {function32, state, function2, function3, Dp.m3885boximpl(f), function22, FabPosition.m1071boximpl(i), function23, bottomSheetState};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(remember)P(1):Composables.kt#9igjgp");
            boolean zChanged = false;
            for (int i5 = 0; i5 < 9; i5++) {
                zChanged |= composerStartRestartGroup.changed(objArr[i5]);
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1

                    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
                    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                    public /* synthetic */ class WhenMappings {
                        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                        static {
                            int[] iArr = new int[BottomSheetValue.values().length];
                            iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                            iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                            $EnumSwitchMapping$0 = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m940invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m940invoke0kLqBqw(SubcomposeMeasureScope SubcomposeLayout, long j) {
                        final Placeable placeableMo3152measureBRTryo0;
                        int height;
                        Intrinsics.checkNotNullParameter(SubcomposeLayout, "$this$SubcomposeLayout");
                        int iM3831getMaxWidthimpl = Constraints.m3831getMaxWidthimpl(j);
                        final int iM3830getMaxHeightimpl = Constraints.m3830getMaxHeightimpl(j);
                        long jM3822copyZbe2FdA$default = Constraints.m3822copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot = BottomSheetScaffoldLayoutSlot.Sheet;
                        final Function3<Integer, Composer, Integer, Unit> function33 = function32;
                        final int i6 = i4;
                        final Placeable placeableMo3152measureBRTryo02 = SubcomposeLayout.subcompose(bottomSheetScaffoldLayoutSlot, ComposableLambdaKt.composableLambdaInstance(520491296, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$sheetPlaceable$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i7) {
                                ComposerKt.sourceInformation(composer3, "C435@17917L25:BottomSheetScaffold.kt#jmzs0o");
                                if ((i7 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                } else {
                                    function33.invoke(Integer.valueOf(iM3830getMaxHeightimpl), composer3, Integer.valueOf((i6 >> 3) & 112));
                                }
                            }
                        })).get(0).mo3152measureBRTryo0(jM3822copyZbe2FdA$default);
                        final int iRoundToInt = MathKt.roundToInt(state.getValue().floatValue());
                        final Function2<Composer, Integer, Unit> function24 = function2;
                        if (function24 != null) {
                            final int i7 = i4;
                            placeableMo3152measureBRTryo0 = SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.TopBar, ComposableLambdaKt.composableLambdaInstance(1988456983, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$topBarPlaceable$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                    invoke(composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer3, int i8) {
                                    ComposerKt.sourceInformation(composer3, "C440@18148L8:BottomSheetScaffold.kt#jmzs0o");
                                    if ((i8 & 11) == 2 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                    } else {
                                        function24.invoke(composer3, Integer.valueOf(i7 & 14));
                                    }
                                }
                            })).get(0).mo3152measureBRTryo0(jM3822copyZbe2FdA$default);
                        } else {
                            placeableMo3152measureBRTryo0 = null;
                        }
                        final int height2 = placeableMo3152measureBRTryo0 != null ? placeableMo3152measureBRTryo0.getHeight() : 0;
                        long jM3822copyZbe2FdA$default2 = Constraints.m3822copyZbe2FdA$default(jM3822copyZbe2FdA$default, 0, 0, 0, iM3830getMaxHeightimpl - height2, 7, null);
                        BottomSheetScaffoldLayoutSlot bottomSheetScaffoldLayoutSlot2 = BottomSheetScaffoldLayoutSlot.Body;
                        final Function3<PaddingValues, Composer, Integer, Unit> function34 = function3;
                        final float f2 = f;
                        final int i8 = i4;
                        final Placeable placeableMo3152measureBRTryo03 = SubcomposeLayout.subcompose(bottomSheetScaffoldLayoutSlot2, ComposableLambdaKt.composableLambdaInstance(1466287989, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$bodyPlaceable$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                                invoke(composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer3, int i9) {
                                ComposerKt.sourceInformation(composer3, "C447@18454L45:BottomSheetScaffold.kt#jmzs0o");
                                if ((i9 & 11) == 2 && composer3.getSkipping()) {
                                    composer3.skipToGroupEnd();
                                } else {
                                    function34.invoke(PaddingKt.m425PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, f2, 7, null), composer3, Integer.valueOf(i8 & 112));
                                }
                            }
                        })).get(0).mo3152measureBRTryo0(jM3822copyZbe2FdA$default2);
                        Function2<Composer, Integer, Unit> function25 = function22;
                        Placeable placeableMo3152measureBRTryo04 = function25 != null ? SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.Fab, function25).get(0).mo3152measureBRTryo0(jM3822copyZbe2FdA$default) : null;
                        int width = placeableMo3152measureBRTryo04 != null ? placeableMo3152measureBRTryo04.getWidth() : 0;
                        int height3 = placeableMo3152measureBRTryo04 != null ? placeableMo3152measureBRTryo04.getHeight() : 0;
                        int i9 = FabPosition.m1074equalsimpl0(i, FabPosition.INSTANCE.m1078getCenter5ygKITE()) ? (iM3831getMaxWidthimpl - width) / 2 : (iM3831getMaxWidthimpl - width) - SubcomposeLayout.mo311roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing);
                        int i10 = height3 / 2;
                        final int i11 = SubcomposeLayout.mo317toPx0680j_4(f) < ((float) i10) ? (iRoundToInt - height3) - SubcomposeLayout.mo311roundToPx0680j_4(BottomSheetScaffoldKt.FabSpacing) : iRoundToInt - i10;
                        final Placeable placeableMo3152measureBRTryo05 = SubcomposeLayout.subcompose(BottomSheetScaffoldLayoutSlot.Snackbar, function23).get(0).mo3152measureBRTryo0(jM3822copyZbe2FdA$default);
                        final int width2 = (iM3831getMaxWidthimpl - placeableMo3152measureBRTryo05.getWidth()) / 2;
                        int i12 = WhenMappings.$EnumSwitchMapping$0[bottomSheetState.getCurrentValue().ordinal()];
                        if (i12 == 1) {
                            height = i11 - placeableMo3152measureBRTryo05.getHeight();
                        } else {
                            if (i12 != 2) {
                                throw new NoWhenBranchMatchedException();
                            }
                            height = iM3830getMaxHeightimpl - placeableMo3152measureBRTryo05.getHeight();
                        }
                        final int i13 = height;
                        final Placeable placeable = placeableMo3152measureBRTryo04;
                        final int i14 = i9;
                        return MeasureScope.CC.layout$default(SubcomposeLayout, iM3831getMaxWidthimpl, iM3830getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo3152measureBRTryo03, 0, height2, 0.0f, 4, null);
                                Placeable placeable2 = placeableMo3152measureBRTryo0;
                                if (placeable2 != null) {
                                    Placeable.PlacementScope.placeRelative$default(layout, placeable2, 0, 0, 0.0f, 4, null);
                                }
                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo3152measureBRTryo02, 0, iRoundToInt, 0.0f, 4, null);
                                Placeable placeable3 = placeable;
                                if (placeable3 != null) {
                                    Placeable.PlacementScope.placeRelative$default(layout, placeable3, i14, i11, 0.0f, 4, null);
                                }
                                Placeable.PlacementScope.placeRelative$default(layout, placeableMo3152measureBRTryo05, width2, i13, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) objRememberedValue, composer2, 0, 1);
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                invoke(composer3, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i6) {
                BottomSheetScaffoldKt.m933BottomSheetScaffoldLayoutKCBPh4w(function2, function3, function32, function22, function23, f, i, state, bottomSheetState, composer3, i2 | 1);
            }
        });
    }
}
