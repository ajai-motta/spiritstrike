package com.hive.promotion.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.hive.core.Logger;
import com.hive.promotion.R;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RoundedCornerView.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\"\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0004J\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\rJ\u001e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\rJ\u0018\u0010!\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\rH\u0002R\u001a\u0010\f\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0005¨\u0006#"}, d2 = {"Lcom/hive/promotion/ui/RoundedCornerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "CORNER_RADIUS", "", "getCORNER_RADIUS", "()F", "setCORNER_RADIUS", "(F)V", "cornerRadius", "getCornerRadius", "setCornerRadius", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "init", "", "setCornerRadiusRound", "radius", "setScaledCornerSize", "scaledDirection", "dp", "round", "convertDpToPx", k.M, "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoundedCornerView extends FrameLayout {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int SCALED_DIRECTION_X = 0;
    public static final int SCALED_DIRECTION_Y = 1;
    private float CORNER_RADIUS;
    private float cornerRadius;
    private Context mContext;

    protected final float getCORNER_RADIUS() {
        return this.CORNER_RADIUS;
    }

    protected final void setCORNER_RADIUS(float f) {
        this.CORNER_RADIUS = f;
    }

    protected final float getCornerRadius() {
        return this.cornerRadius;
    }

    protected final void setCornerRadius(float f) {
        this.cornerRadius = f;
    }

    protected final Context getMContext() {
        return this.mContext;
    }

    protected final void setMContext(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mContext = context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.CORNER_RADIUS = 15.0f;
        this.mContext = context;
        init(context, null, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.CORNER_RADIUS = 15.0f;
        this.mContext = context;
        init(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCornerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.CORNER_RADIUS = 15.0f;
        this.mContext = context;
        init(context, attributeSet, i);
    }

    protected final void init(Context context, AttributeSet attrs, int defStyle) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.cornerRadius = TypedValue.applyDimension(1, this.CORNER_RADIUS, context.getResources().getDisplayMetrics());
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.PromotionViewRoundedCorner, 0, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            try {
                this.cornerRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.PromotionViewRoundedCorner_round, this.cornerRadius);
            } catch (Exception e) {
                Logger.INSTANCE.w("[RoundedCornerView] init() \ne: " + e.getMessage());
            }
            setLayerType(2, null);
            setCornerRadiusRound(this.cornerRadius);
            setWillNotDraw(false);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void setCornerRadiusRound(float radius) {
        this.cornerRadius = radius;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.cornerRadius);
        setBackground(gradientDrawable);
        setClipToOutline(true);
    }

    public final void setScaledCornerSize(final int scaledDirection, final float dp, final float round) {
        if (getViewTreeObserver().isAlive()) {
            getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.hive.promotion.ui.RoundedCornerView.setScaledCornerSize.1
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    float fConvertPxToDp;
                    float f;
                    float f2;
                    if (RoundedCornerView.this.getMeasuredHeight() == 0) {
                        return true;
                    }
                    if (RoundedCornerView.this.getViewTreeObserver().isAlive()) {
                        RoundedCornerView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                    }
                    int i = scaledDirection;
                    if (i == 0) {
                        fConvertPxToDp = RoundedCornerView.INSTANCE.convertPxToDp(RoundedCornerView.this.getMContext(), RoundedCornerView.this.getMeasuredWidth());
                        f = dp;
                    } else if (i == 1) {
                        fConvertPxToDp = RoundedCornerView.INSTANCE.convertPxToDp(RoundedCornerView.this.getMContext(), RoundedCornerView.this.getMeasuredHeight());
                        f = dp;
                    } else {
                        f2 = 0.0f;
                        RoundedCornerView roundedCornerView = RoundedCornerView.this;
                        roundedCornerView.setCornerRadiusRound(roundedCornerView.convertDpToPx(roundedCornerView.getMContext(), f2 * round));
                        return false;
                    }
                    f2 = fConvertPxToDp / f;
                    RoundedCornerView roundedCornerView2 = RoundedCornerView.this;
                    roundedCornerView2.setCornerRadiusRound(roundedCornerView2.convertDpToPx(roundedCornerView2.getMContext(), f2 * round));
                    return false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float convertDpToPx(Context context, float dp) {
        return TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }

    /* JADX INFO: compiled from: RoundedCornerView.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/hive/promotion/ui/RoundedCornerView$Companion;", "", "<init>", "()V", "SCALED_DIRECTION_X", "", "SCALED_DIRECTION_Y", "convertPxToDp", "", "context", "Landroid/content/Context;", "px", "hive-promotion_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final float convertPxToDp(Context context, float px) {
            Intrinsics.checkNotNullParameter(context, "context");
            return px / (context.getResources().getDisplayMetrics().densityDpi / 160);
        }
    }
}
