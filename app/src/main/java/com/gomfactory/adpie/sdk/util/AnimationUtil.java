package com.gomfactory.adpie.sdk.util;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes3.dex */
public class AnimationUtil {
    public static final int ANIMATION_BOTTOM_TO_TOP_SLIDE = 4;
    public static final int ANIMATION_FADE = 5;
    public static final int ANIMATION_LEFT_TO_RIGHT_SLIDE = 1;
    public static final int ANIMATION_NONE = 0;
    public static final int ANIMATION_RIGHT_TO_LEFT_SLIDE = 2;
    public static final int ANIMATION_TOP_TO_BOTTOM_SLIDE = 3;
    private static final long duration = 500;

    public static Animation getShowAnimation(int i, View view) {
        Animation animation;
        if (i == 1) {
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new TranslateAnimation(1, -1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f));
            animationSet.setDuration(500L);
            animation = animationSet;
        } else if (i == 2) {
            AnimationSet animationSet2 = new AnimationSet(true);
            animationSet2.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet2.addAnimation(new TranslateAnimation(1, 1.0f, 1, 0.0f, 1, 0.0f, 1, 0.0f));
            animationSet2.setDuration(500L);
            animation = animationSet2;
        } else if (i == 3) {
            AnimationSet animationSet3 = new AnimationSet(true);
            animationSet3.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet3.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f));
            animationSet3.setDuration(500L);
            animation = animationSet3;
        } else if (i == 4) {
            AnimationSet animationSet4 = new AnimationSet(true);
            animationSet4.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet4.addAnimation(new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f));
            animationSet4.setDuration(500L);
            animation = animationSet4;
        } else if (i == 5) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(500L);
            animation = alphaAnimation;
        } else {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation2.setDuration(0L);
            animation = alphaAnimation2;
        }
        animation.setFillEnabled(true);
        animation.setFillAfter(false);
        animation.setFillBefore(true);
        return animation;
    }

    public static Animation getHideAnimation(int i, View view) {
        Animation animation;
        if (i == 1) {
            TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(500L);
            animation = translateAnimation;
        } else if (i == 2) {
            TranslateAnimation translateAnimation2 = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
            translateAnimation2.setDuration(500L);
            animation = translateAnimation2;
        } else if (i == 3) {
            TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
            translateAnimation3.setDuration(500L);
            animation = translateAnimation3;
        } else if (i == 4) {
            TranslateAnimation translateAnimation4 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
            translateAnimation4.setDuration(500L);
            animation = translateAnimation4;
        } else if (i == 5) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(500L);
            animation = alphaAnimation;
        } else {
            AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 1.0f);
            alphaAnimation2.setDuration(0L);
            animation = alphaAnimation2;
        }
        animation.setFillEnabled(true);
        animation.setFillAfter(true);
        animation.setFillBefore(false);
        return animation;
    }
}
