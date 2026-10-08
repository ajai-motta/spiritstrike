package com.moloco.sdk.internal;

import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.moloco.sdk.R;
import com.moloco.sdk.internal.ortb.model.C2988a;
import com.moloco.sdk.service_locator.a;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f2039a = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.d$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return d.c();
        }
    });
    public static final long b = Color.INSTANCE.m1682getWhite0d7_KjU();
    public static final long c = u.a();
    public static final int d = 30;
    public static final long e;

    public static final class a implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0526a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.z f2040a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i b;

        public a(com.moloco.sdk.internal.ortb.model.z zVar, com.moloco.sdk.internal.ortb.model.i iVar) {
            this.f2040a = zVar;
            this.b = iVar;
        }

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(-1299178940);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1299178940, i, -1, "com.moloco.sdk.internal.determineSkipCloseBehaviorFromDec.<anonymous> (AggregatedOptions.kt:182)");
            }
            float fM3887constructorimpl = Dp.m3887constructorimpl(this.f2040a.getControlSize());
            long jM3909DpSizeYgX7TsA = DpKt.m3909DpSizeYgX7TsA(fM3887constructorimpl, fM3887constructorimpl);
            Alignment alignmentA = d.a(this.f2040a.getHorizontalAlignment(), this.f2040a.getVerticalAlignment());
            PaddingValues paddingValuesM421PaddingValues0680j_4 = PaddingKt.m421PaddingValues0680j_4(Dp.m3887constructorimpl(this.f2040a.getPadding()));
            long jH = this.f2040a.getForegroundColor();
            long sp = TextUnitKt.getSp(this.f2040a.getControlSize());
            TextUnitKt.m4081checkArithmeticR2X_6o(sp);
            long jPack = TextUnitKt.pack(TextUnit.m4066getRawTypeimpl(sp), TextUnit.m4068getValueimpl(sp) / 2);
            long jM3990timesGh9hcWk = DpSize.m3990timesGh9hcWk(jM3909DpSizeYgX7TsA, 0.4f);
            Color colorB = this.f2040a.getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_BACKGROUND_COLOR java.lang.String();
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> function10A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(alignmentA, paddingValuesM421PaddingValues0680j_4, jH, jM3909DpSizeYgX7TsA, jPack, d.b(jM3990timesGh9hcWk, colorB != null ? colorB.m1655unboximpl() : d.b, composer, 0), null, this.b, composer, 0, 64);
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

    public static final class b implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0526a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f2041a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.z b;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.i c;

        public b(boolean z, com.moloco.sdk.internal.ortb.model.z zVar, com.moloco.sdk.internal.ortb.model.i iVar) {
            this.f2041a = z;
            this.b = zVar;
            this.c = iVar;
        }

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> function10A;
            composer.startReplaceableGroup(2061132145);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2061132145, i, -1, "com.moloco.sdk.internal.toCloseButton.<anonymous> (AggregatedOptions.kt:200)");
            }
            if (this.f2041a) {
                function10A = null;
            } else {
                float fM3887constructorimpl = Dp.m3887constructorimpl(this.b.getControlSize());
                long jM3909DpSizeYgX7TsA = DpKt.m3909DpSizeYgX7TsA(fM3887constructorimpl, fM3887constructorimpl);
                Alignment alignmentA = d.a(this.b.getHorizontalAlignment(), this.b.getVerticalAlignment());
                PaddingValues paddingValuesM421PaddingValues0680j_4 = PaddingKt.m421PaddingValues0680j_4(Dp.m3887constructorimpl(this.b.getPadding()));
                long jH = this.b.getForegroundColor();
                long sp = TextUnitKt.getSp(this.b.getControlSize());
                TextUnitKt.m4081checkArithmeticR2X_6o(sp);
                long jPack = TextUnitKt.pack(TextUnit.m4066getRawTypeimpl(sp), TextUnit.m4068getValueimpl(sp) / 2);
                Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.moloco_close, composer, 0);
                long jM3990timesGh9hcWk = DpSize.m3990timesGh9hcWk(jM3909DpSizeYgX7TsA, 0.45f);
                Color colorB = this.b.getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_BACKGROUND_COLOR java.lang.String();
                function10A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(alignmentA, paddingValuesM421PaddingValues0680j_4, jH, jM3909DpSizeYgX7TsA, jPack, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.q.a(painterPainterResource, jM3990timesGh9hcWk, null, colorB != null ? colorB.m1655unboximpl() : d.b, composer, 0, 4), null, this.c, composer, 0, 64);
            }
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

    public static final class c implements Function2<Composer, Integer, Function7<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, ? extends Unit>, ? super Function1<? super Boolean, ? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.v f2042a;

        public c(com.moloco.sdk.internal.ortb.model.v vVar) {
            this.f2042a = vVar;
        }

        public final Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            long jM3909DpSizeYgX7TsA;
            composer.startReplaceableGroup(1012987991);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1012987991, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:77)");
            }
            if (this.f2042a.getMute().getControlSize() != null) {
                float fM3887constructorimpl = Dp.m3887constructorimpl(r1.getData());
                jM3909DpSizeYgX7TsA = DpKt.m3909DpSizeYgX7TsA(fM3887constructorimpl, fM3887constructorimpl);
            } else {
                jM3909DpSizeYgX7TsA = d.e;
            }
            Alignment alignmentA = d.a(this.f2042a.getMute().getHorizontalAlignment(), this.f2042a.getMute().getVerticalAlignment());
            PaddingValues paddingValuesM421PaddingValues0680j_4 = PaddingKt.m421PaddingValues0680j_4(Dp.m3887constructorimpl(this.f2042a.getMute().getPadding()));
            long jM3990timesGh9hcWk = DpSize.m3990timesGh9hcWk(jM3909DpSizeYgX7TsA, 0.6f);
            long jF = this.f2042a.getMute().getForegroundColor();
            Color colorB = this.f2042a.getMute().getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_BACKGROUND_COLOR java.lang.String();
            Function7<BoxScope, Boolean, Boolean, Function2<? super a.AbstractC0526a.c, ? super a.AbstractC0526a.c.EnumC0528a, Unit>, Function1<? super Boolean, Unit>, Composer, Integer, Unit> function7A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a(jM3909DpSizeYgX7TsA, jM3990timesGh9hcWk, null, colorB != null ? colorB.m1655unboximpl() : d.b, alignmentA, paddingValuesM421PaddingValues0680j_4, jF, PainterResources_androidKt.painterResource(R.drawable.moloco_volume_off, composer, 0), PainterResources_androidKt.painterResource(R.drawable.moloco_volume_on, composer, 0), null, composer, 0, 516);
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

    /* JADX INFO: renamed from: com.moloco.sdk.internal.d$d, reason: collision with other inner class name */
    public static final class C0379d implements Function2<Composer, Integer, Function10<? super BoxScope, ? super Boolean, ? super Boolean, ? super Function0<? extends Unit>, ? super Function1<? super a.AbstractC0526a.c, ? extends Unit>, ? super Boolean, ? super UInt, ? super UInt, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.v f2043a;

        public C0379d(com.moloco.sdk.internal.ortb.model.v vVar) {
            this.f2043a = vVar;
        }

        public final Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> a(Composer composer, int i) {
            Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit> function10A;
            composer.startReplaceableGroup(-168563086);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-168563086, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:92)");
            }
            com.moloco.sdk.internal.ortb.model.z skip = this.f2043a.getSkip();
            if (skip == null) {
                function10A = null;
            } else {
                com.moloco.sdk.internal.ortb.model.v vVar = this.f2043a;
                float fM3887constructorimpl = Dp.m3887constructorimpl(skip.getControlSize());
                long jM3909DpSizeYgX7TsA = DpKt.m3909DpSizeYgX7TsA(fM3887constructorimpl, fM3887constructorimpl);
                Alignment alignmentA = d.a(skip.getHorizontalAlignment(), skip.getVerticalAlignment());
                PaddingValues paddingValuesM421PaddingValues0680j_4 = PaddingKt.m421PaddingValues0680j_4(Dp.m3887constructorimpl(skip.getPadding()));
                long jH = skip.getForegroundColor();
                long sp = TextUnitKt.getSp(skip.getControlSize());
                TextUnitKt.m4081checkArithmeticR2X_6o(sp);
                long jPack = TextUnitKt.pack(TextUnit.m4066getRawTypeimpl(sp), TextUnit.m4068getValueimpl(sp) / 2);
                long jM3990timesGh9hcWk = DpSize.m3990timesGh9hcWk(jM3909DpSizeYgX7TsA, 0.4f);
                Color colorB = skip.getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_BACKGROUND_COLOR java.lang.String();
                function10A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(alignmentA, paddingValuesM421PaddingValues0680j_4, jH, jM3909DpSizeYgX7TsA, jPack, d.b(jM3990timesGh9hcWk, colorB != null ? colorB.m1655unboximpl() : d.b, composer, 0), null, vVar.getCountDownTimer(), composer, 0, 64);
            }
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

    public static final class e implements Function2<Composer, Integer, Function7<? super BoxScope, ? super Boolean, ? super StateFlow<? extends i.a>, ? super Function1<? super a.AbstractC0526a.c, ? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f2044a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.v b;

        public e(boolean z, com.moloco.sdk.internal.ortb.model.v vVar) {
            this.f2044a = z;
            this.b = vVar;
        }

        public final Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0526a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0526a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> function7A;
            com.moloco.sdk.internal.ortb.model.g cta;
            composer.startReplaceableGroup(616016756);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(616016756, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:110)");
            }
            if (this.f2044a || (cta = this.b.getCta()) == null) {
                function7A = null;
            } else {
                Alignment alignmentA = d.a(cta.getHorizontalAlignment(), cta.getVerticalAlignment());
                PaddingValues paddingValuesM421PaddingValues0680j_4 = PaddingKt.m421PaddingValues0680j_4(Dp.m3887constructorimpl(cta.getPadding()));
                String strL = cta.getText();
                long jD = cta.getForegroundColor();
                Color colorB = cta.getCom.google.android.exoplayer2.text.ttml.TtmlNode.ATTR_TTS_BACKGROUND_COLOR java.lang.String();
                function7A = u.a(alignmentA, paddingValuesM421PaddingValues0680j_4, strL, jD, colorB != null ? colorB.m1655unboximpl() : u.a(), cta.getImageUrl(), composer, 0, 0);
            }
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

    public static final class f implements Function2<Composer, Integer, Function5<? super BoxScope, ? super Boolean, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f2045a;
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.v b;

        public f(boolean z, com.moloco.sdk.internal.ortb.model.v vVar) {
            this.f2045a = z;
            this.b = vVar;
        }

        public final Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> a(Composer composer, int i) {
            com.moloco.sdk.internal.ortb.model.w progressBar;
            composer.startReplaceableGroup(962638324);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(962638324, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:128)");
            }
            Function5<BoxScope, Boolean, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.i, Composer, Integer, Unit> function5A = (this.f2045a || (progressBar = this.b.getProgressBar()) == null) ? null : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a(d.a(progressBar.getHorizontalAlignment(), progressBar.getVerticalAlignment()), PaddingKt.m421PaddingValues0680j_4(Dp.m3887constructorimpl(progressBar.getPadding())), progressBar.getForegroundColor(), composer, 0, 0);
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

    public static final class g implements Function2<Composer, Integer, Function6<? super BoxScope, ? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, ? super Function0<? extends Unit>, ? super Function0<? extends Unit>, ? super Composer, ? super Integer, ? extends Unit>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.moloco.sdk.internal.ortb.model.v f2046a;

        public g(com.moloco.sdk.internal.ortb.model.v vVar) {
            this.f2046a = vVar;
        }

        public final Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> a(Composer composer, int i) {
            composer.startReplaceableGroup(524680050);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(524680050, i, -1, "com.moloco.sdk.internal.toVastOptions.<anonymous> (AggregatedOptions.kt:142)");
            }
            com.moloco.sdk.internal.ortb.model.A vastPrivacyIcon = this.f2046a.getVastPrivacyIcon();
            composer.startReplaceableGroup(-1135751215);
            Function6<BoxScope, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.j, Function0<Unit>, Function0<Unit>, Composer, Integer, Unit> function6A = vastPrivacyIcon == null ? null : com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.a(d.a(vastPrivacyIcon.getHorizontalAlignment(), vastPrivacyIcon.getVerticalAlignment()), PaddingKt.m421PaddingValues0680j_4(Dp.m3887constructorimpl(vastPrivacyIcon.getPadding())), composer, 0, 0);
            composer.endReplaceableGroup();
            if (function6A == null) {
                function6A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.h.a(null, null, composer, 0, 3);
            }
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

    static {
        float f2 = 30;
        e = DpKt.m3909DpSizeYgX7TsA(Dp.m3887constructorimpl(f2), Dp.m3887constructorimpl(f2));
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h b(com.moloco.sdk.internal.ortb.model.v vVar) {
        Intrinsics.checkNotNullParameter(vVar, "<this>");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f fVarA = a(vVar, false);
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h(b(vVar, false), fVarA, fVarA);
    }

    public static final com.moloco.sdk.internal.ortb.model.v c() {
        long j = c;
        int iM7514constructorimpl = UInt.m7514constructorimpl(30);
        com.moloco.sdk.internal.ortb.model.r rVar = com.moloco.sdk.internal.ortb.model.r.d;
        com.moloco.sdk.internal.ortb.model.B b2 = com.moloco.sdk.internal.ortb.model.B.b;
        DefaultConstructorMarker defaultConstructorMarker = null;
        Color color = null;
        com.moloco.sdk.internal.ortb.model.z zVar = new com.moloco.sdk.internal.ortb.model.z(5, 10, iM7514constructorimpl, rVar, b2, j, color, 64, defaultConstructorMarker);
        com.moloco.sdk.internal.ortb.model.w wVar = new com.moloco.sdk.internal.ortb.model.w(0, com.moloco.sdk.internal.ortb.model.r.c, com.moloco.sdk.internal.ortb.model.B.d, j, null);
        int i = 10;
        UInt uInt = null;
        byte b3 = 0 == true ? 1 : 0;
        boolean z = false;
        boolean z2 = false;
        String str = null;
        com.moloco.sdk.internal.ortb.model.g gVar = null;
        boolean z3 = true;
        com.moloco.sdk.internal.ortb.model.j jVar = null;
        byte b4 = 0 == true ? 1 : 0;
        return new com.moloco.sdk.internal.ortb.model.v(zVar, zVar, wVar, new com.moloco.sdk.internal.ortb.model.u((boolean) b3, i, com.moloco.sdk.internal.ortb.model.r.b, b2, j, uInt, color, 96, defaultConstructorMarker), gVar, z3, new C2988a(z, z2, str, 6, (DefaultConstructorMarker) null), (com.moloco.sdk.internal.ortb.model.A) (0 == true ? 1 : 0), jVar, (com.moloco.sdk.internal.ortb.model.i) b4, RendererCapabilities.MODE_SUPPORT_MASK, (DefaultConstructorMarker) null);
    }

    public static final com.moloco.sdk.internal.ortb.model.v f() {
        return (com.moloco.sdk.internal.ortb.model.v) f2039a.getValue();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h a(com.moloco.sdk.internal.ortb.model.v vVar) {
        Intrinsics.checkNotNullParameter(vVar, "<this>");
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f fVarA = a(vVar, true);
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h(b(vVar, true), fVarA, fVarA);
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h b() {
        return b(f());
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.h a() {
        return a(f());
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y b(com.moloco.sdk.internal.ortb.model.v vVar, boolean z) {
        com.moloco.sdk.internal.ortb.model.p pVarC;
        UInt uIntA;
        boolean zJ = vVar.getMute().getMute();
        Boolean bool = vVar.getSkip() == null ? null : Boolean.TRUE;
        com.moloco.sdk.internal.ortb.model.z skip = vVar.getSkip();
        int iF = skip != null ? skip.getDelaySeconds() : 0;
        C2988a autoStore = vVar.getAutoStore();
        boolean z2 = autoStore != null && autoStore.getEnabled() && vVar.getAutoStore().getOnSkip();
        C2988a autoStore2 = vVar.getAutoStore();
        boolean z3 = autoStore2 != null && autoStore2.getEnabled();
        int iF2 = vVar.getClose().getDelaySeconds();
        com.moloco.sdk.internal.ortb.model.j dec = vVar.getDec();
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.y(zJ, bool, iF, iF2, (dec == null || (pVarC = dec.getClose()) == null || (uIntA = pVarC.getDelaySeconds()) == null) ? 0 : uIntA.getData(), z2, z3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.n.a((AnalyticsListener.EVENT_DRM_KEYS_LOADED & 1) != 0 ? Color.INSTANCE.m1671getBlack0d7_KjU() : 0L, (AnalyticsListener.EVENT_DRM_KEYS_LOADED & 2) != 0 ? n.h.f2923a : new c(vVar), (AnalyticsListener.EVENT_DRM_KEYS_LOADED & 4) != 0 ? n.i.f2924a : a(vVar.getClose(), z, vVar.getCountDownTimer()), (AnalyticsListener.EVENT_DRM_KEYS_LOADED & 8) != 0 ? n.j.f2925a : new C0379d(vVar), (AnalyticsListener.EVENT_DRM_KEYS_LOADED & 16) != 0 ? n.k.f2926a : new e(z, vVar), (AnalyticsListener.EVENT_DRM_KEYS_LOADED & 32) != 0 ? null : p.a(vVar.getIsAllAreaClickable()), (AnalyticsListener.EVENT_DRM_KEYS_LOADED & 64) != 0 ? n.l.f2927a : new f(z, vVar), (AnalyticsListener.EVENT_DRM_KEYS_LOADED & 128) != 0 ? n.m.f2928a : new g(vVar), (AnalyticsListener.EVENT_DRM_KEYS_LOADED & 256) != 0 ? n.C0508n.f2929a : null, (AnalyticsListener.EVENT_DRM_KEYS_LOADED & 512) != 0 ? a.h.f2426a.j() : null));
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f a(com.moloco.sdk.internal.ortb.model.v vVar, boolean z) {
        com.moloco.sdk.internal.ortb.model.p pVarC;
        UInt uIntA;
        int iF = vVar.getClose().getDelaySeconds();
        Function9 function9A = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.webview.b.a(0L, a(z, vVar.getClose(), vVar.getDec(), vVar.getCountDownTimer()), 1, null);
        com.moloco.sdk.internal.ortb.model.j dec = vVar.getDec();
        return new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.f(iF, function9A, (dec == null || (pVarC = dec.getClose()) == null || (uIntA = pVarC.getDelaySeconds()) == null) ? 0 : uIntA.getData(), a(vVar.getClose(), z, null, 2, null));
    }

    public static final Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> a(boolean z, com.moloco.sdk.internal.ortb.model.z close, com.moloco.sdk.internal.ortb.model.j jVar, com.moloco.sdk.internal.ortb.model.i iVar) {
        Intrinsics.checkNotNullParameter(close, "close");
        if (jVar == null) {
            return a(close, z, iVar);
        }
        return new a(close, iVar);
    }

    public static final Function2<Composer, Integer, Function10<BoxScope, Boolean, Boolean, Function0<Unit>, Function1<? super a.AbstractC0526a.c, Unit>, Boolean, UInt, UInt, Composer, Integer, Unit>> a(com.moloco.sdk.internal.ortb.model.z zVar, boolean z, com.moloco.sdk.internal.ortb.model.i iVar) {
        return new b(z, zVar, iVar);
    }

    public static /* synthetic */ Function2 a(com.moloco.sdk.internal.ortb.model.z zVar, boolean z, com.moloco.sdk.internal.ortb.model.i iVar, int i, Object obj) {
        if ((i & 2) != 0) {
            iVar = null;
        }
        return a(zVar, z, iVar);
    }

    public static final Alignment a(com.moloco.sdk.internal.ortb.model.r horizontalAlignment, com.moloco.sdk.internal.ortb.model.B verticalAlignment) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        com.moloco.sdk.internal.ortb.model.B b2 = com.moloco.sdk.internal.ortb.model.B.b;
        if (verticalAlignment == b2 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.b || horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.e)) {
            return Alignment.INSTANCE.getTopStart();
        }
        if (verticalAlignment == b2 && horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.c) {
            return Alignment.INSTANCE.getTopCenter();
        }
        if (verticalAlignment == b2 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.d || horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.f)) {
            return Alignment.INSTANCE.getTopEnd();
        }
        com.moloco.sdk.internal.ortb.model.B b3 = com.moloco.sdk.internal.ortb.model.B.c;
        if (verticalAlignment == b3 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.b || horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.e)) {
            return Alignment.INSTANCE.getCenterStart();
        }
        if (verticalAlignment == b3 && horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.c) {
            return Alignment.INSTANCE.getCenter();
        }
        if (verticalAlignment == b3 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.d || horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.f)) {
            return Alignment.INSTANCE.getCenterEnd();
        }
        com.moloco.sdk.internal.ortb.model.B b4 = com.moloco.sdk.internal.ortb.model.B.d;
        return (verticalAlignment == b4 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.b || horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.e)) ? Alignment.INSTANCE.getBottomStart() : (verticalAlignment == b4 && horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.c) ? Alignment.INSTANCE.getBottomCenter() : (verticalAlignment == b4 && (horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.d || horizontalAlignment == com.moloco.sdk.internal.ortb.model.r.f)) ? Alignment.INSTANCE.getBottomEnd() : Alignment.INSTANCE.getTopStart();
    }

    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o b(long j, long j2, Composer composer, int i) {
        composer.startReplaceableGroup(-868162195);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-868162195, i, -1, "com.moloco.sdk.internal.defaultMolocoSkipAfterCountdownButtonPart (AggregatedOptions.kt:159)");
        }
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o oVarA = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.compose.g.a(PainterResources_androidKt.painterResource(R.drawable.moloco_skip, composer, 0), j, null, j2, composer, ((i << 3) & 112) | ((i << 6) & 7168), 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return oVarA;
    }
}
