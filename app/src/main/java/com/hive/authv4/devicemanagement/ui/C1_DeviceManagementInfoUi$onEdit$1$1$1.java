package com.hive.authv4.devicemanagement.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.hive.authv4.devicemanagement.ui.model.DeviceInfo;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.authv4.devicemanagement.ui.model.OnManagementInfoListener;
import kotlin.Metadata;

/* JADX INFO: compiled from: C1_DeviceManagementInfoUi.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi$onEdit$1$1$1", "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "onActive", "", "summit", "Landroid/os/Bundle;", "onCancel", "onClose", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C1_DeviceManagementInfoUi$onEdit$1$1$1 implements OnBaseButtonListener {
    final /* synthetic */ DeviceInfo $deviceInfo;
    final /* synthetic */ C5_ChangeNameUi $it;
    final /* synthetic */ C1_DeviceManagementInfoUi this$0;

    C1_DeviceManagementInfoUi$onEdit$1$1$1(DeviceInfo deviceInfo, C5_ChangeNameUi c5_ChangeNameUi, C1_DeviceManagementInfoUi c1_DeviceManagementInfoUi) {
        this.$deviceInfo = deviceInfo;
        this.$it = c5_ChangeNameUi;
        this.this$0 = c1_DeviceManagementInfoUi;
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onActive(Bundle summit) {
        String string;
        final DeviceInfo deviceInfoCopy$default = DeviceInfo.copy$default(this.$deviceInfo, null, null, null, (summit == null || (string = summit.getString("deviceName", "")) == null) ? "" : string, null, 23, null);
        Handler handler = new Handler(Looper.getMainLooper());
        final C1_DeviceManagementInfoUi c1_DeviceManagementInfoUi = this.this$0;
        handler.post(new Runnable() { // from class: com.hive.authv4.devicemanagement.ui.C1_DeviceManagementInfoUi$onEdit$1$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C1_DeviceManagementInfoUi$onEdit$1$1$1.onActive$lambda$0(c1_DeviceManagementInfoUi, deviceInfoCopy$default);
            }
        });
        this.$it.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActive$lambda$0(C1_DeviceManagementInfoUi c1_DeviceManagementInfoUi, DeviceInfo deviceInfo) {
        OnBaseButtonListener listener = c1_DeviceManagementInfoUi.getListener();
        OnManagementInfoListener onManagementInfoListener = listener instanceof OnManagementInfoListener ? (OnManagementInfoListener) listener : null;
        if (onManagementInfoListener != null) {
            onManagementInfoListener.onEdit(deviceInfo);
        }
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onCancel() {
        this.$it.finish();
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onClose() {
        this.$it.finish();
    }
}
