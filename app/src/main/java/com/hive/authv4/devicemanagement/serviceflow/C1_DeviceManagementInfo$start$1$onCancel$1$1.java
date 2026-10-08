package com.hive.authv4.devicemanagement.serviceflow;

import android.os.Bundle;
import com.hive.authv4.devicemanagement.DeviceManagementNetwork;
import com.hive.authv4.devicemanagement.ui.B5_RepeatedPhoneNumberRequestErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.C3_VerificationCodeLimitErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.C7_ServiceCancellationGuideUi;
import com.hive.authv4.devicemanagement.ui.C8_ServiceCancellationCompleteUi;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.protocol.authv4.DeviceDeleteUser;
import com.hive.protocol.authv4.SmsSend;
import com.hive.standalone.HiveLifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: C1_DeviceManagementInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/hive/authv4/devicemanagement/serviceflow/C1_DeviceManagementInfo$start$1$onCancel$1$1", "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "onActive", "", "summit", "Landroid/os/Bundle;", "onCancel", "onClose", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C1_DeviceManagementInfo$start$1$onCancel$1$1 implements OnBaseButtonListener {
    final /* synthetic */ C7_ServiceCancellationGuideUi $c7;
    final /* synthetic */ C1_DeviceManagementInfo this$0;

    C1_DeviceManagementInfo$start$1$onCancel$1$1(C1_DeviceManagementInfo c1_DeviceManagementInfo, C7_ServiceCancellationGuideUi c7_ServiceCancellationGuideUi) {
        this.this$0 = c1_DeviceManagementInfo;
        this.$c7 = c7_ServiceCancellationGuideUi;
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onActive(Bundle summit) {
        DeviceManagementNetwork deviceManagementNetwork = DeviceManagementNetwork.INSTANCE;
        HiveLifecycle.HiveAccount hiveAccount = this.this$0.account;
        final C1_DeviceManagementInfo c1_DeviceManagementInfo = this.this$0;
        final C7_ServiceCancellationGuideUi c7_ServiceCancellationGuideUi = this.$c7;
        deviceManagementNetwork.smsSend(hiveAccount, null, null, "device/delete-user", new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onCancel$1$1$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return C1_DeviceManagementInfo$start$1$onCancel$1$1.onActive$lambda$7(c1_DeviceManagementInfo, c7_ServiceCancellationGuideUi, (SmsSend.SmsSendResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActive$lambda$7(final C1_DeviceManagementInfo c1_DeviceManagementInfo, C7_ServiceCancellationGuideUi c7_ServiceCancellationGuideUi, SmsSend.SmsSendResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccess()) {
            new A4_VerifyIdentity(c1_DeviceManagementInfo.activity, c1_DeviceManagementInfo.account, c1_DeviceManagementInfo.phoneCode, c1_DeviceManagementInfo.phoneNumber, "device/delete-user", response.getSignature(), false, new Function2() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onCancel$1$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return C1_DeviceManagementInfo$start$1$onCancel$1$1.onActive$lambda$7$lambda$3(c1_DeviceManagementInfo, ((Boolean) obj).booleanValue(), (String) obj2);
                }
            }).start();
            c7_ServiceCancellationGuideUi.finish();
        } else {
            int resultCode = response.getResultCode();
            if (resultCode == 3005) {
                final C3_VerificationCodeLimitErrorGuideUi c3_VerificationCodeLimitErrorGuideUi = new C3_VerificationCodeLimitErrorGuideUi(c1_DeviceManagementInfo.activity);
                c3_VerificationCodeLimitErrorGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onCancel$1$1$onActive$1$2$1
                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onActive(Bundle summit) {
                        c3_VerificationCodeLimitErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onCancel() {
                        c3_VerificationCodeLimitErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onClose() {
                        c1_DeviceManagementInfo.getC1().onClose();
                        c3_VerificationCodeLimitErrorGuideUi.finish();
                    }
                });
            } else if (resultCode == 3017) {
                final B5_RepeatedPhoneNumberRequestErrorGuideUi b5_RepeatedPhoneNumberRequestErrorGuideUi = new B5_RepeatedPhoneNumberRequestErrorGuideUi(c1_DeviceManagementInfo.activity);
                b5_RepeatedPhoneNumberRequestErrorGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onCancel$1$1$onActive$1$3$1
                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onActive(Bundle summit) {
                        b5_RepeatedPhoneNumberRequestErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onCancel() {
                        b5_RepeatedPhoneNumberRequestErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onClose() {
                        c1_DeviceManagementInfo.getC1().onClose();
                        b5_RepeatedPhoneNumberRequestErrorGuideUi.finish();
                    }
                });
            } else {
                c1_DeviceManagementInfo.error(String.valueOf(response.getResultCode()), new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onCancel$1$1$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return C1_DeviceManagementInfo$start$1$onCancel$1$1.onActive$lambda$7$lambda$6(c1_DeviceManagementInfo, ((Boolean) obj).booleanValue());
                    }
                });
            }
            c7_ServiceCancellationGuideUi.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActive$lambda$7$lambda$3(final C1_DeviceManagementInfo c1_DeviceManagementInfo, boolean z, String str) {
        if (z && str != null) {
            DeviceManagementNetwork.INSTANCE.deviceDeleteUser(c1_DeviceManagementInfo.account, str, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onCancel$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return C1_DeviceManagementInfo$start$1$onCancel$1$1.onActive$lambda$7$lambda$3$lambda$2(c1_DeviceManagementInfo, (DeviceDeleteUser.DeviceDeleteUserResponse) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActive$lambda$7$lambda$3$lambda$2(final C1_DeviceManagementInfo c1_DeviceManagementInfo, DeviceDeleteUser.DeviceDeleteUserResponse deviceDeleteUserResponse) {
        Intrinsics.checkNotNullParameter(deviceDeleteUserResponse, "deviceDeleteUserResponse");
        if (deviceDeleteUserResponse.isSuccess()) {
            final C8_ServiceCancellationCompleteUi c8_ServiceCancellationCompleteUi = new C8_ServiceCancellationCompleteUi(c1_DeviceManagementInfo.activity);
            c8_ServiceCancellationCompleteUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onCancel$1$1$onActive$1$1$1$1$1
                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onActive(Bundle summit) {
                    c1_DeviceManagementInfo.setNeedCheckDevice(true);
                    c1_DeviceManagementInfo.setNeedCheckPhone(true);
                    c1_DeviceManagementInfo.getC1().onClose();
                    c8_ServiceCancellationCompleteUi.finish();
                }

                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onCancel() {
                    c1_DeviceManagementInfo.setNeedCheckDevice(true);
                    c1_DeviceManagementInfo.setNeedCheckPhone(true);
                    c1_DeviceManagementInfo.getC1().onClose();
                    c8_ServiceCancellationCompleteUi.finish();
                }

                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onClose() {
                    c1_DeviceManagementInfo.setNeedCheckDevice(true);
                    c1_DeviceManagementInfo.setNeedCheckPhone(true);
                    c1_DeviceManagementInfo.getC1().onClose();
                    c8_ServiceCancellationCompleteUi.finish();
                }
            });
        } else {
            c1_DeviceManagementInfo.error(String.valueOf(deviceDeleteUserResponse.getResultCode()), new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onCancel$1$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return C1_DeviceManagementInfo$start$1$onCancel$1$1.onActive$lambda$7$lambda$3$lambda$2$lambda$1(c1_DeviceManagementInfo, ((Boolean) obj).booleanValue());
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActive$lambda$7$lambda$3$lambda$2$lambda$1(C1_DeviceManagementInfo c1_DeviceManagementInfo, boolean z) {
        if (!z) {
            c1_DeviceManagementInfo.getC1().onClose();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActive$lambda$7$lambda$6(C1_DeviceManagementInfo c1_DeviceManagementInfo, boolean z) {
        if (!z) {
            c1_DeviceManagementInfo.getC1().onClose();
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onCancel() {
        this.$c7.finish();
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onClose() {
        this.this$0.getC1().onClose();
        this.$c7.finish();
    }
}
