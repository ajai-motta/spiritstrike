package androidx.compose.ui.layout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.MeasureBlocks;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.RendererCapabilities;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Layout.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u009d\u0002\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052-\u0010\u000b\u001a)\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011¢\u0006\u0002\b\u00122-\u0010\u0013\u001a)\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011¢\u0006\u0002\b\u00122-\u0010\u0014\u001a)\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011¢\u0006\u0002\b\u00122-\u0010\u0015\u001a)\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011¢\u0006\u0002\b\u00122\b\b\u0002\u0010\u0006\u001a\u00020\u00072-\u0010\u0016\u001a)\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\fj\u0002`\u001b¢\u0006\u0002\b\u0012H\u0001ø\u0001\u0001¢\u0006\u0002\u0010\u001c\u001a \u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0087\b¢\u0006\u0002\u0010\u001d\u001a:\u0010\u001e\u001a\u00020\u001f2-\u0010\u0016\u001a)\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\fj\u0002`\u001b¢\u0006\u0002\b\u0012H\u0001ø\u0001\u0001\u001a7\u0010 \u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00052\u0006\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010!\u001a4\u0010\"\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0004\u0012\u00020\u00010#¢\u0006\u0002\b\u0004¢\u0006\u0002\b\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0001ø\u0001\u0001¢\u0006\u0002\u0010&\u001aö\u0001\u0010'\u001a\u00020\u001f2-\u0010\u000b\u001a)\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011¢\u0006\u0002\b\u00122-\u0010\u0013\u001a)\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011¢\u0006\u0002\b\u00122-\u0010\u0014\u001a)\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011¢\u0006\u0002\b\u00122-\u0010\u0015\u001a)\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\fj\u0002`\u0011¢\u0006\u0002\b\u00122-\u0010\u0016\u001a)\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\fj\u0002`\u001b¢\u0006\u0002\b\u0012H\u0001ø\u0001\u0001\u001aX\u0010(\u001a\u00020\u0010*\u00020)2)\u0010\u0016\u001a%\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\f¢\u0006\u0002\b\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0001\u001aX\u0010.\u001a\u00020\u0010*\u00020)2)\u0010\u0016\u001a%\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\f¢\u0006\u0002\b\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010/\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0001\u001aX\u00100\u001a\u00020\u0010*\u00020)2)\u0010\u0016\u001a%\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\f¢\u0006\u0002\b\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0001\u001aX\u00101\u001a\u00020\u0010*\u00020)2)\u0010\u0016\u001a%\u0012\u0004\u0012\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\f¢\u0006\u0002\b\u00122\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010/\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0001\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u00062"}, d2 = {"Layout", "", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "modifier", "Landroidx/compose/ui/Modifier;", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "minIntrinsicWidthMeasureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "Landroidx/compose/ui/layout/IntrinsicMeasureBlock;", "Lkotlin/ExtensionFunctionType;", "minIntrinsicHeightMeasureBlock", "maxIntrinsicWidthMeasureBlock", "maxIntrinsicHeightMeasureBlock", "measureBlock", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureBlock;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "MeasuringIntrinsicsMeasureBlocks", "Landroidx/compose/ui/node/MeasureBlocks;", "MultiMeasureLayout", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/runtime/Composer;II)V", "materializerOf", "Lkotlin/Function1;", "Landroidx/compose/runtime/SkippableUpdater;", "Landroidx/compose/ui/node/ComposeUiNode;", "(Landroidx/compose/ui/Modifier;)Lkotlin/jvm/functions/Function3;", "measureBlocksOf", "MeasuringMaxIntrinsicHeight", "Landroidx/compose/ui/unit/Density;", "measurables", "w", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "MeasuringMaxIntrinsicWidth", "h", "MeasuringMinIntrinsicHeight", "MeasuringMinIntrinsicWidth", "ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LayoutKt {
    public static final void Layout(Function2<? super Composer, ? super Integer, Unit> content, Modifier modifier, MeasurePolicy measurePolicy, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        composer.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composer, "C(Layout)P(!1,2)74@2915L7,75@2970L7,76@3029L7,77@3041L460:Layout.kt#80mrfh");
        if ((i2 & 2) != 0) {
            modifier = Modifier.INSTANCE;
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume3 = composer.consume(localViewConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = materializerOf(modifier);
        int i3 = ((i << 9) & 7168) | 6;
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM1298constructorimpl = Updater.m1298constructorimpl(composer);
        Updater.m1305setimpl(composerM1298constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m1305setimpl(composerM1298constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m1305setimpl(composerM1298constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m1305setimpl(composerM1298constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        composer.enableReusing();
        function3MaterializerOf.invoke(SkippableUpdater.m1288boximpl(SkippableUpdater.m1289constructorimpl(composer)), composer, 0);
        composer.startReplaceableGroup(2058660585);
        content.invoke(composer, Integer.valueOf((i3 >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
        composer.endReplaceableGroup();
    }

    public static final void Layout(Modifier modifier, MeasurePolicy measurePolicy, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        composer.startReplaceableGroup(544976794);
        ComposerKt.sourceInformation(composer, "C(Layout)P(1)120@4597L7,121@4652L7,122@4711L7,124@4784L439:Layout.kt#80mrfh");
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume;
        ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localLayoutDirection);
        ComposerKt.sourceInformationMarkerEnd(composer);
        LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
        ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object objConsume3 = composer.consume(localViewConfiguration);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
        Modifier modifierMaterialize = ComposedModifierKt.materialize(composer, modifier);
        final Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        composer.startReplaceableGroup(1405779621);
        ComposerKt.sourceInformation(composer, "C(ReusableComposeNode):Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(new Function0<ComposeUiNode>() { // from class: androidx.compose.ui.layout.LayoutKt$Layout$$inlined$ReusableComposeNode$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final ComposeUiNode invoke() {
                    return constructor.invoke();
                }
            });
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        Composer composerM1298constructorimpl = Updater.m1298constructorimpl(composer);
        Updater.m1305setimpl(composerM1298constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m1305setimpl(composerM1298constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
        Updater.m1305setimpl(composerM1298constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
        Updater.m1305setimpl(composerM1298constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
        Updater.m1305setimpl(composerM1298constructorimpl, modifierMaterialize, ComposeUiNode.INSTANCE.getSetModifier());
        composer.enableReusing();
        composer.endNode();
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    @kotlin.Deprecated(message = "This composable was deprecated. Please use the alternative Layout overloads instead.")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Layout(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r17, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r18, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r19, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r20, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.layout.IntrinsicMeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.IntrinsicMeasurable>, ? super java.lang.Integer, java.lang.Integer> r21, androidx.compose.ui.Modifier r22, final kotlin.jvm.functions.Function3<? super androidx.compose.ui.layout.MeasureScope, ? super java.util.List<? extends androidx.compose.ui.layout.Measurable>, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 527
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutKt.Layout(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @Deprecated(message = "MeasureBlocks was deprecated. Please use MeasurePolicy and the Layout overloads using it instead.")
    public static final MeasureBlocks measureBlocksOf(final Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> minIntrinsicWidthMeasureBlock, final Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> minIntrinsicHeightMeasureBlock, final Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> maxIntrinsicWidthMeasureBlock, final Function3<? super IntrinsicMeasureScope, ? super List<? extends IntrinsicMeasurable>, ? super Integer, Integer> maxIntrinsicHeightMeasureBlock, final Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> measureBlock) {
        Intrinsics.checkNotNullParameter(minIntrinsicWidthMeasureBlock, "minIntrinsicWidthMeasureBlock");
        Intrinsics.checkNotNullParameter(minIntrinsicHeightMeasureBlock, "minIntrinsicHeightMeasureBlock");
        Intrinsics.checkNotNullParameter(maxIntrinsicWidthMeasureBlock, "maxIntrinsicWidthMeasureBlock");
        Intrinsics.checkNotNullParameter(maxIntrinsicHeightMeasureBlock, "maxIntrinsicHeightMeasureBlock");
        Intrinsics.checkNotNullParameter(measureBlock, "measureBlock");
        return new MeasureBlocks() { // from class: androidx.compose.ui.layout.LayoutKt.measureBlocksOf.1
            @Override // androidx.compose.ui.node.MeasureBlocks
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo3159measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> measurables, long constraints) {
                Intrinsics.checkNotNullParameter(measureScope, "measureScope");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return measureBlock.invoke(measureScope, measurables, Constraints.m3819boximpl(constraints));
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int h) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return minIntrinsicWidthMeasureBlock.invoke(intrinsicMeasureScope, measurables, Integer.valueOf(h)).intValue();
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int w) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return minIntrinsicHeightMeasureBlock.invoke(intrinsicMeasureScope, measurables, Integer.valueOf(w)).intValue();
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int h) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return maxIntrinsicWidthMeasureBlock.invoke(intrinsicMeasureScope, measurables, Integer.valueOf(h)).intValue();
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int w) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return maxIntrinsicHeightMeasureBlock.invoke(intrinsicMeasureScope, measurables, Integer.valueOf(w)).intValue();
            }
        };
    }

    public static final Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf(final Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        return ComposableLambdaKt.composableLambdaInstance(-1586257396, true, new Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutKt.materializerOf.1
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(SkippableUpdater<ComposeUiNode> skippableUpdater, Composer composer, Integer num) {
                m3160invokeDeg8D_g(skippableUpdater.getComposer(), composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke-Deg8D_g, reason: not valid java name */
            public final void m3160invokeDeg8D_g(Composer composer, Composer composer2, int i) {
                Intrinsics.checkNotNullParameter(composer, "$this$null");
                ComposerKt.sourceInformation(composer2, "C:Layout.kt#80mrfh");
                Modifier modifierMaterialize = ComposedModifierKt.materialize(composer2, modifier);
                composer.startReplaceableGroup(509942095);
                Updater.m1305setimpl(Updater.m1298constructorimpl(composer), modifierMaterialize, ComposeUiNode.INSTANCE.getSetModifier());
                composer.endReplaceableGroup();
            }
        });
    }

    @Deprecated(message = "This API is unsafe for UI performance at scale - using it incorrectly will lead to exponential performance issues. This API should be avoided whenever possible.")
    public static final void MultiMeasureLayout(Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> content, final MeasurePolicy measurePolicy, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(measurePolicy, "measurePolicy");
        Composer composerStartRestartGroup = composer.startRestartGroup(1949933075);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MultiMeasureLayout)P(2)244@9374L7,245@9429L7,246@9488L7,248@9501L545:Layout.kt#80mrfh");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(content) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i & 896) == 0) {
            i3 |= composerStartRestartGroup.changed(measurePolicy) ? 256 : 128;
        }
        if ((i3 & 731) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifierMaterialize = ComposedModifierKt.materialize(composerStartRestartGroup, modifier);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume2;
            ProvidableCompositionLocal<ViewConfiguration> localViewConfiguration = CompositionLocalsKt.getLocalViewConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localViewConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ViewConfiguration viewConfiguration = (ViewConfiguration) objConsume3;
            Function0<LayoutNode> constructor$ui_release = LayoutNode.INSTANCE.getConstructor$ui_release();
            int i5 = ((i3 << 3) & 896) | 6;
            composerStartRestartGroup.startReplaceableGroup(-692256719);
            ComposerKt.sourceInformation(composerStartRestartGroup, "C(ReusableComposeNode)P(1,2)376@14027L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor$ui_release);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1298constructorimpl = Updater.m1298constructorimpl(composerStartRestartGroup);
            Updater.m1305setimpl(composerM1298constructorimpl, modifierMaterialize, ComposeUiNode.INSTANCE.getSetModifier());
            Updater.m1305setimpl(composerM1298constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m1305setimpl(composerM1298constructorimpl, density, ComposeUiNode.INSTANCE.getSetDensity());
            Updater.m1305setimpl(composerM1298constructorimpl, layoutDirection, ComposeUiNode.INSTANCE.getSetLayoutDirection());
            Updater.m1305setimpl(composerM1298constructorimpl, viewConfiguration, ComposeUiNode.INSTANCE.getSetViewConfiguration());
            Updater.m1302initimpl(composerM1298constructorimpl, new Function1<LayoutNode, Unit>() { // from class: androidx.compose.ui.layout.LayoutKt$MultiMeasureLayout$1$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(LayoutNode layoutNode) {
                    invoke2(layoutNode);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(LayoutNode init) {
                    Intrinsics.checkNotNullParameter(init, "$this$init");
                    init.setCanMultiMeasure$ui_release(true);
                }
            });
            composerStartRestartGroup.enableReusing();
            content.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 6) & 14));
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutKt.MultiMeasureLayout.2
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

            public final void invoke(Composer composer2, int i6) {
                LayoutKt.MultiMeasureLayout(modifier2, content, measurePolicy, composer2, i | 1, i2);
            }
        });
    }

    @Deprecated(message = "MeasuringIntrinsicsMeasureBlocks was deprecated. Please use MeasurePolicy instead.")
    public static final MeasureBlocks MeasuringIntrinsicsMeasureBlocks(final Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> measureBlock) {
        Intrinsics.checkNotNullParameter(measureBlock, "measureBlock");
        return new MeasureBlocks() { // from class: androidx.compose.ui.layout.LayoutKt.MeasuringIntrinsicsMeasureBlocks.1
            @Override // androidx.compose.ui.node.MeasureBlocks
            /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
            public MeasureResult mo3159measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> measurables, long constraints) {
                Intrinsics.checkNotNullParameter(measureScope, "measureScope");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return measureBlock.invoke(measureScope, measurables, Constraints.m3819boximpl(constraints));
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int h) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return LayoutKt.MeasuringMinIntrinsicWidth(intrinsicMeasureScope, measureBlock, measurables, h, intrinsicMeasureScope.getLayoutDirection());
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int w) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return LayoutKt.MeasuringMinIntrinsicHeight(intrinsicMeasureScope, measureBlock, measurables, w, intrinsicMeasureScope.getLayoutDirection());
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int h) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return LayoutKt.MeasuringMaxIntrinsicWidth(intrinsicMeasureScope, measureBlock, measurables, h, intrinsicMeasureScope.getLayoutDirection());
            }

            @Override // androidx.compose.ui.node.MeasureBlocks
            public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> measurables, int w) {
                Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "intrinsicMeasureScope");
                Intrinsics.checkNotNullParameter(measurables, "measurables");
                return LayoutKt.MeasuringMaxIntrinsicHeight(intrinsicMeasureScope, measureBlock, measurables, w, intrinsicMeasureScope.getLayoutDirection());
            }

            public String toString() {
                return JvmActuals_jvmKt.simpleIdentityToString(this, "MeasuringIntrinsicsMeasureBlocks") + "{ measureBlock=" + JvmActuals_jvmKt.simpleIdentityToString(measureBlock, null) + " }";
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MeasuringMinIntrinsicWidth(Density density, Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function3, List<? extends IntrinsicMeasurable> list, int i, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable(list.get(i2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Width));
        }
        long jConstraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null);
        return function3.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3819boximpl(jConstraints$default)).getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MeasuringMinIntrinsicHeight(Density density, Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function3, List<? extends IntrinsicMeasurable> list, int i, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable(list.get(i2), IntrinsicMinMax.Min, IntrinsicWidthHeight.Height));
        }
        long jConstraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null);
        return function3.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3819boximpl(jConstraints$default)).getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MeasuringMaxIntrinsicWidth(Density density, Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function3, List<? extends IntrinsicMeasurable> list, int i, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable(list.get(i2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Width));
        }
        long jConstraints$default = ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null);
        return function3.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3819boximpl(jConstraints$default)).getWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MeasuringMaxIntrinsicHeight(Density density, Function3<? super MeasureScope, ? super List<? extends Measurable>, ? super Constraints, ? extends MeasureResult> function3, List<? extends IntrinsicMeasurable> list, int i, LayoutDirection layoutDirection) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(new DefaultIntrinsicMeasurable(list.get(i2), IntrinsicMinMax.Max, IntrinsicWidthHeight.Height));
        }
        long jConstraints$default = ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null);
        return function3.invoke(new IntrinsicsMeasureScope(density, layoutDirection), arrayList, Constraints.m3819boximpl(jConstraints$default)).getHeight();
    }
}
