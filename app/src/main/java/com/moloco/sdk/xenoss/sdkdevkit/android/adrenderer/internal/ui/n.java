package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import com.google.android.exoplayer2.C;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class n {

    public static final class a implements Function3<o, Composer, Integer, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f2699a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ long c;
        public final /* synthetic */ long d;
        public final /* synthetic */ long e;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.n$a$a, reason: collision with other inner class name */
        public static final class C0474a implements Function3<RowScope, Composer, Integer, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ o f2700a;
            public final /* synthetic */ long b;
            public final /* synthetic */ TextStyle c;

            public C0474a(o oVar, long j, TextStyle textStyle) {
                this.f2700a = oVar;
                this.b = j;
                this.c = textStyle;
            }

            public final void a(RowScope TextButton, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                if ((i & 17) == 16 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-291791758, i, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton.<anonymous>.<anonymous>.<anonymous> (CountdownButton.kt:84)");
                }
                TextKt.m1258TextfLXpl1I(((o.c) this.f2700a).a(), null, 0L, this.b, null, null, null, 0L, null, TextAlign.m3776boximpl(TextAlign.INSTANCE.m3783getCentere0LSkKk()), 0L, 0, false, 1, null, this.c, composer, 0, 3072, 24054);
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

        public a(Function0<Unit> function0, boolean z, long j, long j2, long j3) {
            this.f2699a = function0;
            this.b = z;
            this.c = j;
            this.d = j2;
            this.e = j3;
        }

        public final void a(o buttonPart, Composer composer, int i) {
            int i2;
            Intrinsics.checkNotNullParameter(buttonPart, "buttonPart");
            if ((i & 6) == 0) {
                i2 = i | (composer.changed(buttonPart) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1264027403, i2, -1, "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.CountdownButton.<anonymous>.<anonymous> (CountdownButton.kt:56)");
            }
            TextStyle h6 = MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getH6();
            if (buttonPart instanceof o.a) {
                composer.startReplaceableGroup(1000154410);
                composer.endReplaceableGroup();
            } else if (buttonPart instanceof o.b) {
                composer.startReplaceableGroup(1000496526);
                o.b bVar = (o.b) buttonPart;
                r.a(bVar.e(), this.f2699a, null, this.b, bVar.c(), this.c, this.d, bVar.d(), bVar.b(), bVar.a(), composer, 0, 4);
                composer.endReplaceableGroup();
            } else {
                if (!(buttonPart instanceof o.c)) {
                    composer.startReplaceableGroup(-1491758567);
                    composer.endReplaceableGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceableGroup(-1491726713);
                Function0<Unit> function0 = this.f2699a;
                boolean z = this.b;
                ButtonDefaults buttonDefaults = ButtonDefaults.INSTANCE;
                long j = this.c;
                ButtonKt.TextButton(function0, null, z, null, null, null, null, buttonDefaults.m950textButtonColorsRGew2ao(0L, j, j, composer, ButtonDefaults.$stable << 9, 1), null, ComposableLambdaKt.composableLambda(composer, -291791758, true, new C0474a(buttonPart, this.e, h6)), composer, C.ENCODING_PCM_32BIT, 378);
                composer.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(o oVar, Composer composer, Integer num) {
            a(oVar, composer, num.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(o oVar, Modifier modifier, Function0 function0, boolean z, long j, long j2, long j3, com.moloco.sdk.internal.ortb.model.i iVar, int i, int i2, Composer composer, int i3) {
        a(oVar, modifier, function0, z, j, j2, j3, iVar, composer, i | 1, i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0227 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o r23, androidx.compose.ui.Modifier r24, final kotlin.jvm.functions.Function0<kotlin.Unit> r25, final boolean r26, long r27, long r29, long r31, final com.moloco.sdk.internal.ortb.model.i r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.n.a(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.o, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, boolean, long, long, long, com.moloco.sdk.internal.ortb.model.i, androidx.compose.runtime.Composer, int, int):void");
    }
}
