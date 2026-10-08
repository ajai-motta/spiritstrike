package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.google.android.exoplayer2.RendererCapabilities;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.j;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function5<BoxScope, Boolean, Function0<Unit>, Composer, Integer, Unit> f2906a = c.f2889a.a();

    public static final Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Function5<? super BoxScope, ? super Boolean, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function5, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(718660168);
        if ((i2 & 1) != 0) {
            function5 = f2906a;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(718660168, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultPlaybackControl (PlaybackControl.kt:30)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1901828083, true, new a(function5));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Function5<BoxScope, Boolean, Function0<Unit>, Composer, Integer, Unit> a() {
        return f2906a;
    }

    public static final class a implements Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, ? extends Unit>, Function0<? extends Unit>, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function5<BoxScope, Boolean, Function0<Unit>, Composer, Integer, Unit> f2907a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function5<? super BoxScope, ? super Boolean, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function5) {
            this.f2907a = function5;
        }

        public final void a(BoxScope boxScope, final boolean z, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress, final Function1<? super Boolean, Unit> onShouldPlay, final Function0<Unit> onShouldReplay, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(progress, "progress");
            Intrinsics.checkNotNullParameter(onShouldPlay, "onShouldPlay");
            Intrinsics.checkNotNullParameter(onShouldReplay, "onShouldReplay");
            if ((i & 6) == 0) {
                i2 = (composer.changed(boxScope) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composer.changed(z) ? 32 : 16;
            }
            if ((i & RendererCapabilities.MODE_SUPPORT_MASK) == 0) {
                i2 |= composer.changed(progress) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= composer.changed(onShouldPlay) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                i2 |= composer.changed(onShouldReplay) ? 16384 : 8192;
            }
            if ((74899 & i2) == 74898 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1901828083, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultPlaybackControl.<anonymous> (PlaybackControl.kt:32)");
            }
            composer.startReplaceableGroup(263769922);
            boolean zChanged = composer.changed(progress) | composer.changed(onShouldReplay) | composer.changed(onShouldPlay) | composer.changed(z);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.j$a$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return j.a.a(progress, onShouldReplay, onShouldPlay, z);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            this.f2907a.invoke(boxScope, Boolean.valueOf(z), (Function0) objRememberedValue, composer, Integer.valueOf(i2 & 126));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function7
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Function1<? super Boolean, ? extends Unit> function1, Function0<? extends Unit> function0, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), iVar, function1, function0, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public static final Unit a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Function0 function0, Function1 function1, boolean z) {
            if (iVar instanceof i.a) {
                function0.invoke();
            } else {
                function1.invoke(Boolean.valueOf(!z));
            }
            return Unit.INSTANCE;
        }
    }
}
