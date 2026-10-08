package com.hive.authv4.devicemanagement.serviceflow;

import android.os.Bundle;
import com.hive.authv4.devicemanagement.DeviceManagementNetwork;
import com.hive.authv4.devicemanagement.ui.B4_SignUpLimitErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.B5_RepeatedPhoneNumberRequestErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.C10_ChangeMobilePhoneNo1Ui;
import com.hive.authv4.devicemanagement.ui.C3_VerificationCodeLimitErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.protocol.authv4.SmsSend;
import com.hive.standalone.HiveLifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: C1_DeviceManagementInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/hive/authv4/devicemanagement/serviceflow/C1_DeviceManagementInfo$start$1$onActive$1$1", "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "onActive", "", "summit", "Landroid/os/Bundle;", "onCancel", "onClose", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C1_DeviceManagementInfo$start$1$onActive$1$1 implements OnBaseButtonListener {
    final /* synthetic */ C10_ChangeMobilePhoneNo1Ui $c10;
    final /* synthetic */ C1_DeviceManagementInfo this$0;

    C1_DeviceManagementInfo$start$1$onActive$1$1(C1_DeviceManagementInfo c1_DeviceManagementInfo, C10_ChangeMobilePhoneNo1Ui c10_ChangeMobilePhoneNo1Ui) {
        this.this$0 = c1_DeviceManagementInfo;
        this.$c10 = c10_ChangeMobilePhoneNo1Ui;
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onActive(Bundle summit) {
        DeviceManagementNetwork deviceManagementNetwork = DeviceManagementNetwork.INSTANCE;
        HiveLifecycle.HiveAccount hiveAccount = this.this$0.account;
        final C1_DeviceManagementInfo c1_DeviceManagementInfo = this.this$0;
        final C10_ChangeMobilePhoneNo1Ui c10_ChangeMobilePhoneNo1Ui = this.$c10;
        deviceManagementNetwork.smsSend(hiveAccount, null, null, "device/modify-user", new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onActive$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return C1_DeviceManagementInfo$start$1$onActive$1$1.onActive$lambda$5(c1_DeviceManagementInfo, c10_ChangeMobilePhoneNo1Ui, (SmsSend.SmsSendResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActive$lambda$5(final C1_DeviceManagementInfo c1_DeviceManagementInfo, C10_ChangeMobilePhoneNo1Ui c10_ChangeMobilePhoneNo1Ui, SmsSend.SmsSendResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.isSuccess()) {
            new C11_ChangeMobilePhoneNo2(c1_DeviceManagementInfo.activity, c1_DeviceManagementInfo.account, c1_DeviceManagementInfo.phoneCode, c1_DeviceManagementInfo.phoneNumber, response.getSignature(), new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onActive$1$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return C1_DeviceManagementInfo$start$1$onActive$1$1.onActive$lambda$5$lambda$0(c1_DeviceManagementInfo, (Boolean) obj);
                }
            }).start();
        } else {
            int resultCode = response.getResultCode();
            if (resultCode == 3005) {
                final C3_VerificationCodeLimitErrorGuideUi c3_VerificationCodeLimitErrorGuideUi = new C3_VerificationCodeLimitErrorGuideUi(c1_DeviceManagementInfo.activity);
                c3_VerificationCodeLimitErrorGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onActive$1$1$onActive$1$2$1
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
                b5_RepeatedPhoneNumberRequestErrorGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onActive$1$1$onActive$1$3$1
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
            } else if (resultCode == 3105) {
                final B4_SignUpLimitErrorGuideUi b4_SignUpLimitErrorGuideUi = new B4_SignUpLimitErrorGuideUi(c1_DeviceManagementInfo.activity);
                b4_SignUpLimitErrorGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onActive$1$1$onActive$1$4$1
                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onActive(Bundle summit) {
                        c1_DeviceManagementInfo.callback(false);
                        b4_SignUpLimitErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onCancel() {
                        c1_DeviceManagementInfo.callback(false);
                        b4_SignUpLimitErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onClose() {
                        c1_DeviceManagementInfo.callback(false);
                        b4_SignUpLimitErrorGuideUi.finish();
                    }
                });
            } else {
                c1_DeviceManagementInfo.error(String.valueOf(response.getResultCode()), new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$onActive$1$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return C1_DeviceManagementInfo$start$1$onActive$1$1.onActive$lambda$5$lambda$4(c1_DeviceManagementInfo, ((Boolean) obj).booleanValue());
                    }
                });
            }
        }
        c10_ChangeMobilePhoneNo1Ui.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActive$lambda$5$lambda$0(C1_DeviceManagementInfo c1_DeviceManagementInfo, Boolean bool) {
        if (bool == null) {
            c1_DeviceManagementInfo.getC1().onClose();
        } else if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            c1_DeviceManagementInfo.setNeedCheckDevice(true);
            c1_DeviceManagementInfo.setNeedCheckPhone(true);
            c1_DeviceManagementInfo.getC1().onClose();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onActive$lambda$5$lambda$4(C1_DeviceManagementInfo c1_DeviceManagementInfo, boolean z) {
        if (!z) {
            c1_DeviceManagementInfo.getC1().onClose();
        }
        return Unit.INSTANCE;
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onCancel() {
        this.$c10.finish();
    }

    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
    public void onClose() {
        this.this$0.getC1().onClose();
        this.$c10.finish();
    }
}
