package com.hive.authv4.devicemanagement.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;
import androidx.autofill.HintConstants;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: C10_ChangeMobilePhoneNo1Ui.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/C10_ChangeMobilePhoneNo1Ui;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "hiddenPhoneNumberText", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "Landroid/widget/TextView;", "onActive", "", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C10_ChangeMobilePhoneNo1Ui extends A0_BaseDeviceManagementUi {
    private final String hiddenPhoneNumberText;
    private TextView phoneNumber;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10_ChangeMobilePhoneNo1Ui(Activity parentActivity, String hiddenPhoneNumberText) {
        super(parentActivity, R.layout.hive_device_management_c10_change_mobile_phone_no_1);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(hiddenPhoneNumberText, "hiddenPhoneNumberText");
        this.hiddenPhoneNumberText = hiddenPhoneNumberText;
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void onActive() {
        final Bundle bundle = new Bundle();
        bundle.putString("blindPhoneNumber", this.hiddenPhoneNumberText);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C10_ChangeMobilePhoneNo1Ui$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C10_ChangeMobilePhoneNo1Ui.onActive$lambda$1(this.f$0, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActive$lambda$1(C10_ChangeMobilePhoneNo1Ui c10_ChangeMobilePhoneNo1Ui, Bundle bundle) {
        OnBaseButtonListener listener = c10_ChangeMobilePhoneNo1Ui.getListener();
        if (listener != null) {
            listener.onActive(bundle);
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        View viewFindViewById = activity.findViewById(R.id.hive_device_management_phone_number);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) viewFindViewById;
        textView.setText(this.hiddenPhoneNumberText);
        this.phoneNumber = textView;
        refresh();
    }
}
