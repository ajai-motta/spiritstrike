package com.hive.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.hive.core.Logger;
import com.hive.core.configuration.HiveOrientation;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010\u000f\u001a\u00020\u0005H\u0003J\u0010\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\rJ\u000e\u0010$\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\rJ\u0016\u0010%\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020\u001fJ\u001a\u0010'\u001a\u00020\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010(\u001a\u00020)R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006*"}, d2 = {"Lcom/hive/ui/Util;", "", "<init>", "()V", "systemUI", "", "getSystemUI", "()I", "setSystemUI", "(I)V", "setSystemUiVisibility", "", "view", "Landroid/view/View;", "setOnSystemUiVisibilityChangeListener", "getHiveUiFlags", "hideSystemUI", "window", "Landroid/view/Window;", "getScreenSize", "Landroid/graphics/Point;", "activity", "Landroid/app/Activity;", "isPortrait", "", "isLandscape", "isTable", "context", "Landroid/content/Context;", "isMobile", "getFloat", "", "name", "", "setDisplayCutoutNever", "rootView", "setOnDisplayCutoutNever", "convertDpToPx", "dp", "getSystemScreenOrientation", "hiveOrientation", "Lcom/hive/core/configuration/HiveOrientation;", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Util {
    public static final Util INSTANCE = new Util();
    private static int systemUI;

    /* JADX INFO: compiled from: Util.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HiveOrientation.values().length];
            try {
                iArr[HiveOrientation.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HiveOrientation.ALL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HiveOrientation.PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HiveOrientation.LANDSCAPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HiveOrientation.SYSTEM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private Util() {
    }

    public final int getSystemUI() {
        return systemUI;
    }

    public final void setSystemUI(int i) {
        systemUI = i;
    }

    @Deprecated(message = "Setting only for GameActivity. Use hideSystemUI() instead.")
    public final void setSystemUiVisibility(View view) {
        if (view == null) {
            return;
        }
        view.setSystemUiVisibility(getHiveUiFlags());
    }

    @Deprecated(message = "Setting only for GameActivity. Use hideSystemUI() instead.")
    public final void setOnSystemUiVisibilityChangeListener(final View view) {
        if (view == null) {
            return;
        }
        setSystemUiVisibility(view);
        view.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.hive.ui.Util$$ExternalSyntheticLambda0
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i) {
                Util.setOnSystemUiVisibilityChangeListener$lambda$0(view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnSystemUiVisibilityChangeListener$lambda$0(View view, int i) {
        Util util = INSTANCE;
        if (i != util.getHiveUiFlags()) {
            util.setSystemUiVisibility(view);
        }
    }

    @Deprecated(message = "Setting only for GameActivity. Use hideSystemUI() instead.")
    private final int getHiveUiFlags() {
        int i = systemUI;
        if (i == 0) {
            return 5894;
        }
        return i;
    }

    public final void hideSystemUI(Window window) {
        Object objM7415constructorimpl;
        if (window == null) {
            Logger.INSTANCE.w("[Util] hideSystemUI() window is null.");
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            WindowCompat.setDecorFitsSystemWindows(window, false);
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.statusBars() | WindowInsetsCompat.Type.navigationBars() | WindowInsetsCompat.Type.displayCutout());
            windowInsetsControllerCompat.setSystemBarsBehavior(2);
            objM7415constructorimpl = Result.m7415constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM7418exceptionOrNullimpl = Result.m7418exceptionOrNullimpl(objM7415constructorimpl);
        if (thM7418exceptionOrNullimpl != null) {
            Logger.INSTANCE.w("[Util] Failed hideSystemUI().\nMessage = " + thM7418exceptionOrNullimpl.getMessage());
        }
    }

    public final Point getScreenSize(Activity activity) {
        int i;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics currentWindowMetrics = activity.getWindowManager().getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "getCurrentWindowMetrics(...)");
            WindowInsets windowInsets = currentWindowMetrics.getWindowInsets();
            Intrinsics.checkNotNullExpressionValue(windowInsets, "getWindowInsets(...)");
            Insets insetsIgnoringVisibility = windowInsets.getInsetsIgnoringVisibility(WindowInsets.Type.navigationBars() | WindowInsets.Type.displayCutout());
            Intrinsics.checkNotNullExpressionValue(insetsIgnoringVisibility, "getInsetsIgnoringVisibility(...)");
            int i2 = insetsIgnoringVisibility.right + insetsIgnoringVisibility.left;
            int i3 = insetsIgnoringVisibility.top + insetsIgnoringVisibility.bottom;
            Rect bounds = currentWindowMetrics.getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            int iWidth = bounds.width() - i2;
            int iHeight = bounds.height() - i3;
            point.x = iWidth;
            point.y = iHeight;
            if (Build.VERSION.SDK_INT > 30 && (((i = activity.getResources().getConfiguration().orientation) == 2 && iHeight >= iWidth) || (i == 1 && iWidth >= iHeight))) {
                point.x = iHeight;
                point.y = iWidth;
            }
        } else {
            Object systemService = activity.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).getDefaultDisplay().getSize(point);
        }
        return point;
    }

    public final boolean isPortrait(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Point screenSize = getScreenSize(activity);
        return screenSize.y > screenSize.x;
    }

    public final boolean isLandscape(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return !isPortrait(activity);
    }

    public final boolean isTable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getBoolean(context.getResources().getIdentifier("com_hive_sdk_ui_is_tablet", "bool", context.getPackageName()));
    }

    public final boolean isMobile(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return !isTable(context);
    }

    public final float getFloat(Context context, String name) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        int identifier = context.getResources().getIdentifier(name, "dimen", context.getPackageName());
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(identifier, typedValue, true);
        return typedValue.getFloat();
    }

    public final void setDisplayCutoutNever(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (Build.VERSION.SDK_INT >= 28) {
            rootView.setBackgroundColor(-16777216);
            try {
                DisplayCutout displayCutout = rootView.getRootWindowInsets().getDisplayCutout();
                if (displayCutout != null) {
                    rootView.setPadding(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom());
                }
            } catch (Exception e) {
                Logger.INSTANCE.w("[Util] setDisplayCutoutNever() \ne: " + e.getMessage());
            }
        }
    }

    public final void setOnDisplayCutoutNever(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        if (Build.VERSION.SDK_INT >= 28) {
            rootView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.hive.ui.Util$$ExternalSyntheticLambda1
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return Util.setOnDisplayCutoutNever$lambda$6(view, windowInsets);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets setOnDisplayCutoutNever$lambda$6(View view, WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(windowInsets, "windowInsets");
        INSTANCE.setDisplayCutoutNever(view);
        return windowInsets;
    }

    public final float convertDpToPx(Context context, float dp) {
        Intrinsics.checkNotNullParameter(context, "context");
        return TypedValue.applyDimension(1, dp, context.getResources().getDisplayMetrics());
    }

    public static /* synthetic */ int getSystemScreenOrientation$default(Util util, Activity activity, HiveOrientation hiveOrientation, int i, Object obj) {
        if ((i & 1) != 0) {
            activity = null;
        }
        return util.getSystemScreenOrientation(activity, hiveOrientation);
    }

    public final int getSystemScreenOrientation(Activity activity, HiveOrientation hiveOrientation) {
        Intrinsics.checkNotNullParameter(hiveOrientation, "hiveOrientation");
        int i = WhenMappings.$EnumSwitchMapping$0[hiveOrientation.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return 10;
            }
            if (i != 3) {
                if (i == 4) {
                    return 6;
                }
                if (i == 5) {
                    return -1;
                }
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (activity == null) {
                return 3;
            }
            if (!INSTANCE.isPortrait(activity)) {
                return 6;
            }
        }
        return 7;
    }
}
