package com.hive.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hive.ui.R;
import com.hive.ui.Resource;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ShadowLayout.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010\u0015\u001a\u00020\nH\u0014J\b\u0010\u0016\u001a\u00020\nH\u0014J(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0014J0\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\nH\u0014J\u000e\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020\u0018J\u001a\u0010&\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010'\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u001a\u0010(\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010)\u001a\u00020*2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H\u0002JH\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u00020\n2\u0006\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000e2\u0006\u00105\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/hive/ui/view/ShadowLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mShadowColor", "mShadowRadius", "", "mCornerRadius", "mDx", "mDy", "mInvalidateShadowOnSizeChanged", "", "mForceInvalidateShadow", "getSuggestedMinimumWidth", "getSuggestedMinimumHeight", "onSizeChanged", "", "w", "h", "oldw", "oldh", "onLayout", "changed", "left", ViewHierarchyConstants.DIMENSION_TOP_KEY, TtmlNode.RIGHT, "bottom", "setInvalidateShadowOnSizeChanged", "invalidateShadowOnSizeChanged", "invalidateShadow", "initView", "setBackgroundCompat", "initAttributes", "getTypedArray", "Landroid/content/res/TypedArray;", "attributeSet", "attr", "", "createShadowBitmap", "Landroid/graphics/Bitmap;", "shadowWidth", "shadowHeight", "cornerRadius", "shadowRadius", "dx", "dy", "shadowColor", "fillColor", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShadowLayout extends FrameLayout {
    private float mCornerRadius;
    private float mDx;
    private float mDy;
    private boolean mForceInvalidateShadow;
    private boolean mInvalidateShadowOnSizeChanged;
    private int mShadowColor;
    private float mShadowRadius;

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return 0;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mInvalidateShadowOnSizeChanged = true;
        initView(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mInvalidateShadowOnSizeChanged = true;
        initView(context, attrs);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShadowLayout(Context context, AttributeSet attrs, int i) {
        super(context, attrs, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.mInvalidateShadowOnSizeChanged = true;
        initView(context, attrs);
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w <= 0 || h <= 0) {
            return;
        }
        if (getBackground() == null || this.mInvalidateShadowOnSizeChanged || this.mForceInvalidateShadow) {
            this.mForceInvalidateShadow = false;
            setBackgroundCompat(w, h);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.mForceInvalidateShadow) {
            this.mForceInvalidateShadow = false;
            setBackgroundCompat(right - left, bottom - top);
        }
    }

    public final void setInvalidateShadowOnSizeChanged(boolean invalidateShadowOnSizeChanged) {
        this.mInvalidateShadowOnSizeChanged = invalidateShadowOnSizeChanged;
    }

    public final void invalidateShadow() {
        this.mForceInvalidateShadow = true;
        requestLayout();
        invalidate();
    }

    private final void initView(Context context, AttributeSet attrs) {
        initAttributes(context, attrs);
        int iAbs = (int) (this.mShadowRadius + Math.abs(this.mDx));
        int iAbs2 = (int) (this.mShadowRadius + Math.abs(this.mDy));
        setPadding(iAbs, iAbs2, iAbs, iAbs2);
    }

    private final void setBackgroundCompat(int w, int h) {
        setBackground(new BitmapDrawable(getResources(), createShadowBitmap(w, h, this.mCornerRadius, this.mShadowRadius, this.mDx, this.mDy, this.mShadowColor, 0)));
    }

    private final void initAttributes(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ShadowLayout);
        if (typedArrayObtainStyledAttributes == null) {
            return;
        }
        HashMap<String, Integer> resourceDeclareStyleableIntIndexArray = Resource.INSTANCE.getResourceDeclareStyleableIntIndexArray(context, "ShadowLayout");
        try {
            Integer num = resourceDeclareStyleableIntIndexArray.get("ShadowLayout_sl_cornerRadius");
            this.mCornerRadius = typedArrayObtainStyledAttributes.getDimension(num != null ? num.intValue() : 0, getResources().getDimension(context.getResources().getIdentifier("com_hive_sdk_default_corner_radius", "dimen", context.getPackageName())));
            Integer num2 = resourceDeclareStyleableIntIndexArray.get("ShadowLayout_sl_dx");
            this.mDx = typedArrayObtainStyledAttributes.getDimension(num2 != null ? num2.intValue() : 1, 0.0f);
            Integer num3 = resourceDeclareStyleableIntIndexArray.get("ShadowLayout_sl_dy");
            this.mDy = typedArrayObtainStyledAttributes.getDimension(num3 != null ? num3.intValue() : 2, 0.0f);
            Integer num4 = resourceDeclareStyleableIntIndexArray.get("ShadowLayout_sl_shadowColor");
            this.mShadowColor = typedArrayObtainStyledAttributes.getColor(num4 != null ? num4.intValue() : 3, getResources().getColor(context.getResources().getIdentifier("com_hive_sdk_default_shadow_color", "color", context.getPackageName())));
            Integer num5 = resourceDeclareStyleableIntIndexArray.get("ShadowLayout_sl_shadowRadius");
            this.mShadowRadius = typedArrayObtainStyledAttributes.getDimension(num5 != null ? num5.intValue() : 4, getResources().getDimension(context.getResources().getIdentifier("com_hive_sdk_default_shadow_radius", "dimen", context.getPackageName())));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private final TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, attr, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        return typedArrayObtainStyledAttributes;
    }

    private final Bitmap createShadowBitmap(int shadowWidth, int shadowHeight, float cornerRadius, float shadowRadius, float dx, float dy, int shadowColor, int fillColor) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(shadowWidth, shadowHeight, Bitmap.Config.ALPHA_8);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        RectF rectF = new RectF(shadowRadius, shadowRadius, shadowWidth - shadowRadius, shadowHeight - shadowRadius);
        if (dy > 0.0f) {
            rectF.top += dy;
            rectF.bottom -= dy;
        } else if (dy < 0.0f) {
            rectF.top += Math.abs(dy);
            rectF.bottom -= Math.abs(dy);
        }
        if (dx > 0.0f) {
            rectF.left += dx;
            rectF.right -= dx;
        } else if (dx < 0.0f) {
            rectF.left += Math.abs(dx);
            rectF.right -= Math.abs(dx);
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(fillColor);
        paint.setStyle(Paint.Style.FILL);
        if (!isInEditMode()) {
            paint.setShadowLayer(shadowRadius, dx, dy, shadowColor);
        }
        canvas.drawRoundRect(rectF, cornerRadius, cornerRadius, paint);
        return bitmapCreateBitmap;
    }
}
