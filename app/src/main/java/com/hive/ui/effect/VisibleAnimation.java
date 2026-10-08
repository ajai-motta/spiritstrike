package com.hive.ui.effect;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TouchEffect.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ*\u0010\u0010\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013J*\u0010\u0015\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/hive/ui/effect/VisibleAnimation;", "", "view", "Landroid/view/View;", "fromAlpha", "", "toAlpha", "delayMillis", "", "<init>", "(Landroid/view/View;FFJ)V", "visibleAnimation", "Landroid/view/animation/AlphaAnimation;", "invisibleAnimation", "isChanged", "", "startVisibleAnimation", "", TtmlNode.START, "Lkotlin/Function0;", TtmlNode.END, "startInvisibleAnimation", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VisibleAnimation {
    private final long delayMillis;
    private final float fromAlpha;
    private final AlphaAnimation invisibleAnimation;
    private boolean isChanged;
    private final float toAlpha;
    private final View view;
    private final AlphaAnimation visibleAnimation;

    public VisibleAnimation(View view, float f, float f2, long j) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.fromAlpha = f;
        this.toAlpha = f2;
        this.delayMillis = j;
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setDuration(j);
        this.visibleAnimation = alphaAnimation;
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(f2, f);
        alphaAnimation2.setDuration(j);
        this.invisibleAnimation = alphaAnimation2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startVisibleAnimation$default(VisibleAnimation visibleAnimation, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        visibleAnimation.startVisibleAnimation(function0, function02);
    }

    public final void startVisibleAnimation(final Function0<Unit> start, final Function0<Unit> end) {
        if (this.isChanged) {
            return;
        }
        this.isChanged = true;
        this.visibleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.hive.ui.effect.VisibleAnimation.startVisibleAnimation.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                VisibleAnimation.this.view.setAlpha(VisibleAnimation.this.toAlpha);
                Function0<Unit> function0 = start;
                if (function0 != null) {
                    function0.invoke();
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                Function0<Unit> function0 = end;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        this.view.clearAnimation();
        this.view.startAnimation(this.visibleAnimation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void startInvisibleAnimation$default(VisibleAnimation visibleAnimation, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        if ((i & 2) != 0) {
            function02 = null;
        }
        visibleAnimation.startInvisibleAnimation(function0, function02);
    }

    public final void startInvisibleAnimation(final Function0<Unit> start, final Function0<Unit> end) {
        if (this.isChanged) {
            this.isChanged = false;
            this.invisibleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.hive.ui.effect.VisibleAnimation.startInvisibleAnimation.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    VisibleAnimation.this.view.setAlpha(VisibleAnimation.this.toAlpha);
                    Function0<Unit> function0 = start;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    VisibleAnimation.this.view.setAlpha(VisibleAnimation.this.fromAlpha);
                    Function0<Unit> function0 = end;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
            this.view.clearAnimation();
            this.view.startAnimation(this.invisibleAnimation);
        }
    }
}
