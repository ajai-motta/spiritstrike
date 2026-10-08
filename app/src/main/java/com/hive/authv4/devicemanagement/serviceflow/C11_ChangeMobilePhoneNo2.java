package com.hive.authv4.devicemanagement.serviceflow;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.autofill.HintConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.DeviceManagement;
import com.hive.authv4.devicemanagement.DeviceManagementNetwork;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.ui.C11_ChangeMobilePhoneNo2Ui;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveContext;
import com.hive.protocol.UrlManager;
import com.hive.protocol.authv4.SmsSend;
import com.hive.protocol.authv4.SmsVerify;
import com.hive.standalone.HiveLifecycle;
import com.hive.ui.devicemanagement.model.OnChangeMobilePhoneNo2Listener;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* JADX INFO: compiled from: C11_ChangeMobilePhoneNo2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001BZ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012%\u0010\n\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0010J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0012\u0010\u001c\u001a\u00020\u00102\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R-\u0010\n\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lcom/hive/authv4/devicemanagement/serviceflow/C11_ChangeMobilePhoneNo2;", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "phoneCode", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, InAppPurchaseMetaData.KEY_SIGNATURE, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "<init>", "(Landroid/app/Activity;Lcom/hive/standalone/HiveLifecycle$HiveAccount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "c11", "Lcom/hive/authv4/devicemanagement/ui/C11_ChangeMobilePhoneNo2Ui;", "getC11", "()Lcom/hive/authv4/devicemanagement/ui/C11_ChangeMobilePhoneNo2Ui;", "callback", "b", "(Ljava/lang/Boolean;)V", TtmlNode.START, "smsSend", "smsVerify", "code", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C11_ChangeMobilePhoneNo2 {
    private final HiveLifecycle.HiveAccount account;
    private final Activity activity;
    private final C11_ChangeMobilePhoneNo2Ui c11;
    private Function1<? super Boolean, Unit> listener;
    private final String phoneCode;
    private final String phoneNumber;
    private String signature;

    public C11_ChangeMobilePhoneNo2(Activity activity, HiveLifecycle.HiveAccount account, String phoneCode, String phoneNumber, String str, Function1<? super Boolean, Unit> function1) {
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
        this.c11 = new C11_ChangeMobilePhoneNo2Ui(activity, Marker.ANY_NON_NULL_MARKER + phoneCode + ' ' + phoneNumber, DeviceManagement.INSTANCE.hideCustomerSupport$hive_authv4_device_management_release());
    }

    public /* synthetic */ C11_ChangeMobilePhoneNo2(Activity activity, HiveLifecycle.HiveAccount hiveAccount, String str, String str2, String str3, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, hiveAccount, str, str2, (i & 16) != 0 ? null : str3, function1);
    }

    public final C11_ChangeMobilePhoneNo2Ui getC11() {
        return this.c11;
    }

    public final void callback(Boolean b) {
        Function1<? super Boolean, Unit> function1 = this.listener;
        if (function1 != null) {
            function1.invoke(b);
        }
        this.listener = null;
    }

    public final void start() {
        this.c11.show(new OnChangeMobilePhoneNo2Listener() { // from class: com.hive.authv4.devicemanagement.serviceflow.C11_ChangeMobilePhoneNo2.start.1
            @Override // com.hive.ui.devicemanagement.model.OnChangeMobilePhoneNo2Listener
            public void onResend() {
                C11_ChangeMobilePhoneNo2.this.smsSend();
            }

            @Override // com.hive.ui.devicemanagement.model.OnChangeMobilePhoneNo2Listener
            public void onContactCustomerSupport() {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UrlManager.WithHive.INSTANCE.getCustomerAsk()));
                C11_ChangeMobilePhoneNo2 c11_ChangeMobilePhoneNo2 = C11_ChangeMobilePhoneNo2.this;
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching$default(c11_ChangeMobilePhoneNo2.activity, intent, null, 2, null);
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                C11_ChangeMobilePhoneNo2.this.smsVerify(summit != null ? summit.getString("code") : null);
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                C11_ChangeMobilePhoneNo2.this.callback(false);
                C11_ChangeMobilePhoneNo2.this.getC11().finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                C11_ChangeMobilePhoneNo2.this.callback(null);
                C11_ChangeMobilePhoneNo2.this.getC11().finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void smsSend() {
        DeviceManagementNetwork.INSTANCE.smsSend(this.account, null, null, "device/modify-user", new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C11_ChangeMobilePhoneNo2$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return C11_ChangeMobilePhoneNo2.smsSend$lambda$1(this.f$0, (SmsSend.SmsSendResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsSend$lambda$1(C11_ChangeMobilePhoneNo2 c11_ChangeMobilePhoneNo2, SmsSend.SmsSendResponse it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isSuccess()) {
            c11_ChangeMobilePhoneNo2.signature = it.getSignature();
            c11_ChangeMobilePhoneNo2.c11.setTimerReset();
        } else {
            int resultCode = it.getResultCode();
            if (resultCode == -1) {
                c11_ChangeMobilePhoneNo2.c11.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163));
            } else if (resultCode == 3005) {
                c11_ChangeMobilePhoneNo2.c11.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_403));
            } else if (resultCode == 3017) {
                c11_ChangeMobilePhoneNo2.c11.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_1188));
            } else if (resultCode == 3105) {
                c11_ChangeMobilePhoneNo2.c11.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_492));
            } else if (resultCode == 3014) {
                c11_ChangeMobilePhoneNo2.c11.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_183));
            } else if (resultCode == 3015) {
                c11_ChangeMobilePhoneNo2.c11.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_182));
            } else {
                c11_ChangeMobilePhoneNo2.c11.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_144) + " [" + it.getResultCode() + AbstractJsonLexerKt.END_LIST);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void smsVerify(String code) {
        final String str = this.signature;
        if (code != null && str != null) {
            DeviceManagementNetwork.INSTANCE.smsVerify(this.account, str, code, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C11_ChangeMobilePhoneNo2$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return C11_ChangeMobilePhoneNo2.smsVerify$lambda$4$lambda$3(this.f$0, str, (SmsVerify.SmsVerifyResponse) obj);
                }
            });
        } else {
            this.c11.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_120));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsVerify$lambda$4$lambda$3(final C11_ChangeMobilePhoneNo2 c11_ChangeMobilePhoneNo2, String str, SmsVerify.SmsVerifyResponse it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isSuccess()) {
            new C12_ChangeMobilePhoneNo3(c11_ChangeMobilePhoneNo2.activity, c11_ChangeMobilePhoneNo2.account, c11_ChangeMobilePhoneNo2.phoneCode, c11_ChangeMobilePhoneNo2.phoneNumber, str, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C11_ChangeMobilePhoneNo2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return C11_ChangeMobilePhoneNo2.smsVerify$lambda$4$lambda$3$lambda$2(this.f$0, (Boolean) obj);
                }
            }).start();
            c11_ChangeMobilePhoneNo2.c11.finish();
        } else {
            int resultCode = it.getResultCode();
            if (resultCode == -1) {
                c11_ChangeMobilePhoneNo2.c11.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163));
            } else if (resultCode == 3001 || resultCode == 3008) {
                c11_ChangeMobilePhoneNo2.c11.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_120));
            } else {
                c11_ChangeMobilePhoneNo2.c11.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163) + " [" + it.getResultCode() + AbstractJsonLexerKt.END_LIST);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsVerify$lambda$4$lambda$3$lambda$2(C11_ChangeMobilePhoneNo2 c11_ChangeMobilePhoneNo2, Boolean bool) {
        c11_ChangeMobilePhoneNo2.callback(bool);
        return Unit.INSTANCE;
    }
}
