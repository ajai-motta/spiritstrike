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
import com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo;
import com.hive.authv4.devicemanagement.ui.A6_ErrorGuideUi;
import com.hive.authv4.devicemanagement.ui.C10_ChangeMobilePhoneNo1Ui;
import com.hive.authv4.devicemanagement.ui.C1_DeviceManagementInfoUi;
import com.hive.authv4.devicemanagement.ui.C7_ServiceCancellationGuideUi;
import com.hive.authv4.devicemanagement.ui.model.DeviceInfo;
import com.hive.authv4.devicemanagement.ui.model.OnErrorGuideListener;
import com.hive.authv4.devicemanagement.ui.model.OnManagementInfoListener;
import com.hive.core.ExtentionsKt;
import com.hive.protocol.UrlManager;
import com.hive.protocol.authv4.DeviceDelete;
import com.hive.protocol.authv4.DeviceModify;
import com.hive.standalone.HiveLifecycle;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Marker;

/* JADX INFO: compiled from: C1_DeviceManagementInfo.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\r\u00128\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000f¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u0010J\u0006\u0010%\u001a\u00020\u0015J\"\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150(R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u000e\u001a4\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0014\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001e\"\u0004\b\"\u0010 ¨\u0006)"}, d2 = {"Lcom/hive/authv4/devicemanagement/serviceflow/C1_DeviceManagementInfo;", "", "activity", "Landroid/app/Activity;", "account", "Lcom/hive/standalone/HiveLifecycle$HiveAccount;", "phoneCode", "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "deviceInfoList", "", "Lcom/hive/authv4/devicemanagement/ui/model/DeviceInfo;", "maxDeviceCount", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "needCheckPhone", "", "<init>", "(Landroid/app/Activity;Lcom/hive/standalone/HiveLifecycle$HiveAccount;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILkotlin/jvm/functions/Function2;)V", "c1", "Lcom/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi;", "getC1", "()Lcom/hive/authv4/devicemanagement/ui/C1_DeviceManagementInfoUi;", "needCheckDevice", "getNeedCheckDevice", "()Z", "setNeedCheckDevice", "(Z)V", "getNeedCheckPhone", "setNeedCheckPhone", "callback", "b", TtmlNode.START, "error", "errorCode", "Lkotlin/Function1;", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class C1_DeviceManagementInfo {
    private final HiveLifecycle.HiveAccount account;
    private final Activity activity;
    private final C1_DeviceManagementInfoUi c1;
    private Function2<? super Boolean, ? super Boolean, Unit> listener;
    private boolean needCheckDevice;
    private boolean needCheckPhone;
    private final String phoneCode;
    private final String phoneNumber;

    public C1_DeviceManagementInfo(Activity activity, HiveLifecycle.HiveAccount account, String phoneCode, String phoneNumber, List<DeviceInfo> deviceInfoList, int i, Function2<? super Boolean, ? super Boolean, Unit> function2) {
        Unit unit;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(account, "account");
        Intrinsics.checkNotNullParameter(phoneCode, "phoneCode");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        Intrinsics.checkNotNullParameter(deviceInfoList, "deviceInfoList");
        this.activity = activity;
        this.account = account;
        this.phoneCode = phoneCode;
        this.phoneNumber = phoneNumber;
        this.listener = function2;
        final String mySeq$hive_authv4_device_management_release = DeviceManagement.INSTANCE.getMySeq$hive_authv4_device_management_release();
        final Comparator comparator = new Comparator() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$special$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Boolean.valueOf(Intrinsics.areEqual(((DeviceInfo) t2).getSeq(), mySeq$hive_authv4_device_management_release)), Boolean.valueOf(Intrinsics.areEqual(((DeviceInfo) t).getSeq(), mySeq$hive_authv4_device_management_release)));
            }
        };
        CollectionsKt.sortWith(deviceInfoList, new Comparator() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$special$$inlined$thenByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompare = comparator.compare(t, t2);
                return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(((DeviceInfo) t2).getAddDate(), ((DeviceInfo) t).getAddDate());
            }
        });
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        DateFormat hiveLocaleDateFormat$hive_authv4_device_management_release = DeviceManagement.INSTANCE.getHiveLocaleDateFormat$hive_authv4_device_management_release(activity);
        for (DeviceInfo deviceInfo : deviceInfoList) {
            try {
                Result.Companion companion = Result.INSTANCE;
                Date date = simpleDateFormat.parse(deviceInfo.getAddDate());
                if (date != null) {
                    String str = hiveLocaleDateFormat$hive_authv4_device_management_release.format(date);
                    Intrinsics.checkNotNull(str);
                    deviceInfo.setAddDate(str);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                Result.m7415constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m7415constructorimpl(ResultKt.createFailure(th));
            }
        }
        this.c1 = new C1_DeviceManagementInfoUi(this.activity, Marker.ANY_NON_NULL_MARKER + this.phoneCode + ' ' + this.phoneNumber, deviceInfoList, mySeq$hive_authv4_device_management_release, i);
    }

    public final C1_DeviceManagementInfoUi getC1() {
        return this.c1;
    }

    public final boolean getNeedCheckDevice() {
        return this.needCheckDevice;
    }

    public final void setNeedCheckDevice(boolean z) {
        this.needCheckDevice = z;
    }

    public final boolean getNeedCheckPhone() {
        return this.needCheckPhone;
    }

    public final void setNeedCheckPhone(boolean z) {
        this.needCheckPhone = z;
    }

    public final void callback(boolean b) {
        Function2<? super Boolean, ? super Boolean, Unit> function2 = this.listener;
        if (function2 != null) {
            function2.invoke(Boolean.valueOf(b), Boolean.valueOf(this.needCheckPhone));
        }
        this.listener = null;
    }

    /* JADX INFO: renamed from: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: C1_DeviceManagementInfo.kt */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"com/hive/authv4/devicemanagement/serviceflow/C1_DeviceManagementInfo$start$1", "Lcom/hive/authv4/devicemanagement/ui/model/OnManagementInfoListener;", "onEdit", "", "deviceInfo", "Lcom/hive/authv4/devicemanagement/ui/model/DeviceInfo;", "onDelete", "onActive", "summit", "Landroid/os/Bundle;", "onCancel", "onClose", "hive-authv4-device-management_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AnonymousClass1 implements OnManagementInfoListener {
        AnonymousClass1() {
        }

        @Override // com.hive.authv4.devicemanagement.ui.model.OnManagementInfoListener
        public void onEdit(final DeviceInfo deviceInfo) {
            Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
            DeviceManagementNetwork deviceManagementNetwork = DeviceManagementNetwork.INSTANCE;
            HiveLifecycle.HiveAccount hiveAccount = C1_DeviceManagementInfo.this.account;
            String seq = deviceInfo.getSeq();
            String deviceName = deviceInfo.getDeviceName();
            final C1_DeviceManagementInfo c1_DeviceManagementInfo = C1_DeviceManagementInfo.this;
            deviceManagementNetwork.deviceModify(hiveAccount, seq, deviceName, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return C1_DeviceManagementInfo.AnonymousClass1.onEdit$lambda$0(c1_DeviceManagementInfo, deviceInfo, (DeviceModify.DeviceModifyResponse) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onEdit$lambda$0(C1_DeviceManagementInfo c1_DeviceManagementInfo, DeviceInfo deviceInfo, DeviceModify.DeviceModifyResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccess()) {
                c1_DeviceManagementInfo.getC1().setChanged(deviceInfo, null);
            } else {
                c1_DeviceManagementInfo.getC1().setChanged(deviceInfo, String.valueOf(response.getResultCode()));
            }
            return Unit.INSTANCE;
        }

        @Override // com.hive.authv4.devicemanagement.ui.model.OnManagementInfoListener
        public void onDelete(final DeviceInfo deviceInfo) {
            Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
            DeviceManagementNetwork deviceManagementNetwork = DeviceManagementNetwork.INSTANCE;
            HiveLifecycle.HiveAccount hiveAccount = C1_DeviceManagementInfo.this.account;
            String seq = deviceInfo.getSeq();
            final C1_DeviceManagementInfo c1_DeviceManagementInfo = C1_DeviceManagementInfo.this;
            deviceManagementNetwork.deviceDelete(hiveAccount, seq, new Function1() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$start$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return C1_DeviceManagementInfo.AnonymousClass1.onDelete$lambda$2(c1_DeviceManagementInfo, deviceInfo, (DeviceDelete.DeviceDeleteResponse) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit onDelete$lambda$2(C1_DeviceManagementInfo c1_DeviceManagementInfo, DeviceInfo deviceInfo, DeviceDelete.DeviceDeleteResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isSuccess()) {
                c1_DeviceManagementInfo.getC1().setDelete(deviceInfo, null);
                Unit unit = Unit.INSTANCE;
                c1_DeviceManagementInfo.setNeedCheckDevice(true);
            } else {
                c1_DeviceManagementInfo.getC1().setDelete(deviceInfo, String.valueOf(response.getResultCode()));
            }
            return Unit.INSTANCE;
        }

        @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
        public void onActive(Bundle summit) {
            C10_ChangeMobilePhoneNo1Ui c10_ChangeMobilePhoneNo1Ui = new C10_ChangeMobilePhoneNo1Ui(C1_DeviceManagementInfo.this.activity, Marker.ANY_NON_NULL_MARKER + C1_DeviceManagementInfo.this.phoneCode + ' ' + C1_DeviceManagementInfo.this.phoneNumber);
            c10_ChangeMobilePhoneNo1Ui.show(new C1_DeviceManagementInfo$start$1$onActive$1$1(C1_DeviceManagementInfo.this, c10_ChangeMobilePhoneNo1Ui));
        }

        @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
        public void onCancel() {
            C7_ServiceCancellationGuideUi c7_ServiceCancellationGuideUi = new C7_ServiceCancellationGuideUi(C1_DeviceManagementInfo.this.activity);
            c7_ServiceCancellationGuideUi.show(new C1_DeviceManagementInfo$start$1$onCancel$1$1(C1_DeviceManagementInfo.this, c7_ServiceCancellationGuideUi));
        }

        @Override // com.hive.authv4.devicemanagement.ui.model.OnBaseButtonListener
        public void onClose() {
            C1_DeviceManagementInfo c1_DeviceManagementInfo = C1_DeviceManagementInfo.this;
            c1_DeviceManagementInfo.callback(c1_DeviceManagementInfo.getNeedCheckDevice());
            C1_DeviceManagementInfo.this.getC1().finish();
        }
    }

    public final void start() {
        this.c1.show((OnManagementInfoListener) new AnonymousClass1());
    }

    public final void error(String errorCode, final Function1<? super Boolean, Unit> listener) {
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final A6_ErrorGuideUi a6_ErrorGuideUi = new A6_ErrorGuideUi(this.activity, errorCode, DeviceManagement.INSTANCE.hideCustomerSupport$hive_authv4_device_management_release());
        a6_ErrorGuideUi.show(new OnErrorGuideListener() { // from class: com.hive.authv4.devicemanagement.serviceflow.C1_DeviceManagementInfo$error$1$1
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
                C1_DeviceManagementInfo c1_DeviceManagementInfo = this;
                intent.setFlags(268435456);
                ExtentionsKt.startActivityCatching$default(c1_DeviceManagementInfo.activity, intent, null, 2, null);
            }
        });
    }
}
