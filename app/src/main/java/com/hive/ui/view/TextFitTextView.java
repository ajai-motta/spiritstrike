package com.hive.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextFitTextView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J(\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\nH\u0014J\b\u0010\f\u001a\u00020\rH\u0004R\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/hive/ui/view/TextFitTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fit", "", "getFit$hive_ui_release", "()Z", "setFit$hive_ui_release", "(Z)V", "expanded", "getExpanded$hive_ui_release", "setExpanded$hive_ui_release", "shrinkedSize", "", "getShrinkedSize$hive_ui_release", "()F", "setShrinkedSize$hive_ui_release", "(F)V", "setFitTextToBox", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "h", "oldw", "oldh", k.M, "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextFitTextView extends AppCompatTextView {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "TextFitTextView";
    private boolean expanded;
    private boolean fit;
    private float shrinkedSize;

    /* JADX INFO: compiled from: TextFitTextView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/hive/ui/view/TextFitTextView$Companion;", "", "<init>", "()V", "TAG", "", "getTAG$hive_ui_release", "()Ljava/lang/String;", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$hive_ui_release() {
            return TextFitTextView.TAG;
        }
    }

    /* JADX INFO: renamed from: getFit$hive_ui_release, reason: from getter */
    public final boolean getFit() {
        return this.fit;
    }

    public final void setFit$hive_ui_release(boolean z) {
        this.fit = z;
    }

    /* JADX INFO: renamed from: getExpanded$hive_ui_release, reason: from getter */
    public final boolean getExpanded() {
        return this.expanded;
    }

    public final void setExpanded$hive_ui_release(boolean z) {
        this.expanded = z;
    }

    /* JADX INFO: renamed from: getShrinkedSize$hive_ui_release, reason: from getter */
    public final float getShrinkedSize() {
        return this.shrinkedSize;
    }

    public final void setShrinkedSize$hive_ui_release(float f) {
        this.shrinkedSize = f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFitTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFitTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextFitTextView(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    public final void setFitTextToBox(boolean fit) {
        this.fit = fit;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.fit && fit()) {
            draw(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.expanded = false;
        this.shrinkedSize = 0.0f;
    }

    protected final boolean fit() {
        int height = getHeight();
        int lineCount = getLineCount();
        Rect rect = new Rect();
        getLineBounds(0, rect);
        int lineBounds = getLineBounds(lineCount - 1, rect);
        float textSize = getTextSize();
        if (!this.expanded && lineBounds < height) {
            setTextSize(0, textSize + 10.0f);
            return true;
        }
        this.expanded = true;
        if (lineBounds > height && textSize >= 8.0f) {
            setTextSize(0, textSize - 10.0f);
            return true;
        }
        if (this.shrinkedSize != textSize) {
            float f = textSize * 0.85f;
            this.shrinkedSize = f;
            setTextSize(0, f);
        }
        return false;
    }
}
