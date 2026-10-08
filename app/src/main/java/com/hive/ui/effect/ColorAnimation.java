package com.hive.ui.effect;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.BlendModeColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TouchEffect.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016J*\u0010\u0018\u001a\u00020\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016J \u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/hive/ui/effect/ColorAnimation;", "", "view", "Landroid/view/View;", "fromColor", "", "toColor", "delayMillis", "", "mode", "Landroid/graphics/PorterDuff$Mode;", "<init>", "(Landroid/view/View;IIJLandroid/graphics/PorterDuff$Mode;)V", "changeAnimation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "reverseAnimation", "isChanged", "", "startChangeAnimation", "", TtmlNode.START, "Lkotlin/Function0;", TtmlNode.END, "startReverseAnimation", "update", "animator", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColorAnimation {
    private final ValueAnimator changeAnimation;
    private final long delayMillis;
    private boolean isChanged;
    private final ValueAnimator reverseAnimation;
    private final View view;

    public ColorAnimation(View view, int i, int i2, long j, final PorterDuff.Mode mode) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.view = view;
        this.delayMillis = j;
        ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i), Integer.valueOf(i2));
        valueAnimatorOfObject.setDuration(j);
        valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.hive.ui.effect.ColorAnimation$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ColorAnimation.changeAnimation$lambda$1$lambda$0(this.f$0, mode, valueAnimator);
            }
        });
        this.changeAnimation = valueAnimatorOfObject;
        ValueAnimator valueAnimatorOfObject2 = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(i2), Integer.valueOf(i));
        valueAnimatorOfObject2.setDuration(j);
        valueAnimatorOfObject2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.hive.ui.effect.ColorAnimation$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ColorAnimation.reverseAnimation$lambda$3$lambda$2(this.f$0, mode, valueAnimator);
            }
        });
        this.reverseAnimation = valueAnimatorOfObject2;
    }

    public /* synthetic */ ColorAnimation(View view, int i, int i2, long j, PorterDuff.Mode mode, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, i, i2, j, (i3 & 16) != 0 ? PorterDuff.Mode.SRC_ATOP : mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void changeAnimation$lambda$1$lambda$0(ColorAnimation colorAnimation, PorterDuff.Mode mode, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        colorAnimation.update(colorAnimation.view, animator, mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reverseAnimation$lambda$3$lambda$2(ColorAnimation colorAnimation, PorterDuff.Mode mode, ValueAnimator animator) {
        Intrinsics.checkNotNullParameter(animator, "animator");
        colorAnimation.update(colorAnimation.view, animator, mode);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startChangeAnimation$default(ColorAnimation colorAnimation, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        colorAnimation.startChangeAnimation(function0, function02);
    }

    public final void startChangeAnimation(final Function0<Unit> start, final Function0<Unit> end) {
        if (this.isChanged) {
            return;
        }
        this.isChanged = true;
        this.changeAnimation.removeAllListeners();
        this.changeAnimation.addListener(new Animator.AnimatorListener() { // from class: com.hive.ui.effect.ColorAnimation.startChangeAnimation.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Function0<Unit> function0 = start;
                if (function0 != null) {
                    function0.invoke();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Function0<Unit> function0 = end;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        this.changeAnimation.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startReverseAnimation$default(ColorAnimation colorAnimation, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        colorAnimation.startReverseAnimation(function0, function02);
    }

    public final void startReverseAnimation(final Function0<Unit> start, final Function0<Unit> end) {
        if (this.isChanged) {
            this.isChanged = false;
            this.reverseAnimation.removeAllListeners();
            this.reverseAnimation.addListener(new Animator.AnimatorListener() { // from class: com.hive.ui.effect.ColorAnimation.startReverseAnimation.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    Function0<Unit> function0 = start;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    Function0<Unit> function0 = end;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
            this.reverseAnimation.start();
        }
    }

    private final void update(View view, ValueAnimator animator, PorterDuff.Mode mode) {
        if (view instanceof ImageView) {
            Object animatedValue = animator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            ((ImageView) view).setColorFilter(((Integer) animatedValue).intValue(), mode);
            return;
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (textView.getBackground() != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    Drawable background = textView.getBackground();
                    Object animatedValue2 = animator.getAnimatedValue();
                    Intrinsics.checkNotNull(animatedValue2, "null cannot be cast to non-null type kotlin.Int");
                    background.setColorFilter(new BlendModeColorFilter(((Integer) animatedValue2).intValue(), TouchEffectKt.toBlendMode(mode)));
                    return;
                }
                Drawable background2 = textView.getBackground();
                Object animatedValue3 = animator.getAnimatedValue();
                Intrinsics.checkNotNull(animatedValue3, "null cannot be cast to non-null type kotlin.Int");
                background2.setColorFilter(((Integer) animatedValue3).intValue(), mode);
                return;
            }
            Object animatedValue4 = animator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue4, "null cannot be cast to non-null type kotlin.Int");
            textView.setTextColor(((Integer) animatedValue4).intValue());
            return;
        }
        Object animatedValue5 = animator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue5, "null cannot be cast to non-null type kotlin.Int");
        view.setBackgroundColor(((Integer) animatedValue5).intValue());
    }
}
