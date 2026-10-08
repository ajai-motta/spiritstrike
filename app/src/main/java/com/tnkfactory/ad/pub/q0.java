package com.tnkfactory.ad.pub;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

/* JADX INFO: loaded from: classes6.dex */
public abstract class q0 {
    public static Animation[] a(int i) {
        Animation animation;
        int iCurrentTimeMillis = i == 0 ? ((int) (System.currentTimeMillis() % 9)) + 1 : i;
        switch (iCurrentTimeMillis) {
            case 2:
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(200L);
                animation = alphaAnimation;
                break;
            case 3:
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
                translateAnimation.setDuration(200L);
                animation = translateAnimation;
                break;
            case 4:
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, -1.0f, 2, 0.0f);
                translateAnimation2.setDuration(200L);
                animation = translateAnimation2;
                break;
            case 5:
                TranslateAnimation translateAnimation3 = new TranslateAnimation(2, -1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
                translateAnimation3.setDuration(200L);
                animation = translateAnimation3;
                break;
            case 6:
                TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 1.0f, 2, 0.0f, 2, 0.0f, 2, 0.0f);
                translateAnimation4.setDuration(200L);
                animation = translateAnimation4;
                break;
            case 7:
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 720.0f, 1, 0.5f, 1, 0.5f);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.setDuration(500L);
                animation = animationSet;
                break;
            case 8:
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.2f, 1.0f, 0.2f, 1.0f, 1, 0.5f, 1, 0.5f);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                AnimationSet animationSet2 = new AnimationSet(false);
                animationSet2.addAnimation(scaleAnimation2);
                animationSet2.addAnimation(alphaAnimation2);
                animationSet2.setDuration(300L);
                animation = animationSet2;
                break;
            case 9:
                ScaleAnimation scaleAnimation3 = new ScaleAnimation(2.0f, 1.0f, 2.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(0.0f, 1.0f);
                AnimationSet animationSet3 = new AnimationSet(false);
                animationSet3.addAnimation(scaleAnimation3);
                animationSet3.addAnimation(alphaAnimation3);
                animationSet3.setDuration(300L);
                animation = animationSet3;
                break;
            default:
                animation = null;
                break;
        }
        return new Animation[]{animation, b(iCurrentTimeMillis)};
    }

    public static Animation b(int i) {
        switch (i) {
            case 2:
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(200L);
                return alphaAnimation;
            case 3:
                TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
                translateAnimation.setDuration(200L);
                return translateAnimation;
            case 4:
                TranslateAnimation translateAnimation2 = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, -1.0f);
                translateAnimation2.setDuration(200L);
                return translateAnimation2;
            case 5:
                TranslateAnimation translateAnimation3 = new TranslateAnimation(2, 0.0f, 2, -1.0f, 2, 0.0f, 2, 0.0f);
                translateAnimation3.setDuration(200L);
                return translateAnimation3;
            case 6:
                TranslateAnimation translateAnimation4 = new TranslateAnimation(2, 0.0f, 2, 1.0f, 2, 0.0f, 2, 0.0f);
                translateAnimation4.setDuration(200L);
                return translateAnimation4;
            case 7:
                RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -720.0f, 1, 0.5f, 1, 0.5f);
                ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
                AnimationSet animationSet = new AnimationSet(false);
                animationSet.addAnimation(rotateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.setDuration(500L);
                return animationSet;
            case 8:
                ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.2f, 1.0f, 0.2f, 1, 0.5f, 1, 0.5f);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                AnimationSet animationSet2 = new AnimationSet(false);
                animationSet2.addAnimation(scaleAnimation2);
                animationSet2.addAnimation(alphaAnimation2);
                animationSet2.setDuration(300L);
                return animationSet2;
            case 9:
                ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f, 1, 0.5f, 1, 0.5f);
                AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.0f);
                AnimationSet animationSet3 = new AnimationSet(false);
                animationSet3.addAnimation(scaleAnimation3);
                animationSet3.addAnimation(alphaAnimation3);
                animationSet3.setDuration(300L);
                return animationSet3;
            default:
                return null;
        }
    }
}
