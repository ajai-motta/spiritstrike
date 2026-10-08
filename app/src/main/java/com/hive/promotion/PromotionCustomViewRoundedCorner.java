package com.hive.promotion;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PromotionCustomViewRoundedCorner.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/hive/promotion/PromotionCustomViewRoundedCorner;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CORNER_RADIUS", "", "cornerRadius", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "init", "", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PromotionCustomViewRoundedCorner extends FrameLayout {
    private final float CORNER_RADIUS;
    private float cornerRadius;

    protected final float getCornerRadius() {
        return this.cornerRadius;
    }

    protected final void setCornerRadius(float f) {
        this.cornerRadius = f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionCustomViewRoundedCorner(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.CORNER_RADIUS = 15.0f;
        init(context, null, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionCustomViewRoundedCorner(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.CORNER_RADIUS = 15.0f;
        init(context, attrs, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromotionCustomViewRoundedCorner(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.CORNER_RADIUS = 15.0f;
        init(context, attrs, i);
    }

    private final void init(Context context, AttributeSet attrs, int defStyle) {
        this.cornerRadius = TypedValue.applyDimension(1, this.CORNER_RADIUS, context.getResources().getDisplayMetrics());
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PromotionViewRoundedCorner, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            try {
                this.cornerRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.PromotionViewRoundedCorner_round, this.cornerRadius);
            } catch (Exception e) {
                e.printStackTrace();
            }
            typedArrayObtainStyledAttributes.recycle();
            setLayerType(2, null);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.cornerRadius);
            setBackground(gradientDrawable);
            setClipToOutline(true);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }
}
