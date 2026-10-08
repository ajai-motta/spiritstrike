package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0007¢\u0006\u0002\u0010\tJñ\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$Jñ\u0001\u0010%\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010&\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\r2\b\b\u0002\u0010)\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u0017\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\r2\b\b\u0002\u0010\u001a\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\r2\b\b\u0002\u0010\u001c\u001a\u00020\r2\b\b\u0002\u0010\u001d\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\r2\b\b\u0002\u0010\"\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010$\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006+"}, d2 = {"Landroidx/compose/material/ExposedDropdownMenuDefaults;", "", "()V", "TrailingIcon", "", "expanded", "", "onIconClick", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "outlinedTextFieldColors", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "cursorColor", "errorCursorColor", "focusedBorderColor", "unfocusedBorderColor", "disabledBorderColor", "errorBorderColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "outlinedTextFieldColors-DlUQjxs", "(JJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;IIII)Landroidx/compose/material/TextFieldColors;", "textFieldColors", "focusedIndicatorColor", "unfocusedIndicatorColor", "disabledIndicatorColor", "errorIndicatorColor", "textFieldColors-DlUQjxs", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalMaterialApi
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();

    private ExposedDropdownMenuDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @androidx.compose.material.ExperimentalMaterialApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void TrailingIcon(final boolean r13, kotlin.jvm.functions.Function0<kotlin.Unit> r14, androidx.compose.runtime.Composer r15, final int r16, final int r17) {
        /*
            r12 = this;
            r2 = r13
            r0 = 876077373(0x3437e13d, float:1.7125144E-7)
            r1 = r15
            androidx.compose.runtime.Composer r0 = r15.startRestartGroup(r0)
            java.lang.String r1 = "C(TrailingIcon)294@11256L394:ExposedDropdownMenu.kt#jmzs0o"
            androidx.compose.runtime.ComposerKt.sourceInformation(r0, r1)
            r1 = r17 & 1
            if (r1 == 0) goto L15
            r1 = r16 | 6
            goto L27
        L15:
            r1 = r16 & 14
            if (r1 != 0) goto L25
            boolean r1 = r0.changed(r13)
            if (r1 == 0) goto L21
            r1 = 4
            goto L22
        L21:
            r1 = 2
        L22:
            r1 = r16 | r1
            goto L27
        L25:
            r1 = r16
        L27:
            r3 = r17 & 2
            if (r3 == 0) goto L2e
            r1 = r1 | 48
            goto L40
        L2e:
            r4 = r16 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L40
            r4 = r14
            boolean r5 = r0.changed(r14)
            if (r5 == 0) goto L3c
            r5 = 32
            goto L3e
        L3c:
            r5 = 16
        L3e:
            r1 = r1 | r5
            goto L41
        L40:
            r4 = r14
        L41:
            r5 = r1 & 91
            r6 = 18
            if (r5 != r6) goto L53
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L4e
            goto L53
        L4e:
            r0.skipToGroupEnd()
            r3 = r4
            goto L87
        L53:
            if (r3 == 0) goto L5b
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1 r3 = new kotlin.jvm.functions.Function0<kotlin.Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.1
                static {
                    /*
                        androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1 r0 = new androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1) androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.1.INSTANCE androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.AnonymousClass1.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 0
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.AnonymousClass1.<init>():void");
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    /*
                        r0 = this;
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.AnonymousClass1.invoke2():void");
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
                    /*
                        r1 = this;
                        r1.invoke2()
                        kotlin.Unit r0 = kotlin.Unit.INSTANCE
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.AnonymousClass1.invoke():java.lang.Object");
                }
            }
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            r11 = r3
            goto L5c
        L5b:
            r11 = r4
        L5c:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.INSTANCE
            androidx.compose.ui.Modifier r3 = (androidx.compose.ui.Modifier) r3
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2 r4 = new kotlin.jvm.functions.Function1<androidx.compose.ui.semantics.SemanticsPropertyReceiver, kotlin.Unit>() { // from class: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.2
                static {
                    /*
                        androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2 r0 = new androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2
                        r0.<init>()
                        
                        // error: 0x0005: SPUT (r0 I:androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2) androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon.2.INSTANCE androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.AnonymousClass2.<clinit>():void");
                }

                {
                    /*
                        r1 = this;
                        r0 = 1
                        r1.<init>(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.AnonymousClass2.<init>():void");
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(androidx.compose.ui.semantics.SemanticsPropertyReceiver r2) {
                    /*
                        r1 = this;
                        java.lang.String r0 = "$this$clearAndSetSemantics"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.AnonymousClass2.invoke2(androidx.compose.ui.semantics.SemanticsPropertyReceiver):void");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ kotlin.Unit invoke(androidx.compose.ui.semantics.SemanticsPropertyReceiver r1) {
                    /*
                        r0 = this;
                        androidx.compose.ui.semantics.SemanticsPropertyReceiver r1 = (androidx.compose.ui.semantics.SemanticsPropertyReceiver) r1
                        r0.invoke2(r1)
                        kotlin.Unit r1 = kotlin.Unit.INSTANCE
                        return r1
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.AnonymousClass2.invoke(java.lang.Object):java.lang.Object");
                }
            }
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.semantics.SemanticsModifierKt.clearAndSetSemantics(r3, r4)
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3 r3 = new androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3
            r3.<init>()
            r5 = 726122713(0x2b47c0d9, float:7.096663E-13)
            r6 = 1
            androidx.compose.runtime.internal.ComposableLambda r3 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r5, r6, r3)
            r7 = r3
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            int r1 = r1 >> 3
            r1 = r1 & 14
            r9 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = 12
            r5 = 0
            r6 = 0
            r3 = r11
            r8 = r0
            androidx.compose.material.IconButtonKt.IconButton(r3, r4, r5, r6, r7, r8, r9, r10)
        L87:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L8e
            goto L9f
        L8e:
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4 r7 = new androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4
            r0 = r7
            r1 = r12
            r2 = r13
            r4 = r16
            r5 = r17
            r0.<init>()
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r6.updateScope(r7)
        L9f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon(boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: renamed from: textFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1062textFieldColorsDlUQjxs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, Composer composer, int i, int i2, int i3, int i4) {
        long jM1644copywmQWz5c$default;
        composer.startReplaceableGroup(1208167904);
        ComposerKt.sourceInformation(composer, "C(textFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,8:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)353@14329L7,353@14360L7,354@14433L8,356@14503L6,357@14614L6,358@14678L6,360@14757L6,360@14798L4,362@14872L6,365@15072L8,366@15134L6,368@15208L6,369@15355L8,372@15484L6,374@15614L6,374@15655L4,375@15749L8,376@15814L6,378@15889L6,378@15930L4,379@15988L6,379@16023L6,380@16106L8,381@16164L6,382@16226L6,382@16261L6,383@16347L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM1655unboximpl = ((Color) objConsume).m1655unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM1644copywmQWz5c$default = Color.m1644copywmQWz5c$default(jM1655unboximpl, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM1644copywmQWz5c$default = j;
        }
        long jM1644copywmQWz5c$default2 = (i4 & 2) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM1644copywmQWz5c$default3 = (i4 & 4) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m990getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j3;
        long jM991getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m991getPrimary0d7_KjU() : j4;
        long jM985getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m985getError0d7_KjU() : j5;
        long jM1644copywmQWz5c$default4 = (i4 & 32) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m991getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM1644copywmQWz5c$default5 = (i4 & 64) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m990getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM1644copywmQWz5c$default6 = (i4 & 128) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default5, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long jM985getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m985getError0d7_KjU() : j9;
        long jM1644copywmQWz5c$default7 = (i4 & 512) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m990getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long jM1644copywmQWz5c$default8 = (i4 & 1024) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default7, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long j23 = (i4 & 2048) != 0 ? jM1644copywmQWz5c$default7 : j12;
        long jM1644copywmQWz5c$default9 = (i4 & 4096) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m990getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long jM1644copywmQWz5c$default10 = (i4 & 8192) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m991getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j14;
        long jM1644copywmQWz5c$default11 = (i4 & 16384) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default9, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        long jM985getError0d7_KjU3 = (32768 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m985getError0d7_KjU() : j16;
        long jM1644copywmQWz5c$default12 = (65536 & i4) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m991getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM1644copywmQWz5c$default13 = (131072 & i4) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m990getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j18;
        long jM1644copywmQWz5c$default14 = (262144 & i4) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default13, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j19;
        long jM985getError0d7_KjU4 = (524288 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m985getError0d7_KjU() : j20;
        long jM1644copywmQWz5c$default15 = (1048576 & i4) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m990getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(jM1644copywmQWz5c$default, jM1644copywmQWz5c$default2, jM991getPrimary0d7_KjU, jM985getError0d7_KjU, jM1644copywmQWz5c$default4, jM1644copywmQWz5c$default5, jM985getError0d7_KjU2, jM1644copywmQWz5c$default6, jM1644copywmQWz5c$default7, jM1644copywmQWz5c$default8, j23, jM1644copywmQWz5c$default9, jM1644copywmQWz5c$default10, jM1644copywmQWz5c$default11, jM985getError0d7_KjU3, jM1644copywmQWz5c$default3, jM1644copywmQWz5c$default12, jM1644copywmQWz5c$default13, jM1644copywmQWz5c$default14, jM985getError0d7_KjU4, jM1644copywmQWz5c$default15, (i4 & 2097152) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j22, null);
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }

    /* JADX INFO: renamed from: outlinedTextFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1061outlinedTextFieldColorsDlUQjxs(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, Composer composer, int i, int i2, int i3, int i4) {
        long jM1644copywmQWz5c$default;
        composer.startReplaceableGroup(1162641182);
        ComposerKt.sourceInformation(composer, "C(outlinedTextFieldColors)P(18:c#ui.graphics.Color,6:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color,9:c#ui.graphics.Color,13:c#ui.graphics.Color,20:c#ui.graphics.Color,2:c#ui.graphics.Color,8:c#ui.graphics.Color,16:c#ui.graphics.Color,4:c#ui.graphics.Color,11:c#ui.graphics.Color,19:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,12:c#ui.graphics.Color,14:c#ui.graphics.Color,21:c#ui.graphics.Color,3:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,5:c#ui.graphics.Color)456@20314L7,456@20345L7,457@20418L8,459@20524L6,460@20588L6,462@20664L6,462@20705L4,464@20776L6,464@20819L8,465@20914L8,466@20973L6,468@21047L6,469@21194L8,472@21323L6,474@21453L6,474@21494L4,475@21588L8,476@21653L6,478@21728L6,478@21769L4,479@21827L6,479@21862L6,480@21945L8,481@22003L6,482@22065L6,482@22100L6,483@22186L8:ExposedDropdownMenu.kt#jmzs0o");
        if ((i4 & 1) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            long jM1655unboximpl = ((Color) objConsume).m1655unboximpl();
            ProvidableCompositionLocal<Float> localContentAlpha = ContentAlphaKt.getLocalContentAlpha();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composer.consume(localContentAlpha);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM1644copywmQWz5c$default = Color.m1644copywmQWz5c$default(jM1655unboximpl, ((Number) objConsume2).floatValue(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jM1644copywmQWz5c$default = j;
        }
        long jM1644copywmQWz5c$default2 = (i4 & 2) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM1680getTransparent0d7_KjU = (i4 & 4) != 0 ? Color.INSTANCE.m1680getTransparent0d7_KjU() : j3;
        long jM991getPrimary0d7_KjU = (i4 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m991getPrimary0d7_KjU() : j4;
        long jM985getError0d7_KjU = (i4 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m985getError0d7_KjU() : j5;
        long jM1644copywmQWz5c$default3 = (i4 & 32) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m991getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j6;
        long jM1644copywmQWz5c$default4 = (i4 & 64) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m990getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jM1644copywmQWz5c$default5 = (i4 & 128) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default4, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j8;
        long jM985getError0d7_KjU2 = (i4 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m985getError0d7_KjU() : j9;
        long jM1644copywmQWz5c$default6 = (i4 & 512) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m990getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long jM1644copywmQWz5c$default7 = (i4 & 1024) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default6, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long j23 = (i4 & 2048) != 0 ? jM1644copywmQWz5c$default6 : j12;
        long jM1644copywmQWz5c$default8 = (i4 & 4096) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m990getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j13;
        long jM1644copywmQWz5c$default9 = (i4 & 8192) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m991getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j14;
        long jM1644copywmQWz5c$default10 = (i4 & 16384) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default8, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        long jM985getError0d7_KjU3 = (32768 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m985getError0d7_KjU() : j16;
        long jM1644copywmQWz5c$default11 = (65536 & i4) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m991getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM1644copywmQWz5c$default12 = (131072 & i4) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m990getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j18;
        long jM1644copywmQWz5c$default13 = (262144 & i4) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default12, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j19;
        long jM985getError0d7_KjU4 = (524288 & i4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m985getError0d7_KjU() : j20;
        long jM1644copywmQWz5c$default14 = (1048576 & i4) != 0 ? Color.m1644copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m990getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j21;
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(jM1644copywmQWz5c$default, jM1644copywmQWz5c$default2, jM991getPrimary0d7_KjU, jM985getError0d7_KjU, jM1644copywmQWz5c$default3, jM1644copywmQWz5c$default4, jM985getError0d7_KjU2, jM1644copywmQWz5c$default5, jM1644copywmQWz5c$default6, jM1644copywmQWz5c$default7, j23, jM1644copywmQWz5c$default8, jM1644copywmQWz5c$default9, jM1644copywmQWz5c$default10, jM985getError0d7_KjU3, jM1680getTransparent0d7_KjU, jM1644copywmQWz5c$default11, jM1644copywmQWz5c$default12, jM1644copywmQWz5c$default13, jM985getError0d7_KjU4, jM1644copywmQWz5c$default14, (i4 & 2097152) != 0 ? Color.m1644copywmQWz5c$default(jM1644copywmQWz5c$default14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j22, null);
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }
}
