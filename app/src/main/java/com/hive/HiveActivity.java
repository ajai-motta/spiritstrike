package com.hive;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.emoji2.text.EmojiCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.analytics.AnalyticsImpl;
import com.hive.core.HiveCoreInitializer;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.Resource;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001>B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0007J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u001a\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u001a\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0007J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0007J$\u0010\"\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010#\u001a\u0004\u0018\u00010$H\u0007J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0007J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u001cH\u0007J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0007J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0007J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0005H\u0007J\u0018\u0010+\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u000bH\u0007J*\u0010-\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u00010\u001fH\u0007J3\u00102\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010.\u001a\u00020/2\f\u00103\u001a\b\u0012\u0004\u0012\u000205042\u0006\u00106\u001a\u000207H\u0007¢\u0006\u0002\u00108J\u0018\u00109\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010:\u001a\u00020;H\u0007J \u0010<\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020;H\u0007R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\n\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/hive/HiveActivity;", "", "<init>", "()V", "recentActivity", "Landroid/app/Activity;", "getRecentActivity", "()Landroid/app/Activity;", "setRecentActivity", "(Landroid/app/Activity;)V", "isActivityInitialized", "", "isActivityInitialized$annotations", "()Z", "onActivityLifecycleList", "", "Lcom/hive/ui/OnActivityLifecycle;", "registerHiveActivityLifecycleListeners", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterHiveActivityLifecycleListeners", "attachBaseContext", "Landroid/content/ContextWrapper;", "newBase", "Landroid/content/Context;", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onRestart", "onStart", "onRestoreInstanceState", "persistentState", "Landroid/os/PersistableBundle;", "onResume", "onSaveInstanceState", "outState", "onPause", "onStop", "onDestroy", "onWindowFocusChanged", "hasFocus", "onActivityResult", "requestCode", "", "resultCode", "data", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(Landroid/app/Activity;I[Ljava/lang/String;[I)V", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "HiveActivityLifecycleCallbacks", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveActivity {
    public static final HiveActivity INSTANCE = new HiveActivity();
    private static final Set<OnActivityLifecycle> onActivityLifecycleList = new LinkedHashSet();
    public static Activity recentActivity;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0010"}, d2 = {"Lcom/hive/HiveActivity$HiveActivityLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "<init>", "()V", "onActivityCreated", "", "p0", "Landroid/app/Activity;", "p1", "Landroid/os/Bundle;", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "onActivityDestroyed", "onActivitySaveInstanceState", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class HiveActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity p0, Bundle p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity p0, Bundle p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            AnalyticsImpl.INSTANCE.activateConCurrentUserLog();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                return;
            }
            AnalyticsImpl.INSTANCE.deactivateConcurrentUserLog();
        }
    }

    private HiveActivity() {
    }

    @Deprecated(message = "24.3.0")
    @JvmStatic
    public static final ContextWrapper attachBaseContext(Context newBase) {
        Intrinsics.checkNotNullParameter(newBase, "newBase");
        HiveCoreInitializer.Companion companion = HiveCoreInitializer.INSTANCE;
        if (!companion.isInitContextInitialized()) {
            companion.setInitContext(newBase.getApplicationContext());
        }
        return new ContextWrapper(newBase);
    }

    public static final boolean isActivityInitialized() {
        return recentActivity != null;
    }

    @JvmStatic
    public static /* synthetic */ void isActivityInitialized$annotations() {
    }

    @JvmStatic
    public static final void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onActivityResult");
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onActivityResult(activity, requestCode, resultCode, data);
        }
    }

    @JvmStatic
    public static final void onConfigurationChanged(Activity activity, android.content.res.Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onConfigurationChanged");
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onConfigurationChanged(activity, newConfig);
        }
        AnalyticsImpl.INSTANCE.sendDeviceInfoLog();
    }

    @JvmStatic
    public static final void onCreate(Activity activity, Bundle savedInstanceState) {
        Object objM7415constructorimpl;
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onCreate");
        INSTANCE.setRecentActivity(activity);
        activity.getTheme().applyStyle(Resource.getHiveStyleId$default(Resource.INSTANCE, activity, null, 2, null), true);
        activity.getApplication().registerActivityLifecycleCallbacks(new HiveActivityLifecycleCallbacks());
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onCreate(activity, savedInstanceState);
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(Class.forName("androidx.emoji2.text.EmojiCompat"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM7415constructorimpl = Result.m7415constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m7422isSuccessimpl(objM7415constructorimpl)) {
            EmojiCompat.init(activity.getApplicationContext());
        }
    }

    @JvmStatic
    public static final void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onDestroy");
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onDestroy(activity);
        }
    }

    @JvmStatic
    public static final void onMultiWindowModeChanged(Activity activity, boolean isInMultiWindowMode, android.content.res.Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onMultiWindowModeChanged");
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onMultiWindowModeChanged(activity, isInMultiWindowMode, newConfig);
        }
    }

    @JvmStatic
    public static final void onNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onNewIntent");
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onNewIntent(activity, intent);
        }
    }

    @JvmStatic
    public static final void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onPause");
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onPause(activity);
        }
    }

    @JvmStatic
    public static final void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onRequestPermissionsResult");
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onRequestPermissionsResult(activity, requestCode, permissions, grantResults);
        }
    }

    @JvmStatic
    public static final void onRestart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onRestart");
        INSTANCE.setRecentActivity(activity);
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onRestart(activity);
        }
    }

    @JvmStatic
    public static final void onRestoreInstanceState(Activity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onRestoreInstanceState");
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onRestoreInstanceState(activity, savedInstanceState, persistentState);
        }
    }

    @JvmStatic
    public static final void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onResume");
        INSTANCE.setRecentActivity(activity);
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onResume(activity);
        }
    }

    @JvmStatic
    public static final void onSaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onSaveInstanceState");
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onSaveInstanceState(activity, outState);
        }
    }

    @JvmStatic
    public static final void onStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onStart");
        INSTANCE.setRecentActivity(activity);
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onStart(activity);
        }
    }

    @JvmStatic
    public static final void onStop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onStop");
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onStop(activity);
        }
    }

    @JvmStatic
    public static final void onWindowFocusChanged(Activity activity, boolean hasFocus) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.hive.core.Logger.INSTANCE.d("[HiveActivity] onWindowFocusChanged");
        Iterator<T> it = onActivityLifecycleList.iterator();
        while (it.hasNext()) {
            ((OnActivityLifecycle) it.next()).onWindowFocusChanged(activity, hasFocus);
        }
    }

    @JvmStatic
    public static final void registerHiveActivityLifecycleListeners(OnActivityLifecycle listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        onActivityLifecycleList.add(listener);
    }

    @JvmStatic
    public static final void unregisterHiveActivityLifecycleListeners(OnActivityLifecycle listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        onActivityLifecycleList.remove(listener);
    }

    public final Activity getRecentActivity() {
        Activity activity = recentActivity;
        if (activity != null) {
            return activity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recentActivity");
        return null;
    }

    public final void setRecentActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        recentActivity = activity;
    }
}
