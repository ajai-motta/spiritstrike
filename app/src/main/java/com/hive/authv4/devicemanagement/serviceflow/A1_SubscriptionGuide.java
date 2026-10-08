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
import com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide;
import com.hive.authv4.devicemanagement.ui.A1_SubscriptionGuideUi;
import com.hive.authv4.devicemanagement.ui.A2_CollectionPersonalInformationUi;
import com.hive.authv4.devicemanagement.ui.A3_VerifyIdentityUi;
import com.hive.authv4.devicemanagement.ui.A5_2_RegistrationGuideUi;
import com.hive.authv4.devicemanagement.ui.A6_ErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.A7_TimeoutGuideUi;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.authv4.devicemanagement.ui.model.OnErrorGuideListener;
import com.hive.authv4.devicemanagement.ui.model.OnPersonalInfoListener;
import com.hive.authv4.devicemanagement.ui.model.OnVerifyIdentityListener;
import com.hive.base.Android;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveContext;
import com.hive.protocol.UrlManager;
import com.hive.protocol.authv4.DeviceSetUser;
import com.hive.protocol.authv4.SmsSend;
import com.hive.protocol.authv4.SmsVerify;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import java.util.Date;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* JADX INFO: compiled from: A1_SubscriptionGuide.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001(BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\fJ\u0006\u0010\u001e\u001a\u00020\rJ\b\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u001f\u001a\u00020\rH\u0002J\u0012\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\u0007H\u0002J(\u0010\"\u001a\u00020\r2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u000bH\u0002J$\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u000bH\u0002J$\u0010'\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\r0\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/hive/authv4/devicemanagement/serviceflow/A1_SubscriptionGuide;", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "inputPhoneCode", "", "inputPhoneNumber", InAppPurchaseMetaData.KEY_SIGNATURE, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "", "<init>", "(Landroid/app/Activity;Lcom/hive/standalone/HiveLifecycle$HiveAccount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "a1", "Lcom/hive/authv4/devicemanagement/ui/A1_SubscriptionGuideUi;", "getA1", "()Lcom/hive/authv4/devicemanagement/ui/A1_SubscriptionGuideUi;", "a2", "Lcom/hive/authv4/devicemanagement/ui/A2_CollectionPersonalInformationUi;", "getA2", "()Lcom/hive/authv4/devicemanagement/ui/A2_CollectionPersonalInformationUi;", "a3", "Lcom/hive/authv4/devicemanagement/ui/A3_VerifyIdentityUi;", "getA3", "()Lcom/hive/authv4/devicemanagement/ui/A3_VerifyIdentityUi;", "callback", "b", TtmlNode.START, "smsSend", "smsVerify", "code", "deviceSetUser", "localSig", "Lcom/hive/authv4/devicemanagement/serviceflow/A1_SubscriptionGuide$Button;", "error", "errorCode", "timeout", "Button", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class A1_SubscriptionGuide {
    private final A1_SubscriptionGuideUi a1;
    private final A2_CollectionPersonalInformationUi a2;
    private final A3_VerifyIdentityUi a3;
    private final HiveLifecycle.HiveAccount account;
    private final Activity activity;
    private String inputPhoneCode;
    private String inputPhoneNumber;
    private Function1<? super Boolean, Unit> listener;
    private String signature;

    /* JADX INFO: compiled from: A1_SubscriptionGuide.kt */
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

    public A1_SubscriptionGuide(Activity activity, HiveLifecycle.HiveAccount account, String str, String str2, String str3, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        this.activity = activity;
        this.account = account;
        this.inputPhoneCode = str;
        this.inputPhoneNumber = str2;
        this.signature = str3;
        this.listener = function1;
        this.a1 = new A1_SubscriptionGuideUi(activity);
        this.a2 = new A2_CollectionPersonalInformationUi(activity);
        this.a3 = new A3_VerifyIdentityUi(activity);
    }

    public /* synthetic */ A1_SubscriptionGuide(Activity activity, HiveLifecycle.HiveAccount hiveAccount, String str, String str2, String str3, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, hiveAccount, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, function1);
    }

    public final A1_SubscriptionGuideUi getA1() {
        return this.a1;
    }

    public final A2_CollectionPersonalInformationUi getA2() {
        return this.a2;
    }

    public final A3_VerifyIdentityUi getA3() {
        return this.a3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: A1_SubscriptionGuide.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/hive/authv4/devicemanagement/serviceflow/A1_SubscriptionGuide$Button;", "", "<init>", "(Ljava/lang/String;I)V", "Active", "Cancel", "Close", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public final void start() {
        this.a1.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide.start.1
            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                A1_SubscriptionGuide.this.getA2().show((OnPersonalInfoListener) new A1_SubscriptionGuide$start$1$onActive$1(A1_SubscriptionGuide.this));
                A1_SubscriptionGuide.this.getA1().finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                A1_SubscriptionGuide.this.callback(false);
                A1_SubscriptionGuide.this.getA1().finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                A1_SubscriptionGuide.this.callback(false);
                A1_SubscriptionGuide.this.getA1().finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a3() {
        this.a3.show(new OnVerifyIdentityListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide.a3.1
            @Override // com.hive.authv4.devicemanagement.ui.model.OnVerifyIdentityListener
            public void onSend(Bundle summit) {
                Intrinsics.checkNotNullParameter(summit, "summit");
                A1_SubscriptionGuide a1_SubscriptionGuide = A1_SubscriptionGuide.this;
                String string = summit.getString("phoneCode");
                a1_SubscriptionGuide.inputPhoneCode = string != null ? StringsKt.removePrefix(string, (CharSequence) Marker.ANY_NON_NULL_MARKER) : null;
                A1_SubscriptionGuide.this.inputPhoneNumber = summit.getString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
                A1_SubscriptionGuide.this.smsSend();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnVerifyIdentityListener
            public void onResend() {
                A1_SubscriptionGuide.this.smsSend();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                A1_SubscriptionGuide.this.smsVerify(summit != null ? summit.getString("code") : null);
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                A1_SubscriptionGuide.this.callback(false);
                A1_SubscriptionGuide.this.getA3().finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                A1_SubscriptionGuide.this.callback(false);
                A1_SubscriptionGuide.this.getA3().finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void smsSend() {
        DeviceManagementNetwork.INSTANCE.smsSend(this.account, this.inputPhoneCode, this.inputPhoneNumber, "device/set-user", new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A1_SubscriptionGuide.smsSend$lambda$1(this.f$0, (SmsSend.SmsSendResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsSend$lambda$1(A1_SubscriptionGuide a1_SubscriptionGuide, SmsSend.SmsSendResponse sendResponse) {
        Intrinsics.checkNotNullParameter(sendResponse, "sendResponse");
        if (sendResponse.isSuccess()) {
            a1_SubscriptionGuide.signature = sendResponse.getSignature();
            a1_SubscriptionGuide.a3.setSendError(false, null);
        } else {
            int resultCode = sendResponse.getResultCode();
            if (resultCode == -1) {
                a1_SubscriptionGuide.a3.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163));
            } else if (resultCode == 3005) {
                a1_SubscriptionGuide.a3.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_403));
            } else if (resultCode == 3017) {
                a1_SubscriptionGuide.a3.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_1188));
            } else if (resultCode == 3105) {
                a1_SubscriptionGuide.a3.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_492));
            } else if (resultCode == 3014) {
                a1_SubscriptionGuide.a3.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_183));
            } else if (resultCode == 3015) {
                a1_SubscriptionGuide.a3.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_182));
            } else {
                a1_SubscriptionGuide.a3.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_144) + " [" + sendResponse.getResultCode() + AbstractJsonLexerKt.END_LIST);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void smsVerify(String code) {
        final String str = this.signature;
        if (code != null && str != null) {
            DeviceManagementNetwork.INSTANCE.smsVerify(this.account, str, code, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return A1_SubscriptionGuide.smsVerify$lambda$4$lambda$3(this.f$0, str, (SmsVerify.SmsVerifyResponse) obj);
                }
            });
        } else {
            this.a3.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_120));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsVerify$lambda$4$lambda$3(final A1_SubscriptionGuide a1_SubscriptionGuide, String str, SmsVerify.SmsVerifyResponse verifyResponse) {
        Intrinsics.checkNotNullParameter(verifyResponse, "verifyResponse");
        if (verifyResponse.isSuccess()) {
            a1_SubscriptionGuide.deviceSetUser(str, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return A1_SubscriptionGuide.smsVerify$lambda$4$lambda$3$lambda$2(this.f$0, (A1_SubscriptionGuide.Button) obj);
                }
            });
        } else {
            int resultCode = verifyResponse.getResultCode();
            if (resultCode == -1) {
                a1_SubscriptionGuide.a3.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163));
            } else if (resultCode == 3001 || resultCode == 3008) {
                a1_SubscriptionGuide.a3.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_120));
            } else {
                a1_SubscriptionGuide.a3.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163) + " [" + verifyResponse.getResultCode() + AbstractJsonLexerKt.END_LIST);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsVerify$lambda$4$lambda$3$lambda$2(A1_SubscriptionGuide a1_SubscriptionGuide, Button b) {
        Intrinsics.checkNotNullParameter(b, "b");
        int i = WhenMappings.$EnumSwitchMapping$0[b.ordinal()];
        if (i == 1) {
            a1_SubscriptionGuide.callback(true);
            a1_SubscriptionGuide.a3.finish();
        } else if (i == 2) {
            a1_SubscriptionGuide.callback(false);
        } else {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            }
            a1_SubscriptionGuide.callback(false);
            a1_SubscriptionGuide.a3.finish();
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ void deviceSetUser$default(A1_SubscriptionGuide a1_SubscriptionGuide, String str, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            str = a1_SubscriptionGuide.signature;
        }
        a1_SubscriptionGuide.deviceSetUser(str, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deviceSetUser(String localSig, final Function1<? super Button, Unit> listener) {
        String deviceModel = Android.INSTANCE.getDeviceModel();
        if (deviceModel == null) {
            deviceModel = "Android " + Android.INSTANCE.getOSVersion();
        }
        final String str = deviceModel;
        DeviceManagementNetwork.INSTANCE.deviceSetUser(this.account, this.inputPhoneCode, this.inputPhoneNumber, localSig, DeviceManagement.INSTANCE.getKey(), str, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A1_SubscriptionGuide.deviceSetUser$lambda$9(str, this, listener, (DeviceSetUser.DeviceSetUserResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceSetUser$lambda$9(String str, A1_SubscriptionGuide a1_SubscriptionGuide, final Function1 function1, DeviceSetUser.DeviceSetUserResponse deviceSetUserResponse) {
        Intrinsics.checkNotNullParameter(deviceSetUserResponse, "deviceSetUserResponse");
        if (deviceSetUserResponse.isSuccess()) {
            DeviceManagement deviceManagement = DeviceManagement.INSTANCE;
            String seq = deviceSetUserResponse.getSeq();
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
            final A5_2_RegistrationGuideUi a5_2_RegistrationGuideUi = new A5_2_RegistrationGuideUi(a1_SubscriptionGuide.activity, spannableStringBuilder, spannableStringBuilder2);
            a5_2_RegistrationGuideUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide$deviceSetUser$1$2$1
                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onActive(Bundle summit) {
                    function1.invoke(A1_SubscriptionGuide.Button.Active);
                    a5_2_RegistrationGuideUi.finish();
                }

                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onCancel() {
                    function1.invoke(A1_SubscriptionGuide.Button.Active);
                    a5_2_RegistrationGuideUi.finish();
                }

                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onClose() {
                    function1.invoke(A1_SubscriptionGuide.Button.Active);
                    a5_2_RegistrationGuideUi.finish();
                }
            });
        } else if (deviceSetUserResponse.getResultCode() == 3008) {
            a1_SubscriptionGuide.timeout(String.valueOf(deviceSetUserResponse.getResultCode()), new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return A1_SubscriptionGuide.deviceSetUser$lambda$9$lambda$7(function1, (A1_SubscriptionGuide.Button) obj);
                }
            });
        } else {
            a1_SubscriptionGuide.error(String.valueOf(deviceSetUserResponse.getResultCode()), new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return A1_SubscriptionGuide.deviceSetUser$lambda$9$lambda$8(function1, (A1_SubscriptionGuide.Button) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceSetUser$lambda$9$lambda$7(Function1 function1, Button it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit deviceSetUser$lambda$9$lambda$8(Function1 function1, Button it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(it);
        return Unit.INSTANCE;
    }

    private final void error(String errorCode, final Function1<? super Button, Unit> listener) {
        final A6_ErrorGuideUi a6_ErrorGuideUi = new A6_ErrorGuideUi(this.activity, errorCode, DeviceManagement.INSTANCE.hideCustomerSupport$hive_authv4_device_management_release());
        a6_ErrorGuideUi.show(new OnErrorGuideListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide$error$1$1
            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                listener.invoke(A1_SubscriptionGuide.Button.Cancel);
                a6_ErrorGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                listener.invoke(A1_SubscriptionGuide.Button.Cancel);
                a6_ErrorGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                listener.invoke(A1_SubscriptionGuide.Button.Close);
                a6_ErrorGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnErrorGuideListener
            public void onContactCustomerSupport() {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UrlManager.WithHive.INSTANCE.getCustomerAsk()));
                A1_SubscriptionGuide a1_SubscriptionGuide = this;
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching$default(a1_SubscriptionGuide.activity, intent, null, 2, null);
            }
        });
    }

    private final void timeout(String errorCode, final Function1<? super Button, Unit> listener) {
        final A7_TimeoutGuideUi a7_TimeoutGuideUi = new A7_TimeoutGuideUi(this.activity, errorCode, true);
        a7_TimeoutGuideUi.show(new OnErrorGuideListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.A1_SubscriptionGuide$timeout$1$1
            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                listener.invoke(A1_SubscriptionGuide.Button.Cancel);
                a7_TimeoutGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                listener.invoke(A1_SubscriptionGuide.Button.Cancel);
                a7_TimeoutGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                listener.invoke(A1_SubscriptionGuide.Button.Close);
                a7_TimeoutGuideUi.finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnErrorGuideListener
            public void onContactCustomerSupport() {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UrlManager.WithHive.INSTANCE.getCustomerAsk()));
                A1_SubscriptionGuide a1_SubscriptionGuide = this;
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching$default(a1_SubscriptionGuide.activity, intent, null, 2, null);
            }
        });
    }
}
