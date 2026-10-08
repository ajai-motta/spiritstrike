package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Picture;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ax {
    private static boolean exu = true;
    private static final Object fs = new Object();
    private static ViewConfiguration jpc = null;
    private static float lnr = -1.0f;
    private static int mml = -1;
    private static int mo = -1;
    private static int mzz = -1;
    private static float qdl = -1.0f;
    private static Boolean rq = null;
    private static float to = -1.0f;
    private static int tvp = -1;
    private static int ud = -1;
    private static WindowManager wd;

    private static boolean qdl(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    private static boolean lnr() {
        return qdl < 0.0f || ud < 0 || lnr < 0.0f || mml < 0 || mzz < 0;
    }

    public static void qdl(Context context) {
        qdl(context, false);
    }

    public static void qdl(Context context, boolean z) {
        Context contextQdl = context == null ? com.bytedance.sdk.openadsdk.core.yt.qdl() : context;
        if (contextQdl == null) {
            return;
        }
        wd = (WindowManager) contextQdl.getSystemService("window");
        if (lnr() || z) {
            DisplayMetrics displayMetrics = contextQdl.getResources().getDisplayMetrics();
            qdl = displayMetrics.density;
            ud = displayMetrics.densityDpi;
            lnr = displayMetrics.scaledDensity;
            mml = displayMetrics.widthPixels;
            mzz = displayMetrics.heightPixels;
        }
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration.orientation == 1) {
            int i = mml;
            int i2 = mzz;
            if (i > i2) {
                mml = i2;
                mzz = i;
            }
        } else {
            int i3 = mml;
            int i4 = mzz;
            if (i3 < i4) {
                mml = i4;
                mzz = i3;
            }
        }
        mo = configuration.smallestScreenWidthDp;
    }

    public static float qdl(Context context, float f) {
        qdl(context);
        return f * tvp(context);
    }

    public static int ud(Context context, float f) {
        if (f == 0.0f) {
            return 0;
        }
        return Float.valueOf(qdl(context, f, true)).intValue();
    }

    public static float qdl(Context context, float f, boolean z) {
        qdl(context);
        return (f * jpc(context)) + (z ? 0.5f : 0.0f);
    }

    public static int lnr(Context context, float f) {
        qdl(context, true);
        float fJpc = jpc(context);
        if (fJpc <= 0.0f) {
            fJpc = 1.0f;
        }
        return (int) ((f / fJpc) + 0.5f);
    }

    public static int[] ud(Context context) {
        if (context == null) {
            return null;
        }
        if (wd == null) {
            wd = (WindowManager) com.bytedance.sdk.openadsdk.core.yt.qdl().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = wd;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i = displayMetrics.widthPixels;
            int i2 = displayMetrics.heightPixels;
            try {
                Point point = new Point();
                Display.class.getMethod("getRealSize", Point.class).invoke(defaultDisplay, point);
                i = point.x;
                i2 = point.y;
            } catch (Exception unused) {
            }
            iArr[0] = i;
            iArr[1] = i2;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int lnr(Context context) {
        qdl(context);
        return mml;
    }

    public static int mml(Context context) {
        qdl(context);
        return lnr(context, mml);
    }

    public static int mzz(Context context) {
        qdl(context);
        return mzz;
    }

    public static int mo(Context context) {
        if (context == null) {
            com.bytedance.sdk.openadsdk.core.yt.qdl();
        }
        if (context == null) {
            return mo;
        }
        if (context.getResources() != null && context.getResources().getConfiguration() != null) {
            mo = context.getResources().getConfiguration().smallestScreenWidthDp;
        }
        return mo;
    }

    public static int wd(Context context) {
        qdl(context);
        return lnr(context, mzz);
    }

    public static float jpc(Context context) {
        qdl(context, true);
        return qdl;
    }

    public static float tvp(Context context) {
        qdl(context);
        return lnr;
    }

    public static int to(Context context) {
        qdl(context);
        return ud;
    }

    public static int[] qdl(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] ud(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] lnr(View view) {
        if (view != null) {
            return new int[]{view.getWidth(), view.getHeight()};
        }
        return null;
    }

    public static void qdl(View view, int i) {
        if (view == null || view.getVisibility() == i || !qdl(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static boolean mml(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static void qdl(TextView textView, CharSequence charSequence) {
        if (textView == null || TextUtils.isEmpty(charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public static void qdl(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams;
        if (view == null || (layoutParams = view.getLayoutParams()) == null || !(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return;
        }
        qdl(view, (ViewGroup.MarginLayoutParams) layoutParams, i, i2, i3, i4);
    }

    private static void qdl(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (view == null || marginLayoutParams == null) {
            return;
        }
        if (marginLayoutParams.leftMargin == i && marginLayoutParams.topMargin == i2 && marginLayoutParams.rightMargin == i3 && marginLayoutParams.bottomMargin == i4) {
            return;
        }
        if (i != -3) {
            marginLayoutParams.leftMargin = i;
        }
        if (i2 != -3) {
            marginLayoutParams.topMargin = i2;
        }
        if (i3 != -3) {
            marginLayoutParams.rightMargin = i3;
        }
        if (i4 != -3) {
            marginLayoutParams.bottomMargin = i4;
        }
        view.setLayoutParams(marginLayoutParams);
    }

    private static Bitmap qdl(WebView webView) {
        Bitmap bitmapCreateBitmap = null;
        try {
            Picture pictureCapturePicture = webView.capturePicture();
            bitmapCreateBitmap = Bitmap.createBitmap(pictureCapturePicture.getWidth(), pictureCapturePicture.getHeight(), Bitmap.Config.ARGB_8888);
            pictureCapturePicture.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.aaj.lnr("UIUtils", th.getMessage());
            return bitmapCreateBitmap;
        }
    }

    public static void mzz(View view) {
        if (view == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.ax.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                View view2 = (View) weakReference.get();
                if (view2 != null) {
                    ax.qdl(view2, 8);
                    view2.setAlpha(1.0f);
                }
            }
        });
        objectAnimatorOfFloat.setDuration(800L);
        objectAnimatorOfFloat.start();
    }

    public static void mo(View view) {
        if (view == null) {
            return;
        }
        qdl(view, 0);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.utils.ax.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationEnd(animator);
            }
        });
        objectAnimatorOfFloat.setDuration(300L);
        objectAnimatorOfFloat.start();
    }

    public static Pair<Integer, Integer> rq(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.yt.qdl();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    public static int fs(Context context) {
        return ((Integer) rq(context).second).intValue();
    }

    public static int exu(Context context) {
        return ((Integer) rq(context).first).intValue();
    }

    public static float qdl() {
        float f = to;
        if (f > 0.0f) {
            return f;
        }
        Resources resources = com.bytedance.sdk.openadsdk.core.yt.qdl().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0.0f;
        }
        float dimensionPixelSize = resources.getDimensionPixelSize(identifier);
        to = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public static void qdl(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(3846);
            activity.getWindow().addFlags(1792);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.lnr("UIUtils", e.getMessage());
        }
    }

    public static void ud(Activity activity) {
        if (activity == null) {
            return;
        }
        try {
            activity.getWindow().getDecorView().setSystemUiVisibility(1792);
            activity.getWindow().clearFlags(1792);
        } catch (Exception unused) {
        }
    }

    public static boolean lnr(Activity activity) {
        if (rq == null) {
            synchronized (fs) {
                if (rq == null) {
                    String strQdl = com.bytedance.sdk.openadsdk.jyq.qdl.qdl("cutout_devices", "");
                    String str = Build.MODEL;
                    if (!TextUtils.isEmpty(strQdl) && !TextUtils.isEmpty(str)) {
                        try {
                            JSONArray jSONArray = new JSONArray(strQdl);
                            for (int i = 0; i < jSONArray.length(); i++) {
                                if (str.equals(jSONArray.getString(i))) {
                                    rq = Boolean.TRUE;
                                    return true;
                                }
                            }
                        } catch (Exception e) {
                            com.bytedance.sdk.component.utils.aaj.lnr("UIUtils", e.getMessage());
                        }
                    }
                    rq = Boolean.valueOf(mml(activity) || qdl("ro.miui.notch", activity) == 1 || rdp(activity) || jl(activity) || bjy(activity) || jtx(activity) || yt(activity));
                }
            }
        }
        return rq.booleanValue();
    }

    public static boolean ud() {
        return exu && Build.VERSION.SDK_INT >= 28;
    }

    public static boolean mml(Activity activity) {
        DisplayCutout displayCutout;
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            if (rootWindowInsets != null) {
                displayCutout = rootWindowInsets.getDisplayCutout();
                exu = false;
            } else {
                displayCutout = null;
            }
            return displayCutout != null;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.aaj.lnr("UIUtils", e.getMessage());
            return false;
        }
    }

    public static int qdl(String str, Activity activity) {
        if (!bqt.mzz()) {
            return 0;
        }
        try {
            Class<?> clsLoadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) clsLoadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(clsLoadClass, new String(str), 0)).intValue();
        } catch (ClassNotFoundException e) {
            com.bytedance.sdk.component.utils.aaj.lnr("UIUtils", e.getMessage());
            return 0;
        } catch (IllegalAccessException e2) {
            com.bytedance.sdk.component.utils.aaj.lnr("UIUtils", e2.getMessage());
            return 0;
        } catch (IllegalArgumentException e3) {
            com.bytedance.sdk.component.utils.aaj.lnr("UIUtils", e3.getMessage());
            return 0;
        } catch (NoSuchMethodException e4) {
            com.bytedance.sdk.component.utils.aaj.lnr("UIUtils", e4.getMessage());
            return 0;
        } catch (InvocationTargetException e5) {
            com.bytedance.sdk.component.utils.aaj.lnr("UIUtils", e5.getMessage());
            return 0;
        }
    }

    public static boolean rdp(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean bjy(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    public static boolean jtx(Context context) {
        return Build.MODEL.equals("IN2010") || Build.MODEL.equals("IN2020") || Build.MODEL.equals("KB2000") || Build.MODEL.startsWith("ONEPLUS");
    }

    public static boolean yt(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", TypedValues.Custom.S_STRING, "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string != null) {
                if (!TextUtils.isEmpty(string)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean jl(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static void qdl(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.aaj.lnr("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void qdl(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            com.bytedance.sdk.component.utils.aaj.lnr("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void qdl(View view, float f) {
        if (view == null) {
            return;
        }
        view.setAlpha(f);
    }

    public static void qdl(TextView textView, com.bytedance.sdk.openadsdk.core.widget.jtx jtxVar, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar) {
        qdl(textView, jtxVar, ljhVar, 14);
    }

    public static void qdl(TextView textView, com.bytedance.sdk.openadsdk.core.widget.jtx jtxVar, com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, int i) {
        qdl(textView, jtxVar, (ljhVar == null || ljhVar.fhs() == null) ? -1.0d : ljhVar.fhs().mml(), i);
    }

    public static void qdl(TextView textView, com.bytedance.sdk.openadsdk.core.widget.jtx jtxVar, double d, int i) {
        if (d == -1.0d) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            jtxVar.setVisibility(8);
        } else {
            if (textView != null) {
                textView.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(d)));
            }
            qdl(jtxVar, d, i);
        }
    }

    public static void qdl(com.bytedance.sdk.openadsdk.core.widget.jtx jtxVar, double d, int i) {
        if (d < 0.0d) {
            jtxVar.setVisibility(8);
        } else {
            jtxVar.setVisibility(0);
            jtxVar.qdl(d, i);
        }
    }

    public static Bitmap qdl(com.bytedance.sdk.component.tvp.mo moVar) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        WebView webView = moVar.getWebView();
        int layerType = webView.getLayerType();
        webView.setLayerType(1, null);
        Bitmap bitmapUd = ud(moVar);
        if (bitmapUd == null) {
            bitmapUd = qdl(webView);
        }
        webView.setLayerType(layerType, null);
        if (bitmapUd == null) {
            return null;
        }
        return com.bytedance.sdk.component.utils.mml.qdl(bitmapUd, bitmapUd.getWidth() / 6, bitmapUd.getHeight() / 6);
    }

    public static void qdl(final com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, final String str, final String str2, final Bitmap bitmap, final String str3, final long j) {
        fco.ud(new com.bytedance.sdk.component.jpc.jpc("startCheckPlayableStatusPercentage") { // from class: com.bytedance.sdk.openadsdk.utils.ax.3
            @Override // java.lang.Runnable
            public void run() {
                ax.lnr(ljhVar, str, str2, bitmap, str3, j);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void lnr(final com.bytedance.sdk.openadsdk.core.model.ljh ljhVar, String str, String str2, final Bitmap bitmap, final String str3, final long j) {
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0 && !bitmap.isRecycled()) {
                    com.bytedance.sdk.openadsdk.mml.lnr.qdl(System.currentTimeMillis(), ljhVar, str, str2, new com.bytedance.sdk.openadsdk.bjy.lnr.qdl() { // from class: com.bytedance.sdk.openadsdk.utils.ax.4
                        @Override // com.bytedance.sdk.openadsdk.bjy.lnr.qdl, com.bytedance.sdk.openadsdk.bjy.lnr.ud
                        public JSONObject lnr() {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                int iQdl = ax.qdl(bitmap);
                                jSONObject.put("url", str3);
                                long j2 = j;
                                if (j2 != -1) {
                                    jSONObject.put("page_id", j2);
                                }
                                jSONObject.put("render_type", "h5");
                                jSONObject.put("render_type_2", 0);
                                jSONObject.put("is_blank", iQdl == 100 ? 1 : 0);
                                jSONObject.put("is_playable", com.bytedance.sdk.openadsdk.core.model.vu.ud(ljhVar) ? 1 : 0);
                                jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.exu.lnr.qdl.qdl().qdl(ljhVar) ? 1 : 0);
                            } catch (JSONException unused) {
                            }
                            return jSONObject;
                        }
                    });
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.aaj.lnr("UIUtils", "(Developers can ignore this detection exception)checkWebViewIsTransparent->throwable ex>>>".concat(String.valueOf(th)));
            }
        }
    }

    private static Bitmap ud(com.bytedance.sdk.component.tvp.mo moVar) {
        if (moVar == null) {
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(moVar.getWidth(), moVar.getHeight(), Bitmap.Config.RGB_565);
            moVar.draw(new Canvas(bitmapCreateBitmap));
            return bitmapCreateBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int qdl(Bitmap bitmap) {
        try {
            ArrayList<Integer> arrayListUd = ud(bitmap);
            if (arrayListUd == null) {
                return -1;
            }
            HashMap map = new HashMap();
            for (Integer num : arrayListUd) {
                if (map.containsKey(num)) {
                    Integer numValueOf = Integer.valueOf(((Integer) map.get(num)).intValue() + 1);
                    map.remove(num);
                    map.put(num, numValueOf);
                } else {
                    map.put(num, 1);
                }
            }
            int iIntValue = 0;
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (i < iIntValue2) {
                    iIntValue = ((Integer) entry.getKey()).intValue();
                    i = iIntValue2;
                }
            }
            if (iIntValue == 0) {
                return -1;
            }
            return (int) ((i / ((bitmap.getWidth() * bitmap.getHeight()) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static ArrayList<Integer> ud(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = width * height;
            int[] iArr = new int[i];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = iArr[i2];
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i3) >> 16, (65280 & i3) >> 8, i3 & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void ud(View view, final float f) {
        if (view != null && f > 0.0f) {
            view.setOutlineProvider(new ViewOutlineProvider() { // from class: com.bytedance.sdk.openadsdk.utils.ax.5
                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view2, Outline outline) {
                    if (outline == null) {
                        return;
                    }
                    outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), f);
                }
            });
            view.setClipToOutline(true);
        }
    }

    public static void wd(View view) {
        if (view == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
    }

    public static boolean qdl(float f, float f2, Context context) {
        Float.valueOf(f);
        Float.valueOf(f2);
        if (f != -1.0f && f2 != -1.0f) {
            if (jpc == null) {
                jpc = ViewConfiguration.get(context);
            }
            if (tvp == -1) {
                tvp = jpc.getScaledTouchSlop();
            }
            if (f - f2 > tvp) {
                return true;
            }
        }
        return false;
    }

    public static void qdl(boolean z) {
        rq = Boolean.valueOf(z);
    }
}
