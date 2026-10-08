package com.hive.authv4.devicemanagement.serviceflow;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import androidx.autofill.HintConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.DeviceManagement;
import com.hive.authv4.devicemanagement.DeviceManagementNetwork;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice;
import com.hive.authv4.devicemanagement.ui.A5_2_RegistrationGuideUi;
import com.hive.authv4.devicemanagement.ui.A6_ErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.A7_TimeoutGuideUi;
import com.hive.authv4.devicemanagement.ui.B1_NotRegisteredGuideUi;
import com.hive.authv4.devicemanagement.ui.B3_VerificationCodeLimitErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.B4_SignUpLimitErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.B5_RepeatedPhoneNumberRequestErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.authv4.devicemanagement.ui.model.OnErrorGuideListener;
import com.hive.base.Android;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveContext;
import com.hive.protocol.UrlManager;
import com.hive.protocol.authv4.DeviceAdd;
import com.hive.protocol.authv4.SmsSend;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.Date;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: B1_NotRegisteredDevice.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eBG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\rJ\b\u0010\u0017\u001a\u00020\rH\u0002J$\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u000bH\u0002J$\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u000bH\u0002J$\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\r0\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/hive/authv4/devicemanagement/serviceflow/B1_NotRegisteredDevice;", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "phoneCode", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, InAppPurchaseMetaData.KEY_SIGNATURE, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "", "<init>", "(Landroid/app/Activity;Lcom/hive/standalone/HiveLifecycle$HiveAccount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "b1", "Lcom/hive/authv4/devicemanagement/ui/B1_NotRegisteredGuideUi;", "getB1", "()Lcom/hive/authv4/devicemanagement/ui/B1_NotRegisteredGuideUi;", "callback", "b", TtmlNode.START, "smsSend", "deviceAdd", "verifySignature", "Lcom/hive/authv4/devicemanagement/serviceflow/B1_NotRegisteredDevice$Button;", "error", "errorCode", "timeout", "Button", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class B1_NotRegisteredDevice {
    private final HiveLifecycle.HiveAccount account;
    private final Activity activity;
    private final B1_NotRegisteredGuideUi b1;
    private Function1<? super Boolean, Unit> listener;
    private final String phoneCode;
    private final String phoneNumber;
    private final String signature;

    /* JADX INFO: compiled from: B1_NotRegisteredDevice.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Button.values().length];
            try {
                iArr[Button.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Button.Cancel.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Button.Close.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public B1_NotRegisteredDevice(Activity activity, HiveLifecycle.HiveAccount account, String phoneCode, String phoneNumber, String str, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(phoneCode, "phoneCode");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        this.activity = activity;
        this.account = account;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.signature = str;
        this.listener = function1;
        this.b1 = new B1_NotRegisteredGuideUi(activity);
    }

    public final B1_NotRegisteredGuideUi getB1() {
        return this.b1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: B1_NotRegisteredDevice.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/hive/authv4/devicemanagement/serviceflow/B1_NotRegisteredDevice$Button;", "", "<init>", "(Ljava/lang/String;I)V", "Active", "Cancel", "Close", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final class Button {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Button[] $VALUES;
        public static final Button Active = new Button("Active", 0);
        public static final Button Cancel = new Button("Cancel", 1);
        public static final Button Close = new Button("Close", 2);

        private static final /* synthetic */ Button[] $values() {
            return new Button[]{Active, Cancel, Close};
        }

        public static EnumEntries<Button> getEntries() {
            return $ENTRIES;
        }

        private Button(String str, int i) {
        }

        static {
            Button[] buttonArr$values = $values();
            $VALUES = buttonArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(buttonArr$values);
        }

        public static Button valueOf(String str) {
            return (Button) Enum.valueOf(Button.class, str);
        }

        public static Button[] values() {
            return (Button[]) $VALUES.clone();
        }
    }

    public final void callback(boolean b) {
        Function1<? super Boolean, Unit> function1 = this.listener;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(b));
        }
        this.listener = null;
    }

    /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: B1_NotRegisteredDevice.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/hive/authv4/devicemanagement/serviceflow/B1_NotRegisteredDevice$start$1", "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "onActive", "", "summit", "Landroid/os/Bundle;", "onCancel", "onClose", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements OnBaseButtonListener {

        /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$start$1$WhenMappings */
        /* JADX INFO: compiled from: B1_NotRegisteredDevice.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Button.values().length];
                try {
                    iArr[Button.Active.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Button.Cancel.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Button.Close.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        AnonymousClass1() {
        }

        @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
        public void onActive(Bundle summit) {
            String str = B1_NotRegisteredDevice.this.signature;
            if (str == null || StringsKt.isBlank(str)) {
                B1_NotRegisteredDevice.this.smsSend();
                return;
            }
            B1_NotRegisteredDevice b1_NotRegisteredDevice = B1_NotRegisteredDevice.this;
            String str2 = b1_NotRegisteredDevice.signature;
            final B1_NotRegisteredDevice b1_NotRegisteredDevice2 = B1_NotRegisteredDevice.this;
            b1_NotRegisteredDevice.deviceAdd(str2, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$start$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return B1_NotRegisteredDevice.AnonymousClass1.onActive$lambda$0(b1_NotRegisteredDevice2, (B1_NotRegisteredDevice.Button) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onActive$lambda$0(B1_NotRegisteredDevice b1_NotRegisteredDevice, Button b) {
            Intrinsics.checkNotNullParameter(b, "b");
            int i = WhenMappings.$EnumSwitchMapping$0[b.ordinal()];
            if (i == 1) {
                b1_NotRegisteredDevice.callback(true);
                b1_NotRegisteredDevice.getB1().finish();
            } else if (i == 2) {
                b1_NotRegisteredDevice.smsSend();
            } else {
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                b1_NotRegisteredDevice.callback(false);
                b1_NotRegisteredDevice.getB1().finish();
            }
            return Unit.INSTANCE;
        }

        @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
        public void onCancel() {
            B1_NotRegisteredDevice.this.callback(false);
            B1_NotRegisteredDevice.this.getB1().finish();
        }

        @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
        public void onClose() {
            B1_NotRegisteredDevice.this.callback(false);
            B1_NotRegisteredDevice.this.getB1().finish();
        }
    }

    public final void start() {
        this.b1.show(new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void smsSend() {
        DeviceManagementNetwork.INSTANCE.smsSend(this.account, null, null, "device/add", new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return B1_NotRegisteredDevice.smsSend$lambda$7(this.f$0, (SmsSend.SmsSendResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsSend$lambda$7(final B1_NotRegisteredDevice b1_NotRegisteredDevice, SmsSend.SmsSendResponse sendResponse) {
        Intrinsics.checkNotNullParameter(sendResponse, "sendResponse");
        if (sendResponse.isSuccess()) {
            new A4_VerifyIdentity(b1_NotRegisteredDevice.activity, b1_NotRegisteredDevice.account, b1_NotRegisteredDevice.phoneCode, b1_NotRegisteredDevice.phoneNumber, "device/add", sendResponse.getSignature(), false, new Function2() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return B1_NotRegisteredDevice.smsSend$lambda$7$lambda$2(this.f$0, ((Boolean) obj).booleanValue(), (String) obj2);
                }
            }).start();
            b1_NotRegisteredDevice.b1.finish();
        } else {
            int resultCode = sendResponse.getResultCode();
            if (resultCode == 3005) {
                final B3_VerificationCodeLimitErrorGuideUi b3_VerificationCodeLimitErrorGuideUi = new B3_VerificationCodeLimitErrorGuideUi(b1_NotRegisteredDevice.activity);
                b3_VerificationCodeLimitErrorGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$smsSend$1$2$1
                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onActive(Bundle summit) {
                        this.this$0.callback(false);
                        b3_VerificationCodeLimitErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onCancel() {
                        this.this$0.callback(false);
                        b3_VerificationCodeLimitErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onClose() {
                        this.this$0.callback(false);
                        b3_VerificationCodeLimitErrorGuideUi.finish();
                    }
                });
            } else if (resultCode == 3017) {
                final B5_RepeatedPhoneNumberRequestErrorGuideUi b5_RepeatedPhoneNumberRequestErrorGuideUi = new B5_RepeatedPhoneNumberRequestErrorGuideUi(b1_NotRegisteredDevice.activity);
                b5_RepeatedPhoneNumberRequestErrorGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$smsSend$1$3$1
                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onActive(Bundle summit) {
                        this.this$0.callback(false);
                        b5_RepeatedPhoneNumberRequestErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onCancel() {
                        this.this$0.callback(false);
                        b5_RepeatedPhoneNumberRequestErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onClose() {
                        this.this$0.callback(false);
                        b5_RepeatedPhoneNumberRequestErrorGuideUi.finish();
                    }
                });
            } else if (resultCode == 3105) {
                final B4_SignUpLimitErrorGuideUi b4_SignUpLimitErrorGuideUi = new B4_SignUpLimitErrorGuideUi(b1_NotRegisteredDevice.activity);
                b4_SignUpLimitErrorGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$smsSend$1$4$1
                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onActive(Bundle summit) {
                        this.this$0.callback(false);
                        b4_SignUpLimitErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onCancel() {
                        this.this$0.callback(false);
                        b4_SignUpLimitErrorGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onClose() {
                        this.this$0.callback(false);
                        b4_SignUpLimitErrorGuideUi.finish();
                    }
                });
            } else {
                b1_NotRegisteredDevice.error(String.valueOf(sendResponse.getResultCode()), new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return B1_NotRegisteredDevice.smsSend$lambda$7$lambda$6(this.f$0, (B1_NotRegisteredDevice.Button) obj);
                    }
                });
            }
            b1_NotRegisteredDevice.b1.finish();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsSend$lambda$7$lambda$2(final B1_NotRegisteredDevice b1_NotRegisteredDevice, boolean z, String str) {
        if (z && str != null) {
            b1_NotRegisteredDevice.deviceAdd(str, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return B1_NotRegisteredDevice.smsSend$lambda$7$lambda$2$lambda$1(this.f$0, (B1_NotRegisteredDevice.Button) obj);
                }
            });
        } else {
            b1_NotRegisteredDevice.callback(false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsSend$lambda$7$lambda$2$lambda$1(B1_NotRegisteredDevice b1_NotRegisteredDevice, Button b) {
        Intrinsics.checkNotNullParameter(b, "b");
        int i = WhenMappings.$EnumSwitchMapping$0[b.ordinal()];
        if (i == 1) {
            b1_NotRegisteredDevice.callback(true);
        } else {
            if (i != 2 && i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            b1_NotRegisteredDevice.callback(false);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsSend$lambda$7$lambda$6(B1_NotRegisteredDevice b1_NotRegisteredDevice, Button it) {
        Intrinsics.checkNotNullParameter(it, "it");
        b1_NotRegisteredDevice.callback(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deviceAdd(String verifySignature, final Function1<? super Button, Unit> listener) {
        String deviceModel = Android.INSTANCE.getDeviceModel();
        if (deviceModel == null) {
            deviceModel = "Android " + Android.INSTANCE.getOSVersion();
        }
        final String str = deviceModel;
        DeviceManagementNetwork.INSTANCE.deviceAdd(this.account, verifySignature, DeviceManagement.INSTANCE.getKey(), str, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return B1_NotRegisteredDevice.deviceAdd$lambda$12(str, this, listener, (DeviceAdd.DeviceAddResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceAdd$lambda$12(String str, B1_NotRegisteredDevice b1_NotRegisteredDevice, final Function1 function1, DeviceAdd.DeviceAddResponse deviceAddResponse) {
        Intrinsics.checkNotNullParameter(deviceAddResponse, "deviceAddResponse");
        if (deviceAddResponse.isSuccess()) {
            DeviceManagement deviceManagement = DeviceManagement.INSTANCE;
            String seq = deviceAddResponse.getSeq();
            if (!(!StringsKt.isBlank(seq))) {
                seq = null;
            }
            deviceManagement.setMySeq$hive_authv4_device_management_release(seq);
            String str2 = DeviceManagement.INSTANCE.getHiveLocaleDateFormat$hive_authv4_device_management_release(HiveContext.INSTANCE.getResourceContext()).format(new Date());
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            String string = HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_153_1, str2);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            spannableStringBuilder.append((CharSequence) string);
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, string.length() - str2.length(), 33);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            String string2 = HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_154_1, str);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            spannableStringBuilder2.append((CharSequence) string2);
            spannableStringBuilder2.setSpan(new StyleSpan(1), 0, string2.length() - str.length(), 33);
            final A5_2_RegistrationGuideUi a5_2_RegistrationGuideUi = new A5_2_RegistrationGuideUi(b1_NotRegisteredDevice.activity, spannableStringBuilder, spannableStringBuilder2);
            a5_2_RegistrationGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$deviceAdd$1$2$1
                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onActive(Bundle summit) {
                    function1.invoke(B1_NotRegisteredDevice.Button.Active);
                    a5_2_RegistrationGuideUi.finish();
                }

                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onCancel() {
                    function1.invoke(B1_NotRegisteredDevice.Button.Active);
                    a5_2_RegistrationGuideUi.finish();
                }

                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onClose() {
                    function1.invoke(B1_NotRegisteredDevice.Button.Active);
                    a5_2_RegistrationGuideUi.finish();
                }
            });
        } else if (deviceAddResponse.getResultCode() == 3008) {
            b1_NotRegisteredDevice.timeout(String.valueOf(deviceAddResponse.getResultCode()), new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return B1_NotRegisteredDevice.deviceAdd$lambda$12$lambda$10(function1, (B1_NotRegisteredDevice.Button) obj);
                }
            });
        } else {
            b1_NotRegisteredDevice.error(String.valueOf(deviceAddResponse.getResultCode()), new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return B1_NotRegisteredDevice.deviceAdd$lambda$12$lambda$11(function1, (B1_NotRegisteredDevice.Button) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceAdd$lambda$12$lambda$10(Function1 function1, Button it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceAdd$lambda$12$lambda$11(Function1 function1, Button it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    private final void error(String errorCode, final Function1<? super Button, Unit> listener) {
        final A6_ErrorGuideUi a6_ErrorGuideUi = new A6_ErrorGuideUi(this.activity, errorCode, DeviceManagement.INSTANCE.hideCustomerSupport$hive_authv4_device_management_release());
        a6_ErrorGuideUi.show(new OnErrorGuideListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$error$1$1
            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                listener.invoke(B1_NotRegisteredDevice.Button.Cancel);
                a6_ErrorGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                listener.invoke(B1_NotRegisteredDevice.Button.Cancel);
                a6_ErrorGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                listener.invoke(B1_NotRegisteredDevice.Button.Close);
                a6_ErrorGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnErrorGuideListener
            public void onContactCustomerSupport() {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UrlManager.WithHive.INSTANCE.getCustomerAsk()));
                B1_NotRegisteredDevice b1_NotRegisteredDevice = this;
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching$default(b1_NotRegisteredDevice.activity, intent, null, 2, null);
            }
        });
    }

    private final void timeout(String errorCode, final Function1<? super Button, Unit> listener) {
        final A7_TimeoutGuideUi a7_TimeoutGuideUi = new A7_TimeoutGuideUi(this.activity, errorCode, true);
        a7_TimeoutGuideUi.show(new OnErrorGuideListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.B1_NotRegisteredDevice$timeout$1$1
            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                listener.invoke(B1_NotRegisteredDevice.Button.Cancel);
                a7_TimeoutGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                listener.invoke(B1_NotRegisteredDevice.Button.Cancel);
                a7_TimeoutGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                listener.invoke(B1_NotRegisteredDevice.Button.Close);
                a7_TimeoutGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnErrorGuideListener
            public void onContactCustomerSupport() {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UrlManager.WithHive.INSTANCE.getCustomerAsk()));
                B1_NotRegisteredDevice b1_NotRegisteredDevice = this;
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching$default(b1_NotRegisteredDevice.activity, intent, null, 2, null);
            }
        });
    }
}
