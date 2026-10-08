package com.hive.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HiveUiActivity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J$\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u0010H\u0016J\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u001f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#H\u0016J3\u0010&\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020-H\u0016¢\u0006\u0002\u0010.J*\u0010/\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(2\u0006\u00100\u001a\u00020(2\b\u00101\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u00102\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\b¨\u00063"}, d2 = {"Lcom/hive/ui/OnActivityLifecycle;", "", "<init>", "()V", "isCalledFinish", "", "()Z", "setCalledFinish", "(Z)V", "isRecreated", "setRecreated", "onCreate", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onRestart", "onStart", "onNewIntent", "intent", "Landroid/content/Intent;", "onRestoreInstanceState", "persistentState", "Landroid/os/PersistableBundle;", "onResume", "onSaveInstanceState", "outState", "onPause", "onStop", "onDestroy", "onWindowFocusChanged", "hasFocus", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onMultiWindowModeChanged", "isInMultiWindowMode", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(Landroid/app/Activity;I[Ljava/lang/String;[I)V", "onActivityResult", "resultCode", "data", "onBackPressed", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class OnActivityLifecycle {
    private boolean isCalledFinish;
    private boolean isRecreated;

    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onMultiWindowModeChanged(Activity activity, boolean isInMultiWindowMode, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    public void onNewIntent(Activity activity, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
    }

    public void onRestart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onRestoreInstanceState(Activity activity, Bundle savedInstanceState, PersistableBundle persistentState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onSaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    public void onStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onStop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onWindowFocusChanged(Activity activity, boolean hasFocus) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX INFO: renamed from: isCalledFinish, reason: from getter */
    public final boolean getIsCalledFinish() {
        return this.isCalledFinish;
    }

    public final void setCalledFinish(boolean z) {
        this.isCalledFinish = z;
    }

    /* JADX INFO: renamed from: isRecreated, reason: from getter */
    public final boolean getIsRecreated() {
        return this.isRecreated;
    }

    public final void setRecreated(boolean z) {
        this.isRecreated = z;
    }
}
