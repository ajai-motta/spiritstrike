package com.hive.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.hive.core.Configuration;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveContext;
import com.hive.core.Logger;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.common.controller.HiveUiOrientationController;
import com.hive.ui.common.controller.HiveUiOrientationHelper;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.security.SecureRandom;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveUiActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\b\u0016\u0018\u0000 H2\u00020\u00012\u00020\u0002:\u0001HB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\u0012\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001bH\u0014J\b\u0010\"\u001a\u00020\u001bH\u0014J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0014J\u001c\u0010&\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001bH\u0014J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020 H\u0014J\b\u0010,\u001a\u00020\u001bH\u0014J\b\u0010-\u001a\u00020\u001bH\u0014J\b\u0010.\u001a\u00020\u001bH\u0014J\u0010\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u0015H\u0016J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\u00152\u0006\u00102\u001a\u000203H\u0017J+\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\t2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u0006092\u0006\u0010:\u001a\u00020;H\u0016¢\u0006\u0002\u0010<J\"\u0010=\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\t2\u0006\u0010>\u001a\u00020\t2\b\u0010?\u001a\u0004\u0018\u00010%H\u0015J\b\u0010@\u001a\u00020\u001bH\u0017J\b\u0010A\u001a\u00020\u001bH\u0016J\b\u0010B\u001a\u00020\u001bH\u0016J\u0010\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020\tH\u0002J\u0010\u0010E\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020\tH\u0016J\b\u0010G\u001a\u00020\u001bH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006I"}, d2 = {"Lcom/hive/ui/HiveUiActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/hive/ui/common/controller/HiveUiOrientationController;", "<init>", "()V", ViewHierarchyConstants.TAG_KEY, "", "kotlin.jvm.PlatformType", "activityIndex", "", "getActivityIndex", "()I", "activityIndex$delegate", "Lkotlin/Lazy;", "orientationHelper", "Lcom/hive/ui/common/controller/HiveUiOrientationHelper;", "getOrientationHelper", "()Lcom/hive/ui/common/controller/HiveUiOrientationHelper;", "setOrientationHelper", "(Lcom/hive/ui/common/controller/HiveUiOrientationHelper;)V", "hasCutoutLetterbox", "", "getHasCutoutLetterbox", "()Z", "setHasCutoutLetterbox", "(Z)V", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRestart", "onStart", "onNewIntent", "intent", "Landroid/content/Intent;", "onRestoreInstanceState", "persistentState", "Landroid/os/PersistableBundle;", "onResume", "onSaveInstanceState", "outState", "onPause", "onStop", "onDestroy", "onWindowFocusChanged", "hasFocus", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onActivityResult", "resultCode", "data", "onBackPressed", "finish", "recreate", "setOrientation", AdUnitActivity.EXTRA_ORIENTATION, "lockOrientation", "targetOrientation", "unlockOrientation", k.M, "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class HiveUiActivity extends AppCompatActivity implements HiveUiOrientationController {
    public static final String HIVE_UI_ACTIVITY_CHILD_STYLE = "hive_ui_activity_child_style";
    public static final String HIVE_UI_ACTIVITY_CUSTOM_CLASS = "hive_ui_activity_custom_class";
    private static final String HIVE_UI_ACTIVITY_INDEX = "hive_ui_activity_index";
    public static final String HIVE_UI_ACTIVITY_ORIENTATION = "hive_ui_activity_orientation";
    public static final String IS_HIVE_UI_NOT_CLEAR_BACKGROUND = "hive_ui_clear_background";
    private boolean hasCutoutLetterbox;
    public HiveUiOrientationHelper orientationHelper;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final SparseArray<OnActivityLifecycle> HiveUiActivityListenerArray = new SparseArray<>();
    private final String tag = "HiveUiActivity";

    /* JADX INFO: renamed from: activityIndex$delegate, reason: from kotlin metadata */
    private final Lazy activityIndex = LazyKt.lazy(new Function0() { // from class: com.hive.ui.HiveUiActivity$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Integer.valueOf(HiveUiActivity.activityIndex_delegate$lambda$0(this.f$0));
        }
    });

    /* JADX INFO: compiled from: HiveUiActivity.kt */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u0006J*\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u0006J5\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0018H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/hive/ui/HiveUiActivity$Companion;", "", "<init>", "()V", "HiveUiActivityListenerArray", "Landroid/util/SparseArray;", "Lcom/hive/ui/OnActivityLifecycle;", "HIVE_UI_ACTIVITY_INDEX", "", "IS_HIVE_UI_NOT_CLEAR_BACKGROUND", "HIVE_UI_ACTIVITY_ORIENTATION", "HIVE_UI_ACTIVITY_CHILD_STYLE", "HIVE_UI_ACTIVITY_CUSTOM_CLASS", "launch", "", "context", "Landroid/content/Context;", "onActivityLifecycle", "intent", "Landroid/content/Intent;", "launchForResult", "activity", "Landroid/app/Activity;", "requestCode", "", "innerLaunchForResult", "(Landroid/content/Context;Landroid/content/Intent;Ljava/lang/Integer;Lcom/hive/ui/OnActivityLifecycle;)V", "getUniqueIndex", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch(Context context, OnActivityLifecycle onActivityLifecycle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onActivityLifecycle, "onActivityLifecycle");
            innerLaunchForResult(context, null, null, onActivityLifecycle);
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, Intent intent, OnActivityLifecycle onActivityLifecycle, int i, Object obj) {
            if ((i & 2) != 0) {
                intent = null;
            }
            companion.launch(context, intent, onActivityLifecycle);
        }

        public final void launch(Context context, Intent intent, OnActivityLifecycle onActivityLifecycle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(onActivityLifecycle, "onActivityLifecycle");
            innerLaunchForResult(context, intent, null, onActivityLifecycle);
        }

        public static /* synthetic */ void launchForResult$default(Companion companion, Activity activity, Intent intent, int i, OnActivityLifecycle onActivityLifecycle, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                intent = null;
            }
            companion.launchForResult(activity, intent, i, onActivityLifecycle);
        }

        public final void launchForResult(Activity activity, Intent intent, int requestCode, OnActivityLifecycle onActivityLifecycle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(onActivityLifecycle, "onActivityLifecycle");
            innerLaunchForResult(activity, intent, Integer.valueOf(requestCode), onActivityLifecycle);
        }

        static /* synthetic */ void innerLaunchForResult$default(Companion companion, Context context, Intent intent, Integer num, OnActivityLifecycle onActivityLifecycle, int i, Object obj) {
            if ((i & 2) != 0) {
                intent = null;
            }
            if ((i & 4) != 0) {
                num = null;
            }
            companion.innerLaunchForResult(context, intent, num, onActivityLifecycle);
        }

        private final void innerLaunchForResult(final Context context, Intent intent, final Integer requestCode, OnActivityLifecycle onActivityLifecycle) {
            int uniqueIndex = getUniqueIndex();
            HiveUiActivity.HiveUiActivityListenerArray.append(uniqueIndex, onActivityLifecycle);
            final Intent intent2 = intent != null ? new Intent(intent) : new Intent();
            if (!intent2.getBooleanExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CUSTOM_CLASS, false)) {
                if (intent2.getBooleanExtra(HiveUiActivity.IS_HIVE_UI_NOT_CLEAR_BACKGROUND, false)) {
                    Intrinsics.checkNotNull(intent2.setClass(context, HiveUiNonClearActivity.class));
                } else {
                    Intrinsics.checkNotNull(intent2.setClass(context, HiveUiActivity.class));
                }
            }
            intent2.addFlags(268435456);
            intent2.putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_INDEX, uniqueIndex);
            boolean z = context instanceof Activity;
            intent2.putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_ORIENTATION, intent2.getIntExtra(HiveUiActivity.HIVE_UI_ACTIVITY_ORIENTATION, Util.INSTANCE.getSystemScreenOrientation(z ? (Activity) context : null, Configuration.INSTANCE.getHiveOrientation())));
            if (z && requestCode != null) {
                ((Activity) context).runOnUiThread(new Runnable() { // from class: com.hive.ui.HiveUiActivity$Companion$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        HiveUiActivity.Companion.innerLaunchForResult$lambda$0(context, intent2, requestCode);
                    }
                });
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.ui.HiveUiActivity$Companion$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ExtentionsKt.startActivityCatching$default(context, intent2, null, 2, null);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void innerLaunchForResult$lambda$0(Context context, Intent intent, Integer num) {
            ExtentionsKt.startActivityForResultCatching$default((Activity) context, intent, num.intValue(), null, 4, null);
        }

        private final int getUniqueIndex() {
            int iNextInt;
            do {
                iNextInt = new SecureRandom().nextInt(65500);
            } while (HiveUiActivity.HiveUiActivityListenerArray.get(iNextInt) != null);
            return iNextInt;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int activityIndex_delegate$lambda$0(HiveUiActivity hiveUiActivity) {
        return hiveUiActivity.getIntent().getIntExtra(HIVE_UI_ACTIVITY_INDEX, 0);
    }

    private final int getActivityIndex() {
        return ((Number) this.activityIndex.getValue()).intValue();
    }

    public final HiveUiOrientationHelper getOrientationHelper() {
        HiveUiOrientationHelper hiveUiOrientationHelper = this.orientationHelper;
        if (hiveUiOrientationHelper != null) {
            return hiveUiOrientationHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("orientationHelper");
        return null;
    }

    public final void setOrientationHelper(HiveUiOrientationHelper hiveUiOrientationHelper) {
        Intrinsics.checkNotNullParameter(hiveUiOrientationHelper, "<set-?>");
        this.orientationHelper = hiveUiOrientationHelper;
    }

    public final boolean getHasCutoutLetterbox() {
        return this.hasCutoutLetterbox;
    }

    public final void setHasCutoutLetterbox(boolean z) {
        this.hasCutoutLetterbox = z;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - attachBaseContext()");
        if (newBase != null) {
            super.attachBaseContext(HiveContext.INSTANCE.wrap(newBase, Configuration.INSTANCE.getGameLanguage()));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onCreate()");
        Window window = getWindow();
        if (window != null) {
            window.addFlags(128);
        }
        int intExtra = getIntent().getIntExtra(HIVE_UI_ACTIVITY_ORIENTATION, 3);
        setOrientation(intExtra);
        HiveUiActivity hiveUiActivity = this;
        setOrientationHelper(new HiveUiOrientationHelper(hiveUiActivity, intExtra));
        if (getIntent().getBooleanExtra(IS_HIVE_UI_NOT_CLEAR_BACKGROUND, false)) {
            Util util = Util.INSTANCE;
            View decorView = getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            util.setDisplayCutoutNever(decorView);
            Util util2 = Util.INSTANCE;
            View decorView2 = getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView2, "getDecorView(...)");
            util2.setOnDisplayCutoutNever(decorView2);
            this.hasCutoutLetterbox = true;
            setTheme(R.style.HiveNonClearTheme);
        } else {
            setTheme(R.style.HiveTheme);
            getTheme().applyStyle(R.style.Theme_Hive_AppCompat_Translucent, true);
        }
        getTheme().applyStyle(Resource.INSTANCE.getHiveStyleId(this, getIntent().getStringExtra(HIVE_UI_ACTIVITY_CHILD_STYLE)), false);
        super.onCreate(savedInstanceState);
        SparseArray<OnActivityLifecycle> sparseArray = HiveUiActivityListenerArray;
        OnActivityLifecycle onActivityLifecycle = sparseArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onCreate(hiveUiActivity, savedInstanceState);
        } else {
            finish();
        }
        OnActivityLifecycle onActivityLifecycle2 = sparseArray.get(getActivityIndex());
        if (onActivityLifecycle2 != null) {
            onActivityLifecycle2.setRecreated(false);
        }
        if (Build.VERSION.SDK_INT >= 34) {
            overrideActivityTransition(0, 0, 0);
        } else {
            overridePendingTransition(0, 0);
        }
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        Util.INSTANCE.hideSystemUI(getWindow());
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), this, false, new Function1() { // from class: com.hive.ui.HiveUiActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HiveUiActivity.onCreate$lambda$2(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2(HiveUiActivity hiveUiActivity, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        Logger.INSTANCE.d(hiveUiActivity.tag, hiveUiActivity.tag + ' ' + addCallback.hashCode() + " - onBackPressedDispatcher()");
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(hiveUiActivity.getActivityIndex());
        if (onActivityLifecycle != null && !onActivityLifecycle.onBackPressed()) {
            addCallback.setEnabled(false);
            hiveUiActivity.getOnBackPressedDispatcher().onBackPressed();
        }
        return Unit.INSTANCE;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onRestart()");
        super.onRestart();
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onRestart(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onStart()");
        super.onStart();
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onStart(this);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onNewIntent()");
        super.onNewIntent(intent);
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onNewIntent(this, intent);
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onRestoreInstanceState()");
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onRestoreInstanceState(this, savedInstanceState, persistentState);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onResume()");
        super.onResume();
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onResume(this);
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onSaveInstanceState()");
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onSaveInstanceState(this, outState);
        }
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onPause()");
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onPause(this);
        }
        super.onPause();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onStop()");
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onStop(this);
        }
        super.onStop();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onDestroy()");
        SparseArray<OnActivityLifecycle> sparseArray = HiveUiActivityListenerArray;
        OnActivityLifecycle onActivityLifecycle = sparseArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onDestroy(this);
            if (!onActivityLifecycle.getIsRecreated()) {
                sparseArray.delete(getActivityIndex());
            }
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean hasFocus) {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onWindowFocusChanged() " + hasFocus);
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            Util.INSTANCE.hideSystemUI(getWindow());
        }
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onWindowFocusChanged(this, hasFocus);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onConfigurationChanged()");
        super.onConfigurationChanged(newConfig);
        getResources().getConfiguration().setTo(newConfig);
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onConfigurationChanged(this, newConfig);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, android.content.res.Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onMultiWindowModeChanged()");
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onMultiWindowModeChanged(this, isInMultiWindowMode, newConfig);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onRequestPermissionsResult()");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onActivityResult(" + requestCode + ", " + resultCode + ", " + data + ')');
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.onActivityResult(this, requestCode, resultCode, data);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onBackPressed() {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - onBackPressed()");
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle == null || onActivityLifecycle.onBackPressed()) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void finish() {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - finish()");
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.setCalledFinish(true);
        }
        super.finish();
        if (Build.VERSION.SDK_INT >= 34) {
            overrideActivityTransition(1, 0, 0);
        } else {
            overridePendingTransition(0, 0);
        }
        getOrientationHelper().destroy();
    }

    @Override // android.app.Activity
    public void recreate() {
        Logger.INSTANCE.d(this.tag, this.tag + ' ' + hashCode() + " - recreate()");
        OnActivityLifecycle onActivityLifecycle = HiveUiActivityListenerArray.get(getActivityIndex());
        if (onActivityLifecycle != null) {
            onActivityLifecycle.setRecreated(true);
        }
        super.recreate();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void setOrientation(int r5) {
        /*
            r4 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L1b
            r0 = r4
            com.hive.ui.HiveUiActivity r0 = (com.hive.ui.HiveUiActivity) r0     // Catch: java.lang.Throwable -> L1b
            if (r5 == 0) goto L10
            r0 = 1
            if (r5 == r0) goto Le
            switch(r5) {
                case 6: goto L10;
                case 7: goto Le;
                case 8: goto L10;
                case 9: goto Le;
                default: goto Ld;
            }     // Catch: java.lang.Throwable -> L1b
        Ld:
            goto L11
        Le:
            r5 = 7
            goto L11
        L10:
            r5 = 6
        L11:
            r4.setRequestedOrientation(r5)     // Catch: java.lang.Throwable -> L1b
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L1b
            java.lang.Object r5 = kotlin.Result.m7415constructorimpl(r5)     // Catch: java.lang.Throwable -> L1b
            goto L26
        L1b:
            r5 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m7415constructorimpl(r5)
        L26:
            java.lang.Throwable r5 = kotlin.Result.m7418exceptionOrNullimpl(r5)
            if (r5 == 0) goto L55
            com.hive.core.Logger r0 = com.hive.core.Logger.INSTANCE
            java.lang.String r1 = r4.tag
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r4.tag
            r2.append(r3)
            r3 = 32
            r2.append(r3)
            int r3 = r4.hashCode()
            r2.append(r3)
            java.lang.String r3 = " - setOrientation() failed: "
            r2.append(r3)
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r0.w(r1, r5)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hive.ui.HiveUiActivity.setOrientation(int):void");
    }

    @Override // com.hive.ui.common.controller.HiveUiOrientationController
    public void lockOrientation(int targetOrientation) {
        getOrientationHelper().lock(targetOrientation);
    }

    @Override // com.hive.ui.common.controller.HiveUiOrientationController
    public void unlockOrientation() {
        getOrientationHelper().unlock();
    }
}
