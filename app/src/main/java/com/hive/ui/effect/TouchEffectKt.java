package com.hive.ui.effect;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TouchEffect.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aq\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH\u0007\u001ag\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00072%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000eH\u0007\u001a\u0014\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\fH\u0007¨\u0006\u001a"}, d2 = {"setTouchEffect", "", "Landroid/view/View;", "changeColor", "", "originalColor", "delayMillis", "", "customRect", "Landroid/graphics/Rect;", "delayClick", "mode", "Landroid/graphics/PorterDuff$Mode;", "onClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "setVisibleEffect", "fromAlpha", "", "toAlpha", "setDelayClickTimer", "delay", "toBlendMode", "Landroid/graphics/BlendMode;", "hive-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TouchEffectKt {

    /* JADX INFO: compiled from: TouchEffect.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PorterDuff.Mode.values().length];
            try {
                iArr[PorterDuff.Mode.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PorterDuff.Mode.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PorterDuff.Mode.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PorterDuff.Mode.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PorterDuff.Mode.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PorterDuff.Mode.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PorterDuff.Mode.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[PorterDuff.Mode.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[PorterDuff.Mode.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[PorterDuff.Mode.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[PorterDuff.Mode.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[PorterDuff.Mode.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[PorterDuff.Mode.DARKEN.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[PorterDuff.Mode.LIGHTEN.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[PorterDuff.Mode.MULTIPLY.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[PorterDuff.Mode.SCREEN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[PorterDuff.Mode.ADD.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[PorterDuff.Mode.OVERLAY.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void setTouchEffect(final View view, int i, int i2, final long j, final Rect rect, final long j2, PorterDuff.Mode mode, final Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(mode, "mode");
        final ColorAnimation colorAnimation = new ColorAnimation(view, i2, i2 != 0 ? ColorUtils.blendARGB(i, i2, 0.5f) : i, j, mode);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.ui.effect.TouchEffectKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return TouchEffectKt.setTouchEffect$lambda$2(rect, colorAnimation, j2, view, function1, j, view2, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setTouchEffect$lambda$2(Rect rect, ColorAnimation colorAnimation, long j, final View view, final Function1 function1, long j2, View view2, MotionEvent motionEvent) {
        if (rect == null) {
            rect = new Rect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            ColorAnimation.startChangeAnimation$default(colorAnimation, null, null, 3, null);
        } else if (action == 1) {
            if (j > 0) {
                setDelayClickTimer(view, j);
            }
            ColorAnimation.startReverseAnimation$default(colorAnimation, null, null, 3, null);
            if (rect.contains(view2.getLeft() + ((int) motionEvent.getX()), view2.getTop() + ((int) motionEvent.getY())) && function1 != null) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.hive.ui.effect.TouchEffectKt$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        function1.invoke(view);
                    }
                }, j2);
            }
        } else {
            if (action != 3) {
                return false;
            }
            ColorAnimation.startReverseAnimation$default(colorAnimation, null, null, 3, null);
        }
        return true;
    }

    public static final void setVisibleEffect(final View view, float f, float f2, final long j, final Rect rect, final long j2, final Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        final VisibleAnimation visibleAnimation = new VisibleAnimation(view, f, f2, j);
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.ui.effect.TouchEffectKt$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return TouchEffectKt.setVisibleEffect$lambda$5(rect, visibleAnimation, function1, j, j2, view, view2, motionEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setVisibleEffect$lambda$5(Rect rect, VisibleAnimation visibleAnimation, final Function1 function1, long j, final long j2, final View view, View view2, MotionEvent motionEvent) {
        if (rect == null) {
            rect = new Rect(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            VisibleAnimation.startVisibleAnimation$default(visibleAnimation, null, null, 3, null);
        } else if (action == 1) {
            VisibleAnimation.startInvisibleAnimation$default(visibleAnimation, null, null, 3, null);
            if (rect.contains(view2.getLeft() + ((int) motionEvent.getX()), view2.getTop() + ((int) motionEvent.getY())) && function1 != null) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.hive.ui.effect.TouchEffectKt$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        TouchEffectKt.setVisibleEffect$lambda$5$lambda$4$lambda$3(j2, view, function1);
                    }
                }, j);
            }
        } else {
            if (action != 3) {
                return false;
            }
            VisibleAnimation.startInvisibleAnimation$default(visibleAnimation, null, null, 3, null);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setVisibleEffect$lambda$5$lambda$4$lambda$3(long j, View view, Function1 function1) {
        if (j > 0) {
            setDelayClickTimer(view, j);
        }
        function1.invoke(view);
    }

    public static /* synthetic */ void setDelayClickTimer$default(View view, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 500;
        }
        setDelayClickTimer(view, j);
    }

    public static final void setDelayClickTimer(final View view, long j) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setEnabled(false);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.hive.ui.effect.TouchEffectKt$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                view.setEnabled(true);
            }
        }, j);
    }

    public static final BlendMode toBlendMode(PorterDuff.Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) {
            case 1:
                return BlendMode.CLEAR;
            case 2:
                return BlendMode.SRC;
            case 3:
                return BlendMode.DST;
            case 4:
                return BlendMode.SRC_OVER;
            case 5:
                return BlendMode.DST_OVER;
            case 6:
                return BlendMode.SRC_IN;
            case 7:
                return BlendMode.DST_IN;
            case 8:
                return BlendMode.SRC_OUT;
            case 9:
                return BlendMode.DST_OUT;
            case 10:
                return BlendMode.SRC_ATOP;
            case 11:
                return BlendMode.DST_ATOP;
            case 12:
                return BlendMode.XOR;
            case 13:
                return BlendMode.DARKEN;
            case 14:
                return BlendMode.LIGHTEN;
            case 15:
                return BlendMode.MULTIPLY;
            case 16:
                return BlendMode.SCREEN;
            case 17:
                return BlendMode.PLUS;
            case 18:
                return BlendMode.OVERLAY;
            default:
                return BlendMode.SRC_ATOP;
        }
    }
}
