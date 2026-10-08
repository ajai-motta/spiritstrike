package com.hive.authv4.devicemanagement.ui.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: OnManagementInfoListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/model/OnManagementInfoListener;", "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "onEdit", "", "deviceInfo", "Lcom/hive/authv4/devicemanagement/ui/model/DeviceInfo;", "onDelete", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OnManagementInfoListener extends OnBaseButtonListener {
    void onDelete(DeviceInfo deviceInfo);

    void onEdit(DeviceInfo deviceInfo);
}
