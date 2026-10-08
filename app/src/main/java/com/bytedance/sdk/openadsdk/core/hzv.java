package com.bytedance.sdk.openadsdk.core;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.ax;

/* JADX INFO: loaded from: classes3.dex */
public class hzv {
    private static boolean qdl(View view, int i) {
        float fQdl = qdl(view);
        return fQdl > 0.0f && fQdl >= ((float) i) / 100.0f;
    }

    public static float qdl(View view) {
        if (view != null) {
            try {
                if (view.getVisibility() == 0 && view.getParent() != null) {
                    Rect rect = new Rect();
                    if (!view.getGlobalVisibleRect(rect)) {
                        return -1.0f;
                    }
                    long jHeight = ((long) rect.height()) * ((long) rect.width());
                    long height = ((long) view.getHeight()) * ((long) view.getWidth());
                    if (height <= 0) {
                        return -1.0f;
                    }
                    return jHeight / height;
                }
            } catch (Throwable unused) {
            }
        }
        return -1.0f;
    }

    private static boolean ud(View view) {
        return view != null && view.isShown();
    }

    private static boolean qdl(View view, int i, boolean z) {
        return (i == 1 && z) ? view.getWidth() > 0 && view.getHeight() > 0 : view.getWidth() >= ud(view, i) && view.getHeight() >= lnr(view, i);
    }

    private static int ud(View view, int i) {
        if (i == 3) {
            return (int) (((double) ax.lnr(view.getContext().getApplicationContext())) * 0.7d);
        }
        return 20;
    }

    private static int lnr(View view, int i) {
        if (i == 3) {
            return ax.mzz(view.getContext().getApplicationContext()) / 2;
        }
        return 20;
    }

    private static int ud(View view, int i, int i2, boolean z) throws Throwable {
        if (view.getWindowVisibility() != 0) {
            return 4;
        }
        if (!ud(view)) {
            return 1;
        }
        if (qdl(view, i2, z)) {
            return !qdl(view, i) ? 3 : 0;
        }
        return 6;
    }

    public static boolean qdl(View view, int i, int i2, boolean z) {
        if (i2 == 1) {
            while (view != null) {
                try {
                    if (view.getVisibility() != 0) {
                        return false;
                    }
                    if ((view instanceof com.bytedance.sdk.openadsdk.core.tvp.aaj) || (view instanceof com.bytedance.sdk.openadsdk.core.mml.mml)) {
                        break;
                    }
                    view = (View) view.getParent();
                } catch (Throwable unused) {
                }
            }
            if (z) {
                i = 0;
            }
        }
        return ud(view, i, i2, z) == 0;
    }
}
