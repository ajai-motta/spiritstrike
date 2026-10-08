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
import com.hive.core.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: C5_ChangeNameUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/C5_ChangeNameUi;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "presentName", "", "<init>", "(Landroid/app/Activity;Ljava/lang/String;)V", "inputButton", "Landroid/widget/EditText;", "onActive", "", "onCreate", "activity", "savedInstanceState", "Landroid/os/Bundle;", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C5_ChangeNameUi extends A0_BaseDeviceManagementUi {
    private EditText inputButton;
    private final String presentName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5_ChangeNameUi(Activity parentActivity, String presentName) {
        super(parentActivity, R.layout.hive_device_management_c5_change_name);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
        Intrinsics.checkNotNullParameter(presentName, "presentName");
        this.presentName = presentName;
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void onActive() {
        EditText editText = this.inputButton;
        String strValueOf = String.valueOf(editText != null ? editText.getText() : null);
        if (Intrinsics.areEqual(strValueOf, this.presentName)) {
            Logger.INSTANCE.w("[" + getTag() + "] onActive, input name == present name");
            OnBaseButtonListener listener = getListener();
            if (listener != null) {
                listener.onCancel();
                return;
            }
            return;
        }
        final Bundle bundle = new Bundle();
        bundle.putString("deviceName", strValueOf);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C5_ChangeNameUi$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C5_ChangeNameUi.onActive$lambda$1(this.f$0, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActive$lambda$1(C5_ChangeNameUi c5_ChangeNameUi, Bundle bundle) {
        OnBaseButtonListener listener = c5_ChangeNameUi.getListener();
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
        editText.setText(this.presentName);
        editText.addTextChangedListener(new TextWatcher() { // from class: com.hive.authv4.devicemanagement.ui.C5_ChangeNameUi$onCreate$1$1
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
                C5_ChangeNameUi c5_ChangeNameUi = this.this$0;
                if (c5_ChangeNameUi.getIsActive() != z) {
                    c5_ChangeNameUi.setActive(z);
                    c5_ChangeNameUi.refresh();
                }
            }
        });
        this.inputButton = editText;
        refresh();
    }
}
