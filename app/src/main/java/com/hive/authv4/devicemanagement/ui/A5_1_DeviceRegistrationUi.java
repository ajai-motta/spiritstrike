package com.hive.authv4.devicemanagement.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: A5_1_DeviceRegistrationUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/A5_1_DeviceRegistrationUi;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "defaultDeviceName", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "inputButton", "Landroid/widget/EditText;", "onActive", "", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class A5_1_DeviceRegistrationUi extends A0_BaseDeviceManagementUi {
    private final String defaultDeviceName;
    private EditText inputButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A5_1_DeviceRegistrationUi(Activity parentActivity, String defaultDeviceName) {
        super(parentActivity, R.layout.hive_device_management_a5_1_device_registration);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(defaultDeviceName, "defaultDeviceName");
        this.defaultDeviceName = defaultDeviceName;
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void onActive() {
        EditText editText = this.inputButton;
        String strValueOf = String.valueOf(editText != null ? editText.getText() : null);
        final Bundle bundle = new Bundle();
        bundle.putString("deviceName", strValueOf);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.A5_1_DeviceRegistrationUi$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                A5_1_DeviceRegistrationUi.onActive$lambda$1(this.f$0, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActive$lambda$1(A5_1_DeviceRegistrationUi a5_1_DeviceRegistrationUi, Bundle bundle) {
        OnBaseButtonListener listener = a5_1_DeviceRegistrationUi.getListener();
        if (listener != null) {
            listener.onActive(bundle);
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi, com.hive.ui.OnActivityLifecycle
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onCreate(activity, savedInstanceState);
        View viewFindViewById = activity.findViewById(R.id.hive_device_management_button_input);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.EditText");
        EditText editText = (EditText) viewFindViewById;
        editText.addTextChangedListener(new TextWatcher() { // from class: com.hive.authv4.devicemanagement.ui.A5_1_DeviceRegistrationUi$onCreate$1$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable s) {
                boolean z = false;
                if (s != null && (!StringsKt.isBlank(s))) {
                    z = true;
                }
                A5_1_DeviceRegistrationUi a5_1_DeviceRegistrationUi = this.this$0;
                if (a5_1_DeviceRegistrationUi.getIsActive() != z) {
                    a5_1_DeviceRegistrationUi.setActive(z);
                    a5_1_DeviceRegistrationUi.refresh();
                }
            }
        });
        editText.setText(this.defaultDeviceName);
        this.inputButton = editText;
        refresh();
    }
}
