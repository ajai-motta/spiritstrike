package com.tnkfactory.ad.pub;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Insets;
import android.os.Build;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes6.dex */
public final class t5 extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3198a;
    public final boolean b;

    public t5(Context context) {
        super(context);
        this.f3198a = 0;
        this.b = c0.a(context);
    }

    public final boolean a(int i, boolean z) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1);
        setOnClickListener(new s5());
        if ((getContext() instanceof Activity) && !((Activity) getContext()).isFinishing()) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            layoutParams.copyFrom(((Activity) getContext()).getWindow().getAttributes());
            layoutParams.type = 2;
            setBackgroundColor(i);
            if (z) {
                layoutParams.flags = 66816;
            } else {
                Resources resources = getContext().getResources();
                int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                if (identifier > 0) {
                    this.f3198a = resources.getDimensionPixelSize(identifier);
                }
                layoutParams.flags = 65792;
            }
            layoutParams.format = -3;
            if (windowManager != null) {
                try {
                    windowManager.addView(this, layoutParams);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public int[] getViewSize() {
        int width;
        int height;
        if (this.b) {
            int width2 = getWidth();
            int height2 = getHeight() - this.f3198a;
            if (width2 < height2) {
                width = Math.min(height2 / 2, width2);
                height = (int) (((double) width) * 1.9d);
            } else {
                height = Math.min(width2 / 2, height2);
                width = (int) (((double) height) * 1.9d);
            }
        } else {
            width = getWidth();
            height = getHeight() - this.f3198a;
        }
        return new int[]{width, height};
    }

    public int[] getViewSizeSdk35() {
        int i;
        int i2;
        int width;
        int height;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            Insets insetsIgnoringVisibility = windowManager.getCurrentWindowMetrics().getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            i2 = insetsIgnoringVisibility.left + insetsIgnoringVisibility.right;
            i = insetsIgnoringVisibility.bottom + insetsIgnoringVisibility.top;
        } else {
            i = this.f3198a;
            i2 = 0;
        }
        if (this.b) {
            int width2 = getWidth() - i2;
            int height2 = getHeight() - i;
            if (width2 < height2) {
                width = Math.min(height2 / 2, width2);
                height = (int) (((double) width) * 1.9d);
            } else {
                height = Math.min(width2 / 2, height2);
                width = (int) (((double) height) * 1.9d);
            }
        } else {
            width = getWidth() - i2;
            height = getHeight() - i;
        }
        return new int[]{width, height};
    }

    public final void a() {
        try {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            if (windowManager != null) {
                windowManager.removeView(this);
            }
        } catch (Exception e) {
            Logger.e("error #2014 : " + e.toString());
        }
    }
}
