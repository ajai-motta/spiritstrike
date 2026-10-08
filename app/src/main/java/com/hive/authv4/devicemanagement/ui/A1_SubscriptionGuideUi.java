package com.hive.authv4.devicemanagement.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hive.authv4.devicemanagement.R;
import com.hive.core.Logger;
import com.hive.ui.effect.TouchEffectKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: A1_SubscriptionGuideUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/A1_SubscriptionGuideUi;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "popupBoard", "Landroidx/constraintlayout/widget/ConstraintLayout;", "isPopupBoardVisible", "", "onCreate", "", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class A1_SubscriptionGuideUi extends A0_BaseDeviceManagementUi {
    private boolean isPopupBoardVisible;
    private ConstraintLayout popupBoard;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$1$lambda$0(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A1_SubscriptionGuideUi(Activity parentActivity) {
        super(parentActivity, R.layout.hive_device_management_a1_subscription_guide);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        View viewFindViewById = activity.findViewById(R.id.hive_device_management_popup_board);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        ConstraintLayout constraintLayout = (ConstraintLayout) viewFindViewById;
        constraintLayout.setOnTouchListener(new View.OnTouchListener() { // from class: com.hive.authv4.devicemanagement.ui.A1_SubscriptionGuideUi$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return A1_SubscriptionGuideUi.onCreate$lambda$1$lambda$0(view, motionEvent);
            }
        });
        constraintLayout.setVisibility(this.isPopupBoardVisible ? 0 : 8);
        this.popupBoard = constraintLayout;
        View viewFindViewById2 = activity.findViewById(R.id.hive_device_management_button_question);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        final ImageView imageView = (ImageView) viewFindViewById2;
        TouchEffectKt.setVisibleEffect(imageView, (28 & 1) != 0 ? 0.0f : 1.0f, (28 & 2) != 0 ? 1.0f : 0.8f, (28 & 4) != 0 ? 150L : 0L, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? 0L : 0L, (28 & 32) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A1_SubscriptionGuideUi$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A1_SubscriptionGuideUi.onCreate$lambda$3$lambda$2(imageView, this, (View) obj);
            }
        } : null);
        View viewFindViewById3 = activity.findViewById(R.id.hive_device_management_btn_close);
        Intrinsics.checkNotNull(viewFindViewById3, "null cannot be cast to non-null type android.widget.ImageView");
        final ImageView imageView2 = (ImageView) viewFindViewById3;
        TouchEffectKt.setVisibleEffect(imageView2, (28 & 1) != 0 ? 0.0f : 1.0f, (28 & 2) != 0 ? 1.0f : 0.8f, (28 & 4) != 0 ? 150L : 0L, (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? 0L : 0L, (28 & 32) == 0 ? new Function1() { // from class: com.hive.authv4.devicemanagement.ui.A1_SubscriptionGuideUi$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A1_SubscriptionGuideUi.onCreate$lambda$5$lambda$4(imageView2, this, (View) obj);
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3$lambda$2(ImageView imageView, A1_SubscriptionGuideUi a1_SubscriptionGuideUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + imageView.getTag() + " - questionButton()");
        a1_SubscriptionGuideUi.isPopupBoardVisible = true;
        ConstraintLayout constraintLayout = a1_SubscriptionGuideUi.popupBoard;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$5$lambda$4(ImageView imageView, A1_SubscriptionGuideUi a1_SubscriptionGuideUi, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Logger.INSTANCE.d("[DeviceManagement] " + imageView.getTag() + " - questionButton()");
        a1_SubscriptionGuideUi.isPopupBoardVisible = false;
        ConstraintLayout constraintLayout = a1_SubscriptionGuideUi.popupBoard;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public boolean onBackPressed() {
        Logger.INSTANCE.d("[DeviceManagement] " + getTag() + " - onBackPressed()");
        ConstraintLayout constraintLayout = this.popupBoard;
        if (constraintLayout != null && constraintLayout.getVisibility() == 0) {
            this.isPopupBoardVisible = false;
            ConstraintLayout constraintLayout2 = this.popupBoard;
            if (constraintLayout2 == null) {
                return true;
            }
            constraintLayout2.setVisibility(8);
            return true;
        }
        onCancel();
        return true;
    }
}
