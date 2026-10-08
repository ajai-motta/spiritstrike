package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose;

import android.content.Context;
import android.view.View;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.moloco.sdk.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.P;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.w;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class n {

    public static final class a implements Function3<i.a, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i f2914a;
        public final /* synthetic */ Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> b;
        public final /* synthetic */ Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> c;
        public final /* synthetic */ Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> d;
        public final /* synthetic */ Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, Unit>, Function0<Unit>, Composer, Integer, Unit> e;
        public final /* synthetic */ P f;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i g;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0506a extends FunctionReferenceImpl implements Function0<Unit> {
            public C0506a(Object obj) {
                super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onReplay", "onReplay()V", 0);
            }

            public final void a() {
                ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).z();
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar, Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit> function7, Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit> function5, Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function6, Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit> function72, P p, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar2) {
            this.f2914a = iVar;
            this.b = function7;
            this.c = function5;
            this.d = function6;
            this.e = function72;
            this.f = p;
            this.g = iVar2;
        }

        public final void a(i.a aVar, Composer composer, int i) {
            int i2;
            if ((i & 6) == 0) {
                i2 = i | (composer.changed(aVar) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1837331254, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.VastRenderer.<anonymous>.<anonymous> (VastRenderer.kt:88)");
            }
            if (aVar instanceof i.a.C0495a) {
                composer.startReplaceableGroup(1864270639);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h hVarD = ((i.a.C0495a) aVar).d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar = this.f2914a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.a.a(hVarD, iVar != null ? iVar.a() : null, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, RendererCapabilities.MODE_SUPPORT_MASK, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.c) {
                composer.startReplaceableGroup(1864278356);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k kVarD = ((i.a.c) aVar).d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar2 = this.f2914a;
                Function0<Unit> function0C = iVar2 != null ? iVar2.c() : null;
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> function7 = this.b;
                Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> function5 = this.c;
                Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> function6 = this.d;
                Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, Unit>, Function0<Unit>, Composer, Integer, Unit> function72 = this.e;
                P p = this.f;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar3 = this.g;
                composer.startReplaceableGroup(1864289963);
                boolean zChanged = composer.changed(iVar3);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new C0506a(iVar3);
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.a(kVarD, function0C, modifierFillMaxSize$default, function7, function5, function6, function72, p, (Function0) ((KFunction) objRememberedValue), composer, RendererCapabilities.MODE_SUPPORT_MASK, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.b) {
                composer.startReplaceableGroup(1864292898);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e eVarD = ((i.a.b) aVar).d();
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar4 = this.f2914a;
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f.a(eVarD, iVar4 != null ? iVar4.b() : null, this.d, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 3072, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.d) {
                composer.startReplaceableGroup(1958779838);
                composer.endReplaceableGroup();
            } else {
                if (aVar != null) {
                    composer.startReplaceableGroup(1864269410);
                    composer.endReplaceableGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceableGroup(1958818154);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(i.a aVar, Composer composer, Integer num) {
            a(aVar, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class b extends FunctionReferenceImpl implements Function1<a.AbstractC0526a.c, Unit> {
        public b(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onButtonRendered", "onButtonRendered(Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService$UserInteraction$Button;)V", 0);
        }

        public final void a(a.AbstractC0526a.c p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).a(p0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(a.AbstractC0526a.c cVar) {
            a(cVar);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function0<Unit> {
        public c(Object obj) {
            super(0, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onCTA", "onCTA()V", 0);
        }

        public final void a() {
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).A();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class d extends FunctionReferenceImpl implements Function1<a.AbstractC0526a.c, Unit> {
        public d(Object obj) {
            super(1, obj, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.class, "onButtonRendered", "onButtonRendered(Lcom/moloco/sdk/xenoss/sdkdevkit/android/core/services/CustomUserEventBuilderService$UserInteraction$Button;)V", 0);
        }

        public final void a(a.AbstractC0526a.c p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ((com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) this.receiver).a(p0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(a.AbstractC0526a.c cVar) {
            a(cVar);
            return Unit.INSTANCE;
        }
    }

    public static final class e implements Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0526a.c, ? extends Unit>, Function0<? extends Unit>, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Alignment f2915a;
        public final /* synthetic */ PaddingValues b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ Function0<Unit> f;

        public e(Alignment alignment, PaddingValues paddingValues, String str, String str2, long j, Function0<Unit> function0) {
            this.f2915a = alignment;
            this.b = paddingValues;
            this.c = str;
            this.d = str2;
            this.e = j;
            this.f = function0;
        }

        public static final i.a b(State<? extends i.a> state) {
            return state.getValue();
        }

        @Override // kotlin.jvm.functions.Function7
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, StateFlow<? extends i.a> stateFlow, Function1<? super a.AbstractC0526a.c, ? extends Unit> function1, Function0<? extends Unit> function0, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), stateFlow, function1, function0, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void a(BoxScope boxScope, boolean z, StateFlow<? extends i.a> currentAdPartFlow, Function1<? super a.AbstractC0526a.c, Unit> onButtonRendered, Function0<Unit> onCTA, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(currentAdPartFlow, "currentAdPartFlow");
            Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
            Intrinsics.checkNotNullParameter(onCTA, "onCTA");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(432764356, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous> (VastRenderer.kt:295)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.INSTANCE, this.f2915a)), this.b), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, 1004334236, true, new a(onButtonRendered, SnapshotStateKt.collectAsState(currentAdPartFlow, null, composer, (i >> 6) & 14, 1), this.c, this.d, this.e, onCTA, this.f)), composer, ((i >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        public static final class a implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<a.AbstractC0526a.c, Unit> f2916a;
            public final /* synthetic */ State<i.a> b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ long e;
            public final /* synthetic */ Function0<Unit> f;
            public final /* synthetic */ Function0<Unit> g;

            /* JADX WARN: Multi-variable type inference failed */
            public a(Function1<? super a.AbstractC0526a.c, Unit> function1, State<? extends i.a> state, String str, String str2, long j, Function0<Unit> function0, Function0<Unit> function02) {
                this.f2916a = function1;
                this.b = state;
                this.c = str;
                this.d = str2;
                this.e = j;
                this.f = function0;
                this.g = function02;
            }

            public final void a(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1004334236, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous>.<anonymous> (VastRenderer.kt:314)");
                }
                i.a aVarB = e.b(this.b);
                if (aVarB instanceof i.a.C0495a) {
                    composer.startReplaceableGroup(1203605395);
                    w.a(null, a.AbstractC0526a.c.EnumC0528a.g, this.f2916a, ComposableLambdaKt.composableLambda(composer, -832302220, true, new C0507a(this.c, this.d, this.e, this.f, this.g)), composer, 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarB instanceof i.a.c) {
                    composer.startReplaceableGroup(1204196627);
                    w.a(null, a.AbstractC0526a.c.EnumC0528a.g, this.f2916a, ComposableLambdaKt.composableLambda(composer, 1517460509, true, new b(this.c, this.d, this.e, this.f, this.g)), composer, 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarB instanceof i.a.b) {
                    composer.startReplaceableGroup(1204770127);
                    composer.endReplaceableGroup();
                } else if (aVarB instanceof i.a.d) {
                    composer.startReplaceableGroup(1204855532);
                    composer.endReplaceableGroup();
                } else {
                    if (aVarB != null) {
                        composer.startReplaceableGroup(-1485196057);
                        composer.endReplaceableGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer.startReplaceableGroup(1204890283);
                    composer.endReplaceableGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public static final class b implements Function3<Modifier, Composer, Integer, Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f2918a;
                public final /* synthetic */ String b;
                public final /* synthetic */ long c;
                public final /* synthetic */ Function0<Unit> d;
                public final /* synthetic */ Function0<Unit> e;

                public b(String str, String str2, long j, Function0<Unit> function0, Function0<Unit> function02) {
                    this.f2918a = str;
                    this.b = str2;
                    this.c = j;
                    this.d = function0;
                    this.e = function02;
                }

                public final void a(Modifier it, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i & 6) == 0) {
                        i |= composer.changed(it) ? 4 : 2;
                    }
                    if ((i & 19) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1517460509, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:337)");
                    }
                    String str = this.f2918a;
                    String str2 = this.b;
                    long j = this.c;
                    composer.startReplaceableGroup(-1483978279);
                    boolean zChanged = composer.changed(this.d) | composer.changed(this.e);
                    final Function0<Unit> function0 = this.d;
                    final Function0<Unit> function02 = this.e;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$e$a$b$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return n.e.a.b.a(function0, function02);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k.a(it, str, str2, j, (Function0) objRememberedValue, composer, i & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                    a(modifier, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public static final Unit a(Function0 function0, Function0 function02) {
                    function0.invoke();
                    if (function02 != null) {
                        function02.invoke();
                    }
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$e$a$a, reason: collision with other inner class name */
            public static final class C0507a implements Function3<Modifier, Composer, Integer, Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f2917a;
                public final /* synthetic */ String b;
                public final /* synthetic */ long c;
                public final /* synthetic */ Function0<Unit> d;
                public final /* synthetic */ Function0<Unit> e;

                public C0507a(String str, String str2, long j, Function0<Unit> function0, Function0<Unit> function02) {
                    this.f2917a = str;
                    this.b = str2;
                    this.c = j;
                    this.d = function0;
                    this.e = function02;
                }

                public final void a(Modifier it, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i & 6) == 0) {
                        i |= composer.changed(it) ? 4 : 2;
                    }
                    if ((i & 19) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-832302220, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:320)");
                    }
                    String str = this.f2917a;
                    String str2 = this.b;
                    long j = this.c;
                    composer.startReplaceableGroup(-1483997351);
                    boolean zChanged = composer.changed(this.d) | composer.changed(this.e);
                    final Function0<Unit> function0 = this.d;
                    final Function0<Unit> function02 = this.e;
                    Object objRememberedValue = composer.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$e$a$a$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return n.e.a.C0507a.a(function0, function02);
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceableGroup();
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.k.a(it, str, str2, j, (Function0) objRememberedValue, composer, i & 14, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                    a(modifier, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public static final Unit a(Function0 function0, Function0 function02) {
                    function0.invoke();
                    if (function02 != null) {
                        function02.invoke();
                    }
                    return Unit.INSTANCE;
                }
            }
        }
    }

    public static final class f implements Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, ? extends Unit>, Function1<? super Boolean, ? extends Unit>, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Alignment f2919a;
        public final /* synthetic */ PaddingValues b;
        public final /* synthetic */ Painter c;
        public final /* synthetic */ Painter d;
        public final /* synthetic */ Function0<Unit> e;
        public final /* synthetic */ long f;
        public final /* synthetic */ long g;
        public final /* synthetic */ long h;
        public final /* synthetic */ Shape i;
        public final /* synthetic */ long j;

        public f(Alignment alignment, PaddingValues paddingValues, Painter painter, Painter painter2, Function0<Unit> function0, long j, long j2, long j3, Shape shape, long j4) {
            this.f2919a = alignment;
            this.b = paddingValues;
            this.c = painter;
            this.d = painter2;
            this.e = function0;
            this.f = j;
            this.g = j2;
            this.h = j3;
            this.i = shape;
            this.j = j4;
        }

        public static final /* synthetic */ a.AbstractC0526a.c a(MutableState mutableState) {
            return b(mutableState);
        }

        public static final a.AbstractC0526a.c b(MutableState<a.AbstractC0526a.c> mutableState) {
            return mutableState.getValue();
        }

        @Override // kotlin.jvm.functions.Function7
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, Boolean bool2, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, ? extends Unit> function2, Function1<? super Boolean, ? extends Unit> function1, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), bool2.booleanValue(), function2, function1, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public static final void b(MutableState<a.AbstractC0526a.c> mutableState, a.AbstractC0526a.c cVar) {
            mutableState.setValue(cVar);
        }

        public final void a(BoxScope boxScope, boolean z, boolean z2, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit> onButtonReplaced, Function1<? super Boolean, Unit> onMuteChange, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(onButtonReplaced, "onButtonReplaced");
            Intrinsics.checkNotNullParameter(onMuteChange, "onMuteChange");
            if ((i & 6) == 0) {
                i2 = (composer.changed(boxScope) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i & 48) == 0) {
                i2 |= composer.changed(z) ? 32 : 16;
            }
            if ((i & RendererCapabilities.MODE_SUPPORT_MASK) == 0) {
                i2 |= composer.changed(z2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                i2 |= composer.changed(onButtonReplaced) ? 2048 : 1024;
            }
            if ((i & 24576) == 0) {
                i2 |= composer.changed(onMuteChange) ? 16384 : 8192;
            }
            if ((74899 & i2) == 74898 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-545982054, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultMuteButton.<anonymous> (VastRenderer.kt:231)");
            }
            composer.startReplaceableGroup(-1304253143);
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.b.a(a.AbstractC0526a.c.EnumC0528a.e), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            AnimatedVisibilityKt.AnimatedVisibility(z, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.INSTANCE, this.f2919a)), this.b), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, -2071462974, true, new a(z2, this.c, this.d, (MutableState) objRememberedValue, onButtonReplaced, onMuteChange, this.e, z, this.f, this.g, this.h, this.i, this.j)), composer, ((i2 >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        public static final class a implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f2920a;
            public final /* synthetic */ Painter b;
            public final /* synthetic */ Painter c;
            public final /* synthetic */ MutableState<a.AbstractC0526a.c> d;
            public final /* synthetic */ Function2<a.AbstractC0526a.c, a.AbstractC0526a.c.EnumC0528a, Unit> e;
            public final /* synthetic */ Function1<Boolean, Unit> f;
            public final /* synthetic */ Function0<Unit> g;
            public final /* synthetic */ boolean h;
            public final /* synthetic */ long i;
            public final /* synthetic */ long j;
            public final /* synthetic */ long k;
            public final /* synthetic */ Shape l;
            public final /* synthetic */ long m;

            /* JADX WARN: Multi-variable type inference failed */
            public a(boolean z, Painter painter, Painter painter2, MutableState<a.AbstractC0526a.c> mutableState, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit> function2, Function1<? super Boolean, Unit> function1, Function0<Unit> function0, boolean z2, long j, long j2, long j3, Shape shape, long j4) {
                this.f2920a = z;
                this.b = painter;
                this.c = painter2;
                this.d = mutableState;
                this.e = function2;
                this.f = function1;
                this.g = function0;
                this.h = z2;
                this.i = j;
                this.j = j2;
                this.k = j3;
                this.l = shape;
                this.m = j4;
            }

            /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v10 ??, still in use, count: 1, list:
                  (r2v10 ?? I:java.lang.Object) from 0x00e0: INVOKE (r20v0 ?? I:androidx.compose.runtime.Composer), (r2v10 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:883)
                	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
                	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
                	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
                	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
                	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
                	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
                */
            public final void a(
            /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
                jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v10 ??, still in use, count: 1, list:
                  (r2v10 ?? I:java.lang.Object) from 0x00e0: INVOKE (r20v0 ?? I:androidx.compose.runtime.Composer), (r2v10 ?? I:java.lang.Object) INTERFACE call: androidx.compose.runtime.Composer.updateRememberedValue(java.lang.Object):void A[MD:(java.lang.Object):void (m)] (LINE:883)
                	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
                	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
                	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
                	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
                	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
                */
            /*  JADX ERROR: Method generation error
                jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r19v0 ??
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
                	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
                	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:303)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:312)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:301)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:312)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:301)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(Unknown Source)
                	at java.base/java.util.ArrayList.forEach(Unknown Source)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(Unknown Source)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(Unknown Source)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(Unknown Source)
                	at java.base/java.util.stream.ReferencePipeline.forEach(Unknown Source)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:299)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:288)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:272)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:159)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:88)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:126)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return Unit.INSTANCE;
            }

            public static final Unit a(Function2 function2, boolean z, MutableState mutableState, a.AbstractC0526a.c it) {
                Intrinsics.checkNotNullParameter(it, "it");
                f.b(mutableState, it);
                function2.invoke(f.b(mutableState), z ? a.AbstractC0526a.c.EnumC0528a.e : a.AbstractC0526a.c.EnumC0528a.f);
                return Unit.INSTANCE;
            }

            public static final Unit a(String str, SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                SemanticsPropertiesKt.setContentDescription(semantics, str);
                SemanticsPropertiesKt.setTestTag(semantics, str);
                return Unit.INSTANCE;
            }

            public static final Unit a(Function1 function1, boolean z, Function2 function2, Function0 function0, MutableState mutableState) {
                function1.invoke(Boolean.valueOf(!z));
                f.b(mutableState, new a.AbstractC0526a.c(z ? a.AbstractC0526a.c.EnumC0528a.e : a.AbstractC0526a.c.EnumC0528a.f, f.b(mutableState).e(), f.b(mutableState).f()));
                function2.invoke(f.b(mutableState), z ? a.AbstractC0526a.c.EnumC0528a.f : a.AbstractC0526a.c.EnumC0528a.e);
                if (function0 != null) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }
        }
    }

    public static final class g implements Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Alignment f2921a;
        public final /* synthetic */ PaddingValues b;
        public final /* synthetic */ long c;

        public static final class a implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f2922a;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i b;
            public final /* synthetic */ long c;

            public a(boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, long j) {
                this.f2922a = z;
                this.b = iVar;
                this.c = j;
            }

            public final void a(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1435522410, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultProgressBar.<anonymous>.<anonymous> (VastRenderer.kt:378)");
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.m.a(this.f2922a, this.b, null, this.c, composer, 0, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
                a(animatedVisibilityScope, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        public g(Alignment alignment, PaddingValues paddingValues, long j) {
            this.f2921a = alignment;
            this.b = paddingValues;
            this.c = j;
        }

        public final void a(BoxScope boxScope, boolean z, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i progress, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(progress, "progress");
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
            if ((i2 & 1171) == 1170 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1967084142, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultProgressBar.<anonymous> (VastRenderer.kt:370)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z || ((progress instanceof i.c) && ((i.c) progress).c() > 0), PaddingKt.padding(boxScope.align(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), this.f2921a), this.b), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, -1435522410, true, new a(z, progress, this.c)), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Boolean bool, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i iVar, Composer composer, Integer num) {
            a(boxScope, bool.booleanValue(), iVar, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final class h implements Function2<Composer, Integer, Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, ? extends Unit>, ? super Function1<? super Boolean, ? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f2923a = new h();

        public final Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(838284708);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(838284708, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:174)");
            }
            Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> function7A = n.a(0L, 0L, null, 0L, null, null, 0L, null, null, null, composer, 0, AnalyticsListener.EVENT_DRM_KEYS_LOADED);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function7A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, ? extends Unit>, ? super Function1<? super Boolean, ? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class i implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0526a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f2924a = new i();

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-562763068);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-562763068, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:175)");
            }
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> function10A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function10A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0526a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class j implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0526a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final j f2925a = new j();

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-450891997);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-450891997, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:176)");
            }
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> function10A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function10A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0526a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class k implements Function2<Composer, Integer, Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0526a.c, ? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f2926a = new k();

        public final Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0526a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-832109727);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-832109727, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:177)");
            }
            Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0526a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> function7A = n.a(null, null, 0L, null, null, null, composer, 0, 63);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function7A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0526a.c, ? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class l implements Function2<Composer, Integer, Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f2927a = new l();

        public final Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(976926819);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(976926819, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:179)");
            }
            Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> function5A = n.a(null, null, 0L, composer, 0, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function5A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    public static final class m implements Function2<Composer, Integer, Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f2928a = new m();

        public final Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(658271039);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(658271039, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:180)");
            }
            Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> function6A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.a(null, null, composer, 0, 3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return function6A;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit> invoke(Composer composer, Integer num) {
            return a(composer, num.intValue());
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$n, reason: collision with other inner class name */
    public static final class C0508n implements Function2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0508n f2929a = new C0508n();

        public final Void a(Composer composer, int i) {
            composer.startReplaceableGroup(-1106742594);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1106742594, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous> (VastRenderer.kt:181)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceableGroup();
            return null;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((Composer) obj, ((Number) obj2).intValue());
        }
    }

    public static final class o implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i f2930a;
        public final /* synthetic */ long b;
        public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit>> c;
        public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> d;
        public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> e;
        public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0526a.c, Unit>, Function0<Unit>, Composer, Integer, Unit>> f;
        public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i g;
        public final /* synthetic */ Function2<Composer, Integer, Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit>> h;
        public final /* synthetic */ Function2<Composer, Integer, Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit>> i;
        public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, Unit>, Function0<Unit>, Composer, Integer, Unit>> j;
        public final /* synthetic */ P k;

        public static final class a implements Function2<Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i f2931a;
            public final /* synthetic */ long b;
            public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit>> c;
            public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> d;
            public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> e;
            public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0526a.c, Unit>, Function0<Unit>, Composer, Integer, Unit>> f;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i g;
            public final /* synthetic */ Function2<Composer, Integer, Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit>> h;
            public final /* synthetic */ Function2<Composer, Integer, Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit>> i;
            public final /* synthetic */ Function2<Composer, Integer, Function7<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Function1<? super Boolean, Unit>, Function0<Unit>, Composer, Integer, Unit>> j;
            public final /* synthetic */ P k;

            /* JADX WARN: Multi-variable type inference failed */
            public a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, long j, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit>> function2, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function22, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function23, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function24, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar2, Function2<? super Composer, ? super Integer, ? extends Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit>> function25, Function2<? super Composer, ? super Integer, ? extends Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function26, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function27, P p) {
                this.f2931a = iVar;
                this.b = j;
                this.c = function2;
                this.d = function22;
                this.e = function23;
                this.f = function24;
                this.g = iVar2;
                this.h = function25;
                this.i = function26;
                this.j = function27;
                this.k = p;
            }

            public final void a(Composer composer, int i) {
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(831245532, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:189)");
                }
                n.a(this.f2931a, null, this.b, this.c.invoke(composer, 0), this.d.invoke(composer, 0), this.e.invoke(composer, 0), this.f.invoke(composer, 0), this.g, this.h.invoke(composer, 0), this.i.invoke(composer, 0), this.j.invoke(composer, 0), this.k, composer, 0, 0, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                a(composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public o(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, long j, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit>> function2, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function22, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function23, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function24, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar2, Function2<? super Composer, ? super Integer, ? extends Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit>> function25, Function2<? super Composer, ? super Integer, ? extends Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function26, Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> function27, P p) {
            this.f2930a = iVar;
            this.b = j;
            this.c = function2;
            this.d = function22;
            this.e = function23;
            this.f = function24;
            this.g = iVar2;
            this.h = function25;
            this.i = function26;
            this.j = function27;
            this.k = p;
        }

        public final void a(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(876197241, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultVastRenderer.<anonymous>.<anonymous>.<anonymous> (VastRenderer.kt:188)");
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.a(false, ComposableLambdaKt.composableLambda(composer, 831245532, true, new a(this.f2930a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k)), composer, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            a(composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, Modifier modifier, long j2, Function7 function7, Function10 function10, Function10 function102, Function7 function72, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar2, Function5 function5, Function6 function6, Function7 function73, P p, int i2, int i3, int i4, Composer composer, int i5) {
        a(iVar, modifier, j2, function7, function10, function102, function72, iVar2, function5, function6, function73, p, composer, i2 | 1, i3, i4);
        return Unit.INSTANCE;
    }

    public static final boolean b(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x04f3  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:236:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0113  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r12v1, types: [kotlin.jvm.functions.Function7] */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v2, types: [androidx.compose.foundation.layout.PaddingValues, androidx.compose.ui.Alignment] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r43v3, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i] */
    /* JADX WARN: Type inference failed for: r47v3, types: [kotlin.jvm.functions.Function7] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v34, types: [com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i] */
    /* JADX WARN: Type inference failed for: r9v35 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i r41, androidx.compose.ui.Modifier r42, long r43, kotlin.jvm.functions.Function7<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super java.lang.Boolean, ? super kotlin.jvm.functions.Function2<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0526a.c, ? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0526a.c.EnumC0528a, kotlin.Unit>, ? super kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, kotlin.jvm.functions.Function10<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super java.lang.Boolean, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, ? super kotlin.jvm.functions.Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0526a.c, kotlin.Unit>, ? super java.lang.Boolean, ? super kotlin.UInt, ? super kotlin.UInt, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r46, kotlin.jvm.functions.Function10<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super java.lang.Boolean, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, ? super kotlin.jvm.functions.Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0526a.c, kotlin.Unit>, ? super java.lang.Boolean, ? super kotlin.UInt, ? super kotlin.UInt, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, kotlin.jvm.functions.Function7<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super kotlinx.coroutines.flow.StateFlow<? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a>, ? super kotlin.jvm.functions.Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0526a.c, kotlin.Unit>, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i r49, kotlin.jvm.functions.Function5<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r50, kotlin.jvm.functions.Function6<? super androidx.compose.foundation.layout.BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function7<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit>, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.P r53, androidx.compose.runtime.Composer r54, final int r55, final int r56, final int r57) {
        /*
            Method dump skipped, instruction units count: 1378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, androidx.compose.ui.Modifier, long, kotlin.jvm.functions.Function7, kotlin.jvm.functions.Function10, kotlin.jvm.functions.Function10, kotlin.jvm.functions.Function7, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i, kotlin.jvm.functions.Function5, kotlin.jvm.functions.Function6, kotlin.jvm.functions.Function7, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.P, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final Function2<Context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i, View> a(final long j2, final Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, ? super Function1<? super Boolean, Unit>, ? super Composer, ? super Integer, Unit>> muteButton, final Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> adCloseCountdownButton, final Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> adSkipCountdownButton, final Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> ctaButton, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar, final Function2<? super Composer, ? super Integer, ? extends Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, Unit>> progressBar, final Function2<? super Composer, ? super Integer, ? extends Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> vastIcon, final Function2<? super Composer, ? super Integer, ? extends Function7<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Function1<? super Boolean, Unit>, ? super Function0<Unit>, ? super Composer, ? super Integer, Unit>> playbackControl, final P viewVisibilityTracker) {
        Intrinsics.checkNotNullParameter(muteButton, "muteButton");
        Intrinsics.checkNotNullParameter(adCloseCountdownButton, "adCloseCountdownButton");
        Intrinsics.checkNotNullParameter(adSkipCountdownButton, "adSkipCountdownButton");
        Intrinsics.checkNotNullParameter(ctaButton, "ctaButton");
        Intrinsics.checkNotNullParameter(progressBar, "progressBar");
        Intrinsics.checkNotNullParameter(vastIcon, "vastIcon");
        Intrinsics.checkNotNullParameter(playbackControl, "playbackControl");
        Intrinsics.checkNotNullParameter(viewVisibilityTracker, "viewVisibilityTracker");
        return new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return n.a(j2, muteButton, adCloseCountdownButton, adSkipCountdownButton, ctaButton, iVar, progressBar, vastIcon, playbackControl, viewVisibilityTracker, (Context) obj, (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i) obj2);
            }
        };
    }

    public static final ComposeView a(long j2, Function2 function2, Function2 function22, Function2 function23, Function2 function24, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.i iVar, Function2 function25, Function2 function26, Function2 function27, P p, Context context, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i adViewModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adViewModel, "adViewModel");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setId(R.id.moloco_fullscreen_ad_view_id);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(876197241, true, new o(adViewModel, j2, function2, function22, function23, function24, iVar, function25, function26, function27, p)));
        return composeView;
    }

    public static final Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a(long j2, long j3, Shape shape, long j4, Alignment alignment, PaddingValues paddingValues, long j5, Painter painter, Painter painter2, Function0<Unit> function0, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(447650301);
        long jB = (i3 & 1) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.b() : j2;
        long j6 = (i3 & 2) != 0 ? jB : j3;
        Shape shapeF = (i3 & 4) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.f() : shape;
        long jE = (i3 & 8) != 0 ? com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.e() : j4;
        Alignment topStart = (i3 & 16) != 0 ? Alignment.INSTANCE.getTopStart() : alignment;
        PaddingValues paddingValuesM421PaddingValues0680j_4 = (i3 & 32) != 0 ? PaddingKt.m421PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a()) : paddingValues;
        long jM991getPrimary0d7_KjU = (i3 & 64) != 0 ? MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m991getPrimary0d7_KjU() : j5;
        Painter painterPainterResource = (i3 & 128) != 0 ? PainterResources_androidKt.painterResource(R.drawable.ic_round_volume_off_24, composer, 0) : painter;
        Painter painterPainterResource2 = (i3 & 256) != 0 ? PainterResources_androidKt.painterResource(R.drawable.ic_round_volume_up_24, composer, 0) : painter2;
        Function0<Unit> function02 = (i3 & 512) != 0 ? null : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(447650301, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultMuteButton (VastRenderer.kt:226)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -545982054, true, new f(topStart, paddingValuesM421PaddingValues0680j_4, painterPainterResource, painterPainterResource2, function02, jM991getPrimary0d7_KjU, jB, j6, shapeF, jE));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0526a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Alignment alignment, PaddingValues paddingValues, long j2, String str, String str2, Function0<Unit> function0, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(-926425258);
        Alignment bottomEnd = (i3 & 1) != 0 ? Alignment.INSTANCE.getBottomEnd() : alignment;
        PaddingValues paddingValuesM421PaddingValues0680j_4 = (i3 & 2) != 0 ? PaddingKt.m421PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a()) : paddingValues;
        long jM991getPrimary0d7_KjU = (i3 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m991getPrimary0d7_KjU() : j2;
        String strStringResource = (i3 & 8) != 0 ? StringResources_androidKt.stringResource(R.string.com_moloco_sdk_xenoss_player_learn_more, composer, 0) : str;
        String str3 = (i3 & 16) != 0 ? null : str2;
        Function0<Unit> function02 = (i3 & 32) != 0 ? null : function0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-926425258, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultCTAButton (VastRenderer.kt:294)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 432764356, true, new e(bottomEnd, paddingValuesM421PaddingValues0680j_4, str3, strStringResource, jM991getPrimary0d7_KjU, function02));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> a(Alignment alignment, PaddingValues paddingValues, long j2, Composer composer, int i2, int i3) {
        composer.startReplaceableGroup(716005120);
        if ((i3 & 1) != 0) {
            alignment = Alignment.INSTANCE.getBottomCenter();
        }
        if ((i3 & 2) != 0) {
            paddingValues = PaddingKt.m421PaddingValues0680j_4(Dp.m3887constructorimpl(0));
        }
        if ((i3 & 4) != 0) {
            j2 = MaterialTheme.INSTANCE.getColors(composer, MaterialTheme.$stable).m991getPrimary0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(716005120, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.defaultProgressBar (VastRenderer.kt:369)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 1967084142, true, new g(alignment, paddingValues, j2));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final i.a a(State<? extends i.a> state) {
        return state.getValue();
    }
}
