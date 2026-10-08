package com.hive.authv4.devicemanagement.serviceflow;

import android.app.Activity;
import android.os.Bundle;
import androidx.autofill.HintConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.ui.B2_DevicesExceededGuideUi;
import com.hive.authv4.devicemanagement.ui.model.DeviceInfo;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.standalone.HiveLifecycle;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: B2_DevicesExceeded.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u00128\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0019\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/hive/authv4/devicemanagement/serviceflow/B2_DevicesExceeded;", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "phoneCode", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "deviceInfoList", "", "Lcom/hive/authv4/devicemanagement/ui/model/DeviceInfo;", "maxDeviceCount", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "needCheckPhone", "", "<init>", "(Landroid/app/Activity;Lcom/hive/standalone/HiveLifecycle$HiveAccount;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILkotlin/jvm/functions/Function2;)V", "callback", TtmlNode.START, "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class B2_DevicesExceeded {
    private final HiveLifecycle.HiveAccount account;
    private final Activity activity;
    private final List<DeviceInfo> deviceInfoList;
    private Function2<? super Boolean, ? super Boolean, Unit> listener;
    private final int maxDeviceCount;
    private final String phoneCode;
    private final String phoneNumber;

    public B2_DevicesExceeded(Activity activity, HiveLifecycle.HiveAccount account, String phoneCode, String phoneNumber, List<DeviceInfo> deviceInfoList, int i, Function2<? super Boolean, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(phoneCode, "phoneCode");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(deviceInfoList, "deviceInfoList");
        this.activity = activity;
        this.account = account;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.deviceInfoList = deviceInfoList;
        this.maxDeviceCount = i;
        this.listener = function2;
    }

    public final void callback(boolean isSuccess, boolean needCheckPhone) {
        Function2<? super Boolean, ? super Boolean, Unit> function2 = this.listener;
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(isSuccess), Boolean.valueOf(needCheckPhone));
        }
        this.listener = null;
    }

    public final void start() {
        final B2_DevicesExceededGuideUi b2_DevicesExceededGuideUi = new B2_DevicesExceededGuideUi(this.activity);
        b2_DevicesExceededGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.B2_DevicesExceeded$start$1$1
            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                new C1_DeviceManagementInfo(this.this$0.activity, this.this$0.account, this.this$0.phoneCode, this.this$0.phoneNumber, this.this$0.deviceInfoList, this.this$0.maxDeviceCount, this.this$0.listener).start();
                b2_DevicesExceededGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                this.this$0.callback(false, false);
                b2_DevicesExceededGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                this.this$0.callback(false, false);
                b2_DevicesExceededGuideUi.finish();
            }
        });
    }
}
