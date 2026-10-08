package com.hive.authv4.devicemanagement.ui;

import android.app.Activity;
import com.hive.authv4.devicemanagement.R;
import com.hive.core.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: C2_DeleteGuideUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/C2_DeleteGuideUi;", "Lcom/hive/authv4/devicemanagement/ui/A0_BaseDeviceManagementUi;", "parentActivity", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "refresh", "", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C2_DeleteGuideUi extends A0_BaseDeviceManagementUi {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2_DeleteGuideUi(Activity parentActivity) {
        super(parentActivity, R.layout.hive_device_management_c2_delete_guide);
        Intrinsics.checkNotNullParameter(parentActivity, "parentActivity");
    }

    @Override // com.hive.authv4.devicemanagement.ui.A0_BaseDeviceManagementUi
    public void refresh() {
        Logger.INSTANCE.d("[DeviceManagement] " + getTag() + " - refresh()");
    }
}
