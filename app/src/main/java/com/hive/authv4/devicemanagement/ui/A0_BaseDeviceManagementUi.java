package com.hive.authv4.devicemanagement.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.core.Logger;
import com.hive.ui.HiveUiActivity;
import com.hive.ui.OnActivityLifecycle;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: A0_BaseDeviceManagementUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010.\u001a\u00020/2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u00100\u001a\u00020/H\u0016J\b\u00101\u001a\u00020/H\u0016J\b\u00102\u001a\u00020/H\u0016J\b\u00103\u001a\u00020/H\u0016J\b\u00104\u001a\u00020/H\u0016J\u001a\u00105\u001a\u00020/2\u0006\u00106\u001a\u00020\u00032\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u0010\u00109\u001a\u00020/2\u0006\u00106\u001a\u00020\u0003H\u0016J\u0018\u0010:\u001a\u00020/2\u0006\u00106\u001a\u00020\u00032\u0006\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020\u0018H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010&X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*¨\u0006>"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "Lcom/hive/ui/OnActivityLifecycle;", "parentActivity", "Landroid/app/Activity;", "layoutResId", "", "<init>", "(Landroid/app/Activity;I)V", ViewHierarchyConstants.TAG_KEY, "", "getTag", "()Ljava/lang/String;", "launchActivity", "getLaunchActivity", "()Landroid/app/Activity;", "setLaunchActivity", "(Landroid/app/Activity;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "getListener", "()Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", InAppPurchaseConstants.METHOD_SET_LISTENER, "(Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;)V", "value", "", "isShowing", "()Z", "setShowing", "(Z)V", "isActive", "setActive", "closeButton", "Landroidx/appcompat/widget/AppCompatImageView;", "getCloseButton", "()Landroidx/appcompat/widget/AppCompatImageView;", "setCloseButton", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "activeButton", "Landroid/widget/TextView;", "getActiveButton", "()Landroid/widget/TextView;", "setActiveButton", "(Landroid/widget/TextView;)V", "cancelButton", "getCancelButton", "setCancelButton", "show", "", "refresh", "finish", "onActive", "onCancel", "onClose", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onBackPressed", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class A0_BaseDeviceManagementUi extends OnActivityLifecycle {
    private TextView activeButton;
    private TextView cancelButton;
    private AppCompatImageView closeButton;
    private boolean isActive;
    private boolean isShowing;
    private Activity launchActivity;
    private final int layoutResId;
    private OnBaseButtonListener listener;
    private final Activity parentActivity;
    private final String tag;

    public A0_BaseDeviceManagementUi(Activity parentActivity, int i) {
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        this.parentActivity = parentActivity;
        this.layoutResId = i;
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "getSimpleName(...)");
        this.tag = simpleName;
    }

    protected final String getTag() {
        return this.tag;
    }

    protected final Activity getLaunchActivity() {
        return this.launchActivity;
    }

    protected final void setLaunchActivity(Activity activity) {
        this.launchActivity = activity;
    }

    protected OnBaseButtonListener getListener() {
        return this.listener;
    }

    protected void setListener(OnBaseButtonListener onBaseButtonListener) {
        this.listener = onBaseButtonListener;
    }

    /* JADX INFO: renamed from: isShowing, reason: from getter */
    public final boolean getIsShowing() {
        return this.isShowing;
    }

    protected final void setShowing(boolean z) {
        this.isShowing = z;
    }

    /* JADX INFO: renamed from: isActive, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    protected final void setActive(boolean z) {
        this.isActive = z;
    }

    protected final AppCompatImageView getCloseButton() {
        return this.closeButton;
    }

    protected final void setCloseButton(AppCompatImageView appCompatImageView) {
        this.closeButton = appCompatImageView;
    }

    protected final TextView getActiveButton() {
        return this.activeButton;
    }

    protected final void setActiveButton(TextView textView) {
        this.activeButton = textView;
    }

    protected final TextView getCancelButton() {
        return this.cancelButton;
    }

    protected final void setCancelButton(TextView textView) {
        this.cancelButton = textView;
    }

    public static /* synthetic */ void show$default(A0_BaseDeviceManagementUi a0_BaseDeviceManagementUi, OnBaseButtonListener onBaseButtonListener, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
        }
        if ((i & 1) != 0) {
            onBaseButtonListener = null;
        }
        a0_BaseDeviceManagementUi.show(onBaseButtonListener);
    }

    public void show(OnBaseButtonListener listener) {
        Logger.INSTANCE.d("[DeviceManagement] " + this.tag + " - show()");
        if (this.isShowing) {
            return;
        }
        setListener(listener);
        Intent intentPutExtra = new Intent().putExtra(HiveUiActivity.HIVE_UI_ACTIVITY_CHILD_STYLE, "DeviceManagement");
        Intrinsics.checkNotNullExpressionValue(intentPutExtra, "putExtra(...)");
        HiveUiActivity.INSTANCE.launch(this.parentActivity, intentPutExtra, this);
    }

    public void refresh() {
        Logger.INSTANCE.d("[DeviceManagement] " + this.tag + " - refresh()");
        if (this.isShowing) {
            final Activity activity = this.launchActivity;
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        A0_BaseDeviceManagementUi.refresh$lambda$9$lambda$8(this.f$0, activity);
                    }
                });
                return;
            }
            return;
        }
        Logger.INSTANCE.d("[DeviceManagement] " + this.tag + " - refresh, is not showing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$9$lambda$8(A0_BaseDeviceManagementUi a0_BaseDeviceManagementUi, Activity activity) {
        if (a0_BaseDeviceManagementUi.isActive) {
            TextView textView = a0_BaseDeviceManagementUi.activeButton;
            if (textView != null) {
                textView.setEnabled(true);
            }
            Activity activity2 = activity;
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementButtonActive, typedValue, true);
            Drawable drawable = ContextCompat.getDrawable(activity2, typedValue.resourceId);
            TextView textView2 = a0_BaseDeviceManagementUi.activeButton;
            if (textView2 != null) {
                textView2.setBackground(drawable);
            }
            TypedValue typedValue2 = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementFontColorActive, typedValue2, true);
            int color = ContextCompat.getColor(activity2, typedValue2.resourceId);
            TextView textView3 = a0_BaseDeviceManagementUi.activeButton;
            if (textView3 != null) {
                textView3.setTextColor(color);
                return;
            }
            return;
        }
        TextView textView4 = a0_BaseDeviceManagementUi.activeButton;
        if (textView4 != null) {
            textView4.setEnabled(false);
        }
        Activity activity3 = activity;
        TypedValue typedValue3 = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementButtonInActive, typedValue3, true);
        Drawable drawable2 = ContextCompat.getDrawable(activity3, typedValue3.resourceId);
        TextView textView5 = a0_BaseDeviceManagementUi.activeButton;
        if (textView5 != null) {
            textView5.setBackground(drawable2);
        }
        TypedValue typedValue4 = new TypedValue();
        activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementFontColorInActive, typedValue4, true);
        int color2 = ContextCompat.getColor(activity3, typedValue4.resourceId);
        TextView textView6 = a0_BaseDeviceManagementUi.activeButton;
        if (textView6 != null) {
            textView6.setTextColor(color2);
        }
    }

    public void finish() {
        Activity activity = this.launchActivity;
        if (activity != null) {
            activity.finish();
        }
    }

    public void onActive() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                A0_BaseDeviceManagementUi.onActive$lambda$10(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActive$lambda$10(A0_BaseDeviceManagementUi a0_BaseDeviceManagementUi) {
        OnBaseButtonListener listener = a0_BaseDeviceManagementUi.getListener();
        if (listener != null) {
            OnBaseButtonListener.DefaultImpls.onActive$default(listener, null, 1, null);
        } else {
            a0_BaseDeviceManagementUi.finish();
        }
    }

    public void onCancel() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                A0_BaseDeviceManagementUi.onCancel$lambda$11(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCancel$lambda$11(A0_BaseDeviceManagementUi a0_BaseDeviceManagementUi) {
        OnBaseButtonListener listener = a0_BaseDeviceManagementUi.getListener();
        if (listener != null) {
            listener.onCancel();
        } else {
            a0_BaseDeviceManagementUi.finish();
        }
    }

    public void onClose() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                A0_BaseDeviceManagementUi.onClose$lambda$12(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClose$lambda$12(A0_BaseDeviceManagementUi a0_BaseDeviceManagementUi) {
        OnBaseButtonListener listener = a0_BaseDeviceManagementUi.getListener();
        if (listener != null) {
            listener.onClose();
        } else {
            a0_BaseDeviceManagementUi.finish();
        }
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.INSTANCE.d("[DeviceManagement] " + this.tag + " - onCreate()");
        this.launchActivity = activity;
        this.isShowing = true;
        activity.setContentView(this.layoutResId);
        View viewFindViewById = activity.findViewById(R.id.hive_device_management_button_close);
        TextView textView = null;
        final AppCompatImageView appCompatImageView = viewFindViewById instanceof AppCompatImageView ? (AppCompatImageView) viewFindViewById : null;
        if (appCompatImageView != null) {
            TouchEffectKt.setVisibleEffect(appCompatImageView, (28 & 1) != 0 ? 0.0f : 1.0f, (28 & 2) != 0 ? 1.0f : 0.8f, (28 & 4) != 0 ? 150L : 0L, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? 0L : 0L, (28 & 32) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return A0_BaseDeviceManagementUi.onCreate$lambda$14$lambda$13(appCompatImageView, this, (View) obj);
                }
            } : null);
        } else {
            appCompatImageView = null;
        }
        this.closeButton = appCompatImageView;
        View viewFindViewById2 = activity.findViewById(R.id.hive_device_management_active_button);
        final TextView textView2 = viewFindViewById2 instanceof TextView ? (TextView) viewFindViewById2 : null;
        if (textView2 != null) {
            this.isActive = textView2.isEnabled();
            TouchEffectKt.setTouchEffect(textView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return A0_BaseDeviceManagementUi.onCreate$lambda$16$lambda$15(textView2, this, (View) obj);
                }
            } : null);
        } else {
            textView2 = null;
        }
        this.activeButton = textView2;
        View viewFindViewById3 = activity.findViewById(R.id.hive_device_management_cancel_button);
        final TextView textView3 = viewFindViewById3 instanceof TextView ? (TextView) viewFindViewById3 : null;
        if (textView3 != null) {
            TouchEffectKt.setTouchEffect(textView3, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : Color.argb(117, 255, 255, 255), (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return A0_BaseDeviceManagementUi.onCreate$lambda$18$lambda$17(textView3, this, (View) obj);
                }
            } : null);
            textView = textView3;
        }
        this.cancelButton = textView;
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$14$lambda$13(AppCompatImageView appCompatImageView, A0_BaseDeviceManagementUi a0_BaseDeviceManagementUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + appCompatImageView.getTag() + " - closeButton()");
        a0_BaseDeviceManagementUi.onClose();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$16$lambda$15(TextView textView, A0_BaseDeviceManagementUi a0_BaseDeviceManagementUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + textView.getTag() + " - activeButton()");
        a0_BaseDeviceManagementUi.onActive();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$18$lambda$17(TextView textView, A0_BaseDeviceManagementUi a0_BaseDeviceManagementUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + textView.getTag() + " - cancelButton()");
        a0_BaseDeviceManagementUi.onCancel();
        return Unit.INSTANCE;
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.INSTANCE.d("[DeviceManagement] " + this.tag + " - onDestroy()");
        if (!getIsCalledFinish() && !getIsRecreated()) {
            onClose();
        }
        this.isShowing = false;
        this.launchActivity = null;
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        Logger.INSTANCE.d("[DeviceManagement] " + this.tag + " - onConfigurationChanged()");
        activity.recreate();
    }

    @Override // com.hive.ui.OnActivityLifecycle
    public boolean onBackPressed() {
        Logger.INSTANCE.d("[DeviceManagement] " + this.tag + " - onBackPressed()");
        onCancel();
        return true;
    }
}
