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
import com.hive.authv4.devicemanagement.ui.A4_VerifyIdentityAuthCodeUi;
import com.hive.authv4.devicemanagement.ui.model.OnVerifyIdentityAuthCodeListener;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveContext;
import com.hive.protocol.UrlManager;
import com.hive.protocol.authv4.SmsSend;
import com.hive.protocol.authv4.SmsVerify;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* JADX INFO: compiled from: A4_VerifyIdentity.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\fJ\u0006\u0010\u0018\u001a\u00020\u000fJ\b\u0010\u0019\u001a\u00020\u000fH\u0002J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/hive/authv4/devicemanagement/serviceflow/A4_VerifyIdentity;", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "phoneCode", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "useApi", InAppPurchaseMetaData.KEY_SIGNATURE, "isSubscriptionGuide", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "", "<init>", "(Landroid/app/Activity;Lcom/hive/standalone/HiveLifecycle$HiveAccount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)V", "a4", "Lcom/hive/authv4/devicemanagement/ui/A4_VerifyIdentityAuthCodeUi;", "getA4", "()Lcom/hive/authv4/devicemanagement/ui/A4_VerifyIdentityAuthCodeUi;", "callback", "b", TtmlNode.START, "smsSend", "smsVerify", "code", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class A4_VerifyIdentity {
    private final A4_VerifyIdentityAuthCodeUi a4;
    private final HiveLifecycle.HiveAccount account;
    private final Activity activity;
    private final boolean isSubscriptionGuide;
    private Function2<? super Boolean, ? super String, Unit> listener;
    private final String phoneCode;
    private final String phoneNumber;
    private String signature;
    private final String useApi;

    public A4_VerifyIdentity(Activity activity, HiveLifecycle.HiveAccount account, String str, String str2, String useApi, String str3, boolean z, Function2<? super Boolean, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(useApi, "useApi");
        this.activity = activity;
        this.account = account;
        this.phoneCode = str;
        this.phoneNumber = str2;
        this.useApi = useApi;
        this.signature = str3;
        this.isSubscriptionGuide = z;
        this.listener = function2;
        this.a4 = new A4_VerifyIdentityAuthCodeUi(activity, Marker.ANY_NON_NULL_MARKER + str + ' ' + str2, DeviceManagement.INSTANCE.hideCustomerSupport$hive_authv4_device_management_release());
    }

    public /* synthetic */ A4_VerifyIdentity(Activity activity, HiveLifecycle.HiveAccount hiveAccount, String str, String str2, String str3, String str4, boolean z, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, hiveAccount, str, str2, str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? false : z, function2);
    }

    public final A4_VerifyIdentityAuthCodeUi getA4() {
        return this.a4;
    }

    public final void callback(boolean b) {
        Function2<? super Boolean, ? super String, Unit> function2 = this.listener;
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(b), this.signature);
        }
        this.listener = null;
    }

    public final void start() {
        this.a4.show(new OnVerifyIdentityAuthCodeListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.A4_VerifyIdentity.start.1
            @Override // com.hive.authv4.devicemanagement.ui.model.OnVerifyIdentityAuthCodeListener
            public void onResend() {
                A4_VerifyIdentity.this.smsSend();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                A4_VerifyIdentity.this.smsVerify(summit != null ? summit.getString("code") : null);
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                A4_VerifyIdentity.this.callback(false);
                A4_VerifyIdentity.this.getA4().finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                A4_VerifyIdentity.this.callback(false);
                A4_VerifyIdentity.this.getA4().finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnVerifyIdentityAuthCodeListener
            public void onContactCustomerSupport() {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UrlManager.WithHive.INSTANCE.getCustomerAsk()));
                A4_VerifyIdentity a4_VerifyIdentity = A4_VerifyIdentity.this;
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching$default(a4_VerifyIdentity.activity, intent, null, 2, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void smsSend() {
        DeviceManagementNetwork deviceManagementNetwork = DeviceManagementNetwork.INSTANCE;
        HiveLifecycle.HiveAccount hiveAccount = this.account;
        String str = this.phoneCode;
        boolean z = this.isSubscriptionGuide;
        if (!z) {
            str = null;
        }
        deviceManagementNetwork.smsSend(hiveAccount, str, z ? this.phoneNumber : null, this.useApi, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.A4_VerifyIdentity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return A4_VerifyIdentity.smsSend$lambda$3(this.f$0, (SmsSend.SmsSendResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsSend$lambda$3(A4_VerifyIdentity a4_VerifyIdentity, SmsSend.SmsSendResponse it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isSuccess()) {
            a4_VerifyIdentity.signature = it.getSignature();
            a4_VerifyIdentity.a4.setTimerReset();
        } else {
            int resultCode = it.getResultCode();
            if (resultCode == -1) {
                a4_VerifyIdentity.a4.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163));
            } else if (resultCode == 3005) {
                a4_VerifyIdentity.a4.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_403));
            } else if (resultCode == 3017) {
                a4_VerifyIdentity.a4.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_1188));
            } else if (resultCode == 3105) {
                a4_VerifyIdentity.a4.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_492));
            } else if (resultCode == 3014) {
                a4_VerifyIdentity.a4.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_183));
            } else if (resultCode == 3015) {
                a4_VerifyIdentity.a4.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_182));
            } else {
                a4_VerifyIdentity.a4.setError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_144) + " [" + it.getResultCode() + AbstractJsonLexerKt.END_LIST);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void smsVerify(String code) {
        String str = this.signature;
        if (code != null && str != null) {
            DeviceManagementNetwork.INSTANCE.smsVerify(this.account, str, code, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.A4_VerifyIdentity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return A4_VerifyIdentity.smsVerify$lambda$5$lambda$4(this.f$0, (SmsVerify.SmsVerifyResponse) obj);
                }
            });
        } else {
            this.a4.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_120));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsVerify$lambda$5$lambda$4(A4_VerifyIdentity a4_VerifyIdentity, SmsVerify.SmsVerifyResponse it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isSuccess()) {
            a4_VerifyIdentity.callback(true);
            a4_VerifyIdentity.a4.finish();
        } else {
            int resultCode = it.getResultCode();
            if (resultCode == -1) {
                a4_VerifyIdentity.a4.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163));
            } else if (resultCode == 3001 || resultCode == 3008) {
                a4_VerifyIdentity.a4.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_120));
            } else {
                a4_VerifyIdentity.a4.setVerifyError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163) + " [" + it.getResultCode() + AbstractJsonLexerKt.END_LIST);
            }
        }
        return Unit.INSTANCE;
    }
}
