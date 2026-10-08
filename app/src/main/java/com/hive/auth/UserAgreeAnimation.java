package com.hive.auth;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.hive.auth.AuthImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\nJ\u0006\u0010\u001f\u001a\u00020\u001cJ\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/hive/auth/UserAgreeAnimation;", "", "thiz", "Lcom/hive/auth/UserAgreeDialog;", "mainLayout", "Landroid/view/ViewGroup;", "xDP", "", "yDP", "displayWidth", "", "displayHeight", "titleHeight", "<init>", "(Lcom/hive/auth/UserAgreeDialog;Landroid/view/ViewGroup;FFIII)V", "bodyLayout", "Landroid/widget/RelativeLayout;", "boardTop", "boardDown", "showTitleDuration", "", "openBodyDuration", "closeBodyDuration", "hideTitleDuration", "isOpened", "", "isAnimation", "openAgreementUI", "", "closeAgreementUI", NotificationCompat.CATEGORY_MESSAGE, "configurationChanged", "showTitleAnimation", "openBodyAnimation", "closeBodyAnimation", "hideTitleAnimation", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserAgreeAnimation {
    private final RelativeLayout boardDown;
    private final RelativeLayout boardTop;
    private final RelativeLayout bodyLayout;
    private long closeBodyDuration;
    private int displayHeight;
    private int displayWidth;
    private long hideTitleDuration;
    private boolean isAnimation;
    private boolean isOpened;
    private final ViewGroup mainLayout;
    private long openBodyDuration;
    private long showTitleDuration;
    private final UserAgreeDialog thiz;
    private final int titleHeight;
    private float xDP;
    private float yDP;

    public UserAgreeAnimation(UserAgreeDialog thiz, ViewGroup mainLayout, float f, float f2, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(thiz, "thiz");
        Intrinsics.checkNotNullParameter(mainLayout, "mainLayout");
        this.thiz = thiz;
        this.mainLayout = mainLayout;
        this.xDP = f;
        this.yDP = f2;
        this.displayWidth = i;
        this.displayHeight = i2;
        this.titleHeight = i3;
        View childAt = mainLayout.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.bodyLayout = (RelativeLayout) childAt;
        View childAt2 = mainLayout.getChildAt(1);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.boardTop = (RelativeLayout) childAt2;
        View childAt3 = mainLayout.getChildAt(2);
        Intrinsics.checkNotNull(childAt3, "null cannot be cast to non-null type android.widget.RelativeLayout");
        this.boardDown = (RelativeLayout) childAt3;
        this.showTitleDuration = 750L;
        this.openBodyDuration = 500L;
        this.closeBodyDuration = 750L;
        this.hideTitleDuration = 750L;
    }

    private final void closeBodyAnimation(final int msg) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + 10;
        float f = this.displayHeight;
        float f2 = 20;
        float f3 = this.yDP;
        float f4 = 10;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 0, -(f - (((f2 * f3) + (this.titleHeight * 2)) - (f3 * f4))));
        float f5 = this.displayHeight;
        float f6 = this.yDP;
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 0, -(f5 - (((f2 * f6) + (this.titleHeight * 2)) - (f4 * f6))));
        translateAnimation.setDuration(this.closeBodyDuration - 50);
        translateAnimation2.setDuration(this.closeBodyDuration);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.hive.auth.UserAgreeAnimation.closeBodyAnimation.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                UserAgreeAnimation.this.bodyLayout.setVisibility(8);
                UserAgreeAnimation.this.hideTitleAnimation(msg);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                UserAgreeAnimation.this.isAnimation = true;
            }
        });
        this.boardDown.invalidate();
        this.bodyLayout.invalidate();
        translateAnimation.setStartTime(jCurrentAnimationTimeMillis);
        translateAnimation2.setStartTime(jCurrentAnimationTimeMillis);
        this.boardDown.startAnimation(translateAnimation);
        this.bodyLayout.startAnimation(translateAnimation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideTitleAnimation(final int msg) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + 10;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -0.1f);
        float f = 20;
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 0, -((this.yDP * f) + (this.titleHeight * 2)));
        float f2 = this.displayHeight;
        float f3 = this.yDP;
        float f4 = 10 * f3;
        TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, -(f2 - (((f * f3) + (this.titleHeight * 2)) - f4)), 0, -(f2 + f4));
        translateAnimation.setDuration(this.hideTitleDuration);
        translateAnimation2.setDuration(this.hideTitleDuration);
        translateAnimation3.setDuration(this.hideTitleDuration);
        translateAnimation.setInterpolator(new AnticipateOvershootInterpolator());
        translateAnimation2.setInterpolator(new AnticipateOvershootInterpolator());
        translateAnimation3.setInterpolator(new AnticipateOvershootInterpolator());
        translateAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.hive.auth.UserAgreeAnimation.hideTitleAnimation.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                UserAgreeAnimation.this.mainLayout.setVisibility(8);
                if (msg == 0) {
                    AuthImpl authImpl = AuthImpl.INSTANCE;
                    AuthImpl.UserAgreeListener userAgreeListener = authImpl.getUserAgreeListener();
                    if (userAgreeListener != null) {
                        userAgreeListener.onUserAgreeResult(1000);
                    }
                    AuthImpl.AfterAgreementListener internalAfterAgreementListener$hive_service_release = authImpl.getInternalAfterAgreementListener$hive_service_release();
                    if (internalAfterAgreementListener$hive_service_release != null) {
                        internalAfterAgreementListener$hive_service_release.onAgreementUIFinish(0, true);
                    }
                }
                UserAgreeAnimation.this.thiz.finish();
                UserAgreeAnimation.this.isAnimation = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        this.mainLayout.invalidate();
        this.boardTop.invalidate();
        this.boardDown.invalidate();
        translateAnimation.setStartTime(jCurrentAnimationTimeMillis);
        translateAnimation2.setStartTime(jCurrentAnimationTimeMillis);
        translateAnimation3.setStartTime(jCurrentAnimationTimeMillis);
        this.mainLayout.startAnimation(translateAnimation);
        this.boardTop.startAnimation(translateAnimation2);
        this.boardDown.startAnimation(translateAnimation3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void openBodyAnimation() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + 10;
        float f = this.displayHeight;
        float f2 = 20;
        float f3 = this.yDP;
        float f4 = 10;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, -(f - (((f2 * f3) + (this.titleHeight * 2)) - (f3 * f4))), 1, 0.0f);
        float f5 = this.displayHeight;
        float f6 = this.yDP;
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, -(f5 - (((f2 * f6) + (this.titleHeight * 2)) - (f4 * f6))), 1, 0.0f);
        translateAnimation.setDuration(this.openBodyDuration + 50);
        translateAnimation2.setDuration(this.openBodyDuration);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation2.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.hive.auth.UserAgreeAnimation.openBodyAnimation.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                UserAgreeAnimation.this.isAnimation = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                UserAgreeAnimation.this.bodyLayout.setVisibility(0);
            }
        });
        this.boardDown.invalidate();
        this.bodyLayout.invalidate();
        translateAnimation.setStartTime(jCurrentAnimationTimeMillis);
        translateAnimation2.setStartTime(jCurrentAnimationTimeMillis);
        this.boardDown.startAnimation(translateAnimation);
        this.bodyLayout.startAnimation(translateAnimation2);
    }

    private final void showTitleAnimation() {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() + 100;
        this.bodyLayout.setVisibility(8);
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.1f, 1, 0.0f);
        float f = 20;
        TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, -((this.yDP * f) + (this.titleHeight * 2)), 1, 0.0f);
        float f2 = this.displayHeight;
        float f3 = this.yDP;
        float f4 = 10 * f3;
        TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, -(f2 + f4), 0, -(f2 - (((f * f3) + (this.titleHeight * 2)) - f4)));
        translateAnimation.setDuration(this.showTitleDuration);
        translateAnimation2.setDuration(this.showTitleDuration - 50);
        translateAnimation3.setDuration(this.showTitleDuration - 50);
        translateAnimation.setInterpolator(new AnticipateOvershootInterpolator());
        translateAnimation2.setInterpolator(new AnticipateOvershootInterpolator());
        translateAnimation3.setInterpolator(new AnticipateOvershootInterpolator());
        translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.hive.auth.UserAgreeAnimation.showTitleAnimation.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                UserAgreeAnimation.this.openBodyAnimation();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                UserAgreeAnimation.this.isAnimation = true;
            }
        });
        this.mainLayout.invalidate();
        this.boardTop.invalidate();
        this.boardDown.invalidate();
        translateAnimation.setStartTime(jCurrentAnimationTimeMillis);
        translateAnimation2.setStartTime(jCurrentAnimationTimeMillis);
        translateAnimation3.setStartTime(jCurrentAnimationTimeMillis);
        this.mainLayout.startAnimation(translateAnimation);
        this.boardTop.startAnimation(translateAnimation2);
        this.boardDown.startAnimation(translateAnimation3);
    }

    public final void closeAgreementUI(int msg) {
        if (!this.isOpened || this.isAnimation) {
            return;
        }
        this.isOpened = false;
        closeBodyAnimation(msg);
    }

    public final void configurationChanged() {
        float f = this.xDP;
        this.xDP = this.yDP;
        this.yDP = f;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.thiz.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        this.displayWidth = displayMetrics.widthPixels;
        this.displayHeight = displayMetrics.heightPixels;
    }

    public final void openAgreementUI() {
        if (this.isOpened || this.isAnimation) {
            return;
        }
        this.isOpened = true;
        showTitleAnimation();
    }
}
