package com.hive.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.hive.core.Logger;
import com.hive.ui.R;
import io.ktor.sse.ServerSentEventKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HiveTextView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\u001a\u0010\u0018\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\b\b\u0001\u0010\u001a\u001a\u00020\nR\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lcom/hive/ui/view/HiveTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lastMeasuredWidth", "syncLineHeight", "forceLineBreak", "", "getForceLineBreak", "()Z", "setForceLineBreak", "(Z)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onCreateView", "setSyncLineHeight", "lineHeight", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveTextView extends AppCompatTextView {
    private boolean forceLineBreak;
    private int lastMeasuredWidth;
    private int syncLineHeight;

    public final boolean getForceLineBreak() {
        return this.forceLineBreak;
    }

    public final void setForceLineBreak(boolean z) {
        this.forceLineBreak = z;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        onCreateView(null, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        onCreateView(attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HiveTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        onCreateView(attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.forceLineBreak) {
            forceLineBreak();
        }
    }

    private final void onCreateView(AttributeSet attrs, int defStyleAttr) {
        try {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.HiveTextView, defStyleAttr, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.forceLineBreak = typedArrayObtainStyledAttributes.getBoolean(R.styleable.HiveTextView_forceLineBreak, false);
            this.syncLineHeight = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.HiveTextView_syncLineHeight, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception e) {
            Logger.INSTANCE.w("[HiveTextView] onCreateView() \ne: " + e.getMessage());
        }
        int i = this.syncLineHeight;
        if (i != 0) {
            setSyncLineHeight(i);
        }
    }

    private final void forceLineBreak() {
        int measuredWidth = getMeasuredWidth();
        if (this.lastMeasuredWidth != measuredWidth) {
            this.lastMeasuredWidth = measuredWidth;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            CharSequence text = getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            loop0: while (true) {
                int i = 0;
                for (String str : StringsKt.split$default(text, new String[]{ServerSentEventKt.SPACE}, false, 0, 6, (Object) null)) {
                    if (sb2.length() == 0 && i == 0) {
                        sb2.append(str);
                        int iMeasureText = (int) getPaint().measureText(sb2.toString());
                        if (iMeasureText > measuredWidth) {
                            sb.append(sb2.toString());
                            StringsKt.clear(sb2);
                            i = iMeasureText % measuredWidth;
                        }
                    } else {
                        float fMeasureText = getPaint().measureText(sb2.toString());
                        TextPaint paint = getPaint();
                        if ((measuredWidth - i) - fMeasureText > ((int) paint.measureText(ServerSentEventKt.SPACE + str))) {
                            sb2.append(ServerSentEventKt.SPACE);
                            sb2.append(str);
                        } else {
                            sb2.append("\n");
                            sb.append(sb2.toString());
                            StringsKt.clear(sb2);
                            int iMeasureText2 = (int) getPaint().measureText(str);
                            if (measuredWidth < iMeasureText2) {
                                sb.append(str);
                                i = iMeasureText2 % measuredWidth;
                            }
                        }
                    }
                }
                sb2.append(str);
            }
            if (sb2.length() > 0) {
                sb.append(sb2.toString());
                StringsKt.clear(sb2);
            }
            setText(sb.toString());
        }
    }

    public final void setSyncLineHeight(int lineHeight) {
        int fontMetricsInt;
        if (lineHeight >= 0 && lineHeight != (fontMetricsInt = getPaint().getFontMetricsInt(null))) {
            setLineSpacing(lineHeight - fontMetricsInt, 1.0f);
        }
    }
}
