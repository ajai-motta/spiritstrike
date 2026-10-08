package com.hive.authv4.devicemanagement.ui;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.authv4.devicemanagement.ui.model.OnPersonalInfoListener;
import com.hive.core.Logger;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: A2_CollectionPersonalInformationUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0017J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0002J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/A2_CollectionPersonalInformationUi;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "isChecked", "", "checkLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "checkButton", "Landroidx/appcompat/widget/AppCompatImageView;", "checkText", "Landroid/widget/TextView;", "moreButton", "show", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "Lcom/hive/authv4/devicemanagement/ui/model/OnPersonalInfoListener;", "refresh", "onMore", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class A2_CollectionPersonalInformationUi extends A0_BaseDeviceManagementUi {
    private AppCompatImageView checkButton;
    private ConstraintLayout checkLayout;
    private TextView checkText;
    private boolean isChecked;
    private AppCompatImageView moreButton;

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    @Deprecated(message = "Override function", replaceWith = @ReplaceWith(expression = "show(listener: OnPersonalInfoListener?)", imports = {}))
    public void show(OnBaseButtonListener listener) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A2_CollectionPersonalInformationUi(Activity parentActivity) {
        super(parentActivity, R.layout.hive_device_management_a2_collection_personal_information);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
    }

    public final void show(OnPersonalInfoListener listener) {
        super.show((OnBaseButtonListener) listener);
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void refresh() {
        if (getIsShowing()) {
            final Activity launchActivity = getLaunchActivity();
            if (launchActivity != null) {
                launchActivity.runOnUiThread(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A2_CollectionPersonalInformationUi$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        A2_CollectionPersonalInformationUi.refresh$lambda$5$lambda$4(this.f$0, launchActivity);
                    }
                });
                return;
            }
            return;
        }
        Logger.INSTANCE.d("[" + getTag() + "] refresh, is not showing");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refresh$lambda$5$lambda$4(A2_CollectionPersonalInformationUi a2_CollectionPersonalInformationUi, Activity activity) {
        if (a2_CollectionPersonalInformationUi.isChecked) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementButtonCheckOn, typedValue, true);
            Drawable drawable = ContextCompat.getDrawable(activity, typedValue.resourceId);
            AppCompatImageView appCompatImageView = a2_CollectionPersonalInformationUi.checkButton;
            if (appCompatImageView != null) {
                appCompatImageView.setImageDrawable(drawable);
            }
        } else {
            TypedValue typedValue2 = new TypedValue();
            activity.getTheme().resolveAttribute(R.attr.hiveDeviceManagementButtonCheckOff, typedValue2, true);
            Drawable drawable2 = ContextCompat.getDrawable(activity, typedValue2.resourceId);
            AppCompatImageView appCompatImageView2 = a2_CollectionPersonalInformationUi.checkButton;
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageDrawable(drawable2);
            }
        }
        a2_CollectionPersonalInformationUi.setActive(a2_CollectionPersonalInformationUi.isChecked);
        super.refresh();
    }

    private final void onMore() {
        OnBaseButtonListener listener = getListener();
        OnPersonalInfoListener onPersonalInfoListener = listener instanceof OnPersonalInfoListener ? (OnPersonalInfoListener) listener : null;
        if (onPersonalInfoListener != null) {
            onPersonalInfoListener.onMore();
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        View viewFindViewById = activity.findViewById(R.id.hive_device_management_check_layout);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        final ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.hive.authv4.devicemanagement.ui.A2_CollectionPersonalInformationUi$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                A2_CollectionPersonalInformationUi.onCreate$lambda$8$lambda$7(constraintLayout, this, view);
            }
        });
        this.checkLayout = constraintLayout;
        View viewFindViewById2 = activity.findViewById(R.id.hive_device_management_btn_check);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        final AppCompatImageView appCompatImageView = (AppCompatImageView) viewFindViewById2;
        TouchEffectKt.setTouchEffect(appCompatImageView, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A2_CollectionPersonalInformationUi$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A2_CollectionPersonalInformationUi.onCreate$lambda$11$lambda$10(appCompatImageView, this, (View) obj);
            }
        } : null);
        this.checkButton = appCompatImageView;
        View viewFindViewById3 = activity.findViewById(R.id.hive_device_management_sub_title);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.TextView");
        final TextView textView = (TextView) viewFindViewById3;
        TouchEffectKt.setVisibleEffect(textView, (28 & 1) != 0 ? 0.0f : 1.0f, (28 & 2) != 0 ? 1.0f : 0.8f, (28 & 4) != 0 ? 150L : 0L, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? 0L : 0L, (28 & 32) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A2_CollectionPersonalInformationUi$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A2_CollectionPersonalInformationUi.onCreate$lambda$14$lambda$13(textView, this, (View) obj);
            }
        } : null);
        this.checkText = textView;
        View viewFindViewById4 = activity.findViewById(R.id.hive_device_management_btn_more);
        Intrinsics.checkNotNull(viewFindViewById4, "null cannot be cast to non-null type androidx.appcompat.widget.AppCompatImageView");
        final AppCompatImageView appCompatImageView2 = (AppCompatImageView) viewFindViewById4;
        TouchEffectKt.setTouchEffect(appCompatImageView2, (63 & 1) != 0 ? Color.argb(117, 0, 0, 0) : 0, (63 & 2) == 0 ? 0 : 0, (63 & 4) != 0 ? 150L : 0L, (63 & 8) != 0 ? null : null, (63 & 16) != 0 ? 0L : 0L, (63 & 32) != 0 ? PorterDuff.Mode.SRC_ATOP : null, (63 & 64) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A2_CollectionPersonalInformationUi$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A2_CollectionPersonalInformationUi.onCreate$lambda$16$lambda$15(appCompatImageView2, this, (View) obj);
            }
        } : null);
        this.moreButton = appCompatImageView2;
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$8$lambda$7(ConstraintLayout constraintLayout, A2_CollectionPersonalInformationUi a2_CollectionPersonalInformationUi, View view) {
        Logger.INSTANCE.d("[DeviceManagement] " + constraintLayout.getTag() + " - checkButton()");
        boolean z = a2_CollectionPersonalInformationUi.isChecked ^ true;
        a2_CollectionPersonalInformationUi.setActive(z);
        a2_CollectionPersonalInformationUi.isChecked = z;
        a2_CollectionPersonalInformationUi.refresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$11$lambda$10(AppCompatImageView appCompatImageView, A2_CollectionPersonalInformationUi a2_CollectionPersonalInformationUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + appCompatImageView.getTag() + " - checkButton()");
        boolean z = a2_CollectionPersonalInformationUi.isChecked ^ true;
        a2_CollectionPersonalInformationUi.setActive(z);
        a2_CollectionPersonalInformationUi.isChecked = z;
        a2_CollectionPersonalInformationUi.refresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$14$lambda$13(TextView textView, A2_CollectionPersonalInformationUi a2_CollectionPersonalInformationUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + textView.getTag() + " - checkText()");
        boolean z = a2_CollectionPersonalInformationUi.isChecked ^ true;
        a2_CollectionPersonalInformationUi.setActive(z);
        a2_CollectionPersonalInformationUi.isChecked = z;
        a2_CollectionPersonalInformationUi.refresh();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$16$lambda$15(AppCompatImageView appCompatImageView, A2_CollectionPersonalInformationUi a2_CollectionPersonalInformationUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + appCompatImageView.getTag() + " - moreButton()");
        a2_CollectionPersonalInformationUi.onMore();
        return Unit.INSTANCE;
    }
}
