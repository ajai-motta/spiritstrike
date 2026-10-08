package com.moloco.sdk.internal;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.moloco.sdk.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: loaded from: classes6.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f2403a = ColorKt.Color(4278354171L);

    public static final class a implements Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0526a.c, ? extends Unit>, Function0<? extends Unit>, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Alignment f2404a;
        public final /* synthetic */ PaddingValues b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;
        public final /* synthetic */ long f;

        /* JADX INFO: renamed from: com.moloco.sdk.internal.u$a$a, reason: collision with other inner class name */
        public static final class C0411a implements Function3<AnimatedVisibilityScope, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Function1<a.AbstractC0526a.c, Unit> f2405a;
            public final /* synthetic */ State<i.a> b;
            public final /* synthetic */ String c;
            public final /* synthetic */ String d;
            public final /* synthetic */ long e;
            public final /* synthetic */ long f;
            public final /* synthetic */ Function0<Unit> g;

            /* JADX INFO: renamed from: com.moloco.sdk.internal.u$a$a$a, reason: collision with other inner class name */
            public static final class C0412a implements Function3<Modifier, Composer, Integer, Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f2406a;
                public final /* synthetic */ String b;
                public final /* synthetic */ long c;
                public final /* synthetic */ long d;
                public final /* synthetic */ Function0<Unit> e;

                public C0412a(String str, String str2, long j, long j2, Function0<Unit> function0) {
                    this.f2406a = str;
                    this.b = str2;
                    this.c = j;
                    this.d = j2;
                    this.e = function0;
                }

                public final void a(Modifier it, Composer composer, int i) {
                    int i2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i & 6) == 0) {
                        i2 = i | (composer.changed(it) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 19) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1938502477, i2, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous>.<anonymous> (MolocoVastCTA.kt:72)");
                    }
                    u.a(it, this.f2406a, this.b, this.c, this.d, this.e, composer, i2 & 14, 0);
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

            /* JADX INFO: renamed from: com.moloco.sdk.internal.u$a$a$b */
            public static final class b implements Function3<Modifier, Composer, Integer, Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ String f2407a;
                public final /* synthetic */ String b;
                public final /* synthetic */ long c;
                public final /* synthetic */ long d;
                public final /* synthetic */ Function0<Unit> e;

                public b(String str, String str2, long j, long j2, Function0<Unit> function0) {
                    this.f2407a = str;
                    this.b = str2;
                    this.c = j;
                    this.d = j2;
                    this.e = function0;
                }

                public final void a(Modifier it, Composer composer, int i) {
                    int i2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    if ((i & 6) == 0) {
                        i2 = i | (composer.changed(it) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 19) == 18 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-868048676, i2, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous>.<anonymous> (MolocoVastCTA.kt:87)");
                    }
                    u.a(it, this.f2407a, this.b, this.c, this.d, this.e, composer, i2 & 14, 0);
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
            public C0411a(Function1<? super a.AbstractC0526a.c, Unit> function1, State<? extends i.a> state, String str, String str2, long j, long j2, Function0<Unit> function0) {
                this.f2405a = function1;
                this.b = state;
                this.c = str;
                this.d = str2;
                this.e = j;
                this.f = j2;
                this.g = function0;
            }

            public final void a(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-657845797, i, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous>.<anonymous> (MolocoVastCTA.kt:66)");
                }
                i.a aVarB = a.b(this.b);
                if (aVarB instanceof i.a.C0495a) {
                    composer.startReplaceableGroup(-388830153);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.w.a(null, a.AbstractC0526a.c.EnumC0528a.g, this.f2405a, ComposableLambdaKt.composableLambda(composer, -1938502477, true, new C0412a(this.c, this.d, this.e, this.f, this.g)), composer, 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarB instanceof i.a.c) {
                    composer.startReplaceableGroup(-388268681);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.w.a(null, a.AbstractC0526a.c.EnumC0528a.g, this.f2405a, ComposableLambdaKt.composableLambda(composer, -868048676, true, new b(this.c, this.d, this.e, this.f, this.g)), composer, 3120, 1);
                    composer.endReplaceableGroup();
                } else if (aVarB instanceof i.a.b) {
                    composer.startReplaceableGroup(-387725902);
                    composer.endReplaceableGroup();
                } else if (aVarB instanceof i.a.d) {
                    composer.startReplaceableGroup(-387668366);
                    composer.endReplaceableGroup();
                } else {
                    if (aVarB != null) {
                        composer.startReplaceableGroup(-843828347);
                        composer.endReplaceableGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer.startReplaceableGroup(-387633677);
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
        }

        public a(Alignment alignment, PaddingValues paddingValues, String str, String str2, long j, long j2) {
            this.f2404a = alignment;
            this.b = paddingValues;
            this.c = str;
            this.d = str2;
            this.e = j;
            this.f = j2;
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
                ComposerKt.traceEventStart(-927135997, i, -1, "com.moloco.sdk.internal.molocoCTAButton.<anonymous> (MolocoVastCTA.kt:48)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z, PaddingKt.padding(WindowInsetsPadding_androidKt.displayCutoutPadding(boxScope.align(Modifier.INSTANCE, this.f2404a)), this.b), (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.composableLambda(composer, -657845797, true, new C0411a(onButtonRendered, SnapshotStateKt.collectAsState(currentAdPartFlow, null, composer, (i >> 6) & 14, 1), this.c, this.d, this.e, this.f, onCTA)), composer, ((i >> 3) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    }

    public static final Unit a(Modifier modifier, String str, String str2, long j, long j2, Function0 function0, int i, int i2, Composer composer, int i3) {
        a(modifier, str, str2, j, j2, (Function0<Unit>) function0, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    public static final Function7<BoxScope, Boolean, StateFlow<? extends i.a>, Function1<? super a.AbstractC0526a.c, Unit>, Function0<Unit>, Composer, Integer, Unit> a(Alignment alignment, PaddingValues paddingValues, String str, long j, long j2, String str2, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(959702933);
        Alignment bottomEnd = (i2 & 1) != 0 ? Alignment.INSTANCE.getBottomEnd() : alignment;
        PaddingValues paddingValuesM421PaddingValues0680j_4 = (i2 & 2) != 0 ? PaddingKt.m421PaddingValues0680j_4(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.utils.a.a()) : paddingValues;
        String strStringResource = (i2 & 4) != 0 ? StringResources_androidKt.stringResource(R.string.com_moloco_sdk_xenoss_player_learn_more, composer, 0) : str;
        long jM1682getWhite0d7_KjU = (i2 & 8) != 0 ? Color.INSTANCE.m1682getWhite0d7_KjU() : j;
        long j3 = (i2 & 16) != 0 ? f2403a : j2;
        String str3 = (i2 & 32) != 0 ? null : str2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(959702933, i, -1, "com.moloco.sdk.internal.molocoCTAButton (MolocoVastCTA.kt:47)");
        }
        ComposableLambda composableLambda = ComposableLambdaKt.composableLambda(composer, -927135997, true, new a(bottomEnd, paddingValuesM421PaddingValues0680j_4, str3, strStringResource, jM1682getWhite0d7_KjU, j3));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return composableLambda;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0286  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(androidx.compose.ui.Modifier r34, java.lang.String r35, final java.lang.String r36, final long r37, final long r39, final kotlin.jvm.functions.Function0<kotlin.Unit> r41, androidx.compose.runtime.Composer r42, final int r43, final int r44) {
        /*
            Method dump skipped, instruction units count: 669
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.u.a(androidx.compose.ui.Modifier, java.lang.String, java.lang.String, long, long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final long a() {
        return f2403a;
    }
}
