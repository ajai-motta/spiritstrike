package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.exoplayer2.RendererCapabilities;
import com.moloco.sdk.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.s;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: loaded from: classes6.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f3007a = Dp.m3887constructorimpl(12);

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$b, reason: collision with other inner class name */
    public static final class C0520b implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0526a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0520b f3009a = new C0520b();

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-1994751775);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1994751775, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous> (AdWebViewRenderer.kt:141)");
            }
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> function10A = q.a(null, null, 0L, 0L, 0L, null, null, null, composer, 0, 255);
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

    public static final class c implements Function2<Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MutableStateFlow<Boolean> f3010a;
        public final /* synthetic */ WebView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Function1<a.AbstractC0526a.c, Unit> d;
        public final /* synthetic */ Function0<Unit> e;
        public final /* synthetic */ long f;
        public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> g;
        public final /* synthetic */ z h;
        public final /* synthetic */ Dp i;
        public final /* synthetic */ boolean j;

        public static final class a implements Function2<Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MutableStateFlow<Boolean> f3011a;
            public final /* synthetic */ WebView b;
            public final /* synthetic */ int c;
            public final /* synthetic */ Function1<a.AbstractC0526a.c, Unit> d;
            public final /* synthetic */ Function0<Unit> e;
            public final /* synthetic */ long f;
            public final /* synthetic */ Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> g;
            public final /* synthetic */ z h;
            public final /* synthetic */ Dp i;
            public final /* synthetic */ boolean j;

            /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$c$a$a, reason: collision with other inner class name */
            @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.AdWebViewRendererKt$defaultAdWebViewRenderer$2$1$1$1$1$1", f = "AdWebViewRenderer.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
            public static final class C0521a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f3012a;
                public final /* synthetic */ MutableState<Boolean> b;
                public final /* synthetic */ MutableStateFlow<Boolean> c;

                /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$c$a$a$a, reason: collision with other inner class name */
                public static final class C0522a<T> implements FlowCollector {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ MutableStateFlow<Boolean> f3013a;

                    public C0522a(MutableStateFlow<Boolean> mutableStateFlow) {
                        this.f3013a = mutableStateFlow;
                    }

                    public final Object a(boolean z, Continuation<? super Unit> continuation) {
                        this.f3013a.setValue(Boxing.boxBoolean(z));
                        return Unit.INSTANCE;
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                        return a(((Boolean) obj).booleanValue(), continuation);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0521a(MutableState<Boolean> mutableState, MutableStateFlow<Boolean> mutableStateFlow, Continuation<? super C0521a> continuation) {
                    super(2, continuation);
                    this.b = mutableState;
                    this.c = mutableStateFlow;
                }

                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C0521a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C0521a(this.b, this.c, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f3012a;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        final MutableState<Boolean> mutableState = this.b;
                        Flow flowSnapshotFlow = SnapshotStateKt.snapshotFlow(new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$c$a$a$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(b.c.a.C0521a.a(mutableState));
                            }
                        });
                        C0522a c0522a = new C0522a(this.c);
                        this.f3012a = 1;
                        if (flowSnapshotFlow.collect(c0522a, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                }

                public static final boolean a(MutableState mutableState) {
                    return ((Boolean) mutableState.getValue()).booleanValue();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a(MutableStateFlow<Boolean> mutableStateFlow, WebView webView, int i, Function1<? super a.AbstractC0526a.c, Unit> function1, Function0<Unit> function0, long j, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function2, z zVar, Dp dp, boolean z) {
                this.f3011a = mutableStateFlow;
                this.b = webView;
                this.c = i;
                this.d = function1;
                this.e = function0;
                this.f = j;
                this.g = function2;
                this.h = zVar;
                this.i = dp;
                this.j = z;
            }

            public final void a(Composer composer, int i) {
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-126697744, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AdWebViewRenderer.kt:148)");
                }
                composer.startReplaceableGroup(1335678415);
                MutableStateFlow<Boolean> mutableStateFlow = this.f3011a;
                Object objRememberedValue = composer.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(mutableStateFlow.getValue(), null, 2, null);
                    composer.updateRememberedValue(objRememberedValue);
                }
                MutableState mutableState = (MutableState) objRememberedValue;
                composer.endReplaceableGroup();
                Unit unit = Unit.INSTANCE;
                composer.startReplaceableGroup(1335682252);
                boolean zChanged = composer.changed(mutableState) | composer.changed(this.f3011a);
                MutableStateFlow<Boolean> mutableStateFlow2 = this.f3011a;
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new C0521a(mutableState, mutableStateFlow2, null);
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composer, 6);
                b.a(this.b, this.c, mutableState, this.d, this.e, null, this.f, this.g.invoke(composer, 0), this.h, this.i.m3901unboximpl(), this.j, composer, RendererCapabilities.MODE_SUPPORT_MASK, 0, 32);
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
        public c(MutableStateFlow<Boolean> mutableStateFlow, WebView webView, int i, Function1<? super a.AbstractC0526a.c, Unit> function1, Function0<Unit> function0, long j, Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> function2, z zVar, Dp dp, boolean z) {
            this.f3010a = mutableStateFlow;
            this.b = webView;
            this.c = i;
            this.d = function1;
            this.e = function0;
            this.f = j;
            this.g = function2;
            this.h = zVar;
            this.i = dp;
            this.j = z;
        }

        public final void a(Composer composer, int i) {
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1932677773, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.defaultAdWebViewRenderer.<anonymous>.<anonymous>.<anonymous> (AdWebViewRenderer.kt:147)");
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.theme.c.a(false, ComposableLambdaKt.composableLambda(composer, -126697744, true, new a(this.f3010a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j)), composer, 48, 1);
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

    public static final Unit a(WebView webView, int i, MutableState mutableState, Function1 function1, Function0 function0, Modifier modifier, long j, Function10 function10, z zVar, float f, boolean z, int i2, int i3, int i4, Composer composer, int i5) {
        a(webView, i, mutableState, function1, function0, modifier, j, function10, zVar, f, z, composer, i2 | 1, i3, i4);
        return Unit.INSTANCE;
    }

    public static final void c(MutableStateFlow<Boolean> mutableStateFlow, Function0<Unit> function0) {
        if (mutableStateFlow.getValue().booleanValue()) {
            function0.invoke();
        }
    }

    public static final Unit d(MutableStateFlow mutableStateFlow, Function0 function0) {
        c(mutableStateFlow, function0);
        return Unit.INSTANCE;
    }

    public static final Unit e(MutableStateFlow mutableStateFlow, Function0 function0) {
        c(mutableStateFlow, function0);
        return Unit.INSTANCE;
    }

    public static final Unit a(Activity activity, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i iVar, WebView webView, int i, Function1 function1, Function0 function0, Function9 function9, z zVar, Function10 function10, Function10 function102, int i2, Composer composer, int i3) {
        a(activity, iVar, webView, i, function1, function0, function9, zVar, function10, function102, composer, i2 | 1);
        return Unit.INSTANCE;
    }

    public static final Unit b(MutableStateFlow mutableStateFlow, Function0 function0) {
        a((MutableStateFlow<Boolean>) mutableStateFlow, (Function0<Unit>) function0);
        return Unit.INSTANCE;
    }

    public static final Unit a(Activity activity, WebView webView, int i, Function1 function1, Function0 function0, Function9 function9, z zVar, int i2, Composer composer, int i3) {
        a(activity, webView, i, function1, function0, function9, zVar, composer, i2 | 1);
        return Unit.INSTANCE;
    }

    public static final float a() {
        return f3007a;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:177:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final android.webkit.WebView r33, final int r34, final androidx.compose.runtime.MutableState<java.lang.Boolean> r35, final kotlin.jvm.functions.Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0526a.c, kotlin.Unit> r36, final kotlin.jvm.functions.Function0<kotlin.Unit> r37, androidx.compose.ui.Modifier r38, long r39, kotlin.jvm.functions.Function10<? super androidx.compose.foundation.layout.BoxScope, ? super java.lang.Boolean, ? super java.lang.Boolean, ? super kotlin.jvm.functions.Function0<kotlin.Unit>, ? super kotlin.jvm.functions.Function1<? super com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a.AbstractC0526a.c, kotlin.Unit>, ? super java.lang.Boolean, ? super kotlin.UInt, ? super kotlin.UInt, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z r42, final float r43, final boolean r44, androidx.compose.runtime.Composer r45, final int r46, final int r47, final int r48) {
        /*
            Method dump skipped, instruction units count: 955
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b.a(android.webkit.WebView, int, androidx.compose.runtime.MutableState, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, long, kotlin.jvm.functions.Function10, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.z, float, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final class a implements Function3<i.a, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super a.AbstractC0526a.c, Unit>, Function0<Unit>, z, Dp, Boolean, View> f3008a;
        public final /* synthetic */ WebView b;
        public final /* synthetic */ int c;
        public final /* synthetic */ MutableStateFlow<Boolean> d;
        public final /* synthetic */ Function1<a.AbstractC0526a.c, Unit> e;
        public final /* synthetic */ Function0<Unit> f;
        public final /* synthetic */ z g;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View> function9, WebView webView, int i, MutableStateFlow<Boolean> mutableStateFlow, Function1<? super a.AbstractC0526a.c, Unit> function1, Function0<Unit> function0, z zVar) {
            this.f3008a = function9;
            this.b = webView;
            this.c = i;
            this.d = mutableStateFlow;
            this.e = function1;
            this.f = function0;
            this.g = zVar;
        }

        public final void a(i.a aVar, Composer composer, int i) {
            if ((i & 6) == 0) {
                i |= composer.changed(aVar) ? 4 : 2;
            }
            if ((i & 19) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1684775380, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.MraidAdContainerScreen.<anonymous>.<anonymous> (AdWebViewRenderer.kt:218)");
            }
            if (aVar instanceof i.a.C0495a) {
                composer.startReplaceableGroup(1825931895);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.c) {
                composer.startReplaceableGroup(1825994391);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.b) {
                composer.startReplaceableGroup(-1880756851);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.f.a(((i.a.b) aVar).d(), null, null, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 3504, 0);
                composer.endReplaceableGroup();
            } else if (aVar instanceof i.a.d) {
                composer.startReplaceableGroup(-1880747644);
                composer.startReplaceableGroup(-1880746209);
                boolean zChanged = composer.changed(this.f3008a) | composer.changed(this.b) | composer.changed(this.c) | composer.changed(this.d) | composer.changed(this.e) | composer.changed(this.f) | composer.changed(this.g);
                final Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super a.AbstractC0526a.c, Unit>, Function0<Unit>, z, Dp, Boolean, View> function9 = this.f3008a;
                final WebView webView = this.b;
                final int i2 = this.c;
                final MutableStateFlow<Boolean> mutableStateFlow = this.d;
                final Function1<a.AbstractC0526a.c, Unit> function1 = this.e;
                final z zVar = this.g;
                final Function0<Unit> function0 = this.f;
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$a$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return b.a.a(function9, webView, i2, mutableStateFlow, function1, zVar, function0, (Context) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                AndroidView_androidKt.AndroidView((Function1) objRememberedValue, null, null, composer, 0, 6);
                composer.endReplaceableGroup();
            } else {
                if (aVar != null) {
                    composer.startReplaceableGroup(-1880762669);
                    composer.endReplaceableGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceableGroup(1826950307);
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

        public static final View a(Function9 function9, WebView webView, int i, final MutableStateFlow mutableStateFlow, Function1 function1, z zVar, final Function0 function0, Context it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return (View) function9.invoke(it, webView, Integer.valueOf(i), mutableStateFlow, function1, new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$a$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return b.a.a(mutableStateFlow, function0);
                }
            }, zVar, Dp.m3885boximpl(b.a()), Boolean.TRUE);
        }

        public static final Unit a(MutableStateFlow mutableStateFlow, Function0 function0) {
            b.a((MutableStateFlow<Boolean>) mutableStateFlow, (Function0<Unit>) function0);
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Function9 a(long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = Color.INSTANCE.m1671getBlack0d7_KjU();
        }
        if ((i & 2) != 0) {
            function2 = C0520b.f3009a;
        }
        return a(j, (Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>>) function2);
    }

    public static final Function9<Context, WebView, Integer, MutableStateFlow<Boolean>, Function1<? super a.AbstractC0526a.c, Unit>, Function0<Unit>, z, Dp, Boolean, View> a(final long j, final Function2<? super Composer, ? super Integer, ? extends Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit>> adCloseCountdownButton) {
        Intrinsics.checkNotNullParameter(adCloseCountdownButton, "adCloseCountdownButton");
        return new Function9() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function9
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
                return b.a(j, adCloseCountdownButton, (Context) obj, (WebView) obj2, ((Integer) obj3).intValue(), (MutableStateFlow) obj4, (Function1) obj5, (Function0) obj6, (z) obj7, (Dp) obj8, ((Boolean) obj9).booleanValue());
            }
        };
    }

    public static final ComposeView a(long j, Function2 function2, Context context, WebView webView, int i, MutableStateFlow canClose, Function1 onButtonRendered, Function0 onClose, z zVar, Dp dp, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(canClose, "canClose");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setId(R.id.moloco_fullscreen_ad_view_id);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-1932677773, true, new c(canClose, webView, i, onButtonRendered, onClose, j, function2, zVar, dp, z)));
        return composeView;
    }

    public static final void a(final Activity activity, final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i adViewModel, final WebView webView, final int i, final Function1<? super a.AbstractC0526a.c, Unit> onButtonRendered, final Function0<Unit> onClose, final Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View> adWebViewRenderer, final z zVar, final Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function10, final Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<Unit>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, Unit> function102, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(adViewModel, "adViewModel");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(adWebViewRenderer, "adWebViewRenderer");
        Composer composerStartRestartGroup = composer.startRestartGroup(-476084514);
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(activity) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(adViewModel) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.MODE_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(webView) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(onButtonRendered) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(onClose) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(adWebViewRenderer) ? 1048576 : 524288;
        }
        if ((12582912 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(zVar) ? 8388608 : 4194304;
        }
        if ((100663296 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(function10) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        if ((805306368 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(function102) ? 536870912 : 268435456;
        }
        int i4 = i3;
        if ((306783379 & i4) == 306783378 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-476084514, i4, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.MraidAdContainerScreen (AdWebViewRenderer.kt:200)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(BackgroundKt.m175backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m1671getBlack0d7_KjU(), null, 2, null), "MraidAdContainerScreen");
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierTestTag);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1298constructorimpl = Updater.m1298constructorimpl(composerStartRestartGroup);
            Updater.m1305setimpl(composerM1298constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1305setimpl(composerM1298constructorimpl, density, companion.getSetDensity());
            Updater.m1305setimpl(composerM1298constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m1305setimpl(composerM1298constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m1288boximpl(SkippableUpdater.m1289constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1204536538);
            boolean zChanged = composerStartRestartGroup.changed(i);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = StateFlowKt.MutableStateFlow(Boolean.valueOf(i == 0));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableStateFlow mutableStateFlow = (MutableStateFlow) objRememberedValue;
            composerStartRestartGroup.endReplaceableGroup();
            State stateCollectAsState = SnapshotStateKt.collectAsState(adViewModel.k(), null, composerStartRestartGroup, 0, 1);
            CrossfadeKt.Crossfade(a((State<? extends i.a>) stateCollectAsState), null, null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1684775380, true, new a(adWebViewRenderer, webView, i, mutableStateFlow, onButtonRendered, onClose, zVar)), composerStartRestartGroup, 3072, 6);
            composer2 = composerStartRestartGroup;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.e.a(boxScopeInstance, adViewModel, a((State<? extends i.a>) stateCollectAsState), function102, function10, composer2, (i4 & 112) | 6 | ((i4 >> 18) & 7168) | ((i4 >> 12) & 57344));
            composer2.startReplaceableGroup(1204592495);
            boolean zChanged2 = composer2.changed(mutableStateFlow) | composer2.changed(onClose);
            Object objRememberedValue2 = composer2.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.b(mutableStateFlow, onClose);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue2);
            }
            composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(false, (Function0) objRememberedValue2, composer2, 0, 1);
            s.a(activity, composer2, i4 & 14);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b.a(activity, adViewModel, webView, i, onButtonRendered, onClose, adWebViewRenderer, zVar, function10, function102, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void a(MutableStateFlow<Boolean> mutableStateFlow, Function0<Unit> function0) {
        if (mutableStateFlow.getValue().booleanValue()) {
            function0.invoke();
        }
    }

    public static final void a(final Activity activity, final WebView webView, final int i, final Function1<? super a.AbstractC0526a.c, Unit> onButtonRendered, final Function0<Unit> onClose, final Function9<? super Context, ? super WebView, ? super Integer, ? super MutableStateFlow<Boolean>, ? super Function1<? super a.AbstractC0526a.c, Unit>, ? super Function0<Unit>, ? super z, ? super Dp, ? super Boolean, ? extends View> adWebViewRenderer, final z zVar, Composer composer, final int i2) {
        int i3;
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(onButtonRendered, "onButtonRendered");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(adWebViewRenderer, "adWebViewRenderer");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1336318846);
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(activity) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(webView) ? 32 : 16;
        }
        if ((i2 & RendererCapabilities.MODE_SUPPORT_MASK) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(onButtonRendered) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(onClose) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(adWebViewRenderer) ? 131072 : 65536;
        }
        if ((1572864 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(zVar) ? 1048576 : 524288;
        }
        int i5 = i3;
        if ((599187 & i5) == 599186 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1336318846, i5, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.StaticAdWebViewScreen (AdWebViewRenderer.kt:270)");
            }
            Modifier modifierM175backgroundbw27NRU$default = BackgroundKt.m175backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.INSTANCE.m1671getBlack0d7_KjU(), null, 2, null);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3MaterializerOf = LayoutKt.materializerOf(modifierM175backgroundbw27NRU$default);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1298constructorimpl = Updater.m1298constructorimpl(composerStartRestartGroup);
            Updater.m1305setimpl(composerM1298constructorimpl, measurePolicyRememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1305setimpl(composerM1298constructorimpl, density, companion.getSetDensity());
            Updater.m1305setimpl(composerM1298constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m1305setimpl(composerM1298constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            function3MaterializerOf.invoke(SkippableUpdater.m1288boximpl(SkippableUpdater.m1289constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-2137368960);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(1609892771);
            boolean zChanged = composerStartRestartGroup.changed(i);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = StateFlowKt.MutableStateFlow(Boolean.valueOf(i == 0));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableStateFlow mutableStateFlow = (MutableStateFlow) objRememberedValue;
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1609900314);
            boolean zChanged2 = composerStartRestartGroup.changed(adWebViewRenderer) | composerStartRestartGroup.changed(webView) | composerStartRestartGroup.changed(i) | composerStartRestartGroup.changed(mutableStateFlow) | composerStartRestartGroup.changed(onButtonRendered) | composerStartRestartGroup.changed(onClose) | composerStartRestartGroup.changed(zVar);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                i4 = i5;
                composer2 = composerStartRestartGroup;
                Function1 function1 = new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b.a(adWebViewRenderer, webView, i, mutableStateFlow, onButtonRendered, zVar, onClose, (Context) obj);
                    }
                };
                composer2.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            } else {
                i4 = i5;
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceableGroup();
            AndroidView_androidKt.AndroidView((Function1) objRememberedValue2, null, null, composer2, 0, 6);
            composer2.startReplaceableGroup(1609912856);
            boolean zChanged3 = composer2.changed(mutableStateFlow) | composer2.changed(onClose);
            Object objRememberedValue3 = composer2.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b.e(mutableStateFlow, onClose);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue3);
            }
            composer2.endReplaceableGroup();
            BackHandlerKt.BackHandler(false, (Function0) objRememberedValue3, composer2, 0, 1);
            s.a(activity, composer2, i4 & 14);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b.a(activity, webView, i, onButtonRendered, onClose, adWebViewRenderer, zVar, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final View a(Function9 function9, WebView webView, int i, final MutableStateFlow mutableStateFlow, Function1 function1, z zVar, final Function0 function0, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return (View) function9.invoke(it, webView, Integer.valueOf(i), mutableStateFlow, function1, new Function0() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return b.d(mutableStateFlow, function0);
            }
        }, zVar, Dp.m3885boximpl(f3007a), Boolean.FALSE);
    }

    public static final i.a a(State<? extends i.a> state) {
        return state.getValue();
    }
}
