package com.hive.authv4.devicemanagement.serviceflow;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.DeviceManagement;
import com.hive.authv4.devicemanagement.DeviceManagementNetwork;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.serviceflow.A5_DeviceRegistration;
import com.hive.authv4.devicemanagement.ui.A5_1_DeviceRegistrationUi;
import com.hive.authv4.devicemanagement.ui.A5_2_RegistrationGuideUi;
import com.hive.authv4.devicemanagement.ui.A6_ErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.authv4.devicemanagement.ui.model.OnErrorGuideListener;
import com.hive.base.Android;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveContext;
import com.hive.protocol.UrlManager;
import com.hive.protocol.authv4.DeviceAdd;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: A5_DeviceRegistration.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\nJ\u0006\u0010\u0014\u001a\u00020\u000bJ\"\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/hive/authv4/devicemanagement/serviceflow/A5_DeviceRegistration;", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", InAppPurchaseMetaData.KEY_SIGNATURE, "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "", "<init>", "(Landroid/app/Activity;Lcom/hive/standalone/HiveLifecycle$HiveAccount;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "a5_1", "Lcom/hive/authv4/devicemanagement/ui/A5_1_DeviceRegistrationUi;", "getA5_1", "()Lcom/hive/authv4/devicemanagement/ui/A5_1_DeviceRegistrationUi;", "callback", "b", TtmlNode.START, "error", "errorCode", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class A5_DeviceRegistration {
    private final A5_1_DeviceRegistrationUi a5_1;
    private final HiveLifecycle.HiveAccount account;
    private final Activity activity;
    private Function1<? super Boolean, Unit> listener;
    private final String signature;

    public A5_DeviceRegistration(Activity activity, HiveLifecycle.HiveAccount account, String signature, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(signature, "signature");
        this.activity = activity;
        this.account = account;
        this.signature = signature;
        this.listener = function1;
        String deviceModel = Android.INSTANCE.getDeviceModel();
        this.a5_1 = new A5_1_DeviceRegistrationUi(activity, deviceModel == null ? "" : deviceModel);
    }

    public final A5_1_DeviceRegistrationUi getA5_1() {
        return this.a5_1;
    }

    public final void callback(boolean b) {
        Function1<? super Boolean, Unit> function1 = this.listener;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(b));
        }
        this.listener = null;
    }

    /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.serviceflow.A5_DeviceRegistration$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: A5_DeviceRegistration.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\b"}, d2 = {"com/hive/authv4/devicemanagement/serviceflow/A5_DeviceRegistration$start$1", "Lcom/hive/authv4/devicemanagement/ui/model/OnBaseButtonListener;", "onActive", "", "summit", "Landroid/os/Bundle;", "onCancel", "onClose", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements OnBaseButtonListener {
        AnonymousClass1() {
        }

        @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
        public void onActive(Bundle summit) {
            String deviceModel;
            if ((summit == null || (deviceModel = summit.getString("deviceName")) == null) && (deviceModel = Android.INSTANCE.getDeviceModel()) == null) {
                deviceModel = "";
            }
            final String str = deviceModel;
            DeviceManagementNetwork deviceManagementNetwork = DeviceManagementNetwork.INSTANCE;
            HiveLifecycle.HiveAccount hiveAccount = A5_DeviceRegistration.this.account;
            String str2 = A5_DeviceRegistration.this.signature;
            String key = DeviceManagement.INSTANCE.getKey();
            final A5_DeviceRegistration a5_DeviceRegistration = A5_DeviceRegistration.this;
            deviceManagementNetwork.deviceAdd(hiveAccount, str2, key, str, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.A5_DeviceRegistration$start$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return A5_DeviceRegistration.AnonymousClass1.onActive$lambda$3(str, a5_DeviceRegistration, (DeviceAdd.DeviceAddResponse) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onActive$lambda$3(String str, final A5_DeviceRegistration a5_DeviceRegistration, DeviceAdd.DeviceAddResponse deviceAddResponse) {
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
                final A5_2_RegistrationGuideUi a5_2_RegistrationGuideUi = new A5_2_RegistrationGuideUi(a5_DeviceRegistration.activity, spannableStringBuilder, spannableStringBuilder2);
                a5_2_RegistrationGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.A5_DeviceRegistration$start$1$onActive$1$2$1
                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onActive(Bundle summit) {
                        a5_DeviceRegistration.callback(true);
                        a5_2_RegistrationGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onCancel() {
                        a5_DeviceRegistration.callback(true);
                        a5_2_RegistrationGuideUi.finish();
                    }

                    @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                    public void onClose() {
                        a5_DeviceRegistration.callback(true);
                        a5_2_RegistrationGuideUi.finish();
                    }
                });
            } else {
                a5_DeviceRegistration.error(String.valueOf(deviceAddResponse.getResultCode()), new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.A5_DeviceRegistration$start$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return A5_DeviceRegistration.AnonymousClass1.onActive$lambda$3$lambda$2(a5_DeviceRegistration, ((Boolean) obj).booleanValue());
                    }
                });
            }
            a5_DeviceRegistration.getA5_1().finish();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onActive$lambda$3$lambda$2(A5_DeviceRegistration a5_DeviceRegistration, boolean z) {
            a5_DeviceRegistration.callback(false);
            return Unit.INSTANCE;
        }

        @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
        public void onCancel() {
            A5_DeviceRegistration.this.callback(false);
            A5_DeviceRegistration.this.getA5_1().finish();
        }

        @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
        public void onClose() {
            A5_DeviceRegistration.this.callback(false);
            A5_DeviceRegistration.this.getA5_1().finish();
        }
    }

    public final void start() {
        this.a5_1.show(new AnonymousClass1());
    }

    public final void error(String errorCode, final Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final A6_ErrorGuideUi a6_ErrorGuideUi = new A6_ErrorGuideUi(this.activity, errorCode, DeviceManagement.INSTANCE.hideCustomerSupport$hive_authv4_device_management_release());
        a6_ErrorGuideUi.show(new OnErrorGuideListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.A5_DeviceRegistration$error$1$1
            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                listener.invoke(true);
                a6_ErrorGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                listener.invoke(true);
                a6_ErrorGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                listener.invoke(false);
                a6_ErrorGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnErrorGuideListener
            public void onContactCustomerSupport() {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UrlManager.WithHive.INSTANCE.getCustomerAsk()));
                A5_DeviceRegistration a5_DeviceRegistration = this;
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching$default(a5_DeviceRegistration.activity, intent, null, 2, null);
            }
        });
    }
}
