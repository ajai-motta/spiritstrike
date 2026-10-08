package com.tnkfactory.ad.pub;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.tnkfactory.ad.Logger;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public abstract class n2 {
    public static boolean a(View view, boolean z) {
        if (view == null || view.getVisibility() != 0 || view.getParent() == null || view.getWindowVisibility() != 0) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        if (z) {
            return ((double) (rect.height() * rect.width())) / ((double) (view.getHeight() * view.getWidth())) > 0.5d;
        }
        return true;
    }

    public static m2 b(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            Insets insetsIgnoringVisibility = currentWindowMetrics.getWindowInsets().getInsetsIgnoringVisibility(WindowInsets.Type.systemBars());
            return new m2((currentWindowMetrics.getBounds().width() - insetsIgnoringVisibility.left) - insetsIgnoringVisibility.right, (currentWindowMetrics.getBounds().height() - insetsIgnoringVisibility.bottom) - insetsIgnoringVisibility.top);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return new m2(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static m2 a(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            return new m2(point.x, point.y);
        } catch (Exception e) {
            Logger.e("error #f004 : " + e.toString());
            return new m2(0, 0);
        }
    }

    public static ColorStateList a(String str, String str2) {
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[0]}, new int[]{(int) a(str2), (int) a(str)});
    }

    public static long a(String str) {
        if (str == null) {
            return 0L;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return 0L;
        }
        if (strTrim.startsWith("0x")) {
            return Long.parseLong(strTrim.substring(2), 16);
        }
        return Long.parseLong(strTrim);
    }

    public static float a(Context context, int i, String str) {
        try {
            String strTrim = str.trim();
            if (strTrim.length() == 0) {
                return 0.0f;
            }
            if (strTrim.endsWith("dp")) {
                return TypedValue.applyDimension(1, Float.parseFloat(strTrim.substring(0, strTrim.length() - 2)), context.getResources().getDisplayMetrics());
            }
            if (strTrim.endsWith("px")) {
                return Float.parseFloat(strTrim.substring(0, strTrim.length() - 2));
            }
            float f = Float.parseFloat(strTrim);
            return f < 0.0f ? f : (i * f) / 100.0f;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int[] a(Context context, int i, int i2, String str) {
        int[] iArr = {0, 0, 0, 0};
        int i3 = 0;
        for (String str2 : str.split(",")) {
            if (i3 != 0 && i3 != 2) {
                iArr[i3] = (int) a(context, i2, str2);
            } else {
                iArr[i3] = (int) a(context, i, str2);
            }
            i3++;
            if (i3 >= 4) {
                break;
            }
        }
        return iArr;
    }

    public static ArrayList a(ViewGroup viewGroup, Class cls) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (cls.isInstance(childAt)) {
                arrayList.add(childAt);
            } else if (childAt instanceof ViewGroup) {
                arrayList.addAll(a((ViewGroup) childAt, cls));
            }
        }
        return arrayList;
    }

    public static int a(Bitmap bitmap, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (bitmap == null) {
            return 0;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i == 0) {
            i2 = 0;
            i3 = width;
            i4 = 1;
            i5 = 0;
        } else if (i == 1) {
            i2 = height - 1;
            i3 = width;
            i4 = 1;
            i5 = 0;
        } else if (i != 2) {
            i5 = width - 1;
            i4 = height;
            i3 = 1;
            i2 = 0;
        } else {
            i5 = 0;
            i4 = height;
            i3 = 1;
            i2 = 0;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, i5, i2, i3, i4);
        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, 1, 1, true);
        int pixel = bitmapCreateScaledBitmap.getPixel(0, 0);
        bitmapCreateScaledBitmap.recycle();
        bitmapCreateBitmap.recycle();
        return pixel;
    }
}
