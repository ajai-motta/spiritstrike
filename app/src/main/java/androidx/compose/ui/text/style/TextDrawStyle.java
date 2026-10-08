package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextDrawStyle.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fJ\u0010\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0016J\u0016\u0010\f\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\rH\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0006\u001a\u00020\u0007X¦\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\tø\u0001\u0003\u0082\u0002\u0015\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/style/TextDrawStyle;", "", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "merge", "other", "takeOrElse", "Lkotlin/Function0;", k.M, "Unspecified", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TextDrawStyle {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Brush getBrush();

    /* JADX INFO: renamed from: getColor-0d7_KjU */
    long mo3746getColor0d7_KjU();

    TextDrawStyle merge(TextDrawStyle other);

    TextDrawStyle takeOrElse(Function0<? extends TextDrawStyle> other);

    /* JADX INFO: renamed from: androidx.compose.ui.text.style.TextDrawStyle$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: TextDrawStyle.kt */
    public final /* synthetic */ class CC {
        public static TextDrawStyle $default$merge(final TextDrawStyle _this, TextDrawStyle other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return other.getBrush() != null ? other : _this.getBrush() != null ? _this : other.takeOrElse(new Function0<TextDrawStyle>() { // from class: androidx.compose.ui.text.style.TextDrawStyle.merge.1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final TextDrawStyle invoke() {
                    return TextDrawStyle.this;
                }
            });
        }

        public static TextDrawStyle $default$takeOrElse(TextDrawStyle _this, Function0 other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return !Intrinsics.areEqual(_this, Unspecified.INSTANCE) ? _this : (TextDrawStyle) other.invoke();
        }
    }

    /* JADX INFO: compiled from: TextDrawStyle.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u0007\u001a\u00020\b8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/TextDrawStyle$Unspecified;", "Landroidx/compose/ui/text/style/TextDrawStyle;", "()V", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Unspecified implements TextDrawStyle {
        public static final Unspecified INSTANCE = new Unspecified();

        @Override // androidx.compose.ui.text.style.TextDrawStyle
        public Brush getBrush() {
            return null;
        }

        @Override // androidx.compose.ui.text.style.TextDrawStyle
        public /* synthetic */ TextDrawStyle merge(TextDrawStyle textDrawStyle) {
            return CC.$default$merge(this, textDrawStyle);
        }

        @Override // androidx.compose.ui.text.style.TextDrawStyle
        public /* synthetic */ TextDrawStyle takeOrElse(Function0 function0) {
            return CC.$default$takeOrElse(this, function0);
        }

        private Unspecified() {
        }

        @Override // androidx.compose.ui.text.style.TextDrawStyle
        /* JADX INFO: renamed from: getColor-0d7_KjU */
        public long mo3746getColor0d7_KjU() {
            return Color.INSTANCE.m1681getUnspecified0d7_KjU();
        }
    }

    /* JADX INFO: compiled from: TextDrawStyle.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u001b\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/style/TextDrawStyle$Companion;", "", "()V", "from", "Landroidx/compose/ui/text/style/TextDrawStyle;", "brush", "Landroidx/compose/ui/graphics/Brush;", "color", "Landroidx/compose/ui/graphics/Color;", "from-8_81llA", "(J)Landroidx/compose/ui/text/style/TextDrawStyle;", "ui-text_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final TextDrawStyle from(Brush brush) {
            if (brush == null) {
                return Unspecified.INSTANCE;
            }
            if (brush instanceof SolidColor) {
                return m3801from8_81llA(((SolidColor) brush).getValue());
            }
            if (brush instanceof ShaderBrush) {
                return new BrushStyle((ShaderBrush) brush);
            }
            throw new NoWhenBranchMatchedException();
        }

        /* JADX INFO: renamed from: from-8_81llA, reason: not valid java name */
        public final TextDrawStyle m3801from8_81llA(long color) {
            return color != Color.INSTANCE.m1681getUnspecified0d7_KjU() ? new ColorStyle(color, null) : Unspecified.INSTANCE;
        }
    }
}
