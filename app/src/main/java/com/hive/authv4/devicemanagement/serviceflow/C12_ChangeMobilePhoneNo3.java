package com.hive.authv4.devicemanagement.serviceflow;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.autofill.HintConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hive.authv4.devicemanagement.DeviceManagementNetwork;
import com.hive.authv4.devicemanagement.R;
import com.hive.authv4.devicemanagement.ui.C12_ChangeMobilePhoneNo3Ui;
import com.hive.authv4.devicemanagement.ui.C14_ChangeMobilePhoneNoCompleteUi;
import com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener;
import com.hive.authv4.devicemanagement.ui.model.OnChangeMobilePhoneNo3Listener;
import com.hive.core.Configuration;
import com.hive.core.ExtentionsKt;
import com.hive.core.HiveContext;
import com.hive.protocol.UrlManager;
import com.hive.protocol.authv4.DeviceModifyUser;
import com.hive.protocol.authv4.SmsSend;
import com.hive.protocol.authv4.SmsVerify;
import com.hive.standalone.HiveLifecycle;
import com.unity3d.ads.metadata.InAppPurchaseMetaData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.io.files.FileSystemKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.slf4j.Marker;

/* JADX INFO: compiled from: C12_ChangeMobilePhoneNo3.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0016\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\rJ\b\u0010\u001b\u001a\u00020\rH\u0002J\u0012\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/hive/authv4/devicemanagement/serviceflow/C12_ChangeMobilePhoneNo3;", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "phoneCode", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "c11Signature", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function1;", "", "", "<init>", "(Landroid/app/Activity;Lcom/hive/standalone/HiveLifecycle$HiveAccount;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "c12", "Lcom/hive/authv4/devicemanagement/ui/C12_ChangeMobilePhoneNo3Ui;", "getC12", "()Lcom/hive/authv4/devicemanagement/ui/C12_ChangeMobilePhoneNo3Ui;", "inputPhoneCode", "inputPhoneNumber", InAppPurchaseMetaData.KEY_SIGNATURE, "callback", "b", "(Ljava/lang/Boolean;)V", TtmlNode.START, "smsSend", "smsVerify", "code", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C12_ChangeMobilePhoneNo3 {
    private final HiveLifecycle.HiveAccount account;
    private final Activity activity;
    private final String c11Signature;
    private final C12_ChangeMobilePhoneNo3Ui c12;
    private String inputPhoneCode;
    private String inputPhoneNumber;
    private Function1<? super Boolean, Unit> listener;
    private String signature;

    public C12_ChangeMobilePhoneNo3(Activity activity, HiveLifecycle.HiveAccount account, String phoneCode, String phoneNumber, String c11Signature, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(phoneCode, "phoneCode");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(c11Signature, "c11Signature");
        this.activity = activity;
        this.account = account;
        this.c11Signature = c11Signature;
        this.listener = function1;
        this.c12 = new C12_ChangeMobilePhoneNo3Ui(activity, Marker.ANY_NON_NULL_MARKER + phoneCode + ' ' + phoneNumber);
    }

    public final C12_ChangeMobilePhoneNo3Ui getC12() {
        return this.c12;
    }

    public final void callback(Boolean b) {
        Function1<? super Boolean, Unit> function1 = this.listener;
        if (function1 != null) {
            function1.invoke(b);
        }
        this.listener = null;
    }

    public final void start() {
        this.c12.show(new OnChangeMobilePhoneNo3Listener() { // from class: com.hive.authv4.devicemanagement.serviceflow.C12_ChangeMobilePhoneNo3.start.1
            @Override // com.hive.authv4.devicemanagement.ui.model.OnChangeMobilePhoneNo3Listener
            public void onSend(Bundle summit) {
                Intrinsics.checkNotNullParameter(summit, "summit");
                C12_ChangeMobilePhoneNo3 c12_ChangeMobilePhoneNo3 = C12_ChangeMobilePhoneNo3.this;
                String string = summit.getString("phoneCode");
                c12_ChangeMobilePhoneNo3.inputPhoneCode = string != null ? StringsKt.removePrefix(string, (CharSequence) Marker.ANY_NON_NULL_MARKER) : null;
                C12_ChangeMobilePhoneNo3.this.inputPhoneNumber = summit.getString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
                C12_ChangeMobilePhoneNo3.this.smsSend();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnChangeMobilePhoneNo3Listener
            public void onMore() {
                String company = Configuration.INSTANCE.getCompany();
                if (!(!StringsKt.isBlank(company))) {
                    company = null;
                }
                if (company == null) {
                    company = "Com2uS%20Platform";
                }
                Integer numValueOf = Integer.valueOf(Configuration.INSTANCE.getCompanyIndex());
                if (numValueOf.intValue() == -1) {
                    numValueOf = null;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(UrlManager.Terms.INSTANCE.getDeviceManagement() + FileSystemKt.UnixPathSeparator + (company + FileSystemKt.UnixPathSeparator + (numValueOf != null ? numValueOf.intValue() : 3))));
                C12_ChangeMobilePhoneNo3 c12_ChangeMobilePhoneNo3 = C12_ChangeMobilePhoneNo3.this;
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching$default(c12_ChangeMobilePhoneNo3.activity, intent, null, 2, null);
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onActive(Bundle summit) {
                C12_ChangeMobilePhoneNo3.this.smsVerify(summit != null ? summit.getString("code") : null);
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onCancel() {
                C12_ChangeMobilePhoneNo3.this.callback(false);
                C12_ChangeMobilePhoneNo3.this.getC12().finish();
            }

            @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
            public void onClose() {
                C12_ChangeMobilePhoneNo3.this.callback(null);
                C12_ChangeMobilePhoneNo3.this.getC12().finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void smsSend() {
        DeviceManagementNetwork.INSTANCE.smsSend(this.account, this.inputPhoneCode, this.inputPhoneNumber, "device/modify-user", new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C12_ChangeMobilePhoneNo3$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return C12_ChangeMobilePhoneNo3.smsSend$lambda$1(this.f$0, (SmsSend.SmsSendResponse) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsSend$lambda$1(C12_ChangeMobilePhoneNo3 c12_ChangeMobilePhoneNo3, SmsSend.SmsSendResponse it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isSuccess()) {
            c12_ChangeMobilePhoneNo3.signature = it.getSignature();
            c12_ChangeMobilePhoneNo3.c12.setSendError(false, null);
        } else {
            int resultCode = it.getResultCode();
            if (resultCode == -1) {
                c12_ChangeMobilePhoneNo3.c12.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163));
            } else if (resultCode == 3005) {
                c12_ChangeMobilePhoneNo3.c12.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_403));
            } else if (resultCode == 3017) {
                c12_ChangeMobilePhoneNo3.c12.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_1188));
            } else if (resultCode == 3105) {
                c12_ChangeMobilePhoneNo3.c12.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_492));
            } else if (resultCode == 3014) {
                c12_ChangeMobilePhoneNo3.c12.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_183));
            } else if (resultCode == 3015) {
                c12_ChangeMobilePhoneNo3.c12.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_182));
            } else {
                c12_ChangeMobilePhoneNo3.c12.setSendError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_144) + " [" + it.getResultCode() + AbstractJsonLexerKt.END_LIST);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void smsVerify(String code) {
        String str = this.signature;
        if (code != null && str != null) {
            DeviceManagementNetwork.INSTANCE.smsVerify(this.account, str, code, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C12_ChangeMobilePhoneNo3$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return C12_ChangeMobilePhoneNo3.smsVerify$lambda$5$lambda$4(this.f$0, (SmsVerify.SmsVerifyResponse) obj);
                }
            });
        } else {
            this.c12.setChangeError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_120));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsVerify$lambda$5$lambda$4(final C12_ChangeMobilePhoneNo3 c12_ChangeMobilePhoneNo3, SmsVerify.SmsVerifyResponse verifyResponse) {
        Intrinsics.checkNotNullParameter(verifyResponse, "verifyResponse");
        if (verifyResponse.isSuccess()) {
            DeviceManagementNetwork.INSTANCE.deviceModifyUser(c12_ChangeMobilePhoneNo3.account, c12_ChangeMobilePhoneNo3.inputPhoneCode, c12_ChangeMobilePhoneNo3.inputPhoneNumber, c12_ChangeMobilePhoneNo3.c11Signature, null, null, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C12_ChangeMobilePhoneNo3$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return C12_ChangeMobilePhoneNo3.smsVerify$lambda$5$lambda$4$lambda$3(this.f$0, (DeviceModifyUser.DeviceModifyUserResponse) obj);
                }
            });
        } else {
            int resultCode = verifyResponse.getResultCode();
            if (resultCode == -1) {
                c12_ChangeMobilePhoneNo3.c12.setChangeError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163));
            } else if (resultCode == 3001 || resultCode == 3008) {
                c12_ChangeMobilePhoneNo3.c12.setChangeError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_120));
            } else {
                c12_ChangeMobilePhoneNo3.c12.setChangeError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163) + " [" + verifyResponse.getResultCode() + AbstractJsonLexerKt.END_LIST);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit smsVerify$lambda$5$lambda$4$lambda$3(final C12_ChangeMobilePhoneNo3 c12_ChangeMobilePhoneNo3, DeviceModifyUser.DeviceModifyUserResponse modifyUserResponse) {
        Intrinsics.checkNotNullParameter(modifyUserResponse, "modifyUserResponse");
        if (modifyUserResponse.isSuccess()) {
            final C14_ChangeMobilePhoneNoCompleteUi c14_ChangeMobilePhoneNoCompleteUi = new C14_ChangeMobilePhoneNoCompleteUi(c12_ChangeMobilePhoneNo3.activity);
            c14_ChangeMobilePhoneNoCompleteUi.show(new OnBaseButtonListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.C12_ChangeMobilePhoneNo3$smsVerify$1$1$1$1$1
                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onActive(Bundle summit) {
                    this.this$0.callback(true);
                    c14_ChangeMobilePhoneNoCompleteUi.finish();
                }

                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onCancel() {
                    this.this$0.callback(true);
                    c14_ChangeMobilePhoneNoCompleteUi.finish();
                }

                @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
                public void onClose() {
                    this.this$0.callback(true);
                    c14_ChangeMobilePhoneNoCompleteUi.finish();
                }
            });
            c12_ChangeMobilePhoneNo3.c12.finish();
        } else {
            c12_ChangeMobilePhoneNo3.c12.setChangeError(true, HiveContext.INSTANCE.getResourceContext().getString(R.string.hive_device_management_163) + " [" + modifyUserResponse.getResultCode() + AbstractJsonLexerKt.END_LIST);
        }
        return Unit.INSTANCE;
    }
}
