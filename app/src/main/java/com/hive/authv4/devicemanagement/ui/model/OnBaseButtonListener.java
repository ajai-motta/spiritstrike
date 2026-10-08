package com.hive.authv4.devicemanagement.ui.model;

import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: compiled from: OnBaseButtonListener.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, d2 = {"Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "", "onActive", "", "summit", "Landroid/os/Bundle;", "onCancel", "onClose", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OnBaseButtonListener {
    void onActive(Bundle summit);

    void onCancel();

    void onClose();

    /* JADX INFO: compiled from: OnBaseButtonListener.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void onActive$default(OnBaseButtonListener onBaseButtonListener, Bundle bundle, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onActive");
            }
            if ((i & 1) != 0) {
                bundle = null;
            }
            onBaseButtonListener.onActive(bundle);
        }
    }
}
