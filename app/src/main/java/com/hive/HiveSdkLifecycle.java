package com.hive;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.Process;
import android.view.Window;
import com.hive.auth.AuthImpl;
import com.hive.authv4.AuthV4Impl;
import com.hive.authv4.provider.AuthV4ProviderAdapter;
import com.hive.base.Android;
import com.hive.configuration.ConfigurationImpl;
import com.hive.logger.LoggerImpl;
import com.hive.module.HiveModule;
import com.hive.module.HiveModuleManager;
import com.hive.module.interfaces.GoogleBase;
import com.hive.module.interfaces.HiveAnalytics;
import com.hive.platformhelper.PlatformHelperImpl;
import com.hive.push.PushImpl;
import com.hive.socialv4.provider.SocialV4ProviderAdapter;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.Util;
import java.lang.Thread;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\nH\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J*\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0016J3\u0010!\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010%\u001a\u00020&H\u0016¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010)\u001a\u00020*H\u0016J \u0010+\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\u0010\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\u0006H\u0016¨\u00064"}, d2 = {"Lcom/hive/HiveSdkLifecycle;", "Lcom/hive/ui/OnActivityLifecycle;", "Lcom/hive/standalone/HiveLifecycle$HiveLifecycleListener;", "<init>", "()V", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "onRestart", "onStart", "onRestoreInstanceState", "persistentState", "Landroid/os/PersistableBundle;", "onResume", "onSaveInstanceState", "outState", "onPause", "onStop", "onDestroy", "onWindowFocusChanged", "hasFocus", "", "onActivityResult", "requestCode", "", "resultCode", "data", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(Landroid/app/Activity;I[Ljava/lang/String;[I)V", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "onSetupFinished", "onInitializeFinished", "onSignIn", "hiveAccount", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "onSignOut", "onReset", "hive-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HiveSdkLifecycle extends OnActivityLifecycle implements HiveLifecycle.HiveLifecycleListener {
    public static final HiveSdkLifecycle INSTANCE = new HiveSdkLifecycle();

    private HiveSdkLifecycle() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(Activity activity, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = HiveAnalytics.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof HiveAnalytics)) {
            hiveModule = null;
        }
        HiveAnalytics hiveAnalytics = (HiveAnalytics) (hiveModule instanceof HiveAnalytics ? hiveModule : null);
        if (hiveAnalytics != null) {
            hiveAnalytics.onPause(activity);
        }
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        th.printStackTrace();
        Process.killProcess(Process.myPid());
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onResume$lambda$1(String str, Boolean bool) {
        Android.INSTANCE.updateAdvertisingId(str, bool);
        return Unit.INSTANCE;
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AuthImpl.INSTANCE.onActivityResult(activity, requestCode, resultCode, data);
        PlatformHelperImpl.INSTANCE.onActivityResult(activity, requestCode, resultCode, data);
        AuthV4ProviderAdapter.INSTANCE.onActivityResult(requestCode, resultCode, data);
        SocialV4ProviderAdapter.INSTANCE.onActivityResult(requestCode, resultCode, data);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onAgreement() {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onAgreement(this);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onConfigurationChanged(Activity activity, android.content.res.Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onCreate(final Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Util util = Util.INSTANCE;
        Window window = activity.getWindow();
        util.setOnSystemUiVisibilityChangeListener(window != null ? window.getDecorView() : null);
        Configuration.setContext(activity);
        PushImpl.INSTANCE.onCreate(activity, savedInstanceState);
        AuthV4ProviderAdapter.INSTANCE.onActivityCreated(activity, savedInstanceState);
        SocialV4ProviderAdapter.INSTANCE.onActivityCreated(activity, savedInstanceState);
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.hive.HiveSdkLifecycle$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                HiveSdkLifecycle.onCreate$lambda$0(activity, defaultUncaughtExceptionHandler, thread, th);
            }
        });
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PushImpl.INSTANCE.onDestroy(activity);
        AuthV4ProviderAdapter.INSTANCE.onActivityDestroyed();
        SocialV4ProviderAdapter.INSTANCE.onActivityDestroyed();
        HiveLifecycle.unregisterNetworkCallback$hive_service_release$default(HiveLifecycle.INSTANCE, null, null, 3, null);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onInitializeFinished() {
        if (ConfigurationImpl.INSTANCE.getUseHercules()) {
            try {
                Class.forName("com.hive.hercules.HerculesInitializer");
            } catch (Exception e) {
                LoggerImpl.INSTANCE.e("MainActivity", "[onInitializeFinished] Hercules is not found. " + e);
                Android.INSTANCE.finish();
            }
        }
        PushImpl.INSTANCE.initialize(HiveLifecycle.INSTANCE.getRecentHiveAccount());
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onMultiWindowModeChanged(Activity activity, boolean isInMultiWindowMode, android.content.res.Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onNetworkAvailable(boolean z) {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onNetworkAvailable(this, z);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AuthV4ProviderAdapter.INSTANCE.onActivityNewIntent(intent);
        SocialV4ProviderAdapter.INSTANCE.onActivityNewIntent(intent);
        PushImpl.INSTANCE.onNewIntent(activity, intent);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        PushImpl.INSTANCE.onPause(activity);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onProcessUri(String str) {
        HiveLifecycle.HiveLifecycleListener.DefaultImpls.onProcessUri(this, str);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        AuthImpl.INSTANCE.onRequestPermissionsResult(activity, requestCode, permissions, grantResults);
        PlatformHelperImpl.INSTANCE.onRequestPermissionsResult(activity, requestCode, permissions, grantResults);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onReset() {
        AuthImpl.INSTANCE.memoryReset$hive_service_release();
        AuthV4Impl.INSTANCE.memoryReset$hive_service_release();
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onRestart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onRestoreInstanceState(Activity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        HiveModuleManager hiveModuleManager = HiveModuleManager.INSTANCE;
        String name = GoogleBase.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        HiveModule hiveModule = hiveModuleManager.getHiveModule(name);
        if (!(hiveModule instanceof GoogleBase)) {
            hiveModule = null;
        }
        GoogleBase googleBase = (GoogleBase) (hiveModule instanceof GoogleBase ? hiveModule : null);
        if (googleBase != null) {
            googleBase.getAdvertisingClientInfo(activity, new Function2() { // from class: com.hive.HiveSdkLifecycle$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HiveSdkLifecycle.onResume$lambda$1((String) obj, (Boolean) obj2);
                }
            });
        }
        AuthV4ProviderAdapter.INSTANCE.onActivityResumed(activity);
        SocialV4ProviderAdapter.INSTANCE.onActivityResumed(activity);
        PushImpl.INSTANCE.onResume(activity);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onSaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        AuthV4ProviderAdapter.INSTANCE.onActivitySaveInstanceState(outState);
        SocialV4ProviderAdapter.INSTANCE.onActivitySaveInstanceState(outState);
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onSetupFinished() {
        if (ConfigurationImpl.INSTANCE.getUseHercules()) {
            try {
                Class.forName("com.hive.hercules.HerculesInitializer");
            } catch (Exception e) {
                LoggerImpl.INSTANCE.e("MainActivity", "[onSetupFinished] Hercules is not found. " + e);
                Android.INSTANCE.finish();
            }
        }
        if (ConfigurationImpl.INSTANCE.getAgeGateU13(Android.HW_IDS_DEVICE_TOKEN)) {
            return;
        }
        PushImpl.INSTANCE.initialize(HiveLifecycle.INSTANCE.getRecentHiveAccount());
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onSignIn(HiveLifecycle.HiveAccount hiveAccount) {
        Intrinsics.checkNotNullParameter(hiveAccount, "hiveAccount");
        PushImpl.INSTANCE.onLogin();
    }

    @Override // com.hive.standalone.HiveLifecycle.HiveLifecycleListener
    public void onSignOut() {
        PushImpl.INSTANCE.onLogout();
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AuthImpl.INSTANCE.onStart(activity);
        AuthV4Impl.INSTANCE.onStart(activity);
        AuthV4ProviderAdapter.INSTANCE.onActivityStarted();
        SocialV4ProviderAdapter.INSTANCE.onActivityStarted();
        PushImpl.INSTANCE.onStart(activity);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onStop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        AuthImpl.INSTANCE.onStop(activity);
        AuthV4Impl.INSTANCE.onStop(activity);
        AuthV4ProviderAdapter.INSTANCE.onActivityStopped();
        SocialV4ProviderAdapter.INSTANCE.onActivityStopped();
        PushImpl.INSTANCE.onStop(activity);
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onWindowFocusChanged(Activity activity, boolean hasFocus) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }
}
