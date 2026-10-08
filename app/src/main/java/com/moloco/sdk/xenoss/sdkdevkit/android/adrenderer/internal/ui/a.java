package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.google.android.exoplayer2.RendererCapabilities;
import com.moloco.sdk.R;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2675a = "https://cdn-f.adsmoloco.com/moloco-cdn/privacy.html";

    public static final class b implements Function4<BoxScope, Function1<? super a.AbstractC0526a.c, ? extends Unit>, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Modifier f2679a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1<String, Unit> c;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$b$a, reason: collision with other inner class name */
        public static final class C0468a implements Function3<Modifier, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Modifier f2680a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Function1<String, Unit> c;

            /* JADX WARN: Multi-variable type inference failed */
            public C0468a(Modifier modifier, String str, Function1<? super String, Unit> function1) {
                this.f2680a = modifier;
                this.b = str;
                this.c = function1;
            }

            public final void a(Modifier trackableModifier, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(trackableModifier, "trackableModifier");
                if ((i & 6) == 0) {
                    i |= composer.changed(trackableModifier) ? 4 : 2;
                }
                if ((i & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(592042825, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge.<anonymous>.<anonymous> (AdBadge.kt:136)");
                }
                a.a(this.f2680a.then(trackableModifier), this.b, this.c, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Modifier modifier, String str, Function1<? super String, Unit> function1) {
            this.f2679a = modifier;
            this.b = str;
            this.c = function1;
        }

        public final void a(BoxScope boxScope, Function1<? super a.AbstractC0526a.c, Unit> onButtonRendered, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
            if ((i & 48) == 0) {
                i |= composer.changed(onButtonRendered) ? 32 : 16;
            }
            if ((i & 145) == 144 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652534615, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge.<anonymous> (AdBadge.kt:132)");
            }
            w.a(null, a.AbstractC0526a.c.EnumC0528a.i, onButtonRendered, ComposableLambdaKt.composableLambda(composer, 592042825, true, new C0468a(this.f2679a, this.b, this.c)), composer, ((i << 3) & 896) | 3120, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Function1<? super a.AbstractC0526a.c, ? extends Unit> function1, Composer composer, Integer num) {
            a(boxScope, function1, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(Modifier modifier, String str, Function1 function1, int i, int i2, Composer composer, int i3) {
        a(modifier, str, function1, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final Function5<BoxScope, Function1<? super a.AbstractC0526a.c, Unit>, StateFlow<? extends i.a>, Composer, Integer, Unit> b(Modifier modifier, final String str, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, Function1<? super String, Unit> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1665380566);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = f2675a;
        }
        if ((i2 & 4) != 0) {
            rVar = a.h.f2426a.f();
        }
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-819746537);
            boolean zChanged = composer.changed(rVar) | composer.changed(str);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return a.b(rVar, str, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1665380566, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge (AdBadge.kt:80)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, 781429248, true, new C0466a(modifier, str, function1));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Function4<BoxScope, Function1<? super a.AbstractC0526a.c, Unit>, Composer, Integer, Unit> c(Modifier modifier, final String str, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, Function1<? super String, Unit> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1806921710);
        if ((i2 & 1) != 0) {
            modifier = Modifier.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            str = f2675a;
        }
        if ((i2 & 4) != 0) {
            rVar = a.h.f2426a.f();
        }
        if ((i2 & 8) != 0) {
            composer.startReplaceableGroup(-763782202);
            boolean zChanged = composer.changed(rVar) | composer.changed(str);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return a.c(rVar, str, (String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            function1 = (Function1) objRememberedValue;
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1806921710, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultWebViewAdBadge (AdBadge.kt:131)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -652534615, true, new b(modifier, str, function1));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    public static final Unit a(int i, Composer composer, int i2) {
        a(composer, i | 1);
        return Unit.INSTANCE;
    }

    public static final Unit a(Modifier modifier, String str, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, Function1 function1, int i, int i2, Composer composer, int i3) {
        a(modifier, str, rVar, (Function1<? super String, Unit>) function1, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final String clickUrl, final Function1<? super String, Unit> onClick, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(clickUrl, "clickUrl");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(1037954372);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(clickUrl) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= RendererCapabilities.MODE_SUPPORT_MASK;
        } else if ((i & RendererCapabilities.MODE_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(onClick) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1037954372, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdBadge (AdBadge.kt:43)");
            }
            composerStartRestartGroup.startReplaceableGroup(-363689698);
            final String str = "Ad Badge";
            boolean zChanged = composerStartRestartGroup.changed("Ad Badge");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return a.a(str, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM461requiredSize3ABfNKs = SizeKt.m461requiredSize3ABfNKs(SemanticsModifierKt.semantics$default(modifier3, false, (Function1) objRememberedValue, 1, null), Dp.m3887constructorimpl(12));
            composerStartRestartGroup.startReplaceableGroup(-363682862);
            boolean zChanged2 = composerStartRestartGroup.changed(onClick) | composerStartRestartGroup.changed(clickUrl);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return a.a(onClick, clickUrl);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            IconKt.m1088Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.info_badge, composerStartRestartGroup, 0), "Ad Badge", ClickableKt.m194clickableXHw0xAI$default(modifierM461requiredSize3ABfNKs, false, null, null, (Function0) objRememberedValue2, 7, null), Color.INSTANCE.m1681getUnspecified0d7_KjU(), composerStartRestartGroup, 3120, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return a.a(modifier4, clickUrl, onClick, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$a, reason: collision with other inner class name */
    public static final class C0466a implements Function5<BoxScope, Function1<? super a.AbstractC0526a.c, ? extends Unit>, StateFlow<? extends i.a>, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Modifier f2676a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1<String, Unit> c;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$a$a, reason: collision with other inner class name */
        public static final class C0467a implements Function3<Modifier, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Modifier f2677a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Function1<String, Unit> c;

            /* JADX WARN: Multi-variable type inference failed */
            public C0467a(Modifier modifier, String str, Function1<? super String, Unit> function1) {
                this.f2677a = modifier;
                this.b = str;
                this.c = function1;
            }

            public final void a(Modifier trackableModifier, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(trackableModifier, "trackableModifier");
                if ((i & 6) == 0) {
                    i |= composer.changed(trackableModifier) ? 4 : 2;
                }
                if ((i & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1901554514, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous>.<anonymous>.<anonymous> (AdBadge.kt:89)");
                }
                a.a(this.f2677a.then(trackableModifier), this.b, this.c, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$a$b */
        public static final class b implements Function3<Modifier, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Modifier f2678a;
            public final /* synthetic */ String b;
            public final /* synthetic */ Function1<String, Unit> c;

            /* JADX WARN: Multi-variable type inference failed */
            public b(Modifier modifier, String str, Function1<? super String, Unit> function1) {
                this.f2678a = modifier;
                this.b = str;
                this.c = function1;
            }

            public final void a(Modifier trackableModifier, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(trackableModifier, "trackableModifier");
                if ((i & 6) == 0) {
                    i |= composer.changed(trackableModifier) ? 4 : 2;
                }
                if ((i & 19) == 18 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1149096507, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous>.<anonymous>.<anonymous> (AdBadge.kt:101)");
                }
                a.a(this.f2678a.then(trackableModifier), this.b, this.c, composer, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Modifier modifier, Composer composer, Integer num) {
                a(modifier, composer, num.intValue());
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C0466a(Modifier modifier, String str, Function1<? super String, Unit> function1) {
            this.f2676a = modifier;
            this.b = str;
            this.c = function1;
        }

        public final void a(BoxScope boxScope, Function1<? super a.AbstractC0526a.c, Unit> onButtonRendered, StateFlow<? extends i.a> stateFlow, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(boxScope, "<this>");
            Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(781429248, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultVastAdBadge.<anonymous> (AdBadge.kt:81)");
            }
            if (stateFlow != null) {
                Modifier modifier = this.f2676a;
                String str = this.b;
                Function1<String, Unit> function1 = this.c;
                i.a aVarA = a(SnapshotStateKt.collectAsState(stateFlow, null, composer, 0, 1));
                if (aVarA instanceof i.a.c) {
                    composer.startReplaceableGroup(-784868645);
                    w.a(null, a.AbstractC0526a.c.EnumC0528a.i, onButtonRendered, ComposableLambdaKt.composableLambda(composer, 1901554514, true, new C0467a(modifier, str, function1)), composer, ((i << 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarA instanceof i.a.C0495a) {
                    composer.startReplaceableGroup(-784421253);
                    w.a(null, a.AbstractC0526a.c.EnumC0528a.i, onButtonRendered, ComposableLambdaKt.composableLambda(composer, 1149096507, true, new b(modifier, str, function1)), composer, ((i << 3) & 896) | 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarA instanceof i.a.b) {
                    composer.startReplaceableGroup(-783991872);
                    composer.endReplaceableGroup();
                } else if (aVarA instanceof i.a.d) {
                    composer.startReplaceableGroup(-783934336);
                    composer.endReplaceableGroup();
                } else {
                    if (aVarA != null) {
                        composer.startReplaceableGroup(-1687887796);
                        composer.endReplaceableGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer.startReplaceableGroup(-783899616);
                    composer.endReplaceableGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function5
        public /* bridge */ /* synthetic */ Unit invoke(BoxScope boxScope, Function1<? super a.AbstractC0526a.c, ? extends Unit> function1, StateFlow<? extends i.a> stateFlow, Composer composer, Integer num) {
            a(boxScope, function1, stateFlow, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public static final i.a a(State<? extends i.a> state) {
            return state.getValue();
        }
    }

    public static final Unit c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        rVar.a(str);
        return Unit.INSTANCE;
    }

    public static final Unit b(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        rVar.a(str);
        return Unit.INSTANCE;
    }

    public static final Unit a(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        SemanticsPropertiesKt.setTestTag(semantics, str);
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    public static final Unit a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        rVar.a(str);
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final String str, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar, Function1<? super String, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1950835232);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & RendererCapabilities.MODE_SUPPORT_MASK) == 0) {
            i3 |= ((i2 & 4) == 0 && composerStartRestartGroup.changed(rVar)) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= ((i2 & 8) == 0 && composerStartRestartGroup.changed(function1)) ? 2048 : 1024;
        }
        if ((i3 & 1171) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if (i4 != 0) {
                    modifier = Modifier.INSTANCE;
                }
                if (i5 != 0) {
                    str = f2675a;
                }
                if ((i2 & 4) != 0) {
                    rVar = a.h.f2426a.f();
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    composerStartRestartGroup.startReplaceableGroup(1664240417);
                    boolean zChanged = composerStartRestartGroup.changed(rVar) | composerStartRestartGroup.changed(str);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return a.a(rVar, str, (String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    i3 &= -7169;
                    function1 = (Function1) objRememberedValue;
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1950835232, i3, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.defaultNativeAdImageBadge (AdBadge.kt:155)");
            }
            a(modifier, str, function1, composerStartRestartGroup, (i3 & 126) | ((i3 >> 3) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        final String str2 = str;
        final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.r rVar2 = rVar;
        final Function1<? super String, Unit> function12 = function1;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return a.a(modifier2, str2, rVar2, function12, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void a(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1309369895);
        if (i == 0 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1309369895, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.AdBadgePreview (AdBadge.kt:165)");
            }
            MaterialThemeKt.MaterialTheme(null, null, null, k.f2693a.a(), composerStartRestartGroup, 3072, 7);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.a$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return a.a(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
